package com.vivekgupta.composecoachmark.coachmark;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MessageBoxShapes.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J-\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/vivekgupta/composecoachmark/coachmark/BubbleMessageBox;", "Landroidx/compose/ui/graphics/Shape;", "pointerLength", "", "(F)V", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline;", "composecoachmark_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BubbleMessageBox implements Shape {
    public static final int $stable = 0;
    private final float pointerLength;

    public BubbleMessageBox() {
        this(0.0f, 1, null);
    }

    public BubbleMessageBox(float f) {
        this.pointerLength = f;
    }

    public /* synthetic */ BubbleMessageBox(float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 50.0f : f);
    }

    /* JADX INFO: renamed from: createOutline-Pq9zytI, reason: not valid java name */
    public Outline m2219createOutlinePq9zytI(long size, LayoutDirection layoutDirection, Density density) {
        Pair pair;
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        if (Size.getWidth-impl(size) > Size.getHeight-impl(size)) {
            float f = 2;
            pair = new Pair(Float.valueOf(Size.getWidth-impl(size) / f), Float.valueOf(Size.getHeight-impl(size) / f));
        } else if (Size.getHeight-impl(size) > Size.getWidth-impl(size)) {
            float f2 = 2;
            pair = new Pair(Float.valueOf(Size.getHeight-impl(size) / f2), Float.valueOf(Size.getWidth-impl(size) / f2));
        } else {
            float f3 = 2;
            pair = new Pair(Float.valueOf(Size.getHeight-impl(size) / f3), Float.valueOf(Size.getHeight-impl(size) / f3));
        }
        float fFloatValue = ((Number) pair.component1()).floatValue();
        float fFloatValue2 = ((Number) pair.component2()).floatValue();
        long jOffset = OffsetKt.Offset(Size.getWidth-impl(size) / 2.0f, Size.getHeight-impl(size) / 2.0f);
        double d = 1.7453293f;
        float f4 = Offset.getX-impl(jOffset) + (fFloatValue * ((float) Math.cos(d)));
        float f5 = Offset.getY-impl(jOffset) + (fFloatValue2 * ((float) Math.sin(d)));
        Rect rect = RectKt.Rect-tz77jQw(Offset.Companion.getZero-F1C5BW0(), size);
        Path Path = AndroidPath_androidKt.Path();
        Path.moveTo(Size.getWidth-impl(size) / 2.0f, Size.getHeight-impl(size));
        Path.arcTo(rect, 100.0f, 340.0f, true);
        Path.lineTo(Size.getWidth-impl(size) / 2, Size.getHeight-impl(size) + this.pointerLength);
        Path.lineTo(f4, f5);
        Path.close();
        return new Outline.Generic(Path);
    }
}
