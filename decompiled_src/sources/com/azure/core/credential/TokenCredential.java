package com.azure.core.credential;

import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@FunctionalInterface
public interface TokenCredential {
    Mono<AccessToken> getToken(TokenRequestContext tokenRequestContext);

    default AccessToken getTokenSync(TokenRequestContext tokenRequestContext) {
        return (AccessToken) getToken(tokenRequestContext).block();
    }
}
