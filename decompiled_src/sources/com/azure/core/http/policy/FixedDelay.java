package com.azure.core.http.policy;

import com.azure.core.implementation.accesshelpers.FixedDelayAccessHelper;
import com.azure.core.util.logging.ClientLogger;
import java.time.Duration;
import java.util.Objects;
import java.util.function.Predicate;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class FixedDelay implements RetryStrategy {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) FixedDelay.class);
    private final Duration delay;
    private final int maxRetries;
    private final Predicate<RequestRetryCondition> shouldRetryCondition;

    public static /* synthetic */ FixedDelay $r8$lambda$7A3FTa7ViijxhQkJ3w07us_898g(FixedDelayOptions fixedDelayOptions, Predicate predicate) {
        return new FixedDelay(fixedDelayOptions, (Predicate<RequestRetryCondition>) predicate);
    }

    static {
        FixedDelayAccessHelper.setAccessor(new FixedDelayAccessHelper.FixedDelayAccessor() { // from class: com.azure.core.http.policy.FixedDelay$$ExternalSyntheticLambda0
            @Override // com.azure.core.implementation.accesshelpers.FixedDelayAccessHelper.FixedDelayAccessor
            public final FixedDelay create(FixedDelayOptions fixedDelayOptions, Predicate predicate) {
                return FixedDelay.$r8$lambda$7A3FTa7ViijxhQkJ3w07us_898g(fixedDelayOptions, predicate);
            }
        });
    }

    public FixedDelay(int i, Duration duration) {
        this(i, duration, null);
    }

    public FixedDelay(FixedDelayOptions fixedDelayOptions) {
        this(((FixedDelayOptions) Objects.requireNonNull(fixedDelayOptions, "'fixedDelayOptions' cannot be null.")).getMaxRetries(), ((FixedDelayOptions) Objects.requireNonNull(fixedDelayOptions, "'fixedDelayOptions' cannot be null.")).getDelay());
    }

    private FixedDelay(FixedDelayOptions fixedDelayOptions, Predicate<RequestRetryCondition> predicate) {
        this(((FixedDelayOptions) Objects.requireNonNull(fixedDelayOptions, "'fixedDelayOptions' cannot be null.")).getMaxRetries(), ((FixedDelayOptions) Objects.requireNonNull(fixedDelayOptions, "'fixedDelayOptions' cannot be null.")).getDelay(), predicate);
    }

    private FixedDelay(int i, Duration duration, Predicate<RequestRetryCondition> predicate) {
        if (i < 0) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("Max retries cannot be less than 0."));
        }
        this.maxRetries = i;
        this.delay = (Duration) Objects.requireNonNull(duration, "'delay' cannot be null.");
        this.shouldRetryCondition = predicate;
    }

    @Override // com.azure.core.http.policy.RetryStrategy
    public int getMaxRetries() {
        return this.maxRetries;
    }

    @Override // com.azure.core.http.policy.RetryStrategy
    public Duration calculateRetryDelay(int i) {
        return this.delay;
    }

    @Override // com.azure.core.http.policy.RetryStrategy
    public boolean shouldRetryCondition(RequestRetryCondition requestRetryCondition) {
        Predicate<RequestRetryCondition> predicate = this.shouldRetryCondition;
        if (predicate == null) {
            return super.shouldRetryCondition(requestRetryCondition);
        }
        return predicate.test(requestRetryCondition);
    }
}
