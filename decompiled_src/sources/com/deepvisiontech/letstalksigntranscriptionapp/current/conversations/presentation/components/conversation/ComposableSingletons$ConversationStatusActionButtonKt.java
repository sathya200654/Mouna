package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.SignLanguageKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ConversationStatusActionButton.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$ConversationStatusActionButtonKt {
    public static final ComposableSingletons$ConversationStatusActionButtonKt INSTANCE = new ComposableSingletons$ConversationStatusActionButtonKt();
    private static Function2<Composer, Integer, Unit> lambda$2062386585 = ComposableLambdaKt.composableLambdaInstance(2062386585, false, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ComposableSingletons$ConversationStatusActionButtonKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ConversationStatusActionButtonKt.lambda_2062386585$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$2062386585$app_release() {
        return lambda$2062386585;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_2062386585$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C66@2749L61,64@2667L308:ConversationStatusActionButton.kt#hsonup");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2062386585, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.ComposableSingletons$ConversationStatusActionButtonKt.lambda$2062386585.<anonymous> (ConversationStatusActionButton.kt:64)");
            }
            IconKt.Icon-ww6aTOc(SignLanguageKt.getSignLanguage(Icons.INSTANCE.getDefault()), StringResources_androidKt.stringResource(R.string.conversation_action_button_cd_status, composer, 0), SizeKt.size-3ABfNKs(GraphicsLayerModifierKt.graphicsLayer-_6ThJ44$default(Modifier.Companion, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, (Shape) null, false, (RenderEffect) null, 0L, 0L, 0, 0, (ColorFilter) null, 524286, (Object) null), Dp.constructor-impl(20)), 0L, composer, 0, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
