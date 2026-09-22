package androidx.wear.compose.materialcore;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: compiled from: Stepper.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000b"}, d2 = {"Landroidx/wear/compose/materialcore/StepperDefaults;", "", "()V", "BorderPadding", "Landroidx/compose/ui/unit/Dp;", "getBorderPadding-D9Ej5fM", "()F", "F", "ButtonWeight", "", "ContentWeight", "compose-material-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class StepperDefaults {
    public static final float ButtonWeight = 0.35f;
    public static final float ContentWeight = 0.3f;
    public static final StepperDefaults INSTANCE = new StepperDefaults();
    private static final float BorderPadding = Dp.constructor-impl(22);

    private StepperDefaults() {
    }

    /* JADX INFO: renamed from: getBorderPadding-D9Ej5fM, reason: not valid java name */
    public final float m933getBorderPaddingD9Ej5fM() {
        return BorderPadding;
    }
}
