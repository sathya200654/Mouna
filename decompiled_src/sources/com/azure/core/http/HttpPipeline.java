package com.azure.core.http;

import com.azure.core.http.policy.HttpPipelinePolicy;
import com.azure.core.implementation.http.HttpPipelineCallState;
import com.azure.core.util.Context;
import com.azure.core.util.tracing.Tracer;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class HttpPipeline {
    private final HttpClient httpClient;
    private final HttpPipelinePolicy[] pipelinePolicies;
    private final Tracer tracer;

    HttpPipeline(HttpClient httpClient, List<HttpPipelinePolicy> list, Tracer tracer) {
        Objects.requireNonNull(httpClient, "'httpClient' cannot be null.");
        Objects.requireNonNull(list, "'pipelinePolicies' cannot be null.");
        this.httpClient = httpClient;
        this.pipelinePolicies = (HttpPipelinePolicy[]) list.toArray(new HttpPipelinePolicy[0]);
        this.tracer = tracer;
    }

    public HttpPipelinePolicy getPolicy(int i) {
        return this.pipelinePolicies[i];
    }

    public int getPolicyCount() {
        return this.pipelinePolicies.length;
    }

    public HttpClient getHttpClient() {
        return this.httpClient;
    }

    public Tracer getTracer() {
        return this.tracer;
    }

    public Mono<HttpResponse> send(HttpRequest httpRequest) {
        return send(new HttpPipelineCallContext(httpRequest));
    }

    public Mono<HttpResponse> send(HttpRequest httpRequest, Context context) {
        return send(new HttpPipelineCallContext(httpRequest, context));
    }

    public Mono<HttpResponse> send(final HttpPipelineCallContext httpPipelineCallContext) {
        return Mono.defer(new Supplier() { // from class: com.azure.core.http.HttpPipeline$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.m1122lambda$send$0$comazurecorehttpHttpPipeline(httpPipelineCallContext);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$send$0$com-azure-core-http-HttpPipeline, reason: not valid java name */
    /* synthetic */ Mono m1122lambda$send$0$comazurecorehttpHttpPipeline(HttpPipelineCallContext httpPipelineCallContext) {
        return new HttpPipelineNextPolicy(new HttpPipelineCallState(this, httpPipelineCallContext)).process();
    }

    public HttpResponse sendSync(HttpRequest httpRequest, Context context) {
        return new HttpPipelineNextSyncPolicy(new HttpPipelineCallState(this, new HttpPipelineCallContext(httpRequest, context))).processSync();
    }
}
