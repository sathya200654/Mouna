package androidx.wear.compose.foundation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CurvedLayout.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\r\u0010\u0016\u001a\u00020\u0017H\u0017¢\u0006\u0002\u0010\u0018J(\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001dø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\n\u0010 \u001a\u0004\u0018\u00010\u0001H\u0016J*\u0010!\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001dH\u0016ø\u0001\u0000¢\u0006\u0004\b\"\u0010\u001fJ\u0010\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004H&J\u0018\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0004H&J\u000e\u0010(\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004J\u0016\u0010)\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0004J\f\u0010*\u001a\u00020\u0017*\u00020+H\u0016J\u001a\u0010,\u001a\u00020\u0017*\u00020-2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002000/H\u0016J\f\u00101\u001a\u00020\u0017*\u000202H\u0016R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R/\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\b8@@BX\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00063"}, d2 = {"Landroidx/wear/compose/foundation/CurvedChild;", "", "()V", "<set-?>", "", "estimatedThickness", "getEstimatedThickness$compose_foundation_release", "()F", "Landroidx/wear/compose/foundation/CurvedLayoutInfo;", "layoutInfo", "getLayoutInfo$compose_foundation_release", "()Landroidx/wear/compose/foundation/CurvedLayoutInfo;", "setLayoutInfo", "(Landroidx/wear/compose/foundation/CurvedLayoutInfo;)V", "layoutInfo$delegate", "Landroidx/compose/runtime/MutableState;", "measureRadius", "getMeasureRadius$compose_foundation_release", "partialLayoutInfo", "Landroidx/wear/compose/foundation/PartialLayoutInfo;", "sweepRadians", "getSweepRadians$compose_foundation_release", "SubComposition", "", "(Landroidx/compose/runtime/Composer;I)V", "angularPosition", "parentStartAngleRadians", "parentSweepRadians", "centerOffset", "Landroidx/compose/ui/geometry/Offset;", "angularPosition-0AR0LA0", "(FFJ)F", "computeParentData", "doAngularPosition", "doAngularPosition-0AR0LA0", "doEstimateThickness", "maxRadius", "doRadialPosition", "parentOuterRadius", "parentThickness", "estimateThickness", "radialPosition", "draw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "initializeMeasure", "Landroidx/wear/compose/foundation/CurvedMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "placeIfNeeded", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class CurvedChild {
    public static final int $stable = 8;
    private float estimatedThickness;

    /* JADX INFO: renamed from: layoutInfo$delegate, reason: from kotlin metadata */
    private final MutableState layoutInfo = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    private PartialLayoutInfo partialLayoutInfo;

    public Object computeParentData() {
        return null;
    }

    /* JADX INFO: renamed from: doAngularPosition-0AR0LA0 */
    public float mo234doAngularPosition0AR0LA0(float parentStartAngleRadians, float parentSweepRadians, long centerOffset) {
        return parentStartAngleRadians;
    }

    public abstract float doEstimateThickness(float maxRadius);

    public abstract PartialLayoutInfo doRadialPosition(float parentOuterRadius, float parentThickness);

    public void draw(DrawScope drawScope) {
    }

    public void initializeMeasure(CurvedMeasureScope curvedMeasureScope, Iterator<? extends Measurable> it) {
    }

    public void placeIfNeeded(Placeable.PlacementScope placementScope) {
    }

    private final void setLayoutInfo(CurvedLayoutInfo curvedLayoutInfo) {
        this.layoutInfo.setValue(curvedLayoutInfo);
    }

    public final CurvedLayoutInfo getLayoutInfo$compose_foundation_release() {
        return (CurvedLayoutInfo) this.layoutInfo.getValue();
    }

    /* JADX INFO: renamed from: getEstimatedThickness$compose_foundation_release, reason: from getter */
    public final float getEstimatedThickness() {
        return this.estimatedThickness;
    }

    public final float getSweepRadians$compose_foundation_release() {
        PartialLayoutInfo partialLayoutInfo = this.partialLayoutInfo;
        if (partialLayoutInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partialLayoutInfo");
            partialLayoutInfo = null;
        }
        return partialLayoutInfo.getSweepRadians();
    }

    public final float getMeasureRadius$compose_foundation_release() {
        PartialLayoutInfo partialLayoutInfo = this.partialLayoutInfo;
        if (partialLayoutInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partialLayoutInfo");
            partialLayoutInfo = null;
        }
        return partialLayoutInfo.getMeasureRadius();
    }

    public void SubComposition(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-751425107);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SubComposition):CurvedLayout.kt#m5emhl");
        if ((i & 1) == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-751425107, i, -1, "androidx.wear.compose.foundation.CurvedChild.SubComposition (CurvedLayout.kt:318)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.foundation.CurvedChild.SubComposition.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    CurvedChild.this.SubComposition(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public final float estimateThickness(float maxRadius) {
        float fDoEstimateThickness = doEstimateThickness(maxRadius);
        this.estimatedThickness = fDoEstimateThickness;
        return fDoEstimateThickness;
    }

    public final PartialLayoutInfo radialPosition(float parentOuterRadius, float parentThickness) {
        PartialLayoutInfo partialLayoutInfoDoRadialPosition = doRadialPosition(parentOuterRadius, parentThickness);
        this.partialLayoutInfo = partialLayoutInfoDoRadialPosition;
        return partialLayoutInfoDoRadialPosition;
    }

    /* JADX INFO: renamed from: angularPosition-0AR0LA0, reason: not valid java name */
    public final float m276angularPosition0AR0LA0(float parentStartAngleRadians, float parentSweepRadians, long centerOffset) {
        float fMo234doAngularPosition0AR0LA0 = mo234doAngularPosition0AR0LA0(parentStartAngleRadians, parentSweepRadians, centerOffset);
        float sweepRadians$compose_foundation_release = getSweepRadians$compose_foundation_release();
        PartialLayoutInfo partialLayoutInfo = this.partialLayoutInfo;
        PartialLayoutInfo partialLayoutInfo2 = null;
        if (partialLayoutInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partialLayoutInfo");
            partialLayoutInfo = null;
        }
        float outerRadius = partialLayoutInfo.getOuterRadius();
        PartialLayoutInfo partialLayoutInfo3 = this.partialLayoutInfo;
        if (partialLayoutInfo3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partialLayoutInfo");
            partialLayoutInfo3 = null;
        }
        float thickness = partialLayoutInfo3.getThickness();
        PartialLayoutInfo partialLayoutInfo4 = this.partialLayoutInfo;
        if (partialLayoutInfo4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partialLayoutInfo");
        } else {
            partialLayoutInfo2 = partialLayoutInfo4;
        }
        setLayoutInfo(new CurvedLayoutInfo(sweepRadians$compose_foundation_release, outerRadius, thickness, centerOffset, partialLayoutInfo2.getMeasureRadius(), fMo234doAngularPosition0AR0LA0, null));
        return fMo234doAngularPosition0AR0LA0;
    }
}
