package com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.screen;

import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.MenuKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
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
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: EnvironmentSoundHistoryScreen.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$EnvironmentSoundHistoryScreenKt {
    public static final ComposableSingletons$EnvironmentSoundHistoryScreenKt INSTANCE = new ComposableSingletons$EnvironmentSoundHistoryScreenKt();

    /* JADX INFO: renamed from: lambda$-2020703989, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f40lambda$2020703989 = ComposableLambdaKt.composableLambdaInstance(-2020703989, false, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.screen.ComposableSingletons$EnvironmentSoundHistoryScreenKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$EnvironmentSoundHistoryScreenKt.lambda__2020703989$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-161520533, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f39lambda$161520533 = ComposableLambdaKt.composableLambdaInstance(-161520533, false, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.screen.ComposableSingletons$EnvironmentSoundHistoryScreenKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$EnvironmentSoundHistoryScreenKt.lambda__161520533$lambda$1((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-161520533$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1680getLambda$161520533$app_release() {
        return f39lambda$161520533;
    }

    /* JADX INFO: renamed from: getLambda$-2020703989$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1681getLambda$2020703989$app_release() {
        return f40lambda$2020703989;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__2020703989$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C62@2962L40,62@2957L46:EnvironmentSoundHistoryScreen.kt#rau839");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2020703989, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.screen.ComposableSingletons$EnvironmentSoundHistoryScreenKt.lambda$-2020703989.<anonymous> (EnvironmentSoundHistoryScreen.kt:62)");
            }
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.env_sound_title, composer, 0), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__161520533$lambda$1(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C65@3170L39,65@3124L86:EnvironmentSoundHistoryScreen.kt#rau839");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-161520533, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.presentation.screen.ComposableSingletons$EnvironmentSoundHistoryScreenKt.lambda$-161520533.<anonymous> (EnvironmentSoundHistoryScreen.kt:65)");
            }
            IconKt.Icon-ww6aTOc(MenuKt.getMenu(Icons.INSTANCE.getDefault()), StringResources_androidKt.stringResource(R.string.global_cd_menu, composer, 0), (Modifier) null, 0L, composer, 0, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
