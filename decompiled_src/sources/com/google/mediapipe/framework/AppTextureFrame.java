package com.google.mediapipe.framework;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class AppTextureFrame implements TextureFrame {
    private static final int DEFAULT_FORMAT = 6408;
    private final int format;
    private final int height;
    private boolean inUse;
    private boolean legacyInUse;
    private GlSyncToken releaseSyncToken;
    private final int textureName;
    private long timestamp;
    private final int width;

    public AppTextureFrame(int textureName, int width, int height) {
        this(textureName, width, height, DEFAULT_FORMAT);
    }

    public AppTextureFrame(int textureName, int width, int height, int format) {
        this.timestamp = Long.MIN_VALUE;
        this.inUse = false;
        this.legacyInUse = false;
        this.releaseSyncToken = null;
        this.textureName = textureName;
        this.width = width;
        this.height = height;
        this.format = format;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override // com.google.mediapipe.framework.TextureFrame
    public int getTextureName() {
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

    public boolean isNotYetReleased() {
        boolean z;
        synchronized (this) {
            z = this.inUse && this.releaseSyncToken == null;
        }
        return z;
    }

    public void waitUntilReleased() throws InterruptedException {
        GlSyncToken glSyncToken;
        synchronized (this) {
            while (this.inUse && this.releaseSyncToken == null) {
                wait();
            }
            glSyncToken = this.releaseSyncToken;
            if (glSyncToken != null) {
                this.inUse = false;
                this.releaseSyncToken = null;
            } else {
                glSyncToken = null;
            }
        }
        if (glSyncToken != null) {
            glSyncToken.waitOnCpu();
            glSyncToken.release();
        }
    }

    public void waitUntilReleasedWithGpuSync() throws InterruptedException {
        GlSyncToken glSyncToken;
        synchronized (this) {
            while (this.inUse && this.releaseSyncToken == null) {
                wait();
            }
            glSyncToken = this.releaseSyncToken;
            if (glSyncToken != null) {
                this.inUse = false;
                this.releaseSyncToken = null;
            } else {
                glSyncToken = null;
            }
        }
        if (glSyncToken != null) {
            glSyncToken.waitOnGpu();
            glSyncToken.release();
        }
    }

    @Deprecated
    public boolean getInUse() {
        boolean z;
        synchronized (this) {
            z = this.legacyInUse;
        }
        return z;
    }

    public void setInUse() {
        synchronized (this) {
            GlSyncToken glSyncToken = this.releaseSyncToken;
            if (glSyncToken != null) {
                glSyncToken.release();
                this.releaseSyncToken = null;
            }
            this.inUse = true;
            this.legacyInUse = true;
        }
    }

    @Override // com.google.mediapipe.framework.TextureFrame
    public void release() {
        synchronized (this) {
            this.inUse = false;
            this.legacyInUse = false;
            notifyAll();
        }
    }

    @Override // com.google.mediapipe.framework.TextureFrame, com.google.mediapipe.framework.TextureReleaseCallback
    public void release(GlSyncToken syncToken) {
        synchronized (this) {
            GlSyncToken glSyncToken = this.releaseSyncToken;
            if (glSyncToken != null) {
                glSyncToken.release();
                this.releaseSyncToken = null;
            }
            this.releaseSyncToken = syncToken;
            this.legacyInUse = false;
            notifyAll();
        }
    }

    public void finalize() {
        GlSyncToken glSyncToken = this.releaseSyncToken;
        if (glSyncToken != null) {
            glSyncToken.release();
            this.releaseSyncToken = null;
        }
    }
}
