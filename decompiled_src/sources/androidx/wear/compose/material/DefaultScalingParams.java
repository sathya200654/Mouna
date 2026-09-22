package androidx.wear.compose.material;

import androidx.compose.animation.core.Easing;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScalingLazyColumnMeasure.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0096\u0002J\b\u0010\u001f\u001a\u00020\u000eH\u0016J\u001a\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\rH\u0016ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\b\u0010$\u001a\u00020%H\u0016R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0014\u0010\b\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0007\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006&"}, d2 = {"Landroidx/wear/compose/material/DefaultScalingParams;", "Landroidx/wear/compose/material/ScalingParams;", "edgeScale", "", "edgeAlpha", "minElementHeight", "maxElementHeight", "minTransitionArea", "maxTransitionArea", "scaleInterpolator", "Landroidx/compose/animation/core/Easing;", "viewportVerticalOffsetResolver", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Constraints;", "", "(FFFFFFLandroidx/compose/animation/core/Easing;Lkotlin/jvm/functions/Function1;)V", "getEdgeAlpha", "()F", "getEdgeScale", "getMaxElementHeight", "getMaxTransitionArea", "getMinElementHeight", "getMinTransitionArea", "getScaleInterpolator", "()Landroidx/compose/animation/core/Easing;", "getViewportVerticalOffsetResolver", "()Lkotlin/jvm/functions/Function1;", "equals", "", "other", "", "hashCode", "resolveViewportVerticalOffset", "viewportConstraints", "resolveViewportVerticalOffset-BRTryo0", "(J)I", "toString", "", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultScalingParams implements ScalingParams {
    public static final int $stable = 0;
    private final float edgeAlpha;
    private final float edgeScale;
    private final float maxElementHeight;
    private final float maxTransitionArea;
    private final float minElementHeight;
    private final float minTransitionArea;
    private final Easing scaleInterpolator;
    private final Function1<Constraints, Integer> viewportVerticalOffsetResolver;

    public DefaultScalingParams(float f, float f2, float f3, float f4, float f5, float f6, Easing easing, Function1<? super Constraints, Integer> function1) {
        this.edgeScale = f;
        this.edgeAlpha = f2;
        this.minElementHeight = f3;
        this.maxElementHeight = f4;
        this.minTransitionArea = f5;
        this.maxTransitionArea = f6;
        this.scaleInterpolator = easing;
        this.viewportVerticalOffsetResolver = function1;
        if (getMinElementHeight() > getMaxElementHeight()) {
            throw new IllegalStateException("minElementHeight must be less than or equal to maxElementHeight".toString());
        }
        if (getMinTransitionArea() > getMaxTransitionArea()) {
            throw new IllegalStateException("minTransitionArea must be less than or equal to maxTransitionArea".toString());
        }
    }

    @Override // androidx.wear.compose.material.ScalingParams
    public float getEdgeScale() {
        return this.edgeScale;
    }

    @Override // androidx.wear.compose.material.ScalingParams
    public float getEdgeAlpha() {
        return this.edgeAlpha;
    }

    @Override // androidx.wear.compose.material.ScalingParams
    public float getMinElementHeight() {
        return this.minElementHeight;
    }

    @Override // androidx.wear.compose.material.ScalingParams
    public float getMaxElementHeight() {
        return this.maxElementHeight;
    }

    @Override // androidx.wear.compose.material.ScalingParams
    public float getMinTransitionArea() {
        return this.minTransitionArea;
    }

    @Override // androidx.wear.compose.material.ScalingParams
    public float getMaxTransitionArea() {
        return this.maxTransitionArea;
    }

    @Override // androidx.wear.compose.material.ScalingParams
    public Easing getScaleInterpolator() {
        return this.scaleInterpolator;
    }

    public final Function1<Constraints, Integer> getViewportVerticalOffsetResolver() {
        return this.viewportVerticalOffsetResolver;
    }

    @Override // androidx.wear.compose.material.ScalingParams
    /* JADX INFO: renamed from: resolveViewportVerticalOffset-BRTryo0, reason: not valid java name */
    public int mo586resolveViewportVerticalOffsetBRTryo0(long viewportConstraints) {
        return ((Number) this.viewportVerticalOffsetResolver.invoke(Constraints.box-impl(viewportConstraints))).intValue();
    }

    public String toString() {
        return "ScalingParams(edgeScale=" + getEdgeScale() + ", edgeAlpha=" + getEdgeAlpha() + ", minElementHeight=" + getMinElementHeight() + ", maxElementHeight=" + getMaxElementHeight() + ", minTransitionArea=" + getMinTransitionArea() + ", maxTransitionArea=" + getMaxTransitionArea() + ')';
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        DefaultScalingParams defaultScalingParams = (DefaultScalingParams) other;
        return getEdgeScale() == defaultScalingParams.getEdgeScale() && getEdgeAlpha() == defaultScalingParams.getEdgeAlpha() && getMinElementHeight() == defaultScalingParams.getMinElementHeight() && getMaxElementHeight() == defaultScalingParams.getMaxElementHeight() && getMinTransitionArea() == defaultScalingParams.getMinTransitionArea() && getMaxTransitionArea() == defaultScalingParams.getMaxTransitionArea() && Intrinsics.areEqual(getScaleInterpolator(), defaultScalingParams.getScaleInterpolator()) && this.viewportVerticalOffsetResolver == defaultScalingParams.viewportVerticalOffsetResolver;
    }

    public int hashCode() {
        return (((((((((((((Float.hashCode(getEdgeScale()) * 31) + Float.hashCode(getEdgeAlpha())) * 31) + Float.hashCode(getMinElementHeight())) * 31) + Float.hashCode(getMaxElementHeight())) * 31) + Float.hashCode(getMinTransitionArea())) * 31) + Float.hashCode(getMaxTransitionArea())) * 31) + getScaleInterpolator().hashCode()) * 31) + this.viewportVerticalOffsetResolver.hashCode();
    }
}
