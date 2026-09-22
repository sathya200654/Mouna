package com.azure.core.implementation;

import com.azure.core.util.ProgressReporter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousByteChannel;
import java.nio.channels.CompletionHandler;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class ByteCountingAsynchronousByteChannel implements AsynchronousByteChannel {
    private volatile long bytesRead;
    private volatile long bytesWritten;
    private final AsynchronousByteChannel channel;
    private final ProgressReporter readProgressReporter;
    private final ProgressReporter writeProgressReporter;
    private static final AtomicLongFieldUpdater<ByteCountingAsynchronousByteChannel> BYTES_WRITTEN_ATOMIC_UPDATER = AtomicLongFieldUpdater.newUpdater(ByteCountingAsynchronousByteChannel.class, "bytesWritten");
    private static final AtomicLongFieldUpdater<ByteCountingAsynchronousByteChannel> BYTES_READ_ATOMIC_UPDATER = AtomicLongFieldUpdater.newUpdater(ByteCountingAsynchronousByteChannel.class, "bytesRead");

    public ByteCountingAsynchronousByteChannel(AsynchronousByteChannel asynchronousByteChannel, ProgressReporter progressReporter, ProgressReporter progressReporter2) {
        this.channel = (AsynchronousByteChannel) Objects.requireNonNull(asynchronousByteChannel, "'channel' must not be null");
        this.readProgressReporter = progressReporter;
        this.writeProgressReporter = progressReporter2;
    }

    @Override // java.nio.channels.AsynchronousByteChannel
    public <A> void read(ByteBuffer byteBuffer, A a, CompletionHandler<Integer, ? super A> completionHandler) {
        this.channel.read(byteBuffer, a, new DelegatingCompletionHandler(completionHandler, BYTES_READ_ATOMIC_UPDATER, this.readProgressReporter));
    }

    @Override // java.nio.channels.AsynchronousByteChannel
    public Future<Integer> read(ByteBuffer byteBuffer) {
        CompletableFuture completableFuture = new CompletableFuture();
        this.channel.read(byteBuffer, byteBuffer, new DelegatingCompletionHandler(completableFuture, BYTES_READ_ATOMIC_UPDATER, this.readProgressReporter));
        return completableFuture;
    }

    @Override // java.nio.channels.AsynchronousByteChannel
    public <A> void write(ByteBuffer byteBuffer, A a, CompletionHandler<Integer, ? super A> completionHandler) {
        this.channel.write(byteBuffer, a, new DelegatingCompletionHandler(completionHandler, BYTES_WRITTEN_ATOMIC_UPDATER, this.writeProgressReporter));
    }

    @Override // java.nio.channels.AsynchronousByteChannel
    public Future<Integer> write(ByteBuffer byteBuffer) {
        CompletableFuture completableFuture = new CompletableFuture();
        this.channel.write(byteBuffer, byteBuffer, new DelegatingCompletionHandler(completableFuture, BYTES_WRITTEN_ATOMIC_UPDATER, this.writeProgressReporter));
        return completableFuture;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.channel.isOpen();
    }

    @Override // java.nio.channels.AsynchronousChannel, java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.channel.close();
    }

    public long getBytesWritten() {
        return BYTES_WRITTEN_ATOMIC_UPDATER.get(this);
    }

    public long getBytesRead() {
        return BYTES_READ_ATOMIC_UPDATER.get(this);
    }

    private final class DelegatingCompletionHandler<T> implements CompletionHandler<Integer, T> {
        private final AtomicLongFieldUpdater<ByteCountingAsynchronousByteChannel> atomicLongFieldUpdater;
        private final CompletableFuture<Integer> future;
        private final CompletionHandler<Integer, ? super T> handler;
        private final ProgressReporter progressReporter;

        private DelegatingCompletionHandler(CompletionHandler<Integer, ? super T> completionHandler, AtomicLongFieldUpdater<ByteCountingAsynchronousByteChannel> atomicLongFieldUpdater, ProgressReporter progressReporter) {
            this.handler = completionHandler;
            this.future = null;
            this.atomicLongFieldUpdater = atomicLongFieldUpdater;
            this.progressReporter = progressReporter;
        }

        private DelegatingCompletionHandler(CompletableFuture<Integer> completableFuture, AtomicLongFieldUpdater<ByteCountingAsynchronousByteChannel> atomicLongFieldUpdater, ProgressReporter progressReporter) {
            this.handler = null;
            this.future = completableFuture;
            this.atomicLongFieldUpdater = atomicLongFieldUpdater;
            this.progressReporter = progressReporter;
        }

        @Override // java.nio.channels.CompletionHandler
        public void completed(Integer num, T t) {
            if (num.intValue() > 0) {
                this.atomicLongFieldUpdater.addAndGet(ByteCountingAsynchronousByteChannel.this, num.intValue());
                ProgressReporter progressReporter = this.progressReporter;
                if (progressReporter != null) {
                    progressReporter.reportProgress(num.intValue());
                }
            }
            CompletionHandler<Integer, ? super T> completionHandler = this.handler;
            if (completionHandler != null) {
                completionHandler.completed(num, t);
                return;
            }
            CompletableFuture<Integer> completableFuture = this.future;
            if (completableFuture != null) {
                completableFuture.complete(num);
            }
        }

        @Override // java.nio.channels.CompletionHandler
        public void failed(Throwable th, T t) {
            CompletionHandler<Integer, ? super T> completionHandler = this.handler;
            if (completionHandler != null) {
                completionHandler.failed(th, t);
                return;
            }
            CompletableFuture<Integer> completableFuture = this.future;
            if (completableFuture != null) {
                completableFuture.completeExceptionally(th);
            }
        }
    }
}
