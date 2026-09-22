package com.microsoft.cognitiveservices.speech;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public enum ServicePropertyChannel {
    UriQueryParameter(0),
    HttpHeader(1);

    private final int id;

    ServicePropertyChannel(int i) {
        this.id = i;
    }

    public int getValue() {
        return this.id;
    }
}
