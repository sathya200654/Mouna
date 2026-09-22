package com.azure.core.http;

import com.azure.core.http.policy.HttpPipelinePolicy;
import com.azure.core.implementation.http.HttpPipelineCallState;
import com.azure.core.implementation.http.HttpPipelineNextSyncPolicyHelper;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class HttpPipelineNextSyncPolicy {
    private final HttpPipelineCallState state;

    static {
        HttpPipelineNextSyncPolicyHelper.setAccessor(new HttpPipelineNextSyncPolicyHelper.HttpPipelineNextSyncPolicyAccessor() { // from class: com.azure.core.http.HttpPipelineNextSyncPolicy$$ExternalSyntheticLambda0
            @Override // com.azure.core.implementation.http.HttpPipelineNextSyncPolicyHelper.HttpPipelineNextSyncPolicyAccessor
            public final HttpPipelineNextPolicy toAsyncPolicy(HttpPipelineNextSyncPolicy httpPipelineNextSyncPolicy) {
                return httpPipelineNextSyncPolicy.toAsyncPolicy();
            }
        });
    }

    HttpPipelineNextSyncPolicy(HttpPipelineCallState httpPipelineCallState) {
        this.state = httpPipelineCallState;
    }

    public HttpResponse processSync() {
        HttpPipelinePolicy nextPolicy = this.state.getNextPolicy();
        if (nextPolicy == null) {
            return this.state.getPipeline().getHttpClient().sendSync(this.state.getCallContext().getHttpRequest(), this.state.getCallContext().getContext());
        }
        return nextPolicy.processSync(this.state.getCallContext(), this);
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public HttpPipelineNextSyncPolicy m1126clone() {
        return new HttpPipelineNextSyncPolicy(this.state.m1165clone());
    }

    HttpPipelineNextPolicy toAsyncPolicy() {
        return new HttpPipelineNextPolicy(this.state, true);
    }
}
