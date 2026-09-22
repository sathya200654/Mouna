package com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.components.appscreen;

import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.filled.LogoutKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: DrawerContent.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$DrawerContentKt {
    public static final ComposableSingletons$DrawerContentKt INSTANCE = new ComposableSingletons$DrawerContentKt();

    /* JADX INFO: renamed from: lambda$-1145551095, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f4lambda$1145551095 = ComposableLambdaKt.composableLambdaInstance(-1145551095, false, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.components.appscreen.ComposableSingletons$DrawerContentKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DrawerContentKt.lambda__1145551095$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1999851533 = ComposableLambdaKt.composableLambdaInstance(1999851533, false, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.components.appscreen.ComposableSingletons$DrawerContentKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DrawerContentKt.lambda_1999851533$lambda$1((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1145551095$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1335getLambda$1145551095$app_release() {
        return f4lambda$1145551095;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1999851533$app_release() {
        return lambda$1999851533;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1145551095$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C126@5905L50,127@6003L10,125@5868L179:DrawerContent.kt#q85fds");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1145551095, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.components.appscreen.ComposableSingletons$DrawerContentKt.lambda$-1145551095.<anonymous> (DrawerContent.kt:125)");
            }
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.auth_drawer_action_logout, composer, 0), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleMedium(), composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1999851533$lambda$1(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C130@6092L44:DrawerContent.kt#q85fds");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1999851533, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.components.appscreen.ComposableSingletons$DrawerContentKt.lambda$1999851533.<anonymous> (DrawerContent.kt:130)");
            }
            IconKt.Icon-ww6aTOc(LogoutKt.getLogout(Icons.AutoMirrored.Filled.INSTANCE), (String) null, (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
