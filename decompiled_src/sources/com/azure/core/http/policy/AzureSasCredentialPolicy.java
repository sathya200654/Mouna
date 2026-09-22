package com.azure.core.http.policy;

import androidx.webkit.ProxyConfig;
import com.azure.core.credential.AzureSasCredential;
import com.azure.core.http.HttpPipelineCallContext;
import com.azure.core.http.HttpPipelineNextPolicy;
import com.azure.core.http.HttpPipelineNextSyncPolicy;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.HttpResponse;
import com.azure.core.util.logging.ClientLogger;
import java.util.Objects;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class AzureSasCredentialPolicy implements HttpPipelinePolicy {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) AzureSasCredentialPolicy.class);
    private final AzureSasCredential credential;
    private final HttpPipelineSyncPolicy inner;
    private final boolean requireHttps;

    public AzureSasCredentialPolicy(AzureSasCredential azureSasCredential) {
        this(azureSasCredential, true);
    }

    public AzureSasCredentialPolicy(AzureSasCredential azureSasCredential, boolean z) {
        this.inner = new HttpPipelineSyncPolicy() { // from class: com.azure.core.http.policy.AzureSasCredentialPolicy.1
            @Override // com.azure.core.http.policy.HttpPipelineSyncPolicy
            protected void beforeSendingRequest(HttpPipelineCallContext httpPipelineCallContext) {
                String str;
                HttpRequest httpRequest = httpPipelineCallContext.getHttpRequest();
                if (!AzureSasCredentialPolicy.this.requireHttps || ProxyConfig.MATCH_HTTPS.equals(httpRequest.getUrl().getProtocol())) {
                    String signature = AzureSasCredentialPolicy.this.credential.getSignature();
                    if (signature.startsWith("?")) {
                        signature = signature.substring(1);
                    }
                    String query = httpRequest.getUrl().getQuery();
                    String string = httpRequest.getUrl().toString();
                    if (query == null || query.isEmpty()) {
                        if (!string.endsWith("?")) {
                            str = string + "?" + signature;
                        } else {
                            str = string + signature;
                        }
                    } else {
                        str = string + "&" + signature;
                    }
                    httpRequest.setUrl(str);
                    return;
                }
                throw AzureSasCredentialPolicy.LOGGER.logExceptionAsError(new IllegalStateException("Shared access signature credentials require HTTPS to prevent leaking the shared access signature."));
            }
        };
        Objects.requireNonNull(azureSasCredential, "'credential' cannot be null.");
        this.credential = azureSasCredential;
        this.requireHttps = z;
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
