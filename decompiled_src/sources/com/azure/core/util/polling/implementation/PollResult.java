package com.azure.core.util.polling.implementation;

import com.azure.core.util.polling.LongRunningOperationStatus;
import com.fasterxml.jackson.annotation.JsonSetter;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class PollResult {
    private String resourceLocation;
    private LongRunningOperationStatus status;

    public LongRunningOperationStatus getStatus() {
        return this.status;
    }

    @JsonSetter
    public PollResult setStatus(String str) {
        if (PollingConstants.STATUS_NOT_STARTED.equalsIgnoreCase(str)) {
            this.status = LongRunningOperationStatus.NOT_STARTED;
            return this;
        }
        if (PollingConstants.STATUS_IN_PROGRESS.equalsIgnoreCase(str) || PollingConstants.STATUS_RUNNING.equalsIgnoreCase(str)) {
            this.status = LongRunningOperationStatus.IN_PROGRESS;
            return this;
        }
        if (PollingConstants.STATUS_SUCCEEDED.equalsIgnoreCase(str)) {
            this.status = LongRunningOperationStatus.SUCCESSFULLY_COMPLETED;
            return this;
        }
        if (PollingConstants.STATUS_FAILED.equalsIgnoreCase(str)) {
            this.status = LongRunningOperationStatus.FAILED;
            return this;
        }
        if (PollingConstants.STATUS_CANCELLED.equalsIgnoreCase(str)) {
            this.status = LongRunningOperationStatus.USER_CANCELLED;
            return this;
        }
        this.status = LongRunningOperationStatus.fromString(str, false);
        return this;
    }

    public PollResult setStatus(LongRunningOperationStatus longRunningOperationStatus) {
        this.status = longRunningOperationStatus;
        return this;
    }

    public String getResourceLocation() {
        return this.resourceLocation;
    }

    public PollResult setResourceLocation(String str) {
        this.resourceLocation = str;
        return this;
    }
}
