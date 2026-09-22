package androidx.wear.compose.materialcore;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: RangeDefaults.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\tJ$\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\f"}, d2 = {"Landroidx/wear/compose/materialcore/RangeDefaults;", "", "()V", "calculateCurrentStepValue", "", "currentStep", "", "steps", "valueRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "snapValueToStep", "value", "compose-material-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RangeDefaults {
    public static final int $stable = 0;
    public static final RangeDefaults INSTANCE = new RangeDefaults();

    private RangeDefaults() {
    }

    public final float calculateCurrentStepValue(int currentStep, int steps, ClosedFloatingPointRange<Float> valueRange) {
        return ((Number) RangesKt.coerceIn(Float.valueOf(MathHelpersKt.lerp(((Number) valueRange.getStart()).floatValue(), ((Number) valueRange.getEndInclusive()).floatValue(), currentStep / (steps + 1))), valueRange)).floatValue();
    }

    public final int snapValueToStep(float value, ClosedFloatingPointRange<Float> valueRange, int steps) {
        int i = steps + 1;
        return RangesKt.coerceIn(MathKt.roundToInt(((value - ((Number) valueRange.getStart()).floatValue()) / (((Number) valueRange.getEndInclusive()).floatValue() - ((Number) valueRange.getStart()).floatValue())) * i), 0, i);
    }
}
