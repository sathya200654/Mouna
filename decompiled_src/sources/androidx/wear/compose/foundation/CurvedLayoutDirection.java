package androidx.wear.compose.foundation;

import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CurvedLayout.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J&\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005ø\u0001\u0000¢\u0006\u0002\b\u0015J\u0013\u0010\u0016\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0006\u0010\u001a\u001a\u00020\u0010R\u001c\u0010\u0004\u001a\u00020\u0005X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0002\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000e\u0010\n\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001b"}, d2 = {"Landroidx/wear/compose/foundation/CurvedLayoutDirection;", "", "radial", "Landroidx/wear/compose/foundation/CurvedDirection$Radial;", "angular", "Landroidx/wear/compose/foundation/CurvedDirection$Angular;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(IILandroidx/compose/ui/unit/LayoutDirection;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAngular-gmlPZk4$compose_foundation_release", "()I", "I", "getLayoutDirection$compose_foundation_release", "()Landroidx/compose/ui/unit/LayoutDirection;", "getRadial-Ysh6JRM$compose_foundation_release", "absoluteClockwise", "", "clockwise", "copy", "overrideRadial", "overrideAngular", "copy-3m8pbNU", "equals", "other", "hashCode", "", "outsideIn", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CurvedLayoutDirection {
    public static final int $stable = 0;
    private final int angular;
    private final LayoutDirection layoutDirection;
    private final int radial;

    public /* synthetic */ CurvedLayoutDirection(int i, int i2, LayoutDirection layoutDirection, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, layoutDirection);
    }

    private CurvedLayoutDirection(int i, int i2, LayoutDirection layoutDirection) {
        this.radial = i;
        this.angular = i2;
        this.layoutDirection = layoutDirection;
    }

    /* JADX INFO: renamed from: getRadial-Ysh6JRM$compose_foundation_release, reason: not valid java name and from getter */
    public final int getRadial() {
        return this.radial;
    }

    /* JADX INFO: renamed from: getAngular-gmlPZk4$compose_foundation_release, reason: not valid java name and from getter */
    public final int getAngular() {
        return this.angular;
    }

    /* JADX INFO: renamed from: getLayoutDirection$compose_foundation_release, reason: from getter */
    public final LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    public final boolean clockwise() {
        return CurvedDirection.Angular.m287resolveClockwiseimpl$compose_foundation_release(this.angular, this.layoutDirection);
    }

    public final boolean absoluteClockwise() {
        return CurvedDirection.Angular.m285equalsimpl0(this.angular, CurvedDirection.Angular.INSTANCE.m292getNormalgmlPZk4()) || CurvedDirection.Angular.m285equalsimpl0(this.angular, CurvedDirection.Angular.INSTANCE.m290getClockwisegmlPZk4());
    }

    public final boolean outsideIn() {
        return CurvedDirection.Radial.m297equalsimpl0(this.radial, CurvedDirection.Radial.INSTANCE.m302getOutsideInYsh6JRM());
    }

    /* JADX INFO: renamed from: copy-3m8pbNU$default, reason: not valid java name */
    public static /* synthetic */ CurvedLayoutDirection m315copy3m8pbNU$default(CurvedLayoutDirection curvedLayoutDirection, CurvedDirection.Radial radial, CurvedDirection.Angular angular, int i, Object obj) {
        if ((i & 1) != 0) {
            radial = null;
        }
        if ((i & 2) != 0) {
            angular = null;
        }
        return curvedLayoutDirection.m316copy3m8pbNU(radial, angular);
    }

    /* JADX INFO: renamed from: copy-3m8pbNU, reason: not valid java name */
    public final CurvedLayoutDirection m316copy3m8pbNU(CurvedDirection.Radial overrideRadial, CurvedDirection.Angular overrideAngular) {
        return new CurvedLayoutDirection(overrideRadial != null ? overrideRadial.getValue() : this.radial, overrideAngular != null ? overrideAngular.getValue() : this.angular, this.layoutDirection, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CurvedLayoutDirection)) {
            return false;
        }
        CurvedLayoutDirection curvedLayoutDirection = (CurvedLayoutDirection) other;
        return CurvedDirection.Radial.m297equalsimpl0(this.radial, curvedLayoutDirection.radial) && CurvedDirection.Angular.m285equalsimpl0(this.angular, curvedLayoutDirection.angular) && this.layoutDirection == curvedLayoutDirection.layoutDirection;
    }

    public int hashCode() {
        return (((CurvedDirection.Radial.m298hashCodeimpl(this.radial) * 31) + CurvedDirection.Angular.m286hashCodeimpl(this.angular)) * 31) + this.layoutDirection.hashCode();
    }
}
