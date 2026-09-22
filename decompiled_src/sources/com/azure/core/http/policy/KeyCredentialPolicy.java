package com.azure.core.http.policy;

import androidx.webkit.ProxyConfig;
import com.azure.core.credential.KeyCredential;
import com.azure.core.http.HttpHeaderName;
import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpPipelineCallContext;
import com.azure.core.http.HttpPipelineNextPolicy;
import com.azure.core.http.HttpPipelineNextSyncPolicy;
import com.azure.core.http.HttpResponse;
import com.azure.core.util.FluxUtil;
import com.azure.core.util.logging.ClientLogger;
import java.util.Objects;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class KeyCredentialPolicy implements HttpPipelinePolicy {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) KeyCredentialPolicy.class);
    private final KeyCredential credential;
    private final HttpHeaderName name;
    private final String prefix;

    public KeyCredentialPolicy(String str, KeyCredential keyCredential) {
        this(str, keyCredential, (String) null);
    }

    public KeyCredentialPolicy(String str, KeyCredential keyCredential, String str2) {
        this(validateName(str), (KeyCredential) Objects.requireNonNull(keyCredential, "'credential' cannot be null."), str2);
    }

    private static HttpHeaderName validateName(String str) {
        Objects.requireNonNull(str, "'name' cannot be null.");
        if (str.isEmpty()) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("'name' cannot be empty."));
        }
        return HttpHeaderName.fromString(str);
    }

    KeyCredentialPolicy(HttpHeaderName httpHeaderName, KeyCredential keyCredential, String str) {
        this.name = httpHeaderName;
        this.credential = keyCredential;
        this.prefix = str != null ? str.trim() : null;
    }

    @Override // com.azure.core.http.policy.HttpPipelinePolicy
    public Mono<HttpResponse> process(HttpPipelineCallContext httpPipelineCallContext, HttpPipelineNextPolicy httpPipelineNextPolicy) {
        if (!ProxyConfig.MATCH_HTTPS.equals(httpPipelineCallContext.getHttpRequest().getUrl().getProtocol())) {
            return FluxUtil.monoError(LOGGER, new IllegalStateException("Key credentials require HTTPS to prevent leaking the key."));
        }
        setCredential(httpPipelineCallContext.getHttpRequest().getHeaders());
        return httpPipelineNextPolicy.process();
    }

    @Override // com.azure.core.http.policy.HttpPipelinePolicy
    public HttpResponse processSync(HttpPipelineCallContext httpPipelineCallContext, HttpPipelineNextSyncPolicy httpPipelineNextSyncPolicy) {
        if (!ProxyConfig.MATCH_HTTPS.equals(httpPipelineCallContext.getHttpRequest().getUrl().getProtocol())) {
            throw LOGGER.logExceptionAsError(new IllegalStateException("Key credentials require HTTPS to prevent leaking the key."));
        }
        setCredential(httpPipelineCallContext.getHttpRequest().getHeaders());
        return httpPipelineNextSyncPolicy.processSync();
    }

    void setCredential(HttpHeaders httpHeaders) {
        String key = this.credential.getKey();
        HttpHeaderName httpHeaderName = this.name;
        if (this.prefix != null) {
            key = this.prefix + " " + key;
        }
        httpHeaders.set(httpHeaderName, key);
    }
}
