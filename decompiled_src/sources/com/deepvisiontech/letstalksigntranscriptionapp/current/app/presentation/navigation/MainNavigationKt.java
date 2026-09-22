package com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.navigation;

import androidx.navigation.NavController;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavGraphBuilderKt;
import androidx.navigation.NavHostController;
import com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.navigation.graphs.MainGraph;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.navigation.ConversationGraph;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.navigation.ConversationNavigationKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.navigation.EnvironmentSoundNavigationKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.WebViewManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.navigation.NotificationNavigationKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.navigation.SignPracticeNavigationKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: MainNavigation.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b¨\u0006\t"}, d2 = {"mainGraph", "", "Landroidx/navigation/NavGraphBuilder;", "navController", "Landroidx/navigation/NavHostController;", "webViewManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/manager/WebViewManager;", "onDrawerClick", "Lkotlin/Function0;", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class MainNavigationKt {
    public static final void mainGraph(NavGraphBuilder navGraphBuilder, final NavHostController navHostController, final WebViewManager webViewManager, final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(navHostController, "navController");
        Intrinsics.checkNotNullParameter(webViewManager, "webViewManager");
        Intrinsics.checkNotNullParameter(function0, "onDrawerClick");
        ConversationGraph conversationGraph = ConversationGraph.INSTANCE;
        Function1 function1 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.navigation.MainNavigationKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return MainNavigationKt.mainGraph$lambda$0(navHostController, webViewManager, function0, (NavGraphBuilder) obj);
            }
        };
        NavGraphBuilderKt.navigation(navGraphBuilder, Reflection.getOrCreateKotlinClass(MainGraph.class), conversationGraph, MapsKt.emptyMap(), function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mainGraph$lambda$0(NavHostController navHostController, WebViewManager webViewManager, Function0 function0, NavGraphBuilder navGraphBuilder) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "$this$navigation");
        ConversationNavigationKt.conversationGraph(navGraphBuilder, (NavController) navHostController, webViewManager, function0);
        NotificationNavigationKt.notificationGraph(navGraphBuilder, navHostController, function0);
        SignPracticeNavigationKt.signPracticeGraph(navGraphBuilder, navHostController, webViewManager, function0);
        EnvironmentSoundNavigationKt.environmentSoundGraph(navGraphBuilder, function0);
        return Unit.INSTANCE;
    }
}
