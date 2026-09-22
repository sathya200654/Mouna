package androidx.wear.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Chip.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u001d\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0017¢\u0006\u0002\u0010\tJ\u0013\u0010\n\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/wear/compose/material/DefaultChipBorder;", "Landroidx/wear/compose/material/ChipBorder;", "borderStroke", "Landroidx/compose/foundation/BorderStroke;", "disabledBorderStroke", "(Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/BorderStroke;)V", "Landroidx/compose/runtime/State;", "enabled", "", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "", "hashCode", "", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DefaultChipBorder implements ChipBorder {
    private final BorderStroke borderStroke;
    private final BorderStroke disabledBorderStroke;

    /* JADX WARN: Illegal instructions before constructor call */
    public DefaultChipBorder() {
        BorderStroke borderStroke = null;
        this(borderStroke, borderStroke, 3, borderStroke);
    }

    public DefaultChipBorder(BorderStroke borderStroke, BorderStroke borderStroke2) {
        this.borderStroke = borderStroke;
        this.disabledBorderStroke = borderStroke2;
    }

    public /* synthetic */ DefaultChipBorder(BorderStroke borderStroke, BorderStroke borderStroke2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : borderStroke, (i & 2) != 0 ? null : borderStroke2);
    }

    @Override // androidx.wear.compose.material.ChipBorder
    public State<BorderStroke> borderStroke(boolean z, Composer composer, int i) {
        composer.startReplaceGroup(-693730917);
        ComposerKt.sourceInformation(composer, "C(borderStroke)1366@62324L73:Chip.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-693730917, i, -1, "androidx.wear.compose.material.DefaultChipBorder.borderStroke (Chip.kt:1365)");
        }
        State<BorderStroke> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(z ? this.borderStroke : this.disabledBorderStroke, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return stateRememberUpdatedState;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        DefaultChipBorder defaultChipBorder = (DefaultChipBorder) other;
        return Intrinsics.areEqual(this.borderStroke, defaultChipBorder.borderStroke) && Intrinsics.areEqual(this.disabledBorderStroke, defaultChipBorder.disabledBorderStroke);
    }

    public int hashCode() {
        BorderStroke borderStroke = this.borderStroke;
        int iHashCode = (borderStroke != null ? borderStroke.hashCode() : 0) * 31;
        BorderStroke borderStroke2 = this.disabledBorderStroke;
        return iHashCode + (borderStroke2 != null ? borderStroke2.hashCode() : 0);
    }
}
