package androidx.wear.compose.foundation;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: HierarchicalFocusCoordinator.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u0006¢\u0006\u0002\u0010\u0007R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/wear/compose/foundation/FocusNode;", "", "focused", "Landroidx/compose/runtime/State;", "", "children", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "(Landroidx/compose/runtime/State;Landroidx/compose/runtime/snapshots/SnapshotStateList;)V", "getChildren", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", "setChildren", "(Landroidx/compose/runtime/snapshots/SnapshotStateList;)V", "getFocused", "()Landroidx/compose/runtime/State;", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FocusNode {
    public static final int $stable = 8;
    private SnapshotStateList<FocusNode> children;
    private final State<Boolean> focused;

    public FocusNode(State<Boolean> state, SnapshotStateList<FocusNode> snapshotStateList) {
        this.focused = state;
        this.children = snapshotStateList;
    }

    public final State<Boolean> getFocused() {
        return this.focused;
    }

    public /* synthetic */ FocusNode(State state, SnapshotStateList snapshotStateList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(state, (i & 2) != 0 ? SnapshotStateKt.mutableStateListOf() : snapshotStateList);
    }

    public final SnapshotStateList<FocusNode> getChildren() {
        return this.children;
    }

    public final void setChildren(SnapshotStateList<FocusNode> snapshotStateList) {
        this.children = snapshotStateList;
    }
}
