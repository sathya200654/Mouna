package com.azure.core.http.rest;

import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpRequest;
import com.azure.core.util.IterableStream;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class PagedResponseBase<H, T> implements PagedResponse<T> {
    private final String continuationToken;
    private final H deserializedHeaders;
    private final HttpHeaders headers;
    private final List<T> items;
    private final HttpRequest request;
    private final int statusCode;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public PagedResponseBase(HttpRequest httpRequest, int i, HttpHeaders httpHeaders, Page<T> page, H h) {
        this(httpRequest, i, httpHeaders, page.getItems(), page.getContinuationToken(), h);
    }

    public PagedResponseBase(HttpRequest httpRequest, int i, HttpHeaders httpHeaders, List<T> list, String str, H h) {
        this.request = httpRequest;
        this.statusCode = i;
        this.headers = httpHeaders;
        this.items = list;
        this.continuationToken = str;
        this.deserializedHeaders = h;
    }

    @Override // com.azure.core.util.paging.ContinuablePage
    public IterableStream<T> getElements() {
        return IterableStream.of(this.items);
    }

    @Override // com.azure.core.util.paging.ContinuablePage
    public String getContinuationToken() {
        return this.continuationToken;
    }

    @Override // com.azure.core.http.rest.Response
    public int getStatusCode() {
        return this.statusCode;
    }

    @Override // com.azure.core.http.rest.Response
    public HttpHeaders getHeaders() {
        return this.headers;
    }

    @Override // com.azure.core.http.rest.Response
    public HttpRequest getRequest() {
        return this.request;
    }

    public H getDeserializedHeaders() {
        return this.deserializedHeaders;
    }
}
