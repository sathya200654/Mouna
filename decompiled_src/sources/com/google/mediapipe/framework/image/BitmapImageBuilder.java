package com.google.mediapipe.framework.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class BitmapImageBuilder {
    private final Bitmap bitmap;
    private long timestamp;

    public BitmapImageBuilder(Bitmap bitmap) {
        this.bitmap = bitmap;
        this.timestamp = 0L;
    }

    public BitmapImageBuilder(Context context, Uri uri) throws IOException {
        this(MediaStore.Images.Media.getBitmap(context.getContentResolver(), uri));
    }

    BitmapImageBuilder setTimestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public MPImage build() {
        return new MPImage(new BitmapImageContainer(this.bitmap), this.timestamp, this.bitmap.getWidth(), this.bitmap.getHeight());
    }
}
