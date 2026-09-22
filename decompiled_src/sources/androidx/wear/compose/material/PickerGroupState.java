package androidx.wear.compose.material;

import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PickerGroup.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R+\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0004¨\u0006\r"}, d2 = {"Landroidx/wear/compose/material/PickerGroupState;", "", "initiallySelectedIndex", "", "(I)V", "<set-?>", "selectedIndex", "getSelectedIndex", "()I", "setSelectedIndex", "selectedIndex$delegate", "Landroidx/compose/runtime/MutableIntState;", "Companion", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PickerGroupState {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Saver<PickerGroupState, Object> Saver = ListSaverKt.listSaver(new Function2<SaverScope, PickerGroupState, List<? extends Object>>() { // from class: androidx.wear.compose.material.PickerGroupState$Companion$Saver$1
        public final List<Object> invoke(SaverScope saverScope, PickerGroupState pickerGroupState) {
            return CollectionsKt.listOf(Integer.valueOf(pickerGroupState.getSelectedIndex()));
        }
    }, new Function1<List<? extends Object>, PickerGroupState>() { // from class: androidx.wear.compose.material.PickerGroupState$Companion$Saver$2
        public final PickerGroupState invoke(List<? extends Object> list) {
            Object obj = list.get(0);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            return new PickerGroupState(((Integer) obj).intValue());
        }
    });

    /* JADX INFO: renamed from: selectedIndex$delegate, reason: from kotlin metadata */
    private final MutableIntState selectedIndex;

    public PickerGroupState() {
        this(0, 1, null);
    }

    public PickerGroupState(int i) {
        this.selectedIndex = SnapshotIntStateKt.mutableIntStateOf(i);
    }

    public /* synthetic */ PickerGroupState(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public final int getSelectedIndex() {
        return this.selectedIndex.getIntValue();
    }

    public final void setSelectedIndex(int i) {
        this.selectedIndex.setIntValue(i);
    }

    /* JADX INFO: compiled from: PickerGroup.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/wear/compose/material/PickerGroupState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/wear/compose/material/PickerGroupState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<PickerGroupState, Object> getSaver() {
            return PickerGroupState.Saver;
        }
    }
}
