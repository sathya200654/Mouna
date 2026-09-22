package com.azure.core.implementation.http;

import com.azure.core.http.HttpPipelineNextPolicy;
import com.azure.core.http.HttpPipelineNextSyncPolicy;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class HttpPipelineNextSyncPolicyHelper {
    private static HttpPipelineNextSyncPolicyAccessor accessor;

    public interface HttpPipelineNextSyncPolicyAccessor {
        HttpPipelineNextPolicy toAsyncPolicy(HttpPipelineNextSyncPolicy httpPipelineNextSyncPolicy);
    }

    private HttpPipelineNextSyncPolicyHelper() {
    }

    public static void setAccessor(HttpPipelineNextSyncPolicyAccessor httpPipelineNextSyncPolicyAccessor) {
        accessor = httpPipelineNextSyncPolicyAccessor;
    }

    public static HttpPipelineNextPolicy toAsyncPolicy(HttpPipelineNextSyncPolicy httpPipelineNextSyncPolicy) {
        return accessor.toAsyncPolicy(httpPipelineNextSyncPolicy);
    }
}
