package com.azure.core.http;

import com.azure.core.util.Context;
import java.util.Objects;
import java.util.Optional;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class HttpPipelineCallContext {
    private Context data;
    private HttpRequest httpRequest;

    HttpPipelineCallContext(HttpRequest httpRequest) {
        this(httpRequest, Context.NONE);
    }

    HttpPipelineCallContext(HttpRequest httpRequest, Context context) {
        Objects.requireNonNull(httpRequest, "'httpRequest' cannot be null.");
        Objects.requireNonNull(context, "'data' cannot be null.");
        this.httpRequest = httpRequest;
        this.data = context;
    }

    public void setData(String str, Object obj) {
        this.data = this.data.addData(str, obj);
    }

    public Optional<Object> getData(String str) {
        return this.data.getData(str);
    }

    public Context getContext() {
        return this.data;
    }

    public HttpRequest getHttpRequest() {
        return this.httpRequest;
    }

    public HttpPipelineCallContext setHttpRequest(HttpRequest httpRequest) {
        this.httpRequest = httpRequest;
        return this;
    }
}
