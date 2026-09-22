package com.azure.core.client.traits;

import com.azure.core.client.traits.AzureSasCredentialTrait;
import com.azure.core.credential.AzureSasCredential;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface AzureSasCredentialTrait<T extends AzureSasCredentialTrait<T>> {
    T credential(AzureSasCredential azureSasCredential);
}
