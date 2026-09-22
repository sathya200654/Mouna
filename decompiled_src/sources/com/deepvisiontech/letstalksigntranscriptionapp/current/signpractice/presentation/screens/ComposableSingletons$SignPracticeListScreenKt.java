package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens;

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

/* JADX INFO: compiled from: SignPracticeListScreen.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$SignPracticeListScreenKt {
    public static final ComposableSingletons$SignPracticeListScreenKt INSTANCE = new ComposableSingletons$SignPracticeListScreenKt();
    private static Function2<Composer, Integer, Unit> lambda$585790184 = ComposableLambdaKt.composableLambdaInstance(585790184, false, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.ComposableSingletons$SignPracticeListScreenKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SignPracticeListScreenKt.lambda_585790184$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$585790184$app_release() {
        return lambda$585790184;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_585790184$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C102@4731L53,100@4645L157:SignPracticeListScreen.kt#1lejub");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(585790184, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.ComposableSingletons$SignPracticeListScreenKt.lambda$585790184.<anonymous> (SignPracticeListScreen.kt:100)");
            }
            IconKt.Icon-ww6aTOc(AddKt.getAdd(Icons.INSTANCE.getDefault()), StringResources_androidKt.stringResource(R.string.sign_practice_list_cd_create, composer, 0), (Modifier) null, 0L, composer, 0, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
