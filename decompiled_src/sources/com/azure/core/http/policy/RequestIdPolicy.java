package com.azure.core.http.policy;

import com.azure.core.http.HttpHeaderName;
import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpPipelineCallContext;
import com.azure.core.http.HttpPipelineNextPolicy;
import com.azure.core.http.HttpPipelineNextSyncPolicy;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.HttpResponse;
import com.azure.core.util.CoreUtils;
import java.util.Objects;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class RequestIdPolicy implements HttpPipelinePolicy {
    private static final HttpHeaderName REQUEST_ID_HEADER = HttpHeaderName.fromString("x-ms-client-request-id");
    private final HttpHeaderName requestIdHeaderName;

    public RequestIdPolicy(String str) {
        this.requestIdHeaderName = HttpHeaderName.fromString((String) Objects.requireNonNull(str, "requestIdHeaderName can not be null."));
    }

    public RequestIdPolicy() {
        this.requestIdHeaderName = REQUEST_ID_HEADER;
    }

    @Override // com.azure.core.http.policy.HttpPipelinePolicy
    public Mono<HttpResponse> process(HttpPipelineCallContext httpPipelineCallContext, HttpPipelineNextPolicy httpPipelineNextPolicy) {
        setRequestIdHeader(httpPipelineCallContext.getHttpRequest(), this.requestIdHeaderName);
        return httpPipelineNextPolicy.process();
    }

    @Override // com.azure.core.http.policy.HttpPipelinePolicy
    public HttpResponse processSync(HttpPipelineCallContext httpPipelineCallContext, HttpPipelineNextSyncPolicy httpPipelineNextSyncPolicy) {
        setRequestIdHeader(httpPipelineCallContext.getHttpRequest(), this.requestIdHeaderName);
        return httpPipelineNextSyncPolicy.processSync();
    }

    private static void setRequestIdHeader(HttpRequest httpRequest, HttpHeaderName httpHeaderName) {
        HttpHeaders headers = httpRequest.getHeaders();
        if (headers.getValue(httpHeaderName) == null) {
            headers.set(httpHeaderName, CoreUtils.randomUuid().toString());
        }
    }
}
