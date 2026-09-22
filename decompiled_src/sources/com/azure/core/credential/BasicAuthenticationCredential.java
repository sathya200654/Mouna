package com.azure.core.credential;

import com.azure.core.util.Base64Util;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.concurrent.Callable;
import reactor.core.publisher.Mono;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class BasicAuthenticationCredential implements TokenCredential {
    private final String encodedCredential;

    public BasicAuthenticationCredential(String str, String str2) {
        this.encodedCredential = Base64Util.encodeToString((str + ":" + str2).getBytes(StandardCharsets.UTF_8));
    }

    @Override // com.azure.core.credential.TokenCredential
    public Mono<AccessToken> getToken(TokenRequestContext tokenRequestContext) {
        return Mono.fromCallable(new Callable() { // from class: com.azure.core.credential.BasicAuthenticationCredential$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m1114x170c79f3();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$getToken$0$com-azure-core-credential-BasicAuthenticationCredential, reason: not valid java name */
    /* synthetic */ AccessToken m1114x170c79f3() throws Exception {
        return new AccessToken(this.encodedCredential, OffsetDateTime.MAX);
    }

    @Override // com.azure.core.credential.TokenCredential
    public AccessToken getTokenSync(TokenRequestContext tokenRequestContext) {
        return new AccessToken(this.encodedCredential, OffsetDateTime.MAX);
    }
}
