package com.google.mediapipe.framework.image;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class ByteBufferImageBuilder {
    private final ByteBuffer buffer;
    private final int height;
    private final int imageFormat;
    private long timestamp = 0;
    private final int width;

    public ByteBufferImageBuilder(ByteBuffer byteBuffer, int width, int height, int imageFormat) {
        this.buffer = byteBuffer;
        this.width = width;
        this.height = height;
        this.imageFormat = imageFormat;
    }

    ByteBufferImageBuilder setTimestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public MPImage build() {
        return new MPImage(new ByteBufferImageContainer(this.buffer, this.imageFormat), this.timestamp, this.width, this.height);
    }
}
