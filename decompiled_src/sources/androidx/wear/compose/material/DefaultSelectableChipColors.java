package androidx.wear.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SelectableChip.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005¢\u0006\u0002\u0010\u0014J#\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0017¢\u0006\u0002\u0010\u001bJ#\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0017¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001d\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0096\u0002J\b\u0010 \u001a\u00020!H\u0016J#\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0017¢\u0006\u0002\u0010\u001bJ#\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0017¢\u0006\u0002\u0010\u001bR\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0015R\u0016\u0010\u000b\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0015R\u0016\u0010\n\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0010\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0015R\u0016\u0010\u0013\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0015R\u0016\u0010\u0012\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0015R\u0016\u0010\u0007\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0015R\u0016\u0010\u0006\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0015R\u0016\u0010\u000f\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0015R\u0016\u0010\u000e\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0015\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006$"}, d2 = {"Landroidx/wear/compose/material/DefaultSelectableChipColors;", "Landroidx/wear/compose/material/SelectableChipColors;", "selectedBackgroundPainter", "Landroidx/compose/ui/graphics/painter/Painter;", "selectedContentColor", "Landroidx/compose/ui/graphics/Color;", "selectedSecondaryContentColor", "selectedIconColor", "disabledSelectedBackgroundPainter", "disabledSelectedContentColor", "disabledSelectedSecondaryContentColor", "disabledSelectedIconColor", "unselectedBackgroundPainter", "unselectedContentColor", "unselectedSecondaryContentColor", "unselectedIconColor", "disabledUnselectedBackgroundPainter", "disabledUnselectedContentColor", "disabledUnselectedSecondaryContentColor", "disabledUnselectedIconColor", "(Landroidx/compose/ui/graphics/painter/Painter;JJJLandroidx/compose/ui/graphics/painter/Painter;JJJLandroidx/compose/ui/graphics/painter/Painter;JJJLandroidx/compose/ui/graphics/painter/Painter;JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "background", "Landroidx/compose/runtime/State;", "enabled", "", "selected", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "contentColor", "equals", "other", "", "hashCode", "", "secondaryContentColor", "selectionControlColor", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DefaultSelectableChipColors implements SelectableChipColors {
    private final Painter disabledSelectedBackgroundPainter;
    private final long disabledSelectedContentColor;
    private final long disabledSelectedIconColor;
    private final long disabledSelectedSecondaryContentColor;
    private final Painter disabledUnselectedBackgroundPainter;
    private final long disabledUnselectedContentColor;
    private final long disabledUnselectedIconColor;
    private final long disabledUnselectedSecondaryContentColor;
    private final Painter selectedBackgroundPainter;
    private final long selectedContentColor;
    private final long selectedIconColor;
    private final long selectedSecondaryContentColor;
    private final Painter unselectedBackgroundPainter;
    private final long unselectedContentColor;
    private final long unselectedIconColor;
    private final long unselectedSecondaryContentColor;

    public /* synthetic */ DefaultSelectableChipColors(Painter painter, long j, long j2, long j3, Painter painter2, long j4, long j5, long j6, Painter painter3, long j7, long j8, long j9, Painter painter4, long j10, long j11, long j12, DefaultConstructorMarker defaultConstructorMarker) {
        this(painter, j, j2, j3, painter2, j4, j5, j6, painter3, j7, j8, j9, painter4, j10, j11, j12);
    }

    private DefaultSelectableChipColors(Painter painter, long j, long j2, long j3, Painter painter2, long j4, long j5, long j6, Painter painter3, long j7, long j8, long j9, Painter painter4, long j10, long j11, long j12) {
        this.selectedBackgroundPainter = painter;
        this.selectedContentColor = j;
        this.selectedSecondaryContentColor = j2;
        this.selectedIconColor = j3;
        this.disabledSelectedBackgroundPainter = painter2;
        this.disabledSelectedContentColor = j4;
        this.disabledSelectedSecondaryContentColor = j5;
        this.disabledSelectedIconColor = j6;
        this.unselectedBackgroundPainter = painter3;
        this.unselectedContentColor = j7;
        this.unselectedSecondaryContentColor = j8;
        this.unselectedIconColor = j9;
        this.disabledUnselectedBackgroundPainter = painter4;
        this.disabledUnselectedContentColor = j10;
        this.disabledUnselectedSecondaryContentColor = j11;
        this.disabledUnselectedIconColor = j12;
    }

    @Override // androidx.wear.compose.material.SelectableChipColors
    public State<Painter> background(boolean z, boolean z2, Composer composer, int i) {
        Painter painter;
        composer.startReplaceGroup(523653989);
        ComposerKt.sourceInformation(composer, "C(background)622@29838L307:SelectableChip.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(523653989, i, -1, "androidx.wear.compose.material.DefaultSelectableChipColors.background (SelectableChip.kt:621)");
        }
        if (z) {
            painter = z2 ? this.selectedBackgroundPainter : this.unselectedBackgroundPainter;
        } else if (z2) {
            painter = this.disabledSelectedBackgroundPainter;
        } else {
            painter = this.disabledUnselectedBackgroundPainter;
        }
        State<Painter> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(painter, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return stateRememberUpdatedState;
    }

    @Override // androidx.wear.compose.material.SelectableChipColors
    public State<Color> contentColor(boolean z, boolean z2, Composer composer, int i) {
        long j;
        composer.startReplaceGroup(-1554998751);
        ComposerKt.sourceInformation(composer, "C(contentColor)634@30267L267:SelectableChip.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1554998751, i, -1, "androidx.wear.compose.material.DefaultSelectableChipColors.contentColor (SelectableChip.kt:633)");
        }
        if (z) {
            j = z2 ? this.selectedContentColor : this.unselectedContentColor;
        } else {
            j = z2 ? this.disabledSelectedContentColor : this.disabledUnselectedContentColor;
        }
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.box-impl(j), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return stateRememberUpdatedState;
    }

    @Override // androidx.wear.compose.material.SelectableChipColors
    public State<Color> secondaryContentColor(boolean z, boolean z2, Composer composer, int i) {
        long j;
        composer.startReplaceGroup(-1777633191);
        ComposerKt.sourceInformation(composer, "C(secondaryContentColor)645@30665L323:SelectableChip.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1777633191, i, -1, "androidx.wear.compose.material.DefaultSelectableChipColors.secondaryContentColor (SelectableChip.kt:644)");
        }
        if (z) {
            j = z2 ? this.selectedSecondaryContentColor : this.unselectedSecondaryContentColor;
        } else if (z2) {
            j = this.disabledSelectedSecondaryContentColor;
        } else {
            j = this.disabledUnselectedSecondaryContentColor;
        }
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.box-impl(j), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return stateRememberUpdatedState;
    }

    @Override // androidx.wear.compose.material.SelectableChipColors
    public State<Color> selectionControlColor(boolean z, boolean z2, Composer composer, int i) {
        long j;
        composer.startReplaceGroup(-278930163);
        ComposerKt.sourceInformation(composer, "C(selectionControlColor)657@31119L255:SelectableChip.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-278930163, i, -1, "androidx.wear.compose.material.DefaultSelectableChipColors.selectionControlColor (SelectableChip.kt:656)");
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

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        DefaultSelectableChipColors defaultSelectableChipColors = (DefaultSelectableChipColors) other;
        return Intrinsics.areEqual(this.selectedBackgroundPainter, defaultSelectableChipColors.selectedBackgroundPainter) && Color.equals-impl0(this.selectedContentColor, defaultSelectableChipColors.selectedContentColor) && Color.equals-impl0(this.selectedIconColor, defaultSelectableChipColors.selectedIconColor) && Color.equals-impl0(this.selectedSecondaryContentColor, defaultSelectableChipColors.selectedSecondaryContentColor) && Intrinsics.areEqual(this.unselectedBackgroundPainter, defaultSelectableChipColors.unselectedBackgroundPainter) && Color.equals-impl0(this.unselectedContentColor, defaultSelectableChipColors.unselectedContentColor) && Color.equals-impl0(this.unselectedIconColor, defaultSelectableChipColors.unselectedIconColor) && Color.equals-impl0(this.unselectedSecondaryContentColor, defaultSelectableChipColors.unselectedSecondaryContentColor) && Intrinsics.areEqual(this.disabledSelectedBackgroundPainter, defaultSelectableChipColors.disabledSelectedBackgroundPainter) && Color.equals-impl0(this.disabledSelectedContentColor, defaultSelectableChipColors.disabledSelectedContentColor) && Color.equals-impl0(this.disabledSelectedIconColor, defaultSelectableChipColors.disabledSelectedIconColor) && Color.equals-impl0(this.disabledSelectedSecondaryContentColor, defaultSelectableChipColors.disabledSelectedSecondaryContentColor) && Intrinsics.areEqual(this.disabledUnselectedBackgroundPainter, defaultSelectableChipColors.disabledUnselectedBackgroundPainter) && Color.equals-impl0(this.disabledUnselectedContentColor, defaultSelectableChipColors.disabledUnselectedContentColor) && Color.equals-impl0(this.disabledUnselectedIconColor, defaultSelectableChipColors.disabledUnselectedIconColor) && Color.equals-impl0(this.disabledUnselectedSecondaryContentColor, defaultSelectableChipColors.disabledUnselectedSecondaryContentColor);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((this.selectedBackgroundPainter.hashCode() * 31) + Color.hashCode-impl(this.selectedContentColor)) * 31) + Color.hashCode-impl(this.selectedSecondaryContentColor)) * 31) + Color.hashCode-impl(this.selectedIconColor)) * 31) + this.unselectedBackgroundPainter.hashCode()) * 31) + Color.hashCode-impl(this.unselectedContentColor)) * 31) + Color.hashCode-impl(this.unselectedSecondaryContentColor)) * 31) + Color.hashCode-impl(this.unselectedIconColor)) * 31) + this.disabledSelectedBackgroundPainter.hashCode()) * 31) + Color.hashCode-impl(this.disabledSelectedContentColor)) * 31) + Color.hashCode-impl(this.disabledSelectedSecondaryContentColor)) * 31) + Color.hashCode-impl(this.disabledSelectedIconColor)) * 31) + this.disabledUnselectedBackgroundPainter.hashCode()) * 31) + Color.hashCode-impl(this.disabledUnselectedContentColor)) * 31) + Color.hashCode-impl(this.disabledUnselectedSecondaryContentColor)) * 31) + Color.hashCode-impl(this.disabledUnselectedIconColor);
    }
}
