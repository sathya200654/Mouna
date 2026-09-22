package com.azure.core.http.policy;

import androidx.webkit.ProxyConfig;
import com.azure.core.credential.AccessToken;
import com.azure.core.credential.TokenCredential;
import com.azure.core.credential.TokenRequestContext;
import com.azure.core.http.HttpHeaderName;
import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpPipelineCallContext;
import com.azure.core.http.HttpPipelineNextPolicy;
import com.azure.core.http.HttpPipelineNextSyncPolicy;
import com.azure.core.http.HttpResponse;
import com.azure.core.implementation.AccessTokenCache;
import com.azure.core.implementation.http.policy.AuthorizationChallengeParser;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.logging.ClientLogger;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class BearerTokenAuthenticationPolicy implements HttpPipelinePolicy {
    private static final String BEARER = "Bearer";
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) BearerTokenAuthenticationPolicy.class);
    private final AccessTokenCache cache;
    private final String[] scopes;

    public BearerTokenAuthenticationPolicy(TokenCredential tokenCredential, String... strArr) {
        Objects.requireNonNull(tokenCredential);
        this.scopes = strArr;
        this.cache = new AccessTokenCache(tokenCredential);
    }

    public Mono<Void> authorizeRequest(HttpPipelineCallContext httpPipelineCallContext) {
        if (this.scopes == null) {
            return Mono.empty();
        }
        return setAuthorizationHeaderHelper(httpPipelineCallContext, new TokenRequestContext().addScopes(this.scopes).setCaeEnabled(true), false);
    }

    public void authorizeRequestSync(HttpPipelineCallContext httpPipelineCallContext) {
        setAuthorizationHeaderHelperSync(httpPipelineCallContext, new TokenRequestContext().addScopes(this.scopes).setCaeEnabled(true), false);
    }

    public Mono<Boolean> authorizeRequestOnChallenge(HttpPipelineCallContext httpPipelineCallContext, HttpResponse httpResponse) {
        TokenRequestContext tokenRequestContextForCaeChallenge;
        if (AuthorizationChallengeParser.isCaeClaimsChallenge(httpResponse) && (tokenRequestContextForCaeChallenge = getTokenRequestContextForCaeChallenge(httpResponse)) != null) {
            return setAuthorizationHeader(httpPipelineCallContext, tokenRequestContextForCaeChallenge).then(Mono.just(true));
        }
        return Mono.just(false);
    }

    public boolean authorizeRequestOnChallengeSync(HttpPipelineCallContext httpPipelineCallContext, HttpResponse httpResponse) {
        TokenRequestContext tokenRequestContextForCaeChallenge;
        if (!AuthorizationChallengeParser.isCaeClaimsChallenge(httpResponse) || (tokenRequestContextForCaeChallenge = getTokenRequestContextForCaeChallenge(httpResponse)) == null) {
            return false;
        }
        setAuthorizationHeaderSync(httpPipelineCallContext, tokenRequestContextForCaeChallenge);
        return true;
    }

    @Override // com.azure.core.http.policy.HttpPipelinePolicy
    public Mono<HttpResponse> process(final HttpPipelineCallContext httpPipelineCallContext, final HttpPipelineNextPolicy httpPipelineNextPolicy) {
        if (!ProxyConfig.MATCH_HTTPS.equals(httpPipelineCallContext.getHttpRequest().getUrl().getProtocol())) {
            return Mono.error(new RuntimeException("token credentials require a URL using the HTTPS protocol scheme"));
        }
        final HttpPipelineNextPolicy httpPipelineNextPolicyM1125clone = httpPipelineNextPolicy.m1125clone();
        Mono<Void> monoAuthorizeRequest = authorizeRequest(httpPipelineCallContext);
        Objects.requireNonNull(httpPipelineNextPolicy);
        return monoAuthorizeRequest.then(Mono.defer(new Supplier() { // from class: com.azure.core.http.policy.BearerTokenAuthenticationPolicy$$ExternalSyntheticLambda2
            @Override // java.util.function.Supplier
            public final Object get() {
                return httpPipelineNextPolicy.process();
            }
        })).flatMap(new Function() { // from class: com.azure.core.http.policy.BearerTokenAuthenticationPolicy$$ExternalSyntheticLambda3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m1128xb19de66d(httpPipelineCallContext, httpPipelineNextPolicyM1125clone, (HttpResponse) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$process$1$com-azure-core-http-policy-BearerTokenAuthenticationPolicy, reason: not valid java name */
    /* synthetic */ Mono m1128xb19de66d(HttpPipelineCallContext httpPipelineCallContext, final HttpPipelineNextPolicy httpPipelineNextPolicy, final HttpResponse httpResponse) {
        String headerValue = httpResponse.getHeaderValue(HttpHeaderName.WWW_AUTHENTICATE);
        if (httpResponse.getStatusCode() == 401 && headerValue != null) {
            return authorizeRequestOnChallenge(httpPipelineCallContext, httpResponse).flatMap(new Function() { // from class: com.azure.core.http.policy.BearerTokenAuthenticationPolicy$$ExternalSyntheticLambda0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return BearerTokenAuthenticationPolicy.lambda$process$0(httpResponse, httpPipelineNextPolicy, (Boolean) obj);
                }
            });
        }
        return Mono.just(httpResponse);
    }

    static /* synthetic */ Mono lambda$process$0(HttpResponse httpResponse, HttpPipelineNextPolicy httpPipelineNextPolicy, Boolean bool) {
        if (bool.booleanValue()) {
            httpResponse.close();
            return httpPipelineNextPolicy.process();
        }
        return Mono.just(httpResponse);
    }

    @Override // com.azure.core.http.policy.HttpPipelinePolicy
    public HttpResponse processSync(HttpPipelineCallContext httpPipelineCallContext, HttpPipelineNextSyncPolicy httpPipelineNextSyncPolicy) {
        if (!ProxyConfig.MATCH_HTTPS.equals(httpPipelineCallContext.getHttpRequest().getUrl().getProtocol())) {
            throw LOGGER.logExceptionAsError(new RuntimeException("token credentials require a URL using the HTTPS protocol scheme"));
        }
        HttpPipelineNextSyncPolicy httpPipelineNextSyncPolicyM1126clone = httpPipelineNextSyncPolicy.m1126clone();
        authorizeRequestSync(httpPipelineCallContext);
        HttpResponse httpResponseProcessSync = httpPipelineNextSyncPolicy.processSync();
        String headerValue = httpResponseProcessSync.getHeaderValue(HttpHeaderName.WWW_AUTHENTICATE);
        if (httpResponseProcessSync.getStatusCode() != 401 || headerValue == null || !authorizeRequestOnChallengeSync(httpPipelineCallContext, httpResponseProcessSync)) {
            return httpResponseProcessSync;
        }
        httpResponseProcessSync.close();
        return httpPipelineNextSyncPolicyM1126clone.processSync();
    }

    public Mono<Void> setAuthorizationHeader(HttpPipelineCallContext httpPipelineCallContext, TokenRequestContext tokenRequestContext) {
        return setAuthorizationHeaderHelper(httpPipelineCallContext, tokenRequestContext, true);
    }

    public void setAuthorizationHeaderSync(HttpPipelineCallContext httpPipelineCallContext, TokenRequestContext tokenRequestContext) {
        setAuthorizationHeaderHelperSync(httpPipelineCallContext, tokenRequestContext, true);
    }

    private Mono<Void> setAuthorizationHeaderHelper(final HttpPipelineCallContext httpPipelineCallContext, TokenRequestContext tokenRequestContext, boolean z) {
        return this.cache.getToken(tokenRequestContext, z).flatMap(new Function() { // from class: com.azure.core.http.policy.BearerTokenAuthenticationPolicy$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return BearerTokenAuthenticationPolicy.lambda$setAuthorizationHeaderHelper$2(httpPipelineCallContext, (AccessToken) obj);
            }
        });
    }

    static /* synthetic */ Mono lambda$setAuthorizationHeaderHelper$2(HttpPipelineCallContext httpPipelineCallContext, AccessToken accessToken) {
        setAuthorizationHeader(httpPipelineCallContext.getHttpRequest().getHeaders(), accessToken.getToken());
        return Mono.empty();
    }

    private void setAuthorizationHeaderHelperSync(HttpPipelineCallContext httpPipelineCallContext, TokenRequestContext tokenRequestContext, boolean z) {
        setAuthorizationHeader(httpPipelineCallContext.getHttpRequest().getHeaders(), this.cache.getTokenSync(tokenRequestContext, z).getToken());
    }

    private static void setAuthorizationHeader(HttpHeaders httpHeaders, String str) {
        httpHeaders.set(HttpHeaderName.AUTHORIZATION, "Bearer " + str);
    }

    private TokenRequestContext getTokenRequestContextForCaeChallenge(HttpResponse httpResponse) {
        String str;
        String challengeParameterFromResponse = AuthorizationChallengeParser.getChallengeParameterFromResponse(httpResponse, BEARER, "claims");
        if (CoreUtils.isNullOrEmpty(challengeParameterFromResponse)) {
            str = null;
        } else {
            try {
                str = new String(Base64.getDecoder().decode(challengeParameterFromResponse), StandardCharsets.UTF_8);
            } catch (IllegalArgumentException unused) {
                LOGGER.warning("Failed to decode the claims from the CAE challenge. Encoded claims: " + challengeParameterFromResponse);
                str = null;
            }
        }
        if (str == null) {
            return null;
        }
        return new TokenRequestContext().setClaims(str).addScopes(this.scopes).setCaeEnabled(true);
    }
}
