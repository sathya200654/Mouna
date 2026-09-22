package androidx.wear.compose.material;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.AddKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.wear.compose.materialcore.RangeIcons;
import kotlin.Metadata;

/* JADX INFO: compiled from: Stepper.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Landroidx/wear/compose/material/StepperDefaults;", "", "()V", "Decrease", "Landroidx/compose/ui/graphics/vector/ImageVector;", "getDecrease", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "Increase", "getIncrease", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class StepperDefaults {
    public static final int $stable = 0;
    public static final StepperDefaults INSTANCE = new StepperDefaults();
    private static final ImageVector Decrease = RangeIcons.INSTANCE.getMinus();
    private static final ImageVector Increase = AddKt.getAdd(Icons.Filled.INSTANCE);

    private StepperDefaults() {
    }

    public final ImageVector getDecrease() {
        return Decrease;
    }

    public final ImageVector getIncrease() {
        return Increase;
    }
}
