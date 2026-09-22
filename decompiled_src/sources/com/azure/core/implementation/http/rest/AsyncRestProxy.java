package com.azure.core.implementation.http.rest;

import androidx.camera.core.ImageAnalysis$;
import com.azure.core.exception.HttpResponseException;
import com.azure.core.http.HttpHeaderName;
import com.azure.core.http.HttpMethod;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.HttpResponse;
import com.azure.core.http.rest.RequestOptions;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.StreamResponse;
import com.azure.core.implementation.ReflectionSerializable;
import com.azure.core.implementation.TypeUtil;
import com.azure.core.implementation.logging.LoggingKeys;
import com.azure.core.implementation.serializer.HttpResponseDecoder;
import com.azure.core.util.Base64Url;
import com.azure.core.util.BinaryData;
import com.azure.core.util.Context;
import com.azure.core.util.FluxUtil;
import com.azure.core.util.serializer.SerializerAdapter;
import com.azure.core.util.serializer.SerializerEncoding;
import com.azure.core.util.tracing.Tracer;
import com.azure.json.JsonSerializable;
import com.azure.xml.XmlSerializable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.util.EnumSet;
import java.util.concurrent.Callable;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Signal;
import reactor.core.publisher.SynchronousSink;
import reactor.core.scheduler.Schedulers;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class AsyncRestProxy extends RestProxyBase {
    private static final String TEXT_EVENT_STREAM = "text/event-stream";

    public AsyncRestProxy(HttpPipeline httpPipeline, SerializerAdapter serializerAdapter, SwaggerInterfaceParser swaggerInterfaceParser) {
        super(httpPipeline, serializerAdapter, swaggerInterfaceParser);
    }

    Mono<HttpResponse> send(HttpRequest httpRequest, Context context) {
        return this.httpPipeline.send(httpRequest, context);
    }

    @Override // com.azure.core.implementation.http.rest.RestProxyBase
    public Object invoke(Object obj, Method method, RequestOptions requestOptions, EnumSet<ErrorOptions> enumSet, Consumer<HttpRequest> consumer, SwaggerMethodParser swaggerMethodParser, HttpRequest httpRequest, Context context) {
        final Context contextStartTracingSpan = startTracingSpan(swaggerMethodParser, context);
        if (requestOptions != null && consumer != null) {
            consumer.accept(httpRequest);
        }
        return handleRestReturnType(this.decoder.decode(RestProxyUtils.validateLengthAsync(httpRequest).flatMap(new Function() { // from class: com.azure.core.implementation.http.rest.AsyncRestProxy$$ExternalSyntheticLambda3
            @Override // java.util.function.Function
            public final Object apply(Object obj2) {
                return this.f$0.m1189x84f7a2ec(contextStartTracingSpan, (HttpRequest) obj2);
            }
        }), swaggerMethodParser), swaggerMethodParser, swaggerMethodParser.getReturnType(), contextStartTracingSpan, requestOptions, enumSet);
    }

    /* JADX INFO: renamed from: lambda$invoke$0$com-azure-core-implementation-http-rest-AsyncRestProxy, reason: not valid java name */
    /* synthetic */ Mono m1189x84f7a2ec(Context context, HttpRequest httpRequest) {
        try {
            AutoCloseable autoCloseableMakeSpanCurrent = this.tracer.makeSpanCurrent(context);
            try {
                Mono<HttpResponse> monoSend = send(httpRequest, context);
                if (autoCloseableMakeSpanCurrent != null) {
                    ImageAnalysis$.ExternalSyntheticBackport0.m(autoCloseableMakeSpanCurrent);
                }
                return monoSend;
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
        } catch (Throwable th3) {
            return Mono.error(th3);
        }
    }

    private Mono<HttpResponseDecoder.HttpDecodedResponse> ensureExpectedStatus(Mono<HttpResponseDecoder.HttpDecodedResponse> mono, final SwaggerMethodParser swaggerMethodParser, final RequestOptions requestOptions, final EnumSet<ErrorOptions> enumSet) {
        return mono.flatMap(new Function() { // from class: com.azure.core.implementation.http.rest.AsyncRestProxy$$ExternalSyntheticLambda11
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return AsyncRestProxy.lambda$ensureExpectedStatus$3(swaggerMethodParser, requestOptions, enumSet, (HttpResponseDecoder.HttpDecodedResponse) obj);
            }
        });
    }

    static /* synthetic */ Mono lambda$ensureExpectedStatus$3(final SwaggerMethodParser swaggerMethodParser, RequestOptions requestOptions, EnumSet enumSet, final HttpResponseDecoder.HttpDecodedResponse httpDecodedResponse) {
        final int statusCode = httpDecodedResponse.getSourceResponse().getStatusCode();
        if (swaggerMethodParser.isExpectedResponseStatusCode(statusCode) || (requestOptions != null && enumSet.contains(ErrorOptions.NO_THROW))) {
            return Mono.just(httpDecodedResponse);
        }
        return httpDecodedResponse.getSourceResponse().getBodyAsByteArray().map(new Function() { // from class: com.azure.core.implementation.http.rest.AsyncRestProxy$$ExternalSyntheticLambda18
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                SwaggerMethodParser swaggerMethodParser2 = swaggerMethodParser;
                int i = statusCode;
                HttpResponseDecoder.HttpDecodedResponse httpDecodedResponse2 = httpDecodedResponse;
                byte[] bArr = (byte[]) obj;
                return AsyncRestProxy.instantiateUnexpectedException(swaggerMethodParser2.getUnexpectedException(i), httpDecodedResponse2.getSourceResponse(), bArr, httpDecodedResponse2.getDecodedBody(bArr));
            }
        }).switchIfEmpty(Mono.fromSupplier(new Supplier() { // from class: com.azure.core.implementation.http.rest.AsyncRestProxy$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return AsyncRestProxy.instantiateUnexpectedException(swaggerMethodParser.getUnexpectedException(statusCode), httpDecodedResponse.getSourceResponse(), null, null);
            }
        })).flatMap(new Function() { // from class: com.azure.core.implementation.http.rest.AsyncRestProxy$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Mono.error((HttpResponseException) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleRestResponseReturnType, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public Mono<?> m1188xe2e550e9(final HttpResponseDecoder.HttpDecodedResponse httpDecodedResponse, SwaggerMethodParser swaggerMethodParser, final Type type) {
        if (swaggerMethodParser.isStreamResponse()) {
            return Mono.fromSupplier(new Supplier() { // from class: com.azure.core.implementation.http.rest.AsyncRestProxy$$ExternalSyntheticLambda4
                @Override // java.util.function.Supplier
                public final Object get() {
                    return AsyncRestProxy.lambda$handleRestResponseReturnType$4(httpDecodedResponse);
                }
            });
        }
        if (TypeUtil.isTypeOrSubTypeOf(type, Response.class)) {
            Type restResponseBodyType = TypeUtil.getRestResponseBodyType(type);
            if (TypeUtil.isTypeOrSubTypeOf(restResponseBodyType, Void.class)) {
                return httpDecodedResponse.getSourceResponse().getBody().ignoreElements().then(Mono.fromCallable(new Callable() { // from class: com.azure.core.implementation.http.rest.AsyncRestProxy$$ExternalSyntheticLambda5
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.f$0.m1184x8d4fad78(httpDecodedResponse, type);
                    }
                }));
            }
            return handleBodyReturnType(httpDecodedResponse.getSourceResponse(), decodeBytes(httpDecodedResponse), swaggerMethodParser, restResponseBodyType).map(new Function() { // from class: com.azure.core.implementation.http.rest.AsyncRestProxy$$ExternalSyntheticLambda6
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.f$0.m1185x8e860057(httpDecodedResponse, type, obj);
                }
            }).switchIfEmpty(Mono.fromCallable(new Callable() { // from class: com.azure.core.implementation.http.rest.AsyncRestProxy$$ExternalSyntheticLambda7
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f$0.m1186x8fbc5336(httpDecodedResponse, type);
                }
            }));
        }
        return handleBodyReturnType(httpDecodedResponse.getSourceResponse(), decodeBytes(httpDecodedResponse), swaggerMethodParser, type);
    }

    static /* synthetic */ StreamResponse lambda$handleRestResponseReturnType$4(HttpResponseDecoder.HttpDecodedResponse httpDecodedResponse) {
        return new StreamResponse(httpDecodedResponse.getSourceResponse());
    }

    /* JADX INFO: renamed from: lambda$handleRestResponseReturnType$5$com-azure-core-implementation-http-rest-AsyncRestProxy, reason: not valid java name */
    /* synthetic */ Response m1184x8d4fad78(HttpResponseDecoder.HttpDecodedResponse httpDecodedResponse, Type type) throws Exception {
        return createResponse(httpDecodedResponse, type, null);
    }

    /* JADX INFO: renamed from: lambda$handleRestResponseReturnType$6$com-azure-core-implementation-http-rest-AsyncRestProxy, reason: not valid java name */
    /* synthetic */ Response m1185x8e860057(HttpResponseDecoder.HttpDecodedResponse httpDecodedResponse, Type type, Object obj) {
        return createResponse(httpDecodedResponse, type, obj);
    }

    /* JADX INFO: renamed from: lambda$handleRestResponseReturnType$7$com-azure-core-implementation-http-rest-AsyncRestProxy, reason: not valid java name */
    /* synthetic */ Response m1186x8fbc5336(HttpResponseDecoder.HttpDecodedResponse httpDecodedResponse, Type type) throws Exception {
        return createResponse(httpDecodedResponse, type, null);
    }

    private static Function<byte[], Mono<Object>> decodeBytes(final HttpResponseDecoder.HttpDecodedResponse httpDecodedResponse) {
        return new Function() { // from class: com.azure.core.implementation.http.rest.AsyncRestProxy$$ExternalSyntheticLambda2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Mono.fromCallable(new Callable() { // from class: com.azure.core.implementation.http.rest.AsyncRestProxy$$ExternalSyntheticLambda16
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return httpDecodedResponse.getDecodedBody(bArr);
                    }
                }).publishOn(Schedulers.boundedElastic()).handle(new BiConsumer() { // from class: com.azure.core.implementation.http.rest.AsyncRestProxy$$ExternalSyntheticLambda17
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj2, Object obj3) {
                        AsyncRestProxy.lambda$decodeBytes$9(obj2, (SynchronousSink) obj3);
                    }
                });
            }
        };
    }

    static /* synthetic */ void lambda$decodeBytes$9(Object obj, SynchronousSink synchronousSink) {
        if (obj == null) {
            synchronousSink.complete();
        } else {
            synchronousSink.next(obj);
            synchronousSink.complete();
        }
    }

    static Mono<?> handleBodyReturnType(HttpResponse httpResponse, Function<byte[], Mono<Object>> function, SwaggerMethodParser swaggerMethodParser, Type type) {
        int statusCode = httpResponse.getStatusCode();
        HttpMethod httpMethod = swaggerMethodParser.getHttpMethod();
        Type returnValueWireType = swaggerMethodParser.getReturnValueWireType();
        if (httpMethod == HttpMethod.HEAD && (TypeUtil.isTypeOrSubTypeOf(type, Boolean.TYPE) || TypeUtil.isTypeOrSubTypeOf(type, Boolean.class))) {
            return Mono.just(Boolean.valueOf(statusCode / 100 == 2));
        }
        if (TypeUtil.isTypeOrSubTypeOf(type, byte[].class)) {
            Mono bodyAsByteArray = httpResponse.getBodyAsByteArray();
            return returnValueWireType == Base64Url.class ? bodyAsByteArray.mapNotNull(new Function() { // from class: com.azure.core.implementation.http.rest.AsyncRestProxy$$ExternalSyntheticLambda10
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return new Base64Url((byte[]) obj).decodedBytes();
                }
            }) : bodyAsByteArray;
        }
        if (FluxUtil.isFluxByteBuffer(type)) {
            return Mono.just(httpResponse.getBody());
        }
        if (TypeUtil.isTypeOrSubTypeOf(type, BinaryData.class)) {
            String value = httpResponse.getHeaders().getValue(HttpHeaderName.CONTENT_TYPE);
            if (value != null && value.startsWith(TEXT_EVENT_STREAM)) {
                return BinaryData.fromFlux(httpResponse.getBody(), null, false);
            }
            return BinaryData.fromFlux(httpResponse.getBody());
        }
        if (TypeUtil.isTypeOrSubTypeOf(type, InputStream.class)) {
            return httpResponse.getBodyAsInputStream();
        }
        return httpResponse.getBodyAsByteArray().flatMap(function);
    }

    private Object handleRestReturnType(Mono<HttpResponseDecoder.HttpDecodedResponse> mono, final SwaggerMethodParser swaggerMethodParser, final Type type, Context context, RequestOptions requestOptions, EnumSet<ErrorOptions> enumSet) {
        Mono<HttpResponseDecoder.HttpDecodedResponse> monoEndSpanWhenDone = endSpanWhenDone(ensureExpectedStatus(mono, swaggerMethodParser, requestOptions, enumSet), context);
        if (TypeUtil.isTypeOrSubTypeOf(type, Mono.class)) {
            final Type typeArgument = TypeUtil.getTypeArgument(type);
            if (TypeUtil.isTypeOrSubTypeOf(typeArgument, Void.class)) {
                return monoEndSpanWhenDone.doOnNext(new Consumer() { // from class: com.azure.core.implementation.http.rest.AsyncRestProxy$$ExternalSyntheticLambda12
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        ((HttpResponseDecoder.HttpDecodedResponse) obj).close();
                    }
                }).then();
            }
            return monoEndSpanWhenDone.flatMap(new Function() { // from class: com.azure.core.implementation.http.rest.AsyncRestProxy$$ExternalSyntheticLambda13
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.f$0.m1187xe078ab2b(swaggerMethodParser, typeArgument, (HttpResponseDecoder.HttpDecodedResponse) obj);
                }
            });
        }
        if (FluxUtil.isFluxByteBuffer(type)) {
            return monoEndSpanWhenDone.flatMapMany(new Function() { // from class: com.azure.core.implementation.http.rest.AsyncRestProxy$$ExternalSyntheticLambda14
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ((HttpResponseDecoder.HttpDecodedResponse) obj).getSourceResponse().getBody();
                }
            });
        }
        if (TypeUtil.isTypeOrSubTypeOf(type, Void.TYPE) || TypeUtil.isTypeOrSubTypeOf(type, Void.class)) {
            monoEndSpanWhenDone.doOnNext(new Consumer() { // from class: com.azure.core.implementation.http.rest.AsyncRestProxy$$ExternalSyntheticLambda12
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((HttpResponseDecoder.HttpDecodedResponse) obj).close();
                }
            }).block();
            return null;
        }
        return monoEndSpanWhenDone.flatMap(new Function() { // from class: com.azure.core.implementation.http.rest.AsyncRestProxy$$ExternalSyntheticLambda15
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1188xe2e550e9(swaggerMethodParser, type, (HttpResponseDecoder.HttpDecodedResponse) obj);
            }
        }).block();
    }

    private Mono<HttpResponseDecoder.HttpDecodedResponse> endSpanWhenDone(Mono<HttpResponseDecoder.HttpDecodedResponse> mono, final Context context) {
        return isTracingEnabled(context) ? mono.doOnEach(new Consumer() { // from class: com.azure.core.implementation.http.rest.AsyncRestProxy$$ExternalSyntheticLambda8
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.m1182xa43c24e9(context, (Signal) obj);
            }
        }).doOnCancel(new Runnable() { // from class: com.azure.core.implementation.http.rest.AsyncRestProxy$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1183xa57277c8(context);
            }
        }).contextWrite(reactor.util.context.Context.of(Tracer.PARENT_TRACE_CONTEXT_KEY, context)) : mono;
    }

    /* JADX INFO: renamed from: lambda$endSpanWhenDone$15$com-azure-core-implementation-http-rest-AsyncRestProxy, reason: not valid java name */
    /* synthetic */ void m1182xa43c24e9(Context context, Signal signal) {
        if (signal.hasValue()) {
            int statusCode = ((HttpResponseDecoder.HttpDecodedResponse) signal.get()).getSourceResponse().getStatusCode();
            this.tracer.end(statusCode >= 400 ? String.valueOf(statusCode) : null, (Throwable) null, context);
        } else if (signal.isOnError()) {
            this.tracer.end((String) null, signal.getThrowable(), context);
        }
    }

    /* JADX INFO: renamed from: lambda$endSpanWhenDone$16$com-azure-core-implementation-http-rest-AsyncRestProxy, reason: not valid java name */
    /* synthetic */ void m1183xa57277c8(Context context) {
        this.tracer.end(LoggingKeys.CANCELLED_ERROR_TYPE, (Throwable) null, context);
    }

    @Override // com.azure.core.implementation.http.rest.RestProxyBase
    public void updateRequest(RequestDataConfiguration requestDataConfiguration, SerializerAdapter serializerAdapter) throws IOException {
        boolean zIsJson = requestDataConfiguration.isJson();
        HttpRequest httpRequest = requestDataConfiguration.getHttpRequest();
        Object bodyContent = requestDataConfiguration.getBodyContent();
        SwaggerMethodParser methodParser = requestDataConfiguration.getMethodParser();
        if (bodyContent == null) {
            return;
        }
        if (ReflectionSerializable.supportsJsonSerializable(bodyContent.getClass())) {
            httpRequest.setBody(ReflectionSerializable.serializeJsonSerializableToBytes((JsonSerializable) bodyContent));
            return;
        }
        if (ReflectionSerializable.supportsXmlSerializable(bodyContent.getClass())) {
            httpRequest.setBody(ReflectionSerializable.serializeXmlSerializableToBytes((XmlSerializable) bodyContent));
            return;
        }
        if (zIsJson) {
            httpRequest.setBody(serializerAdapter.serializeToBytes(bodyContent, SerializerEncoding.JSON));
            return;
        }
        if (FluxUtil.isFluxByteBuffer(methodParser.getBodyJavaType())) {
            httpRequest.setBody((Flux<ByteBuffer>) bodyContent);
            return;
        }
        if (bodyContent instanceof byte[]) {
            httpRequest.setBody((byte[]) bodyContent);
            return;
        }
        if (bodyContent instanceof String) {
            String str = (String) bodyContent;
            if (str.isEmpty()) {
                return;
            }
            httpRequest.setBody(str);
            return;
        }
        if (bodyContent instanceof ByteBuffer) {
            httpRequest.setBody(BinaryData.fromByteBuffer((ByteBuffer) bodyContent));
        } else {
            httpRequest.setBody(serializerAdapter.serializeToBytes(bodyContent, SerializerEncoding.fromHeaders(httpRequest.getHeaders())));
        }
    }
}
