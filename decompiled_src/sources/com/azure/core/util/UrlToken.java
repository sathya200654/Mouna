package com.azure.core.util;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
class UrlToken {
    private final String text;
    private final UrlTokenType type;

    UrlToken(String str, UrlTokenType urlTokenType) {
        this.text = str;
        this.type = urlTokenType;
    }

    String text() {
        return this.text;
    }

    UrlTokenType type() {
        return this.type;
    }

    public boolean equals(Object obj) {
        return (obj instanceof UrlToken) && equals((UrlToken) obj);
    }

    public boolean equals(UrlToken urlToken) {
        return urlToken != null && this.text.equals(urlToken.text) && this.type == urlToken.type;
    }

    public String toString() {
        return "\"" + this.text + "\" (" + this.type + ")";
    }

    public int hashCode() {
        String str = this.text;
        return this.type.hashCode() ^ (str == null ? 0 : str.hashCode());
    }

    static UrlToken scheme(String str) {
        return new UrlToken(str, UrlTokenType.SCHEME);
    }

    static UrlToken host(String str) {
        return new UrlToken(str, UrlTokenType.HOST);
    }

    static UrlToken port(String str) {
        return new UrlToken(str, UrlTokenType.PORT);
    }

    static UrlToken path(String str) {
        return new UrlToken(str, UrlTokenType.PATH);
    }

    static UrlToken query(String str) {
        return new UrlToken(str, UrlTokenType.QUERY);
    }
}
