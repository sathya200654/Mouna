package androidx.wear.compose.materialcore;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import io.grpc.internal.GrpcUtil;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;

/* JADX INFO: compiled from: Stepper.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001aÄ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\n2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0010\u0010\u0012\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u00132\u0010\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u001c\u0010\u0018\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\n¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001ad\u0010\u001d\u001a\u00020\u0001*\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0010\u0010&\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u00132\u0006\u0010'\u001a\u00020\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0003¢\u0006\u0002\u0010(\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006)"}, d2 = {"Stepper", "", "value", "", "onValueChange", "Lkotlin/Function1;", "steps", "", "decreaseIcon", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "increaseIcon", "modifier", "Landroidx/compose/ui/Modifier;", "valueRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "enabledButtonProviderValues", "", "Landroidx/compose/runtime/ProvidedValue;", "disabledButtonProviderValues", "buttonRipple", "Landroidx/compose/foundation/Indication;", "content", "Landroidx/compose/foundation/layout/BoxScope;", "Lkotlin/ExtensionFunctionType;", "Stepper-SPO2TK8", "(FLkotlin/jvm/functions/Function1;ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/ranges/ClosedFloatingPointRange;J[Landroidx/compose/runtime/ProvidedValue;[Landroidx/compose/runtime/ProvidedValue;Landroidx/compose/foundation/Indication;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "FullScreenButton", "Landroidx/compose/foundation/layout/ColumnScope;", "onClick", "contentAlignment", "Landroidx/compose/ui/Alignment;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "enabled", "", "buttonProviderValues", "ripple", "(Landroidx/compose/foundation/layout/ColumnScope;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Alignment;Landroidx/compose/foundation/layout/PaddingValues;Z[Landroidx/compose/runtime/ProvidedValue;Landroidx/compose/foundation/Indication;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "compose-material-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class StepperKt {
    /* JADX INFO: renamed from: Stepper-SPO2TK8, reason: not valid java name */
    public static final void m934StepperSPO2TK8(final float f, final Function1<? super Float, Unit> function1, final int i, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, final Modifier modifier, final ClosedFloatingPointRange<Float> closedFloatingPointRange, final long j, final ProvidedValue<?>[] providedValueArr, final ProvidedValue<?>[] providedValueArr2, final Indication indication, final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i2, final int i3) {
        int i4;
        int i5;
        final int i6;
        Object obj;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(466509428);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Stepper)P(10,8,9,3,6,7,11,0:c#ui.graphics.Color,5,4)93@4738L128,99@4905L192,105@5103L1497:Stepper.kt#f7tims");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(i) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function2) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        if ((i2 & 24576) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function3) ? 16384 : 8192;
        }
        if ((i2 & 196608) == 0) {
            i4 |= composerStartRestartGroup.changed(modifier) ? 131072 : ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
        }
        if ((i2 & 1572864) == 0) {
            i4 |= composerStartRestartGroup.changed(closedFloatingPointRange) ? 1048576 : 524288;
        }
        if ((i2 & 12582912) == 0) {
            i4 |= composerStartRestartGroup.changed(j) ? 8388608 : GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
        }
        if ((i2 & 100663296) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(providedValueArr) ? 67108864 : 33554432;
        }
        if ((i2 & 805306368) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(providedValueArr2) ? 536870912 : 268435456;
        }
        if ((i3 & 6) == 0) {
            i5 = i3 | (composerStartRestartGroup.changed(indication) ? 4 : 2);
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(function4) ? 32 : 16;
        }
        int i7 = i5;
        if ((i4 & 306783379) != 306783378 || (i7 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(466509428, i4, i7, "androidx.wear.compose.materialcore.Stepper (Stepper.kt:91)");
            }
            if (i < 0) {
                throw new IllegalArgumentException("steps should be >= 0".toString());
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1267000017, "CC(remember):Stepper.kt#9igjgp");
            int i8 = i4 & 14;
            int i9 = i4 & 3670016;
            int i10 = i4 & 896;
            int i11 = i4;
            boolean z = (i8 == 4) | (i9 == 1048576) | (i10 == 256);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = Integer.valueOf(RangeDefaults.INSTANCE.snapValueToStep(f, closedFloatingPointRange, i));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            int iIntValue = ((Number) objRememberedValue).intValue();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1266994609, "CC(remember):Stepper.kt#9igjgp");
            boolean zChanged = (i9 == 1048576) | (i10 == 256) | composerStartRestartGroup.changed(iIntValue) | (i8 == 4) | ((i11 & 112) == 32);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                i6 = iIntValue;
                obj = (Function1) new Function1<Integer, Unit>() { // from class: androidx.wear.compose.materialcore.StepperKt$Stepper$updateValue$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke(((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i12) {
                        float fCalculateCurrentStepValue = RangeDefaults.INSTANCE.calculateCurrentStepValue(i6 + i12, i, closedFloatingPointRange);
                        if (fCalculateCurrentStepValue == f) {
                            return;
                        }
                        function1.invoke(Float.valueOf(fCalculateCurrentStepValue));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(obj);
            } else {
                obj = objRememberedValue2;
                i6 = iIntValue;
            }
            final Function1 function5 = (Function1) obj;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifier2 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(modifier, 0.0f, 1, (Object) null), j, (Shape) null, 2, (Object) null);
            Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(vertical, Alignment.Companion.getStart(), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
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
            Composer composer3 = Updater.constructor-impl(composerStartRestartGroup);
            Updater.set-impl(composer3, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer3.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.set-impl(composer3, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384862393, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1374465204, "C116@5462L18,115@5422L453,125@5884L213,134@6174L19,133@6134L460:Stepper.kt#f7tims");
            boolean z2 = i6 < i + 1;
            boolean z3 = i6 > 0;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -94205248, "CC(remember):Stepper.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(function5);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                objRememberedValue3 = (Function0) new Function0<Unit>() { // from class: androidx.wear.compose.materialcore.StepperKt$Stepper$2$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m935invoke();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m935invoke() {
                        function5.invoke(1);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Function0 function0 = (Function0) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i12 = ((r21 << 18) & 3670016) | 3462;
            FullScreenButton(columnScope, function0, Alignment.Companion.getTopCenter(), PaddingKt.PaddingValues-a9UjIt4$default(0.0f, StepperDefaults.INSTANCE.m933getBorderPaddingD9Ej5fM(), 0.0f, 0.0f, 13, (Object) null), z2, z2 ? providedValueArr : providedValueArr2, indication, function3, composerStartRestartGroup, i12 | ((i11 << 9) & 29360128));
            Modifier modifierWeight$default = ColumnScope.weight$default(columnScope, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.3f, false, 2, (Object) null);
            Alignment center = Alignment.Companion.getCenter();
            int i13 = ((i7 << 6) & 7168) | 48;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default);
            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composer4 = Updater.constructor-impl(composerStartRestartGroup);
            Updater.set-impl(composer4, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer4, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer4.getInserting() || !Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composer4.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.set-impl(composer4, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            function4.invoke(BoxScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i13 >> 6) & 112) | 6));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -94182463, "CC(remember):Stepper.kt#9igjgp");
            boolean zChanged3 = composerStartRestartGroup.changed(function5);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChanged3 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                objRememberedValue4 = (Function0) new Function0<Unit>() { // from class: androidx.wear.compose.materialcore.StepperKt$Stepper$2$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m936invoke();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m936invoke() {
                        function5.invoke(-1);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            Function0 function6 = (Function0) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i14 = i12 | ((i11 << 12) & 29360128);
            composer2 = composerStartRestartGroup;
            FullScreenButton(columnScope, function6, Alignment.Companion.getBottomCenter(), PaddingKt.PaddingValues-a9UjIt4$default(0.0f, 0.0f, 0.0f, StepperDefaults.INSTANCE.m933getBorderPaddingD9Ej5fM(), 7, (Object) null), z3, z3 ? providedValueArr : providedValueArr2, indication, function2, composer2, i14);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.materialcore.StepperKt$Stepper$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke((Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer5, int i15) {
                    StepperKt.m934StepperSPO2TK8(f, function1, i, function2, function3, modifier, closedFloatingPointRange, j, providedValueArr, providedValueArr2, indication, function4, composer5, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void FullScreenButton(final ColumnScope columnScope, final Function0<Unit> function0, final Alignment alignment, final PaddingValues paddingValues, final boolean z, final ProvidedValue<?>[] providedValueArr, final Indication indication, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Function0<Unit> function1;
        Composer composerStartRestartGroup = composer.startRestartGroup(48663817);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FullScreenButton)P(4,2,5,3!1,6)156@6915L39,157@6959L601:Stepper.kt#f7tims");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(columnScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            function1 = function0;
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        } else {
            function1 = function0;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(alignment) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(paddingValues) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(providedValueArr) ? 131072 : ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(indication) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 8388608 : GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
        }
        if ((4793491 & i2) != 4793490 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(48663817, i2, -1, "androidx.wear.compose.materialcore.FullScreenButton (Stepper.kt:155)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2137102314, "CC(remember):Stepper.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            InteractionSource interactionSource = (MutableInteractionSource) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Function0<Unit> function3 = function1;
            Modifier modifierPadding = PaddingKt.padding(IndicationKt.indication(SizeKt.wrapContentWidth$default(RepeatableClickableKt.m912repeatableClickableXVZzFYc(ColumnScope.weight$default(columnScope, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.35f, false, 2, (Object) null), interactionSource, null, (376 & 4) != 0 ? true : z, (376 & 8) != 0 ? null : null, (376 & 16) != 0 ? null : null, (376 & 32) != 0 ? 500L : 0L, (376 & 64) != 0 ? 60L : 0L, function3, (376 & 256) != 0 ? function3 : null), (Alignment.Horizontal) null, false, 3, (Object) null), interactionSource, indication), paddingValues);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(alignment, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPadding);
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
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 643556885, "C172@7458L96:Stepper.kt#f7tims");
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue[]) Arrays.copyOf(providedValueArr, providedValueArr.length), function2, composerStartRestartGroup, ((i2 >> 18) & 112) | ProvidedValue.$stable);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.materialcore.StepperKt.FullScreenButton.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i3) {
                    StepperKt.FullScreenButton(columnScope, function0, alignment, paddingValues, z, providedValueArr, indication, function2, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
