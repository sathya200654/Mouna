package androidx.wear.compose.material;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageWithScrimPainter.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\u0012\u0010\u0016\u001a\u00020\u00152\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\u0013\u0010\u0017\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\f\u0010\u001e\u001a\u00020\u001f*\u00020 H\u0014R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u00020\u0010X\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, d2 = {"Landroidx/wear/compose/material/ImageWithScrimPainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "imagePainter", "brush", "Landroidx/compose/ui/graphics/Brush;", "scrimAlpha", "", "alpha", "(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/Brush;FF)V", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "getImagePainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "J", "applyAlpha", "", "applyColorFilter", "equals", "other", "", "hashCode", "", "toString", "", "onDraw", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ImageWithScrimPainter extends Painter {
    public static final int $stable = 8;
    private float alpha;
    private final Brush brush;
    private ColorFilter colorFilter;
    private final Painter imagePainter;
    private final long intrinsicSize;
    private float scrimAlpha;

    public /* synthetic */ ImageWithScrimPainter(Painter painter, Brush brush, float f, float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(painter, brush, (i & 4) != 0 ? 1.0f : f, (i & 8) != 0 ? 1.0f : f2);
    }

    public final Painter getImagePainter() {
        return this.imagePainter;
    }

    public final Brush getBrush() {
        return this.brush;
    }

    public ImageWithScrimPainter(Painter painter, Brush brush, float f, float f2) {
        this.imagePainter = painter;
        this.brush = brush;
        this.scrimAlpha = f;
        this.alpha = f2;
        this.intrinsicSize = painter.getIntrinsicSize-NH-jbRc();
    }

    protected void onDraw(DrawScope drawScope) {
        this.imagePainter.draw-x_KDEd0(drawScope, drawScope.getSize-NH-jbRc(), this.alpha, this.colorFilter);
        DrawScope.drawRect-AsUm42w$default(drawScope, this.brush, 0L, 0L, this.scrimAlpha * this.alpha, (DrawStyle) null, this.colorFilter, 0, 86, (Object) null);
    }

    protected boolean applyAlpha(float alpha) {
        this.alpha = alpha;
        return true;
    }

    protected boolean applyColorFilter(ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
        return true;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        ImageWithScrimPainter imageWithScrimPainter = (ImageWithScrimPainter) other;
        return Intrinsics.areEqual(this.imagePainter, imageWithScrimPainter.imagePainter) && Intrinsics.areEqual(this.brush, imageWithScrimPainter.brush) && this.scrimAlpha == imageWithScrimPainter.scrimAlpha;
    }

    public int hashCode() {
        return (((this.imagePainter.hashCode() * 31) + this.brush.hashCode()) * 31) + Float.hashCode(this.scrimAlpha);
    }

    public String toString() {
        return "ImageWithScrimPainter(imagePainter=" + this.imagePainter + ", brush=" + this.brush + ", scrimAlpha=" + this.scrimAlpha + ')';
    }

    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc, reason: not valid java name and from getter */
    public long getIntrinsicSize() {
        return this.intrinsicSize;
    }
}
