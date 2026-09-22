package com.azure.core.implementation.http;

import com.azure.core.http.HttpHeaderName;
import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpResponse;
import com.azure.core.implementation.util.IterableOfByteBuffersInputStream;
import com.azure.core.util.BinaryData;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.FluxUtil;
import com.azure.core.util.logging.ClientLogger;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class BufferedHttpResponse extends HttpResponse {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) BufferedHttpResponse.class);
    private final Mono<List<ByteBuffer>> cachedBody;
    private final AtomicLong cachedBodySize;
    private final HttpResponse innerHttpResponse;

    @Override // com.azure.core.http.HttpResponse
    public BufferedHttpResponse buffer() {
        return this;
    }

    public BufferedHttpResponse(HttpResponse httpResponse) {
        super(httpResponse.getRequest());
        this.cachedBodySize = new AtomicLong();
        this.innerHttpResponse = httpResponse;
        this.cachedBody = httpResponse.getBody().map(new Function() { // from class: com.azure.core.implementation.http.BufferedHttpResponse$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1164x3fbb7421((ByteBuffer) obj);
            }
        }).collectList().cache();
    }

    /* JADX INFO: renamed from: lambda$new$0$com-azure-core-implementation-http-BufferedHttpResponse, reason: not valid java name */
    /* synthetic */ ByteBuffer m1164x3fbb7421(ByteBuffer byteBuffer) {
        this.cachedBodySize.addAndGet(byteBuffer.remaining());
        return ByteBuffer.wrap(FluxUtil.byteBufferToArray(byteBuffer));
    }

    @Override // com.azure.core.http.HttpResponse
    public int getStatusCode() {
        return this.innerHttpResponse.getStatusCode();
    }

    @Override // com.azure.core.http.HttpResponse
    @Deprecated
    public String getHeaderValue(String str) {
        return this.innerHttpResponse.getHeaderValue(str);
    }

    @Override // com.azure.core.http.HttpResponse
    public String getHeaderValue(HttpHeaderName httpHeaderName) {
        return this.innerHttpResponse.getHeaderValue(httpHeaderName);
    }

    @Override // com.azure.core.http.HttpResponse
    public HttpHeaders getHeaders() {
        return this.innerHttpResponse.getHeaders();
    }

    @Override // com.azure.core.http.HttpResponse
    public Flux<ByteBuffer> getBody() {
        return this.cachedBody.flatMapMany(new Function() { // from class: com.azure.core.implementation.http.BufferedHttpResponse$$ExternalSyntheticLambda3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Flux.fromIterable((List) obj);
            }
        }).map(new Function() { // from class: com.azure.core.implementation.http.BufferedHttpResponse$$ExternalSyntheticLambda4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ByteBuffer) obj).duplicate();
            }
        });
    }

    @Override // com.azure.core.http.HttpResponse
    public Mono<byte[]> getBodyAsByteArray() {
        if (this.cachedBodySize.get() > 2147483647L) {
            return FluxUtil.monoError(LOGGER, new IllegalStateException("Response with body size " + this.cachedBodySize.get() + " doesn't fit into a byte array."));
        }
        return FluxUtil.collectBytesInByteBufferStream(getBody(), (int) this.cachedBodySize.get());
    }

    @Override // com.azure.core.http.HttpResponse
    public Mono<String> getBodyAsString() {
        if (this.cachedBodySize.get() > 2147483647L) {
            return FluxUtil.monoError(LOGGER, new IllegalStateException("Response with body size " + this.cachedBodySize.get() + " doesn't fit into a String."));
        }
        return getBodyAsByteArray().map(new Function() { // from class: com.azure.core.implementation.http.BufferedHttpResponse$$ExternalSyntheticLambda5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1163x8b42105d((byte[]) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$getBodyAsString$1$com-azure-core-implementation-http-BufferedHttpResponse, reason: not valid java name */
    /* synthetic */ String m1163x8b42105d(byte[] bArr) {
        return CoreUtils.bomAwareToString(bArr, this.innerHttpResponse.getHeaderValue(HttpHeaderName.CONTENT_TYPE));
    }

    @Override // com.azure.core.http.HttpResponse
    public Mono<String> getBodyAsString(final Charset charset) {
        if (this.cachedBodySize.get() > 2147483647L) {
            return FluxUtil.monoError(LOGGER, new IllegalStateException("Response with body size " + this.cachedBodySize.get() + " doesn't fit into a String."));
        }
        return getBodyAsByteArray().map(new Function() { // from class: com.azure.core.implementation.http.BufferedHttpResponse$$ExternalSyntheticLambda2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return BufferedHttpResponse.lambda$getBodyAsString$2(charset, (byte[]) obj);
            }
        });
    }

    static /* synthetic */ String lambda$getBodyAsString$2(Charset charset, byte[] bArr) {
        return new String(bArr, charset);
    }

    @Override // com.azure.core.http.HttpResponse
    public BinaryData getBodyAsBinaryData() {
        return (BinaryData) BinaryData.fromFlux(getBody(), Long.valueOf(this.cachedBodySize.get()), false).block();
    }

    @Override // com.azure.core.http.HttpResponse
    public Mono<InputStream> getBodyAsInputStream() {
        return getBody().collectList().map(new Function() { // from class: com.azure.core.implementation.http.BufferedHttpResponse$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return new IterableOfByteBuffersInputStream((List) obj);
            }
        });
    }

    @Override // com.azure.core.http.HttpResponse
    public Mono<Void> writeBodyToAsync(AsynchronousByteChannel asynchronousByteChannel) {
        return FluxUtil.writeToAsynchronousByteChannel(getBody(), asynchronousByteChannel);
    }

    @Override // com.azure.core.http.HttpResponse
    public void writeBodyTo(WritableByteChannel writableByteChannel) throws IOException {
        FluxUtil.writeToWritableByteChannel(getBody(), writableByteChannel).block();
    }
}
