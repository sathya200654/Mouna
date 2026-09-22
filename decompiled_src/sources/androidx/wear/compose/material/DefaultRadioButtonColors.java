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
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ#\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0017¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J#\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0017¢\u0006\u0002\u0010\u0012R\u0016\u0010\b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\u0007\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\n\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\t\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Landroidx/wear/compose/material/DefaultRadioButtonColors;", "Landroidx/wear/compose/material/RadioButtonColors;", "selectedRingColor", "Landroidx/compose/ui/graphics/Color;", "selectedDotColor", "unselectedRingColor", "unselectedDotColor", "disabledSelectedRingColor", "disabledSelectedDotColor", "disabledUnselectedRingColor", "disabledUnselectedDotColor", "(JJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "dotColor", "Landroidx/compose/runtime/State;", "enabled", "", "selected", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "", "hashCode", "", "ringColor", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DefaultRadioButtonColors implements RadioButtonColors {
    private final long disabledSelectedDotColor;
    private final long disabledSelectedRingColor;
    private final long disabledUnselectedDotColor;
    private final long disabledUnselectedRingColor;
    private final long selectedDotColor;
    private final long selectedRingColor;
    private final long unselectedDotColor;
    private final long unselectedRingColor;

    public /* synthetic */ DefaultRadioButtonColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8);
    }

    private DefaultRadioButtonColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8) {
        this.selectedRingColor = j;
        this.selectedDotColor = j2;
        this.unselectedRingColor = j3;
        this.unselectedDotColor = j4;
        this.disabledSelectedRingColor = j5;
        this.disabledSelectedDotColor = j6;
        this.disabledUnselectedRingColor = j7;
        this.disabledUnselectedDotColor = j8;
    }

    @Override // androidx.wear.compose.material.RadioButtonColors
    public State<Color> ringColor(boolean z, boolean z2, Composer composer, int i) {
        composer.startReplaceGroup(669097718);
        ComposerKt.sourceInformation(composer, "C(ringColor)613@24539L368:ToggleControl.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(669097718, i, -1, "androidx.wear.compose.material.DefaultRadioButtonColors.ringColor (ToggleControl.kt:613)");
        }
        State<Color> stateM920animateSelectionColorNghDbR4 = SelectionControlsKt.m920animateSelectionColorNghDbR4(z, z2, this.selectedRingColor, this.unselectedRingColor, this.disabledSelectedRingColor, this.disabledUnselectedRingColor, ToggleControlKt.COLOR_ANIMATION_SPEC, composer, i & 126);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return stateM920animateSelectionColorNghDbR4;
    }

    @Override // androidx.wear.compose.material.RadioButtonColors
    public State<Color> dotColor(boolean z, boolean z2, Composer composer, int i) {
        composer.startReplaceGroup(1288992153);
        ComposerKt.sourceInformation(composer, "C(dotColor)625@25012L364:ToggleControl.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1288992153, i, -1, "androidx.wear.compose.material.DefaultRadioButtonColors.dotColor (ToggleControl.kt:625)");
        }
        State<Color> stateM920animateSelectionColorNghDbR4 = SelectionControlsKt.m920animateSelectionColorNghDbR4(z, z2, this.selectedDotColor, this.unselectedDotColor, this.disabledSelectedDotColor, this.disabledUnselectedDotColor, ToggleControlKt.COLOR_ANIMATION_SPEC, composer, i & 126);
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
        DefaultRadioButtonColors defaultRadioButtonColors = (DefaultRadioButtonColors) other;
        return Color.equals-impl0(this.selectedRingColor, defaultRadioButtonColors.selectedRingColor) && Color.equals-impl0(this.selectedDotColor, defaultRadioButtonColors.selectedDotColor) && Color.equals-impl0(this.unselectedRingColor, defaultRadioButtonColors.unselectedRingColor) && Color.equals-impl0(this.unselectedDotColor, defaultRadioButtonColors.unselectedDotColor) && Color.equals-impl0(this.disabledSelectedRingColor, defaultRadioButtonColors.disabledSelectedRingColor) && Color.equals-impl0(this.disabledSelectedDotColor, defaultRadioButtonColors.disabledSelectedDotColor) && Color.equals-impl0(this.disabledUnselectedRingColor, defaultRadioButtonColors.disabledUnselectedRingColor) && Color.equals-impl0(this.disabledUnselectedDotColor, defaultRadioButtonColors.disabledUnselectedDotColor);
    }

    public int hashCode() {
        return (((((((((((((Color.hashCode-impl(this.selectedRingColor) * 31) + Color.hashCode-impl(this.selectedDotColor)) * 31) + Color.hashCode-impl(this.unselectedRingColor)) * 31) + Color.hashCode-impl(this.unselectedDotColor)) * 31) + Color.hashCode-impl(this.disabledSelectedRingColor)) * 31) + Color.hashCode-impl(this.disabledSelectedDotColor)) * 31) + Color.hashCode-impl(this.disabledUnselectedRingColor)) * 31) + Color.hashCode-impl(this.disabledUnselectedDotColor);
    }
}
