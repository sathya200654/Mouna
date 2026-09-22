package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FlowLayoutKt;
import androidx.compose.foundation.layout.FlowRowScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.foundation.text.selection.SelectionContainerKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.SignLanguageKt;
import androidx.compose.material3.DividerDefaults;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.FloatingActionButtonElevation;
import androidx.compose.material3.FloatingActionButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SnackbarHostKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.window.core.layout.WindowSizeClass;
import com.azure.core.implementation.ImplUtils;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.CircularProgressIndicatorComponentKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.TagChipKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.SimpleTopBarKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.media.MediaPlayerState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.WebViewManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPractice;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.SignPracticeMediaPlayerControllerKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeSessionEventState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeSessionUiState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeSessionViewModel;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.flow.SharedFlow;

/* JADX INFO: compiled from: SignPracticeSessionScreen.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a7\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b²\u0006\n\u0010\f\u001a\u00020\rX\u008a\u0084\u0002"}, d2 = {"SignPracticeSessionScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "signPracticeSessionViewModel", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/viewmodels/SignPracticeSessionViewModel;", "webViewManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/manager/WebViewManager;", "navigateBack", "Lkotlin/Function0;", "(Landroidx/compose/ui/Modifier;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/viewmodels/SignPracticeSessionViewModel;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/manager/WebViewManager;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_release", "uiState", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/viewmodels/SignPracticeSessionUiState;"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SignPracticeSessionScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int SignPracticeSessionScreen$lambda$24$lambda$10$lambda$9(int i) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int SignPracticeSessionScreen$lambda$24$lambda$12$lambda$11(int i) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeSessionScreen$lambda$46(Modifier modifier, SignPracticeSessionViewModel signPracticeSessionViewModel, WebViewManager webViewManager, Function0 function0, int i, int i2, Composer composer, int i3) {
        SignPracticeSessionScreen(modifier, signPracticeSessionViewModel, webViewManager, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void SignPracticeSessionScreen(Modifier modifier, SignPracticeSessionViewModel signPracticeSessionViewModel, final WebViewManager webViewManager, final Function0<Unit> function0, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        SignPracticeSessionViewModel signPracticeSessionViewModel2;
        final Modifier modifier3;
        final SignPracticeSessionViewModel signPracticeSessionViewModel3;
        Modifier modifier4;
        final SignPracticeSessionViewModel signPracticeSessionViewModel4;
        CreationExtras defaultViewModelCreationExtras;
        Intrinsics.checkNotNullParameter(webViewManager, "webViewManager");
        Intrinsics.checkNotNullParameter(function0, "navigateBack");
        Composer composerStartRestartGroup = composer.startRestartGroup(-606320036);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SignPracticeSessionScreen)P(!1,2,3)72@3999L16,74@4099L32,75@4163L7,77@4200L310,77@4176L334,89@4539L149,89@4516L172,98@4750L279,157@7474L2401,107@5054L55,110@5142L2310,201@9882L3727,96@4694L8915:SignPracticeSessionScreen.kt#1lejub");
        int i4 = i2 & 1;
        if (i4 != 0) {
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
                signPracticeSessionViewModel2 = signPracticeSessionViewModel;
                int i5 = composerStartRestartGroup.changedInstance(signPracticeSessionViewModel2) ? 32 : 16;
                i3 |= i5;
            } else {
                signPracticeSessionViewModel2 = signPracticeSessionViewModel;
            }
            i3 |= i5;
        } else {
            signPracticeSessionViewModel2 = signPracticeSessionViewModel;
        }
        if ((i & 384) == 0) {
            i3 |= (i & 512) == 0 ? composerStartRestartGroup.changed(webViewManager) : composerStartRestartGroup.changedInstance(webViewManager) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        int i6 = i3;
        if (composerStartRestartGroup.shouldExecute((i6 & 1171) != 1170, i6 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "68@3857L15");
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i6 &= -113;
                }
                modifier4 = modifier2;
                signPracticeSessionViewModel4 = signPracticeSessionViewModel2;
            } else {
                Modifier modifier5 = i4 != 0 ? (Modifier) Modifier.Companion : modifier2;
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
                    ViewModel viewModel = ViewModelKt.viewModel(SignPracticeSessionViewModel.class, current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 36936, 0);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    SignPracticeSessionViewModel signPracticeSessionViewModel5 = (SignPracticeSessionViewModel) viewModel;
                    i6 &= -113;
                    modifier4 = modifier5;
                    signPracticeSessionViewModel4 = signPracticeSessionViewModel5;
                } else {
                    modifier4 = modifier5;
                    signPracticeSessionViewModel4 = signPracticeSessionViewModel2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-606320036, i6, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeSessionScreen (SignPracticeSessionScreen.kt:71)");
            }
            final State stateCollectAsState = SnapshotStateKt.collectAsState(signPracticeSessionViewModel4.getUiState(), (CoroutineContext) null, composerStartRestartGroup, 0, 1);
            SharedFlow<SignPracticeSessionEventState> uiEvent = signPracticeSessionViewModel4.getUiEvent();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1442011196, "CC(remember):SignPracticeSessionScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new SnackbarHostState();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final SnackbarHostState snackbarHostState = (SnackbarHostState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Context context = (Context) objConsume;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1442014706, "CC(remember):SignPracticeSessionScreen.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(uiEvent) | composerStartRestartGroup.changedInstance(context);
            SignPracticeSessionScreenKt$SignPracticeSessionScreen$1$1 signPracticeSessionScreenKt$SignPracticeSessionScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || signPracticeSessionScreenKt$SignPracticeSessionScreen$1$1RememberedValue == Composer.Companion.getEmpty()) {
                signPracticeSessionScreenKt$SignPracticeSessionScreen$1$1RememberedValue = new SignPracticeSessionScreenKt$SignPracticeSessionScreen$1$1(uiEvent, snackbarHostState, context, null);
                composerStartRestartGroup.updateRememberedValue(signPracticeSessionScreenKt$SignPracticeSessionScreen$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(uiEvent, (Function2) signPracticeSessionScreenKt$SignPracticeSessionScreen$1$1RememberedValue, composerStartRestartGroup, 0);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1442025393, "CC(remember):SignPracticeSessionScreen.kt#9igjgp");
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(signPracticeSessionViewModel4);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeSessionScreenKt$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj) {
                        return SignPracticeSessionScreenKt.SignPracticeSessionScreen$lambda$5$lambda$4(signPracticeSessionViewModel4, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.DisposableEffect(unit, (Function1) objRememberedValue2, composerStartRestartGroup, 6);
            ScaffoldKt.Scaffold-TvnljyQ(modifier4, ComposableLambdaKt.rememberComposableLambda(140144416, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeSessionScreenKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    return SignPracticeSessionScreenKt.SignPracticeSessionScreen$lambda$8(signPracticeSessionViewModel4, function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(2087874849, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeSessionScreenKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    return SignPracticeSessionScreenKt.SignPracticeSessionScreen$lambda$24(stateCollectAsState, signPracticeSessionViewModel4, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-259362014, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeSessionScreenKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    return SignPracticeSessionScreenKt.SignPracticeSessionScreen$lambda$25(snackbarHostState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(1688368419, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeSessionScreenKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    return SignPracticeSessionScreenKt.SignPracticeSessionScreen$lambda$33(signPracticeSessionViewModel4, stateCollectAsState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), 0, 0L, 0L, (WindowInsets) null, ComposableLambdaKt.rememberComposableLambda(-901543445, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeSessionScreenKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SignPracticeSessionScreenKt.SignPracticeSessionScreen$lambda$45(stateCollectAsState, webViewManager, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i6 & 14) | 805334448, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            signPracticeSessionViewModel3 = signPracticeSessionViewModel4;
            modifier3 = modifier4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            signPracticeSessionViewModel3 = signPracticeSessionViewModel2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeSessionScreenKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2) {
                    return SignPracticeSessionScreenKt.SignPracticeSessionScreen$lambda$46(modifier3, signPracticeSessionViewModel3, webViewManager, function0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeSessionScreen$lambda$8(final SignPracticeSessionViewModel signPracticeSessionViewModel, final Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C100@4802L52,101@4887L118,99@4764L255:SignPracticeSessionScreen.kt#1lejub");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(140144416, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeSessionScreen.<anonymous> (SignPracticeSessionScreen.kt:99)");
            }
            String strStringResource = StringResources_androidKt.stringResource(R.string.sign_practice_session_title, composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, 1534802102, "CC(remember):SignPracticeSessionScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(signPracticeSessionViewModel) | composer.changed(function0);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeSessionScreenKt$$ExternalSyntheticLambda22
                    public final Object invoke() {
                        return SignPracticeSessionScreenKt.SignPracticeSessionScreen$lambda$8$lambda$7$lambda$6(signPracticeSessionViewModel, function0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SimpleTopBarKt.SimpleTopBar(null, strStringResource, (Function0) objRememberedValue, composer, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeSessionScreen$lambda$8$lambda$7$lambda$6(SignPracticeSessionViewModel signPracticeSessionViewModel, Function0 function0) {
        signPracticeSessionViewModel.stopPlayBack();
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeSessionScreen$lambda$25(SnackbarHostState snackbarHostState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C108@5068L31:SignPracticeSessionScreen.kt#1lejub");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-259362014, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeSessionScreen.<anonymous> (SignPracticeSessionScreen.kt:108)");
            }
            SnackbarHostKt.SnackbarHost(snackbarHostState, (Modifier) null, (Function3) null, composer, 6, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit SignPracticeSessionScreen$lambda$33(final SignPracticeSessionViewModel signPracticeSessionViewModel, State state, Composer composer, int i) throws NoWhenBranchMatchedException {
        ComposerKt.sourceInformation(composer, "C111@5189L88:SignPracticeSessionScreen.kt#1lejub");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1688368419, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeSessionScreen.<anonymous> (SignPracticeSessionScreen.kt:111)");
            }
            final String strStringResource = StringResources_androidKt.stringResource(R.string.sign_practice_progress_cd_loading, composer, 0);
            final SignPracticeSessionUiState signPracticeSessionUiStateSignPracticeSessionScreen$lambda$0 = SignPracticeSessionScreen$lambda$0(state);
            if (Intrinsics.areEqual(signPracticeSessionUiStateSignPracticeSessionScreen$lambda$0, SignPracticeSessionUiState.Loading.INSTANCE)) {
                composer.startReplaceGroup(-178202819);
                composer.endReplaceGroup();
            } else {
                if (!(signPracticeSessionUiStateSignPracticeSessionScreen$lambda$0 instanceof SignPracticeSessionUiState.Success)) {
                    composer.startReplaceGroup(-975580310);
                    composer.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composer.startReplaceGroup(-178081547);
                ComposerKt.sourceInformation(composer, "");
                SignPracticeSessionUiState.Success success = (SignPracticeSessionUiState.Success) signPracticeSessionUiStateSignPracticeSessionScreen$lambda$0;
                if (success.getWebViewState() instanceof WebViewState.IsInterpretingSentences) {
                    composer.startReplaceGroup(-178039480);
                    ComposerKt.sourceInformation(composer, "119@5577L105,119@5546L551");
                    ComposerKt.sourceInformationMarkerStart(composer, -975573204, "CC(remember):SignPracticeSessionScreen.kt#9igjgp");
                    boolean zChangedInstance = composer.changedInstance(signPracticeSessionViewModel);
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeSessionScreenKt$$ExternalSyntheticLambda0
                            public final Object invoke() {
                                return SignPracticeSessionScreenKt.SignPracticeSessionScreen$lambda$33$lambda$27$lambda$26(signPracticeSessionViewModel);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    FloatingActionButtonKt.FloatingActionButton-X-z6DiA((Function0) objRememberedValue, (Modifier) null, (Shape) null, 0L, 0L, (FloatingActionButtonElevation) null, (MutableInteractionSource) null, ComposableSingletons$SignPracticeSessionScreenKt.INSTANCE.m1808getLambda$1900353119$app_release(), composer, 12582912, 126);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(-177418054);
                    ComposerKt.sourceInformation(composer, "132@6274L217,136@6493L895,132@6243L1145");
                    final boolean z = success.getWebViewState() instanceof WebViewState.IsLoading;
                    ComposerKt.sourceInformationMarkerStart(composer, -975550788, "CC(remember):SignPracticeSessionScreen.kt#9igjgp");
                    boolean zChanged = composer.changed(z) | composer.changedInstance(signPracticeSessionViewModel) | composer.changedInstance(signPracticeSessionUiStateSignPracticeSessionScreen$lambda$0);
                    Object objRememberedValue2 = composer.rememberedValue();
                    if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                        objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeSessionScreenKt$$ExternalSyntheticLambda11
                            public final Object invoke() {
                                return SignPracticeSessionScreenKt.SignPracticeSessionScreen$lambda$33$lambda$29$lambda$28(z, signPracticeSessionViewModel, signPracticeSessionUiStateSignPracticeSessionScreen$lambda$0);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    FloatingActionButtonKt.FloatingActionButton-X-z6DiA((Function0) objRememberedValue2, (Modifier) null, (Shape) null, 0L, 0L, (FloatingActionButtonElevation) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(592090602, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeSessionScreenKt$$ExternalSyntheticLambda18
                        public final Object invoke(Object obj, Object obj2) {
                            return SignPracticeSessionScreenKt.SignPracticeSessionScreen$lambda$33$lambda$32(signPracticeSessionUiStateSignPracticeSessionScreen$lambda$0, z, strStringResource, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer, 54), composer, 12582912, 126);
                    composer.endReplaceGroup();
                }
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeSessionScreen$lambda$33$lambda$27$lambda$26(SignPracticeSessionViewModel signPracticeSessionViewModel) {
        signPracticeSessionViewModel.stopInterpretation();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeSessionScreen$lambda$33$lambda$29$lambda$28(boolean z, SignPracticeSessionViewModel signPracticeSessionViewModel, SignPracticeSessionUiState signPracticeSessionUiState) {
        if (!z) {
            signPracticeSessionViewModel.sendSignPracticeToWebView(((SignPracticeSessionUiState.Success) signPracticeSessionUiState).getSignPractice());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeSessionScreen$lambda$33$lambda$32(SignPracticeSessionUiState signPracticeSessionUiState, boolean z, final String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:SignPracticeSessionScreen.kt#1lejub");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(592090602, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeSessionScreen.<anonymous>.<anonymous> (SignPracticeSessionScreen.kt:137)");
            }
            if (((SignPracticeSessionUiState.Success) signPracticeSessionUiState).isTranslatingSignPractice() || z) {
                composer.startReplaceGroup(-459464326);
                ComposerKt.sourceInformation(composer, "139@6707L127,138@6614L254");
                Modifier modifier = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart(composer, 2063392425, "CC(remember):SignPracticeSessionScreen.kt#9igjgp");
                boolean zChanged = composer.changed(str);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeSessionScreenKt$$ExternalSyntheticLambda12
                        public final Object invoke(Object obj) {
                            return SignPracticeSessionScreenKt.SignPracticeSessionScreen$lambda$33$lambda$32$lambda$31$lambda$30(str, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                ProgressIndicatorKt.CircularProgressIndicator-4lLiAd8(SemanticsModifierKt.semantics$default(modifier, false, (Function1) objRememberedValue, 1, (Object) null), 0L, 0.0f, 0L, 0, 0.0f, composer, 0, 62);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-459138578);
                ComposerKt.sourceInformation(composer, "146@7079L134,144@6938L394");
                IconKt.Icon-ww6aTOc(SignLanguageKt.getSignLanguage(Icons.INSTANCE.getDefault()), StringResources_androidKt.stringResource(R.string.sign_practice_icon_cd_interpret, composer, 0), GraphicsLayerModifierKt.graphicsLayer-_6ThJ44$default(Modifier.Companion, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, (Shape) null, false, (RenderEffect) null, 0L, 0L, 0, 0, (ColorFilter) null, 524286, (Object) null), 0L, composer, 0, 8);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeSessionScreen$lambda$33$lambda$32$lambda$31$lambda$30(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit SignPracticeSessionScreen$lambda$24(State state, final SignPracticeSessionViewModel signPracticeSessionViewModel, Composer composer, int i) throws NoWhenBranchMatchedException {
        ComposerKt.sourceInformation(composer, "C:SignPracticeSessionScreen.kt#1lejub");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2087874849, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeSessionScreen.<anonymous> (SignPracticeSessionScreen.kt:158)");
            }
            SignPracticeSessionUiState signPracticeSessionUiStateSignPracticeSessionScreen$lambda$0 = SignPracticeSessionScreen$lambda$0(state);
            if (Intrinsics.areEqual(signPracticeSessionUiStateSignPracticeSessionScreen$lambda$0, SignPracticeSessionUiState.Loading.INSTANCE)) {
                composer.startReplaceGroup(163342175);
                composer.endReplaceGroup();
            } else {
                if (!(signPracticeSessionUiStateSignPracticeSessionScreen$lambda$0 instanceof SignPracticeSessionUiState.Success)) {
                    composer.startReplaceGroup(698005482);
                    composer.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composer.startReplaceGroup(163470453);
                ComposerKt.sourceInformation(composer, "166@7972L6,167@8047L6,168@8077L1756,164@7827L2006");
                SignPracticeSessionUiState.Success success = (SignPracticeSessionUiState.Success) signPracticeSessionUiStateSignPracticeSessionScreen$lambda$0;
                boolean z = success.getWebViewState() instanceof WebViewState.IsInterpretingSentences;
                final MediaPlayerState mediaPlayerState = success.getMediaPlayerState();
                boolean z2 = !z;
                ComposerKt.sourceInformationMarkerStart(composer, 698018599, "CC(remember):SignPracticeSessionScreen.kt#9igjgp");
                Object objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeSessionScreenKt$$ExternalSyntheticLambda19
                        public final Object invoke(Object obj) {
                            return Integer.valueOf(SignPracticeSessionScreenKt.SignPracticeSessionScreen$lambda$24$lambda$10$lambda$9(((Integer) obj).intValue()));
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                EnterTransition enterTransitionSlideInVertically$default = EnterExitTransitionKt.slideInVertically$default((FiniteAnimationSpec) null, (Function1) objRememberedValue, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart(composer, 698020999, "CC(remember):SignPracticeSessionScreen.kt#9igjgp");
                Object objRememberedValue2 = composer.rememberedValue();
                if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeSessionScreenKt$$ExternalSyntheticLambda20
                        public final Object invoke(Object obj) {
                            return Integer.valueOf(SignPracticeSessionScreenKt.SignPracticeSessionScreen$lambda$24$lambda$12$lambda$11(((Integer) obj).intValue()));
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                AnimatedVisibilityKt.AnimatedVisibility(z2, (Modifier) null, enterTransitionSlideInVertically$default, EnterExitTransitionKt.slideOutVertically$default((FiniteAnimationSpec) null, (Function1) objRememberedValue2, 1, (Object) null), (String) null, ComposableLambdaKt.rememberComposableLambda(-1139703398, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeSessionScreenKt$$ExternalSyntheticLambda21
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return SignPracticeSessionScreenKt.SignPracticeSessionScreen$lambda$24$lambda$23(mediaPlayerState, signPracticeSessionViewModel, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, 54), composer, 200064, 18);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeSessionScreen$lambda$24$lambda$23(final MediaPlayerState mediaPlayerState, final SignPracticeSessionViewModel signPracticeSessionViewModel, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animatedVisibilityScope, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C171@8248L317,178@8606L222,182@8874L245,186@9158L226,193@9660L125,169@8103L1708:SignPracticeSessionScreen.kt#1lejub");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1139703398, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeSessionScreen.<anonymous>.<anonymous> (SignPracticeSessionScreen.kt:169)");
        }
        boolean zIsPlaying = mediaPlayerState.isPlaying();
        ComposerKt.sourceInformationMarkerStart(composer, -38299209, "CC(remember):SignPracticeSessionScreen.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(mediaPlayerState) | composer.changedInstance(signPracticeSessionViewModel);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeSessionScreenKt$$ExternalSyntheticLambda23
                public final Object invoke() {
                    return SignPracticeSessionScreenKt.SignPracticeSessionScreen$lambda$24$lambda$23$lambda$14$lambda$13(mediaPlayerState, signPracticeSessionViewModel);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Function0 function0 = (Function0) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -38287848, "CC(remember):SignPracticeSessionScreen.kt#9igjgp");
        boolean zChangedInstance2 = composer.changedInstance(mediaPlayerState) | composer.changedInstance(signPracticeSessionViewModel);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
            objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeSessionScreenKt$$ExternalSyntheticLambda24
                public final Object invoke() {
                    return SignPracticeSessionScreenKt.SignPracticeSessionScreen$lambda$24$lambda$23$lambda$16$lambda$15(mediaPlayerState, signPracticeSessionViewModel);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        Function0 function1 = (Function0) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -38279249, "CC(remember):SignPracticeSessionScreen.kt#9igjgp");
        boolean zChangedInstance3 = composer.changedInstance(mediaPlayerState) | composer.changedInstance(signPracticeSessionViewModel);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChangedInstance3 || objRememberedValue3 == Composer.Companion.getEmpty()) {
            objRememberedValue3 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeSessionScreenKt$$ExternalSyntheticLambda25
                public final Object invoke() {
                    return SignPracticeSessionScreenKt.SignPracticeSessionScreen$lambda$24$lambda$23$lambda$18$lambda$17(mediaPlayerState, signPracticeSessionViewModel);
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        Function0 function2 = (Function0) objRememberedValue3;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -38270180, "CC(remember):SignPracticeSessionScreen.kt#9igjgp");
        boolean zChangedInstance4 = composer.changedInstance(mediaPlayerState) | composer.changedInstance(signPracticeSessionViewModel);
        Object objRememberedValue4 = composer.rememberedValue();
        if (zChangedInstance4 || objRememberedValue4 == Composer.Companion.getEmpty()) {
            objRememberedValue4 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeSessionScreenKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    return SignPracticeSessionScreenKt.SignPracticeSessionScreen$lambda$24$lambda$23$lambda$20$lambda$19(mediaPlayerState, signPracticeSessionViewModel, ((Float) obj).floatValue());
                }
            };
            composer.updateRememberedValue(objRememberedValue4);
        }
        Function1 function3 = (Function1) objRememberedValue4;
        ComposerKt.sourceInformationMarkerEnd(composer);
        long duration = mediaPlayerState.getDuration();
        long currentPosition = mediaPlayerState.getCurrentPosition();
        float playbackSpeed = mediaPlayerState.getPlaybackSpeed();
        ComposerKt.sourceInformationMarkerStart(composer, -38254217, "CC(remember):SignPracticeSessionScreen.kt#9igjgp");
        boolean zChangedInstance5 = composer.changedInstance(signPracticeSessionViewModel);
        Object objRememberedValue5 = composer.rememberedValue();
        if (zChangedInstance5 || objRememberedValue5 == Composer.Companion.getEmpty()) {
            objRememberedValue5 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeSessionScreenKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    return SignPracticeSessionScreenKt.SignPracticeSessionScreen$lambda$24$lambda$23$lambda$22$lambda$21(signPracticeSessionViewModel, ((Float) obj).floatValue());
                }
            };
            composer.updateRememberedValue(objRememberedValue5);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        SignPracticeMediaPlayerControllerKt.SignPracticeMediaPlayerController(null, zIsPlaying, function0, function1, function2, function3, duration, currentPosition, playbackSpeed, (Function1) objRememberedValue5, composer, 0, 1);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeSessionScreen$lambda$24$lambda$23$lambda$14$lambda$13(MediaPlayerState mediaPlayerState, SignPracticeSessionViewModel signPracticeSessionViewModel) {
        if (mediaPlayerState.isPlaying()) {
            signPracticeSessionViewModel.pause();
        } else {
            signPracticeSessionViewModel.play();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeSessionScreen$lambda$24$lambda$23$lambda$16$lambda$15(MediaPlayerState mediaPlayerState, SignPracticeSessionViewModel signPracticeSessionViewModel) {
        signPracticeSessionViewModel.seekTo(RangesKt.coerceAtLeast(mediaPlayerState.getCurrentPosition() - ((long) ImplUtils.MAX_CACHE_SIZE), 0L));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeSessionScreen$lambda$24$lambda$23$lambda$18$lambda$17(MediaPlayerState mediaPlayerState, SignPracticeSessionViewModel signPracticeSessionViewModel) {
        signPracticeSessionViewModel.seekTo(RangesKt.coerceAtMost(mediaPlayerState.getCurrentPosition() + ((long) ImplUtils.MAX_CACHE_SIZE), mediaPlayerState.getDuration()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeSessionScreen$lambda$24$lambda$23$lambda$20$lambda$19(MediaPlayerState mediaPlayerState, SignPracticeSessionViewModel signPracticeSessionViewModel, float f) {
        signPracticeSessionViewModel.seekTo((long) (mediaPlayerState.getDuration() * f));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeSessionScreen$lambda$24$lambda$23$lambda$22$lambda$21(SignPracticeSessionViewModel signPracticeSessionViewModel, float f) {
        signPracticeSessionViewModel.setPlayBackSpeed(f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit SignPracticeSessionScreen$lambda$45(State state, final WebViewManager webViewManager, PaddingValues paddingValues, Composer composer, int i) throws NoWhenBranchMatchedException {
        int i2;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer2, "C202@9909L3694:SignPracticeSessionScreen.kt#1lejub");
        if ((i & 6) == 0) {
            i2 = i | (composer2.changed(paddingValues) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer2.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-901543445, i2, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeSessionScreen.<anonymous> (SignPracticeSessionScreen.kt:202)");
            }
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(PaddingKt.padding(Modifier.Companion, paddingValues), 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxSize$default);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer composer3 = Updater.constructor-impl(composer2);
            Updater.set-impl(composer3, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer3, Integer.valueOf(iHashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer3, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 489050654, "C207@10073L97:SignPracticeSessionScreen.kt#1lejub");
            final String strStringResource = StringResources_androidKt.stringResource(R.string.sign_practice_progress_cd_loading_practice, composer2, 0);
            SignPracticeSessionUiState signPracticeSessionUiStateSignPracticeSessionScreen$lambda$0 = SignPracticeSessionScreen$lambda$0(state);
            if (Intrinsics.areEqual(signPracticeSessionUiStateSignPracticeSessionScreen$lambda$0, SignPracticeSessionUiState.Loading.INSTANCE)) {
                composer2.startReplaceGroup(489179210);
                ComposerKt.sourceInformation(composer2, "215@10458L50,212@10295L235");
                Modifier modifierAlign = boxScope.align(Modifier.Companion, Alignment.Companion.getCenter());
                ComposerKt.sourceInformationMarkerStart(composer2, 1678353655, "CC(remember):SignPracticeSessionScreen.kt#9igjgp");
                boolean zChanged = composer2.changed(strStringResource);
                Object objRememberedValue = composer2.rememberedValue();
                if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeSessionScreenKt$$ExternalSyntheticLambda13
                        public final Object invoke(Object obj) {
                            return SignPracticeSessionScreenKt.SignPracticeSessionScreen$lambda$45$lambda$44$lambda$35$lambda$34(strStringResource, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                CircularProgressIndicatorComponentKt.CircularProgressComponent(SemanticsModifierKt.semantics$default(modifierAlign, false, (Function1) objRememberedValue, 1, (Object) null), composer2, 0, 0);
                composer2.endReplaceGroup();
            } else {
                if (!(signPracticeSessionUiStateSignPracticeSessionScreen$lambda$0 instanceof SignPracticeSessionUiState.Success)) {
                    composer2.startReplaceGroup(1678348215);
                    composer2.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composer2.startReplaceGroup(489593184);
                ComposerKt.sourceInformation(composer2, "224@10833L21,221@10694L1949");
                SignPracticeSessionUiState.Success success = (SignPracticeSessionUiState.Success) signPracticeSessionUiStateSignPracticeSessionScreen$lambda$0;
                final SignPractice signPractice = success.getSignPractice();
                float f = 16;
                Modifier modifier = PaddingKt.padding-3ABfNKs(ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), ScrollKt.rememberScrollState(0, composer2, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null), Dp.constructor-impl(f));
                ComposerKt.sourceInformationMarkerStart(composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer2, 0);
                ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifier);
                Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2);
                } else {
                    composer2.useNode();
                }
                Composer composer4 = Updater.constructor-impl(composer2);
                Updater.set-impl(composer4, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer4, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl(composer4, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl(composer4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl(composer4, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 105229292, "C229@11066L10,231@11200L11,232@11279L13,227@10948L370,235@11344L41,240@11603L331,237@11411L523,247@11960L41,251@12163L11,249@12027L203,254@12256L41,256@12342L279,256@12323L298:SignPracticeSessionScreen.kt#1lejub");
                String practiceName = signPractice.getPracticeName();
                TextStyle headlineLarge = MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getHeadlineLarge();
                FontWeight bold = FontWeight.Companion.getBold();
                long j = MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimary-0d7_KjU();
                Modifier modifier2 = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart(composer2, 1943066075, "CC(remember):SignPracticeSessionScreen.kt#9igjgp");
                Object objRememberedValue2 = composer2.rememberedValue();
                if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeSessionScreenKt$$ExternalSyntheticLambda14
                        public final Object invoke(Object obj) {
                            return SignPracticeSessionScreenKt.SignPracticeSessionScreen$lambda$45$lambda$44$lambda$40$lambda$37$lambda$36((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                TextKt.Text-Nvy7gAk(practiceName, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue2, 1, (Object) null), j, (TextAutoSize) null, 0L, (FontStyle) null, bold, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, headlineLarge, composer, 1572864, 0, 131000);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), composer, 6);
                float f2 = 8;
                FlowLayoutKt.FlowRow((Modifier) null, Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(f2)), Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(f2)), (Alignment.Vertical) null, 0, 0, ComposableLambdaKt.rememberComposableLambda(1290086441, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeSessionScreenKt$$ExternalSyntheticLambda15
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return SignPracticeSessionScreenKt.SignPracticeSessionScreen$lambda$45$lambda$44$lambda$40$lambda$38(signPractice, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, 54), composer, 1573296, 57);
                composer2 = composer;
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), composer2, 6);
                DividerKt.HorizontalDivider-9IZ8Weo((Modifier) null, DividerDefaults.INSTANCE.getThickness-D9Ej5fM(), Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurface-0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), composer2, 0, 1);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), composer2, 6);
                SelectionContainerKt.SelectionContainer((Modifier) null, ComposableLambdaKt.rememberComposableLambda(-972706261, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeSessionScreenKt$$ExternalSyntheticLambda16
                    public final Object invoke(Object obj, Object obj2) {
                        return SignPracticeSessionScreenKt.SignPracticeSessionScreen$lambda$45$lambda$44$lambda$40$lambda$39(signPractice, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54), composer2, 48, 1);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (!(success.getWebViewState() instanceof WebViewState.IsInterpretingSentences)) {
                    composer2.startReplaceGroup(478978877);
                } else {
                    composer2.startReplaceGroup(491639556);
                    ComposerKt.sourceInformation(composer2, "273@13118L6,274@13158L381,266@12762L777");
                    SurfaceKt.Surface-T9BRK9s(ZIndexModifierKt.zIndex(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(boxScope.align(Modifier.Companion, Alignment.Companion.getCenter()), Dp.constructor-impl(250)), Dp.constructor-impl(350)), 1.0f), MaterialTheme.INSTANCE.getShapes(composer2, MaterialTheme.$stable).getMedium(), 0L, 0L, 0.0f, Dp.constructor-impl(f2), (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-744466, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeSessionScreenKt$$ExternalSyntheticLambda17
                        public final Object invoke(Object obj, Object obj2) {
                            return SignPracticeSessionScreenKt.SignPracticeSessionScreen$lambda$45$lambda$44$lambda$43(webViewManager, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer2, 54), composer, 12779520, 92);
                    composer2 = composer;
                }
                composer2.endReplaceGroup();
                composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeSessionScreen$lambda$45$lambda$44$lambda$35$lambda$34(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeSessionScreen$lambda$45$lambda$44$lambda$40$lambda$37$lambda$36(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.heading(semanticsPropertyReceiver);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeSessionScreen$lambda$45$lambda$44$lambda$40$lambda$38(SignPractice signPractice, FlowRowScope flowRowScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(flowRowScope, "$this$FlowRow");
        ComposerKt.sourceInformation(composer, "C241@11633L35,242@11697L34,243@11775L54,243@11760L70,244@11859L49:SignPracticeSessionScreen.kt#1lejub");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1290086441, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeSessionScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SignPracticeSessionScreen.kt:241)");
            }
            TagChipKt.TagChip(null, signPractice.getDomain(), composer, 0, 1);
            TagChipKt.TagChip(null, signPractice.getTopic(), composer, 0, 1);
            TagChipKt.TagChip(null, StringResources_androidKt.stringResource(signPractice.getComplexity().getDisplayNameRes(), composer, 0), composer, 0, 1);
            TagChipKt.TagChip(null, signPractice.getLanguage().getDisplayText(), composer, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeSessionScreen$lambda$45$lambda$44$lambda$40$lambda$39(SignPractice signPractice, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C259@12493L10,257@12372L223:SignPracticeSessionScreen.kt#1lejub");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-972706261, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeSessionScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SignPracticeSessionScreen.kt:257)");
            }
            TextKt.Text-Nvy7gAk(signPractice.getContent(), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(24), 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyLarge(), composer, 0, 48, 129022);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeSessionScreen$lambda$45$lambda$44$lambda$43(final WebViewManager webViewManager, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C276@13243L240,275@13188L325:SignPracticeSessionScreen.kt#1lejub");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-744466, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeSessionScreen.<anonymous>.<anonymous>.<anonymous> (SignPracticeSessionScreen.kt:275)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -715428866, "CC(remember):SignPracticeSessionScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(webViewManager);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeSessionScreenKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        return SignPracticeSessionScreenKt.SignPracticeSessionScreen$lambda$45$lambda$44$lambda$43$lambda$42$lambda$41(webViewManager, (Context) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            AndroidView_androidKt.AndroidView((Function1) objRememberedValue, (Modifier) null, (Function1) null, composer, 0, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WebView SignPracticeSessionScreen$lambda$45$lambda$44$lambda$43$lambda$42$lambda$41(WebViewManager webViewManager, Context context) {
        Intrinsics.checkNotNullParameter(context, "it");
        WebView webView = webViewManager.getWebView();
        ViewParent parent = webView.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(webView);
        }
        return webView;
    }

    private static final SignPracticeSessionUiState SignPracticeSessionScreen$lambda$0(State<? extends SignPracticeSessionUiState> state) {
        return (SignPracticeSessionUiState) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult SignPracticeSessionScreen$lambda$5$lambda$4(final SignPracticeSessionViewModel signPracticeSessionViewModel, DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeSessionScreenKt$SignPracticeSessionScreen$lambda$5$lambda$4$$inlined$onDispose$1
            public void dispose() {
                signPracticeSessionViewModel.resetWebView();
                signPracticeSessionViewModel.stopPlayBack();
            }
        };
    }
}
