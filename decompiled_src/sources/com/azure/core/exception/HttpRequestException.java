package com.azure.core.exception;

import com.azure.core.http.HttpRequest;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class HttpRequestException extends AzureException {
    private final transient HttpRequest request;

    public HttpRequestException(HttpRequest httpRequest) {
        this.request = httpRequest;
    }

    public HttpRequestException(String str, HttpRequest httpRequest) {
        super(str);
        this.request = httpRequest;
    }

    public HttpRequestException(HttpRequest httpRequest, Throwable th) {
        super(th);
        this.request = httpRequest;
    }

    public HttpRequestException(String str, HttpRequest httpRequest, Throwable th) {
        super(str, th);
        this.request = httpRequest;
    }

    public HttpRequestException(String str, HttpRequest httpRequest, Throwable th, boolean z, boolean z2) {
        super(str, th, z, z2);
        this.request = httpRequest;
    }

    public HttpRequest getRequest() {
        return this.request;
    }
}
