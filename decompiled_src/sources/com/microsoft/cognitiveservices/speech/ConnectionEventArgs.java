package com.microsoft.cognitiveservices.speech;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class ConnectionEventArgs extends SessionEventArgs {
    public ConnectionEventArgs(long j) {
        super(j);
        storeEventData(false);
    }

    ConnectionEventArgs(long j, boolean z) {
        super(j);
        storeEventData(z);
    }

    private void storeEventData(boolean z) {
        if (z) {
            super.close();
        }
    }
}
