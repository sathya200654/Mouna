package com.azure.core.http.policy;

import java.util.Objects;
import java.util.function.Predicate;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class RetryOptions {
    private final ExponentialBackoffOptions exponentialBackoffOptions;
    private final FixedDelayOptions fixedDelayOptions;
    private Predicate<RequestRetryCondition> shouldRetryCondition;

    public RetryOptions(ExponentialBackoffOptions exponentialBackoffOptions) {
        this.exponentialBackoffOptions = (ExponentialBackoffOptions) Objects.requireNonNull(exponentialBackoffOptions, "'exponentialBackoffOptions' cannot be null.");
        this.fixedDelayOptions = null;
    }

    public RetryOptions(FixedDelayOptions fixedDelayOptions) {
        this.fixedDelayOptions = (FixedDelayOptions) Objects.requireNonNull(fixedDelayOptions, "'fixedDelayOptions' cannot be null.");
        this.exponentialBackoffOptions = null;
    }

    public ExponentialBackoffOptions getExponentialBackoffOptions() {
        return this.exponentialBackoffOptions;
    }

    public FixedDelayOptions getFixedDelayOptions() {
        return this.fixedDelayOptions;
    }

    public Predicate<RequestRetryCondition> getShouldRetryCondition() {
        return this.shouldRetryCondition;
    }

    public RetryOptions setShouldRetryCondition(Predicate<RequestRetryCondition> predicate) {
        this.shouldRetryCondition = predicate;
        return this;
    }
}
