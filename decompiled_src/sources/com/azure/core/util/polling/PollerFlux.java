package com.azure.core.util.polling;

import com.azure.core.http.rest.Response;
import com.azure.core.util.FluxUtil;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.serializer.TypeReference;
import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import org.reactivestreams.Publisher;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class PollerFlux<T, U> extends Flux<AsyncPollResponse<T, U>> {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) PollerFlux.class);
    private final BiFunction<PollingContext<T>, PollResponse<T>, Mono<T>> cancelOperation;
    private final Function<PollingContext<T>, Mono<U>> fetchResultOperation;
    private final Mono<Boolean> oneTimeActivationMono;
    private volatile Duration pollInterval;
    private final Function<PollingContext<T>, Mono<PollResponse<T>>> pollOperation;
    private final PollingContext<T> rootContext;
    private final Function<PollingContext<T>, PollResponse<T>> syncActivationOperation;

    static /* synthetic */ void lambda$pollingLoop$19(PollingContext pollingContext) {
    }

    public PollerFlux(Duration duration, final Function<PollingContext<T>, Mono<T>> function, Function<PollingContext<T>, Mono<PollResponse<T>>> function2, BiFunction<PollingContext<T>, PollResponse<T>, Mono<T>> biFunction, Function<PollingContext<T>, Mono<U>> function3) {
        PollingContext<T> pollingContext = new PollingContext<>();
        this.rootContext = pollingContext;
        Objects.requireNonNull(duration, "'pollInterval' cannot be null.");
        if (duration.compareTo(Duration.ZERO) <= 0) {
            throw LOGGER.logExceptionAsWarning(new IllegalArgumentException("Negative or zero value for 'defaultPollInterval' is not allowed."));
        }
        this.pollInterval = duration;
        Objects.requireNonNull(function, "'activationOperation' cannot be null.");
        this.pollOperation = (Function) Objects.requireNonNull(function2, "'pollOperation' cannot be null.");
        this.cancelOperation = (BiFunction) Objects.requireNonNull(biFunction, "'cancelOperation' cannot be null.");
        this.fetchResultOperation = (Function) Objects.requireNonNull(function3, "'fetchResultOperation' cannot be null.");
        this.oneTimeActivationMono = new OneTimeActivation(pollingContext, function, new Function() { // from class: com.azure.core.util.polling.PollerFlux$$ExternalSyntheticLambda11
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return PollerFlux.lambda$new$0(obj);
            }
        }).getMono();
        this.syncActivationOperation = new Function() { // from class: com.azure.core.util.polling.PollerFlux$$ExternalSyntheticLambda13
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return PollerFlux.lambda$new$1(function, (PollingContext) obj);
            }
        };
    }

    static /* synthetic */ PollResponse lambda$new$0(Object obj) {
        return new PollResponse(LongRunningOperationStatus.NOT_STARTED, obj);
    }

    static /* synthetic */ PollResponse lambda$new$1(Function function, PollingContext pollingContext) {
        return new PollResponse(LongRunningOperationStatus.NOT_STARTED, ((Mono) function.apply(pollingContext)).block());
    }

    public static <T, U> PollerFlux<T, U> create(Duration duration, Function<PollingContext<T>, Mono<PollResponse<T>>> function, Function<PollingContext<T>, Mono<PollResponse<T>>> function2, BiFunction<PollingContext<T>, PollResponse<T>, Mono<T>> biFunction, Function<PollingContext<T>, Mono<U>> function3) {
        return new PollerFlux<>(duration, function, function2, biFunction, function3, true);
    }

    public static <T, U> PollerFlux<T, U> create(Duration duration, final Supplier<Mono<? extends Response<?>>> supplier, final PollingStrategy<T, U> pollingStrategy, final TypeReference<T> typeReference, final TypeReference<U> typeReference2) {
        Function function = new Function() { // from class: com.azure.core.util.polling.PollerFlux$$ExternalSyntheticLambda20
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((Mono) supplier.get()).flatMap(new Function() { // from class: com.azure.core.util.polling.PollerFlux$$ExternalSyntheticLambda19
                    @Override // java.util.function.Function
                    public final Object apply(Object obj2) {
                        PollingStrategy pollingStrategy2 = pollingStrategy;
                        Response response = (Response) obj2;
                        return pollingStrategy2.canPoll(response).flatMap(new Function() { // from class: com.azure.core.util.polling.PollerFlux$$ExternalSyntheticLambda18
                            @Override // java.util.function.Function
                            public final Object apply(Object obj3) {
                                return PollerFlux.lambda$create$2(pollingStrategy2, response, pollingContext, typeReference, (Boolean) obj3);
                            }
                        });
                    }
                });
            }
        };
        Function function2 = new Function() { // from class: com.azure.core.util.polling.PollerFlux$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return pollingStrategy.poll((PollingContext) obj, typeReference);
            }
        };
        Objects.requireNonNull(pollingStrategy);
        return create(duration, function, function2, new BiFunction() { // from class: com.azure.core.util.polling.PollerFlux$$ExternalSyntheticLambda2
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return pollingStrategy.cancel((PollingContext) obj, (PollResponse) obj2);
            }
        }, new Function() { // from class: com.azure.core.util.polling.PollerFlux$$ExternalSyntheticLambda3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return pollingStrategy.getResult((PollingContext) obj, typeReference2);
            }
        });
    }

    static /* synthetic */ Mono lambda$create$2(PollingStrategy pollingStrategy, Response response, PollingContext pollingContext, TypeReference typeReference, Boolean bool) {
        if (!bool.booleanValue()) {
            return Mono.error(new IllegalStateException("Cannot poll with strategy " + pollingStrategy.getClass().getSimpleName()));
        }
        return pollingStrategy.onInitialResponse(response, pollingContext, typeReference);
    }

    private PollerFlux(Duration duration, final Function<PollingContext<T>, Mono<PollResponse<T>>> function, Function<PollingContext<T>, Mono<PollResponse<T>>> function2, BiFunction<PollingContext<T>, PollResponse<T>, Mono<T>> biFunction, Function<PollingContext<T>, Mono<U>> function3, boolean z) {
        PollingContext<T> pollingContext = new PollingContext<>();
        this.rootContext = pollingContext;
        Objects.requireNonNull(duration, "'pollInterval' cannot be null.");
        if (duration.isNegative() || duration.isZero()) {
            throw LOGGER.logExceptionAsWarning(new IllegalArgumentException("Negative or zero value for 'pollInterval' is not allowed."));
        }
        this.pollInterval = duration;
        Objects.requireNonNull(function, "'activationOperation' cannot be null.");
        this.pollOperation = (Function) Objects.requireNonNull(function2, "'pollOperation' cannot be null.");
        this.cancelOperation = (BiFunction) Objects.requireNonNull(biFunction, "'cancelOperation' cannot be null.");
        this.fetchResultOperation = (Function) Objects.requireNonNull(function3, "'fetchResultOperation' cannot be null.");
        this.oneTimeActivationMono = new OneTimeActivation(pollingContext, function, Function.identity()).getMono();
        this.syncActivationOperation = new Function() { // from class: com.azure.core.util.polling.PollerFlux$$ExternalSyntheticLambda17
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return PollerFlux.lambda$new$7(function, (PollingContext) obj);
            }
        };
    }

    static /* synthetic */ PollResponse lambda$new$7(Function function, PollingContext pollingContext) {
        return (PollResponse) ((Mono) function.apply(pollingContext)).block();
    }

    public static <T, U> PollerFlux<T, U> error(final Exception exc) {
        return new PollerFlux<>(Duration.ofMillis(1L), new Function() { // from class: com.azure.core.util.polling.PollerFlux$$ExternalSyntheticLambda4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Mono.error(exc);
            }
        }, new Function() { // from class: com.azure.core.util.polling.PollerFlux$$ExternalSyntheticLambda5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Mono.error(exc);
            }
        }, new BiFunction() { // from class: com.azure.core.util.polling.PollerFlux$$ExternalSyntheticLambda6
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Mono.error(exc);
            }
        }, new Function() { // from class: com.azure.core.util.polling.PollerFlux$$ExternalSyntheticLambda7
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Mono.error(exc);
            }
        });
    }

    public PollerFlux<T, U> setPollInterval(Duration duration) {
        Objects.requireNonNull(duration, "'pollInterval' cannot be null.");
        if (duration.isNegative() || duration.isZero()) {
            throw LOGGER.logExceptionAsWarning(new IllegalArgumentException("Negative or zero value for 'pollInterval' is not allowed."));
        }
        this.pollInterval = duration;
        return this;
    }

    public Duration getPollInterval() {
        return this.pollInterval;
    }

    public void subscribe(CoreSubscriber<? super AsyncPollResponse<T, U>> coreSubscriber) {
        this.oneTimeActivationMono.flatMapMany(new Function() { // from class: com.azure.core.util.polling.PollerFlux$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1277lambda$subscribe$12$comazurecoreutilpollingPollerFlux((Boolean) obj);
            }
        }).subscribe(coreSubscriber);
    }

    /* JADX INFO: renamed from: lambda$subscribe$12$com-azure-core-util-polling-PollerFlux, reason: not valid java name */
    /* synthetic */ Publisher m1277lambda$subscribe$12$comazurecoreutilpollingPollerFlux(Boolean bool) {
        if (this.rootContext.getActivationResponse().getStatus().isComplete()) {
            return Flux.just(new AsyncPollResponse(this.rootContext, this.cancelOperation, this.fetchResultOperation));
        }
        return pollingLoop();
    }

    public SyncPoller<T, U> getSyncPoller() {
        return new SyncOverAsyncPoller(this.pollInterval, this.syncActivationOperation, this.pollOperation, this.cancelOperation, this.fetchResultOperation);
    }

    private Flux<AsyncPollResponse<T, U>> pollingLoop() {
        return Flux.using(new Callable() { // from class: com.azure.core.util.polling.PollerFlux$$ExternalSyntheticLambda14
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m1273lambda$pollingLoop$13$comazurecoreutilpollingPollerFlux();
            }
        }, new Function() { // from class: com.azure.core.util.polling.PollerFlux$$ExternalSyntheticLambda15
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1276lambda$pollingLoop$18$comazurecoreutilpollingPollerFlux((PollingContext) obj);
            }
        }, new Consumer() { // from class: com.azure.core.util.polling.PollerFlux$$ExternalSyntheticLambda16
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                PollerFlux.lambda$pollingLoop$19((PollingContext) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$pollingLoop$13$com-azure-core-util-polling-PollerFlux, reason: not valid java name */
    /* synthetic */ PollingContext m1273lambda$pollingLoop$13$comazurecoreutilpollingPollerFlux() throws Exception {
        return this.rootContext.copy();
    }

    /* JADX INFO: renamed from: lambda$pollingLoop$18$com-azure-core-util-polling-PollerFlux, reason: not valid java name */
    /* synthetic */ Publisher m1276lambda$pollingLoop$18$comazurecoreutilpollingPollerFlux(final PollingContext pollingContext) {
        return Mono.defer(new Supplier() { // from class: com.azure.core.util.polling.PollerFlux$$ExternalSyntheticLambda8
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.m1274lambda$pollingLoop$14$comazurecoreutilpollingPollerFlux(pollingContext);
            }
        }).switchIfEmpty(Mono.error(new Supplier() { // from class: com.azure.core.util.polling.PollerFlux$$ExternalSyntheticLambda9
            @Override // java.util.function.Supplier
            public final Object get() {
                return PollerFlux.lambda$pollingLoop$15();
            }
        })).repeat().takeUntil(new Predicate() { // from class: com.azure.core.util.polling.PollerFlux$$ExternalSyntheticLambda10
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((PollResponse) obj).getStatus().isComplete();
            }
        }).concatMap(new Function() { // from class: com.azure.core.util.polling.PollerFlux$$ExternalSyntheticLambda12
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1275lambda$pollingLoop$17$comazurecoreutilpollingPollerFlux(pollingContext, (PollResponse) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$pollingLoop$14$com-azure-core-util-polling-PollerFlux, reason: not valid java name */
    /* synthetic */ Mono m1274lambda$pollingLoop$14$comazurecoreutilpollingPollerFlux(PollingContext pollingContext) {
        return this.pollOperation.apply(pollingContext).delaySubscription(getDelay(pollingContext.getLatestResponse()));
    }

    static /* synthetic */ Throwable lambda$pollingLoop$15() {
        return new IllegalStateException("PollOperation returned Mono.empty().");
    }

    /* JADX INFO: renamed from: lambda$pollingLoop$17$com-azure-core-util-polling-PollerFlux, reason: not valid java name */
    /* synthetic */ Publisher m1275lambda$pollingLoop$17$comazurecoreutilpollingPollerFlux(PollingContext pollingContext, PollResponse pollResponse) {
        pollingContext.setLatestResponse(pollResponse);
        return Mono.just(new AsyncPollResponse(pollingContext, this.cancelOperation, this.fetchResultOperation));
    }

    private Duration getDelay(PollResponse<T> pollResponse) {
        Duration retryAfter = pollResponse.getRetryAfter();
        return (retryAfter == null || retryAfter.isNegative() || retryAfter.isZero()) ? this.pollInterval : retryAfter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class OneTimeActivation<V, R> {
        private final Function<PollingContext<V>, Mono<R>> activationFunction;
        private final Function<R, PollResponse<V>> activationPollResponseMapper;
        private final PollingContext<V> rootContext;
        private volatile boolean activated = false;
        private final AtomicBoolean guardActivation = new AtomicBoolean(false);

        OneTimeActivation(PollingContext<V> pollingContext, Function<PollingContext<V>, Mono<R>> function, Function<R, PollResponse<V>> function2) {
            this.rootContext = pollingContext;
            this.activationFunction = function;
            this.activationPollResponseMapper = function2;
        }

        Mono<Boolean> getMono() {
            return Mono.defer(new Supplier() { // from class: com.azure.core.util.polling.PollerFlux$OneTimeActivation$$ExternalSyntheticLambda3
                @Override // java.util.function.Supplier
                public final Object get() {
                    return this.f$0.m1280x845ccae4();
                }
            }).repeatWhenEmpty(new Function() { // from class: com.azure.core.util.polling.PollerFlux$OneTimeActivation$$ExternalSyntheticLambda4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ((Flux) obj).concatMap(new Function() { // from class: com.azure.core.util.polling.PollerFlux$OneTimeActivation$$ExternalSyntheticLambda5
                        @Override // java.util.function.Function
                        public final Object apply(Object obj2) {
                            return Flux.just(true);
                        }
                    });
                }
            });
        }

        /* JADX INFO: renamed from: lambda$getMono$3$com-azure-core-util-polling-PollerFlux$OneTimeActivation, reason: not valid java name */
        /* synthetic */ Mono m1280x845ccae4() {
            if (this.activated) {
                return Mono.just(true);
            }
            if (this.guardActivation.compareAndSet(false, true)) {
                try {
                    return this.activationFunction.apply(this.rootContext).map(this.activationPollResponseMapper).switchIfEmpty(Mono.fromSupplier(new Supplier() { // from class: com.azure.core.util.polling.PollerFlux$OneTimeActivation$$ExternalSyntheticLambda0
                        @Override // java.util.function.Supplier
                        public final Object get() {
                            return PollerFlux.OneTimeActivation.lambda$getMono$0();
                        }
                    })).map(new Function() { // from class: com.azure.core.util.polling.PollerFlux$OneTimeActivation$$ExternalSyntheticLambda1
                        @Override // java.util.function.Function
                        public final Object apply(Object obj) {
                            return this.f$0.m1278x6a829ca6((PollResponse) obj);
                        }
                    }).doOnError(new Consumer() { // from class: com.azure.core.util.polling.PollerFlux$OneTimeActivation$$ExternalSyntheticLambda2
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj) {
                            this.f$0.m1279xf76fb3c5((Throwable) obj);
                        }
                    });
                } catch (RuntimeException e) {
                    this.guardActivation.set(false);
                    return FluxUtil.monoError(PollerFlux.LOGGER, e);
                }
            }
            return Mono.empty();
        }

        static /* synthetic */ PollResponse lambda$getMono$0() {
            return new PollResponse(LongRunningOperationStatus.NOT_STARTED, null);
        }

        /* JADX INFO: renamed from: lambda$getMono$1$com-azure-core-util-polling-PollerFlux$OneTimeActivation, reason: not valid java name */
        /* synthetic */ Boolean m1278x6a829ca6(PollResponse pollResponse) {
            this.rootContext.setOnetimeActivationResponse(pollResponse);
            this.activated = true;
            return true;
        }

        /* JADX INFO: renamed from: lambda$getMono$2$com-azure-core-util-polling-PollerFlux$OneTimeActivation, reason: not valid java name */
        /* synthetic */ void m1279xf76fb3c5(Throwable th) {
            this.guardActivation.set(false);
        }
    }
}
