package androidx.wear.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: HorizontalPageIndicator.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0007\u001a\u00020\bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u0004X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, d2 = {"Landroidx/wear/compose/material/PageIndicatorDefaults;", "", "()V", "MaxNumberOfIndicators", "", "getMaxNumberOfIndicators$compose_material_release", "()I", "style", "Landroidx/wear/compose/material/PageIndicatorStyle;", "style-2L-WCLk", "(Landroidx/compose/runtime/Composer;I)I", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PageIndicatorDefaults {
    public static final int $stable = 0;
    public static final PageIndicatorDefaults INSTANCE = new PageIndicatorDefaults();
    private static final int MaxNumberOfIndicators = 6;

    private PageIndicatorDefaults() {
    }

    /* JADX INFO: renamed from: style-2L-WCLk, reason: not valid java name */
    public final int m619style2LWCLk(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 449650583, "C(style)250@10126L15:HorizontalPageIndicator.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(449650583, i, -1, "androidx.wear.compose.material.PageIndicatorDefaults.style (HorizontalPageIndicator.kt:250)");
        }
        int iM627getCurvedwm_g0bU = androidx.wear.compose.materialcore.ResourcesKt.isRoundDevice(composer, 0) ? PageIndicatorStyle.INSTANCE.m627getCurvedwm_g0bU() : PageIndicatorStyle.INSTANCE.m628getLinearwm_g0bU();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iM627getCurvedwm_g0bU;
    }

    public final int getMaxNumberOfIndicators$compose_material_release() {
        return MaxNumberOfIndicators;
    }
}
