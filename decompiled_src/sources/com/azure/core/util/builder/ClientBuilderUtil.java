package com.azure.core.util.builder;

import com.azure.core.http.policy.HttpPipelinePolicy;
import com.azure.core.http.policy.RetryOptions;
import com.azure.core.http.policy.RetryPolicy;
import com.azure.core.util.logging.ClientLogger;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ClientBuilderUtil {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) ClientBuilderUtil.class);
    private static final RetryPolicy DEFAULT_RETRY_POLICY = new RetryPolicy();

    private ClientBuilderUtil() {
    }

    public static HttpPipelinePolicy validateAndGetRetryPolicy(HttpPipelinePolicy httpPipelinePolicy, RetryOptions retryOptions) {
        return validateAndGetRetryPolicy(httpPipelinePolicy, retryOptions, DEFAULT_RETRY_POLICY);
    }

    public static HttpPipelinePolicy validateAndGetRetryPolicy(HttpPipelinePolicy httpPipelinePolicy, RetryOptions retryOptions, HttpPipelinePolicy httpPipelinePolicy2) {
        Objects.requireNonNull(httpPipelinePolicy2, "'defaultPolicy' cannot be null.");
        if (httpPipelinePolicy != null && retryOptions != null) {
            throw LOGGER.logExceptionAsWarning(new IllegalStateException("'retryPolicy' and 'retryOptions' cannot both be set"));
        }
        if (httpPipelinePolicy != null) {
            return httpPipelinePolicy;
        }
        return retryOptions != null ? new RetryPolicy(retryOptions) : httpPipelinePolicy2;
    }
}
