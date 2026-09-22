package com.azure.core.util.polling;

import com.azure.core.http.rest.Response;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.serializer.TypeReference;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SyncChainedPollingStrategy<T, U> implements SyncPollingStrategy<T, U> {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) SyncChainedPollingStrategy.class);
    private SyncPollingStrategy<T, U> pollableStrategy = null;
    private final List<SyncPollingStrategy<T, U>> pollingStrategies;

    public SyncChainedPollingStrategy(List<SyncPollingStrategy<T, U>> list) {
        Objects.requireNonNull(list, "'strategies' cannot be null.");
        if (list.isEmpty()) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("'strategies' cannot be empty."));
        }
        this.pollingStrategies = Collections.unmodifiableList(list);
    }

    @Override // com.azure.core.util.polling.SyncPollingStrategy
    public boolean canPoll(Response<?> response) {
        for (SyncPollingStrategy<T, U> syncPollingStrategy : this.pollingStrategies) {
            if (syncPollingStrategy.canPoll(response)) {
                this.pollableStrategy = syncPollingStrategy;
                return true;
            }
        }
        return false;
    }

    @Override // com.azure.core.util.polling.SyncPollingStrategy
    public U getResult(PollingContext<T> pollingContext, TypeReference<U> typeReference) {
        return this.pollableStrategy.getResult(pollingContext, typeReference);
    }

    @Override // com.azure.core.util.polling.SyncPollingStrategy
    public PollResponse<T> onInitialResponse(Response<?> response, PollingContext<T> pollingContext, TypeReference<T> typeReference) {
        return this.pollableStrategy.onInitialResponse(response, pollingContext, typeReference);
    }

    @Override // com.azure.core.util.polling.SyncPollingStrategy
    public PollResponse<T> poll(PollingContext<T> pollingContext, TypeReference<T> typeReference) {
        return this.pollableStrategy.poll(pollingContext, typeReference);
    }

    @Override // com.azure.core.util.polling.SyncPollingStrategy
    public T cancel(PollingContext<T> pollingContext, PollResponse<T> pollResponse) {
        return this.pollableStrategy.cancel(pollingContext, pollResponse);
    }
}
