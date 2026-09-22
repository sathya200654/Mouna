package com.azure.core.http;

import com.azure.core.implementation.http.HttpClientProviders;
import com.azure.core.util.Context;
import com.azure.core.util.HttpClientOptions;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface HttpClient {
    Mono<HttpResponse> send(HttpRequest httpRequest);

    default Mono<HttpResponse> send(HttpRequest httpRequest, Context context) {
        return send(httpRequest);
    }

    default HttpResponse sendSync(HttpRequest httpRequest, Context context) {
        return (HttpResponse) send(httpRequest, context).block();
    }

    static HttpClient createDefault() {
        return createDefault(null);
    }

    static HttpClient createDefault(HttpClientOptions httpClientOptions) {
        return HttpClientProviders.createInstance(httpClientOptions);
    }
}
