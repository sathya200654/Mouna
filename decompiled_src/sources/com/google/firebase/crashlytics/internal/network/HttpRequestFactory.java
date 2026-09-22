package com.google.firebase.crashlytics.internal.network;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class HttpRequestFactory {
    public HttpGetRequest buildHttpGetRequest(String str) {
        return buildHttpGetRequest(str, Collections.emptyMap());
    }

    public HttpGetRequest buildHttpGetRequest(String str, Map<String, String> map) {
        return new HttpGetRequest(str, map);
    }
}
