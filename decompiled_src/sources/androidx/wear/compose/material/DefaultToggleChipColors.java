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

/* JADX INFO: compiled from: ToggleChip.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005¢\u0006\u0002\u0010\u0014J#\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0017¢\u0006\u0002\u0010\u001bJ#\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0017¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001d\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0096\u0002J\b\u0010 \u001a\u00020!H\u0016J#\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0017¢\u0006\u0002\u0010\u001bJ#\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0017¢\u0006\u0002\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0015R\u0016\u0010\u0007\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0015R\u0016\u0010\u0006\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0015R\u0016\u0010\u000b\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0015R\u0016\u0010\n\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0010\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0015R\u0016\u0010\u0013\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0015R\u0016\u0010\u0012\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0015R\u0016\u0010\u000f\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0015R\u0016\u0010\u000e\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0015\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006$"}, d2 = {"Landroidx/wear/compose/material/DefaultToggleChipColors;", "Landroidx/wear/compose/material/ToggleChipColors;", "checkedBackgroundPainter", "Landroidx/compose/ui/graphics/painter/Painter;", "checkedContentColor", "Landroidx/compose/ui/graphics/Color;", "checkedSecondaryContentColor", "checkedIconColor", "disabledCheckedBackgroundPainter", "disabledCheckedContentColor", "disabledCheckedSecondaryContentColor", "disabledCheckedIconColor", "uncheckedBackgroundPainter", "uncheckedContentColor", "uncheckedSecondaryContentColor", "uncheckedIconColor", "disabledUncheckedBackgroundPainter", "disabledUncheckedContentColor", "disabledUncheckedSecondaryContentColor", "disabledUncheckedIconColor", "(Landroidx/compose/ui/graphics/painter/Painter;JJJLandroidx/compose/ui/graphics/painter/Painter;JJJLandroidx/compose/ui/graphics/painter/Painter;JJJLandroidx/compose/ui/graphics/painter/Painter;JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "background", "Landroidx/compose/runtime/State;", "enabled", "", "checked", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "contentColor", "equals", "other", "", "hashCode", "", "secondaryContentColor", "toggleControlColor", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DefaultToggleChipColors implements ToggleChipColors {
    private final Painter checkedBackgroundPainter;
    private final long checkedContentColor;
    private final long checkedIconColor;
    private final long checkedSecondaryContentColor;
    private final Painter disabledCheckedBackgroundPainter;
    private final long disabledCheckedContentColor;
    private final long disabledCheckedIconColor;
    private final long disabledCheckedSecondaryContentColor;
    private final Painter disabledUncheckedBackgroundPainter;
    private final long disabledUncheckedContentColor;
    private final long disabledUncheckedIconColor;
    private final long disabledUncheckedSecondaryContentColor;
    private final Painter uncheckedBackgroundPainter;
    private final long uncheckedContentColor;
    private final long uncheckedIconColor;
    private final long uncheckedSecondaryContentColor;

    public /* synthetic */ DefaultToggleChipColors(Painter painter, long j, long j2, long j3, Painter painter2, long j4, long j5, long j6, Painter painter3, long j7, long j8, long j9, Painter painter4, long j10, long j11, long j12, DefaultConstructorMarker defaultConstructorMarker) {
        this(painter, j, j2, j3, painter2, j4, j5, j6, painter3, j7, j8, j9, painter4, j10, j11, j12);
    }

    private DefaultToggleChipColors(Painter painter, long j, long j2, long j3, Painter painter2, long j4, long j5, long j6, Painter painter3, long j7, long j8, long j9, Painter painter4, long j10, long j11, long j12) {
        this.checkedBackgroundPainter = painter;
        this.checkedContentColor = j;
        this.checkedSecondaryContentColor = j2;
        this.checkedIconColor = j3;
        this.disabledCheckedBackgroundPainter = painter2;
        this.disabledCheckedContentColor = j4;
        this.disabledCheckedSecondaryContentColor = j5;
        this.disabledCheckedIconColor = j6;
        this.uncheckedBackgroundPainter = painter3;
        this.uncheckedContentColor = j7;
        this.uncheckedSecondaryContentColor = j8;
        this.uncheckedIconColor = j9;
        this.disabledUncheckedBackgroundPainter = painter4;
        this.disabledUncheckedContentColor = j10;
        this.disabledUncheckedSecondaryContentColor = j11;
        this.disabledUncheckedIconColor = j12;
    }

    @Override // androidx.wear.compose.material.ToggleChipColors
    public State<Painter> background(boolean z, boolean z2, Composer composer, int i) {
        Painter painter;
        composer.startReplaceGroup(1892317221);
        ComposerKt.sourceInformation(composer, "C(background)P(1)858@38891L301:ToggleChip.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1892317221, i, -1, "androidx.wear.compose.material.DefaultToggleChipColors.background (ToggleChip.kt:857)");
        }
        if (z) {
            painter = z2 ? this.checkedBackgroundPainter : this.uncheckedBackgroundPainter;
        } else if (z2) {
            painter = this.disabledCheckedBackgroundPainter;
        } else {
            painter = this.disabledUncheckedBackgroundPainter;
        }
        State<Painter> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(painter, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return stateRememberUpdatedState;
    }

    @Override // androidx.wear.compose.material.ToggleChipColors
    public State<Color> contentColor(boolean z, boolean z2, Composer composer, int i) {
        long j;
        composer.startReplaceGroup(-1870316831);
        ComposerKt.sourceInformation(composer, "C(contentColor)P(1)870@39313L261:ToggleChip.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1870316831, i, -1, "androidx.wear.compose.material.DefaultToggleChipColors.contentColor (ToggleChip.kt:869)");
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

    @Override // androidx.wear.compose.material.ToggleChipColors
    public State<Color> secondaryContentColor(boolean z, boolean z2, Composer composer, int i) {
        long j;
        composer.startReplaceGroup(859689241);
        ComposerKt.sourceInformation(composer, "C(secondaryContentColor)P(1)881@39704L317:ToggleChip.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(859689241, i, -1, "androidx.wear.compose.material.DefaultToggleChipColors.secondaryContentColor (ToggleChip.kt:880)");
        }
        if (z) {
            j = z2 ? this.checkedSecondaryContentColor : this.uncheckedSecondaryContentColor;
        } else if (z2) {
            j = this.disabledCheckedSecondaryContentColor;
        } else {
            j = this.disabledUncheckedSecondaryContentColor;
        }
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.box-impl(j), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return stateRememberUpdatedState;
    }

    @Override // androidx.wear.compose.material.ToggleChipColors
    public State<Color> toggleControlColor(boolean z, boolean z2, Composer composer, int i) {
        long j;
        composer.startReplaceGroup(1895928689);
        ComposerKt.sourceInformation(composer, "C(toggleControlColor)P(1)893@40148L249:ToggleChip.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1895928689, i, -1, "androidx.wear.compose.material.DefaultToggleChipColors.toggleControlColor (ToggleChip.kt:892)");
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

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        DefaultToggleChipColors defaultToggleChipColors = (DefaultToggleChipColors) other;
        return Intrinsics.areEqual(this.checkedBackgroundPainter, defaultToggleChipColors.checkedBackgroundPainter) && Color.equals-impl0(this.checkedContentColor, defaultToggleChipColors.checkedContentColor) && Color.equals-impl0(this.checkedIconColor, defaultToggleChipColors.checkedIconColor) && Color.equals-impl0(this.checkedSecondaryContentColor, defaultToggleChipColors.checkedSecondaryContentColor) && Intrinsics.areEqual(this.uncheckedBackgroundPainter, defaultToggleChipColors.uncheckedBackgroundPainter) && Color.equals-impl0(this.uncheckedContentColor, defaultToggleChipColors.uncheckedContentColor) && Color.equals-impl0(this.uncheckedIconColor, defaultToggleChipColors.uncheckedIconColor) && Color.equals-impl0(this.uncheckedSecondaryContentColor, defaultToggleChipColors.uncheckedSecondaryContentColor) && Intrinsics.areEqual(this.disabledCheckedBackgroundPainter, defaultToggleChipColors.disabledCheckedBackgroundPainter) && Color.equals-impl0(this.disabledCheckedContentColor, defaultToggleChipColors.disabledCheckedContentColor) && Color.equals-impl0(this.disabledCheckedIconColor, defaultToggleChipColors.disabledCheckedIconColor) && Color.equals-impl0(this.disabledCheckedSecondaryContentColor, defaultToggleChipColors.disabledCheckedSecondaryContentColor) && Intrinsics.areEqual(this.disabledUncheckedBackgroundPainter, defaultToggleChipColors.disabledUncheckedBackgroundPainter) && Color.equals-impl0(this.disabledUncheckedContentColor, defaultToggleChipColors.disabledUncheckedContentColor) && Color.equals-impl0(this.disabledUncheckedIconColor, defaultToggleChipColors.disabledUncheckedIconColor) && Color.equals-impl0(this.disabledUncheckedSecondaryContentColor, defaultToggleChipColors.disabledUncheckedSecondaryContentColor);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((this.checkedBackgroundPainter.hashCode() * 31) + Color.hashCode-impl(this.checkedContentColor)) * 31) + Color.hashCode-impl(this.checkedSecondaryContentColor)) * 31) + Color.hashCode-impl(this.checkedIconColor)) * 31) + this.uncheckedBackgroundPainter.hashCode()) * 31) + Color.hashCode-impl(this.uncheckedContentColor)) * 31) + Color.hashCode-impl(this.uncheckedSecondaryContentColor)) * 31) + Color.hashCode-impl(this.uncheckedIconColor)) * 31) + this.disabledCheckedBackgroundPainter.hashCode()) * 31) + Color.hashCode-impl(this.disabledCheckedContentColor)) * 31) + Color.hashCode-impl(this.disabledCheckedSecondaryContentColor)) * 31) + Color.hashCode-impl(this.disabledCheckedIconColor)) * 31) + this.disabledUncheckedBackgroundPainter.hashCode()) * 31) + Color.hashCode-impl(this.disabledUncheckedContentColor)) * 31) + Color.hashCode-impl(this.disabledUncheckedSecondaryContentColor)) * 31) + Color.hashCode-impl(this.disabledUncheckedIconColor);
    }
}
