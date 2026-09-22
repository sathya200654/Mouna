package com.azure.core.implementation.http.policy;

import androidx.camera.core.ImageAnalysis$;
import com.azure.core.http.HttpHeaderName;
import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpPipelineCallContext;
import com.azure.core.http.HttpPipelineNextPolicy;
import com.azure.core.http.HttpPipelineNextSyncPolicy;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.HttpResponse;
import com.azure.core.http.policy.HttpLoggingPolicy;
import com.azure.core.http.policy.HttpPipelinePolicy;
import com.azure.core.implementation.http.UrlSanitizer;
import com.azure.core.implementation.logging.LoggingKeys;
import com.azure.core.util.BinaryData;
import com.azure.core.util.Context;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.tracing.SpanKind;
import com.azure.core.util.tracing.StartSpanOptions;
import com.azure.core.util.tracing.Tracer;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class InstrumentationPolicy implements HttpPipelinePolicy {
    private static final String CLIENT_REQUEST_ID_ATTRIBUTE = "requestId";
    private static final String HTTP_METHOD = "http.method";
    private static final String HTTP_RESEND_COUNT = "http.request.resend_count";
    private static final String HTTP_STATUS_CODE = "http.status_code";
    private static final String HTTP_URL = "http.url";
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) InstrumentationPolicy.class);
    private static final String OTHER_ERROR_TYPE = "_OTHER";
    private static final String SERVER_ADDRESS = "server.address";
    private static final String SERVER_PORT = "server.port";
    private static final String SERVICE_REQUEST_ID_ATTRIBUTE = "serviceRequestId";
    private Tracer tracer;
    private UrlSanitizer urlSanitizer;

    static /* synthetic */ void lambda$process$5(Context context) {
    }

    public void initialize(Tracer tracer, UrlSanitizer urlSanitizer) {
        this.tracer = tracer;
        this.urlSanitizer = urlSanitizer;
    }

    @Override // com.azure.core.http.policy.HttpPipelinePolicy
    public Mono<HttpResponse> process(final HttpPipelineCallContext httpPipelineCallContext, final HttpPipelineNextPolicy httpPipelineNextPolicy) {
        if (!isTracingEnabled(httpPipelineCallContext)) {
            return httpPipelineNextPolicy.process();
        }
        return Mono.using(new Callable() { // from class: com.azure.core.implementation.http.policy.InstrumentationPolicy$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m1167xe05ed2ed(httpPipelineCallContext);
            }
        }, new Function() { // from class: com.azure.core.implementation.http.policy.InstrumentationPolicy$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1171x175cb2f1(httpPipelineNextPolicy, (Context) obj);
            }
        }, new Consumer() { // from class: com.azure.core.implementation.http.policy.InstrumentationPolicy$$ExternalSyntheticLambda2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                InstrumentationPolicy.lambda$process$5((Context) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$process$4$com-azure-core-implementation-http-policy-InstrumentationPolicy, reason: not valid java name */
    /* synthetic */ Mono m1171x175cb2f1(HttpPipelineNextPolicy httpPipelineNextPolicy, final Context context) {
        return httpPipelineNextPolicy.process().map(new Function() { // from class: com.azure.core.implementation.http.policy.InstrumentationPolicy$$ExternalSyntheticLambda4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1168x2e1e4aee(context, (HttpResponse) obj);
            }
        }).doOnCancel(new Runnable() { // from class: com.azure.core.implementation.http.policy.InstrumentationPolicy$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1169x7bddc2ef(context);
            }
        }).doOnError(new Consumer() { // from class: com.azure.core.implementation.http.policy.InstrumentationPolicy$$ExternalSyntheticLambda6
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.m1170xc99d3af0(context, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$process$1$com-azure-core-implementation-http-policy-InstrumentationPolicy, reason: not valid java name */
    /* synthetic */ HttpResponse m1168x2e1e4aee(Context context, HttpResponse httpResponse) {
        onResponseCode(httpResponse, context);
        return TraceableResponse.create(httpResponse, this.tracer, context);
    }

    /* JADX INFO: renamed from: lambda$process$2$com-azure-core-implementation-http-policy-InstrumentationPolicy, reason: not valid java name */
    /* synthetic */ void m1169x7bddc2ef(Context context) {
        this.tracer.end(LoggingKeys.CANCELLED_ERROR_TYPE, (Throwable) null, context);
    }

    /* JADX INFO: renamed from: lambda$process$3$com-azure-core-implementation-http-policy-InstrumentationPolicy, reason: not valid java name */
    /* synthetic */ void m1170xc99d3af0(Context context, Throwable th) {
        this.tracer.end((String) null, th, context);
    }

    @Override // com.azure.core.http.policy.HttpPipelinePolicy
    public HttpResponse processSync(HttpPipelineCallContext httpPipelineCallContext, HttpPipelineNextSyncPolicy httpPipelineNextSyncPolicy) {
        if (!isTracingEnabled(httpPipelineCallContext)) {
            return httpPipelineNextSyncPolicy.processSync();
        }
        Context contextM1167xe05ed2ed = m1167xe05ed2ed(httpPipelineCallContext);
        try {
            AutoCloseable autoCloseableMakeSpanCurrent = this.tracer.makeSpanCurrent(contextM1167xe05ed2ed);
            try {
                HttpResponse httpResponseProcessSync = httpPipelineNextSyncPolicy.processSync();
                onResponseCode(httpResponseProcessSync, contextM1167xe05ed2ed);
                HttpResponse httpResponseCreate = TraceableResponse.create(httpResponseProcessSync, this.tracer, contextM1167xe05ed2ed);
                if (autoCloseableMakeSpanCurrent != null) {
                    ImageAnalysis$.ExternalSyntheticBackport0.m(autoCloseableMakeSpanCurrent);
                }
                return httpResponseCreate;
            } catch (Throwable th) {
                if (autoCloseableMakeSpanCurrent != null) {
                    try {
                        ImageAnalysis$.ExternalSyntheticBackport0.m(autoCloseableMakeSpanCurrent);
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (RuntimeException e) {
            this.tracer.end((String) null, e, contextM1167xe05ed2ed);
            throw e;
        } catch (Exception e2) {
            this.tracer.end((String) null, e2, contextM1167xe05ed2ed);
            throw LOGGER.logExceptionAsWarning(new RuntimeException(e2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: startSpan, reason: merged with bridge method [inline-methods] */
    public Context m1167xe05ed2ed(HttpPipelineCallContext httpPipelineCallContext) {
        final HttpRequest httpRequest = httpPipelineCallContext.getHttpRequest();
        String string = httpRequest.getHttpMethod().toString();
        Context contextStart = this.tracer.start(string, new StartSpanOptions(SpanKind.CLIENT).setAttribute(HTTP_METHOD, string).setAttribute(HTTP_URL, this.urlSanitizer.getRedactedUrl(httpRequest.getUrl())).setAttribute(SERVER_ADDRESS, httpRequest.getUrl().getHost()).setAttribute(SERVER_PORT, Integer.valueOf(getPort(httpRequest.getUrl()))), httpPipelineCallContext.getContext());
        addPostSamplingAttributes(contextStart, httpRequest);
        this.tracer.injectContext(new BiConsumer() { // from class: com.azure.core.implementation.http.policy.InstrumentationPolicy$$ExternalSyntheticLambda3
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                httpRequest.getHeaders().set((String) obj, (String) obj2);
            }
        }, contextStart);
        return contextStart;
    }

    private static int getPort(URL url) {
        int port = url.getPort();
        return port == -1 ? url.getDefaultPort() : port;
    }

    private void addPostSamplingAttributes(Context context, HttpRequest httpRequest) {
        Object objOrElse = context.getData(HttpLoggingPolicy.RETRY_COUNT_CONTEXT).orElse(null);
        if (objOrElse instanceof Integer) {
            Integer num = (Integer) objOrElse;
            if (num.intValue() > 0) {
                this.tracer.setAttribute(HTTP_RESEND_COUNT, num.longValue(), context);
            }
        }
        String value = httpRequest.getHeaders().getValue(HttpHeaderName.X_MS_CLIENT_REQUEST_ID);
        if (CoreUtils.isNullOrEmpty(value)) {
            return;
        }
        this.tracer.setAttribute(CLIENT_REQUEST_ID_ATTRIBUTE, value, context);
    }

    private void onResponseCode(HttpResponse httpResponse, Context context) {
        if (httpResponse == null || !this.tracer.isRecording(context)) {
            return;
        }
        this.tracer.setAttribute(HTTP_STATUS_CODE, httpResponse.getStatusCode(), context);
        String headerValue = httpResponse.getHeaderValue(HttpHeaderName.X_MS_REQUEST_ID);
        if (headerValue != null) {
            this.tracer.setAttribute(SERVICE_REQUEST_ID_ATTRIBUTE, headerValue, context);
        }
    }

    private boolean isTracingEnabled(HttpPipelineCallContext httpPipelineCallContext) {
        Tracer tracer = this.tracer;
        return (tracer == null || !tracer.isEnabled() || ((Boolean) httpPipelineCallContext.getData(Tracer.DISABLE_TRACING_KEY).orElse(false)).booleanValue()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class TraceableResponse extends HttpResponse {
        private static final AtomicIntegerFieldUpdater<TraceableResponse> ENDED_UPDATER = AtomicIntegerFieldUpdater.newUpdater(TraceableResponse.class, "ended");
        private volatile int ended;
        private final HttpResponse response;
        private final Context span;
        private final Tracer tracer;

        private TraceableResponse(HttpResponse httpResponse, Tracer tracer, Context context) {
            super(httpResponse.getRequest());
            this.ended = 0;
            this.response = httpResponse;
            this.span = context;
            this.tracer = tracer;
        }

        public static HttpResponse create(HttpResponse httpResponse, Tracer tracer, Context context) {
            if (tracer.isRecording(context)) {
                return new TraceableResponse(httpResponse, tracer, context);
            }
            tracer.end((String) null, (Throwable) null, context);
            return httpResponse;
        }

        @Override // com.azure.core.http.HttpResponse
        public int getStatusCode() {
            return this.response.getStatusCode();
        }

        @Override // com.azure.core.http.HttpResponse
        @Deprecated
        public String getHeaderValue(String str) {
            return this.response.getHeaderValue(str);
        }

        @Override // com.azure.core.http.HttpResponse
        public String getHeaderValue(HttpHeaderName httpHeaderName) {
            return this.response.getHeaderValue(httpHeaderName);
        }

        @Override // com.azure.core.http.HttpResponse
        public HttpHeaders getHeaders() {
            return this.response.getHeaders();
        }

        @Override // com.azure.core.http.HttpResponse
        public Flux<ByteBuffer> getBody() {
            return Flux.using(new Callable() { // from class: com.azure.core.implementation.http.policy.InstrumentationPolicy$TraceableResponse$$ExternalSyntheticLambda3
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f$0.m1177x2107092();
                }
            }, new Function() { // from class: com.azure.core.implementation.http.policy.InstrumentationPolicy$TraceableResponse$$ExternalSyntheticLambda4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.f$0.m1180xf883fdd5((Context) obj);
                }
            }, new Consumer() { // from class: com.azure.core.implementation.http.policy.InstrumentationPolicy$TraceableResponse$$ExternalSyntheticLambda5
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f$0.m1181x9fffd796((Context) obj);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$getBody$0$com-azure-core-implementation-http-policy-InstrumentationPolicy$TraceableResponse, reason: not valid java name */
        /* synthetic */ Context m1177x2107092() throws Exception {
            return this.span;
        }

        /* JADX INFO: renamed from: lambda$getBody$3$com-azure-core-implementation-http-policy-InstrumentationPolicy$TraceableResponse, reason: not valid java name */
        /* synthetic */ Publisher m1180xf883fdd5(Context context) {
            return this.response.getBody().doOnError(new Consumer() { // from class: com.azure.core.implementation.http.policy.InstrumentationPolicy$TraceableResponse$$ExternalSyntheticLambda6
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f$0.m1178xa98c4a53((Throwable) obj);
                }
            }).doOnCancel(new Runnable() { // from class: com.azure.core.implementation.http.policy.InstrumentationPolicy$TraceableResponse$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m1179x51082414();
                }
            });
        }

        /* JADX INFO: renamed from: lambda$getBody$1$com-azure-core-implementation-http-policy-InstrumentationPolicy$TraceableResponse, reason: not valid java name */
        /* synthetic */ void m1178xa98c4a53(Throwable th) {
            onError(null, th);
        }

        /* JADX INFO: renamed from: lambda$getBody$2$com-azure-core-implementation-http-policy-InstrumentationPolicy$TraceableResponse, reason: not valid java name */
        /* synthetic */ void m1179x51082414() {
            onError(LoggingKeys.CANCELLED_ERROR_TYPE, null);
        }

        /* JADX INFO: renamed from: lambda$getBody$4$com-azure-core-implementation-http-policy-InstrumentationPolicy$TraceableResponse, reason: not valid java name */
        /* synthetic */ void m1181x9fffd796(Context context) {
            endNoError();
        }

        @Override // com.azure.core.http.HttpResponse
        public Mono<byte[]> getBodyAsByteArray() {
            return endSpanWhen(this.response.getBodyAsByteArray());
        }

        @Override // com.azure.core.http.HttpResponse
        public Mono<String> getBodyAsString() {
            return endSpanWhen(this.response.getBodyAsString());
        }

        @Override // com.azure.core.http.HttpResponse
        public BinaryData getBodyAsBinaryData() {
            try {
                try {
                    BinaryData bodyAsBinaryData = this.response.getBodyAsBinaryData();
                    endNoError();
                    return bodyAsBinaryData;
                } catch (Exception e) {
                    onError(null, e);
                    throw e;
                }
            } catch (Throwable th) {
                endNoError();
                throw th;
            }
        }

        @Override // com.azure.core.http.HttpResponse
        public Mono<String> getBodyAsString(Charset charset) {
            return endSpanWhen(this.response.getBodyAsString(charset));
        }

        @Override // com.azure.core.http.HttpResponse
        public Mono<InputStream> getBodyAsInputStream() {
            return endSpanWhen(this.response.getBodyAsInputStream());
        }

        @Override // com.azure.core.http.HttpResponse, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.response.close();
            endNoError();
        }

        private <T> Mono<T> endSpanWhen(final Mono<T> mono) {
            return Mono.using(new Callable() { // from class: com.azure.core.implementation.http.policy.InstrumentationPolicy$TraceableResponse$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f$0.m1172xd06d87de();
                }
            }, new Function() { // from class: com.azure.core.implementation.http.policy.InstrumentationPolicy$TraceableResponse$$ExternalSyntheticLambda1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.f$0.m1175xc6e11521(mono, (Context) obj);
                }
            }, new Consumer() { // from class: com.azure.core.implementation.http.policy.InstrumentationPolicy$TraceableResponse$$ExternalSyntheticLambda2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f$0.m1176x6e5ceee2((Context) obj);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$endSpanWhen$5$com-azure-core-implementation-http-policy-InstrumentationPolicy$TraceableResponse, reason: not valid java name */
        /* synthetic */ Context m1172xd06d87de() throws Exception {
            return this.span;
        }

        /* JADX INFO: renamed from: lambda$endSpanWhen$6$com-azure-core-implementation-http-policy-InstrumentationPolicy$TraceableResponse, reason: not valid java name */
        /* synthetic */ void m1173x77e9619f(Throwable th) {
            onError(null, th);
        }

        /* JADX INFO: renamed from: lambda$endSpanWhen$7$com-azure-core-implementation-http-policy-InstrumentationPolicy$TraceableResponse, reason: not valid java name */
        /* synthetic */ void m1174x1f653b60() {
            onError(LoggingKeys.CANCELLED_ERROR_TYPE, null);
        }

        /* JADX INFO: renamed from: lambda$endSpanWhen$8$com-azure-core-implementation-http-policy-InstrumentationPolicy$TraceableResponse, reason: not valid java name */
        /* synthetic */ Mono m1175xc6e11521(Mono mono, Context context) {
            return mono.doOnError(new Consumer() { // from class: com.azure.core.implementation.http.policy.InstrumentationPolicy$TraceableResponse$$ExternalSyntheticLambda8
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f$0.m1173x77e9619f((Throwable) obj);
                }
            }).doOnCancel(new Runnable() { // from class: com.azure.core.implementation.http.policy.InstrumentationPolicy$TraceableResponse$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m1174x1f653b60();
                }
            });
        }

        /* JADX INFO: renamed from: lambda$endSpanWhen$9$com-azure-core-implementation-http-policy-InstrumentationPolicy$TraceableResponse, reason: not valid java name */
        /* synthetic */ void m1176x6e5ceee2(Context context) {
            endNoError();
        }

        private void onError(String str, Throwable th) {
            if (ENDED_UPDATER.compareAndSet(this, 0, 1)) {
                this.tracer.end(str, th, this.span);
            }
        }

        private void endNoError() {
            String strValueOf;
            if (ENDED_UPDATER.compareAndSet(this, 0, 1)) {
                HttpResponse httpResponse = this.response;
                if (httpResponse == null) {
                    strValueOf = InstrumentationPolicy.OTHER_ERROR_TYPE;
                } else {
                    strValueOf = httpResponse.getStatusCode() >= 400 ? String.valueOf(this.response.getStatusCode()) : null;
                }
                this.tracer.end(strValueOf, (Throwable) null, this.span);
            }
        }
    }
}
