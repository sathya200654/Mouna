package io.reactivex;

import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface FlowableOperator<Downstream, Upstream> {
    Subscriber<? super Upstream> apply(Subscriber<? super Downstream> subscriber) throws Exception;
}
