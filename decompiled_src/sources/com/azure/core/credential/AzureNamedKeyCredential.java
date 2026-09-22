package com.azure.core.credential;

import com.azure.core.util.logging.ClientLogger;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class AzureNamedKeyCredential {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) AzureNamedKeyCredential.class);
    private volatile AzureNamedKey credentials;

    public AzureNamedKeyCredential(String str, String str2) {
        validateInputParameters(str, str2);
        this.credentials = new AzureNamedKey(str, str2);
    }

    public AzureNamedKey getAzureNamedKey() {
        return this.credentials;
    }

    public AzureNamedKeyCredential update(String str, String str2) {
        validateInputParameters(str, str2);
        this.credentials = new AzureNamedKey(str, str2);
        return this;
    }

    private void validateInputParameters(String str, String str2) {
        Objects.requireNonNull(str, "'name' cannot be null.");
        Objects.requireNonNull(str2, "'key' cannot be null.");
        if (str.isEmpty()) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("'name' cannot be empty."));
        }
        if (str2.isEmpty()) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("'key' cannot be empty."));
        }
    }
}
