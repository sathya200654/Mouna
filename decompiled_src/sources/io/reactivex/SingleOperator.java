package io.reactivex;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface SingleOperator<Downstream, Upstream> {
    SingleObserver<? super Upstream> apply(SingleObserver<? super Downstream> singleObserver) throws Exception;
}
