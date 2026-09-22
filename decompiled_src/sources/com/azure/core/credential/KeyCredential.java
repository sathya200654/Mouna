package com.azure.core.credential;

import com.azure.core.util.logging.ClientLogger;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class KeyCredential {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) KeyCredential.class);
    private volatile String key;

    public KeyCredential(String str) {
        Objects.requireNonNull(str, "'key' cannot be null.");
        if (str.isEmpty()) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("'key' cannot be empty."));
        }
        this.key = str;
    }

    public String getKey() {
        return this.key;
    }

    public KeyCredential update(String str) {
        Objects.requireNonNull(str, "'key' cannot be null.");
        if (str.isEmpty()) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("'key' cannot be empty."));
        }
        this.key = str;
        return this;
    }
}
