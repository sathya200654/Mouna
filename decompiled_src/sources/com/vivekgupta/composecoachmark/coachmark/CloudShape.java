package com.vivekgupta.composecoachmark.coachmark;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MessageBoxShapes.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/vivekgupta/composecoachmark/coachmark/CloudShape;", "Landroidx/compose/ui/graphics/Shape;", "()V", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline;", "composecoachmark_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CloudShape implements Shape {
    public static final int $stable = 0;
    public static final CloudShape INSTANCE = new CloudShape();

    private CloudShape() {
    }

    /* JADX INFO: renamed from: createOutline-Pq9zytI, reason: not valid java name */
    public Outline m2223createOutlinePq9zytI(long size, LayoutDirection layoutDirection, Density density) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        float f = Size.getHeight-impl(size) / 2.0f;
        float f2 = Size.getWidth-impl(size) / 4.0f;
        float f3 = Size.getHeight-impl(size) / 4.0f;
        float f4 = Size.getWidth-impl(size) / 2.0f;
        float f5 = (Size.getWidth-impl(size) * 3.0f) / 4.0f;
        float f6 = Size.getHeight-impl(size) / 4.0f;
        float f7 = Size.getWidth-impl(size);
        float f8 = Size.getHeight-impl(size) / 2.0f;
        Path Path = AndroidPath_androidKt.Path();
        Path.moveTo(0.0f, f);
        Path.quadraticBezierTo(0.0f, Size.getHeight-impl(size) / 4.0f, f2, f3);
        Path.quadraticBezierTo(Size.getWidth-impl(size) / 4, 0.0f, f4, 0.0f);
        Path.quadraticBezierTo((Size.getWidth-impl(size) * 3.0f) / 4.0f, 0.0f, f5, f6);
        Path.quadraticBezierTo(Size.getWidth-impl(size), Size.getHeight-impl(size) / 4.0f, f7, f8);
        Path.quadraticBezierTo(Size.getWidth-impl(size), (Size.getHeight-impl(size) * 3.0f) / 4.0f, (Size.getWidth-impl(size) * 3.0f) / 4.0f, (Size.getHeight-impl(size) * 3.0f) / 4.0f);
        Path.quadraticBezierTo((Size.getWidth-impl(size) * 3.0f) / 4.0f, Size.getHeight-impl(size), Size.getWidth-impl(size) / 2.0f, Size.getHeight-impl(size));
        Path.quadraticBezierTo(Size.getWidth-impl(size) / 4.0f, Size.getHeight-impl(size), Size.getWidth-impl(size) / 4.0f, (Size.getHeight-impl(size) * 3.0f) / 4.0f);
        Path.quadraticBezierTo(0.0f, (Size.getHeight-impl(size) * 3.0f) / 4.0f, 0.0f, Size.getHeight-impl(size) / 2);
        Path.close();
        return new Outline.Generic(Path);
    }
}
