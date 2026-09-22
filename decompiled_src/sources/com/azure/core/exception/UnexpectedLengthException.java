package com.azure.core.exception;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class UnexpectedLengthException extends IllegalStateException {
    private final long bytesExpected;
    private final long bytesRead;

    public UnexpectedLengthException(String str, long j, long j2) {
        super(str);
        this.bytesRead = j;
        this.bytesExpected = j2;
    }

    public long getBytesRead() {
        return this.bytesRead;
    }

    public long getBytesExpected() {
        return this.bytesExpected;
    }
}
