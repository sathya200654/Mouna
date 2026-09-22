package com.azure.core.http.policy;

import com.azure.core.http.HttpResponse;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.logging.LogLevel;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@FunctionalInterface
public interface HttpResponseLogger {
    Mono<HttpResponse> logResponse(ClientLogger clientLogger, HttpResponseLoggingContext httpResponseLoggingContext);

    default LogLevel getLogLevel(HttpResponseLoggingContext httpResponseLoggingContext) {
        return LogLevel.INFORMATIONAL;
    }

    default HttpResponse logResponseSync(ClientLogger clientLogger, HttpResponseLoggingContext httpResponseLoggingContext) {
        return (HttpResponse) logResponse(clientLogger, httpResponseLoggingContext).block();
    }
}
