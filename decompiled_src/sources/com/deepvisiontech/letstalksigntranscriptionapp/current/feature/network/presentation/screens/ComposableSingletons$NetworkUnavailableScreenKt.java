package com.deepvisiontech.letstalksigntranscriptionapp.current.feature.network.presentation.screens;

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
import androidx.compose.ui.unit.TextUnitKt;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkUnavailableScreen.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$NetworkUnavailableScreenKt {
    public static final ComposableSingletons$NetworkUnavailableScreenKt INSTANCE = new ComposableSingletons$NetworkUnavailableScreenKt();
    private static Function2<Composer, Integer, Unit> lambda$1732889588 = ComposableLambdaKt.composableLambdaInstance(1732889588, false, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.feature.network.presentation.screens.ComposableSingletons$NetworkUnavailableScreenKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NetworkUnavailableScreenKt.lambda_1732889588$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$1290914287 = ComposableLambdaKt.composableLambdaInstance(1290914287, false, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.feature.network.presentation.screens.ComposableSingletons$NetworkUnavailableScreenKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$NetworkUnavailableScreenKt.lambda_1290914287$lambda$1((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$1290914287$app_release() {
        return lambda$1290914287;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1732889588$app_release() {
        return lambda$1732889588;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1732889588$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:NetworkUnavailableScreen.kt#nfxm87");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1732889588, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.feature.network.presentation.screens.ComposableSingletons$NetworkUnavailableScreenKt.lambda$1732889588.<anonymous> (NetworkUnavailableScreen.kt:57)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1290914287$lambda$1(RowScope rowScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(rowScope, "$this$Button");
        ComposerKt.sourceInformation(composer, "C90@3690L43,89@3657L182:NetworkUnavailableScreen.kt#nfxm87");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1290914287, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.feature.network.presentation.screens.ComposableSingletons$NetworkUnavailableScreenKt.lambda$1290914287.<anonymous> (NetworkUnavailableScreen.kt:89)");
            }
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.global_action_exit, composer, 0), (Modifier) null, 0L, (TextAutoSize) null, TextUnitKt.getSp(24), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 24576, 0, 261102);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
