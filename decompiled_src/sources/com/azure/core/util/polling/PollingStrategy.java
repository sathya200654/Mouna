package com.azure.core.util.polling;

import com.azure.core.http.rest.Response;
import com.azure.core.util.serializer.TypeReference;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface PollingStrategy<T, U> {
    Mono<Boolean> canPoll(Response<?> response);

    Mono<U> getResult(PollingContext<T> pollingContext, TypeReference<U> typeReference);

    Mono<PollResponse<T>> onInitialResponse(Response<?> response, PollingContext<T> pollingContext, TypeReference<T> typeReference);

    Mono<PollResponse<T>> poll(PollingContext<T> pollingContext, TypeReference<T> typeReference);

    default Mono<T> cancel(PollingContext<T> pollingContext, PollResponse<T> pollResponse) {
        return Mono.error(new IllegalStateException("Cancellation is not supported."));
    }
}
