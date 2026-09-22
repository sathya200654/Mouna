package com.azure.core.http.policy;

import com.azure.core.http.HttpHeaderName;
import com.azure.core.http.HttpPipelineCallContext;
import com.azure.core.http.HttpPipelineNextPolicy;
import com.azure.core.http.HttpPipelineNextSyncPolicy;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.HttpResponse;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class RedirectPolicy implements HttpPipelinePolicy {
    private final RedirectStrategy redirectStrategy;

    public RedirectPolicy() {
        this(new DefaultRedirectStrategy());
    }

    public RedirectPolicy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = (RedirectStrategy) Objects.requireNonNull(redirectStrategy, "'redirectStrategy' cannot be null.");
    }

    @Override // com.azure.core.http.policy.HttpPipelinePolicy
    public Mono<HttpResponse> process(HttpPipelineCallContext httpPipelineCallContext, HttpPipelineNextPolicy httpPipelineNextPolicy) {
        return attemptRedirect(httpPipelineCallContext, httpPipelineNextPolicy, httpPipelineCallContext.getHttpRequest(), 1, new HashSet());
    }

    @Override // com.azure.core.http.policy.HttpPipelinePolicy
    public HttpResponse processSync(HttpPipelineCallContext httpPipelineCallContext, HttpPipelineNextSyncPolicy httpPipelineNextSyncPolicy) {
        return attemptRedirectSync(httpPipelineCallContext, httpPipelineNextSyncPolicy, httpPipelineCallContext.getHttpRequest(), 1, new HashSet());
    }

    private Mono<HttpResponse> attemptRedirect(final HttpPipelineCallContext httpPipelineCallContext, final HttpPipelineNextPolicy httpPipelineNextPolicy, HttpRequest httpRequest, final int i, final Set<String> set) {
        httpPipelineCallContext.setHttpRequest(httpRequest.copy());
        return httpPipelineNextPolicy.m1125clone().process().flatMap(new Function() { // from class: com.azure.core.http.policy.RedirectPolicy$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1137x6713dfc(httpPipelineCallContext, i, set, httpPipelineNextPolicy, (HttpResponse) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attemptRedirect$0$com-azure-core-http-policy-RedirectPolicy, reason: not valid java name */
    /* synthetic */ Mono m1137x6713dfc(HttpPipelineCallContext httpPipelineCallContext, int i, Set set, HttpPipelineNextPolicy httpPipelineNextPolicy, HttpResponse httpResponse) {
        if (this.redirectStrategy.shouldAttemptRedirect(httpPipelineCallContext, httpResponse, i, set)) {
            return attemptRedirect(httpPipelineCallContext, httpPipelineNextPolicy, createRedirectRequest(httpResponse), i + 1, set);
        }
        return Mono.just(httpResponse);
    }

    private HttpResponse attemptRedirectSync(HttpPipelineCallContext httpPipelineCallContext, HttpPipelineNextSyncPolicy httpPipelineNextSyncPolicy, HttpRequest httpRequest, int i, Set<String> set) {
        httpPipelineCallContext.setHttpRequest(httpRequest.copy());
        HttpResponse httpResponseProcessSync = httpPipelineNextSyncPolicy.m1126clone().processSync();
        return this.redirectStrategy.shouldAttemptRedirect(httpPipelineCallContext, httpResponseProcessSync, i, set) ? attemptRedirectSync(httpPipelineCallContext, httpPipelineNextSyncPolicy, createRedirectRequest(httpResponseProcessSync), i + 1, set) : httpResponseProcessSync;
    }

    private HttpRequest createRedirectRequest(HttpResponse httpResponse) {
        httpResponse.getRequest().getHeaders().remove(HttpHeaderName.AUTHORIZATION);
        HttpRequest httpRequestCreateRedirectRequest = this.redirectStrategy.createRedirectRequest(httpResponse);
        httpResponse.close();
        return httpRequestCreateRedirectRequest;
    }
}
