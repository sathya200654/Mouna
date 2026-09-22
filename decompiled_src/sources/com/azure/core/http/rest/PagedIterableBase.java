package com.azure.core.http.rest;

import com.azure.core.http.rest.PagedResponse;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.paging.ContinuablePagedIterable;
import com.azure.core.util.paging.PageRetrieverSync;
import java.util.function.Predicate;
import java.util.function.Supplier;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class PagedIterableBase<T, P extends PagedResponse<T>> extends ContinuablePagedIterable<String, T, P> {
    public PagedIterableBase(PagedFluxBase<T, P> pagedFluxBase) {
        super(pagedFluxBase);
    }

    public PagedIterableBase(Supplier<PageRetrieverSync<String, P>> supplier) {
        super(supplier, null, new Predicate() { // from class: com.azure.core.http.rest.PagedIterableBase$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return PagedIterableBase.lambda$new$0((String) obj);
            }
        });
    }

    static /* synthetic */ boolean lambda$new$0(String str) {
        return !CoreUtils.isNullOrEmpty(str);
    }
}
