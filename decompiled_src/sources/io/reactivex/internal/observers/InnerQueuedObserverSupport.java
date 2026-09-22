package io.reactivex.internal.observers;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface InnerQueuedObserverSupport<T> {
    void drain();

    void innerComplete(InnerQueuedObserver<T> innerQueuedObserver);

    void innerError(InnerQueuedObserver<T> innerQueuedObserver, Throwable th);

    void innerNext(InnerQueuedObserver<T> innerQueuedObserver, T t);
}
