package com.google.mediapipe.framework;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class Packet {
    private long nativePacketHandle;

    private native long nativeCopyPacket(long packetHandle);

    private native long nativeGetTimestamp(long packetHandle);

    private native boolean nativeIsEmpty(long packetHandle);

    private native void nativeReleasePacket(long packetHandle);

    public static Packet create(long nativeHandle) {
        return new Packet(nativeHandle);
    }

    public long getNativeHandle() {
        return this.nativePacketHandle;
    }

    public long getTimestamp() {
        return nativeGetTimestamp(this.nativePacketHandle);
    }

    public boolean isEmpty() {
        return nativeIsEmpty(this.nativePacketHandle);
    }

    public Packet copy() {
        return new Packet(nativeCopyPacket(this.nativePacketHandle));
    }

    public void release() {
        long j = this.nativePacketHandle;
        if (j != 0) {
            nativeReleasePacket(j);
            this.nativePacketHandle = 0L;
        }
    }

    private Packet(long handle) {
        this.nativePacketHandle = handle;
    }
}
