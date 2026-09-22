package com.azure.core.http.policy;

import com.azure.core.http.HttpPipelineCallContext;
import com.azure.core.http.HttpPipelineNextPolicy;
import com.azure.core.http.HttpPipelineNextSyncPolicy;
import com.azure.core.http.HttpPipelinePosition;
import com.azure.core.http.HttpResponse;
import com.azure.core.implementation.http.HttpPipelineNextSyncPolicyHelper;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@FunctionalInterface
public interface HttpPipelinePolicy {
    Mono<HttpResponse> process(HttpPipelineCallContext httpPipelineCallContext, HttpPipelineNextPolicy httpPipelineNextPolicy);

    default HttpResponse processSync(HttpPipelineCallContext httpPipelineCallContext, HttpPipelineNextSyncPolicy httpPipelineNextSyncPolicy) {
        return (HttpResponse) process(httpPipelineCallContext, HttpPipelineNextSyncPolicyHelper.toAsyncPolicy(httpPipelineNextSyncPolicy)).block();
    }

    default HttpPipelinePosition getPipelinePosition() {
        return HttpPipelinePosition.PER_RETRY;
    }
}
