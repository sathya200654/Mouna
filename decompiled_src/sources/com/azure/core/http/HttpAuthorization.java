package com.azure.core.http;

import com.azure.core.util.logging.ClientLogger;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class HttpAuthorization {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) HttpAuthorization.class);
    private final String parameter;
    private final String scheme;

    public HttpAuthorization(String str, String str2) {
        Objects.requireNonNull(str, "'scheme' cannot be null.");
        Objects.requireNonNull(str2, "'parameter' cannot be null.");
        if (str.isEmpty()) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("'scheme' cannot be empty."));
        }
        if (str2.isEmpty()) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("'parameter' cannot be empty."));
        }
        this.scheme = str;
        this.parameter = str2;
    }

    public String getScheme() {
        return this.scheme;
    }

    public String getParameter() {
        return this.parameter;
    }

    public String toString() {
        return this.scheme + " " + this.parameter;
    }
}
