package androidx.wear.compose.foundation;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CurvedRow.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B2\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n¢\u0006\u0002\u0010\u000bJ*\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0016R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Landroidx/wear/compose/foundation/CurvedRowChild;", "Landroidx/wear/compose/foundation/ContainerChild;", "curvedLayoutDirection", "Landroidx/wear/compose/foundation/CurvedLayoutDirection;", "radialAlignment", "Landroidx/wear/compose/foundation/CurvedAlignment$Radial;", "contentBuilder", "Lkotlin/Function1;", "Landroidx/wear/compose/foundation/CurvedScope;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/wear/compose/foundation/CurvedLayoutDirection;Landroidx/wear/compose/foundation/CurvedAlignment$Radial;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getRadialAlignment-xcdaxW0", "()Landroidx/wear/compose/foundation/CurvedAlignment$Radial;", "doAngularPosition", "", "parentStartAngleRadians", "parentSweepRadians", "centerOffset", "Landroidx/compose/ui/geometry/Offset;", "doAngularPosition-0AR0LA0", "(FFJ)F", "doEstimateThickness", "maxRadius", "doRadialPosition", "Landroidx/wear/compose/foundation/PartialLayoutInfo;", "parentOuterRadius", "parentThickness", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CurvedRowChild extends ContainerChild {
    public static final int $stable = 0;
    private final CurvedAlignment.Radial radialAlignment;

    public /* synthetic */ CurvedRowChild(CurvedLayoutDirection curvedLayoutDirection, CurvedAlignment.Radial radial, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(curvedLayoutDirection, radial, function1);
    }

    public /* synthetic */ CurvedRowChild(CurvedLayoutDirection curvedLayoutDirection, CurvedAlignment.Radial radial, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(curvedLayoutDirection, (i & 2) != 0 ? null : radial, function1, null);
    }

    /* JADX INFO: renamed from: getRadialAlignment-xcdaxW0, reason: not valid java name and from getter */
    public final CurvedAlignment.Radial getRadialAlignment() {
        return this.radialAlignment;
    }

    private CurvedRowChild(CurvedLayoutDirection curvedLayoutDirection, CurvedAlignment.Radial radial, Function1<? super CurvedScope, Unit> function1) {
        super(curvedLayoutDirection, !curvedLayoutDirection.clockwise(), function1);
        this.radialAlignment = radial;
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
    public PartialLayoutInfo doRadialPosition(final float parentOuterRadius, final float parentThickness) {
        return new PartialLayoutInfo(CurvedLayoutKt.sumOf(getChildren$compose_foundation_release(), new Function1<CurvedChild, Float>() { // from class: androidx.wear.compose.foundation.CurvedRowChild$doRadialPosition$totalSweep$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Float invoke(CurvedChild curvedChild) {
                float ratio = parentOuterRadius;
                float estimatedThickness = parentThickness;
                if (this.getRadialAlignment() != null) {
                    ratio = parentOuterRadius - (this.getRadialAlignment().getRatio() * (parentThickness - curvedChild.getEstimatedThickness()));
                    estimatedThickness = curvedChild.getEstimatedThickness();
                }
                curvedChild.radialPosition(ratio, estimatedThickness);
                return Float.valueOf(curvedChild.getSweepRadians$compose_foundation_release());
            }
        }), parentOuterRadius, parentThickness, parentOuterRadius - (parentThickness / 2));
    }

    @Override // androidx.wear.compose.foundation.CurvedChild
    /* JADX INFO: renamed from: doAngularPosition-0AR0LA0 */
    public float mo234doAngularPosition0AR0LA0(float parentStartAngleRadians, float parentSweepRadians, long centerOffset) {
        float sweepRadians$compose_foundation_release;
        List<CurvedChild> childrenInLayoutOrder$compose_foundation_release = getChildrenInLayoutOrder$compose_foundation_release();
        ArrayList arrayList = new ArrayList(childrenInLayoutOrder$compose_foundation_release.size());
        int size = childrenInLayoutOrder$compose_foundation_release.size();
        int i = 0;
        while (true) {
            float weight = 0.0f;
            if (i >= size) {
                break;
            }
            ArrayList arrayList2 = arrayList;
            Object objComputeParentData = childrenInLayoutOrder$compose_foundation_release.get(i).computeParentData();
            CurvedScopeParentData curvedScopeParentData = objComputeParentData instanceof CurvedScopeParentData ? (CurvedScopeParentData) objComputeParentData : null;
            if (curvedScopeParentData != null) {
                weight = curvedScopeParentData.getWeight();
            }
            arrayList2.add(Float.valueOf(weight));
            i++;
        }
        ArrayList arrayList3 = arrayList;
        float fSumOfFloat = CollectionsKt.sumOfFloat(arrayList3);
        List<CurvedChild> childrenInLayoutOrder$compose_foundation_release2 = getChildrenInLayoutOrder$compose_foundation_release();
        ArrayList arrayList4 = new ArrayList(childrenInLayoutOrder$compose_foundation_release2.size());
        int size2 = childrenInLayoutOrder$compose_foundation_release2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            arrayList4.add(Float.valueOf(((Number) arrayList3.get(i2)).floatValue() == 0.0f ? childrenInLayoutOrder$compose_foundation_release2.get(i2).getSweepRadians$compose_foundation_release() : 0.0f));
        }
        float fSumOfFloat2 = parentSweepRadians - CollectionsKt.sumOfFloat(arrayList4);
        List<CurvedChild> childrenInLayoutOrder$compose_foundation_release3 = getChildrenInLayoutOrder$compose_foundation_release();
        int size3 = childrenInLayoutOrder$compose_foundation_release3.size();
        float f = parentStartAngleRadians;
        for (int i3 = 0; i3 < size3; i3++) {
            CurvedChild curvedChild = childrenInLayoutOrder$compose_foundation_release3.get(i3);
            if (((Number) arrayList3.get(i3)).floatValue() > 0.0f) {
                sweepRadians$compose_foundation_release = (((Number) arrayList3.get(i3)).floatValue() * fSumOfFloat2) / fSumOfFloat;
            } else {
                sweepRadians$compose_foundation_release = curvedChild.getSweepRadians$compose_foundation_release();
            }
            curvedChild.m276angularPosition0AR0LA0(f, sweepRadians$compose_foundation_release, centerOffset);
            f += sweepRadians$compose_foundation_release;
        }
        return parentStartAngleRadians;
    }
}
