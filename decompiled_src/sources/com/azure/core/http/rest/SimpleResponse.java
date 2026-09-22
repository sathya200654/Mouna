package com.azure.core.http.rest;

import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpRequest;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class SimpleResponse<T> implements Response<T> {
    private final HttpHeaders headers;
    private final HttpRequest request;
    private final int statusCode;
    private final T value;

    public SimpleResponse(HttpRequest httpRequest, int i, HttpHeaders httpHeaders, T t) {
        this.request = httpRequest;
        this.statusCode = i;
        this.headers = httpHeaders;
        this.value = t;
    }

    public SimpleResponse(Response<?> response, T t) {
        this.request = response.getRequest();
        this.statusCode = response.getStatusCode();
        this.headers = response.getHeaders();
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

    @Override // com.azure.core.http.rest.Response
    public T getValue() {
        return this.value;
    }
}
