package com.azure.core.implementation.serializer;

import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.serializer.JacksonAdapter;
import com.azure.core.util.serializer.JsonSerializer;
import com.azure.core.util.serializer.SerializerAdapter;
import com.azure.core.util.serializer.SerializerEncoding;
import com.azure.core.util.serializer.TypeReference;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.util.concurrent.Callable;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class DefaultJsonSerializer implements JsonSerializer {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) DefaultJsonSerializer.class);
    private final SerializerAdapter jacksonAdapter = JacksonAdapter.createDefaultSerializerAdapter();

    @Override // com.azure.core.util.serializer.JsonSerializer, com.azure.core.util.serializer.ObjectSerializer
    /* JADX INFO: renamed from: deserializeFromBytes, reason: merged with bridge method [inline-methods] */
    public <T> T m1210xacbeabd2(byte[] bArr, TypeReference<T> typeReference) {
        try {
            return (T) this.jacksonAdapter.deserialize(bArr, typeReference.getJavaType(), SerializerEncoding.JSON);
        } catch (IOException e) {
            throw LOGGER.logExceptionAsError(new UncheckedIOException(e));
        }
    }

    @Override // com.azure.core.util.serializer.JsonSerializer, com.azure.core.util.serializer.ObjectSerializer
    /* JADX INFO: renamed from: deserialize, reason: merged with bridge method [inline-methods] */
    public <T> T m1209xcd757cb4(InputStream inputStream, TypeReference<T> typeReference) {
        try {
            return (T) this.jacksonAdapter.deserialize(inputStream, typeReference.getJavaType(), SerializerEncoding.JSON);
        } catch (IOException e) {
            throw LOGGER.logExceptionAsError(new UncheckedIOException(e));
        }
    }

    @Override // com.azure.core.util.serializer.JsonSerializer, com.azure.core.util.serializer.ObjectSerializer
    public <T> Mono<T> deserializeFromBytesAsync(final byte[] bArr, final TypeReference<T> typeReference) {
        return Mono.fromCallable(new Callable() { // from class: com.azure.core.implementation.serializer.DefaultJsonSerializer$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m1210xacbeabd2(bArr, typeReference);
            }
        });
    }

    @Override // com.azure.core.util.serializer.JsonSerializer, com.azure.core.util.serializer.ObjectSerializer
    public <T> Mono<T> deserializeAsync(final InputStream inputStream, final TypeReference<T> typeReference) {
        return Mono.fromCallable(new Callable() { // from class: com.azure.core.implementation.serializer.DefaultJsonSerializer$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m1209xcd757cb4(inputStream, typeReference);
            }
        });
    }

    @Override // com.azure.core.util.serializer.JsonSerializer, com.azure.core.util.serializer.ObjectSerializer
    /* JADX INFO: renamed from: serializeToBytes, reason: merged with bridge method [inline-methods] */
    public byte[] m1212xb620fd1e(Object obj) {
        try {
            return this.jacksonAdapter.serializeToBytes(obj, SerializerEncoding.JSON);
        } catch (IOException e) {
            throw LOGGER.logExceptionAsError(new UncheckedIOException(e));
        }
    }

    @Override // com.azure.core.util.serializer.JsonSerializer, com.azure.core.util.serializer.ObjectSerializer
    /* JADX INFO: renamed from: serialize, reason: merged with bridge method [inline-methods] */
    public void m1211x4ca677d3(OutputStream outputStream, Object obj) {
        try {
            this.jacksonAdapter.serialize(obj, SerializerEncoding.JSON, outputStream);
        } catch (IOException e) {
            throw LOGGER.logExceptionAsError(new UncheckedIOException(e));
        }
    }

    @Override // com.azure.core.util.serializer.JsonSerializer, com.azure.core.util.serializer.ObjectSerializer
    public Mono<byte[]> serializeToBytesAsync(final Object obj) {
        return Mono.fromCallable(new Callable() { // from class: com.azure.core.implementation.serializer.DefaultJsonSerializer$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m1212xb620fd1e(obj);
            }
        });
    }

    @Override // com.azure.core.util.serializer.JsonSerializer, com.azure.core.util.serializer.ObjectSerializer
    public Mono<Void> serializeAsync(final OutputStream outputStream, final Object obj) {
        return Mono.fromRunnable(new Runnable() { // from class: com.azure.core.implementation.serializer.DefaultJsonSerializer$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1211x4ca677d3(outputStream, obj);
            }
        });
    }
}
