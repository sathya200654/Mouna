package com.azure.core.util.polling;

import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.polling.implementation.PollContextRequiredException;
import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class SyncOverAsyncPoller<T, U> implements SyncPoller<T, U> {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) SyncOverAsyncPoller.class);
    private final PollResponse<T> activationResponse;
    private final BiFunction<PollingContext<T>, PollResponse<T>, Mono<T>> cancelOperation;
    private final Function<PollingContext<T>, Mono<U>> fetchResultOperation;
    private volatile Duration pollInterval;
    private final Function<PollingContext<T>, Mono<PollResponse<T>>> pollOperation;
    private final PollingContext<T> pollingContext;
    private volatile PollingContext<T> terminalPollContext;

    SyncOverAsyncPoller(Duration duration, Function<PollingContext<T>, PollResponse<T>> function, Function<PollingContext<T>, Mono<PollResponse<T>>> function2, BiFunction<PollingContext<T>, PollResponse<T>, Mono<T>> biFunction, Function<PollingContext<T>, Mono<U>> function3) {
        PollingContext<T> pollingContext = new PollingContext<>();
        this.pollingContext = pollingContext;
        Objects.requireNonNull(duration, "'pollInterval' cannot be null.");
        if (duration.isNegative() || duration.isZero()) {
            throw LOGGER.logExceptionAsWarning(new IllegalArgumentException("Negative or zero value for 'defaultPollInterval' is not allowed."));
        }
        this.pollInterval = duration;
        Objects.requireNonNull(function, "'syncActivationOperation' cannot be null.");
        this.pollOperation = (Function) Objects.requireNonNull(function2, "'pollOperation' cannot be null.");
        this.cancelOperation = (BiFunction) Objects.requireNonNull(biFunction, "'cancelOperation' cannot be null.");
        this.fetchResultOperation = (Function) Objects.requireNonNull(function3, "'fetchResultOperation' cannot be null.");
        PollResponse<T> pollResponseApply = function.apply(pollingContext);
        this.activationResponse = pollResponseApply;
        pollingContext.setOnetimeActivationResponse(pollResponseApply);
        pollingContext.setLatestResponse(pollResponseApply);
        if (pollResponseApply.getStatus().isComplete()) {
            this.terminalPollContext = pollingContext;
        }
    }

    @Override // com.azure.core.util.polling.SyncPoller
    public PollResponse<T> poll() {
        return (PollResponse) this.pollOperation.apply(this.pollingContext).map(new Function() { // from class: com.azure.core.util.polling.SyncOverAsyncPoller$$ExternalSyntheticLambda2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1284lambda$poll$0$comazurecoreutilpollingSyncOverAsyncPoller((PollResponse) obj);
            }
        }).block();
    }

    /* JADX INFO: renamed from: lambda$poll$0$com-azure-core-util-polling-SyncOverAsyncPoller, reason: not valid java name */
    /* synthetic */ PollResponse m1284lambda$poll$0$comazurecoreutilpollingSyncOverAsyncPoller(PollResponse pollResponse) {
        this.pollingContext.setLatestResponse(pollResponse);
        if (pollResponse.getStatus().isComplete()) {
            this.terminalPollContext = this.pollingContext.copy();
        }
        return pollResponse;
    }

    @Override // com.azure.core.util.polling.SyncPoller
    public PollResponse<T> waitForCompletion() {
        PollingContext<T> pollingContext = this.terminalPollContext;
        if (pollingContext != null) {
            return pollingContext.getLatestResponse();
        }
        final PollingContext<T> pollingContextCopy = this.pollingContext.copy();
        return (PollResponse) PollingUtil.pollingLoopAsync(pollingContextCopy, this.pollOperation, this.cancelOperation, this.fetchResultOperation, this.pollInterval).last().map(new Function() { // from class: com.azure.core.util.polling.SyncOverAsyncPoller$$ExternalSyntheticLambda6
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1285x96038f44(pollingContextCopy, (AsyncPollResponse) obj);
            }
        }).block();
    }

    /* JADX INFO: renamed from: lambda$waitForCompletion$1$com-azure-core-util-polling-SyncOverAsyncPoller, reason: not valid java name */
    /* synthetic */ PollResponse m1285x96038f44(PollingContext pollingContext, AsyncPollResponse asyncPollResponse) {
        this.terminalPollContext = pollingContext;
        return PollingUtil.toPollResponse(asyncPollResponse);
    }

    @Override // com.azure.core.util.polling.SyncPoller
    public PollResponse<T> waitForCompletion(Duration duration) {
        PollingUtil.validateTimeout(duration, LOGGER);
        PollingContext<T> pollingContext = this.terminalPollContext;
        if (pollingContext != null) {
            return pollingContext.getLatestResponse();
        }
        final PollingContext<T> pollingContextCopy = this.pollingContext.copy();
        return (PollResponse) PollingUtil.pollingLoopAsync(pollingContextCopy, this.pollOperation, this.cancelOperation, this.fetchResultOperation, this.pollInterval).take(duration).switchIfEmpty(Mono.error(new Supplier() { // from class: com.azure.core.util.polling.SyncOverAsyncPoller$$ExternalSyntheticLambda10
            @Override // java.util.function.Supplier
            public final Object get() {
                return SyncOverAsyncPoller.lambda$waitForCompletion$2();
            }
        })).last().flatMap(new Function() { // from class: com.azure.core.util.polling.SyncOverAsyncPoller$$ExternalSyntheticLambda11
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1286x9516c346(pollingContextCopy, (AsyncPollResponse) obj);
            }
        }).block();
    }

    static /* synthetic */ Throwable lambda$waitForCompletion$2() {
        return new TimeoutException("Polling didn't complete before the timeout period.");
    }

    /* JADX INFO: renamed from: lambda$waitForCompletion$3$com-azure-core-util-polling-SyncOverAsyncPoller, reason: not valid java name */
    /* synthetic */ Mono m1286x9516c346(PollingContext pollingContext, AsyncPollResponse asyncPollResponse) {
        if (asyncPollResponse == null || !asyncPollResponse.getStatus().isComplete()) {
            return Mono.error(new TimeoutException("Polling didn't complete before the timeout period."));
        }
        this.terminalPollContext = pollingContext;
        return Mono.just(PollingUtil.toPollResponse(asyncPollResponse));
    }

    @Override // com.azure.core.util.polling.SyncPoller
    public PollResponse<T> waitUntil(final LongRunningOperationStatus longRunningOperationStatus) {
        Objects.requireNonNull(longRunningOperationStatus, "'statusToWaitFor' cannot be null.");
        PollingContext<T> pollingContext = this.terminalPollContext;
        if (pollingContext != null) {
            return pollingContext.getLatestResponse();
        }
        final PollingContext<T> pollingContextCopy = this.pollingContext.copy();
        return (PollResponse) PollingUtil.pollingLoopAsync(pollingContextCopy, this.pollOperation, this.cancelOperation, this.fetchResultOperation, this.pollInterval).takeUntil(new Predicate() { // from class: com.azure.core.util.polling.SyncOverAsyncPoller$$ExternalSyntheticLambda8
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return PollingUtil.matchStatus((AsyncPollResponse) obj, longRunningOperationStatus);
            }
        }).last().map(new Function() { // from class: com.azure.core.util.polling.SyncOverAsyncPoller$$ExternalSyntheticLambda9
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1287xcb4f16e1(pollingContextCopy, (AsyncPollResponse) obj);
            }
        }).block();
    }

    /* JADX INFO: renamed from: lambda$waitUntil$5$com-azure-core-util-polling-SyncOverAsyncPoller, reason: not valid java name */
    /* synthetic */ PollResponse m1287xcb4f16e1(PollingContext pollingContext, AsyncPollResponse asyncPollResponse) {
        if (asyncPollResponse.getStatus().isComplete()) {
            this.terminalPollContext = pollingContext;
        }
        return PollingUtil.toPollResponse(asyncPollResponse);
    }

    @Override // com.azure.core.util.polling.SyncPoller
    public PollResponse<T> waitUntil(Duration duration, final LongRunningOperationStatus longRunningOperationStatus) {
        PollingUtil.validateTimeout(duration, LOGGER);
        Objects.requireNonNull(longRunningOperationStatus, "'statusToWaitFor' cannot be null.");
        PollingContext<T> pollingContext = this.terminalPollContext;
        if (pollingContext != null) {
            return pollingContext.getLatestResponse();
        }
        final PollingContext<T> pollingContextCopy = this.pollingContext.copy();
        Flux fluxFlatMap = PollingUtil.pollingLoopAsync(pollingContextCopy, this.pollOperation, this.cancelOperation, this.fetchResultOperation, this.pollInterval).take(duration).takeUntil(new Predicate() { // from class: com.azure.core.util.polling.SyncOverAsyncPoller$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return PollingUtil.matchStatus((AsyncPollResponse) obj, longRunningOperationStatus);
            }
        }).takeLast(1).flatMap(new Function() { // from class: com.azure.core.util.polling.SyncOverAsyncPoller$$ExternalSyntheticLambda4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1288xca624ae3(pollingContextCopy, (AsyncPollResponse) obj);
            }
        });
        final PollingContext<T> pollingContext2 = this.pollingContext;
        Objects.requireNonNull(pollingContext2);
        return (PollResponse) fluxFlatMap.switchIfEmpty(Mono.fromCallable(new Callable() { // from class: com.azure.core.util.polling.SyncOverAsyncPoller$$ExternalSyntheticLambda5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return pollingContext2.getLatestResponse();
            }
        })).blockLast();
    }

    /* JADX INFO: renamed from: lambda$waitUntil$7$com-azure-core-util-polling-SyncOverAsyncPoller, reason: not valid java name */
    /* synthetic */ Publisher m1288xca624ae3(PollingContext pollingContext, AsyncPollResponse asyncPollResponse) {
        if (asyncPollResponse.getStatus().isComplete()) {
            this.terminalPollContext = pollingContext;
        }
        return Mono.just(PollingUtil.toPollResponse(asyncPollResponse));
    }

    @Override // com.azure.core.util.polling.SyncPoller
    public U getFinalResult() {
        PollingContext<T> pollingContext = this.terminalPollContext;
        if (pollingContext != null) {
            return (U) this.fetchResultOperation.apply(pollingContext).block();
        }
        final PollingContext<T> pollingContextCopy = this.pollingContext.copy();
        return (U) PollingUtil.pollingLoopAsync(pollingContextCopy, this.pollOperation, this.cancelOperation, this.fetchResultOperation, this.pollInterval).last().flatMap(new Function() { // from class: com.azure.core.util.polling.SyncOverAsyncPoller$$ExternalSyntheticLambda3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1283xa9193192(pollingContextCopy, (AsyncPollResponse) obj);
            }
        }).block();
    }

    /* JADX INFO: renamed from: lambda$getFinalResult$8$com-azure-core-util-polling-SyncOverAsyncPoller, reason: not valid java name */
    /* synthetic */ Mono m1283xa9193192(PollingContext pollingContext, AsyncPollResponse asyncPollResponse) {
        this.terminalPollContext = pollingContext;
        return asyncPollResponse.getFinalResult();
    }

    @Override // com.azure.core.util.polling.SyncPoller
    public U getFinalResult(Duration duration) {
        PollingContext<T> pollingContext = this.terminalPollContext;
        if (pollingContext != null) {
            return (U) this.fetchResultOperation.apply(pollingContext).block();
        }
        final PollingContext<T> pollingContextCopy = this.pollingContext.copy();
        return (U) PollingUtil.pollingLoopAsync(pollingContextCopy, this.pollOperation, this.cancelOperation, this.fetchResultOperation, this.pollInterval).take(duration).switchIfEmpty(Mono.error(new Supplier() { // from class: com.azure.core.util.polling.SyncOverAsyncPoller$$ExternalSyntheticLambda12
            @Override // java.util.function.Supplier
            public final Object get() {
                return SyncOverAsyncPoller.lambda$getFinalResult$9();
            }
        })).last().flatMap(new Function() { // from class: com.azure.core.util.polling.SyncOverAsyncPoller$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1282xb40a9f8d(pollingContextCopy, (AsyncPollResponse) obj);
            }
        }).block();
    }

    static /* synthetic */ Throwable lambda$getFinalResult$9() {
        return new TimeoutException("Polling didn't complete before the timeout period.");
    }

    /* JADX INFO: renamed from: lambda$getFinalResult$10$com-azure-core-util-polling-SyncOverAsyncPoller, reason: not valid java name */
    /* synthetic */ Mono m1282xb40a9f8d(PollingContext pollingContext, AsyncPollResponse asyncPollResponse) {
        if (asyncPollResponse == null || !asyncPollResponse.getStatus().isComplete()) {
            return Mono.error(new TimeoutException("Polling didn't complete before the timeout period."));
        }
        this.terminalPollContext = pollingContext;
        return asyncPollResponse.getFinalResult();
    }

    @Override // com.azure.core.util.polling.SyncPoller
    public void cancelOperation() {
        PollingContext<T> pollingContextCopy = this.pollingContext.copy();
        if (pollingContextCopy.getActivationResponse() == pollingContextCopy.getLatestResponse()) {
            this.cancelOperation.apply(pollingContextCopy, pollingContextCopy.getActivationResponse()).block();
        } else {
            this.cancelOperation.apply(null, this.activationResponse).onErrorResume(PollContextRequiredException.class, new Function() { // from class: com.azure.core.util.polling.SyncOverAsyncPoller$$ExternalSyntheticLambda7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.f$0.m1281x4716b318((PollContextRequiredException) obj);
                }
            }).block();
        }
    }

    /* JADX INFO: renamed from: lambda$cancelOperation$11$com-azure-core-util-polling-SyncOverAsyncPoller, reason: not valid java name */
    /* synthetic */ Mono m1281x4716b318(PollContextRequiredException pollContextRequiredException) {
        PollingContext<T> pollingContextCopy = this.pollingContext.copy();
        return PollingUtil.pollingLoopAsync(pollingContextCopy, this.pollOperation, this.cancelOperation, this.fetchResultOperation, this.pollInterval).next().then(this.cancelOperation.apply(pollingContextCopy, this.activationResponse));
    }

    @Override // com.azure.core.util.polling.SyncPoller
    public SyncPoller<T, U> setPollInterval(Duration duration) {
        this.pollInterval = PollingUtil.validatePollInterval(duration, LOGGER);
        return this;
    }
}
