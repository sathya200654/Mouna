package io.reactivex;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface MaybeTransformer<Upstream, Downstream> {
    MaybeSource<Downstream> apply(Maybe<Upstream> maybe);
}
