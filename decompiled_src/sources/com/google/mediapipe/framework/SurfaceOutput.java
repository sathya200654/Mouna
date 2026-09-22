package com.google.mediapipe.framework;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class SurfaceOutput {
    private Graph mediapipeGraph;
    private Packet surfaceHolderPacket;

    private native void nativeSetEglSurface(long nativeContext, long nativePacket, long nativeEglSurface);

    private native void nativeSetFlipY(long nativePacket, boolean flip);

    private native void nativeSetSurface(long nativeContext, long nativePacket, Object surface);

    private native void nativeSetUpdatePresentationTime(long nativePacket, boolean updateTimestamp);

    SurfaceOutput(Graph context, Packet holderPacket) {
        this.mediapipeGraph = context;
        this.surfaceHolderPacket = holderPacket;
    }

    public void setFlipY(boolean flip) {
        nativeSetFlipY(this.surfaceHolderPacket.getNativeHandle(), flip);
    }

    public void setUpdatePresentationTime(boolean updateTimestamp) {
        nativeSetUpdatePresentationTime(this.surfaceHolderPacket.getNativeHandle(), updateTimestamp);
    }

    public void setSurface(@Nullable Object surface) {
        nativeSetSurface(this.mediapipeGraph.getNativeHandle(), this.surfaceHolderPacket.getNativeHandle(), surface);
    }

    public void setEglSurface(long nativeEglSurface) {
        nativeSetEglSurface(this.mediapipeGraph.getNativeHandle(), this.surfaceHolderPacket.getNativeHandle(), nativeEglSurface);
    }
}
