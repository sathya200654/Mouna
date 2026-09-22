package io.reactivex;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface Observer<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);

    void onSubscribe(Disposable disposable);
}
