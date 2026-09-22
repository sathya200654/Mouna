package com.google.mediapipe.framework.image;

import java.io.Closeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class MPImage implements Closeable {
    public static final int IMAGE_FORMAT_ALPHA = 8;
    public static final int IMAGE_FORMAT_JPEG = 9;
    public static final int IMAGE_FORMAT_NV12 = 3;
    public static final int IMAGE_FORMAT_NV21 = 4;
    public static final int IMAGE_FORMAT_RGB = 2;
    public static final int IMAGE_FORMAT_RGBA = 1;
    public static final int IMAGE_FORMAT_UNKNOWN = 0;
    public static final int IMAGE_FORMAT_VEC32F1 = 10;
    public static final int IMAGE_FORMAT_VEC32F2 = 11;
    public static final int IMAGE_FORMAT_YUV_420_888 = 7;
    public static final int IMAGE_FORMAT_YV12 = 5;
    public static final int IMAGE_FORMAT_YV21 = 6;
    public static final int STORAGE_TYPE_BITMAP = 1;
    public static final int STORAGE_TYPE_BYTEBUFFER = 2;
    public static final int STORAGE_TYPE_IMAGE_PROXY = 4;
    public static final int STORAGE_TYPE_MEDIA_IMAGE = 3;
    private final Map<MPImageProperties, MPImageContainer> containerMap;
    private final int height;
    private int referenceCount;
    private final long timestamp;
    private final int width;

    @Retention(RetentionPolicy.SOURCE)
    public @interface MPImageFormat {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface StorageType {
    }

    public List<MPImageProperties> getContainedImageProperties() {
        return Collections.singletonList(getContainer().getImageProperties());
    }

    long getTimestamp() {
        return this.timestamp;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void acquire() {
        this.referenceCount++;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        int i = this.referenceCount - 1;
        this.referenceCount = i;
        if (i == 0) {
            Iterator<MPImageContainer> it = this.containerMap.values().iterator();
            while (it.hasNext()) {
                it.next().close();
            }
        }
    }

    static final class Internal {
        private final MPImage image;

        void acquire() {
            this.image.acquire();
        }

        private Internal(MPImage image) {
            this.image = image;
        }
    }

    Internal getInternal() {
        return new Internal();
    }

    MPImage(MPImageContainer container, long timestamp, int width, int height) {
        HashMap map = new HashMap();
        this.containerMap = map;
        map.put(container.getImageProperties(), container);
        this.timestamp = timestamp;
        this.width = width;
        this.height = height;
        this.referenceCount = 1;
    }

    MPImageContainer getContainer() {
        return this.containerMap.values().iterator().next();
    }

    MPImageContainer getContainer(int storageType) {
        for (Map.Entry<MPImageProperties, MPImageContainer> entry : this.containerMap.entrySet()) {
            if (entry.getKey().getStorageType() == storageType) {
                return entry.getValue();
            }
        }
        return null;
    }

    MPImageContainer getContainer(MPImageProperties imageProperties) {
        return this.containerMap.get(imageProperties);
    }

    boolean addContainer(MPImageContainer container) {
        MPImageProperties imageProperties = container.getImageProperties();
        if (this.containerMap.containsKey(imageProperties)) {
            return false;
        }
        this.containerMap.put(imageProperties, container);
        return true;
    }
}
