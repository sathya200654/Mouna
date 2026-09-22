package com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.navigation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.navigation.NavController;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptionsBuilder;
import androidx.navigation.PopUpToBuilder;
import androidx.navigation.compose.NavHostKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.navigation.graphs.MainGraph;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.navigation.AuthGraph;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.navigation.AuthNavigationKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.WebViewManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.feature.network.presentation.navigation.NetworkUnavailableGraph;
import com.deepvisiontech.letstalksigntranscriptionapp.current.feature.network.presentation.navigation.NetworkUnavailableNavigationKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.navigation.NotificationRoute;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.navigation.PersonaSurveyGraph;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.navigation.PersonaSurveyNavigationKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: AppNavHost.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"AppNavHost", "", "navController", "Landroidx/navigation/NavHostController;", "webViewManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/manager/WebViewManager;", "onDrawerClick", "Lkotlin/Function0;", "(Landroidx/navigation/NavHostController;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/manager/WebViewManager;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AppNavHostKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppNavHost$lambda$17(NavHostController navHostController, WebViewManager webViewManager, Function0 function0, int i, Composer composer, int i2) {
        AppNavHost(navHostController, webViewManager, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void AppNavHost(final NavHostController navHostController, final WebViewManager webViewManager, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(navHostController, "navController");
        Intrinsics.checkNotNullParameter(webViewManager, "webViewManager");
        Intrinsics.checkNotNullParameter(function0, "onDrawerClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(863829572);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AppNavHost)P(!1,2)27@1626L1427,24@1535L1518:AppNavHost.kt#xd0xfl");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(navHostController) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? composerStartRestartGroup.changed(webViewManager) : composerStartRestartGroup.changedInstance(webViewManager) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(863829572, i2, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.navigation.AppNavHost (AppNavHost.kt:23)");
            }
            AuthGraph authGraph = AuthGraph.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1211539383, "CC(remember):AppNavHost.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(navHostController) | ((i2 & 112) == 32 || ((i2 & 64) != 0 && composerStartRestartGroup.changedInstance(webViewManager))) | ((i2 & 896) == 256);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.navigation.AppNavHostKt$$ExternalSyntheticLambda10
                    public final Object invoke(Object obj) {
                        return AppNavHostKt.AppNavHost$lambda$16$lambda$15(navHostController, webViewManager, function0, (NavGraphBuilder) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            NavHostKt.NavHost(navHostController, authGraph, (Modifier) null, (Alignment) null, (KClass) null, (Map) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) objRememberedValue, composerStartRestartGroup, (i2 & 14) | 48, 0, 2044);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.navigation.AppNavHostKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2) {
                    return AppNavHostKt.AppNavHost$lambda$17(navHostController, webViewManager, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppNavHost$lambda$16$lambda$15(final NavHostController navHostController, WebViewManager webViewManager, Function0 function0, NavGraphBuilder navGraphBuilder) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "$this$NavHost");
        AuthNavigationKt.authGraph(navGraphBuilder, (NavController) navHostController, new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.navigation.AppNavHostKt$$ExternalSyntheticLambda15
            public final Object invoke() {
                return AppNavHostKt.AppNavHost$lambda$16$lambda$15$lambda$2(navHostController);
            }
        }, new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.navigation.AppNavHostKt$$ExternalSyntheticLambda16
            public final Object invoke() {
                return AppNavHostKt.AppNavHost$lambda$16$lambda$15$lambda$5(navHostController);
            }
        }, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.navigation.AppNavHostKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return AppNavHostKt.AppNavHost$lambda$16$lambda$15$lambda$8(navHostController, (String) obj);
            }
        });
        PersonaSurveyNavigationKt.personaSurveyGraph(navGraphBuilder, new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.navigation.AppNavHostKt$$ExternalSyntheticLambda2
            public final Object invoke() {
                return AppNavHostKt.AppNavHost$lambda$16$lambda$15$lambda$11(navHostController);
            }
        });
        MainNavigationKt.mainGraph(navGraphBuilder, navHostController, webViewManager, function0);
        NetworkUnavailableNavigationKt.networkUnavailableGraph(navGraphBuilder, new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.navigation.AppNavHostKt$$ExternalSyntheticLambda3
            public final Object invoke() {
                return AppNavHostKt.AppNavHost$lambda$16$lambda$15$lambda$14(navHostController);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppNavHost$lambda$16$lambda$15$lambda$2(NavHostController navHostController) {
        navHostController.navigate(PersonaSurveyGraph.INSTANCE, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.navigation.AppNavHostKt$$ExternalSyntheticLambda9
            public final Object invoke(Object obj) {
                return AppNavHostKt.AppNavHost$lambda$16$lambda$15$lambda$2$lambda$1((NavOptionsBuilder) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppNavHost$lambda$16$lambda$15$lambda$2$lambda$1(NavOptionsBuilder navOptionsBuilder) {
        Intrinsics.checkNotNullParameter(navOptionsBuilder, "$this$navigate");
        navOptionsBuilder.popUpTo(AuthGraph.INSTANCE, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.navigation.AppNavHostKt$$ExternalSyntheticLambda12
            public final Object invoke(Object obj) {
                return AppNavHostKt.AppNavHost$lambda$16$lambda$15$lambda$2$lambda$1$lambda$0((PopUpToBuilder) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppNavHost$lambda$16$lambda$15$lambda$2$lambda$1$lambda$0(PopUpToBuilder popUpToBuilder) {
        Intrinsics.checkNotNullParameter(popUpToBuilder, "$this$popUpTo");
        popUpToBuilder.setInclusive(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppNavHost$lambda$16$lambda$15$lambda$5(NavHostController navHostController) {
        navHostController.navigate(MainGraph.INSTANCE, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.navigation.AppNavHostKt$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                return AppNavHostKt.AppNavHost$lambda$16$lambda$15$lambda$5$lambda$4((NavOptionsBuilder) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppNavHost$lambda$16$lambda$15$lambda$5$lambda$4(NavOptionsBuilder navOptionsBuilder) {
        Intrinsics.checkNotNullParameter(navOptionsBuilder, "$this$navigate");
        navOptionsBuilder.popUpTo(0, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.navigation.AppNavHostKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return AppNavHostKt.AppNavHost$lambda$16$lambda$15$lambda$5$lambda$4$lambda$3((PopUpToBuilder) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppNavHost$lambda$16$lambda$15$lambda$5$lambda$4$lambda$3(PopUpToBuilder popUpToBuilder) {
        Intrinsics.checkNotNullParameter(popUpToBuilder, "$this$popUpTo");
        popUpToBuilder.setInclusive(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppNavHost$lambda$16$lambda$15$lambda$8(NavHostController navHostController, String str) {
        Intrinsics.checkNotNullParameter(str, "notificationId");
        navHostController.navigate(new NotificationRoute.NotificationScreen(str), new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.navigation.AppNavHostKt$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                return AppNavHostKt.AppNavHost$lambda$16$lambda$15$lambda$8$lambda$7((NavOptionsBuilder) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppNavHost$lambda$16$lambda$15$lambda$8$lambda$7(NavOptionsBuilder navOptionsBuilder) {
        Intrinsics.checkNotNullParameter(navOptionsBuilder, "$this$navigate");
        navOptionsBuilder.popUpTo(0, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.navigation.AppNavHostKt$$ExternalSyntheticLambda14
            public final Object invoke(Object obj) {
                return AppNavHostKt.AppNavHost$lambda$16$lambda$15$lambda$8$lambda$7$lambda$6((PopUpToBuilder) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppNavHost$lambda$16$lambda$15$lambda$8$lambda$7$lambda$6(PopUpToBuilder popUpToBuilder) {
        Intrinsics.checkNotNullParameter(popUpToBuilder, "$this$popUpTo");
        popUpToBuilder.setInclusive(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppNavHost$lambda$16$lambda$15$lambda$11(NavHostController navHostController) {
        navHostController.navigate(MainGraph.INSTANCE, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.navigation.AppNavHostKt$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                return AppNavHostKt.AppNavHost$lambda$16$lambda$15$lambda$11$lambda$10((NavOptionsBuilder) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppNavHost$lambda$16$lambda$15$lambda$11$lambda$10(NavOptionsBuilder navOptionsBuilder) {
        Intrinsics.checkNotNullParameter(navOptionsBuilder, "$this$navigate");
        navOptionsBuilder.popUpTo(0, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.navigation.AppNavHostKt$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                return AppNavHostKt.AppNavHost$lambda$16$lambda$15$lambda$11$lambda$10$lambda$9((PopUpToBuilder) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppNavHost$lambda$16$lambda$15$lambda$11$lambda$10$lambda$9(PopUpToBuilder popUpToBuilder) {
        Intrinsics.checkNotNullParameter(popUpToBuilder, "$this$popUpTo");
        popUpToBuilder.setInclusive(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppNavHost$lambda$16$lambda$15$lambda$14(NavHostController navHostController) {
        navHostController.navigate(AuthGraph.INSTANCE, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.navigation.AppNavHostKt$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                return AppNavHostKt.AppNavHost$lambda$16$lambda$15$lambda$14$lambda$13((NavOptionsBuilder) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppNavHost$lambda$16$lambda$15$lambda$14$lambda$13(NavOptionsBuilder navOptionsBuilder) {
        Intrinsics.checkNotNullParameter(navOptionsBuilder, "$this$navigate");
        navOptionsBuilder.popUpTo(NetworkUnavailableGraph.INSTANCE, new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.navigation.AppNavHostKt$$ExternalSyntheticLambda13
            public final Object invoke(Object obj) {
                return AppNavHostKt.AppNavHost$lambda$16$lambda$15$lambda$14$lambda$13$lambda$12((PopUpToBuilder) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppNavHost$lambda$16$lambda$15$lambda$14$lambda$13$lambda$12(PopUpToBuilder popUpToBuilder) {
        Intrinsics.checkNotNullParameter(popUpToBuilder, "$this$popUpTo");
        popUpToBuilder.setInclusive(true);
        return Unit.INSTANCE;
    }
}
