package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversationlist;

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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CreateNewConversationDialog.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$CreateNewConversationDialogKt {
    public static final ComposableSingletons$CreateNewConversationDialogKt INSTANCE = new ComposableSingletons$CreateNewConversationDialogKt();

    /* JADX INFO: renamed from: lambda$-1011275621, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f37lambda$1011275621 = ComposableLambdaKt.composableLambdaInstance(-1011275621, false, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversationlist.ComposableSingletons$CreateNewConversationDialogKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$CreateNewConversationDialogKt.lambda__1011275621$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$764929076 = ComposableLambdaKt.composableLambdaInstance(764929076, false, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversationlist.ComposableSingletons$CreateNewConversationDialogKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$CreateNewConversationDialogKt.lambda_764929076$lambda$1((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1011275621$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1609getLambda$1011275621$app_release() {
        return f37lambda$1011275621;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$764929076$app_release() {
        return lambda$764929076;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1011275621$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C75@3095L55,75@3090L61:CreateNewConversationDialog.kt#q5ez8f");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1011275621, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversationlist.ComposableSingletons$CreateNewConversationDialogKt.lambda$-1011275621.<anonymous> (CreateNewConversationDialog.kt:75)");
            }
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.conversation_dialog_name_label, composer, 0), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_764929076$lambda$1(RowScope rowScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(rowScope, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C89@3745L45,89@3740L51:CreateNewConversationDialog.kt#q5ez8f");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(764929076, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversationlist.ComposableSingletons$CreateNewConversationDialogKt.lambda$764929076.<anonymous> (CreateNewConversationDialog.kt:89)");
            }
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.global_action_cancel, composer, 0), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
