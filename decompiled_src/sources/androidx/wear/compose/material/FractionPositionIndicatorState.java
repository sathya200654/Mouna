package androidx.wear.compose.material;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PositionIndicator.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\u001d\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u0004H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0015"}, d2 = {"Landroidx/wear/compose/material/FractionPositionIndicatorState;", "Landroidx/wear/compose/material/PositionIndicatorState;", "fraction", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "positionFraction", "getPositionFraction", "()F", "equals", "", "other", "", "hashCode", "", "sizeFraction", "scrollableContainerSizePx", "visibility", "Landroidx/wear/compose/material/PositionIndicatorVisibility;", "visibility-KCSNhGQ", "(F)I", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FractionPositionIndicatorState implements PositionIndicatorState {
    public static final int $stable = 0;
    private final Function0<Float> fraction;
    private final float positionFraction = 1.0f;

    public FractionPositionIndicatorState(Function0<Float> function0) {
        this.fraction = function0;
    }

    @Override // androidx.wear.compose.material.PositionIndicatorState
    public float getPositionFraction() {
        return this.positionFraction;
    }

    @Override // androidx.wear.compose.material.PositionIndicatorState
    public float sizeFraction(float scrollableContainerSizePx) {
        return ((Number) this.fraction.invoke()).floatValue();
    }

    public boolean equals(Object other) {
        Function0<Float> function0;
        Float f = null;
        FractionPositionIndicatorState fractionPositionIndicatorState = other instanceof FractionPositionIndicatorState ? (FractionPositionIndicatorState) other : null;
        if (fractionPositionIndicatorState != null && (function0 = fractionPositionIndicatorState.fraction) != null) {
            f = (Float) function0.invoke();
        }
        return Intrinsics.areEqual(f, ((Number) this.fraction.invoke()).floatValue());
    }

    public int hashCode() {
        return Float.hashCode(((Number) this.fraction.invoke()).floatValue());
    }

    @Override // androidx.wear.compose.material.PositionIndicatorState
    /* JADX INFO: renamed from: visibility-KCSNhGQ, reason: not valid java name */
    public int mo597visibilityKCSNhGQ(float scrollableContainerSizePx) {
        return PositionIndicatorVisibility.INSTANCE.m726getShowGLQwCHQ();
    }
}
