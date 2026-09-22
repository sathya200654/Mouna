package androidx.wear.compose.material;

import androidx.compose.animation.core.CubicBezierEasing;
import kotlin.Metadata;

/* JADX INFO: compiled from: Animation.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\"\u0014\u0010\n\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"CASUAL", "", "FLASH", "QUICK", "RAPID", "STANDARD", "STANDARD_IN", "Landroidx/compose/animation/core/CubicBezierEasing;", "getSTANDARD_IN", "()Landroidx/compose/animation/core/CubicBezierEasing;", "STANDARD_OUT", "getSTANDARD_OUT", "compose-material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AnimationKt {
    public static final int CASUAL = 400;
    public static final int FLASH = 75;
    public static final int QUICK = 250;
    public static final int RAPID = 150;
    public static final int STANDARD = 300;
    private static final CubicBezierEasing STANDARD_IN = new CubicBezierEasing(0.0f, 0.0f, 0.2f, 1.0f);
    private static final CubicBezierEasing STANDARD_OUT = new CubicBezierEasing(0.4f, 0.0f, 1.0f, 1.0f);

    public static final CubicBezierEasing getSTANDARD_IN() {
        return STANDARD_IN;
    }

    public static final CubicBezierEasing getSTANDARD_OUT() {
        return STANDARD_OUT;
    }
}
