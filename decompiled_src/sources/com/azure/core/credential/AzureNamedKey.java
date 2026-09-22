package com.azure.core.credential;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class AzureNamedKey {
    private final String key;
    private final String name;

    AzureNamedKey(String str, String str2) {
        this.name = str;
        this.key = str2;
    }

    public String getKey() {
        return this.key;
    }

    public String getName() {
        return this.name;
    }
}
