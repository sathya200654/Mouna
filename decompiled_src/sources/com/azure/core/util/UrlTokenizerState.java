package com.azure.core.util;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
enum UrlTokenizerState {
    SCHEME,
    SCHEME_OR_HOST,
    HOST,
    PORT,
    PATH,
    QUERY,
    DONE
}
