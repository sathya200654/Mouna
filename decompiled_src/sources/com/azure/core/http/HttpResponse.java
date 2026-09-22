package com.azure.core.http;

import com.azure.core.implementation.http.BufferedHttpResponse;
import com.azure.core.implementation.util.BinaryDataHelper;
import com.azure.core.implementation.util.FluxByteBufferContent;
import com.azure.core.util.BinaryData;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.FluxUtil;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public abstract class HttpResponse implements Closeable {
    private final HttpRequest request;

    public static /* synthetic */ ByteArrayInputStream $r8$lambda$4pBbdZRRCaAPukdCTwk31QKdumw(byte[] bArr) {
        return new ByteArrayInputStream(bArr);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public abstract Flux<ByteBuffer> getBody();

    public abstract Mono<byte[]> getBodyAsByteArray();

    public abstract Mono<String> getBodyAsString();

    public abstract Mono<String> getBodyAsString(Charset charset);

    @Deprecated
    public abstract String getHeaderValue(String str);

    public abstract HttpHeaders getHeaders();

    public abstract int getStatusCode();

    /* JADX INFO: renamed from: lambda$writeBodyTo$0$com-azure-core-http-HttpResponse, reason: not valid java name */
    /* synthetic */ HttpResponse m1127lambda$writeBodyTo$0$comazurecorehttpHttpResponse() throws Exception {
        return this;
    }

    protected HttpResponse(HttpRequest httpRequest) {
        this.request = httpRequest;
    }

    public String getHeaderValue(HttpHeaderName httpHeaderName) {
        return getHeaders().getValue(httpHeaderName);
    }

    public BinaryData getBodyAsBinaryData() {
        String headerValue = getHeaderValue(HttpHeaderName.CONTENT_LENGTH);
        Flux<ByteBuffer> body = getBody();
        if (CoreUtils.isNullOrEmpty(headerValue)) {
            return BinaryDataHelper.createBinaryData(new FluxByteBufferContent(body));
        }
        try {
            return BinaryDataHelper.createBinaryData(new FluxByteBufferContent(body, Long.valueOf(Long.parseLong(headerValue))));
        } catch (NumberFormatException unused) {
            return BinaryDataHelper.createBinaryData(new FluxByteBufferContent(body));
        }
    }

    public Mono<InputStream> getBodyAsInputStream() {
        return getBodyAsByteArray().map(new Function() { // from class: com.azure.core.http.HttpResponse$$ExternalSyntheticLambda3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return HttpResponse.$r8$lambda$4pBbdZRRCaAPukdCTwk31QKdumw((byte[]) obj);
            }
        });
    }

    public final HttpRequest getRequest() {
        return this.request;
    }

    public HttpResponse buffer() {
        return new BufferedHttpResponse(this);
    }

    public Mono<Void> writeBodyToAsync(AsynchronousByteChannel asynchronousByteChannel) {
        Objects.requireNonNull(asynchronousByteChannel, "'channel' must not be null");
        Flux<ByteBuffer> body = getBody();
        if (body != null) {
            return FluxUtil.writeToAsynchronousByteChannel(body, asynchronousByteChannel);
        }
        return Mono.empty();
    }

    public void writeBodyTo(final WritableByteChannel writableByteChannel) throws IOException {
        final Flux<ByteBuffer> body = getBody();
        if (body != null) {
            Mono.using(new Callable() { // from class: com.azure.core.http.HttpResponse$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f$0.m1127lambda$writeBodyTo$0$comazurecorehttpHttpResponse();
                }
            }, new Function() { // from class: com.azure.core.http.HttpResponse$$ExternalSyntheticLambda1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return FluxUtil.writeToWritableByteChannel(body, writableByteChannel);
                }
            }, new Consumer() { // from class: com.azure.core.http.HttpResponse$$ExternalSyntheticLambda2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((HttpResponse) obj).close();
                }
            }).block();
        }
    }
}
