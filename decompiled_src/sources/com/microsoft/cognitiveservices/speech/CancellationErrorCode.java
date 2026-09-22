package com.microsoft.cognitiveservices.speech;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public enum CancellationErrorCode {
    NoError(0),
    AuthenticationFailure(1),
    BadRequest(2),
    TooManyRequests(3),
    Forbidden(4),
    ConnectionFailure(5),
    ServiceTimeout(6),
    ServiceError(7),
    ServiceUnavailable(8),
    RuntimeError(9),
    ServiceRedirectTemporary(10),
    ServiceRedirectPermanent(11),
    EmbeddedModelError(12);

    private final int id;

    CancellationErrorCode(int i) {
        this.id = i;
    }

    public int getValue() {
        return this.id;
    }
}
