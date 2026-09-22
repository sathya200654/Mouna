package com.azure.core.http;

import com.azure.core.util.logging.ClientLogger;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class HttpRange {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) HttpRange.class);
    private final Long length;
    private final long offset;

    public HttpRange(long j) {
        this(j, null);
    }

    public HttpRange(long j, Long l) {
        if (j < 0) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("'offset' cannot be less than 0."));
        }
        if (l != null && l.longValue() <= 0) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("'length' cannot be equal to or less than 0."));
        }
        this.offset = j;
        this.length = l;
    }

    public long getOffset() {
        return this.offset;
    }

    public Long getLength() {
        return this.length;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.offset), this.length);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof HttpRange)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        HttpRange httpRange = (HttpRange) obj;
        return httpRange.offset == this.offset && Objects.equals(httpRange.length, this.length);
    }

    public String toString() {
        return (this.length == null ? new StringBuilder("bytes=").append(this.offset).append("-") : new StringBuilder("bytes=").append(this.offset).append("-").append((this.offset + this.length.longValue()) - 1)).toString();
    }
}
