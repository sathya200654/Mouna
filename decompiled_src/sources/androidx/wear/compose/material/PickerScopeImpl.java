package androidx.wear.compose.material;

import kotlin.Metadata;

/* JADX INFO: compiled from: Picker.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/wear/compose/material/PickerScopeImpl;", "Landroidx/wear/compose/material/PickerScope;", "pickerState", "Landroidx/wear/compose/material/PickerState;", "(Landroidx/wear/compose/material/PickerState;)V", "selectedOption", "", "getSelectedOption", "()I", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class PickerScopeImpl implements PickerScope {
    private final PickerState pickerState;

    public PickerScopeImpl(PickerState pickerState) {
        this.pickerState = pickerState;
    }

    @Override // androidx.wear.compose.material.PickerScope
    public int getSelectedOption() {
        return this.pickerState.getSelectedOption();
    }
}
