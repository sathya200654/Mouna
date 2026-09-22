package io.reactivex.internal.observers;

import io.reactivex.internal.fuseable.QueueDisposable;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public abstract class BasicQueueDisposable<T> implements QueueDisposable<T> {
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called");
    }

    public final boolean offer(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
