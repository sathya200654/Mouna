package androidx.wear.compose.foundation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: CurvedContainer.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b \u0018\u00002\u00020\u0001B.\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n¢\u0006\u0002\u0010\u000bJ\r\u0010\u0016\u001a\u00020\tH\u0017¢\u0006\u0002\u0010\u0017J\f\u0010\u0018\u001a\u00020\t*\u00020\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\t*\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0016J\f\u0010\u001f\u001a\u00020\t*\u00020 H\u0016R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u00118@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000fR\u000e\u0010\u0013\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Landroidx/wear/compose/foundation/ContainerChild;", "Landroidx/wear/compose/foundation/CurvedChild;", "curvedLayoutDirection", "Landroidx/wear/compose/foundation/CurvedLayoutDirection;", "reverseLayout", "", "contentBuilder", "Lkotlin/Function1;", "Landroidx/wear/compose/foundation/CurvedScope;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/wear/compose/foundation/CurvedLayoutDirection;ZLkotlin/jvm/functions/Function1;)V", "children", "", "getChildren$compose_foundation_release", "()Ljava/util/List;", "childrenInLayoutOrder", "", "getChildrenInLayoutOrder$compose_foundation_release", "curvedContainerScope", "getReverseLayout$compose_foundation_release", "()Z", "SubComposition", "(Landroidx/compose/runtime/Composer;I)V", "draw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "initializeMeasure", "Landroidx/wear/compose/foundation/CurvedMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "placeIfNeeded", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ContainerChild extends CurvedChild {
    public static final int $stable = 8;
    private final CurvedScope curvedContainerScope;
    private final boolean reverseLayout;

    /* JADX INFO: renamed from: getReverseLayout$compose_foundation_release, reason: from getter */
    public final boolean getReverseLayout() {
        return this.reverseLayout;
    }

    public ContainerChild(CurvedLayoutDirection curvedLayoutDirection, boolean z, Function1<? super CurvedScope, Unit> function1) {
        this.reverseLayout = z;
        CurvedScope curvedScope = new CurvedScope(curvedLayoutDirection);
        function1.invoke(curvedScope);
        this.curvedContainerScope = curvedScope;
    }

    public final List<CurvedChild> getChildren$compose_foundation_release() {
        return this.curvedContainerScope.getNodes$compose_foundation_release();
    }

    public final List<CurvedChild> getChildrenInLayoutOrder$compose_foundation_release() {
        Iterable indices = CollectionsKt.getIndices(getChildren$compose_foundation_release());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(indices, 10));
        IntIterator it = indices.iterator();
        while (it.hasNext()) {
            int iNextInt = it.nextInt();
            List<CurvedChild> children$compose_foundation_release = getChildren$compose_foundation_release();
            if (this.reverseLayout) {
                iNextInt = (getChildren$compose_foundation_release().size() - 1) - iNextInt;
            }
            arrayList.add(children$compose_foundation_release.get(iNextInt));
        }
        return arrayList;
    }

    @Override // androidx.wear.compose.foundation.CurvedChild
    public void SubComposition(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1782620852);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SubComposition)*57@2038L16:CurvedContainer.kt#m5emhl");
        int i2 = (i & 6) == 0 ? (composerStartRestartGroup.changedInstance(this) ? 4 : 2) | i : i;
        if ((i2 & 3) != 2 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1782620852, i2, -1, "androidx.wear.compose.foundation.ContainerChild.SubComposition (CurvedContainer.kt:55)");
            }
            List<CurvedChild> children$compose_foundation_release = getChildren$compose_foundation_release();
            int size = children$compose_foundation_release.size();
            for (int i3 = 0; i3 < size; i3++) {
                children$compose_foundation_release.get(i3).SubComposition(composerStartRestartGroup, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.foundation.ContainerChild.SubComposition.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    ContainerChild.this.SubComposition(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @Override // androidx.wear.compose.foundation.CurvedChild
    public void initializeMeasure(CurvedMeasureScope curvedMeasureScope, Iterator<? extends Measurable> it) {
        List<CurvedChild> children$compose_foundation_release = getChildren$compose_foundation_release();
        int size = children$compose_foundation_release.size();
        for (int i = 0; i < size; i++) {
            children$compose_foundation_release.get(i).initializeMeasure(new CurvedMeasureScope(curvedMeasureScope, this.curvedContainerScope.getCurvedLayoutDirection(), curvedMeasureScope.getRadius()), it);
        }
    }

    @Override // androidx.wear.compose.foundation.CurvedChild
    public void draw(DrawScope drawScope) {
        List<CurvedChild> children$compose_foundation_release = getChildren$compose_foundation_release();
        int size = children$compose_foundation_release.size();
        for (int i = 0; i < size; i++) {
            children$compose_foundation_release.get(i).draw(drawScope);
        }
    }

    @Override // androidx.wear.compose.foundation.CurvedChild
    public void placeIfNeeded(Placeable.PlacementScope placementScope) {
        List<CurvedChild> children$compose_foundation_release = getChildren$compose_foundation_release();
        int size = children$compose_foundation_release.size();
        for (int i = 0; i < size; i++) {
            children$compose_foundation_release.get(i).placeIfNeeded(placementScope);
        }
    }
}
