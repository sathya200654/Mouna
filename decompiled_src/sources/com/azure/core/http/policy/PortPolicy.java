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
public class PortPolicy implements HttpPipelinePolicy {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) PortPolicy.class);
    private final HttpPipelineSyncPolicy inner = new HttpPipelineSyncPolicy() { // from class: com.azure.core.http.policy.PortPolicy.1
        @Override // com.azure.core.http.policy.HttpPipelineSyncPolicy
        protected void beforeSendingRequest(HttpPipelineCallContext httpPipelineCallContext) {
            UrlBuilder urlBuilder = UrlBuilder.parse(httpPipelineCallContext.getHttpRequest().getUrl());
            if (PortPolicy.this.overwrite || urlBuilder.getPort() == null) {
                PortPolicy.LOGGER.atVerbose().addKeyValue("port", PortPolicy.this.port).log("Changing host");
                try {
                    httpPipelineCallContext.getHttpRequest().setUrl(urlBuilder.setPort(PortPolicy.this.port).toUrl());
                } catch (MalformedURLException e) {
                    throw PortPolicy.LOGGER.logExceptionAsError(new RuntimeException("Failed to set the HTTP request port to " + PortPolicy.this.port + ".", e));
                }
            }
        }
    };
    private final boolean overwrite;
    private final int port;

    public PortPolicy(int i, boolean z) {
        this.port = i;
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
