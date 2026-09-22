package androidx.wear.compose.foundation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusRequester;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: HierarchicalFocusCoordinator.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aM\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u001d\u0010\n\u001a\u0019\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0002\b\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\u000fH\u0001¢\u0006\u0002\u0010\u0010\u001a.\u0010\u0011\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0002\u0010\u0013\u001a,\u0010\u0014\u001a\u00020\u00062\u001d\u0010\n\u001a\u0019\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u0015\u001a\u0015\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\r\u0010\u001a\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u001b\"\u001c\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u001c²\u0006\u0010\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u008a\u0084\u0002²\u0006\f\u0010\u001e\u001a\u0004\u0018\u00010\u0002X\u008a\u0084\u0002"}, d2 = {"LocalFocusNodeParent", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/wear/compose/foundation/FocusNode;", "getLocalFocusNodeParent", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "FocusComposableImpl", "", "focusEnabled", "Lkotlin/Function0;", "", "onFocusChanged", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/ExtensionFunctionType;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "HierarchicalFocusCoordinator", "requiresFocus", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "OnFocusChange", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "RequestFocusWhenActive", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "(Landroidx/compose/ui/focus/FocusRequester;Landroidx/compose/runtime/Composer;I)V", "rememberActiveFocusRequester", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/focus/FocusRequester;", "compose-foundation_release", "updatedFocusEnabled", "parent"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class HierarchicalFocusCoordinatorKt {
    private static final ProvidableCompositionLocal<FocusNode> LocalFocusNodeParent = CompositionLocalKt.compositionLocalOf$default((SnapshotMutationPolicy) null, new Function0<FocusNode>() { // from class: androidx.wear.compose.foundation.HierarchicalFocusCoordinatorKt$LocalFocusNodeParent$1
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final FocusNode m375invoke() {
            return null;
        }
    }, 1, (Object) null);

    public static final void HierarchicalFocusCoordinator(final Function0<Boolean> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1784564595);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HierarchicalFocusCoordinator)P(1)61@2788L7,64@2869L37,62@2800L139:HierarchicalFocusCoordinator.kt#m5emhl");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1784564595, i2, -1, "androidx.wear.compose.foundation.HierarchicalFocusCoordinator (HierarchicalFocusCoordinator.kt:60)");
            }
            CompositionLocal localFocusManager = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFocusManager();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localFocusManager);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final FocusManager focusManager = (FocusManager) objConsume;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 110440891, "CC(remember):HierarchicalFocusCoordinator.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(focusManager);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = (Function2) new Function2<CoroutineScope, Boolean, Unit>() { // from class: androidx.wear.compose.foundation.HierarchicalFocusCoordinatorKt$HierarchicalFocusCoordinator$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((CoroutineScope) obj, ((Boolean) obj2).booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(CoroutineScope coroutineScope, boolean z) {
                        if (z) {
                            FocusManager.clearFocus$default(focusManager, false, 1, (Object) null);
                        }
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            FocusComposableImpl(function0, (Function2) objRememberedValue, function2, composerStartRestartGroup, (i2 & 14) | ((i2 << 3) & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.foundation.HierarchicalFocusCoordinatorKt.HierarchicalFocusCoordinator.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    HierarchicalFocusCoordinatorKt.HierarchicalFocusCoordinator(function0, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void OnFocusChange(final Function2<? super CoroutineScope, ? super Boolean, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2118828981);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OnFocusChange)79@3367L121:HierarchicalFocusCoordinator.kt#m5emhl");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2118828981, i2, -1, "androidx.wear.compose.foundation.OnFocusChange (HierarchicalFocusCoordinator.kt:78)");
            }
            FocusComposableImpl(new Function0<Boolean>() { // from class: androidx.wear.compose.foundation.HierarchicalFocusCoordinatorKt.OnFocusChange.1
                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Boolean m376invoke() {
                    return true;
                }
            }, function2, ComposableSingletons$HierarchicalFocusCoordinatorKt.INSTANCE.m247getLambda1$compose_foundation_release(), composerStartRestartGroup, ((i2 << 3) & 112) | 390);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.foundation.HierarchicalFocusCoordinatorKt.OnFocusChange.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    HierarchicalFocusCoordinatorKt.OnFocusChange(function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void RequestFocusWhenActive(final FocusRequester focusRequester, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2112725629);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RequestFocusWhenActive)97@4036L53,97@4022L67:HierarchicalFocusCoordinator.kt#m5emhl");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(focusRequester) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2112725629, i2, -1, "androidx.wear.compose.foundation.RequestFocusWhenActive (HierarchicalFocusCoordinator.kt:96)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2128805843, "CC(remember):HierarchicalFocusCoordinator.kt#9igjgp");
            boolean z = (i2 & 14) == 4;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = (Function2) new Function2<CoroutineScope, Boolean, Unit>() { // from class: androidx.wear.compose.foundation.HierarchicalFocusCoordinatorKt$RequestFocusWhenActive$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((CoroutineScope) obj, ((Boolean) obj2).booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(CoroutineScope coroutineScope, boolean z2) {
                        if (z2) {
                            focusRequester.requestFocus();
                        }
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            OnFocusChange((Function2) objRememberedValue, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.foundation.HierarchicalFocusCoordinatorKt.RequestFocusWhenActive.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    HierarchicalFocusCoordinatorKt.RequestFocusWhenActive(focusRequester, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final FocusRequester rememberActiveFocusRequester(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -378722091, "C(rememberActiveFocusRequester):HierarchicalFocusCoordinator.kt#m5emhl");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-378722091, i, -1, "androidx.wear.compose.foundation.rememberActiveFocusRequester (HierarchicalFocusCoordinator.kt:113)");
        }
        composer.startReplaceGroup(-1797288881);
        ComposerKt.sourceInformation(composer, "*113@4669L29,113@4706L26");
        ComposerKt.sourceInformationMarkerStart(composer, -1797289847, "CC(remember):HierarchicalFocusCoordinator.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new FocusRequester();
            composer.updateRememberedValue(objRememberedValue);
        }
        FocusRequester focusRequester = (FocusRequester) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        RequestFocusWhenActive(focusRequester, composer, 0);
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return focusRequester;
    }

    public static final void FocusComposableImpl(final Function0<Boolean> function0, final Function2<? super CoroutineScope, ? super Boolean, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1975773111);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FocusComposableImpl)P(1,2)129@5393L34,130@5488L7,130@5446L50,133@5588L122,148@5977L79,151@6173L103,151@6138L138:HierarchicalFocusCoordinator.kt#m5emhl");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1975773111, i2, -1, "androidx.wear.compose.foundation.FocusComposableImpl (HierarchicalFocusCoordinator.kt:128)");
            }
            final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function0, composerStartRestartGroup, i2 & 14);
            CompositionLocal compositionLocal = LocalFocusNodeParent;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(compositionLocal);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final State stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(objConsume, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -640652406, "CC(remember):HierarchicalFocusCoordinator.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new FocusNode(SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: androidx.wear.compose.foundation.HierarchicalFocusCoordinatorKt$FocusComposableImpl$node$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final Boolean m374invoke() {
                        State<Boolean> focused;
                        FocusNode focusNodeFocusComposableImpl$lambda$5 = HierarchicalFocusCoordinatorKt.FocusComposableImpl$lambda$5(stateRememberUpdatedState2);
                        return Boolean.valueOf(((focusNodeFocusComposableImpl$lambda$5 == null || (focused = focusNodeFocusComposableImpl$lambda$5.getFocused()) == null) ? true : ((Boolean) focused.getValue()).booleanValue()) && ((Boolean) HierarchicalFocusCoordinatorKt.FocusComposableImpl$lambda$4(stateRememberUpdatedState).invoke()).booleanValue());
                    }
                }), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final FocusNode focusNode = (FocusNode) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final FocusNode focusNodeFocusComposableImpl$lambda$5 = FocusComposableImpl$lambda$5(stateRememberUpdatedState2);
            composerStartRestartGroup.startReplaceGroup(-640645418);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*139@5840L125,139@5819L146");
            if (focusNodeFocusComposableImpl$lambda$5 != null) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 845509900, "CC(remember):HierarchicalFocusCoordinator.kt#9igjgp");
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(focusNodeFocusComposableImpl$lambda$5) | composerStartRestartGroup.changedInstance(focusNode);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.wear.compose.foundation.HierarchicalFocusCoordinatorKt$FocusComposableImpl$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                            focusNodeFocusComposableImpl$lambda$5.getChildren().add(focusNode);
                            final FocusNode focusNode2 = focusNodeFocusComposableImpl$lambda$5;
                            final FocusNode focusNode3 = focusNode;
                            return new DisposableEffectResult() { // from class: androidx.wear.compose.foundation.HierarchicalFocusCoordinatorKt$FocusComposableImpl$1$1$1$invoke$$inlined$onDispose$1
                                public void dispose() {
                                    focusNode2.getChildren().remove(focusNode3);
                                }
                            };
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.DisposableEffect(focusNodeFocusComposableImpl$lambda$5, (Function1) objRememberedValue2, composerStartRestartGroup, 0);
                Unit unit = Unit.INSTANCE;
            }
            composerStartRestartGroup.endReplaceGroup();
            CompositionLocalKt.CompositionLocalProvider(compositionLocal.provides(focusNode), function3, composerStartRestartGroup, ProvidedValue.$stable | ((i2 >> 3) & 112));
            Object value = focusNode.getFocused().getValue();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -640633705, "CC(remember):HierarchicalFocusCoordinator.kt#9igjgp");
            boolean zChangedInstance2 = ((i2 & 112) == 32) | composerStartRestartGroup.changedInstance(focusNode);
            HierarchicalFocusCoordinatorKt$FocusComposableImpl$2$1 hierarchicalFocusCoordinatorKt$FocusComposableImpl$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || hierarchicalFocusCoordinatorKt$FocusComposableImpl$2$1RememberedValue == Composer.Companion.getEmpty()) {
                hierarchicalFocusCoordinatorKt$FocusComposableImpl$2$1RememberedValue = new HierarchicalFocusCoordinatorKt$FocusComposableImpl$2$1(focusNode, function2, null);
                composerStartRestartGroup.updateRememberedValue(hierarchicalFocusCoordinatorKt$FocusComposableImpl$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(value, (Function2) hierarchicalFocusCoordinatorKt$FocusComposableImpl$2$1RememberedValue, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.foundation.HierarchicalFocusCoordinatorKt.FocusComposableImpl.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    HierarchicalFocusCoordinatorKt.FocusComposableImpl(function0, function2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final ProvidableCompositionLocal<FocusNode> getLocalFocusNodeParent() {
        return LocalFocusNodeParent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function0<Boolean> FocusComposableImpl$lambda$4(State<? extends Function0<Boolean>> state) {
        return (Function0) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FocusNode FocusComposableImpl$lambda$5(State<FocusNode> state) {
        return (FocusNode) state.getValue();
    }
}
