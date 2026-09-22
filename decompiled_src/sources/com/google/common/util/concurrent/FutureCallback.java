package com.google.common.util.concurrent;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@ElementTypesAreNonnullByDefault
public interface FutureCallback<V> {
    void onFailure(Throwable t);

    void onSuccess(@ParametricNullness V result);
}
