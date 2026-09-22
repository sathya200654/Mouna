package com.azure.core.http.rest;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
class EncodedParameter {
    private final String encodedValue;
    private final String name;

    EncodedParameter(String str, String str2) {
        this.name = str;
        this.encodedValue = str2;
    }

    public String getName() {
        return this.name;
    }

    public String getEncodedValue() {
        return this.encodedValue;
    }
}
