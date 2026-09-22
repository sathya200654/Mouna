package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.CircularProgressIndicatorComponentKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SplashScreen.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$SplashScreenKt {
    public static final ComposableSingletons$SplashScreenKt INSTANCE = new ComposableSingletons$SplashScreenKt();

    /* JADX INFO: renamed from: lambda$-1035923150, reason: not valid java name */
    private static Function3<PaddingValues, Composer, Integer, Unit> f10lambda$1035923150 = ComposableLambdaKt.composableLambdaInstance(-1035923150, false, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens.ComposableSingletons$SplashScreenKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SplashScreenKt.lambda__1035923150$lambda$0((PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1035923150$app_release, reason: not valid java name */
    public final Function3<PaddingValues, Composer, Integer, Unit> m1383getLambda$1035923150$app_release() {
        return f10lambda$1035923150;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1035923150$lambda$0(PaddingValues paddingValues, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer, "C50@1987L99:SplashScreen.kt#qjj2jn");
        if ((i & 6) == 0) {
            i |= composer.changed(paddingValues) ? 4 : 2;
        }
        if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1035923150, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens.ComposableSingletons$SplashScreenKt.lambda$-1035923150.<anonymous> (SplashScreen.kt:50)");
            }
            CircularProgressIndicatorComponentKt.CircularProgressComponent(PaddingKt.padding(Modifier.Companion, paddingValues), composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
