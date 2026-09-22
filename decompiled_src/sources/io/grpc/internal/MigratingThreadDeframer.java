package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.Decompressor;
import io.perfmark.Link;
import io.perfmark.PerfMark;
import io.perfmark.TaskCloseable;
import java.io.Closeable;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
final class MigratingThreadDeframer implements ThreadOptimizedDeframer {
    private final ApplicationThreadDeframerListener appListener;
    private final MessageDeframer deframer;
    private boolean deframerOnTransportThread;
    private boolean messageProducerEnqueued;
    private final MigratingDeframerListener migratingListener;
    private final ApplicationThreadDeframerListener.TransportExecutor transportExecutor;
    private final MessageDeframer.Listener transportListener;
    private final DeframeMessageProducer messageProducer = new DeframeMessageProducer();
    private final Object lock = new Object();
    private final Queue<Op> opQueue = new ArrayDeque();

    private interface Op {
        void run(boolean z);
    }

    public MigratingThreadDeframer(MessageDeframer.Listener listener, ApplicationThreadDeframerListener.TransportExecutor transportExecutor, MessageDeframer messageDeframer) {
        SquelchLateMessagesAvailableDeframerListener squelchLateMessagesAvailableDeframerListener = new SquelchLateMessagesAvailableDeframerListener((MessageDeframer.Listener) Preconditions.checkNotNull(listener, "listener"));
        this.transportListener = squelchLateMessagesAvailableDeframerListener;
        this.transportExecutor = (ApplicationThreadDeframerListener.TransportExecutor) Preconditions.checkNotNull(transportExecutor, "transportExecutor");
        ApplicationThreadDeframerListener applicationThreadDeframerListener = new ApplicationThreadDeframerListener(squelchLateMessagesAvailableDeframerListener, transportExecutor);
        this.appListener = applicationThreadDeframerListener;
        MigratingDeframerListener migratingDeframerListener = new MigratingDeframerListener(applicationThreadDeframerListener);
        this.migratingListener = migratingDeframerListener;
        messageDeframer.setListener(migratingDeframerListener);
        this.deframer = messageDeframer;
    }

    @Override // io.grpc.internal.Deframer
    public void setMaxInboundMessageSize(int i) {
        this.deframer.setMaxInboundMessageSize(i);
    }

    @Override // io.grpc.internal.Deframer
    public void setDecompressor(Decompressor decompressor) {
        this.deframer.setDecompressor(decompressor);
    }

    @Override // io.grpc.internal.Deframer
    public void setFullStreamDecompressor(GzipInflatingBuffer gzipInflatingBuffer) {
        this.deframer.setFullStreamDecompressor(gzipInflatingBuffer);
    }

    private boolean runWhereAppropriate(Op op) {
        return runWhereAppropriate(op, true);
    }

    private boolean runWhereAppropriate(Op op, boolean z) {
        boolean z2;
        boolean z3;
        synchronized (this.lock) {
            z2 = this.deframerOnTransportThread;
            z3 = this.messageProducerEnqueued;
            if (!z2) {
                this.opQueue.offer(op);
                this.messageProducerEnqueued = true;
            }
        }
        if (z2) {
            op.run(true);
            return true;
        }
        if (z3) {
            return false;
        }
        if (z) {
            TaskCloseable taskCloseableTraceTask = PerfMark.traceTask("MigratingThreadDeframer.messageAvailable");
            try {
                this.transportListener.messagesAvailable(this.messageProducer);
                if (taskCloseableTraceTask == null) {
                    return false;
                }
                taskCloseableTraceTask.close();
                return false;
            } catch (Throwable th) {
                if (taskCloseableTraceTask != null) {
                    try {
                        taskCloseableTraceTask.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        final Link linkLinkOut = PerfMark.linkOut();
        this.transportExecutor.runOnTransportThread(new Runnable() { // from class: io.grpc.internal.MigratingThreadDeframer.1
            @Override // java.lang.Runnable
            public void run() {
                TaskCloseable taskCloseableTraceTask2 = PerfMark.traceTask("MigratingThreadDeframer.messageAvailable");
                try {
                    PerfMark.linkIn(linkLinkOut);
                    MigratingThreadDeframer.this.transportListener.messagesAvailable(MigratingThreadDeframer.this.messageProducer);
                    if (taskCloseableTraceTask2 != null) {
                        taskCloseableTraceTask2.close();
                    }
                } catch (Throwable th3) {
                    if (taskCloseableTraceTask2 != null) {
                        try {
                            taskCloseableTraceTask2.close();
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                        }
                    }
                    throw th3;
                }
            }
        });
        return false;
    }

    @Override // io.grpc.internal.ThreadOptimizedDeframer, io.grpc.internal.Deframer
    public void request(final int i) {
        runWhereAppropriate(new Op() { // from class: io.grpc.internal.MigratingThreadDeframer.1RequestOp
            @Override // io.grpc.internal.MigratingThreadDeframer.Op
            public void run(boolean z) {
                if (z) {
                    final Link linkLinkOut = PerfMark.linkOut();
                    MigratingThreadDeframer.this.transportExecutor.runOnTransportThread(new Runnable() { // from class: io.grpc.internal.MigratingThreadDeframer.1RequestOp.1
                        @Override // java.lang.Runnable
                        public void run() {
                            TaskCloseable taskCloseableTraceTask = PerfMark.traceTask("MigratingThreadDeframer.request");
                            try {
                                PerfMark.linkIn(linkLinkOut);
                                MigratingThreadDeframer.this.requestFromTransportThread(i);
                                if (taskCloseableTraceTask != null) {
                                    taskCloseableTraceTask.close();
                                }
                            } catch (Throwable th) {
                                if (taskCloseableTraceTask != null) {
                                    try {
                                        taskCloseableTraceTask.close();
                                    } catch (Throwable th2) {
                                        th.addSuppressed(th2);
                                    }
                                }
                                throw th;
                            }
                        }
                    });
                    return;
                }
                try {
                    TaskCloseable taskCloseableTraceTask = PerfMark.traceTask("MigratingThreadDeframer.request");
                    try {
                        MigratingThreadDeframer.this.deframer.request(i);
                        if (taskCloseableTraceTask != null) {
                            taskCloseableTraceTask.close();
                        }
                    } catch (Throwable th) {
                        if (taskCloseableTraceTask != null) {
                            try {
                                taskCloseableTraceTask.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    MigratingThreadDeframer.this.appListener.deframeFailed(th3);
                    MigratingThreadDeframer.this.deframer.close();
                }
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestFromTransportThread(final int i) {
        runWhereAppropriate(new Op() { // from class: io.grpc.internal.MigratingThreadDeframer.1RequestAgainOp
            @Override // io.grpc.internal.MigratingThreadDeframer.Op
            public void run(boolean z) {
                if (z) {
                    try {
                        MigratingThreadDeframer.this.deframer.request(i);
                    } catch (Throwable th) {
                        MigratingThreadDeframer.this.appListener.deframeFailed(th);
                        MigratingThreadDeframer.this.deframer.close();
                    }
                    if (MigratingThreadDeframer.this.deframer.hasPendingDeliveries()) {
                        return;
                    }
                    synchronized (MigratingThreadDeframer.this.lock) {
                        PerfMark.event("MigratingThreadDeframer.deframerOnApplicationThread");
                        MigratingThreadDeframer.this.migratingListener.setDelegate(MigratingThreadDeframer.this.appListener);
                        MigratingThreadDeframer.this.deframerOnTransportThread = false;
                    }
                    return;
                }
                MigratingThreadDeframer.this.request(i);
            }
        });
    }

    /* JADX INFO: renamed from: io.grpc.internal.MigratingThreadDeframer$1DeframeOp, reason: invalid class name */
    class C1DeframeOp implements Op, Closeable {
        final /* synthetic */ ReadableBuffer val$data;

        C1DeframeOp(ReadableBuffer readableBuffer) {
            this.val$data = readableBuffer;
        }

        @Override // io.grpc.internal.MigratingThreadDeframer.Op
        public void run(boolean z) {
            TaskCloseable taskCloseableTraceTask = PerfMark.traceTask("MigratingThreadDeframer.deframe");
            try {
                if (z) {
                    MigratingThreadDeframer.this.deframer.deframe(this.val$data);
                    if (taskCloseableTraceTask != null) {
                        taskCloseableTraceTask.close();
                        return;
                    }
                    return;
                }
                try {
                    MigratingThreadDeframer.this.deframer.deframe(this.val$data);
                } catch (Throwable th) {
                    MigratingThreadDeframer.this.appListener.deframeFailed(th);
                    MigratingThreadDeframer.this.deframer.close();
                }
                if (taskCloseableTraceTask != null) {
                    taskCloseableTraceTask.close();
                }
            } catch (Throwable th2) {
                if (taskCloseableTraceTask != null) {
                    try {
                        taskCloseableTraceTask.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.val$data.close();
        }
    }

    @Override // io.grpc.internal.Deframer
    public void deframe(ReadableBuffer readableBuffer) {
        runWhereAppropriate(new C1DeframeOp(readableBuffer));
    }

    @Override // io.grpc.internal.Deframer
    public void closeWhenComplete() {
        runWhereAppropriate(new Op() { // from class: io.grpc.internal.MigratingThreadDeframer.1CloseWhenCompleteOp
            @Override // io.grpc.internal.MigratingThreadDeframer.Op
            public void run(boolean z) {
                MigratingThreadDeframer.this.deframer.closeWhenComplete();
            }
        });
    }

    @Override // io.grpc.internal.Deframer
    public void close() {
        if (runWhereAppropriate(new Op() { // from class: io.grpc.internal.MigratingThreadDeframer.1CloseOp
            @Override // io.grpc.internal.MigratingThreadDeframer.Op
            public void run(boolean z) {
                MigratingThreadDeframer.this.deframer.close();
            }
        })) {
            return;
        }
        this.deframer.stopDelivery();
    }

    class DeframeMessageProducer implements StreamListener.MessageProducer, Closeable {
        DeframeMessageProducer() {
        }

        @Override // io.grpc.internal.StreamListener.MessageProducer
        public InputStream next() {
            Op op;
            while (true) {
                InputStream inputStreamMessageReadQueuePoll = MigratingThreadDeframer.this.appListener.messageReadQueuePoll();
                if (inputStreamMessageReadQueuePoll != null) {
                    return inputStreamMessageReadQueuePoll;
                }
                synchronized (MigratingThreadDeframer.this.lock) {
                    op = (Op) MigratingThreadDeframer.this.opQueue.poll();
                    if (op == null) {
                        if (MigratingThreadDeframer.this.deframer.hasPendingDeliveries()) {
                            PerfMark.event("MigratingThreadDeframer.deframerOnTransportThread");
                            MigratingThreadDeframer.this.migratingListener.setDelegate(MigratingThreadDeframer.this.transportListener);
                            MigratingThreadDeframer.this.deframerOnTransportThread = true;
                        }
                        MigratingThreadDeframer.this.messageProducerEnqueued = false;
                        return null;
                    }
                }
                op.run(false);
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Op op;
            while (true) {
                synchronized (MigratingThreadDeframer.this.lock) {
                    do {
                        op = (Op) MigratingThreadDeframer.this.opQueue.poll();
                        if (op == null) {
                            break;
                        }
                    } while (!(op instanceof Closeable));
                    if (op == null) {
                        MigratingThreadDeframer.this.messageProducerEnqueued = false;
                        return;
                    }
                }
                GrpcUtil.closeQuietly((Closeable) op);
            }
        }
    }

    static class MigratingDeframerListener extends ForwardingDeframerListener {
        private MessageDeframer.Listener delegate;

        public MigratingDeframerListener(MessageDeframer.Listener listener) {
            setDelegate(listener);
        }

        @Override // io.grpc.internal.ForwardingDeframerListener
        protected MessageDeframer.Listener delegate() {
            return this.delegate;
        }

        public void setDelegate(MessageDeframer.Listener listener) {
            this.delegate = (MessageDeframer.Listener) Preconditions.checkNotNull(listener, "delegate");
        }
    }
}
