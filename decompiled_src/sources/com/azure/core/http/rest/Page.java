package com.azure.core.http.rest;

import com.azure.core.util.paging.ContinuablePage;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface Page<T> extends ContinuablePage<String, T> {
    @Deprecated
    default List<T> getItems() {
        return getElements() == null ? new ArrayList() : (List) getElements().stream().collect(Collectors.toList());
    }
}
