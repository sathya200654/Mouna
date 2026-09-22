package com.google.common.util.concurrent;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@ElementTypesAreNonnullByDefault
public interface AsyncFunction<I, O> {
    ListenableFuture<O> apply(@ParametricNullness I input) throws Exception;
}
