package com.azure.core.util.serializer;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public enum CollectionFormat {
    CSV(","),
    SSV(" "),
    TSV("\t"),
    PIPES("|"),
    MULTI("&");

    private String delimiter;

    CollectionFormat(String str) {
        this.delimiter = str;
    }

    public String getDelimiter() {
        return this.delimiter;
    }
}
