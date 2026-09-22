package com.azure.core.util;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ProgressReporter {
    private static final AtomicLongFieldUpdater<ProgressReporter> PROGRESS_ATOMIC_UPDATER = AtomicLongFieldUpdater.newUpdater(ProgressReporter.class, "progress");
    private final Lock listenerLock;
    private final ProgressReporter parent;
    private volatile long progress;
    private final ProgressListener progressListener;

    private ProgressReporter(ProgressListener progressListener) {
        this.progressListener = (ProgressListener) Objects.requireNonNull(progressListener, "'progressListener' must not be null");
        this.listenerLock = new ReentrantLock();
        this.parent = null;
    }

    private ProgressReporter(ProgressReporter progressReporter) {
        this.parent = (ProgressReporter) Objects.requireNonNull(progressReporter, "'parent' must not be null");
        this.progressListener = null;
        this.listenerLock = null;
    }

    public static ProgressReporter withProgressListener(ProgressListener progressListener) {
        return new ProgressReporter(progressListener);
    }

    public ProgressReporter createChild() {
        return new ProgressReporter(this);
    }

    public void reset() {
        try {
            Lock lock = this.listenerLock;
            if (lock != null) {
                lock.lock();
            }
            long andSet = PROGRESS_ATOMIC_UPDATER.getAndSet(this, 0L);
            ProgressReporter progressReporter = this.parent;
            if (progressReporter != null) {
                progressReporter.reportProgress(andSet * (-1));
            }
            ProgressListener progressListener = this.progressListener;
            if (progressListener != null) {
                progressListener.handleProgress(0L);
            }
        } finally {
            Lock lock2 = this.listenerLock;
            if (lock2 != null) {
                lock2.unlock();
            }
        }
    }

    public void reportProgress(long j) {
        try {
            Lock lock = this.listenerLock;
            if (lock != null) {
                lock.lock();
            }
            long jAddAndGet = PROGRESS_ATOMIC_UPDATER.addAndGet(this, j);
            ProgressReporter progressReporter = this.parent;
            if (progressReporter != null) {
                progressReporter.reportProgress(j);
            }
            ProgressListener progressListener = this.progressListener;
            if (progressListener != null) {
                progressListener.handleProgress(jAddAndGet);
            }
        } finally {
            Lock lock2 = this.listenerLock;
            if (lock2 != null) {
                lock2.unlock();
            }
        }
    }
}
