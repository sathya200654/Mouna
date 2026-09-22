package com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.navigation;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavGraphBuilderKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.screen.EnvironmentSoundHistoryScreenKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: EnvironmentSoundNavigation.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004¨\u0006\u0005"}, d2 = {"environmentSoundGraph", "", "Landroidx/navigation/NavGraphBuilder;", "onDrawerClick", "Lkotlin/Function0;", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class EnvironmentSoundNavigationKt {
    public static final void environmentSoundGraph(NavGraphBuilder navGraphBuilder, final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(function0, "onDrawerClick");
        EnvironmentSoundRoute.EnvironmentSoundHistoryScreen environmentSoundHistoryScreen = EnvironmentSoundRoute.EnvironmentSoundHistoryScreen.INSTANCE;
        Function1 function1 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.navigation.EnvironmentSoundNavigationKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return EnvironmentSoundNavigationKt.environmentSoundGraph$lambda$1(function0, (NavGraphBuilder) obj);
            }
        };
        NavGraphBuilderKt.navigation(navGraphBuilder, Reflection.getOrCreateKotlinClass(EnvironmentSoundGraph.class), environmentSoundHistoryScreen, MapsKt.emptyMap(), function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit environmentSoundGraph$lambda$1(final Function0 function0, NavGraphBuilder navGraphBuilder) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "$this$navigation");
        Function4 function4ComposableLambdaInstance = ComposableLambdaKt.composableLambdaInstance(1919946727, true, new Function4() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.navigation.EnvironmentSoundNavigationKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return EnvironmentSoundNavigationKt.environmentSoundGraph$lambda$1$lambda$0(function0, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        androidx.navigation.compose.NavGraphBuilderKt.composable(navGraphBuilder, Reflection.getOrCreateKotlinClass(EnvironmentSoundRoute.EnvironmentSoundHistoryScreen.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, function4ComposableLambdaInstance);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit environmentSoundGraph$lambda$1$lambda$0(Function0 function0, AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animatedContentScope, "$this$composable");
        Intrinsics.checkNotNullParameter(navBackStackEntry, "$unused$var$");
        ComposerKt.sourceInformation(composer, "C12@658L90:EnvironmentSoundNavigation.kt#ts4p0z");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1919946727, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.navigation.environmentSoundGraph.<anonymous>.<anonymous> (EnvironmentSoundNavigation.kt:12)");
        }
        EnvironmentSoundHistoryScreenKt.EnvironmentSoundHistoryScreen(function0, null, composer, 0, 2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}
