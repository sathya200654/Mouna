package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens;

import android.content.Context;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.FlowLayoutKt;
import androidx.compose.foundation.layout.FlowRowScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.CheckKt;
import androidx.compose.material3.ChipKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SelectableChipColors;
import androidx.compose.material3.SelectableChipElevation;
import androidx.compose.material3.SnackbarHostKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
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
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.recyclerview.widget.RecyclerView;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.CharacterLimitedOutlinedTextFieldKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.CircularProgressIndicatorComponentKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.CircularProgressIndicatorDialogComponentKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.SimpleTopBarKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPracticeComplexity;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPracticeDomain;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPracticeType;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPracticeWordCount;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.SignCreationBottomBarKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.SignCreationSectionTitleKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeCreationUiEvent;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeCreationUiState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeCreationViewModel;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.SharedFlow;

/* JADX INFO: compiled from: SignPracticeCreationScreen.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\u001aR\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\tH\u0007¢\u0006\u0002\u0010\u000e¨\u0006\u000f²\u0006\n\u0010\u0010\u001a\u00020\u0011X\u008a\u0084\u0002"}, d2 = {"SignPracticeCreationScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "signPracticeCreationViewModel", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/viewmodels/SignPracticeCreationViewModel;", "navigateBack", "Lkotlin/Function0;", "navigateToSingPracticeSession", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "practiceId", "(Landroidx/compose/ui/Modifier;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/viewmodels/SignPracticeCreationViewModel;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "app_release", "uiState", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/viewmodels/SignPracticeCreationUiState;"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SignPracticeCreationScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeCreationScreen$lambda$65(Modifier modifier, SignPracticeCreationViewModel signPracticeCreationViewModel, Function0 function0, Function1 function1, int i, int i2, Composer composer, int i3) {
        SignPracticeCreationScreen(modifier, signPracticeCreationViewModel, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    public static final void SignPracticeCreationScreen(Modifier modifier, SignPracticeCreationViewModel signPracticeCreationViewModel, final Function0<Unit> function0, final Function1<? super Long, Unit> function1, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        SignPracticeCreationViewModel signPracticeCreationViewModel2;
        final Modifier modifier3;
        final SignPracticeCreationViewModel signPracticeCreationViewModel3;
        Modifier modifier4;
        ?? r13;
        final SignPracticeCreationViewModel signPracticeCreationViewModel4;
        CreationExtras defaultViewModelCreationExtras;
        Intrinsics.checkNotNullParameter(function0, "navigateBack");
        Intrinsics.checkNotNullParameter(function1, "navigateToSingPracticeSession");
        Composer composerStartRestartGroup = composer.startRestartGroup(1469057904);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SignPracticeCreationScreen)P(!1,3)61@3627L16,63@3728L32,65@3793L7,67@3830L472,67@3806L496,84@4377L210,95@4701L196,92@4612L67,102@4904L11097,82@4308L11693:SignPracticeCreationScreen.kt#1lejub");
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
                signPracticeCreationViewModel2 = signPracticeCreationViewModel;
                int i5 = composerStartRestartGroup.changedInstance(signPracticeCreationViewModel2) ? 32 : 16;
                i3 |= i5;
            } else {
                signPracticeCreationViewModel2 = signPracticeCreationViewModel;
            }
            i3 |= i5;
        } else {
            signPracticeCreationViewModel2 = signPracticeCreationViewModel;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        int i6 = i3;
        if (composerStartRestartGroup.shouldExecute((i6 & 1171) != 1170, i6 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "57@3457L15");
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i6 &= -113;
                }
                modifier4 = modifier2;
                signPracticeCreationViewModel4 = signPracticeCreationViewModel2;
                r13 = 1;
            } else {
                modifier4 = i4 != 0 ? (Modifier) Modifier.Companion : modifier2;
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
                    r13 = 1;
                    ViewModel viewModel = ViewModelKt.viewModel(SignPracticeCreationViewModel.class, current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 36936, 0);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    i6 &= -113;
                    signPracticeCreationViewModel4 = (SignPracticeCreationViewModel) viewModel;
                } else {
                    r13 = 1;
                    signPracticeCreationViewModel4 = signPracticeCreationViewModel2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1469057904, i6, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreen (SignPracticeCreationScreen.kt:60)");
            }
            final State stateCollectAsState = SnapshotStateKt.collectAsState(signPracticeCreationViewModel4.getUiState(), (CoroutineContext) null, composerStartRestartGroup, 0, (int) r13);
            SharedFlow<SignPracticeCreationUiEvent> uiEvent = signPracticeCreationViewModel4.getUiEvent();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1279578704, "CC(remember):SignPracticeCreationScreen.kt#9igjgp");
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1279575000, "CC(remember):SignPracticeCreationScreen.kt#9igjgp");
            ?? r7 = (composerStartRestartGroup.changedInstance(uiEvent) ? 1 : 0) | (composerStartRestartGroup.changedInstance(context) ? 1 : 0) | ((i6 & 7168) == 2048 ? r13 : 0);
            SignPracticeCreationScreenKt$SignPracticeCreationScreen$1$1 signPracticeCreationScreenKt$SignPracticeCreationScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (r7 != 0 || signPracticeCreationScreenKt$SignPracticeCreationScreen$1$1RememberedValue == Composer.Companion.getEmpty()) {
                signPracticeCreationScreenKt$SignPracticeCreationScreen$1$1RememberedValue = new SignPracticeCreationScreenKt$SignPracticeCreationScreen$1$1(uiEvent, snackbarHostState, context, function1, null);
                composerStartRestartGroup.updateRememberedValue(signPracticeCreationScreenKt$SignPracticeCreationScreen$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(uiEvent, (Function2) signPracticeCreationScreenKt$SignPracticeCreationScreen$1$1RememberedValue, composerStartRestartGroup, 0);
            Modifier modifierImePadding = WindowInsetsPadding_androidKt.imePadding(modifier4);
            Function2 function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2078764748, (boolean) r13, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreenKt$$ExternalSyntheticLambda41
                public final Object invoke(Object obj, Object obj2) {
                    return SignPracticeCreationScreenKt.SignPracticeCreationScreen$lambda$3(function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            Function2 function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1902436491, (boolean) r13, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreenKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    return SignPracticeCreationScreenKt.SignPracticeCreationScreen$lambda$6(signPracticeCreationViewModel4, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            Function2 function2RememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1726108234, (boolean) r13, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreenKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    return SignPracticeCreationScreenKt.SignPracticeCreationScreen$lambda$7(snackbarHostState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            Function3 function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(110092991, (boolean) r13, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreenKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SignPracticeCreationScreenKt.SignPracticeCreationScreen$lambda$64(stateCollectAsState, signPracticeCreationViewModel4, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54);
            SignPracticeCreationViewModel signPracticeCreationViewModel5 = signPracticeCreationViewModel4;
            ScaffoldKt.Scaffold-TvnljyQ(modifierImePadding, function2RememberComposableLambda, function2RememberComposableLambda2, function2RememberComposableLambda3, (Function2) null, 0, 0L, 0L, (WindowInsets) null, function3RememberComposableLambda, composerStartRestartGroup, 805309872, 496);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            Modifier modifier5 = modifier4;
            signPracticeCreationViewModel3 = signPracticeCreationViewModel5;
            modifier3 = modifier5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            signPracticeCreationViewModel3 = signPracticeCreationViewModel2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreenKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    return SignPracticeCreationScreenKt.SignPracticeCreationScreen$lambda$65(modifier3, signPracticeCreationViewModel3, function0, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeCreationScreen$lambda$3(Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C87@4474L89,85@4391L186:SignPracticeCreationScreen.kt#1lejub");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2078764748, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreen.<anonymous> (SignPracticeCreationScreen.kt:85)");
            }
            SimpleTopBarKt.SimpleTopBar(null, StringResources_androidKt.stringResource(R.string.sign_practice_create_title, composer, 0), function0, composer, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeCreationScreen$lambda$7(SnackbarHostState snackbarHostState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C93@4626L43:SignPracticeCreationScreen.kt#1lejub");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1726108234, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreen.<anonymous> (SignPracticeCreationScreen.kt:93)");
            }
            SnackbarHostKt.SnackbarHost(snackbarHostState, (Modifier) null, (Function3) null, composer, 6, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeCreationScreen$lambda$6(final SignPracticeCreationViewModel signPracticeCreationViewModel, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C98@4803L84,96@4715L172:SignPracticeCreationScreen.kt#1lejub");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1902436491, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreen.<anonymous> (SignPracticeCreationScreen.kt:96)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 1414603593, "CC(remember):SignPracticeCreationScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(signPracticeCreationViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreenKt$$ExternalSyntheticLambda12
                    public final Object invoke() {
                        return SignPracticeCreationScreenKt.SignPracticeCreationScreen$lambda$6$lambda$5$lambda$4(signPracticeCreationViewModel);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SignCreationBottomBarKt.SignCreationBottomBar(modifierFillMaxWidth$default, (Function0) objRememberedValue, composer, 6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeCreationScreen$lambda$6$lambda$5$lambda$4(SignPracticeCreationViewModel signPracticeCreationViewModel) {
        signPracticeCreationViewModel.generateSignPractice();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeCreationScreen$lambda$64(final State state, final SignPracticeCreationViewModel signPracticeCreationViewModel, PaddingValues paddingValues, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer, "C:SignPracticeCreationScreen.kt#1lejub");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(paddingValues) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(110092991, i2, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreen.<anonymous> (SignPracticeCreationScreen.kt:103)");
            }
            if (SignPracticeCreationScreen$lambda$0(state).isLoading()) {
                composer.startReplaceGroup(-1574665848);
                ComposerKt.sourceInformation(composer, "104@4968L99");
                CircularProgressIndicatorComponentKt.CircularProgressComponent(PaddingKt.padding(Modifier.Companion, paddingValues), composer, 0, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1574203421);
                ComposerKt.sourceInformation(composer, "122@5648L10337,116@5390L10595");
                if (!SignPracticeCreationScreen$lambda$0(state).isGenerating()) {
                    composer.startReplaceGroup(-1579585021);
                } else {
                    composer.startReplaceGroup(-1574494139);
                    ComposerKt.sourceInformation(composer, "110@5222L2,111@5254L91,109@5141L222");
                    ComposerKt.sourceInformationMarkerStart(composer, -1574807871, "CC(remember):SignPracticeCreationScreen.kt#9igjgp");
                    Object objRememberedValue = composer.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreenKt$$ExternalSyntheticLambda21
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    CircularProgressIndicatorDialogComponentKt.CircularProgressIndicatorDialogComponent(null, (Function0) objRememberedValue, StringResources_androidKt.stringResource(R.string.global_label_loading, composer, 0), composer, 48, 1);
                }
                composer.endReplaceGroup();
                Modifier modifier = PaddingKt.padding-VpY3zN4$default(PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), paddingValues), Dp.constructor-impl(16), 0.0f, 2, (Object) null);
                Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
                ComposerKt.sourceInformationMarkerStart(composer, -1574783904, "CC(remember):SignPracticeCreationScreen.kt#9igjgp");
                boolean zChanged = composer.changed(state) | composer.changedInstance(signPracticeCreationViewModel);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreenKt$$ExternalSyntheticLambda23
                        public final Object invoke(Object obj) {
                            return SignPracticeCreationScreenKt.SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62(state, signPracticeCreationViewModel, (LazyListScope) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                LazyDslKt.LazyColumn(modifier, (LazyListState) null, (PaddingValues) null, false, (Arrangement.Vertical) null, centerHorizontally, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) objRememberedValue2, composer, 196608, 478);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62(final State state, final SignPracticeCreationViewModel signPracticeCreationViewModel, LazyListScope lazyListScope) {
        Intrinsics.checkNotNullParameter(lazyListScope, "$this$LazyColumn");
        LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1426872218, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreenKt$$ExternalSyntheticLambda5
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SignPracticeCreationScreenKt.SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$18(state, signPracticeCreationViewModel, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, (Object) null);
        LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(735535375, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreenKt$$ExternalSyntheticLambda6
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SignPracticeCreationScreenKt.SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$27(signPracticeCreationViewModel, state, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, (Object) null);
        LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(967203886, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreenKt$$ExternalSyntheticLambda7
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SignPracticeCreationScreenKt.SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$36(signPracticeCreationViewModel, state, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, (Object) null);
        LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(1198872397, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreenKt$$ExternalSyntheticLambda8
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SignPracticeCreationScreenKt.SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$45(signPracticeCreationViewModel, state, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, (Object) null);
        LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(1430540908, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreenKt$$ExternalSyntheticLambda9
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SignPracticeCreationScreenKt.SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$54(signPracticeCreationViewModel, state, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, (Object) null);
        LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(1662209419, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreenKt$$ExternalSyntheticLambda10
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SignPracticeCreationScreenKt.SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$61(signPracticeCreationViewModel, state, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$18(final State state, final SignPracticeCreationViewModel signPracticeCreationViewModel, LazyItemScope lazyItemScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(lazyItemScope, "$this$item");
        ComposerKt.sourceInformation(composer, "C124@5693L41,126@5813L59,127@5928L13,125@5755L208,129@5984L40,134@6285L829,130@6045L1069,151@7135L41:SignPracticeCreationScreen.kt#1lejub");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1426872218, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SignPracticeCreationScreen.kt:124)");
            }
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), composer, 6);
            String strStringResource = StringResources_androidKt.stringResource(R.string.sign_practice_create_label_domains, composer, 0);
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(composer, -1129625837, "CC(remember):SignPracticeCreationScreen.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreenKt$$ExternalSyntheticLambda39
                    public final Object invoke(Object obj) {
                        return SignPracticeCreationScreenKt.SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$18$lambda$11$lambda$10((SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SignCreationSectionTitleKt.SignCreationSectionTitle(strStringResource, SemanticsModifierKt.semantics$default(modifier, false, (Function1) objRememberedValue, 1, (Object) null), composer, 0, 0);
            float f = 8;
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), composer, 6);
            FlowLayoutKt.FlowRow(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(f)), Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(f)), (Alignment.Vertical) null, 0, 0, ComposableLambdaKt.rememberComposableLambda(1895530081, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreenKt$$ExternalSyntheticLambda40
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SignPracticeCreationScreenKt.SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$18$lambda$17(state, signPracticeCreationViewModel, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 1573302, 56);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$18$lambda$11$lambda$10(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.heading(semanticsPropertyReceiver);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$18$lambda$17(State state, final SignPracticeCreationViewModel signPracticeCreationViewModel, FlowRowScope flowRowScope, Composer composer, int i) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(flowRowScope, "$this$FlowRow");
        ComposerKt.sourceInformation(composer2, "C*138@6491L57,139@6590L27,140@6665L371,136@6375L691:SignPracticeCreationScreen.kt#1lejub");
        boolean z = true;
        if (!composer2.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1895530081, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SignPracticeCreationScreen.kt:135)");
            }
            for (final SignPracticeDomain signPracticeDomain : SignPracticeCreationScreen$lambda$0(state).getDomains()) {
                boolean zIsSelected = signPracticeDomain.isSelected();
                ComposerKt.sourceInformationMarkerStart(composer2, -840054017, "CC(remember):SignPracticeCreationScreen.kt#9igjgp");
                boolean zChangedInstance = composer2.changedInstance(signPracticeCreationViewModel) | composer2.changed(signPracticeDomain);
                Object objRememberedValue = composer2.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreenKt$$ExternalSyntheticLambda29
                        public final Object invoke() {
                            return SignPracticeCreationScreenKt.SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$18$lambda$17$lambda$16$lambda$13$lambda$12(signPracticeCreationViewModel, signPracticeDomain);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ChipKt.FilterChip(zIsSelected, (Function0) objRememberedValue, ComposableLambdaKt.rememberComposableLambda(1047177721, z, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreenKt$$ExternalSyntheticLambda30
                    public final Object invoke(Object obj, Object obj2) {
                        return SignPracticeCreationScreenKt.SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$18$lambda$17$lambda$16$lambda$14(signPracticeDomain, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54), (Modifier) null, false, ComposableLambdaKt.rememberComposableLambda(-2143278916, z, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreenKt$$ExternalSyntheticLambda31
                    public final Object invoke(Object obj, Object obj2) {
                        return SignPracticeCreationScreenKt.SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$18$lambda$17$lambda$16$lambda$15(signPracticeDomain, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54), (Function2) null, (Shape) null, (SelectableChipColors) null, (SelectableChipElevation) null, (BorderStroke) null, (MutableInteractionSource) null, composer2, 196992, 0, 4056);
                composer2 = composer;
                z = z;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$18$lambda$17$lambda$16$lambda$13$lambda$12(SignPracticeCreationViewModel signPracticeCreationViewModel, SignPracticeDomain signPracticeDomain) {
        signPracticeCreationViewModel.selectDomain(signPracticeDomain.getId());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$18$lambda$17$lambda$16$lambda$14(SignPracticeDomain signPracticeDomain, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C139@6592L23:SignPracticeCreationScreen.kt#1lejub");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1047177721, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SignPracticeCreationScreen.kt:139)");
            }
            TextKt.Text-Nvy7gAk(signPracticeDomain.getDomainName(), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$18$lambda$17$lambda$16$lambda$15(SignPracticeDomain signPracticeDomain, Composer composer, int i) {
        Composer composer2;
        ComposerKt.sourceInformation(composer, "C:SignPracticeCreationScreen.kt#1lejub");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2143278916, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SignPracticeCreationScreen.kt:141)");
            }
            if (!signPracticeDomain.isSelected()) {
                composer2 = composer;
                composer2.startReplaceGroup(-1444976890);
            } else {
                composer.startReplaceGroup(-1438295150);
                ComposerKt.sourceInformation(composer, "142@6768L196");
                composer2 = composer;
                IconKt.Icon-ww6aTOc(CheckKt.getCheck(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, 0L, composer2, 48, 12);
            }
            composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$27(final SignPracticeCreationViewModel signPracticeCreationViewModel, final State state, LazyItemScope lazyItemScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(lazyItemScope, "$this$item");
        ComposerKt.sourceInformation(composer, "C155@7239L41,157@7359L114,160@7529L13,156@7301L263,162@7585L40,169@7962L862,163@7646L1178,186@8845L41:SignPracticeCreationScreen.kt#1lejub");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(735535375, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SignPracticeCreationScreen.kt:155)");
            }
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), composer, 6);
            String strStringResource = StringResources_androidKt.stringResource(R.string.sign_practice_create_label_language, composer, 0);
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(composer, -1820098468, "CC(remember):SignPracticeCreationScreen.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreenKt$$ExternalSyntheticLambda24
                    public final Object invoke(Object obj) {
                        return SignPracticeCreationScreenKt.SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$27$lambda$20$lambda$19((SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SignCreationSectionTitleKt.SignCreationSectionTitle(strStringResource, SemanticsModifierKt.semantics$default(modifier, false, (Function1) objRememberedValue, 1, (Object) null), composer, 0, 0);
            float f = 8;
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), composer, 6);
            FlowLayoutKt.FlowRow(SelectableGroupKt.selectableGroup(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null)), Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(f)), Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(f)), (Alignment.Vertical) null, 0, 0, ComposableLambdaKt.rememberComposableLambda(-1891523510, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreenKt$$ExternalSyntheticLambda25
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SignPracticeCreationScreenKt.SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$27$lambda$26(signPracticeCreationViewModel, state, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 1573302, 56);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$27$lambda$20$lambda$19(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.heading(semanticsPropertyReceiver);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$27$lambda$26(final SignPracticeCreationViewModel signPracticeCreationViewModel, final State state, FlowRowScope flowRowScope, Composer composer, int i) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(flowRowScope, "$this$FlowRow");
        ComposerKt.sourceInformation(composer2, "C*173@8186L58,174@8286L30,175@8364L382,171@8059L717:SignPracticeCreationScreen.kt#1lejub");
        boolean z = true;
        if (!composer2.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1891523510, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SignPracticeCreationScreen.kt:170)");
            }
            for (final LanguageEnum languageEnum : LanguageEnum.getEntries()) {
                boolean z2 = languageEnum == SignPracticeCreationScreen$lambda$0(state).getLanguage() ? z : false;
                ComposerKt.sourceInformationMarkerStart(composer2, -284490836, "CC(remember):SignPracticeCreationScreen.kt#9igjgp");
                boolean zChangedInstance = composer2.changedInstance(signPracticeCreationViewModel) | composer2.changed(languageEnum.ordinal());
                Object objRememberedValue = composer2.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreenKt$$ExternalSyntheticLambda36
                        public final Object invoke() {
                            return SignPracticeCreationScreenKt.SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$27$lambda$26$lambda$25$lambda$22$lambda$21(signPracticeCreationViewModel, languageEnum);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ChipKt.FilterChip(z2, (Function0) objRememberedValue, ComposableLambdaKt.rememberComposableLambda(44877189, z, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreenKt$$ExternalSyntheticLambda37
                    public final Object invoke(Object obj, Object obj2) {
                        return SignPracticeCreationScreenKt.SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$27$lambda$26$lambda$25$lambda$23(languageEnum, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54), (Modifier) null, false, ComposableLambdaKt.rememberComposableLambda(423501256, z, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreenKt$$ExternalSyntheticLambda38
                    public final Object invoke(Object obj, Object obj2) {
                        return SignPracticeCreationScreenKt.SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$27$lambda$26$lambda$25$lambda$24(languageEnum, state, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54), (Function2) null, (Shape) null, (SelectableChipColors) null, (SelectableChipElevation) null, (BorderStroke) null, (MutableInteractionSource) null, composer2, 196992, 0, 4056);
                composer2 = composer;
                z = z;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$27$lambda$26$lambda$25$lambda$22$lambda$21(SignPracticeCreationViewModel signPracticeCreationViewModel, LanguageEnum languageEnum) {
        signPracticeCreationViewModel.selectLanguage(languageEnum);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$27$lambda$26$lambda$25$lambda$23(LanguageEnum languageEnum, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C174@8288L26:SignPracticeCreationScreen.kt#1lejub");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(44877189, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SignPracticeCreationScreen.kt:174)");
            }
            TextKt.Text-Nvy7gAk(languageEnum.getDisplayText(), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$27$lambda$26$lambda$25$lambda$24(LanguageEnum languageEnum, State state, Composer composer, int i) {
        Composer composer2;
        ComposerKt.sourceInformation(composer, "C:SignPracticeCreationScreen.kt#1lejub");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(423501256, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SignPracticeCreationScreen.kt:176)");
            }
            if (languageEnum != SignPracticeCreationScreen$lambda$0(state).getLanguage()) {
                composer2 = composer;
                composer2.startReplaceGroup(-2096296230);
            } else {
                composer.startReplaceGroup(-2087918170);
                ComposerKt.sourceInformation(composer, "177@8478L196");
                composer2 = composer;
                IconKt.Icon-ww6aTOc(CheckKt.getCheck(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, 0L, composer2, 48, 12);
            }
            composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$36(final SignPracticeCreationViewModel signPracticeCreationViewModel, final State state, LazyItemScope lazyItemScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(lazyItemScope, "$this$item");
        ComposerKt.sourceInformation(composer, "C190@8949L41,192@9069L110,195@9235L13,191@9011L259,197@9291L40,204@9668L853,198@9352L1169,221@10542L41:SignPracticeCreationScreen.kt#1lejub");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(967203886, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SignPracticeCreationScreen.kt:190)");
            }
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), composer, 6);
            String strStringResource = StringResources_androidKt.stringResource(R.string.sign_practice_create_label_type, composer, 0);
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(composer, 1770008379, "CC(remember):SignPracticeCreationScreen.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreenKt$$ExternalSyntheticLambda19
                    public final Object invoke(Object obj) {
                        return SignPracticeCreationScreenKt.SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$36$lambda$29$lambda$28((SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SignCreationSectionTitleKt.SignCreationSectionTitle(strStringResource, SemanticsModifierKt.semantics$default(modifier, false, (Function1) objRememberedValue, 1, (Object) null), composer, 0, 0);
            float f = 8;
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), composer, 6);
            FlowLayoutKt.FlowRow(SelectableGroupKt.selectableGroup(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null)), Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(f)), Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(f)), (Alignment.Vertical) null, 0, 0, ComposableLambdaKt.rememberComposableLambda(-1659854999, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreenKt$$ExternalSyntheticLambda20
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SignPracticeCreationScreenKt.SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$36$lambda$35(signPracticeCreationViewModel, state, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 1573302, 56);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$36$lambda$29$lambda$28(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.heading(semanticsPropertyReceiver);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$36$lambda$35(final SignPracticeCreationViewModel signPracticeCreationViewModel, final State state, FlowRowScope flowRowScope, Composer composer, int i) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(flowRowScope, "$this$FlowRow");
        ComposerKt.sourceInformation(composer2, "C*208@9884L50,209@9976L45,210@10069L374,206@9765L708:SignPracticeCreationScreen.kt#1lejub");
        boolean z = true;
        if (!composer2.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1659854999, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SignPracticeCreationScreen.kt:205)");
            }
            for (final SignPracticeType signPracticeType : SignPracticeType.getEntries()) {
                boolean z2 = signPracticeType == SignPracticeCreationScreen$lambda$0(state).getType() ? z : false;
                ComposerKt.sourceInformationMarkerStart(composer2, -209923350, "CC(remember):SignPracticeCreationScreen.kt#9igjgp");
                boolean zChangedInstance = composer2.changedInstance(signPracticeCreationViewModel) | composer2.changed(signPracticeType.ordinal());
                Object objRememberedValue = composer2.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreenKt$$ExternalSyntheticLambda16
                        public final Object invoke() {
                            return SignPracticeCreationScreenKt.SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$36$lambda$35$lambda$34$lambda$31$lambda$30(signPracticeCreationViewModel, signPracticeType);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ChipKt.FilterChip(z2, (Function0) objRememberedValue, ComposableLambdaKt.rememberComposableLambda(1432190539, z, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreenKt$$ExternalSyntheticLambda17
                    public final Object invoke(Object obj, Object obj2) {
                        return SignPracticeCreationScreenKt.SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$36$lambda$35$lambda$34$lambda$32(signPracticeType, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54), (Modifier) null, false, ComposableLambdaKt.rememberComposableLambda(-1758266098, z, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreenKt$$ExternalSyntheticLambda18
                    public final Object invoke(Object obj, Object obj2) {
                        return SignPracticeCreationScreenKt.SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$36$lambda$35$lambda$34$lambda$33(signPracticeType, state, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54), (Function2) null, (Shape) null, (SelectableChipColors) null, (SelectableChipElevation) null, (BorderStroke) null, (MutableInteractionSource) null, composer2, 196992, 0, 4056);
                composer2 = composer;
                z = z;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$36$lambda$35$lambda$34$lambda$31$lambda$30(SignPracticeCreationViewModel signPracticeCreationViewModel, SignPracticeType signPracticeType) {
        signPracticeCreationViewModel.selectType(signPracticeType);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$36$lambda$35$lambda$34$lambda$32(SignPracticeType signPracticeType, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C209@9983L35,209@9978L41:SignPracticeCreationScreen.kt#1lejub");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1432190539, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SignPracticeCreationScreen.kt:209)");
            }
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(signPracticeType.getDisplayNameRes(), composer, 0), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$36$lambda$35$lambda$34$lambda$33(SignPracticeType signPracticeType, State state, Composer composer, int i) {
        Composer composer2;
        ComposerKt.sourceInformation(composer, "C:SignPracticeCreationScreen.kt#1lejub");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1758266098, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SignPracticeCreationScreen.kt:211)");
            }
            if (signPracticeType != SignPracticeCreationScreen$lambda$0(state).getType()) {
                composer2 = composer;
                composer2.startReplaceGroup(905827060);
            } else {
                composer.startReplaceGroup(915888544);
                ComposerKt.sourceInformation(composer, "212@10175L196");
                composer2 = composer;
                IconKt.Icon-ww6aTOc(CheckKt.getCheck(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, 0L, composer2, 48, 12);
            }
            composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$45(final SignPracticeCreationViewModel signPracticeCreationViewModel, final State state, LazyItemScope lazyItemScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(lazyItemScope, "$this$item");
        ComposerKt.sourceInformation(composer, "C225@10646L41,227@10766L112,230@10934L13,226@10708L261,232@10990L40,239@11367L1169,233@11051L1485,262@12557L41:SignPracticeCreationScreen.kt#1lejub");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1198872397, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SignPracticeCreationScreen.kt:225)");
            }
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), composer, 6);
            String strStringResource = StringResources_androidKt.stringResource(R.string.sign_practice_create_label_length, composer, 0);
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(composer, 1065148122, "CC(remember):SignPracticeCreationScreen.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreenKt$$ExternalSyntheticLambda22
                    public final Object invoke(Object obj) {
                        return SignPracticeCreationScreenKt.SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$45$lambda$38$lambda$37((SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SignCreationSectionTitleKt.SignCreationSectionTitle(strStringResource, SemanticsModifierKt.semantics$default(modifier, false, (Function1) objRememberedValue, 1, (Object) null), composer, 0, 0);
            float f = 8;
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), composer, 6);
            FlowLayoutKt.FlowRow(SelectableGroupKt.selectableGroup(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null)), Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(f)), Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(f)), (Alignment.Vertical) null, 0, 0, ComposableLambdaKt.rememberComposableLambda(-1428186488, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreenKt$$ExternalSyntheticLambda33
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SignPracticeCreationScreenKt.SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$45$lambda$44(signPracticeCreationViewModel, state, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 1573302, 56);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$45$lambda$38$lambda$37(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.heading(semanticsPropertyReceiver);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$45$lambda$44(final SignPracticeCreationViewModel signPracticeCreationViewModel, final State state, FlowRowScope flowRowScope, Composer composer, int i) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(flowRowScope, "$this$FlowRow");
        ComposerKt.sourceInformation(composer2, "C*243@11603L60,244@11705L321,251@12074L384,241@11474L1014:SignPracticeCreationScreen.kt#1lejub");
        boolean z = true;
        if (!composer2.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1428186488, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SignPracticeCreationScreen.kt:240)");
            }
            for (final SignPracticeWordCount signPracticeWordCount : SignPracticeWordCount.getEntries()) {
                boolean z2 = signPracticeWordCount == SignPracticeCreationScreen$lambda$0(state).getWordCount() ? z : false;
                ComposerKt.sourceInformationMarkerStart(composer2, 210417838, "CC(remember):SignPracticeCreationScreen.kt#9igjgp");
                boolean zChangedInstance = composer2.changedInstance(signPracticeCreationViewModel) | composer2.changed(signPracticeWordCount.ordinal());
                Object objRememberedValue = composer2.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreenKt$$ExternalSyntheticLambda13
                        public final Object invoke() {
                            return SignPracticeCreationScreenKt.SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$45$lambda$44$lambda$43$lambda$40$lambda$39(signPracticeCreationViewModel, signPracticeWordCount);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ChipKt.FilterChip(z2, (Function0) objRememberedValue, ComposableLambdaKt.rememberComposableLambda(-707418593, z, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreenKt$$ExternalSyntheticLambda14
                    public final Object invoke(Object obj, Object obj2) {
                        return SignPracticeCreationScreenKt.SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$45$lambda$44$lambda$43$lambda$41(signPracticeWordCount, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54), (Modifier) null, false, ComposableLambdaKt.rememberComposableLambda(-1065359044, z, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreenKt$$ExternalSyntheticLambda15
                    public final Object invoke(Object obj, Object obj2) {
                        return SignPracticeCreationScreenKt.SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$45$lambda$44$lambda$43$lambda$42(signPracticeWordCount, state, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54), (Function2) null, (Shape) null, (SelectableChipColors) null, (SelectableChipElevation) null, (BorderStroke) null, (MutableInteractionSource) null, composer2, 196992, 0, 4056);
                composer2 = composer;
                z = z;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$45$lambda$44$lambda$43$lambda$40$lambda$39(SignPracticeCreationViewModel signPracticeCreationViewModel, SignPracticeWordCount signPracticeWordCount) {
        signPracticeCreationViewModel.selectWordCount(signPracticeWordCount);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$45$lambda$44$lambda$43$lambda$41(SignPracticeWordCount signPracticeWordCount, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C245@11749L241,244@11707L317:SignPracticeCreationScreen.kt#1lejub");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-707418593, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SignPracticeCreationScreen.kt:244)");
            }
            TextKt.Text-Nvy7gAk(StringResources_androidKt.pluralStringResource(R.plurals.global_word_count, signPracticeWordCount.getCount(), new Object[]{Integer.valueOf(signPracticeWordCount.getCount())}, composer, 0), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$45$lambda$44$lambda$43$lambda$42(SignPracticeWordCount signPracticeWordCount, State state, Composer composer, int i) {
        Composer composer2;
        ComposerKt.sourceInformation(composer, "C:SignPracticeCreationScreen.kt#1lejub");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1065359044, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SignPracticeCreationScreen.kt:252)");
            }
            if (signPracticeWordCount != SignPracticeCreationScreen$lambda$0(state).getWordCount()) {
                composer2 = composer;
                composer2.startReplaceGroup(1685059238);
            } else {
                composer.startReplaceGroup(1697119602);
                ComposerKt.sourceInformation(composer, "253@12190L196");
                composer2 = composer;
                IconKt.Icon-ww6aTOc(CheckKt.getCheck(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, 0L, composer2, 48, 12);
            }
            composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$54(final SignPracticeCreationViewModel signPracticeCreationViewModel, final State state, LazyItemScope lazyItemScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(lazyItemScope, "$this$item");
        ComposerKt.sourceInformation(composer, "C267@12719L116,270@12891L13,266@12661L265,272@12947L40,279@13324L1001,273@13008L1317,298@14346L41:SignPracticeCreationScreen.kt#1lejub");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1430540908, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SignPracticeCreationScreen.kt:266)");
            }
            String strStringResource = StringResources_androidKt.stringResource(R.string.sign_practice_create_label_complexity, composer, 0);
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(composer, 360285945, "CC(remember):SignPracticeCreationScreen.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreenKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        return SignPracticeCreationScreenKt.SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$54$lambda$47$lambda$46((SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SignCreationSectionTitleKt.SignCreationSectionTitle(strStringResource, SemanticsModifierKt.semantics$default(modifier, false, (Function1) objRememberedValue, 1, (Object) null), composer, 0, 0);
            float f = 8;
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), composer, 6);
            FlowLayoutKt.FlowRow(SelectableGroupKt.selectableGroup(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null)), Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(f)), Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(f)), (Alignment.Vertical) null, 0, 0, ComposableLambdaKt.rememberComposableLambda(-1196517977, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreenKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SignPracticeCreationScreenKt.SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$54$lambda$53(signPracticeCreationViewModel, state, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 1573302, 56);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$54$lambda$47$lambda$46(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.heading(semanticsPropertyReceiver);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$54$lambda$53(final SignPracticeCreationViewModel signPracticeCreationViewModel, final State state, FlowRowScope flowRowScope, Composer composer, int i) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(flowRowScope, "$this$FlowRow");
        ComposerKt.sourceInformation(composer2, "C*283@13572L140,286@13754L51,287@13853L394,281@13433L844:SignPracticeCreationScreen.kt#1lejub");
        boolean z = true;
        if (!composer2.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1196517977, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SignPracticeCreationScreen.kt:280)");
            }
            for (final SignPracticeComplexity signPracticeComplexity : SignPracticeComplexity.getEntries()) {
                boolean z2 = signPracticeComplexity == SignPracticeCreationScreen$lambda$0(state).getPracticeComplexity() ? z : false;
                ComposerKt.sourceInformationMarkerStart(composer2, 2116231230, "CC(remember):SignPracticeCreationScreen.kt#9igjgp");
                boolean zChangedInstance = composer2.changedInstance(signPracticeCreationViewModel) | composer2.changed(signPracticeComplexity.ordinal());
                Object objRememberedValue = composer2.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreenKt$$ExternalSyntheticLambda32
                        public final Object invoke() {
                            return SignPracticeCreationScreenKt.SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$54$lambda$53$lambda$52$lambda$49$lambda$48(signPracticeCreationViewModel, signPracticeComplexity);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ChipKt.FilterChip(z2, (Function0) objRememberedValue, ComposableLambdaKt.rememberComposableLambda(1752562757, z, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreenKt$$ExternalSyntheticLambda34
                    public final Object invoke(Object obj, Object obj2) {
                        return SignPracticeCreationScreenKt.SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$54$lambda$53$lambda$52$lambda$50(signPracticeComplexity, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54), (Modifier) null, false, ComposableLambdaKt.rememberComposableLambda(-753656632, z, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreenKt$$ExternalSyntheticLambda35
                    public final Object invoke(Object obj, Object obj2) {
                        return SignPracticeCreationScreenKt.SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$54$lambda$53$lambda$52$lambda$51(signPracticeComplexity, state, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54), (Function2) null, (Shape) null, (SelectableChipColors) null, (SelectableChipElevation) null, (BorderStroke) null, (MutableInteractionSource) null, composer2, 196992, 0, 4056);
                composer2 = composer;
                z = z;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$54$lambda$53$lambda$52$lambda$49$lambda$48(SignPracticeCreationViewModel signPracticeCreationViewModel, SignPracticeComplexity signPracticeComplexity) {
        signPracticeCreationViewModel.onPracticeComplexityChange(signPracticeComplexity);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$54$lambda$53$lambda$52$lambda$50(SignPracticeComplexity signPracticeComplexity, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C286@13761L41,286@13756L47:SignPracticeCreationScreen.kt#1lejub");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1752562757, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SignPracticeCreationScreen.kt:286)");
            }
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(signPracticeComplexity.getDisplayNameRes(), composer, 0), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$54$lambda$53$lambda$52$lambda$51(SignPracticeComplexity signPracticeComplexity, State state, Composer composer, int i) {
        Composer composer2;
        ComposerKt.sourceInformation(composer, "C:SignPracticeCreationScreen.kt#1lejub");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-753656632, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SignPracticeCreationScreen.kt:288)");
            }
            if (signPracticeComplexity != SignPracticeCreationScreen$lambda$0(state).getPracticeComplexity()) {
                composer2 = composer;
                composer2.startReplaceGroup(1890556410);
            } else {
                composer.startReplaceGroup(1904391462);
                ComposerKt.sourceInformation(composer, "289@13979L196");
                composer2 = composer;
                IconKt.Icon-ww6aTOc(CheckKt.getCheck(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, 0L, composer2, 48, 12);
            }
            composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$61(final SignPracticeCreationViewModel signPracticeCreationViewModel, State state, LazyItemScope lazyItemScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(lazyItemScope, "$this$item");
        ComposerKt.sourceInformation(composer, "C303@14508L113,306@14677L13,302@14450L262,308@14733L41,310@14862L110,314@15068L110,309@14795L505,320@15321L41,322@15450L111,326@15658L111,321@15383L508,332@15912L41:SignPracticeCreationScreen.kt#1lejub");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1662209419, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SignPracticeCreationScreen.kt:302)");
            }
            String strStringResource = StringResources_androidKt.stringResource(R.string.sign_practice_create_label_details, composer, 0);
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(composer, -344574472, "CC(remember):SignPracticeCreationScreen.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreenKt$$ExternalSyntheticLambda26
                    public final Object invoke(Object obj) {
                        return SignPracticeCreationScreenKt.SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$61$lambda$56$lambda$55((SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SignCreationSectionTitleKt.SignCreationSectionTitle(strStringResource, SemanticsModifierKt.semantics$default(modifier, false, (Function1) objRememberedValue, 1, (Object) null), composer, 0, 0);
            float f = 16;
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), composer, 6);
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.sign_practice_create_label_name, composer, 0);
            String practiceName = SignPracticeCreationScreen$lambda$0(state).getPracticeName();
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, -344561863, "CC(remember):SignPracticeCreationScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(signPracticeCreationViewModel);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreenKt$$ExternalSyntheticLambda27
                    public final Object invoke(Object obj) {
                        return SignPracticeCreationScreenKt.SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$61$lambda$58$lambda$57(signPracticeCreationViewModel, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            CharacterLimitedOutlinedTextFieldKt.CharacterLimitedOutlinedTextField(practiceName, (Function1) objRememberedValue2, strStringResource2, 30, modifierFillMaxWidth$default, false, null, null, composer, 27648, 224);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), composer, 6);
            String strStringResource3 = StringResources_androidKt.stringResource(R.string.sign_practice_create_label_topic, composer, 0);
            String practiceTopic = SignPracticeCreationScreen$lambda$0(state).getPracticeTopic();
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, -344542982, "CC(remember):SignPracticeCreationScreen.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(signPracticeCreationViewModel);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreenKt$$ExternalSyntheticLambda28
                    public final Object invoke(Object obj) {
                        return SignPracticeCreationScreenKt.SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$61$lambda$60$lambda$59(signPracticeCreationViewModel, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            CharacterLimitedOutlinedTextFieldKt.CharacterLimitedOutlinedTextField(practiceTopic, (Function1) objRememberedValue3, strStringResource3, 85, modifierFillMaxWidth$default2, false, null, null, composer, 27648, 224);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$61$lambda$56$lambda$55(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.heading(semanticsPropertyReceiver);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$61$lambda$58$lambda$57(SignPracticeCreationViewModel signPracticeCreationViewModel, String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        signPracticeCreationViewModel.onPracticeNameChange(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeCreationScreen$lambda$64$lambda$63$lambda$62$lambda$61$lambda$60$lambda$59(SignPracticeCreationViewModel signPracticeCreationViewModel, String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        signPracticeCreationViewModel.onPracticeTopicChange(str);
        return Unit.INSTANCE;
    }

    private static final SignPracticeCreationUiState SignPracticeCreationScreen$lambda$0(State<SignPracticeCreationUiState> state) {
        return (SignPracticeCreationUiState) state.getValue();
    }
}
