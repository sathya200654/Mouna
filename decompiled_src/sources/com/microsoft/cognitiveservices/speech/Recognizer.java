package com.microsoft.cognitiveservices.speech;

import com.azure.core.credential.AccessToken;
import com.azure.core.credential.TokenCredential;
import com.azure.core.credential.TokenRequestContext;
import com.microsoft.cognitiveservices.speech.audio.AudioConfig;
import com.microsoft.cognitiveservices.speech.util.AsyncThreadService;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.EventHandler;
import com.microsoft.cognitiveservices.speech.util.EventHandlerImpl;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.SafeHandleType;
import java.time.OffsetDateTime;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class Recognizer implements AutoCloseable {
    protected static final String AUTH_TOKEN_ERROR_PROPERTY = "service.auth.token.lasterror";
    protected static final String AUTH_TOKEN_EXPIRY_PROPERTY = "service.auth.token.expirems";
    protected static final String AUTH_TOKEN_REFRESH_INTERVAL_MS_PROPERTY = "service.auth.token.refreshintervalms";
    private static final String[] TOKEN_REQUEST_SCOPES = {"https://cognitiveservices.azure.com/.default"};
    private AudioConfig audioInputKeepAlive;
    private SafeHandle recoHandle;
    private final TokenCredential tokenCredential;
    protected AtomicInteger eventCounter = new AtomicInteger(0);
    protected final EventHandlerImpl<SessionEventArgs> tokenRequested = new EventHandlerImpl<>(this.eventCounter);
    public final EventHandlerImpl<SessionEventArgs> sessionStarted = new EventHandlerImpl<>(this.eventCounter);
    public final EventHandlerImpl<SessionEventArgs> sessionStopped = new EventHandlerImpl<>(this.eventCounter);
    public final EventHandlerImpl<RecognitionEventArgs> speechStartDetected = new EventHandlerImpl<>(this.eventCounter);
    public final EventHandlerImpl<RecognitionEventArgs> speechEndDetected = new EventHandlerImpl<>(this.eventCounter);
    protected boolean disposed = false;
    private final Object recognizerLock = new Object();
    private int activeAsyncRecognitionCounter = 0;

    protected Recognizer(AudioConfig audioConfig, TokenCredential tokenCredential) {
        this.recoHandle = null;
        this.audioInputKeepAlive = null;
        AsyncThreadService.initialize();
        this.recoHandle = new SafeHandle(0L, SafeHandleType.Recognizer);
        this.tokenCredential = tokenCredential;
        this.audioInputKeepAlive = audioConfig;
    }

    private final native long recognizeOnce(SafeHandle safeHandle, IntRef intRef);

    protected final native long canceledSetCallback(long j);

    @Override // java.lang.AutoCloseable
    public void close() {
        synchronized (this.recognizerLock) {
            if (this.activeAsyncRecognitionCounter != 0) {
                throw new IllegalStateException("Cannot dispose a recognizer while async recognition is running. Await async recognitions to avoid unexpected disposals.");
            }
            dispose(true);
        }
    }

    protected void dispose(boolean z) {
        if (this.disposed) {
            return;
        }
        SafeHandle safeHandle = this.recoHandle;
        if (safeHandle != null) {
            safeHandle.close();
            this.recoHandle = null;
        }
        AsyncThreadService.shutdown();
        this.audioInputKeepAlive = null;
        this.disposed = true;
    }

    protected void doAsyncRecognitionAction(Runnable runnable) {
        synchronized (this.recognizerLock) {
            this.activeAsyncRecognitionCounter++;
        }
        if (this.disposed) {
            throw new IllegalStateException(getClass().getName());
        }
        try {
            runnable.run();
            synchronized (this.recognizerLock) {
                this.activeAsyncRecognitionCounter--;
            }
        } catch (Throwable th) {
            synchronized (this.recognizerLock) {
                this.activeAsyncRecognitionCounter--;
                throw th;
            }
        }
    }

    public SafeHandle getImpl() {
        return this.recoHandle;
    }

    protected final native long getPropertyBagFromRecognizerHandle(SafeHandle safeHandle, IntRef intRef);

    /* JADX INFO: renamed from: lambda$setUpTokenRefreshCallback$0$com-microsoft-cognitiveservices-speech-Recognizer, reason: not valid java name */
    /* synthetic */ void m2205x1f22f91e(PropertyCollection propertyCollection, Object obj, SessionEventArgs sessionEventArgs) {
        updateAuthToken(propertyCollection);
    }

    protected long recognize() {
        Contracts.throwIfNull(this.recoHandle, "Invalid recognizer handle");
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(recognizeOnce(this.recoHandle, intRef));
        return intRef.getValue();
    }

    protected final native long recognizedSetCallback(long j);

    protected final native long recognizingSetCallback(long j);

    protected void sessionStartedEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "recognizer");
            if (this.disposed) {
                return;
            }
            SessionEventArgs sessionEventArgs = new SessionEventArgs(j, true);
            EventHandlerImpl<SessionEventArgs> eventHandlerImpl = this.sessionStarted;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, sessionEventArgs);
            }
        } catch (Exception unused) {
        }
    }

    protected final native long sessionStartedSetCallback(long j);

    protected void sessionStoppedEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "recognizer");
            if (this.disposed) {
                return;
            }
            SessionEventArgs sessionEventArgs = new SessionEventArgs(j, true);
            EventHandlerImpl<SessionEventArgs> eventHandlerImpl = this.sessionStopped;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, sessionEventArgs);
            }
        } catch (Exception unused) {
        }
    }

    protected final native long sessionStoppedSetCallback(long j);

    protected void setUpTokenRefreshCallback(final PropertyCollection propertyCollection) {
        if (this.tokenCredential == null || propertyCollection == null) {
            return;
        }
        this.tokenRequested.addEventListener(new EventHandler() { // from class: com.microsoft.cognitiveservices.speech.Recognizer$$ExternalSyntheticLambda0
            @Override // com.microsoft.cognitiveservices.speech.util.EventHandler
            public final void onEvent(Object obj, Object obj2) {
                this.f$0.m2205x1f22f91e(propertyCollection, obj, (SessionEventArgs) obj2);
            }
        });
        propertyCollection.setProperty(AUTH_TOKEN_EXPIRY_PROPERTY, "infinite");
    }

    protected void speechEndDetectedEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "recognizer");
            if (this.disposed) {
                return;
            }
            RecognitionEventArgs recognitionEventArgs = new RecognitionEventArgs(j, true);
            EventHandlerImpl<RecognitionEventArgs> eventHandlerImpl = this.speechEndDetected;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, recognitionEventArgs);
            }
        } catch (Exception unused) {
        }
    }

    protected final native long speechEndDetectedSetCallback(long j);

    protected void speechStartDetectedEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "recognizer");
            if (this.disposed) {
                return;
            }
            RecognitionEventArgs recognitionEventArgs = new RecognitionEventArgs(j, true);
            EventHandlerImpl<RecognitionEventArgs> eventHandlerImpl = this.speechStartDetected;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, recognitionEventArgs);
            }
        } catch (Exception unused) {
        }
    }

    protected final native long speechStartDetectedSetCallback(long j);

    protected final native long startContinuousRecognition(SafeHandle safeHandle);

    protected final native long startKeywordRecognition(SafeHandle safeHandle, SafeHandle safeHandle2);

    protected final native long stopContinuousRecognition(SafeHandle safeHandle);

    protected final native long stopKeywordRecognition(SafeHandle safeHandle);

    protected void tokenRefreshEventCallback(long j) {
        try {
            Contracts.throwIfNull(this, "recognizer");
            if (this.disposed) {
                return;
            }
            SessionEventArgs sessionEventArgs = new SessionEventArgs(j, true);
            EventHandlerImpl<SessionEventArgs> eventHandlerImpl = this.tokenRequested;
            if (eventHandlerImpl != null) {
                eventHandlerImpl.fireEvent(this, sessionEventArgs);
            }
        } catch (Exception unused) {
        }
    }

    protected final native long tokenRefreshSetCallback(long j);

    protected void updateAuthToken(PropertyCollection propertyCollection) {
        long epochMilli;
        String strValueOf;
        if (propertyCollection == null || this.tokenCredential == null) {
            return;
        }
        String property = propertyCollection.getProperty(PropertyId.SpeechServiceAuthorization_Token);
        String property2 = propertyCollection.getProperty(AUTH_TOKEN_EXPIRY_PROPERTY, "");
        String property3 = propertyCollection.getProperty(AUTH_TOKEN_REFRESH_INTERVAL_MS_PROPERTY, "");
        try {
            try {
                AccessToken accessToken = (AccessToken) this.tokenCredential.getToken(new TokenRequestContext().addScopes(TOKEN_REQUEST_SCOPES)).block();
                property = accessToken.getToken();
                if (property3 != null && !property3.isEmpty()) {
                    try {
                        strValueOf = String.valueOf(OffsetDateTime.now().plusSeconds(((long) Integer.parseInt(property3)) / 1000).toInstant().toEpochMilli());
                    } catch (NumberFormatException unused) {
                        epochMilli = accessToken.getExpiresAt().toInstant().toEpochMilli();
                        strValueOf = String.valueOf(epochMilli);
                    }
                    property2 = strValueOf;
                    propertyCollection.setProperty(AUTH_TOKEN_ERROR_PROPERTY, "");
                }
                epochMilli = accessToken.getExpiresAt().toInstant().toEpochMilli();
                strValueOf = String.valueOf(epochMilli);
                property2 = strValueOf;
                propertyCollection.setProperty(AUTH_TOKEN_ERROR_PROPERTY, "");
            } finally {
                propertyCollection.setProperty(PropertyId.SpeechServiceAuthorization_Token, property);
                propertyCollection.setProperty(AUTH_TOKEN_EXPIRY_PROPERTY, property2);
            }
        } catch (Exception e) {
            propertyCollection.setProperty(AUTH_TOKEN_ERROR_PROPERTY, e.toString());
        }
    }
}
