package com.azure.core.util;

import java.nio.ByteBuffer;
import java.util.function.Function;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class BufferedFluxByteBuffer extends Flux<ByteBuffer> {
    private final Flux<ByteBuffer> flux;

    BufferedFluxByteBuffer(Flux<ByteBuffer> flux) {
        this.flux = flux.map(new Function() { // from class: com.azure.core.util.BufferedFluxByteBuffer$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return BufferedFluxByteBuffer.lambda$new$0((ByteBuffer) obj);
            }
        }).cache().map(new Function() { // from class: com.azure.core.util.BufferedFluxByteBuffer$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ByteBuffer) obj).duplicate();
            }
        });
    }

    static /* synthetic */ ByteBuffer lambda$new$0(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining());
        byteBufferAllocate.put(byteBuffer);
        byteBufferAllocate.rewind();
        return byteBufferAllocate;
    }

    public void subscribe(CoreSubscriber<? super ByteBuffer> coreSubscriber) {
        this.flux.subscribe(coreSubscriber);
    }
}
