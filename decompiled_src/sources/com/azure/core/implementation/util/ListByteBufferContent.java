package com.azure.core.implementation.util;

import com.azure.core.implementation.ImplUtils;
import com.azure.core.util.FluxUtil;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.serializer.ObjectSerializer;
import com.azure.core.util.serializer.TypeReference;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Function;
import java.util.function.ToLongFunction;
import java.util.function.UnaryOperator;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class ListByteBufferContent extends BinaryDataContent {
    private volatile byte[] bytes;
    private Long cachedLength;
    private final List<ByteBuffer> content;
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) ListByteBufferContent.class);
    private static final AtomicReferenceFieldUpdater<ListByteBufferContent, byte[]> BYTES_UPDATER = AtomicReferenceFieldUpdater.newUpdater(ListByteBufferContent.class, byte[].class, "bytes");

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public boolean isReplayable() {
        return true;
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public BinaryDataContent toReplayableContent() {
        return this;
    }

    public ListByteBufferContent(List<ByteBuffer> list) {
        this.content = (List) Objects.requireNonNull(list, "'content' cannot be null.");
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public Long getLength() {
        if (this.cachedLength == null) {
            this.cachedLength = Long.valueOf(this.content.stream().mapToLong(new ToLongFunction() { // from class: com.azure.core.implementation.util.ListByteBufferContent$$ExternalSyntheticLambda1
                @Override // java.util.function.ToLongFunction
                public final long applyAsLong(Object obj) {
                    return ((ByteBuffer) obj).remaining();
                }
            }).sum());
        }
        return this.cachedLength;
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public String toString() {
        return new String(toBytes(), StandardCharsets.UTF_8);
    }

    /* JADX INFO: renamed from: lambda$toBytes$0$com-azure-core-implementation-util-ListByteBufferContent, reason: not valid java name */
    /* synthetic */ byte[] m1224x6f39c7c4(byte[] bArr) {
        return bArr == null ? getBytes() : bArr;
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public byte[] toBytes() {
        return BYTES_UPDATER.updateAndGet(this, new UnaryOperator() { // from class: com.azure.core.implementation.util.ListByteBufferContent$$ExternalSyntheticLambda2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1224x6f39c7c4((byte[]) obj);
            }
        });
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public <T> T toObject(TypeReference<T> typeReference, ObjectSerializer objectSerializer) {
        return (T) objectSerializer.m1210xacbeabd2(toBytes(), typeReference);
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public InputStream toStream() {
        return new IterableOfByteBuffersInputStream(this.content);
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public ByteBuffer toByteBuffer() {
        return ByteBuffer.wrap(toBytes()).asReadOnlyBuffer();
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public Flux<ByteBuffer> toFluxByteBuffer() {
        return Flux.fromIterable(this.content).map(new Function() { // from class: com.azure.core.implementation.util.ListByteBufferContent$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ByteBuffer) obj).asReadOnlyBuffer();
            }
        });
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public void writeTo(OutputStream outputStream) throws IOException {
        Iterator<ByteBuffer> it = this.content.iterator();
        while (it.hasNext()) {
            ImplUtils.writeByteBufferToStream(it.next().asReadOnlyBuffer(), outputStream);
        }
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public void writeTo(WritableByteChannel writableByteChannel) throws IOException {
        Iterator<ByteBuffer> it = this.content.iterator();
        while (it.hasNext()) {
            ImplUtils.fullyWriteBuffer(it.next().asReadOnlyBuffer(), writableByteChannel);
        }
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public Mono<Void> writeTo(AsynchronousByteChannel asynchronousByteChannel) {
        if (asynchronousByteChannel == null) {
            return FluxUtil.monoError(LOGGER, new NullPointerException("'channel' cannot be null."));
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
        long jLongValue = getLength().longValue();
        if (jLongValue > 2147483639) {
            throw LOGGER.logExceptionAsError(new IllegalStateException("The content length is too large for a byte array. Content length is: " + jLongValue));
        }
        byte[] bArr = new byte[(int) jLongValue];
        Iterator<ByteBuffer> it = this.content.iterator();
        int i = 0;
        while (it.hasNext()) {
            ByteBuffer byteBufferDuplicate = it.next().duplicate();
            int iRemaining = byteBufferDuplicate.remaining();
            byteBufferDuplicate.get(bArr, i, iRemaining);
            i += iRemaining;
        }
        return bArr;
    }
}
