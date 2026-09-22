package com.azure.core.implementation.util;

import com.azure.core.http.HttpHeader;
import com.azure.core.http.HttpHeaders;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class HttpHeadersAccessHelper {
    private static HttpHeadersAccessor accessor;

    public interface HttpHeadersAccessor {
        void addInternal(HttpHeaders httpHeaders, String str, String str2, String str3);

        Map<String, HttpHeader> getRawHeaderMap(HttpHeaders httpHeaders);

        void setInternal(HttpHeaders httpHeaders, String str, String str2, List<String> list);
    }

    public static Map<String, HttpHeader> getRawHeaderMap(HttpHeaders httpHeaders) {
        return accessor.getRawHeaderMap(httpHeaders);
    }

    public static void addInternal(HttpHeaders httpHeaders, String str, String str2, String str3) {
        accessor.addInternal(httpHeaders, str, str2, str3);
    }

    public static void setInternal(HttpHeaders httpHeaders, String str, String str2, List<String> list) {
        accessor.setInternal(httpHeaders, str, str2, list);
    }

    public static void setAccessor(HttpHeadersAccessor httpHeadersAccessor) {
        accessor = httpHeadersAccessor;
    }

    private HttpHeadersAccessHelper() {
    }
}
