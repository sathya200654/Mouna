package com.vivekgupta.composecoachmark.coachmark;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CombinedRevealAndCoachStyle.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public final class ComposableSingletons$CombinedRevealAndCoachStyleKt {
    public static final ComposableSingletons$CombinedRevealAndCoachStyleKt INSTANCE = new ComposableSingletons$CombinedRevealAndCoachStyleKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f53lambda1 = ComposableLambdaKt.composableLambdaInstance(-1408879947, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.ComposableSingletons$CombinedRevealAndCoachStyleKt$lambda-1$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope rowScope, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(rowScope, "$this$Button");
            if ((i & 81) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1408879947, i, -1, "com.vivekgupta.composecoachmark.coachmark.ComposableSingletons$CombinedRevealAndCoachStyleKt.lambda-1.<anonymous> (CombinedRevealAndCoachStyle.kt:54)");
            }
            TextKt.Text-fLXpl1I("Skip", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 65534);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-2, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f54lambda2 = ComposableLambdaKt.composableLambdaInstance(2003332908, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.ComposableSingletons$CombinedRevealAndCoachStyleKt$lambda-2$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope rowScope, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(rowScope, "$this$Button");
            if ((i & 81) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2003332908, i, -1, "com.vivekgupta.composecoachmark.coachmark.ComposableSingletons$CombinedRevealAndCoachStyleKt.lambda-2.<anonymous> (CombinedRevealAndCoachStyle.kt:59)");
            }
            TextKt.Text-fLXpl1I("Next", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, (Function1) null, (TextStyle) null, composer, 6, 0, 65534);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$composecoachmark_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m2252getLambda1$composecoachmark_release() {
        return f53lambda1;
    }

    /* JADX INFO: renamed from: getLambda-2$composecoachmark_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m2253getLambda2$composecoachmark_release() {
        return f54lambda2;
    }
}
