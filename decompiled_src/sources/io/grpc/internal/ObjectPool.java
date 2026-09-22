package io.grpc.internal;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface ObjectPool<T> {
    T getObject();

    T returnObject(Object obj);
}
