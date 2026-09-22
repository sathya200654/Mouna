package androidx.wear.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: compiled from: PositionIndicator.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000f"}, d2 = {"Landroidx/wear/compose/material/PositionIndicatorDefaults;", "", "()V", "horizontalPadding", "Landroidx/compose/ui/unit/Dp;", "getHorizontalPadding-D9Ej5fM$compose_material_release", "()F", "F", "positionAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "getPositionAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "visibilityAnimationSpec", "getVisibilityAnimationSpec", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PositionIndicatorDefaults {
    public static final PositionIndicatorDefaults INSTANCE = new PositionIndicatorDefaults();
    private static final AnimationSpec<Float> positionAnimationSpec = AnimationSpecKt.tween$default(500, 0, new CubicBezierEasing(0.0f, 0.0f, 0.0f, 1.0f), 2, (Object) null);
    private static final AnimationSpec<Float> visibilityAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null);
    private static final float horizontalPadding = Dp.constructor-impl(2);
    public static final int $stable = 8;

    private PositionIndicatorDefaults() {
    }

    public final AnimationSpec<Float> getPositionAnimationSpec() {
        return positionAnimationSpec;
    }

    public final AnimationSpec<Float> getVisibilityAnimationSpec() {
        return visibilityAnimationSpec;
    }

    /* JADX INFO: renamed from: getHorizontalPadding-D9Ej5fM$compose_material_release, reason: not valid java name */
    public final float m702getHorizontalPaddingD9Ej5fM$compose_material_release() {
        return horizontalPadding;
    }
}
