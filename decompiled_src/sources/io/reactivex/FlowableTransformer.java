package io.reactivex;

import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface FlowableTransformer<Upstream, Downstream> {
    Publisher<Downstream> apply(Flowable<Upstream> flowable);
}
