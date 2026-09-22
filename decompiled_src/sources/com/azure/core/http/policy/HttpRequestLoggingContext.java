package com.azure.core.http.policy;

import com.azure.core.http.HttpRequest;
import com.azure.core.util.Context;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class HttpRequestLoggingContext {
    private final Context context;
    private final HttpRequest httpRequest;
    private final Integer tryCount;

    HttpRequestLoggingContext(HttpRequest httpRequest, Context context, Integer num) {
        this.httpRequest = httpRequest;
        this.context = context;
        this.tryCount = num;
    }

    public HttpRequest getHttpRequest() {
        return this.httpRequest;
    }

    public Context getContext() {
        return this.context;
    }

    public Integer getTryCount() {
        return this.tryCount;
    }
}
