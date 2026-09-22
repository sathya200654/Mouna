package com.azure.core.implementation;

import com.azure.core.http.HttpHeaderName;
import com.azure.core.http.HttpHeaders;
import com.azure.core.http.policy.RetryOptions;
import com.azure.core.http.policy.RetryStrategy;
import com.azure.core.implementation.accesshelpers.ExponentialBackoffAccessHelper;
import com.azure.core.implementation.accesshelpers.FixedDelayAccessHelper;
import com.azure.core.util.Configuration;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.DateTimeRfc1123;
import com.azure.core.util.FluxUtil;
import com.azure.core.util.UrlBuilder;
import com.azure.core.util.logging.ClientLogger;
import com.azure.xml.implementation.aalto.util.CharsetNames;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.time.DateTimeException;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ImplUtils {
    private static final byte BB = -69;
    private static final byte BF = -65;
    private static final byte EF = -17;
    private static final byte FE = -2;
    private static final byte FF = -1;
    public static final int MAX_CACHE_SIZE = 10000;
    private static final byte ZERO = 0;
    private static final Charset UTF_32BE = Charset.forName(CharsetNames.CS_UTF32BE);
    private static final Charset UTF_32LE = Charset.forName(CharsetNames.CS_UTF32LE);
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) ImplUtils.class);
    private static final Pattern CHARSET_PATTERN = Pattern.compile("charset=(\\S+)\\b", 2);

    public static Duration getRetryAfterFromHeaders(HttpHeaders httpHeaders, final Supplier<OffsetDateTime> supplier) {
        Duration durationTryGetRetryDelay = tryGetRetryDelay(httpHeaders, HttpHeaderName.X_MS_RETRY_AFTER_MS, new Function() { // from class: com.azure.core.implementation.ImplUtils$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ImplUtils.tryGetDelayMillis((String) obj);
            }
        });
        if (durationTryGetRetryDelay != null) {
            return durationTryGetRetryDelay;
        }
        Duration durationTryGetRetryDelay2 = tryGetRetryDelay(httpHeaders, HttpHeaderName.RETRY_AFTER_MS, new Function() { // from class: com.azure.core.implementation.ImplUtils$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ImplUtils.tryGetDelayMillis((String) obj);
            }
        });
        return durationTryGetRetryDelay2 != null ? durationTryGetRetryDelay2 : tryGetRetryDelay(httpHeaders, HttpHeaderName.RETRY_AFTER, new Function() { // from class: com.azure.core.implementation.ImplUtils$$ExternalSyntheticLambda2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ImplUtils.tryParseLongOrDateTime((String) obj, supplier);
            }
        });
    }

    private static Duration tryGetRetryDelay(HttpHeaders httpHeaders, HttpHeaderName httpHeaderName, Function<String, Duration> function) {
        String value = httpHeaders.getValue(httpHeaderName);
        if (CoreUtils.isNullOrEmpty(value)) {
            return null;
        }
        return function.apply(value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Duration tryGetDelayMillis(String str) {
        long jTryParseLong = tryParseLong(str);
        if (jTryParseLong >= 0) {
            return Duration.ofMillis(jTryParseLong);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Duration tryParseLongOrDateTime(String str, Supplier<OffsetDateTime> supplier) {
        long jTryParseLong;
        try {
            jTryParseLong = supplier.get().until(new DateTimeRfc1123(str).getDateTime(), ChronoUnit.SECONDS);
        } catch (DateTimeException unused) {
            jTryParseLong = tryParseLong(str);
        }
        if (jTryParseLong >= 0) {
            return Duration.ofSeconds(jTryParseLong);
        }
        return null;
    }

    private static long tryParseLong(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static void writeByteBufferToStream(ByteBuffer byteBuffer, OutputStream outputStream) throws IOException {
        if (byteBuffer.hasArray()) {
            outputStream.write(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining());
            byteBuffer.position(byteBuffer.position() + byteBuffer.remaining());
        } else if (outputStream instanceof FileOutputStream) {
            ((FileOutputStream) outputStream).getChannel().write(byteBuffer);
        } else {
            outputStream.write(FluxUtil.byteBufferToArray(byteBuffer));
        }
    }

    public static UrlBuilder parseUrl(URL url, boolean z) {
        UrlBuilder urlBuilder = new UrlBuilder();
        if (url != null) {
            String protocol = url.getProtocol();
            if (protocol != null && !protocol.isEmpty()) {
                urlBuilder.setScheme(protocol);
            }
            String host = url.getHost();
            if (host != null && !host.isEmpty()) {
                urlBuilder.setHost(host);
            }
            int port = url.getPort();
            if (port != -1) {
                urlBuilder.setPort(port);
            }
            String path = url.getPath();
            if (path != null && !path.isEmpty()) {
                urlBuilder.setPath(path);
            }
            String query = url.getQuery();
            if (query != null && !query.isEmpty() && z) {
                urlBuilder.setQuery(query);
            }
        }
        return urlBuilder;
    }

    public static final class QueryParameterIterator implements Iterator<Map.Entry<String, String>> {
        private boolean done = false;
        private int position;
        private final String queryParameters;
        private final int queryParametersLength;

        public QueryParameterIterator(String str) {
            this.queryParameters = str;
            this.queryParametersLength = str.length();
            this.position = str.startsWith("?") ? 1 : 0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.done;
        }

        @Override // java.util.Iterator
        public Map.Entry<String, String> next() {
            String strSubstring;
            char cCharAt;
            if (this.done) {
                throw new NoSuchElementException();
            }
            int i = this.position;
            while (i < this.queryParametersLength && (cCharAt = this.queryParameters.charAt(i)) != '=') {
                if (cCharAt == '&') {
                    String strSubstring2 = this.queryParameters.substring(this.position, i);
                    this.position = i + 1;
                    return new AbstractMap.SimpleImmutableEntry(strSubstring2, "");
                }
                i++;
            }
            if (i == this.queryParametersLength) {
                this.done = true;
                return new AbstractMap.SimpleImmutableEntry(this.queryParameters.substring(this.position), "");
            }
            String strSubstring3 = this.queryParameters.substring(this.position, i);
            int i2 = i + 1;
            this.position = i2;
            int iIndexOf = this.queryParameters.indexOf(38, i2);
            if (iIndexOf == -1) {
                this.done = true;
                strSubstring = this.queryParameters.substring(this.position);
            } else {
                String strSubstring4 = this.queryParameters.substring(this.position, iIndexOf);
                this.position = iIndexOf + 1;
                strSubstring = strSubstring4;
            }
            return new AbstractMap.SimpleImmutableEntry(strSubstring3, strSubstring);
        }
    }

    public static String bomAwareToString(byte[] bArr, int i, int i2, String str) {
        if (bArr == null) {
            return null;
        }
        if (i2 >= 3 && bArr[i] == -17 && bArr[i + 1] == -69 && bArr[i + 2] == -65) {
            return new String(bArr, 3, bArr.length - 3, StandardCharsets.UTF_8);
        }
        if (i2 >= 4 && bArr[i] == 0 && bArr[i + 1] == 0 && bArr[i + 2] == -2 && bArr[i + 3] == -1) {
            return new String(bArr, 4, bArr.length - 4, UTF_32BE);
        }
        if (i2 >= 4 && bArr[i] == -1 && bArr[i + 1] == -2 && bArr[i + 2] == 0 && bArr[i + 3] == 0) {
            return new String(bArr, 4, bArr.length - 4, UTF_32LE);
        }
        if (i2 >= 2 && bArr[i] == -2 && bArr[i + 1] == -1) {
            return new String(bArr, 2, bArr.length - 2, StandardCharsets.UTF_16BE);
        }
        if (i2 >= 2 && bArr[i] == -1 && bArr[i + 1] == -2) {
            return new String(bArr, 2, bArr.length - 2, StandardCharsets.UTF_16LE);
        }
        if (!CoreUtils.isNullOrEmpty(str)) {
            try {
                Matcher matcher = CHARSET_PATTERN.matcher(str);
                if (matcher.find()) {
                    return new String(bArr, i, i2, Charset.forName(matcher.group(1)));
                }
                return new String(bArr, i, i2, StandardCharsets.UTF_8);
            } catch (IllegalCharsetNameException | UnsupportedCharsetException unused) {
                return new String(bArr, i, i2, StandardCharsets.UTF_8);
            }
        }
        return new String(bArr, i, i2, StandardCharsets.UTF_8);
    }

    public static URL createUrl(String str) throws MalformedURLException {
        return new URL(str);
    }

    public static <T> Class<? extends T> getClassByName(String str) {
        Objects.requireNonNull(str, "'className' cannot be null");
        try {
            return (Class<? extends T>) Class.forName(str, false, ImplUtils.class.getClassLoader());
        } catch (ClassNotFoundException e) {
            throw LOGGER.logExceptionAsError(new RuntimeException("Class '" + str + "' is not found on the classpath.", e));
        }
    }

    public static RetryStrategy getRetryStrategyFromOptions(RetryOptions retryOptions) {
        Objects.requireNonNull(retryOptions, "'retryOptions' cannot be null.");
        if (retryOptions.getExponentialBackoffOptions() != null) {
            return ExponentialBackoffAccessHelper.create(retryOptions.getExponentialBackoffOptions(), retryOptions.getShouldRetryCondition());
        }
        if (retryOptions.getFixedDelayOptions() != null) {
            return FixedDelayAccessHelper.create(retryOptions.getFixedDelayOptions(), retryOptions.getShouldRetryCondition());
        }
        throw new IllegalArgumentException("'retryOptions' didn't define any retry strategy options");
    }

    public static void fullyWriteBuffer(ByteBuffer byteBuffer, WritableByteChannel writableByteChannel) throws IOException {
        while (byteBuffer.hasRemaining()) {
            writableByteChannel.write(byteBuffer);
        }
    }

    public static <E extends Throwable> void sneakyThrows(Throwable th) throws Throwable {
        throw th;
    }

    public static <T> T getResultWithTimeout(Future<T> future, long j) throws Throwable {
        Objects.requireNonNull(future, "'future' cannot be null.");
        if (j <= 0) {
            return future.get();
        }
        try {
            return future.get(j, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            sneakyThrows(cause);
            throw e;
        } catch (TimeoutException e2) {
            future.cancel(true);
            throw e2;
        }
    }

    public static Thread addShutdownHookSafely(final Thread thread) {
        if (thread == null) {
            return null;
        }
        if (ShutdownHookAccessHelperHolder.shutdownHookAccessHelper) {
            AccessControllerUtils.doPrivileged(new Supplier() { // from class: com.azure.core.implementation.ImplUtils$$ExternalSyntheticLambda0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return ImplUtils.lambda$addShutdownHookSafely$1(thread);
                }
            });
            return thread;
        }
        Runtime.getRuntime().addShutdownHook(thread);
        return thread;
    }

    static /* synthetic */ Object lambda$addShutdownHookSafely$1(Thread thread) {
        Runtime.getRuntime().addShutdownHook(thread);
        return null;
    }

    public static void removeShutdownHookSafely(final Thread thread) {
        if (thread == null) {
            return;
        }
        if (ShutdownHookAccessHelperHolder.shutdownHookAccessHelper) {
            AccessControllerUtils.doPrivileged(new Supplier() { // from class: com.azure.core.implementation.ImplUtils$$ExternalSyntheticLambda3
                @Override // java.util.function.Supplier
                public final Object get() {
                    return ImplUtils.lambda$removeShutdownHookSafely$2(thread);
                }
            });
        } else {
            Runtime.getRuntime().removeShutdownHook(thread);
        }
    }

    static /* synthetic */ Object lambda$removeShutdownHookSafely$2(Thread thread) {
        Runtime.getRuntime().removeShutdownHook(thread);
        return null;
    }

    private static final class ShutdownHookAccessHelperHolder {
        private static boolean shutdownHookAccessHelper = Boolean.parseBoolean(Configuration.getGlobalConfiguration().get("AZURE_ENABLE_SHUTDOWN_HOOK_WITH_PRIVILEGE"));

        private ShutdownHookAccessHelperHolder() {
        }
    }

    static boolean isShutdownHookAccessHelper() {
        return ShutdownHookAccessHelperHolder.shutdownHookAccessHelper;
    }

    static void setShutdownHookAccessHelper(boolean z) {
        boolean unused = ShutdownHookAccessHelperHolder.shutdownHookAccessHelper = z;
    }

    private ImplUtils() {
    }
}
