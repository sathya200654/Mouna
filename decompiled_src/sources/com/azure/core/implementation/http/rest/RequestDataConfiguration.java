package com.azure.core.implementation.http.rest;

import com.azure.core.http.HttpRequest;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class RequestDataConfiguration {
    private final Object bodyContent;
    private final HttpRequest httpRequest;
    private final boolean isJson;
    private final SwaggerMethodParser methodParser;

    public RequestDataConfiguration(HttpRequest httpRequest, SwaggerMethodParser swaggerMethodParser, boolean z, Object obj) {
        this.httpRequest = httpRequest;
        this.methodParser = swaggerMethodParser;
        this.isJson = z;
        this.bodyContent = obj;
    }

    public HttpRequest getHttpRequest() {
        return this.httpRequest;
    }

    public SwaggerMethodParser getMethodParser() {
        return this.methodParser;
    }

    public boolean isJson() {
        return this.isJson;
    }

    public Object getBodyContent() {
        return this.bodyContent;
    }
}
