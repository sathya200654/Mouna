package androidx.wear.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SelectableChip.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003¢\u0006\u0002\u0010\u0011J\u001b\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0017¢\u0006\u0002\u0010\u0016J\u001b\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0017¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u001b\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0017¢\u0006\u0002\u0010\u0016J#\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0015H\u0017¢\u0006\u0002\u0010\u001eJ#\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0015H\u0017¢\u0006\u0002\u0010\u001eR\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0012R\u0016\u0010\b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0012R\u0016\u0010\t\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0012R\u0016\u0010\n\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0012R\u0016\u0010\u000b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0012R\u0016\u0010\f\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0012R\u0016\u0010\u000f\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0012R\u0016\u0010\u0010\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0012R\u0016\u0010\r\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0012R\u0016\u0010\u000e\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0012\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, d2 = {"Landroidx/wear/compose/material/DefaultSplitSelectableChipColors;", "Landroidx/wear/compose/material/SplitSelectableChipColors;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "secondaryContentColor", "selectedIconColor", "selectedSplitBackgroundOverlay", "disabledBackgroundColor", "disabledContentColor", "disabledSecondaryContentColor", "disabledSelectedIconColor", "disabledSelectedSplitBackgroundOverlay", "unselectedIconColor", "unselectedSplitBackgroundOverlay", "disabledUnselectedIconColor", "disabledUnselectedSplitBackgroundOverlay", "(JJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "Landroidx/compose/runtime/State;", "enabled", "", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "", "hashCode", "", "selectionControlColor", "selected", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "splitBackgroundOverlay", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DefaultSplitSelectableChipColors implements SplitSelectableChipColors {
    private final long backgroundColor;
    private final long contentColor;
    private final long disabledBackgroundColor;
    private final long disabledContentColor;
    private final long disabledSecondaryContentColor;
    private final long disabledSelectedIconColor;
    private final long disabledSelectedSplitBackgroundOverlay;
    private final long disabledUnselectedIconColor;
    private final long disabledUnselectedSplitBackgroundOverlay;
    private final long secondaryContentColor;
    private final long selectedIconColor;
    private final long selectedSplitBackgroundOverlay;
    private final long unselectedIconColor;
    private final long unselectedSplitBackgroundOverlay;

    public /* synthetic */ DefaultSplitSelectableChipColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14);
    }

    private DefaultSplitSelectableChipColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14) {
        this.backgroundColor = j;
        this.contentColor = j2;
        this.secondaryContentColor = j3;
        this.selectedIconColor = j4;
        this.selectedSplitBackgroundOverlay = j5;
        this.disabledBackgroundColor = j6;
        this.disabledContentColor = j7;
        this.disabledSecondaryContentColor = j8;
        this.disabledSelectedIconColor = j9;
        this.disabledSelectedSplitBackgroundOverlay = j10;
        this.unselectedIconColor = j11;
        this.unselectedSplitBackgroundOverlay = j12;
        this.disabledUnselectedIconColor = j13;
        this.disabledUnselectedSplitBackgroundOverlay = j14;
    }

    @Override // androidx.wear.compose.material.SplitSelectableChipColors
    public State<Color> backgroundColor(boolean z, Composer composer, int i) {
        composer.startReplaceGroup(-1570714122);
        ComposerKt.sourceInformation(composer, "C(backgroundColor)744@35333L101:SelectableChip.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1570714122, i, -1, "androidx.wear.compose.material.DefaultSplitSelectableChipColors.backgroundColor (SelectableChip.kt:743)");
        }
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.box-impl(z ? this.backgroundColor : this.disabledBackgroundColor), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return stateRememberUpdatedState;
    }

    @Override // androidx.wear.compose.material.SplitSelectableChipColors
    public State<Color> contentColor(boolean z, Composer composer, int i) {
        composer.startReplaceGroup(1148626021);
        ComposerKt.sourceInformation(composer, "C(contentColor)751@35537L95:SelectableChip.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1148626021, i, -1, "androidx.wear.compose.material.DefaultSplitSelectableChipColors.contentColor (SelectableChip.kt:750)");
        }
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.box-impl(z ? this.contentColor : this.disabledContentColor), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return stateRememberUpdatedState;
    }

    @Override // androidx.wear.compose.material.SplitSelectableChipColors
    public State<Color> secondaryContentColor(boolean z, Composer composer, int i) {
        composer.startReplaceGroup(-348442323);
        ComposerKt.sourceInformation(composer, "C(secondaryContentColor)758@35744L113:SelectableChip.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-348442323, i, -1, "androidx.wear.compose.material.DefaultSplitSelectableChipColors.secondaryContentColor (SelectableChip.kt:757)");
        }
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.box-impl(z ? this.secondaryContentColor : this.disabledSecondaryContentColor), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return stateRememberUpdatedState;
    }

    @Override // androidx.wear.compose.material.SplitSelectableChipColors
    public State<Color> selectionControlColor(boolean z, boolean z2, Composer composer, int i) {
        long j;
        composer.startReplaceGroup(-792583395);
        ComposerKt.sourceInformation(composer, "C(selectionControlColor)765@35988L255:SelectableChip.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-792583395, i, -1, "androidx.wear.compose.material.DefaultSplitSelectableChipColors.selectionControlColor (SelectableChip.kt:764)");
        }
        if (z) {
            j = z2 ? this.selectedIconColor : this.unselectedIconColor;
        } else {
            j = z2 ? this.disabledSelectedIconColor : this.disabledUnselectedIconColor;
        }
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.box-impl(j), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return stateRememberUpdatedState;
    }

    @Override // androidx.wear.compose.material.SplitSelectableChipColors
    public State<Color> splitBackgroundOverlay(boolean z, boolean z2, Composer composer, int i) {
        long j;
        composer.startReplaceGroup(-1290992277);
        ComposerKt.sourceInformation(composer, "C(splitBackgroundOverlay)776@36375L327:SelectableChip.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1290992277, i, -1, "androidx.wear.compose.material.DefaultSplitSelectableChipColors.splitBackgroundOverlay (SelectableChip.kt:775)");
        }
        if (z) {
            j = z2 ? this.selectedSplitBackgroundOverlay : this.unselectedSplitBackgroundOverlay;
        } else if (z2) {
            j = this.disabledSelectedSplitBackgroundOverlay;
        } else {
            j = this.disabledUnselectedSplitBackgroundOverlay;
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
        DefaultSplitSelectableChipColors defaultSplitSelectableChipColors = (DefaultSplitSelectableChipColors) other;
        return Color.equals-impl0(this.backgroundColor, defaultSplitSelectableChipColors.backgroundColor) && Color.equals-impl0(this.contentColor, defaultSplitSelectableChipColors.contentColor) && Color.equals-impl0(this.selectedIconColor, defaultSplitSelectableChipColors.selectedIconColor) && Color.equals-impl0(this.selectedSplitBackgroundOverlay, defaultSplitSelectableChipColors.selectedSplitBackgroundOverlay) && Color.equals-impl0(this.unselectedIconColor, defaultSplitSelectableChipColors.unselectedIconColor) && Color.equals-impl0(this.unselectedSplitBackgroundOverlay, defaultSplitSelectableChipColors.unselectedSplitBackgroundOverlay) && Color.equals-impl0(this.disabledBackgroundColor, defaultSplitSelectableChipColors.disabledBackgroundColor) && Color.equals-impl0(this.disabledContentColor, defaultSplitSelectableChipColors.disabledContentColor) && Color.equals-impl0(this.disabledSelectedIconColor, defaultSplitSelectableChipColors.disabledSelectedIconColor) && Color.equals-impl0(this.disabledSecondaryContentColor, defaultSplitSelectableChipColors.disabledSecondaryContentColor) && Color.equals-impl0(this.disabledSelectedSplitBackgroundOverlay, defaultSplitSelectableChipColors.disabledSelectedSplitBackgroundOverlay) && Color.equals-impl0(this.disabledUnselectedIconColor, defaultSplitSelectableChipColors.disabledUnselectedIconColor) && Color.equals-impl0(this.disabledUnselectedSplitBackgroundOverlay, defaultSplitSelectableChipColors.disabledUnselectedSplitBackgroundOverlay);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((Color.hashCode-impl(this.backgroundColor) * 31) + Color.hashCode-impl(this.contentColor)) * 31) + Color.hashCode-impl(this.secondaryContentColor)) * 31) + Color.hashCode-impl(this.selectedIconColor)) * 31) + Color.hashCode-impl(this.selectedSplitBackgroundOverlay)) * 31) + Color.hashCode-impl(this.unselectedIconColor)) * 31) + Color.hashCode-impl(this.unselectedSplitBackgroundOverlay)) * 31) + Color.hashCode-impl(this.disabledBackgroundColor)) * 31) + Color.hashCode-impl(this.disabledContentColor)) * 31) + Color.hashCode-impl(this.disabledSecondaryContentColor)) * 31) + Color.hashCode-impl(this.disabledSelectedIconColor)) * 31) + Color.hashCode-impl(this.disabledSelectedSplitBackgroundOverlay)) * 31) + Color.hashCode-impl(this.disabledUnselectedIconColor)) * 31) + Color.hashCode-impl(this.disabledUnselectedSplitBackgroundOverlay);
    }
}
