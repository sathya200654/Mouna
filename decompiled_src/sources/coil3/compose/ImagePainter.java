package coil3.compose;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import coil3.Image;
import kotlin.Metadata;

/* JADX INFO: compiled from: ImagePainter.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\f\u001a\u00020\r*\u00020\u000eH\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcoil3/compose/ImagePainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "image", "Lcoil3/Image;", "<init>", "(Lcoil3/Image;)V", "getImage", "()Lcoil3/Image;", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "onDraw", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "coil-compose-core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ImagePainter extends Painter {
    public static final int $stable = 8;
    private final Image image;

    public final Image getImage() {
        return this.image;
    }

    public ImagePainter(Image image) {
        this.image = image;
    }

    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc, reason: not valid java name */
    public long m1017getIntrinsicSizeNHjbRc() {
        int width = this.image.getWidth();
        float f = width > 0 ? width : Float.NaN;
        int height = this.image.getHeight();
        return Size.constructor-impl((((long) Float.floatToRawIntBits(height > 0 ? height : Float.NaN)) & 4294967295L) | (((long) Float.floatToRawIntBits(f)) << 32));
    }

    protected void onDraw(DrawScope drawScope) {
        int width = this.image.getWidth();
        float fIntBitsToFloat = width > 0 ? Float.intBitsToFloat((int) (drawScope.getSize-NH-jbRc() >> 32)) / width : 1.0f;
        int height = this.image.getHeight();
        float fIntBitsToFloat2 = height > 0 ? Float.intBitsToFloat((int) (drawScope.getSize-NH-jbRc() & 4294967295L)) / height : 1.0f;
        long j = Offset.Companion.getZero-F1C5BW0();
        DrawContext drawContext = drawScope.getDrawContext();
        long j2 = drawContext.getSize-NH-jbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().scale-0AR0LA0(fIntBitsToFloat, fIntBitsToFloat2, j);
            this.image.draw(ImagePainter_androidKt.getNativeCanvas(drawScope.getDrawContext().getCanvas()));
        } finally {
            drawContext.getCanvas().restore();
            drawContext.setSize-uvyYCjk(j2);
        }
    }
}
