package com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.MenuKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SimpleTopBarWithNavigationDrawer.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$SimpleTopBarWithNavigationDrawerKt {
    public static final ComposableSingletons$SimpleTopBarWithNavigationDrawerKt INSTANCE = new ComposableSingletons$SimpleTopBarWithNavigationDrawerKt();

    /* JADX INFO: renamed from: lambda$-494027573, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f23lambda$494027573 = ComposableLambdaKt.composableLambdaInstance(-494027573, false, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ComposableSingletons$SimpleTopBarWithNavigationDrawerKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SimpleTopBarWithNavigationDrawerKt.lambda__494027573$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-374556010, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f22lambda$374556010 = ComposableLambdaKt.composableLambdaInstance(-374556010, false, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ComposableSingletons$SimpleTopBarWithNavigationDrawerKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SimpleTopBarWithNavigationDrawerKt.lambda__374556010$lambda$1((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-374556010$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1441getLambda$374556010$app_release() {
        return f22lambda$374556010;
    }

    /* JADX INFO: renamed from: getLambda$-494027573$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1442getLambda$494027573$app_release() {
        return f23lambda$494027573;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__494027573$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C38@1313L39,36@1212L158:SimpleTopBarWithNavigationDrawer.kt#u4jokp");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-494027573, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ComposableSingletons$SimpleTopBarWithNavigationDrawerKt.lambda$-494027573.<anonymous> (SimpleTopBarWithNavigationDrawer.kt:36)");
            }
            IconKt.Icon-ww6aTOc(MenuKt.getMenu(Icons.INSTANCE.getDefault()), StringResources_androidKt.stringResource(R.string.global_cd_menu, composer, 0), (Modifier) null, 0L, composer, 0, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__374556010$lambda$1(RowScope rowScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(rowScope, "$this$TopAppBar");
        ComposerKt.sourceInformation(composer, "C:SimpleTopBarWithNavigationDrawer.kt#u4jokp");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-374556010, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ComposableSingletons$SimpleTopBarWithNavigationDrawerKt.lambda$-374556010.<anonymous> (SimpleTopBarWithNavigationDrawer.kt:42)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
