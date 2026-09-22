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

/* JADX INFO: compiled from: RoleSelectionPage.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$RoleSelectionPageKt {
    public static final ComposableSingletons$RoleSelectionPageKt INSTANCE = new ComposableSingletons$RoleSelectionPageKt();

    /* JADX INFO: renamed from: lambda$-272844658, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f44lambda$272844658 = ComposableLambdaKt.composableLambdaInstance(-272844658, false, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.ComposableSingletons$RoleSelectionPageKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$RoleSelectionPageKt.lambda__272844658$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-272844658$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1781getLambda$272844658$app_release() {
        return f44lambda$272844658;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__272844658$lambda$0(RowScope rowScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(rowScope, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C98@4029L45,99@4118L10,97@3996L214:RoleSelectionPage.kt#j5zu2x");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-272844658, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.screens.ComposableSingletons$RoleSelectionPageKt.lambda$-272844658.<anonymous> (RoleSelectionPage.kt:97)");
            }
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.global_action_submit, composer, 0), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getHeadlineSmall(), composer, 0, 0, 130046);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
