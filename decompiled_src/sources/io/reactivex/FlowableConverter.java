package io.reactivex;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface FlowableConverter<T, R> {
    R apply(Flowable<T> flowable);
}
