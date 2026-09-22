package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
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
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.pager.PageSize;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SnackbarHostKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
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
import androidx.media3.common.MediaItem;
import androidx.media3.common.Player;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.CircularProgressIndicatorComponentKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.paging.HorizontalPageProgressIndicatorKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.SimpleTopBarKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.media.MediaPlayerState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.NotificationData;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.NotificationPageType;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.NotificationResponseType;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationScreenEventState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationScreenUiAction;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationScreenUiState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationViewModel;
import java.util.List;
import java.util.Set;
import kotlin.KotlinNothingValueException;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.SharedFlow;

/* JADX INFO: compiled from: NotificationScreen.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u001a/\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\t²\u0006\n\u0010\n\u001a\u00020\u000bX\u008a\u0084\u0002²\u0006\n\u0010\f\u001a\u00020\rX\u008a\u0084\u0002"}, d2 = {"NotificationScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "notificationViewModel", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationViewModel;", "onNavigateBack", "Lkotlin/Function0;", "(Landroidx/compose/ui/Modifier;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationViewModel;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_release", "uiState", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationScreenUiState;", "mediaPlayerState", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/media/MediaPlayerState;"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class NotificationScreenKt {

    /* JADX INFO: compiled from: NotificationScreen.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NotificationPageType.values().length];
            try {
                iArr[NotificationPageType.BASIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NotificationPageType.TEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NotificationPageType.LIST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[NotificationPageType.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[NotificationPageType.VIDEO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotificationScreen$lambda$37(Modifier modifier, NotificationViewModel notificationViewModel, Function0 function0, int i, int i2, Composer composer, int i3) {
        NotificationScreen(modifier, notificationViewModel, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:63:0x0101  */
    /* JADX WARN: Code duplicated, block: B:66:0x014b  */
    /* JADX WARN: Code duplicated, block: B:71:0x0176  */
    /* JADX WARN: Code duplicated, block: B:74:0x01d9  */
    public static final void NotificationScreen(Modifier modifier, NotificationViewModel notificationViewModel, final Function0<Unit> function0, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        NotificationViewModel notificationViewModel2;
        final Modifier modifier3;
        final NotificationViewModel notificationViewModel3;
        CreationExtras defaultViewModelCreationExtras;
        SharedFlow<NotificationScreenEventState> uiEvent;
        Context context;
        Object objRememberedValue;
        final SnackbarHostState snackbarHostState;
        boolean zChangedInstance;
        NotificationScreenKt$NotificationScreen$1$1 notificationScreenKt$NotificationScreen$1$1RememberedValue;
        Intrinsics.checkNotNullParameter(function0, "onNavigateBack");
        Composer composerStartRestartGroup = composer.startRestartGroup(1729376051);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NotificationScreen)48@2752L29,49@2849L29,51@2958L7,53@2995L32,55@3057L289,55@3033L313,68@3482L441,67@3428L35,81@3943L9993,65@3352L10590:NotificationScreen.kt#om2ogl");
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
                notificationViewModel2 = notificationViewModel;
                int i5 = composerStartRestartGroup.changedInstance(notificationViewModel2) ? 32 : 16;
                i3 |= i5;
            } else {
                notificationViewModel2 = notificationViewModel;
            }
            i3 |= i5;
        } else {
            notificationViewModel2 = notificationViewModel;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        int i6 = i3;
        if (composerStartRestartGroup.shouldExecute((i6 & 147) != 146, i6 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "44@2650L15");
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i6 &= -113;
                }
                modifier3 = modifier2;
            } else {
                modifier3 = i4 != 0 ? (Modifier) Modifier.Companion : modifier2;
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
                    ViewModel viewModel = ViewModelKt.viewModel(NotificationViewModel.class, current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 36936, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    notificationViewModel3 = (NotificationViewModel) viewModel;
                    i6 &= -113;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1729376051, i6, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationScreen (NotificationScreen.kt:46)");
                }
                final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(notificationViewModel3.getUiState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                final State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(notificationViewModel3.getMediaPlayerState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                uiEvent = notificationViewModel3.getUiEvent();
                CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localContext);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                context = (Context) objConsume;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -221942253, "CC(remember):NotificationScreen.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = new SnackbarHostState();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                snackbarHostState = (SnackbarHostState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -221940012, "CC(remember):NotificationScreen.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(uiEvent) | composerStartRestartGroup.changedInstance(context);
                notificationScreenKt$NotificationScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance || notificationScreenKt$NotificationScreen$1$1RememberedValue == Composer.Companion.getEmpty()) {
                    notificationScreenKt$NotificationScreen$1$1RememberedValue = new NotificationScreenKt$NotificationScreen$1$1(uiEvent, snackbarHostState, context, null);
                    composerStartRestartGroup.updateRememberedValue(notificationScreenKt$NotificationScreen$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(uiEvent, (Function2) notificationScreenKt$NotificationScreen$1$1RememberedValue, composerStartRestartGroup, 0);
                Composer composer2 = composerStartRestartGroup;
                ScaffoldKt.Scaffold-TvnljyQ(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, (Object) null), ComposableLambdaKt.rememberComposableLambda(345493743, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationScreenKt$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj, Object obj2) {
                        return NotificationScreenKt.NotificationScreen$lambda$6(stateCollectAsStateWithLifecycle, function0, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), (Function2) null, ComposableLambdaKt.rememberComposableLambda(-509045715, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationScreenKt$$ExternalSyntheticLambda6
                    public final Object invoke(Object obj, Object obj2) {
                        return NotificationScreenKt.NotificationScreen$lambda$7(snackbarHostState, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), (Function2) null, 0, 0L, 0L, (WindowInsets) null, ComposableLambdaKt.rememberComposableLambda(1855731204, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationScreenKt$$ExternalSyntheticLambda7
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return NotificationScreenKt.NotificationScreen$lambda$36(stateCollectAsStateWithLifecycle, notificationViewModel3, stateCollectAsStateWithLifecycle2, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, 805309488, 500);
                composerStartRestartGroup = composer2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            notificationViewModel3 = notificationViewModel2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1729376051, i6, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationScreen (NotificationScreen.kt:46)");
            }
            final State stateCollectAsStateWithLifecycle3 = FlowExtKt.collectAsStateWithLifecycle(notificationViewModel3.getUiState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            final State stateCollectAsStateWithLifecycle4 = FlowExtKt.collectAsStateWithLifecycle(notificationViewModel3.getMediaPlayerState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            uiEvent = notificationViewModel3.getUiEvent();
            CompositionLocal localContext2 = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localContext2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            context = (Context) objConsume2;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -221942253, "CC(remember):NotificationScreen.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new SnackbarHostState();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            snackbarHostState = (SnackbarHostState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -221940012, "CC(remember):NotificationScreen.kt#9igjgp");
            zChangedInstance = composerStartRestartGroup.changedInstance(uiEvent) | composerStartRestartGroup.changedInstance(context);
            notificationScreenKt$NotificationScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance) {
                notificationScreenKt$NotificationScreen$1$1RememberedValue = new NotificationScreenKt$NotificationScreen$1$1(uiEvent, snackbarHostState, context, null);
                composerStartRestartGroup.updateRememberedValue(notificationScreenKt$NotificationScreen$1$1RememberedValue);
            } else {
                notificationScreenKt$NotificationScreen$1$1RememberedValue = new NotificationScreenKt$NotificationScreen$1$1(uiEvent, snackbarHostState, context, null);
                composerStartRestartGroup.updateRememberedValue(notificationScreenKt$NotificationScreen$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(uiEvent, (Function2) notificationScreenKt$NotificationScreen$1$1RememberedValue, composerStartRestartGroup, 0);
            Composer composer3 = composerStartRestartGroup;
            ScaffoldKt.Scaffold-TvnljyQ(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, (Object) null), ComposableLambdaKt.rememberComposableLambda(345493743, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationScreenKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    return NotificationScreenKt.NotificationScreen$lambda$6(stateCollectAsStateWithLifecycle3, function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), (Function2) null, ComposableLambdaKt.rememberComposableLambda(-509045715, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationScreenKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    return NotificationScreenKt.NotificationScreen$lambda$7(snackbarHostState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), (Function2) null, 0, 0L, 0L, (WindowInsets) null, ComposableLambdaKt.rememberComposableLambda(1855731204, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationScreenKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NotificationScreenKt.NotificationScreen$lambda$36(stateCollectAsStateWithLifecycle3, notificationViewModel3, stateCollectAsStateWithLifecycle4, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer3, 805309488, 500);
            composerStartRestartGroup = composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            notificationViewModel3 = notificationViewModel2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationScreenKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    return NotificationScreenKt.NotificationScreen$lambda$37(modifier3, notificationViewModel3, function0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotificationScreen$lambda$7(SnackbarHostState snackbarHostState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C67@3430L31:NotificationScreen.kt#om2ogl");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-509045715, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationScreen.<anonymous> (NotificationScreen.kt:67)");
            }
            SnackbarHostKt.SnackbarHost(snackbarHostState, (Modifier) null, (Function3) null, composer, 6, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotificationScreen$lambda$6(final State state, final Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C70@3534L89,73@3656L243,69@3496L417:NotificationScreen.kt#om2ogl");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(345493743, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationScreen.<anonymous> (NotificationScreen.kt:69)");
            }
            String strStringResource = StringResources_androidKt.stringResource(R.string.notification_session_title, composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, 1307011042, "CC(remember):NotificationScreen.kt#9igjgp");
            boolean zChanged = composer.changed(state) | composer.changed(function0);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationScreenKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        return NotificationScreenKt.NotificationScreen$lambda$6$lambda$5$lambda$4(function0, state);
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
    /* JADX WARN: Code duplicated, block: B:6:0x0019  */
    public static final Unit NotificationScreen$lambda$6$lambda$5$lambda$4(Function0 function0, State state) {
        if (NotificationScreen$lambda$0(state) instanceof NotificationScreenUiState.Success) {
            NotificationScreenUiState notificationScreenUiStateNotificationScreen$lambda$0 = NotificationScreen$lambda$0(state);
            Intrinsics.checkNotNull(notificationScreenUiStateNotificationScreen$lambda$0, "null cannot be cast to non-null type com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationScreenUiState.Success");
            if (!((NotificationScreenUiState.Success) notificationScreenUiStateNotificationScreen$lambda$0).isSubmitting()) {
                function0.invoke();
            }
        } else {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    /* JADX WARN: Code duplicated, block: B:70:0x0467  */
    public static final Unit NotificationScreen$lambda$36(State state, final NotificationViewModel notificationViewModel, final State state2, PaddingValues paddingValues, Composer composer, int i) throws NoWhenBranchMatchedException {
        int i2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer2, "C82@3974L9952:NotificationScreen.kt#om2ogl");
        if ((i & 6) == 0) {
            i2 = i | (composer2.changed(paddingValues) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer2.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1855731204, i2, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationScreen.<anonymous> (NotificationScreen.kt:82)");
            }
            Modifier modifierPadding = PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), paddingValues);
            ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
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
            Updater.set-impl(composer3, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer3, Integer.valueOf(iHashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer3, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 2009891967, "C87@4126L9089:NotificationScreen.kt#om2ogl");
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
            Arrangement.Vertical center = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composer2, 54);
            ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxSize$default);
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
            ComposerKt.sourceInformationMarkerStart(composer2, -1860552928, "C:NotificationScreen.kt#om2ogl");
            final NotificationScreenUiState notificationScreenUiStateNotificationScreen$lambda$0 = NotificationScreen$lambda$0(state);
            if (Intrinsics.areEqual(notificationScreenUiStateNotificationScreen$lambda$0, NotificationScreenUiState.Loading.INSTANCE)) {
                composer2.startReplaceGroup(-1860735953);
                ComposerKt.sourceInformation(composer2, "94@4481L27");
                CircularProgressIndicatorComponentKt.CircularProgressComponent(null, composer2, 0, 1);
                composer2.endReplaceGroup();
                str = "C72@3469L9:Box.kt#2w3rfo";
                str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                str3 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                str4 = "CC(remember):NotificationScreen.kt#9igjgp";
                str5 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
            } else {
                if (!(notificationScreenUiStateNotificationScreen$lambda$0 instanceof NotificationScreenUiState.Success)) {
                    composer2.startReplaceGroup(-614207165);
                    composer2.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composer2.startReplaceGroup(-1860325854);
                ComposerKt.sourceInformation(composer2, "");
                NotificationScreenUiState.Success success = (NotificationScreenUiState.Success) notificationScreenUiStateNotificationScreen$lambda$0;
                final List<NotificationData> data = success.getNotification().getData();
                List<NotificationData> list = data;
                if (list != null && !list.isEmpty()) {
                    composer2.startReplaceGroup(-1859916313);
                    ComposerKt.sourceInformation(composer2, "105@5108L25,105@5077L57,110@5418L7523,106@5167L7774");
                    ComposerKt.sourceInformationMarkerStart(composer2, -614192103, "CC(remember):NotificationScreen.kt#9igjgp");
                    boolean zChangedInstance = composer2.changedInstance(data);
                    Object objRememberedValue = composer2.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationScreenKt$$ExternalSyntheticLambda9
                            public final Object invoke() {
                                return Integer.valueOf(data.size());
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                    str = "C72@3469L9:Box.kt#2w3rfo";
                    PagerState pagerStateRememberPagerState = PagerStateKt.rememberPagerState(0, 0.0f, (Function0) objRememberedValue, composer2, 0, 3);
                    Modifier modifierWeight$default = ColumnScope.weight$default(columnScope, Modifier.Companion, 1.0f, false, 2, (Object) null);
                    boolean z = !success.isSubmitting();
                    Function4 function4RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1908507962, true, new Function4() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationScreenKt$$ExternalSyntheticLambda10
                        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return NotificationScreenKt.NotificationScreen$lambda$36$lambda$35$lambda$31$lambda$30(data, notificationViewModel, notificationScreenUiStateNotificationScreen$lambda$0, state2, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    }, composer2, 54);
                    composer2 = composer;
                    str3 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                    str4 = "CC(remember):NotificationScreen.kt#9igjgp";
                    str5 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                    PagerKt.HorizontalPager--8jOkeI(pagerStateRememberPagerState, modifierWeight$default, (PaddingValues) null, (PageSize) null, 0, 0.0f, (Alignment.Vertical) null, (TargetedFlingBehavior) null, z, false, (Function1) null, (NestedScrollConnection) null, (SnapPosition) null, (OverscrollEffect) null, function4RememberComposableLambda, composer2, 0, 24576, 16124);
                    if (pagerStateRememberPagerState.getPageCount() <= 1) {
                        composer2.startReplaceGroup(-1865154910);
                    } else {
                        composer2.startReplaceGroup(-1852250385);
                        ComposerKt.sourceInformation(composer2, "218@13042L43");
                        HorizontalPageProgressIndicatorKt.m1430HorizontalPageProgressIndicatoreaDK9VM(pagerStateRememberPagerState, null, 0L, 0L, composer2, 0, 14);
                    }
                    composer2.endReplaceGroup();
                    composer2.endReplaceGroup();
                } else {
                    str = "C72@3469L9:Box.kt#2w3rfo";
                    str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                    str3 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                    str4 = "CC(remember):NotificationScreen.kt#9igjgp";
                    str5 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                    composer2.startReplaceGroup(-1860441236);
                    ComposerKt.sourceInformation(composer2, "100@4818L138,99@4776L214");
                    TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.notification_session_info_responded, composer2, 0), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262142);
                    composer2 = composer;
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
            if (NotificationScreen$lambda$0(state) instanceof NotificationScreenUiState.Success) {
                NotificationScreenUiState notificationScreenUiStateNotificationScreen$lambda$1 = NotificationScreen$lambda$0(state);
                Intrinsics.checkNotNull(notificationScreenUiStateNotificationScreen$lambda$1, "null cannot be cast to non-null type com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationScreenUiState.Success");
                if (!((NotificationScreenUiState.Success) notificationScreenUiStateNotificationScreen$lambda$1).isSubmitting()) {
                    composer2.startReplaceGroup(2005494616);
                } else {
                    composer2.startReplaceGroup(2018751425);
                    ComposerKt.sourceInformation(composer2, "229@13596L2,225@13367L527");
                    Modifier modifier = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.3f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null);
                    ComposerKt.sourceInformationMarkerStart(composer2, -627608180, str4);
                    Object objRememberedValue2 = composer2.rememberedValue();
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationScreenKt$$ExternalSyntheticLambda11
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Modifier modifierZIndex = ZIndexModifierKt.zIndex(ClickableKt.clickable-oSLSa3U$default(modifier, true, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) objRememberedValue2, 14, (Object) null), 10.0f);
                    Alignment center2 = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, str3);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, str5);
                    int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                    CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, modifierZIndex);
                    Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -553112988, str2);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor3);
                    } else {
                        composer2.useNode();
                    }
                    Composer composer5 = Updater.constructor-impl(composer2);
                    Updater.set-impl(composer5, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer5, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl(composer5, Integer.valueOf(iHashCode3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl(composer5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl(composer5, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, 1833054614, str);
                    BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 1426717310, "C234@13827L11,233@13750L122:NotificationScreen.kt#om2ogl");
                    ProgressIndicatorKt.CircularProgressIndicator-4lLiAd8((Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimary-0d7_KjU(), 0.0f, 0L, 0, 0.0f, composer2, 0, 61);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                }
            } else {
                composer2.startReplaceGroup(2005494616);
            }
            composer2.endReplaceGroup();
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
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.KotlinNothingValueException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit NotificationScreen$lambda$36$lambda$35$lambda$31$lambda$30(List list, final NotificationViewModel notificationViewModel, NotificationScreenUiState notificationScreenUiState, State state, PagerScope pagerScope, int i, Composer composer, int i2) throws NoWhenBranchMatchedException, KotlinNothingValueException {
        Intrinsics.checkNotNullParameter(pagerScope, "$this$HorizontalPager");
        ComposerKt.sourceInformation(composer, "C:NotificationScreen.kt#om2ogl");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1908507962, i2, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NotificationScreen.kt:111)");
        }
        final NotificationData notificationData = (NotificationData) list.get(i);
        int i3 = WhenMappings.$EnumSwitchMapping$0[notificationData.getPageType().ordinal()];
        if (i3 == 1) {
            composer.startReplaceGroup(416602217);
            ComposerKt.sourceInformation(composer, "114@5690L219");
            BasicNotificationPageKt.BasicNotificationPage(notificationData, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), composer, NotificationData.$stable | 48, 0);
            composer.endReplaceGroup();
        } else if (i3 == 2) {
            composer.startReplaceGroup(417012688);
            ComposerKt.sourceInformation(composer, "123@6305L523,131@6894L523,120@6067L1396");
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, -125087183, "CC(remember):NotificationScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(notificationViewModel) | composer.changedInstance(notificationData);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationScreenKt$$ExternalSyntheticLambda12
                    public final Object invoke(Object obj) {
                        return NotificationScreenKt.NotificationScreen$lambda$36$lambda$35$lambda$31$lambda$30$lambda$11$lambda$10(notificationViewModel, notificationData, (NotificationResponseType) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -125068335, "CC(remember):NotificationScreen.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(notificationViewModel) | composer.changedInstance(notificationData);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationScreenKt$$ExternalSyntheticLambda13
                    public final Object invoke(Object obj) {
                        return NotificationScreenKt.NotificationScreen$lambda$36$lambda$35$lambda$31$lambda$30$lambda$13$lambda$12(notificationViewModel, notificationData, (NotificationResponseType) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextNotificationPageKt.TextNotificationPage(modifierFillMaxSize$default, notificationData, function1, (Function1) objRememberedValue2, composer, (NotificationData.$stable << 3) | 6, 0);
            composer.endReplaceGroup();
        } else if (i3 == 3) {
            composer.startReplaceGroup(418569229);
            ComposerKt.sourceInformation(composer, "146@7982L443,153@8491L523,161@9081L373,142@7621L1879");
            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Set<String> optionsForPage = ((NotificationScreenUiState.Success) notificationScreenUiState).getUserSelections().getOptionsForPage(notificationData.getPageId());
            ComposerKt.sourceInformationMarkerStart(composer, -125033599, "CC(remember):NotificationScreen.kt#9igjgp");
            boolean zChangedInstance3 = composer.changedInstance(notificationViewModel) | composer.changedInstance(notificationData);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationScreenKt$$ExternalSyntheticLambda14
                    public final Object invoke() {
                        return NotificationScreenKt.NotificationScreen$lambda$36$lambda$35$lambda$31$lambda$30$lambda$15$lambda$14(notificationViewModel, notificationData);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            Function0 function0 = (Function0) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -125017231, "CC(remember):NotificationScreen.kt#9igjgp");
            boolean zChangedInstance4 = composer.changedInstance(notificationViewModel) | composer.changedInstance(notificationData);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance4 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationScreenKt$$ExternalSyntheticLambda15
                    public final Object invoke(Object obj) {
                        return NotificationScreenKt.NotificationScreen$lambda$36$lambda$35$lambda$31$lambda$30$lambda$17$lambda$16(notificationViewModel, notificationData, (NotificationResponseType) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            Function1 function2 = (Function1) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -124998501, "CC(remember):NotificationScreen.kt#9igjgp");
            boolean zChangedInstance5 = composer.changedInstance(notificationViewModel) | composer.changedInstance(notificationData);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChangedInstance5 || objRememberedValue5 == Composer.Companion.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationScreenKt$$ExternalSyntheticLambda16
                    public final Object invoke(Object obj) {
                        return NotificationScreenKt.NotificationScreen$lambda$36$lambda$35$lambda$31$lambda$30$lambda$19$lambda$18(notificationViewModel, notificationData, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ListNotificationPageKt.ListNotificationPage(modifierFillMaxSize$default2, notificationData, optionsForPage, function0, function2, (Function1) objRememberedValue5, composer, (NotificationData.$stable << 3) | 6, 0);
            composer.endReplaceGroup();
        } else if (i3 == 4) {
            composer.startReplaceGroup(420575983);
            ComposerKt.sourceInformation(composer, "173@9898L523,181@10487L523,170@9659L1397");
            Modifier modifierFillMaxSize$default3 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, -124972207, "CC(remember):NotificationScreen.kt#9igjgp");
            boolean zChangedInstance6 = composer.changedInstance(notificationViewModel) | composer.changedInstance(notificationData);
            Object objRememberedValue6 = composer.rememberedValue();
            if (zChangedInstance6 || objRememberedValue6 == Composer.Companion.getEmpty()) {
                objRememberedValue6 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationScreenKt$$ExternalSyntheticLambda17
                    public final Object invoke(Object obj) {
                        return NotificationScreenKt.NotificationScreen$lambda$36$lambda$35$lambda$31$lambda$30$lambda$21$lambda$20(notificationViewModel, notificationData, (NotificationResponseType) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            }
            Function1 function3 = (Function1) objRememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -124953359, "CC(remember):NotificationScreen.kt#9igjgp");
            boolean zChangedInstance7 = composer.changedInstance(notificationViewModel) | composer.changedInstance(notificationData);
            Object objRememberedValue7 = composer.rememberedValue();
            if (zChangedInstance7 || objRememberedValue7 == Composer.Companion.getEmpty()) {
                objRememberedValue7 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationScreenKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        return NotificationScreenKt.NotificationScreen$lambda$36$lambda$35$lambda$31$lambda$30$lambda$23$lambda$22(notificationViewModel, notificationData, (NotificationResponseType) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue7);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ImageNotificationPageKt.ImageNotificationPage(modifierFillMaxSize$default3, notificationData, function3, (Function1) objRememberedValue7, composer, (NotificationData.$stable << 3) | 6, 0);
            composer.endReplaceGroup();
        } else {
            if (i3 != 5) {
                composer.startReplaceGroup(-125104571);
                composer.endReplaceGroup();
                throw new NoWhenBranchMatchedException();
            }
            composer.startReplaceGroup(422126200);
            ComposerKt.sourceInformation(composer, "196@11541L62,197@11669L523,205@12258L523,192@11215L1612");
            MediaPlayerState mediaPlayerStateNotificationScreen$lambda$1 = NotificationScreen$lambda$1(state);
            Player player = notificationViewModel.getPlayer();
            ComposerKt.sourceInformationMarkerStart(composer, -124920092, "CC(remember):NotificationScreen.kt#9igjgp");
            boolean zChangedInstance8 = composer.changedInstance(notificationViewModel);
            Object objRememberedValue8 = composer.rememberedValue();
            if (zChangedInstance8 || objRememberedValue8 == Composer.Companion.getEmpty()) {
                objRememberedValue8 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationScreenKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        return NotificationScreenKt.NotificationScreen$lambda$36$lambda$35$lambda$31$lambda$30$lambda$25$lambda$24(notificationViewModel, (MediaItem) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue8);
            }
            Function1 function4 = (Function1) objRememberedValue8;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -124915535, "CC(remember):NotificationScreen.kt#9igjgp");
            boolean zChangedInstance9 = composer.changedInstance(notificationViewModel) | composer.changedInstance(notificationData);
            Object objRememberedValue9 = composer.rememberedValue();
            if (zChangedInstance9 || objRememberedValue9 == Composer.Companion.getEmpty()) {
                objRememberedValue9 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationScreenKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        return NotificationScreenKt.NotificationScreen$lambda$36$lambda$35$lambda$31$lambda$30$lambda$27$lambda$26(notificationViewModel, notificationData, (NotificationResponseType) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue9);
            }
            Function1 function5 = (Function1) objRememberedValue9;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -124896687, "CC(remember):NotificationScreen.kt#9igjgp");
            boolean zChangedInstance10 = composer.changedInstance(notificationViewModel) | composer.changedInstance(notificationData);
            Object objRememberedValue10 = composer.rememberedValue();
            if (zChangedInstance10 || objRememberedValue10 == Composer.Companion.getEmpty()) {
                objRememberedValue10 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationScreenKt$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj) {
                        return NotificationScreenKt.NotificationScreen$lambda$36$lambda$35$lambda$31$lambda$30$lambda$29$lambda$28(notificationViewModel, notificationData, (NotificationResponseType) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue10);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            VideoNotificationPageKt.VideoNotificationPage(null, notificationData, mediaPlayerStateNotificationScreen$lambda$1, player, function4, function5, (Function1) objRememberedValue10, composer, (NotificationData.$stable << 3) | (MediaPlayerState.$stable << 6), 1);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit NotificationScreen$lambda$36$lambda$35$lambda$31$lambda$30$lambda$11$lambda$10(NotificationViewModel notificationViewModel, NotificationData notificationData, NotificationResponseType notificationResponseType) throws NoWhenBranchMatchedException {
        Intrinsics.checkNotNullParameter(notificationResponseType, "responseType");
        notificationViewModel.onAction(new NotificationScreenUiAction.OnNotificationActionClick(notificationData.getPageId(), notificationResponseType));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit NotificationScreen$lambda$36$lambda$35$lambda$31$lambda$30$lambda$13$lambda$12(NotificationViewModel notificationViewModel, NotificationData notificationData, NotificationResponseType notificationResponseType) throws NoWhenBranchMatchedException {
        Intrinsics.checkNotNullParameter(notificationResponseType, "responseType");
        notificationViewModel.onAction(new NotificationScreenUiAction.OnNotificationActionClick(notificationData.getPageId(), notificationResponseType));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit NotificationScreen$lambda$36$lambda$35$lambda$31$lambda$30$lambda$15$lambda$14(NotificationViewModel notificationViewModel, NotificationData notificationData) throws NoWhenBranchMatchedException {
        notificationViewModel.onAction(new NotificationScreenUiAction.OnNotificationSubmitListActionClick(notificationData.getPageId()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit NotificationScreen$lambda$36$lambda$35$lambda$31$lambda$30$lambda$17$lambda$16(NotificationViewModel notificationViewModel, NotificationData notificationData, NotificationResponseType notificationResponseType) throws NoWhenBranchMatchedException {
        Intrinsics.checkNotNullParameter(notificationResponseType, "responseType");
        notificationViewModel.onAction(new NotificationScreenUiAction.OnNotificationActionClick(notificationData.getPageId(), notificationResponseType));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotificationScreen$lambda$36$lambda$35$lambda$31$lambda$30$lambda$19$lambda$18(NotificationViewModel notificationViewModel, NotificationData notificationData, String str) {
        Intrinsics.checkNotNullParameter(str, "option");
        notificationViewModel.updateSelectedOptions(notificationData.getPageId(), StringsKt.trim(str).toString());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit NotificationScreen$lambda$36$lambda$35$lambda$31$lambda$30$lambda$21$lambda$20(NotificationViewModel notificationViewModel, NotificationData notificationData, NotificationResponseType notificationResponseType) throws NoWhenBranchMatchedException {
        Intrinsics.checkNotNullParameter(notificationResponseType, "responseType");
        notificationViewModel.onAction(new NotificationScreenUiAction.OnNotificationActionClick(notificationData.getPageId(), notificationResponseType));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit NotificationScreen$lambda$36$lambda$35$lambda$31$lambda$30$lambda$23$lambda$22(NotificationViewModel notificationViewModel, NotificationData notificationData, NotificationResponseType notificationResponseType) throws NoWhenBranchMatchedException {
        Intrinsics.checkNotNullParameter(notificationResponseType, "responseType");
        notificationViewModel.onAction(new NotificationScreenUiAction.OnNotificationActionClick(notificationData.getPageId(), notificationResponseType));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotificationScreen$lambda$36$lambda$35$lambda$31$lambda$30$lambda$25$lambda$24(NotificationViewModel notificationViewModel, MediaItem mediaItem) {
        Intrinsics.checkNotNullParameter(mediaItem, "mediaItem");
        notificationViewModel.setMediaItem(mediaItem);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit NotificationScreen$lambda$36$lambda$35$lambda$31$lambda$30$lambda$27$lambda$26(NotificationViewModel notificationViewModel, NotificationData notificationData, NotificationResponseType notificationResponseType) throws NoWhenBranchMatchedException {
        Intrinsics.checkNotNullParameter(notificationResponseType, "responseType");
        notificationViewModel.onAction(new NotificationScreenUiAction.OnNotificationActionClick(notificationData.getPageId(), notificationResponseType));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit NotificationScreen$lambda$36$lambda$35$lambda$31$lambda$30$lambda$29$lambda$28(NotificationViewModel notificationViewModel, NotificationData notificationData, NotificationResponseType notificationResponseType) throws NoWhenBranchMatchedException {
        Intrinsics.checkNotNullParameter(notificationResponseType, "responseType");
        notificationViewModel.onAction(new NotificationScreenUiAction.OnNotificationActionClick(notificationData.getPageId(), notificationResponseType));
        return Unit.INSTANCE;
    }

    private static final NotificationScreenUiState NotificationScreen$lambda$0(State<? extends NotificationScreenUiState> state) {
        return (NotificationScreenUiState) state.getValue();
    }

    private static final MediaPlayerState NotificationScreen$lambda$1(State<MediaPlayerState> state) {
        return (MediaPlayerState) state.getValue();
    }
}
