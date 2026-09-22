package androidx.wear.compose.foundation;

import androidx.compose.ui.layout.Measurable;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: CurvedSize.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\b \u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H$J*\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\fH\u0016J\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\fH\u0016J\u001a\u0010\u001e\u001a\u00020\u001f*\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0004R\u0019\u0010\u0006\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\r\u0010\tR\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006$"}, d2 = {"Landroidx/wear/compose/foundation/BaseSizeWrapper;", "Landroidx/wear/compose/foundation/BaseCurvedChildWrapper;", "child", "Landroidx/wear/compose/foundation/CurvedChild;", "minThickness", "Landroidx/compose/ui/unit/Dp;", "maxThickness", "(Landroidx/wear/compose/foundation/CurvedChild;FFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMaxThickness-D9Ej5fM", "()F", "F", "maxThicknessPx", "", "getMinThickness-D9Ej5fM", "minThicknessPx", "calculateSweepRadians", "partialLayoutInfo", "Landroidx/wear/compose/foundation/PartialLayoutInfo;", "doAngularPosition", "parentStartAngleRadians", "parentSweepRadians", "centerOffset", "Landroidx/compose/ui/geometry/Offset;", "doAngularPosition-0AR0LA0", "(FFJ)F", "doEstimateThickness", "maxRadius", "doRadialPosition", "parentOuterRadius", "parentThickness", "baseInitializeMeasure", "", "Landroidx/wear/compose/foundation/CurvedMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class BaseSizeWrapper extends BaseCurvedChildWrapper {
    public static final int $stable = 8;
    private final float maxThickness;
    private float maxThicknessPx;
    private final float minThickness;
    private float minThicknessPx;

    public /* synthetic */ BaseSizeWrapper(CurvedChild curvedChild, float f, float f2, DefaultConstructorMarker defaultConstructorMarker) {
        this(curvedChild, f, f2);
    }

    protected abstract float calculateSweepRadians(PartialLayoutInfo partialLayoutInfo);

    /* JADX INFO: renamed from: getMinThickness-D9Ej5fM, reason: not valid java name and from getter */
    public final float getMinThickness() {
        return this.minThickness;
    }

    /* JADX INFO: renamed from: getMaxThickness-D9Ej5fM, reason: not valid java name and from getter */
    public final float getMaxThickness() {
        return this.maxThickness;
    }

    private BaseSizeWrapper(CurvedChild curvedChild, float f, float f2) {
        super(curvedChild);
        this.minThickness = f;
        this.maxThickness = f2;
    }

    protected final void baseInitializeMeasure(CurvedMeasureScope curvedMeasureScope, Iterator<? extends Measurable> it) {
        this.minThicknessPx = curvedMeasureScope.m331toPx0680j_4(this.minThickness);
        this.maxThicknessPx = curvedMeasureScope.m331toPx0680j_4(this.maxThickness);
        getWrapped().initializeMeasure(curvedMeasureScope, it);
    }

    @Override // androidx.wear.compose.foundation.BaseCurvedChildWrapper, androidx.wear.compose.foundation.CurvedChild
    public float doEstimateThickness(float maxRadius) {
        return RangesKt.coerceIn(getWrapped().estimateThickness(maxRadius), this.minThicknessPx, this.maxThicknessPx);
    }

    @Override // androidx.wear.compose.foundation.BaseCurvedChildWrapper, androidx.wear.compose.foundation.CurvedChild
    /* JADX INFO: renamed from: doAngularPosition-0AR0LA0 */
    public float mo234doAngularPosition0AR0LA0(float parentStartAngleRadians, float parentSweepRadians, long centerOffset) {
        getWrapped().m276angularPosition0AR0LA0(parentStartAngleRadians, getSweepRadians$compose_foundation_release(), centerOffset);
        return parentStartAngleRadians;
    }

    @Override // androidx.wear.compose.foundation.BaseCurvedChildWrapper, androidx.wear.compose.foundation.CurvedChild
    public PartialLayoutInfo doRadialPosition(float parentOuterRadius, float parentThickness) {
        PartialLayoutInfo partialLayoutInfoRadialPosition = getWrapped().radialPosition(parentOuterRadius, getEstimatedThickness());
        return new PartialLayoutInfo(calculateSweepRadians(partialLayoutInfoRadialPosition), parentOuterRadius, getEstimatedThickness(), (partialLayoutInfoRadialPosition.getMeasureRadius() + partialLayoutInfoRadialPosition.getOuterRadius()) - parentOuterRadius);
    }
}
