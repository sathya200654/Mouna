package com.azure.core.util.polling;

import com.azure.core.http.HttpPipeline;
import com.azure.core.http.rest.Response;
import com.azure.core.implementation.serializer.DefaultJsonSerializer;
import com.azure.core.util.Context;
import com.azure.core.util.serializer.JsonSerializer;
import com.azure.core.util.serializer.TypeReference;
import java.util.Arrays;
import java.util.Objects;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class DefaultPollingStrategy<T, U> implements PollingStrategy<T, U> {
    private final ChainedPollingStrategy<T, U> chainedPollingStrategy;

    public DefaultPollingStrategy(HttpPipeline httpPipeline) {
        this(httpPipeline, new DefaultJsonSerializer(), Context.NONE);
    }

    public DefaultPollingStrategy(HttpPipeline httpPipeline, JsonSerializer jsonSerializer) {
        this(httpPipeline, jsonSerializer, Context.NONE);
    }

    public DefaultPollingStrategy(HttpPipeline httpPipeline, JsonSerializer jsonSerializer, Context context) {
        this(httpPipeline, null, jsonSerializer, context);
    }

    public DefaultPollingStrategy(HttpPipeline httpPipeline, String str, JsonSerializer jsonSerializer, Context context) {
        this(new PollingStrategyOptions(httpPipeline).setEndpoint(str).setSerializer(jsonSerializer).setContext(context));
    }

    public DefaultPollingStrategy(PollingStrategyOptions pollingStrategyOptions) {
        Objects.requireNonNull(pollingStrategyOptions, "'pollingStrategyOptions' cannot be null");
        this.chainedPollingStrategy = new ChainedPollingStrategy<>(Arrays.asList(new OperationResourcePollingStrategy(null, pollingStrategyOptions), new LocationPollingStrategy(pollingStrategyOptions), new StatusCheckPollingStrategy(pollingStrategyOptions.getSerializer())));
    }

    @Override // com.azure.core.util.polling.PollingStrategy
    public Mono<U> getResult(PollingContext<T> pollingContext, TypeReference<U> typeReference) {
        return this.chainedPollingStrategy.getResult(pollingContext, typeReference);
    }

    @Override // com.azure.core.util.polling.PollingStrategy
    public Mono<Boolean> canPoll(Response<?> response) {
        return this.chainedPollingStrategy.canPoll(response);
    }

    @Override // com.azure.core.util.polling.PollingStrategy
    public Mono<PollResponse<T>> onInitialResponse(Response<?> response, PollingContext<T> pollingContext, TypeReference<T> typeReference) {
        return this.chainedPollingStrategy.onInitialResponse(response, pollingContext, typeReference);
    }

    @Override // com.azure.core.util.polling.PollingStrategy
    public Mono<PollResponse<T>> poll(PollingContext<T> pollingContext, TypeReference<T> typeReference) {
        return this.chainedPollingStrategy.poll(pollingContext, typeReference);
    }
}
