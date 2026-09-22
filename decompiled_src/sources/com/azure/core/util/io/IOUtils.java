package com.azure.core.util.io;

import com.azure.core.http.HttpHeaderName;
import com.azure.core.http.rest.StreamResponse;
import com.azure.core.implementation.AsynchronousFileChannelAdapter;
import com.azure.core.implementation.ByteCountingAsynchronousByteChannel;
import com.azure.core.implementation.ImplUtils;
import com.azure.core.implementation.logging.LoggingKeys;
import com.azure.core.util.ProgressReporter;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.logging.LogLevel;
import com.azure.core.util.logging.LoggingEventBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousByteChannel;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.LongConsumer;
import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoSink;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class IOUtils {
    private static final int DEFAULT_BUFFER_SIZE = 8192;
    private static final int GB = 1073741824;
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) IOUtils.class);
    private static final int MB = 1048576;
    private static final int SIXTY_FOUR_KB = 65536;
    private static final int THIRTY_TWO_KB = 32768;

    private static int getBufferSize(long j) {
        if (j > 1073741824) {
            return 65536;
        }
        return j > 1048576 ? 32768 : 8192;
    }

    static /* synthetic */ StreamResponse lambda$transferStreamResponseToAsynchronousByteChannelHelper$2(StreamResponse streamResponse) throws Exception {
        return streamResponse;
    }

    public static AsynchronousByteChannel toAsynchronousByteChannel(AsynchronousFileChannel asynchronousFileChannel, long j) {
        Objects.requireNonNull(asynchronousFileChannel, "'fileChannel' must not be null");
        if (j < 0) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("'position' cannot be less than 0."));
        }
        return new AsynchronousFileChannelAdapter(asynchronousFileChannel, j);
    }

    public static void transfer(ReadableByteChannel readableByteChannel, WritableByteChannel writableByteChannel) throws IOException {
        transfer(readableByteChannel, writableByteChannel, null);
    }

    public static void transfer(ReadableByteChannel readableByteChannel, WritableByteChannel writableByteChannel, Long l) throws IOException {
        int i;
        if (readableByteChannel == null && writableByteChannel == null) {
            throw new NullPointerException("'source' and 'destination' cannot be null.");
        }
        if (readableByteChannel == null) {
            throw new NullPointerException("'source' cannot be null.");
        }
        if (writableByteChannel == null) {
            throw new NullPointerException("'destination' cannot be null.");
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(l == null ? getBufferSize(readableByteChannel) : getBufferSize(l.longValue()));
        do {
            byteBufferAllocate.clear();
            i = readableByteChannel.read(byteBufferAllocate);
            byteBufferAllocate.flip();
            ImplUtils.fullyWriteBuffer(byteBufferAllocate, writableByteChannel);
        } while (i >= 0);
    }

    public static Mono<Void> transferAsync(ReadableByteChannel readableByteChannel, AsynchronousByteChannel asynchronousByteChannel) {
        return transferAsync(readableByteChannel, asynchronousByteChannel, null);
    }

    public static Mono<Void> transferAsync(final ReadableByteChannel readableByteChannel, final AsynchronousByteChannel asynchronousByteChannel, Long l) {
        if (readableByteChannel == null && asynchronousByteChannel == null) {
            return Mono.error(new NullPointerException("'source' and 'destination' cannot be null."));
        }
        if (readableByteChannel == null) {
            return Mono.error(new NullPointerException("'source' cannot be null."));
        }
        if (asynchronousByteChannel == null) {
            return Mono.error(new NullPointerException("'destination' cannot be null."));
        }
        final int bufferSize = l == null ? getBufferSize(readableByteChannel) : getBufferSize(l.longValue());
        return Mono.create(new Consumer() { // from class: com.azure.core.util.io.IOUtils$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                MonoSink monoSink = (MonoSink) obj;
                monoSink.onRequest(new LongConsumer() { // from class: com.azure.core.util.io.IOUtils$$ExternalSyntheticLambda6
                    @Override // java.util.function.LongConsumer
                    public final void accept(long j) {
                        IOUtils.lambda$transferAsync$0(i, readableByteChannel, asynchronousByteChannel, monoSink, j);
                    }
                });
            }
        });
    }

    static /* synthetic */ void lambda$transferAsync$0(int i, ReadableByteChannel readableByteChannel, AsynchronousByteChannel asynchronousByteChannel, MonoSink monoSink, long j) {
        try {
            transferAsynchronously(readableByteChannel, asynchronousByteChannel, ByteBuffer.allocate(i), monoSink);
        } catch (IOException e) {
            monoSink.error(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void transferAsynchronously(final ReadableByteChannel readableByteChannel, final AsynchronousByteChannel asynchronousByteChannel, final ByteBuffer byteBuffer, final MonoSink<Void> monoSink) throws IOException {
        byteBuffer.clear();
        if (readableByteChannel.read(byteBuffer) >= 0) {
            byteBuffer.flip();
            asynchronousByteChannel.write(byteBuffer, byteBuffer, new CompletionHandler<Integer, ByteBuffer>() { // from class: com.azure.core.util.io.IOUtils.1
                @Override // java.nio.channels.CompletionHandler
                public void completed(Integer num, ByteBuffer byteBuffer2) {
                    try {
                        if (!byteBuffer.hasRemaining()) {
                            IOUtils.transferAsynchronously(readableByteChannel, asynchronousByteChannel, byteBuffer, monoSink);
                            return;
                        }
                        AsynchronousByteChannel asynchronousByteChannel2 = asynchronousByteChannel;
                        ByteBuffer byteBuffer3 = byteBuffer;
                        asynchronousByteChannel2.write(byteBuffer3, byteBuffer3, this);
                    } catch (IOException e) {
                        monoSink.error(e);
                    }
                }

                @Override // java.nio.channels.CompletionHandler
                public void failed(Throwable th, ByteBuffer byteBuffer2) {
                    monoSink.error(th);
                }
            });
        } else {
            monoSink.success();
        }
    }

    public static Mono<Void> transferStreamResponseToAsynchronousByteChannel(AsynchronousByteChannel asynchronousByteChannel, StreamResponse streamResponse, BiFunction<Throwable, Long, Mono<StreamResponse>> biFunction, ProgressReporter progressReporter, int i) {
        return transferStreamResponseToAsynchronousByteChannelHelper(new ByteCountingAsynchronousByteChannel(asynchronousByteChannel, null, progressReporter), streamResponse, biFunction, i, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Mono<Void> transferStreamResponseToAsynchronousByteChannelHelper(final ByteCountingAsynchronousByteChannel byteCountingAsynchronousByteChannel, final StreamResponse streamResponse, final BiFunction<Throwable, Long, Mono<StreamResponse>> biFunction, final int i, final int i2) {
        return Mono.using(new Callable() { // from class: com.azure.core.util.io.IOUtils$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return IOUtils.lambda$transferStreamResponseToAsynchronousByteChannelHelper$2(streamResponse);
            }
        }, new Function() { // from class: com.azure.core.util.io.IOUtils$$ExternalSyntheticLambda3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                ByteCountingAsynchronousByteChannel byteCountingAsynchronousByteChannel2 = byteCountingAsynchronousByteChannel;
                return ((StreamResponse) obj).writeValueToAsync(byteCountingAsynchronousByteChannel2).onErrorResume(Exception.class, new Function() { // from class: com.azure.core.util.io.IOUtils$$ExternalSyntheticLambda1
                    @Override // java.util.function.Function
                    public final Object apply(Object obj2) {
                        return IOUtils.lambda$transferStreamResponseToAsynchronousByteChannelHelper$4(streamResponse, i, i, byteCountingAsynchronousByteChannel2, biFunction, (Exception) obj2);
                    }
                });
            }
        }, new Consumer() { // from class: com.azure.core.util.io.IOUtils$$ExternalSyntheticLambda4
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((StreamResponse) obj).close();
            }
        });
    }

    static /* synthetic */ Mono lambda$transferStreamResponseToAsynchronousByteChannelHelper$4(StreamResponse streamResponse, int i, final int i2, final ByteCountingAsynchronousByteChannel byteCountingAsynchronousByteChannel, final BiFunction biFunction, Exception exc) {
        streamResponse.close();
        final int i3 = i + 1;
        if (i3 > i2) {
            createBasicLoggingContext(LogLevel.ERROR, streamResponse).addKeyValue(LoggingKeys.TRY_COUNT_KEY, i).log("Retry attempts have been exhausted.", exc);
            return Mono.error(exc);
        }
        long bytesWritten = byteCountingAsynchronousByteChannel.getBytesWritten();
        createBasicLoggingContext(LogLevel.INFORMATIONAL, streamResponse).addKeyValue(LoggingKeys.TRY_COUNT_KEY, i).addKeyValue("maxRetries", i2).addKeyValue("bytesWritten", bytesWritten).log("Attempt failed. Scheduling retry.", exc);
        return ((Mono) biFunction.apply(exc, Long.valueOf(bytesWritten))).flatMap(new Function() { // from class: com.azure.core.util.io.IOUtils$$ExternalSyntheticLambda5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return IOUtils.transferStreamResponseToAsynchronousByteChannelHelper(byteCountingAsynchronousByteChannel, (StreamResponse) obj, biFunction, i2, i3);
            }
        });
    }

    private static int getBufferSize(ReadableByteChannel readableByteChannel) {
        if (!(readableByteChannel instanceof SeekableByteChannel)) {
            return 8192;
        }
        SeekableByteChannel seekableByteChannel = (SeekableByteChannel) readableByteChannel;
        try {
            return getBufferSize(seekableByteChannel.size() - seekableByteChannel.position());
        } catch (IOException unused) {
            return 8192;
        }
    }

    private static LoggingEventBuilder createBasicLoggingContext(LogLevel logLevel, StreamResponse streamResponse) {
        ClientLogger clientLogger = LOGGER;
        LoggingEventBuilder loggingEventBuilderAtLevel = clientLogger.atLevel(logLevel);
        if (clientLogger.canLogAtLevel(logLevel)) {
            String value = streamResponse.getRequest().getHeaders().getValue(HttpHeaderName.X_MS_CLIENT_REQUEST_ID);
            if (value != null) {
                loggingEventBuilderAtLevel.addKeyValue(HttpHeaderName.X_MS_CLIENT_REQUEST_ID.getCaseInsensitiveName(), value);
            }
            String value2 = streamResponse.getRequest().getHeaders().getValue(HttpHeaderName.TRACEPARENT);
            if (value2 != null) {
                loggingEventBuilderAtLevel.addKeyValue(HttpHeaderName.TRACEPARENT.getCaseInsensitiveName(), value2);
            }
        }
        return loggingEventBuilderAtLevel;
    }

    private IOUtils() {
    }
}
