package com.google.firebase.inject;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface Deferred<T> {

    public interface DeferredHandler<T> {
        void handle(Provider<T> provider);
    }

    void whenAvailable(DeferredHandler<T> deferredHandler);
}
