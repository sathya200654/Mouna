package com.azure.core.util.serializer;

import java.io.InputStream;
import java.io.OutputStream;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface JsonSerializer extends ObjectSerializer {
    @Override // com.azure.core.util.serializer.ObjectSerializer
    <T> T deserialize(InputStream inputStream, TypeReference<T> typeReference);

    @Override // com.azure.core.util.serializer.ObjectSerializer
    <T> Mono<T> deserializeAsync(InputStream inputStream, TypeReference<T> typeReference);

    @Override // com.azure.core.util.serializer.ObjectSerializer
    void serialize(OutputStream outputStream, Object obj);

    @Override // com.azure.core.util.serializer.ObjectSerializer
    Mono<Void> serializeAsync(OutputStream outputStream, Object obj);

    @Override // com.azure.core.util.serializer.ObjectSerializer
    default <T> T deserializeFromBytes(byte[] bArr, TypeReference<T> typeReference) {
        return (T) super.deserializeFromBytes(bArr, typeReference);
    }

    @Override // com.azure.core.util.serializer.ObjectSerializer
    default <T> Mono<T> deserializeFromBytesAsync(byte[] bArr, TypeReference<T> typeReference) {
        return super.deserializeFromBytesAsync(bArr, typeReference);
    }

    @Override // com.azure.core.util.serializer.ObjectSerializer
    default byte[] serializeToBytes(Object obj) {
        return super.serializeToBytes(obj);
    }

    @Override // com.azure.core.util.serializer.ObjectSerializer
    default Mono<byte[]> serializeToBytesAsync(Object obj) {
        return super.serializeToBytesAsync(obj);
    }
}
