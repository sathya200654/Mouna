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

/* JADX INFO: compiled from: VoiceSelectionDialogBox.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$VoiceSelectionDialogBoxKt {
    public static final ComposableSingletons$VoiceSelectionDialogBoxKt INSTANCE = new ComposableSingletons$VoiceSelectionDialogBoxKt();
    private static Function3<RowScope, Composer, Integer, Unit> lambda$1631426777 = ComposableLambdaKt.composableLambdaInstance(1631426777, false, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversationsettings.ComposableSingletons$VoiceSelectionDialogBoxKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$VoiceSelectionDialogBoxKt.lambda_1631426777$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$1489355472 = ComposableLambdaKt.composableLambdaInstance(1489355472, false, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversationsettings.ComposableSingletons$VoiceSelectionDialogBoxKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$VoiceSelectionDialogBoxKt.lambda_1489355472$lambda$1((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$1489355472$app_release() {
        return lambda$1489355472;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$1631426777$app_release() {
        return lambda$1631426777;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1631426777$lambda$0(RowScope rowScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(rowScope, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C138@5808L45,138@5803L51:VoiceSelectionDialogBox.kt#k61bfg");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1631426777, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversationsettings.ComposableSingletons$VoiceSelectionDialogBoxKt.lambda$1631426777.<anonymous> (VoiceSelectionDialogBox.kt:138)");
            }
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.global_action_cancel, composer, 0), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1489355472$lambda$1(RowScope rowScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(rowScope, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C150@6283L43,150@6278L49:VoiceSelectionDialogBox.kt#k61bfg");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1489355472, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversationsettings.ComposableSingletons$VoiceSelectionDialogBoxKt.lambda$1489355472.<anonymous> (VoiceSelectionDialogBox.kt:150)");
            }
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.global_action_save, composer, 0), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
