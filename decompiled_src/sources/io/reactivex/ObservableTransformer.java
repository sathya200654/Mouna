package io.reactivex;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface ObservableTransformer<Upstream, Downstream> {
    ObservableSource<Downstream> apply(Observable<Upstream> observable);
}
