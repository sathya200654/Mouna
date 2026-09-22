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
public class ProtocolPolicy implements HttpPipelinePolicy {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) ProtocolPolicy.class);
    private final HttpPipelineSyncPolicy inner = new HttpPipelineSyncPolicy() { // from class: com.azure.core.http.policy.ProtocolPolicy.1
        @Override // com.azure.core.http.policy.HttpPipelineSyncPolicy
        protected void beforeSendingRequest(HttpPipelineCallContext httpPipelineCallContext) {
            UrlBuilder urlBuilder = UrlBuilder.parse(httpPipelineCallContext.getHttpRequest().getUrl());
            if (ProtocolPolicy.this.overwrite || urlBuilder.getScheme() == null) {
                ProtocolPolicy.LOGGER.atVerbose().addKeyValue("protocol", ProtocolPolicy.this.protocol).log("Setting protocol");
                try {
                    httpPipelineCallContext.getHttpRequest().setUrl(urlBuilder.setScheme(ProtocolPolicy.this.protocol).toUrl());
                } catch (MalformedURLException e) {
                    throw ProtocolPolicy.LOGGER.logExceptionAsError(new RuntimeException("Failed to set the HTTP request protocol to " + ProtocolPolicy.this.protocol + ".", e));
                }
            }
        }
    };
    private final boolean overwrite;
    private final String protocol;

    public ProtocolPolicy(String str, boolean z) {
        this.protocol = str;
        this.overwrite = z;
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
