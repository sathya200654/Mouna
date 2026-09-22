package com.azure.core.http;

import com.azure.core.util.HttpClientOptions;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@FunctionalInterface
public interface HttpClientProvider {
    HttpClient createInstance();

    default HttpClient createInstance(HttpClientOptions httpClientOptions) {
        return createInstance();
    }
}
