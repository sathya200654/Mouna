package io.reactivex;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface SingleTransformer<Upstream, Downstream> {
    SingleSource<Downstream> apply(Single<Upstream> single);
}
