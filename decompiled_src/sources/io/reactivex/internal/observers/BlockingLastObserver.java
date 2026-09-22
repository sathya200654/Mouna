package io.reactivex.internal.observers;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class BlockingLastObserver<T> extends BlockingBaseObserver<T> {
    @Override // io.reactivex.Observer
    public void onNext(T t) {
        this.value = t;
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        this.value = null;
        this.error = th;
        countDown();
    }
}
