package com.google.mediapipe.framework;

import android.content.Context;
import android.content.res.AssetManager;
import com.google.common.io.ByteStreams;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class AndroidAssetUtil {
    private static native boolean nativeInitializeAssetManager(Context androidContext, String cacheDirPath);

    public static byte[] getAssetBytes(AssetManager assets, String assetName) {
        try {
            InputStream inputStreamOpen = assets.open(assetName);
            byte[] byteArray = ByteStreams.toByteArray(inputStreamOpen);
            inputStreamOpen.close();
            return byteArray;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized boolean initializeNativeAssetManager(Context androidContext) {
        return nativeInitializeAssetManager(androidContext, androidContext.getCacheDir().getAbsolutePath());
    }

    private AndroidAssetUtil() {
    }
}
