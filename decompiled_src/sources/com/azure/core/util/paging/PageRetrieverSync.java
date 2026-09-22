package com.azure.core.util.paging;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@FunctionalInterface
public interface PageRetrieverSync<C, P> {
    P getPage(C c, Integer num);
}
