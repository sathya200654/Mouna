package com.google.mediapipe.framework;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface TextureFrame extends TextureReleaseCallback {
    int getFormat();

    int getHeight();

    int getTextureName();

    long getTimestamp();

    int getWidth();

    void release();

    @Override // com.google.mediapipe.framework.TextureReleaseCallback
    void release(GlSyncToken syncToken);

    default boolean supportsRetain() {
        return false;
    }

    default void retain() {
        throw new UnsupportedOperationException();
    }
}
