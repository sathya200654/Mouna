package com.azure.core.implementation.http;

import com.azure.core.http.HttpPipeline;
import com.azure.core.http.HttpPipelineCallContext;
import com.azure.core.http.policy.HttpPipelinePolicy;
import com.azure.core.util.logging.ClientLogger;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class HttpPipelineCallState {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) HttpPipelineCallState.class);
    private final HttpPipelineCallContext callContext;
    private int currentPolicyIndex = -1;
    private final HttpPipeline pipeline;

    public HttpPipelineCallState(HttpPipeline httpPipeline, HttpPipelineCallContext httpPipelineCallContext) {
        this.pipeline = httpPipeline;
        this.callContext = httpPipelineCallContext;
    }

    public HttpPipelinePolicy getNextPolicy() {
        int policyCount = this.pipeline.getPolicyCount();
        int i = this.currentPolicyIndex + 1;
        this.currentPolicyIndex = i;
        if (i > policyCount) {
            throw LOGGER.logExceptionAsError(new IllegalStateException("There is no more policies to execute."));
        }
        if (i == policyCount) {
            return null;
        }
        return this.pipeline.getPolicy(i);
    }

    public HttpPipeline getPipeline() {
        return this.pipeline;
    }

    public HttpPipelinePolicy getCurrentPolicy() {
        return this.pipeline.getPolicy(this.currentPolicyIndex);
    }

    public HttpPipelineCallContext getCallContext() {
        return this.callContext;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public HttpPipelineCallState m1165clone() {
        HttpPipelineCallState httpPipelineCallState = new HttpPipelineCallState(this.pipeline, this.callContext);
        httpPipelineCallState.currentPolicyIndex = this.currentPolicyIndex;
        return httpPipelineCallState;
    }
}
