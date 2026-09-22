package com.azure.core.implementation.util;

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
import java.util.LinkedList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class FluxByteBufferContent extends BinaryDataContent {
    private volatile byte[] bytes;
    private final AtomicReference<FluxByteBufferContent> cachedReplayableContent;
    private final Flux<ByteBuffer> content;
    private final boolean isReplayable;
    private final Long length;
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) FluxByteBufferContent.class);
    private static final AtomicReferenceFieldUpdater<FluxByteBufferContent, byte[]> BYTES_UPDATER = AtomicReferenceFieldUpdater.newUpdater(FluxByteBufferContent.class, byte[].class, "bytes");

    public static /* synthetic */ LinkedList $r8$lambda$dInyoCRuWG0jJXEDIgRgINWfY58() {
        return new LinkedList();
    }

    public FluxByteBufferContent(Flux<ByteBuffer> flux) {
        this(flux, null);
    }

    public FluxByteBufferContent(Flux<ByteBuffer> flux, Long l) {
        this(flux, l, false);
    }

    public FluxByteBufferContent(Flux<ByteBuffer> flux, Long l, boolean z) {
        this.cachedReplayableContent = new AtomicReference<>();
        this.content = (Flux) Objects.requireNonNull(flux, "'content' cannot be null.");
        this.length = l;
        this.isReplayable = z;
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public Long getLength() {
        byte[] bArr = BYTES_UPDATER.get(this);
        if (bArr != null) {
            return Long.valueOf(bArr.length);
        }
        return this.length;
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public String toString() {
        return new String(toBytes(), StandardCharsets.UTF_8);
    }

    /* JADX INFO: renamed from: lambda$toBytes$0$com-azure-core-implementation-util-FluxByteBufferContent, reason: not valid java name */
    /* synthetic */ byte[] m1219x8825d5d9(byte[] bArr) {
        return bArr == null ? getBytes() : bArr;
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public byte[] toBytes() {
        return BYTES_UPDATER.updateAndGet(this, new UnaryOperator() { // from class: com.azure.core.implementation.util.FluxByteBufferContent$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1219x8825d5d9((byte[]) obj);
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

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public Flux<ByteBuffer> toFluxByteBuffer() {
        return this.content;
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public void writeTo(OutputStream outputStream) throws IOException {
        FluxUtil.writeToOutputStream(this.content, outputStream).block();
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public void writeTo(WritableByteChannel writableByteChannel) throws IOException {
        FluxUtil.writeToWritableByteChannel(this.content, writableByteChannel).block();
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public Mono<Void> writeTo(AsynchronousByteChannel asynchronousByteChannel) {
        if (asynchronousByteChannel == null) {
            return FluxUtil.monoError(LOGGER, new NullPointerException("'channel' cannot be null."));
        }
        return FluxUtil.writeToAsynchronousByteChannel(this.content, asynchronousByteChannel);
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public void writeTo(JsonWriter jsonWriter) throws IOException {
        Objects.requireNonNull(jsonWriter, "'jsonWriter' cannot be null");
        jsonWriter.writeBinary(toBytes());
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public boolean isReplayable() {
        return this.isReplayable;
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public BinaryDataContent toReplayableContent() {
        if (this.isReplayable) {
            return this;
        }
        FluxByteBufferContent fluxByteBufferContent = this.cachedReplayableContent.get();
        return fluxByteBufferContent != null ? fluxByteBufferContent : (BinaryDataContent) bufferContent().map(new Function() { // from class: com.azure.core.implementation.util.FluxByteBufferContent$$ExternalSyntheticLambda7
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1220x54f28dcb((LinkedList) obj);
            }
        }).block();
    }

    /* JADX INFO: renamed from: lambda$toReplayableContent$1$com-azure-core-implementation-util-FluxByteBufferContent, reason: not valid java name */
    /* synthetic */ FluxByteBufferContent m1220x54f28dcb(LinkedList linkedList) {
        FluxByteBufferContent fluxByteBufferContent = new FluxByteBufferContent(Flux.fromIterable(linkedList).map(new Function() { // from class: com.azure.core.implementation.util.FluxByteBufferContent$$ExternalSyntheticLambda6
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ByteBuffer) obj).duplicate();
            }
        }), this.length, true);
        this.cachedReplayableContent.set(fluxByteBufferContent);
        return fluxByteBufferContent;
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public Mono<BinaryDataContent> toReplayableContentAsync() {
        if (this.isReplayable) {
            return Mono.just(this);
        }
        FluxByteBufferContent fluxByteBufferContent = this.cachedReplayableContent.get();
        if (fluxByteBufferContent != null) {
            return Mono.just(fluxByteBufferContent);
        }
        return bufferContent().cache().map(new Function() { // from class: com.azure.core.implementation.util.FluxByteBufferContent$$ExternalSyntheticLambda5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1221xa83840ce((LinkedList) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$toReplayableContentAsync$2$com-azure-core-implementation-util-FluxByteBufferContent, reason: not valid java name */
    /* synthetic */ BinaryDataContent m1221xa83840ce(LinkedList linkedList) {
        FluxByteBufferContent fluxByteBufferContent = new FluxByteBufferContent(Flux.fromIterable(linkedList).map(new Function() { // from class: com.azure.core.implementation.util.FluxByteBufferContent$$ExternalSyntheticLambda4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ByteBuffer) obj).asReadOnlyBuffer();
            }
        }), this.length, true);
        this.cachedReplayableContent.set(fluxByteBufferContent);
        return fluxByteBufferContent;
    }

    private Mono<LinkedList<ByteBuffer>> bufferContent() {
        return this.content.map(new Function() { // from class: com.azure.core.implementation.util.FluxByteBufferContent$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return FluxByteBufferContent.lambda$bufferContent$3((ByteBuffer) obj);
            }
        }).collect(new Supplier() { // from class: com.azure.core.implementation.util.FluxByteBufferContent$$ExternalSyntheticLambda2
            @Override // java.util.function.Supplier
            public final Object get() {
                return FluxByteBufferContent.$r8$lambda$dInyoCRuWG0jJXEDIgRgINWfY58();
            }
        }, new BiConsumer() { // from class: com.azure.core.implementation.util.FluxByteBufferContent$$ExternalSyntheticLambda3
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((LinkedList) obj).add((ByteBuffer) obj2);
            }
        });
    }

    static /* synthetic */ ByteBuffer lambda$bufferContent$3(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining());
        byteBufferAllocate.put(byteBuffer);
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public BinaryDataContentType getContentType() {
        return BinaryDataContentType.BINARY;
    }

    private byte[] getBytes() {
        Long l = this.length;
        if (l != null && l.longValue() > 2147483639) {
            throw LOGGER.logExceptionAsError(new IllegalStateException("The content length is too large for a byte array. Content length is: " + this.length));
        }
        return (byte[]) FluxUtil.collectBytesInByteBufferStream(this.content).share().block();
    }
}
