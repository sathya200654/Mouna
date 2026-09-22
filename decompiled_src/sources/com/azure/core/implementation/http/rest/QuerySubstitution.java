package com.azure.core.implementation.http.rest;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class QuerySubstitution extends Substitution {
    private final boolean multipleParams;

    public QuerySubstitution(String str, int i, boolean z, boolean z2) {
        super(str, i, z);
        this.multipleParams = z2;
    }

    public boolean mergeParameters() {
        return this.multipleParams;
    }
}
