package com.vivekgupta.composecoachmark.coachmark;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MessageBoxShapes.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J-\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/vivekgupta/composecoachmark/coachmark/MessageShape;", "Landroidx/compose/ui/graphics/Shape;", "roundedCorner", "", "pointerLength", "(FF)V", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline;", "composecoachmark_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MessageShape implements Shape {
    public static final int $stable = 0;
    private final float pointerLength;
    private final float roundedCorner;

    /* JADX WARN: Illegal instructions before constructor call */
    public MessageShape() {
        float f = 0.0f;
        this(f, f, 3, null);
    }

    public MessageShape(float f, float f2) {
        this.roundedCorner = f;
        this.pointerLength = f2;
    }

    public /* synthetic */ MessageShape(float f, float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 20.0f : f, (i & 2) != 0 ? 50.0f : f2);
    }

    /* JADX INFO: renamed from: createOutline-Pq9zytI, reason: not valid java name */
    public Outline m2259createOutlinePq9zytI(long size, LayoutDirection layoutDirection, Density density) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        Path Path = AndroidPath_androidKt.Path();
        Path.moveTo(0.0f, 0.0f);
        Path.lineTo(Size.getWidth-impl(size) - this.roundedCorner, 0.0f);
        Path.quadraticBezierTo(Size.getWidth-impl(size), 0.0f, Size.getWidth-impl(size), this.roundedCorner);
        Path.lineTo(Size.getWidth-impl(size), Size.getHeight-impl(size) - this.roundedCorner);
        Path.quadraticBezierTo(Size.getWidth-impl(size), Size.getHeight-impl(size), Size.getWidth-impl(size) - this.roundedCorner, Size.getHeight-impl(size));
        Path.lineTo(this.roundedCorner, Size.getHeight-impl(size));
        Path.quadraticBezierTo(0.0f, Size.getHeight-impl(size), 0.0f, Size.getHeight-impl(size) - this.roundedCorner);
        Path.lineTo(0.0f, (Size.getHeight-impl(size) * 3.0f) / 4.0f);
        Path.lineTo(-this.pointerLength, (Size.getHeight-impl(size) * 3.0f) / 4.0f);
        Path.lineTo(0.0f, Size.getHeight-impl(size) / 2.0f);
        Path.lineTo(0.0f, this.roundedCorner);
        Path.quadraticBezierTo(0.0f, 0.0f, this.roundedCorner, 0.0f);
        Path.close();
        return new Outline.Generic(Path);
    }
}
