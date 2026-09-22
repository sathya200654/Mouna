package androidx.wear.compose.foundation;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CurvedColumn.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B0\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n¢\u0006\u0002\u0010\u000bJ*\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\rH\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001a"}, d2 = {"Landroidx/wear/compose/foundation/CurvedColumnChild;", "Landroidx/wear/compose/foundation/ContainerChild;", "curvedLayoutDirection", "Landroidx/wear/compose/foundation/CurvedLayoutDirection;", "angularAlignment", "Landroidx/wear/compose/foundation/CurvedAlignment$Angular;", "contentBuilder", "Lkotlin/Function1;", "Landroidx/wear/compose/foundation/CurvedScope;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/wear/compose/foundation/CurvedLayoutDirection;Landroidx/wear/compose/foundation/CurvedAlignment$Angular;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "doAngularPosition", "", "parentStartAngleRadians", "parentSweepRadians", "centerOffset", "Landroidx/compose/ui/geometry/Offset;", "doAngularPosition-0AR0LA0", "(FFJ)F", "doEstimateThickness", "maxRadius", "doRadialPosition", "Landroidx/wear/compose/foundation/PartialLayoutInfo;", "parentOuterRadius", "parentThickness", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CurvedColumnChild extends ContainerChild {
    public static final int $stable = 0;
    private final CurvedAlignment.Angular angularAlignment;

    public /* synthetic */ CurvedColumnChild(CurvedLayoutDirection curvedLayoutDirection, CurvedAlignment.Angular angular, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(curvedLayoutDirection, angular, function1);
    }

    private CurvedColumnChild(CurvedLayoutDirection curvedLayoutDirection, CurvedAlignment.Angular angular, Function1<? super CurvedScope, Unit> function1) {
        super(curvedLayoutDirection, !curvedLayoutDirection.outsideIn(), function1);
        this.angularAlignment = angular;
    }

    @Override // androidx.wear.compose.foundation.CurvedChild
    public float doEstimateThickness(float maxRadius) {
        List<CurvedChild> children$compose_foundation_release = getChildren$compose_foundation_release();
        Float fValueOf = Float.valueOf(maxRadius);
        int size = children$compose_foundation_release.size();
        for (int i = 0; i < size; i++) {
            CurvedChild curvedChild = children$compose_foundation_release.get(i);
            float fFloatValue = fValueOf.floatValue();
            fValueOf = Float.valueOf(fFloatValue - curvedChild.estimateThickness(fFloatValue));
        }
        return maxRadius - fValueOf.floatValue();
    }

    @Override // androidx.wear.compose.foundation.CurvedChild
    public PartialLayoutInfo doRadialPosition(float parentOuterRadius, float parentThickness) {
        Float f;
        List<CurvedChild> childrenInLayoutOrder$compose_foundation_release = getChildrenInLayoutOrder$compose_foundation_release();
        ArrayList arrayList = new ArrayList(childrenInLayoutOrder$compose_foundation_release.size());
        int size = childrenInLayoutOrder$compose_foundation_release.size();
        int i = 0;
        while (true) {
            f = null;
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
            arrayList4.add(Float.valueOf(((Number) arrayList3.get(i2)).floatValue() == 0.0f ? childrenInLayoutOrder$compose_foundation_release2.get(i2).getEstimatedThickness() : 0.0f));
        }
        float fSumOfFloat2 = parentThickness - CollectionsKt.sumOfFloat(arrayList4);
        List<CurvedChild> childrenInLayoutOrder$compose_foundation_release3 = getChildrenInLayoutOrder$compose_foundation_release();
        int size3 = childrenInLayoutOrder$compose_foundation_release3.size();
        float f2 = parentOuterRadius;
        for (int i3 = 0; i3 < size3; i3++) {
            CurvedChild curvedChild = childrenInLayoutOrder$compose_foundation_release3.get(i3);
            float fFloatValue = ((Number) arrayList3.get(i3)).floatValue() > 0.0f ? (((Number) arrayList3.get(i3)).floatValue() * fSumOfFloat2) / fSumOfFloat : curvedChild.getEstimatedThickness();
            curvedChild.radialPosition(f2, fFloatValue);
            f2 -= fFloatValue;
        }
        List<CurvedChild> childrenInLayoutOrder$compose_foundation_release4 = getChildrenInLayoutOrder$compose_foundation_release();
        if (!childrenInLayoutOrder$compose_foundation_release4.isEmpty()) {
            Float fValueOf = Float.valueOf(childrenInLayoutOrder$compose_foundation_release4.get(0).getSweepRadians$compose_foundation_release());
            int lastIndex = CollectionsKt.getLastIndex(childrenInLayoutOrder$compose_foundation_release4);
            int i4 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Float fValueOf2 = Float.valueOf(childrenInLayoutOrder$compose_foundation_release4.get(i4).getSweepRadians$compose_foundation_release());
                    if (fValueOf2.compareTo(fValueOf) > 0) {
                        fValueOf = fValueOf2;
                    }
                    if (i4 == lastIndex) {
                        break;
                    }
                    i4++;
                }
            }
            f = fValueOf;
        }
        Float f3 = f;
        return new PartialLayoutInfo(f3 != null ? f3.floatValue() : 0.0f, parentOuterRadius, parentOuterRadius - f2, (f2 + parentOuterRadius) / 2);
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
