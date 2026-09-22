package androidx.wear.compose.material.dialog;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.wear.compose.material.VignetteKt;
import androidx.wear.compose.material.VignettePosition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: Dialog.android.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public final class ComposableSingletons$Dialog_androidKt {
    public static final ComposableSingletons$Dialog_androidKt INSTANCE = new ComposableSingletons$Dialog_androidKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function3<AnimatedVisibilityScope, Composer, Integer, Unit> f2lambda1 = ComposableLambdaKt.composableLambdaInstance(-587334602, false, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.dialog.ComposableSingletons$Dialog_androidKt$lambda-1$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((AnimatedVisibilityScope) obj, (Composer) obj2, ((Number) obj3).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C195@8447L58:Dialog.android.kt#iw0lpz");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-587334602, i, -1, "androidx.wear.compose.material.dialog.ComposableSingletons$Dialog_androidKt.lambda-1.<anonymous> (Dialog.android.kt:195)");
            }
            VignetteKt.m869VignetteVtdIJU(VignettePosition.Companion.m881getTopAndBottomGuQh5Jg(), null, composer, 6, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$compose_material_release, reason: not valid java name */
    public final Function3<AnimatedVisibilityScope, Composer, Integer, Unit> m882getLambda1$compose_material_release() {
        return f2lambda1;
    }
}
