package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.speech.tts.Voice;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.FastForwardKt;
import androidx.compose.material.icons.filled.InfoKt;
import androidx.compose.material.icons.filled.Man4Kt;
import androidx.compose.material.icons.filled.RateReviewKt;
import androidx.compose.material.icons.filled.RecordVoiceOverKt;
import androidx.compose.material.icons.filled.ReplayKt;
import androidx.compose.material.icons.filled.ShareKt;
import androidx.compose.material.icons.filled.SpeedKt;
import androidx.compose.material.icons.filled.SurroundSoundKt;
import androidx.compose.material.icons.filled.TextFieldsKt;
import androidx.compose.material.icons.filled.UploadKt;
import androidx.compose.material.icons.filled.WhatsappKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SnackbarHostKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.SwitchColors;
import androidx.compose.material3.SwitchKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.core.content.ContextCompat;
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
import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.SimpleTopBarWithNavigationDrawerKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.conversationsettings.VoiceOption;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversationsettings.ConversationFontSizeSelectionDialogKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversationsettings.InterpretationSpeedSelectionDialogKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversationsettings.VoiceSelectionDialogBoxKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationSettingsAction;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationSettingsEvent;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationSettingsState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationSettingsViewModel;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.model.InterpretationMode;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.model.InterpretationSpeed;
import com.deepvisiontech.letstalksigntranscriptionapp.legacy.utils.UsageUtilsKt;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.flow.SharedFlow;

/* JADX INFO: compiled from: ConversationSettingsScreen.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a=\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\fH\u0007¢\u0006\u0002\u0010\u000e¨\u0006\u000f²\u0006\n\u0010\u0010\u001a\u00020\u0011X\u008a\u0084\u0002²\u0006\n\u0010\u0012\u001a\u00020\u0013X\u008a\u008e\u0002²\u0006\n\u0010\u0014\u001a\u00020\u0013X\u008a\u008e\u0002²\u0006\n\u0010\u0015\u001a\u00020\u0013X\u008a\u008e\u0002"}, d2 = {"openPlayStoreForReview", "", "context", "Landroid/content/Context;", "openWhatsAppCommunityLink", "openAppLinkShareIntent", "ConversationSettingsScreen", "modifier", "Landroidx/compose/ui/Modifier;", "conversationSettingsViewModel", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsViewModel;", "onDrawerClick", "Lkotlin/Function0;", "onNavigateToSignUpload", "(Landroidx/compose/ui/Modifier;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsViewModel;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_release", "uiState", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsState;", "isFontSizeDialogVisible", "", "isSignSpeedDialogVisible", "isVoiceSelectionDialogVisible"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ConversationSettingsScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationSettingsScreen$lambda$84(Modifier modifier, ConversationSettingsViewModel conversationSettingsViewModel, Function0 function0, Function0 function1, int i, int i2, Composer composer, int i3) {
        ConversationSettingsScreen(modifier, conversationSettingsViewModel, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    private static final void openPlayStoreForReview(Context context) {
        String packageName = context.getPackageName();
        try {
            String string = context.getString(R.string.deep_link_play_app_page, packageName);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(string)));
        } catch (Exception unused) {
            String string2 = context.getString(R.string.url_play_app_page, packageName);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(string2)));
        }
    }

    private static final void openWhatsAppCommunityLink(Context context) {
        String string = context.getString(R.string.url_whatsapp_channel);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(string)));
    }

    private static final void openAppLinkShareIntent(Context context) {
        String packageName = context.getPackageName();
        String string = context.getString(R.string.url_play_app_page);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(string, Arrays.copyOf(new Object[]{packageName}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        String string2 = context.getString(R.string.conversation_share_intent_text, str);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", string2);
        intent.setType("text/plain");
        context.startActivity(Intent.createChooser(intent, null));
    }

    public static final void ConversationSettingsScreen(Modifier modifier, ConversationSettingsViewModel conversationSettingsViewModel, final Function0<Unit> function0, final Function0<Unit> function1, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        ConversationSettingsViewModel conversationSettingsViewModel2;
        final ConversationSettingsViewModel conversationSettingsViewModel3;
        Modifier modifier3;
        int i4;
        final ConversationSettingsViewModel conversationSettingsViewModel4;
        CreationExtras defaultViewModelCreationExtras;
        Intrinsics.checkNotNullParameter(function0, "onDrawerClick");
        Intrinsics.checkNotNullParameter(function1, "onNavigateToSignUpload");
        Composer composerStartRestartGroup = composer.startRestartGroup(-504507382);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ConversationSettingsScreen)P(1)112@5719L7,114@5785L29,116@5899L32,120@6071L209,118@5967L313,128@6307L463,128@6286L484,141@6824L25,141@6807L42,142@6903L25,142@6886L42,143@6987L25,143@6970L42,147@7074L205,717@32103L55,153@7299L24779,145@7018L25146:ConversationSettingsScreen.kt#6g1srx");
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
                conversationSettingsViewModel2 = conversationSettingsViewModel;
                int i6 = composerStartRestartGroup.changedInstance(conversationSettingsViewModel2) ? 32 : 16;
                i3 |= i6;
            } else {
                conversationSettingsViewModel2 = conversationSettingsViewModel;
            }
            i3 |= i6;
        } else {
            conversationSettingsViewModel2 = conversationSettingsViewModel;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "108@5597L15");
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
                ConversationSettingsViewModel conversationSettingsViewModel5 = conversationSettingsViewModel2;
                i4 = i3;
                conversationSettingsViewModel4 = conversationSettingsViewModel5;
                modifier3 = modifier2;
            } else {
                modifier3 = i5 != 0 ? (Modifier) Modifier.Companion : modifier2;
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
                    ViewModel viewModel = ViewModelKt.viewModel(ConversationSettingsViewModel.class, current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 36936, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    conversationSettingsViewModel2 = (ConversationSettingsViewModel) viewModel;
                    i3 &= -113;
                }
                ConversationSettingsViewModel conversationSettingsViewModel6 = conversationSettingsViewModel2;
                i4 = i3;
                conversationSettingsViewModel4 = conversationSettingsViewModel6;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-504507382, i4, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationSettingsScreen (ConversationSettingsScreen.kt:111)");
            }
            CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Context context = (Context) objConsume;
            final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(conversationSettingsViewModel4.getUiState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            SharedFlow<ConversationSettingsEvent> uiEvent = conversationSettingsViewModel4.getUiEvent();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 499725994, "CC(remember):ConversationSettingsScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new SnackbarHostState();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final SnackbarHostState snackbarHostState = (SnackbarHostState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ActivityResultContract requestPermission = new ActivityResultContracts.RequestPermission();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 499731675, "CC(remember):ConversationSettingsScreen.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(conversationSettingsViewModel4);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationSettingsScreenKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        return ConversationSettingsScreenKt.ConversationSettingsScreen$lambda$4$lambda$3(conversationSettingsViewModel4, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(requestPermission, (Function1) objRememberedValue2, composerStartRestartGroup, 0);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 499739481, "CC(remember):ConversationSettingsScreen.kt#9igjgp");
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(uiEvent) | composerStartRestartGroup.changedInstance(context);
            ConversationSettingsScreenKt$ConversationSettingsScreen$1$1 conversationSettingsScreenKt$ConversationSettingsScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || conversationSettingsScreenKt$ConversationSettingsScreen$1$1RememberedValue == Composer.Companion.getEmpty()) {
                conversationSettingsScreenKt$ConversationSettingsScreen$1$1RememberedValue = new ConversationSettingsScreenKt$ConversationSettingsScreen$1$1(uiEvent, snackbarHostState, context, null);
                composerStartRestartGroup.updateRememberedValue(conversationSettingsScreenKt$ConversationSettingsScreen$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(unit, (Function2) conversationSettingsScreenKt$ConversationSettingsScreen$1$1RememberedValue, composerStartRestartGroup, 6);
            Object[] objArr = new Object[0];
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 499755587, "CC(remember):ConversationSettingsScreen.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.Companion.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationSettingsScreenKt$$ExternalSyntheticLambda11
                    public final Object invoke() {
                        return ConversationSettingsScreenKt.ConversationSettingsScreen$lambda$7$lambda$6();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final MutableState mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr, (Function0) objRememberedValue3, composerStartRestartGroup, 48);
            Object[] objArr2 = new Object[0];
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 499758115, "CC(remember):ConversationSettingsScreen.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.Companion.getEmpty()) {
                objRememberedValue4 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationSettingsScreenKt$$ExternalSyntheticLambda19
                    public final Object invoke() {
                        return ConversationSettingsScreenKt.ConversationSettingsScreen$lambda$11$lambda$10();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final MutableState mutableState2 = (MutableState) RememberSaveableKt.rememberSaveable(objArr2, (Function0) objRememberedValue4, composerStartRestartGroup, 48);
            Object[] objArr3 = new Object[0];
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 499760803, "CC(remember):ConversationSettingsScreen.kt#9igjgp");
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                objRememberedValue5 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationSettingsScreenKt$$ExternalSyntheticLambda20
                    public final Object invoke() {
                        return ConversationSettingsScreenKt.ConversationSettingsScreen$lambda$15$lambda$14();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final MutableState mutableState3 = (MutableState) RememberSaveableKt.rememberSaveable(objArr3, (Function0) objRememberedValue5, composerStartRestartGroup, 48);
            ConversationSettingsViewModel conversationSettingsViewModel7 = conversationSettingsViewModel4;
            modifier2 = modifier3;
            Composer composer2 = composerStartRestartGroup;
            ScaffoldKt.Scaffold-TvnljyQ(modifier2, ComposableLambdaKt.rememberComposableLambda(1182140102, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationSettingsScreenKt$$ExternalSyntheticLambda21
                public final Object invoke(Object obj, Object obj2) {
                    return ConversationSettingsScreenKt.ConversationSettingsScreen$lambda$18(function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), (Function2) null, ComposableLambdaKt.rememberComposableLambda(-770409852, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationSettingsScreenKt$$ExternalSyntheticLambda22
                public final Object invoke(Object obj, Object obj2) {
                    return ConversationSettingsScreenKt.ConversationSettingsScreen$lambda$19(snackbarHostState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), (Function2) null, 0, 0L, 0L, (WindowInsets) null, ComposableLambdaKt.rememberComposableLambda(317253275, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationSettingsScreenKt$$ExternalSyntheticLambda23
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ConversationSettingsScreenKt.ConversationSettingsScreen$lambda$83(conversationSettingsViewModel4, mutableState3, mutableState, mutableState2, stateCollectAsStateWithLifecycle, function1, context, managedActivityResultLauncherRememberLauncherForActivityResult, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, (i4 & 14) | 805309488, 500);
            composerStartRestartGroup = composer2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            conversationSettingsViewModel3 = conversationSettingsViewModel7;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            conversationSettingsViewModel3 = conversationSettingsViewModel2;
        }
        final Modifier modifier4 = modifier2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationSettingsScreenKt$$ExternalSyntheticLambda24
                public final Object invoke(Object obj, Object obj2) {
                    return ConversationSettingsScreenKt.ConversationSettingsScreen$lambda$84(modifier4, conversationSettingsViewModel3, function0, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationSettingsScreen$lambda$4$lambda$3(ConversationSettingsViewModel conversationSettingsViewModel, boolean z) {
        if (z) {
            conversationSettingsViewModel.onAction(new ConversationSettingsAction.OnToggleEnvironmentSignRecognizerState(true));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState ConversationSettingsScreen$lambda$7$lambda$6() {
        return SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    private static final boolean ConversationSettingsScreen$lambda$8(MutableState<Boolean> mutableState) {
        return ((Boolean) ((State) mutableState).getValue()).booleanValue();
    }

    private static final void ConversationSettingsScreen$lambda$9(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState ConversationSettingsScreen$lambda$11$lambda$10() {
        return SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    private static final boolean ConversationSettingsScreen$lambda$12(MutableState<Boolean> mutableState) {
        return ((Boolean) ((State) mutableState).getValue()).booleanValue();
    }

    private static final void ConversationSettingsScreen$lambda$13(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState ConversationSettingsScreen$lambda$15$lambda$14() {
        return SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    private static final boolean ConversationSettingsScreen$lambda$16(MutableState<Boolean> mutableState) {
        return ((Boolean) ((State) mutableState).getValue()).booleanValue();
    }

    private static final void ConversationSettingsScreen$lambda$17(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationSettingsScreen$lambda$18(Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C149@7146L52,148@7088L181:ConversationSettingsScreen.kt#6g1srx");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1182140102, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationSettingsScreen.<anonymous> (ConversationSettingsScreen.kt:148)");
            }
            SimpleTopBarWithNavigationDrawerKt.SimpleTopBarWithNavigationDrawer(null, StringResources_androidKt.stringResource(R.string.conversation_settings_title, composer, 0), function0, composer, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationSettingsScreen$lambda$83(final ConversationSettingsViewModel conversationSettingsViewModel, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final State state, final Function0 function0, final Context context, final ManagedActivityResultLauncher managedActivityResultLauncher, PaddingValues paddingValues, Composer composer, int i) {
        int i2;
        int i3;
        String str;
        Object next;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer2, "C202@9399L21,200@9319L22749:ConversationSettingsScreen.kt#6g1srx");
        if ((i & 6) == 0) {
            i2 = i | (composer2.changed(paddingValues) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer2.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(317253275, i2, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationSettingsScreen.<anonymous> (ConversationSettingsScreen.kt:155)");
            }
            if (!ConversationSettingsScreen$lambda$16(mutableState)) {
                i3 = -1937944569;
                composer2.startReplaceGroup(-1937944569);
            } else {
                composer2.startReplaceGroup(-1930612294);
                ComposerKt.sourceInformation(composer2, "159@7571L182,165@7908L207,162@7787L85,156@7384L749");
                List<VoiceOption> conversationTtsVoices = ConversationSettingsScreen$lambda$1(state).getConversationTtsVoices();
                String selectedVoice = ConversationSettingsScreen$lambda$1(state).getSelectedVoice();
                ComposerKt.sourceInformationMarkerStart(composer2, -62271855, "CC(remember):ConversationSettingsScreen.kt#9igjgp");
                boolean zChangedInstance = composer2.changedInstance(conversationSettingsViewModel);
                Object objRememberedValue = composer2.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationSettingsScreenKt$$ExternalSyntheticLambda25
                        public final Object invoke(Object obj) {
                            return ConversationSettingsScreenKt.ConversationSettingsScreen$lambda$83$lambda$21$lambda$20(conversationSettingsViewModel, (VoiceOption) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                Function1 function1 = (Function1) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, -62261046, "CC(remember):ConversationSettingsScreen.kt#9igjgp");
                boolean zChangedInstance2 = composer2.changedInstance(conversationSettingsViewModel);
                Object objRememberedValue2 = composer2.rememberedValue();
                if (zChangedInstance2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationSettingsScreenKt$$ExternalSyntheticLambda8
                        public final Object invoke(Object obj) {
                            return ConversationSettingsScreenKt.ConversationSettingsScreen$lambda$83$lambda$23$lambda$22(conversationSettingsViewModel, (Voice) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                Function1 function2 = (Function1) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, -62265040, "CC(remember):ConversationSettingsScreen.kt#9igjgp");
                boolean zChanged = composer2.changed(mutableState);
                Object objRememberedValue3 = composer2.rememberedValue();
                if (zChanged || objRememberedValue3 == Composer.Companion.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationSettingsScreenKt$$ExternalSyntheticLambda9
                        public final Object invoke() {
                            return ConversationSettingsScreenKt.ConversationSettingsScreen$lambda$83$lambda$25$lambda$24(mutableState);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                i3 = -1937944569;
                VoiceSelectionDialogBoxKt.VoiceSelectionDialogBox(null, conversationTtsVoices, selectedVoice, function1, function2, (Function0) objRememberedValue3, composer, 0, 1);
                composer2 = composer;
            }
            composer2.endReplaceGroup();
            if (!ConversationSettingsScreen$lambda$8(mutableState2)) {
                str = r10;
                composer2.startReplaceGroup(i3);
            } else {
                composer2.startReplaceGroup(-1929802171);
                ComposerKt.sourceInformation(composer2, "176@8371L220,181@8625L79,174@8208L514");
                float activeConversationTranscriptionFontSize = ConversationSettingsScreen$lambda$1(state).getActiveConversationTranscriptionFontSize();
                str = "CC(remember):ConversationSettingsScreen.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(composer2, -62246217, str);
                boolean zChangedInstance3 = composer2.changedInstance(conversationSettingsViewModel);
                Object objRememberedValue4 = composer2.rememberedValue();
                if (zChangedInstance3 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                    objRememberedValue4 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationSettingsScreenKt$$ExternalSyntheticLambda10
                        public final Object invoke(Object obj) {
                            return ConversationSettingsScreenKt.ConversationSettingsScreen$lambda$83$lambda$27$lambda$26(conversationSettingsViewModel, ((Float) obj).floatValue());
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                Function1 function3 = (Function1) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, -62238230, str);
                boolean zChanged2 = composer2.changed(mutableState2);
                Object objRememberedValue5 = composer2.rememberedValue();
                if (zChanged2 || objRememberedValue5 == Composer.Companion.getEmpty()) {
                    objRememberedValue5 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationSettingsScreenKt$$ExternalSyntheticLambda12
                        public final Object invoke() {
                            return ConversationSettingsScreenKt.ConversationSettingsScreen$lambda$83$lambda$29$lambda$28(mutableState2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue5);
                }
                Function0 function4 = (Function0) objRememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Composer composer3 = composer2;
                ConversationFontSizeSelectionDialogKt.ConversationFontSizeSelectionDialog(null, activeConversationTranscriptionFontSize, function3, function4, composer3, 0, 1);
                composer2 = composer3;
            }
            composer2.endReplaceGroup();
            if (ConversationSettingsScreen$lambda$12(mutableState3)) {
                composer2.startReplaceGroup(-1929217542);
                ComposerKt.sourceInformation(composer2, "190@8930L273,196@9237L36,188@8798L493");
                InterpretationSpeed activeInterpretationSpeed = ConversationSettingsScreen$lambda$1(state).getActiveInterpretationSpeed();
                ComposerKt.sourceInformationMarkerStart(composer2, -62228276, str);
                boolean zChangedInstance4 = composer2.changedInstance(conversationSettingsViewModel) | composer2.changed(mutableState3);
                Object objRememberedValue6 = composer2.rememberedValue();
                if (zChangedInstance4 || objRememberedValue6 == Composer.Companion.getEmpty()) {
                    objRememberedValue6 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationSettingsScreenKt$$ExternalSyntheticLambda13
                        public final Object invoke(Object obj) {
                            return ConversationSettingsScreenKt.ConversationSettingsScreen$lambda$83$lambda$31$lambda$30(conversationSettingsViewModel, mutableState3, (InterpretationSpeed) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue6);
                }
                Function1 function5 = (Function1) objRememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, -62218689, str);
                boolean zChanged3 = composer2.changed(mutableState3);
                Object objRememberedValue7 = composer2.rememberedValue();
                if (zChanged3 || objRememberedValue7 == Composer.Companion.getEmpty()) {
                    objRememberedValue7 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationSettingsScreenKt$$ExternalSyntheticLambda14
                        public final Object invoke() {
                            return ConversationSettingsScreenKt.ConversationSettingsScreen$lambda$83$lambda$33$lambda$32(mutableState3);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                InterpretationSpeedSelectionDialogKt.SpeedSelectionDialogBox(null, null, activeInterpretationSpeed, function5, (Function0) objRememberedValue7, composer, 0, 3);
                composer2 = composer;
                composer2.endReplaceGroup();
                str = str;
            } else {
                composer2.startReplaceGroup(i3);
                composer2.endReplaceGroup();
            }
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(PaddingKt.padding(ScrollKt.verticalScroll$default(Modifier.Companion, ScrollKt.rememberScrollState(0, composer2, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null), paddingValues), 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer2, 0);
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
            Composer composer4 = Updater.constructor-impl(composer2);
            Updater.set-impl(composer4, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer4, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer4, Integer.valueOf(iHashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer4, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 1749841274, "C210@9692L40,207@9534L2087,259@11826L95,255@11639L1956,304@13712L1930,302@13613L2029,347@15660L1877,389@17555L2625,450@20425L225,445@20198L1617,487@22020L94,483@21833L1997,535@24106L80,530@23848L1405,569@25529L372,564@25271L1689,608@27236L377,603@26978L1698,647@28952L371,642@28694L1683,681@30395L1659:ConversationSettingsScreen.kt#6g1srx");
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(composer2, 472071065, str);
            boolean zChanged4 = composer2.changed(mutableState);
            Object objRememberedValue8 = composer2.rememberedValue();
            if (zChanged4 || objRememberedValue8 == Composer.Companion.getEmpty()) {
                objRememberedValue8 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationSettingsScreenKt$$ExternalSyntheticLambda15
                    public final Object invoke() {
                        return ConversationSettingsScreenKt.ConversationSettingsScreen$lambda$83$lambda$82$lambda$35$lambda$34(mutableState);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue8);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            float f = 16;
            float f2 = 8;
            Modifier modifier2 = PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) objRememberedValue8, 15, (Object) null), 0.0f, 1, (Object) null), Dp.constructor-impl(f), Dp.constructor-impl(f2));
            ComposerKt.sourceInformationMarkerStart(composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            String str2 = str;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 48);
            ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifier2);
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
            Composer composer5 = Updater.constructor-impl(composer2);
            Updater.set-impl(composer5, measurePolicyRowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer5, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer5, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer5, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 610170967, "C214@9884L282,222@10188L740,244@11207L33,243@11170L433:ConversationSettingsScreen.kt#6g1srx");
            float f3 = 10;
            float f4 = 25;
            IconKt.Icon-ww6aTOc(RecordVoiceOverKt.getRecordVoiceOver(Icons.INSTANCE.getDefault()), (String) null, SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(f3), 0.0f, 11, (Object) null), Dp.constructor-impl(f4)), 0L, composer, 432, 8);
            Modifier modifierWeight$default = RowScope.weight$default(rowScope, Modifier.Companion, 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, modifierWeight$default);
            Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor3);
            } else {
                composer.useNode();
            }
            Composer composer6 = Updater.constructor-impl(composer);
            Updater.set-impl(composer6, measurePolicyColumnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer6, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer6, Integer.valueOf(iHashCode3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer6, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer6, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1303548921, "C226@10340L58,225@10299L275,232@10640L57,235@10853L11,231@10599L307:ConversationSettingsScreen.kt#6g1srx");
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.conversation_settings_voice_title, composer, 0), (Modifier) null, 0L, (TextAutoSize) null, TextUnitKt.getSp(20), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 2, 0, (Function1) null, (TextStyle) null, composer, 24576, 24960, 241646);
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.conversation_settings_voice_desc, composer, 0), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getInversePrimary-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 2, 0, (Function1) null, (TextStyle) null, composer, 0, 24960, 241658);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Iterator<T> it = ConversationSettingsScreen$lambda$1(state).getConversationTtsVoices().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(((VoiceOption) next).getId(), ConversationSettingsScreen$lambda$1(state).getSelectedVoice()));
            VoiceOption voiceOption = (VoiceOption) next;
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(voiceOption != null ? voiceOption.getDisplayNameRes() : R.string.global_label_system_default, composer, 0), rowScope.weight(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(f2), 0.0f, 0.0f, 0.0f, 14, (Object) null), 0.4f, false), 0L, (TextAutoSize) null, TextUnitKt.getSp(20), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getEnd-e0LSkKk()), 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 2, 0, (Function1) null, (TextStyle) null, composer, 24576, 24960, 240620);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Alignment.Vertical centerVertically2 = Alignment.Companion.getCenterVertically();
            Modifier modifier3 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(composer, 472139408, str2);
            boolean zChanged5 = composer.changed(mutableState3);
            Object objRememberedValue9 = composer.rememberedValue();
            if (zChanged5 || objRememberedValue9 == Composer.Companion.getEmpty()) {
                objRememberedValue9 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationSettingsScreenKt$$ExternalSyntheticLambda16
                    public final Object invoke() {
                        return ConversationSettingsScreenKt.ConversationSettingsScreen$lambda$83$lambda$82$lambda$40$lambda$39(mutableState3);
                    }
                };
                composer.updateRememberedValue(objRememberedValue9);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifier4 = PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(ClickableKt.clickable-oSLSa3U$default(modifier3, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) objRememberedValue9, 15, (Object) null), 0.0f, 1, (Object) null), Dp.constructor-impl(f), Dp.constructor-impl(f2));
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer, modifier4);
            Function0 constructor4 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor4);
            } else {
                composer.useNode();
            }
            Composer composer7 = Updater.constructor-impl(composer);
            Updater.set-impl(composer7, measurePolicyRowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer7, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer7, Integer.valueOf(iHashCode4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer7, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer7, modifierMaterializeModifier4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1414864912, "C266@12098L341,275@12461L636,291@13156L58,290@13119L458:ConversationSettingsScreen.kt#6g1srx");
            IconKt.Icon-ww6aTOc(FastForwardKt.getFastForward(Icons.INSTANCE.getDefault()), (String) null, rowScope2.align(SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(f3), 0.0f, 11, (Object) null), Dp.constructor-impl(f4)), Alignment.Companion.getCenterVertically()), 0L, composer, 48, 8);
            Modifier modifierWeight$default2 = RowScope.weight$default(rowScope2, Modifier.Companion, 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap5 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composer, modifierWeight$default2);
            Function0 constructor5 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor5);
            } else {
                composer.useNode();
            }
            Composer composer8 = Updater.constructor-impl(composer);
            Updater.set-impl(composer8, measurePolicyColumnMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer8, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer8, Integer.valueOf(iHashCode5), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer8, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer8, modifierMaterializeModifier5, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope3 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -769293942, "C279@12613L58,278@12572L275,285@12913L57,286@13022L11,284@12872L203:ConversationSettingsScreen.kt#6g1srx");
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.conversation_settings_speed_title, composer, 0), (Modifier) null, 0L, (TextAutoSize) null, TextUnitKt.getSp(20), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 2, 0, (Function1) null, (TextStyle) null, composer, 24576, 24960, 241646);
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.conversation_settings_speed_desc, composer, 0), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getInversePrimary-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262138);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(ConversationSettingsScreen$lambda$1(state).getActiveInterpretationSpeed().getLabelRes(), composer, 0), rowScope2.weight(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(f2), 0.0f, 0.0f, 0.0f, 14, (Object) null), 0.4f, false), 0L, (TextAutoSize) null, TextUnitKt.getSp(20), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getEnd-e0LSkKk()), 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 2, 0, (Function1) null, (TextStyle) null, composer, 24576, 24960, 240620);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            AnimatedVisibilityKt.AnimatedVisibility(columnScope, ConversationSettingsScreen$lambda$1(state).getShowSpeakerDetectionRow(), (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(1066204265, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationSettingsScreenKt$$ExternalSyntheticLambda17
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ConversationSettingsScreenKt.ConversationSettingsScreen$lambda$83$lambda$82$lambda$47(conversationSettingsViewModel, state, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 1572870, 30);
            Alignment.Vertical centerVertically3 = Alignment.Companion.getCenterVertically();
            Modifier modifier5 = PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(f), Dp.constructor-impl(f2));
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically3, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap6 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composer, modifier5);
            Function0 constructor6 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor6);
            } else {
                composer.useNode();
            }
            Composer composer9 = Updater.constructor-impl(composer);
            Updater.set-impl(composer9, measurePolicyRowMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer9, currentCompositionLocalMap6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer9, Integer.valueOf(iHashCode6), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer9, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer9, modifierMaterializeModifier6, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope3 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1487172602, "C353@15923L335,362@16280L646,379@17094L324,377@16948L571:ConversationSettingsScreen.kt#6g1srx");
            IconKt.Icon-ww6aTOc(SpeedKt.getSpeed(Icons.INSTANCE.getDefault()), (String) null, rowScope3.align(SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(f3), 0.0f, 11, (Object) null), Dp.constructor-impl(f4)), Alignment.Companion.getCenterVertically()), 0L, composer, 48, 8);
            Modifier modifierWeight$default3 = RowScope.weight$default(rowScope3, Modifier.Companion, 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode7 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap7 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composer, modifierWeight$default3);
            Function0 constructor7 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor7);
            } else {
                composer.useNode();
            }
            Composer composer10 = Updater.constructor-impl(composer);
            Updater.set-impl(composer10, measurePolicyColumnMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer10, currentCompositionLocalMap7, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer10, Integer.valueOf(iHashCode7), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer10, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer10, modifierMaterializeModifier7, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope4 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 2132740255, "C366@16432L63,365@16391L281,372@16738L62,373@16852L11,371@16697L207:ConversationSettingsScreen.kt#6g1srx");
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.conversation_settings_high_speed_title, composer, 0), (Modifier) null, 0L, (TextAutoSize) null, TextUnitKt.getSp(20), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 2, 0, (Function1) null, (TextStyle) null, composer, 24576, 24960, 241646);
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.conversation_settings_high_speed_desc, composer, 0), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getInversePrimary-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262138);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            boolean z = ConversationSettingsScreen$lambda$1(state).getActiveInterpretationMode() == InterpretationMode.QUICK;
            ComposerKt.sourceInformationMarkerStart(composer, -644727151, str2);
            boolean zChangedInstance5 = composer.changedInstance(conversationSettingsViewModel);
            Object objRememberedValue10 = composer.rememberedValue();
            if (zChangedInstance5 || objRememberedValue10 == Composer.Companion.getEmpty()) {
                objRememberedValue10 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationSettingsScreenKt$$ExternalSyntheticLambda26
                    public final Object invoke(Object obj) {
                        return ConversationSettingsScreenKt.ConversationSettingsScreen$lambda$83$lambda$82$lambda$51$lambda$50$lambda$49(conversationSettingsViewModel, ((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue10);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SwitchKt.Switch(z, (Function1) objRememberedValue10, rowScope3.align(Modifier.Companion, Alignment.Companion.getCenterVertically()), (Function2) null, false, (SwitchColors) null, (MutableInteractionSource) null, composer, 0, 120);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Alignment.Vertical centerVertically4 = Alignment.Companion.getCenterVertically();
            Modifier modifier6 = PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(f), Dp.constructor-impl(f2));
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically4, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode8 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap8 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composer, modifier6);
            Function0 constructor8 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor8);
            } else {
                composer.useNode();
            }
            Composer composer11 = Updater.constructor-impl(composer);
            Updater.set-impl(composer11, measurePolicyRowMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer11, currentCompositionLocalMap8, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer11, Integer.valueOf(iHashCode8), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer11, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer11, modifierMaterializeModifier8, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope4 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 94262381, "C395@17818L343,404@18183L644,421@18966L1095,419@18849L1313:ConversationSettingsScreen.kt#6g1srx");
            IconKt.Icon-ww6aTOc(SurroundSoundKt.getSurroundSound(Icons.INSTANCE.getDefault()), (String) null, rowScope4.align(SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(f3), 0.0f, 11, (Object) null), Dp.constructor-impl(f4)), Alignment.Companion.getCenterVertically()), 0L, composer, 48, 8);
            Modifier modifierWeight$default4 = RowScope.weight$default(rowScope4, Modifier.Companion, 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy5 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode9 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap9 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composer, modifierWeight$default4);
            Function0 constructor9 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor9);
            } else {
                composer.useNode();
            }
            Composer composer12 = Updater.constructor-impl(composer);
            Updater.set-impl(composer12, measurePolicyColumnMeasurePolicy5, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer12, currentCompositionLocalMap9, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer12, Integer.valueOf(iHashCode9), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer12, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer12, modifierMaterializeModifier9, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope5 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 739806784, "C408@18335L62,407@18294L280,414@18640L61,415@18753L11,413@18599L206:ConversationSettingsScreen.kt#6g1srx");
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.conversation_settings_env_sound_title, composer, 0), (Modifier) null, 0L, (TextAutoSize) null, TextUnitKt.getSp(20), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 2, 0, (Function1) null, (TextStyle) null, composer, 24576, 24960, 241646);
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.conversation_settings_env_sound_desc, composer, 0), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getInversePrimary-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262138);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            boolean envSoundRecognizerState = ConversationSettingsScreen$lambda$1(state).getEnvSoundRecognizerState();
            ComposerKt.sourceInformationMarkerStart(composer, 141623541, str2);
            boolean zChangedInstance6 = composer.changedInstance(context) | composer.changedInstance(conversationSettingsViewModel) | composer.changedInstance(managedActivityResultLauncher);
            Object objRememberedValue11 = composer.rememberedValue();
            if (zChangedInstance6 || objRememberedValue11 == Composer.Companion.getEmpty()) {
                objRememberedValue11 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationSettingsScreenKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        return ConversationSettingsScreenKt.ConversationSettingsScreen$lambda$83$lambda$82$lambda$55$lambda$54$lambda$53(context, conversationSettingsViewModel, managedActivityResultLauncher, ((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue11);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SwitchKt.Switch(envSoundRecognizerState, (Function1) objRememberedValue11, rowScope4.align(Modifier.Companion, Alignment.Companion.getCenterVertically()), (Function2) null, false, (SwitchColors) null, (MutableInteractionSource) null, composer, 0, 120);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Alignment.Vertical centerVertically5 = Alignment.Companion.getCenterVertically();
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 472414706, str2);
            boolean zChangedInstance7 = composer.changedInstance(conversationSettingsViewModel);
            Object objRememberedValue12 = composer.rememberedValue();
            if (zChangedInstance7 || objRememberedValue12 == Composer.Companion.getEmpty()) {
                objRememberedValue12 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationSettingsScreenKt$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        return ConversationSettingsScreenKt.ConversationSettingsScreen$lambda$83$lambda$82$lambda$57$lambda$56(conversationSettingsViewModel);
                    }
                };
                composer.updateRememberedValue(objRememberedValue12);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifier7 = PaddingKt.padding-VpY3zN4(ClickableKt.clickable-oSLSa3U$default(modifierFillMaxWidth$default, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) objRememberedValue12, 15, (Object) null), Dp.constructor-impl(f), Dp.constructor-impl(f2));
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy5 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically5, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode10 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap10 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composer, modifier7);
            Function0 constructor10 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor10);
            } else {
                composer.useNode();
            }
            Composer composer13 = Updater.constructor-impl(composer);
            Updater.set-impl(composer13, measurePolicyRowMeasurePolicy5, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer13, currentCompositionLocalMap10, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer13, Integer.valueOf(iHashCode10), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer13, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer13, modifierMaterializeModifier10, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope5 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1298712382, "C458@20787L336,467@21145L652:ConversationSettingsScreen.kt#6g1srx");
            IconKt.Icon-ww6aTOc(ReplayKt.getReplay(Icons.INSTANCE.getDefault()), (String) null, rowScope5.align(SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(f3), 0.0f, 11, (Object) null), Dp.constructor-impl(f4)), Alignment.Companion.getCenterVertically()), 0L, composer, 48, 8);
            Modifier modifierWeight$default5 = RowScope.weight$default(rowScope5, Modifier.Companion, 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy6 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode11 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap11 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composer, modifierWeight$default5);
            Function0 constructor11 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor11);
            } else {
                composer.useNode();
            }
            Composer composer14 = Updater.constructor-impl(composer);
            Updater.set-impl(composer14, measurePolicyColumnMeasurePolicy6, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer14, currentCompositionLocalMap11, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer14, Integer.valueOf(iHashCode11), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer14, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer14, modifierMaterializeModifier11, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope6 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -653126377, "C471@21297L66,470@21256L283,477@21605L65,478@21722L11,476@21564L211:ConversationSettingsScreen.kt#6g1srx");
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.conversation_settings_reset_persona_title, composer, 0), (Modifier) null, 0L, (TextAutoSize) null, TextUnitKt.getSp(20), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 2, 0, (Function1) null, (TextStyle) null, composer, 24576, 24960, 241646);
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.conversation_settings_reset_persona_desc, composer, 0), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getInversePrimary-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262138);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Alignment.Vertical centerVertically6 = Alignment.Companion.getCenterVertically();
            Modifier modifier8 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(composer, 472465615, str2);
            boolean zChanged6 = composer.changed(mutableState2);
            Object objRememberedValue13 = composer.rememberedValue();
            if (zChanged6 || objRememberedValue13 == Composer.Companion.getEmpty()) {
                objRememberedValue13 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationSettingsScreenKt$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        return ConversationSettingsScreenKt.ConversationSettingsScreen$lambda$83$lambda$82$lambda$61$lambda$60(mutableState2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue13);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifier9 = PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(ClickableKt.clickable-oSLSa3U$default(modifier8, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) objRememberedValue13, 15, (Object) null), 0.0f, 1, (Object) null), Dp.constructor-impl(f), Dp.constructor-impl(f2));
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy6 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically6, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode12 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap12 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composer, modifier9);
            Function0 constructor12 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor12);
            } else {
                composer.useNode();
            }
            Composer composer15 = Updater.constructor-impl(composer);
            Updater.set-impl(composer15, measurePolicyRowMeasurePolicy6, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer15, currentCompositionLocalMap12, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer15, Integer.valueOf(iHashCode12), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer15, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer15, modifierMaterializeModifier12, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope6 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1603337346, "C494@22291L340,503@22653L634,519@23346L58,518@23309L503:ConversationSettingsScreen.kt#6g1srx");
            IconKt.Icon-ww6aTOc(TextFieldsKt.getTextFields(Icons.INSTANCE.getDefault()), (String) null, rowScope6.align(SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(f3), 0.0f, 11, (Object) null), Dp.constructor-impl(f4)), Alignment.Companion.getCenterVertically()), 0L, composer, 48, 8);
            Modifier modifierWeight$default6 = RowScope.weight$default(rowScope6, Modifier.Companion, 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy7 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode13 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap13 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier13 = ComposedModifierKt.materializeModifier(composer, modifierWeight$default6);
            Function0 constructor13 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor13);
            } else {
                composer.useNode();
            }
            Composer composer16 = Updater.constructor-impl(composer);
            Updater.set-impl(composer16, measurePolicyColumnMeasurePolicy7, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer16, currentCompositionLocalMap13, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer16, Integer.valueOf(iHashCode13), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer16, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer16, modifierMaterializeModifier13, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope7 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -2046060344, "C507@22805L57,506@22764L275,513@23105L56,514@23213L11,512@23064L201:ConversationSettingsScreen.kt#6g1srx");
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.conversation_settings_font_title, composer, 0), (Modifier) null, 0L, (TextAutoSize) null, TextUnitKt.getSp(20), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 2, 0, (Function1) null, (TextStyle) null, composer, 24576, 24960, 241646);
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.conversation_settings_font_desc, composer, 0), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getInversePrimary-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262138);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.conversation_settings_font_sample, composer, 0), rowScope6.weight(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(f2), 0.0f, 0.0f, 0.0f, 14, (Object) null), 0.4f, false), 0L, (TextAutoSize) null, TextUnitKt.getSp(ConversationSettingsScreen$lambda$1(state).getActiveConversationTranscriptionFontSize()), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getEnd-e0LSkKk()), 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 2, 0, (Function1) null, (TextStyle) null, composer, 0, 24960, 240620);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Alignment.Vertical centerVertically7 = Alignment.Companion.getCenterVertically();
            Modifier modifier10 = PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(f), Dp.constructor-impl(f2));
            ComposerKt.sourceInformationMarkerStart(composer, 472532353, str2);
            boolean zChanged7 = composer.changed(function0);
            Object objRememberedValue14 = composer.rememberedValue();
            if (zChanged7 || objRememberedValue14 == Composer.Companion.getEmpty()) {
                objRememberedValue14 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationSettingsScreenKt$$ExternalSyntheticLambda4
                    public final Object invoke() {
                        return ConversationSettingsScreenKt.ConversationSettingsScreen$lambda$83$lambda$82$lambda$65$lambda$64(function0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue14);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifier11 = ClickableKt.clickable-oSLSa3U$default(modifier10, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) objRememberedValue14, 15, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy7 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically7, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode14 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap14 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier14 = ComposedModifierKt.materializeModifier(composer, modifier11);
            Function0 constructor14 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor14);
            } else {
                composer.useNode();
            }
            Composer composer17 = Updater.constructor-impl(composer);
            Updater.set-impl(composer17, measurePolicyRowMeasurePolicy7, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer17, currentCompositionLocalMap14, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer17, Integer.valueOf(iHashCode14), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer17, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer17, modifierMaterializeModifier14, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope7 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 210388034, "C539@24227L336,548@24585L650:ConversationSettingsScreen.kt#6g1srx");
            IconKt.Icon-ww6aTOc(UploadKt.getUpload(Icons.INSTANCE.getDefault()), (String) null, rowScope7.align(SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(f3), 0.0f, 11, (Object) null), Dp.constructor-impl(f4)), Alignment.Companion.getCenterVertically()), 0L, composer, 48, 8);
            Modifier modifierWeight$default7 = RowScope.weight$default(rowScope7, Modifier.Companion, 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy8 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode15 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap15 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier15 = ComposedModifierKt.materializeModifier(composer, modifierWeight$default7);
            Function0 constructor15 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor15);
            } else {
                composer.useNode();
            }
            Composer composer18 = Updater.constructor-impl(composer);
            Updater.set-impl(composer18, measurePolicyColumnMeasurePolicy8, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer18, currentCompositionLocalMap15, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer18, Integer.valueOf(iHashCode15), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer18, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer18, modifierMaterializeModifier15, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope8 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 855974039, "C552@24737L65,551@24696L282,558@25044L64,559@25160L11,557@25003L210:ConversationSettingsScreen.kt#6g1srx");
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.conversation_settings_upload_video_title, composer, 0), (Modifier) null, 0L, (TextAutoSize) null, TextUnitKt.getSp(20), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 2, 0, (Function1) null, (TextStyle) null, composer, 24576, 24960, 241646);
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.conversation_settings_upload_video_desc, composer, 0), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getInversePrimary-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262138);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Alignment.Vertical centerVertically8 = Alignment.Companion.getCenterVertically();
            Modifier modifier12 = PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(f), Dp.constructor-impl(f2));
            ComposerKt.sourceInformationMarkerStart(composer, 472578181, str2);
            boolean zChangedInstance8 = composer.changedInstance(conversationSettingsViewModel) | composer.changedInstance(context);
            Object objRememberedValue15 = composer.rememberedValue();
            if (zChangedInstance8 || objRememberedValue15 == Composer.Companion.getEmpty()) {
                objRememberedValue15 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationSettingsScreenKt$$ExternalSyntheticLambda5
                    public final Object invoke() {
                        return ConversationSettingsScreenKt.ConversationSettingsScreen$lambda$83$lambda$82$lambda$69$lambda$68(conversationSettingsViewModel, context);
                    }
                };
                composer.updateRememberedValue(objRememberedValue15);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifier13 = ClickableKt.clickable-oSLSa3U$default(modifier12, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) objRememberedValue15, 15, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy8 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically8, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode16 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap16 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier16 = ComposedModifierKt.materializeModifier(composer, modifier13);
            Function0 constructor16 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor16);
            } else {
                composer.useNode();
            }
            Composer composer19 = Updater.constructor-impl(composer);
            Updater.set-impl(composer19, measurePolicyRowMeasurePolicy8, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer19, currentCompositionLocalMap16, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer19, Integer.valueOf(iHashCode16), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer19, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer19, modifierMaterializeModifier16, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope8 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1182545623, "C578@25942L340,587@26304L638:ConversationSettingsScreen.kt#6g1srx");
            IconKt.Icon-ww6aTOc(RateReviewKt.getRateReview(Icons.INSTANCE.getDefault()), (String) null, rowScope8.align(SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(f3), 0.0f, 11, (Object) null), Dp.constructor-impl(f4)), Alignment.Companion.getCenterVertically()), 0L, composer, 48, 8);
            Modifier modifierWeight$default8 = RowScope.weight$default(rowScope8, Modifier.Companion, 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy9 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode17 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap17 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier17 = ComposedModifierKt.materializeModifier(composer, modifierWeight$default8);
            Function0 constructor17 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor17);
            } else {
                composer.useNode();
            }
            Composer composer20 = Updater.constructor-impl(composer);
            Updater.set-impl(composer20, measurePolicyColumnMeasurePolicy9, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer20, currentCompositionLocalMap17, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer20, Integer.valueOf(iHashCode17), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer20, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer20, modifierMaterializeModifier17, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope9 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -536959742, "C591@26456L59,590@26415L276,597@26757L58,598@26867L11,596@26716L204:ConversationSettingsScreen.kt#6g1srx");
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.conversation_settings_review_title, composer, 0), (Modifier) null, 0L, (TextAutoSize) null, TextUnitKt.getSp(20), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 2, 0, (Function1) null, (TextStyle) null, composer, 24576, 24960, 241646);
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.conversation_settings_review_desc, composer, 0), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getInversePrimary-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262138);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Alignment.Vertical centerVertically9 = Alignment.Companion.getCenterVertically();
            Modifier modifier14 = PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(f), Dp.constructor-impl(f2));
            ComposerKt.sourceInformationMarkerStart(composer, 472632810, str2);
            boolean zChangedInstance9 = composer.changedInstance(conversationSettingsViewModel) | composer.changedInstance(context);
            Object objRememberedValue16 = composer.rememberedValue();
            if (zChangedInstance9 || objRememberedValue16 == Composer.Companion.getEmpty()) {
                objRememberedValue16 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationSettingsScreenKt$$ExternalSyntheticLambda6
                    public final Object invoke() {
                        return ConversationSettingsScreenKt.ConversationSettingsScreen$lambda$83$lambda$82$lambda$73$lambda$72(conversationSettingsViewModel, context);
                    }
                };
                composer.updateRememberedValue(objRememberedValue16);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifier15 = ClickableKt.clickable-oSLSa3U$default(modifier14, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) objRememberedValue16, 15, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy9 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically9, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode18 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap18 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier18 = ComposedModifierKt.materializeModifier(composer, modifier15);
            Function0 constructor18 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor18);
            } else {
                composer.useNode();
            }
            Composer composer21 = Updater.constructor-impl(composer);
            Updater.set-impl(composer21, measurePolicyRowMeasurePolicy9, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer21, currentCompositionLocalMap18, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer21, Integer.valueOf(iHashCode18), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer21, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer21, modifierMaterializeModifier18, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope9 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1719488388, "C617@27654L338,626@28014L644:ConversationSettingsScreen.kt#6g1srx");
            IconKt.Icon-ww6aTOc(WhatsappKt.getWhatsapp(Icons.INSTANCE.getDefault()), (String) null, rowScope9.align(SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(f3), 0.0f, 11, (Object) null), Dp.constructor-impl(f4)), Alignment.Companion.getCenterVertically()), 0L, composer, 48, 8);
            Modifier modifierWeight$default9 = RowScope.weight$default(rowScope9, Modifier.Companion, 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy10 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode19 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap19 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier19 = ComposedModifierKt.materializeModifier(composer, modifierWeight$default9);
            Function0 constructor19 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor19);
            } else {
                composer.useNode();
            }
            Composer composer22 = Updater.constructor-impl(composer);
            Updater.set-impl(composer22, measurePolicyColumnMeasurePolicy10, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer22, currentCompositionLocalMap19, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer22, Integer.valueOf(iHashCode19), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer22, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer22, modifierMaterializeModifier19, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope10 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1929892965, "C630@28166L62,629@28125L279,636@28470L61,637@28583L11,635@28429L207:ConversationSettingsScreen.kt#6g1srx");
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.conversation_settings_community_title, composer, 0), (Modifier) null, 0L, (TextAutoSize) null, TextUnitKt.getSp(20), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 2, 0, (Function1) null, (TextStyle) null, composer, 24576, 24960, 241646);
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.conversation_settings_community_desc, composer, 0), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getInversePrimary-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262138);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Alignment.Vertical centerVertically10 = Alignment.Companion.getCenterVertically();
            Modifier modifier16 = PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(f), Dp.constructor-impl(f2));
            ComposerKt.sourceInformationMarkerStart(composer, 472687716, str2);
            boolean zChangedInstance10 = composer.changedInstance(conversationSettingsViewModel) | composer.changedInstance(context);
            Object objRememberedValue17 = composer.rememberedValue();
            if (zChangedInstance10 || objRememberedValue17 == Composer.Companion.getEmpty()) {
                objRememberedValue17 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationSettingsScreenKt$$ExternalSyntheticLambda7
                    public final Object invoke() {
                        return ConversationSettingsScreenKt.ConversationSettingsScreen$lambda$83$lambda$82$lambda$77$lambda$76(conversationSettingsViewModel, context);
                    }
                };
                composer.updateRememberedValue(objRememberedValue17);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifier17 = ClickableKt.clickable-oSLSa3U$default(modifier16, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) objRememberedValue17, 15, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy10 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically10, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode20 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap20 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier20 = ComposedModifierKt.materializeModifier(composer, modifier17);
            Function0 constructor20 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor20);
            } else {
                composer.useNode();
            }
            Composer composer23 = Updater.constructor-impl(composer);
            Updater.set-impl(composer23, measurePolicyRowMeasurePolicy10, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer23, currentCompositionLocalMap20, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer23, Integer.valueOf(iHashCode20), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer23, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer23, modifierMaterializeModifier20, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope10 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 326554700, "C656@29364L335,665@29721L638:ConversationSettingsScreen.kt#6g1srx");
            IconKt.Icon-ww6aTOc(ShareKt.getShare(Icons.INSTANCE.getDefault()), (String) null, rowScope10.align(SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(f3), 0.0f, 11, (Object) null), Dp.constructor-impl(f4)), Alignment.Companion.getCenterVertically()), 0L, composer, 48, 8);
            Modifier modifierWeight$default10 = RowScope.weight$default(rowScope10, Modifier.Companion, 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy11 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode21 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap21 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier21 = ComposedModifierKt.materializeModifier(composer, modifierWeight$default10);
            Function0 constructor21 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor21);
            } else {
                composer.useNode();
            }
            Composer composer24 = Updater.constructor-impl(composer);
            Updater.set-impl(composer24, measurePolicyColumnMeasurePolicy11, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer24, currentCompositionLocalMap21, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer24, Integer.valueOf(iHashCode21), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer24, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer24, modifierMaterializeModifier21, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope11 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 972140736, "C669@29873L59,668@29832L276,675@30174L58,676@30284L11,674@30133L204:ConversationSettingsScreen.kt#6g1srx");
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.conversation_settings_invite_title, composer, 0), (Modifier) null, 0L, (TextAutoSize) null, TextUnitKt.getSp(20), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 2, 0, (Function1) null, (TextStyle) null, composer, 24576, 24960, 241646);
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.conversation_settings_invite_desc, composer, 0), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getInversePrimary-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262138);
            Composer composer25 = composer;
            ComposerKt.sourceInformationMarkerEnd(composer25);
            ComposerKt.sourceInformationMarkerEnd(composer25);
            composer25.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer25);
            ComposerKt.sourceInformationMarkerEnd(composer25);
            ComposerKt.sourceInformationMarkerEnd(composer25);
            ComposerKt.sourceInformationMarkerEnd(composer25);
            ComposerKt.sourceInformationMarkerEnd(composer25);
            composer25.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer25);
            ComposerKt.sourceInformationMarkerEnd(composer25);
            ComposerKt.sourceInformationMarkerEnd(composer25);
            Alignment.Vertical centerVertically11 = Alignment.Companion.getCenterVertically();
            Modifier modifier18 = PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(f), Dp.constructor-impl(f2));
            ComposerKt.sourceInformationMarkerStart(composer25, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy11 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically11, composer25, 48);
            ComposerKt.sourceInformationMarkerStart(composer25, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode22 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer25, 0));
            CompositionLocalMap currentCompositionLocalMap22 = composer25.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier22 = ComposedModifierKt.materializeModifier(composer25, modifier18);
            Function0 constructor22 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer25, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer25.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer25.startReusableNode();
            if (composer25.getInserting()) {
                composer25.createNode(constructor22);
            } else {
                composer25.useNode();
            }
            Composer composer26 = Updater.constructor-impl(composer25);
            Updater.set-impl(composer26, measurePolicyRowMeasurePolicy11, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer26, currentCompositionLocalMap22, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer26, Integer.valueOf(iHashCode22), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer26, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer26, modifierMaterializeModifier22, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer25, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope11 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer25, -641485159, "C687@30658L334:ConversationSettingsScreen.kt#6g1srx");
            IconKt.Icon-ww6aTOc(InfoKt.getInfo(Icons.INSTANCE.getDefault()), (String) null, rowScope11.align(SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(f3), 0.0f, 11, (Object) null), Dp.constructor-impl(f4)), Alignment.Companion.getCenterVertically()), 0L, composer25, 48, 8);
            Pair<String, Integer> appVersionDetails = UsageUtilsKt.getAppVersionDetails(context);
            if (appVersionDetails == null || appVersionDetails.getFirst() == null) {
                composer25.startReplaceGroup(-671941606);
            } else {
                composer25.startReplaceGroup(-641018114);
                ComposerKt.sourceInformation(composer25, "697@31170L844");
                ComposerKt.sourceInformationMarkerStart(composer25, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Modifier modifier19 = Modifier.Companion;
                MeasurePolicy measurePolicyColumnMeasurePolicy12 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer25, 0);
                ComposerKt.sourceInformationMarkerStart(composer25, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode23 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer25, 0));
                CompositionLocalMap currentCompositionLocalMap23 = composer25.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier23 = ComposedModifierKt.materializeModifier(composer25, modifier19);
                Function0 constructor23 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer25, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composer25.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer25.startReusableNode();
                if (composer25.getInserting()) {
                    composer25.createNode(constructor23);
                } else {
                    composer25.useNode();
                }
                Composer composer27 = Updater.constructor-impl(composer25);
                Updater.set-impl(composer27, measurePolicyColumnMeasurePolicy12, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer27, currentCompositionLocalMap23, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl(composer27, Integer.valueOf(iHashCode23), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl(composer27, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl(composer27, modifierMaterializeModifier23, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer25, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope12 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer25, -2031870625, "C699@31252L67,701@31425L11,698@31207L342,705@31623L135,709@31864L11,704@31578L410:ConversationSettingsScreen.kt#6g1srx");
                TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.global_label_version, new Object[]{appVersionDetails.getSecond()}, composer25, 0), SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer25, MaterialTheme.$stable).getInversePrimary-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(20), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 24624, 0, 262120);
                int i4 = R.string.global_label_name;
                Object first = appVersionDetails.getFirst();
                Intrinsics.checkNotNull(first);
                TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(i4, new Object[]{first}, composer, 0), SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getInversePrimary-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(20), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 24624, 0, 262120);
                composer25 = composer;
                ComposerKt.sourceInformationMarkerEnd(composer25);
                ComposerKt.sourceInformationMarkerEnd(composer25);
                composer25.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer25);
                ComposerKt.sourceInformationMarkerEnd(composer25);
                ComposerKt.sourceInformationMarkerEnd(composer25);
            }
            composer25.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer25);
            ComposerKt.sourceInformationMarkerEnd(composer25);
            composer25.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer25);
            ComposerKt.sourceInformationMarkerEnd(composer25);
            ComposerKt.sourceInformationMarkerEnd(composer25);
            ComposerKt.sourceInformationMarkerEnd(composer25);
            ComposerKt.sourceInformationMarkerEnd(composer25);
            composer25.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer25);
            ComposerKt.sourceInformationMarkerEnd(composer25);
            ComposerKt.sourceInformationMarkerEnd(composer25);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationSettingsScreen$lambda$83$lambda$21$lambda$20(ConversationSettingsViewModel conversationSettingsViewModel, VoiceOption voiceOption) {
        Intrinsics.checkNotNullParameter(voiceOption, "selectedVoiceOption");
        conversationSettingsViewModel.onAction(new ConversationSettingsAction.OnSpeakSampleText(voiceOption.getVoice()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationSettingsScreen$lambda$83$lambda$25$lambda$24(MutableState mutableState) {
        ConversationSettingsScreen$lambda$17(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationSettingsScreen$lambda$83$lambda$23$lambda$22(ConversationSettingsViewModel conversationSettingsViewModel, Voice voice) {
        conversationSettingsViewModel.onAction(new ConversationSettingsAction.OnSetConversationVoice(voice));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationSettingsScreen$lambda$83$lambda$27$lambda$26(ConversationSettingsViewModel conversationSettingsViewModel, float f) {
        conversationSettingsViewModel.onAction(new ConversationSettingsAction.OnSetConversationTranscriptionFontSize(f));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationSettingsScreen$lambda$83$lambda$29$lambda$28(MutableState mutableState) {
        ConversationSettingsScreen$lambda$9(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationSettingsScreen$lambda$83$lambda$31$lambda$30(ConversationSettingsViewModel conversationSettingsViewModel, MutableState mutableState, InterpretationSpeed interpretationSpeed) {
        Intrinsics.checkNotNullParameter(interpretationSpeed, "speed");
        conversationSettingsViewModel.onAction(new ConversationSettingsAction.OnSetInterpretationSpeedUseCase(interpretationSpeed));
        ConversationSettingsScreen$lambda$13(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationSettingsScreen$lambda$83$lambda$33$lambda$32(MutableState mutableState) {
        ConversationSettingsScreen$lambda$13(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationSettingsScreen$lambda$83$lambda$82$lambda$35$lambda$34(MutableState mutableState) {
        ConversationSettingsScreen$lambda$17(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationSettingsScreen$lambda$83$lambda$82$lambda$40$lambda$39(MutableState mutableState) {
        ConversationSettingsScreen$lambda$13(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationSettingsScreen$lambda$83$lambda$82$lambda$47(final ConversationSettingsViewModel conversationSettingsViewModel, State state, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animatedVisibilityScope, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C305@13734L1890:ConversationSettingsScreen.kt#6g1srx");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1066204265, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationSettingsScreen.<anonymous>.<anonymous>.<anonymous> (ConversationSettingsScreen.kt:305)");
        }
        Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
        Modifier modifier = PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(16), Dp.constructor-impl(8));
        ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer, 48);
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
        Updater.set-impl(composer2, measurePolicyRowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Updater.init-impl(composer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
        Updater.reconcile-impl(composer2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
        Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
        RowScope rowScope = RowScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, -877721783, "C311@14021L362,320@14409L706,337@15268L225,335@15141L461:ConversationSettingsScreen.kt#6g1srx");
        IconKt.Icon-ww6aTOc(Man4Kt.getMan4(Icons.INSTANCE.getDefault()), (String) null, rowScope.align(SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(10), 0.0f, 11, (Object) null), Dp.constructor-impl(25)), Alignment.Companion.getCenterVertically()), 0L, composer, 48, 8);
        Modifier modifierWeight$default = RowScope.weight$default(rowScope, Modifier.Companion, 1.0f, false, 2, (Object) null);
        ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, 0);
        ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
        int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierWeight$default);
        Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
        ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor2);
        } else {
            composer.useNode();
        }
        Composer composer3 = Updater.constructor-impl(composer);
        Updater.set-impl(composer3, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Updater.init-impl(composer3, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
        Updater.reconcile-impl(composer3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
        Updater.set-impl(composer3, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
        ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 1578630803, "C324@14577L67,323@14532L305,330@14911L66,331@15033L11,329@14866L223:ConversationSettingsScreen.kt#6g1srx");
        TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.conversation_settings_speaker_detect_title, composer, 0), (Modifier) null, 0L, (TextAutoSize) null, TextUnitKt.getSp(20), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 2, 0, (Function1) null, (TextStyle) null, composer, 24576, 24960, 241646);
        TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.conversation_settings_speaker_detect_desc, composer, 0), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getInversePrimary-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262138);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        boolean zIsSpeakerDetectionEnabled = ConversationSettingsScreen$lambda$1(state).isSpeakerDetectionEnabled();
        ComposerKt.sourceInformationMarkerStart(composer, -28275058, "CC(remember):ConversationSettingsScreen.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(conversationSettingsViewModel);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationSettingsScreenKt$$ExternalSyntheticLambda18
                public final Object invoke(Object obj) {
                    return ConversationSettingsScreenKt.ConversationSettingsScreen$lambda$83$lambda$82$lambda$47$lambda$46$lambda$45$lambda$44(conversationSettingsViewModel, ((Boolean) obj).booleanValue());
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        SwitchKt.Switch(zIsSpeakerDetectionEnabled, (Function1) objRememberedValue, rowScope.align(Modifier.Companion, Alignment.Companion.getCenterVertically()), (Function2) null, false, (SwitchColors) null, (MutableInteractionSource) null, composer, 0, 120);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationSettingsScreen$lambda$83$lambda$82$lambda$47$lambda$46$lambda$45$lambda$44(ConversationSettingsViewModel conversationSettingsViewModel, boolean z) {
        conversationSettingsViewModel.onAction(ConversationSettingsAction.OnToggleSpeakerDetection.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationSettingsScreen$lambda$83$lambda$82$lambda$51$lambda$50$lambda$49(ConversationSettingsViewModel conversationSettingsViewModel, boolean z) {
        conversationSettingsViewModel.onAction(new ConversationSettingsAction.OnSetInterpretationModeUseCase(z ? InterpretationMode.QUICK : InterpretationMode.NORMAL));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationSettingsScreen$lambda$83$lambda$82$lambda$55$lambda$54$lambda$53(Context context, ConversationSettingsViewModel conversationSettingsViewModel, ManagedActivityResultLauncher managedActivityResultLauncher, boolean z) {
        if (z) {
            if (ContextCompat.checkSelfPermission(context, "android.permission.RECORD_AUDIO") == 0) {
                conversationSettingsViewModel.onAction(new ConversationSettingsAction.OnToggleEnvironmentSignRecognizerState(true));
            } else {
                managedActivityResultLauncher.launch("android.permission.RECORD_AUDIO");
            }
        } else {
            conversationSettingsViewModel.onAction(new ConversationSettingsAction.OnToggleEnvironmentSignRecognizerState(false));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationSettingsScreen$lambda$83$lambda$82$lambda$57$lambda$56(ConversationSettingsViewModel conversationSettingsViewModel) {
        conversationSettingsViewModel.onAction(ConversationSettingsAction.OnResetUserPersonaSurvey.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationSettingsScreen$lambda$83$lambda$82$lambda$61$lambda$60(MutableState mutableState) {
        ConversationSettingsScreen$lambda$9(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationSettingsScreen$lambda$83$lambda$82$lambda$65$lambda$64(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationSettingsScreen$lambda$83$lambda$82$lambda$69$lambda$68(ConversationSettingsViewModel conversationSettingsViewModel, Context context) {
        conversationSettingsViewModel.onAction(new ConversationSettingsAction.OnRedirectActionClicked(AnalyticsEvent.ReviewLinkClicked.INSTANCE));
        openPlayStoreForReview(context);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationSettingsScreen$lambda$83$lambda$82$lambda$73$lambda$72(ConversationSettingsViewModel conversationSettingsViewModel, Context context) {
        conversationSettingsViewModel.onAction(new ConversationSettingsAction.OnRedirectActionClicked(AnalyticsEvent.WhatsappLinkClicked.INSTANCE));
        openWhatsAppCommunityLink(context);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationSettingsScreen$lambda$83$lambda$82$lambda$77$lambda$76(ConversationSettingsViewModel conversationSettingsViewModel, Context context) {
        conversationSettingsViewModel.onAction(new ConversationSettingsAction.OnRedirectActionClicked(AnalyticsEvent.ShareLinkClicked.INSTANCE));
        openAppLinkShareIntent(context);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConversationSettingsScreen$lambda$19(SnackbarHostState snackbarHostState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C718@32117L31:ConversationSettingsScreen.kt#6g1srx");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-770409852, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationSettingsScreen.<anonymous> (ConversationSettingsScreen.kt:718)");
            }
            SnackbarHostKt.SnackbarHost(snackbarHostState, (Modifier) null, (Function3) null, composer, 6, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final ConversationSettingsState ConversationSettingsScreen$lambda$1(State<ConversationSettingsState> state) {
        return (ConversationSettingsState) state.getValue();
    }
}
