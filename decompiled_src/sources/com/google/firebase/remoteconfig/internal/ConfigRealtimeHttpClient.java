package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.azure.core.http.ContentType;
import com.azure.xml.implementation.aalto.util.XmlConsts;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.common.net.HttpHeaders;
import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.remoteconfig.BuildConfig;
import com.google.firebase.remoteconfig.ConfigUpdate;
import com.google.firebase.remoteconfig.ConfigUpdateListener;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class ConfigRealtimeHttpClient {
    private static final String API_KEY_HEADER = "X-Goog-Api-Key";
    static final int[] BACKOFF_TIME_DURATIONS_IN_MINUTES = {2, 4, 8, 16, 32, 64, 128, 256};
    private static final Pattern GMP_APP_ID_PATTERN = Pattern.compile("^[^:]+:([0-9]+):(android|ios|web):([0-9a-f]+)");
    private static final String INSTALLATIONS_AUTH_TOKEN_HEADER = "X-Goog-Firebase-Installations-Auth";
    private static final String X_ACCEPT_RESPONSE_STREAMING = "X-Accept-Response-Streaming";
    private static final String X_ANDROID_CERT_HEADER = "X-Android-Cert";
    private static final String X_ANDROID_PACKAGE_HEADER = "X-Android-Package";
    private static final String X_GOOGLE_GFE_CAN_RETRY = "X-Google-GFE-Can-Retry";
    ConfigCacheClient activatedCache;
    private ConfigAutoFetch configAutoFetch;
    private final ConfigFetchHandler configFetchHandler;
    private final Context context;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;
    private int httpRetriesRemaining;
    private HttpURLConnection httpURLConnection;
    private final Set<ConfigUpdateListener> listeners;
    private final String namespace;
    private final ScheduledExecutorService scheduledExecutorService;
    private final ConfigSharedPrefsClient sharedPrefsClient;
    private final int ORIGINAL_RETRIES = 8;
    private boolean isHttpConnectionRunning = false;
    private final Random random = new Random();
    private final Clock clock = DefaultClock.getInstance();
    private boolean isRealtimeDisabled = false;
    private boolean isInBackground = false;
    private final Object backgroundLock = new Object();

    private boolean isStatusCodeRetryable(int i) {
        return i == 408 || i == 429 || i == 502 || i == 503 || i == 504;
    }

    public ConfigRealtimeHttpClient(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, ConfigFetchHandler configFetchHandler, ConfigCacheClient configCacheClient, Context context, String str, Set<ConfigUpdateListener> set, ConfigSharedPrefsClient configSharedPrefsClient, ScheduledExecutorService scheduledExecutorService) {
        this.listeners = set;
        this.scheduledExecutorService = scheduledExecutorService;
        this.httpRetriesRemaining = Math.max(8 - configSharedPrefsClient.getRealtimeBackoffMetadata().getNumFailedStreams(), 1);
        this.firebaseApp = firebaseApp;
        this.configFetchHandler = configFetchHandler;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.activatedCache = configCacheClient;
        this.context = context;
        this.namespace = str;
        this.sharedPrefsClient = configSharedPrefsClient;
    }

    private static String extractProjectNumberFromAppId(String str) {
        Matcher matcher = GMP_APP_ID_PATTERN.matcher(str);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return null;
    }

    private String getFingerprintHashForPackage() {
        try {
            Context context = this.context;
            byte[] packageCertificateHashBytes = AndroidUtilsLight.getPackageCertificateHashBytes(context, context.getPackageName());
            if (packageCertificateHashBytes != null) {
                return Hex.bytesToStringUppercase(packageCertificateHashBytes, false);
            }
            Log.e(FirebaseRemoteConfig.TAG, "Could not get fingerprint hash for package: " + this.context.getPackageName());
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.i(FirebaseRemoteConfig.TAG, "No such package: " + this.context.getPackageName());
            return null;
        }
    }

    private void setCommonRequestHeaders(HttpURLConnection httpURLConnection, String str) {
        httpURLConnection.setRequestProperty(INSTALLATIONS_AUTH_TOKEN_HEADER, str);
        httpURLConnection.setRequestProperty(API_KEY_HEADER, this.firebaseApp.getOptions().getApiKey());
        httpURLConnection.setRequestProperty(X_ANDROID_PACKAGE_HEADER, this.context.getPackageName());
        httpURLConnection.setRequestProperty(X_ANDROID_CERT_HEADER, getFingerprintHashForPackage());
        httpURLConnection.setRequestProperty(X_GOOGLE_GFE_CAN_RETRY, XmlConsts.XML_SA_YES);
        httpURLConnection.setRequestProperty(X_ACCEPT_RESPONSE_STREAMING, "true");
        httpURLConnection.setRequestProperty("Content-Type", ContentType.APPLICATION_JSON);
        httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON);
    }

    private JSONObject createRequestBody(String str) {
        HashMap map = new HashMap();
        map.put("project", extractProjectNumberFromAppId(this.firebaseApp.getOptions().getApplicationId()));
        map.put("namespace", this.namespace);
        map.put("lastKnownVersionNumber", Long.toString(this.configFetchHandler.getTemplateVersionNumber()));
        map.put(RemoteConfigConstants.RequestFieldKey.APP_ID, this.firebaseApp.getOptions().getApplicationId());
        map.put(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, BuildConfig.VERSION_NAME);
        map.put(RemoteConfigConstants.RequestFieldKey.INSTANCE_ID, str);
        return new JSONObject(map);
    }

    public void setRequestParams(HttpURLConnection httpURLConnection, String str, String str2) throws IOException {
        httpURLConnection.setRequestMethod("POST");
        setCommonRequestHeaders(httpURLConnection, str2);
        byte[] bytes = createRequestBody(str).toString().getBytes("utf-8");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
        bufferedOutputStream.write(bytes);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void propagateErrors(FirebaseRemoteConfigException firebaseRemoteConfigException) {
        Iterator<ConfigUpdateListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onError(firebaseRemoteConfigException);
        }
    }

    public int getNumberOfFailedStreams() {
        return this.sharedPrefsClient.getRealtimeBackoffMetadata().getNumFailedStreams();
    }

    public Date getBackoffEndTime() {
        return this.sharedPrefsClient.getRealtimeBackoffMetadata().getBackoffEndTime();
    }

    private void updateBackoffMetadataWithLastFailedStreamConnectionTime(Date date) {
        int numFailedStreams = this.sharedPrefsClient.getRealtimeBackoffMetadata().getNumFailedStreams() + 1;
        this.sharedPrefsClient.setRealtimeBackoffMetadata(numFailedStreams, new Date(date.getTime() + getRandomizedBackoffDurationInMillis(numFailedStreams)));
    }

    private long getRandomizedBackoffDurationInMillis(int i) {
        int[] iArr = BACKOFF_TIME_DURATIONS_IN_MINUTES;
        int length = iArr.length;
        if (i >= length) {
            i = length;
        }
        long millis = TimeUnit.MINUTES.toMillis(iArr[i - 1]);
        return (millis / 2) + ((long) this.random.nextInt((int) millis));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void enableBackoff() {
        this.isRealtimeDisabled = true;
    }

    private synchronized boolean canMakeHttpStreamConnection() {
        return (this.listeners.isEmpty() || this.isHttpConnectionRunning || this.isRealtimeDisabled || this.isInBackground) ? false : true;
    }

    private String getRealtimeURL(String str) {
        return String.format(RemoteConfigConstants.REALTIME_REGEX_URL, extractProjectNumberFromAppId(this.firebaseApp.getOptions().getApplicationId()), str);
    }

    private URL getUrl() {
        try {
            return new URL(getRealtimeURL(this.namespace));
        } catch (MalformedURLException unused) {
            Log.e(FirebaseRemoteConfig.TAG, "URL is malformed");
            return null;
        }
    }

    public Task<HttpURLConnection> createRealtimeConnection() {
        final Task<InstallationTokenResult> token = this.firebaseInstallations.getToken(false);
        final Task<String> id = this.firebaseInstallations.getId();
        return Tasks.whenAllComplete(new Task[]{token, id}).continueWithTask(this.scheduledExecutorService, new Continuation() { // from class: com.google.firebase.remoteconfig.internal.ConfigRealtimeHttpClient$$ExternalSyntheticLambda0
            public final Object then(Task task) {
                return this.f$0.m2169xad28ecdf(token, id, task);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$createRealtimeConnection$0$com-google-firebase-remoteconfig-internal-ConfigRealtimeHttpClient, reason: not valid java name */
    /* synthetic */ Task m2169xad28ecdf(Task task, Task task2, Task task3) throws Exception {
        if (!task.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation auth token for config update listener connection.", task.getException()));
        }
        if (!task2.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation ID for config update listener connection.", task2.getException()));
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) getUrl().openConnection();
            setRequestParams(httpURLConnection, (String) task2.getResult(), ((InstallationTokenResult) task.getResult()).getToken());
            return Tasks.forResult(httpURLConnection);
        } catch (IOException e) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Failed to open HTTP stream connection", e));
        }
    }

    public void startHttpConnection() {
        makeRealtimeHttpConnection(0L);
    }

    public synchronized void retryHttpConnectionWhenBackoffEnds() {
        makeRealtimeHttpConnection(Math.max(0L, this.sharedPrefsClient.getRealtimeBackoffMetadata().getBackoffEndTime().getTime() - new Date(this.clock.currentTimeMillis()).getTime()));
    }

    private synchronized void makeRealtimeHttpConnection(long j) {
        if (canMakeHttpStreamConnection()) {
            int i = this.httpRetriesRemaining;
            if (i > 0) {
                this.httpRetriesRemaining = i - 1;
                this.scheduledExecutorService.schedule(new Runnable() { // from class: com.google.firebase.remoteconfig.internal.ConfigRealtimeHttpClient.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ConfigRealtimeHttpClient.this.beginRealtimeHttpStream();
                    }
                }, j, TimeUnit.MILLISECONDS);
            } else if (!this.isInBackground) {
                propagateErrors(new FirebaseRemoteConfigClientException("Unable to connect to the server. Check your connection and try again.", FirebaseRemoteConfigException.Code.CONFIG_UPDATE_STREAM_ERROR));
            }
        }
    }

    public void setIsInBackground(boolean z) {
        HttpURLConnection httpURLConnection;
        synchronized (this.backgroundLock) {
            this.isInBackground = z;
            ConfigAutoFetch configAutoFetch = this.configAutoFetch;
            if (configAutoFetch != null) {
                configAutoFetch.setIsInBackground(z);
            }
            if (z && (httpURLConnection = this.httpURLConnection) != null) {
                httpURLConnection.disconnect();
            }
        }
    }

    private synchronized void resetRetryCount() {
        this.httpRetriesRemaining = 8;
    }

    private synchronized boolean checkAndSetHttpConnectionFlagIfNotRunning() {
        boolean zCanMakeHttpStreamConnection;
        zCanMakeHttpStreamConnection = canMakeHttpStreamConnection();
        if (zCanMakeHttpStreamConnection) {
            setIsHttpConnectionRunning(true);
        }
        return zCanMakeHttpStreamConnection;
    }

    private synchronized void setIsHttpConnectionRunning(boolean z) {
        this.isHttpConnectionRunning = z;
    }

    public synchronized ConfigAutoFetch startAutoFetch(HttpURLConnection httpURLConnection) {
        return new ConfigAutoFetch(httpURLConnection, this.configFetchHandler, this.activatedCache, this.listeners, new ConfigUpdateListener() { // from class: com.google.firebase.remoteconfig.internal.ConfigRealtimeHttpClient.2
            @Override // com.google.firebase.remoteconfig.ConfigUpdateListener
            public void onUpdate(ConfigUpdate configUpdate) {
            }

            @Override // com.google.firebase.remoteconfig.ConfigUpdateListener
            public void onError(FirebaseRemoteConfigException firebaseRemoteConfigException) {
                ConfigRealtimeHttpClient.this.enableBackoff();
                ConfigRealtimeHttpClient.this.propagateErrors(firebaseRemoteConfigException);
            }
        }, this.scheduledExecutorService);
    }

    private String parseForbiddenErrorResponseMessage(InputStream inputStream) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line);
            }
        } catch (IOException unused) {
            if (sb.length() == 0) {
                return "Unable to connect to the server, access is forbidden. HTTP status code: 403";
            }
        }
        return sb.toString();
    }

    public void beginRealtimeHttpStream() {
        if (checkAndSetHttpConnectionFlagIfNotRunning()) {
            if (new Date(this.clock.currentTimeMillis()).before(this.sharedPrefsClient.getRealtimeBackoffMetadata().getBackoffEndTime())) {
                retryHttpConnectionWhenBackoffEnds();
            } else {
                final Task<HttpURLConnection> taskCreateRealtimeConnection = createRealtimeConnection();
                Tasks.whenAllComplete(new Task[]{taskCreateRealtimeConnection}).continueWith(this.scheduledExecutorService, new Continuation() { // from class: com.google.firebase.remoteconfig.internal.ConfigRealtimeHttpClient$$ExternalSyntheticLambda1
                    public final Object then(Task task) {
                        return this.f$0.m2168x5fb1dc1(taskCreateRealtimeConnection, task);
                    }
                });
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x009d  */
    /* JADX WARN: Code duplicated, block: B:49:0x00cf A[Catch: all -> 0x0139, TryCatch #5 {all -> 0x0139, blocks: (B:8:0x002b, B:10:0x0031, B:47:0x00cb, B:49:0x00cf, B:50:0x00d3), top: B:89:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00d3 A[Catch: all -> 0x0139, TRY_LEAVE, TryCatch #5 {all -> 0x0139, blocks: (B:8:0x002b, B:10:0x0031, B:47:0x00cb, B:49:0x00cf, B:50:0x00d3), top: B:89:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:59:0x00f4  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: lambda$beginRealtimeHttpStream$1$com-google-firebase-remoteconfig-internal-ConfigRealtimeHttpClient, reason: not valid java name */
    /* synthetic */ Task m2168x5fb1dc1(Task task, Task task2) throws Exception {
        InputStream errorStream;
        Integer num;
        Throwable th;
        Integer numValueOf;
        FirebaseRemoteConfigServerException firebaseRemoteConfigServerException;
        boolean z = true;
        try {
            try {
                if (!task.isSuccessful()) {
                    throw new IOException(task.getException());
                }
                HttpURLConnection httpURLConnection = (HttpURLConnection) task.getResult();
                this.httpURLConnection = httpURLConnection;
                task = httpURLConnection.getInputStream();
                try {
                    errorStream = this.httpURLConnection.getErrorStream();
                    try {
                        numValueOf = Integer.valueOf(this.httpURLConnection.getResponseCode());
                        try {
                            if (numValueOf.intValue() == 200) {
                                resetRetryCount();
                                this.sharedPrefsClient.resetRealtimeBackoff();
                                ConfigAutoFetch configAutoFetchStartAutoFetch = startAutoFetch(this.httpURLConnection);
                                this.configAutoFetch = configAutoFetchStartAutoFetch;
                                configAutoFetchStartAutoFetch.listenForNotifications();
                            }
                            closeRealtimeHttpConnection(task, errorStream);
                            setIsHttpConnectionRunning(false);
                            if (this.isInBackground || (numValueOf != 0 && !isStatusCodeRetryable(numValueOf.intValue()))) {
                                z = false;
                            }
                            if (z) {
                                updateBackoffMetadataWithLastFailedStreamConnectionTime(new Date(this.clock.currentTimeMillis()));
                            }
                            if (z || numValueOf.intValue() == 200) {
                                retryHttpConnectionWhenBackoffEnds();
                            } else {
                                String forbiddenErrorResponseMessage = String.format("Unable to connect to the server. Try again in a few minutes. HTTP status code: %d", numValueOf);
                                if (numValueOf.intValue() == 403) {
                                    forbiddenErrorResponseMessage = parseForbiddenErrorResponseMessage(this.httpURLConnection.getErrorStream());
                                }
                                firebaseRemoteConfigServerException = new FirebaseRemoteConfigServerException(numValueOf.intValue(), forbiddenErrorResponseMessage, FirebaseRemoteConfigException.Code.CONFIG_UPDATE_STREAM_ERROR);
                                propagateErrors(firebaseRemoteConfigServerException);
                            }
                        } catch (IOException e) {
                            e = e;
                            if (this.isInBackground) {
                                resetRetryCount();
                            } else {
                                Log.d(FirebaseRemoteConfig.TAG, "Exception connecting to real-time RC backend. Retrying the connection...", e);
                            }
                            closeRealtimeHttpConnection(task, errorStream);
                            setIsHttpConnectionRunning(false);
                            if (this.isInBackground || (numValueOf != 0 && !isStatusCodeRetryable(numValueOf.intValue()))) {
                                z = false;
                            }
                            if (z) {
                                updateBackoffMetadataWithLastFailedStreamConnectionTime(new Date(this.clock.currentTimeMillis()));
                            }
                            if (!z || numValueOf.intValue() == 200) {
                                retryHttpConnectionWhenBackoffEnds();
                            } else {
                                String forbiddenErrorResponseMessage2 = String.format("Unable to connect to the server. Try again in a few minutes. HTTP status code: %d", numValueOf);
                                if (numValueOf.intValue() == 403) {
                                    forbiddenErrorResponseMessage2 = parseForbiddenErrorResponseMessage(this.httpURLConnection.getErrorStream());
                                }
                                firebaseRemoteConfigServerException = new FirebaseRemoteConfigServerException(numValueOf.intValue(), forbiddenErrorResponseMessage2, FirebaseRemoteConfigException.Code.CONFIG_UPDATE_STREAM_ERROR);
                            }
                            this.httpURLConnection = null;
                            this.configAutoFetch = null;
                            return Tasks.forResult((Object) null);
                        }
                    } catch (IOException e2) {
                        e = e2;
                        numValueOf = 0;
                    } catch (Throwable th2) {
                        num = null;
                        th = th2;
                        closeRealtimeHttpConnection(task, errorStream);
                        setIsHttpConnectionRunning(false);
                        if (this.isInBackground || (num != null && !isStatusCodeRetryable(num.intValue()))) {
                            z = false;
                        }
                        if (z) {
                            updateBackoffMetadataWithLastFailedStreamConnectionTime(new Date(this.clock.currentTimeMillis()));
                        }
                        if (z || num.intValue() == 200) {
                            retryHttpConnectionWhenBackoffEnds();
                        } else {
                            String forbiddenErrorResponseMessage3 = String.format("Unable to connect to the server. Try again in a few minutes. HTTP status code: %d", num);
                            if (num.intValue() == 403) {
                                forbiddenErrorResponseMessage3 = parseForbiddenErrorResponseMessage(this.httpURLConnection.getErrorStream());
                            }
                            propagateErrors(new FirebaseRemoteConfigServerException(num.intValue(), forbiddenErrorResponseMessage3, FirebaseRemoteConfigException.Code.CONFIG_UPDATE_STREAM_ERROR));
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                    errorStream = null;
                    numValueOf = errorStream;
                    if (this.isInBackground) {
                        resetRetryCount();
                    } else {
                        Log.d(FirebaseRemoteConfig.TAG, "Exception connecting to real-time RC backend. Retrying the connection...", e);
                    }
                    closeRealtimeHttpConnection(task, errorStream);
                    setIsHttpConnectionRunning(false);
                    if (this.isInBackground) {
                        z = false;
                    } else {
                        z = false;
                    }
                    if (z) {
                        updateBackoffMetadataWithLastFailedStreamConnectionTime(new Date(this.clock.currentTimeMillis()));
                    }
                    if (z) {
                    }
                    retryHttpConnectionWhenBackoffEnds();
                    this.httpURLConnection = null;
                    this.configAutoFetch = null;
                    return Tasks.forResult((Object) null);
                } catch (Throwable th3) {
                    num = null;
                    th = th3;
                    errorStream = null;
                }
                this.httpURLConnection = null;
                this.configAutoFetch = null;
                return Tasks.forResult((Object) null);
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (IOException e4) {
            e = e4;
            task = null;
            errorStream = null;
        } catch (Throwable th5) {
            errorStream = null;
            num = null;
            th = th5;
            task = null;
        }
    }

    private void closeHttpConnectionInputStream(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                Log.d(FirebaseRemoteConfig.TAG, "Error closing connection stream.", e);
            }
        }
    }

    public void closeRealtimeHttpConnection(InputStream inputStream, InputStream inputStream2) {
        HttpURLConnection httpURLConnection = this.httpURLConnection;
        if (httpURLConnection != null && !this.isInBackground) {
            httpURLConnection.disconnect();
        }
        closeHttpConnectionInputStream(inputStream);
        closeHttpConnectionInputStream(inputStream2);
    }
}
