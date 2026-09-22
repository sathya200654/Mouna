package com.azure.core.http.policy;

import com.azure.core.util.logging.ClientLogger;
import java.time.Duration;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class FixedDelayOptions {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) FixedDelayOptions.class);
    private final Duration delay;
    private final int maxRetries;

    public FixedDelayOptions(int i, Duration duration) {
        if (i < 0) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("Max retries cannot be less than 0."));
        }
        this.maxRetries = i;
        this.delay = (Duration) Objects.requireNonNull(duration, "'delay' cannot be null.");
    }

    public int getMaxRetries() {
        return this.maxRetries;
    }

    public Duration getDelay() {
        return this.delay;
    }
}
