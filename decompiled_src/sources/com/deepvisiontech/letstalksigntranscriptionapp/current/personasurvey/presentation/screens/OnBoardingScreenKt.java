package com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens;

import android.content.Context;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.pager.PageSize;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.paging.HorizontalPageProgressIndicatorKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.model.Persona;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.viewmodels.OnBoardingPages;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.viewmodels.OnBoardingUiEvent;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.viewmodels.OnBoardingUiState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.viewmodels.OnBoardingViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.SharedFlow;

/* JADX INFO: compiled from: OnBoardingScreen.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a/\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\t²\u0006\n\u0010\n\u001a\u00020\u000bX\u008a\u0084\u0002"}, d2 = {"OnBoardingScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "onBoardingViewModel", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/presentation/viewmodels/OnBoardingViewModel;", "onNavigateToMain", "Lkotlin/Function0;", "(Landroidx/compose/ui/Modifier;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/presentation/viewmodels/OnBoardingViewModel;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_release", "uiState", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/presentation/viewmodels/OnBoardingUiState;"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class OnBoardingScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnBoardingScreen$lambda$22(Modifier modifier, OnBoardingViewModel onBoardingViewModel, Function0 function0, int i, int i2, Composer composer, int i3) {
        OnBoardingScreen(modifier, onBoardingViewModel, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void OnBoardingScreen(Modifier modifier, OnBoardingViewModel onBoardingViewModel, final Function0<Unit> function0, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        OnBoardingViewModel onBoardingViewModel2;
        final Modifier modifier3;
        final OnBoardingViewModel onBoardingViewModel3;
        int i4;
        Modifier modifier4;
        final OnBoardingViewModel onBoardingViewModel4;
        CreationExtras defaultViewModelCreationExtras;
        Intrinsics.checkNotNullParameter(function0, "onNavigateToMain");
        Composer composerStartRestartGroup = composer.startRestartGroup(-711193631);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OnBoardingScreen)36@1704L16,37@1773L22,37@1742L54,38@1822L24,39@1875L32,42@1986L7,44@2023L172,44@1999L196,52@2236L147,52@2201L182,60@2460L3502,58@2389L3579:OnBoardingScreen.kt#j5zu2x");
        int i5 = i2 & 1;
        if (i5 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                onBoardingViewModel2 = onBoardingViewModel;
                int i6 = composerStartRestartGroup.changedInstance(onBoardingViewModel2) ? 32 : 16;
                i3 |= i6;
            } else {
                onBoardingViewModel2 = onBoardingViewModel;
            }
            i3 |= i6;
        } else {
            onBoardingViewModel2 = onBoardingViewModel;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "32@1602L15");
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
                modifier4 = modifier2;
                onBoardingViewModel4 = onBoardingViewModel2;
                i4 = 1;
            } else {
                Modifier modifier5 = i5 != 0 ? (Modifier) Modifier.Companion : modifier2;
                if ((i2 & 2) != 0) {
                    composerStartRestartGroup.startReplaceableGroup(1890788296);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
                    HasDefaultViewModelProviderFactory current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, LocalViewModelStoreOwner.$stable);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                    }
                    ViewModelProvider.Factory factoryCreateHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(1729797275);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        defaultViewModelCreationExtras = current.getDefaultViewModelCreationExtras();
                    } else {
                        defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    i4 = 1;
                    ViewModel viewModel = ViewModelKt.viewModel(OnBoardingViewModel.class, current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 36936, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    onBoardingViewModel2 = (OnBoardingViewModel) viewModel;
                    i3 &= -113;
                } else {
                    i4 = 1;
                }
                modifier4 = modifier5;
                onBoardingViewModel4 = onBoardingViewModel2;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-711193631, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.OnBoardingScreen (OnBoardingScreen.kt:34)");
            }
            final State stateCollectAsState = SnapshotStateKt.collectAsState(onBoardingViewModel4.getUiState(), (CoroutineContext) null, composerStartRestartGroup, 0, i4);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -557270121, "CC(remember):OnBoardingScreen.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(stateCollectAsState);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.OnBoardingScreenKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        return Integer.valueOf(OnBoardingScreenKt.OnBoardingScreen$lambda$2$lambda$1(stateCollectAsState));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final PagerState pagerStateRememberPagerState = PagerStateKt.rememberPagerState(0, 0.0f, (Function0) objRememberedValue, composerStartRestartGroup, 0, 3);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -557266847, "CC(remember):OnBoardingScreen.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.Companion.getEmpty()) {
                objRememberedValue3 = new SnackbarHostState();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            SnackbarHostState snackbarHostState = (SnackbarHostState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SharedFlow<OnBoardingUiEvent> uiEvent = onBoardingViewModel4.getUiEvent();
            CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Context context = (Context) objConsume;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -557261971, "CC(remember):OnBoardingScreen.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(uiEvent) | composerStartRestartGroup.changedInstance(context);
            OnBoardingScreenKt$OnBoardingScreen$1$1 onBoardingScreenKt$OnBoardingScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || onBoardingScreenKt$OnBoardingScreen$1$1RememberedValue == Composer.Companion.getEmpty()) {
                onBoardingScreenKt$OnBoardingScreen$1$1RememberedValue = new OnBoardingScreenKt$OnBoardingScreen$1$1(uiEvent, snackbarHostState, context, null);
                composerStartRestartGroup.updateRememberedValue(onBoardingScreenKt$OnBoardingScreen$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(uiEvent, (Function2) onBoardingScreenKt$OnBoardingScreen$1$1RememberedValue, composerStartRestartGroup, 0);
            Integer numValueOf = Integer.valueOf(OnBoardingScreen$lambda$0(stateCollectAsState).getPages().size());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -557255180, "CC(remember):OnBoardingScreen.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(stateCollectAsState) | composerStartRestartGroup.changed(pagerStateRememberPagerState);
            OnBoardingScreenKt$OnBoardingScreen$2$1 onBoardingScreenKt$OnBoardingScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || onBoardingScreenKt$OnBoardingScreen$2$1RememberedValue == Composer.Companion.getEmpty()) {
                onBoardingScreenKt$OnBoardingScreen$2$1RememberedValue = new OnBoardingScreenKt$OnBoardingScreen$2$1(pagerStateRememberPagerState, stateCollectAsState, null);
                composerStartRestartGroup.updateRememberedValue(onBoardingScreenKt$OnBoardingScreen$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(numValueOf, (Function2) onBoardingScreenKt$OnBoardingScreen$2$1RememberedValue, composerStartRestartGroup, 0);
            Composer composer2 = composerStartRestartGroup;
            modifier3 = modifier4;
            ScaffoldKt.Scaffold-TvnljyQ(SizeKt.fillMaxSize$default(modifier4, 0.0f, i4, (Object) null), (Function2) null, (Function2) null, (Function2) null, (Function2) null, 0, 0L, 0L, (WindowInsets) null, ComposableLambdaKt.rememberComposableLambda(-1977498766, i4, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.OnBoardingScreenKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return OnBoardingScreenKt.OnBoardingScreen$lambda$21(pagerStateRememberPagerState, coroutineScope, onBoardingViewModel4, function0, stateCollectAsState, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, 805306368, 510);
            composerStartRestartGroup = composer2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            onBoardingViewModel3 = onBoardingViewModel4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            onBoardingViewModel3 = onBoardingViewModel2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.OnBoardingScreenKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    return OnBoardingScreenKt.OnBoardingScreen$lambda$22(modifier3, onBoardingViewModel3, function0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int OnBoardingScreen$lambda$2$lambda$1(State state) {
        return OnBoardingScreen$lambda$0(state).getPages().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnBoardingScreen$lambda$21(final PagerState pagerState, final CoroutineScope coroutineScope, final OnBoardingViewModel onBoardingViewModel, final Function0 function0, final State state, PaddingValues paddingValues, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer, "C63@2573L3379,61@2491L3461:OnBoardingScreen.kt#j5zu2x");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(paddingValues) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1977498766, i2, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.OnBoardingScreen.<anonymous> (OnBoardingScreen.kt:61)");
            }
            SurfaceKt.Surface-T9BRK9s(PaddingKt.padding(Modifier.Companion, paddingValues), (Shape) null, 0L, 0L, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(1304381005, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.OnBoardingScreenKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    return OnBoardingScreenKt.OnBoardingScreen$lambda$21$lambda$20(pagerState, coroutineScope, onBoardingViewModel, function0, state, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 12582912, 126);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnBoardingScreen$lambda$21$lambda$20(PagerState pagerState, final CoroutineScope coroutineScope, final OnBoardingViewModel onBoardingViewModel, final Function0 function0, final State state, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C64@2591L3347:OnBoardingScreen.kt#j5zu2x");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1304381005, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.OnBoardingScreen.<anonymous>.<anonymous> (OnBoardingScreen.kt:64)");
            }
            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
            Arrangement.Vertical center = Arrangement.INSTANCE.getCenter();
            Modifier modifier = PaddingKt.padding-3ABfNKs(SizeKt.fillMaxSize$default(ZIndexModifierKt.zIndex(Modifier.Companion, 2.0f), 0.0f, 1, (Object) null), Dp.constructor-impl(4));
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifier);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composer2 = Updater.constructor-impl(composer);
            Updater.set-impl(composer2, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            final ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 356036155, "C75@3057L2720,72@2927L2850:OnBoardingScreen.kt#j5zu2x");
            PagerKt.HorizontalPager--8jOkeI(pagerState, ColumnScope.weight$default(columnScope, Modifier.Companion, 1.0f, false, 2, (Object) null), (PaddingValues) null, (PageSize) null, 0, 0.0f, (Alignment.Vertical) null, (TargetedFlingBehavior) null, false, false, (Function1) null, (NestedScrollConnection) null, (SnapPosition) null, (OverscrollEffect) null, ComposableLambdaKt.rememberComposableLambda(-1339585034, true, new Function4() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.OnBoardingScreenKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return OnBoardingScreenKt.OnBoardingScreen$lambda$21$lambda$20$lambda$19$lambda$18(coroutineScope, onBoardingViewModel, function0, columnScope, state, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composer, 54), composer, 0, 24576, 16380);
            if (pagerState.getPageCount() <= 1) {
                composer.startReplaceGroup(353038795);
            } else {
                composer.startReplaceGroup(358824976);
                ComposerKt.sourceInformation(composer, "132@5855L43");
                HorizontalPageProgressIndicatorKt.m1430HorizontalPageProgressIndicatoreaDK9VM(pagerState, null, 0L, 0L, composer, 0, 14);
            }
            composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit OnBoardingScreen$lambda$21$lambda$20$lambda$19$lambda$18(final CoroutineScope coroutineScope, final OnBoardingViewModel onBoardingViewModel, final Function0 function0, ColumnScope columnScope, State state, PagerScope pagerScope, final int i, Composer composer, int i2) throws NoWhenBranchMatchedException {
        Intrinsics.checkNotNullParameter(pagerScope, "$this$HorizontalPager");
        ComposerKt.sourceInformation(composer, "C:OnBoardingScreen.kt#j5zu2x");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1339585034, i2, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.OnBoardingScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OnBoardingScreen.kt:76)");
        }
        final OnBoardingPages onBoardingPages = OnBoardingScreen$lambda$0(state).getPages().get(i);
        if (onBoardingPages instanceof OnBoardingPages.ConsentPage) {
            composer.startReplaceGroup(1258533196);
            ComposerKt.sourceInformation(composer, "80@3304L221,85@3577L167,79@3238L608");
            ComposerKt.sourceInformationMarkerStart(composer, 1148979251, "CC(remember):OnBoardingScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(coroutineScope) | composer.changedInstance(onBoardingViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.OnBoardingScreenKt$$ExternalSyntheticLambda6
                    public final Object invoke() {
                        return OnBoardingScreenKt.OnBoardingScreen$lambda$21$lambda$20$lambda$19$lambda$18$lambda$7$lambda$6(coroutineScope, onBoardingViewModel);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function1 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1148987933, "CC(remember):OnBoardingScreen.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(onBoardingViewModel) | composer.changed(function0);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.OnBoardingScreenKt$$ExternalSyntheticLambda7
                    public final Object invoke() {
                        return OnBoardingScreenKt.OnBoardingScreen$lambda$21$lambda$20$lambda$19$lambda$18$lambda$9$lambda$8(onBoardingViewModel, function0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ConsentPageKt.ConsentPage(function1, (Function0) objRememberedValue2, ColumnScope.weight$default(columnScope, Modifier.Companion, 1.0f, false, 2, (Object) null), composer, 0, 0);
            composer.endReplaceGroup();
        } else {
            if (onBoardingPages instanceof OnBoardingPages.PersonaPage) {
                composer.startReplaceGroup(1259260084);
                ComposerKt.sourceInformation(composer, "96@4114L262,94@3974L504");
                List<Persona> personas = ((OnBoardingPages.PersonaPage) onBoardingPages).getPersonas();
                ComposerKt.sourceInformationMarkerStart(composer, 1149005212, "CC(remember):OnBoardingScreen.kt#9igjgp");
                boolean zChangedInstance3 = composer.changedInstance(coroutineScope) | composer.changedInstance(onBoardingViewModel) | ((((i2 & 112) ^ 48) > 32 && composer.changed(i)) || (i2 & 48) == 32);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChangedInstance3 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.OnBoardingScreenKt$$ExternalSyntheticLambda8
                        public final Object invoke(Object obj) {
                            return OnBoardingScreenKt.OnBoardingScreen$lambda$21$lambda$20$lambda$19$lambda$18$lambda$11$lambda$10(coroutineScope, onBoardingViewModel, i, (String) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                PersonaSelectionPageKt.PersonaSelectionPage(personas, (Function1) objRememberedValue3, ColumnScope.weight$default(columnScope, Modifier.Companion, 1.0f, false, 2, (Object) null), composer, 0, 0);
                composer.endReplaceGroup();
            } else if (onBoardingPages instanceof OnBoardingPages.RolePage) {
                composer.startReplaceGroup(1259888206);
                ComposerKt.sourceInformation(composer, "108@4735L153,111@4937L122,106@4603L638");
                OnBoardingPages.RolePage rolePage = (OnBoardingPages.RolePage) onBoardingPages;
                Persona persona = rolePage.getPersona();
                ComposerKt.sourceInformationMarkerStart(composer, 1149024975, "CC(remember):OnBoardingScreen.kt#9igjgp");
                boolean zChangedInstance4 = composer.changedInstance(onBoardingViewModel);
                Object objRememberedValue4 = composer.rememberedValue();
                if (zChangedInstance4 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                    objRememberedValue4 = new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.OnBoardingScreenKt$$ExternalSyntheticLambda9
                        public final Object invoke(Object obj, Object obj2) {
                            return OnBoardingScreenKt.OnBoardingScreen$lambda$21$lambda$20$lambda$19$lambda$18$lambda$13$lambda$12(onBoardingViewModel, (String) obj, (String) obj2);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue4);
                }
                Function2 function2 = (Function2) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, 1149031408, "CC(remember):OnBoardingScreen.kt#9igjgp");
                boolean zChangedInstance5 = composer.changedInstance(onBoardingViewModel) | composer.changedInstance(onBoardingPages);
                Object objRememberedValue5 = composer.rememberedValue();
                if (zChangedInstance5 || objRememberedValue5 == Composer.Companion.getEmpty()) {
                    objRememberedValue5 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.OnBoardingScreenKt$$ExternalSyntheticLambda10
                        public final Object invoke() {
                            return OnBoardingScreenKt.OnBoardingScreen$lambda$21$lambda$20$lambda$19$lambda$18$lambda$15$lambda$14(onBoardingViewModel, onBoardingPages);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                RoleSelectionPageKt.RoleSelectionPage(persona, function2, (Function0) objRememberedValue5, rolePage.getSelectedRoleCount(), ColumnScope.weight$default(columnScope, Modifier.Companion, 1.0f, false, 2, (Object) null), composer, 0, 0);
                composer.endReplaceGroup();
            } else {
                if (!(onBoardingPages instanceof OnBoardingPages.ThankYouPage)) {
                    composer.startReplaceGroup(1148975033);
                    composer.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composer.startReplaceGroup(1260639491);
                ComposerKt.sourceInformation(composer, "121@5432L165,120@5370L329");
                ComposerKt.sourceInformationMarkerStart(composer, 1149047291, "CC(remember):OnBoardingScreen.kt#9igjgp");
                boolean zChangedInstance6 = composer.changedInstance(onBoardingViewModel) | composer.changed(function0);
                Object objRememberedValue6 = composer.rememberedValue();
                if (zChangedInstance6 || objRememberedValue6 == Composer.Companion.getEmpty()) {
                    objRememberedValue6 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.OnBoardingScreenKt$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            return OnBoardingScreenKt.OnBoardingScreen$lambda$21$lambda$20$lambda$19$lambda$18$lambda$17$lambda$16(onBoardingViewModel, function0);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                ThankYouPageKt.ThankYouPage((Function0) objRememberedValue6, ColumnScope.weight$default(columnScope, Modifier.Companion, 1.0f, false, 2, (Object) null), composer, 0, 0);
                composer.endReplaceGroup();
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnBoardingScreen$lambda$21$lambda$20$lambda$19$lambda$18$lambda$7$lambda$6(CoroutineScope coroutineScope, OnBoardingViewModel onBoardingViewModel) {
        BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new OnBoardingScreenKt$OnBoardingScreen$3$1$1$1$1$1$1(onBoardingViewModel, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnBoardingScreen$lambda$21$lambda$20$lambda$19$lambda$18$lambda$9$lambda$8(OnBoardingViewModel onBoardingViewModel, Function0 function0) {
        onBoardingViewModel.onSkip();
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnBoardingScreen$lambda$21$lambda$20$lambda$19$lambda$18$lambda$11$lambda$10(CoroutineScope coroutineScope, OnBoardingViewModel onBoardingViewModel, int i, String str) {
        Intrinsics.checkNotNullParameter(str, "personaId");
        BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new OnBoardingScreenKt$OnBoardingScreen$3$1$1$1$3$1$1(onBoardingViewModel, str, i, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnBoardingScreen$lambda$21$lambda$20$lambda$19$lambda$18$lambda$13$lambda$12(OnBoardingViewModel onBoardingViewModel, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "roleId");
        Intrinsics.checkNotNullParameter(str2, "personaId");
        onBoardingViewModel.onRoleToggled(str, str2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnBoardingScreen$lambda$21$lambda$20$lambda$19$lambda$18$lambda$15$lambda$14(OnBoardingViewModel onBoardingViewModel, OnBoardingPages onBoardingPages) {
        onBoardingViewModel.onSubmit(((OnBoardingPages.RolePage) onBoardingPages).getPersona());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnBoardingScreen$lambda$21$lambda$20$lambda$19$lambda$18$lambda$17$lambda$16(OnBoardingViewModel onBoardingViewModel, Function0 function0) {
        onBoardingViewModel.onOk();
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OnBoardingUiState OnBoardingScreen$lambda$0(State<OnBoardingUiState> state) {
        return (OnBoardingUiState) state.getValue();
    }
}
