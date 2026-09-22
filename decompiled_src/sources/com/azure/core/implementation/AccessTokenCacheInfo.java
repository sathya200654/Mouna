package com.azure.core.implementation;

import com.azure.core.credential.AccessToken;
import java.time.OffsetDateTime;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class AccessTokenCacheInfo {
    private final AccessToken cache;
    private final OffsetDateTime nextTokenRefresh;

    public AccessTokenCacheInfo(AccessToken accessToken, OffsetDateTime offsetDateTime) {
        this.cache = accessToken;
        this.nextTokenRefresh = offsetDateTime;
    }

    public AccessToken getCachedAccessToken() {
        return this.cache;
    }

    public OffsetDateTime getNextTokenRefresh() {
        return this.nextTokenRefresh;
    }
}
