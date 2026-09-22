package com.azure.core.http.policy;

import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.logging.LogLevel;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@FunctionalInterface
public interface HttpRequestLogger {
    Mono<Void> logRequest(ClientLogger clientLogger, HttpRequestLoggingContext httpRequestLoggingContext);

    default LogLevel getLogLevel(HttpRequestLoggingContext httpRequestLoggingContext) {
        return LogLevel.INFORMATIONAL;
    }

    default void logRequestSync(ClientLogger clientLogger, HttpRequestLoggingContext httpRequestLoggingContext) {
        logRequest(clientLogger, httpRequestLoggingContext).block();
    }
}
