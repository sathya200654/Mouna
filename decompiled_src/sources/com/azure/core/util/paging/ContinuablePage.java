package com.azure.core.util.paging;

import com.azure.core.util.IterableStream;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface ContinuablePage<C, T> {
    C getContinuationToken();

    IterableStream<T> getElements();
}
