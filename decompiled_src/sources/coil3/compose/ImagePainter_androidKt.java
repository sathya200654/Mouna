package coil3.compose;

import android.content.Context;
import android.graphics.Canvas;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.BitmapPainterKt;
import androidx.compose.ui.graphics.painter.Painter;
import coil3.BitmapImage;
import coil3.DrawableImage;
import coil3.Image;
import coil3.Image_androidKt;
import com.google.accompanist.drawablepainter.DrawablePainter;
import kotlin.Metadata;

/* JADX INFO: compiled from: ImagePainter.android.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\u0010\u0003\u001a\u00060\u0004j\u0002`\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\t\"\u001c\u0010\n\u001a\u00060\u000bj\u0002`\f*\u00020\r8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"asPainter", "Landroidx/compose/ui/graphics/painter/Painter;", "Lcoil3/Image;", "context", "Landroid/content/Context;", "Lcoil3/PlatformContext;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "asPainter-55t9-rM", "(Lcoil3/Image;Landroid/content/Context;I)Landroidx/compose/ui/graphics/painter/Painter;", "nativeCanvas", "Landroid/graphics/Canvas;", "Landroidx/compose/ui/graphics/NativeCanvas;", "Landroidx/compose/ui/graphics/Canvas;", "getNativeCanvas", "(Landroidx/compose/ui/graphics/Canvas;)Landroid/graphics/Canvas;", "coil-compose-core_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ImagePainter_androidKt {
    /* JADX INFO: renamed from: asPainter-55t9-rM, reason: not valid java name */
    public static final Painter m1018asPainter55t9rM(Image image, Context context, int i) {
        if (image instanceof BitmapImage) {
            return BitmapPainterKt.BitmapPainter-QZhYCtY$default(AndroidImageBitmap_androidKt.asImageBitmap(((BitmapImage) image).getBitmap()), 0L, 0L, i, 6, (Object) null);
        }
        if (image instanceof DrawableImage) {
            return new DrawablePainter(Image_androidKt.asDrawable(image, context.getResources()).mutate());
        }
        return new ImagePainter(image);
    }

    public static final Canvas getNativeCanvas(androidx.compose.ui.graphics.Canvas canvas) {
        return AndroidCanvas_androidKt.getNativeCanvas(canvas);
    }

    /* JADX INFO: renamed from: asPainter-55t9-rM$default, reason: not valid java name */
    public static /* synthetic */ Painter m1019asPainter55t9rM$default(Image image, Context context, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = DrawScope.Companion.getDefaultFilterQuality-f-v9h1I();
        }
        return m1018asPainter55t9rM(image, context, i);
    }
}
