package com.azure.core.http.rest;

import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.HttpResponse;
import com.azure.core.util.FluxUtil;
import com.azure.core.util.logging.ClientLogger;
import java.io.Closeable;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class StreamResponse extends SimpleResponse<Flux<ByteBuffer>> implements Closeable {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) StreamResponse.class);
    private volatile boolean consumed;
    private final HttpResponse response;

    /* JADX INFO: renamed from: lambda$getValue$0$com-azure-core-http-rest-StreamResponse, reason: not valid java name */
    /* synthetic */ StreamResponse m1146lambda$getValue$0$comazurecorehttprestStreamResponse() throws Exception {
        return this;
    }

    @Deprecated
    public StreamResponse(HttpRequest httpRequest, int i, HttpHeaders httpHeaders, Flux<ByteBuffer> flux) {
        super(httpRequest, i, httpHeaders, flux);
        this.response = null;
    }

    public StreamResponse(HttpResponse httpResponse) {
        super(httpResponse.getRequest(), httpResponse.getStatusCode(), httpResponse.getHeaders(), null);
        this.response = httpResponse;
    }

    @Override // com.azure.core.http.rest.SimpleResponse, com.azure.core.http.rest.Response
    public Flux<ByteBuffer> getValue() {
        if (this.response == null) {
            return Flux.using(new Callable() { // from class: com.azure.core.http.rest.StreamResponse$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f$0.m1146lambda$getValue$0$comazurecorehttprestStreamResponse();
                }
            }, new Function() { // from class: com.azure.core.http.rest.StreamResponse$$ExternalSyntheticLambda1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.f$0.m1147lambda$getValue$1$comazurecorehttprestStreamResponse((StreamResponse) obj);
                }
            }, new Consumer() { // from class: com.azure.core.http.rest.StreamResponse$$ExternalSyntheticLambda2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((StreamResponse) obj).consumed = true;
                }
            });
        }
        return Flux.using(new Callable() { // from class: com.azure.core.http.rest.StreamResponse$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m1148lambda$getValue$3$comazurecorehttprestStreamResponse();
            }
        }, new Function() { // from class: com.azure.core.http.rest.StreamResponse$$ExternalSyntheticLambda4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((HttpResponse) obj).getBody();
            }
        }, new Consumer() { // from class: com.azure.core.http.rest.StreamResponse$$ExternalSyntheticLambda5
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.m1149lambda$getValue$4$comazurecorehttprestStreamResponse((HttpResponse) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$getValue$1$com-azure-core-http-rest-StreamResponse, reason: not valid java name */
    /* synthetic */ Publisher m1147lambda$getValue$1$comazurecorehttprestStreamResponse(StreamResponse streamResponse) {
        return (Publisher) super.getValue();
    }

    /* JADX INFO: renamed from: lambda$getValue$3$com-azure-core-http-rest-StreamResponse, reason: not valid java name */
    /* synthetic */ HttpResponse m1148lambda$getValue$3$comazurecorehttprestStreamResponse() throws Exception {
        return this.response;
    }

    /* JADX INFO: renamed from: lambda$getValue$4$com-azure-core-http-rest-StreamResponse, reason: not valid java name */
    /* synthetic */ void m1149lambda$getValue$4$comazurecorehttprestStreamResponse(HttpResponse httpResponse) {
        this.consumed = true;
        httpResponse.close();
    }

    public Mono<Void> writeValueToAsync(AsynchronousByteChannel asynchronousByteChannel) {
        Objects.requireNonNull(asynchronousByteChannel, "'channel' must not be null");
        HttpResponse httpResponse = this.response;
        if (httpResponse == null) {
            return FluxUtil.writeToAsynchronousByteChannel(getValue(), asynchronousByteChannel);
        }
        return httpResponse.writeBodyToAsync(asynchronousByteChannel);
    }

    public void writeValueTo(WritableByteChannel writableByteChannel) {
        Objects.requireNonNull(writableByteChannel, "'channel' must not be null");
        HttpResponse httpResponse = this.response;
        if (httpResponse == null) {
            FluxUtil.writeToWritableByteChannel(getValue(), writableByteChannel).block();
            return;
        }
        try {
            httpResponse.writeBodyTo(writableByteChannel);
        } catch (IOException e) {
            throw LOGGER.logExceptionAsError(new UncheckedIOException(e));
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.consumed) {
            return;
        }
        this.consumed = true;
        HttpResponse httpResponse = this.response;
        if (httpResponse == null) {
            getValue().subscribe().dispose();
        } else {
            httpResponse.close();
        }
    }
}
