package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens;

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
import androidx.compose.material.icons.filled.FolderKt;
import androidx.compose.material3.FloatingActionButtonElevation;
import androidx.compose.material3.FloatingActionButtonKt;
import androidx.compose.material3.MaterialTheme;
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
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.DateFilterRange;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.ListSortOrder;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.CircularProgressIndicatorComponentKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.DateRangePickerDialogKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.EmptyContentComponentKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.GenericConfirmationDialogKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.TextEditDialogKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBarKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.Conversation;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.ConversationCardKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListScreenEvent;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListScreenUiState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListViewModel;
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

/* JADX INFO: compiled from: ConversationListScreen.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\u001a=\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\t¨\u0006\n²\u0006\n\u0010\u000b\u001a\u00020\fX\u008a\u0084\u0002²\u0006\n\u0010\r\u001a\u00020\u000eX\u008a\u008e\u0002"}, d2 = {"ConversationListScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "conversationListViewModel", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationListViewModel;", "onDrawerClick", "Lkotlin/Function0;", "navigateToConversation", "(Landroidx/compose/ui/Modifier;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationListViewModel;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_release", "uiState", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationListScreenUiState;", "showCreateConversationDialog", ""}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ConversationListScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationListScreen$lambda$42(Modifier modifier, ConversationListViewModel conversationListViewModel, Function0 function0, Function0 function1, int i, int i2, Composer composer, int i3) {
        ConversationListScreen(modifier, conversationListViewModel, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0059  */
    public static final void ConversationListScreen(Modifier modifier, ConversationListViewModel conversationListViewModel, final Function0<Unit> function0, final Function0<Unit> function1, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Composer composer2;
        final ConversationListViewModel conversationListViewModel2;
        final Modifier modifier3;
        char c;
        boolean z;
        Composer composer3;
        Modifier modifier4;
        int i4;
        CreationExtras defaultViewModelCreationExtras;
        SharedFlow<ConversationListScreenEvent> sharedFlow;
        int i5;
        int i6;
        ConversationListViewModel conversationListViewModel3 = conversationListViewModel;
        Intrinsics.checkNotNullParameter(function0, "onDrawerClick");
        Intrinsics.checkNotNullParameter(function1, "navigateToConversation");
        Composer composerStartRestartGroup = composer.startRestartGroup(909858917);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ConversationListScreen)P(1!1,3)49@2893L29,52@3001L34,53@3063L34,54@3126L32,55@3199L34,57@3266L7,59@3303L409,59@3279L433,75@3774L956,206@9892L55,99@4763L410,110@5193L4674,73@3718L6235:ConversationListScreen.kt#6g1srx");
        int i7 = i2 & 1;
        if (i7 != 0) {
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
            if ((i2 & 2) != 0) {
                i6 = 16;
            } else {
                if ((i & 64) == 0 ? composerStartRestartGroup.changed(conversationListViewModel3) : composerStartRestartGroup.changedInstance(conversationListViewModel3)) {
                    i6 = 32;
                } else {
                    i6 = 16;
                }
            }
            i3 |= i6;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 2048 : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "45@2749L15");
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
                modifier4 = modifier2;
                i4 = i3;
                c = 2048;
                z = false;
                composer3 = composerStartRestartGroup;
            } else {
                Modifier modifier5 = i7 != 0 ? (Modifier) Modifier.Companion : modifier2;
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
                    ViewModel viewModel = ViewModelKt.viewModel(ConversationListViewModel.class, current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composer3, 36936, 0);
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    ConversationListViewModel conversationListViewModel4 = (ConversationListViewModel) viewModel;
                    i3 &= -113;
                    c = 2048;
                    conversationListViewModel3 = conversationListViewModel4;
                } else {
                    c = 2048;
                    z = false;
                    composer3 = composerStartRestartGroup;
                }
                modifier4 = modifier5;
                i4 = i3;
            }
            composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(909858917, i4, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationListScreen (ConversationListScreen.kt:48)");
            }
            Composer composer4 = composer3;
            final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(conversationListViewModel3.getUiState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composer4, 0, 7);
            SharedFlow<ConversationListScreenEvent> uiEvent = conversationListViewModel3.getUiEvent();
            ComposerKt.sourceInformationMarkerStart(composer4, -1798896761, "CC(remember):ConversationListScreen.kt#9igjgp");
            Object objRememberedValue = composer4.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z), (SnapshotMutationPolicy) null, 2, (Object) null);
                composer4.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerStart(composer4, -1798894777, "CC(remember):ConversationListScreen.kt#9igjgp");
            Object objRememberedValue2 = composer4.rememberedValue();
            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z), (SnapshotMutationPolicy) null, 2, (Object) null);
                composer4.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerStart(composer4, -1798892763, "CC(remember):ConversationListScreen.kt#9igjgp");
            Object objRememberedValue3 = composer4.rememberedValue();
            boolean z2 = z;
            if (objRememberedValue3 == Composer.Companion.getEmpty()) {
                objRememberedValue3 = new SnackbarHostState();
                composer4.updateRememberedValue(objRememberedValue3);
            }
            final SnackbarHostState snackbarHostState = (SnackbarHostState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerStart(composer4, -1798890425, "CC(remember):ConversationListScreen.kt#9igjgp");
            Object objRememberedValue4 = composer4.rememberedValue();
            if (objRememberedValue4 == Composer.Companion.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z2), (SnapshotMutationPolicy) null, 2, (Object) null);
                composer4.updateRememberedValue(objRememberedValue4);
            }
            final MutableState mutableState3 = (MutableState) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer4);
            CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composer4, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer4.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            Context context = (Context) objConsume;
            ComposerKt.sourceInformationMarkerStart(composer4, -1798886722, "CC(remember):ConversationListScreen.kt#9igjgp");
            boolean zChangedInstance = composer4.changedInstance(uiEvent) | composer4.changedInstance(context) | ((i4 & 7168) == 2048 ? true : z2);
            ConversationListScreenKt$ConversationListScreen$1$1 conversationListScreenKt$ConversationListScreen$1$1RememberedValue = composer4.rememberedValue();
            if (zChangedInstance || conversationListScreenKt$ConversationListScreen$1$1RememberedValue == Composer.Companion.getEmpty()) {
                int i8 = i4;
                sharedFlow = uiEvent;
                i5 = i8;
                conversationListScreenKt$ConversationListScreen$1$1RememberedValue = new ConversationListScreenKt$ConversationListScreen$1$1(sharedFlow, snackbarHostState, context, function1, null);
                composer4.updateRememberedValue(conversationListScreenKt$ConversationListScreen$1$1RememberedValue);
            } else {
                i5 = i4;
                sharedFlow = uiEvent;
            }
            ComposerKt.sourceInformationMarkerEnd(composer4);
            EffectsKt.LaunchedEffect(sharedFlow, (Function2) conversationListScreenKt$ConversationListScreen$1$1RememberedValue, composer4, z2);
            conversationListViewModel2 = conversationListViewModel3;
            composer2 = composer4;
            Modifier modifier6 = modifier4;
            ScaffoldKt.Scaffold-TvnljyQ(modifier6, ComposableLambdaKt.rememberComposableLambda(1028441377, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationListScreenKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    return ConversationListScreenKt.ConversationListScreen$lambda$18(function0, conversationListViewModel2, stateCollectAsStateWithLifecycle, mutableState2, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer4, 54), (Function2) null, ComposableLambdaKt.rememberComposableLambda(-1642306081, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationListScreenKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj, Object obj2) {
                    return ConversationListScreenKt.ConversationListScreen$lambda$19(snackbarHostState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer4, 54), ComposableLambdaKt.rememberComposableLambda(1317287486, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationListScreenKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2) {
                    return ConversationListScreenKt.ConversationListScreen$lambda$22(mutableState3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer4, 54), 0, 0L, 0L, (WindowInsets) null, ComposableLambdaKt.rememberComposableLambda(601422966, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationListScreenKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ConversationListScreenKt.ConversationListScreen$lambda$41(mutableState, conversationListViewModel2, mutableState2, stateCollectAsStateWithLifecycle, mutableState3, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer4, 54), composer2, (i5 & 14) | 805334064, 484);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier6;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            conversationListViewModel2 = conversationListViewModel3;
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationListScreenKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2) {
                    return ConversationListScreenKt.ConversationListScreen$lambda$42(modifier3, conversationListViewModel2, function0, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean ConversationListScreen$lambda$5(MutableState<Boolean> mutableState) {
        return ((Boolean) ((State) mutableState).getValue()).booleanValue();
    }

    private static final void ConversationListScreen$lambda$6(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationListScreen$lambda$18(final Function0 function0, final ConversationListViewModel conversationListViewModel, State state, final MutableState mutableState, final MutableState mutableState2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C78@3882L48,79@3971L54,82@4161L55,85@4250L69,88@4357L67,91@4462L105,94@4607L99,76@3788L932:ConversationListScreen.kt#6g1srx");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1028441377, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationListScreen.<anonymous> (ConversationListScreen.kt:76)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            String strStringResource = StringResources_androidKt.stringResource(R.string.conversation_list_title, composer, 0);
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.conversation_list_search_hint, composer, 0);
            String searchQuery = ConversationListScreen$lambda$0(state).getSearchQuery();
            boolean zIsSelecting = ConversationListScreen$lambda$0(state).isSelecting();
            ComposerKt.sourceInformationMarkerStart(composer, 489697656, "CC(remember):ConversationListScreen.kt#9igjgp");
            boolean zChanged = composer.changed(function0);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationListScreenKt$$ExternalSyntheticLambda13
                    public final Object invoke() {
                        return ConversationListScreenKt.ConversationListScreen$lambda$18$lambda$9$lambda$8(function0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function1 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 489700518, "CC(remember):ConversationListScreen.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationListScreenKt$$ExternalSyntheticLambda14
                    public final Object invoke() {
                        return ConversationListScreenKt.ConversationListScreen$lambda$18$lambda$11$lambda$10(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function0 function2 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 489703940, "CC(remember):ConversationListScreen.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.Companion.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationListScreenKt$$ExternalSyntheticLambda15
                    public final Object invoke() {
                        return ConversationListScreenKt.ConversationListScreen$lambda$18$lambda$13$lambda$12(mutableState2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            Function0 function3 = (Function0) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 489707338, "CC(remember):ConversationListScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(conversationListViewModel);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue4 == Composer.Companion.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationListScreenKt$$ExternalSyntheticLambda16
                    public final Object invoke(Object obj) {
                        return ConversationListScreenKt.ConversationListScreen$lambda$18$lambda$15$lambda$14(conversationListViewModel, (ListSortOrder) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            Function1 function4 = (Function1) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 489711972, "CC(remember):ConversationListScreen.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(conversationListViewModel);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue5 == Composer.Companion.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationListScreenKt$$ExternalSyntheticLambda17
                    public final Object invoke(Object obj) {
                        return ConversationListScreenKt.ConversationListScreen$lambda$18$lambda$17$lambda$16(conversationListViewModel, (String) obj);
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
    public static final Unit ConversationListScreen$lambda$18$lambda$9$lambda$8(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationListScreen$lambda$18$lambda$11$lambda$10(MutableState mutableState) {
        mutableState.setValue(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationListScreen$lambda$18$lambda$13$lambda$12(MutableState mutableState) {
        mutableState.setValue(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationListScreen$lambda$18$lambda$15$lambda$14(ConversationListViewModel conversationListViewModel, ListSortOrder listSortOrder) {
        Intrinsics.checkNotNullParameter(listSortOrder, "sortOrder");
        conversationListViewModel.updateSortOrder(listSortOrder);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationListScreen$lambda$18$lambda$17$lambda$16(ConversationListViewModel conversationListViewModel, String str) {
        Intrinsics.checkNotNullParameter(str, "query");
        conversationListViewModel.updateSearchQuery(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationListScreen$lambda$22(final MutableState mutableState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C101@4825L75,104@4949L11,105@5015L11,100@4777L386:ConversationListScreen.kt#6g1srx");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1317287486, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationListScreen.<anonymous> (ConversationListScreen.kt:100)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -1102076215, "CC(remember):ConversationListScreen.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationListScreenKt$$ExternalSyntheticLambda8
                    public final Object invoke() {
                        return ConversationListScreenKt.ConversationListScreen$lambda$22$lambda$21$lambda$20(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FloatingActionButtonKt.FloatingActionButton-X-z6DiA((Function0) objRememberedValue, (Modifier) null, (Shape) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnPrimary-0d7_KjU(), (FloatingActionButtonElevation) null, (MutableInteractionSource) null, ComposableSingletons$ConversationListScreenKt.INSTANCE.m1627getLambda$768339204$app_release(), composer, 12582918, 102);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationListScreen$lambda$22$lambda$21$lambda$20(MutableState mutableState) {
        ConversationListScreen$lambda$6(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit ConversationListScreen$lambda$41(final MutableState mutableState, final ConversationListViewModel conversationListViewModel, final MutableState mutableState2, final State state, final MutableState mutableState3, PaddingValues paddingValues, Composer composer, int i) throws NoWhenBranchMatchedException {
        int i2;
        int i3;
        String str;
        String str2;
        int i4;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer2, "C111@5224L4633:ConversationListScreen.kt#6g1srx");
        if ((i & 6) == 0) {
            i2 = i | (composer2.changed(paddingValues) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer2.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(601422966, i2, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationListScreen.<anonymous> (ConversationListScreen.kt:111)");
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
            ComposerKt.sourceInformationMarkerStart(composer2, 1283542821, "C:ConversationListScreen.kt#6g1srx");
            if (!((Boolean) mutableState.getValue()).booleanValue()) {
                composer2.startReplaceGroup(1277946390);
            } else {
                composer2.startReplaceGroup(1283446348);
                ComposerKt.sourceInformation(composer2, "121@5681L113,124@5832L84,119@5552L386");
                Modifier modifier = PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8));
                ComposerKt.sourceInformationMarkerStart(composer2, -1066972643, "CC(remember):ConversationListScreen.kt#9igjgp");
                boolean zChangedInstance = composer2.changedInstance(conversationListViewModel);
                Object objRememberedValue = composer2.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationListScreenKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            return ConversationListScreenKt.ConversationListScreen$lambda$41$lambda$40$lambda$24$lambda$23(conversationListViewModel, (DateFilterRange) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                Function1 function1 = (Function1) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, -1066967840, "CC(remember):ConversationListScreen.kt#9igjgp");
                Object objRememberedValue2 = composer2.rememberedValue();
                if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationListScreenKt$$ExternalSyntheticLambda2
                        public final Object invoke() {
                            return ConversationListScreenKt.ConversationListScreen$lambda$41$lambda$40$lambda$26$lambda$25(mutableState);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                DateRangePickerDialogKt.DateRangePickerDialog(modifier, function1, (Function0) objRememberedValue2, composer2, 390, 0);
            }
            composer2.endReplaceGroup();
            if (!((Boolean) mutableState2.getValue()).booleanValue()) {
                i3 = 1277946390;
                str = "CC(remember):ConversationListScreen.kt#9igjgp";
                composer2.startReplaceGroup(1277946390);
            } else {
                composer2.startReplaceGroup(1283927468);
                ComposerKt.sourceInformation(composer2, "132@6094L159,136@6296L103,139@6433L57,140@6530L56,141@6626L46,142@6712L46,131@6024L802");
                ComposerKt.sourceInformationMarkerStart(composer2, -1066959381, "CC(remember):ConversationListScreen.kt#9igjgp");
                boolean zChangedInstance2 = composer2.changedInstance(conversationListViewModel);
                Object objRememberedValue3 = composer2.rememberedValue();
                if (zChangedInstance2 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationListScreenKt$$ExternalSyntheticLambda3
                        public final Object invoke() {
                            return ConversationListScreenKt.ConversationListScreen$lambda$41$lambda$40$lambda$28$lambda$27(conversationListViewModel, mutableState2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                Function0 function0 = (Function0) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, -1066952973, "CC(remember):ConversationListScreen.kt#9igjgp");
                boolean zChangedInstance3 = composer2.changedInstance(conversationListViewModel);
                Object objRememberedValue4 = composer2.rememberedValue();
                if (zChangedInstance3 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                    objRememberedValue4 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationListScreenKt$$ExternalSyntheticLambda4
                        public final Object invoke() {
                            return ConversationListScreenKt.ConversationListScreen$lambda$41$lambda$40$lambda$30$lambda$29(conversationListViewModel);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                i3 = 1277946390;
                str = "CC(remember):ConversationListScreen.kt#9igjgp";
                GenericConfirmationDialogKt.GenericConfirmationDialog(null, function0, (Function0) objRememberedValue4, StringResources_androidKt.stringResource(R.string.conversation_dialog_delete_title, composer2, 0), StringResources_androidKt.stringResource(R.string.conversation_dialog_delete_desc, composer2, 0), StringResources_androidKt.stringResource(R.string.global_action_confirm, composer2, 0), StringResources_androidKt.stringResource(R.string.global_action_dismiss, composer2, 0), null, true, null, composer, 100663296, 641);
                composer2 = composer;
            }
            composer2.endReplaceGroup();
            if (!ConversationListScreen$lambda$5(mutableState3)) {
                str2 = str;
                i4 = 0;
                composer2.startReplaceGroup(i3);
            } else {
                composer2.startReplaceGroup(1284812456);
                ComposerKt.sourceInformation(composer2, "149@6966L55,150@7055L55,151@7157L45,153@7289L92,157@7456L182,148@6918L742");
                i4 = 0;
                String strStringResource = StringResources_androidKt.stringResource(R.string.conversation_dialog_name_title, composer2, 0);
                String strStringResource2 = StringResources_androidKt.stringResource(R.string.conversation_dialog_name_label, composer2, 0);
                String strStringResource3 = StringResources_androidKt.stringResource(R.string.global_action_create, composer2, 0);
                str2 = str;
                ComposerKt.sourceInformationMarkerStart(composer2, -1066921208, str2);
                Object objRememberedValue5 = composer2.rememberedValue();
                if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                    objRememberedValue5 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationListScreenKt$$ExternalSyntheticLambda5
                        public final Object invoke() {
                            return ConversationListScreenKt.ConversationListScreen$lambda$41$lambda$40$lambda$32$lambda$31(mutableState3);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue5);
                }
                Function0 function2 = (Function0) objRememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, -1066915774, str2);
                boolean zChangedInstance4 = composer2.changedInstance(conversationListViewModel);
                Object objRememberedValue6 = composer2.rememberedValue();
                if (zChangedInstance4 || objRememberedValue6 == Composer.Companion.getEmpty()) {
                    objRememberedValue6 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationListScreenKt$$ExternalSyntheticLambda6
                        public final Object invoke(Object obj) {
                            return ConversationListScreenKt.ConversationListScreen$lambda$41$lambda$40$lambda$34$lambda$33(conversationListViewModel, mutableState3, (String) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                TextEditDialogKt.TextEditDialog(null, strStringResource, strStringResource2, strStringResource3, null, "", 1, function2, (Function1) objRememberedValue6, composer, 14352384, 17);
                composer2 = composer;
            }
            composer2.endReplaceGroup();
            boolean zIsLoading = ConversationListScreen$lambda$0(state).isLoading();
            if (zIsLoading) {
                composer2.startReplaceGroup(1285638699);
                ComposerKt.sourceInformation(composer2, "166@7777L27");
                CircularProgressIndicatorComponentKt.CircularProgressComponent(null, composer2, i4, 1);
                composer2.endReplaceGroup();
            } else {
                if (zIsLoading) {
                    composer2.startReplaceGroup(-1066906129);
                    composer2.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composer2.startReplaceGroup(1285801573);
                ComposerKt.sourceInformation(composer2, "");
                if (!ConversationListScreen$lambda$0(state).getConversations().isEmpty()) {
                    composer2.startReplaceGroup(1285851948);
                    ComposerKt.sourceInformation(composer2, "174@8181L1197,170@7952L1426");
                    Alignment.Horizontal centerHorizontally2 = Alignment.Companion.getCenterHorizontally();
                    Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1066891559, str2);
                    boolean zChanged = composer2.changed(state) | composer2.changedInstance(conversationListViewModel);
                    Object objRememberedValue7 = composer2.rememberedValue();
                    if (zChanged || objRememberedValue7 == Composer.Companion.getEmpty()) {
                        objRememberedValue7 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationListScreenKt$$ExternalSyntheticLambda7
                            public final Object invoke(Object obj) {
                                return ConversationListScreenKt.ConversationListScreen$lambda$41$lambda$40$lambda$39$lambda$38(state, conversationListViewModel, (LazyListScope) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue7);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    LazyDslKt.LazyColumn(modifierFillMaxSize$default, (LazyListState) null, (PaddingValues) null, false, (Arrangement.Vertical) null, centerHorizontally2, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) objRememberedValue7, composer2, 196614, 478);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(1287294285);
                    ComposerKt.sourceInformation(composer2, "199@9693L54,195@9440L337");
                    EmptyContentComponentKt.EmptyContentComponent(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), FolderKt.getFolder(Icons.INSTANCE.getDefault()), null, StringResources_androidKt.stringResource(R.string.conversation_list_empty_state, composer2, i4), composer2, 390, 0);
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
    public static final Unit ConversationListScreen$lambda$41$lambda$40$lambda$24$lambda$23(ConversationListViewModel conversationListViewModel, DateFilterRange dateFilterRange) {
        Intrinsics.checkNotNullParameter(dateFilterRange, "range");
        conversationListViewModel.updateDateRange(dateFilterRange);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationListScreen$lambda$41$lambda$40$lambda$26$lambda$25(MutableState mutableState) {
        mutableState.setValue(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationListScreen$lambda$41$lambda$40$lambda$28$lambda$27(ConversationListViewModel conversationListViewModel, MutableState mutableState) {
        conversationListViewModel.clearSelectedIds();
        mutableState.setValue(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationListScreen$lambda$41$lambda$40$lambda$30$lambda$29(ConversationListViewModel conversationListViewModel) {
        conversationListViewModel.deleteConversations();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationListScreen$lambda$41$lambda$40$lambda$32$lambda$31(MutableState mutableState) {
        ConversationListScreen$lambda$6(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationListScreen$lambda$41$lambda$40$lambda$34$lambda$33(ConversationListViewModel conversationListViewModel, MutableState mutableState, String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        conversationListViewModel.createNewConversation(str);
        ConversationListScreen$lambda$6(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationListScreen$lambda$41$lambda$40$lambda$39$lambda$38(final State state, final ConversationListViewModel conversationListViewModel, LazyListScope lazyListScope) {
        Intrinsics.checkNotNullParameter(lazyListScope, "$this$LazyColumn");
        final List<Conversation> conversations = ConversationListScreen$lambda$0(state).getConversations();
        final ConversationListScreenKt$ConversationListScreen$lambda$41$lambda$40$lambda$39$lambda$38$$inlined$items$default$1 conversationListScreenKt$ConversationListScreen$lambda$41$lambda$40$lambda$39$lambda$38$$inlined$items$default$1 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationListScreenKt$ConversationListScreen$lambda$41$lambda$40$lambda$39$lambda$38$$inlined$items$default$1
            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final Void m1634invoke(Conversation conversation) {
                return null;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return m1634invoke((Conversation) obj);
            }
        };
        lazyListScope.items(conversations.size(), (Function1) null, new Function1<Integer, Object>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationListScreenKt$ConversationListScreen$lambda$41$lambda$40$lambda$39$lambda$38$$inlined$items$default$3
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Object invoke(int i) {
                return conversationListScreenKt$ConversationListScreen$lambda$41$lambda$40$lambda$39$lambda$38$$inlined$items$default$1.invoke(conversations.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationListScreenKt$ConversationListScreen$lambda$41$lambda$40$lambda$39$lambda$38$$inlined$items$default$4
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
                final Conversation conversation = (Conversation) conversations.get(i);
                composer.startReplaceGroup(789481465);
                ComposerKt.sourceInformation(composer, "C*188@9123L153,181@8612L443,176@8298L1016:ConversationListScreen.kt#6g1srx");
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart(composer, -2052717301, "CC(remember):ConversationListScreen.kt#9igjgp");
                boolean zChangedInstance = composer.changedInstance(conversationListViewModel) | composer.changed(conversation);
                Object objRememberedValue = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                    final ConversationListViewModel conversationListViewModel2 = conversationListViewModel;
                    objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationListScreenKt$ConversationListScreen$5$1$7$1$1$1$1
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m1632invoke();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m1632invoke() {
                            conversationListViewModel2.updateSelectedIds(conversation.getId());
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Function0 function0 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -2052733363, "CC(remember):ConversationListScreen.kt#9igjgp");
                boolean zChanged = composer.changed(state) | composer.changedInstance(conversationListViewModel) | composer.changed(conversation);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                    final ConversationListViewModel conversationListViewModel3 = conversationListViewModel;
                    final State state2 = state;
                    objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationListScreenKt$ConversationListScreen$5$1$7$1$1$2$1
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m1633invoke();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m1633invoke() {
                            if (ConversationListScreenKt.ConversationListScreen$lambda$0(state2).isSelecting()) {
                                conversationListViewModel3.updateSelectedIds(conversation.getId());
                            } else {
                                conversationListViewModel3.updateActiveConversation(conversation.getId());
                            }
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                ConversationCardKt.ConversationCard(modifierFillMaxWidth$default, conversation, function0, (Function0) objRememberedValue2, composer, 6, 0);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationListScreen$lambda$19(SnackbarHostState snackbarHostState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C207@9906L31:ConversationListScreen.kt#6g1srx");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1642306081, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationListScreen.<anonymous> (ConversationListScreen.kt:207)");
            }
            SnackbarHostKt.SnackbarHost(snackbarHostState, (Modifier) null, (Function3) null, composer, 6, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConversationListScreenUiState ConversationListScreen$lambda$0(State<ConversationListScreenUiState> state) {
        return (ConversationListScreenUiState) state.getValue();
    }
}
