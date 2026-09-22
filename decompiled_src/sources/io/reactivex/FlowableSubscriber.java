package io.reactivex;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface FlowableSubscriber<T> extends Subscriber<T> {
    void onSubscribe(Subscription subscription);
}
