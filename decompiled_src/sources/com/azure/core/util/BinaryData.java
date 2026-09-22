package com.azure.core.util;

import com.azure.core.implementation.util.BinaryDataContent;
import com.azure.core.implementation.util.BinaryDataHelper;
import com.azure.core.implementation.util.ByteArrayContent;
import com.azure.core.implementation.util.ByteBufferContent;
import com.azure.core.implementation.util.FileContent;
import com.azure.core.implementation.util.FluxByteBufferContent;
import com.azure.core.implementation.util.InputStreamContent;
import com.azure.core.implementation.util.ListByteBufferContent;
import com.azure.core.implementation.util.SerializableContent;
import com.azure.core.implementation.util.StringContent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.serializer.JsonSerializer;
import com.azure.core.util.serializer.JsonSerializerProviders;
import com.azure.core.util.serializer.ObjectSerializer;
import com.azure.core.util.serializer.TypeReference;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class BinaryData {
    static final int MAX_ARRAY_SIZE = 2147483639;
    private final BinaryDataContent content;
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) BinaryData.class);
    static final JsonSerializer SERIALIZER = JsonSerializerProviders.createInstance(true);

    public static /* synthetic */ LinkedList $r8$lambda$dInyoCRuWG0jJXEDIgRgINWfY58() {
        return new LinkedList();
    }

    static {
        BinaryDataHelper.setAccessor(new BinaryDataHelper.BinaryDataAccessor() { // from class: com.azure.core.util.BinaryData.1
            @Override // com.azure.core.implementation.util.BinaryDataHelper.BinaryDataAccessor
            public BinaryData createBinaryData(BinaryDataContent binaryDataContent) {
                return new BinaryData(binaryDataContent);
            }

            @Override // com.azure.core.implementation.util.BinaryDataHelper.BinaryDataAccessor
            public BinaryDataContent getContent(BinaryData binaryData) {
                return binaryData.content;
            }
        });
    }

    BinaryData(BinaryDataContent binaryDataContent) {
        this.content = (BinaryDataContent) Objects.requireNonNull(binaryDataContent, "'content' cannot be null.");
    }

    public static BinaryData fromStream(InputStream inputStream) {
        return fromStream(inputStream, null);
    }

    public static BinaryData fromStream(InputStream inputStream, Long l) {
        return new BinaryData(new InputStreamContent(inputStream, l));
    }

    public static Mono<BinaryData> fromStreamAsync(InputStream inputStream) {
        return fromStreamAsync(inputStream, null);
    }

    public static Mono<BinaryData> fromStreamAsync(final InputStream inputStream, final Long l) {
        return Mono.fromCallable(new Callable() { // from class: com.azure.core.util.BinaryData$$ExternalSyntheticLambda7
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return BinaryData.fromStream(inputStream, l);
            }
        });
    }

    public static Mono<BinaryData> fromFlux(Flux<ByteBuffer> flux) {
        return fromFlux(flux, null);
    }

    public static Mono<BinaryData> fromFlux(Flux<ByteBuffer> flux, Long l) {
        return fromFlux(flux, l, true);
    }

    public static Mono<BinaryData> fromFlux(Flux<ByteBuffer> flux, final Long l, boolean z) {
        if (flux == null) {
            return FluxUtil.monoError(LOGGER, new NullPointerException("'data' cannot be null."));
        }
        if (l != null && l.longValue() < 0) {
            return FluxUtil.monoError(LOGGER, new IllegalArgumentException("'length' cannot be less than 0."));
        }
        if (!z) {
            return Mono.just(new BinaryData(new FluxByteBufferContent(flux, l)));
        }
        final long[] jArr = {0};
        return flux.map(new Function() { // from class: com.azure.core.util.BinaryData$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return BinaryData.lambda$fromFlux$1(jArr, (ByteBuffer) obj);
            }
        }).collect(new Supplier() { // from class: com.azure.core.util.BinaryData$$ExternalSyntheticLambda1
            @Override // java.util.function.Supplier
            public final Object get() {
                return BinaryData.$r8$lambda$dInyoCRuWG0jJXEDIgRgINWfY58();
            }
        }, new BiConsumer() { // from class: com.azure.core.util.BinaryData$$ExternalSyntheticLambda2
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((LinkedList) obj).add((ByteBuffer) obj2);
            }
        }).map(new Function() { // from class: com.azure.core.util.BinaryData$$ExternalSyntheticLambda3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return BinaryData.lambda$fromFlux$2(l, jArr, (LinkedList) obj);
            }
        });
    }

    static /* synthetic */ ByteBuffer lambda$fromFlux$1(long[] jArr, ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(iRemaining);
        jArr[0] = jArr[0] + ((long) iRemaining);
        byteBufferAllocate.put(byteBuffer);
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    static /* synthetic */ BinaryData lambda$fromFlux$2(Long l, long[] jArr, LinkedList linkedList) {
        return new BinaryData(new FluxByteBufferContent(Flux.fromIterable(linkedList).map(new Function() { // from class: com.azure.core.util.BinaryData$$ExternalSyntheticLambda4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ByteBuffer) obj).duplicate();
            }
        }), Long.valueOf(l != null ? l.longValue() : jArr[0]), true));
    }

    public static BinaryData fromString(String str) {
        return new BinaryData(new StringContent(str));
    }

    public static BinaryData fromBytes(byte[] bArr) {
        return new BinaryData(new ByteArrayContent(bArr));
    }

    public static BinaryData fromByteBuffer(ByteBuffer byteBuffer) {
        return new BinaryData(new ByteBufferContent(byteBuffer));
    }

    public static BinaryData fromListByteBuffer(List<ByteBuffer> list) {
        return new BinaryData(new ListByteBufferContent(list));
    }

    public static BinaryData fromObject(Object obj) {
        return fromObject(obj, SERIALIZER);
    }

    public static Mono<BinaryData> fromObjectAsync(Object obj) {
        return fromObjectAsync(obj, SERIALIZER);
    }

    public static BinaryData fromObject(Object obj, ObjectSerializer objectSerializer) {
        return new BinaryData(new SerializableContent(obj, objectSerializer));
    }

    public static Mono<BinaryData> fromObjectAsync(final Object obj, final ObjectSerializer objectSerializer) {
        return Mono.fromCallable(new Callable() { // from class: com.azure.core.util.BinaryData$$ExternalSyntheticLambda8
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return BinaryData.fromObject(obj, objectSerializer);
            }
        });
    }

    public static BinaryData fromFile(Path path) {
        return fromFile(path, 8192);
    }

    public static BinaryData fromFile(Path path, int i) {
        return new BinaryData(new FileContent(path, i, (Long) null, (Long) null));
    }

    public static BinaryData fromFile(Path path, Long l, Long l2) {
        return new BinaryData(new FileContent(path, 8192, l, l2));
    }

    public static BinaryData fromFile(Path path, Long l, Long l2, int i) {
        return new BinaryData(new FileContent(path, i, l, l2));
    }

    public byte[] toBytes() {
        return this.content.toBytes();
    }

    public String toString() {
        return this.content.toString();
    }

    public <T> T toObject(Class<T> cls) {
        return (T) m1236lambda$toObjectAsync$4$comazurecoreutilBinaryData(TypeReference.createInstance(cls), SERIALIZER);
    }

    public <T> T toObject(TypeReference<T> typeReference) {
        return (T) m1236lambda$toObjectAsync$4$comazurecoreutilBinaryData(typeReference, SERIALIZER);
    }

    public <T> T toObject(Class<T> cls, ObjectSerializer objectSerializer) {
        return (T) m1236lambda$toObjectAsync$4$comazurecoreutilBinaryData(TypeReference.createInstance(cls), objectSerializer);
    }

    /* JADX INFO: renamed from: toObject, reason: merged with bridge method [inline-methods] */
    public <T> T m1236lambda$toObjectAsync$4$comazurecoreutilBinaryData(TypeReference<T> typeReference, ObjectSerializer objectSerializer) {
        Objects.requireNonNull(typeReference, "'typeReference' cannot be null.");
        Objects.requireNonNull(objectSerializer, "'serializer' cannot be null.");
        return (T) this.content.toObject(typeReference, objectSerializer);
    }

    public <T> Mono<T> toObjectAsync(Class<T> cls) {
        return toObjectAsync(TypeReference.createInstance(cls), SERIALIZER);
    }

    public <T> Mono<T> toObjectAsync(TypeReference<T> typeReference) {
        return toObjectAsync(typeReference, SERIALIZER);
    }

    public <T> Mono<T> toObjectAsync(Class<T> cls, ObjectSerializer objectSerializer) {
        return toObjectAsync(TypeReference.createInstance(cls), objectSerializer);
    }

    public <T> Mono<T> toObjectAsync(final TypeReference<T> typeReference, final ObjectSerializer objectSerializer) {
        return Mono.fromCallable(new Callable() { // from class: com.azure.core.util.BinaryData$$ExternalSyntheticLambda6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m1236lambda$toObjectAsync$4$comazurecoreutilBinaryData(typeReference, objectSerializer);
            }
        });
    }

    public InputStream toStream() {
        return this.content.toStream();
    }

    public ByteBuffer toByteBuffer() {
        return this.content.toByteBuffer();
    }

    public Flux<ByteBuffer> toFluxByteBuffer() {
        return this.content.toFluxByteBuffer();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        Objects.requireNonNull(outputStream, "'outputStream' cannot be null.");
        this.content.writeTo(outputStream);
    }

    public void writeTo(WritableByteChannel writableByteChannel) throws IOException {
        Objects.requireNonNull(writableByteChannel, "'channel' cannot be null.");
        this.content.writeTo(writableByteChannel);
    }

    public Mono<Void> writeTo(AsynchronousByteChannel asynchronousByteChannel) {
        return this.content.writeTo(asynchronousByteChannel);
    }

    public void writeTo(JsonWriter jsonWriter) throws IOException {
        this.content.writeTo(jsonWriter);
    }

    public Long getLength() {
        return this.content.getLength();
    }

    public boolean isReplayable() {
        return this.content.isReplayable();
    }

    public BinaryData toReplayableBinaryData() {
        return isReplayable() ? this : new BinaryData(this.content.toReplayableContent());
    }

    public Mono<BinaryData> toReplayableBinaryDataAsync() {
        if (isReplayable()) {
            return Mono.just(this);
        }
        return this.content.toReplayableContentAsync().map(new Function() { // from class: com.azure.core.util.BinaryData$$ExternalSyntheticLambda5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return new BinaryData((BinaryDataContent) obj);
            }
        });
    }
}
