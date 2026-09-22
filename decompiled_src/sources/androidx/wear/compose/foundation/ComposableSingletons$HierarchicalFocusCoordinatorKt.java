package androidx.wear.compose.foundation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: HierarchicalFocusCoordinator.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public final class ComposableSingletons$HierarchicalFocusCoordinatorKt {
    public static final ComposableSingletons$HierarchicalFocusCoordinatorKt INSTANCE = new ComposableSingletons$HierarchicalFocusCoordinatorKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f0lambda1 = ComposableLambdaKt.composableLambdaInstance(1686524019, false, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.foundation.ComposableSingletons$HierarchicalFocusCoordinatorKt$lambda-1$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C:HierarchicalFocusCoordinator.kt#m5emhl");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1686524019, i, -1, "androidx.wear.compose.foundation.ComposableSingletons$HierarchicalFocusCoordinatorKt.lambda-1.<anonymous> (HierarchicalFocusCoordinator.kt:82)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$compose_foundation_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m247getLambda1$compose_foundation_release() {
        return f0lambda1;
    }
}
