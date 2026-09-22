package com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components;

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

/* JADX INFO: compiled from: DateRangePickerDialog.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$DateRangePickerDialogKt {
    public static final ComposableSingletons$DateRangePickerDialogKt INSTANCE = new ComposableSingletons$DateRangePickerDialogKt();
    private static Function3<RowScope, Composer, Integer, Unit> lambda$1479051244 = ComposableLambdaKt.composableLambdaInstance(1479051244, false, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.ComposableSingletons$DateRangePickerDialogKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$DateRangePickerDialogKt.lambda_1479051244$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$611123882 = ComposableLambdaKt.composableLambdaInstance(611123882, false, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.ComposableSingletons$DateRangePickerDialogKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$DateRangePickerDialogKt.lambda_611123882$lambda$1((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1781850652, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f11lambda$1781850652 = ComposableLambdaKt.composableLambdaInstance(-1781850652, false, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.ComposableSingletons$DateRangePickerDialogKt$$ExternalSyntheticLambda2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DateRangePickerDialogKt.lambda__1781850652$lambda$2((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1781850652$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1415getLambda$1781850652$app_release() {
        return f11lambda$1781850652;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$1479051244$app_release() {
        return lambda$1479051244;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$611123882$app_release() {
        return lambda$611123882;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1479051244$lambda$0(RowScope rowScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(rowScope, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C42@1691L45,42@1686L51:DateRangePickerDialog.kt#rnaxq5");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1479051244, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.ComposableSingletons$DateRangePickerDialogKt.lambda$1479051244.<anonymous> (DateRangePickerDialog.kt:42)");
            }
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.global_action_accept, composer, 0), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_611123882$lambda$1(RowScope rowScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(rowScope, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C47@1856L46,47@1851L52:DateRangePickerDialog.kt#rnaxq5");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(611123882, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.ComposableSingletons$DateRangePickerDialogKt.lambda$611123882.<anonymous> (DateRangePickerDialog.kt:47)");
            }
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.global_action_dismiss, composer, 0), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1781850652$lambda$2(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C55@2074L55,54@2041L106:DateRangePickerDialog.kt#rnaxq5");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1781850652, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.ComposableSingletons$DateRangePickerDialogKt.lambda$-1781850652.<anonymous> (DateRangePickerDialog.kt:54)");
            }
            TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(R.string.global_picker_date_range_title, composer, 0), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
