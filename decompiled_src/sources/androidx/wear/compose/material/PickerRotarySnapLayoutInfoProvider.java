package androidx.wear.compose.material;

import androidx.wear.compose.foundation.rotary.RotarySnapLayoutInfoProvider;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: Picker.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\f¨\u0006\u0011"}, d2 = {"Landroidx/wear/compose/material/PickerRotarySnapLayoutInfoProvider;", "Landroidx/wear/compose/foundation/rotary/RotarySnapLayoutInfoProvider;", "scrollableState", "Landroidx/wear/compose/material/PickerState;", "(Landroidx/wear/compose/material/PickerState;)V", "averageItemSize", "", "getAverageItemSize", "()F", "currentItemIndex", "", "getCurrentItemIndex", "()I", "currentItemOffset", "getCurrentItemOffset", "totalItemCount", "getTotalItemCount", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PickerRotarySnapLayoutInfoProvider implements RotarySnapLayoutInfoProvider {
    public static final int $stable = 0;
    private final PickerState scrollableState;

    public PickerRotarySnapLayoutInfoProvider(PickerState pickerState) {
        this.scrollableState = pickerState;
    }

    @Override // androidx.wear.compose.foundation.rotary.RotarySnapLayoutInfoProvider
    public float getAverageItemSize() {
        androidx.wear.compose.foundation.lazy.ScalingLazyListItemInfo scalingLazyListItemInfo = (androidx.wear.compose.foundation.lazy.ScalingLazyListItemInfo) CollectionsKt.firstOrNull(this.scrollableState.getScalingLazyListState().getLayoutInfo().getVisibleItemsInfo());
        if (scalingLazyListItemInfo != null) {
            return scalingLazyListItemInfo.getUnadjustedSize();
        }
        return 0.0f;
    }

    @Override // androidx.wear.compose.foundation.rotary.RotarySnapLayoutInfoProvider
    public int getCurrentItemIndex() {
        return this.scrollableState.getScalingLazyListState().getCenterItemIndex();
    }

    @Override // androidx.wear.compose.foundation.rotary.RotarySnapLayoutInfoProvider
    public float getCurrentItemOffset() {
        return this.scrollableState.getScalingLazyListState().getCenterItemScrollOffset();
    }

    @Override // androidx.wear.compose.foundation.rotary.RotarySnapLayoutInfoProvider
    public int getTotalItemCount() {
        return this.scrollableState.getScalingLazyListState().getLayoutInfo().getTotalItemsCount();
    }
}
