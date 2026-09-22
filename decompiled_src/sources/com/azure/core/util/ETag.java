package com.azure.core.util;

import com.azure.core.util.logging.ClientLogger;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ETag {
    private static final String ASTERISK = "*";
    private static final String QUOTE_STRING = "\"";
    private static final String WEAK_ETAG_PREFIX_QUOTE = "W/\"";
    private final String eTag;
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) ETag.class);
    public static final ETag ALL = new ETag("*");

    public ETag(String str) {
        checkValidETag(str);
        this.eTag = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ETag) {
            return Objects.equals(this.eTag, ((ETag) obj).eTag);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.eTag);
    }

    public String toString() {
        return this.eTag;
    }

    private void checkValidETag(String str) {
        if (str == null || "*".equals(str)) {
            return;
        }
        if ((!str.startsWith(QUOTE_STRING) && !str.startsWith(WEAK_ETAG_PREFIX_QUOTE)) || !str.endsWith(QUOTE_STRING)) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(String.format("The value=%s should be equal to * , be wrapped in quotes, or be wrapped in quotes prefixed by W/", str)));
        }
    }
}
