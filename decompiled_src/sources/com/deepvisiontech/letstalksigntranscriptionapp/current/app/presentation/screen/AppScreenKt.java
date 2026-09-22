package com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.screen;

import android.content.Context;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.AnimationModifierKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.DrawerState;
import androidx.compose.material3.DrawerValue;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.NavigationDrawerKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.LongState;
import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotLongStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
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
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptionsBuilder;
import androidx.navigation.Navigator;
import androidx.navigation.PopUpToBuilder;
import androidx.navigation.compose.NavHostControllerKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.components.appscreen.DrawerContentKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.navigation.AppNavHostKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.navigation.graphs.MainGraph;
import com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel.AppUiAction;
import com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel.AppUiState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel.AppViewModel;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.navigation.AuthRoute;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.ShareAppDialogKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.navigation.ConversationNavigationRoute;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.domain.model.EnvironmentSound;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.WebViewManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.navigation.NotificationRoute;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.navigation.SignPracticeRoute;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: compiled from: AppScreen.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a!\u0010\u0007\u001a\u00020\u00012\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\f¨\u0006\r²\u0006\n\u0010\u000e\u001a\u00020\u000fX\u008a\u0084\u0002²\u0006\f\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u008a\u008e\u0002²\u0006\n\u0010\u0012\u001a\u00020\u0013X\u008a\u008e\u0002²\u0006\f\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u008a\u0084\u0002"}, d2 = {"AppScreen", "", "webViewManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/manager/WebViewManager;", "appViewModel", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/app/presentation/viewmodel/AppViewModel;", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/manager/WebViewManager;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/app/presentation/viewmodel/AppViewModel;Landroidx/compose/runtime/Composer;II)V", "EnvironmentSoundPill", "sound", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/domain/model/EnvironmentSound;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/domain/model/EnvironmentSound;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "app_release", "uiState", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/app/presentation/viewmodel/AppUiState;", "lastVibratedLabel", "", "lastVibrateTime", "", "navBackStackEntry", "Landroidx/navigation/NavBackStackEntry;"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AppScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppScreen$lambda$29(WebViewManager webViewManager, AppViewModel appViewModel, int i, int i2, Composer composer, int i3) {
        AppScreen(webViewManager, appViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EnvironmentSoundPill$lambda$38(EnvironmentSound environmentSound, Modifier modifier, int i, int i2, Composer composer, int i3) {
        EnvironmentSoundPill(environmentSound, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x02ae  */
    /* JADX WARN: Code duplicated, block: B:105:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:107:0x02e5  */
    /* JADX WARN: Code duplicated, block: B:110:0x033f  */
    /* JADX WARN: Code duplicated, block: B:52:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:55:0x0144  */
    /* JADX WARN: Code duplicated, block: B:58:0x016b  */
    /* JADX WARN: Code duplicated, block: B:61:0x018b  */
    /* JADX WARN: Code duplicated, block: B:64:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:65:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:67:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:79:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:82:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:83:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:88:0x0220  */
    /* JADX WARN: Code duplicated, block: B:93:0x0268  */
    /* JADX WARN: Code duplicated, block: B:96:0x028b  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void AppScreen(final WebViewManager webViewManager, AppViewModel appViewModel, Composer composer, final int i, final int i2) {
        int i3;
        final AppViewModel appViewModel2;
        CreationExtras defaultViewModelCreationExtras;
        int i4;
        final State stateCollectAsStateWithLifecycle;
        Context context;
        final NavController navControllerRememberNavController;
        Object objRememberedValue;
        Object objRememberedValue2;
        MutableState mutableState;
        Object objRememberedValue3;
        MutableLongState mutableLongState;
        NavBackStackEntry navBackStackEntryAppScreen$lambda$7;
        NavDestination destination;
        int i5;
        boolean zChangedInstance;
        AppScreenKt$AppScreen$1$1 appScreenKt$AppScreen$1$1RememberedValue;
        boolean zChanged;
        AppScreenKt$AppScreen$2$1 appScreenKt$AppScreen$2$1RememberedValue;
        boolean zChangedInstance2;
        Object objRememberedValue4;
        boolean zChangedInstance3;
        Object objRememberedValue5;
        int i6;
        Intrinsics.checkNotNullParameter(webViewManager, "webViewManager");
        Composer composerStartRestartGroup = composer.startRestartGroup(209234958);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AppScreen)P(1)67@4108L29,68@4169L7,70@4200L39,71@4264L23,72@4304L24,74@4359L42,75@4429L35,77@4509L30,87@5174L470,87@5153L491,103@5718L837,103@5650L905,141@7004L1037,169@8048L719,138@6873L1894:AppScreen.kt#3jxhm1");
        if ((i & 6) == 0) {
            i3 = ((i & 8) == 0 ? composerStartRestartGroup.changed(webViewManager) : composerStartRestartGroup.changedInstance(webViewManager) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                appViewModel2 = appViewModel;
                int i7 = composerStartRestartGroup.changedInstance(appViewModel2) ? 32 : 16;
                i3 |= i7;
            } else {
                appViewModel2 = appViewModel;
            }
            i3 |= i7;
        } else {
            appViewModel2 = appViewModel;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "65@4048L15");
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
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
                    ViewModel viewModel = ViewModelKt.viewModel(AppViewModel.class, current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 36936, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    i3 &= -113;
                    i4 = 0;
                    appViewModel2 = (AppViewModel) viewModel;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(209234958, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.screen.AppScreen (AppScreen.kt:66)");
                }
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(appViewModel2.getUiState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localContext);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                context = (Context) objConsume;
                final DrawerState drawerStateRememberDrawerState = NavigationDrawerKt.rememberDrawerState(DrawerValue.Closed, (Function1) null, composerStartRestartGroup, 6, 2);
                navControllerRememberNavController = NavHostControllerKt.rememberNavController(new Navigator[i4], composerStartRestartGroup, i4);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -788655208, "CC(remember):AppScreen.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -788652975, "CC(remember):AppScreen.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.Companion.getEmpty()) {
                    objRememberedValue3 = SnapshotLongStateKt.mutableLongStateOf(0L);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                mutableLongState = (MutableLongState) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                navBackStackEntryAppScreen$lambda$7 = AppScreen$lambda$7(NavHostControllerKt.currentBackStackEntryAsState(navControllerRememberNavController, composerStartRestartGroup, i4));
                if (navBackStackEntryAppScreen$lambda$7 != null) {
                    destination = navBackStackEntryAppScreen$lambda$7.getDestination();
                } else {
                    destination = null;
                }
                if (destination == null) {
                    i5 = i4;
                } else {
                    if (!NavDestination.Companion.hasRoute(destination, Reflection.getOrCreateKotlinClass(ConversationNavigationRoute.ConversationRoute.class)) || NavDestination.Companion.hasRoute(destination, Reflection.getOrCreateKotlinClass(ConversationNavigationRoute.ConversationListRoute.class)) || NavDestination.Companion.hasRoute(destination, Reflection.getOrCreateKotlinClass(ConversationNavigationRoute.ConversationSettingsRoute.class)) || NavDestination.Companion.hasRoute(destination, Reflection.getOrCreateKotlinClass(NotificationRoute.NotificationListScreen.class)) || NavDestination.Companion.hasRoute(destination, Reflection.getOrCreateKotlinClass(SignPracticeRoute.SignPracticeListScreen.class))) {
                        i6 = 1;
                    } else {
                        i6 = i4;
                    }
                    if (i6 == 1) {
                        i5 = 1;
                    } else {
                        i5 = i4;
                    }
                }
                Unit unit = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -788628700, "CC(remember):AppScreen.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(appViewModel2) | composerStartRestartGroup.changedInstance(navControllerRememberNavController);
                appScreenKt$AppScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance || appScreenKt$AppScreen$1$1RememberedValue == Composer.Companion.getEmpty()) {
                    appScreenKt$AppScreen$1$1RememberedValue = new AppScreenKt$AppScreen$1$1(appViewModel2, navControllerRememberNavController, null);
                    composerStartRestartGroup.updateRememberedValue(appScreenKt$AppScreen$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(unit, (Function2) appScreenKt$AppScreen$1$1RememberedValue, composerStartRestartGroup, 6);
                EnvironmentSound environmentSound = AppScreen$lambda$0(stateCollectAsStateWithLifecycle).getEnvironmentSound();
                Boolean boolValueOf = Boolean.valueOf(AppScreen$lambda$0(stateCollectAsStateWithLifecycle).isEnvSoundEnabled());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -788610925, "CC(remember):AppScreen.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | composerStartRestartGroup.changedInstance(context);
                appScreenKt$AppScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || appScreenKt$AppScreen$2$1RememberedValue == Composer.Companion.getEmpty()) {
                    appScreenKt$AppScreen$2$1RememberedValue = new AppScreenKt$AppScreen$2$1(stateCollectAsStateWithLifecycle, context, mutableLongState, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(appScreenKt$AppScreen$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(environmentSound, boolValueOf, (Function2) appScreenKt$AppScreen$2$1RememberedValue, composerStartRestartGroup, 0);
                if (AppScreen$lambda$0(stateCollectAsStateWithLifecycle).isShareAppDialogVisible()) {
                    composerStartRestartGroup.startReplaceGroup(1317165908);
                } else {
                    composerStartRestartGroup.startReplaceGroup(1323720455);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "129@6648L90,132@6762L89,128@6608L253");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -788581912, "CC(remember):AppScreen.kt#9igjgp");
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(appViewModel2);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance2 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                        objRememberedValue4 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.screen.AppScreenKt$$ExternalSyntheticLambda15
                            public final Object invoke() {
                                return AppScreenKt.AppScreen$lambda$12$lambda$11(appViewModel2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    Function0 function0 = (Function0) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -788578265, "CC(remember):AppScreen.kt#9igjgp");
                    zChangedInstance3 = composerStartRestartGroup.changedInstance(appViewModel2);
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance3 || objRememberedValue5 == Composer.Companion.getEmpty()) {
                        objRememberedValue5 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.screen.AppScreenKt$$ExternalSyntheticLambda16
                            public final Object invoke() {
                                return AppScreenKt.AppScreen$lambda$14$lambda$13(appViewModel2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ShareAppDialogKt.ShareAppDialog(function0, (Function0) objRememberedValue5, composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceGroup();
                final AppViewModel appViewModel3 = appViewModel2;
                final NavDestination navDestination = destination;
                Composer composer2 = composerStartRestartGroup;
                NavigationDrawerKt.ModalNavigationDrawer-FHprtrg(ComposableLambdaKt.rememberComposableLambda(940678055, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.screen.AppScreenKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj, Object obj2) {
                        return AppScreenKt.AppScreen$lambda$23(navDestination, navControllerRememberNavController, coroutineScope, drawerStateRememberDrawerState, appViewModel3, stateCollectAsStateWithLifecycle, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), (Modifier) null, drawerStateRememberDrawerState, i5, 0L, ComposableLambdaKt.rememberComposableLambda(643583404, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.screen.AppScreenKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj, Object obj2) {
                        return AppScreenKt.AppScreen$lambda$28(navControllerRememberNavController, webViewManager, coroutineScope, drawerStateRememberDrawerState, stateCollectAsStateWithLifecycle, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, 196614, 18);
                composerStartRestartGroup = composer2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                appViewModel2 = appViewModel3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
            }
            i4 = 0;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(209234958, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.screen.AppScreen (AppScreen.kt:66)");
            }
            stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(appViewModel2.getUiState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            CompositionLocal localContext2 = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localContext2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            context = (Context) objConsume2;
            final DrawerState drawerStateRememberDrawerState2 = NavigationDrawerKt.rememberDrawerState(DrawerValue.Closed, (Function1) null, composerStartRestartGroup, 6, 2);
            navControllerRememberNavController = NavHostControllerKt.rememberNavController(new Navigator[i4], composerStartRestartGroup, i4);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final CoroutineScope coroutineScope2 = (CoroutineScope) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -788655208, "CC(remember):AppScreen.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            mutableState = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -788652975, "CC(remember):AppScreen.kt#9igjgp");
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.Companion.getEmpty()) {
                objRememberedValue3 = SnapshotLongStateKt.mutableLongStateOf(0L);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            mutableLongState = (MutableLongState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            navBackStackEntryAppScreen$lambda$7 = AppScreen$lambda$7(NavHostControllerKt.currentBackStackEntryAsState(navControllerRememberNavController, composerStartRestartGroup, i4));
            if (navBackStackEntryAppScreen$lambda$7 != null) {
                destination = navBackStackEntryAppScreen$lambda$7.getDestination();
            } else {
                destination = null;
            }
            if (destination == null) {
                i5 = i4;
            } else {
                if (NavDestination.Companion.hasRoute(destination, Reflection.getOrCreateKotlinClass(ConversationNavigationRoute.ConversationRoute.class))) {
                    i6 = 1;
                } else {
                    i6 = 1;
                }
                if (i6 == 1) {
                    i5 = 1;
                } else {
                    i5 = i4;
                }
            }
            Unit unit2 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -788628700, "CC(remember):AppScreen.kt#9igjgp");
            zChangedInstance = composerStartRestartGroup.changedInstance(appViewModel2) | composerStartRestartGroup.changedInstance(navControllerRememberNavController);
            appScreenKt$AppScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance) {
                appScreenKt$AppScreen$1$1RememberedValue = new AppScreenKt$AppScreen$1$1(appViewModel2, navControllerRememberNavController, null);
                composerStartRestartGroup.updateRememberedValue(appScreenKt$AppScreen$1$1RememberedValue);
            } else {
                appScreenKt$AppScreen$1$1RememberedValue = new AppScreenKt$AppScreen$1$1(appViewModel2, navControllerRememberNavController, null);
                composerStartRestartGroup.updateRememberedValue(appScreenKt$AppScreen$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(unit2, (Function2) appScreenKt$AppScreen$1$1RememberedValue, composerStartRestartGroup, 6);
            EnvironmentSound environmentSound2 = AppScreen$lambda$0(stateCollectAsStateWithLifecycle).getEnvironmentSound();
            Boolean boolValueOf2 = Boolean.valueOf(AppScreen$lambda$0(stateCollectAsStateWithLifecycle).isEnvSoundEnabled());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -788610925, "CC(remember):AppScreen.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | composerStartRestartGroup.changedInstance(context);
            appScreenKt$AppScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                appScreenKt$AppScreen$2$1RememberedValue = new AppScreenKt$AppScreen$2$1(stateCollectAsStateWithLifecycle, context, mutableLongState, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(appScreenKt$AppScreen$2$1RememberedValue);
            } else {
                appScreenKt$AppScreen$2$1RememberedValue = new AppScreenKt$AppScreen$2$1(stateCollectAsStateWithLifecycle, context, mutableLongState, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(appScreenKt$AppScreen$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(environmentSound2, boolValueOf2, (Function2) appScreenKt$AppScreen$2$1RememberedValue, composerStartRestartGroup, 0);
            if (AppScreen$lambda$0(stateCollectAsStateWithLifecycle).isShareAppDialogVisible()) {
                composerStartRestartGroup.startReplaceGroup(1317165908);
            } else {
                composerStartRestartGroup.startReplaceGroup(1323720455);
                ComposerKt.sourceInformation(composerStartRestartGroup, "129@6648L90,132@6762L89,128@6608L253");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -788581912, "CC(remember):AppScreen.kt#9igjgp");
                zChangedInstance2 = composerStartRestartGroup.changedInstance(appViewModel2);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance2) {
                    objRememberedValue4 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.screen.AppScreenKt$$ExternalSyntheticLambda15
                        public final Object invoke() {
                            return AppScreenKt.AppScreen$lambda$12$lambda$11(appViewModel2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.screen.AppScreenKt$$ExternalSyntheticLambda15
                        public final Object invoke() {
                            return AppScreenKt.AppScreen$lambda$12$lambda$11(appViewModel2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                Function0 function1 = (Function0) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -788578265, "CC(remember):AppScreen.kt#9igjgp");
                zChangedInstance3 = composerStartRestartGroup.changedInstance(appViewModel2);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance3) {
                    objRememberedValue5 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.screen.AppScreenKt$$ExternalSyntheticLambda16
                        public final Object invoke() {
                            return AppScreenKt.AppScreen$lambda$14$lambda$13(appViewModel2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.screen.AppScreenKt$$ExternalSyntheticLambda16
                        public final Object invoke() {
                            return AppScreenKt.AppScreen$lambda$14$lambda$13(appViewModel2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ShareAppDialogKt.ShareAppDialog(function1, (Function0) objRememberedValue5, composerStartRestartGroup, 0);
            }
            composerStartRestartGroup.endReplaceGroup();
            final AppViewModel appViewModel4 = appViewModel2;
            final NavDestination navDestination2 = destination;
            Composer composer3 = composerStartRestartGroup;
            NavigationDrawerKt.ModalNavigationDrawer-FHprtrg(ComposableLambdaKt.rememberComposableLambda(940678055, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.screen.AppScreenKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    return AppScreenKt.AppScreen$lambda$23(navDestination2, navControllerRememberNavController, coroutineScope2, drawerStateRememberDrawerState2, appViewModel4, stateCollectAsStateWithLifecycle, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), (Modifier) null, drawerStateRememberDrawerState2, i5, 0L, ComposableLambdaKt.rememberComposableLambda(643583404, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.screen.AppScreenKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    return AppScreenKt.AppScreen$lambda$28(navControllerRememberNavController, webViewManager, coroutineScope2, drawerStateRememberDrawerState2, stateCollectAsStateWithLifecycle, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composer3, 196614, 18);
            composerStartRestartGroup = composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            appViewModel2 = appViewModel4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.screen.AppScreenKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    return AppScreenKt.AppScreen$lambda$29(webViewManager, appViewModel2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AppScreen$lambda$2(MutableState<String> mutableState) {
        return (String) ((State) mutableState).getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long AppScreen$lambda$5(MutableLongState mutableLongState) {
        return ((LongState) mutableLongState).getLongValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit AppScreen$lambda$12$lambda$11(AppViewModel appViewModel) throws NoWhenBranchMatchedException {
        appViewModel.onAction(AppUiAction.OnShareAppDialogDismiss.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit AppScreen$lambda$14$lambda$13(AppViewModel appViewModel) throws NoWhenBranchMatchedException {
        appViewModel.onAction(AppUiAction.OnShareAppDialogShared.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppScreen$lambda$23(NavDestination navDestination, final NavHostController navHostController, final CoroutineScope coroutineScope, final DrawerState drawerState, final AppViewModel appViewModel, State state, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C146@7236L410,158@7680L337,142@7018L1013:AppScreen.kt#3jxhm1");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(940678055, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.screen.AppScreen.<anonymous> (AppScreen.kt:142)");
            }
            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(Modifier.Companion, 0.8f);
            String userPersonaId = AppScreen$lambda$0(state).getUserPersonaId();
            ComposerKt.sourceInformationMarkerStart(composer, 2048486529, "CC(remember):AppScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(navHostController) | composer.changedInstance(coroutineScope) | composer.changed(drawerState);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.screen.AppScreenKt$$ExternalSyntheticLambda8
                    public final Object invoke(Object obj) {
                        return AppScreenKt.AppScreen$lambda$23$lambda$18$lambda$17(navHostController, coroutineScope, drawerState, obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 2048500664, "CC(remember):AppScreen.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(appViewModel) | composer.changedInstance(coroutineScope) | composer.changed(drawerState) | composer.changedInstance(navHostController);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.screen.AppScreenKt$$ExternalSyntheticLambda9
                    public final Object invoke() {
                        return AppScreenKt.AppScreen$lambda$23$lambda$22$lambda$21(appViewModel, coroutineScope, navHostController, drawerState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            DrawerContentKt.DrawerContent(modifierFillMaxWidth, navDestination, userPersonaId, function1, (Function0) objRememberedValue2, composer, 6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppScreen$lambda$23$lambda$18$lambda$17(NavHostController navHostController, CoroutineScope coroutineScope, DrawerState drawerState, Object obj) {
        Intrinsics.checkNotNullParameter(obj, "route");
        navHostController.navigate(obj, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.screen.AppScreenKt$$ExternalSyntheticLambda11
            public final Object invoke(Object obj2) {
                return AppScreenKt.AppScreen$lambda$23$lambda$18$lambda$17$lambda$16((NavOptionsBuilder) obj2);
            }
        });
        BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AppScreenKt$AppScreen$5$1$1$2(drawerState, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppScreen$lambda$23$lambda$18$lambda$17$lambda$16(NavOptionsBuilder navOptionsBuilder) {
        Intrinsics.checkNotNullParameter(navOptionsBuilder, "$this$navigate");
        navOptionsBuilder.popUpTo(MainGraph.INSTANCE, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.screen.AppScreenKt$$ExternalSyntheticLambda14
            public final Object invoke(Object obj) {
                return AppScreenKt.AppScreen$lambda$23$lambda$18$lambda$17$lambda$16$lambda$15((PopUpToBuilder) obj);
            }
        });
        navOptionsBuilder.setLaunchSingleTop(true);
        navOptionsBuilder.setRestoreState(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppScreen$lambda$23$lambda$18$lambda$17$lambda$16$lambda$15(PopUpToBuilder popUpToBuilder) {
        Intrinsics.checkNotNullParameter(popUpToBuilder, "$this$popUpTo");
        popUpToBuilder.setSaveState(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit AppScreen$lambda$23$lambda$22$lambda$21(AppViewModel appViewModel, CoroutineScope coroutineScope, NavHostController navHostController, DrawerState drawerState) throws NoWhenBranchMatchedException {
        appViewModel.onAction(AppUiAction.LogOut.INSTANCE);
        BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AppScreenKt$AppScreen$5$2$1$1(drawerState, null), 3, (Object) null);
        navHostController.navigate(AuthRoute.SignInScreen.INSTANCE, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.screen.AppScreenKt$$ExternalSyntheticLambda12
            public final Object invoke(Object obj) {
                return AppScreenKt.AppScreen$lambda$23$lambda$22$lambda$21$lambda$20((NavOptionsBuilder) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppScreen$lambda$23$lambda$22$lambda$21$lambda$20(NavOptionsBuilder navOptionsBuilder) {
        Intrinsics.checkNotNullParameter(navOptionsBuilder, "$this$navigate");
        navOptionsBuilder.popUpTo(0, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.screen.AppScreenKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return AppScreenKt.AppScreen$lambda$23$lambda$22$lambda$21$lambda$20$lambda$19((PopUpToBuilder) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppScreen$lambda$23$lambda$22$lambda$21$lambda$20$lambda$19(PopUpToBuilder popUpToBuilder) {
        Intrinsics.checkNotNullParameter(popUpToBuilder, "$this$popUpTo");
        popUpToBuilder.setInclusive(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppScreen$lambda$28(NavHostController navHostController, WebViewManager webViewManager, final CoroutineScope coroutineScope, final DrawerState drawerState, State state, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C170@8058L703:AppScreen.kt#3jxhm1");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(643583404, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.screen.AppScreen.<anonymous> (AppScreen.kt:170)");
            }
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
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
            ComposerKt.sourceInformationMarkerStart(composer, -526708399, "C174@8251L119,171@8111L273,181@8398L353:AppScreen.kt#3jxhm1");
            ComposerKt.sourceInformationMarkerStart(composer, -432628631, "CC(remember):AppScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(coroutineScope) | composer.changed(drawerState);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.screen.AppScreenKt$$ExternalSyntheticLambda13
                    public final Object invoke() {
                        return AppScreenKt.AppScreen$lambda$28$lambda$27$lambda$25$lambda$24(coroutineScope, drawerState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            AppNavHostKt.AppNavHost(navHostController, webViewManager, (Function0) objRememberedValue, composer, 0);
            Modifier modifier = PaddingKt.padding-qDBjuR0$default(WindowInsetsPadding_androidKt.statusBarsPadding(boxScope.align(Modifier.Companion, Alignment.Companion.getTopEnd())), 0.0f, Dp.constructor-impl(64), Dp.constructor-impl(16), 0.0f, 9, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifier);
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
            Updater.set-impl(composer3, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer3, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer3, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -2106525778, "C:AppScreen.kt#3jxhm1");
            if (!AppScreen$lambda$0(state).isEnvSoundEnabled()) {
                composer.startReplaceGroup(-2115073750);
            } else {
                composer.startReplaceGroup(-2106495988);
                ComposerKt.sourceInformation(composer, "188@8665L54");
                EnvironmentSoundPill(AppScreen$lambda$0(state).getEnvironmentSound(), null, composer, 0, 2);
            }
            composer.endReplaceGroup();
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
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppScreen$lambda$28$lambda$27$lambda$25$lambda$24(CoroutineScope coroutineScope, DrawerState drawerState) {
        BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AppScreenKt$AppScreen$6$1$1$1$1(drawerState, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    public static final void EnvironmentSoundPill(final EnvironmentSound environmentSound, final Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-746314114);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(EnvironmentSoundPill)P(1)202@8998L10,203@9075L10,204@9093L1251,200@8881L1463:AppScreen.kt#3jxhm1");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(environmentSound) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-746314114, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.screen.EnvironmentSoundPill (AppScreen.kt:199)");
            }
            boolean z = environmentSound != null;
            EnterTransition enterTransitionFadeIn$default = EnterExitTransitionKt.fadeIn$default((FiniteAnimationSpec) null, 0.0f, 3, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 51682152, "CC(remember):AppScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.screen.AppScreenKt$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj) {
                        return Integer.valueOf(AppScreenKt.EnvironmentSoundPill$lambda$31$lambda$30(((Integer) obj).intValue()));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EnterTransition enterTransitionPlus = enterTransitionFadeIn$default.plus(EnterExitTransitionKt.slideInHorizontally$default((FiniteAnimationSpec) null, (Function1) objRememberedValue, 1, (Object) null));
            ExitTransition exitTransitionFadeOut$default = EnterExitTransitionKt.fadeOut$default((FiniteAnimationSpec) null, 0.0f, 3, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 51684616, "CC(remember):AppScreen.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.screen.AppScreenKt$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj) {
                        return Integer.valueOf(AppScreenKt.EnvironmentSoundPill$lambda$33$lambda$32(((Integer) obj).intValue()));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AnimatedVisibilityKt.AnimatedVisibility(z, (Modifier) null, enterTransitionPlus, exitTransitionFadeOut$default.plus(EnterExitTransitionKt.slideOutHorizontally$default((FiniteAnimationSpec) null, (Function1) objRememberedValue2, 1, (Object) null)), (String) null, ComposableLambdaKt.rememberComposableLambda(1242306390, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.screen.AppScreenKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AppScreenKt.EnvironmentSoundPill$lambda$37(environmentSound, modifier, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.screen.AppScreenKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    return AppScreenKt.EnvironmentSoundPill$lambda$38(environmentSound, modifier, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int EnvironmentSoundPill$lambda$31$lambda$30(int i) {
        return i / 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int EnvironmentSoundPill$lambda$33$lambda$32(int i) {
        return i / 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EnvironmentSoundPill$lambda$37(final EnvironmentSound environmentSound, Modifier modifier, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animatedVisibilityScope, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C:AppScreen.kt#3jxhm1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1242306390, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.screen.EnvironmentSoundPill.<anonymous> (AppScreen.kt:205)");
        }
        if (environmentSound == null) {
            composer.startReplaceGroup(-183470209);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-183470208);
            ComposerKt.sourceInformation(composer, "*209@9275L11,210@9371L11,212@9457L871,206@9143L1185");
            SurfaceKt.Surface-T9BRK9s(modifier, RoundedCornerShapeKt.RoundedCornerShape(50), Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getTertiaryContainer-0d7_KjU(), 0.85f, 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnTertiaryContainer-0d7_KjU(), 0.0f, Dp.constructor-impl(4), (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-148186680, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.screen.AppScreenKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2) {
                    return AppScreenKt.EnvironmentSoundPill$lambda$37$lambda$36$lambda$35(environmentSound, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 12779520, 80);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EnvironmentSoundPill$lambda$37$lambda$36$lambda$35(EnvironmentSound environmentSound, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C213@9475L839:AppScreen.kt#3jxhm1");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-148186680, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.screen.EnvironmentSoundPill.<anonymous>.<anonymous>.<anonymous> (AppScreen.kt:213)");
            }
            Modifier modifierAnimateContentSize$default = AnimationModifierKt.animateContentSize$default(PaddingKt.padding-VpY3zN4(Modifier.Companion, Dp.constructor-impl(12), Dp.constructor-impl(8)), (FiniteAnimationSpec) null, (Function2) null, 3, (Object) null);
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal center = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierAnimateContentSize$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, 743295663, "C220@9808L203,225@10032L39,228@10194L10,226@10092L204:AppScreen.kt#3jxhm1");
            IconKt.Icon-ww6aTOc(environmentSound.getIcon(), environmentSound.getLabel(), SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), 0L, composer, 384, 8);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(6)), composer, 6);
            TextKt.Text-Nvy7gAk(environmentSound.getLabel(), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, FontWeight.Companion.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelMedium(), composer, 1572864, 0, 131006);
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
    public static final AppUiState AppScreen$lambda$0(State<AppUiState> state) {
        return (AppUiState) state.getValue();
    }

    private static final NavBackStackEntry AppScreen$lambda$7(State<NavBackStackEntry> state) {
        return (NavBackStackEntry) state.getValue();
    }
}
