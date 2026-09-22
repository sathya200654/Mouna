package androidx.wear.compose.foundation;

import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CurvedPadding.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\"\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\"\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H\u0016ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H\u0016ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001bJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0096\u0002J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020%H\u0016R\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\tR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\r\u0010\t\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006&"}, d2 = {"Landroidx/wear/compose/foundation/ArcPaddingValuesImpl;", "Landroidx/wear/compose/foundation/ArcPaddingValues;", "outer", "Landroidx/compose/ui/unit/Dp;", "inner", "before", "after", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAfter-D9Ej5fM", "()F", "F", "getBefore-D9Ej5fM", "getInner-D9Ej5fM", "getOuter-D9Ej5fM", "calculateAfterPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "angularDirection", "Landroidx/wear/compose/foundation/CurvedDirection$Angular;", "calculateAfterPadding-h2ZJBLU", "(Landroidx/compose/ui/unit/LayoutDirection;I)F", "calculateBeforePadding", "calculateBeforePadding-h2ZJBLU", "calculateInnerPadding", "radialDirection", "Landroidx/wear/compose/foundation/CurvedDirection$Radial;", "calculateInnerPadding-bxc3Tjc", "(I)F", "calculateOuterPadding", "calculateOuterPadding-bxc3Tjc", "equals", "", "other", "", "hashCode", "", "toString", "", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ArcPaddingValuesImpl implements ArcPaddingValues {
    public static final int $stable = 0;
    private final float after;
    private final float before;
    private final float inner;
    private final float outer;

    public /* synthetic */ ArcPaddingValuesImpl(float f, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4);
    }

    private ArcPaddingValuesImpl(float f, float f2, float f3, float f4) {
        this.outer = f;
        this.inner = f2;
        this.before = f3;
        this.after = f4;
    }

    /* JADX INFO: renamed from: getAfter-D9Ej5fM, reason: not valid java name and from getter */
    public final float getAfter() {
        return this.after;
    }

    /* JADX INFO: renamed from: getBefore-D9Ej5fM, reason: not valid java name and from getter */
    public final float getBefore() {
        return this.before;
    }

    /* JADX INFO: renamed from: getInner-D9Ej5fM, reason: not valid java name and from getter */
    public final float getInner() {
        return this.inner;
    }

    /* JADX INFO: renamed from: getOuter-D9Ej5fM, reason: not valid java name and from getter */
    public final float getOuter() {
        return this.outer;
    }

    public boolean equals(Object other) {
        if (!(other instanceof ArcPaddingValuesImpl)) {
            return false;
        }
        ArcPaddingValuesImpl arcPaddingValuesImpl = (ArcPaddingValuesImpl) other;
        return Dp.equals-impl0(this.outer, arcPaddingValuesImpl.outer) && Dp.equals-impl0(this.inner, arcPaddingValuesImpl.inner) && Dp.equals-impl0(this.before, arcPaddingValuesImpl.before) && Dp.equals-impl0(this.after, arcPaddingValuesImpl.after);
    }

    public int hashCode() {
        return (((((Dp.hashCode-impl(this.outer) * 31) + Dp.hashCode-impl(this.inner)) * 31) + Dp.hashCode-impl(this.before)) * 31) + Dp.hashCode-impl(this.after);
    }

    public String toString() {
        return "ArcPaddingValuesImpl(outer=" + ((Object) Dp.toString-impl(this.outer)) + ", inner=" + ((Object) Dp.toString-impl(this.inner)) + ", before=" + ((Object) Dp.toString-impl(this.before)) + ", after=" + ((Object) Dp.toString-impl(this.after)) + ')';
    }

    @Override // androidx.wear.compose.foundation.ArcPaddingValues
    /* JADX INFO: renamed from: calculateOuterPadding-bxc3Tjc */
    public float mo229calculateOuterPaddingbxc3Tjc(int radialDirection) {
        return this.outer;
    }

    @Override // androidx.wear.compose.foundation.ArcPaddingValues
    /* JADX INFO: renamed from: calculateInnerPadding-bxc3Tjc */
    public float mo228calculateInnerPaddingbxc3Tjc(int radialDirection) {
        return this.inner;
    }

    @Override // androidx.wear.compose.foundation.ArcPaddingValues
    /* JADX INFO: renamed from: calculateBeforePadding-h2ZJBLU */
    public float mo227calculateBeforePaddingh2ZJBLU(LayoutDirection layoutDirection, int angularDirection) {
        return this.before;
    }

    @Override // androidx.wear.compose.foundation.ArcPaddingValues
    /* JADX INFO: renamed from: calculateAfterPadding-h2ZJBLU */
    public float mo226calculateAfterPaddingh2ZJBLU(LayoutDirection layoutDirection, int angularDirection) {
        return this.after;
    }
}
