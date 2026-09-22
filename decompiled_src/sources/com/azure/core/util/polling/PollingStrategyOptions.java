package com.azure.core.util.polling;

import com.azure.core.http.HttpPipeline;
import com.azure.core.util.Context;
import com.azure.core.util.serializer.ObjectSerializer;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class PollingStrategyOptions {
    private Context context;
    private String endpoint;
    private final HttpPipeline httpPipeline;
    private ObjectSerializer serializer;
    private String serviceVersion;

    public PollingStrategyOptions(HttpPipeline httpPipeline) {
        this.httpPipeline = (HttpPipeline) Objects.requireNonNull(httpPipeline, "'httpPipeline' cannot be null");
    }

    public HttpPipeline getHttpPipeline() {
        return this.httpPipeline;
    }

    public String getEndpoint() {
        return this.endpoint;
    }

    public PollingStrategyOptions setEndpoint(String str) {
        this.endpoint = str;
        return this;
    }

    public ObjectSerializer getSerializer() {
        return this.serializer;
    }

    public PollingStrategyOptions setSerializer(ObjectSerializer objectSerializer) {
        this.serializer = objectSerializer;
        return this;
    }

    public Context getContext() {
        return this.context;
    }

    public PollingStrategyOptions setContext(Context context) {
        this.context = context;
        return this;
    }

    public String getServiceVersion() {
        return this.serviceVersion;
    }

    public PollingStrategyOptions setServiceVersion(String str) {
        this.serviceVersion = str;
        return this;
    }
}
