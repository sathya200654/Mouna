package com.azure.core.util.polling;

import com.azure.core.http.rest.Response;
import com.azure.core.util.serializer.TypeReference;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface SyncPollingStrategy<T, U> {
    boolean canPoll(Response<?> response);

    U getResult(PollingContext<T> pollingContext, TypeReference<U> typeReference);

    PollResponse<T> onInitialResponse(Response<?> response, PollingContext<T> pollingContext, TypeReference<T> typeReference);

    PollResponse<T> poll(PollingContext<T> pollingContext, TypeReference<T> typeReference);

    default T cancel(PollingContext<T> pollingContext, PollResponse<T> pollResponse) {
        throw new IllegalStateException("Cancellation is not supported.");
    }
}
