package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SignCreationSectionTitle.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"SignCreationSectionTitle", "", "title", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SignCreationSectionTitleKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignCreationSectionTitle$lambda$0(String str, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SignCreationSectionTitle(str, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004a  */
    /* JADX WARN: Code duplicated, block: B:24:0x004c  */
    /* JADX WARN: Code duplicated, block: B:27:0x0055 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x0057  */
    /* JADX WARN: Code duplicated, block: B:29:0x005c  */
    /* JADX WARN: Code duplicated, block: B:32:0x0063  */
    /* JADX WARN: Code duplicated, block: B:35:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:40:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:42:? A[RETURN, SYNTHETIC] */
    public static final void SignCreationSectionTitle(final String str, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        boolean z;
        Composer composer2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(str, "title");
        Composer composerStartRestartGroup = composer.startRestartGroup(-499840859);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SignCreationSectionTitle)P(1)13@531L10,11@473L167:SignCreationSectionTitle.kt#1r82af");
        if ((i & 6) == 0) {
            i3 = i | (composerStartRestartGroup.changed(str) ? 4 : 2);
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i3 & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
            } else {
                if (i4 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-499840859, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.SignCreationSectionTitle (SignCreationSectionTitle.kt:10)");
                }
                composer2 = composerStartRestartGroup;
                Modifier modifier4 = modifier3;
                TextKt.Text-Nvy7gAk(str, SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getStart-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleMedium(), composer2, i3 & 14, 0, 130044);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.SignCreationSectionTitleKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj, Object obj2) {
                        return SignCreationSectionTitleKt.SignCreationSectionTitle$lambda$0(str, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i3 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-499840859, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.SignCreationSectionTitle (SignCreationSectionTitle.kt:10)");
            }
            composer2 = composerStartRestartGroup;
            Modifier modifier5 = modifier3;
            TextKt.Text-Nvy7gAk(str, SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getStart-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleMedium(), composer2, i3 & 14, 0, 130044);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier5;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.screens.components.SignCreationSectionTitleKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    return SignCreationSectionTitleKt.SignCreationSectionTitle$lambda$0(str, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
