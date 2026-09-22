package com.google.mediapipe.framework.image;

import android.media.Image;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
class MediaImageContainer implements MPImageContainer {
    private final Image mediaImage;
    private final MPImageProperties properties;

    static int convertFormatCode(int graphicsFormat) {
        if (graphicsFormat == 42) {
            return 1;
        }
        if (graphicsFormat == 41) {
            return 2;
        }
        if (graphicsFormat != 35) {
            return graphicsFormat != 256 ? 0 : 9;
        }
        return 7;
    }

    public MediaImageContainer(Image mediaImage) {
        this.mediaImage = mediaImage;
        this.properties = MPImageProperties.builder().setStorageType(3).setImageFormat(convertFormatCode(mediaImage.getFormat())).build();
    }

    public Image getImage() {
        return this.mediaImage;
    }

    @Override // com.google.mediapipe.framework.image.MPImageContainer
    public MPImageProperties getImageProperties() {
        return this.properties;
    }

    @Override // com.google.mediapipe.framework.image.MPImageContainer
    public void close() {
        this.mediaImage.close();
    }
}
