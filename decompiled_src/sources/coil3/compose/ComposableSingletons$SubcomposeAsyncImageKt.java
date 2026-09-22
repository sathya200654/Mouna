package coil3.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.google.firebase.perf.util.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: SubcomposeAsyncImage.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$SubcomposeAsyncImageKt {
    public static final ComposableSingletons$SubcomposeAsyncImageKt INSTANCE = new ComposableSingletons$SubcomposeAsyncImageKt();
    private static Function3<SubcomposeAsyncImageScope, Composer, Integer, Unit> lambda$1938077476 = ComposableLambdaKt.composableLambdaInstance(1938077476, false, new Function3() { // from class: coil3.compose.ComposableSingletons$SubcomposeAsyncImageKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SubcomposeAsyncImageKt.lambda_1938077476$lambda$0((SubcomposeAsyncImageScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    public final Function3<SubcomposeAsyncImageScope, Composer, Integer, Unit> getLambda$1938077476$coil_compose_core_release() {
        return lambda$1938077476;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1938077476$lambda$0(SubcomposeAsyncImageScope subcomposeAsyncImageScope, Composer composer, int i) {
        int i2;
        ComposerKt.sourceInformation(composer, "C309@13094L29:SubcomposeAsyncImage.kt#8xxpns");
        if ((i & 6) == 0) {
            i2 = (composer.changed(subcomposeAsyncImageScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1938077476, i2, -1, "coil3.compose.ComposableSingletons$SubcomposeAsyncImageKt.lambda$1938077476.<anonymous> (SubcomposeAsyncImage.kt:309)");
            }
            SubcomposeAsyncImageKt.SubcomposeAsyncImageContent(subcomposeAsyncImageScope, null, null, null, null, null, 0.0f, null, false, composer, i2 & 14, Constants.MAX_HOST_LENGTH);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
