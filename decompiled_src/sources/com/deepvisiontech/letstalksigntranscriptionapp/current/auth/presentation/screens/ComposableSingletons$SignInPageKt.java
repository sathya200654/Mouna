package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarColors;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.TextUnitKt;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: SignInPage.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$SignInPageKt {
    public static final ComposableSingletons$SignInPageKt INSTANCE = new ComposableSingletons$SignInPageKt();
    private static Function2<Composer, Integer, Unit> lambda$204651875 = ComposableLambdaKt.composableLambdaInstance(204651875, false, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens.ComposableSingletons$SignInPageKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SignInPageKt.lambda_204651875$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-130017922, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f9lambda$130017922 = ComposableLambdaKt.composableLambdaInstance(-130017922, false, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens.ComposableSingletons$SignInPageKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SignInPageKt.lambda__130017922$lambda$1((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-130017922$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1382getLambda$130017922$app_release() {
        return f9lambda$130017922;
    }

    public final Function2<Composer, Integer, Unit> getLambda$204651875$app_release() {
        return lambda$204651875;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__130017922$lambda$1(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C92@3859L388:SignInPage.kt#qjj2jn");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-130017922, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens.ComposableSingletons$SignInPageKt.lambda$-130017922.<anonymous> (SignInPage.kt:92)");
            }
            AppBarKt.CenterAlignedTopAppBar-GHTll3U(lambda$204651875, (Modifier) null, (Function2) null, (Function3) null, 0.0f, (WindowInsets) null, (TopAppBarColors) null, (TopAppBarScrollBehavior) null, composer, 6, 254);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_204651875$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C95@3966L54,98@4164L11,94@3929L286:SignInPage.kt#qjj2jn");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(204651875, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.screens.ComposableSingletons$SignInPageKt.lambda$204651875.<anonymous> (SignInPage.kt:94)");
            }
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.auth_credentials_title_screen, composer, 0), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getTertiaryContainer-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(32), (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 1597440, 0, 262058);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
