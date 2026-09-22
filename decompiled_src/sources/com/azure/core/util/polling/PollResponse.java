package com.azure.core.util.polling;

import java.time.Duration;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class PollResponse<T> {
    private final Duration retryAfter;
    private final LongRunningOperationStatus status;
    private final T value;

    public PollResponse(LongRunningOperationStatus longRunningOperationStatus, T t, Duration duration) {
        Objects.requireNonNull(longRunningOperationStatus, "The status input parameter cannot be null.");
        this.status = longRunningOperationStatus;
        this.value = t;
        this.retryAfter = duration;
    }

    public PollResponse(LongRunningOperationStatus longRunningOperationStatus, T t) {
        this(longRunningOperationStatus, t, null);
    }

    public LongRunningOperationStatus getStatus() {
        return this.status;
    }

    public T getValue() {
        return this.value;
    }

    public Duration getRetryAfter() {
        return this.retryAfter;
    }
}
