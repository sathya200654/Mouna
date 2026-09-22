package com.azure.core.http.policy;

import com.azure.core.http.HttpPipelineCallContext;
import com.azure.core.http.HttpPipelineNextPolicy;
import com.azure.core.http.HttpPipelineNextSyncPolicy;
import com.azure.core.http.HttpResponse;
import java.util.concurrent.Callable;
import java.util.function.Function;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class HttpPipelineSyncPolicy implements HttpPipelinePolicy {
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: afterReceivedResponse, reason: merged with bridge method [inline-methods] */
    public HttpResponse m1136xdf0df28d(HttpPipelineCallContext httpPipelineCallContext, HttpResponse httpResponse) {
        return httpResponse;
    }

    protected void beforeSendingRequest(HttpPipelineCallContext httpPipelineCallContext) {
    }

    @Override // com.azure.core.http.policy.HttpPipelinePolicy
    public final Mono<HttpResponse> process(final HttpPipelineCallContext httpPipelineCallContext, final HttpPipelineNextPolicy httpPipelineNextPolicy) {
        return Mono.fromCallable(new Callable() { // from class: com.azure.core.http.policy.HttpPipelineSyncPolicy$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m1135x57f7b70b(httpPipelineCallContext, httpPipelineNextPolicy);
            }
        }).flatMap(new Function() { // from class: com.azure.core.http.policy.HttpPipelineSyncPolicy$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return httpPipelineNextPolicy.process();
            }
        }).map(new Function() { // from class: com.azure.core.http.policy.HttpPipelineSyncPolicy$$ExternalSyntheticLambda2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1136xdf0df28d(httpPipelineCallContext, (HttpResponse) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$process$0$com-azure-core-http-policy-HttpPipelineSyncPolicy, reason: not valid java name */
    /* synthetic */ HttpPipelineNextPolicy m1135x57f7b70b(HttpPipelineCallContext httpPipelineCallContext, HttpPipelineNextPolicy httpPipelineNextPolicy) throws Exception {
        beforeSendingRequest(httpPipelineCallContext);
        return httpPipelineNextPolicy;
    }

    @Override // com.azure.core.http.policy.HttpPipelinePolicy
    public final HttpResponse processSync(HttpPipelineCallContext httpPipelineCallContext, HttpPipelineNextSyncPolicy httpPipelineNextSyncPolicy) {
        beforeSendingRequest(httpPipelineCallContext);
        return m1136xdf0df28d(httpPipelineCallContext, httpPipelineNextSyncPolicy.processSync());
    }
}
