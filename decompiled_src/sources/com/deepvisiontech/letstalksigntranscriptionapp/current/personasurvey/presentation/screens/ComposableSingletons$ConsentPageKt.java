package com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.text.TextAutoSize;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConsentPage.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$ConsentPageKt {
    public static final ComposableSingletons$ConsentPageKt INSTANCE = new ComposableSingletons$ConsentPageKt();

    /* JADX INFO: renamed from: lambda$-2028257321, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f43lambda$2028257321 = ComposableLambdaKt.composableLambdaInstance(-2028257321, false, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.ComposableSingletons$ConsentPageKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$ConsentPageKt.lambda__2028257321$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1236165491, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f42lambda$1236165491 = ComposableLambdaKt.composableLambdaInstance(-1236165491, false, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.ComposableSingletons$ConsentPageKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$ConsentPageKt.lambda__1236165491$lambda$1((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1236165491$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1779getLambda$1236165491$app_release() {
        return f42lambda$1236165491;
    }

    /* JADX INFO: renamed from: getLambda$-2028257321$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1780getLambda$2028257321$app_release() {
        return f43lambda$2028257321;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__2028257321$lambda$0(RowScope rowScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(rowScope, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C76@3101L46,78@3249L10,75@3064L232:ConsentPage.kt#j5zu2x");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2028257321, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.ComposableSingletons$ConsentPageKt.lambda$-2028257321.<anonymous> (ConsentPage.kt:75)");
            }
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.global_action_proceed, composer, 0), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getHeadlineLarge(), composer, 0, 0, 130046);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1236165491$lambda$1(RowScope rowScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(rowScope, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C100@4075L43,102@4212L10,99@4042L212:ConsentPage.kt#j5zu2x");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1236165491, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.ComposableSingletons$ConsentPageKt.lambda$-1236165491.<anonymous> (ConsentPage.kt:99)");
            }
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.global_action_skip, composer, 0), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getHeadlineSmall(), composer, 0, 0, 130046);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
