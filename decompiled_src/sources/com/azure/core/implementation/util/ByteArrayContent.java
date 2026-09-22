package com.azure.core.implementation.util;

import com.azure.core.implementation.ImplUtils;
import com.azure.core.util.FluxUtil;
import com.azure.core.util.serializer.ObjectSerializer;
import com.azure.core.util.serializer.TypeReference;
import com.azure.json.JsonWriter;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.function.Supplier;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ByteArrayContent extends BinaryDataContent {
    private final byte[] content;

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public boolean isReplayable() {
        return true;
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public BinaryDataContent toReplayableContent() {
        return this;
    }

    public ByteArrayContent(byte[] bArr) {
        this.content = (byte[]) Objects.requireNonNull(bArr, "'content' cannot be null");
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public Long getLength() {
        return Long.valueOf(this.content.length);
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public String toString() {
        return new String(this.content, StandardCharsets.UTF_8);
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public byte[] toBytes() {
        return this.content;
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public <T> T toObject(TypeReference<T> typeReference, ObjectSerializer objectSerializer) {
        return (T) objectSerializer.m1210xacbeabd2(this.content, typeReference);
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public InputStream toStream() {
        return new ByteArrayInputStream(this.content);
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public ByteBuffer toByteBuffer() {
        return ByteBuffer.wrap(this.content).asReadOnlyBuffer();
    }

    /* JADX INFO: renamed from: lambda$toFluxByteBuffer$0$com-azure-core-implementation-util-ByteArrayContent, reason: not valid java name */
    /* synthetic */ ByteBuffer m1214xfe8a070d() {
        return ByteBuffer.wrap(toBytes()).asReadOnlyBuffer();
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public Flux<ByteBuffer> toFluxByteBuffer() {
        return Mono.fromSupplier(new Supplier() { // from class: com.azure.core.implementation.util.ByteArrayContent$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.m1214xfe8a070d();
            }
        }).flux();
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public void writeTo(OutputStream outputStream) throws IOException {
        Objects.requireNonNull(outputStream, "'outputStream' cannot be null");
        outputStream.write(toBytes());
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public void writeTo(WritableByteChannel writableByteChannel) throws IOException {
        Objects.requireNonNull(writableByteChannel, "'channel' cannot be null");
        ImplUtils.fullyWriteBuffer(toByteBuffer(), writableByteChannel);
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public Mono<Void> writeTo(AsynchronousByteChannel asynchronousByteChannel) {
        if (asynchronousByteChannel == null) {
            return Mono.error(new NullPointerException("'channel' cannot be null"));
        }
        return FluxUtil.writeToAsynchronousByteChannel(toFluxByteBuffer(), asynchronousByteChannel);
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public void writeTo(JsonWriter jsonWriter) throws IOException {
        Objects.requireNonNull(jsonWriter, "'jsonWriter' cannot be null");
        jsonWriter.writeBinary(toBytes());
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public Mono<BinaryDataContent> toReplayableContentAsync() {
        return Mono.just(this);
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public BinaryDataContentType getContentType() {
        return BinaryDataContentType.BINARY;
    }
}
