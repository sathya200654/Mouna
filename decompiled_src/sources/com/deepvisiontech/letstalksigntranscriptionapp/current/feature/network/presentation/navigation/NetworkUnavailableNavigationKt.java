package com.deepvisiontech.letstalksigntranscriptionapp.current.feature.network.presentation.navigation;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavGraphBuilderKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.feature.network.presentation.screens.NetworkUnavailableScreenKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: NetworkUnavailableNavigation.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004¨\u0006\u0005"}, d2 = {"networkUnavailableGraph", "", "Landroidx/navigation/NavGraphBuilder;", "onNavigateToAuthGraph", "Lkotlin/Function0;", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class NetworkUnavailableNavigationKt {
    public static final void networkUnavailableGraph(NavGraphBuilder navGraphBuilder, final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(function0, "onNavigateToAuthGraph");
        NetworkUnavailableRoute.NetworkUnavailableScreenRoute networkUnavailableScreenRoute = NetworkUnavailableRoute.NetworkUnavailableScreenRoute.INSTANCE;
        Function1 function1 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.feature.network.presentation.navigation.NetworkUnavailableNavigationKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return NetworkUnavailableNavigationKt.networkUnavailableGraph$lambda$1(function0, (NavGraphBuilder) obj);
            }
        };
        NavGraphBuilderKt.navigation(navGraphBuilder, Reflection.getOrCreateKotlinClass(NetworkUnavailableGraph.class), networkUnavailableScreenRoute, MapsKt.emptyMap(), function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit networkUnavailableGraph$lambda$1(final Function0 function0, NavGraphBuilder navGraphBuilder) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "$this$navigation");
        Function4 function4ComposableLambdaInstance = ComposableLambdaKt.composableLambdaInstance(-510294566, true, new Function4() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.feature.network.presentation.navigation.NetworkUnavailableNavigationKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return NetworkUnavailableNavigationKt.networkUnavailableGraph$lambda$1$lambda$0(function0, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        androidx.navigation.compose.NavGraphBuilderKt.composable(navGraphBuilder, Reflection.getOrCreateKotlinClass(NetworkUnavailableRoute.NetworkUnavailableScreenRoute.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, function4ComposableLambdaInstance);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit networkUnavailableGraph$lambda$1$lambda$0(Function0 function0, AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animatedContentScope, "$this$composable");
        Intrinsics.checkNotNullParameter(navBackStackEntry, "it");
        ComposerKt.sourceInformation(composer, "C12@649L101:NetworkUnavailableNavigation.kt#uj70oc");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-510294566, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.feature.network.presentation.navigation.networkUnavailableGraph.<anonymous>.<anonymous> (NetworkUnavailableNavigation.kt:12)");
        }
        NetworkUnavailableScreenKt.NetworkUnavailableScreen(null, null, function0, composer, 0, 3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}
