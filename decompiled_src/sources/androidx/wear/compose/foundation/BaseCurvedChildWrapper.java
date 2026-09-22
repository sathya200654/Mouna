package androidx.wear.compose.foundation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: CurvedModifier.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0010\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0007H\u0017¢\u0006\u0002\u0010\bJ\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J*\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0016J\f\u0010\u0019\u001a\u00020\u0007*\u00020\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u0007*\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0016J\f\u0010 \u001a\u00020\u0007*\u00020!H\u0016R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\""}, d2 = {"Landroidx/wear/compose/foundation/BaseCurvedChildWrapper;", "Landroidx/wear/compose/foundation/CurvedChild;", "wrapped", "(Landroidx/wear/compose/foundation/CurvedChild;)V", "getWrapped", "()Landroidx/wear/compose/foundation/CurvedChild;", "SubComposition", "", "(Landroidx/compose/runtime/Composer;I)V", "computeParentData", "", "doAngularPosition", "", "parentStartAngleRadians", "parentSweepRadians", "centerOffset", "Landroidx/compose/ui/geometry/Offset;", "doAngularPosition-0AR0LA0", "(FFJ)F", "doEstimateThickness", "maxRadius", "doRadialPosition", "Landroidx/wear/compose/foundation/PartialLayoutInfo;", "parentOuterRadius", "parentThickness", "draw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "initializeMeasure", "Landroidx/wear/compose/foundation/CurvedMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "placeIfNeeded", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class BaseCurvedChildWrapper extends CurvedChild {
    public static final int $stable = 8;
    private final CurvedChild wrapped;

    public BaseCurvedChildWrapper(CurvedChild curvedChild) {
        this.wrapped = curvedChild;
    }

    public final CurvedChild getWrapped() {
        return this.wrapped;
    }

    @Override // androidx.wear.compose.foundation.CurvedChild
    public void SubComposition(Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-681015612);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SubComposition)84@2913L16:CurvedModifier.kt#m5emhl");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(this) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-681015612, i2, -1, "androidx.wear.compose.foundation.BaseCurvedChildWrapper.SubComposition (CurvedModifier.kt:84)");
            }
            this.wrapped.SubComposition(composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.foundation.BaseCurvedChildWrapper.SubComposition.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    BaseCurvedChildWrapper.this.SubComposition(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @Override // androidx.wear.compose.foundation.CurvedChild
    public void initializeMeasure(CurvedMeasureScope curvedMeasureScope, Iterator<? extends Measurable> it) {
        this.wrapped.initializeMeasure(curvedMeasureScope, it);
    }

    @Override // androidx.wear.compose.foundation.CurvedChild
    public Object computeParentData() {
        return this.wrapped.computeParentData();
    }

    @Override // androidx.wear.compose.foundation.CurvedChild
    public float doEstimateThickness(float maxRadius) {
        return this.wrapped.estimateThickness(maxRadius);
    }

    @Override // androidx.wear.compose.foundation.CurvedChild
    public PartialLayoutInfo doRadialPosition(float parentOuterRadius, float parentThickness) {
        return this.wrapped.radialPosition(parentOuterRadius, parentThickness);
    }

    @Override // androidx.wear.compose.foundation.CurvedChild
    /* JADX INFO: renamed from: doAngularPosition-0AR0LA0, reason: not valid java name */
    public float mo234doAngularPosition0AR0LA0(float parentStartAngleRadians, float parentSweepRadians, long centerOffset) {
        return this.wrapped.m276angularPosition0AR0LA0(parentStartAngleRadians, parentSweepRadians, centerOffset);
    }

    @Override // androidx.wear.compose.foundation.CurvedChild
    public void placeIfNeeded(Placeable.PlacementScope placementScope) {
        this.wrapped.placeIfNeeded(placementScope);
    }

    @Override // androidx.wear.compose.foundation.CurvedChild
    public void draw(DrawScope drawScope) {
        this.wrapped.draw(drawScope);
    }
}
