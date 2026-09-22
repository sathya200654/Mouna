package com.azure.core.http.policy;

import com.azure.core.http.HttpHeaderName;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.logging.ClientLogger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class HttpLogOptions {
    static final Set<HttpHeaderName> DEFAULT_HEADERS_ALLOWLIST;
    static final List<String> DEFAULT_QUERY_PARAMS_ALLOWLIST;
    private static final String INVALID_APPLICATION_ID_LENGTH = "'applicationId' length cannot be greater than 24";
    private static final String INVALID_APPLICATION_ID_SPACE = "'applicationId' cannot contain spaces.";
    private static final ClientLogger LOGGER;
    private static final int MAX_APPLICATION_ID_LENGTH = 24;
    private static final HttpHeaderName MS_CV;
    private static final HttpHeaderName REQUEST_ID;
    private static final HttpHeaderName X_MS_RETURN_CLIENT_REQUEST_ID;
    private boolean disableRedactedHeaderLogging;
    private boolean prettyPrintBody;
    private HttpRequestLogger requestLogger;
    private HttpResponseLogger responseLogger;
    private HttpLogDetailLevel logLevel = HttpLogDetailLevel.ENVIRONMENT_HTTP_LOG_DETAIL_LEVEL;
    private Set<HttpHeaderName> allowedHeaderNames = new HashSet(DEFAULT_HEADERS_ALLOWLIST);
    private Set<String> allowedQueryParamNames = new HashSet(DEFAULT_QUERY_PARAMS_ALLOWLIST);
    private String applicationId = null;

    static {
        HttpHeaderName httpHeaderNameFromString = HttpHeaderName.fromString("x-ms-return-client-request-id");
        X_MS_RETURN_CLIENT_REQUEST_ID = httpHeaderNameFromString;
        HttpHeaderName httpHeaderNameFromString2 = HttpHeaderName.fromString("MS-CV");
        MS_CV = httpHeaderNameFromString2;
        HttpHeaderName httpHeaderNameFromString3 = HttpHeaderName.fromString("Request-Id");
        REQUEST_ID = httpHeaderNameFromString3;
        LOGGER = new ClientLogger((Class<?>) HttpLogOptions.class);
        DEFAULT_HEADERS_ALLOWLIST = Collections.unmodifiableSet(new HashSet(Arrays.asList(HttpHeaderName.X_MS_REQUEST_ID, HttpHeaderName.X_MS_CLIENT_REQUEST_ID, httpHeaderNameFromString, HttpHeaderName.TRACEPARENT, httpHeaderNameFromString2, HttpHeaderName.ACCEPT, HttpHeaderName.CACHE_CONTROL, HttpHeaderName.CONNECTION, HttpHeaderName.CONTENT_LENGTH, HttpHeaderName.DATE, HttpHeaderName.ETAG, HttpHeaderName.EXPIRES, HttpHeaderName.IF_MATCH, HttpHeaderName.IF_MODIFIED_SINCE, HttpHeaderName.IF_NONE_MATCH, HttpHeaderName.IF_UNMODIFIED_SINCE, HttpHeaderName.LAST_MODIFIED, HttpHeaderName.PRAGMA, httpHeaderNameFromString3, HttpHeaderName.RETRY_AFTER, HttpHeaderName.RETRY_AFTER_MS, HttpHeaderName.SERVER, HttpHeaderName.TRANSFER_ENCODING, HttpHeaderName.USER_AGENT, HttpHeaderName.WWW_AUTHENTICATE)));
        DEFAULT_QUERY_PARAMS_ALLOWLIST = Collections.singletonList("api-version");
    }

    public HttpLogDetailLevel getLogLevel() {
        return this.logLevel;
    }

    public HttpLogOptions setLogLevel(HttpLogDetailLevel httpLogDetailLevel) {
        if (httpLogDetailLevel == null) {
            httpLogDetailLevel = HttpLogDetailLevel.NONE;
        }
        this.logLevel = httpLogDetailLevel;
        return this;
    }

    @Deprecated
    public Set<String> getAllowedHeaderNames() {
        return (Set) this.allowedHeaderNames.stream().map(new Function() { // from class: com.azure.core.http.policy.HttpLogOptions$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((HttpHeaderName) obj).getCaseSensitiveName();
            }
        }).collect(Collectors.toSet());
    }

    public Set<HttpHeaderName> getAllowedHttpHeaderNames() {
        return this.allowedHeaderNames;
    }

    @Deprecated
    public HttpLogOptions setAllowedHeaderNames(Set<String> set) {
        Set<HttpHeaderName> hashSet;
        if (set == null) {
            hashSet = new HashSet<>();
        } else {
            hashSet = (Set) set.stream().map(new Function() { // from class: com.azure.core.http.policy.HttpLogOptions$$ExternalSyntheticLambda0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return HttpHeaderName.fromString((String) obj);
                }
            }).collect(Collectors.toSet());
        }
        this.allowedHeaderNames = hashSet;
        return this;
    }

    public HttpLogOptions setAllowedHttpHeaderNames(Set<HttpHeaderName> set) {
        if (set == null) {
            set = new HashSet<>();
        }
        this.allowedHeaderNames = set;
        return this;
    }

    @Deprecated
    public HttpLogOptions addAllowedHeaderName(String str) {
        Objects.requireNonNull(str);
        this.allowedHeaderNames.add(HttpHeaderName.fromString(str));
        return this;
    }

    public HttpLogOptions addAllowedHttpHeaderName(HttpHeaderName httpHeaderName) {
        Objects.requireNonNull(httpHeaderName);
        this.allowedHeaderNames.add(httpHeaderName);
        return this;
    }

    public Set<String> getAllowedQueryParamNames() {
        return this.allowedQueryParamNames;
    }

    public HttpLogOptions setAllowedQueryParamNames(Set<String> set) {
        if (set == null) {
            set = new HashSet<>();
        }
        this.allowedQueryParamNames = set;
        return this;
    }

    public HttpLogOptions addAllowedQueryParamName(String str) {
        this.allowedQueryParamNames.add(str);
        return this;
    }

    @Deprecated
    public String getApplicationId() {
        return this.applicationId;
    }

    @Deprecated
    public HttpLogOptions setApplicationId(String str) {
        if (!CoreUtils.isNullOrEmpty(str)) {
            if (str.length() > 24) {
                throw LOGGER.logExceptionAsError(new IllegalArgumentException(INVALID_APPLICATION_ID_LENGTH));
            }
            if (str.contains(" ")) {
                throw LOGGER.logExceptionAsError(new IllegalArgumentException(INVALID_APPLICATION_ID_SPACE));
            }
        }
        this.applicationId = str;
        return this;
    }

    @Deprecated
    public boolean isPrettyPrintBody() {
        return this.prettyPrintBody;
    }

    @Deprecated
    public HttpLogOptions setPrettyPrintBody(boolean z) {
        this.prettyPrintBody = z;
        return this;
    }

    public HttpRequestLogger getRequestLogger() {
        return this.requestLogger;
    }

    public HttpLogOptions setRequestLogger(HttpRequestLogger httpRequestLogger) {
        this.requestLogger = httpRequestLogger;
        return this;
    }

    public HttpResponseLogger getResponseLogger() {
        return this.responseLogger;
    }

    public HttpLogOptions setResponseLogger(HttpResponseLogger httpResponseLogger) {
        this.responseLogger = httpResponseLogger;
        return this;
    }

    public HttpLogOptions disableRedactedHeaderLogging(boolean z) {
        this.disableRedactedHeaderLogging = z;
        return this;
    }

    public boolean isRedactedHeaderLoggingDisabled() {
        return this.disableRedactedHeaderLogging;
    }
}
