package com.azure.core.implementation.util;

import com.azure.core.util.FluxUtil;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.serializer.ObjectSerializer;
import com.azure.core.util.serializer.TypeReference;
import com.azure.json.JsonWriter;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.AsynchronousByteChannel;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import org.reactivestreams.Publisher;
import reactor.core.Exceptions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class FileContent extends BinaryDataContent {
    private volatile byte[] bytes;
    private final int chunkSize;
    private final Path file;
    private final long length;
    private final long position;
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) FileContent.class);
    private static final AtomicReferenceFieldUpdater<FileContent, byte[]> BYTES_UPDATER = AtomicReferenceFieldUpdater.newUpdater(FileContent.class, byte[].class, "bytes");

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public boolean isReplayable() {
        return true;
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public BinaryDataContent toReplayableContent() {
        return this;
    }

    public FileContent(Path path, int i, Long l, Long l2) {
        this(validateFile(path), validateChunkSize(i), validatePosition(l), validateLength(l2, path.toFile().length(), validatePosition(l)));
    }

    FileContent(Path path, int i, long j, long j2) {
        this.file = path;
        this.chunkSize = i;
        this.position = j;
        this.length = j2;
    }

    private static Path validateFile(Path path) {
        Objects.requireNonNull(path, "'file' cannot be null.");
        if (path.toFile().exists()) {
            return path;
        }
        throw LOGGER.logExceptionAsError(new UncheckedIOException(new FileNotFoundException("File does not exist " + path)));
    }

    private static int validateChunkSize(int i) {
        if (i > 0) {
            return i;
        }
        throw LOGGER.logExceptionAsError(new IllegalArgumentException("'chunkSize' cannot be less than or equal to 0."));
    }

    private static long validatePosition(Long l) {
        if (l != null && l.longValue() < 0) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("'position' cannot be negative."));
        }
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    private static long validateLength(Long l, long j, long j2) {
        if (l != null && l.longValue() < 0) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("'length' cannot be negative."));
        }
        long j3 = j - j2;
        return l == null ? j3 : Math.min(l.longValue(), j3);
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public Long getLength() {
        return Long.valueOf(this.length);
    }

    public long getPosition() {
        return this.position;
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public String toString() {
        return new String(toBytes(), StandardCharsets.UTF_8);
    }

    /* JADX INFO: renamed from: lambda$toBytes$0$com-azure-core-implementation-util-FileContent, reason: not valid java name */
    /* synthetic */ byte[] m1216lambda$toBytes$0$comazurecoreimplementationutilFileContent(byte[] bArr) {
        return bArr == null ? getBytes() : bArr;
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public byte[] toBytes() {
        return BYTES_UPDATER.updateAndGet(this, new UnaryOperator() { // from class: com.azure.core.implementation.util.FileContent$$ExternalSyntheticLambda3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1216lambda$toBytes$0$comazurecoreimplementationutilFileContent((byte[]) obj);
            }
        });
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public <T> T toObject(TypeReference<T> typeReference, ObjectSerializer objectSerializer) {
        return (T) objectSerializer.m1209xcd757cb4(toStream(), typeReference);
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public InputStream toStream() {
        try {
            return new SliceInputStream(new BufferedInputStream(getFileInputStream(), this.chunkSize), this.position, this.length);
        } catch (FileNotFoundException e) {
            throw LOGGER.logExceptionAsError(new UncheckedIOException("File not found " + this.file, e));
        }
    }

    protected FileInputStream getFileInputStream() throws FileNotFoundException {
        return new FileInputStream(this.file.toFile());
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public ByteBuffer toByteBuffer() {
        if (this.length > 2147483647L) {
            throw LOGGER.logExceptionAsError(new IllegalStateException("The content length is too large for a byte array. Content length is: " + this.length));
        }
        return toByteBufferInternal();
    }

    protected ByteBuffer toByteBufferInternal() {
        try {
            FileChannel fileChannelOpen = FileChannel.open(this.file, new OpenOption[0]);
            try {
                MappedByteBuffer map = fileChannelOpen.map(FileChannel.MapMode.READ_ONLY, this.position, this.length);
                if (fileChannelOpen != null) {
                    fileChannelOpen.close();
                }
                return map;
            } catch (Throwable th) {
                if (fileChannelOpen == null) {
                    throw th;
                }
                try {
                    fileChannelOpen.close();
                    throw th;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                    throw th;
                }
            }
        } catch (IOException e) {
            throw LOGGER.logExceptionAsError(new UncheckedIOException(e));
        }
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public Flux<ByteBuffer> toFluxByteBuffer() {
        return Flux.using(new Callable() { // from class: com.azure.core.implementation.util.FileContent$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.openAsynchronousFileChannel();
            }
        }, new Function() { // from class: com.azure.core.implementation.util.FileContent$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1217xdb91bc17((AsynchronousFileChannel) obj);
            }
        }, new Consumer() { // from class: com.azure.core.implementation.util.FileContent$$ExternalSyntheticLambda2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                FileContent.lambda$toFluxByteBuffer$2((AsynchronousFileChannel) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$toFluxByteBuffer$1$com-azure-core-implementation-util-FileContent, reason: not valid java name */
    /* synthetic */ Publisher m1217xdb91bc17(AsynchronousFileChannel asynchronousFileChannel) {
        return FluxUtil.readFile(asynchronousFileChannel, this.chunkSize, this.position, this.length);
    }

    static /* synthetic */ void lambda$toFluxByteBuffer$2(AsynchronousFileChannel asynchronousFileChannel) {
        try {
            asynchronousFileChannel.close();
        } catch (IOException e) {
            throw LOGGER.logExceptionAsError(Exceptions.propagate(e));
        }
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public void writeTo(OutputStream outputStream) throws IOException {
        writeTo(Channels.newChannel(outputStream));
    }

    @Override // com.azure.core.implementation.util.BinaryDataContent
    public void writeTo(WritableByteChannel writableByteChannel) throws IOException {
        FileChannel fileChannelOpen = FileChannel.open(this.file, new OpenOption[0]);
        long j = 0;
        while (true) {
            try {
                long j2 = this.length;
                if (j >= j2) {
                    if (fileChannelOpen != null) {
                        fileChannelOpen.close();
                        return;
                    }
                    return;
                }
                WritableByteChannel writableByteChannel2 = writableByteChannel;
                long jTransferTo = fileChannelOpen.transferTo(this.position + j, j2 - j, writableByteChannel2);
                if (jTransferTo < 0) {
                    if (fileChannelOpen != null) {
                        fileChannelOpen.close();
                        return;
                    }
                    return;
                }
                j += jTransferTo;
                writableByteChannel = writableByteChannel2;
            } catch (Throwable th) {
                if (fileChannelOpen == null) {
                    throw th;
                }
                try {
                    fileChannelOpen.close();
                    throw th;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                    throw th;
                }
            }
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

    protected AsynchronousFileChannel openAsynchronousFileChannel() throws IOException {
        return AsynchronousFileChannel.open(this.file, StandardOpenOption.READ);
    }

    public Path getFile() {
        return this.file;
    }

    public int getChunkSize() {
        return this.chunkSize;
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
        if (this.length > 2147483639) {
            throw LOGGER.logExceptionAsError(new IllegalStateException("The content length is too large for a byte array. Content length is: " + this.length));
        }
        try {
            InputStream stream = toStream();
            try {
                int i = (int) this.length;
                byte[] bArr = new byte[i];
                int i2 = 0;
                do {
                    int i3 = stream.read(bArr, i2, i);
                    if (i3 < 0) {
                        throw LOGGER.logExceptionAsError(new IllegalStateException("Premature EOF. File was modified concurrently."));
                    }
                    i -= i3;
                    i2 += i3;
                    throw LOGGER.logExceptionAsError(new UncheckedIOException(e));
                } while (i > 0);
                if (stream != null) {
                    stream.close();
                }
                return bArr;
            } catch (Throwable th) {
                if (stream != null) {
                    try {
                        stream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (IOException e) {
            throw LOGGER.logExceptionAsError(new UncheckedIOException(e));
        }
    }
}
