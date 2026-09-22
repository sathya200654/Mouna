package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.view.View;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SnackbarHostKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
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
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.CircularProgressIndicatorDialogComponentKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.viewmodels.ConversationSharedViewModel;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.Conversation;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.ConversationMessage;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.ConversationMode;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.conversationsuggestion.CorrectionSuggestion;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.conversationsuggestion.SuggestionCategory;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.LanguageSelectionDialogBoxKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConfigurationBottomSheetKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationBottomBarKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ConversationTopBarKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.DraggableFloatingWebViewKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.EllipsisAnimationTranscriptBubbleKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.InputBottomSheetKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.InputSuggestionBottomSheetKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.LanguageAnnouncementPopUpKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.PartialTextBubbleKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.SaveInputSuggestionDialogKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TranscriptionBubbleKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TtsDrawerKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversationlist.CreateNewConversationDialogKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationActionElement;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationActivity;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationDrawer;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiAction;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiEvent;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.SaveInputSuggestionDialogState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.WebViewManager;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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

/* JADX INFO: compiled from: ConversationScreen.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\u001aM\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e²\u0006\n\u0010\u000f\u001a\u00020\u0010X\u008a\u0084\u0002²\u0006\n\u0010\u0011\u001a\u00020\u0012X\u008a\u008e\u0002"}, d2 = {"ConversationScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "conversationSharedViewModel", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/presentation/viewmodels/ConversationSharedViewModel;", "conversationViewModel", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationViewModel;", "webViewManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/manager/WebViewManager;", "onDrawerClick", "Lkotlin/Function0;", "navigateToDocumentScanner", "(Landroidx/compose/ui/Modifier;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/presentation/viewmodels/ConversationSharedViewModel;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationViewModel;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/manager/WebViewManager;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_release", "uiState", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiState;", "showConversationRenameDialogBox", ""}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ConversationScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationScreen$lambda$81(Modifier modifier, ConversationSharedViewModel conversationSharedViewModel, ConversationViewModel conversationViewModel, WebViewManager webViewManager, Function0 function0, Function0 function1, int i, int i2, Composer composer, int i3) {
        ConversationScreen(modifier, conversationSharedViewModel, conversationViewModel, webViewManager, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0260  */
    /* JADX WARN: Code duplicated, block: B:104:0x029a  */
    /* JADX WARN: Code duplicated, block: B:107:0x02c1  */
    /* JADX WARN: Code duplicated, block: B:110:0x02e8  */
    /* JADX WARN: Code duplicated, block: B:117:0x0337  */
    /* JADX WARN: Code duplicated, block: B:120:0x036a  */
    /* JADX WARN: Code duplicated, block: B:121:0x0379  */
    /* JADX WARN: Code duplicated, block: B:126:0x03b9  */
    /* JADX WARN: Code duplicated, block: B:135:0x03ee  */
    /* JADX WARN: Code duplicated, block: B:140:0x0407  */
    /* JADX WARN: Code duplicated, block: B:143:0x043b  */
    /* JADX WARN: Code duplicated, block: B:144:0x043d  */
    /* JADX WARN: Code duplicated, block: B:151:0x0455  */
    /* JADX WARN: Code duplicated, block: B:156:0x0491  */
    /* JADX WARN: Code duplicated, block: B:159:0x04e9  */
    /* JADX WARN: Code duplicated, block: B:162:0x04f5  */
    /* JADX WARN: Code duplicated, block: B:163:0x04f9  */
    /* JADX WARN: Code duplicated, block: B:166:0x05c8  */
    /* JADX WARN: Code duplicated, block: B:170:0x0609  */
    /* JADX WARN: Code duplicated, block: B:175:0x062e  */
    /* JADX WARN: Code duplicated, block: B:180:0x0653  */
    /* JADX WARN: Code duplicated, block: B:182:0x0667  */
    /* JADX WARN: Code duplicated, block: B:185:0x0688  */
    /* JADX WARN: Code duplicated, block: B:90:0x015f  */
    /* JADX WARN: Code duplicated, block: B:93:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:96:0x01e7  */
    public static final void ConversationScreen(Modifier modifier, final ConversationSharedViewModel conversationSharedViewModel, ConversationViewModel conversationViewModel, final WebViewManager webViewManager, final Function0<Unit> function0, final Function0<Unit> function1, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        ConversationViewModel conversationViewModel2;
        final Modifier modifier3;
        final ConversationViewModel conversationViewModel3;
        Modifier modifier4;
        CreationExtras defaultViewModelCreationExtras;
        final ConversationViewModel conversationViewModel4;
        final Context context;
        final LifecycleOwner lifecycleOwner;
        View view;
        Object objRememberedValue;
        final SnackbarHostState snackbarHostState;
        Object objRememberedValue2;
        final CoroutineScope coroutineScope;
        SharedFlow<ConversationUiEvent> uiEvent;
        final State stateCollectAsStateWithLifecycle;
        int i4;
        final LazyListState lazyListStateRememberLazyListState;
        boolean zChanged;
        ConversationScreenKt$ConversationScreen$1$1 conversationScreenKt$ConversationScreen$1$1RememberedValue;
        Object objRememberedValue3;
        AudioManager audioManager;
        Object objRememberedValue4;
        int iIntValue;
        Object objRememberedValue5;
        int iIntValue2;
        String strStringResource;
        boolean zChangedInstance;
        ConversationScreenKt$ConversationScreen$2$1 conversationScreenKt$ConversationScreen$2$1RememberedValue;
        View view2;
        Object objRememberedValue6;
        int i5;
        final String strStringResource2;
        boolean zChangedInstance2;
        Object objRememberedValue7;
        ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult;
        boolean z;
        boolean zChangedInstance3;
        Object objRememberedValue8;
        boolean z2;
        boolean z3;
        Context context2;
        Composer composer2;
        Object obj;
        ConversationScreenKt$ConversationScreen$4$1 conversationScreenKt$ConversationScreen$4$1;
        boolean zChangedInstance4;
        Object objRememberedValue9;
        Function0 constructor;
        boolean zChangedInstance5;
        Object objRememberedValue10;
        boolean zChangedInstance6;
        Object objRememberedValue11;
        boolean zChangedInstance7;
        Object objRememberedValue12;
        Intrinsics.checkNotNullParameter(conversationSharedViewModel, "conversationSharedViewModel");
        Intrinsics.checkNotNullParameter(webViewManager, "webViewManager");
        Intrinsics.checkNotNullParameter(function0, "onDrawerClick");
        Intrinsics.checkNotNullParameter(function1, "navigateToDocumentScanner");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1790213083);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ConversationScreen)P(2!2,5,4)87@5972L7,88@6025L7,89@6058L7,91@6095L32,92@6144L24,95@6267L29,97@6318L23,103@6475L210,99@6347L338,109@6710L76,110@6807L71,111@6903L68,113@7005L84,118@7116L368,118@7095L389,130@7529L34,132@7611L79,138@7835L663,136@7731L767,157@8537L603,157@8504L636,176@9167L964,176@9146L985,200@10160L284,200@10137L307,208@10450L11632:ConversationScreen.kt#6g1srx");
        int i6 = i2 & 1;
        if (i6 != 0) {
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
            i3 |= (i & 64) == 0 ? composerStartRestartGroup.changed(conversationSharedViewModel) : composerStartRestartGroup.changedInstance(conversationSharedViewModel) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                conversationViewModel2 = conversationViewModel;
                int i7 = composerStartRestartGroup.changedInstance(conversationViewModel2) ? 256 : 128;
                i3 |= i7;
            } else {
                conversationViewModel2 = conversationViewModel;
            }
            i3 |= i7;
        } else {
            conversationViewModel2 = conversationViewModel;
        }
        if ((i & 3072) == 0) {
            i3 |= (i & 4096) == 0 ? composerStartRestartGroup.changed(webViewManager) : composerStartRestartGroup.changedInstance(webViewManager) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 131072 : ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
        }
        if (composerStartRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "82@5811L15");
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
                modifier4 = modifier2;
            } else {
                modifier4 = i6 != 0 ? (Modifier) Modifier.Companion : modifier2;
                if ((i2 & 4) != 0) {
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
                    ViewModel viewModel = ViewModelKt.viewModel(ConversationViewModel.class, current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 36936, 0);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    conversationViewModel4 = (ConversationViewModel) viewModel;
                    i3 &= -897;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1790213083, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreen (ConversationScreen.kt:86)");
                }
                CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localContext);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                context = (Context) objConsume;
                CompositionLocal localLifecycleOwner = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume2 = composerStartRestartGroup.consume(localLifecycleOwner);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                lifecycleOwner = (LifecycleOwner) objConsume2;
                CompositionLocal localView = AndroidCompositionLocals_androidKt.getLocalView();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume3 = composerStartRestartGroup.consume(localView);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                view = (View) objConsume3;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1887129221, "CC(remember):ConversationScreen.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = new SnackbarHostState();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                snackbarHostState = (SnackbarHostState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                coroutineScope = (CoroutineScope) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                uiEvent = conversationViewModel4.getUiEvent();
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(conversationViewModel4.getUiState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                i4 = i3;
                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                Integer numValueOf = Integer.valueOf(ConversationScreen$lambda$1(stateCollectAsStateWithLifecycle).getConversationMessages().size());
                Boolean boolValueOf = Boolean.valueOf(ConversationScreen$lambda$1(stateCollectAsStateWithLifecycle).isPartialTextVisible());
                ConversationActivity activity = ConversationScreen$lambda$1(stateCollectAsStateWithLifecycle).getActivity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1887141559, "CC(remember):ConversationScreen.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | composerStartRestartGroup.changed(lazyListStateRememberLazyListState);
                conversationScreenKt$ConversationScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || conversationScreenKt$ConversationScreen$1$1RememberedValue == Composer.Companion.getEmpty()) {
                    conversationScreenKt$ConversationScreen$1$1RememberedValue = new ConversationScreenKt$ConversationScreen$1$1(lazyListStateRememberLazyListState, stateCollectAsStateWithLifecycle, null);
                    composerStartRestartGroup.updateRememberedValue(conversationScreenKt$ConversationScreen$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(numValueOf, boolValueOf, activity, (Function2) conversationScreenKt$ConversationScreen$1$1RememberedValue, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1887148945, "CC(remember):ConversationScreen.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.Companion.getEmpty()) {
                    Object systemService = context.getSystemService("audio");
                    Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
                    objRememberedValue3 = (AudioManager) systemService;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                audioManager = (AudioManager) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1887152044, "CC(remember):ConversationScreen.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.Companion.getEmpty()) {
                    objRememberedValue4 = Integer.valueOf(audioManager.getStreamMaxVolume(3));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                iIntValue = ((Number) objRememberedValue4).intValue();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1887155113, "CC(remember):ConversationScreen.kt#9igjgp");
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                    objRememberedValue5 = Integer.valueOf(audioManager.getStreamVolume(3));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                iIntValue2 = ((Number) objRememberedValue5).intValue();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                strStringResource = StringResources_androidKt.stringResource(R.string.conversation_snackbar_volume_info, new Object[]{50}, composerStartRestartGroup, 0);
                Unit unit = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1887162229, "CC(remember):ConversationScreen.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(audioManager) | composerStartRestartGroup.changed(strStringResource) | composerStartRestartGroup.changedInstance(view);
                conversationScreenKt$ConversationScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance || conversationScreenKt$ConversationScreen$2$1RememberedValue == Composer.Companion.getEmpty()) {
                    ConversationScreenKt$ConversationScreen$2$1 conversationScreenKt$ConversationScreen$2$1 = new ConversationScreenKt$ConversationScreen$2$1(iIntValue2, iIntValue, audioManager, snackbarHostState, strStringResource, view, null);
                    view2 = view;
                    conversationScreenKt$ConversationScreen$2$1RememberedValue = conversationScreenKt$ConversationScreen$2$1;
                    composerStartRestartGroup.updateRememberedValue(conversationScreenKt$ConversationScreen$2$1RememberedValue);
                } else {
                    view2 = view;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(unit, (Function2) conversationScreenKt$ConversationScreen$2$1RememberedValue, composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1887175111, "CC(remember):ConversationScreen.kt#9igjgp");
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == Composer.Companion.getEmpty()) {
                    i5 = 0;
                    objRememberedValue6 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    i5 = 0;
                }
                final MutableState mutableState = (MutableState) objRememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                strStringResource2 = StringResources_androidKt.stringResource(R.string.conversation_snackbar_permission_warning, composerStartRestartGroup, i5);
                ActivityResultContract requestPermission = new ActivityResultContracts.RequestPermission();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1887185532, "CC(remember):ConversationScreen.kt#9igjgp");
                zChangedInstance2 = composerStartRestartGroup.changedInstance(conversationViewModel4) | composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changed(strStringResource2) | composerStartRestartGroup.changedInstance(context);
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance2 || objRememberedValue7 == Composer.Companion.getEmpty()) {
                    final ConversationViewModel conversationViewModel5 = conversationViewModel4;
                    objRememberedValue7 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda29
                        public final Object invoke(Object obj2) {
                            return ConversationScreenKt.ConversationScreen$lambda$11$lambda$10(conversationViewModel5, coroutineScope, context, snackbarHostState, strStringResource2, ((Boolean) obj2).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                managedActivityResultLauncherRememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(requestPermission, (Function1) objRememberedValue7, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1887207936, "CC(remember):ConversationScreen.kt#9igjgp");
                if ((i4 & 112) != 32 || ((i4 & 64) != 0 && composerStartRestartGroup.changedInstance(conversationSharedViewModel))) {
                    z = true;
                } else {
                    z = false;
                }
                zChangedInstance3 = z | composerStartRestartGroup.changedInstance(conversationViewModel4) | composerStartRestartGroup.changedInstance(lifecycleOwner);
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance3 || objRememberedValue8 == Composer.Companion.getEmpty()) {
                    objRememberedValue8 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda31
                        public final Object invoke(Object obj2) {
                            return ConversationScreenKt.ConversationScreen$lambda$15$lambda$14(lifecycleOwner, conversationSharedViewModel, conversationViewModel4, (DisposableEffectScope) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.DisposableEffect(lifecycleOwner, (Function1) objRememberedValue8, composerStartRestartGroup, 0);
                Unit unit2 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1887228457, "CC(remember):ConversationScreen.kt#9igjgp");
                boolean zChangedInstance8 = composerStartRestartGroup.changedInstance(uiEvent) | composerStartRestartGroup.changedInstance(context) | composerStartRestartGroup.changedInstance(view2) | composerStartRestartGroup.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult);
                if ((i4 & 458752) == 131072) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z3 = zChangedInstance8 | z2;
                Object objRememberedValue13 = composerStartRestartGroup.rememberedValue();
                if (!z3 || objRememberedValue13 == Composer.Companion.getEmpty()) {
                    context2 = context;
                    composer2 = composerStartRestartGroup;
                    obj = null;
                    conversationScreenKt$ConversationScreen$4$1 = new ConversationScreenKt$ConversationScreen$4$1(uiEvent, snackbarHostState, context2, view2, managedActivityResultLauncherRememberLauncherForActivityResult, function1, null);
                    composer2.updateRememberedValue(conversationScreenKt$ConversationScreen$4$1);
                } else {
                    context2 = context;
                    composer2 = composerStartRestartGroup;
                    obj = null;
                    conversationScreenKt$ConversationScreen$4$1 = objRememberedValue13;
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                EffectsKt.LaunchedEffect(unit2, (Function2) conversationScreenKt$ConversationScreen$4$1, composer2, 6);
                Unit unit3 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 1887259553, (String) r15);
                zChangedInstance4 = composer2.changedInstance(conversationViewModel4);
                objRememberedValue9 = composer2.rememberedValue();
                if (!zChangedInstance4 || objRememberedValue9 == Composer.Companion.getEmpty()) {
                    objRememberedValue9 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda32
                        public final Object invoke(Object obj2) {
                            return ConversationScreenKt.ConversationScreen$lambda$19$lambda$18(conversationViewModel4, (DisposableEffectScope) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue9);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                EffectsKt.DisposableEffect(unit3, (Function1) objRememberedValue9, composer2, 6);
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, obj);
                ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxSize$default);
                constructor = ComposeUiNode.Companion.getConstructor();
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
                ComposerKt.sourceInformationMarkerStart(composer2, -1956545824, "C212@10577L877,417@21119L179,414@21030L63,228@11478L9523,210@10500L10808:ConversationScreen.kt#6g1srx");
                Modifier modifierImePadding = WindowInsetsPadding_androidKt.imePadding(Modifier.Companion);
                Function2 function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-703214993, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda33
                    public final Object invoke(Object obj2, Object obj3) {
                        return ConversationScreenKt.ConversationScreen$lambda$80$lambda$24(function0, conversationViewModel4, stateCollectAsStateWithLifecycle, mutableState, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer2, 54);
                Function2 function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1457341552, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda34
                    public final Object invoke(Object obj2, Object obj3) {
                        return ConversationScreenKt.ConversationScreen$lambda$80$lambda$27(conversationViewModel4, stateCollectAsStateWithLifecycle, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer2, 54);
                Function2 function2RememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-677069199, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda35
                    public final Object invoke(Object obj2, Object obj3) {
                        return ConversationScreenKt.ConversationScreen$lambda$80$lambda$28(snackbarHostState, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer2, 54);
                Composer composer4 = composer2;
                Modifier modifier5 = modifier4;
                final ConversationViewModel conversationViewModel6 = conversationViewModel4;
                final Context context3 = context2;
                conversationViewModel3 = conversationViewModel6;
                ScaffoldKt.Scaffold-TvnljyQ(modifierImePadding, function2RememberComposableLambda, function2RememberComposableLambda2, function2RememberComposableLambda3, (Function2) null, 0, 0L, 0L, (WindowInsets) null, ComposableLambdaKt.rememberComposableLambda(-385675974, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        return ConversationScreenKt.ConversationScreen$lambda$80$lambda$73(conversationViewModel6, lazyListStateRememberLazyListState, stateCollectAsStateWithLifecycle, context3, webViewManager, mutableState, (PaddingValues) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composer4, 54), composer4, 805309872, 496);
                composerStartRestartGroup = composer4;
                if (ConversationScreen$lambda$1(stateCollectAsStateWithLifecycle).getActiveActionElement() instanceof ConversationActionElement.TextToSpeechDrawer) {
                    composerStartRestartGroup.startReplaceGroup(-1967321673);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1946071886);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "431@21667L110,434@21811L104,437@21943L109,425@21413L653");
                    Modifier modifierStatusBarsPadding = WindowInsetsPadding_androidKt.statusBarsPadding(ZIndexModifierKt.zIndex(Modifier.Companion, 10.0f));
                    String ttsText = ConversationScreen$lambda$1(stateCollectAsStateWithLifecycle).getTtsText();
                    LanguageEnum ttsLanguage = ConversationScreen$lambda$1(stateCollectAsStateWithLifecycle).getTtsLanguage();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 491420825, "CC(remember):ConversationScreen.kt#9igjgp");
                    zChangedInstance5 = composerStartRestartGroup.changedInstance(conversationViewModel3);
                    objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance5 || objRememberedValue10 == Composer.Companion.getEmpty()) {
                        objRememberedValue10 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda2
                            public final Object invoke() {
                                return ConversationScreenKt.ConversationScreen$lambda$80$lambda$75$lambda$74(conversationViewModel3);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                    }
                    Function0 function2 = (Function0) objRememberedValue10;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 491425427, "CC(remember):ConversationScreen.kt#9igjgp");
                    zChangedInstance6 = composerStartRestartGroup.changedInstance(conversationViewModel3);
                    objRememberedValue11 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance6 || objRememberedValue11 == Composer.Companion.getEmpty()) {
                        objRememberedValue11 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda3
                            public final Object invoke() {
                                return ConversationScreenKt.ConversationScreen$lambda$80$lambda$77$lambda$76(conversationViewModel3);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                    }
                    Function0 function3 = (Function0) objRememberedValue11;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 491429656, "CC(remember):ConversationScreen.kt#9igjgp");
                    zChangedInstance7 = composerStartRestartGroup.changedInstance(conversationViewModel3);
                    objRememberedValue12 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance7 || objRememberedValue12 == Composer.Companion.getEmpty()) {
                        objRememberedValue12 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda4
                            public final Object invoke() {
                                return ConversationScreenKt.ConversationScreen$lambda$80$lambda$79$lambda$78(conversationViewModel3);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue12);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    TtsDrawerKt.TtsDrawer(modifierStatusBarsPadding, ttsText, ttsLanguage, function2, function3, (Function0) objRememberedValue12, composerStartRestartGroup, 0, 0);
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
            }
            conversationViewModel4 = conversationViewModel2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1790213083, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreen (ConversationScreen.kt:86)");
            }
            CompositionLocal localContext2 = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume4 = composerStartRestartGroup.consume(localContext2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            context = (Context) objConsume4;
            CompositionLocal localLifecycleOwner2 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume5 = composerStartRestartGroup.consume(localLifecycleOwner2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            lifecycleOwner = (LifecycleOwner) objConsume5;
            CompositionLocal localView2 = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume6 = composerStartRestartGroup.consume(localView2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            view = (View) objConsume6;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1887129221, "CC(remember):ConversationScreen.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new SnackbarHostState();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            snackbarHostState = (SnackbarHostState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            coroutineScope = (CoroutineScope) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            uiEvent = conversationViewModel4.getUiEvent();
            stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(conversationViewModel4.getUiState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            i4 = i3;
            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
            Integer numValueOf2 = Integer.valueOf(ConversationScreen$lambda$1(stateCollectAsStateWithLifecycle).getConversationMessages().size());
            Boolean boolValueOf2 = Boolean.valueOf(ConversationScreen$lambda$1(stateCollectAsStateWithLifecycle).isPartialTextVisible());
            ConversationActivity activity2 = ConversationScreen$lambda$1(stateCollectAsStateWithLifecycle).getActivity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1887141559, "CC(remember):ConversationScreen.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | composerStartRestartGroup.changed(lazyListStateRememberLazyListState);
            conversationScreenKt$ConversationScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                conversationScreenKt$ConversationScreen$1$1RememberedValue = new ConversationScreenKt$ConversationScreen$1$1(lazyListStateRememberLazyListState, stateCollectAsStateWithLifecycle, null);
                composerStartRestartGroup.updateRememberedValue(conversationScreenKt$ConversationScreen$1$1RememberedValue);
            } else {
                conversationScreenKt$ConversationScreen$1$1RememberedValue = new ConversationScreenKt$ConversationScreen$1$1(lazyListStateRememberLazyListState, stateCollectAsStateWithLifecycle, null);
                composerStartRestartGroup.updateRememberedValue(conversationScreenKt$ConversationScreen$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(numValueOf2, boolValueOf2, activity2, (Function2) conversationScreenKt$ConversationScreen$1$1RememberedValue, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1887148945, "CC(remember):ConversationScreen.kt#9igjgp");
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.Companion.getEmpty()) {
                Object systemService2 = context.getSystemService("audio");
                Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.media.AudioManager");
                objRememberedValue3 = (AudioManager) systemService2;
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            audioManager = (AudioManager) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1887152044, "CC(remember):ConversationScreen.kt#9igjgp");
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.Companion.getEmpty()) {
                objRememberedValue4 = Integer.valueOf(audioManager.getStreamMaxVolume(3));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            iIntValue = ((Number) objRememberedValue4).intValue();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1887155113, "CC(remember):ConversationScreen.kt#9igjgp");
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                objRememberedValue5 = Integer.valueOf(audioManager.getStreamVolume(3));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            iIntValue2 = ((Number) objRememberedValue5).intValue();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            strStringResource = StringResources_androidKt.stringResource(R.string.conversation_snackbar_volume_info, new Object[]{50}, composerStartRestartGroup, 0);
            Unit unit4 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1887162229, "CC(remember):ConversationScreen.kt#9igjgp");
            zChangedInstance = composerStartRestartGroup.changedInstance(audioManager) | composerStartRestartGroup.changed(strStringResource) | composerStartRestartGroup.changedInstance(view);
            conversationScreenKt$ConversationScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance) {
                ConversationScreenKt$ConversationScreen$2$1 conversationScreenKt$ConversationScreen$2$2 = new ConversationScreenKt$ConversationScreen$2$1(iIntValue2, iIntValue, audioManager, snackbarHostState, strStringResource, view, null);
                view2 = view;
                conversationScreenKt$ConversationScreen$2$1RememberedValue = conversationScreenKt$ConversationScreen$2$2;
                composerStartRestartGroup.updateRememberedValue(conversationScreenKt$ConversationScreen$2$1RememberedValue);
            } else {
                ConversationScreenKt$ConversationScreen$2$1 conversationScreenKt$ConversationScreen$2$3 = new ConversationScreenKt$ConversationScreen$2$1(iIntValue2, iIntValue, audioManager, snackbarHostState, strStringResource, view, null);
                view2 = view;
                conversationScreenKt$ConversationScreen$2$1RememberedValue = conversationScreenKt$ConversationScreen$2$3;
                composerStartRestartGroup.updateRememberedValue(conversationScreenKt$ConversationScreen$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(unit4, (Function2) conversationScreenKt$ConversationScreen$2$1RememberedValue, composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1887175111, "CC(remember):ConversationScreen.kt#9igjgp");
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == Composer.Companion.getEmpty()) {
                i5 = 0;
                objRememberedValue6 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            } else {
                i5 = 0;
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            strStringResource2 = StringResources_androidKt.stringResource(R.string.conversation_snackbar_permission_warning, composerStartRestartGroup, i5);
            ActivityResultContract requestPermission2 = new ActivityResultContracts.RequestPermission();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1887185532, "CC(remember):ConversationScreen.kt#9igjgp");
            zChangedInstance2 = composerStartRestartGroup.changedInstance(conversationViewModel4) | composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changed(strStringResource2) | composerStartRestartGroup.changedInstance(context);
            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance2) {
                final ConversationViewModel conversationViewModel7 = conversationViewModel4;
                objRememberedValue7 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda29
                    public final Object invoke(Object obj2) {
                        return ConversationScreenKt.ConversationScreen$lambda$11$lambda$10(conversationViewModel7, coroutineScope, context, snackbarHostState, strStringResource2, ((Boolean) obj2).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            } else {
                final ConversationViewModel conversationViewModel8 = conversationViewModel4;
                objRememberedValue7 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda29
                    public final Object invoke(Object obj2) {
                        return ConversationScreenKt.ConversationScreen$lambda$11$lambda$10(conversationViewModel8, coroutineScope, context, snackbarHostState, strStringResource2, ((Boolean) obj2).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            managedActivityResultLauncherRememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(requestPermission2, (Function1) objRememberedValue7, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1887207936, "CC(remember):ConversationScreen.kt#9igjgp");
            if ((i4 & 112) != 32) {
                z = true;
            } else {
                z = true;
            }
            zChangedInstance3 = z | composerStartRestartGroup.changedInstance(conversationViewModel4) | composerStartRestartGroup.changedInstance(lifecycleOwner);
            objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance3) {
                objRememberedValue8 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda31
                    public final Object invoke(Object obj2) {
                        return ConversationScreenKt.ConversationScreen$lambda$15$lambda$14(lifecycleOwner, conversationSharedViewModel, conversationViewModel4, (DisposableEffectScope) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            } else {
                objRememberedValue8 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda31
                    public final Object invoke(Object obj2) {
                        return ConversationScreenKt.ConversationScreen$lambda$15$lambda$14(lifecycleOwner, conversationSharedViewModel, conversationViewModel4, (DisposableEffectScope) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.DisposableEffect(lifecycleOwner, (Function1) objRememberedValue8, composerStartRestartGroup, 0);
            Unit unit5 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1887228457, "CC(remember):ConversationScreen.kt#9igjgp");
            boolean zChangedInstance9 = composerStartRestartGroup.changedInstance(uiEvent) | composerStartRestartGroup.changedInstance(context) | composerStartRestartGroup.changedInstance(view2) | composerStartRestartGroup.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult);
            if ((i4 & 458752) == 131072) {
                z2 = true;
            } else {
                z2 = false;
            }
            z3 = zChangedInstance9 | z2;
            Object objRememberedValue14 = composerStartRestartGroup.rememberedValue();
            if (z3) {
                context2 = context;
                composer2 = composerStartRestartGroup;
                obj = null;
                conversationScreenKt$ConversationScreen$4$1 = new ConversationScreenKt$ConversationScreen$4$1(uiEvent, snackbarHostState, context2, view2, managedActivityResultLauncherRememberLauncherForActivityResult, function1, null);
                composer2.updateRememberedValue(conversationScreenKt$ConversationScreen$4$1);
            } else {
                context2 = context;
                composer2 = composerStartRestartGroup;
                obj = null;
                conversationScreenKt$ConversationScreen$4$1 = new ConversationScreenKt$ConversationScreen$4$1(uiEvent, snackbarHostState, context2, view2, managedActivityResultLauncherRememberLauncherForActivityResult, function1, null);
                composer2.updateRememberedValue(conversationScreenKt$ConversationScreen$4$1);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            EffectsKt.LaunchedEffect(unit5, (Function2) conversationScreenKt$ConversationScreen$4$1, composer2, 6);
            Unit unit6 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 1887259553, (String) r15);
            zChangedInstance4 = composer2.changedInstance(conversationViewModel4);
            objRememberedValue9 = composer2.rememberedValue();
            if (!zChangedInstance4) {
                objRememberedValue9 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda32
                    public final Object invoke(Object obj2) {
                        return ConversationScreenKt.ConversationScreen$lambda$19$lambda$18(conversationViewModel4, (DisposableEffectScope) obj2);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue9);
            } else {
                objRememberedValue9 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda32
                    public final Object invoke(Object obj2) {
                        return ConversationScreenKt.ConversationScreen$lambda$19$lambda$18(conversationViewModel4, (DisposableEffectScope) obj2);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue9);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            EffectsKt.DisposableEffect(unit6, (Function1) objRememberedValue9, composer2, 6);
            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, obj);
            ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxSize$default2);
            constructor = ComposeUiNode.Companion.getConstructor();
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
            Composer composer5 = Updater.constructor-impl(composer2);
            Updater.set-impl(composer5, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer5, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer5, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer5, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -1956545824, "C212@10577L877,417@21119L179,414@21030L63,228@11478L9523,210@10500L10808:ConversationScreen.kt#6g1srx");
            Modifier modifierImePadding2 = WindowInsetsPadding_androidKt.imePadding(Modifier.Companion);
            Function2 function2RememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(-703214993, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda33
                public final Object invoke(Object obj2, Object obj3) {
                    return ConversationScreenKt.ConversationScreen$lambda$80$lambda$24(function0, conversationViewModel4, stateCollectAsStateWithLifecycle, mutableState2, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, 54);
            Function2 function2RememberComposableLambda5 = ComposableLambdaKt.rememberComposableLambda(1457341552, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda34
                public final Object invoke(Object obj2, Object obj3) {
                    return ConversationScreenKt.ConversationScreen$lambda$80$lambda$27(conversationViewModel4, stateCollectAsStateWithLifecycle, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, 54);
            Function2 function2RememberComposableLambda6 = ComposableLambdaKt.rememberComposableLambda(-677069199, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda35
                public final Object invoke(Object obj2, Object obj3) {
                    return ConversationScreenKt.ConversationScreen$lambda$80$lambda$28(snackbarHostState, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, 54);
            Composer composer6 = composer2;
            Modifier modifier6 = modifier4;
            final ConversationViewModel conversationViewModel9 = conversationViewModel4;
            final Context context4 = context2;
            conversationViewModel3 = conversationViewModel9;
            ScaffoldKt.Scaffold-TvnljyQ(modifierImePadding2, function2RememberComposableLambda4, function2RememberComposableLambda5, function2RememberComposableLambda6, (Function2) null, 0, 0L, 0L, (WindowInsets) null, ComposableLambdaKt.rememberComposableLambda(-385675974, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return ConversationScreenKt.ConversationScreen$lambda$80$lambda$73(conversationViewModel9, lazyListStateRememberLazyListState, stateCollectAsStateWithLifecycle, context4, webViewManager, mutableState2, (PaddingValues) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composer6, 54), composer6, 805309872, 496);
            composerStartRestartGroup = composer6;
            if (ConversationScreen$lambda$1(stateCollectAsStateWithLifecycle).getActiveActionElement() instanceof ConversationActionElement.TextToSpeechDrawer) {
                composerStartRestartGroup.startReplaceGroup(-1967321673);
            } else {
                composerStartRestartGroup.startReplaceGroup(-1946071886);
                ComposerKt.sourceInformation(composerStartRestartGroup, "431@21667L110,434@21811L104,437@21943L109,425@21413L653");
                Modifier modifierStatusBarsPadding2 = WindowInsetsPadding_androidKt.statusBarsPadding(ZIndexModifierKt.zIndex(Modifier.Companion, 10.0f));
                String ttsText2 = ConversationScreen$lambda$1(stateCollectAsStateWithLifecycle).getTtsText();
                LanguageEnum ttsLanguage2 = ConversationScreen$lambda$1(stateCollectAsStateWithLifecycle).getTtsLanguage();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 491420825, "CC(remember):ConversationScreen.kt#9igjgp");
                zChangedInstance5 = composerStartRestartGroup.changedInstance(conversationViewModel3);
                objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance5) {
                    objRememberedValue10 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda2
                        public final Object invoke() {
                            return ConversationScreenKt.ConversationScreen$lambda$80$lambda$75$lambda$74(conversationViewModel3);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                } else {
                    objRememberedValue10 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda2
                        public final Object invoke() {
                            return ConversationScreenKt.ConversationScreen$lambda$80$lambda$75$lambda$74(conversationViewModel3);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                }
                Function0 function4 = (Function0) objRememberedValue10;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 491425427, "CC(remember):ConversationScreen.kt#9igjgp");
                zChangedInstance6 = composerStartRestartGroup.changedInstance(conversationViewModel3);
                objRememberedValue11 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance6) {
                    objRememberedValue11 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda3
                        public final Object invoke() {
                            return ConversationScreenKt.ConversationScreen$lambda$80$lambda$77$lambda$76(conversationViewModel3);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                } else {
                    objRememberedValue11 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda3
                        public final Object invoke() {
                            return ConversationScreenKt.ConversationScreen$lambda$80$lambda$77$lambda$76(conversationViewModel3);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                }
                Function0 function5 = (Function0) objRememberedValue11;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 491429656, "CC(remember):ConversationScreen.kt#9igjgp");
                zChangedInstance7 = composerStartRestartGroup.changedInstance(conversationViewModel3);
                objRememberedValue12 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance7) {
                    objRememberedValue12 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda4
                        public final Object invoke() {
                            return ConversationScreenKt.ConversationScreen$lambda$80$lambda$79$lambda$78(conversationViewModel3);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue12);
                } else {
                    objRememberedValue12 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda4
                        public final Object invoke() {
                            return ConversationScreenKt.ConversationScreen$lambda$80$lambda$79$lambda$78(conversationViewModel3);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue12);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                TtsDrawerKt.TtsDrawer(modifierStatusBarsPadding2, ttsText2, ttsLanguage2, function4, function5, (Function0) objRememberedValue12, composerStartRestartGroup, 0, 0);
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier6;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            conversationViewModel3 = conversationViewModel2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda30
                public final Object invoke(Object obj2, Object obj3) {
                    return ConversationScreenKt.ConversationScreen$lambda$81(modifier3, conversationSharedViewModel, conversationViewModel3, webViewManager, function0, function1, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    private static final boolean ConversationScreen$lambda$8(MutableState<Boolean> mutableState) {
        return ((Boolean) ((State) mutableState).getValue()).booleanValue();
    }

    private static final void ConversationScreen$lambda$9(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit ConversationScreen$lambda$11$lambda$10(ConversationViewModel conversationViewModel, CoroutineScope coroutineScope, Context context, SnackbarHostState snackbarHostState, String str, boolean z) throws NoWhenBranchMatchedException {
        if (z) {
            conversationViewModel.onAction(ConversationUiAction.OnMicrophonePermissionGranted.INSTANCE);
        } else {
            BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ConversationScreenKt$ConversationScreen$microphonePermissionLauncher$1$1$1(snackbarHostState, str, null), 3, (Object) null);
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", context.getPackageName(), null));
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult ConversationScreen$lambda$15$lambda$14(final LifecycleOwner lifecycleOwner, final ConversationSharedViewModel conversationSharedViewModel, final ConversationViewModel conversationViewModel, DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        final LifecycleObserver lifecycleObserver = new LifecycleEventObserver() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda6
            /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) throws NoWhenBranchMatchedException {
                ConversationScreenKt.ConversationScreen$lambda$15$lambda$14$lambda$12(conversationSharedViewModel, conversationViewModel, lifecycleOwner2, event);
            }
        };
        lifecycleOwner.getLifecycle().addObserver(lifecycleObserver);
        return new DisposableEffectResult() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$ConversationScreen$lambda$15$lambda$14$$inlined$onDispose$1
            public void dispose() {
                lifecycleOwner.getLifecycle().removeObserver(lifecycleObserver);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final void ConversationScreen$lambda$15$lambda$14$lambda$12(ConversationSharedViewModel conversationSharedViewModel, ConversationViewModel conversationViewModel, LifecycleOwner lifecycleOwner, Lifecycle.Event event) throws NoWhenBranchMatchedException {
        String strConsumeScannedText;
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event != Lifecycle.Event.ON_RESUME || (strConsumeScannedText = conversationSharedViewModel.consumeScannedText()) == null) {
            return;
        }
        conversationViewModel.onAction(new ConversationUiAction.OnInterpretScannedDocument(strConsumeScannedText));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationScreen$lambda$80$lambda$24(Function0 function0, final ConversationViewModel conversationViewModel, State state, final MutableState mutableState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C215@10705L58,217@10949L86,220@11080L56,223@11286L136,213@10595L845:ConversationScreen.kt#6g1srx");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-703214993, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreen.<anonymous>.<anonymous> (ConversationScreen.kt:213)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            String strStringResource = StringResources_androidKt.stringResource(R.string.conversation_screen_title_default, composer, 0);
            Conversation conversation = ConversationScreen$lambda$1(state).getConversation();
            String conversationName = conversation != null ? conversation.getConversationName() : null;
            if (conversationName == null) {
                composer.startReplaceGroup(-1479733945);
                ComposerKt.sourceInformation(composer, "216@10852L56");
                conversationName = StringResources_androidKt.stringResource(R.string.conversation_screen_title_error, composer, 0);
            } else {
                composer.startReplaceGroup(-1479735247);
            }
            composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart(composer, -1479730811, "CC(remember):ConversationScreen.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda11
                    public final Object invoke() {
                        return ConversationScreenKt.ConversationScreen$lambda$80$lambda$24$lambda$21$lambda$20(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function1 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.conversation_screen_search_hint, composer, 0);
            String searchQuery = ConversationScreen$lambda$1(state).getSearchQuery();
            ComposerKt.sourceInformationMarkerStart(composer, -1479719977, "CC(remember):ConversationScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(conversationViewModel);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda22
                    public final Object invoke(Object obj) {
                        return ConversationScreenKt.ConversationScreen$lambda$80$lambda$24$lambda$23$lambda$22(conversationViewModel, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ConversationTopBarKt.ConversationScreenTopBar(modifierFillMaxWidth$default, strStringResource, conversationName, function1, strStringResource2, searchQuery, function0, (Function1) objRememberedValue2, composer, 3078, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationScreen$lambda$80$lambda$24$lambda$21$lambda$20(MutableState mutableState) {
        ConversationScreen$lambda$9(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit ConversationScreen$lambda$80$lambda$24$lambda$23$lambda$22(ConversationViewModel conversationViewModel, String str) throws NoWhenBranchMatchedException {
        Intrinsics.checkNotNullParameter(str, "query");
        conversationViewModel.onAction(new ConversationUiAction.OnSearchQueryChange(str));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationScreen$lambda$80$lambda$73(final ConversationViewModel conversationViewModel, LazyListState lazyListState, final State state, final Context context, WebViewManager webViewManager, final MutableState mutableState, PaddingValues paddingValues, Composer composer, int i) {
        int i2;
        String str;
        Modifier modifier;
        int i3;
        String conversationName;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer, "C229@11513L4652:ConversationScreen.kt#6g1srx");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(paddingValues) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-385675974, i2, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreen.<anonymous>.<anonymous> (ConversationScreen.kt:229)");
            }
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(PaddingKt.padding(Modifier.Companion, paddingValues), 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxSize$default);
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
            Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1336330878, "C238@11879L98,243@12089L3506,234@11685L3910:ConversationScreen.kt#6g1srx");
            Modifier modifier2 = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(8), 0.0f, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 788178390, "CC(remember):ConversationScreen.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda7
                    public final Object invoke(Object obj) {
                        return ConversationScreenKt.ConversationScreen$lambda$80$lambda$73$lambda$46$lambda$30$lambda$29((SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 788188518, "CC(remember):ConversationScreen.kt#9igjgp");
            boolean zChanged = composer.changed(state) | composer.changedInstance(context) | composer.changedInstance(conversationViewModel);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda15
                    public final Object invoke(Object obj) {
                        return ConversationScreenKt.ConversationScreen$lambda$80$lambda$73$lambda$46$lambda$43$lambda$42(state, context, conversationViewModel, (LazyListScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            LazyDslKt.LazyColumn(modifierSemantics$default, lazyListState, (PaddingValues) null, true, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) objRememberedValue2, composer, 3072, 500);
            Composer composer3 = composer;
            if (!(ConversationScreen$lambda$1(state).getActiveActionElement() instanceof ConversationActionElement.InterpretationWebView)) {
                composer3.startReplaceGroup(-1348061682);
            } else {
                composer3.startReplaceGroup(-1332471503);
                ComposerKt.sourceInformation(composer3, "307@15965L133,304@15727L397");
                ConversationActionElement activeActionElement = ConversationScreen$lambda$1(state).getActiveActionElement();
                Intrinsics.checkNotNull(activeActionElement, "null cannot be cast to non-null type com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationActionElement.InterpretationWebView");
                ConversationActionElement.InterpretationWebView interpretationWebView = (ConversationActionElement.InterpretationWebView) activeActionElement;
                ComposerKt.sourceInformationMarkerStart(composer3, 788309177, "CC(remember):ConversationScreen.kt#9igjgp");
                boolean zChangedInstance = composer3.changedInstance(conversationViewModel);
                Object objRememberedValue3 = composer3.rememberedValue();
                if (zChangedInstance || objRememberedValue3 == Composer.Companion.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda16
                        public final Object invoke() {
                            return ConversationScreenKt.ConversationScreen$lambda$80$lambda$73$lambda$46$lambda$45$lambda$44(conversationViewModel);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                DraggableFloatingWebViewKt.ConversationWebView(null, webViewManager, interpretationWebView, (Function0) objRememberedValue3, composer3, 0, 1);
            }
            composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            if (!ConversationScreen$lambda$1(state).isLanguageAnnouncementPopUpVisible()) {
                composer3.startReplaceGroup(-646811800);
            } else {
                composer3.startReplaceGroup(-630693164);
                ComposerKt.sourceInformation(composer3, "319@16417L136,318@16379L2,322@16597L126,316@16253L492");
                LanguageEnum speakerLang = ConversationScreen$lambda$1(state).getSpeakerLang();
                ComposerKt.sourceInformationMarkerStart(composer3, -1267265374, "CC(remember):ConversationScreen.kt#9igjgp");
                boolean zChangedInstance2 = composer3.changedInstance(conversationViewModel);
                Object objRememberedValue4 = composer3.rememberedValue();
                if (zChangedInstance2 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                    objRememberedValue4 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda17
                        public final Object invoke() {
                            return ConversationScreenKt.ConversationScreen$lambda$80$lambda$73$lambda$48$lambda$47(conversationViewModel);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue4);
                }
                Function0 function0 = (Function0) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1267266724, "CC(remember):ConversationScreen.kt#9igjgp");
                Object objRememberedValue5 = composer3.rememberedValue();
                if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                    objRememberedValue5 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda18
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue5);
                }
                Function0 function1 = (Function0) objRememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1267259624, "CC(remember):ConversationScreen.kt#9igjgp");
                boolean zChangedInstance3 = composer3.changedInstance(conversationViewModel);
                Object objRememberedValue6 = composer3.rememberedValue();
                if (zChangedInstance3 || objRememberedValue6 == Composer.Companion.getEmpty()) {
                    objRememberedValue6 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda19
                        public final Object invoke() {
                            return ConversationScreenKt.ConversationScreen$lambda$80$lambda$73$lambda$52$lambda$51(conversationViewModel);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                LanguageAnnouncementPopUpKt.LanguageAnnouncementPopup(null, speakerLang, function0, function1, (Function0) objRememberedValue6, 0L, composer, 3072, 33);
                composer3 = composer;
            }
            composer3.endReplaceGroup();
            if (!ConversationScreen$lambda$1(state).isLanguageSelectionDialogVisible()) {
                composer3.startReplaceGroup(-646811800);
            } else {
                composer3.startReplaceGroup(-630095856);
                ComposerKt.sourceInformation(composer3, "336@17276L239,333@17105L126,329@16849L688");
                Modifier modifierRotate = RotateKt.rotate(Modifier.Companion, 180.0f);
                List entries = LanguageEnum.getEntries();
                LanguageEnum speakerLang2 = ConversationScreen$lambda$1(state).getSpeakerLang();
                List list = entries;
                ComposerKt.sourceInformationMarkerStart(composer3, -1267237783, "CC(remember):ConversationScreen.kt#9igjgp");
                boolean zChangedInstance4 = composer3.changedInstance(conversationViewModel);
                Object objRememberedValue7 = composer3.rememberedValue();
                if (zChangedInstance4 || objRememberedValue7 == Composer.Companion.getEmpty()) {
                    objRememberedValue7 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda20
                        public final Object invoke(Object obj) {
                            return ConversationScreenKt.ConversationScreen$lambda$80$lambda$73$lambda$54$lambda$53(conversationViewModel, (LanguageEnum) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue7);
                }
                Function1 function2 = (Function1) objRememberedValue7;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1267243368, "CC(remember):ConversationScreen.kt#9igjgp");
                boolean zChangedInstance5 = composer3.changedInstance(conversationViewModel);
                Object objRememberedValue8 = composer3.rememberedValue();
                if (zChangedInstance5 || objRememberedValue8 == Composer.Companion.getEmpty()) {
                    objRememberedValue8 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda21
                        public final Object invoke() {
                            return ConversationScreenKt.ConversationScreen$lambda$80$lambda$73$lambda$56$lambda$55(conversationViewModel);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue8);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                LanguageSelectionDialogBoxKt.LanguageSelectionDialogBox(modifierRotate, list, speakerLang2, function2, (Function0) objRememberedValue8, composer, 6, 0);
                composer3 = composer;
            }
            composer3.endReplaceGroup();
            if (!ConversationScreen$lambda$8(mutableState)) {
                str = "CC(remember):ConversationScreen.kt#9igjgp";
                modifier = null;
                i3 = 0;
                composer3.startReplaceGroup(-646811800);
            } else {
                composer3.startReplaceGroup(-629317880);
                ComposerKt.sourceInformation(composer3, "346@17693L57,347@17796L43,349@17968L95,352@18101L237,345@17632L728");
                String strStringResource = StringResources_androidKt.stringResource(R.string.conversation_dialog_rename_title, composer3, 0);
                String strStringResource2 = StringResources_androidKt.stringResource(R.string.global_action_save, composer3, 0);
                Conversation conversation = ConversationScreen$lambda$1(state).getConversation();
                if (conversation == null || (conversationName = conversation.getConversationName()) == null) {
                    conversationName = "";
                }
                ComposerKt.sourceInformationMarkerStart(composer3, -1267215783, "CC(remember):ConversationScreen.kt#9igjgp");
                Object objRememberedValue9 = composer3.rememberedValue();
                if (objRememberedValue9 == Composer.Companion.getEmpty()) {
                    objRememberedValue9 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda23
                        public final Object invoke() {
                            return ConversationScreenKt.ConversationScreen$lambda$80$lambda$73$lambda$58$lambda$57(mutableState);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue9);
                }
                Function0 function3 = (Function0) objRememberedValue9;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1267211385, "CC(remember):ConversationScreen.kt#9igjgp");
                boolean zChangedInstance6 = composer3.changedInstance(conversationViewModel);
                Object objRememberedValue10 = composer3.rememberedValue();
                if (zChangedInstance6 || objRememberedValue10 == Composer.Companion.getEmpty()) {
                    objRememberedValue10 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda24
                        public final Object invoke(Object obj) {
                            return ConversationScreenKt.ConversationScreen$lambda$80$lambda$73$lambda$60$lambda$59(conversationViewModel, mutableState, (String) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue10);
                }
                Function1 function4 = (Function1) objRememberedValue10;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                str = "CC(remember):ConversationScreen.kt#9igjgp";
                i3 = 0;
                modifier = null;
                CreateNewConversationDialogKt.ConversationNameInputDialog(null, strStringResource, strStringResource2, conversationName, function3, function4, composer3, 24576, 1);
            }
            composer3.endReplaceGroup();
            if (!(ConversationScreen$lambda$1(state).getActiveDrawer() instanceof ConversationDrawer.Settings)) {
                composer3.startReplaceGroup(-646811800);
            } else {
                composer3.startReplaceGroup(-628489870);
                ComposerKt.sourceInformation(composer3, "365@18811L104,360@18475L462");
                boolean zIsCorrectionSuggestionsEnabled = ConversationScreen$lambda$1(state).isCorrectionSuggestionsEnabled();
                ConversationMode conversationMode = ConversationScreen$lambda$1(state).getConversationMode();
                LanguageEnum userLang = ConversationScreen$lambda$1(state).getUserLang();
                LanguageEnum speakerLang3 = ConversationScreen$lambda$1(state).getSpeakerLang();
                ComposerKt.sourceInformationMarkerStart(composer3, -1267188798, str);
                boolean zChangedInstance7 = composer3.changedInstance(conversationViewModel);
                Object objRememberedValue11 = composer3.rememberedValue();
                if (zChangedInstance7 || objRememberedValue11 == Composer.Companion.getEmpty()) {
                    objRememberedValue11 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda8
                        public final Object invoke(Object obj) {
                            return ConversationScreenKt.ConversationScreen$lambda$80$lambda$73$lambda$62$lambda$61(conversationViewModel, (ConversationUiAction) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue11);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ConfigurationBottomSheetKt.ConfigBottomSheet(null, zIsCorrectionSuggestionsEnabled, conversationMode, userLang, speakerLang3, (Function1) objRememberedValue11, composer3, 0, 1);
            }
            composer3.endReplaceGroup();
            if (!(ConversationScreen$lambda$1(state).getActiveDrawer() instanceof ConversationDrawer.InputSuggestions)) {
                composer3.startReplaceGroup(-646811800);
            } else {
                composer3.startReplaceGroup(-627916649);
                ComposerKt.sourceInformation(composer3, "374@19167L104,372@19060L233");
                ConversationUiState conversationUiStateConversationScreen$lambda$1 = ConversationScreen$lambda$1(state);
                ComposerKt.sourceInformationMarkerStart(composer3, -1267177406, str);
                boolean zChangedInstance8 = composer3.changedInstance(conversationViewModel);
                Object objRememberedValue12 = composer3.rememberedValue();
                if (zChangedInstance8 || objRememberedValue12 == Composer.Companion.getEmpty()) {
                    objRememberedValue12 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda9
                        public final Object invoke(Object obj) {
                            return ConversationScreenKt.ConversationScreen$lambda$80$lambda$73$lambda$64$lambda$63(conversationViewModel, (ConversationUiAction) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue12);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                InputSuggestionBottomSheetKt.InputSuggestionsBottomSheet(null, conversationUiStateConversationScreen$lambda$1, (Function1) objRememberedValue12, composer3, 0, 1);
            }
            composer3.endReplaceGroup();
            if (!(ConversationScreen$lambda$1(state).getSaveInputSuggestionDialogState() instanceof SaveInputSuggestionDialogState.Show)) {
                composer3.startReplaceGroup(-646811800);
            } else {
                composer3.startReplaceGroup(-627523662);
                ComposerKt.sourceInformation(composer3, "384@19736L142,387@19913L441,381@19434L942");
                SaveInputSuggestionDialogState saveInputSuggestionDialogState = ConversationScreen$lambda$1(state).getSaveInputSuggestionDialogState();
                Intrinsics.checkNotNull(saveInputSuggestionDialogState, "null cannot be cast to non-null type com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.SaveInputSuggestionDialogState.Show");
                CorrectionSuggestion correctionSuggestion = ((SaveInputSuggestionDialogState.Show) saveInputSuggestionDialogState).getCorrectionSuggestion();
                List<SuggestionCategory> conversationSuggestionCategories = ConversationScreen$lambda$1(state).getConversationSuggestionCategories();
                ComposerKt.sourceInformationMarkerStart(composer3, -1267159160, str);
                boolean zChangedInstance9 = composer3.changedInstance(conversationViewModel);
                Object objRememberedValue13 = composer3.rememberedValue();
                if (zChangedInstance9 || objRememberedValue13 == Composer.Companion.getEmpty()) {
                    objRememberedValue13 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda10
                        public final Object invoke() {
                            return ConversationScreenKt.ConversationScreen$lambda$80$lambda$73$lambda$66$lambda$65(conversationViewModel);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue13);
                }
                Function0 function5 = (Function0) objRememberedValue13;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1267153197, str);
                boolean zChangedInstance10 = composer3.changedInstance(conversationViewModel);
                Object objRememberedValue14 = composer3.rememberedValue();
                if (zChangedInstance10 || objRememberedValue14 == Composer.Companion.getEmpty()) {
                    objRememberedValue14 = new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda12
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return ConversationScreenKt.ConversationScreen$lambda$80$lambda$73$lambda$68$lambda$67(conversationViewModel, (SuggestionCategory) obj, (String) obj2, (CorrectionSuggestion) obj3);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue14);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                SaveInputSuggestionDialogKt.SaveInputSuggestionDialog(null, correctionSuggestion, conversationSuggestionCategories, function5, (Function3) objRememberedValue14, composer, 0, 1);
                composer3 = composer;
            }
            composer3.endReplaceGroup();
            if (!(ConversationScreen$lambda$1(state).getActiveDrawer() instanceof ConversationDrawer.Input)) {
                composer3.startReplaceGroup(-646811800);
            } else {
                composer3.startReplaceGroup(-626501747);
                ComposerKt.sourceInformation(composer3, "401@20541L104,400@20488L179");
                ComposerKt.sourceInformationMarkerStart(composer3, -1267133438, str);
                boolean zChangedInstance11 = composer3.changedInstance(conversationViewModel);
                Object objRememberedValue15 = composer3.rememberedValue();
                if (zChangedInstance11 || objRememberedValue15 == Composer.Companion.getEmpty()) {
                    objRememberedValue15 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda13
                        public final Object invoke(Object obj) {
                            return ConversationScreenKt.ConversationScreen$lambda$80$lambda$73$lambda$70$lambda$69(conversationViewModel, (ConversationUiAction) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue15);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                InputBottomSheetKt.InputBottomSheet(modifier, (Function1) objRememberedValue15, composer3, i3, 1);
            }
            composer3.endReplaceGroup();
            if (!ConversationScreen$lambda$1(state).isProcessingIndicatorVisible()) {
                composer3.startReplaceGroup(-646811800);
            } else {
                composer3.startReplaceGroup(-626224266);
                ComposerKt.sourceInformation(composer3, "409@20852L2,410@20888L59,408@20767L202");
                ComposerKt.sourceInformationMarkerStart(composer3, -1267123588, str);
                Object objRememberedValue16 = composer3.rememberedValue();
                if (objRememberedValue16 == Composer.Companion.getEmpty()) {
                    objRememberedValue16 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda14
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue16);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                CircularProgressIndicatorDialogComponentKt.CircularProgressIndicatorDialogComponent(null, (Function0) objRememberedValue16, StringResources_androidKt.stringResource(R.string.conversation_dialog_progress_title, composer3, i3), composer3, 48, 1);
            }
            composer3.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationScreen$lambda$80$lambda$73$lambda$46$lambda$30$lambda$29(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setLiveRegion-hR3wRGc(semanticsPropertyReceiver, LiveRegionMode.Companion.getPolite-0phEisY());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationScreen$lambda$80$lambda$73$lambda$46$lambda$43$lambda$42(final State state, final Context context, final ConversationViewModel conversationViewModel, LazyListScope lazyListScope) {
        Intrinsics.checkNotNullParameter(lazyListScope, "$this$LazyColumn");
        if (ConversationScreen$lambda$1(state).getActivity() instanceof ConversationActivity.IsInterpreting) {
            if (ConversationScreen$lambda$1(state).isListeningEllipsisVisible()) {
                LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-2117613559, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda25
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ConversationScreenKt.ConversationScreen$lambda$80$lambda$73$lambda$46$lambda$43$lambda$42$lambda$34(context, state, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }), 3, (Object) null);
            }
            ConversationActivity activity = ConversationScreen$lambda$1(state).getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationActivity.IsInterpreting");
            final ConversationMessage conversationMessage = ((ConversationActivity.IsInterpreting) activity).getConversationMessage();
            LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(1516076100, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda26
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ConversationScreenKt.ConversationScreen$lambda$80$lambda$73$lambda$46$lambda$43$lambda$42$lambda$37(conversationMessage, conversationViewModel, state, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 3, (Object) null);
        } else {
            if (ConversationScreen$lambda$1(state).isPartialTextVisible()) {
                LazyListScope.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(963433760, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda27
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ConversationScreenKt.ConversationScreen$lambda$80$lambda$73$lambda$46$lambda$43$lambda$42$lambda$39(state, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }), 3, (Object) null);
            }
            final List listReversed = CollectionsKt.reversed(ConversationScreen$lambda$1(state).getConversationMessages());
            final ConversationScreenKt$ConversationScreen$lambda$80$lambda$73$lambda$46$lambda$43$lambda$42$$inlined$items$default$1 conversationScreenKt$ConversationScreen$lambda$80$lambda$73$lambda$46$lambda$43$lambda$42$$inlined$items$default$1 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$ConversationScreen$lambda$80$lambda$73$lambda$46$lambda$43$lambda$42$$inlined$items$default$1
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final Void m1641invoke(ConversationMessage conversationMessage2) {
                    return null;
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return m1641invoke((ConversationMessage) obj);
                }
            };
            lazyListScope.items(listReversed.size(), (Function1) null, new Function1<Integer, Object>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$ConversationScreen$lambda$80$lambda$73$lambda$46$lambda$43$lambda$42$$inlined$items$default$3
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).intValue());
                }

                public final Object invoke(int i) {
                    return conversationScreenKt$ConversationScreen$lambda$80$lambda$73$lambda$46$lambda$43$lambda$42$$inlined$items$default$1.invoke(listReversed.get(i));
                }
            }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$ConversationScreen$lambda$80$lambda$73$lambda$46$lambda$43$lambda$42$$inlined$items$default$4
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
                    ConversationMessage conversationMessage2 = (ConversationMessage) listReversed.get(i);
                    composer.startReplaceGroup(-1188808653);
                    ComposerKt.sourceInformation(composer, "C*294@15245L156,290@14954L563:ConversationScreen.kt#6g1srx");
                    Modifier modifier = PaddingKt.padding-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(4), 1, (Object) null);
                    boolean zIsSpeakerDetectionEnabled = ConversationScreenKt.ConversationScreen$lambda$1(state).isSpeakerDetectionEnabled();
                    long sp = TextUnitKt.getSp(ConversationScreenKt.ConversationScreen$lambda$1(state).getTranscriptFontSize());
                    ComposerKt.sourceInformationMarkerStart(composer, -1839455079, "CC(remember):ConversationScreen.kt#9igjgp");
                    boolean zChangedInstance = composer.changedInstance(conversationViewModel);
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                        final ConversationViewModel conversationViewModel2 = conversationViewModel;
                        objRememberedValue = (Function1) new Function1<ConversationUiAction, Unit>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$ConversationScreen$6$4$1$2$1$4$1$1
                            /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) throws NoWhenBranchMatchedException {
                                invoke((ConversationUiAction) obj);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                            public final void invoke(ConversationUiAction conversationUiAction) throws NoWhenBranchMatchedException {
                                Intrinsics.checkNotNullParameter(conversationUiAction, "conversationUiAction");
                                conversationViewModel2.onAction(conversationUiAction);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    TranscriptionBubbleKt.m1601TranscriptionBubblen82DnDo(modifier, conversationMessage2, zIsSpeakerDetectionEnabled, sp, (Function1) objRememberedValue, composer, 6, 0);
                    composer.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationScreen$lambda$80$lambda$73$lambda$46$lambda$43$lambda$42$lambda$34(final Context context, State state, LazyItemScope lazyItemScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(lazyItemScope, "$this$item");
        ComposerKt.sourceInformation(composer, "C250@12503L176,247@12323L812:ConversationScreen.kt#6g1srx");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2117613559, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ConversationScreen.kt:247)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 787875257, "CC(remember):ConversationScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(context);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        return ConversationScreenKt.ConversationScreen$lambda$80$lambda$73$lambda$46$lambda$43$lambda$42$lambda$34$lambda$32$lambda$31(context, (SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierFillMaxWidth$default, false, (Function1) objRememberedValue, 1, (Object) null);
            Alignment centerStart = Alignment.Companion.getCenterStart();
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(centerStart, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierSemantics$default);
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
            Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1534386305, "C255@12842L255:ConversationScreen.kt#6g1srx");
            EllipsisAnimationTranscriptBubbleKt.m1579EllipsisAnimationTranscriptBubbleKmRG4DE(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(4), 1, (Object) null), TextUnitKt.getSp(ConversationScreen$lambda$1(state).getTranscriptFontSize()), composer, 6, 0);
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
    public static final Unit ConversationScreen$lambda$80$lambda$73$lambda$46$lambda$43$lambda$42$lambda$34$lambda$32$lambda$31(Context context, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        String string = context.getString(R.string.conversation_bubble_cd_thinking);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, string);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationScreen$lambda$80$lambda$73$lambda$46$lambda$43$lambda$42$lambda$37(ConversationMessage conversationMessage, final ConversationViewModel conversationViewModel, State state, LazyItemScope lazyItemScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(lazyItemScope, "$this$item");
        ComposerKt.sourceInformation(composer, "C268@13703L156,264@13387L588:ConversationScreen.kt#6g1srx");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1516076100, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ConversationScreen.kt:264)");
            }
            Modifier modifier = PaddingKt.padding-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(4), 1, (Object) null);
            ConversationMessage conversationMessageCopy$default = ConversationMessage.copy$default(conversationMessage, 0L, 0L, null, null, null, null, null, 0, null, null, null, true, false, 0L, 14335, null);
            boolean zIsSpeakerDetectionEnabled = ConversationScreen$lambda$1(state).isSpeakerDetectionEnabled();
            long sp = TextUnitKt.getSp(ConversationScreen$lambda$1(state).getTranscriptFontSize());
            ComposerKt.sourceInformationMarkerStart(composer, 955230112, "CC(remember):ConversationScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(conversationViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj) {
                        return ConversationScreenKt.ConversationScreen$lambda$80$lambda$73$lambda$46$lambda$43$lambda$42$lambda$37$lambda$36$lambda$35(conversationViewModel, (ConversationUiAction) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            TranscriptionBubbleKt.m1601TranscriptionBubblen82DnDo(modifier, conversationMessageCopy$default, zIsSpeakerDetectionEnabled, sp, (Function1) objRememberedValue, composer, 6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit ConversationScreen$lambda$80$lambda$73$lambda$46$lambda$43$lambda$42$lambda$37$lambda$36$lambda$35(ConversationViewModel conversationViewModel, ConversationUiAction conversationUiAction) throws NoWhenBranchMatchedException {
        Intrinsics.checkNotNullParameter(conversationUiAction, "conversationUiAction");
        conversationViewModel.onAction(conversationUiAction);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationScreen$lambda$80$lambda$73$lambda$46$lambda$43$lambda$42$lambda$39(State state, LazyItemScope lazyItemScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(lazyItemScope, "$this$item");
        ComposerKt.sourceInformation(composer, "C277@14178L591:ConversationScreen.kt#6g1srx");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(963433760, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ConversationScreen.kt:277)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Alignment centerStart = Alignment.Companion.getCenterStart();
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(centerStart, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
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
            Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1854056366, "C281@14420L311:ConversationScreen.kt#6g1srx");
            PartialTextBubbleKt.m1595PartialTextBubblea5Y_hM(ConversationScreen$lambda$1(state).getPartialText(), PaddingKt.padding-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(4), 1, (Object) null), TextUnitKt.getSp(ConversationScreen$lambda$1(state).getTranscriptFontSize()), composer, 48, 0);
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
    public static final Unit ConversationScreen$lambda$80$lambda$73$lambda$46$lambda$45$lambda$44(ConversationViewModel conversationViewModel) throws NoWhenBranchMatchedException {
        conversationViewModel.onAction(ConversationUiAction.OnRestoreWebView.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit ConversationScreen$lambda$80$lambda$73$lambda$48$lambda$47(ConversationViewModel conversationViewModel) throws NoWhenBranchMatchedException {
        conversationViewModel.onAction(ConversationUiAction.OnShowSpeakerLanguageDialog.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit ConversationScreen$lambda$80$lambda$73$lambda$52$lambda$51(ConversationViewModel conversationViewModel) throws NoWhenBranchMatchedException {
        conversationViewModel.onAction(ConversationUiAction.OnInterpretSpeech.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit ConversationScreen$lambda$80$lambda$73$lambda$56$lambda$55(ConversationViewModel conversationViewModel) throws NoWhenBranchMatchedException {
        conversationViewModel.onAction(ConversationUiAction.OnInterpretSpeech.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit ConversationScreen$lambda$80$lambda$73$lambda$54$lambda$53(ConversationViewModel conversationViewModel, LanguageEnum languageEnum) throws NoWhenBranchMatchedException {
        Intrinsics.checkNotNullParameter(languageEnum, "targetLang");
        conversationViewModel.onAction(new ConversationUiAction.OnSetSpeakerLanguageAndStartInterpretation(languageEnum));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationScreen$lambda$80$lambda$73$lambda$58$lambda$57(MutableState mutableState) {
        ConversationScreen$lambda$9(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit ConversationScreen$lambda$80$lambda$73$lambda$60$lambda$59(ConversationViewModel conversationViewModel, MutableState mutableState, String str) throws NoWhenBranchMatchedException {
        Intrinsics.checkNotNullParameter(str, "conversationName");
        conversationViewModel.onAction(new ConversationUiAction.UpdateConversationName(str));
        ConversationScreen$lambda$9(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit ConversationScreen$lambda$80$lambda$73$lambda$62$lambda$61(ConversationViewModel conversationViewModel, ConversationUiAction conversationUiAction) throws NoWhenBranchMatchedException {
        Intrinsics.checkNotNullParameter(conversationUiAction, "action");
        conversationViewModel.onAction(conversationUiAction);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit ConversationScreen$lambda$80$lambda$73$lambda$64$lambda$63(ConversationViewModel conversationViewModel, ConversationUiAction conversationUiAction) throws NoWhenBranchMatchedException {
        Intrinsics.checkNotNullParameter(conversationUiAction, "action");
        conversationViewModel.onAction(conversationUiAction);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit ConversationScreen$lambda$80$lambda$73$lambda$66$lambda$65(ConversationViewModel conversationViewModel) throws NoWhenBranchMatchedException {
        conversationViewModel.onAction(ConversationUiAction.OnCorrectionSuggestionSaveDismiss.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit ConversationScreen$lambda$80$lambda$73$lambda$68$lambda$67(ConversationViewModel conversationViewModel, SuggestionCategory suggestionCategory, String str, CorrectionSuggestion correctionSuggestion) throws NoWhenBranchMatchedException {
        Intrinsics.checkNotNullParameter(str, "categoryName");
        Intrinsics.checkNotNullParameter(correctionSuggestion, "suggestionToSave");
        conversationViewModel.onAction(new ConversationUiAction.OnSaveCorrectionSuggestion(correctionSuggestion, suggestionCategory, str));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit ConversationScreen$lambda$80$lambda$73$lambda$70$lambda$69(ConversationViewModel conversationViewModel, ConversationUiAction conversationUiAction) throws NoWhenBranchMatchedException {
        Intrinsics.checkNotNullParameter(conversationUiAction, "action");
        conversationViewModel.onAction(conversationUiAction);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationScreen$lambda$80$lambda$28(SnackbarHostState snackbarHostState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C415@21048L31:ConversationScreen.kt#6g1srx");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-677069199, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreen.<anonymous>.<anonymous> (ConversationScreen.kt:415)");
            }
            SnackbarHostKt.SnackbarHost(snackbarHostState, (Modifier) null, (Function3) null, composer, 6, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationScreen$lambda$80$lambda$27(final ConversationViewModel conversationViewModel, State state, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C418@21191L92,418@21137L147:ConversationScreen.kt#6g1srx");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1457341552, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreen.<anonymous>.<anonymous> (ConversationScreen.kt:418)");
            }
            ConversationUiState conversationUiStateConversationScreen$lambda$1 = ConversationScreen$lambda$1(state);
            ComposerKt.sourceInformationMarkerStart(composer, 345895372, "CC(remember):ConversationScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(conversationViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$$ExternalSyntheticLambda28
                    public final Object invoke(Object obj) {
                        return ConversationScreenKt.ConversationScreen$lambda$80$lambda$27$lambda$26$lambda$25(conversationViewModel, (ConversationUiAction) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ConversationBottomBarKt.ConversationBottomBar(null, conversationUiStateConversationScreen$lambda$1, (Function1) objRememberedValue, composer, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit ConversationScreen$lambda$80$lambda$27$lambda$26$lambda$25(ConversationViewModel conversationViewModel, ConversationUiAction conversationUiAction) throws NoWhenBranchMatchedException {
        Intrinsics.checkNotNullParameter(conversationUiAction, "uiAction");
        conversationViewModel.onAction(conversationUiAction);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit ConversationScreen$lambda$80$lambda$75$lambda$74(ConversationViewModel conversationViewModel) throws NoWhenBranchMatchedException {
        conversationViewModel.onAction(ConversationUiAction.OnInterpretSpeech.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit ConversationScreen$lambda$80$lambda$77$lambda$76(ConversationViewModel conversationViewModel) throws NoWhenBranchMatchedException {
        conversationViewModel.onAction(ConversationUiAction.OnTtsRepeat.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit ConversationScreen$lambda$80$lambda$79$lambda$78(ConversationViewModel conversationViewModel) throws NoWhenBranchMatchedException {
        conversationViewModel.onAction(ConversationUiAction.OnTtsDrawerClose.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConversationUiState ConversationScreen$lambda$1(State<ConversationUiState> state) {
        return (ConversationUiState) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult ConversationScreen$lambda$19$lambda$18(final ConversationViewModel conversationViewModel, DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$ConversationScreen$lambda$19$lambda$18$$inlined$onDispose$1
            /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
            public void dispose() throws NoWhenBranchMatchedException {
                conversationViewModel.onAction(ConversationUiAction.OnStopInterpretationAndTranscription.INSTANCE);
                conversationViewModel.resetLanguageAnnouncementState();
                conversationViewModel.onAction(ConversationUiAction.OnHideDrawer.INSTANCE);
            }
        };
    }
}
