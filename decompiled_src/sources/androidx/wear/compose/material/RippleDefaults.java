package androidx.wear.compose.material;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: Ripple.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\b"}, d2 = {"Landroidx/wear/compose/material/RippleDefaults;", "", "()V", "rippleColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "rippleColor-l2rxGTc", "(J)J", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class RippleDefaults {
    public static final RippleDefaults INSTANCE = new RippleDefaults();

    private RippleDefaults() {
    }

    /* JADX INFO: renamed from: rippleColor-l2rxGTc, reason: not valid java name */
    public final long m740rippleColorl2rxGTc(long contentColor) {
        return ((double) ColorKt.luminance-8_81llA(contentColor)) < 0.5d ? Color.Companion.getWhite-0d7_KjU() : contentColor;
    }
}
