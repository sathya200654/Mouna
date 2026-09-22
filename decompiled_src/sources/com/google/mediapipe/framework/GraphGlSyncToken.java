package com.google.mediapipe.framework;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class GraphGlSyncToken implements GlSyncToken {
    private long token;

    private static native void nativeRelease(long token);

    private static native void nativeWaitOnCpu(long token);

    private static native void nativeWaitOnGpu(long token);

    @Override // com.google.mediapipe.framework.GlSyncToken
    public void waitOnCpu() {
        long j = this.token;
        if (j != 0) {
            nativeWaitOnCpu(j);
        }
    }

    @Override // com.google.mediapipe.framework.GlSyncToken
    public void waitOnGpu() {
        long j = this.token;
        if (j != 0) {
            nativeWaitOnGpu(j);
        }
    }

    @Override // com.google.mediapipe.framework.GlSyncToken
    public void release() {
        long j = this.token;
        if (j != 0) {
            nativeRelease(j);
            this.token = 0L;
        }
    }

    @Override // com.google.mediapipe.framework.GlSyncToken
    public long nativeToken() {
        return this.token;
    }

    public GraphGlSyncToken(long token) {
        this.token = token;
    }
}
