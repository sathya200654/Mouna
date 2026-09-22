package io.reactivex;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface ObservableOperator<Downstream, Upstream> {
    Observer<? super Upstream> apply(Observer<? super Downstream> observer) throws Exception;
}
