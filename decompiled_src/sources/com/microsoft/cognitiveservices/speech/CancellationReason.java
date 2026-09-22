package com.microsoft.cognitiveservices.speech;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public enum CancellationReason {
    Error(1),
    EndOfStream(2),
    CancelledByUser(3);

    private final int id;

    CancellationReason(int i) {
        this.id = i;
    }

    public int getValue() {
        return this.id;
    }
}
