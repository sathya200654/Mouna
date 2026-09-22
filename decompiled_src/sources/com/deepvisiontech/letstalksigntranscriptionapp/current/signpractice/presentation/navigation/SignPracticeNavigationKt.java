package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.navigation;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavGraphBuilderKt;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.WebViewManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeCreationScreenKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeListScreenKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.SignPracticeSessionScreenKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: SignPracticeNavigation.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b¨\u0006\t"}, d2 = {"signPracticeGraph", "", "Landroidx/navigation/NavGraphBuilder;", "navController", "Landroidx/navigation/NavHostController;", "webViewManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/manager/WebViewManager;", "onDrawerClick", "Lkotlin/Function0;", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SignPracticeNavigationKt {
    public static final void signPracticeGraph(NavGraphBuilder navGraphBuilder, final NavHostController navHostController, final WebViewManager webViewManager, final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(navHostController, "navController");
        Intrinsics.checkNotNullParameter(webViewManager, "webViewManager");
        Intrinsics.checkNotNullParameter(function0, "onDrawerClick");
        SignPracticeRoute.SignPracticeListScreen signPracticeListScreen = SignPracticeRoute.SignPracticeListScreen.INSTANCE;
        Function1 function1 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.navigation.SignPracticeNavigationKt$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                return SignPracticeNavigationKt.signPracticeGraph$lambda$13(function0, navHostController, webViewManager, (NavGraphBuilder) obj);
            }
        };
        NavGraphBuilderKt.navigation(navGraphBuilder, Reflection.getOrCreateKotlinClass(SignPracticeGraph.class), signPracticeListScreen, MapsKt.emptyMap(), function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit signPracticeGraph$lambda$13(final Function0 function0, final NavHostController navHostController, final WebViewManager webViewManager, NavGraphBuilder navGraphBuilder) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "$this$navigation");
        Function4 function4ComposableLambdaInstance = ComposableLambdaKt.composableLambdaInstance(810719217, true, new Function4() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.navigation.SignPracticeNavigationKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return SignPracticeNavigationKt.signPracticeGraph$lambda$13$lambda$4(function0, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        androidx.navigation.compose.NavGraphBuilderKt.composable(navGraphBuilder, Reflection.getOrCreateKotlinClass(SignPracticeRoute.SignPracticeListScreen.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, function4ComposableLambdaInstance);
        Function4 function4ComposableLambdaInstance2 = ComposableLambdaKt.composableLambdaInstance(1639601640, true, new Function4() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.navigation.SignPracticeNavigationKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return SignPracticeNavigationKt.signPracticeGraph$lambda$13$lambda$9(navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        androidx.navigation.compose.NavGraphBuilderKt.composable(navGraphBuilder, Reflection.getOrCreateKotlinClass(SignPracticeRoute.SignPracticeCreationScreen.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, function4ComposableLambdaInstance2);
        Function4 function4ComposableLambdaInstance3 = ComposableLambdaKt.composableLambdaInstance(-399861847, true, new Function4() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.navigation.SignPracticeNavigationKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return SignPracticeNavigationKt.signPracticeGraph$lambda$13$lambda$12(webViewManager, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        androidx.navigation.compose.NavGraphBuilderKt.composable(navGraphBuilder, Reflection.getOrCreateKotlinClass(SignPracticeRoute.SignPracticeSessionScreen.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, function4ComposableLambdaInstance3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit signPracticeGraph$lambda$13$lambda$4(Function0 function0, final NavHostController navHostController, AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animatedContentScope, "$this$composable");
        Intrinsics.checkNotNullParameter(navBackStackEntry, "it");
        ComposerKt.sourceInformation(composer, "C20@1187L108,23@1345L117,18@1067L409:SignPracticeNavigation.kt#h89gs2");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(810719217, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.navigation.signPracticeGraph.<anonymous>.<anonymous> (SignPracticeNavigation.kt:18)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1712091357, "CC(remember):SignPracticeNavigation.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(navHostController);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.navigation.SignPracticeNavigationKt$$ExternalSyntheticLambda6
                public final Object invoke() {
                    return SignPracticeNavigationKt.signPracticeGraph$lambda$13$lambda$4$lambda$1$lambda$0(navHostController);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Function0 function1 = (Function0) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 1712096422, "CC(remember):SignPracticeNavigation.kt#9igjgp");
        boolean zChangedInstance2 = composer.changedInstance(navHostController);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
            objRememberedValue2 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.navigation.SignPracticeNavigationKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj) {
                    return SignPracticeNavigationKt.signPracticeGraph$lambda$13$lambda$4$lambda$3$lambda$2(navHostController, ((Long) obj).longValue());
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        SignPracticeListScreenKt.SignPracticeListScreen(null, null, function0, function1, (Function1) objRememberedValue2, composer, 0, 3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit signPracticeGraph$lambda$13$lambda$4$lambda$1$lambda$0(NavHostController navHostController) {
        NavController.navigate$default((NavController) navHostController, SignPracticeRoute.SignPracticeCreationScreen.INSTANCE, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit signPracticeGraph$lambda$13$lambda$4$lambda$3$lambda$2(NavHostController navHostController, long j) {
        NavController.navigate$default((NavController) navHostController, new SignPracticeRoute.SignPracticeSessionScreen(j), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit signPracticeGraph$lambda$13$lambda$9(final NavHostController navHostController, AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animatedContentScope, "$this$composable");
        Intrinsics.checkNotNullParameter(navBackStackEntry, "it");
        ComposerKt.sourceInformation(composer, "C30@1625L68,33@1743L116,29@1566L307:SignPracticeNavigation.kt#h89gs2");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1639601640, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.navigation.signPracticeGraph.<anonymous>.<anonymous> (SignPracticeNavigation.kt:29)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -595819188, "CC(remember):SignPracticeNavigation.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(navHostController);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.navigation.SignPracticeNavigationKt$$ExternalSyntheticLambda3
                public final Object invoke() {
                    return SignPracticeNavigationKt.signPracticeGraph$lambda$13$lambda$9$lambda$6$lambda$5(navHostController);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Function0 function0 = (Function0) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -595815364, "CC(remember):SignPracticeNavigation.kt#9igjgp");
        boolean zChangedInstance2 = composer.changedInstance(navHostController);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
            objRememberedValue2 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.navigation.SignPracticeNavigationKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj) {
                    return SignPracticeNavigationKt.signPracticeGraph$lambda$13$lambda$9$lambda$8$lambda$7(navHostController, ((Long) obj).longValue());
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        SignPracticeCreationScreenKt.SignPracticeCreationScreen(null, null, function0, (Function1) objRememberedValue2, composer, 0, 3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit signPracticeGraph$lambda$13$lambda$9$lambda$6$lambda$5(NavHostController navHostController) {
        navHostController.popBackStack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit signPracticeGraph$lambda$13$lambda$9$lambda$8$lambda$7(NavHostController navHostController, long j) {
        NavController.navigate$default((NavController) navHostController, new SignPracticeRoute.SignPracticeSessionScreen(j), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit signPracticeGraph$lambda$13$lambda$12(WebViewManager webViewManager, final NavHostController navHostController, AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animatedContentScope, "$this$composable");
        Intrinsics.checkNotNullParameter(navBackStackEntry, "it");
        ComposerKt.sourceInformation(composer, "C41@2069L68,39@1962L189:SignPracticeNavigation.kt#h89gs2");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-399861847, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.navigation.signPracticeGraph.<anonymous>.<anonymous> (SignPracticeNavigation.kt:39)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -2015141683, "CC(remember):SignPracticeNavigation.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(navHostController);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.navigation.SignPracticeNavigationKt$$ExternalSyntheticLambda8
                public final Object invoke() {
                    return SignPracticeNavigationKt.signPracticeGraph$lambda$13$lambda$12$lambda$11$lambda$10(navHostController);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        SignPracticeSessionScreenKt.SignPracticeSessionScreen(null, null, webViewManager, (Function0) objRememberedValue, composer, 0, 3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit signPracticeGraph$lambda$13$lambda$12$lambda$11$lambda$10(NavHostController navHostController) {
        navHostController.popBackStack();
        return Unit.INSTANCE;
    }
}
