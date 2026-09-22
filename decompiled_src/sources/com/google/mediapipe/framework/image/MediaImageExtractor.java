package com.google.mediapipe.framework.image;

import android.media.Image;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class MediaImageExtractor {
    private MediaImageExtractor() {
    }

    public static Image extract(MPImage image) {
        MPImageContainer container = image.getContainer(3);
        if (container != null) {
            return ((MediaImageContainer) container).getImage();
        }
        throw new IllegalArgumentException("Extract Media Image from a MPImage created by objects other than Media Image is not supported");
    }
}
