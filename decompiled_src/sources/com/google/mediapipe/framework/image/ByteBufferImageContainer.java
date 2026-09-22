package com.google.mediapipe.framework.image;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
class ByteBufferImageContainer implements MPImageContainer {
    private final ByteBuffer buffer;
    private final MPImageProperties properties;

    @Override // com.google.mediapipe.framework.image.MPImageContainer
    public void close() {
    }

    public ByteBufferImageContainer(ByteBuffer buffer, int imageFormat) {
        this.buffer = buffer;
        this.properties = MPImageProperties.builder().setStorageType(2).setImageFormat(imageFormat).build();
    }

    public ByteBuffer getByteBuffer() {
        return this.buffer;
    }

    @Override // com.google.mediapipe.framework.image.MPImageContainer
    public MPImageProperties getImageProperties() {
        return this.properties;
    }

    public int getImageFormat() {
        return this.properties.getImageFormat();
    }
}
