package com.azure.core.http.policy;

import com.azure.core.util.Configuration;
import io.reactivex.annotations.SchedulerSupport;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public enum HttpLogDetailLevel {
    NONE,
    BASIC,
    HEADERS,
    BODY,
    BODY_AND_HEADERS;

    static final String BASIC_VALUE = "basic";
    static final String BODYANDHEADERS_VALUE = "bodyandheaders";
    static final String BODY_AND_HEADERS_VALUE = "body_and_headers";
    static final String BODY_VALUE = "body";
    static final HttpLogDetailLevel ENVIRONMENT_HTTP_LOG_DETAIL_LEVEL = fromConfiguration(Configuration.getGlobalConfiguration());
    static final String HEADERS_VALUE = "headers";

    static HttpLogDetailLevel fromConfiguration(Configuration configuration) {
        String str = (String) configuration.get(Configuration.PROPERTY_AZURE_HTTP_LOG_DETAIL_LEVEL, SchedulerSupport.NONE);
        if (BASIC_VALUE.equalsIgnoreCase(str)) {
            return BASIC;
        }
        if (HEADERS_VALUE.equalsIgnoreCase(str)) {
            return HEADERS;
        }
        if ("body".equalsIgnoreCase(str)) {
            return BODY;
        }
        if (BODY_AND_HEADERS_VALUE.equalsIgnoreCase(str) || BODYANDHEADERS_VALUE.equalsIgnoreCase(str)) {
            return BODY_AND_HEADERS;
        }
        return NONE;
    }

    public boolean shouldLogUrl() {
        return this != NONE;
    }

    public boolean shouldLogHeaders() {
        return this == HEADERS || this == BODY_AND_HEADERS;
    }

    public boolean shouldLogBody() {
        return this == BODY || this == BODY_AND_HEADERS;
    }
}
