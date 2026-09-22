package com.azure.core.http;

import com.azure.core.http.policy.HttpPipelinePolicy;
import com.azure.core.implementation.http.HttpPipelineCallState;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.logging.LogLevel;
import java.util.concurrent.Callable;
import java.util.function.Supplier;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class HttpPipelineNextPolicy {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) HttpPipelineNextPolicy.class);
    private final boolean originatedFromSyncPolicy;
    private final HttpPipelineCallState state;

    HttpPipelineNextPolicy(HttpPipelineCallState httpPipelineCallState) {
        this.state = httpPipelineCallState;
        this.originatedFromSyncPolicy = false;
    }

    HttpPipelineNextPolicy(HttpPipelineCallState httpPipelineCallState, boolean z) {
        this.state = httpPipelineCallState;
        this.originatedFromSyncPolicy = z;
    }

    public Mono<HttpResponse> process() {
        if (this.originatedFromSyncPolicy && !Schedulers.isInNonBlockingThread()) {
            return Mono.fromCallable(new Callable() { // from class: com.azure.core.http.HttpPipelineNextPolicy$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f$0.m1123lambda$process$0$comazurecorehttpHttpPipelineNextPolicy();
                }
            });
        }
        if (this.originatedFromSyncPolicy) {
            LOGGER.log(LogLevel.WARNING, new Supplier() { // from class: com.azure.core.http.HttpPipelineNextPolicy$$ExternalSyntheticLambda1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return this.f$0.m1124lambda$process$1$comazurecorehttpHttpPipelineNextPolicy();
                }
            });
        }
        HttpPipelinePolicy nextPolicy = this.state.getNextPolicy();
        if (nextPolicy == null) {
            return this.state.getPipeline().getHttpClient().send(this.state.getCallContext().getHttpRequest(), this.state.getCallContext().getContext());
        }
        return nextPolicy.process(this.state.getCallContext(), this);
    }

    /* JADX INFO: renamed from: lambda$process$0$com-azure-core-http-HttpPipelineNextPolicy, reason: not valid java name */
    /* synthetic */ HttpResponse m1123lambda$process$0$comazurecorehttpHttpPipelineNextPolicy() throws Exception {
        return new HttpPipelineNextSyncPolicy(this.state).processSync();
    }

    /* JADX INFO: renamed from: lambda$process$1$com-azure-core-http-HttpPipelineNextPolicy, reason: not valid java name */
    /* synthetic */ String m1124lambda$process$1$comazurecorehttpHttpPipelineNextPolicy() {
        return "The pipeline switched from synchronous to asynchronous. Check if " + this.state.getCurrentPolicy().getClass().getSimpleName() + " does not override HttpPipelinePolicy.processSync";
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public HttpPipelineNextPolicy m1125clone() {
        return new HttpPipelineNextPolicy(this.state.m1165clone(), this.originatedFromSyncPolicy);
    }
}
