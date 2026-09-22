package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.text.TextAutoSize;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LanguageSelectionDialogBox.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$LanguageSelectionDialogBoxKt {
    public static final ComposableSingletons$LanguageSelectionDialogBoxKt INSTANCE = new ComposableSingletons$LanguageSelectionDialogBoxKt();
    private static Function3<RowScope, Composer, Integer, Unit> lambda$1581863946 = ComposableLambdaKt.composableLambdaInstance(1581863946, false, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.ComposableSingletons$LanguageSelectionDialogBoxKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$LanguageSelectionDialogBoxKt.lambda_1581863946$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$1581863946$app_release() {
        return lambda$1581863946;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1581863946$lambda$0(RowScope rowScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(rowScope, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C121@5088L45,121@5083L51:LanguageSelectionDialogBox.kt#ur4zcg");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1581863946, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.ComposableSingletons$LanguageSelectionDialogBoxKt.lambda$1581863946.<anonymous> (LanguageSelectionDialogBox.kt:121)");
            }
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.global_action_cancel, composer, 0), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
