package com.azure.core.exception;

import com.azure.core.http.HttpResponse;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class ResourceModifiedException extends HttpResponseException {
    public ResourceModifiedException(String str, HttpResponse httpResponse) {
        super(str, httpResponse);
    }

    public ResourceModifiedException(String str, HttpResponse httpResponse, Object obj) {
        super(str, httpResponse, obj);
    }

    public ResourceModifiedException(String str, HttpResponse httpResponse, Throwable th) {
        super(str, httpResponse, th);
    }
}
