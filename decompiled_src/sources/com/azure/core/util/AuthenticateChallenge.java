package com.azure.core.util;

import com.azure.core.util.logging.ClientLogger;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class AuthenticateChallenge {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) AuthenticateChallenge.class);
    private final Map<String, String> parameters;
    private final String scheme;
    private final String token68;

    public AuthenticateChallenge(String str) {
        this(str, Collections.emptyMap(), null);
    }

    public AuthenticateChallenge(String str, String str2) {
        this(str, Collections.emptyMap(), str2);
    }

    public AuthenticateChallenge(String str, Map<String, String> map) {
        this(str, map, null);
    }

    AuthenticateChallenge(String str, Map<String, String> map, String str2) {
        if (CoreUtils.isNullOrEmpty(str)) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException("scheme cannot be null or empty."));
        }
        this.scheme = str;
        this.parameters = Collections.unmodifiableMap(map);
        this.token68 = str2;
    }

    public String getScheme() {
        return this.scheme;
    }

    public Map<String, String> getParameters() {
        return this.parameters;
    }

    public String getToken68() {
        return this.token68;
    }
}
