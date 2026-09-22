package com.azure.core.implementation.util;

import com.azure.core.implementation.ImplUtils;
import com.azure.core.util.FluxUtil;
import com.azure.core.util.logging.ClientLogger;
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
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SerializableContent extends BinaryDataContent {
    private volatile byte[] bytes;
    private final Object content;
    private final ObjectSerializer serializer;
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) SerializableContent.class);
    private static final AtomicReferenceFieldUpdater<SerializableContent, byte[]> BYTES_UPDATER = AtomicReferenceFieldUpdater.newUpdater(SerializableContent.class, byte[].class, "bytes");

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public boolean isReplayable() {
        return true;
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public BinaryDataContent toReplayableContent() {
        return this;
    }

    public SerializableContent(Object obj, ObjectSerializer objectSerializer) {
        this.content = obj;
        this.serializer = (ObjectSerializer) Objects.requireNonNull(objectSerializer, "'serializer' cannot be null.");
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public Long getLength() {
        if (this.content == null) {
            return null;
        }
        return Long.valueOf(toBytes().length);
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public String toString() {
        return new String(toBytes(), StandardCharsets.UTF_8);
    }

    /* JADX INFO: renamed from: lambda$toBytes$0$com-azure-core-implementation-util-SerializableContent, reason: not valid java name */
    /* synthetic */ byte[] m1225x3314238b(byte[] bArr) {
        return bArr == null ? getBytes() : bArr;
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public byte[] toBytes() {
        return BYTES_UPDATER.updateAndGet(this, new UnaryOperator() { // from class: com.azure.core.implementation.util.SerializableContent$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1225x3314238b((byte[]) obj);
            }
        });
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public <T> T toObject(TypeReference<T> typeReference, ObjectSerializer objectSerializer) {
        return (T) objectSerializer.m1210xacbeabd2(toBytes(), typeReference);
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public InputStream toStream() {
        return new ByteArrayInputStream(getBytes());
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public ByteBuffer toByteBuffer() {
        return ByteBuffer.wrap(toBytes()).asReadOnlyBuffer();
    }

    /* JADX INFO: renamed from: lambda$toFluxByteBuffer$1$com-azure-core-implementation-util-SerializableContent, reason: not valid java name */
    /* synthetic */ ByteBuffer m1226xae349534() {
        return ByteBuffer.wrap(toBytes());
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public Flux<ByteBuffer> toFluxByteBuffer() {
        return Mono.fromSupplier(new Supplier() { // from class: com.azure.core.implementation.util.SerializableContent$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.m1226xae349534();
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
            return FluxUtil.monoError(LOGGER, new NullPointerException("'channel' cannot be null"));
        }
        return FluxUtil.writeToAsynchronousByteChannel(toFluxByteBuffer(), asynchronousByteChannel);
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public void writeTo(JsonWriter jsonWriter) throws IOException {
        Objects.requireNonNull(jsonWriter, "'jsonWriter' cannot be null");
        if (this.content == null) {
            jsonWriter.writeNull();
        } else {
            jsonWriter.writeRawValue(toString());
        }
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public Mono<BinaryDataContent> toReplayableContentAsync() {
        return Mono.just(this);
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public BinaryDataContentType getContentType() {
        return BinaryDataContentType.OBJECT;
    }

    private byte[] getBytes() {
        return this.serializer.m1212xb620fd1e(this.content);
    }
}
