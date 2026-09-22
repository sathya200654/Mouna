package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.components;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.window.DialogProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DisclaimerDialog.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a3\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"DisclaimerDialog", "", "modifier", "Landroidx/compose/ui/Modifier;", "onDismissRequest", "Lkotlin/Function0;", "onOkClick", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DisclaimerDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DisclaimerDialog$lambda$1(Modifier modifier, Function0 function0, Function0 function1, int i, int i2, Composer composer, int i3) {
        DisclaimerDialog(modifier, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void DisclaimerDialog(Modifier modifier, final Function0<Unit> function0, final Function0<Unit> function1, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Composer composer2;
        final Modifier modifier3;
        Intrinsics.checkNotNullParameter(function0, "onDismissRequest");
        Intrinsics.checkNotNullParameter(function1, "onOkClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-655273719);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DisclaimerDialog)39@1376L135,21@781L736:DisclaimerDialog.kt#bv2vsw");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            Modifier modifier4 = i4 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-655273719, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.components.DisclaimerDialog (DisclaimerDialog.kt:20)");
            }
            composer2 = composerStartRestartGroup;
            AndroidAlertDialog_androidKt.AlertDialog-Oix01E0(function0, ComposableLambdaKt.rememberComposableLambda(-602008239, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.components.DisclaimerDialogKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    return DisclaimerDialogKt.DisclaimerDialog$lambda$0(function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), modifier4, (Function2) null, (Function2) null, ComposableSingletons$DisclaimerDialogKt.INSTANCE.getLambda$1203832917$app_release(), ComposableSingletons$DisclaimerDialogKt.INSTANCE.m1372getLambda$492190442$app_release(), (Shape) null, 0L, 0L, 0L, 0L, 0.0f, (DialogProperties) null, composer2, ((i3 >> 3) & 14) | 1769520 | ((i3 << 6) & 896), 0, 16280);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.components.DisclaimerDialogKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    return DisclaimerDialogKt.DisclaimerDialog$lambda$1(modifier3, function0, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DisclaimerDialog$lambda$0(Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C40@1390L111:DisclaimerDialog.kt#bv2vsw");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-602008239, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.components.DisclaimerDialog.<anonymous> (DisclaimerDialog.kt:40)");
            }
            ButtonKt.TextButton(function0, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$DisclaimerDialogKt.INSTANCE.m1373getLambda$724757874$app_release(), composer, 805306368, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
