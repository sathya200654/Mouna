package androidx.wear.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.wear.compose.materialcore.SelectionControlsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ToggleControl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ#\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0017¢\u0006\u0002\u0010\u0012J#\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0017¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0014\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\u0007\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\t\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\n\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Landroidx/wear/compose/material/DefaultCheckboxColors;", "Landroidx/wear/compose/material/CheckboxColors;", "checkedBoxColor", "Landroidx/compose/ui/graphics/Color;", "checkedCheckmarkColor", "uncheckedCheckmarkColor", "uncheckedBoxColor", "disabledCheckedBoxColor", "disabledCheckedCheckmarkColor", "disabledUncheckedBoxColor", "disabledUncheckedCheckmarkColor", "(JJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "boxColor", "Landroidx/compose/runtime/State;", "enabled", "", "checked", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "checkmarkColor", "equals", "other", "", "hashCode", "", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DefaultCheckboxColors implements CheckboxColors {
    private final long checkedBoxColor;
    private final long checkedCheckmarkColor;
    private final long disabledCheckedBoxColor;
    private final long disabledCheckedCheckmarkColor;
    private final long disabledUncheckedBoxColor;
    private final long disabledUncheckedCheckmarkColor;
    private final long uncheckedBoxColor;
    private final long uncheckedCheckmarkColor;

    public /* synthetic */ DefaultCheckboxColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8);
    }

    private DefaultCheckboxColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8) {
        this.checkedBoxColor = j;
        this.checkedCheckmarkColor = j2;
        this.uncheckedCheckmarkColor = j3;
        this.uncheckedBoxColor = j4;
        this.disabledCheckedBoxColor = j5;
        this.disabledCheckedCheckmarkColor = j6;
        this.disabledUncheckedBoxColor = j7;
        this.disabledUncheckedCheckmarkColor = j8;
    }

    @Override // androidx.wear.compose.material.CheckboxColors
    public State<Color> boxColor(boolean z, boolean z2, Composer composer, int i) {
        composer.startReplaceGroup(2078036211);
        ComposerKt.sourceInformation(composer, "C(boxColor)P(1)473@18675L359:ToggleControl.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2078036211, i, -1, "androidx.wear.compose.material.DefaultCheckboxColors.boxColor (ToggleControl.kt:473)");
        }
        State<Color> stateM920animateSelectionColorNghDbR4 = SelectionControlsKt.m920animateSelectionColorNghDbR4(z, z2, this.checkedBoxColor, this.uncheckedBoxColor, this.disabledCheckedBoxColor, this.disabledUncheckedBoxColor, ToggleControlKt.COLOR_ANIMATION_SPEC, composer, i & 126);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return stateM920animateSelectionColorNghDbR4;
    }

    @Override // androidx.wear.compose.material.CheckboxColors
    public State<Color> checkmarkColor(boolean z, boolean z2, Composer composer, int i) {
        composer.startReplaceGroup(-1385078403);
        ComposerKt.sourceInformation(composer, "C(checkmarkColor)P(1)485@19144L383:ToggleControl.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1385078403, i, -1, "androidx.wear.compose.material.DefaultCheckboxColors.checkmarkColor (ToggleControl.kt:485)");
        }
        State<Color> stateM920animateSelectionColorNghDbR4 = SelectionControlsKt.m920animateSelectionColorNghDbR4(z, z2, this.checkedCheckmarkColor, this.uncheckedCheckmarkColor, this.disabledCheckedCheckmarkColor, this.disabledUncheckedCheckmarkColor, ToggleControlKt.COLOR_ANIMATION_SPEC, composer, i & 126);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return stateM920animateSelectionColorNghDbR4;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        DefaultCheckboxColors defaultCheckboxColors = (DefaultCheckboxColors) other;
        return Color.equals-impl0(this.checkedBoxColor, defaultCheckboxColors.checkedBoxColor) && Color.equals-impl0(this.checkedCheckmarkColor, defaultCheckboxColors.checkedCheckmarkColor) && Color.equals-impl0(this.uncheckedCheckmarkColor, defaultCheckboxColors.uncheckedCheckmarkColor) && Color.equals-impl0(this.uncheckedBoxColor, defaultCheckboxColors.uncheckedBoxColor) && Color.equals-impl0(this.disabledCheckedBoxColor, defaultCheckboxColors.disabledCheckedBoxColor) && Color.equals-impl0(this.disabledCheckedCheckmarkColor, defaultCheckboxColors.disabledCheckedCheckmarkColor) && Color.equals-impl0(this.disabledUncheckedBoxColor, defaultCheckboxColors.disabledUncheckedBoxColor) && Color.equals-impl0(this.disabledUncheckedCheckmarkColor, defaultCheckboxColors.disabledUncheckedCheckmarkColor);
    }

    public int hashCode() {
        return (((((((((((((Color.hashCode-impl(this.checkedBoxColor) * 31) + Color.hashCode-impl(this.checkedCheckmarkColor)) * 31) + Color.hashCode-impl(this.uncheckedCheckmarkColor)) * 31) + Color.hashCode-impl(this.uncheckedBoxColor)) * 31) + Color.hashCode-impl(this.disabledCheckedBoxColor)) * 31) + Color.hashCode-impl(this.disabledCheckedCheckmarkColor)) * 31) + Color.hashCode-impl(this.disabledUncheckedBoxColor)) * 31) + Color.hashCode-impl(this.disabledUncheckedCheckmarkColor);
    }
}
