package com.azure.core.util.paging;

import reactor.core.publisher.Flux;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@FunctionalInterface
public interface PageRetriever<C, P> {
    Flux<P> get(C c, Integer num);
}
