package androidx.wear.compose.foundation.rotary;

import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.Easing;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.wear.compose.foundation.lazy.ScalingLazyColumnMeasureKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RotaryScrollable.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0002\u0010\tJ\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0006\u0010\u0011\u001a\u00020\u0003J \u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0002J\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0003R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/wear/compose/foundation/rotary/ThresholdHandler;", "", "maxThresholdDivider", "", "minVelocity", "maxVelocity", "smoothingConstant", "averageItemSize", "Lkotlin/Function0;", "(FFFFLkotlin/jvm/functions/Function0;)V", "rotaryVelocityTracker", "Landroidx/wear/compose/foundation/rotary/RotaryVelocityTracker;", "smoothedVelocity", "thresholdDividerEasing", "Landroidx/compose/animation/core/Easing;", "applySmoothing", "", "calculateSnapThreshold", "exponentialSmoothing", "currentVelocity", "prevVelocity", "startThresholdTracking", "time", "", "updateTracking", "timestamp", "delta", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ThresholdHandler {
    public static final int $stable = 8;
    private final Function0<Float> averageItemSize;
    private final float maxThresholdDivider;
    private final float maxVelocity;
    private final float minVelocity;
    private final RotaryVelocityTracker rotaryVelocityTracker;
    private float smoothedVelocity;
    private final float smoothingConstant;
    private final Easing thresholdDividerEasing;

    private final float exponentialSmoothing(float currentVelocity, float prevVelocity, float smoothingConstant) {
        return (currentVelocity * smoothingConstant) + ((1 - smoothingConstant) * prevVelocity);
    }

    public ThresholdHandler(float f, float f2, float f3, float f4, Function0<Float> function0) {
        this.maxThresholdDivider = f;
        this.minVelocity = f2;
        this.maxVelocity = f3;
        this.smoothingConstant = f4;
        this.averageItemSize = function0;
        this.thresholdDividerEasing = new CubicBezierEasing(0.5f, 0.0f, 0.5f, 1.0f);
        this.rotaryVelocityTracker = new RotaryVelocityTracker();
    }

    public /* synthetic */ ThresholdHandler(float f, float f2, float f3, float f4, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, (i & 2) != 0 ? 300.0f : f2, (i & 4) != 0 ? 3000.0f : f3, (i & 8) != 0 ? 0.4f : f4, function0);
    }

    public final void startThresholdTracking(long time) {
        this.rotaryVelocityTracker.start(time);
        this.smoothedVelocity = 0.0f;
    }

    public final void updateTracking(long timestamp, float delta) {
        this.rotaryVelocityTracker.move(timestamp, delta);
        applySmoothing();
    }

    public final float calculateSnapThreshold() {
        return ((Number) this.averageItemSize.invoke()).floatValue() / MathHelpersKt.lerp(1.0f, this.maxThresholdDivider, this.thresholdDividerEasing.transform(ScalingLazyColumnMeasureKt.inverseLerp(this.minVelocity, this.maxVelocity, this.smoothedVelocity)));
    }

    private final void applySmoothing() {
        if (this.rotaryVelocityTracker.getVelocity() == 0.0f) {
            return;
        }
        this.smoothedVelocity = exponentialSmoothing(Math.abs(this.rotaryVelocityTracker.getVelocity()), this.smoothedVelocity, this.smoothingConstant);
    }
}
