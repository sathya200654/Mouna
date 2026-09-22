package com.google.mediapipe.framework.image;

import android.media.Image;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class MediaImageBuilder {
    private final Image mediaImage;
    private long timestamp = 0;

    public MediaImageBuilder(Image mediaImage) {
        this.mediaImage = mediaImage;
    }

    MediaImageBuilder setTimestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public MPImage build() {
        return new MPImage(new MediaImageContainer(this.mediaImage), this.timestamp, this.mediaImage.getWidth(), this.mediaImage.getHeight());
    }
}
