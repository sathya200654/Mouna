package com.azure.core.http.policy;

import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpPipelineCallContext;
import com.azure.core.http.HttpPipelineNextPolicy;
import com.azure.core.http.HttpPipelineNextSyncPolicy;
import com.azure.core.http.HttpResponse;
import java.util.function.Consumer;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class AddHeadersFromContextPolicy implements HttpPipelinePolicy {
    public static final String AZURE_REQUEST_HTTP_HEADERS_KEY = "azure-http-headers-key";

    @Override // com.azure.core.http.policy.HttpPipelinePolicy
    public Mono<HttpResponse> process(HttpPipelineCallContext httpPipelineCallContext, HttpPipelineNextPolicy httpPipelineNextPolicy) {
        addHeadersFromContext(httpPipelineCallContext);
        return httpPipelineNextPolicy.process();
    }

    @Override // com.azure.core.http.policy.HttpPipelinePolicy
    public HttpResponse processSync(HttpPipelineCallContext httpPipelineCallContext, HttpPipelineNextSyncPolicy httpPipelineNextSyncPolicy) {
        addHeadersFromContext(httpPipelineCallContext);
        return httpPipelineNextSyncPolicy.processSync();
    }

    private static void addHeadersFromContext(final HttpPipelineCallContext httpPipelineCallContext) {
        httpPipelineCallContext.getData(AZURE_REQUEST_HTTP_HEADERS_KEY).ifPresent(new Consumer() { // from class: com.azure.core.http.policy.AddHeadersFromContextPolicy$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                AddHeadersFromContextPolicy.lambda$addHeadersFromContext$0(httpPipelineCallContext, obj);
            }
        });
    }

    static /* synthetic */ void lambda$addHeadersFromContext$0(HttpPipelineCallContext httpPipelineCallContext, Object obj) {
        if (obj instanceof HttpHeaders) {
            httpPipelineCallContext.getHttpRequest().getHeaders().setAllHttpHeaders((HttpHeaders) obj);
        }
    }
}
