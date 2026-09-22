package com.google.mediapipe.framework;

import com.google.common.flogger.FluentLogger;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class GraphTextureFrame implements TextureFrame {
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();
    private final Set<Long> activeConsumerContextHandleSet;
    private final boolean deferredSync;
    private final int format;
    private int height;
    private long nativeBufferHandle;
    private int refCount;
    private int textureName;
    private long timestamp;
    private int width;

    private native long nativeCreateSyncTokenForCurrentExternalContext(long nativeHandle);

    private native void nativeDidRead(long nativeHandle, long consumerSyncToken);

    private native long nativeGetCurrentExternalContextHandle();

    private native int nativeGetFormat(long nativeHandle);

    private native int nativeGetHeight(long nativeHandle);

    private native int nativeGetTextureName(long nativeHandle);

    private native int nativeGetWidth(long nativeHandle);

    private native void nativeGpuWait(long nativeHandle);

    private native void nativeReleaseBuffer(long nativeHandle);

    @Override // com.google.mediapipe.framework.TextureFrame
    public boolean supportsRetain() {
        return true;
    }

    GraphTextureFrame(long nativeHandle, long timestamp) {
        this(nativeHandle, timestamp, false);
    }

    public GraphTextureFrame(long nativeHandle, long timestamp, boolean deferredSync) {
        this.timestamp = Long.MIN_VALUE;
        this.activeConsumerContextHandleSet = new HashSet();
        this.refCount = 1;
        this.nativeBufferHandle = nativeHandle;
        this.textureName = nativeGetTextureName(nativeHandle);
        this.width = nativeGetWidth(this.nativeBufferHandle);
        this.height = nativeGetHeight(this.nativeBufferHandle);
        this.format = nativeGetFormat(this.nativeBufferHandle);
        this.timestamp = timestamp;
        this.deferredSync = deferredSync;
    }

    @Override // com.google.mediapipe.framework.TextureFrame
    public synchronized int getTextureName() {
        if (this.nativeBufferHandle == 0) {
            return 0;
        }
        long jNativeGetCurrentExternalContextHandle = nativeGetCurrentExternalContextHandle();
        if (jNativeGetCurrentExternalContextHandle != 0 && this.activeConsumerContextHandleSet.add(Long.valueOf(jNativeGetCurrentExternalContextHandle)) && this.deferredSync) {
            nativeGpuWait(this.nativeBufferHandle);
        }
        return this.textureName;
    }

    @Override // com.google.mediapipe.framework.TextureFrame
    public int getWidth() {
        return this.width;
    }

    @Override // com.google.mediapipe.framework.TextureFrame
    public int getHeight() {
        return this.height;
    }

    @Override // com.google.mediapipe.framework.TextureFrame
    public long getTimestamp() {
        return this.timestamp;
    }

    @Override // com.google.mediapipe.framework.TextureFrame
    public int getFormat() {
        return this.format;
    }

    @Override // com.google.mediapipe.framework.TextureFrame
    public synchronized void retain() {
        this.refCount++;
    }

    @Override // com.google.mediapipe.framework.TextureFrame
    public synchronized void release() {
        long jNativeGetCurrentExternalContextHandle = nativeGetCurrentExternalContextHandle();
        if (jNativeGetCurrentExternalContextHandle == 0 && !this.activeConsumerContextHandleSet.isEmpty()) {
            logger.atWarning().log("GraphTextureFrame is being released on non GL thread while having active consumers, which may lead to external / internal GL contexts synchronization issues.");
        }
        release((jNativeGetCurrentExternalContextHandle == 0 || !this.activeConsumerContextHandleSet.remove(Long.valueOf(jNativeGetCurrentExternalContextHandle))) ? null : new GraphGlSyncToken(nativeCreateSyncTokenForCurrentExternalContext(this.nativeBufferHandle)));
    }

    @Override // com.google.mediapipe.framework.TextureFrame, com.google.mediapipe.framework.TextureReleaseCallback
    public synchronized void release(GlSyncToken consumerSyncToken) {
        if (this.nativeBufferHandle == 0) {
            if (consumerSyncToken != null) {
                logger.atWarning().log("release with sync token, but handle is 0");
            }
            return;
        }
        if (consumerSyncToken != null) {
            nativeDidRead(this.nativeBufferHandle, consumerSyncToken.nativeToken());
            consumerSyncToken.release();
        }
        int i = this.refCount - 1;
        this.refCount = i;
        if (i <= 0) {
            nativeReleaseBuffer(this.nativeBufferHandle);
            this.nativeBufferHandle = 0L;
        }
    }

    protected void finalize() throws Throwable {
        if (this.refCount > 0 || this.nativeBufferHandle != 0) {
            logger.atWarning().log("release was not called before finalize");
        }
        if (this.activeConsumerContextHandleSet.isEmpty()) {
            return;
        }
        logger.atWarning().log("active consumers did not release with sync before finalize");
    }
}
