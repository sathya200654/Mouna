package com.azure.core.client.traits;

import com.azure.core.client.traits.HttpTrait;
import com.azure.core.http.HttpClient;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.policy.HttpLogOptions;
import com.azure.core.http.policy.HttpPipelinePolicy;
import com.azure.core.http.policy.RetryOptions;
import com.azure.core.util.ClientOptions;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface HttpTrait<T extends HttpTrait<T>> {
    T addPolicy(HttpPipelinePolicy httpPipelinePolicy);

    T clientOptions(ClientOptions clientOptions);

    T httpClient(HttpClient httpClient);

    T httpLogOptions(HttpLogOptions httpLogOptions);

    T pipeline(HttpPipeline httpPipeline);

    T retryOptions(RetryOptions retryOptions);
}
