package com.azure.core.exception;

import com.azure.core.http.HttpResponse;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class TooManyRedirectsException extends HttpResponseException {
    public TooManyRedirectsException(String str, HttpResponse httpResponse) {
        super(str, httpResponse);
    }

    public TooManyRedirectsException(String str, HttpResponse httpResponse, Object obj) {
        super(str, httpResponse, obj);
    }

    public TooManyRedirectsException(String str, HttpResponse httpResponse, Throwable th) {
        super(str, httpResponse, th);
    }
}
