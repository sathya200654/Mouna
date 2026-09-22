package androidx.wear.compose.material;

import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: compiled from: ProgressIndicator.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u00020\u0006X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u000f\u0010\bR\u000e\u0010\u0010\u001a\u00020\u0011X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0080T¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u00020\u0006X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0014\u0010\bR\u0019\u0010\u0015\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0016\u0010\bR\u000e\u0010\u0017\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0011X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0011X\u0080T¢\u0006\u0002\n\u0000R\u0019\u0010\u001f\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b \u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, d2 = {"Landroidx/wear/compose/material/ProgressIndicatorDefaults;", "", "()V", "BaseRotationAngle", "", "ButtonCircularIndicatorDiameter", "Landroidx/compose/ui/unit/Dp;", "getButtonCircularIndicatorDiameter-D9Ej5fM$compose_material_release", "()F", "F", "CircularEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "getCircularEasing$compose_material_release", "()Landroidx/compose/animation/core/CubicBezierEasing;", "FullScreenStrokeWidth", "getFullScreenStrokeWidth-D9Ej5fM", "HeadAndTailAnimationDuration", "", "HeadAndTailDelayDuration", "IndeterminateCircularIndicatorDiameter", "getIndeterminateCircularIndicatorDiameter-D9Ej5fM$compose_material_release", "IndeterminateStrokeWidth", "getIndeterminateStrokeWidth-D9Ej5fM", "JumpRotationAngle", "ProgressAnimationSpec", "Landroidx/compose/animation/core/SpringSpec;", "getProgressAnimationSpec", "()Landroidx/compose/animation/core/SpringSpec;", "RotationAngleOffset", "RotationDuration", "RotationsPerCycle", "StrokeWidth", "getStrokeWidth-D9Ej5fM", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ProgressIndicatorDefaults {
    public static final int $stable = 0;
    public static final float BaseRotationAngle = 286.0f;
    public static final int HeadAndTailAnimationDuration = 666;
    public static final int HeadAndTailDelayDuration = 666;
    public static final float JumpRotationAngle = 290.0f;
    public static final float RotationAngleOffset = 216.0f;
    public static final int RotationDuration = 1332;
    public static final int RotationsPerCycle = 5;
    public static final ProgressIndicatorDefaults INSTANCE = new ProgressIndicatorDefaults();
    private static final float StrokeWidth = Dp.constructor-impl(4);
    private static final float IndeterminateStrokeWidth = Dp.constructor-impl(3);
    private static final float FullScreenStrokeWidth = Dp.constructor-impl(5);
    private static final SpringSpec<Float> ProgressAnimationSpec = new SpringSpec<>(1.0f, 50.0f, Float.valueOf(0.001f));
    private static final float ButtonCircularIndicatorDiameter = Dp.constructor-impl(40);
    private static final float IndeterminateCircularIndicatorDiameter = Dp.constructor-impl(24);
    private static final CubicBezierEasing CircularEasing = new CubicBezierEasing(0.4f, 0.0f, 0.2f, 1.0f);

    private ProgressIndicatorDefaults() {
    }

    /* JADX INFO: renamed from: getStrokeWidth-D9Ej5fM, reason: not valid java name */
    public final float m731getStrokeWidthD9Ej5fM() {
        return StrokeWidth;
    }

    /* JADX INFO: renamed from: getIndeterminateStrokeWidth-D9Ej5fM, reason: not valid java name */
    public final float m730getIndeterminateStrokeWidthD9Ej5fM() {
        return IndeterminateStrokeWidth;
    }

    /* JADX INFO: renamed from: getFullScreenStrokeWidth-D9Ej5fM, reason: not valid java name */
    public final float m728getFullScreenStrokeWidthD9Ej5fM() {
        return FullScreenStrokeWidth;
    }

    public final SpringSpec<Float> getProgressAnimationSpec() {
        return ProgressAnimationSpec;
    }

    /* JADX INFO: renamed from: getButtonCircularIndicatorDiameter-D9Ej5fM$compose_material_release, reason: not valid java name */
    public final float m727x22647636() {
        return ButtonCircularIndicatorDiameter;
    }

    /* JADX INFO: renamed from: getIndeterminateCircularIndicatorDiameter-D9Ej5fM$compose_material_release, reason: not valid java name */
    public final float m729x1ee816d3() {
        return IndeterminateCircularIndicatorDiameter;
    }

    public final CubicBezierEasing getCircularEasing$compose_material_release() {
        return CircularEasing;
    }
}
