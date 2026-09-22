package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SignCreationBottomBar.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"SignCreationBottomBar", "", "modifier", "Landroidx/compose/ui/Modifier;", "onGenerateClick", "Lkotlin/Function0;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SignCreationBottomBarKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignCreationBottomBar$lambda$3(Modifier modifier, Function0 function0, int i, int i2, Composer composer, int i3) {
        SignCreationBottomBar(modifier, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void SignCreationBottomBar(Modifier modifier, final Function0<Unit> function0, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        final Modifier modifier3;
        Intrinsics.checkNotNullParameter(function0, "onGenerateClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(614177940);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SignCreationBottomBar)22@823L609,20@775L657:SignCreationBottomBar.kt#1r82af");
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
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            modifier3 = i4 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(614177940, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.SignCreationBottomBar (SignCreationBottomBar.kt:19)");
            }
            AppBarKt.BottomAppBar-1oL4kX8(modifier3, 0L, 0L, 0.0f, (PaddingValues) null, (WindowInsets) null, ComposableLambdaKt.rememberComposableLambda(1392321948, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.SignCreationBottomBarKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SignCreationBottomBarKt.SignCreationBottomBar$lambda$2(function0, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | 1572864, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.SignCreationBottomBarKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    return SignCreationBottomBarKt.SignCreationBottomBar$lambda$3(modifier3, function0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignCreationBottomBar$lambda$2(final Function0 function0, RowScope rowScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(rowScope, "$this$BottomAppBar");
        ComposerKt.sourceInformation(composer, "C31@1111L11,32@1186L11,30@1050L180,27@963L49,23@833L593:SignCreationBottomBar.kt#1r82af");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1392321948, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.SignCreationBottomBar.<anonymous> (SignCreationBottomBar.kt:23)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), 0.0f, 1, (Object) null);
            ButtonColors buttonColors = ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimaryContainer-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnPrimaryContainer-0d7_KjU(), 0L, 0L, composer, ButtonDefaults.$stable << 12, 12);
            ComposerKt.sourceInformationMarkerStart(composer, -2008399795, "CC(remember):SignCreationBottomBar.kt#9igjgp");
            boolean zChanged = composer.changed(function0);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.SignCreationBottomBarKt$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        return SignCreationBottomBarKt.SignCreationBottomBar$lambda$2$lambda$1$lambda$0(function0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ButtonKt.TextButton((Function0) objRememberedValue, modifierFillMaxWidth$default, false, (Shape) null, buttonColors, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$SignCreationBottomBarKt.INSTANCE.getLambda$1946869913$app_release(), composer, 805306416, 492);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignCreationBottomBar$lambda$2$lambda$1$lambda$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }
}
