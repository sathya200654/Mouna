package com.azure.core.http;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class HttpHeaderName extends ExpandableStringEnum<HttpHeaderName> {
    private String caseInsensitive;
    public static final HttpHeaderName ACCEPT = fromString(com.google.common.net.HttpHeaders.ACCEPT);
    public static final HttpHeaderName ACCEPT_CHARSET = fromString(com.google.common.net.HttpHeaders.ACCEPT_CHARSET);
    public static final HttpHeaderName ACCESS_CONTROL_ALLOW_CREDENTIALS = fromString(com.google.common.net.HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS);
    public static final HttpHeaderName ACCESS_CONTROL_ALLOW_HEADERS = fromString(com.google.common.net.HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS);
    public static final HttpHeaderName ACCESS_CONTROL_ALLOW_METHODS = fromString(com.google.common.net.HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS);
    public static final HttpHeaderName ACCESS_CONTROL_ALLOW_ORIGIN = fromString(com.google.common.net.HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN);
    public static final HttpHeaderName ACCESS_CONTROL_EXPOSE_HEADERS = fromString(com.google.common.net.HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS);
    public static final HttpHeaderName ACCESS_CONTROL_MAX_AGE = fromString(com.google.common.net.HttpHeaders.ACCESS_CONTROL_MAX_AGE);
    public static final HttpHeaderName ACCEPT_DATETIME = fromString("Accept-Datetime");
    public static final HttpHeaderName ACCEPT_ENCODING = fromString(com.google.common.net.HttpHeaders.ACCEPT_ENCODING);
    public static final HttpHeaderName ACCEPT_LANGUAGE = fromString(com.google.common.net.HttpHeaders.ACCEPT_LANGUAGE);
    public static final HttpHeaderName ACCEPT_PATCH = fromString("Accept-Patch");
    public static final HttpHeaderName ACCEPT_RANGES = fromString(com.google.common.net.HttpHeaders.ACCEPT_RANGES);
    public static final HttpHeaderName AGE = fromString(com.google.common.net.HttpHeaders.AGE);
    public static final HttpHeaderName ALLOW = fromString(com.google.common.net.HttpHeaders.ALLOW);
    public static final HttpHeaderName AUTHORIZATION = fromString("Authorization");
    public static final HttpHeaderName AZURE_ASYNCOPERATION = fromString("Azure-AsyncOperation");
    public static final HttpHeaderName CACHE_CONTROL = fromString("Cache-Control");
    public static final HttpHeaderName CONNECTION = fromString(com.google.common.net.HttpHeaders.CONNECTION);
    public static final HttpHeaderName CONTENT_DISPOSITION = fromString(com.google.common.net.HttpHeaders.CONTENT_DISPOSITION);
    public static final HttpHeaderName CONTENT_ENCODING = fromString(com.google.common.net.HttpHeaders.CONTENT_ENCODING);
    public static final HttpHeaderName CONTENT_LANGUAGE = fromString(com.google.common.net.HttpHeaders.CONTENT_LANGUAGE);
    public static final HttpHeaderName CONTENT_LENGTH = fromString(com.google.common.net.HttpHeaders.CONTENT_LENGTH);
    public static final HttpHeaderName CONTENT_LOCATION = fromString(com.google.common.net.HttpHeaders.CONTENT_LOCATION);
    public static final HttpHeaderName CONTENT_MD5 = fromString(com.google.common.net.HttpHeaders.CONTENT_MD5);
    public static final HttpHeaderName CONTENT_RANGE = fromString(com.google.common.net.HttpHeaders.CONTENT_RANGE);
    public static final HttpHeaderName CONTENT_TYPE = fromString("Content-Type");
    public static final HttpHeaderName COOKIE = fromString(com.google.common.net.HttpHeaders.COOKIE);
    public static final HttpHeaderName DATE = fromString(com.google.common.net.HttpHeaders.DATE);
    public static final HttpHeaderName ETAG = fromString(com.google.common.net.HttpHeaders.ETAG);
    public static final HttpHeaderName EXPECT = fromString(com.google.common.net.HttpHeaders.EXPECT);
    public static final HttpHeaderName EXPIRES = fromString(com.google.common.net.HttpHeaders.EXPIRES);
    public static final HttpHeaderName FORWARDED = fromString(com.google.common.net.HttpHeaders.FORWARDED);
    public static final HttpHeaderName FROM = fromString(com.google.common.net.HttpHeaders.FROM);
    public static final HttpHeaderName HOST = fromString(com.google.common.net.HttpHeaders.HOST);
    public static final HttpHeaderName HTTP2_SETTINGS = fromString(com.google.common.net.HttpHeaders.HTTP2_SETTINGS);
    public static final HttpHeaderName IF_MATCH = fromString(com.google.common.net.HttpHeaders.IF_MATCH);
    public static final HttpHeaderName IF_MODIFIED_SINCE = fromString(com.google.common.net.HttpHeaders.IF_MODIFIED_SINCE);
    public static final HttpHeaderName IF_NONE_MATCH = fromString(com.google.common.net.HttpHeaders.IF_NONE_MATCH);
    public static final HttpHeaderName IF_RANGE = fromString(com.google.common.net.HttpHeaders.IF_RANGE);
    public static final HttpHeaderName IF_UNMODIFIED_SINCE = fromString(com.google.common.net.HttpHeaders.IF_UNMODIFIED_SINCE);
    public static final HttpHeaderName LAST_MODIFIED = fromString(com.google.common.net.HttpHeaders.LAST_MODIFIED);
    public static final HttpHeaderName LINK = fromString(com.google.common.net.HttpHeaders.LINK);
    public static final HttpHeaderName LOCATION = fromString("Location");
    public static final HttpHeaderName MAX_FORWARDS = fromString(com.google.common.net.HttpHeaders.MAX_FORWARDS);
    public static final HttpHeaderName OPERATION_LOCATION = fromString("Operation-Location");
    public static final HttpHeaderName ORIGIN = fromString(com.google.common.net.HttpHeaders.ORIGIN);
    public static final HttpHeaderName PRAGMA = fromString(com.google.common.net.HttpHeaders.PRAGMA);
    public static final HttpHeaderName PREFER = fromString("Prefer");
    public static final HttpHeaderName PREFERENCE_APPLIED = fromString("Preference-Applied");
    public static final HttpHeaderName PROXY_AUTHENTICATE = fromString("Proxy-Authenticate");
    public static final HttpHeaderName PROXY_AUTHORIZATION = fromString("Proxy-Authorization");
    public static final HttpHeaderName RANGE = fromString(com.google.common.net.HttpHeaders.RANGE);
    public static final HttpHeaderName REFERER = fromString(com.google.common.net.HttpHeaders.REFERER);
    public static final HttpHeaderName RETRY_AFTER = fromString("Retry-After");
    public static final HttpHeaderName RETRY_AFTER_MS = fromString("retry-after-ms");
    public static final HttpHeaderName SERVER = fromString(com.google.common.net.HttpHeaders.SERVER);
    public static final HttpHeaderName SET_COOKIE = fromString(com.google.common.net.HttpHeaders.SET_COOKIE);
    public static final HttpHeaderName STRICT_TRANSPORT_SECURITY = fromString(com.google.common.net.HttpHeaders.STRICT_TRANSPORT_SECURITY);
    public static final HttpHeaderName TE = fromString(com.google.common.net.HttpHeaders.TE);
    public static final HttpHeaderName TRAILER = fromString(com.google.common.net.HttpHeaders.TRAILER);
    public static final HttpHeaderName TRANSFER_ENCODING = fromString(com.google.common.net.HttpHeaders.TRANSFER_ENCODING);
    public static final HttpHeaderName USER_AGENT = fromString(com.google.common.net.HttpHeaders.USER_AGENT);
    public static final HttpHeaderName UPGRADE = fromString(com.google.common.net.HttpHeaders.UPGRADE);
    public static final HttpHeaderName VARY = fromString(com.google.common.net.HttpHeaders.VARY);
    public static final HttpHeaderName VIA = fromString(com.google.common.net.HttpHeaders.VIA);
    public static final HttpHeaderName WARNING = fromString(com.google.common.net.HttpHeaders.WARNING);
    public static final HttpHeaderName WWW_AUTHENTICATE = fromString("WWW-Authenticate");
    public static final HttpHeaderName X_MS_CLIENT_ID = fromString("x-ms-client-id");
    public static final HttpHeaderName X_MS_CLIENT_REQUEST_ID = fromString("x-ms-client-request-id");
    public static final HttpHeaderName X_MS_DATE = fromString("x-ms-date");
    public static final HttpHeaderName X_MS_REQUEST_ID = fromString("x-ms-request-id");
    public static final HttpHeaderName X_MS_RETRY_AFTER_MS = fromString("x-ms-retry-after-ms");
    public static final HttpHeaderName TRACEPARENT = fromString("traceparent");

    @Deprecated
    public HttpHeaderName() {
    }

    public String getCaseSensitiveName() {
        return toString();
    }

    public String getCaseInsensitiveName() {
        return this.caseInsensitive;
    }

    public static HttpHeaderName fromString(String str) {
        if (str == null) {
            return null;
        }
        HttpHeaderName httpHeaderName = (HttpHeaderName) fromString(str, HttpHeaderName.class);
        httpHeaderName.caseInsensitive = str.toLowerCase(Locale.ROOT);
        return httpHeaderName;
    }

    @Override // com.azure.core.util.ExpandableStringEnum
    public int hashCode() {
        return Objects.hashCode(this.caseInsensitive);
    }

    @Override // com.azure.core.util.ExpandableStringEnum
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HttpHeaderName) {
            return Objects.equals(this.caseInsensitive, ((HttpHeaderName) obj).caseInsensitive);
        }
        return false;
    }
}
