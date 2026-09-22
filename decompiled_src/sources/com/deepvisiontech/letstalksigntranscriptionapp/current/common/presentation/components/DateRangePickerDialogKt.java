package com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.DatePickerColors;
import androidx.compose.material3.DatePickerDialog_androidKt;
import androidx.compose.material3.DatePickerFormatter;
import androidx.compose.material3.DateRangePickerKt;
import androidx.compose.material3.DateRangePickerState;
import androidx.compose.material3.SelectableDates;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.DialogProperties;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.DateFilterRange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: DateRangePickerDialog.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aH\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0007¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"DateRangePickerDialog", "", "modifier", "Landroidx/compose/ui/Modifier;", "onDateRangeSelected", "Lkotlin/Function1;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/DateFilterRange;", "Lkotlin/ParameterName;", "name", "range", "onDismiss", "Lkotlin/Function0;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DateRangePickerDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateRangePickerDialog$lambda$5(Modifier modifier, Function1 function1, Function0 function0, int i, int i2, Composer composer, int i3) {
        DateRangePickerDialog(modifier, function1, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void DateRangePickerDialog(Modifier modifier, final Function1<? super DateFilterRange, Unit> function1, final Function0<Unit> function0, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Intrinsics.checkNotNullParameter(function1, "onDateRangeSelected");
        Intrinsics.checkNotNullParameter(function0, "onDismiss");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2103454885);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DateRangePickerDialog)25@1108L30,30@1253L508,45@1787L140,50@1934L408,27@1144L1198:DateRangePickerDialog.kt#rnaxq5");
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
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        int i5 = i3;
        if (!composerStartRestartGroup.shouldExecute((i5 & 147) != 146, i5 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            Modifier modifier3 = i4 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2103454885, i5, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.DateRangePickerDialog (DateRangePickerDialog.kt:24)");
            }
            final DateRangePickerState dateRangePickerState = DateRangePickerKt.rememberDateRangePickerState-IlFM19s((Long) null, (Long) null, (Long) null, (IntRange) null, 0, (SelectableDates) null, composerStartRestartGroup, 0, 63);
            modifier2 = modifier3;
            DatePickerDialog_androidKt.DatePickerDialog-GmEhDVc(function0, ComposableLambdaKt.rememberComposableLambda(-1680145527, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.DateRangePickerDialogKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    return DateRangePickerDialogKt.DateRangePickerDialog$lambda$2(function1, dateRangePickerState, function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), modifier2, ComposableLambdaKt.rememberComposableLambda(1746894407, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.DateRangePickerDialogKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    return DateRangePickerDialogKt.DateRangePickerDialog$lambda$3(function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), (Shape) null, 0.0f, (DatePickerColors) null, (DialogProperties) null, ComposableLambdaKt.rememberComposableLambda(1030715282, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.DateRangePickerDialogKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DateRangePickerDialogKt.DateRangePickerDialog$lambda$4(dateRangePickerState, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i5 >> 6) & 14) | 100666416 | ((i5 << 6) & 896), 240);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier4 = modifier2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.DateRangePickerDialogKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    return DateRangePickerDialogKt.DateRangePickerDialog$lambda$5(modifier4, function1, function0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateRangePickerDialog$lambda$2(final Function1 function1, final DateRangePickerState dateRangePickerState, final Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C32@1305L348,31@1267L484:DateRangePickerDialog.kt#rnaxq5");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1680145527, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.DateRangePickerDialog.<anonymous> (DateRangePickerDialog.kt:31)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 287853861, "CC(remember):DateRangePickerDialog.kt#9igjgp");
            boolean zChanged = composer.changed(function1) | composer.changed(dateRangePickerState) | composer.changed(function0);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.DateRangePickerDialogKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        return DateRangePickerDialogKt.DateRangePickerDialog$lambda$2$lambda$1$lambda$0(function1, dateRangePickerState, function0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ButtonKt.TextButton((Function0) objRememberedValue, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$DateRangePickerDialogKt.INSTANCE.getLambda$1479051244$app_release(), composer, 805306368, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateRangePickerDialog$lambda$2$lambda$1$lambda$0(Function1 function1, DateRangePickerState dateRangePickerState, Function0 function0) {
        function1.invoke(new DateFilterRange(dateRangePickerState.getSelectedStartDateMillis(), dateRangePickerState.getSelectedEndDateMillis()));
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateRangePickerDialog$lambda$3(Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C46@1801L116:DateRangePickerDialog.kt#rnaxq5");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1746894407, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.DateRangePickerDialog.<anonymous> (DateRangePickerDialog.kt:46)");
            }
            ButtonKt.TextButton(function0, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$DateRangePickerDialogKt.INSTANCE.getLambda$611123882$app_release(), composer, 805306368, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateRangePickerDialog$lambda$4(DateRangePickerState dateRangePickerState, ColumnScope columnScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(columnScope, "$this$DatePickerDialog");
        ComposerKt.sourceInformation(composer, "C51@1944L392:DateRangePickerDialog.kt#rnaxq5");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1030715282, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.DateRangePickerDialog.<anonymous> (DateRangePickerDialog.kt:51)");
            }
            DateRangePickerKt.DateRangePicker(dateRangePickerState, PaddingKt.padding-3ABfNKs(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(500)), Dp.constructor-impl(16)), (DatePickerFormatter) null, (DatePickerColors) null, ComposableSingletons$DateRangePickerDialogKt.INSTANCE.m1415getLambda$1781850652$app_release(), (Function2) null, false, (FocusRequester) null, composer, 1597488, 172);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
