package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens;

import android.content.Context;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
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
import androidx.compose.material.icons.filled.NotificationsKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
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
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.DateFilterRange;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.ListSortOrder;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.CircularProgressIndicatorComponentKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.DateRangePickerDialogKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.EmptyContentComponentKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.dialog.GenericConfirmationDialogKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ListScreenTopBarKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.Notification;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.NotificationData;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.components.NotificationCardKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationListScreenEvent;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationListScreenUiState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationListViewModel;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.SharedFlow;

/* JADX INFO: compiled from: NotificationsListScreen.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\u001aR\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\tH\u0007¢\u0006\u0002\u0010\u000e¨\u0006\u000f²\u0006\n\u0010\u0010\u001a\u00020\u0011X\u008a\u0084\u0002"}, d2 = {"NotificationListScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "notificationListViewModel", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationListViewModel;", "onDrawerClick", "Lkotlin/Function0;", "navigateToNotification", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "notificationId", "(Landroidx/compose/ui/Modifier;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationListViewModel;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "app_release", "uiState", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationListScreenUiState;"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class NotificationsListScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotificationListScreen$lambda$31(Modifier modifier, NotificationListViewModel notificationListViewModel, Function0 function0, Function1 function1, int i, int i2, Composer composer, int i3) {
        NotificationListScreen(modifier, notificationListViewModel, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r4v12, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v27 */
    public static final void NotificationListScreen(Modifier modifier, NotificationListViewModel notificationListViewModel, final Function0<Unit> function0, final Function1<? super String, Unit> function1, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        NotificationListViewModel notificationListViewModel2;
        final Modifier modifier3;
        final NotificationListViewModel notificationListViewModel3;
        boolean z;
        int i4;
        Modifier modifier4;
        int i5;
        CreationExtras defaultViewModelCreationExtras;
        ?? r4;
        Intrinsics.checkNotNullParameter(function0, "onDrawerClick");
        Intrinsics.checkNotNullParameter(function1, "navigateToNotification");
        Composer composerStartRestartGroup = composer.startRestartGroup(-291921757);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NotificationListScreen)P(!1,2,3)43@2512L16,46@2607L34,47@2669L34,50@2784L7,52@2821L314,52@2797L338,66@3197L944,175@8007L35,91@4161L3821,64@3141L4907:NotificationsListScreen.kt#om2ogl");
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
            if ((i2 & 2) == 0) {
                notificationListViewModel2 = notificationListViewModel;
                int i7 = composerStartRestartGroup.changedInstance(notificationListViewModel2) ? 32 : 16;
                i3 |= i7;
            } else {
                notificationListViewModel2 = notificationListViewModel;
            }
            i3 |= i7;
        } else {
            notificationListViewModel2 = notificationListViewModel;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "38@2345L15");
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
                i5 = i3;
                notificationListViewModel3 = notificationListViewModel2;
                i4 = 1;
                modifier4 = modifier2;
                r4 = 0;
            } else {
                Modifier modifier5 = i6 != 0 ? (Modifier) Modifier.Companion : modifier2;
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
                    i4 = 1;
                    ViewModel viewModel = ViewModelKt.viewModel(NotificationListViewModel.class, current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 36936, 0);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    notificationListViewModel2 = (NotificationListViewModel) viewModel;
                    i3 &= -113;
                } else {
                    z = false;
                    i4 = 1;
                }
                NotificationListViewModel notificationListViewModel4 = notificationListViewModel2;
                modifier4 = modifier5;
                notificationListViewModel3 = notificationListViewModel4;
                i5 = i3;
                r4 = z;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-291921757, i5, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationListScreen (NotificationsListScreen.kt:41)");
            }
            final State stateCollectAsState = SnapshotStateKt.collectAsState(notificationListViewModel3.getUiState(), (CoroutineContext) null, composerStartRestartGroup, (int) r4, i4);
            SharedFlow<NotificationListScreenEvent> uiEvent = notificationListViewModel3.getUiEvent();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1363921531, "CC(remember):NotificationsListScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf((boolean) r4), (SnapshotMutationPolicy) null, 2, (Object) null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1363919547, "CC(remember):NotificationsListScreen.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf((boolean) r4), (SnapshotMutationPolicy) null, 2, (Object) null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final SnackbarHostState snackbarHostState = new SnackbarHostState();
            CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Context context = (Context) objConsume;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1363914403, "CC(remember):NotificationsListScreen.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(uiEvent) | composerStartRestartGroup.changed(snackbarHostState) | composerStartRestartGroup.changedInstance(context);
            NotificationsListScreenKt$NotificationListScreen$1$1 notificationsListScreenKt$NotificationListScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || notificationsListScreenKt$NotificationListScreen$1$1RememberedValue == Composer.Companion.getEmpty()) {
                notificationsListScreenKt$NotificationListScreen$1$1RememberedValue = new NotificationsListScreenKt$NotificationListScreen$1$1(uiEvent, snackbarHostState, context, null);
                composerStartRestartGroup.updateRememberedValue(notificationsListScreenKt$NotificationListScreen$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(uiEvent, (Function2) notificationsListScreenKt$NotificationListScreen$1$1RememberedValue, composerStartRestartGroup, 0);
            ScaffoldKt.Scaffold-TvnljyQ(modifier4, ComposableLambdaKt.rememberComposableLambda(-910832793, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationsListScreenKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    return NotificationsListScreenKt.NotificationListScreen$lambda$14(function0, notificationListViewModel3, stateCollectAsState, mutableState2, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), (Function2) null, ComposableLambdaKt.rememberComposableLambda(-2099625367, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationsListScreenKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    return NotificationsListScreenKt.NotificationListScreen$lambda$15(snackbarHostState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), (Function2) null, 0, 0L, 0L, (WindowInsets) null, ComposableLambdaKt.rememberComposableLambda(-1263501646, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationsListScreenKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NotificationsListScreenKt.NotificationListScreen$lambda$30(mutableState, notificationListViewModel3, mutableState2, stateCollectAsState, function1, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i5 & 14) | 805309488, 500);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            notificationListViewModel3 = notificationListViewModel2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationsListScreenKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    return NotificationsListScreenKt.NotificationListScreen$lambda$31(modifier3, notificationListViewModel3, function0, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotificationListScreen$lambda$14(final Function0 function0, final NotificationListViewModel notificationListViewModel, State state, final MutableState mutableState, final MutableState mutableState2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C68@3253L86,71@3380L92,76@3608L19,77@3661L69,80@3768L67,83@3873L105,86@4018L99,67@3211L920:NotificationsListScreen.kt#om2ogl");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-910832793, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationListScreen.<anonymous> (NotificationsListScreen.kt:67)");
            }
            String strStringResource = StringResources_androidKt.stringResource(R.string.notification_list_title, composer, 0);
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.notification_list_search_hint, composer, 0);
            String searchQuery = NotificationListScreen$lambda$0(state).getSearchQuery();
            boolean zIsSelecting = NotificationListScreen$lambda$0(state).isSelecting();
            ComposerKt.sourceInformationMarkerStart(composer, 863027482, "CC(remember):NotificationsListScreen.kt#9igjgp");
            boolean zChanged = composer.changed(function0);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationsListScreenKt$$ExternalSyntheticLambda9
                    public final Object invoke() {
                        return NotificationsListScreenKt.NotificationListScreen$lambda$14$lambda$5$lambda$4(function0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function1 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 863029228, "CC(remember):NotificationsListScreen.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationsListScreenKt$$ExternalSyntheticLambda10
                    public final Object invoke() {
                        return NotificationsListScreenKt.NotificationListScreen$lambda$14$lambda$7$lambda$6(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function0 function2 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 863032650, "CC(remember):NotificationsListScreen.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.Companion.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationsListScreenKt$$ExternalSyntheticLambda11
                    public final Object invoke() {
                        return NotificationsListScreenKt.NotificationListScreen$lambda$14$lambda$9$lambda$8(mutableState2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            Function0 function3 = (Function0) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 863036048, "CC(remember):NotificationsListScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(notificationListViewModel);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue4 == Composer.Companion.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationsListScreenKt$$ExternalSyntheticLambda12
                    public final Object invoke(Object obj) {
                        return NotificationsListScreenKt.NotificationListScreen$lambda$14$lambda$11$lambda$10(notificationListViewModel, (ListSortOrder) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            Function1 function4 = (Function1) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 863040682, "CC(remember):NotificationsListScreen.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(notificationListViewModel);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue5 == Composer.Companion.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationsListScreenKt$$ExternalSyntheticLambda13
                    public final Object invoke(Object obj) {
                        return NotificationsListScreenKt.NotificationListScreen$lambda$14$lambda$13$lambda$12(notificationListViewModel, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ListScreenTopBarKt.ListScreenTopBar(null, strStringResource, strStringResource2, searchQuery, zIsSelecting, function1, function2, function3, function4, (Function1) objRememberedValue5, composer, 14155776, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotificationListScreen$lambda$14$lambda$5$lambda$4(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotificationListScreen$lambda$14$lambda$7$lambda$6(MutableState mutableState) {
        mutableState.setValue(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotificationListScreen$lambda$14$lambda$9$lambda$8(MutableState mutableState) {
        mutableState.setValue(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotificationListScreen$lambda$14$lambda$11$lambda$10(NotificationListViewModel notificationListViewModel, ListSortOrder listSortOrder) {
        Intrinsics.checkNotNullParameter(listSortOrder, "sortOrder");
        notificationListViewModel.updateSortOrder(listSortOrder);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotificationListScreen$lambda$14$lambda$13$lambda$12(NotificationListViewModel notificationListViewModel, String str) {
        Intrinsics.checkNotNullParameter(str, "query");
        notificationListViewModel.updateSearchQuery(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotificationListScreen$lambda$30(final MutableState mutableState, final NotificationListViewModel notificationListViewModel, final MutableState mutableState2, final State state, final Function1 function1, PaddingValues paddingValues, Composer composer, int i) {
        int i2;
        int i3;
        int i4;
        String str;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer2, "C92@4192L3780:NotificationsListScreen.kt#om2ogl");
        if ((i & 6) == 0) {
            i2 = i | (composer2.changed(paddingValues) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer2.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1263501646, i2, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationListScreen.<anonymous> (NotificationsListScreen.kt:92)");
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
            ComposerKt.sourceInformationMarkerStart(composer2, -321893174, "C:NotificationsListScreen.kt#om2ogl");
            if (!((Boolean) mutableState.getValue()).booleanValue()) {
                composer2.startReplaceGroup(-326439418);
            } else {
                composer2.startReplaceGroup(-321963204);
                ComposerKt.sourceInformation(composer2, "102@4649L113,105@4800L84,100@4520L386");
                Modifier modifier = PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8));
                ComposerKt.sourceInformationMarkerStart(composer2, -148928723, "CC(remember):NotificationsListScreen.kt#9igjgp");
                boolean zChangedInstance = composer2.changedInstance(notificationListViewModel);
                Object objRememberedValue = composer2.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationsListScreenKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            return NotificationsListScreenKt.NotificationListScreen$lambda$30$lambda$29$lambda$17$lambda$16(notificationListViewModel, (DateFilterRange) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                Function1 function2 = (Function1) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, -148923920, "CC(remember):NotificationsListScreen.kt#9igjgp");
                Object objRememberedValue2 = composer2.rememberedValue();
                if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationsListScreenKt$$ExternalSyntheticLambda5
                        public final Object invoke() {
                            return NotificationsListScreenKt.NotificationListScreen$lambda$30$lambda$29$lambda$19$lambda$18(mutableState);
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
                i4 = 0;
                str = "CC(remember):NotificationsListScreen.kt#9igjgp";
                composer2.startReplaceGroup(-326439418);
            } else {
                composer2.startReplaceGroup(-321476876);
                ComposerKt.sourceInformation(composer2, "113@5051L111,116@5202L110,119@5352L99,122@5491L99,125@5635L159,129@5837L103,112@4992L970");
                String strStringResource = StringResources_androidKt.stringResource(R.string.notification_dialog_delete_title, composer2, 0);
                String strStringResource2 = StringResources_androidKt.stringResource(R.string.notification_dialog_delete_desc, composer2, 0);
                String strStringResource3 = StringResources_androidKt.stringResource(R.string.global_action_accept, composer2, 0);
                String strStringResource4 = StringResources_androidKt.stringResource(R.string.global_action_cancel, composer2, 0);
                ComposerKt.sourceInformationMarkerStart(composer2, -148897125, "CC(remember):NotificationsListScreen.kt#9igjgp");
                boolean zChangedInstance2 = composer2.changedInstance(notificationListViewModel);
                Object objRememberedValue3 = composer2.rememberedValue();
                if (zChangedInstance2 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationsListScreenKt$$ExternalSyntheticLambda6
                        public final Object invoke() {
                            return NotificationsListScreenKt.NotificationListScreen$lambda$30$lambda$29$lambda$21$lambda$20(notificationListViewModel, mutableState2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                Function0 function0 = (Function0) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, -148890717, "CC(remember):NotificationsListScreen.kt#9igjgp");
                boolean zChangedInstance3 = composer2.changedInstance(notificationListViewModel);
                Object objRememberedValue4 = composer2.rememberedValue();
                if (zChangedInstance3 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                    objRememberedValue4 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationsListScreenKt$$ExternalSyntheticLambda7
                        public final Object invoke() {
                            return NotificationsListScreenKt.NotificationListScreen$lambda$30$lambda$29$lambda$23$lambda$22(notificationListViewModel);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                str = "CC(remember):NotificationsListScreen.kt#9igjgp";
                i3 = 1;
                i4 = 0;
                GenericConfirmationDialogKt.GenericConfirmationDialog(null, function0, (Function0) objRememberedValue4, strStringResource, strStringResource2, strStringResource3, strStringResource4, null, false, null, composer, 0, 897);
                composer2 = composer;
            }
            composer2.endReplaceGroup();
            if (NotificationListScreen$lambda$0(state).isLoading()) {
                composer2.startReplaceGroup(-320463517);
                ComposerKt.sourceInformation(composer2, "136@6043L27");
                CircularProgressIndicatorComponentKt.CircularProgressComponent(0, composer2, i4, i3);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-320335394);
                ComposerKt.sourceInformation(composer2, "");
                if (!NotificationListScreen$lambda$0(state).getNotifications().isEmpty()) {
                    composer2.startReplaceGroup(-320288026);
                    ComposerKt.sourceInformation(composer2, "143@6395L1147,139@6182L1360");
                    Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, i3, (Object) r13);
                    Alignment.Horizontal centerHorizontally2 = Alignment.Companion.getCenterHorizontally();
                    ComposerKt.sourceInformationMarkerStart(composer2, -148871817, str);
                    boolean zChanged = composer2.changed(state) | composer2.changedInstance(notificationListViewModel) | composer2.changed(function1);
                    Object objRememberedValue5 = composer2.rememberedValue();
                    if (zChanged || objRememberedValue5 == Composer.Companion.getEmpty()) {
                        objRememberedValue5 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationsListScreenKt$$ExternalSyntheticLambda8
                            public final Object invoke(Object obj) {
                                return NotificationsListScreenKt.NotificationListScreen$lambda$30$lambda$29$lambda$28$lambda$27(state, notificationListViewModel, function1, (LazyListScope) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    LazyDslKt.LazyColumn(modifierFillMaxSize$default, (LazyListState) null, (PaddingValues) null, false, (Arrangement.Vertical) null, centerHorizontally2, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) objRememberedValue5, composer2, 196614, 478);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(-318917516);
                    ComposerKt.sourceInformation(composer2, "167@7777L115,164@7596L322");
                    EmptyContentComponentKt.EmptyContentComponent(null, NotificationsKt.getNotifications(Icons.INSTANCE.getDefault()), null, StringResources_androidKt.stringResource(R.string.notification_list_info_empty, composer2, i4), composer2, 384, 1);
                    composer.endReplaceGroup();
                }
                composer.endReplaceGroup();
            }
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
    public static final Unit NotificationListScreen$lambda$30$lambda$29$lambda$17$lambda$16(NotificationListViewModel notificationListViewModel, DateFilterRange dateFilterRange) {
        Intrinsics.checkNotNullParameter(dateFilterRange, "range");
        notificationListViewModel.updateDateRange(dateFilterRange);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotificationListScreen$lambda$30$lambda$29$lambda$19$lambda$18(MutableState mutableState) {
        mutableState.setValue(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotificationListScreen$lambda$30$lambda$29$lambda$21$lambda$20(NotificationListViewModel notificationListViewModel, MutableState mutableState) {
        notificationListViewModel.clearSelectedIds();
        mutableState.setValue(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotificationListScreen$lambda$30$lambda$29$lambda$23$lambda$22(NotificationListViewModel notificationListViewModel) {
        notificationListViewModel.deleteNotifications();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotificationListScreen$lambda$30$lambda$29$lambda$28$lambda$27(final State state, final NotificationListViewModel notificationListViewModel, final Function1 function1, LazyListScope lazyListScope) {
        Intrinsics.checkNotNullParameter(lazyListScope, "$this$LazyColumn");
        final List<Notification> notifications = NotificationListScreen$lambda$0(state).getNotifications();
        final NotificationsListScreenKt$NotificationListScreen$lambda$30$lambda$29$lambda$28$lambda$27$$inlined$items$default$1 notificationsListScreenKt$NotificationListScreen$lambda$30$lambda$29$lambda$28$lambda$27$$inlined$items$default$1 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationsListScreenKt$NotificationListScreen$lambda$30$lambda$29$lambda$28$lambda$27$$inlined$items$default$1
            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final Void m1758invoke(Notification notification) {
                return null;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return m1758invoke((Notification) obj);
            }
        };
        lazyListScope.items(notifications.size(), (Function1) null, new Function1<Integer, Object>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationsListScreenKt$NotificationListScreen$lambda$30$lambda$29$lambda$28$lambda$27$$inlined$items$default$3
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Object invoke(int i) {
                return notificationsListScreenKt$NotificationListScreen$lambda$30$lambda$29$lambda$28$lambda$27$$inlined$items$default$1.invoke(notifications.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationsListScreenKt$NotificationListScreen$lambda$30$lambda$29$lambda$28$lambda$27$$inlined$items$default$4
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
                final Notification notification = (Notification) notifications.get(i);
                composer.startReplaceGroup(-1895534662);
                ComposerKt.sourceInformation(composer, "C*148@6720L145,151@6925L527,145@6504L982:NotificationsListScreen.kt#om2ogl");
                Modifier modifier = PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4));
                ComposerKt.sourceInformationMarkerStart(composer, 493049124, "CC(remember):NotificationsListScreen.kt#9igjgp");
                boolean zChangedInstance = composer.changedInstance(notificationListViewModel) | composer.changedInstance(notification);
                Object objRememberedValue = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                    final NotificationListViewModel notificationListViewModel2 = notificationListViewModel;
                    objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationsListScreenKt$NotificationListScreen$4$1$5$1$1$1$1
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m1756invoke();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m1756invoke() {
                            notificationListViewModel2.updateSelectedIds(notification.getId());
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Function0 function0 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, 493056066, "CC(remember):NotificationsListScreen.kt#9igjgp");
                boolean zChanged = composer.changed(state) | composer.changedInstance(notificationListViewModel) | composer.changedInstance(notification) | composer.changed(function1);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                    final NotificationListViewModel notificationListViewModel3 = notificationListViewModel;
                    final Function1 function2 = function1;
                    final State state2 = state;
                    objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationsListScreenKt$NotificationListScreen$4$1$5$1$1$2$1
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m1757invoke();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m1757invoke() {
                            if (NotificationsListScreenKt.NotificationListScreen$lambda$0(state2).isSelecting()) {
                                notificationListViewModel3.updateSelectedIds(notification.getId());
                                return;
                            }
                            List<NotificationData> data = notification.getData();
                            if (data == null || data.isEmpty()) {
                                return;
                            }
                            function2.invoke(notification.getId());
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                NotificationCardKt.NotificationCard(modifier, notification, function0, (Function0) objRememberedValue2, composer, (Notification.$stable << 3) | 6, 0);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotificationListScreen$lambda$15(SnackbarHostState snackbarHostState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C175@8009L31:NotificationsListScreen.kt#om2ogl");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2099625367, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationListScreen.<anonymous> (NotificationsListScreen.kt:175)");
            }
            SnackbarHostKt.SnackbarHost(snackbarHostState, (Modifier) null, (Function3) null, composer, 0, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NotificationListScreenUiState NotificationListScreen$lambda$0(State<NotificationListScreenUiState> state) {
        return (NotificationListScreenUiState) state.getValue();
    }
}
