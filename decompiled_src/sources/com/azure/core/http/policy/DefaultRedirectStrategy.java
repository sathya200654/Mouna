package com.azure.core.http.policy;

import com.azure.core.http.HttpHeaderName;
import com.azure.core.http.HttpMethod;
import com.azure.core.http.HttpPipelineCallContext;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.HttpResponse;
import com.azure.core.implementation.logging.LoggingKeys;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.logging.LogLevel;
import com.azure.core.util.logging.LoggingEventBuilder;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class DefaultRedirectStrategy implements RedirectStrategy {
    private static final int DEFAULT_MAX_REDIRECT_ATTEMPTS = 3;
    private static final int PERMANENT_REDIRECT_STATUS_CODE = 308;
    private static final String REDIRECT_URLS_KEY = "redirectUrls";
    private static final int TEMPORARY_REDIRECT_STATUS_CODE = 307;
    private final Set<HttpMethod> allowedRedirectHttpMethods;
    private final HttpHeaderName locationHeader;
    private final int maxAttempts;
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) DefaultRedirectStrategy.class);
    private static final Set<HttpMethod> DEFAULT_REDIRECT_ALLOWED_METHODS = EnumSet.of(HttpMethod.GET, HttpMethod.HEAD);

    private boolean isValidRedirectStatusCode(int i) {
        return i == 302 || i == 301 || i == 308 || i == 307;
    }

    public DefaultRedirectStrategy() {
        this(3, HttpHeaderName.LOCATION, DEFAULT_REDIRECT_ALLOWED_METHODS);
    }

    public DefaultRedirectStrategy(int i) {
        this(i, HttpHeaderName.LOCATION, DEFAULT_REDIRECT_ALLOWED_METHODS);
    }

    public DefaultRedirectStrategy(int i, String str, Set<HttpMethod> set) {
        this(i, validateLocationHeader(str), validateAllowedMethods(set));
    }

    private DefaultRedirectStrategy(int i, HttpHeaderName httpHeaderName, Set<HttpMethod> set) {
        if (i < 0) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("Max attempts cannot be less than 0."));
        }
        this.maxAttempts = i;
        this.locationHeader = httpHeaderName;
        this.allowedRedirectHttpMethods = set;
    }

    private static HttpHeaderName validateLocationHeader(String str) {
        if (CoreUtils.isNullOrEmpty(str)) {
            LOGGER.log(LogLevel.INFORMATIONAL, new Supplier() { // from class: com.azure.core.http.policy.DefaultRedirectStrategy$$ExternalSyntheticLambda2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return DefaultRedirectStrategy.lambda$validateLocationHeader$0();
                }
            });
            return HttpHeaderName.LOCATION;
        }
        return HttpHeaderName.fromString(str);
    }

    static /* synthetic */ String lambda$validateLocationHeader$0() {
        return "'locationHeader' provided as null will be defaulted to " + HttpHeaderName.LOCATION;
    }

    private static Set<HttpMethod> validateAllowedMethods(Set<HttpMethod> set) {
        if (CoreUtils.isNullOrEmpty(set)) {
            LOGGER.log(LogLevel.INFORMATIONAL, new Supplier() { // from class: com.azure.core.http.policy.DefaultRedirectStrategy$$ExternalSyntheticLambda0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return DefaultRedirectStrategy.lambda$validateAllowedMethods$1();
                }
            });
            return DEFAULT_REDIRECT_ALLOWED_METHODS;
        }
        return EnumSet.copyOf((Collection) set);
    }

    static /* synthetic */ String lambda$validateAllowedMethods$1() {
        return "'allowedMethods' provided as null will be defaulted to " + DEFAULT_REDIRECT_ALLOWED_METHODS;
    }

    @Override // com.azure.core.http.policy.RedirectStrategy
    public boolean shouldAttemptRedirect(HttpPipelineCallContext httpPipelineCallContext, HttpResponse httpResponse, int i, final Set<String> set) {
        String headerValue;
        if (!isValidRedirectStatusCode(httpResponse.getStatusCode()) || !isValidRedirectCount(i) || !isAllowedRedirectMethod(httpResponse.getRequest().getHttpMethod()) || (headerValue = httpResponse.getHeaderValue(this.locationHeader)) == null || alreadyAttemptedRedirectUrl(headerValue, set)) {
            return false;
        }
        LoggingEventBuilder loggingEventBuilderAddKeyValue = LOGGER.atVerbose().addKeyValue(LoggingKeys.TRY_COUNT_KEY, i);
        Objects.requireNonNull(set);
        loggingEventBuilderAddKeyValue.addKeyValue(REDIRECT_URLS_KEY, new Supplier() { // from class: com.azure.core.http.policy.DefaultRedirectStrategy$$ExternalSyntheticLambda1
            @Override // java.util.function.Supplier
            public final Object get() {
                return set.toString();
            }
        }).log("Redirecting.");
        set.add(headerValue);
        return true;
    }

    @Override // com.azure.core.http.policy.RedirectStrategy
    public HttpRequest createRedirectRequest(HttpResponse httpResponse) {
        return httpResponse.getRequest().setUrl(httpResponse.getHeaderValue(this.locationHeader));
    }

    @Override // com.azure.core.http.policy.RedirectStrategy
    public int getMaxAttempts() {
        return this.maxAttempts;
    }

    private boolean alreadyAttemptedRedirectUrl(String str, Set<String> set) {
        if (!set.contains(str)) {
            return false;
        }
        LOGGER.atError().addKeyValue(LoggingKeys.REDIRECT_URL_KEY, str).log("Request was redirected more than once to the same URL.");
        return true;
    }

    private boolean isValidRedirectCount(int i) {
        if (i < getMaxAttempts()) {
            return true;
        }
        LOGGER.atError().addKeyValue("maxAttempts", getMaxAttempts()).log("Redirect attempts have been exhausted.");
        return false;
    }

    private boolean isAllowedRedirectMethod(HttpMethod httpMethod) {
        if (this.allowedRedirectHttpMethods.contains(httpMethod)) {
            return true;
        }
        LOGGER.atError().addKeyValue(LoggingKeys.HTTP_METHOD_KEY, httpMethod).log("Request was redirected from an invalid redirect allowed method.");
        return false;
    }
}
