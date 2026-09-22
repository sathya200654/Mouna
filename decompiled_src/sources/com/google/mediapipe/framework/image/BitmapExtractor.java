package com.google.mediapipe.framework.image;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class BitmapExtractor {
    public static Bitmap extract(MPImage image) {
        MPImageContainer container = image.getContainer(1);
        if (container != null) {
            return ((BitmapImageContainer) container).getBitmap();
        }
        throw new IllegalArgumentException("Extracting Bitmap from a MPImage created by objects other than Bitmap is not supported");
    }

    private BitmapExtractor() {
    }
}
