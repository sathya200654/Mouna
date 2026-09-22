package androidx.wear.compose.foundation;

import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CurvedDraw.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B4\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001d\u0010\u0004\u001a\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ*\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019H\u0016ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\f\u0010\u001e\u001a\u00020\b*\u00020\u0006H\u0016R(\u0010\u0004\u001a\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001f"}, d2 = {"Landroidx/wear/compose/foundation/DrawWrapper;", "Landroidx/wear/compose/foundation/BaseCurvedChildWrapper;", "child", "Landroidx/wear/compose/foundation/CurvedChild;", "customDraw", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/wear/compose/foundation/CurvedLayoutInfo;", "", "Lkotlin/ExtensionFunctionType;", "drawBefore", "", "(Landroidx/wear/compose/foundation/CurvedChild;Lkotlin/jvm/functions/Function2;Z)V", "getCustomDraw", "()Lkotlin/jvm/functions/Function2;", "getDrawBefore", "()Z", "outerLayoutInfo", "parentOuterRadius", "", "parentThickness", "doAngularPosition", "parentStartAngleRadians", "parentSweepRadians", "centerOffset", "Landroidx/compose/ui/geometry/Offset;", "doAngularPosition-0AR0LA0", "(FFJ)F", "doRadialPosition", "Landroidx/wear/compose/foundation/PartialLayoutInfo;", "draw", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DrawWrapper extends BaseCurvedChildWrapper {
    public static final int $stable = 8;
    private final Function2<DrawScope, CurvedLayoutInfo, Unit> customDraw;
    private final boolean drawBefore;
    private CurvedLayoutInfo outerLayoutInfo;
    private float parentOuterRadius;
    private float parentThickness;

    public final Function2<DrawScope, CurvedLayoutInfo, Unit> getCustomDraw() {
        return this.customDraw;
    }

    public final boolean getDrawBefore() {
        return this.drawBefore;
    }

    public DrawWrapper(CurvedChild curvedChild, Function2<? super DrawScope, ? super CurvedLayoutInfo, Unit> function2, boolean z) {
        super(curvedChild);
        this.customDraw = function2;
        this.drawBefore = z;
    }

    @Override // androidx.wear.compose.foundation.BaseCurvedChildWrapper, androidx.wear.compose.foundation.CurvedChild
    public PartialLayoutInfo doRadialPosition(float parentOuterRadius, float parentThickness) {
        this.parentThickness = parentThickness;
        this.parentOuterRadius = parentOuterRadius;
        return getWrapped().radialPosition(parentOuterRadius, parentThickness);
    }

    @Override // androidx.wear.compose.foundation.BaseCurvedChildWrapper, androidx.wear.compose.foundation.CurvedChild
    /* JADX INFO: renamed from: doAngularPosition-0AR0LA0 */
    public float mo234doAngularPosition0AR0LA0(float parentStartAngleRadians, float parentSweepRadians, long centerOffset) {
        float f = this.parentOuterRadius;
        float f2 = this.parentThickness;
        this.outerLayoutInfo = new CurvedLayoutInfo(parentSweepRadians, f, f2, centerOffset, f - (f2 / 2.0f), parentStartAngleRadians, null);
        return getWrapped().m276angularPosition0AR0LA0(parentStartAngleRadians, parentSweepRadians, centerOffset);
    }

    @Override // androidx.wear.compose.foundation.BaseCurvedChildWrapper, androidx.wear.compose.foundation.CurvedChild
    public void draw(DrawScope drawScope) {
        CurvedLayoutInfo curvedLayoutInfo = null;
        if (this.drawBefore) {
            Function2<DrawScope, CurvedLayoutInfo, Unit> function2 = this.customDraw;
            CurvedLayoutInfo curvedLayoutInfo2 = this.outerLayoutInfo;
            if (curvedLayoutInfo2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("outerLayoutInfo");
                curvedLayoutInfo2 = null;
            }
            function2.invoke(drawScope, curvedLayoutInfo2);
        }
        getWrapped().draw(drawScope);
        if (this.drawBefore) {
            return;
        }
        Function2<DrawScope, CurvedLayoutInfo, Unit> function3 = this.customDraw;
        CurvedLayoutInfo curvedLayoutInfo3 = this.outerLayoutInfo;
        if (curvedLayoutInfo3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("outerLayoutInfo");
        } else {
            curvedLayoutInfo = curvedLayoutInfo3;
        }
        function3.invoke(drawScope, curvedLayoutInfo);
    }
}
