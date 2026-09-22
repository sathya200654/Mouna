package com.azure.core.client.traits;

import com.azure.core.client.traits.AzureKeyCredentialTrait;
import com.azure.core.credential.AzureKeyCredential;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface AzureKeyCredentialTrait<T extends AzureKeyCredentialTrait<T>> {
    T credential(AzureKeyCredential azureKeyCredential);
}
