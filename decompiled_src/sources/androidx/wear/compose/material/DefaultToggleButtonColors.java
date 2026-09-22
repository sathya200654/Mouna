package androidx.wear.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ToggleButton.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ#\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0017¢\u0006\u0002\u0010\u0012J#\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0017¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0014\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\t\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\n\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\u0007\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Landroidx/wear/compose/material/DefaultToggleButtonColors;", "Landroidx/wear/compose/material/ToggleButtonColors;", "checkedBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "checkedContentColor", "disabledCheckedBackgroundColor", "disabledCheckedContentColor", "uncheckedBackgroundColor", "uncheckedContentColor", "disabledUncheckedBackgroundColor", "disabledUncheckedContentColor", "(JJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "backgroundColor", "Landroidx/compose/runtime/State;", "enabled", "", "checked", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "contentColor", "equals", "other", "", "hashCode", "", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DefaultToggleButtonColors implements ToggleButtonColors {
    private final long checkedBackgroundColor;
    private final long checkedContentColor;
    private final long disabledCheckedBackgroundColor;
    private final long disabledCheckedContentColor;
    private final long disabledUncheckedBackgroundColor;
    private final long disabledUncheckedContentColor;
    private final long uncheckedBackgroundColor;
    private final long uncheckedContentColor;

    public /* synthetic */ DefaultToggleButtonColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8);
    }

    private DefaultToggleButtonColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8) {
        this.checkedBackgroundColor = j;
        this.checkedContentColor = j2;
        this.disabledCheckedBackgroundColor = j3;
        this.disabledCheckedContentColor = j4;
        this.uncheckedBackgroundColor = j5;
        this.uncheckedContentColor = j6;
        this.disabledUncheckedBackgroundColor = j7;
        this.disabledUncheckedContentColor = j8;
    }

    @Override // androidx.wear.compose.material.ToggleButtonColors
    public State<Color> backgroundColor(boolean z, boolean z2, Composer composer, int i) {
        long j;
        composer.startReplaceGroup(-1439386064);
        ComposerKt.sourceInformation(composer, "C(backgroundColor)P(1)355@16085L273:ToggleButton.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1439386064, i, -1, "androidx.wear.compose.material.DefaultToggleButtonColors.backgroundColor (ToggleButton.kt:354)");
        }
        if (z) {
            j = z2 ? this.checkedBackgroundColor : this.uncheckedBackgroundColor;
        } else {
            j = z2 ? this.disabledCheckedBackgroundColor : this.disabledUncheckedBackgroundColor;
        }
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.box-impl(j), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return stateRememberUpdatedState;
    }

    @Override // androidx.wear.compose.material.ToggleButtonColors
    public State<Color> contentColor(boolean z, boolean z2, Composer composer, int i) {
        long j;
        composer.startReplaceGroup(2112017889);
        ComposerKt.sourceInformation(composer, "C(contentColor)P(1)366@16479L261:ToggleButton.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2112017889, i, -1, "androidx.wear.compose.material.DefaultToggleButtonColors.contentColor (ToggleButton.kt:365)");
        }
        if (z) {
            j = z2 ? this.checkedContentColor : this.uncheckedContentColor;
        } else {
            j = z2 ? this.disabledCheckedContentColor : this.disabledUncheckedContentColor;
        }
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.box-impl(j), composer, 0);
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
        DefaultToggleButtonColors defaultToggleButtonColors = (DefaultToggleButtonColors) other;
        return Color.equals-impl0(this.checkedBackgroundColor, defaultToggleButtonColors.checkedBackgroundColor) && Color.equals-impl0(this.checkedContentColor, defaultToggleButtonColors.checkedContentColor) && Color.equals-impl0(this.disabledCheckedBackgroundColor, defaultToggleButtonColors.disabledCheckedBackgroundColor) && Color.equals-impl0(this.disabledCheckedContentColor, defaultToggleButtonColors.disabledCheckedContentColor) && Color.equals-impl0(this.uncheckedBackgroundColor, defaultToggleButtonColors.uncheckedBackgroundColor) && Color.equals-impl0(this.uncheckedContentColor, defaultToggleButtonColors.uncheckedContentColor) && Color.equals-impl0(this.disabledUncheckedBackgroundColor, defaultToggleButtonColors.disabledUncheckedBackgroundColor) && Color.equals-impl0(this.disabledUncheckedContentColor, defaultToggleButtonColors.disabledUncheckedContentColor);
    }

    public int hashCode() {
        return (((((((((((((Color.hashCode-impl(this.checkedBackgroundColor) * 31) + Color.hashCode-impl(this.checkedContentColor)) * 31) + Color.hashCode-impl(this.disabledCheckedBackgroundColor)) * 31) + Color.hashCode-impl(this.disabledCheckedContentColor)) * 31) + Color.hashCode-impl(this.uncheckedBackgroundColor)) * 31) + Color.hashCode-impl(this.uncheckedContentColor)) * 31) + Color.hashCode-impl(this.disabledUncheckedBackgroundColor)) * 31) + Color.hashCode-impl(this.disabledUncheckedContentColor);
    }
}
