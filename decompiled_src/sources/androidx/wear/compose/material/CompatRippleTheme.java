package androidx.wear.compose.material;

import androidx.compose.material.ripple.RippleAlpha;
import androidx.compose.material.ripple.RippleTheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.ui.graphics.Color;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: compiled from: Ripple.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u0004H\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\bH\u0017¢\u0006\u0002\u0010\t\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\n"}, d2 = {"Landroidx/wear/compose/material/CompatRippleTheme;", "Landroidx/compose/material/ripple/RippleTheme;", "()V", "defaultColor", "Landroidx/compose/ui/graphics/Color;", "defaultColor-WaAFU9c", "(Landroidx/compose/runtime/Composer;I)J", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/ripple/RippleAlpha;", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CompatRippleTheme implements RippleTheme {
    public static final int $stable = 0;
    public static final CompatRippleTheme INSTANCE = new CompatRippleTheme();

    private CompatRippleTheme() {
    }

    @Deprecated(message = "Super method is deprecated")
    /* JADX INFO: renamed from: defaultColor-WaAFU9c, reason: not valid java name */
    public long m577defaultColorWaAFU9c(Composer composer, int i) {
        composer.startReplaceGroup(-969350931);
        ComposerKt.sourceInformation(composer, "C(defaultColor)194@8796L7:Ripple.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-969350931, i, -1, "androidx.wear.compose.material.CompatRippleTheme.defaultColor (Ripple.kt:194)");
        }
        RippleDefaults rippleDefaults = RippleDefaults.INSTANCE;
        CompositionLocal localContentColor = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContentColor);
        ComposerKt.sourceInformationMarkerEnd(composer);
        long jM740rippleColorl2rxGTc = rippleDefaults.m740rippleColorl2rxGTc(((Color) objConsume).unbox-impl());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return jM740rippleColorl2rxGTc;
    }

    @Deprecated(message = "Super method is deprecated")
    public RippleAlpha rippleAlpha(Composer composer, int i) {
        composer.startReplaceGroup(-25295608);
        ComposerKt.sourceInformation(composer, "C(rippleAlpha):Ripple.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-25295608, i, -1, "androidx.wear.compose.material.CompatRippleTheme.rippleAlpha (Ripple.kt:198)");
        }
        RippleAlpha rippleAlpha = RippleKt.RippleAlpha;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return rippleAlpha;
    }
}
