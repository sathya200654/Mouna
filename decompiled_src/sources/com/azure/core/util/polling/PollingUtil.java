package com.azure.core.util.polling;

import com.azure.core.http.HttpHeader;
import com.azure.core.http.HttpHeaderName;
import com.azure.core.http.rest.Response;
import com.azure.core.implementation.ImplUtils;
import com.azure.core.util.SharedExecutorService;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.polling.implementation.PollingUtils;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
class PollingUtil {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) PollingUtil.class);

    static /* synthetic */ PollingContext lambda$pollingLoopAsync$2(PollingContext pollingContext) throws Exception {
        return pollingContext;
    }

    static /* synthetic */ void lambda$pollingLoopAsync$8(PollingContext pollingContext) {
    }

    PollingUtil() {
    }

    static <T> PollResponse<T> pollingLoop(final PollingContext<T> pollingContext, Duration duration, LongRunningOperationStatus longRunningOperationStatus, final Function<PollingContext<T>, PollResponse<T>> function, Duration duration2, boolean z) {
        boolean z2;
        Future<T> futureSchedule;
        boolean z3 = true;
        boolean z4 = duration != null;
        long millis = z4 ? duration.toMillis() : -1L;
        long jCurrentTimeMillis = System.currentTimeMillis();
        PollResponse<T> latestResponse = pollingContext.getLatestResponse();
        while (!latestResponse.getStatus().isComplete()) {
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            if (z4 && jCurrentTimeMillis2 >= millis) {
                if (!latestResponse.getStatus().equals(longRunningOperationStatus) && !z) {
                    throw LOGGER.logExceptionAsError(new RuntimeException(new TimeoutException("Polling didn't complete before the timeout period.")));
                }
                break;
                break;
            }
            if (latestResponse.getStatus().equals(longRunningOperationStatus)) {
                break;
            }
            if (z3) {
                futureSchedule = SharedExecutorService.getInstance().submit(new Callable() { // from class: com.azure.core.util.polling.PollingUtil$$ExternalSyntheticLambda0
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return PollingUtil.lambda$pollingLoop$0(function, pollingContext);
                    }
                });
                z2 = false;
            } else {
                z2 = z3;
                futureSchedule = SharedExecutorService.getInstance().schedule(new Callable() { // from class: com.azure.core.util.polling.PollingUtil$$ExternalSyntheticLambda1
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return PollingUtil.lambda$pollingLoop$1(function, pollingContext);
                    }
                }, getDelay(latestResponse, duration2).toMillis(), TimeUnit.MILLISECONDS);
            }
            try {
                PollResponse<T> pollResponse = (PollResponse) ImplUtils.getResultWithTimeout(futureSchedule, z4 ? millis - jCurrentTimeMillis2 : -1L);
                try {
                    pollingContext.setLatestResponse(pollResponse);
                    latestResponse = pollResponse;
                    z3 = z2;
                } catch (InterruptedException | ExecutionException | TimeoutException e) {
                    e = e;
                    latestResponse = pollResponse;
                    if (z) {
                        return latestResponse;
                    }
                    throw LOGGER.logExceptionAsError(new RuntimeException(e));
                }
            } catch (InterruptedException | ExecutionException | TimeoutException e2) {
                e = e2;
            }
        }
        return latestResponse;
    }

    static /* synthetic */ PollResponse lambda$pollingLoop$0(Function function, PollingContext pollingContext) throws Exception {
        return (PollResponse) function.apply(pollingContext);
    }

    static /* synthetic */ PollResponse lambda$pollingLoop$1(Function function, PollingContext pollingContext) throws Exception {
        return (PollResponse) function.apply(pollingContext);
    }

    static <T, U> Flux<AsyncPollResponse<T, U>> pollingLoopAsync(final PollingContext<T> pollingContext, final Function<PollingContext<T>, Mono<PollResponse<T>>> function, final BiFunction<PollingContext<T>, PollResponse<T>, Mono<T>> biFunction, final Function<PollingContext<T>, Mono<U>> function2, final Duration duration) {
        return Flux.using(new Callable() { // from class: com.azure.core.util.polling.PollingUtil$$ExternalSyntheticLambda6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PollingUtil.lambda$pollingLoopAsync$2(pollingContext);
            }
        }, new Function() { // from class: com.azure.core.util.polling.PollingUtil$$ExternalSyntheticLambda7
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                PollingContext pollingContext2 = (PollingContext) obj;
                return Mono.defer(new Supplier() { // from class: com.azure.core.util.polling.PollingUtil$$ExternalSyntheticLambda2
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return PollingUtil.lambda$pollingLoopAsync$3(function, pollingContext2);
                    }
                }).delaySubscription(PollingUtil.getDelay(pollingContext2.getLatestResponse(), duration)).switchIfEmpty(Mono.error(new Supplier() { // from class: com.azure.core.util.polling.PollingUtil$$ExternalSyntheticLambda3
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return PollingUtil.lambda$pollingLoopAsync$4();
                    }
                })).repeat().takeUntil(new Predicate() { // from class: com.azure.core.util.polling.PollingUtil$$ExternalSyntheticLambda4
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj2) {
                        return ((PollResponse) obj2).getStatus().isComplete();
                    }
                }).concatMap(new Function() { // from class: com.azure.core.util.polling.PollingUtil$$ExternalSyntheticLambda5
                    @Override // java.util.function.Function
                    public final Object apply(Object obj2) {
                        return PollingUtil.lambda$pollingLoopAsync$6(pollingContext2, biFunction, function, (PollResponse) obj2);
                    }
                });
            }
        }, new Consumer() { // from class: com.azure.core.util.polling.PollingUtil$$ExternalSyntheticLambda8
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                PollingUtil.lambda$pollingLoopAsync$8((PollingContext) obj);
            }
        });
    }

    static /* synthetic */ Mono lambda$pollingLoopAsync$3(Function function, PollingContext pollingContext) {
        return (Mono) function.apply(pollingContext);
    }

    static /* synthetic */ Throwable lambda$pollingLoopAsync$4() {
        return new IllegalStateException("PollOperation returned Mono.empty().");
    }

    static /* synthetic */ Publisher lambda$pollingLoopAsync$6(PollingContext pollingContext, BiFunction biFunction, Function function, PollResponse pollResponse) {
        pollingContext.setLatestResponse(pollResponse);
        return Mono.just(new AsyncPollResponse(pollingContext, biFunction, function));
    }

    private static <T> Duration getDelay(PollResponse<T> pollResponse, Duration duration) {
        Duration retryAfter = pollResponse.getRetryAfter();
        return (retryAfter != null && retryAfter.compareTo(Duration.ZERO) > 0) ? retryAfter : duration;
    }

    static <T, U> PollResponse<T> toPollResponse(AsyncPollResponse<T, U> asyncPollResponse) {
        return new PollResponse<>(asyncPollResponse.getStatus(), asyncPollResponse.getValue(), asyncPollResponse.getRetryAfter());
    }

    static boolean matchStatus(AsyncPollResponse<?, ?> asyncPollResponse, LongRunningOperationStatus longRunningOperationStatus) {
        return (asyncPollResponse == null || longRunningOperationStatus == null || longRunningOperationStatus != asyncPollResponse.getStatus()) ? false : true;
    }

    static boolean locationCanPoll(Response<?> response, String str, ClientLogger clientLogger) {
        HttpHeader httpHeader = response.getHeaders().get(HttpHeaderName.LOCATION);
        if (httpHeader != null) {
            try {
                ImplUtils.createUrl(PollingUtils.getAbsolutePath(httpHeader.getValue(), str, clientLogger));
                return true;
            } catch (MalformedURLException e) {
                clientLogger.info("Failed to parse Location header into a URL.", e);
            }
        }
        return false;
    }

    static boolean operationResourceCanPoll(Response<?> response, HttpHeaderName httpHeaderName, String str, ClientLogger clientLogger) {
        HttpHeader httpHeader = response.getHeaders().get(httpHeaderName);
        if (httpHeader != null) {
            try {
                ImplUtils.createUrl(PollingUtils.getAbsolutePath(httpHeader.getValue(), str, clientLogger));
                return true;
            } catch (MalformedURLException unused) {
            }
        }
        return false;
    }

    static void validateTimeout(Duration duration, ClientLogger clientLogger) {
        Objects.requireNonNull(duration, "'timeout' cannot be null.");
        if (duration.isNegative() || duration.isZero()) {
            throw clientLogger.logExceptionAsWarning(new IllegalArgumentException("Negative or zero value for timeout is not allowed."));
        }
    }

    static Duration validatePollInterval(Duration duration, ClientLogger clientLogger) {
        Objects.requireNonNull(duration, "'pollInterval' cannot be null.");
        if (duration.isNegative() || duration.isZero()) {
            throw clientLogger.logExceptionAsWarning(new IllegalArgumentException("Negative or zero value for pollInterval is not allowed."));
        }
        return duration;
    }
}
