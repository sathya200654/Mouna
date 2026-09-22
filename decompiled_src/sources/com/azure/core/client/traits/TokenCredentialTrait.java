package com.azure.core.client.traits;

import com.azure.core.client.traits.TokenCredentialTrait;
import com.azure.core.credential.TokenCredential;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface TokenCredentialTrait<T extends TokenCredentialTrait<T>> {
    T credential(TokenCredential tokenCredential);
}
