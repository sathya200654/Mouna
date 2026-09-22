package com.azure.core.http.rest;

import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpRequest;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface Response<T> {
    HttpHeaders getHeaders();

    HttpRequest getRequest();

    int getStatusCode();

    T getValue();
}
