package com.azure.core.http;

import java.time.OffsetDateTime;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public class RequestConditions extends MatchConditions {
    private OffsetDateTime ifModifiedSince;
    private OffsetDateTime ifUnmodifiedSince;

    @Override // com.azure.core.http.MatchConditions
    public RequestConditions setIfMatch(String str) {
        super.setIfMatch(str);
        return this;
    }

    @Override // com.azure.core.http.MatchConditions
    public RequestConditions setIfNoneMatch(String str) {
        super.setIfNoneMatch(str);
        return this;
    }

    public OffsetDateTime getIfModifiedSince() {
        return this.ifModifiedSince;
    }

    public RequestConditions setIfModifiedSince(OffsetDateTime offsetDateTime) {
        this.ifModifiedSince = offsetDateTime;
        return this;
    }

    public OffsetDateTime getIfUnmodifiedSince() {
        return this.ifUnmodifiedSince;
    }

    public RequestConditions setIfUnmodifiedSince(OffsetDateTime offsetDateTime) {
        this.ifUnmodifiedSince = offsetDateTime;
        return this;
    }
}
