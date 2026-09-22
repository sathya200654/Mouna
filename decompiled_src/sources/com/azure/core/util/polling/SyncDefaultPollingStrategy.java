package com.azure.core.util.polling;

import com.azure.core.http.HttpPipeline;
import com.azure.core.http.rest.Response;
import com.azure.core.implementation.serializer.DefaultJsonSerializer;
import com.azure.core.util.Context;
import com.azure.core.util.serializer.JsonSerializer;
import com.azure.core.util.serializer.TypeReference;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SyncDefaultPollingStrategy<T, U> implements SyncPollingStrategy<T, U> {
    private final SyncChainedPollingStrategy<T, U> chainedPollingStrategy;

    public SyncDefaultPollingStrategy(HttpPipeline httpPipeline) {
        this(httpPipeline, new DefaultJsonSerializer(), Context.NONE);
    }

    public SyncDefaultPollingStrategy(HttpPipeline httpPipeline, JsonSerializer jsonSerializer) {
        this(httpPipeline, jsonSerializer, Context.NONE);
    }

    public SyncDefaultPollingStrategy(HttpPipeline httpPipeline, JsonSerializer jsonSerializer, Context context) {
        this(httpPipeline, null, jsonSerializer, context);
    }

    public SyncDefaultPollingStrategy(HttpPipeline httpPipeline, String str, JsonSerializer jsonSerializer, Context context) {
        this.chainedPollingStrategy = new SyncChainedPollingStrategy<>(Arrays.asList(new SyncOperationResourcePollingStrategy(httpPipeline, str, jsonSerializer, null, context), new SyncLocationPollingStrategy(httpPipeline, str, jsonSerializer, context), new SyncStatusCheckPollingStrategy(jsonSerializer)));
    }

    public SyncDefaultPollingStrategy(PollingStrategyOptions pollingStrategyOptions) {
        Objects.requireNonNull(pollingStrategyOptions, "'pollingStrategyOptions' cannot be null");
        this.chainedPollingStrategy = new SyncChainedPollingStrategy<>(Arrays.asList(new SyncOperationResourcePollingStrategy(null, pollingStrategyOptions), new SyncLocationPollingStrategy(pollingStrategyOptions), new SyncStatusCheckPollingStrategy(pollingStrategyOptions.getSerializer())));
    }

    @Override // com.azure.core.util.polling.SyncPollingStrategy
    public U getResult(PollingContext<T> pollingContext, TypeReference<U> typeReference) {
        return this.chainedPollingStrategy.getResult(pollingContext, typeReference);
    }

    @Override // com.azure.core.util.polling.SyncPollingStrategy
    public boolean canPoll(Response<?> response) {
        return this.chainedPollingStrategy.canPoll(response);
    }

    @Override // com.azure.core.util.polling.SyncPollingStrategy
    public PollResponse<T> onInitialResponse(Response<?> response, PollingContext<T> pollingContext, TypeReference<T> typeReference) {
        return this.chainedPollingStrategy.onInitialResponse(response, pollingContext, typeReference);
    }

    @Override // com.azure.core.util.polling.SyncPollingStrategy
    public PollResponse<T> poll(PollingContext<T> pollingContext, TypeReference<T> typeReference) {
        return this.chainedPollingStrategy.poll(pollingContext, typeReference);
    }

    @Override // com.azure.core.util.polling.SyncPollingStrategy
    public T cancel(PollingContext<T> pollingContext, PollResponse<T> pollResponse) {
        return this.chainedPollingStrategy.cancel(pollingContext, pollResponse);
    }
}
