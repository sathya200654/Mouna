package com.azure.core.util;

import com.azure.core.http.HttpHeaderName;
import com.azure.core.http.HttpHeaders;
import com.azure.core.http.policy.ExponentialBackoffOptions;
import com.azure.core.http.policy.RetryOptions;
import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.Response;
import com.azure.core.implementation.AsynchronousByteChannelWriteSubscriber;
import com.azure.core.implementation.ByteBufferCollector;
import com.azure.core.implementation.ImplUtils;
import com.azure.core.implementation.OutputStreamWriteSubscriber;
import com.azure.core.implementation.RetriableDownloadFlux;
import com.azure.core.implementation.TypeUtil;
import com.azure.core.util.io.IOUtils;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.logging.LoggingEventBuilder;
import com.google.protobuf.Reader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousByteChannel;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.CoreSubscriber;
import reactor.core.Exceptions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoSink;
import reactor.core.publisher.Operators;
import reactor.core.publisher.SynchronousSink;
import reactor.core.scheduler.Schedulers;
import reactor.util.context.ContextView;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class FluxUtil {
    private static final int DEFAULT_CHUNK_SIZE = 65536;
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) FluxUtil.class);

    static /* synthetic */ FileChannel lambda$toFluxByteBuffer$3(FileChannel fileChannel) throws Exception {
        return fileChannel;
    }

    static /* synthetic */ InputStream lambda$toFluxByteBuffer$5(InputStream inputStream) throws Exception {
        return inputStream;
    }

    public static boolean isFluxByteBuffer(Type type) {
        if (TypeUtil.isTypeOrSubTypeOf(type, Flux.class)) {
            return TypeUtil.isTypeOrSubTypeOf(TypeUtil.getTypeArguments(type)[0], ByteBuffer.class);
        }
        return false;
    }

    public static Flux<ByteBuffer> addProgressReporting(final Flux<ByteBuffer> flux, ProgressReporter progressReporter) {
        return progressReporter == null ? flux : Mono.just(progressReporter).flatMapMany(new Function() { // from class: com.azure.core.util.FluxUtil$$ExternalSyntheticLambda13
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return FluxUtil.lambda$addProgressReporting$1(flux, (ProgressReporter) obj);
            }
        });
    }

    static /* synthetic */ Publisher lambda$addProgressReporting$1(Flux flux, final ProgressReporter progressReporter) {
        progressReporter.reset();
        return flux.doOnNext(new Consumer() { // from class: com.azure.core.util.FluxUtil$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                progressReporter.reportProgress(((ByteBuffer) obj).remaining());
            }
        });
    }

    public static Mono<byte[]> collectBytesInByteBufferStream(Flux<ByteBuffer> flux) {
        return flux.collect(new Supplier() { // from class: com.azure.core.util.FluxUtil$$ExternalSyntheticLambda3
            @Override // java.util.function.Supplier
            public final Object get() {
                return new ByteBufferCollector();
            }
        }, new FluxUtil$$ExternalSyntheticLambda4()).map(new FluxUtil$$ExternalSyntheticLambda5());
    }

    public static Mono<byte[]> collectBytesInByteBufferStream(Flux<ByteBuffer> flux, final int i) {
        return flux.collect(new Supplier() { // from class: com.azure.core.util.FluxUtil$$ExternalSyntheticLambda12
            @Override // java.util.function.Supplier
            public final Object get() {
                return FluxUtil.lambda$collectBytesInByteBufferStream$2(i);
            }
        }, new FluxUtil$$ExternalSyntheticLambda4()).map(new FluxUtil$$ExternalSyntheticLambda5());
    }

    static /* synthetic */ ByteBufferCollector lambda$collectBytesInByteBufferStream$2(int i) {
        return new ByteBufferCollector(i);
    }

    public static Mono<byte[]> collectBytesFromNetworkResponse(Flux<ByteBuffer> flux, HttpHeaders httpHeaders) {
        Objects.requireNonNull(httpHeaders, "'headers' cannot be null.");
        String value = httpHeaders.getValue(HttpHeaderName.CONTENT_LENGTH);
        if (value == null) {
            return collectBytesInByteBufferStream(flux);
        }
        try {
            int i = Integer.parseInt(value);
            if (i > 0) {
                return collectBytesInByteBufferStream(flux, i);
            }
            return Mono.just(EMPTY_BYTE_ARRAY);
        } catch (NumberFormatException unused) {
            return collectBytesInByteBufferStream(flux);
        }
    }

    public static byte[] byteBufferToArray(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return bArr;
    }

    public static Flux<ByteBuffer> createRetriableDownloadFlux(Supplier<Flux<ByteBuffer>> supplier, BiFunction<Throwable, Long, Flux<ByteBuffer>> biFunction, int i) {
        return createRetriableDownloadFlux(supplier, biFunction, createDefaultRetryOptions(i), 0L);
    }

    public static Flux<ByteBuffer> createRetriableDownloadFlux(Supplier<Flux<ByteBuffer>> supplier, BiFunction<Throwable, Long, Flux<ByteBuffer>> biFunction, int i, long j) {
        return createRetriableDownloadFlux(supplier, biFunction, createDefaultRetryOptions(i), j);
    }

    private static RetryOptions createDefaultRetryOptions(int i) {
        return new RetryOptions(new ExponentialBackoffOptions().setMaxRetries(Integer.valueOf(Math.max(0, i))));
    }

    public static Flux<ByteBuffer> createRetriableDownloadFlux(Supplier<Flux<ByteBuffer>> supplier, BiFunction<Throwable, Long, Flux<ByteBuffer>> biFunction, RetryOptions retryOptions, long j) {
        if (retryOptions == null) {
            retryOptions = new RetryOptions(new ExponentialBackoffOptions());
        }
        return new RetriableDownloadFlux(supplier, biFunction, retryOptions, j);
    }

    public static Flux<ByteBuffer> toFluxByteBuffer(InputStream inputStream) {
        return toFluxByteBuffer(inputStream, 4096);
    }

    public static Flux<ByteBuffer> toFluxByteBuffer(final InputStream inputStream, final int i) {
        if (i <= 0) {
            return Flux.error(new IllegalArgumentException("'chunkSize' must be greater than 0."));
        }
        if (inputStream == null) {
            return Flux.empty();
        }
        if ((inputStream instanceof FileInputStream) && !System.getProperty("os.name").contains("Windows")) {
            final FileChannel channel = ((FileInputStream) inputStream).getChannel();
            return Flux.generate(new Callable() { // from class: com.azure.core.util.FluxUtil$$ExternalSyntheticLambda18
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return FluxUtil.lambda$toFluxByteBuffer$3(channel);
                }
            }, new BiFunction() { // from class: com.azure.core.util.FluxUtil$$ExternalSyntheticLambda19
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return FluxUtil.lambda$toFluxByteBuffer$4(i, (FileChannel) obj, (SynchronousSink) obj2);
                }
            });
        }
        return Flux.generate(new Callable() { // from class: com.azure.core.util.FluxUtil$$ExternalSyntheticLambda20
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return FluxUtil.lambda$toFluxByteBuffer$5(inputStream);
            }
        }, new BiFunction() { // from class: com.azure.core.util.FluxUtil$$ExternalSyntheticLambda1
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return FluxUtil.lambda$toFluxByteBuffer$6(i, inputStream, (InputStream) obj, (SynchronousSink) obj2);
            }
        }).filter(new Predicate() { // from class: com.azure.core.util.FluxUtil$$ExternalSyntheticLambda2
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((ByteBuffer) obj).hasRemaining();
            }
        });
    }

    static /* synthetic */ FileChannel lambda$toFluxByteBuffer$4(int i, FileChannel fileChannel, SynchronousSink synchronousSink) {
        FileChannel fileChannel2;
        IOException iOException;
        try {
            long jPosition = fileChannel.position();
            long size = fileChannel.size();
            if (jPosition == size) {
                try {
                    fileChannel.close();
                    synchronousSink.complete();
                    return fileChannel;
                } catch (IOException e) {
                    iOException = e;
                    fileChannel2 = fileChannel;
                }
            } else {
                long jMin = (int) Math.min(i, size - jPosition);
                fileChannel2 = fileChannel;
                try {
                    synchronousSink.next(fileChannel2.map(FileChannel.MapMode.READ_ONLY, jPosition, jMin));
                    fileChannel2.position(jPosition + jMin);
                    return fileChannel2;
                } catch (IOException e2) {
                    e = e2;
                }
            }
        } catch (IOException e3) {
            e = e3;
            fileChannel2 = fileChannel;
        }
        iOException = e;
        synchronousSink.error(iOException);
        return fileChannel2;
    }

    static /* synthetic */ InputStream lambda$toFluxByteBuffer$6(int i, InputStream inputStream, InputStream inputStream2, SynchronousSink synchronousSink) {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            try {
                int i3 = inputStream.read(bArr, i2, i - i2);
                if (i3 == -1) {
                    if (i2 > 0) {
                        synchronousSink.next(ByteBuffer.wrap(bArr, 0, i2));
                    }
                    synchronousSink.complete();
                    return inputStream2;
                }
                i2 += i3;
            } catch (IOException e) {
                synchronousSink.error(e);
                return inputStream2;
            }
        }
        synchronousSink.next(ByteBuffer.wrap(bArr));
        return inputStream2;
    }

    public static <T> Mono<T> withContext(Function<Context, Mono<T>> function) {
        return withContext(function, Collections.emptyMap());
    }

    public static <T> Mono<T> withContext(final Function<Context, Mono<T>> function, final Map<String, String> map) {
        return Mono.deferContextual(new Function() { // from class: com.azure.core.util.FluxUtil$$ExternalSyntheticLambda8
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return FluxUtil.lambda$withContext$9(map, function, (ContextView) obj);
            }
        });
    }

    static /* synthetic */ Mono lambda$withContext$9(Map map, Function function, ContextView contextView) {
        final Context[] contextArr = {Context.NONE};
        if (!CoreUtils.isNullOrEmpty((Map<?, ?>) map)) {
            map.forEach(new BiConsumer() { // from class: com.azure.core.util.FluxUtil$$ExternalSyntheticLambda15
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    FluxUtil.lambda$withContext$7(contextArr, (String) obj, (String) obj2);
                }
            });
        }
        if (!contextView.isEmpty()) {
            contextView.stream().forEach(new Consumer() { // from class: com.azure.core.util.FluxUtil$$ExternalSyntheticLambda16
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    FluxUtil.lambda$withContext$8(contextArr, (Map.Entry) obj);
                }
            });
        }
        return (Mono) function.apply(contextArr[0]);
    }

    static /* synthetic */ void lambda$withContext$7(Context[] contextArr, String str, String str2) {
        contextArr[0] = contextArr[0].addData(str, str2);
    }

    static /* synthetic */ void lambda$withContext$8(Context[] contextArr, Map.Entry entry) {
        contextArr[0] = contextArr[0].addData(entry.getKey(), entry.getValue());
    }

    public static <T> Mono<T> toMono(Response<T> response) {
        return Mono.justOrEmpty(response.getValue());
    }

    public static <T> Mono<T> monoError(ClientLogger clientLogger, RuntimeException runtimeException) {
        return Mono.error(clientLogger.logExceptionAsError(Exceptions.propagate(runtimeException)));
    }

    public static <T> Mono<T> monoError(LoggingEventBuilder loggingEventBuilder, RuntimeException runtimeException) {
        return Mono.error(loggingEventBuilder.log(Exceptions.propagate(runtimeException)));
    }

    public static <T> Flux<T> fluxError(ClientLogger clientLogger, RuntimeException runtimeException) {
        return Flux.error(clientLogger.logExceptionAsError(Exceptions.propagate(runtimeException)));
    }

    public static <T> PagedFlux<T> pagedFluxError(final ClientLogger clientLogger, final RuntimeException runtimeException) {
        return new PagedFlux<>(new Supplier() { // from class: com.azure.core.util.FluxUtil$$ExternalSyntheticLambda10
            @Override // java.util.function.Supplier
            public final Object get() {
                return FluxUtil.monoError(clientLogger, runtimeException);
            }
        });
    }

    public static <T> Flux<T> fluxContext(final Function<Context, Flux<T>> function) {
        return Flux.deferContextual(new Function() { // from class: com.azure.core.util.FluxUtil$$ExternalSyntheticLambda14
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return FluxUtil.lambda$fluxContext$11(function, (ContextView) obj);
            }
        });
    }

    static /* synthetic */ Publisher lambda$fluxContext$11(Function function, ContextView contextView) {
        return (Publisher) function.apply(toAzureContext(contextView));
    }

    private static Context toAzureContext(ContextView contextView) {
        final Context[] contextArr = {Context.NONE};
        if (!contextView.isEmpty()) {
            contextView.stream().forEach(new Consumer() { // from class: com.azure.core.util.FluxUtil$$ExternalSyntheticLambda17
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    FluxUtil.lambda$toAzureContext$12(contextArr, (Map.Entry) obj);
                }
            });
        }
        return contextArr[0];
    }

    static /* synthetic */ void lambda$toAzureContext$12(Context[] contextArr, Map.Entry entry) {
        contextArr[0] = contextArr[0].addData(entry.getKey(), entry.getValue());
    }

    public static reactor.util.context.Context toReactorContext(Context context) {
        if (context == null) {
            return reactor.util.context.Context.empty();
        }
        reactor.util.context.Context contextEmpty = reactor.util.context.Context.empty();
        for (Context context2 : context.getContextChain()) {
            if (context2 != null && context2.getValue() != null) {
                contextEmpty = contextEmpty.put(context2.getKey(), context2.getValue());
            }
        }
        return contextEmpty;
    }

    public static Mono<Void> writeToOutputStream(final Flux<ByteBuffer> flux, final OutputStream outputStream) {
        if (flux == null && outputStream == null) {
            return monoError(LOGGER, new NullPointerException("'content' and 'stream' cannot be null."));
        }
        if (flux == null) {
            return monoError(LOGGER, new NullPointerException("'content' cannot be null."));
        }
        if (outputStream == null) {
            return monoError(LOGGER, new NullPointerException("'stream' cannot be null."));
        }
        return Mono.create(new Consumer() { // from class: com.azure.core.util.FluxUtil$$ExternalSyntheticLambda9
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                flux.subscribe(new OutputStreamWriteSubscriber((MonoSink) obj, outputStream, FluxUtil.LOGGER));
            }
        });
    }

    public static Mono<Void> writeFile(Flux<ByteBuffer> flux, AsynchronousFileChannel asynchronousFileChannel) {
        return writeFile(flux, asynchronousFileChannel, 0L);
    }

    public static Mono<Void> writeFile(final Flux<ByteBuffer> flux, final AsynchronousFileChannel asynchronousFileChannel, final long j) {
        if (flux == null && asynchronousFileChannel == null) {
            return monoError(LOGGER, new NullPointerException("'content' and 'outFile' cannot be null."));
        }
        if (flux == null) {
            return monoError(LOGGER, new NullPointerException("'content' cannot be null."));
        }
        if (asynchronousFileChannel == null) {
            return monoError(LOGGER, new NullPointerException("'outFile' cannot be null."));
        }
        if (j < 0) {
            return monoError(LOGGER, new IllegalArgumentException("'position' cannot be less than 0."));
        }
        return Mono.create(new Consumer() { // from class: com.azure.core.util.FluxUtil$$ExternalSyntheticLambda7
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                flux.subscribe(new AsynchronousByteChannelWriteSubscriber(IOUtils.toAsynchronousByteChannel(asynchronousFileChannel, j), (MonoSink) obj));
            }
        });
    }

    public static Mono<Void> writeToAsynchronousByteChannel(final Flux<ByteBuffer> flux, final AsynchronousByteChannel asynchronousByteChannel) {
        if (flux == null && asynchronousByteChannel == null) {
            return monoError(LOGGER, new NullPointerException("'content' and 'channel' cannot be null."));
        }
        if (flux == null) {
            return monoError(LOGGER, new NullPointerException("'content' cannot be null."));
        }
        if (asynchronousByteChannel == null) {
            return monoError(LOGGER, new NullPointerException("'channel' cannot be null."));
        }
        return Mono.create(new Consumer() { // from class: com.azure.core.util.FluxUtil$$ExternalSyntheticLambda11
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                flux.subscribe(new AsynchronousByteChannelWriteSubscriber(asynchronousByteChannel, (MonoSink) obj));
            }
        });
    }

    public static Mono<Void> writeToWritableByteChannel(Flux<ByteBuffer> flux, final WritableByteChannel writableByteChannel) {
        if (flux == null && writableByteChannel == null) {
            return monoError(LOGGER, new NullPointerException("'content' and 'channel' cannot be null."));
        }
        if (flux == null) {
            return monoError(LOGGER, new NullPointerException("'content' cannot be null."));
        }
        if (writableByteChannel == null) {
            return monoError(LOGGER, new NullPointerException("'channel' cannot be null."));
        }
        return flux.publishOn(Schedulers.boundedElastic()).map(new Function() { // from class: com.azure.core.util.FluxUtil$$ExternalSyntheticLambda6
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return FluxUtil.lambda$writeToWritableByteChannel$16(writableByteChannel, (ByteBuffer) obj);
            }
        }).then();
    }

    static /* synthetic */ ByteBuffer lambda$writeToWritableByteChannel$16(WritableByteChannel writableByteChannel, ByteBuffer byteBuffer) {
        try {
            ImplUtils.fullyWriteBuffer(byteBuffer, writableByteChannel);
            return byteBuffer;
        } catch (IOException e) {
            throw Exceptions.propagate(e);
        }
    }

    public static Flux<ByteBuffer> readFile(AsynchronousFileChannel asynchronousFileChannel, int i, long j, long j2) {
        return new FileReadFlux(asynchronousFileChannel, i, j, j2);
    }

    public static Flux<ByteBuffer> readFile(AsynchronousFileChannel asynchronousFileChannel, long j, long j2) {
        return readFile(asynchronousFileChannel, 65536, j, j2);
    }

    public static Flux<ByteBuffer> readFile(AsynchronousFileChannel asynchronousFileChannel) {
        try {
            return readFile(asynchronousFileChannel, 65536, 0L, asynchronousFileChannel.size());
        } catch (IOException e) {
            return Flux.error(new RuntimeException("Failed to read the file.", e));
        }
    }

    private static final class FileReadFlux extends Flux<ByteBuffer> {
        private final int chunkSize;
        private final AsynchronousFileChannel fileChannel;
        private final long length;
        private final long offset;

        FileReadFlux(AsynchronousFileChannel asynchronousFileChannel, int i, long j, long j2) {
            this.fileChannel = asynchronousFileChannel;
            this.chunkSize = i;
            this.offset = j;
            this.length = j2;
        }

        public void subscribe(CoreSubscriber<? super ByteBuffer> coreSubscriber) {
            coreSubscriber.onSubscribe(new FileReadSubscription(coreSubscriber, this.fileChannel, this.chunkSize, this.offset, this.length));
        }

        static final class FileReadSubscription implements Subscription, CompletionHandler<Integer, ByteBuffer> {
            private static final int NOT_SET = -1;
            private static final long serialVersionUID = -6831808726875304256L;
            private volatile boolean cancelled;
            private final int chunkSize;
            private volatile boolean done;
            private Throwable error;
            private final AsynchronousFileChannel fileChannel;
            private final long length;
            private volatile ByteBuffer next;
            private final long offset;
            private volatile long position = -1;
            volatile long requested;
            private final Subscriber<? super ByteBuffer> subscriber;
            volatile int wip;
            static final AtomicIntegerFieldUpdater<FileReadSubscription> WIP = AtomicIntegerFieldUpdater.newUpdater(FileReadSubscription.class, "wip");
            static final AtomicLongFieldUpdater<FileReadSubscription> REQUESTED = AtomicLongFieldUpdater.newUpdater(FileReadSubscription.class, "requested");

            FileReadSubscription(Subscriber<? super ByteBuffer> subscriber, AsynchronousFileChannel asynchronousFileChannel, int i, long j, long j2) {
                this.subscriber = subscriber;
                this.fileChannel = asynchronousFileChannel;
                this.chunkSize = i;
                this.offset = j;
                this.length = j2;
            }

            public void request(long j) {
                if (Operators.validate(j)) {
                    Operators.addCap(REQUESTED, this, j);
                    drain();
                }
            }

            public void cancel() {
                this.cancelled = true;
            }

            @Override // java.nio.channels.CompletionHandler
            public void completed(Integer num, ByteBuffer byteBuffer) {
                if (this.cancelled) {
                    return;
                }
                if (num.intValue() == -1) {
                    this.done = true;
                } else {
                    long j = this.position;
                    int iMin = Math.min(num.intValue(), maxRequired(j));
                    long j2 = j + ((long) iMin);
                    this.position = j2;
                    byteBuffer.position(iMin);
                    byteBuffer.flip();
                    this.next = byteBuffer;
                    if (j2 >= this.offset + this.length) {
                        this.done = true;
                    }
                }
                drain();
            }

            @Override // java.nio.channels.CompletionHandler
            public void failed(Throwable th, ByteBuffer byteBuffer) {
                if (this.cancelled) {
                    return;
                }
                this.error = th;
                this.done = true;
                drain();
            }

            private void drain() {
                boolean z;
                if (WIP.getAndIncrement(this) != 0) {
                    return;
                }
                if (this.position == -1) {
                    this.position = this.offset;
                    doRead();
                }
                int iAddAndGet = 1;
                while (!this.cancelled) {
                    AtomicLongFieldUpdater<FileReadSubscription> atomicLongFieldUpdater = REQUESTED;
                    if (atomicLongFieldUpdater.get(this) > 0) {
                        boolean z2 = this.done;
                        ByteBuffer byteBuffer = this.next;
                        if (byteBuffer != null) {
                            this.next = null;
                            this.subscriber.onNext(byteBuffer);
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z2) {
                            Throwable th = this.error;
                            if (th != null) {
                                this.subscriber.onError(th);
                                return;
                            } else {
                                this.subscriber.onComplete();
                                return;
                            }
                        }
                        if (z) {
                            Operators.produced(atomicLongFieldUpdater, this, 1L);
                            doRead();
                        }
                    }
                    iAddAndGet = WIP.addAndGet(this, -iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }

            private void doRead() {
                long j = this.position;
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(Math.min(this.chunkSize, maxRequired(j)));
                this.fileChannel.read(byteBufferAllocate, j, byteBufferAllocate, this);
            }

            private int maxRequired(long j) {
                long j2 = (this.offset + this.length) - j;
                if (j2 <= 0) {
                    return 0;
                }
                int i = (int) j2;
                return i < 0 ? Reader.READ_DONE : i;
            }
        }
    }

    private FluxUtil() {
    }
}
