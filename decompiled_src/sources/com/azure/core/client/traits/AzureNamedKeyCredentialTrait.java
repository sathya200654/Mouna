package com.azure.core.client.traits;

import com.azure.core.client.traits.AzureNamedKeyCredentialTrait;
import com.azure.core.credential.AzureNamedKeyCredential;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public interface AzureNamedKeyCredentialTrait<T extends AzureNamedKeyCredentialTrait<T>> {
    T credential(AzureNamedKeyCredential azureNamedKeyCredential);
}
