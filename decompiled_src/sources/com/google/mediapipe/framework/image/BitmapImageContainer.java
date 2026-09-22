package com.google.mediapipe.framework.image;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
class BitmapImageContainer implements MPImageContainer {
    private final Bitmap bitmap;
    private final MPImageProperties properties;

    public BitmapImageContainer(Bitmap bitmap) {
        this.bitmap = bitmap;
        this.properties = MPImageProperties.builder().setImageFormat(convertFormatCode(bitmap.getConfig())).setStorageType(1).build();
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    @Override // com.google.mediapipe.framework.image.MPImageContainer
    public MPImageProperties getImageProperties() {
        return this.properties;
    }

    @Override // com.google.mediapipe.framework.image.MPImageContainer
    public void close() {
        this.bitmap.recycle();
    }

    /* JADX INFO: renamed from: com.google.mediapipe.framework.image.BitmapImageContainer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            $SwitchMap$android$graphics$Bitmap$Config = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_8888.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static int convertFormatCode(Bitmap.Config config) {
        int i = AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()];
        if (i != 1) {
            return i != 2 ? 0 : 1;
        }
        return 8;
    }
}
