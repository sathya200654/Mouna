package coil3.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: DrawScopeSizeResolver.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\b\u0010\u0003\u001a\u00020\u0001H\u0007¨\u0006\u0004"}, d2 = {"rememberDrawScopeSizeResolver", "Lcoil3/compose/DrawScopeSizeResolver;", "(Landroidx/compose/runtime/Composer;I)Lcoil3/compose/DrawScopeSizeResolver;", "DrawScopeSizeResolver", "coil-compose-core_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DrawScopeSizeResolverKt {
    public static final DrawScopeSizeResolver rememberDrawScopeSizeResolver(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 2057132148, "C(rememberDrawScopeSizeResolver)27@951L36:DrawScopeSizeResolver.kt#8xxpns");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2057132148, i, -1, "coil3.compose.rememberDrawScopeSizeResolver (DrawScopeSizeResolver.kt:26)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1219041464, "CC(remember):DrawScopeSizeResolver.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = DrawScopeSizeResolver();
            composer.updateRememberedValue(objRememberedValue);
        }
        DrawScopeSizeResolver drawScopeSizeResolver = (DrawScopeSizeResolver) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return drawScopeSizeResolver;
    }

    public static final DrawScopeSizeResolver DrawScopeSizeResolver() {
        return new RealDrawScopeSizeResolver();
    }
}
