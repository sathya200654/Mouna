package androidx.wear.compose.foundation;

import androidx.compose.ui.layout.Measurable;
import java.util.Iterator;
import kotlin.Metadata;

/* JADX INFO: compiled from: CurvedPadding.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J*\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\bH\u0016J\u001a\u0010\u001b\u001a\u00020\u001c*\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006!"}, d2 = {"Landroidx/wear/compose/foundation/PaddingWrapper;", "Landroidx/wear/compose/foundation/BaseCurvedChildWrapper;", "child", "Landroidx/wear/compose/foundation/CurvedChild;", "paddingValues", "Landroidx/wear/compose/foundation/ArcPaddingValues;", "(Landroidx/wear/compose/foundation/CurvedChild;Landroidx/wear/compose/foundation/ArcPaddingValues;)V", "afterPx", "", "beforePx", "innerPx", "outerPx", "getPaddingValues", "()Landroidx/wear/compose/foundation/ArcPaddingValues;", "doAngularPosition", "parentStartAngleRadians", "parentSweepRadians", "centerOffset", "Landroidx/compose/ui/geometry/Offset;", "doAngularPosition-0AR0LA0", "(FFJ)F", "doEstimateThickness", "maxRadius", "doRadialPosition", "Landroidx/wear/compose/foundation/PartialLayoutInfo;", "parentOuterRadius", "parentThickness", "initializeMeasure", "", "Landroidx/wear/compose/foundation/CurvedMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PaddingWrapper extends BaseCurvedChildWrapper {
    public static final int $stable = 8;
    private float afterPx;
    private float beforePx;
    private float innerPx;
    private float outerPx;
    private final ArcPaddingValues paddingValues;

    public final ArcPaddingValues getPaddingValues() {
        return this.paddingValues;
    }

    public PaddingWrapper(CurvedChild curvedChild, ArcPaddingValues arcPaddingValues) {
        super(curvedChild);
        this.paddingValues = arcPaddingValues;
    }

    @Override // androidx.wear.compose.foundation.BaseCurvedChildWrapper, androidx.wear.compose.foundation.CurvedChild
    public void initializeMeasure(CurvedMeasureScope curvedMeasureScope, Iterator<? extends Measurable> it) {
        this.outerPx = curvedMeasureScope.m331toPx0680j_4(this.paddingValues.mo229calculateOuterPaddingbxc3Tjc(curvedMeasureScope.getCurvedLayoutDirection().getRadial()));
        this.innerPx = curvedMeasureScope.m331toPx0680j_4(this.paddingValues.mo228calculateInnerPaddingbxc3Tjc(curvedMeasureScope.getCurvedLayoutDirection().getRadial()));
        this.beforePx = curvedMeasureScope.m331toPx0680j_4(this.paddingValues.mo227calculateBeforePaddingh2ZJBLU(curvedMeasureScope.getCurvedLayoutDirection().getLayoutDirection(), curvedMeasureScope.getCurvedLayoutDirection().getAngular()));
        this.afterPx = curvedMeasureScope.m331toPx0680j_4(this.paddingValues.mo226calculateAfterPaddingh2ZJBLU(curvedMeasureScope.getCurvedLayoutDirection().getLayoutDirection(), curvedMeasureScope.getCurvedLayoutDirection().getAngular()));
        getWrapped().initializeMeasure(curvedMeasureScope, it);
    }

    @Override // androidx.wear.compose.foundation.BaseCurvedChildWrapper, androidx.wear.compose.foundation.CurvedChild
    public float doEstimateThickness(float maxRadius) {
        return getWrapped().estimateThickness(maxRadius) + this.outerPx + this.innerPx;
    }

    @Override // androidx.wear.compose.foundation.BaseCurvedChildWrapper, androidx.wear.compose.foundation.CurvedChild
    public PartialLayoutInfo doRadialPosition(float parentOuterRadius, float parentThickness) {
        CurvedChild wrapped = getWrapped();
        float f = this.outerPx;
        PartialLayoutInfo partialLayoutInfoRadialPosition = wrapped.radialPosition(parentOuterRadius - f, (parentThickness - f) - this.innerPx);
        return new PartialLayoutInfo(partialLayoutInfoRadialPosition.getSweepRadians() + ((this.beforePx + this.afterPx) / partialLayoutInfoRadialPosition.getMeasureRadius()), partialLayoutInfoRadialPosition.getOuterRadius() + this.outerPx, partialLayoutInfoRadialPosition.getThickness() + this.innerPx + this.outerPx, partialLayoutInfoRadialPosition.getMeasureRadius());
    }

    @Override // androidx.wear.compose.foundation.BaseCurvedChildWrapper, androidx.wear.compose.foundation.CurvedChild
    /* JADX INFO: renamed from: doAngularPosition-0AR0LA0 */
    public float mo234doAngularPosition0AR0LA0(float parentStartAngleRadians, float parentSweepRadians, long centerOffset) {
        float measureRadius$compose_foundation_release = this.beforePx / getMeasureRadius$compose_foundation_release();
        return getWrapped().m276angularPosition0AR0LA0(parentStartAngleRadians + measureRadius$compose_foundation_release, parentSweepRadians - ((this.beforePx + this.afterPx) / getMeasureRadius$compose_foundation_release()), centerOffset) - measureRadius$compose_foundation_release;
    }
}
