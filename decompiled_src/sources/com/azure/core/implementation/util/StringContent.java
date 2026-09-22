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
public final class StringContent extends BinaryDataContent {
    private volatile byte[] bytes;
    private final String content;
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) StringContent.class);
    private static final AtomicReferenceFieldUpdater<StringContent, byte[]> BYTES_UPDATER = AtomicReferenceFieldUpdater.newUpdater(StringContent.class, byte[].class, "bytes");

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public boolean isReplayable() {
        return true;
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public BinaryDataContent toReplayableContent() {
        return this;
    }

    public StringContent(String str) {
        this.content = (String) Objects.requireNonNull(str, "'content' cannot be null.");
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public Long getLength() {
        return Long.valueOf(toBytes().length);
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public String toString() {
        return this.content;
    }

    /* JADX INFO: renamed from: lambda$toBytes$0$com-azure-core-implementation-util-StringContent, reason: not valid java name */
    /* synthetic */ byte[] m1227x8983c4f9(byte[] bArr) {
        return bArr == null ? getBytes() : bArr;
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public byte[] toBytes() {
        return BYTES_UPDATER.updateAndGet(this, new UnaryOperator() { // from class: com.azure.core.implementation.util.StringContent$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1227x8983c4f9((byte[]) obj);
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
        return ByteBuffer.wrap(toBytes()).asReadOnlyBuffer();
    }

    /* JADX INFO: renamed from: lambda$toFluxByteBuffer$1$com-azure-core-implementation-util-StringContent, reason: not valid java name */
    /* synthetic */ ByteBuffer m1228xbba0e962() {
        return ByteBuffer.wrap(toBytes());
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public Flux<ByteBuffer> toFluxByteBuffer() {
        return Mono.fromSupplier(new Supplier() { // from class: com.azure.core.implementation.util.StringContent$$ExternalSyntheticLambda1
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.m1228xbba0e962();
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
        jsonWriter.writeString(toString());
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public Mono<BinaryDataContent> toReplayableContentAsync() {
        return Mono.just(this);
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public BinaryDataContentType getContentType() {
        return BinaryDataContentType.TEXT;
    }

    private byte[] getBytes() {
        return this.content.getBytes(StandardCharsets.UTF_8);
    }
}
