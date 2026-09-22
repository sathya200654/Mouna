package com.azure.core.util.polling;

import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.polling.implementation.PollContextRequiredException;
import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.Semaphore;
import java.util.function.BiFunction;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
final class SimpleSyncPoller<T, U> implements SyncPoller<T, U> {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) SimpleSyncPoller.class);
    private final PollResponse<T> activationResponse;
    private final BiFunction<PollingContext<T>, PollResponse<T>, T> cancelOperation;
    private final Function<PollingContext<T>, U> fetchResultOperation;
    private volatile Duration pollInterval;
    private final Function<PollingContext<T>, PollResponse<T>> pollOperation;
    private final PollingContext<T> pollingContext;
    private final Semaphore pollingSemaphore;
    private volatile PollingContext<T> terminalPollContext;

    SimpleSyncPoller(Duration duration, Function<PollingContext<T>, PollResponse<T>> function, Function<PollingContext<T>, PollResponse<T>> function2, BiFunction<PollingContext<T>, PollResponse<T>, T> biFunction, Function<PollingContext<T>, U> function3) {
        PollingContext<T> pollingContext = new PollingContext<>();
        this.pollingContext = pollingContext;
        this.pollingSemaphore = new Semaphore(1);
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
        try {
            this.pollingSemaphore.acquire();
            try {
                PollResponse<T> pollResponseApply = this.pollOperation.apply(this.pollingContext);
                this.pollingContext.setLatestResponse(pollResponseApply);
                if (pollResponseApply.getStatus().isComplete()) {
                    this.terminalPollContext = this.pollingContext.copy();
                }
                return pollResponseApply;
            } finally {
                this.pollingSemaphore.release();
            }
        } catch (InterruptedException e) {
            throw LOGGER.logExceptionAsError(new RuntimeException(e));
        }
    }

    @Override // com.azure.core.util.polling.SyncPoller
    public PollResponse<T> waitForCompletion() {
        return waitForCompletionHelper(null);
    }

    @Override // com.azure.core.util.polling.SyncPoller
    public PollResponse<T> waitForCompletion(Duration duration) {
        PollingUtil.validateTimeout(duration, LOGGER);
        return waitForCompletionHelper(duration);
    }

    @Override // com.azure.core.util.polling.SyncPoller
    public PollResponse<T> waitUntil(LongRunningOperationStatus longRunningOperationStatus) {
        Objects.requireNonNull(longRunningOperationStatus, "'statusToWaitFor' cannot be null.");
        return waitUntilHelper(null, longRunningOperationStatus);
    }

    @Override // com.azure.core.util.polling.SyncPoller
    public PollResponse<T> waitUntil(Duration duration, LongRunningOperationStatus longRunningOperationStatus) {
        PollingUtil.validateTimeout(duration, LOGGER);
        Objects.requireNonNull(longRunningOperationStatus, "'statusToWaitFor' cannot be null.");
        return waitUntilHelper(duration, longRunningOperationStatus);
    }

    private PollResponse<T> waitUntilHelper(Duration duration, LongRunningOperationStatus longRunningOperationStatus) {
        PollingContext<T> pollingContext = this.terminalPollContext;
        if (pollingContext != null) {
            return pollingContext.getLatestResponse();
        }
        PollingContext<T> pollingContextCopy = this.pollingContext.copy();
        PollResponse<T> pollResponsePollingLoop = PollingUtil.pollingLoop(pollingContextCopy, duration, longRunningOperationStatus, this.pollOperation, this.pollInterval, true);
        if (pollResponsePollingLoop.getStatus().isComplete()) {
            this.terminalPollContext = pollingContextCopy;
        }
        return pollResponsePollingLoop;
    }

    private PollResponse<T> waitForCompletionHelper(Duration duration) {
        PollingContext<T> pollingContext = this.terminalPollContext;
        if (pollingContext != null) {
            return pollingContext.getLatestResponse();
        }
        PollingContext<T> pollingContextCopy = this.pollingContext.copy();
        PollResponse<T> pollResponsePollingLoop = PollingUtil.pollingLoop(pollingContextCopy, duration, null, this.pollOperation, this.pollInterval, false);
        this.terminalPollContext = pollingContextCopy;
        return pollResponsePollingLoop;
    }

    @Override // com.azure.core.util.polling.SyncPoller
    public U getFinalResult() {
        return getFinalResultHelper(null);
    }

    @Override // com.azure.core.util.polling.SyncPoller
    public U getFinalResult(Duration duration) {
        PollingUtil.validateTimeout(duration, LOGGER);
        return getFinalResultHelper(duration);
    }

    private U getFinalResultHelper(Duration duration) {
        PollingContext<T> pollingContext = this.terminalPollContext;
        if (pollingContext != null) {
            return this.fetchResultOperation.apply(pollingContext);
        }
        PollingContext<T> pollingContextCopy = this.pollingContext.copy();
        PollingUtil.pollingLoop(pollingContextCopy, duration, null, this.pollOperation, this.pollInterval, false);
        this.terminalPollContext = pollingContextCopy;
        return getFinalResult();
    }

    @Override // com.azure.core.util.polling.SyncPoller
    public void cancelOperation() {
        PollingContext<T> pollingContextCopy = this.pollingContext.copy();
        if (pollingContextCopy.getActivationResponse() == pollingContextCopy.getLatestResponse()) {
            this.cancelOperation.apply(pollingContextCopy, pollingContextCopy.getActivationResponse());
            return;
        }
        try {
            this.cancelOperation.apply(null, this.activationResponse);
        } catch (PollContextRequiredException unused) {
            PollingContext<T> pollingContextCopy2 = this.pollingContext.copy();
            PollingUtil.pollingLoop(this.pollingContext, null, null, this.pollOperation, this.pollInterval, false);
            this.cancelOperation.apply(pollingContextCopy2, this.activationResponse);
        }
    }

    @Override // com.azure.core.util.polling.SyncPoller
    public SyncPoller<T, U> setPollInterval(Duration duration) {
        this.pollInterval = PollingUtil.validatePollInterval(duration, LOGGER);
        return this;
    }
}
