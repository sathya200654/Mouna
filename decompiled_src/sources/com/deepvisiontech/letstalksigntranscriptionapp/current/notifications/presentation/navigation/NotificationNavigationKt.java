package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.navigation;

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
import androidx.navigation.NavOptionsBuilder;
import androidx.navigation.Navigator;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationScreenKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationsListScreenKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: NotificationNavigation.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006¨\u0006\u0007"}, d2 = {"notificationGraph", "", "Landroidx/navigation/NavGraphBuilder;", "navController", "Landroidx/navigation/NavHostController;", "onDrawerClick", "Lkotlin/Function0;", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class NotificationNavigationKt {
    public static final void notificationGraph(NavGraphBuilder navGraphBuilder, final NavHostController navHostController, final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(navHostController, "navController");
        Intrinsics.checkNotNullParameter(function0, "onDrawerClick");
        NotificationRoute.NotificationListScreen notificationListScreen = NotificationRoute.NotificationListScreen.INSTANCE;
        Function1 function1 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.navigation.NotificationNavigationKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return NotificationNavigationKt.notificationGraph$lambda$7(function0, navHostController, (NavGraphBuilder) obj);
            }
        };
        NavGraphBuilderKt.navigation(navGraphBuilder, Reflection.getOrCreateKotlinClass(NotificationGraph.class), notificationListScreen, MapsKt.emptyMap(), function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit notificationGraph$lambda$7(final Function0 function0, final NavHostController navHostController, NavGraphBuilder navGraphBuilder) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "$this$navigation");
        Function4 function4ComposableLambdaInstance = ComposableLambdaKt.composableLambdaInstance(163010353, true, new Function4() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.navigation.NotificationNavigationKt$$ExternalSyntheticLambda3
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return NotificationNavigationKt.notificationGraph$lambda$7$lambda$2(function0, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        androidx.navigation.compose.NavGraphBuilderKt.composable(navGraphBuilder, Reflection.getOrCreateKotlinClass(NotificationRoute.NotificationListScreen.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, function4ComposableLambdaInstance);
        Function4 function4ComposableLambdaInstance2 = ComposableLambdaKt.composableLambdaInstance(2143076712, true, new Function4() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.navigation.NotificationNavigationKt$$ExternalSyntheticLambda4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return NotificationNavigationKt.notificationGraph$lambda$7$lambda$6(navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        androidx.navigation.compose.NavGraphBuilderKt.composable(navGraphBuilder, Reflection.getOrCreateKotlinClass(NotificationRoute.NotificationScreen.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, function4ComposableLambdaInstance2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit notificationGraph$lambda$7$lambda$2(Function0 function0, final NavHostController navHostController, AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animatedContentScope, "$this$composable");
        Intrinsics.checkNotNullParameter(navBackStackEntry, "it");
        ComposerKt.sourceInformation(composer, "C17@909L156,15@797L282:NotificationNavigation.kt#y6j2ii");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(163010353, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.navigation.notificationGraph.<anonymous>.<anonymous> (NotificationNavigation.kt:15)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2034130765, "CC(remember):NotificationNavigation.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(navHostController);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.navigation.NotificationNavigationKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    return NotificationNavigationKt.notificationGraph$lambda$7$lambda$2$lambda$1$lambda$0(navHostController, (String) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        NotificationsListScreenKt.NotificationListScreen(null, null, function0, (Function1) objRememberedValue, composer, 0, 3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit notificationGraph$lambda$7$lambda$2$lambda$1$lambda$0(NavHostController navHostController, String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        NavController.navigate$default((NavController) navHostController, new NotificationRoute.NotificationScreen(str), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit notificationGraph$lambda$7$lambda$6(final NavHostController navHostController, AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animatedContentScope, "$this$composable");
        Intrinsics.checkNotNullParameter(navBackStackEntry, "it");
        ComposerKt.sourceInformation(composer, "C27@1215L306,26@1162L373:NotificationNavigation.kt#y6j2ii");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2143076712, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.navigation.notificationGraph.<anonymous>.<anonymous> (NotificationNavigation.kt:26)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -2087579398, "CC(remember):NotificationNavigation.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(navHostController);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.navigation.NotificationNavigationKt$$ExternalSyntheticLambda2
                public final Object invoke() {
                    return NotificationNavigationKt.notificationGraph$lambda$7$lambda$6$lambda$5$lambda$4(navHostController);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        NotificationScreenKt.NotificationScreen(null, null, (Function0) objRememberedValue, composer, 0, 3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit notificationGraph$lambda$7$lambda$6$lambda$5$lambda$4(NavHostController navHostController) {
        if (!navHostController.popBackStack()) {
            navHostController.navigate(NotificationRoute.NotificationListScreen.INSTANCE, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.navigation.NotificationNavigationKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj) {
                    return NotificationNavigationKt.notificationGraph$lambda$7$lambda$6$lambda$5$lambda$4$lambda$3((NavOptionsBuilder) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit notificationGraph$lambda$7$lambda$6$lambda$5$lambda$4$lambda$3(NavOptionsBuilder navOptionsBuilder) {
        Intrinsics.checkNotNullParameter(navOptionsBuilder, "$this$navigate");
        navOptionsBuilder.setLaunchSingleTop(true);
        return Unit.INSTANCE;
    }
}
