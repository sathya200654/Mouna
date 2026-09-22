package com.azure.core.http.policy;

import com.azure.core.credential.AzureKeyCredential;
import com.azure.core.credential.KeyCredential;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class AzureKeyCredentialPolicy extends KeyCredentialPolicy {
    public AzureKeyCredentialPolicy(String str, AzureKeyCredential azureKeyCredential) {
        super(str, azureKeyCredential, (String) null);
    }

    public AzureKeyCredentialPolicy(String str, AzureKeyCredential azureKeyCredential, String str2) {
        super(str, (KeyCredential) Objects.requireNonNull(azureKeyCredential, "'credential' cannot be null."), str2);
    }
}
