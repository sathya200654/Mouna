package androidx.wear.compose.material;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Placeholder.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\bH\u0014J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\u0013\u0010\u0017\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\f\u0010\u001e\u001a\u00020\u001f*\u00020 H\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u00020\u000eX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, d2 = {"Landroidx/wear/compose/material/PlaceholderBackgroundPainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "painter", "placeholderState", "Landroidx/wear/compose/material/PlaceholderState;", "color", "Landroidx/compose/ui/graphics/Color;", "alpha", "", "(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/wear/compose/material/PlaceholderState;JFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColor-0d7_KjU", "()J", "J", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "applyAlpha", "", "applyColorFilter", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "equals", "other", "", "hashCode", "", "toString", "", "onDraw", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PlaceholderBackgroundPainter extends Painter {
    public static final int $stable = 8;
    private float alpha;
    private final long color;
    private final long intrinsicSize;
    private final Painter painter;
    private final PlaceholderState placeholderState;

    public /* synthetic */ PlaceholderBackgroundPainter(Painter painter, PlaceholderState placeholderState, long j, float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(painter, placeholderState, j, f);
    }

    protected boolean applyColorFilter(ColorFilter colorFilter) {
        return false;
    }

    public /* synthetic */ PlaceholderBackgroundPainter(Painter painter, PlaceholderState placeholderState, long j, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(painter, placeholderState, j, (i & 8) != 0 ? 1.0f : f, null);
    }

    public final Painter getPainter() {
        return this.painter;
    }

    /* JADX INFO: renamed from: getColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getColor() {
        return this.color;
    }

    private PlaceholderBackgroundPainter(Painter painter, PlaceholderState placeholderState, long j, float f) {
        this.painter = painter;
        this.placeholderState = placeholderState;
        this.color = j;
        this.alpha = f;
        this.intrinsicSize = painter != null ? painter.getIntrinsicSize-NH-jbRc() : Size.Companion.getUnspecified-NH-jbRc();
    }

    protected void onDraw(DrawScope drawScope) {
        Pair pair;
        DrawScope drawScope2;
        int iM678getPlaceholderStage47HYLpQ$compose_material_release = this.placeholderState.m678getPlaceholderStage47HYLpQ$compose_material_release();
        if (PlaceholderStage.m669equalsimpl0(iM678getPlaceholderStage47HYLpQ$compose_material_release, PlaceholderStage.INSTANCE.m676getWipeOff47HYLpQ())) {
            pair = TuplesKt.to(PlaceholderKt.m665wipeOffBrushqcb84PM(this.color, this.placeholderState.getBackgroundOffset(), this.placeholderState), (Object) null);
        } else {
            if (PlaceholderStage.m669equalsimpl0(iM678getPlaceholderStage47HYLpQ$compose_material_release, PlaceholderStage.INSTANCE.m675getShowPlaceholder47HYLpQ()) ? true : PlaceholderStage.m669equalsimpl0(iM678getPlaceholderStage47HYLpQ$compose_material_release, PlaceholderStage.INSTANCE.m673getResetContent47HYLpQ())) {
                if (this.painter == null) {
                    pair = TuplesKt.to(new SolidColor(this.color, (DefaultConstructorMarker) null), (Object) null);
                } else {
                    pair = TuplesKt.to((Object) null, ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, this.color, 0, 2, (Object) null));
                }
            } else {
                pair = TuplesKt.to((Object) null, (Object) null);
            }
        }
        Brush brush = (Brush) pair.component1();
        ColorFilter colorFilter = (ColorFilter) pair.component2();
        this.alpha = PlaceholderStage.m669equalsimpl0(this.placeholderState.m678getPlaceholderStage47HYLpQ$compose_material_release(), PlaceholderStage.INSTANCE.m673getResetContent47HYLpQ()) ? 1.0f - this.placeholderState.getResetPlaceholderFadeOutAlpha$compose_material_release() : 1.0f;
        long j = drawScope.getSize-NH-jbRc();
        Painter painter = this.painter;
        if (painter != null) {
            painter.draw-x_KDEd0(drawScope, j, this.alpha, colorFilter);
            drawScope2 = drawScope;
        } else {
            drawScope2 = drawScope;
        }
        if (brush != null) {
            DrawScope.drawRect-AsUm42w$default(drawScope2, brush, 0L, 0L, this.alpha, (DrawStyle) null, colorFilter, 0, 86, (Object) null);
        }
    }

    protected boolean applyAlpha(float alpha) {
        this.alpha = alpha;
        return true;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type androidx.wear.compose.material.PlaceholderBackgroundPainter");
        PlaceholderBackgroundPainter placeholderBackgroundPainter = (PlaceholderBackgroundPainter) other;
        return Intrinsics.areEqual(this.painter, placeholderBackgroundPainter.painter) && Intrinsics.areEqual(this.placeholderState, placeholderBackgroundPainter.placeholderState) && Color.equals-impl0(this.color, placeholderBackgroundPainter.color) && this.alpha == placeholderBackgroundPainter.alpha && Size.equals-impl0(getIntrinsicSize(), placeholderBackgroundPainter.getIntrinsicSize());
    }

    public int hashCode() {
        Painter painter = this.painter;
        return ((((((((painter != null ? painter.hashCode() : 0) * 31) + this.placeholderState.hashCode()) * 31) + Color.hashCode-impl(this.color)) * 31) + Float.hashCode(this.alpha)) * 31) + Size.hashCode-impl(getIntrinsicSize());
    }

    public String toString() {
        return "PlaceholderBackgroundPainter(painter=" + this.painter + ", placeholderState=" + this.placeholderState + ", color=" + ((Object) Color.toString-impl(this.color)) + ", alpha=" + this.alpha + ", intrinsicSize=" + ((Object) Size.toString-impl(getIntrinsicSize())) + ')';
    }

    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc, reason: not valid java name and from getter */
    public long getIntrinsicSize() {
        return this.intrinsicSize;
    }
}
