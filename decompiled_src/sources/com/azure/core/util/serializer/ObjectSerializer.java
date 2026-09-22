package com.azure.core.util.serializer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface ObjectSerializer {
    <T> T deserialize(InputStream inputStream, TypeReference<T> typeReference);

    <T> Mono<T> deserializeAsync(InputStream inputStream, TypeReference<T> typeReference);

    void serialize(OutputStream outputStream, Object obj);

    Mono<Void> serializeAsync(OutputStream outputStream, Object obj);

    default <T> T deserializeFromBytes(byte[] bArr, TypeReference<T> typeReference) {
        if (bArr == null) {
            return (T) deserialize(new ByteArrayInputStream(new byte[0]), typeReference);
        }
        return (T) deserialize(new ByteArrayInputStream(bArr), typeReference);
    }

    default <T> Mono<T> deserializeFromBytesAsync(final byte[] bArr, final TypeReference<T> typeReference) {
        return Mono.fromCallable(new Callable() { // from class: com.azure.core.util.serializer.ObjectSerializer$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.deserializeFromBytes(bArr, typeReference);
            }
        });
    }

    default byte[] serializeToBytes(Object obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        serialize(byteArrayOutputStream, obj);
        return byteArrayOutputStream.toByteArray();
    }

    default Mono<byte[]> serializeToBytesAsync(final Object obj) {
        return Mono.fromCallable(new Callable() { // from class: com.azure.core.util.serializer.ObjectSerializer$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.serializeToBytes(obj);
            }
        });
    }
}
