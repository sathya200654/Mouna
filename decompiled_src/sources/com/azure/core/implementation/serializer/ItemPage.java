package com.azure.core.implementation.serializer;

import com.azure.core.http.rest.Page;
import com.azure.core.util.IterableStream;
import com.fasterxml.jackson.annotation.JsonAlias;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
class ItemPage<T> implements Page<T> {

    @JsonAlias({"nextLink", "nextPageLink"})
    private String continuationToken;

    @JsonAlias({"items", "value"})
    private List<T> items;

    ItemPage() {
    }

    @Override // com.azure.core.util.paging.ContinuablePage
    public IterableStream<T> getElements() {
        return IterableStream.of(this.items);
    }

    @Override // com.azure.core.util.paging.ContinuablePage
    public String getContinuationToken() {
        return this.continuationToken;
    }
}
