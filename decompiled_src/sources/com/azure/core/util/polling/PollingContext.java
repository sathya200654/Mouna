package com.azure.core.util.polling;

import com.azure.core.util.logging.ClientLogger;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class PollingContext<T> {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) PollingContext.class);
    private volatile PollResponse<T> activationResponse;
    private volatile PollResponse<T> latestResponse;
    private final Map<String, String> map;

    public String getData(String str) {
        return this.map.get(str);
    }

    public PollingContext<T> setData(String str, String str2) {
        this.map.put(str, str2);
        return this;
    }

    public PollResponse<T> getActivationResponse() {
        return this.activationResponse;
    }

    public PollResponse<T> getLatestResponse() {
        return this.latestResponse;
    }

    void setLatestResponse(PollResponse<T> pollResponse) {
        this.latestResponse = (PollResponse) Objects.requireNonNull(pollResponse, "'latestResponse' is required.");
    }

    void setOnetimeActivationResponse(PollResponse<T> pollResponse) {
        if (this.activationResponse != null) {
            throw LOGGER.logExceptionAsError(new IllegalStateException("setOnetimeActivationResponse can be called only once."));
        }
        this.activationResponse = pollResponse;
        this.latestResponse = this.activationResponse;
    }

    PollingContext<T> copy() {
        return new PollingContext<>(this.activationResponse, this.latestResponse, new HashMap(this.map));
    }

    PollingContext() {
        this.map = new HashMap();
    }

    private PollingContext(PollResponse<T> pollResponse, PollResponse<T> pollResponse2, Map<String, String> map) {
        this.activationResponse = (PollResponse) Objects.requireNonNull(pollResponse, "'activationResponse' cannot be null.");
        this.latestResponse = (PollResponse) Objects.requireNonNull(pollResponse2, "'latestResponse' cannot be null.");
        this.map = map;
    }
}
