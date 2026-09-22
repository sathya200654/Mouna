package coil3.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil3.decode.DecodeUtils;
import coil3.size.Scale;
import coil3.size.Size;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: DrawableUtils.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002J(\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcoil3/util/DrawableUtils;", "", "<init>", "()V", "DEFAULT_SIZE", "", "convertToBitmap", "Landroid/graphics/Bitmap;", "drawable", "Landroid/graphics/drawable/Drawable;", "config", "Landroid/graphics/Bitmap$Config;", "size", "Lcoil3/size/Size;", "scale", "Lcoil3/size/Scale;", "allowInexactSize", "", "isConfigValid", "bitmap", "isSizeValid", "coil-core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DrawableUtils {
    private static final int DEFAULT_SIZE = 512;
    public static final DrawableUtils INSTANCE = new DrawableUtils();

    private DrawableUtils() {
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public final Bitmap convertToBitmap(Drawable drawable, Bitmap.Config config, Size size, Scale scale, boolean allowInexactSize) throws NoWhenBranchMatchedException {
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            if (isConfigValid(bitmap, config) && isSizeValid(allowInexactSize, bitmap, size, scale)) {
                return bitmap;
            }
        }
        Drawable drawableMutate = drawable.mutate();
        int width = Utils_androidKt.getWidth(drawableMutate);
        int i = DEFAULT_SIZE;
        if (width <= 0) {
            width = DEFAULT_SIZE;
        }
        int height = Utils_androidKt.getHeight(drawableMutate);
        if (height > 0) {
            i = height;
        }
        long jM1048computeDstSizesEdh43o = DecodeUtils.m1048computeDstSizesEdh43o(width, i, size, scale, Size.ORIGINAL);
        double dComputeSizeMultiplier = DecodeUtils.computeSizeMultiplier(width, i, IntPair.m1108getFirstimpl(jM1048computeDstSizesEdh43o), IntPair.m1109getSecondimpl(jM1048computeDstSizesEdh43o), scale);
        int iRoundToInt = MathKt.roundToInt(((double) width) * dComputeSizeMultiplier);
        int iRoundToInt2 = MathKt.roundToInt(dComputeSizeMultiplier * ((double) i));
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iRoundToInt, iRoundToInt2, BitmapsKt.toSoftware(config));
        Rect bounds = drawableMutate.getBounds();
        int i2 = bounds.left;
        int i3 = bounds.top;
        int i4 = bounds.right;
        int i5 = bounds.bottom;
        drawableMutate.setBounds(0, 0, iRoundToInt, iRoundToInt2);
        drawableMutate.draw(new Canvas(bitmapCreateBitmap));
        drawableMutate.setBounds(i2, i3, i4, i5);
        return bitmapCreateBitmap;
    }

    private final boolean isConfigValid(Bitmap bitmap, Bitmap.Config config) {
        return bitmap.getConfig() == BitmapsKt.toSoftware(config);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    private final boolean isSizeValid(boolean allowInexactSize, Bitmap bitmap, Size size, Scale scale) throws NoWhenBranchMatchedException {
        if (allowInexactSize) {
            return true;
        }
        long jM1048computeDstSizesEdh43o = DecodeUtils.m1048computeDstSizesEdh43o(bitmap.getWidth(), bitmap.getHeight(), size, scale, Size.ORIGINAL);
        return DecodeUtils.computeSizeMultiplier(bitmap.getWidth(), bitmap.getHeight(), IntPair.m1108getFirstimpl(jM1048computeDstSizesEdh43o), IntPair.m1109getSecondimpl(jM1048computeDstSizesEdh43o), scale) == 1.0d;
    }
}
