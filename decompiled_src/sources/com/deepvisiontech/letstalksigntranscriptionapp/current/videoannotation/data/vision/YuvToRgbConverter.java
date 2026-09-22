package com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.data.vision;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.media.Image;
import androidx.window.embedding.DividerAttributes;
import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.perf.util.Constants;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: YuvToRgbConverter.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\u000b"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/data/vision/YuvToRgbConverter;", "", "<init>", "()V", "yuvToRgb", "", "image", "Landroid/media/Image;", "output", "Landroid/graphics/Bitmap;", "yuvToRgbDirect", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class YuvToRgbConverter {
    public static final int $stable = 0;

    public final void yuvToRgb(Image image, Bitmap output) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(output, "output");
        if (image.getFormat() != 35) {
            throw new IllegalArgumentException("Invalid image format, expected YUV_420_888");
        }
        Image.Plane[] planes = image.getPlanes();
        ByteBuffer buffer = planes[0].getBuffer();
        ByteBuffer buffer2 = planes[1].getBuffer();
        ByteBuffer buffer3 = planes[2].getBuffer();
        int iRemaining = buffer.remaining();
        int iRemaining2 = buffer2.remaining();
        int iRemaining3 = buffer3.remaining();
        byte[] bArr = new byte[iRemaining + iRemaining2 + iRemaining3];
        buffer.get(bArr, 0, iRemaining);
        buffer3.get(bArr, iRemaining, iRemaining3);
        buffer2.get(bArr, iRemaining + iRemaining3, iRemaining2);
        YuvImage yuvImage = new YuvImage(bArr, 17, image.getWidth(), image.getHeight(), null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(new Rect(0, 0, yuvImage.getWidth(), yuvImage.getHeight()), 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        new Canvas(output).drawBitmap(BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length), 0.0f, 0.0f, (Paint) null);
    }

    public final void yuvToRgbDirect(Image image, Bitmap output) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(output, "output");
        int width = image.getWidth();
        int height = image.getHeight();
        int i = 0;
        Image.Plane plane = image.getPlanes()[0];
        Image.Plane plane2 = image.getPlanes()[1];
        Image.Plane plane3 = image.getPlanes()[2];
        ByteBuffer buffer = plane.getBuffer();
        Intrinsics.checkNotNullExpressionValue(buffer, "getBuffer(...)");
        ByteBuffer buffer2 = plane2.getBuffer();
        Intrinsics.checkNotNullExpressionValue(buffer2, "getBuffer(...)");
        ByteBuffer buffer3 = plane3.getBuffer();
        Intrinsics.checkNotNullExpressionValue(buffer3, "getBuffer(...)");
        int rowStride = plane.getRowStride();
        int rowStride2 = plane2.getRowStride();
        int rowStride3 = plane3.getRowStride();
        int pixelStride = plane2.getPixelStride();
        int pixelStride2 = plane3.getPixelStride();
        int i2 = 0;
        while (i2 < height) {
            int i3 = i;
            while (i3 < width) {
                int i4 = buffer.get((i2 * rowStride) + i3) & UnsignedBytes.MAX_VALUE;
                int i5 = i2 / 2;
                int i6 = i3 / 2;
                int i7 = buffer2.get((i5 * rowStride2) + (i6 * pixelStride)) & UnsignedBytes.MAX_VALUE;
                int i8 = width;
                float f = i4;
                float f2 = (buffer3.get((i5 * rowStride3) + (i6 * pixelStride2)) & UnsignedBytes.MAX_VALUE) - 128;
                float f3 = i7 - 128;
                int iCoerceIn = RangesKt.coerceIn((int) (f + (1.370705f * f2)), 0, Constants.MAX_HOST_LENGTH);
                output.setPixel(i3, i2, (RangesKt.coerceIn((int) ((f - (f2 * 0.698001f)) - (0.337633f * f3)), 0, Constants.MAX_HOST_LENGTH) << 8) | (iCoerceIn << 16) | DividerAttributes.COLOR_SYSTEM_DEFAULT | RangesKt.coerceIn((int) (f + (f3 * 1.732446f)), 0, Constants.MAX_HOST_LENGTH));
                i3++;
                i = 0;
                width = i8;
                pixelStride2 = pixelStride2;
            }
            i2++;
            pixelStride2 = pixelStride2;
        }
    }
}
