package com.azure.core.http.policy;

import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpPipelineCallContext;
import com.azure.core.http.HttpPipelineNextPolicy;
import com.azure.core.http.HttpPipelineNextSyncPolicy;
import com.azure.core.http.HttpResponse;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class AddHeadersPolicy implements HttpPipelinePolicy {
    private final HttpHeaders headers;

    public AddHeadersPolicy(HttpHeaders httpHeaders) {
        this.headers = httpHeaders;
    }

    @Override // com.azure.core.http.policy.HttpPipelinePolicy
    public Mono<HttpResponse> process(HttpPipelineCallContext httpPipelineCallContext, HttpPipelineNextPolicy httpPipelineNextPolicy) {
        setHeaders(httpPipelineCallContext.getHttpRequest().getHeaders(), this.headers);
        return httpPipelineNextPolicy.process();
    }

    @Override // com.azure.core.http.policy.HttpPipelinePolicy
    public HttpResponse processSync(HttpPipelineCallContext httpPipelineCallContext, HttpPipelineNextSyncPolicy httpPipelineNextSyncPolicy) {
        setHeaders(httpPipelineCallContext.getHttpRequest().getHeaders(), this.headers);
        return httpPipelineNextSyncPolicy.processSync();
    }

    private static void setHeaders(HttpHeaders httpHeaders, HttpHeaders httpHeaders2) {
        httpHeaders.setAllHttpHeaders(httpHeaders2);
    }
}
