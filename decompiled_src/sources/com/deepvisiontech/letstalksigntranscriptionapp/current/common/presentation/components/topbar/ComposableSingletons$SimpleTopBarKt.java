package com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.filled.ArrowBackKt;
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

/* JADX INFO: compiled from: SimpleTopBar.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$SimpleTopBarKt {
    public static final ComposableSingletons$SimpleTopBarKt INSTANCE = new ComposableSingletons$SimpleTopBarKt();

    /* JADX INFO: renamed from: lambda$-1096704661, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f21lambda$1096704661 = ComposableLambdaKt.composableLambdaInstance(-1096704661, false, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ComposableSingletons$SimpleTopBarKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SimpleTopBarKt.lambda__1096704661$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1096704661$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1440getLambda$1096704661$app_release() {
        return f21lambda$1096704661;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1096704661$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C38@1292L48,36@1188L170:SimpleTopBar.kt#u4jokp");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1096704661, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.ComposableSingletons$SimpleTopBarKt.lambda$-1096704661.<anonymous> (SimpleTopBar.kt:36)");
            }
            IconKt.Icon-ww6aTOc(ArrowBackKt.getArrowBack(Icons.AutoMirrored.Filled.INSTANCE), StringResources_androidKt.stringResource(R.string.global_cd_navigate_back, composer, 0), (Modifier) null, 0L, composer, 0, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
