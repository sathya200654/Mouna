package com.azure.core.http.policy;

import com.azure.core.http.HttpHeader;
import com.azure.core.http.HttpPipelineCallContext;
import com.azure.core.http.HttpPipelineNextPolicy;
import com.azure.core.http.HttpPipelineNextSyncPolicy;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.HttpResponse;
import com.azure.core.util.logging.ClientLogger;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import reactor.core.Exceptions;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class CookiePolicy implements HttpPipelinePolicy {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) CookiePolicy.class);
    private final CookieHandler cookies = new CookieManager();

    @Override // com.azure.core.http.policy.HttpPipelinePolicy
    public Mono<HttpResponse> process(final HttpPipelineCallContext httpPipelineCallContext, final HttpPipelineNextPolicy httpPipelineNextPolicy) {
        return Mono.defer(new Supplier() { // from class: com.azure.core.http.policy.CookiePolicy$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.m1129lambda$process$0$comazurecorehttppolicyCookiePolicy(httpPipelineCallContext, httpPipelineNextPolicy);
            }
        }).map(new Function() { // from class: com.azure.core.http.policy.CookiePolicy$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1130lambda$process$1$comazurecorehttppolicyCookiePolicy(httpPipelineCallContext, (HttpResponse) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$process$0$com-azure-core-http-policy-CookiePolicy, reason: not valid java name */
    /* synthetic */ Mono m1129lambda$process$0$comazurecorehttppolicyCookiePolicy(HttpPipelineCallContext httpPipelineCallContext, HttpPipelineNextPolicy httpPipelineNextPolicy) {
        beforeRequest(httpPipelineCallContext.getHttpRequest(), this.cookies);
        return httpPipelineNextPolicy.process();
    }

    /* JADX INFO: renamed from: lambda$process$1$com-azure-core-http-policy-CookiePolicy, reason: not valid java name */
    /* synthetic */ HttpResponse m1130lambda$process$1$comazurecorehttppolicyCookiePolicy(HttpPipelineCallContext httpPipelineCallContext, HttpResponse httpResponse) {
        return afterResponse(httpPipelineCallContext, httpResponse, this.cookies);
    }

    @Override // com.azure.core.http.policy.HttpPipelinePolicy
    public HttpResponse processSync(HttpPipelineCallContext httpPipelineCallContext, HttpPipelineNextSyncPolicy httpPipelineNextSyncPolicy) {
        beforeRequest(httpPipelineCallContext.getHttpRequest(), this.cookies);
        return afterResponse(httpPipelineCallContext, httpPipelineNextSyncPolicy.processSync(), this.cookies);
    }

    private static void beforeRequest(HttpRequest httpRequest, CookieHandler cookieHandler) {
        try {
            URI uri = httpRequest.getUrl().toURI();
            HashMap map = new HashMap();
            for (HttpHeader httpHeader : httpRequest.getHeaders()) {
                map.put(httpHeader.getName(), httpHeader.getValuesList());
            }
            for (Map.Entry<String, List<String>> entry : cookieHandler.get(uri, map).entrySet()) {
                httpRequest.getHeaders().set(entry.getKey(), entry.getValue());
            }
        } catch (IOException | URISyntaxException e) {
            throw LOGGER.logExceptionAsError(new RuntimeException(e));
        }
    }

    private static HttpResponse afterResponse(HttpPipelineCallContext httpPipelineCallContext, HttpResponse httpResponse, CookieHandler cookieHandler) {
        HashMap map = new HashMap();
        for (HttpHeader httpHeader : httpResponse.getHeaders()) {
            map.put(httpHeader.getName(), httpHeader.getValuesList());
        }
        try {
            cookieHandler.put(httpPipelineCallContext.getHttpRequest().getUrl().toURI(), map);
            return httpResponse;
        } catch (IOException | URISyntaxException e) {
            throw LOGGER.logExceptionAsError(Exceptions.propagate(e));
        }
    }
}
