package com.azure.core.exception;

import com.azure.core.http.HttpResponse;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class HttpResponseException extends AzureException {
    private final HttpResponse response;
    private final Object value;

    public HttpResponseException(HttpResponse httpResponse) {
        this.value = null;
        this.response = httpResponse;
    }

    public HttpResponseException(String str, HttpResponse httpResponse) {
        super(str);
        this.value = null;
        this.response = httpResponse;
    }

    public HttpResponseException(HttpResponse httpResponse, Throwable th) {
        super(th);
        this.value = null;
        this.response = httpResponse;
    }

    public HttpResponseException(String str, HttpResponse httpResponse, Object obj) {
        super(str);
        this.value = obj;
        this.response = httpResponse;
    }

    public HttpResponseException(String str, HttpResponse httpResponse, Throwable th) {
        super(str, th);
        this.value = null;
        this.response = httpResponse;
    }

    public HttpResponseException(String str, HttpResponse httpResponse, Throwable th, boolean z, boolean z2) {
        super(str, th, z, z2);
        this.value = null;
        this.response = httpResponse;
    }

    public HttpResponse getResponse() {
        return this.response;
    }

    public Object getValue() {
        return this.value;
    }
}
