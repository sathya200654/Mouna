package androidx.wear.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ToggleChip.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003¢\u0006\u0002\u0010\u0011J\u001b\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0017¢\u0006\u0002\u0010\u0016J\u001b\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0017¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u001b\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0017¢\u0006\u0002\u0010\u0016J#\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0015H\u0017¢\u0006\u0002\u0010\u001eJ#\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0015H\u0017¢\u0006\u0002\u0010\u001eR\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0012R\u0016\u0010\b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0012R\u0016\u0010\u000b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0012R\u0016\u0010\f\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0012R\u0016\u0010\t\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0012R\u0016\u0010\n\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0012R\u0016\u0010\u000f\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0012R\u0016\u0010\u0010\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0012R\u0016\u0010\r\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0012R\u0016\u0010\u000e\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0012\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, d2 = {"Landroidx/wear/compose/material/DefaultSplitToggleChipColors;", "Landroidx/wear/compose/material/SplitToggleChipColors;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "secondaryContentColor", "checkedIconColor", "checkedSplitBackgroundOverlay", "disabledBackgroundColor", "disabledContentColor", "disabledSecondaryContentColor", "disabledCheckedIconColor", "disabledCheckedSplitBackgroundOverlay", "uncheckedIconColor", "uncheckedSplitBackgroundOverlay", "disabledUncheckedIconColor", "disabledUncheckedSplitBackgroundOverlay", "(JJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "Landroidx/compose/runtime/State;", "enabled", "", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "", "hashCode", "", "splitBackgroundOverlay", "checked", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "toggleControlColor", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DefaultSplitToggleChipColors implements SplitToggleChipColors {
    private final long backgroundColor;
    private final long checkedIconColor;
    private final long checkedSplitBackgroundOverlay;
    private final long contentColor;
    private final long disabledBackgroundColor;
    private final long disabledCheckedIconColor;
    private final long disabledCheckedSplitBackgroundOverlay;
    private final long disabledContentColor;
    private final long disabledSecondaryContentColor;
    private final long disabledUncheckedIconColor;
    private final long disabledUncheckedSplitBackgroundOverlay;
    private final long secondaryContentColor;
    private final long uncheckedIconColor;
    private final long uncheckedSplitBackgroundOverlay;

    public /* synthetic */ DefaultSplitToggleChipColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14);
    }

    private DefaultSplitToggleChipColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14) {
        this.backgroundColor = j;
        this.contentColor = j2;
        this.secondaryContentColor = j3;
        this.checkedIconColor = j4;
        this.checkedSplitBackgroundOverlay = j5;
        this.disabledBackgroundColor = j6;
        this.disabledContentColor = j7;
        this.disabledSecondaryContentColor = j8;
        this.disabledCheckedIconColor = j9;
        this.disabledCheckedSplitBackgroundOverlay = j10;
        this.uncheckedIconColor = j11;
        this.uncheckedSplitBackgroundOverlay = j12;
        this.disabledUncheckedIconColor = j13;
        this.disabledUncheckedSplitBackgroundOverlay = j14;
    }

    @Override // androidx.wear.compose.material.SplitToggleChipColors
    public State<Color> backgroundColor(boolean z, Composer composer, int i) {
        composer.startReplaceGroup(-604171338);
        ComposerKt.sourceInformation(composer, "C(backgroundColor)979@44272L101:ToggleChip.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-604171338, i, -1, "androidx.wear.compose.material.DefaultSplitToggleChipColors.backgroundColor (ToggleChip.kt:978)");
        }
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.box-impl(z ? this.backgroundColor : this.disabledBackgroundColor), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return stateRememberUpdatedState;
    }

    @Override // androidx.wear.compose.material.SplitToggleChipColors
    public State<Color> contentColor(boolean z, Composer composer, int i) {
        composer.startReplaceGroup(-1611937499);
        ComposerKt.sourceInformation(composer, "C(contentColor)986@44476L95:ToggleChip.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1611937499, i, -1, "androidx.wear.compose.material.DefaultSplitToggleChipColors.contentColor (ToggleChip.kt:985)");
        }
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.box-impl(z ? this.contentColor : this.disabledContentColor), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return stateRememberUpdatedState;
    }

    @Override // androidx.wear.compose.material.SplitToggleChipColors
    public State<Color> secondaryContentColor(boolean z, Composer composer, int i) {
        composer.startReplaceGroup(-1236427283);
        ComposerKt.sourceInformation(composer, "C(secondaryContentColor)993@44683L113:ToggleChip.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1236427283, i, -1, "androidx.wear.compose.material.DefaultSplitToggleChipColors.secondaryContentColor (ToggleChip.kt:992)");
        }
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.box-impl(z ? this.secondaryContentColor : this.disabledSecondaryContentColor), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return stateRememberUpdatedState;
    }

    @Override // androidx.wear.compose.material.SplitToggleChipColors
    public State<Color> toggleControlColor(boolean z, boolean z2, Composer composer, int i) {
        long j;
        composer.startReplaceGroup(-432243527);
        ComposerKt.sourceInformation(composer, "C(toggleControlColor)P(1)1000@44923L249:ToggleChip.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-432243527, i, -1, "androidx.wear.compose.material.DefaultSplitToggleChipColors.toggleControlColor (ToggleChip.kt:999)");
        }
        if (z) {
            j = z2 ? this.checkedIconColor : this.uncheckedIconColor;
        } else {
            j = z2 ? this.disabledCheckedIconColor : this.disabledUncheckedIconColor;
        }
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.box-impl(j), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return stateRememberUpdatedState;
    }

    @Override // androidx.wear.compose.material.SplitToggleChipColors
    public State<Color> splitBackgroundOverlay(boolean z, boolean z2, Composer composer, int i) {
        long j;
        composer.startReplaceGroup(882806827);
        ComposerKt.sourceInformation(composer, "C(splitBackgroundOverlay)P(1)1011@45303L321:ToggleChip.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(882806827, i, -1, "androidx.wear.compose.material.DefaultSplitToggleChipColors.splitBackgroundOverlay (ToggleChip.kt:1010)");
        }
        if (z) {
            j = z2 ? this.checkedSplitBackgroundOverlay : this.uncheckedSplitBackgroundOverlay;
        } else if (z2) {
            j = this.disabledCheckedSplitBackgroundOverlay;
        } else {
            j = this.disabledUncheckedSplitBackgroundOverlay;
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
        DefaultSplitToggleChipColors defaultSplitToggleChipColors = (DefaultSplitToggleChipColors) other;
        return Color.equals-impl0(this.backgroundColor, defaultSplitToggleChipColors.backgroundColor) && Color.equals-impl0(this.contentColor, defaultSplitToggleChipColors.contentColor) && Color.equals-impl0(this.checkedIconColor, defaultSplitToggleChipColors.checkedIconColor) && Color.equals-impl0(this.checkedSplitBackgroundOverlay, defaultSplitToggleChipColors.checkedSplitBackgroundOverlay) && Color.equals-impl0(this.uncheckedIconColor, defaultSplitToggleChipColors.uncheckedIconColor) && Color.equals-impl0(this.uncheckedSplitBackgroundOverlay, defaultSplitToggleChipColors.uncheckedSplitBackgroundOverlay) && Color.equals-impl0(this.disabledBackgroundColor, defaultSplitToggleChipColors.disabledBackgroundColor) && Color.equals-impl0(this.disabledContentColor, defaultSplitToggleChipColors.disabledContentColor) && Color.equals-impl0(this.disabledCheckedIconColor, defaultSplitToggleChipColors.disabledCheckedIconColor) && Color.equals-impl0(this.disabledSecondaryContentColor, defaultSplitToggleChipColors.disabledSecondaryContentColor) && Color.equals-impl0(this.disabledCheckedSplitBackgroundOverlay, defaultSplitToggleChipColors.disabledCheckedSplitBackgroundOverlay) && Color.equals-impl0(this.disabledUncheckedIconColor, defaultSplitToggleChipColors.disabledUncheckedIconColor) && Color.equals-impl0(this.disabledUncheckedSplitBackgroundOverlay, defaultSplitToggleChipColors.disabledUncheckedSplitBackgroundOverlay);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((Color.hashCode-impl(this.backgroundColor) * 31) + Color.hashCode-impl(this.contentColor)) * 31) + Color.hashCode-impl(this.secondaryContentColor)) * 31) + Color.hashCode-impl(this.checkedIconColor)) * 31) + Color.hashCode-impl(this.checkedSplitBackgroundOverlay)) * 31) + Color.hashCode-impl(this.uncheckedIconColor)) * 31) + Color.hashCode-impl(this.uncheckedSplitBackgroundOverlay)) * 31) + Color.hashCode-impl(this.disabledBackgroundColor)) * 31) + Color.hashCode-impl(this.disabledContentColor)) * 31) + Color.hashCode-impl(this.disabledSecondaryContentColor)) * 31) + Color.hashCode-impl(this.disabledCheckedIconColor)) * 31) + Color.hashCode-impl(this.disabledCheckedSplitBackgroundOverlay)) * 31) + Color.hashCode-impl(this.disabledUncheckedIconColor)) * 31) + Color.hashCode-impl(this.disabledUncheckedSplitBackgroundOverlay);
    }
}
