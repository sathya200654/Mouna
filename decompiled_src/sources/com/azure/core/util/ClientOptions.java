package com.azure.core.util;

import com.azure.core.util.logging.ClientLogger;
import java.util.Collections;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class ClientOptions {
    private static final String INVALID_APPLICATION_ID_SPACE = "'applicationId' cannot contain spaces.";
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) ClientOptions.class);
    private String applicationId;
    private Iterable<Header> headers;
    private MetricsOptions metricsOptions;
    private TracingOptions tracingOptions;

    public String getApplicationId() {
        return this.applicationId;
    }

    public ClientOptions setApplicationId(String str) {
        if (!CoreUtils.isNullOrEmpty(str) && str.contains(" ")) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(INVALID_APPLICATION_ID_SPACE));
        }
        this.applicationId = str;
        return this;
    }

    public ClientOptions setHeaders(Iterable<Header> iterable) {
        this.headers = iterable;
        return this;
    }

    public Iterable<Header> getHeaders() {
        Iterable<Header> iterable = this.headers;
        return iterable == null ? Collections.emptyList() : iterable;
    }

    public ClientOptions setMetricsOptions(MetricsOptions metricsOptions) {
        this.metricsOptions = metricsOptions;
        return this;
    }

    public MetricsOptions getMetricsOptions() {
        return this.metricsOptions;
    }

    public ClientOptions setTracingOptions(TracingOptions tracingOptions) {
        this.tracingOptions = tracingOptions;
        return this;
    }

    public TracingOptions getTracingOptions() {
        return this.tracingOptions;
    }
}
