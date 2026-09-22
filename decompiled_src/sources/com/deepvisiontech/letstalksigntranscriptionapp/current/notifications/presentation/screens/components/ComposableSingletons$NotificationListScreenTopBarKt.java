package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.components;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.MenuKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: NotificationListScreenTopBar.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$NotificationListScreenTopBarKt {
    public static final ComposableSingletons$NotificationListScreenTopBarKt INSTANCE = new ComposableSingletons$NotificationListScreenTopBarKt();

    /* JADX INFO: renamed from: lambda$-2107071679, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f41lambda$2107071679 = ComposableLambdaKt.composableLambdaInstance(-2107071679, false, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.components.ComposableSingletons$NotificationListScreenTopBarKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NotificationListScreenTopBarKt.lambda__2107071679$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-2107071679$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1765getLambda$2107071679$app_release() {
        return f41lambda$2107071679;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__2107071679$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C35@1119L130:NotificationListScreenTopBar.kt#sbahtd");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2107071679, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.components.ComposableSingletons$NotificationListScreenTopBarKt.lambda$-2107071679.<anonymous> (NotificationListScreenTopBar.kt:35)");
            }
            IconKt.Icon-ww6aTOc(MenuKt.getMenu(Icons.INSTANCE.getDefault()), "Open Menu", (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
