package com.vivekgupta.composecoachmark.coachmark;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import kotlin.Metadata;

/* JADX INFO: compiled from: Helper.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/vivekgupta/composecoachmark/coachmark/CoachMarkState;", "", "()V", "targetList", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "", "Lcom/vivekgupta/composecoachmark/coachmark/CoachData;", "getTargetList$composecoachmark_release", "()Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "composecoachmark_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CoachMarkState {
    public static final int $stable = 0;
    private final SnapshotStateMap<Integer, CoachData> targetList = SnapshotStateKt.mutableStateMapOf();

    public final SnapshotStateMap<Integer, CoachData> getTargetList$composecoachmark_release() {
        return this.targetList;
    }
}
