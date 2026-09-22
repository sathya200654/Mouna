package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.AddKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ConversationListScreen.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$ConversationListScreenKt {
    public static final ComposableSingletons$ConversationListScreenKt INSTANCE = new ComposableSingletons$ConversationListScreenKt();

    /* JADX INFO: renamed from: lambda$-768339204, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f38lambda$768339204 = ComposableLambdaKt.composableLambdaInstance(-768339204, false, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ComposableSingletons$ConversationListScreenKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ConversationListScreenKt.lambda__768339204$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-768339204$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1627getLambda$768339204$app_release() {
        return f38lambda$768339204;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__768339204$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C107@5092L56,107@5069L80:ConversationListScreen.kt#6g1srx");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-768339204, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ComposableSingletons$ConversationListScreenKt.lambda$-768339204.<anonymous> (ConversationListScreen.kt:107)");
            }
            IconKt.Icon-ww6aTOc(AddKt.getAdd(Icons.INSTANCE.getDefault()), StringResources_androidKt.stringResource(R.string.conversation_list_cd_create_new, composer, 0), (Modifier) null, 0L, composer, 0, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
