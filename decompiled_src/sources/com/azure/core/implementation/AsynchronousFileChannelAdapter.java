package com.azure.core.implementation;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$;
import com.azure.core.util.logging.ClientLogger;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousByteChannel;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.ReadPendingException;
import java.nio.channels.WritePendingException;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class AsynchronousFileChannelAdapter implements AsynchronousByteChannel {
    private final AsynchronousFileChannel fileChannel;
    private volatile Operation pendingOperation = null;
    private volatile long position;
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) AsynchronousFileChannelAdapter.class);
    private static final AtomicLongFieldUpdater<AsynchronousFileChannelAdapter> POSITION_ATOMIC_UPDATER = AtomicLongFieldUpdater.newUpdater(AsynchronousFileChannelAdapter.class, "position");
    private static final AtomicReferenceFieldUpdater<AsynchronousFileChannelAdapter, Operation> PENDING_OPERATION_ATOMIC_UPDATER = AtomicReferenceFieldUpdater.newUpdater(AsynchronousFileChannelAdapter.class, Operation.class, "pendingOperation");

    private enum Operation {
        READ,
        WRITE
    }

    public AsynchronousFileChannelAdapter(AsynchronousFileChannel asynchronousFileChannel, long j) {
        this.fileChannel = (AsynchronousFileChannel) Objects.requireNonNull(asynchronousFileChannel);
        this.position = j;
    }

    @Override // java.nio.channels.AsynchronousByteChannel
    public <A> void read(ByteBuffer byteBuffer, A a, CompletionHandler<Integer, ? super A> completionHandler) {
        beginOperation(Operation.READ);
        this.fileChannel.read(byteBuffer, POSITION_ATOMIC_UPDATER.get(this), a, new DelegatingCompletionHandler(completionHandler, Operation.READ));
    }

    @Override // java.nio.channels.AsynchronousByteChannel
    public Future<Integer> read(ByteBuffer byteBuffer) {
        beginOperation(Operation.READ);
        CompletableFuture completableFuture = new CompletableFuture();
        this.fileChannel.read(byteBuffer, POSITION_ATOMIC_UPDATER.get(this), byteBuffer, new DelegatingCompletionHandler(completableFuture, Operation.READ));
        return completableFuture;
    }

    @Override // java.nio.channels.AsynchronousByteChannel
    public <A> void write(ByteBuffer byteBuffer, A a, CompletionHandler<Integer, ? super A> completionHandler) {
        beginOperation(Operation.WRITE);
        this.fileChannel.write(byteBuffer, POSITION_ATOMIC_UPDATER.get(this), a, new DelegatingCompletionHandler(completionHandler, Operation.WRITE));
    }

    @Override // java.nio.channels.AsynchronousByteChannel
    public Future<Integer> write(ByteBuffer byteBuffer) {
        beginOperation(Operation.WRITE);
        CompletableFuture completableFuture = new CompletableFuture();
        this.fileChannel.write(byteBuffer, POSITION_ATOMIC_UPDATER.get(this), byteBuffer, new DelegatingCompletionHandler(completableFuture, Operation.WRITE));
        return completableFuture;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.fileChannel.isOpen();
    }

    @Override // java.nio.channels.AsynchronousChannel, java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.fileChannel.close();
    }

    private void beginOperation(Operation operation) {
        AtomicReferenceFieldUpdater<AsynchronousFileChannelAdapter, Operation> atomicReferenceFieldUpdater = PENDING_OPERATION_ATOMIC_UPDATER;
        if (AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, this, (Object) null, operation)) {
            return;
        }
        int iOrdinal = atomicReferenceFieldUpdater.get(this).ordinal();
        if (iOrdinal == 0) {
            throw LOGGER.logExceptionAsError(new ReadPendingException());
        }
        if (iOrdinal == 1) {
            throw LOGGER.logExceptionAsError(new WritePendingException());
        }
        throw LOGGER.logExceptionAsError(new IllegalStateException("Unknown channel operation"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void endOperation(Operation operation) {
        if (!AbstractResolvableFuture$SafeAtomicHelper$.ExternalSyntheticBackportWithForwarding0.m(PENDING_OPERATION_ATOMIC_UPDATER, this, operation, (Object) null)) {
            throw LOGGER.logExceptionAsError(new IllegalStateException("There's no pending " + operation));
        }
    }

    private final class DelegatingCompletionHandler<T> implements CompletionHandler<Integer, T> {
        private final CompletableFuture<Integer> future;
        private final CompletionHandler<Integer, ? super T> handler;
        private final Operation operation;

        private DelegatingCompletionHandler(CompletionHandler<Integer, ? super T> completionHandler, Operation operation) {
            this.handler = completionHandler;
            this.future = null;
            this.operation = operation;
        }

        private DelegatingCompletionHandler(CompletableFuture<Integer> completableFuture, Operation operation) {
            this.handler = null;
            this.future = completableFuture;
            this.operation = operation;
        }

        @Override // java.nio.channels.CompletionHandler
        public void completed(Integer num, T t) {
            if (num.intValue() > 0) {
                AsynchronousFileChannelAdapter.POSITION_ATOMIC_UPDATER.addAndGet(AsynchronousFileChannelAdapter.this, num.intValue());
            }
            AsynchronousFileChannelAdapter.this.endOperation(this.operation);
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
            AsynchronousFileChannelAdapter.this.endOperation(this.operation);
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
