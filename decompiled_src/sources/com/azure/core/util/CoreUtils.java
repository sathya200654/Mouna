package com.azure.core.util;

import androidx.webkit.ProxyConfig;
import com.azure.core.http.HttpHeaders;
import com.azure.core.http.policy.HttpLogOptions;
import com.azure.core.http.rest.PagedResponse;
import com.azure.core.implementation.ImplUtils;
import com.azure.core.implementation.http.AuthenticateChallengeParser;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.logging.LogLevel;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalQuery;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class CoreUtils {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) CoreUtils.class);
    private static final char[] LOWERCASE_HEX_CHARACTERS = "0123456789abcdef".toCharArray();
    private static final Pattern ISO8601_COLONLESS_OFFSET = Pattern.compile("([+-][0-9]{2})([0-9]{2})(?=\\[|$)");

    private CoreUtils() {
    }

    public static byte[] clone(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public static int[] clone(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        int[] iArr2 = new int[iArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    public static <T> T[] clone(T[] tArr) {
        if (tArr == null) {
            return null;
        }
        return (T[]) Arrays.copyOf(tArr, tArr.length);
    }

    public static boolean isNullOrEmpty(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    public static boolean isNullOrEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isNullOrEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static boolean isNullOrEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static <T> String arrayToString(T[] tArr, Function<T, String> function) {
        if (isNullOrEmpty(tArr)) {
            return null;
        }
        return (String) Arrays.stream(tArr).map(function).collect(Collectors.joining(","));
    }

    public static <T> T findFirstOfType(Object[] objArr, Class<T> cls) {
        if (isNullOrEmpty(objArr)) {
            return null;
        }
        for (Object obj : objArr) {
            if (cls.isInstance(obj)) {
                return cls.cast(obj);
            }
        }
        return null;
    }

    @Deprecated
    public static <T> Publisher<T> extractAndFetch(PagedResponse<T> pagedResponse, Context context, BiFunction<String, Context, Publisher<T>> biFunction) {
        String continuationToken = pagedResponse.getContinuationToken();
        if (continuationToken == null) {
            return Flux.fromIterable(pagedResponse.getElements());
        }
        return Flux.fromIterable(pagedResponse.getElements()).concatWith(biFunction.apply(continuationToken, context));
    }

    public static Map<String, String> getProperties(final String str) {
        try {
            InputStream resourceAsStream = CoreUtils.class.getClassLoader().getResourceAsStream(str);
            if (resourceAsStream != null) {
                try {
                    Properties properties = new Properties();
                    properties.load(resourceAsStream);
                    Map<String, String> mapUnmodifiableMap = Collections.unmodifiableMap((Map) properties.entrySet().stream().collect(Collectors.toMap(new Function() { // from class: com.azure.core.util.CoreUtils$$ExternalSyntheticLambda0
                        @Override // java.util.function.Function
                        public final Object apply(Object obj) {
                            return CoreUtils.lambda$getProperties$0((Map.Entry) obj);
                        }
                    }, new Function() { // from class: com.azure.core.util.CoreUtils$$ExternalSyntheticLambda1
                        @Override // java.util.function.Function
                        public final Object apply(Object obj) {
                            return CoreUtils.lambda$getProperties$1((Map.Entry) obj);
                        }
                    })));
                    if (resourceAsStream != null) {
                        resourceAsStream.close();
                    }
                    return mapUnmodifiableMap;
                } catch (Throwable th) {
                    if (resourceAsStream != null) {
                        try {
                            resourceAsStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
            if (resourceAsStream != null) {
                resourceAsStream.close();
            }
            return Collections.emptyMap();
        } catch (IOException e) {
            LOGGER.log(LogLevel.WARNING, new Supplier() { // from class: com.azure.core.util.CoreUtils$$ExternalSyntheticLambda2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return CoreUtils.lambda$getProperties$2(str);
                }
            }, e);
        }
    }

    static /* synthetic */ String lambda$getProperties$0(Map.Entry entry) {
        return (String) entry.getKey();
    }

    static /* synthetic */ String lambda$getProperties$1(Map.Entry entry) {
        return (String) entry.getValue();
    }

    static /* synthetic */ String lambda$getProperties$2(String str) {
        return "Failed to get properties from " + str;
    }

    public static String bomAwareToString(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        return ImplUtils.bomAwareToString(bArr, 0, bArr.length, str);
    }

    public static String getApplicationId(ClientOptions clientOptions, HttpLogOptions httpLogOptions) {
        if (clientOptions != null && !isNullOrEmpty(clientOptions.getApplicationId())) {
            return clientOptions.getApplicationId();
        }
        if (httpLogOptions == null || isNullOrEmpty(httpLogOptions.getApplicationId())) {
            return null;
        }
        return httpLogOptions.getApplicationId();
    }

    public static HttpHeaders createHttpHeadersFromClientOptions(ClientOptions clientOptions) {
        if (clientOptions == null) {
            return null;
        }
        Iterator<Header> it = clientOptions.getHeaders().iterator();
        if (!it.hasNext()) {
            return null;
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        do {
            Header next = it.next();
            httpHeaders.set(next.getName(), next.getValue());
        } while (it.hasNext());
        return httpHeaders;
    }

    public static Duration getDefaultTimeoutFromEnvironment(Configuration configuration, String str, Duration duration, ClientLogger clientLogger) {
        String str2 = configuration.get(str);
        if (isNullOrEmpty(str2)) {
            return duration;
        }
        try {
            long j = Long.parseLong(str2);
            if (j < 0) {
                clientLogger.atVerbose().addKeyValue(str, j).log("Negative timeout values are not allowed. Using 'Duration.ZERO' to indicate no timeout.");
                return Duration.ZERO;
            }
            return Duration.ofMillis(j);
        } catch (NumberFormatException e) {
            clientLogger.atInfo().addKeyValue(str, str2).addKeyValue("defaultTimeout", duration).log("Timeout is not valid number. Using default value.", e);
            return duration;
        }
    }

    public static Context mergeContexts(Context context, Context context2) {
        Objects.requireNonNull(context, "'into' cannot be null.");
        Objects.requireNonNull(context2, "'from' cannot be null.");
        if (context == Context.NONE) {
            return context2;
        }
        if (context2 == Context.NONE) {
            return context;
        }
        for (Context context3 : context2.getContextChain()) {
            if (context3 != null) {
                context = context.addData(context3.getKey(), context3.getValue());
            }
        }
        return context;
    }

    public static String stringJoin(String str, List<String> list) {
        Objects.requireNonNull(str, "'delimiter' cannot be null.");
        Objects.requireNonNull(list, "'values' cannot be null.");
        switch (list.size()) {
            case 0:
                return "";
            case 1:
                return list.get(0);
            case 2:
                return list.get(0) + str + list.get(1);
            case 3:
                return list.get(0) + str + list.get(1) + str + list.get(2);
            case 4:
                return list.get(0) + str + list.get(1) + str + list.get(2) + str + list.get(3);
            case 5:
                return list.get(0) + str + list.get(1) + str + list.get(2) + str + list.get(3) + str + list.get(4);
            case 6:
                return list.get(0) + str + list.get(1) + str + list.get(2) + str + list.get(3) + str + list.get(4) + str + list.get(5);
            case 7:
                return list.get(0) + str + list.get(1) + str + list.get(2) + str + list.get(3) + str + list.get(4) + str + list.get(5) + str + list.get(6);
            case 8:
                return list.get(0) + str + list.get(1) + str + list.get(2) + str + list.get(3) + str + list.get(4) + str + list.get(5) + str + list.get(6) + str + list.get(7);
            case 9:
                return list.get(0) + str + list.get(1) + str + list.get(2) + str + list.get(3) + str + list.get(4) + str + list.get(5) + str + list.get(6) + str + list.get(7) + str + list.get(8);
            case 10:
                return list.get(0) + str + list.get(1) + str + list.get(2) + str + list.get(3) + str + list.get(4) + str + list.get(5) + str + list.get(6) + str + list.get(7) + str + list.get(8) + str + list.get(9);
            default:
                return String.join(str, list);
        }
    }

    public static String bytesToHexString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return "";
        }
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            int i2 = b & UnsignedBytes.MAX_VALUE;
            int i3 = i * 2;
            char[] cArr2 = LOWERCASE_HEX_CHARACTERS;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public static long extractSizeFromContentRange(String str) {
        Objects.requireNonNull(str, "Cannot extract length from null 'contentRange'.");
        int iIndexOf = str.indexOf(47);
        if (iIndexOf == -1) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("The Content-Range header wasn't properly formatted and didn't contain a '/size' segment. The 'contentRange' was: " + str));
        }
        String strTrim = str.substring(iIndexOf + 1).trim();
        if (ProxyConfig.MATCH_ALL_SCHEMES.equals(strTrim)) {
            return -1L;
        }
        return Long.parseLong(strTrim);
    }

    public static Iterator<Map.Entry<String, String>> parseQueryParameters(String str) {
        if (isNullOrEmpty(str)) {
            return Collections.emptyIterator();
        }
        return new ImplUtils.QueryParameterIterator(str);
    }

    public static UUID randomUuid() {
        return randomUuid(ThreadLocalRandom.current().nextLong(), ThreadLocalRandom.current().nextLong());
    }

    static UUID randomUuid(long j, long j2) {
        return new UUID((j & (-61441)) | 16384, (j2 & 4611686018427387903L) | Long.MIN_VALUE);
    }

    public static <T> T getResultWithTimeout(Future<T> future, Duration duration) throws ExecutionException, InterruptedException, TimeoutException {
        Objects.requireNonNull(future, "'future' cannot be null.");
        if (duration == null) {
            return future.get();
        }
        return (T) ImplUtils.getResultWithTimeout(future, duration.toMillis());
    }

    public static ExecutorService addShutdownHookSafely(ExecutorService executorService, Duration duration) {
        if (executorService == null) {
            return null;
        }
        Objects.requireNonNull(duration, "'shutdownTimeout' cannot be null.");
        if (duration.isZero() || duration.isNegative()) {
            throw new IllegalArgumentException("'shutdownTimeout' must be a non-zero positive duration.");
        }
        addShutdownHookSafely(createExecutorServiceShutdownThread(executorService, duration));
        return executorService;
    }

    static Thread createExecutorServiceShutdownThread(final ExecutorService executorService, Duration duration) {
        final long nanos = duration.toNanos();
        return new Thread(new Runnable() { // from class: com.azure.core.util.CoreUtils$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                CoreUtils.lambda$createExecutorServiceShutdownThread$3(executorService, nanos);
            }
        });
    }

    static /* synthetic */ void lambda$createExecutorServiceShutdownThread$3(ExecutorService executorService, long j) {
        try {
            executorService.shutdown();
            if (executorService.awaitTermination(j / 2, TimeUnit.NANOSECONDS)) {
                return;
            }
            executorService.shutdownNow();
            executorService.awaitTermination(j / 2, TimeUnit.NANOSECONDS);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            executorService.shutdown();
        }
    }

    public static Thread addShutdownHookSafely(Thread thread) {
        return ImplUtils.addShutdownHookSafely(thread);
    }

    public static String durationToStringWithDays(Duration duration) {
        if (duration == null) {
            return null;
        }
        if (duration.isZero()) {
            return "PT0S";
        }
        StringBuilder sb = new StringBuilder();
        if (duration.isNegative()) {
            sb.append("-P");
            duration = duration.negated();
        } else {
            sb.append('P');
        }
        long days = duration.toDays();
        if (days > 0) {
            sb.append(days);
            sb.append('D');
            duration = duration.minusDays(days);
        }
        long hours = duration.toHours();
        if (hours > 0) {
            sb.append('T');
            sb.append(hours);
            sb.append('H');
            duration = duration.minusHours(hours);
        }
        long minutes = duration.toMinutes();
        if (minutes > 0) {
            if (hours == 0) {
                sb.append('T');
            }
            sb.append(minutes);
            sb.append('M');
            duration = duration.minusMinutes(minutes);
        }
        long seconds = duration.getSeconds();
        if (seconds > 0) {
            if (hours == 0 && minutes == 0) {
                sb.append('T');
            }
            sb.append(seconds);
            duration = duration.minusSeconds(seconds);
        }
        long millis = duration.toMillis();
        if (millis > 0) {
            if (hours == 0 && minutes == 0 && seconds == 0) {
                sb.append("T");
            }
            if (seconds == 0) {
                sb.append("0");
            }
            sb.append('.');
            if (millis <= 99) {
                sb.append('0');
                if (millis <= 9) {
                    sb.append('0');
                }
            }
            while (millis % 10 == 0) {
                millis /= 10;
            }
            sb.append(millis);
        }
        if (seconds > 0 || millis > 0) {
            sb.append('S');
        }
        return sb.toString();
    }

    public static OffsetDateTime parseBestOffsetDateTime(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = ISO8601_COLONLESS_OFFSET.matcher(str);
        if (matcher.find()) {
            str = str.substring(0, matcher.start()) + matcher.group(1) + ":" + matcher.group(2) + str.substring(matcher.start() + 5);
        }
        TemporalAccessor best = DateTimeFormatter.ISO_DATE_TIME.parseBest(str, new TemporalQuery() { // from class: com.azure.core.util.CoreUtils$$ExternalSyntheticLambda3
            @Override // java.time.temporal.TemporalQuery
            public final Object queryFrom(TemporalAccessor temporalAccessor) {
                return OffsetDateTime.from(temporalAccessor);
            }
        }, new TemporalQuery() { // from class: com.azure.core.util.CoreUtils$$ExternalSyntheticLambda4
            @Override // java.time.temporal.TemporalQuery
            public final Object queryFrom(TemporalAccessor temporalAccessor) {
                return LocalDateTime.from(temporalAccessor);
            }
        });
        if (best.query(TemporalQueries.offset()) == null) {
            return LocalDateTime.from(best).atOffset(ZoneOffset.UTC);
        }
        return OffsetDateTime.from(best);
    }

    public static List<AuthenticateChallenge> parseAuthenticateHeader(String str) {
        if (isNullOrEmpty(str)) {
            return Collections.emptyList();
        }
        return new AuthenticateChallengeParser(str).parse();
    }
}
