package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversationsettings;

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

/* JADX INFO: compiled from: InterpretationSpeedSelectionDialog.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$InterpretationSpeedSelectionDialogKt {
    public static final ComposableSingletons$InterpretationSpeedSelectionDialogKt INSTANCE = new ComposableSingletons$InterpretationSpeedSelectionDialogKt();
    private static Function3<RowScope, Composer, Integer, Unit> lambda$757245111 = ComposableLambdaKt.composableLambdaInstance(757245111, false, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversationsettings.ComposableSingletons$InterpretationSpeedSelectionDialogKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$InterpretationSpeedSelectionDialogKt.lambda_757245111$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$757245111$app_release() {
        return lambda$757245111;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_757245111$lambda$0(RowScope rowScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(rowScope, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C110@4792L45,110@4787L51:InterpretationSpeedSelectionDialog.kt#k61bfg");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(757245111, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversationsettings.ComposableSingletons$InterpretationSpeedSelectionDialogKt.lambda$757245111.<anonymous> (InterpretationSpeedSelectionDialog.kt:110)");
            }
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.global_action_cancel, composer, 0), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
