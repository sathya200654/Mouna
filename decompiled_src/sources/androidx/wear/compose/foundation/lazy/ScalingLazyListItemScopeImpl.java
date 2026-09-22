package androidx.wear.compose.foundation.lazy;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScalingLazyListItemScope.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0016\u0010\u0011\u001a\u00020\u0005HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\bJ'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0014\u0010\u001e\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0014\u0010\"\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0014\u0010#\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016R\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\rX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\rX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000e\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006$"}, d2 = {"Landroidx/wear/compose/foundation/lazy/ScalingLazyListItemScopeImpl;", "Landroidx/wear/compose/foundation/lazy/ScalingLazyListItemScope;", "density", "Landroidx/compose/ui/unit/Density;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "(Landroidx/compose/ui/unit/Density;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getConstraints-msEJaDk", "()J", "J", "getDensity", "()Landroidx/compose/ui/unit/Density;", "maxHeight", "Landroidx/compose/ui/unit/Dp;", "F", "maxWidth", "component1", "component2", "component2-msEJaDk", "copy", "copy-0kLqBqw", "(Landroidx/compose/ui/unit/Density;J)Landroidx/wear/compose/foundation/lazy/ScalingLazyListItemScopeImpl;", "equals", "", "other", "", "hashCode", "", "toString", "", "fillParentMaxHeight", "Landroidx/compose/ui/Modifier;", "fraction", "", "fillParentMaxSize", "fillParentMaxWidth", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ScalingLazyListItemScopeImpl implements ScalingLazyListItemScope {
    public static final int $stable = 0;
    private final long constraints;
    private final Density density;
    private final float maxHeight;
    private final float maxWidth;

    public /* synthetic */ ScalingLazyListItemScopeImpl(Density density, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(density, j);
    }

    /* JADX INFO: renamed from: copy-0kLqBqw$default, reason: not valid java name */
    public static /* synthetic */ ScalingLazyListItemScopeImpl m471copy0kLqBqw$default(ScalingLazyListItemScopeImpl scalingLazyListItemScopeImpl, Density density, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            density = scalingLazyListItemScopeImpl.density;
        }
        if ((i & 2) != 0) {
            j = scalingLazyListItemScopeImpl.constraints;
        }
        return scalingLazyListItemScopeImpl.m473copy0kLqBqw(density, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Density getDensity() {
        return this.density;
    }

    /* JADX INFO: renamed from: component2-msEJaDk, reason: not valid java name and from getter */
    public final long getConstraints() {
        return this.constraints;
    }

    /* JADX INFO: renamed from: copy-0kLqBqw, reason: not valid java name */
    public final ScalingLazyListItemScopeImpl m473copy0kLqBqw(Density density, long constraints) {
        return new ScalingLazyListItemScopeImpl(density, constraints, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScalingLazyListItemScopeImpl)) {
            return false;
        }
        ScalingLazyListItemScopeImpl scalingLazyListItemScopeImpl = (ScalingLazyListItemScopeImpl) other;
        return Intrinsics.areEqual(this.density, scalingLazyListItemScopeImpl.density) && Constraints.equals-impl0(this.constraints, scalingLazyListItemScopeImpl.constraints);
    }

    public int hashCode() {
        return (this.density.hashCode() * 31) + Constraints.hashCode-impl(this.constraints);
    }

    public String toString() {
        return "ScalingLazyListItemScopeImpl(density=" + this.density + ", constraints=" + ((Object) Constraints.toString-impl(this.constraints)) + ')';
    }

    private ScalingLazyListItemScopeImpl(Density density, long j) {
        this.density = density;
        this.constraints = j;
        this.maxWidth = density.toDp-u2uoSUM(Constraints.getMaxWidth-impl(j));
        this.maxHeight = density.toDp-u2uoSUM(Constraints.getMaxHeight-impl(j));
    }

    public final Density getDensity() {
        return this.density;
    }

    /* JADX INFO: renamed from: getConstraints-msEJaDk, reason: not valid java name */
    public final long m474getConstraintsmsEJaDk() {
        return this.constraints;
    }

    @Override // androidx.wear.compose.foundation.lazy.ScalingLazyListItemScope
    public Modifier fillParentMaxSize(Modifier modifier, float f) {
        return SizeKt.size-VpY3zN4(modifier, Dp.constructor-impl(this.maxWidth * f), Dp.constructor-impl(this.maxHeight * f));
    }

    @Override // androidx.wear.compose.foundation.lazy.ScalingLazyListItemScope
    public Modifier fillParentMaxWidth(Modifier modifier, float f) {
        return SizeKt.width-3ABfNKs(modifier, Dp.constructor-impl(this.maxWidth * f));
    }

    @Override // androidx.wear.compose.foundation.lazy.ScalingLazyListItemScope
    public Modifier fillParentMaxHeight(Modifier modifier, float f) {
        return SizeKt.height-3ABfNKs(modifier, Dp.constructor-impl(this.maxHeight * f));
    }
}
