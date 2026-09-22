package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.CloseKt;
import androidx.compose.material.icons.filled.MicKt;
import androidx.compose.material.icons.filled.ReplayKt;
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

/* JADX INFO: compiled from: TtsDrawer.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$TtsDrawerKt {
    public static final ComposableSingletons$TtsDrawerKt INSTANCE = new ComposableSingletons$TtsDrawerKt();

    /* JADX INFO: renamed from: lambda$-50124036, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f36lambda$50124036 = ComposableLambdaKt.composableLambdaInstance(-50124036, false, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ComposableSingletons$TtsDrawerKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$TtsDrawerKt.lambda__50124036$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1565165032, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f35lambda$1565165032 = ComposableLambdaKt.composableLambdaInstance(-1565165032, false, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ComposableSingletons$TtsDrawerKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$TtsDrawerKt.lambda__1565165032$lambda$1((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1983284267 = ComposableLambdaKt.composableLambdaInstance(1983284267, false, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ComposableSingletons$TtsDrawerKt$$ExternalSyntheticLambda2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$TtsDrawerKt.lambda_1983284267$lambda$2((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1565165032$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1551getLambda$1565165032$app_release() {
        return f35lambda$1565165032;
    }

    /* JADX INFO: renamed from: getLambda$-50124036$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1552getLambda$50124036$app_release() {
        return f36lambda$50124036;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1983284267$app_release() {
        return lambda$1983284267;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__50124036$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C200@9623L54,198@9499L208:TtsDrawer.kt#hsonup");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-50124036, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ComposableSingletons$TtsDrawerKt.lambda$-50124036.<anonymous> (TtsDrawer.kt:198)");
            }
            IconKt.Icon-ww6aTOc(MicKt.getMic(Icons.INSTANCE.getDefault()), StringResources_androidKt.stringResource(R.string.conversation_tts_cd_interpret, composer, 0), (Modifier) null, 0L, composer, 0, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1565165032$lambda$1(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C214@10359L51,212@10240L196:TtsDrawer.kt#hsonup");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1565165032, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ComposableSingletons$TtsDrawerKt.lambda$-1565165032.<anonymous> (TtsDrawer.kt:212)");
            }
            IconKt.Icon-ww6aTOc(ReplayKt.getReplay(Icons.INSTANCE.getDefault()), StringResources_androidKt.stringResource(R.string.conversation_tts_cd_replay, composer, 0), (Modifier) null, 0L, composer, 0, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1983284267$lambda$2(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C240@11470L40,238@11360L172:TtsDrawer.kt#hsonup");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1983284267, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ComposableSingletons$TtsDrawerKt.lambda$1983284267.<anonymous> (TtsDrawer.kt:238)");
            }
            IconKt.Icon-ww6aTOc(CloseKt.getClose(Icons.INSTANCE.getDefault()), StringResources_androidKt.stringResource(R.string.global_cd_close, composer, 0), (Modifier) null, 0L, composer, 0, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
