package com.azure.core.http.policy;

import com.azure.core.http.HttpHeaderName;
import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpPipelineCallContext;
import com.azure.core.http.HttpPipelineNextPolicy;
import com.azure.core.http.HttpPipelineNextSyncPolicy;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.HttpResponse;
import com.azure.core.implementation.ImplUtils;
import com.azure.core.implementation.logging.LoggingKeys;
import com.azure.core.util.BinaryData;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.logging.LoggingEventBuilder;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import reactor.core.Exceptions;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class RetryPolicy implements HttpPipelinePolicy {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) RetryPolicy.class);
    private final HttpHeaderName retryAfterHeader;
    private final ChronoUnit retryAfterTimeUnit;
    private final RetryStrategy retryStrategy;

    public RetryPolicy() {
        this(new ExponentialBackoff(), null, null);
    }

    public RetryPolicy(String str, ChronoUnit chronoUnit) {
        this(new ExponentialBackoff(), str, chronoUnit);
    }

    public RetryPolicy(RetryStrategy retryStrategy, String str, ChronoUnit chronoUnit) {
        this.retryStrategy = (RetryStrategy) Objects.requireNonNull(retryStrategy, "'retryStrategy' cannot be null.");
        this.retryAfterHeader = HttpHeaderName.fromString(str);
        this.retryAfterTimeUnit = chronoUnit;
        if (CoreUtils.isNullOrEmpty(str)) {
            return;
        }
        Objects.requireNonNull(chronoUnit, "'retryAfterTimeUnit' cannot be null.");
    }

    public RetryPolicy(RetryStrategy retryStrategy) {
        this(retryStrategy, null, null);
    }

    public RetryPolicy(RetryOptions retryOptions) {
        this(ImplUtils.getRetryStrategyFromOptions(retryOptions), null, null);
    }

    @Override // com.azure.core.http.policy.HttpPipelinePolicy
    public Mono<HttpResponse> process(final HttpPipelineCallContext httpPipelineCallContext, final HttpPipelineNextPolicy httpPipelineNextPolicy) {
        final HttpRequest httpRequest = httpPipelineCallContext.getHttpRequest();
        BinaryData bodyAsBinaryData = httpRequest.getBodyAsBinaryData();
        if (this.retryStrategy.getMaxRetries() > 0 && bodyAsBinaryData != null && !bodyAsBinaryData.isReplayable()) {
            return bodyAsBinaryData.toReplayableBinaryDataAsync().flatMap(new Function() { // from class: com.azure.core.http.policy.RetryPolicy$$ExternalSyntheticLambda5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.f$0.m1141lambda$process$0$comazurecorehttppolicyRetryPolicy(httpPipelineCallContext, httpPipelineNextPolicy, httpRequest, (BinaryData) obj);
                }
            });
        }
        return attemptAsync(httpPipelineCallContext, httpPipelineNextPolicy, httpRequest, 0, null);
    }

    /* JADX INFO: renamed from: lambda$process$0$com-azure-core-http-policy-RetryPolicy, reason: not valid java name */
    /* synthetic */ Mono m1141lambda$process$0$comazurecorehttppolicyRetryPolicy(HttpPipelineCallContext httpPipelineCallContext, HttpPipelineNextPolicy httpPipelineNextPolicy, HttpRequest httpRequest, BinaryData binaryData) {
        httpPipelineCallContext.getHttpRequest().setBody(binaryData);
        return attemptAsync(httpPipelineCallContext, httpPipelineNextPolicy, httpRequest, 0, null);
    }

    @Override // com.azure.core.http.policy.HttpPipelinePolicy
    public HttpResponse processSync(HttpPipelineCallContext httpPipelineCallContext, HttpPipelineNextSyncPolicy httpPipelineNextSyncPolicy) {
        HttpRequest httpRequest = httpPipelineCallContext.getHttpRequest();
        BinaryData bodyAsBinaryData = httpRequest.getBodyAsBinaryData();
        if (this.retryStrategy.getMaxRetries() > 0 && bodyAsBinaryData != null && !bodyAsBinaryData.isReplayable()) {
            httpPipelineCallContext.getHttpRequest().setBody(httpPipelineCallContext.getHttpRequest().getBodyAsBinaryData().toReplayableBinaryData());
        }
        return attemptSync(httpPipelineCallContext, httpPipelineNextSyncPolicy, httpRequest, 0, null);
    }

    private Mono<HttpResponse> attemptAsync(final HttpPipelineCallContext httpPipelineCallContext, final HttpPipelineNextPolicy httpPipelineNextPolicy, final HttpRequest httpRequest, final int i, final List<Throwable> list) {
        httpPipelineCallContext.setData(HttpLoggingPolicy.RETRY_COUNT_CONTEXT, Integer.valueOf(i + 1));
        httpPipelineCallContext.setHttpRequest(httpRequest.copy());
        return httpPipelineNextPolicy.m1125clone().process().flatMap(new Function() { // from class: com.azure.core.http.policy.RetryPolicy$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1139lambda$attemptAsync$1$comazurecorehttppolicyRetryPolicy(i, list, httpPipelineCallContext, httpPipelineNextPolicy, httpRequest, (HttpResponse) obj);
            }
        }).onErrorResume(Exception.class, new Function() { // from class: com.azure.core.http.policy.RetryPolicy$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1140lambda$attemptAsync$2$comazurecorehttppolicyRetryPolicy(i, list, httpPipelineCallContext, httpPipelineNextPolicy, httpRequest, (Exception) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attemptAsync$1$com-azure-core-http-policy-RetryPolicy, reason: not valid java name */
    /* synthetic */ Mono m1139lambda$attemptAsync$1$comazurecorehttppolicyRetryPolicy(int i, List list, HttpPipelineCallContext httpPipelineCallContext, HttpPipelineNextPolicy httpPipelineNextPolicy, HttpRequest httpRequest, HttpResponse httpResponse) {
        if (shouldRetry(this.retryStrategy, httpResponse, i, list)) {
            Duration durationDetermineDelayDuration = determineDelayDuration(httpResponse, i, this.retryStrategy, this.retryAfterHeader, this.retryAfterTimeUnit);
            logRetry(i, durationDetermineDelayDuration);
            httpResponse.close();
            return addBackoffDelay(attemptAsync(httpPipelineCallContext, httpPipelineNextPolicy, httpRequest, i + 1, list), durationDetermineDelayDuration);
        }
        if (i >= this.retryStrategy.getMaxRetries()) {
            logRetryExhausted(i);
        }
        return Mono.just(httpResponse);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: lambda$attemptAsync$2$com-azure-core-http-policy-RetryPolicy, reason: not valid java name */
    /* synthetic */ Mono m1140lambda$attemptAsync$2$comazurecorehttppolicyRetryPolicy(int i, List list, HttpPipelineCallContext httpPipelineCallContext, HttpPipelineNextPolicy httpPipelineNextPolicy, HttpRequest httpRequest, final Exception exc) {
        if (shouldRetryException(this.retryStrategy, exc, i, list)) {
            logRetryWithError(LOGGER.atVerbose(), i, "Error resume.", exc);
            if (list == null) {
                list = new LinkedList();
            }
            List list2 = list;
            list2.add(exc);
            return addBackoffDelay(attemptAsync(httpPipelineCallContext, httpPipelineNextPolicy, httpRequest, i + 1, list2), this.retryStrategy.calculateRetryDelay(i));
        }
        logRetryWithError(LOGGER.atError(), i, "Retry attempts have been exhausted.", exc);
        if (list != null) {
            Objects.requireNonNull(exc);
            list.forEach(new Consumer() { // from class: com.azure.core.http.policy.RetryPolicy$$ExternalSyntheticLambda2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    exc.addSuppressed((Throwable) obj);
                }
            });
        }
        return Mono.error(exc);
    }

    private Mono<HttpResponse> addBackoffDelay(Mono<HttpResponse> mono, Duration duration) {
        return (duration.isNegative() || duration.isZero()) ? mono : mono.delaySubscription(duration);
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    private HttpResponse attemptSync(HttpPipelineCallContext httpPipelineCallContext, HttpPipelineNextSyncPolicy httpPipelineNextSyncPolicy, HttpRequest httpRequest, int i, List<Throwable> list) {
        int i2 = i + 1;
        try {
            httpPipelineCallContext.setData(HttpLoggingPolicy.RETRY_COUNT_CONTEXT, Integer.valueOf(i2));
            httpPipelineCallContext.setHttpRequest(httpRequest.copy());
            HttpResponse httpResponseProcessSync = httpPipelineNextSyncPolicy.m1126clone().processSync();
            if (shouldRetry(this.retryStrategy, httpResponseProcessSync, i, list)) {
                Duration durationDetermineDelayDuration = determineDelayDuration(httpResponseProcessSync, i, this.retryStrategy, this.retryAfterHeader, this.retryAfterTimeUnit);
                logRetry(i, durationDetermineDelayDuration);
                httpResponseProcessSync.close();
                if (!durationDetermineDelayDuration.isNegative() && !durationDetermineDelayDuration.isZero()) {
                    try {
                        Thread.sleep(durationDetermineDelayDuration.toMillis());
                    } catch (InterruptedException e) {
                        throw LOGGER.logExceptionAsError(new RuntimeException(e));
                    }
                }
                return attemptSync(httpPipelineCallContext, httpPipelineNextSyncPolicy, httpRequest, i2, list);
            }
            if (i >= this.retryStrategy.getMaxRetries()) {
                logRetryExhausted(i);
            }
            return httpResponseProcessSync;
        } catch (RuntimeException e2) {
            if (shouldRetryException(this.retryStrategy, e2, i, list)) {
                logRetryWithError(LOGGER.atVerbose(), i, "Error resume.", e2);
                Duration durationCalculateRetryDelay = this.retryStrategy.calculateRetryDelay(i);
                if (!durationCalculateRetryDelay.isNegative() && !durationCalculateRetryDelay.isZero()) {
                    try {
                        Thread.sleep(durationCalculateRetryDelay.toMillis());
                    } catch (InterruptedException e3) {
                        e2.addSuppressed(e3);
                        throw LOGGER.logExceptionAsError(e2);
                    }
                }
                if (list == null) {
                    list = new LinkedList<>();
                }
                List<Throwable> list2 = list;
                list2.add(e2);
                return attemptSync(httpPipelineCallContext, httpPipelineNextSyncPolicy, httpRequest, i + 1, list2);
            }
            ClientLogger clientLogger = LOGGER;
            logRetryWithError(clientLogger.atError(), i, "Retry attempts have been exhausted.", e2);
            if (list != null) {
                Objects.requireNonNull(e2);
                list.forEach(new Consumer() { // from class: com.azure.core.http.policy.RetryPolicy$$ExternalSyntheticLambda4
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        e2.addSuppressed((Throwable) obj);
                    }
                });
            }
            throw clientLogger.logExceptionAsError(e2);
        }
    }

    private static boolean shouldRetry(RetryStrategy retryStrategy, HttpResponse httpResponse, int i, List<Throwable> list) {
        return i < retryStrategy.getMaxRetries() && retryStrategy.shouldRetryCondition(new RequestRetryCondition(httpResponse, null, i, list));
    }

    private static boolean shouldRetryException(RetryStrategy retryStrategy, Throwable th, int i, List<Throwable> list) {
        if (i >= retryStrategy.getMaxRetries()) {
            return false;
        }
        Throwable thUnwrap = Exceptions.unwrap(th);
        RequestRetryCondition requestRetryCondition = new RequestRetryCondition(null, thUnwrap, i, list);
        while (thUnwrap != null) {
            if (retryStrategy.shouldRetryCondition(requestRetryCondition)) {
                return true;
            }
            thUnwrap = thUnwrap.getCause();
            requestRetryCondition = new RequestRetryCondition(null, thUnwrap, i, list);
        }
        return false;
    }

    private static void logRetry(int i, Duration duration) {
        LOGGER.atVerbose().addKeyValue(LoggingKeys.TRY_COUNT_KEY, i).addKeyValue(LoggingKeys.DURATION_MS_KEY, duration.toMillis()).log("Retrying.");
    }

    private static void logRetryExhausted(int i) {
        LOGGER.atInfo().addKeyValue(LoggingKeys.TRY_COUNT_KEY, i).log("Retry attempts have been exhausted.");
    }

    private static void logRetryWithError(LoggingEventBuilder loggingEventBuilder, int i, String str, Throwable th) {
        loggingEventBuilder.addKeyValue(LoggingKeys.TRY_COUNT_KEY, i).log(str, th);
    }

    static Duration determineDelayDuration(HttpResponse httpResponse, int i, RetryStrategy retryStrategy, HttpHeaderName httpHeaderName, ChronoUnit chronoUnit) {
        if (httpHeaderName == null) {
            return getWellKnownRetryDelay(httpResponse.getHeaders(), i, retryStrategy, new Supplier() { // from class: com.azure.core.http.policy.RetryPolicy$$ExternalSyntheticLambda3
                @Override // java.util.function.Supplier
                public final Object get() {
                    return OffsetDateTime.now();
                }
            });
        }
        String headerValue = httpResponse.getHeaderValue(httpHeaderName);
        if (CoreUtils.isNullOrEmpty(headerValue)) {
            return retryStrategy.calculateRetryDelay(i);
        }
        return Duration.of(Integer.parseInt(headerValue), chronoUnit);
    }

    static Duration getWellKnownRetryDelay(HttpHeaders httpHeaders, int i, RetryStrategy retryStrategy, Supplier<OffsetDateTime> supplier) {
        Duration retryAfterFromHeaders = ImplUtils.getRetryAfterFromHeaders(httpHeaders, supplier);
        return retryAfterFromHeaders != null ? retryAfterFromHeaders : retryStrategy.calculateRetryDelay(i);
    }
}
