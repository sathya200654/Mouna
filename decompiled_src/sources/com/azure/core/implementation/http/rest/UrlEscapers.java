package com.azure.core.implementation.http.rest;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class UrlEscapers {
    private static final String SUB_DELIMS = "!$&'()*+,;=";
    public static final PercentEscaper PATH_ESCAPER = new PercentEscaper("-._~!$&'()*+,;=:@", false);
    public static final PercentEscaper QUERY_ESCAPER = new PercentEscaper("-._~/?", false);
    private static final String UNRESERVED_SYMBOLS = "-._~";
    public static final PercentEscaper FORM_ESCAPER = new PercentEscaper(UNRESERVED_SYMBOLS, true);
}
