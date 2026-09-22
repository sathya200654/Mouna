package io.reactivex;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface Emitter<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);
}
