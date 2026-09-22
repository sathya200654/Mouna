package com.azure.core.implementation.util;

import com.azure.core.implementation.AccessibleByteArrayOutputStream;
import com.azure.core.implementation.ImplUtils;
import com.azure.core.util.FluxUtil;
import com.azure.core.util.io.IOUtils;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.serializer.ObjectSerializer;
import com.azure.core.util.serializer.TypeReference;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousByteChannel;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.util.function.Tuple2;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class InputStreamContent extends BinaryDataContent {
    private static final int INITIAL_BUFFER_CHUNK_SIZE = 8192;
    private static final int MAX_ARRAY_LENGTH = 2147483639;
    private static final int MAX_BUFFER_CHUNK_SIZE = 8388608;
    private final List<ByteBuffer> bufferedContent;
    private volatile byte[] bytes;
    private final Supplier<InputStream> content;
    private final boolean isReplayable;
    private final Long length;
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) InputStreamContent.class);
    private static final AtomicReferenceFieldUpdater<InputStreamContent, byte[]> BYTES_UPDATER = AtomicReferenceFieldUpdater.newUpdater(InputStreamContent.class, byte[].class, "bytes");

    static /* synthetic */ InputStream lambda$new$1(InputStream inputStream) {
        return inputStream;
    }

    public InputStreamContent(final InputStream inputStream, Long l) {
        Objects.requireNonNull(inputStream, "'inputStream' cannot be null.");
        this.length = l;
        boolean zCanMarkReset = canMarkReset(inputStream, l);
        this.isReplayable = zCanMarkReset;
        if (zCanMarkReset) {
            inputStream.mark(l.intValue());
            this.content = new Supplier() { // from class: com.azure.core.implementation.util.InputStreamContent$$ExternalSyntheticLambda3
                @Override // java.util.function.Supplier
                public final Object get() {
                    return InputStreamContent.resettableContent(inputStream);
                }
            };
        } else {
            this.content = new Supplier() { // from class: com.azure.core.implementation.util.InputStreamContent$$ExternalSyntheticLambda4
                @Override // java.util.function.Supplier
                public final Object get() {
                    return InputStreamContent.lambda$new$1(inputStream);
                }
            };
        }
        this.bufferedContent = null;
    }

    private InputStreamContent(Supplier<InputStream> supplier, Long l, List<ByteBuffer> list) {
        this.content = (Supplier) Objects.requireNonNull(supplier, "'inputStreamSupplier' cannot be null.");
        this.length = l;
        this.isReplayable = true;
        this.bufferedContent = list;
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

    /* JADX INFO: renamed from: lambda$toBytes$2$com-azure-core-implementation-util-InputStreamContent, reason: not valid java name */
    /* synthetic */ byte[] m1222xe652a480(byte[] bArr) {
        return bArr == null ? getBytes() : bArr;
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public byte[] toBytes() {
        return BYTES_UPDATER.updateAndGet(this, new UnaryOperator() { // from class: com.azure.core.implementation.util.InputStreamContent$$ExternalSyntheticLambda6
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1222xe652a480((byte[]) obj);
            }
        });
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public <T> T toObject(TypeReference<T> typeReference, ObjectSerializer objectSerializer) {
        return (T) objectSerializer.m1210xacbeabd2(toBytes(), typeReference);
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public InputStream toStream() {
        return this.content.get();
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public ByteBuffer toByteBuffer() {
        return ByteBuffer.wrap(toBytes()).asReadOnlyBuffer();
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public Flux<ByteBuffer> toFluxByteBuffer() {
        List<ByteBuffer> list = this.bufferedContent;
        if (list != null) {
            return Flux.fromIterable(list).map(new Function() { // from class: com.azure.core.implementation.util.InputStreamContent$$ExternalSyntheticLambda5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ((ByteBuffer) obj).asReadOnlyBuffer();
                }
            });
        }
        return FluxUtil.toFluxByteBuffer(this.content.get(), 8192);
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public void writeTo(OutputStream outputStream) throws IOException {
        writeTo(Channels.newChannel(outputStream));
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public void writeTo(WritableByteChannel writableByteChannel) throws IOException {
        InputStream inputStream = this.content.get();
        List<ByteBuffer> list = this.bufferedContent;
        if (list != null) {
            Iterator<ByteBuffer> it = list.iterator();
            while (it.hasNext()) {
                ImplUtils.fullyWriteBuffer(it.next().duplicate(), writableByteChannel);
            }
            return;
        }
        IOUtils.transfer(Channels.newChannel(inputStream), writableByteChannel, this.length);
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
    public boolean isReplayable() {
        return this.isReplayable;
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public BinaryDataContent toReplayableContent() {
        return this.isReplayable ? this : readAndBuffer(this.content.get(), this.length);
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public Mono<BinaryDataContent> toReplayableContentAsync() {
        if (this.isReplayable) {
            return Mono.just(this);
        }
        return Mono.just(this.content.get()).publishOn(Schedulers.boundedElastic()).map(new Function() { // from class: com.azure.core.implementation.util.InputStreamContent$$ExternalSyntheticLambda2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1223x4d83d06a((InputStream) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$toReplayableContentAsync$3$com-azure-core-implementation-util-InputStreamContent, reason: not valid java name */
    /* synthetic */ BinaryDataContent m1223x4d83d06a(InputStream inputStream) {
        return readAndBuffer(inputStream, this.length);
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public BinaryDataContentType getContentType() {
        return BinaryDataContentType.BINARY;
    }

    private static boolean canMarkReset(InputStream inputStream, Long l) {
        return l != null && l.longValue() < 2147483639 && inputStream.markSupported();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static InputStream resettableContent(InputStream inputStream) {
        try {
            inputStream.reset();
            return inputStream;
        } catch (IOException e) {
            throw LOGGER.logExceptionAsError(new UncheckedIOException(e));
        }
    }

    private static InputStreamContent readAndBuffer(InputStream inputStream, Long l) {
        try {
            Tuple2<Long, List<ByteBuffer>> streamToListOfByteBuffers = StreamUtil.readStreamToListOfByteBuffers(inputStream, l, 8192, MAX_BUFFER_CHUNK_SIZE);
            long jLongValue = ((Long) streamToListOfByteBuffers.getT1()).longValue();
            final List list = (List) streamToListOfByteBuffers.getT2();
            if (l != null && l.longValue() == jLongValue) {
                return new InputStreamContent(new Supplier() { // from class: com.azure.core.implementation.util.InputStreamContent$$ExternalSyntheticLambda1
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return InputStreamContent.lambda$readAndBuffer$5(list);
                    }
                }, l, list);
            }
            return new InputStreamContent(new Supplier() { // from class: com.azure.core.implementation.util.InputStreamContent$$ExternalSyntheticLambda0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return InputStreamContent.lambda$readAndBuffer$4(list);
                }
            }, Long.valueOf(jLongValue), list);
        } catch (IOException e) {
            throw LOGGER.logExceptionAsError(new UncheckedIOException(e));
        }
    }

    static /* synthetic */ InputStream lambda$readAndBuffer$4(List list) {
        return new IterableOfByteBuffersInputStream(list);
    }

    static /* synthetic */ InputStream lambda$readAndBuffer$5(List list) {
        return new IterableOfByteBuffersInputStream(list);
    }

    private byte[] getBytes() {
        AccessibleByteArrayOutputStream accessibleByteArrayOutputStream;
        try {
            Long l = this.length;
            if (l == null || l.longValue() < 2147483639) {
                accessibleByteArrayOutputStream = new AccessibleByteArrayOutputStream();
            } else {
                accessibleByteArrayOutputStream = new AccessibleByteArrayOutputStream(this.length.intValue());
            }
            byte[] bArr = new byte[8192];
            InputStream inputStream = this.content.get();
            while (true) {
                int i = inputStream.read(bArr, 0, 8192);
                if (i != -1) {
                    accessibleByteArrayOutputStream.write(bArr, 0, i);
                } else {
                    return accessibleByteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e) {
            throw LOGGER.logExceptionAsError(new UncheckedIOException(e));
        }
    }
}
