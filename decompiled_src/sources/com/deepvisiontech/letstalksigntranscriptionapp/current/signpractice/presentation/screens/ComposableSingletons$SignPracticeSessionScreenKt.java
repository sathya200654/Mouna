package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.StopKt;
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
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: SignPracticeSessionScreen.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$SignPracticeSessionScreenKt {
    public static final ComposableSingletons$SignPracticeSessionScreenKt INSTANCE = new ComposableSingletons$SignPracticeSessionScreenKt();

    /* JADX INFO: renamed from: lambda$-1900353119, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f45lambda$1900353119 = ComposableLambdaKt.composableLambdaInstance(-1900353119, false, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.ComposableSingletons$SignPracticeSessionScreenKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SignPracticeSessionScreenKt.lambda__1900353119$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1900353119$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1808getLambda$1900353119$app_release() {
        return f45lambda$1900353119;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1900353119$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C124@5839L121,122@5714L357:SignPracticeSessionScreen.kt#1lejub");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1900353119, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.ComposableSingletons$SignPracticeSessionScreenKt.lambda$-1900353119.<anonymous> (SignPracticeSessionScreen.kt:122)");
            }
            IconKt.Icon-ww6aTOc(StopKt.getStop(Icons.INSTANCE.getDefault()), StringResources_androidKt.stringResource(R.string.sign_practice_icon_cd_stop, composer, 0), GraphicsLayerModifierKt.graphicsLayer-_6ThJ44$default(Modifier.Companion, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, (Shape) null, false, (RenderEffect) null, 0L, 0L, 0, 0, (ColorFilter) null, 524286, (Object) null), 0L, composer, 0, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
