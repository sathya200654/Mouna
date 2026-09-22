package com.azure.core.implementation.http.rest;

import com.azure.core.http.HttpHeaderName;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class HeaderSubstitution extends Substitution {
    private final HttpHeaderName headerName;

    public HeaderSubstitution(String str, int i, boolean z) {
        super(str, i, z);
        this.headerName = str == null ? null : HttpHeaderName.fromString(str);
    }

    public HttpHeaderName getHeaderName() {
        return this.headerName;
    }
}
