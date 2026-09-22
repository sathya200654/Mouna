package androidx.wear.compose.foundation;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.util.MathHelpersKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CurvedComposable.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001c\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n¢\u0006\u0002\b\u000b¢\u0006\u0002\u0010\fJ\r\u0010\u001d\u001a\u00020\tH\u0017¢\u0006\u0002\u0010\u001eJ$\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130 2\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u0013H\u0002J*\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010%\u001a\u00020&H\u0016ø\u0001\u0000¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u0013H\u0016J\u0018\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00132\u0006\u0010.\u001a\u00020\u0013H\u0016J\u001a\u0010/\u001a\u00020\t*\u0002002\f\u00101\u001a\b\u0012\u0004\u0012\u00020302H\u0016J\f\u00104\u001a\u00020\t*\u000205H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR)\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n¢\u0006\u0002\b\u000b¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00066"}, d2 = {"Landroidx/wear/compose/foundation/CurvedComposableChild;", "Landroidx/wear/compose/foundation/CurvedChild;", "clockwise", "", "radialAlignment", "Landroidx/wear/compose/foundation/CurvedAlignment$Radial;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZFLkotlin/jvm/functions/Function3;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getClockwise", "()Z", "getContent", "()Lkotlin/jvm/functions/Function3;", "Lkotlin/jvm/functions/Function3;", "parentSweepRadians", "", "placeable", "Landroidx/compose/ui/layout/Placeable;", "getPlaceable", "()Landroidx/compose/ui/layout/Placeable;", "setPlaceable", "(Landroidx/compose/ui/layout/Placeable;)V", "getRadialAlignment-BjYtHoc", "()F", "F", "SubComposition", "(Landroidx/compose/runtime/Composer;I)V", "computeAnnulusRadii", "Lkotlin/Pair;", "targetRadius", "radiusAlpha", "doAngularPosition", "parentStartAngleRadians", "centerOffset", "Landroidx/compose/ui/geometry/Offset;", "doAngularPosition-0AR0LA0", "(FFJ)F", "doEstimateThickness", "maxRadius", "doRadialPosition", "Landroidx/wear/compose/foundation/PartialLayoutInfo;", "parentOuterRadius", "parentThickness", "initializeMeasure", "Landroidx/wear/compose/foundation/CurvedMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "placeIfNeeded", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CurvedComposableChild extends CurvedChild {
    public static final int $stable = 8;
    private final boolean clockwise;
    private final Function3<BoxScope, Composer, Integer, Unit> content;
    private float parentSweepRadians;
    public Placeable placeable;
    private final float radialAlignment;

    public /* synthetic */ CurvedComposableChild(boolean z, float f, Function3 function3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, f, function3);
    }

    public final boolean getClockwise() {
        return this.clockwise;
    }

    /* JADX INFO: renamed from: getRadialAlignment-BjYtHoc, reason: not valid java name and from getter */
    public final float getRadialAlignment() {
        return this.radialAlignment;
    }

    public final Function3<BoxScope, Composer, Integer, Unit> getContent() {
        return this.content;
    }

    private CurvedComposableChild(boolean z, float f, Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function3) {
        this.clockwise = z;
        this.radialAlignment = f;
        this.content = function3;
    }

    public final Placeable getPlaceable() {
        Placeable placeable = this.placeable;
        if (placeable != null) {
            return placeable;
        }
        Intrinsics.throwUninitializedPropertyAccessException("placeable");
        return null;
    }

    public final void setPlaceable(Placeable placeable) {
        this.placeable = placeable;
    }

    @Override // androidx.wear.compose.foundation.CurvedChild
    public void SubComposition(Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(225286045);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SubComposition)62@2328L22:CurvedComposable.kt#m5emhl");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(this) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(225286045, i2, -1, "androidx.wear.compose.foundation.CurvedComposableChild.SubComposition (CurvedComposable.kt:60)");
            }
            Function3<BoxScope, Composer, Integer, Unit> function3 = this.content;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Modifier modifier = Modifier.Companion;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composer2 = Updater.constructor-impl(composerStartRestartGroup);
            Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            function3.invoke(BoxScopeInstance.INSTANCE, composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.foundation.CurvedComposableChild.SubComposition.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i3) {
                    CurvedComposableChild.this.SubComposition(composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @Override // androidx.wear.compose.foundation.CurvedChild
    public void initializeMeasure(CurvedMeasureScope curvedMeasureScope, Iterator<? extends Measurable> it) {
        setPlaceable(it.next().measure-BRTryo0(ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, (Object) null)));
    }

    @Override // androidx.wear.compose.foundation.CurvedChild
    public float doEstimateThickness(float maxRadius) {
        Pair<Float, Float> pairComputeAnnulusRadii = computeAnnulusRadii(maxRadius, 0.0f);
        return ((Number) pairComputeAnnulusRadii.component2()).floatValue() - ((Number) pairComputeAnnulusRadii.component1()).floatValue();
    }

    @Override // androidx.wear.compose.foundation.CurvedChild
    public PartialLayoutInfo doRadialPosition(float parentOuterRadius, float parentThickness) {
        Pair<Float, Float> pairComputeAnnulusRadii = computeAnnulusRadii(MathHelpersKt.lerp(parentOuterRadius, parentOuterRadius - parentThickness, this.radialAlignment), this.radialAlignment);
        float fFloatValue = ((Number) pairComputeAnnulusRadii.component1()).floatValue();
        float fFloatValue2 = ((Number) pairComputeAnnulusRadii.component2()).floatValue();
        return new PartialLayoutInfo(((float) Math.asin((getPlaceable().getWidth() / 2.0f) / fFloatValue)) * 2.0f, fFloatValue2, fFloatValue2 - fFloatValue, (fFloatValue + fFloatValue2) / 2);
    }

    @Override // androidx.wear.compose.foundation.CurvedChild
    /* JADX INFO: renamed from: doAngularPosition-0AR0LA0 */
    public float mo234doAngularPosition0AR0LA0(float parentStartAngleRadians, float parentSweepRadians, long centerOffset) {
        this.parentSweepRadians = parentSweepRadians;
        return parentStartAngleRadians;
    }

    @Override // androidx.wear.compose.foundation.CurvedChild
    public void placeIfNeeded(Placeable.PlacementScope placementScope) {
        Placeable placeable = getPlaceable();
        CurvedLayoutInfo layoutInfo$compose_foundation_release = getLayoutInfo$compose_foundation_release();
        Intrinsics.checkNotNull(layoutInfo$compose_foundation_release);
        CurvedComposableKt.place(placementScope, placeable, layoutInfo$compose_foundation_release, this.parentSweepRadians, this.clockwise);
    }

    private final Pair<Float, Float> computeAnnulusRadii(float targetRadius, float radiusAlpha) {
        float fPow2 = CurvedComposableKt.pow2(getPlaceable().getWidth() / 2.0f);
        float fSqrt = (float) Math.sqrt(CurvedComposableKt.pow2(targetRadius) - fPow2);
        return TuplesKt.to(Float.valueOf((float) Math.sqrt(fPow2 + CurvedComposableKt.pow2(fSqrt - ((1 - radiusAlpha) * getPlaceable().getHeight())))), Float.valueOf((float) Math.sqrt(CurvedComposableKt.pow2((getPlaceable().getHeight() * radiusAlpha) + fSqrt) + fPow2)));
    }
}
