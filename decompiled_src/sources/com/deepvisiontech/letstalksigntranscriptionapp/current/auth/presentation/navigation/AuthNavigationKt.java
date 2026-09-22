package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.navigation;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavGraphBuilderKt;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens.SetupScreenKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens.SignInPageKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens.SplashScreenKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: AuthNavigation.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aQ\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\t¨\u0006\u000e"}, d2 = {"authGraph", "", "Landroidx/navigation/NavGraphBuilder;", "navController", "Landroidx/navigation/NavController;", "navigateToOnBoardingGraph", "Lkotlin/Function0;", "navigateToFeatureGraph", "navigateToNotification", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "notificationId", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AuthNavigationKt {
    public static final void authGraph(NavGraphBuilder navGraphBuilder, final NavController navController, final Function0<Unit> function0, final Function0<Unit> function1, final Function1<? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(function0, "navigateToOnBoardingGraph");
        Intrinsics.checkNotNullParameter(function1, "navigateToFeatureGraph");
        Intrinsics.checkNotNullParameter(function2, "navigateToNotification");
        AuthRoute.SplashScreen splashScreen = AuthRoute.SplashScreen.INSTANCE;
        Function1 function3 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.navigation.AuthNavigationKt$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return AuthNavigationKt.authGraph$lambda$9(navController, function0, function1, function2, (NavGraphBuilder) obj);
            }
        };
        NavGraphBuilderKt.navigation(navGraphBuilder, Reflection.getOrCreateKotlinClass(AuthGraph.class), splashScreen, MapsKt.emptyMap(), function3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit authGraph$lambda$9(final NavController navController, final Function0 function0, final Function0 function1, final Function1 function2, NavGraphBuilder navGraphBuilder) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "$this$navigation");
        Function4 function4ComposableLambdaInstance = ComposableLambdaKt.composableLambdaInstance(-101553914, true, new Function4() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.navigation.AuthNavigationKt$$ExternalSyntheticLambda4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return AuthNavigationKt.authGraph$lambda$9$lambda$4(navController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        androidx.navigation.compose.NavGraphBuilderKt.composable(navGraphBuilder, Reflection.getOrCreateKotlinClass(AuthRoute.SplashScreen.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, function4ComposableLambdaInstance);
        Function4 function4ComposableLambdaInstance2 = ComposableLambdaKt.composableLambdaInstance(-321039121, true, new Function4() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.navigation.AuthNavigationKt$$ExternalSyntheticLambda5
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return AuthNavigationKt.authGraph$lambda$9$lambda$7(navController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        androidx.navigation.compose.NavGraphBuilderKt.composable(navGraphBuilder, Reflection.getOrCreateKotlinClass(AuthRoute.SignInScreen.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, function4ComposableLambdaInstance2);
        Function4 function4ComposableLambdaInstance3 = ComposableLambdaKt.composableLambdaInstance(-457066418, true, new Function4() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.navigation.AuthNavigationKt$$ExternalSyntheticLambda6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return AuthNavigationKt.authGraph$lambda$9$lambda$8(function0, function1, function2, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        androidx.navigation.compose.NavGraphBuilderKt.composable(navGraphBuilder, Reflection.getOrCreateKotlinClass(AuthRoute.SetupScreen.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, function4ComposableLambdaInstance3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit authGraph$lambda$9$lambda$4(final NavController navController, AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animatedContentScope, "$this$composable");
        Intrinsics.checkNotNullParameter(navBackStackEntry, "it");
        ComposerKt.sourceInformation(composer, "C19@971L85,22@1099L86,18@917L282:AuthNavigation.kt#qcauta");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-101553914, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.navigation.authGraph.<anonymous>.<anonymous> (AuthNavigation.kt:18)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1190938715, "CC(remember):AuthNavigation.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(navController);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.navigation.AuthNavigationKt$$ExternalSyntheticLambda1
                public final Object invoke() {
                    return AuthNavigationKt.authGraph$lambda$9$lambda$4$lambda$1$lambda$0(navController);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Function0 function0 = (Function0) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 1190942812, "CC(remember):AuthNavigation.kt#9igjgp");
        boolean zChangedInstance2 = composer.changedInstance(navController);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
            objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.navigation.AuthNavigationKt$$ExternalSyntheticLambda2
                public final Object invoke() {
                    return AuthNavigationKt.authGraph$lambda$9$lambda$4$lambda$3$lambda$2(navController);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        SplashScreenKt.SplashScreen(null, function0, (Function0) objRememberedValue2, null, composer, 0, 9);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit authGraph$lambda$9$lambda$4$lambda$1$lambda$0(NavController navController) {
        NavController.navigate$default(navController, AuthRoute.SetupScreen.INSTANCE, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit authGraph$lambda$9$lambda$4$lambda$3$lambda$2(NavController navController) {
        NavController.navigate$default(navController, AuthRoute.SignInScreen.INSTANCE, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit authGraph$lambda$9$lambda$7(final NavController navController, AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animatedContentScope, "$this$composable");
        Intrinsics.checkNotNullParameter(navBackStackEntry, "it");
        ComposerKt.sourceInformation(composer, "C30@1330L85,29@1268L161:AuthNavigation.kt#qcauta");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-321039121, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.navigation.authGraph.<anonymous>.<anonymous> (AuthNavigation.kt:29)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 719052548, "CC(remember):AuthNavigation.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(navController);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.navigation.AuthNavigationKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    return AuthNavigationKt.authGraph$lambda$9$lambda$7$lambda$6$lambda$5(navController);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        SignInPageKt.UserCredentialScreen(null, null, (Function0) objRememberedValue, composer, 0, 3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit authGraph$lambda$9$lambda$7$lambda$6$lambda$5(NavController navController) {
        NavController.navigate$default(navController, AuthRoute.SetupScreen.INSTANCE, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final Unit authGraph$lambda$9$lambda$8(Function0 function0, Function0 function1, Function1 function2, AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry, Composer composer, int i) throws NoWhenBranchMatchedException {
        Intrinsics.checkNotNullParameter(animatedContentScope, "$this$composable");
        Intrinsics.checkNotNullParameter(navBackStackEntry, "it");
        ComposerKt.sourceInformation(composer, "C37@1497L233:AuthNavigation.kt#qcauta");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-457066418, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.navigation.authGraph.<anonymous>.<anonymous> (AuthNavigation.kt:37)");
        }
        SetupScreenKt.SetupScreen(null, null, function0, function1, function2, composer, 0, 3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}
