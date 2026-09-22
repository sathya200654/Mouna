package com.azure.core.http.rest;

import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpRequest;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class ResponseBase<H, T> implements Response<T> {
    private final H deserializedHeaders;
    private final HttpHeaders headers;
    private final HttpRequest request;
    private final int statusCode;
    private final T value;

    public ResponseBase(HttpRequest httpRequest, int i, HttpHeaders httpHeaders, T t, H h) {
        this.request = httpRequest;
        this.statusCode = i;
        this.headers = httpHeaders;
        this.deserializedHeaders = h;
        this.value = t;
    }

    @Override // com.azure.core.http.rest.Response
    public HttpRequest getRequest() {
        return this.request;
    }

    @Override // com.azure.core.http.rest.Response
    public int getStatusCode() {
        return this.statusCode;
    }

    @Override // com.azure.core.http.rest.Response
    public HttpHeaders getHeaders() {
        return this.headers;
    }

    public H getDeserializedHeaders() {
        return this.deserializedHeaders;
    }

    @Override // com.azure.core.http.rest.Response
    public T getValue() {
        return this.value;
    }
}
