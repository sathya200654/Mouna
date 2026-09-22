package androidx.wear.compose.foundation.lazy;

import androidx.compose.animation.core.Easing;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScalingLazyColumnMeasure.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J\b\u0010!\u001a\u00020\"H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0014\u0010\u0010\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006#"}, d2 = {"Landroidx/wear/compose/foundation/lazy/ReduceMotionScalingParams;", "Landroidx/wear/compose/foundation/lazy/ScalingParams;", "initial", "(Landroidx/wear/compose/foundation/lazy/ScalingParams;)V", "edgeAlpha", "", "getEdgeAlpha", "()F", "edgeScale", "getEdgeScale", "maxElementHeight", "getMaxElementHeight", "maxTransitionArea", "getMaxTransitionArea", "minElementHeight", "getMinElementHeight", "minTransitionArea", "getMinTransitionArea", "scaleInterpolator", "Landroidx/compose/animation/core/Easing;", "getScaleInterpolator", "()Landroidx/compose/animation/core/Easing;", "equals", "", "other", "", "hashCode", "", "resolveViewportVerticalOffset", "viewportConstraints", "Landroidx/compose/ui/unit/Constraints;", "resolveViewportVerticalOffset-BRTryo0", "(J)I", "toString", "", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ReduceMotionScalingParams implements ScalingParams {
    public static final int $stable = 0;
    private final ScalingParams initial;
    private final float maxElementHeight;
    private final float maxTransitionArea;
    private final float minElementHeight;
    private final float minTransitionArea;
    private final Easing scaleInterpolator;
    private final float edgeScale = 1.0f;
    private final float edgeAlpha = 1.0f;

    public ReduceMotionScalingParams(ScalingParams scalingParams) {
        this.initial = scalingParams;
        this.minElementHeight = scalingParams.getMinElementHeight();
        this.maxElementHeight = scalingParams.getMaxElementHeight();
        this.minTransitionArea = scalingParams.getMinTransitionArea();
        this.maxTransitionArea = scalingParams.getMaxTransitionArea();
        this.scaleInterpolator = scalingParams.getScaleInterpolator();
    }

    @Override // androidx.wear.compose.foundation.lazy.ScalingParams
    public float getEdgeScale() {
        return this.edgeScale;
    }

    @Override // androidx.wear.compose.foundation.lazy.ScalingParams
    public float getEdgeAlpha() {
        return this.edgeAlpha;
    }

    @Override // androidx.wear.compose.foundation.lazy.ScalingParams
    public float getMinElementHeight() {
        return this.minElementHeight;
    }

    @Override // androidx.wear.compose.foundation.lazy.ScalingParams
    public float getMaxElementHeight() {
        return this.maxElementHeight;
    }

    @Override // androidx.wear.compose.foundation.lazy.ScalingParams
    public float getMinTransitionArea() {
        return this.minTransitionArea;
    }

    @Override // androidx.wear.compose.foundation.lazy.ScalingParams
    public float getMaxTransitionArea() {
        return this.maxTransitionArea;
    }

    @Override // androidx.wear.compose.foundation.lazy.ScalingParams
    public Easing getScaleInterpolator() {
        return this.scaleInterpolator;
    }

    @Override // androidx.wear.compose.foundation.lazy.ScalingParams
    /* JADX INFO: renamed from: resolveViewportVerticalOffset-BRTryo0 */
    public int mo448resolveViewportVerticalOffsetBRTryo0(long viewportConstraints) {
        return this.initial.mo448resolveViewportVerticalOffsetBRTryo0(viewportConstraints);
    }

    public String toString() {
        return "ReduceMotionScalingParams(edgeScale=" + getEdgeScale() + ", edgeAlpha=" + getEdgeAlpha() + ", minElementHeight=" + getMinElementHeight() + ", maxElementHeight=" + getMaxElementHeight() + ", minTransitionArea=" + getMinTransitionArea() + ", maxTransitionArea=" + getMaxTransitionArea() + ')';
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        ReduceMotionScalingParams reduceMotionScalingParams = (ReduceMotionScalingParams) other;
        return getEdgeScale() == reduceMotionScalingParams.getEdgeScale() && getEdgeAlpha() == reduceMotionScalingParams.getEdgeAlpha() && getMinElementHeight() == reduceMotionScalingParams.getMinElementHeight() && getMaxElementHeight() == reduceMotionScalingParams.getMaxElementHeight() && getMinTransitionArea() == reduceMotionScalingParams.getMinTransitionArea() && getMaxTransitionArea() == reduceMotionScalingParams.getMaxTransitionArea() && Intrinsics.areEqual(getScaleInterpolator(), reduceMotionScalingParams.getScaleInterpolator());
    }

    public int hashCode() {
        return (((((((((((Float.hashCode(getEdgeScale()) * 31) + Float.hashCode(getEdgeAlpha())) * 31) + Float.hashCode(getMinElementHeight())) * 31) + Float.hashCode(getMaxElementHeight())) * 31) + Float.hashCode(getMinTransitionArea())) * 31) + Float.hashCode(getMaxTransitionArea())) * 31) + getScaleInterpolator().hashCode();
    }
}
