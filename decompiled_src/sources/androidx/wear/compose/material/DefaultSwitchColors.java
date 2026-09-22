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
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J#\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000eH\u0017¢\u0006\u0002\u0010\u0017J#\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000eH\u0017¢\u0006\u0002\u0010\u0017R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\u0007\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\t\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\n\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Landroidx/wear/compose/material/DefaultSwitchColors;", "Landroidx/wear/compose/material/SwitchColors;", "checkedThumbColor", "Landroidx/compose/ui/graphics/Color;", "checkedTrackColor", "uncheckedThumbColor", "uncheckedTrackColor", "disabledCheckedThumbColor", "disabledCheckedTrackColor", "disabledUncheckedThumbColor", "disabledUncheckedTrackColor", "(JJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "equals", "", "other", "", "hashCode", "", "thumbColor", "Landroidx/compose/runtime/State;", "enabled", "checked", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "trackColor", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DefaultSwitchColors implements SwitchColors {
    private final long checkedThumbColor;
    private final long checkedTrackColor;
    private final long disabledCheckedThumbColor;
    private final long disabledCheckedTrackColor;
    private final long disabledUncheckedThumbColor;
    private final long disabledUncheckedTrackColor;
    private final long uncheckedThumbColor;
    private final long uncheckedTrackColor;

    public /* synthetic */ DefaultSwitchColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8);
    }

    private DefaultSwitchColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8) {
        this.checkedThumbColor = j;
        this.checkedTrackColor = j2;
        this.uncheckedThumbColor = j3;
        this.uncheckedTrackColor = j4;
        this.disabledCheckedThumbColor = j5;
        this.disabledCheckedTrackColor = j6;
        this.disabledUncheckedThumbColor = j7;
        this.disabledUncheckedTrackColor = j8;
    }

    @Override // androidx.wear.compose.material.SwitchColors
    public State<Color> thumbColor(boolean z, boolean z2, Composer composer, int i) {
        composer.startReplaceGroup(-177917459);
        ComposerKt.sourceInformation(composer, "C(thumbColor)P(1)543@21623L367:ToggleControl.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-177917459, i, -1, "androidx.wear.compose.material.DefaultSwitchColors.thumbColor (ToggleControl.kt:543)");
        }
        State<Color> stateM920animateSelectionColorNghDbR4 = SelectionControlsKt.m920animateSelectionColorNghDbR4(z, z2, this.checkedThumbColor, this.uncheckedThumbColor, this.disabledCheckedThumbColor, this.disabledUncheckedThumbColor, ToggleControlKt.COLOR_ANIMATION_SPEC, composer, i & 126);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return stateM920animateSelectionColorNghDbR4;
    }

    @Override // androidx.wear.compose.material.SwitchColors
    public State<Color> trackColor(boolean z, boolean z2, Composer composer, int i) {
        composer.startReplaceGroup(-29981534);
        ComposerKt.sourceInformation(composer, "C(trackColor)P(1)555@22096L367:ToggleControl.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-29981534, i, -1, "androidx.wear.compose.material.DefaultSwitchColors.trackColor (ToggleControl.kt:555)");
        }
        State<Color> stateM920animateSelectionColorNghDbR4 = SelectionControlsKt.m920animateSelectionColorNghDbR4(z, z2, this.checkedTrackColor, this.uncheckedTrackColor, this.disabledCheckedTrackColor, this.disabledUncheckedTrackColor, ToggleControlKt.COLOR_ANIMATION_SPEC, composer, i & 126);
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
        DefaultSwitchColors defaultSwitchColors = (DefaultSwitchColors) other;
        return Color.equals-impl0(this.checkedThumbColor, defaultSwitchColors.checkedThumbColor) && Color.equals-impl0(this.checkedTrackColor, defaultSwitchColors.checkedTrackColor) && Color.equals-impl0(this.uncheckedThumbColor, defaultSwitchColors.uncheckedThumbColor) && Color.equals-impl0(this.uncheckedTrackColor, defaultSwitchColors.uncheckedTrackColor) && Color.equals-impl0(this.disabledCheckedThumbColor, defaultSwitchColors.disabledCheckedThumbColor) && Color.equals-impl0(this.disabledCheckedTrackColor, defaultSwitchColors.disabledCheckedTrackColor) && Color.equals-impl0(this.disabledUncheckedThumbColor, defaultSwitchColors.disabledUncheckedThumbColor) && Color.equals-impl0(this.disabledUncheckedTrackColor, defaultSwitchColors.disabledUncheckedTrackColor);
    }

    public int hashCode() {
        return (((((((((((((Color.hashCode-impl(this.checkedThumbColor) * 31) + Color.hashCode-impl(this.checkedTrackColor)) * 31) + Color.hashCode-impl(this.uncheckedThumbColor)) * 31) + Color.hashCode-impl(this.uncheckedTrackColor)) * 31) + Color.hashCode-impl(this.disabledCheckedThumbColor)) * 31) + Color.hashCode-impl(this.disabledCheckedTrackColor)) * 31) + Color.hashCode-impl(this.disabledUncheckedThumbColor)) * 31) + Color.hashCode-impl(this.disabledUncheckedTrackColor);
    }
}
