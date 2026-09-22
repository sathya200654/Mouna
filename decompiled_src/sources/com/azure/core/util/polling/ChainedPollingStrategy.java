package com.azure.core.util.polling;

import com.azure.core.http.rest.Response;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.serializer.TypeReference;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ChainedPollingStrategy<T, U> implements PollingStrategy<T, U> {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) ChainedPollingStrategy.class);
    private PollingStrategy<T, U> pollableStrategy = null;
    private final List<PollingStrategy<T, U>> pollingStrategies;

    public ChainedPollingStrategy(List<PollingStrategy<T, U>> list) {
        Objects.requireNonNull(list, "'strategies' cannot be null.");
        if (list.isEmpty()) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("'strategies' cannot be empty."));
        }
        this.pollingStrategies = Collections.unmodifiableList(list);
    }

    @Override // com.azure.core.util.polling.PollingStrategy
    public Mono<Boolean> canPoll(final Response<?> response) {
        return Flux.fromIterable(this.pollingStrategies).concatMap(new Function() { // from class: com.azure.core.util.polling.ChainedPollingStrategy$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                PollingStrategy pollingStrategy = (PollingStrategy) obj;
                return pollingStrategy.canPoll(response).map(new Function() { // from class: com.azure.core.util.polling.ChainedPollingStrategy$$ExternalSyntheticLambda0
                    @Override // java.util.function.Function
                    public final Object apply(Object obj2) {
                        return Tuples.of(pollingStrategy, (Boolean) obj2);
                    }
                });
            }
        }).takeUntil(new Predicate() { // from class: com.azure.core.util.polling.ChainedPollingStrategy$$ExternalSyntheticLambda2
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((Boolean) ((Tuple2) obj).getT2()).booleanValue();
            }
        }).last().map(new Function() { // from class: com.azure.core.util.polling.ChainedPollingStrategy$$ExternalSyntheticLambda3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1258x2383b90b((Tuple2) obj);
            }
        }).defaultIfEmpty(false);
    }

    /* JADX INFO: renamed from: lambda$canPoll$2$com-azure-core-util-polling-ChainedPollingStrategy, reason: not valid java name */
    /* synthetic */ Boolean m1258x2383b90b(Tuple2 tuple2) {
        this.pollableStrategy = (PollingStrategy) tuple2.getT1();
        return true;
    }

    @Override // com.azure.core.util.polling.PollingStrategy
    public Mono<U> getResult(PollingContext<T> pollingContext, TypeReference<U> typeReference) {
        return this.pollableStrategy.getResult(pollingContext, typeReference);
    }

    @Override // com.azure.core.util.polling.PollingStrategy
    public Mono<PollResponse<T>> onInitialResponse(Response<?> response, PollingContext<T> pollingContext, TypeReference<T> typeReference) {
        return this.pollableStrategy.onInitialResponse(response, pollingContext, typeReference);
    }

    @Override // com.azure.core.util.polling.PollingStrategy
    public Mono<PollResponse<T>> poll(PollingContext<T> pollingContext, TypeReference<T> typeReference) {
        return this.pollableStrategy.poll(pollingContext, typeReference);
    }

    @Override // com.azure.core.util.polling.PollingStrategy
    public Mono<T> cancel(PollingContext<T> pollingContext, PollResponse<T> pollResponse) {
        return this.pollableStrategy.cancel(pollingContext, pollResponse);
    }
}
