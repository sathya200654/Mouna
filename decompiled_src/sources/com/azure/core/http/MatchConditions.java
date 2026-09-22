package com.azure.core.http;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class MatchConditions {
    private String ifMatch;
    private String ifNoneMatch;

    public String getIfMatch() {
        return this.ifMatch;
    }

    public MatchConditions setIfMatch(String str) {
        this.ifMatch = str;
        return this;
    }

    public String getIfNoneMatch() {
        return this.ifNoneMatch;
    }

    public MatchConditions setIfNoneMatch(String str) {
        this.ifNoneMatch = str;
        return this;
    }
}
