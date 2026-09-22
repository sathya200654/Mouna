package com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
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

/* JADX INFO: compiled from: ShareAppDialog.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$ShareAppDialogKt {
    public static final ComposableSingletons$ShareAppDialogKt INSTANCE = new ComposableSingletons$ShareAppDialogKt();

    /* JADX INFO: renamed from: lambda$-1109064564, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f12lambda$1109064564 = ComposableLambdaKt.composableLambdaInstance(-1109064564, false, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.ComposableSingletons$ShareAppDialogKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$ShareAppDialogKt.lambda__1109064564$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-796476107, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f13lambda$796476107 = ComposableLambdaKt.composableLambdaInstance(-796476107, false, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.ComposableSingletons$ShareAppDialogKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$ShareAppDialogKt.lambda__796476107$lambda$1((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1109064564$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1416getLambda$1109064564$app_release() {
        return f12lambda$1109064564;
    }

    /* JADX INFO: renamed from: getLambda$-796476107$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1417getLambda$796476107$app_release() {
        return f13lambda$796476107;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1109064564$lambda$0(RowScope rowScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(rowScope, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C73@2833L45,74@2930L10,72@2792L185:ShareAppDialog.kt#rnaxq5");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1109064564, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.ComposableSingletons$ShareAppDialogKt.lambda$-1109064564.<anonymous> (ShareAppDialog.kt:72)");
            }
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.global_action_cancel, composer, 0), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelLarge(), composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__796476107$lambda$1(RowScope rowScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(rowScope, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C86@3320L44,87@3416L10,85@3279L184:ShareAppDialog.kt#rnaxq5");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-796476107, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.ComposableSingletons$ShareAppDialogKt.lambda$-796476107.<anonymous> (ShareAppDialog.kt:85)");
            }
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.global_action_share, composer, 0), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelLarge(), composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
