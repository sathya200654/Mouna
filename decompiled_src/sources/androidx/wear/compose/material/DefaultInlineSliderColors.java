package androidx.wear.compose.material;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Slider.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\u001b\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0017¢\u0006\u0002\u0010\u0010J#\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0017¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u001b\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0017¢\u0006\u0002\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\u0007\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\t\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\n\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Landroidx/wear/compose/material/DefaultInlineSliderColors;", "Landroidx/wear/compose/material/InlineSliderColors;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "spacerColor", "selectedBarColor", "unselectedBarColor", "disabledBackgroundColor", "disabledSpacerColor", "disabledSelectedBarColor", "disabledUnselectedBarColor", "(JJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "Landroidx/compose/runtime/State;", "enabled", "", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "barColor", "selected", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "", "hashCode", "", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DefaultInlineSliderColors implements InlineSliderColors {
    private final long backgroundColor;
    private final long disabledBackgroundColor;
    private final long disabledSelectedBarColor;
    private final long disabledSpacerColor;
    private final long disabledUnselectedBarColor;
    private final long selectedBarColor;
    private final long spacerColor;
    private final long unselectedBarColor;

    public /* synthetic */ DefaultInlineSliderColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8);
    }

    private DefaultInlineSliderColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8) {
        this.backgroundColor = j;
        this.spacerColor = j2;
        this.selectedBarColor = j3;
        this.unselectedBarColor = j4;
        this.disabledBackgroundColor = j5;
        this.disabledSpacerColor = j6;
        this.disabledSelectedBarColor = j7;
        this.disabledUnselectedBarColor = j8;
    }

    @Override // androidx.wear.compose.material.InlineSliderColors
    public State<Color> backgroundColor(boolean z, Composer composer, int i) {
        composer.startReplaceGroup(1051709485);
        ComposerKt.sourceInformation(composer, "C(backgroundColor)394@16957L78:Slider.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1051709485, i, -1, "androidx.wear.compose.material.DefaultInlineSliderColors.backgroundColor (Slider.kt:394)");
        }
        State<Color> state = SingleValueAnimationKt.animateColorAsState-euL9pac(z ? this.backgroundColor : this.disabledBackgroundColor, (AnimationSpec) null, (String) null, (Function1) null, composer, 0, 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return state;
    }

    @Override // androidx.wear.compose.material.InlineSliderColors
    public State<Color> spacerColor(boolean z, Composer composer, int i) {
        composer.startReplaceGroup(-834718481);
        ComposerKt.sourceInformation(composer, "C(spacerColor)398@17124L92:Slider.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-834718481, i, -1, "androidx.wear.compose.material.DefaultInlineSliderColors.spacerColor (Slider.kt:398)");
        }
        State<Color> state = SingleValueAnimationKt.animateColorAsState-euL9pac(z ? this.spacerColor : this.disabledSpacerColor, (AnimationSpec) null, (String) null, (Function1) null, composer, 0, 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return state;
    }

    @Override // androidx.wear.compose.material.InlineSliderColors
    public State<Color> barColor(boolean z, boolean z2, Composer composer, int i) {
        long j;
        composer.startReplaceGroup(-1933964896);
        ComposerKt.sourceInformation(composer, "C(barColor)404@17321L250:Slider.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1933964896, i, -1, "androidx.wear.compose.material.DefaultInlineSliderColors.barColor (Slider.kt:404)");
        }
        if (z) {
            j = z2 ? this.selectedBarColor : this.unselectedBarColor;
        } else {
            j = z2 ? this.disabledSelectedBarColor : this.disabledUnselectedBarColor;
        }
        State<Color> state = SingleValueAnimationKt.animateColorAsState-euL9pac(j, (AnimationSpec) null, (String) null, (Function1) null, composer, 0, 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return state;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        DefaultInlineSliderColors defaultInlineSliderColors = (DefaultInlineSliderColors) other;
        return Color.equals-impl0(this.backgroundColor, defaultInlineSliderColors.backgroundColor) && Color.equals-impl0(this.spacerColor, defaultInlineSliderColors.spacerColor) && Color.equals-impl0(this.selectedBarColor, defaultInlineSliderColors.selectedBarColor) && Color.equals-impl0(this.unselectedBarColor, defaultInlineSliderColors.unselectedBarColor) && Color.equals-impl0(this.disabledBackgroundColor, defaultInlineSliderColors.disabledBackgroundColor) && Color.equals-impl0(this.disabledSpacerColor, defaultInlineSliderColors.disabledSpacerColor) && Color.equals-impl0(this.disabledSelectedBarColor, defaultInlineSliderColors.disabledSelectedBarColor) && Color.equals-impl0(this.disabledUnselectedBarColor, defaultInlineSliderColors.disabledUnselectedBarColor);
    }

    public int hashCode() {
        return (((((((((((((Color.hashCode-impl(this.backgroundColor) * 31) + Color.hashCode-impl(this.spacerColor)) * 31) + Color.hashCode-impl(this.selectedBarColor)) * 31) + Color.hashCode-impl(this.unselectedBarColor)) * 31) + Color.hashCode-impl(this.disabledBackgroundColor)) * 31) + Color.hashCode-impl(this.disabledSpacerColor)) * 31) + Color.hashCode-impl(this.disabledSelectedBarColor)) * 31) + Color.hashCode-impl(this.disabledUnselectedBarColor);
    }
}
