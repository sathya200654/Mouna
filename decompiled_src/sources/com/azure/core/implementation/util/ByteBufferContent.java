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
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ByteBufferContent extends BinaryDataContent {
    private static final AtomicReferenceFieldUpdater<ByteBufferContent, byte[]> BYTES_UPDATER = AtomicReferenceFieldUpdater.newUpdater(ByteBufferContent.class, byte[].class, "bytes");
    private volatile byte[] bytes;
    private final ByteBuffer content;

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public boolean isReplayable() {
        return true;
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public BinaryDataContent toReplayableContent() {
        return this;
    }

    public ByteBufferContent(ByteBuffer byteBuffer) {
        this.content = (ByteBuffer) Objects.requireNonNull(byteBuffer, "'content' cannot be null.");
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public Long getLength() {
        return Long.valueOf(this.content.remaining());
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public String toString() {
        return new String(toBytes(), StandardCharsets.UTF_8);
    }

    /* JADX INFO: renamed from: lambda$toBytes$0$com-azure-core-implementation-util-ByteBufferContent, reason: not valid java name */
    /* synthetic */ byte[] m1215x4741b942(byte[] bArr) {
        return bArr == null ? getBytes() : bArr;
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public byte[] toBytes() {
        return BYTES_UPDATER.updateAndGet(this, new UnaryOperator() { // from class: com.azure.core.implementation.util.ByteBufferContent$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1215x4741b942((byte[]) obj);
            }
        });
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public <T> T toObject(TypeReference<T> typeReference, ObjectSerializer objectSerializer) {
        return (T) objectSerializer.m1210xacbeabd2(toBytes(), typeReference);
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public InputStream toStream() {
        return new ByteArrayInputStream(toBytes());
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public ByteBuffer toByteBuffer() {
        return this.content.asReadOnlyBuffer();
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public Flux<ByteBuffer> toFluxByteBuffer() {
        return Flux.just(this.content).map(new Function() { // from class: com.azure.core.implementation.util.ByteBufferContent$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ByteBuffer) obj).asReadOnlyBuffer();
            }
        });
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public void writeTo(OutputStream outputStream) throws IOException {
        Objects.requireNonNull(outputStream, "'outputStream' cannot be null");
        ImplUtils.writeByteBufferToStream(toByteBuffer(), outputStream);
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

    private byte[] getBytes() {
        byte[] bArr = new byte[this.content.remaining()];
        this.content.mark();
        this.content.get(bArr);
        this.content.flip();
        return bArr;
    }
}
