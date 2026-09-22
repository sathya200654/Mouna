package com.azure.core.http.rest;

import com.azure.core.util.IterableStream;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface PagedResponse<T> extends Page<T>, Response<List<T>>, Closeable {
    @Override // com.azure.core.http.rest.Response
    default List<T> getValue() {
        IterableStream<T> elements = getElements();
        return elements == null ? new ArrayList() : (List) elements.stream().collect(Collectors.toList());
    }
}
