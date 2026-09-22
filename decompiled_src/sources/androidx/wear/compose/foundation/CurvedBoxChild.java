package androidx.wear.compose.foundation;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CurvedBox.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B>\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\f¢\u0006\u0002\u0010\rJ*\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0016R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Landroidx/wear/compose/foundation/CurvedBoxChild;", "Landroidx/wear/compose/foundation/ContainerChild;", "curvedLayoutDirection", "Landroidx/wear/compose/foundation/CurvedLayoutDirection;", "radialAlignment", "Landroidx/wear/compose/foundation/CurvedAlignment$Radial;", "angularAlignment", "Landroidx/wear/compose/foundation/CurvedAlignment$Angular;", "contentBuilder", "Lkotlin/Function1;", "Landroidx/wear/compose/foundation/CurvedScope;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/wear/compose/foundation/CurvedLayoutDirection;Landroidx/wear/compose/foundation/CurvedAlignment$Radial;Landroidx/wear/compose/foundation/CurvedAlignment$Angular;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "doAngularPosition", "", "parentStartAngleRadians", "parentSweepRadians", "centerOffset", "Landroidx/compose/ui/geometry/Offset;", "doAngularPosition-0AR0LA0", "(FFJ)F", "doEstimateThickness", "maxRadius", "doRadialPosition", "Landroidx/wear/compose/foundation/PartialLayoutInfo;", "parentOuterRadius", "parentThickness", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CurvedBoxChild extends ContainerChild {
    public static final int $stable = 0;
    private final CurvedAlignment.Angular angularAlignment;
    private final CurvedAlignment.Radial radialAlignment;

    public /* synthetic */ CurvedBoxChild(CurvedLayoutDirection curvedLayoutDirection, CurvedAlignment.Radial radial, CurvedAlignment.Angular angular, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(curvedLayoutDirection, radial, angular, function1);
    }

    public /* synthetic */ CurvedBoxChild(CurvedLayoutDirection curvedLayoutDirection, CurvedAlignment.Radial radial, CurvedAlignment.Angular angular, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(curvedLayoutDirection, (i & 2) != 0 ? null : radial, (i & 4) != 0 ? null : angular, function1, null);
    }

    private CurvedBoxChild(CurvedLayoutDirection curvedLayoutDirection, CurvedAlignment.Radial radial, CurvedAlignment.Angular angular, Function1<? super CurvedScope, Unit> function1) {
        super(curvedLayoutDirection, false, function1);
        this.radialAlignment = radial;
        this.angularAlignment = angular;
    }

    @Override // androidx.wear.compose.foundation.CurvedChild
    public float doEstimateThickness(float maxRadius) {
        Float f;
        List<CurvedChild> children$compose_foundation_release = getChildren$compose_foundation_release();
        if (children$compose_foundation_release.isEmpty()) {
            f = null;
        } else {
            Float fValueOf = Float.valueOf(children$compose_foundation_release.get(0).estimateThickness(maxRadius));
            int lastIndex = CollectionsKt.getLastIndex(children$compose_foundation_release);
            int i = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Float fValueOf2 = Float.valueOf(children$compose_foundation_release.get(i).estimateThickness(maxRadius));
                    if (fValueOf2.compareTo(fValueOf) > 0) {
                        fValueOf = fValueOf2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
            f = fValueOf;
        }
        Float f2 = f;
        if (f2 != null) {
            return f2.floatValue();
        }
        return 0.0f;
    }

    @Override // androidx.wear.compose.foundation.CurvedChild
    public PartialLayoutInfo doRadialPosition(float parentOuterRadius, float parentThickness) {
        float ratio;
        float estimatedThickness;
        Float f;
        float ratio2;
        float estimatedThickness2;
        List<CurvedChild> children$compose_foundation_release = getChildren$compose_foundation_release();
        if (children$compose_foundation_release.isEmpty()) {
            f = null;
        } else {
            CurvedChild curvedChild = children$compose_foundation_release.get(0);
            CurvedAlignment.Radial radial = this.radialAlignment;
            if (radial != null) {
                ratio = parentOuterRadius - (radial.getRatio() * (parentThickness - curvedChild.getEstimatedThickness()));
                estimatedThickness = curvedChild.getEstimatedThickness();
            } else {
                ratio = parentOuterRadius;
                estimatedThickness = parentThickness;
            }
            curvedChild.radialPosition(ratio, estimatedThickness);
            Float fValueOf = Float.valueOf(curvedChild.getSweepRadians$compose_foundation_release());
            int lastIndex = CollectionsKt.getLastIndex(children$compose_foundation_release);
            int i = 1;
            if (1 <= lastIndex) {
                while (true) {
                    CurvedChild curvedChild2 = children$compose_foundation_release.get(i);
                    CurvedAlignment.Radial radial2 = this.radialAlignment;
                    if (radial2 != null) {
                        ratio2 = parentOuterRadius - (radial2.getRatio() * (parentThickness - curvedChild2.getEstimatedThickness()));
                        estimatedThickness2 = curvedChild2.getEstimatedThickness();
                    } else {
                        ratio2 = parentOuterRadius;
                        estimatedThickness2 = parentThickness;
                    }
                    curvedChild2.radialPosition(ratio2, estimatedThickness2);
                    Float fValueOf2 = Float.valueOf(curvedChild2.getSweepRadians$compose_foundation_release());
                    if (fValueOf2.compareTo(fValueOf) > 0) {
                        fValueOf = fValueOf2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
            f = fValueOf;
        }
        Float f2 = f;
        return new PartialLayoutInfo(f2 != null ? f2.floatValue() : 0.0f, parentOuterRadius, parentThickness, parentOuterRadius - (parentThickness / 2));
    }

    @Override // androidx.wear.compose.foundation.CurvedChild
    /* JADX INFO: renamed from: doAngularPosition-0AR0LA0 */
    public float mo234doAngularPosition0AR0LA0(float parentStartAngleRadians, float parentSweepRadians, long centerOffset) {
        float ratio;
        float sweepRadians$compose_foundation_release;
        List<CurvedChild> children$compose_foundation_release = getChildren$compose_foundation_release();
        int size = children$compose_foundation_release.size();
        for (int i = 0; i < size; i++) {
            CurvedChild curvedChild = children$compose_foundation_release.get(i);
            CurvedAlignment.Angular angular = this.angularAlignment;
            if (angular != null) {
                ratio = (angular.getRatio() * (parentSweepRadians - curvedChild.getSweepRadians$compose_foundation_release())) + parentStartAngleRadians;
                sweepRadians$compose_foundation_release = curvedChild.getSweepRadians$compose_foundation_release();
            } else {
                ratio = parentStartAngleRadians;
                sweepRadians$compose_foundation_release = parentSweepRadians;
            }
            curvedChild.m276angularPosition0AR0LA0(ratio, sweepRadians$compose_foundation_release, centerOffset);
        }
        return parentStartAngleRadians;
    }
}
