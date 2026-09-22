package com.azure.core.implementation.http.rest;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class Substitution {
    private final int methodParameterIndex;
    private final boolean shouldEncode;
    private final String urlParameterName;

    public Substitution(String str, int i, boolean z) {
        this.urlParameterName = str;
        this.methodParameterIndex = i;
        this.shouldEncode = z;
    }

    public String getUrlParameterName() {
        return this.urlParameterName;
    }

    public int getMethodParameterIndex() {
        return this.methodParameterIndex;
    }

    public boolean shouldEncode() {
        return this.shouldEncode;
    }
}
