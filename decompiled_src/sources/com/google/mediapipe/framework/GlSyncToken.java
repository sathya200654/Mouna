package com.google.mediapipe.framework;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface GlSyncToken {
    long nativeToken();

    void release();

    void waitOnCpu();

    void waitOnGpu();
}
