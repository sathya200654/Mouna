package com.azure.core.http.policy;

import com.azure.core.http.HttpPipelineCallContext;
import com.azure.core.http.HttpPipelineNextPolicy;
import com.azure.core.http.HttpResponse;
import java.time.Duration;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Deprecated
public class TimeoutPolicy implements HttpPipelinePolicy {
    private final Duration timeoutDuration;

    public TimeoutPolicy(Duration duration) {
        this.timeoutDuration = duration;
    }

    @Override // com.azure.core.http.policy.HttpPipelinePolicy
    public Mono<HttpResponse> process(HttpPipelineCallContext httpPipelineCallContext, HttpPipelineNextPolicy httpPipelineNextPolicy) {
        return httpPipelineNextPolicy.process().timeout(this.timeoutDuration);
    }
}
