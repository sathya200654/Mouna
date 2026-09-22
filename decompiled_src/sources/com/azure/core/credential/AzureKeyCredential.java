package com.azure.core.credential;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class AzureKeyCredential extends KeyCredential {
    public AzureKeyCredential(String str) {
        super(str);
    }

    @Override // com.azure.core.credential.KeyCredential
    public AzureKeyCredential update(String str) {
        super.update(str);
        return this;
    }
}
