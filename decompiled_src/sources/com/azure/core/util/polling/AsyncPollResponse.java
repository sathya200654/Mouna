package com.azure.core.util.polling;

import com.azure.core.util.FluxUtil;
import com.azure.core.util.logging.ClientLogger;
import java.time.Duration;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class AsyncPollResponse<T, U> {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) AsyncPollResponse.class);
    private final BiFunction<PollingContext<T>, PollResponse<T>, Mono<T>> cancellationOperation;
    private final Function<PollingContext<T>, Mono<U>> fetchResultOperation;
    private final PollResponse<T> pollResponse;
    private final PollingContext<T> pollingContext;

    AsyncPollResponse(PollingContext<T> pollingContext, BiFunction<PollingContext<T>, PollResponse<T>, Mono<T>> biFunction, Function<PollingContext<T>, Mono<U>> function) {
        PollingContext<T> pollingContext2 = (PollingContext) Objects.requireNonNull(pollingContext, "'pollingContext' cannot be null.");
        this.pollingContext = pollingContext2;
        this.cancellationOperation = (BiFunction) Objects.requireNonNull(biFunction, "'cancellationOperation' cannot be null.");
        this.fetchResultOperation = (Function) Objects.requireNonNull(function, "'fetchResultOperation' cannot be null.");
        this.pollResponse = pollingContext2.getLatestResponse();
    }

    public LongRunningOperationStatus getStatus() {
        return this.pollResponse.getStatus();
    }

    public T getValue() {
        return this.pollResponse.getValue();
    }

    public Mono<T> cancelOperation() {
        return Mono.defer(new Supplier() { // from class: com.azure.core.util.polling.AsyncPollResponse$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.m1256x45345d83();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$cancelOperation$0$com-azure-core-util-polling-AsyncPollResponse, reason: not valid java name */
    /* synthetic */ Mono m1256x45345d83() {
        try {
            BiFunction<PollingContext<T>, PollResponse<T>, Mono<T>> biFunction = this.cancellationOperation;
            PollingContext<T> pollingContext = this.pollingContext;
            return biFunction.apply(pollingContext, pollingContext.getActivationResponse());
        } catch (RuntimeException e) {
            return FluxUtil.monoError(LOGGER, e);
        }
    }

    public Mono<U> getFinalResult() {
        return Mono.defer(new Supplier() { // from class: com.azure.core.util.polling.AsyncPollResponse$$ExternalSyntheticLambda1
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.m1257xcf95810e();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$getFinalResult$1$com-azure-core-util-polling-AsyncPollResponse, reason: not valid java name */
    /* synthetic */ Mono m1257xcf95810e() {
        if (!this.pollResponse.getStatus().isComplete()) {
            return Mono.empty();
        }
        try {
            return this.fetchResultOperation.apply(this.pollingContext);
        } catch (RuntimeException e) {
            return FluxUtil.monoError(LOGGER, e);
        }
    }

    Duration getRetryAfter() {
        return this.pollResponse.getRetryAfter();
    }
}
