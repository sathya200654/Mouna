package com.azure.core.implementation.http.rest;

import com.azure.core.annotation.ResumeOperation;
import com.azure.core.exception.UnexpectedLengthException;
import com.azure.core.http.HttpHeaderName;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.HttpPipelineBuilder;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.policy.CookiePolicy;
import com.azure.core.http.policy.HttpPipelinePolicy;
import com.azure.core.http.policy.RetryPolicy;
import com.azure.core.http.policy.UserAgentPolicy;
import com.azure.core.http.rest.RequestOptions;
import com.azure.core.implementation.util.BinaryDataContent;
import com.azure.core.implementation.util.BinaryDataHelper;
import com.azure.core.implementation.util.FluxByteBufferContent;
import com.azure.core.implementation.util.InputStreamContent;
import com.azure.core.util.BinaryData;
import com.azure.core.util.Context;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.serializer.JacksonAdapter;
import com.azure.core.util.serializer.SerializerAdapter;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SynchronousSink;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class RestProxyUtils {
    public static final String BODY_TOO_LARGE = "Request body emitted %d bytes, more than the expected %d bytes.";
    public static final String BODY_TOO_SMALL = "Request body emitted %d bytes, less than the expected %d bytes.";
    private static final ByteBuffer VALIDATION_BUFFER = ByteBuffer.allocate(0);
    public static final ClientLogger LOGGER = new ClientLogger((Class<?>) RestProxyUtils.class);

    private RestProxyUtils() {
    }

    public static Mono<HttpRequest> validateLengthAsync(final HttpRequest httpRequest) {
        final BinaryData bodyAsBinaryData = httpRequest.getBodyAsBinaryData();
        if (bodyAsBinaryData == null) {
            return Mono.just(httpRequest);
        }
        return Mono.fromCallable(new Callable() { // from class: com.azure.core.implementation.http.rest.RestProxyUtils$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return RestProxyUtils.lambda$validateLengthAsync$0(bodyAsBinaryData, httpRequest);
            }
        });
    }

    static /* synthetic */ HttpRequest lambda$validateLengthAsync$0(BinaryData binaryData, HttpRequest httpRequest) throws Exception {
        BinaryDataContent content = BinaryDataHelper.getContent(binaryData);
        long j = Long.parseLong(httpRequest.getHeaders().getValue(HttpHeaderName.CONTENT_LENGTH));
        if (content instanceof InputStreamContent) {
            httpRequest.setBody(BinaryData.fromStream(new LengthValidatingInputStream(content.toStream(), j), Long.valueOf(j)));
            return httpRequest;
        }
        if (content instanceof FluxByteBufferContent) {
            httpRequest.setBody(validateFluxLength(binaryData.toFluxByteBuffer(), j));
            return httpRequest;
        }
        Long length = binaryData.getLength();
        if (length == null) {
            httpRequest.setBody(validateFluxLength(binaryData.toFluxByteBuffer(), j));
            return httpRequest;
        }
        if (length.longValue() < j) {
            throw new UnexpectedLengthException(String.format(BODY_TOO_SMALL, length, Long.valueOf(j)), length.longValue(), j);
        }
        if (length.longValue() <= j) {
            return httpRequest;
        }
        throw new UnexpectedLengthException(String.format(BODY_TOO_LARGE, length, Long.valueOf(j)), length.longValue(), j);
    }

    private static Flux<ByteBuffer> validateFluxLength(final Flux<ByteBuffer> flux, final long j) {
        if (flux == null) {
            return Flux.empty();
        }
        return Flux.defer(new Supplier() { // from class: com.azure.core.implementation.http.rest.RestProxyUtils$$ExternalSyntheticLambda2
            @Override // java.util.function.Supplier
            public final Object get() {
                return RestProxyUtils.lambda$validateFluxLength$2(flux, j);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Publisher lambda$validateFluxLength$2(Flux flux, final long j) {
        final long[] jArr = new long[1];
        return Flux.concat(new Publisher[]{flux, Flux.just(VALIDATION_BUFFER)}).handle(new BiConsumer() { // from class: com.azure.core.implementation.http.rest.RestProxyUtils$$ExternalSyntheticLambda0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                RestProxyUtils.lambda$validateFluxLength$1(j, jArr, (ByteBuffer) obj, (SynchronousSink) obj2);
            }
        });
    }

    static /* synthetic */ void lambda$validateFluxLength$1(long j, long[] jArr, ByteBuffer byteBuffer, SynchronousSink synchronousSink) {
        if (byteBuffer == null) {
            return;
        }
        if (byteBuffer == VALIDATION_BUFFER) {
            if (j != jArr[0]) {
                synchronousSink.error(new UnexpectedLengthException(String.format(BODY_TOO_SMALL, Long.valueOf(jArr[0]), Long.valueOf(j)), jArr[0], j));
                return;
            } else {
                synchronousSink.complete();
                return;
            }
        }
        long jRemaining = jArr[0] + ((long) byteBuffer.remaining());
        jArr[0] = jRemaining;
        if (jRemaining > j) {
            synchronousSink.error(new UnexpectedLengthException(String.format(BODY_TOO_LARGE, Long.valueOf(jArr[0]), Long.valueOf(j)), jArr[0], j));
        } else {
            synchronousSink.next(byteBuffer);
        }
    }

    public static BinaryData validateLengthSync(HttpRequest httpRequest) {
        BinaryData bodyAsBinaryData = httpRequest.getBodyAsBinaryData();
        if (bodyAsBinaryData == null) {
            return null;
        }
        long j = Long.parseLong(httpRequest.getHeaders().getValue(HttpHeaderName.CONTENT_LENGTH));
        Long length = bodyAsBinaryData.getLength();
        BinaryDataContent content = BinaryDataHelper.getContent(bodyAsBinaryData);
        if (content instanceof FluxByteBufferContent) {
            throw new IllegalStateException("Flux Byte Buffer is not supported in Synchronous Rest Proxy.");
        }
        if (content instanceof InputStreamContent) {
            return BinaryData.fromStream(new LengthValidatingInputStream(((InputStreamContent) content).toStream(), j), Long.valueOf(j));
        }
        if (length == null) {
            byte[] bytes = content.toBytes();
            validateLength(Long.valueOf(Integer.valueOf(bytes.length).longValue()).longValue(), j);
            return BinaryData.fromBytes(bytes);
        }
        validateLength(length.longValue(), j);
        return bodyAsBinaryData;
    }

    private static void validateLength(long j, long j2) {
        if (j > j2) {
            throw new UnexpectedLengthException(String.format(BODY_TOO_LARGE, Long.valueOf(j), Long.valueOf(j2)), j, j2);
        }
        if (j < j2) {
            throw new UnexpectedLengthException(String.format(BODY_TOO_SMALL, Long.valueOf(j), Long.valueOf(j2)), j, j2);
        }
    }

    public static Context mergeRequestOptionsContext(Context context, RequestOptions requestOptions) {
        Context context2;
        return (requestOptions == null || (context2 = requestOptions.getContext()) == null || context2 == Context.NONE) ? context : CoreUtils.mergeContexts(context, context2);
    }

    public static void validateResumeOperationIsNotPresent(Method method) {
        if (method.isAnnotationPresent(ResumeOperation.class)) {
            throw LOGGER.logExceptionAsError(new IllegalStateException("'ResumeOperation' isn't supported."));
        }
    }

    public static SerializerAdapter createDefaultSerializer() {
        return JacksonAdapter.createDefaultSerializerAdapter();
    }

    public static HttpPipeline createDefaultPipeline() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new UserAgentPolicy());
        arrayList.add(new RetryPolicy());
        arrayList.add(new CookiePolicy());
        return new HttpPipelineBuilder().policies((HttpPipelinePolicy[]) arrayList.toArray(new HttpPipelinePolicy[0])).build();
    }
}
