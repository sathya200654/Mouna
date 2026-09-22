package com.azure.core.credential;

import com.azure.core.util.logging.ClientLogger;
import java.util.Objects;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class AzureSasCredential {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) AzureSasCredential.class);
    private volatile String signature;
    private final Function<String, String> signatureEncoder;

    public AzureSasCredential(String str) {
        this(str, null);
    }

    public AzureSasCredential(String str, Function<String, String> function) {
        Objects.requireNonNull(str, "'signature' cannot be null.");
        if (str.isEmpty()) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("'signature' cannot be empty."));
        }
        this.signatureEncoder = function;
        this.signature = function != null ? function.apply(str) : str;
    }

    public String getSignature() {
        return this.signature;
    }

    public AzureSasCredential update(String str) {
        Objects.requireNonNull(str, "'signature' cannot be null.");
        if (str.isEmpty()) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("'signature' cannot be empty."));
        }
        Function<String, String> function = this.signatureEncoder;
        if (function != null) {
            str = function.apply(str);
        }
        this.signature = str;
        return this;
    }
}
