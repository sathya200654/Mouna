package com.azure.core.implementation.util;

import com.azure.core.util.serializer.ObjectSerializer;
import com.azure.core.util.serializer.TypeReference;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousByteChannel;
import java.nio.channels.WritableByteChannel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public abstract class BinaryDataContent {
    static final int MAX_ARRAY_SIZE = 2147483639;
    public static final int STREAM_READ_SIZE = 8192;
    static final String TOO_LARGE_FOR_BYTE_ARRAY = "The content length is too large for a byte array. Content length is: ";

    public abstract BinaryDataContentType getContentType();

    public abstract Long getLength();

    public abstract boolean isReplayable();

    public abstract ByteBuffer toByteBuffer();

    public abstract byte[] toBytes();

    public abstract Flux<ByteBuffer> toFluxByteBuffer();

    public abstract <T> T toObject(TypeReference<T> typeReference, ObjectSerializer objectSerializer);

    public abstract BinaryDataContent toReplayableContent();

    public abstract Mono<BinaryDataContent> toReplayableContentAsync();

    public abstract InputStream toStream();

    public abstract String toString();

    public abstract Mono<Void> writeTo(AsynchronousByteChannel asynchronousByteChannel);

    public abstract void writeTo(JsonWriter jsonWriter) throws IOException;

    public abstract void writeTo(OutputStream outputStream) throws IOException;

    public abstract void writeTo(WritableByteChannel writableByteChannel) throws IOException;
}
