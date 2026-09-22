package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.StopKt;
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

/* JADX INFO: compiled from: AnimatedStopButton.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$AnimatedStopButtonKt {
    public static final ComposableSingletons$AnimatedStopButtonKt INSTANCE = new ComposableSingletons$AnimatedStopButtonKt();

    /* JADX INFO: renamed from: lambda$-578058224, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f24lambda$578058224 = ComposableLambdaKt.composableLambdaInstance(-578058224, false, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ComposableSingletons$AnimatedStopButtonKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AnimatedStopButtonKt.lambda__578058224$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-578058224$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1533getLambda$578058224$app_release() {
        return f24lambda$578058224;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__578058224$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C61@2261L66,59@2168L224:AnimatedStopButton.kt#hsonup");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-578058224, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ComposableSingletons$AnimatedStopButtonKt.lambda$-578058224.<anonymous> (AnimatedStopButton.kt:59)");
            }
            IconKt.Icon-ww6aTOc(StopKt.getStop(Icons.INSTANCE.getDefault()), StringResources_androidKt.stringResource(R.string.conversation_button_cd_stop_transcription, composer, 0), SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), 0L, composer, 384, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
