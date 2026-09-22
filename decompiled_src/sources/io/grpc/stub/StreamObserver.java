package io.grpc.stub;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface StreamObserver<V> {
    void onCompleted();

    void onError(Throwable th);

    void onNext(V v);
}
