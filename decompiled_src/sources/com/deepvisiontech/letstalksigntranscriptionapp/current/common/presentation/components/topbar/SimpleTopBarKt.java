package com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarColors;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SimpleTopBar.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"SimpleTopBar", "", "modifier", "Landroidx/compose/ui/Modifier;", "title", "", "navigateBack", "Lkotlin/Function0;", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SimpleTopBarKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SimpleTopBar$lambda$4(Modifier modifier, String str, Function0 function0, int i, int i2, Composer composer, int i3) {
        SimpleTopBar(modifier, str, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void SimpleTopBar(Modifier modifier, final String str, final Function0<Unit> function0, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        final Modifier modifier3;
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(function0, "navigateBack");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1652189177);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SimpleTopBar)P(!1,2)24@891L131,30@1049L333,22@835L553:SimpleTopBar.kt#u4jokp");
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
            i3 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            Modifier modifier4 = i4 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1652189177, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.SimpleTopBar (SimpleTopBar.kt:21)");
            }
            int i5 = ((i3 << 3) & 112) | 390;
            Modifier modifier5 = modifier4;
            AppBarKt.TopAppBar-GHTll3U(ComposableLambdaKt.rememberComposableLambda(408503499, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.SimpleTopBarKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    return SimpleTopBarKt.SimpleTopBar$lambda$0(str, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), modifier5, ComposableLambdaKt.rememberComposableLambda(1566035789, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.SimpleTopBarKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    return SimpleTopBarKt.SimpleTopBar$lambda$3(function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), (Function3) null, 0.0f, (WindowInsets) null, (TopAppBarColors) null, (TopAppBarScrollBehavior) null, composerStartRestartGroup, i5, 248);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.SimpleTopBarKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    return SimpleTopBarKt.SimpleTopBar$lambda$4(modifier3, str, function0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SimpleTopBar$lambda$0(String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C27@979L11,25@905L107:SimpleTopBar.kt#u4jokp");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(408503499, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.SimpleTopBar.<anonymous> (SimpleTopBar.kt:25)");
            }
            TextKt.Text-Nvy7gAk(str, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262138);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SimpleTopBar$lambda$3(final Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C32@1101L54,31@1063L309:SimpleTopBar.kt#u4jokp");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1566035789, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.SimpleTopBar.<anonymous> (SimpleTopBar.kt:31)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1721841347, "CC(remember):SimpleTopBar.kt#9igjgp");
            boolean zChanged = composer.changed(function0);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.topbar.SimpleTopBarKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        return SimpleTopBarKt.SimpleTopBar$lambda$3$lambda$2$lambda$1(function0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.IconButton((Function0) objRememberedValue, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableSingletons$SimpleTopBarKt.INSTANCE.m1440getLambda$1096704661$app_release(), composer, 1572864, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SimpleTopBar$lambda$3$lambda$2$lambda$1(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }
}
