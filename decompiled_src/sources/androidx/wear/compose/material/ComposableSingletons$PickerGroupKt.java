package androidx.wear.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: PickerGroup.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public final class ComposableSingletons$PickerGroupKt {
    public static final ComposableSingletons$PickerGroupKt INSTANCE = new ComposableSingletons$PickerGroupKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f1lambda1 = ComposableLambdaKt.composableLambdaInstance(27333683, false, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ComposableSingletons$PickerGroupKt$lambda-1$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C:PickerGroup.kt#gj9v0t");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(27333683, i, -1, "androidx.wear.compose.material.ComposableSingletons$PickerGroupKt.lambda-1.<anonymous> (PickerGroup.kt:121)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$compose_material_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m578getLambda1$compose_material_release() {
        return f1lambda1;
    }
}
