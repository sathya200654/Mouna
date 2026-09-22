package com.azure.core.credential;

import java.time.Duration;
import java.time.OffsetDateTime;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class AccessToken {
    private final OffsetDateTime expiresAt;
    private final OffsetDateTime refreshAt;
    private final String token;
    private final String tokenType;

    public AccessToken(String str, OffsetDateTime offsetDateTime) {
        this.token = str;
        this.expiresAt = offsetDateTime;
        this.refreshAt = null;
        this.tokenType = "Bearer";
    }

    public AccessToken(String str, OffsetDateTime offsetDateTime, OffsetDateTime offsetDateTime2) {
        this.token = str;
        this.expiresAt = offsetDateTime;
        this.refreshAt = offsetDateTime2;
        this.tokenType = "Bearer";
    }

    public AccessToken(String str, OffsetDateTime offsetDateTime, OffsetDateTime offsetDateTime2, String str2) {
        this.token = str;
        this.expiresAt = offsetDateTime;
        this.refreshAt = offsetDateTime2;
        this.tokenType = str2;
    }

    public String getToken() {
        return this.token;
    }

    public OffsetDateTime getExpiresAt() {
        return this.expiresAt;
    }

    public OffsetDateTime getRefreshAt() {
        return this.refreshAt;
    }

    public boolean isExpired() {
        return OffsetDateTime.now().isAfter(this.expiresAt);
    }

    public String getTokenType() {
        return this.tokenType;
    }

    public Duration getDurationUntilExpiration() {
        return Duration.between(this.expiresAt, OffsetDateTime.now()).negated();
    }
}
