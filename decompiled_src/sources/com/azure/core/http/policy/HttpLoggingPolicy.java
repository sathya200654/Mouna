package com.azure.core.http.policy;

import com.azure.core.http.ContentType;
import com.azure.core.http.HttpHeader;
import com.azure.core.http.HttpHeaderName;
import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpPipelineCallContext;
import com.azure.core.http.HttpPipelineNextPolicy;
import com.azure.core.http.HttpPipelineNextSyncPolicy;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.HttpResponse;
import com.azure.core.implementation.AccessibleByteArrayOutputStream;
import com.azure.core.implementation.ImplUtils;
import com.azure.core.implementation.http.UrlSanitizer;
import com.azure.core.implementation.jackson.ObjectMapperShim;
import com.azure.core.implementation.logging.LoggingKeys;
import com.azure.core.implementation.util.BinaryDataContent;
import com.azure.core.implementation.util.BinaryDataHelper;
import com.azure.core.implementation.util.ByteArrayContent;
import com.azure.core.implementation.util.ByteBufferContent;
import com.azure.core.implementation.util.HttpHeadersAccessHelper;
import com.azure.core.implementation.util.InputStreamContent;
import com.azure.core.implementation.util.SerializableContent;
import com.azure.core.implementation.util.StringContent;
import com.azure.core.util.Context;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.FluxUtil;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.logging.LogLevel;
import com.azure.core.util.logging.LoggingEventBuilder;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class HttpLoggingPolicy implements HttpPipelinePolicy {
    private static final int LOGGER_CACHE_MAX_SIZE = 1000;
    private static final int MAX_BODY_LOG_SIZE = 16384;
    private static final String REQUEST_LOG_MESSAGE = "HTTP request";
    private static final String RESPONSE_LOG_MESSAGE = "HTTP response";
    public static final String RETRY_COUNT_CONTEXT = "requestRetryCount";
    private final Set<String> allowedHeaderNames;
    private final boolean disableRedactedHeaderLogging;
    private final HttpLogDetailLevel httpLogDetailLevel;
    private final boolean prettyPrintBody;
    private final HttpRequestLogger requestLogger;
    private final HttpResponseLogger responseLogger;
    private final UrlSanitizer urlSanitizer;
    private static final ObjectMapperShim PRETTY_PRINTER = ObjectMapperShim.createPrettyPrintMapper();
    private static final String CONTENT_LENGTH_KEY = HttpHeaderName.CONTENT_LENGTH.getCaseInsensitiveName();
    private static final Map<String, ClientLogger> CALLER_METHOD_LOGGER_CACHE = new ConcurrentHashMap();
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) HttpLoggingPolicy.class);

    static /* synthetic */ AccessibleByteArrayOutputStream lambda$logBody$2(AccessibleByteArrayOutputStream accessibleByteArrayOutputStream) throws Exception {
        return accessibleByteArrayOutputStream;
    }

    public HttpLoggingPolicy(HttpLogOptions httpLogOptions) {
        HttpRequestLogger requestLogger;
        HttpResponseLogger responseLogger;
        AnonymousClass1 anonymousClass1 = null;
        if (httpLogOptions == null) {
            this.httpLogDetailLevel = HttpLogDetailLevel.ENVIRONMENT_HTTP_LOG_DETAIL_LEVEL;
            this.allowedHeaderNames = (Set) HttpLogOptions.DEFAULT_HEADERS_ALLOWLIST.stream().map(new Function() { // from class: com.azure.core.http.policy.HttpLoggingPolicy$$ExternalSyntheticLambda6
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ((HttpHeaderName) obj).getCaseInsensitiveName();
                }
            }).collect(Collectors.toSet());
            this.urlSanitizer = new UrlSanitizer(null);
            this.prettyPrintBody = false;
            this.disableRedactedHeaderLogging = false;
            this.requestLogger = new DefaultHttpRequestLogger(this, anonymousClass1);
            this.responseLogger = new DefaultHttpResponseLogger(this, anonymousClass1);
            return;
        }
        this.httpLogDetailLevel = httpLogOptions.getLogLevel();
        this.allowedHeaderNames = (Set) httpLogOptions.getAllowedHttpHeaderNames().stream().map(new Function() { // from class: com.azure.core.http.policy.HttpLoggingPolicy$$ExternalSyntheticLambda6
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((HttpHeaderName) obj).getCaseInsensitiveName();
            }
        }).collect(Collectors.toSet());
        this.urlSanitizer = new UrlSanitizer(httpLogOptions.getAllowedQueryParamNames());
        this.prettyPrintBody = httpLogOptions.isPrettyPrintBody();
        this.disableRedactedHeaderLogging = httpLogOptions.isRedactedHeaderLoggingDisabled();
        if (httpLogOptions.getRequestLogger() == null) {
            requestLogger = new DefaultHttpRequestLogger(this, anonymousClass1);
        } else {
            requestLogger = httpLogOptions.getRequestLogger();
        }
        this.requestLogger = requestLogger;
        if (httpLogOptions.getResponseLogger() == null) {
            responseLogger = new DefaultHttpResponseLogger(this, anonymousClass1);
        } else {
            responseLogger = httpLogOptions.getResponseLogger();
        }
        this.responseLogger = responseLogger;
    }

    @Override // com.azure.core.http.policy.HttpPipelinePolicy
    public Mono<HttpResponse> process(final HttpPipelineCallContext httpPipelineCallContext, HttpPipelineNextPolicy httpPipelineNextPolicy) {
        if (this.httpLogDetailLevel == HttpLogDetailLevel.NONE) {
            return httpPipelineNextPolicy.process();
        }
        final ClientLogger orCreateMethodLogger = getOrCreateMethodLogger(httpPipelineCallContext.getContext());
        final long jNanoTime = System.nanoTime();
        return this.requestLogger.logRequest(orCreateMethodLogger, getRequestLoggingOptions(httpPipelineCallContext)).then(httpPipelineNextPolicy.process()).flatMap(new Function() { // from class: com.azure.core.http.policy.HttpLoggingPolicy$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1132lambda$process$0$comazurecorehttppolicyHttpLoggingPolicy(orCreateMethodLogger, jNanoTime, httpPipelineCallContext, (HttpResponse) obj);
            }
        }).doOnError(new Consumer() { // from class: com.azure.core.http.policy.HttpLoggingPolicy$$ExternalSyntheticLambda1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.m1133lambda$process$1$comazurecorehttppolicyHttpLoggingPolicy(orCreateMethodLogger, httpPipelineCallContext, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$process$0$com-azure-core-http-policy-HttpLoggingPolicy, reason: not valid java name */
    /* synthetic */ Mono m1132lambda$process$0$comazurecorehttppolicyHttpLoggingPolicy(ClientLogger clientLogger, long j, HttpPipelineCallContext httpPipelineCallContext, HttpResponse httpResponse) {
        return this.responseLogger.logResponse(clientLogger, getResponseLoggingOptions(httpResponse, j, httpPipelineCallContext));
    }

    /* JADX INFO: renamed from: lambda$process$1$com-azure-core-http-policy-HttpLoggingPolicy, reason: not valid java name */
    /* synthetic */ void m1133lambda$process$1$comazurecorehttppolicyHttpLoggingPolicy(ClientLogger clientLogger, HttpPipelineCallContext httpPipelineCallContext, Throwable th) {
        createBasicLoggingContext(clientLogger, LogLevel.WARNING, httpPipelineCallContext.getHttpRequest()).log("HTTP FAILED", th);
    }

    @Override // com.azure.core.http.policy.HttpPipelinePolicy
    public HttpResponse processSync(HttpPipelineCallContext httpPipelineCallContext, HttpPipelineNextSyncPolicy httpPipelineNextSyncPolicy) {
        if (this.httpLogDetailLevel == HttpLogDetailLevel.NONE) {
            return httpPipelineNextSyncPolicy.processSync();
        }
        ClientLogger orCreateMethodLogger = getOrCreateMethodLogger(httpPipelineCallContext.getContext());
        long jNanoTime = System.nanoTime();
        this.requestLogger.logRequestSync(orCreateMethodLogger, getRequestLoggingOptions(httpPipelineCallContext));
        try {
            HttpResponse httpResponseProcessSync = httpPipelineNextSyncPolicy.processSync();
            return httpResponseProcessSync != null ? this.responseLogger.logResponseSync(orCreateMethodLogger, getResponseLoggingOptions(httpResponseProcessSync, jNanoTime, httpPipelineCallContext)) : httpResponseProcessSync;
        } catch (RuntimeException e) {
            createBasicLoggingContext(orCreateMethodLogger, LogLevel.WARNING, httpPipelineCallContext.getHttpRequest()).log("HTTP FAILED", e);
            throw e;
        }
    }

    private LoggingEventBuilder createBasicLoggingContext(ClientLogger clientLogger, LogLevel logLevel, HttpRequest httpRequest) {
        String value;
        String value2;
        LoggingEventBuilder loggingEventBuilderAtLevel = clientLogger.atLevel(logLevel);
        if (LOGGER.canLogAtLevel(logLevel) && httpRequest != null) {
            if (this.allowedHeaderNames.contains(HttpHeaderName.X_MS_CLIENT_REQUEST_ID.getCaseInsensitiveName()) && (value2 = httpRequest.getHeaders().getValue(HttpHeaderName.X_MS_CLIENT_REQUEST_ID)) != null) {
                loggingEventBuilderAtLevel.addKeyValue(HttpHeaderName.X_MS_CLIENT_REQUEST_ID.getCaseInsensitiveName(), value2);
            }
            if (this.allowedHeaderNames.contains(HttpHeaderName.TRACEPARENT.getCaseInsensitiveName()) && (value = httpRequest.getHeaders().getValue(HttpHeaderName.TRACEPARENT)) != null) {
                loggingEventBuilderAtLevel.addKeyValue(HttpHeaderName.TRACEPARENT.getCaseInsensitiveName(), value);
            }
        }
        return loggingEventBuilderAtLevel;
    }

    private HttpRequestLoggingContext getRequestLoggingOptions(HttpPipelineCallContext httpPipelineCallContext) {
        return new HttpRequestLoggingContext(httpPipelineCallContext.getHttpRequest(), httpPipelineCallContext.getContext(), getRequestRetryCount(httpPipelineCallContext.getContext()));
    }

    private HttpResponseLoggingContext getResponseLoggingOptions(HttpResponse httpResponse, long j, HttpPipelineCallContext httpPipelineCallContext) {
        return new HttpResponseLoggingContext(httpResponse, Duration.ofNanos(System.nanoTime() - j), httpPipelineCallContext.getContext(), getRequestRetryCount(httpPipelineCallContext.getContext()));
    }

    private final class DefaultHttpRequestLogger implements HttpRequestLogger {
        private DefaultHttpRequestLogger() {
        }

        /* synthetic */ DefaultHttpRequestLogger(HttpLoggingPolicy httpLoggingPolicy, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.azure.core.http.policy.HttpRequestLogger
        public Mono<Void> logRequest(ClientLogger clientLogger, HttpRequestLoggingContext httpRequestLoggingContext) {
            logRequestSync(clientLogger, httpRequestLoggingContext);
            return Mono.empty();
        }

        @Override // com.azure.core.http.policy.HttpRequestLogger
        public void logRequestSync(ClientLogger clientLogger, HttpRequestLoggingContext httpRequestLoggingContext) {
            log(getLogLevel(httpRequestLoggingContext), clientLogger, httpRequestLoggingContext);
        }

        private void log(LogLevel logLevel, ClientLogger clientLogger, HttpRequestLoggingContext httpRequestLoggingContext) {
            if (!clientLogger.canLogAtLevel(logLevel) || HttpLoggingPolicy.this.httpLogDetailLevel == HttpLogDetailLevel.NONE) {
                return;
            }
            HttpRequest httpRequest = httpRequestLoggingContext.getHttpRequest();
            LoggingEventBuilder loggingEventBuilderAddKeyValue = HttpLoggingPolicy.getLogBuilder(logLevel, clientLogger).addKeyValue(LoggingKeys.HTTP_METHOD_KEY, httpRequest.getHttpMethod()).addKeyValue(LoggingKeys.URL_KEY, HttpLoggingPolicy.this.urlSanitizer.getRedactedUrl(httpRequest.getUrl()));
            Integer tryCount = httpRequestLoggingContext.getTryCount();
            if (tryCount != null) {
                loggingEventBuilderAddKeyValue.addKeyValue(LoggingKeys.TRY_COUNT_KEY, tryCount);
            }
            if (HttpLoggingPolicy.this.httpLogDetailLevel.shouldLogHeaders() && clientLogger.canLogAtLevel(LogLevel.INFORMATIONAL)) {
                HttpLoggingPolicy.addHeadersToLogMessage(HttpLoggingPolicy.this.allowedHeaderNames, httpRequest.getHeaders(), loggingEventBuilderAddKeyValue, HttpLoggingPolicy.this.disableRedactedHeaderLogging);
            }
            Long andLogContentLength = HttpLoggingPolicy.this.getAndLogContentLength(httpRequest.getHeaders(), loggingEventBuilderAddKeyValue, clientLogger);
            if (httpRequest.getBody() == null) {
                loggingEventBuilderAddKeyValue.log(HttpLoggingPolicy.REQUEST_LOG_MESSAGE);
                return;
            }
            String value = httpRequest.getHeaders().getValue(HttpHeaderName.CONTENT_TYPE);
            if (HttpLoggingPolicy.this.httpLogDetailLevel.shouldLogBody() && HttpLoggingPolicy.shouldBodyBeLogged(value, andLogContentLength)) {
                HttpLoggingPolicy.this.logBody(httpRequest, andLogContentLength.intValue(), loggingEventBuilderAddKeyValue, clientLogger, value);
            } else {
                loggingEventBuilderAddKeyValue.log(HttpLoggingPolicy.REQUEST_LOG_MESSAGE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logBody(HttpRequest httpRequest, int i, final LoggingEventBuilder loggingEventBuilder, final ClientLogger clientLogger, final String str) {
        final BinaryDataContent content = BinaryDataHelper.getContent(httpRequest.getBodyAsBinaryData());
        if ((content instanceof StringContent) || (content instanceof ByteBufferContent) || (content instanceof SerializableContent) || (content instanceof ByteArrayContent)) {
            logBody(loggingEventBuilder, clientLogger, str, content.toString());
            return;
        }
        if (content instanceof InputStreamContent) {
            byte[] bytes = content.toBytes();
            httpRequest.setBody(bytes);
            logBody(loggingEventBuilder, clientLogger, str, new String(bytes, StandardCharsets.UTF_8));
        } else {
            final AccessibleByteArrayOutputStream accessibleByteArrayOutputStream = new AccessibleByteArrayOutputStream(i);
            httpRequest.setBody(Flux.using(new Callable() { // from class: com.azure.core.http.policy.HttpLoggingPolicy$$ExternalSyntheticLambda3
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return HttpLoggingPolicy.lambda$logBody$2(accessibleByteArrayOutputStream);
                }
            }, new Function() { // from class: com.azure.core.http.policy.HttpLoggingPolicy$$ExternalSyntheticLambda4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return content.toFluxByteBuffer().doOnNext(new Consumer() { // from class: com.azure.core.http.policy.HttpLoggingPolicy$$ExternalSyntheticLambda2
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj2) {
                            HttpLoggingPolicy.lambda$logBody$3(accessibleByteArrayOutputStream, (ByteBuffer) obj2);
                        }
                    });
                }
            }, new Consumer() { // from class: com.azure.core.http.policy.HttpLoggingPolicy$$ExternalSyntheticLambda5
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f$0.m1131lambda$logBody$5$comazurecorehttppolicyHttpLoggingPolicy(loggingEventBuilder, clientLogger, str, (AccessibleByteArrayOutputStream) obj);
                }
            }));
        }
    }

    static /* synthetic */ void lambda$logBody$3(AccessibleByteArrayOutputStream accessibleByteArrayOutputStream, ByteBuffer byteBuffer) {
        try {
            ImplUtils.writeByteBufferToStream(byteBuffer.duplicate(), accessibleByteArrayOutputStream);
        } catch (IOException e) {
            throw LOGGER.logExceptionAsError(new UncheckedIOException(e));
        }
    }

    /* JADX INFO: renamed from: lambda$logBody$5$com-azure-core-http-policy-HttpLoggingPolicy, reason: not valid java name */
    /* synthetic */ void m1131lambda$logBody$5$comazurecorehttppolicyHttpLoggingPolicy(LoggingEventBuilder loggingEventBuilder, ClientLogger clientLogger, String str, AccessibleByteArrayOutputStream accessibleByteArrayOutputStream) {
        logBody(loggingEventBuilder, clientLogger, str, accessibleByteArrayOutputStream.toString(StandardCharsets.UTF_8));
    }

    private void logBody(LoggingEventBuilder loggingEventBuilder, ClientLogger clientLogger, String str, String str2) {
        loggingEventBuilder.addKeyValue(LoggingKeys.BODY_KEY, prettyPrintIfNeeded(clientLogger, this.prettyPrintBody, str, str2)).log(REQUEST_LOG_MESSAGE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class DefaultHttpResponseLogger implements HttpResponseLogger {
        private DefaultHttpResponseLogger() {
        }

        /* synthetic */ DefaultHttpResponseLogger(HttpLoggingPolicy httpLoggingPolicy, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.azure.core.http.policy.HttpResponseLogger
        public Mono<HttpResponse> logResponse(final ClientLogger clientLogger, HttpResponseLoggingContext httpResponseLoggingContext) {
            LogLevel logLevel = getLogLevel(httpResponseLoggingContext);
            HttpResponse httpResponse = httpResponseLoggingContext.getHttpResponse();
            if (clientLogger.canLogAtLevel(logLevel) && HttpLoggingPolicy.this.httpLogDetailLevel != HttpLogDetailLevel.NONE) {
                final LoggingEventBuilder logBuilder = HttpLoggingPolicy.getLogBuilder(logLevel, clientLogger);
                addBasicResponseProperties(clientLogger, httpResponseLoggingContext, httpResponse, logBuilder);
                Long andLogContentLength = HttpLoggingPolicy.this.getAndLogContentLength(httpResponse.getHeaders(), logBuilder, clientLogger);
                Mono monoJust = Mono.just(httpResponse);
                if (HttpLoggingPolicy.this.httpLogDetailLevel.shouldLogBody()) {
                    final String headerValue = httpResponse.getHeaderValue(HttpHeaderName.CONTENT_TYPE);
                    if (HttpLoggingPolicy.shouldBodyBeLogged(headerValue, andLogContentLength)) {
                        final HttpResponse httpResponseBuffer = httpResponse.buffer();
                        monoJust = FluxUtil.collectBytesInByteBufferStream(httpResponseBuffer.getBody()).map(new Function() { // from class: com.azure.core.http.policy.HttpLoggingPolicy$DefaultHttpResponseLogger$$ExternalSyntheticLambda0
                            @Override // java.util.function.Function
                            public final Object apply(Object obj) {
                                return this.f$0.m1134x6f8909d5(logBuilder, clientLogger, headerValue, httpResponseBuffer, (byte[]) obj);
                            }
                        });
                    }
                }
                return monoJust.doOnNext(new Consumer() { // from class: com.azure.core.http.policy.HttpLoggingPolicy$DefaultHttpResponseLogger$$ExternalSyntheticLambda1
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        logBuilder.log(HttpLoggingPolicy.RESPONSE_LOG_MESSAGE);
                    }
                });
            }
            return Mono.just(httpResponse);
        }

        /* JADX INFO: renamed from: lambda$logResponse$0$com-azure-core-http-policy-HttpLoggingPolicy$DefaultHttpResponseLogger, reason: not valid java name */
        /* synthetic */ HttpResponse m1134x6f8909d5(LoggingEventBuilder loggingEventBuilder, ClientLogger clientLogger, String str, HttpResponse httpResponse, byte[] bArr) {
            loggingEventBuilder.addKeyValue(LoggingKeys.BODY_KEY, HttpLoggingPolicy.prettyPrintIfNeeded(clientLogger, HttpLoggingPolicy.this.prettyPrintBody, str, new String(bArr, StandardCharsets.UTF_8)));
            return httpResponse;
        }

        private void logHeaders(ClientLogger clientLogger, HttpResponse httpResponse, LoggingEventBuilder loggingEventBuilder) {
            if (HttpLoggingPolicy.this.httpLogDetailLevel.shouldLogHeaders() && clientLogger.canLogAtLevel(LogLevel.INFORMATIONAL)) {
                HttpLoggingPolicy.addHeadersToLogMessage(HttpLoggingPolicy.this.allowedHeaderNames, httpResponse.getHeaders(), loggingEventBuilder, HttpLoggingPolicy.this.disableRedactedHeaderLogging);
            }
        }

        private void addBasicResponseProperties(ClientLogger clientLogger, HttpResponseLoggingContext httpResponseLoggingContext, HttpResponse httpResponse, LoggingEventBuilder loggingEventBuilder) {
            loggingEventBuilder.addKeyValue(LoggingKeys.STATUS_CODE_KEY, httpResponse.getStatusCode()).addKeyValue(LoggingKeys.URL_KEY, HttpLoggingPolicy.this.urlSanitizer.getRedactedUrl(httpResponse.getRequest().getUrl())).addKeyValue(LoggingKeys.DURATION_MS_KEY, httpResponseLoggingContext.getResponseDuration().toMillis());
            HttpLoggingPolicy.this.getAndLogContentLength(httpResponse.getHeaders(), loggingEventBuilder, clientLogger);
            logHeaders(clientLogger, httpResponse, loggingEventBuilder);
        }

        @Override // com.azure.core.http.policy.HttpResponseLogger
        public HttpResponse logResponseSync(ClientLogger clientLogger, HttpResponseLoggingContext httpResponseLoggingContext) {
            LogLevel logLevel = getLogLevel(httpResponseLoggingContext);
            HttpResponse httpResponse = httpResponseLoggingContext.getHttpResponse();
            if (!clientLogger.canLogAtLevel(logLevel)) {
                return httpResponse;
            }
            LoggingEventBuilder logBuilder = HttpLoggingPolicy.getLogBuilder(logLevel, clientLogger);
            addBasicResponseProperties(clientLogger, httpResponseLoggingContext, httpResponse, logBuilder);
            Long andLogContentLength = HttpLoggingPolicy.this.getAndLogContentLength(httpResponse.getHeaders(), logBuilder, clientLogger);
            if (HttpLoggingPolicy.this.httpLogDetailLevel.shouldLogBody()) {
                String headerValue = httpResponse.getHeaderValue(HttpHeaderName.CONTENT_TYPE);
                if (HttpLoggingPolicy.shouldBodyBeLogged(headerValue, andLogContentLength)) {
                    httpResponse = httpResponse.buffer();
                    logBuilder.addKeyValue(LoggingKeys.BODY_KEY, HttpLoggingPolicy.prettyPrintIfNeeded(clientLogger, HttpLoggingPolicy.this.prettyPrintBody, headerValue, httpResponse.getBodyAsBinaryData().toString()));
                }
            }
            logBuilder.log(HttpLoggingPolicy.RESPONSE_LOG_MESSAGE);
            return httpResponse;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void addHeadersToLogMessage(final Set<String> set, HttpHeaders httpHeaders, final LoggingEventBuilder loggingEventBuilder, final boolean z) {
        final StringBuilder sb = new StringBuilder();
        HttpHeadersAccessHelper.getRawHeaderMap(httpHeaders).forEach(new BiConsumer() { // from class: com.azure.core.http.policy.HttpLoggingPolicy$$ExternalSyntheticLambda7
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                HttpLoggingPolicy.lambda$addHeadersToLogMessage$6(set, loggingEventBuilder, z, sb, (String) obj, (HttpHeader) obj2);
            }
        });
        if (sb.length() > 0) {
            loggingEventBuilder.addKeyValue("redactedHeaders", sb.toString());
        }
    }

    static /* synthetic */ void lambda$addHeadersToLogMessage$6(Set set, LoggingEventBuilder loggingEventBuilder, boolean z, StringBuilder sb, String str, HttpHeader httpHeader) {
        if (CONTENT_LENGTH_KEY.equals(str)) {
            return;
        }
        if (set.contains(str)) {
            loggingEventBuilder.addKeyValue(httpHeader.getName(), httpHeader.getValue());
        } else {
            if (z) {
                return;
            }
            if (sb.length() > 0) {
                sb.append(',');
            }
            sb.append(httpHeader.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String prettyPrintIfNeeded(ClientLogger clientLogger, boolean z, String str, String str2) {
        if (z && str != null && (str.startsWith(ContentType.APPLICATION_JSON) || str.startsWith("text/json"))) {
            try {
                ObjectMapperShim objectMapperShim = PRETTY_PRINTER;
                return objectMapperShim.writeValueAsString(objectMapperShim.readTree(str2));
            } catch (Exception e) {
                clientLogger.log(LogLevel.WARNING, new Supplier() { // from class: com.azure.core.http.policy.HttpLoggingPolicy$$ExternalSyntheticLambda9
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return HttpLoggingPolicy.lambda$prettyPrintIfNeeded$7();
                    }
                }, e);
            }
        }
        return str2;
    }

    static /* synthetic */ String lambda$prettyPrintIfNeeded$7() {
        return "Failed to pretty print JSON";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Long getAndLogContentLength(HttpHeaders httpHeaders, LoggingEventBuilder loggingEventBuilder, ClientLogger clientLogger) {
        String value = httpHeaders.getValue(HttpHeaderName.CONTENT_LENGTH);
        if (CoreUtils.isNullOrEmpty(value)) {
            return null;
        }
        try {
            Long lValueOf = Long.valueOf(Long.parseLong(value));
            loggingEventBuilder.addKeyValue(CONTENT_LENGTH_KEY, lValueOf);
            return lValueOf;
        } catch (NumberFormatException e) {
            clientLogger.atInfo().addKeyValue(CONTENT_LENGTH_KEY, value).log("Could not parse the HTTP header content-length", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean shouldBodyBeLogged(String str, Long l) {
        return (l == null || ContentType.APPLICATION_OCTET_STREAM.equalsIgnoreCase(str) || l.longValue() == 0 || l.longValue() >= 16384) ? false : true;
    }

    private static Integer getRequestRetryCount(Context context) {
        Object objOrElse = context.getData(RETRY_COUNT_CONTEXT).orElse(null);
        if (objOrElse == null) {
            return null;
        }
        try {
            return Integer.valueOf(objOrElse.toString());
        } catch (NumberFormatException unused) {
            LOGGER.atInfo().addKeyValue(LoggingKeys.TRY_COUNT_KEY, objOrElse).log("Could not parse the request retry count.");
            return null;
        }
    }

    private static ClientLogger getOrCreateMethodLogger(Context context) {
        ClientLogger clientLogger = (ClientLogger) context.getData("caller-method-logger").orElse(null);
        if (clientLogger != null) {
            return clientLogger;
        }
        String str = (String) context.getData("caller-method").orElse("");
        Map<String, ClientLogger> map = CALLER_METHOD_LOGGER_CACHE;
        if (map.size() > 1000) {
            map.clear();
        }
        return map.computeIfAbsent(str, new Function() { // from class: com.azure.core.http.policy.HttpLoggingPolicy$$ExternalSyntheticLambda8
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return new ClientLogger((String) obj);
            }
        });
    }

    /* JADX INFO: renamed from: com.azure.core.http.policy.HttpLoggingPolicy$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$azure$core$util$logging$LogLevel;

        static {
            int[] iArr = new int[LogLevel.values().length];
            $SwitchMap$com$azure$core$util$logging$LogLevel = iArr;
            try {
                iArr[LogLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$azure$core$util$logging$LogLevel[LogLevel.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$azure$core$util$logging$LogLevel[LogLevel.INFORMATIONAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$azure$core$util$logging$LogLevel[LogLevel.VERBOSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static LoggingEventBuilder getLogBuilder(LogLevel logLevel, ClientLogger clientLogger) {
        int i = AnonymousClass1.$SwitchMap$com$azure$core$util$logging$LogLevel[logLevel.ordinal()];
        if (i == 1) {
            return clientLogger.atError();
        }
        if (i == 2) {
            return clientLogger.atWarning();
        }
        if (i == 3) {
            return clientLogger.atInfo();
        }
        return clientLogger.atVerbose();
    }
}
