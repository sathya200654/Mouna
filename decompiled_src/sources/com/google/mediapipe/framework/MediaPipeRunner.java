package com.google.mediapipe.framework;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public abstract class MediaPipeRunner extends Graph {
    protected Context context;

    public abstract void pause();

    public abstract void release();

    public abstract void resume();

    public abstract void start();

    public MediaPipeRunner(Context context) {
        AssetCache.create(context);
        this.context = context;
    }

    public void loadBinaryGraphFromAsset(String assetPath) {
        try {
            loadBinaryGraph(AssetCache.getAssetCache().getAbsolutePathFromAsset(assetPath));
        } catch (MediaPipeException unused) {
        }
    }

    public void release(long timeoutMillis) {
        release();
    }
}
