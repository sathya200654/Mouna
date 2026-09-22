package com.azure.core.http.policy;

import com.azure.core.util.logging.ClientLogger;
import java.time.Duration;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class ExponentialBackoffOptions {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) ExponentialBackoffOptions.class);
    private Duration baseDelay;
    private Duration maxDelay;
    private Integer maxRetries;

    public Integer getMaxRetries() {
        return this.maxRetries;
    }

    public ExponentialBackoffOptions setMaxRetries(Integer num) {
        if (num != null && num.intValue() < 0) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("Max retries cannot be less than 0."));
        }
        this.maxRetries = num;
        return this;
    }

    public Duration getBaseDelay() {
        return this.baseDelay;
    }

    public ExponentialBackoffOptions setBaseDelay(Duration duration) {
        validateDelays(duration, this.maxDelay);
        this.baseDelay = duration;
        return this;
    }

    public Duration getMaxDelay() {
        return this.maxDelay;
    }

    public ExponentialBackoffOptions setMaxDelay(Duration duration) {
        validateDelays(this.baseDelay, duration);
        this.maxDelay = duration;
        return this;
    }

    private void validateDelays(Duration duration, Duration duration2) {
        if (duration != null && (duration.isZero() || duration.isNegative())) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("'baseDelay' cannot be negative or 0."));
        }
        if (duration2 != null && (duration2.isZero() || duration2.isNegative())) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("'maxDelay' cannot be negative or 0."));
        }
        if (duration != null && duration2 != null && duration.compareTo(duration2) > 0) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("'baseDelay' cannot be greater than 'maxDelay'."));
        }
    }
}
