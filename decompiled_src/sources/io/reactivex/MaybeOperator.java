package io.reactivex;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface MaybeOperator<Downstream, Upstream> {
    MaybeObserver<? super Upstream> apply(MaybeObserver<? super Downstream> maybeObserver) throws Exception;
}
