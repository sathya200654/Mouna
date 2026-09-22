package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens;

import android.content.Context;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.BookKt;
import androidx.compose.material3.FabPosition;
import androidx.compose.material3.FloatingActionButtonElevation;
import androidx.compose.material3.FloatingActionButtonKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SnackbarHostKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.recyclerview.widget.RecyclerView;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.DateFilterRange;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.ListSortOrder;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.CircularProgressIndicatorComponentKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.DateRangePickerDialogKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.EmptyContentComponentKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.GenericConfirmationDialogKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBarKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPractice;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.SignPracticeCardKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeListUiEvent;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeListUiState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeListViewModel;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.SharedFlow;

/* JADX INFO: compiled from: SignPracticeListScreen.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\u001a`\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00010\nH\u0007¢\u0006\u0002\u0010\u000f¨\u0006\u0010²\u0006\n\u0010\u0011\u001a\u00020\u0012X\u008a\u0084\u0002"}, d2 = {"SignPracticeListScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "signPracticeListViewModel", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/viewmodels/SignPracticeListViewModel;", "onDrawerClick", "Lkotlin/Function0;", "navigateToSignPracticeCreation", "navigateToSingPracticeSession", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "practiceId", "(Landroidx/compose/ui/Modifier;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/viewmodels/SignPracticeListViewModel;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "app_release", "uiState", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/viewmodels/SignPracticeListUiState;"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SignPracticeListScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeListScreen$lambda$35(Modifier modifier, SignPracticeListViewModel signPracticeListViewModel, Function0 function0, Function0 function1, Function1 function2, int i, int i2, Composer composer, int i3) {
        SignPracticeListScreen(modifier, signPracticeListViewModel, function0, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void SignPracticeListScreen(Modifier modifier, SignPracticeListViewModel signPracticeListViewModel, final Function0<Unit> function0, final Function0<Unit> function1, final Function1<? super Long, Unit> function2, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        SignPracticeListViewModel signPracticeListViewModel2;
        Composer composer2;
        final Modifier modifier3;
        final SignPracticeListViewModel signPracticeListViewModel3;
        boolean z;
        Composer composer3;
        Modifier modifier4;
        CreationExtras defaultViewModelCreationExtras;
        Intrinsics.checkNotNullParameter(function0, "onDrawerClick");
        Intrinsics.checkNotNullParameter(function1, "navigateToSignPracticeCreation");
        Intrinsics.checkNotNullParameter(function2, "navigateToSingPracticeSession");
        Composer composerStartRestartGroup = composer.startRestartGroup(1415590815);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SignPracticeListScreen)P(!1,4,3)48@2803L29,51@2911L34,52@2973L34,53@3036L32,55@3101L7,57@3138L316,57@3114L340,70@3487L958,107@4914L67,94@4478L348,111@5017L3591,69@3460L5148:SignPracticeListScreen.kt#1lejub");
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
                signPracticeListViewModel2 = signPracticeListViewModel;
                int i5 = composerStartRestartGroup.changedInstance(signPracticeListViewModel2) ? 32 : 16;
                i3 |= i5;
            } else {
                signPracticeListViewModel2 = signPracticeListViewModel;
            }
            i3 |= i5;
        } else {
            signPracticeListViewModel2 = signPracticeListViewModel;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "43@2588L15");
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
                modifier4 = modifier2;
                signPracticeListViewModel3 = signPracticeListViewModel2;
                z = false;
                composer3 = composerStartRestartGroup;
            } else {
                Modifier modifier5 = i4 != 0 ? (Modifier) Modifier.Companion : modifier2;
                if ((i2 & 2) != 0) {
                    composerStartRestartGroup.startReplaceableGroup(1890788296);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
                    HasDefaultViewModelProviderFactory current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, LocalViewModelStoreOwner.$stable);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                    }
                    z = false;
                    ViewModelProvider.Factory factoryCreateHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(1729797275);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        defaultViewModelCreationExtras = current.getDefaultViewModelCreationExtras();
                    } else {
                        defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    composer3 = composerStartRestartGroup;
                    ViewModel viewModel = ViewModelKt.viewModel(SignPracticeListViewModel.class, current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composer3, 36936, 0);
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    signPracticeListViewModel2 = (SignPracticeListViewModel) viewModel;
                    i3 &= -113;
                } else {
                    z = false;
                    composer3 = composerStartRestartGroup;
                }
                modifier4 = modifier5;
                signPracticeListViewModel3 = signPracticeListViewModel2;
            }
            composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1415590815, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeListScreen (SignPracticeListScreen.kt:47)");
            }
            Composer composer4 = composer3;
            final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(signPracticeListViewModel3.getUiState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composer4, 0, 7);
            SharedFlow<SignPracticeListUiEvent> uiEvent = signPracticeListViewModel3.getUiEvent();
            ComposerKt.sourceInformationMarkerStart(composer4, -1121844959, "CC(remember):SignPracticeListScreen.kt#9igjgp");
            Object objRememberedValue = composer4.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z), (SnapshotMutationPolicy) null, 2, (Object) null);
                composer4.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerStart(composer4, -1121842975, "CC(remember):SignPracticeListScreen.kt#9igjgp");
            Object objRememberedValue2 = composer4.rememberedValue();
            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z), (SnapshotMutationPolicy) null, 2, (Object) null);
                composer4.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerStart(composer4, -1121840961, "CC(remember):SignPracticeListScreen.kt#9igjgp");
            Object objRememberedValue3 = composer4.rememberedValue();
            if (objRememberedValue3 == Composer.Companion.getEmpty()) {
                objRememberedValue3 = new SnackbarHostState();
                composer4.updateRememberedValue(objRememberedValue3);
            }
            final SnackbarHostState snackbarHostState = (SnackbarHostState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer4);
            CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composer4, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer4.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            Context context = (Context) objConsume;
            ComposerKt.sourceInformationMarkerStart(composer4, -1121837413, "CC(remember):SignPracticeListScreen.kt#9igjgp");
            boolean zChangedInstance = composer4.changedInstance(uiEvent) | composer4.changedInstance(context);
            SignPracticeListScreenKt$SignPracticeListScreen$1$1 signPracticeListScreenKt$SignPracticeListScreen$1$1RememberedValue = composer4.rememberedValue();
            if (zChangedInstance || signPracticeListScreenKt$SignPracticeListScreen$1$1RememberedValue == Composer.Companion.getEmpty()) {
                signPracticeListScreenKt$SignPracticeListScreen$1$1RememberedValue = new SignPracticeListScreenKt$SignPracticeListScreen$1$1(uiEvent, snackbarHostState, context, null);
                composer4.updateRememberedValue(signPracticeListScreenKt$SignPracticeListScreen$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer4);
            EffectsKt.LaunchedEffect(uiEvent, (Function2) signPracticeListScreenKt$SignPracticeListScreen$1$1RememberedValue, composer4, 0);
            Modifier modifier6 = modifier4;
            composer2 = composer4;
            ScaffoldKt.Scaffold-TvnljyQ(modifier6, ComposableLambdaKt.rememberComposableLambda(303520355, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeListScreenKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    return SignPracticeListScreenKt.SignPracticeListScreen$lambda$15(function0, signPracticeListViewModel3, stateCollectAsStateWithLifecycle, mutableState2, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer4, 54), (Function2) null, ComposableLambdaKt.rememberComposableLambda(1599975269, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeListScreenKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    return SignPracticeListScreenKt.SignPracticeListScreen$lambda$16(snackbarHostState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer4, 54), ComposableLambdaKt.rememberComposableLambda(-2046764570, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeListScreenKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    return SignPracticeListScreenKt.SignPracticeListScreen$lambda$19(function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer4, 54), FabPosition.Companion.getEndOverlay-ERTFSPs(), 0L, 0L, (WindowInsets) null, ComposableLambdaKt.rememberComposableLambda(-1396993362, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeListScreenKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SignPracticeListScreenKt.SignPracticeListScreen$lambda$34(mutableState, signPracticeListViewModel3, mutableState2, stateCollectAsStateWithLifecycle, function2, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer4, 54), composer2, (i3 & 14) | 805334064, 452);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier6;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            signPracticeListViewModel3 = signPracticeListViewModel2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeListScreenKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    return SignPracticeListScreenKt.SignPracticeListScreen$lambda$35(modifier3, signPracticeListViewModel3, function0, function1, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeListScreen$lambda$15(final Function0 function0, final SignPracticeListViewModel signPracticeListViewModel, State state, final MutableState mutableState, final MutableState mutableState2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C73@3595L49,74@3685L55,77@3876L55,80@3965L69,83@4072L67,86@4177L105,89@4322L99,71@3501L934:SignPracticeListScreen.kt#1lejub");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(303520355, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeListScreen.<anonymous> (SignPracticeListScreen.kt:71)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            String strStringResource = StringResources_androidKt.stringResource(R.string.sign_practice_list_title, composer, 0);
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.sign_practice_list_search_hint, composer, 0);
            String searchQuery = SignPracticeListScreen$lambda$0(state).getSearchQuery();
            boolean zIsSelecting = SignPracticeListScreen$lambda$0(state).isSelecting();
            ComposerKt.sourceInformationMarkerStart(composer, -374702470, "CC(remember):SignPracticeListScreen.kt#9igjgp");
            boolean zChanged = composer.changed(function0);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeListScreenKt$$ExternalSyntheticLambda12
                    public final Object invoke() {
                        return SignPracticeListScreenKt.SignPracticeListScreen$lambda$15$lambda$6$lambda$5(function0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function1 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -374699608, "CC(remember):SignPracticeListScreen.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeListScreenKt$$ExternalSyntheticLambda13
                    public final Object invoke() {
                        return SignPracticeListScreenKt.SignPracticeListScreen$lambda$15$lambda$8$lambda$7(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function0 function2 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -374696186, "CC(remember):SignPracticeListScreen.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.Companion.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeListScreenKt$$ExternalSyntheticLambda14
                    public final Object invoke() {
                        return SignPracticeListScreenKt.SignPracticeListScreen$lambda$15$lambda$10$lambda$9(mutableState2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            Function0 function3 = (Function0) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -374692788, "CC(remember):SignPracticeListScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(signPracticeListViewModel);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue4 == Composer.Companion.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeListScreenKt$$ExternalSyntheticLambda15
                    public final Object invoke(Object obj) {
                        return SignPracticeListScreenKt.SignPracticeListScreen$lambda$15$lambda$12$lambda$11(signPracticeListViewModel, (ListSortOrder) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            Function1 function4 = (Function1) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -374688154, "CC(remember):SignPracticeListScreen.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(signPracticeListViewModel);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue5 == Composer.Companion.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeListScreenKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        return SignPracticeListScreenKt.SignPracticeListScreen$lambda$15$lambda$14$lambda$13(signPracticeListViewModel, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ListScreenTopBarKt.ListScreenTopBar(modifierFillMaxWidth$default, strStringResource, strStringResource2, searchQuery, zIsSelecting, function1, function2, function3, function4, (Function1) objRememberedValue5, composer, 14155782, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeListScreen$lambda$15$lambda$6$lambda$5(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeListScreen$lambda$15$lambda$8$lambda$7(MutableState mutableState) {
        mutableState.setValue(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeListScreen$lambda$15$lambda$10$lambda$9(MutableState mutableState) {
        mutableState.setValue(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeListScreen$lambda$15$lambda$12$lambda$11(SignPracticeListViewModel signPracticeListViewModel, ListSortOrder listSortOrder) {
        Intrinsics.checkNotNullParameter(listSortOrder, "sortOrder");
        signPracticeListViewModel.updateSortOrder(listSortOrder);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeListScreen$lambda$15$lambda$14$lambda$13(SignPracticeListViewModel signPracticeListViewModel, String str) {
        Intrinsics.checkNotNullParameter(str, "query");
        signPracticeListViewModel.updateSearchQuery(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeListScreen$lambda$19(final Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C96@4540L72,95@4492L324:SignPracticeListScreen.kt#1lejub");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2046764570, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeListScreen.<anonymous> (SignPracticeListScreen.kt:95)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 154271854, "CC(remember):SignPracticeListScreen.kt#9igjgp");
            boolean zChanged = composer.changed(function0);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeListScreenKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        return SignPracticeListScreenKt.SignPracticeListScreen$lambda$19$lambda$18$lambda$17(function0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FloatingActionButtonKt.FloatingActionButton-X-z6DiA((Function0) objRememberedValue, (Modifier) null, (Shape) null, 0L, 0L, (FloatingActionButtonElevation) null, (MutableInteractionSource) null, ComposableSingletons$SignPracticeListScreenKt.INSTANCE.getLambda$585790184$app_release(), composer, 12582912, 126);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeListScreen$lambda$19$lambda$18$lambda$17(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeListScreen$lambda$16(SnackbarHostState snackbarHostState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C108@4928L43:SignPracticeListScreen.kt#1lejub");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1599975269, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeListScreen.<anonymous> (SignPracticeListScreen.kt:108)");
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
    public static final Unit SignPracticeListScreen$lambda$34(final MutableState mutableState, final SignPracticeListViewModel signPracticeListViewModel, final MutableState mutableState2, final State state, final Function1 function1, PaddingValues paddingValues, Composer composer, int i) throws NoWhenBranchMatchedException {
        int i2;
        int i3;
        String str;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer2, "C113@5045L3557:SignPracticeListScreen.kt#1lejub");
        if ((i & 6) == 0) {
            i2 = i | (composer2.changed(paddingValues) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer2.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1396993362, i2, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeListScreen.<anonymous> (SignPracticeListScreen.kt:113)");
            }
            Modifier modifierPadding = PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), paddingValues);
            Arrangement.Vertical center = Arrangement.INSTANCE.getCenter();
            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composer2, 54);
            ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierPadding);
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
            Updater.set-impl(composer3, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer3, Integer.valueOf(iHashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer3, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 1338600109, "C:SignPracticeListScreen.kt#1lejub");
            if (!((Boolean) mutableState.getValue()).booleanValue()) {
                composer2.startReplaceGroup(1333241386);
            } else {
                composer2.startReplaceGroup(1338534760);
                ComposerKt.sourceInformation(composer2, "123@5462L105,126@5601L76,121@5341L354");
                Modifier modifier = PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8));
                ComposerKt.sourceInformationMarkerStart(composer2, 1567203361, "CC(remember):SignPracticeListScreen.kt#9igjgp");
                boolean zChangedInstance = composer2.changedInstance(signPracticeListViewModel);
                Object objRememberedValue = composer2.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeListScreenKt$$ExternalSyntheticLambda7
                        public final Object invoke(Object obj) {
                            return SignPracticeListScreenKt.SignPracticeListScreen$lambda$34$lambda$33$lambda$21$lambda$20(signPracticeListViewModel, (DateFilterRange) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                Function1 function2 = (Function1) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, 1567207780, "CC(remember):SignPracticeListScreen.kt#9igjgp");
                Object objRememberedValue2 = composer2.rememberedValue();
                if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeListScreenKt$$ExternalSyntheticLambda8
                        public final Object invoke() {
                            return SignPracticeListScreenKt.SignPracticeListScreen$lambda$34$lambda$33$lambda$23$lambda$22(mutableState);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                DateRangePickerDialogKt.DateRangePickerDialog(modifier, function2, (Function0) objRememberedValue2, composer2, 390, 0);
            }
            composer2.endReplaceGroup();
            if (!((Boolean) mutableState2.getValue()).booleanValue()) {
                i3 = 1;
                str = "CC(remember):SignPracticeListScreen.kt#9igjgp";
                composer2.startReplaceGroup(1333241386);
            } else {
                composer2.startReplaceGroup(1338970372);
                ComposerKt.sourceInformation(composer2, "134@5824L58,135@5918L57,143@6333L46,144@6415L46,136@6016L147,140@6202L95,133@5769L710");
                String strStringResource = StringResources_androidKt.stringResource(R.string.sign_practice_dialog_delete_title, composer2, 0);
                String strStringResource2 = StringResources_androidKt.stringResource(R.string.sign_practice_dialog_delete_desc, composer2, 0);
                String strStringResource3 = StringResources_androidKt.stringResource(R.string.global_action_confirm, composer2, 0);
                String strStringResource4 = StringResources_androidKt.stringResource(R.string.global_action_dismiss, composer2, 0);
                ComposerKt.sourceInformationMarkerStart(composer2, 1567221131, "CC(remember):SignPracticeListScreen.kt#9igjgp");
                boolean zChangedInstance2 = composer2.changedInstance(signPracticeListViewModel);
                Object objRememberedValue3 = composer2.rememberedValue();
                if (zChangedInstance2 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeListScreenKt$$ExternalSyntheticLambda9
                        public final Object invoke() {
                            return SignPracticeListScreenKt.SignPracticeListScreen$lambda$34$lambda$33$lambda$25$lambda$24(signPracticeListViewModel, mutableState2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                Function0 function0 = (Function0) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, 1567227031, "CC(remember):SignPracticeListScreen.kt#9igjgp");
                boolean zChangedInstance3 = composer2.changedInstance(signPracticeListViewModel);
                Object objRememberedValue4 = composer2.rememberedValue();
                if (zChangedInstance3 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                    objRememberedValue4 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeListScreenKt$$ExternalSyntheticLambda10
                        public final Object invoke() {
                            return SignPracticeListScreenKt.SignPracticeListScreen$lambda$34$lambda$33$lambda$27$lambda$26(signPracticeListViewModel);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                str = "CC(remember):SignPracticeListScreen.kt#9igjgp";
                i3 = 1;
                GenericConfirmationDialogKt.GenericConfirmationDialog(null, function0, (Function0) objRememberedValue4, strStringResource, strStringResource2, strStringResource3, strStringResource4, null, false, null, composer, 0, 897);
                composer2 = composer;
            }
            composer2.endReplaceGroup();
            boolean zIsLoading = SignPracticeListScreen$lambda$0(state).isLoading();
            if (zIsLoading == i3) {
                composer2.startReplaceGroup(1339749991);
                ComposerKt.sourceInformation(composer2, "150@6580L27");
                CircularProgressIndicatorComponentKt.CircularProgressComponent(null, composer2, 0, i3);
                composer2.endReplaceGroup();
            } else {
                if (zIsLoading) {
                    composer2.startReplaceGroup(1567238781);
                    composer2.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composer2.startReplaceGroup(1339899907);
                ComposerKt.sourceInformation(composer2, "");
                if (!SignPracticeListScreen$lambda$0(state).getSignPractices().isEmpty()) {
                    composer2.startReplaceGroup(1339947461);
                    ComposerKt.sourceInformation(composer2, "158@6952L1216,154@6739L1429");
                    Alignment.Horizontal centerHorizontally2 = Alignment.Companion.getCenterHorizontally();
                    Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, i3, (Object) null);
                    ComposerKt.sourceInformationMarkerStart(composer2, 1567252152, str);
                    boolean zChanged = composer2.changed(state) | composer2.changedInstance(signPracticeListViewModel) | composer2.changed(function1);
                    Object objRememberedValue5 = composer2.rememberedValue();
                    if (zChanged || objRememberedValue5 == Composer.Companion.getEmpty()) {
                        objRememberedValue5 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeListScreenKt$$ExternalSyntheticLambda11
                            public final Object invoke(Object obj) {
                                return SignPracticeListScreenKt.SignPracticeListScreen$lambda$34$lambda$33$lambda$32$lambda$31(state, signPracticeListViewModel, function1, (LazyListScope) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    LazyDslKt.LazyColumn(modifierFillMaxSize$default, (LazyListState) null, (PaddingValues) null, false, (Arrangement.Vertical) null, centerHorizontally2, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) objRememberedValue5, composer2, 196614, 478);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(1341384094);
                    ComposerKt.sourceInformation(composer2, "184@8457L55,180@8222L316");
                    EmptyContentComponentKt.EmptyContentComponent(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, i3, (Object) null), BookKt.getBook(Icons.INSTANCE.getDefault()), null, StringResources_androidKt.stringResource(R.string.sign_practice_list_empty_state, composer2, 0), composer2, 390, 0);
                    composer2.endReplaceGroup();
                }
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
    public static final Unit SignPracticeListScreen$lambda$34$lambda$33$lambda$21$lambda$20(SignPracticeListViewModel signPracticeListViewModel, DateFilterRange dateFilterRange) {
        Intrinsics.checkNotNullParameter(dateFilterRange, "range");
        signPracticeListViewModel.updateDateRange(dateFilterRange);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeListScreen$lambda$34$lambda$33$lambda$23$lambda$22(MutableState mutableState) {
        mutableState.setValue(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeListScreen$lambda$34$lambda$33$lambda$25$lambda$24(SignPracticeListViewModel signPracticeListViewModel, MutableState mutableState) {
        signPracticeListViewModel.clearSelectedIds();
        mutableState.setValue(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeListScreen$lambda$34$lambda$33$lambda$27$lambda$26(SignPracticeListViewModel signPracticeListViewModel) {
        signPracticeListViewModel.deleteSignPractices();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignPracticeListScreen$lambda$34$lambda$33$lambda$32$lambda$31(final State state, final SignPracticeListViewModel signPracticeListViewModel, final Function1 function1, LazyListScope lazyListScope) {
        Intrinsics.checkNotNullParameter(lazyListScope, "$this$LazyColumn");
        final List<SignPractice> signPractices = SignPracticeListScreen$lambda$0(state).getSignPractices();
        final SignPracticeListScreenKt$SignPracticeListScreen$lambda$34$lambda$33$lambda$32$lambda$31$$inlined$items$default$1 signPracticeListScreenKt$SignPracticeListScreen$lambda$34$lambda$33$lambda$32$lambda$31$$inlined$items$default$1 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeListScreenKt$SignPracticeListScreen$lambda$34$lambda$33$lambda$32$lambda$31$$inlined$items$default$1
            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final Void m1837invoke(SignPractice signPractice) {
                return null;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return m1837invoke((SignPractice) obj);
            }
        };
        lazyListScope.items(signPractices.size(), (Function1) null, new Function1<Integer, Object>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeListScreenKt$SignPracticeListScreen$lambda$34$lambda$33$lambda$32$lambda$31$$inlined$items$default$3
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Object invoke(int i) {
                return signPracticeListScreenKt$SignPracticeListScreen$lambda$34$lambda$33$lambda$32$lambda$31$$inlined$items$default$1.invoke(signPractices.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeListScreenKt$SignPracticeListScreen$lambda$34$lambda$33$lambda$32$lambda$31$$inlined$items$default$4
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                int i3;
                ComposerKt.sourceInformation(composer, "CN(it)178@8834L22:LazyDsl.kt#428nma");
                if ((i2 & 6) == 0) {
                    i3 = (composer.changed(lazyItemScope) ? 4 : 2) | i2;
                } else {
                    i3 = i2;
                }
                if ((i2 & 48) == 0) {
                    i3 |= composer.changed(i) ? 32 : 16;
                }
                if (!composer.shouldExecute((i3 & 147) != 146, i3 & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(802480018, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                final SignPractice signPractice = (SignPractice) signPractices.get(i);
                composer.startReplaceGroup(930106699);
                ComposerKt.sourceInformation(composer, "C*173@7933L145,165@7351L522,160@7061L1051:SignPracticeListScreen.kt#1lejub");
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart(composer, -1909632210, "CC(remember):SignPracticeListScreen.kt#9igjgp");
                boolean zChangedInstance = composer.changedInstance(signPracticeListViewModel) | composer.changedInstance(signPractice);
                Object objRememberedValue = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                    final SignPracticeListViewModel signPracticeListViewModel2 = signPracticeListViewModel;
                    objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeListScreenKt$SignPracticeListScreen$5$1$5$1$1$1$1
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m1835invoke();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m1835invoke() {
                            signPracticeListViewModel2.updateSelectedIds(signPractice.getId());
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Function0 function0 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -1909650457, "CC(remember):SignPracticeListScreen.kt#9igjgp");
                boolean zChanged = composer.changed(state) | composer.changedInstance(signPracticeListViewModel) | composer.changedInstance(signPractice) | composer.changed(function1);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                    final SignPracticeListViewModel signPracticeListViewModel3 = signPracticeListViewModel;
                    final Function1 function2 = function1;
                    final State state2 = state;
                    objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeListScreenKt$SignPracticeListScreen$5$1$5$1$1$2$1
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m1836invoke();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m1836invoke() {
                            if (SignPracticeListScreenKt.SignPracticeListScreen$lambda$0(state2).isSelecting()) {
                                signPracticeListViewModel3.updateSelectedIds(signPractice.getId());
                            } else {
                                signPracticeListViewModel3.incrementSignPracticeOpenCount(signPractice);
                                function2.invoke(Long.valueOf(signPractice.getId()));
                            }
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                SignPracticeCardKt.SignPracticeCard(modifierFillMaxWidth$default, signPractice, function0, (Function0) objRememberedValue2, composer, (SignPractice.$stable << 3) | 6, 0);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SignPracticeListUiState SignPracticeListScreen$lambda$0(State<SignPracticeListUiState> state) {
        return (SignPracticeListUiState) state.getValue();
    }
}
