package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.navigation;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavGraphBuilderKt;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.viewmodels.ConversationSharedViewModel;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationListScreenKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationSettingsScreenKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.DocumentScannerScreenKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.WebViewManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.screens.SignUploadScreenKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: ConversationNavigation.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b¨\u0006\t"}, d2 = {"conversationGraph", "", "Landroidx/navigation/NavGraphBuilder;", "navController", "Landroidx/navigation/NavController;", "webViewManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/manager/WebViewManager;", "onDrawerClick", "Lkotlin/Function0;", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ConversationNavigationKt {
    public static final void conversationGraph(NavGraphBuilder navGraphBuilder, final NavController navController, final WebViewManager webViewManager, final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(webViewManager, "webViewManager");
        Intrinsics.checkNotNullParameter(function0, "onDrawerClick");
        ConversationNavigationRoute.ConversationRoute conversationRoute = ConversationNavigationRoute.ConversationRoute.INSTANCE;
        Function1 function1 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.navigation.ConversationNavigationKt$$ExternalSyntheticLambda10
            public final Object invoke(Object obj) {
                return ConversationNavigationKt.conversationGraph$lambda$17(webViewManager, function0, navController, (NavGraphBuilder) obj);
            }
        };
        NavGraphBuilderKt.navigation(navGraphBuilder, Reflection.getOrCreateKotlinClass(ConversationGraph.class), conversationRoute, MapsKt.emptyMap(), function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit conversationGraph$lambda$17(final WebViewManager webViewManager, final Function0 function0, final NavController navController, NavGraphBuilder navGraphBuilder) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "$this$navigation");
        Function4 function4ComposableLambdaInstance = ComposableLambdaKt.composableLambdaInstance(1319296525, true, new Function4() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.navigation.ConversationNavigationKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return ConversationNavigationKt.conversationGraph$lambda$17$lambda$3(webViewManager, function0, navController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        androidx.navigation.compose.NavGraphBuilderKt.composable(navGraphBuilder, Reflection.getOrCreateKotlinClass(ConversationNavigationRoute.ConversationRoute.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, function4ComposableLambdaInstance);
        Function4 function4ComposableLambdaInstance2 = ComposableLambdaKt.composableLambdaInstance(-1994278026, true, new Function4() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.navigation.ConversationNavigationKt$$ExternalSyntheticLambda3
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return ConversationNavigationKt.conversationGraph$lambda$17$lambda$7(navController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        androidx.navigation.compose.NavGraphBuilderKt.composable(navGraphBuilder, Reflection.getOrCreateKotlinClass(ConversationNavigationRoute.DocumentScannerRoute.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, function4ComposableLambdaInstance2);
        Function4 function4ComposableLambdaInstance3 = ComposableLambdaKt.composableLambdaInstance(2058991957, true, new Function4() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.navigation.ConversationNavigationKt$$ExternalSyntheticLambda4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return ConversationNavigationKt.conversationGraph$lambda$17$lambda$10(function0, navController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        androidx.navigation.compose.NavGraphBuilderKt.composable(navGraphBuilder, Reflection.getOrCreateKotlinClass(ConversationNavigationRoute.ConversationListRoute.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, function4ComposableLambdaInstance3);
        Function4 function4ComposableLambdaInstance4 = ComposableLambdaKt.composableLambdaInstance(1817294644, true, new Function4() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.navigation.ConversationNavigationKt$$ExternalSyntheticLambda5
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return ConversationNavigationKt.conversationGraph$lambda$17$lambda$13(function0, navController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        androidx.navigation.compose.NavGraphBuilderKt.composable(navGraphBuilder, Reflection.getOrCreateKotlinClass(ConversationNavigationRoute.ConversationSettingsRoute.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, function4ComposableLambdaInstance4);
        Function4 function4ComposableLambdaInstance5 = ComposableLambdaKt.composableLambdaInstance(1575597331, true, new Function4() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.navigation.ConversationNavigationKt$$ExternalSyntheticLambda6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return ConversationNavigationKt.conversationGraph$lambda$17$lambda$16(navController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        androidx.navigation.compose.NavGraphBuilderKt.composable(navGraphBuilder, Reflection.getOrCreateKotlinClass(ConversationNavigationRoute.SignUploadRoute.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, function4ComposableLambdaInstance5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit conversationGraph$lambda$17$lambda$3(WebViewManager webViewManager, Function0 function0, final NavController navController, AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry, Composer composer, int i) {
        CreationExtras defaultViewModelCreationExtras;
        Intrinsics.checkNotNullParameter(animatedContentScope, "$this$composable");
        Intrinsics.checkNotNullParameter(navBackStackEntry, "backStackEntry");
        ComposerKt.sourceInformation(composer, "C23@1555L109,27@1741L25,32@2014L112,28@1779L361:ConversationNavigation.kt#22lc0i");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1319296525, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.navigation.conversationGraph.<anonymous>.<anonymous> (ConversationNavigation.kt:23)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 828609882, "CC(remember):ConversationNavigation.kt#9igjgp");
        boolean zChanged = composer.changed(navBackStackEntry);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = navController.getBackStackEntry(Reflection.getOrCreateKotlinClass(ConversationGraph.class));
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = (ViewModelStoreOwner) ((NavBackStackEntry) objRememberedValue);
        composer.startReplaceableGroup(1890788296);
        ComposerKt.sourceInformation(composer, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
        ViewModelProvider.Factory factoryCreateHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(hasDefaultViewModelProviderFactory, composer, 0);
        composer.startReplaceableGroup(1729797275);
        ComposerKt.sourceInformation(composer, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
        if (hasDefaultViewModelProviderFactory instanceof HasDefaultViewModelProviderFactory) {
            defaultViewModelCreationExtras = hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras();
        } else {
            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
        }
        ViewModel viewModel = ViewModelKt.viewModel(ConversationSharedViewModel.class, hasDefaultViewModelProviderFactory, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composer, 36936, 0);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        ConversationSharedViewModel conversationSharedViewModel = (ConversationSharedViewModel) viewModel;
        ComposerKt.sourceInformationMarkerStart(composer, 828624573, "CC(remember):ConversationNavigation.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(navController);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == Composer.Companion.getEmpty()) {
            objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.navigation.ConversationNavigationKt$$ExternalSyntheticLambda9
                public final Object invoke() {
                    return ConversationNavigationKt.conversationGraph$lambda$17$lambda$3$lambda$2$lambda$1(navController);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        ConversationScreenKt.ConversationScreen(null, conversationSharedViewModel, null, webViewManager, function0, (Function0) objRememberedValue2, composer, 0, 5);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit conversationGraph$lambda$17$lambda$3$lambda$2$lambda$1(NavController navController) {
        NavController.navigate$default(navController, ConversationNavigationRoute.DocumentScannerRoute.INSTANCE, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit conversationGraph$lambda$17$lambda$7(final NavController navController, AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry, Composer composer, int i) {
        CreationExtras defaultViewModelCreationExtras;
        Intrinsics.checkNotNullParameter(animatedContentScope, "$this$composable");
        Intrinsics.checkNotNullParameter(navBackStackEntry, "backStackEntry");
        ComposerKt.sourceInformation(composer, "C39@2270L109,43@2456L25,45@2548L68,44@2494L212:ConversationNavigation.kt#22lc0i");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1994278026, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.navigation.conversationGraph.<anonymous>.<anonymous> (ConversationNavigation.kt:39)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -945767293, "CC(remember):ConversationNavigation.kt#9igjgp");
        boolean zChanged = composer.changed(navBackStackEntry);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = navController.getBackStackEntry(Reflection.getOrCreateKotlinClass(ConversationGraph.class));
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = (ViewModelStoreOwner) ((NavBackStackEntry) objRememberedValue);
        composer.startReplaceableGroup(1890788296);
        ComposerKt.sourceInformation(composer, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
        ViewModelProvider.Factory factoryCreateHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(hasDefaultViewModelProviderFactory, composer, 0);
        composer.startReplaceableGroup(1729797275);
        ComposerKt.sourceInformation(composer, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
        if (hasDefaultViewModelProviderFactory instanceof HasDefaultViewModelProviderFactory) {
            defaultViewModelCreationExtras = hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras();
        } else {
            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
        }
        ViewModel viewModel = ViewModelKt.viewModel(ConversationSharedViewModel.class, hasDefaultViewModelProviderFactory, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composer, 36936, 0);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        ConversationSharedViewModel conversationSharedViewModel = (ConversationSharedViewModel) viewModel;
        ComposerKt.sourceInformationMarkerStart(composer, -945758438, "CC(remember):ConversationNavigation.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(navController);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == Composer.Companion.getEmpty()) {
            objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.navigation.ConversationNavigationKt$$ExternalSyntheticLambda8
                public final Object invoke() {
                    return ConversationNavigationKt.conversationGraph$lambda$17$lambda$7$lambda$6$lambda$5(navController);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        DocumentScannerScreenKt.DocumentScannerScreen(null, (Function0) objRememberedValue2, conversationSharedViewModel, null, composer, 0, 9);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit conversationGraph$lambda$17$lambda$7$lambda$6$lambda$5(NavController navController) {
        navController.popBackStack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit conversationGraph$lambda$17$lambda$10(Function0 function0, final NavController navController, AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animatedContentScope, "$this$composable");
        Intrinsics.checkNotNullParameter(navBackStackEntry, "it");
        ComposerKt.sourceInformation(composer, "C55@2914L109,53@2802L235:ConversationNavigation.kt#22lc0i");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2058991957, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.navigation.conversationGraph.<anonymous>.<anonymous> (ConversationNavigation.kt:53)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1288648638, "CC(remember):ConversationNavigation.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(navController);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.navigation.ConversationNavigationKt$$ExternalSyntheticLambda1
                public final Object invoke() {
                    return ConversationNavigationKt.conversationGraph$lambda$17$lambda$10$lambda$9$lambda$8(navController);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        ConversationListScreenKt.ConversationListScreen(null, null, function0, (Function0) objRememberedValue, composer, 0, 3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit conversationGraph$lambda$17$lambda$10$lambda$9$lambda$8(NavController navController) {
        NavController.navigate$default(navController, ConversationNavigationRoute.ConversationRoute.INSTANCE, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit conversationGraph$lambda$17$lambda$13(Function0 function0, final NavController navController, AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animatedContentScope, "$this$composable");
        Intrinsics.checkNotNullParameter(navBackStackEntry, "it");
        ComposerKt.sourceInformation(composer, "C64@3253L107,62@3137L237:ConversationNavigation.kt#22lc0i");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1817294644, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.navigation.conversationGraph.<anonymous>.<anonymous> (ConversationNavigation.kt:62)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1631532321, "CC(remember):ConversationNavigation.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(navController);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.navigation.ConversationNavigationKt$$ExternalSyntheticLambda7
                public final Object invoke() {
                    return ConversationNavigationKt.conversationGraph$lambda$17$lambda$13$lambda$12$lambda$11(navController);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        ConversationSettingsScreenKt.ConversationSettingsScreen(null, null, function0, (Function0) objRememberedValue, composer, 0, 3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit conversationGraph$lambda$17$lambda$13$lambda$12$lambda$11(NavController navController) {
        NavController.navigate$default(navController, ConversationNavigationRoute.SignUploadRoute.INSTANCE, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit conversationGraph$lambda$17$lambda$16(final NavController navController, AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animatedContentScope, "$this$composable");
        Intrinsics.checkNotNullParameter(navBackStackEntry, "it");
        ComposerKt.sourceInformation(composer, "C72@3513L68,71@3464L131:ConversationNavigation.kt#22lc0i");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1575597331, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.navigation.conversationGraph.<anonymous>.<anonymous> (ConversationNavigation.kt:71)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1974418313, "CC(remember):ConversationNavigation.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(navController);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.navigation.ConversationNavigationKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    return ConversationNavigationKt.conversationGraph$lambda$17$lambda$16$lambda$15$lambda$14(navController);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        SignUploadScreenKt.SignUploadScreen(null, null, (Function0) objRememberedValue, composer, 0, 3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit conversationGraph$lambda$17$lambda$16$lambda$15$lambda$14(NavController navController) {
        navController.popBackStack();
        return Unit.INSTANCE;
    }
}
