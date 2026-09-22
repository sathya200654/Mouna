package com.azure.core.http.policy;

import com.azure.core.http.HttpPipelineCallContext;
import com.azure.core.http.HttpPipelineNextPolicy;
import com.azure.core.http.HttpPipelineNextSyncPolicy;
import com.azure.core.http.HttpResponse;
import com.azure.core.util.UrlBuilder;
import com.azure.core.util.logging.ClientLogger;
import java.net.MalformedURLException;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class HostPolicy implements HttpPipelinePolicy {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) HostPolicy.class);
    private final String host;
    private final HttpPipelineSyncPolicy inner = new HttpPipelineSyncPolicy() { // from class: com.azure.core.http.policy.HostPolicy.1
        @Override // com.azure.core.http.policy.HttpPipelineSyncPolicy
        protected void beforeSendingRequest(HttpPipelineCallContext httpPipelineCallContext) {
            HostPolicy.LOGGER.atVerbose().addKeyValue("host", HostPolicy.this.host).log("Setting host");
            try {
                httpPipelineCallContext.getHttpRequest().setUrl(UrlBuilder.parse(httpPipelineCallContext.getHttpRequest().getUrl()).setHost(HostPolicy.this.host).toUrl());
            } catch (MalformedURLException e) {
                throw HostPolicy.LOGGER.logExceptionAsError(new RuntimeException(String.format("Host URL '%s' is invalid.", HostPolicy.this.host), e));
            }
        }
    };

    public HostPolicy(String str) {
        this.host = str;
    }

    @Override // com.azure.core.http.policy.HttpPipelinePolicy
    public Mono<HttpResponse> process(HttpPipelineCallContext httpPipelineCallContext, HttpPipelineNextPolicy httpPipelineNextPolicy) {
        return this.inner.process(httpPipelineCallContext, httpPipelineNextPolicy);
    }

    @Override // com.azure.core.http.policy.HttpPipelinePolicy
    public HttpResponse processSync(HttpPipelineCallContext httpPipelineCallContext, HttpPipelineNextSyncPolicy httpPipelineNextSyncPolicy) {
        return this.inner.processSync(httpPipelineCallContext, httpPipelineNextSyncPolicy);
    }
}
