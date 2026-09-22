package androidx.wear.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.ColorPainter;
import androidx.compose.ui.graphics.painter.Painter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Chip.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0001\u0018\u00002\u00020\u0001BG\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bBE\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000fJ\u001b\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0017¢\u0006\u0002\u0010\u0015J\u001b\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0017¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0017¢\u0006\u0002\u0010\u0015J\u001b\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0017¢\u0006\u0002\u0010\u0015R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0010R\u0016\u0010\n\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0010R\u0016\u0010\t\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0010\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001b"}, d2 = {"Landroidx/wear/compose/material/DefaultChipColors;", "Landroidx/wear/compose/material/ChipColors;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "secondaryContentColor", "iconColor", "disabledBackgroundColor", "disabledContentColor", "disabledSecondaryContentColor", "disabledIconColor", "(JJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "backgroundPainter", "Landroidx/compose/ui/graphics/painter/Painter;", "disabledBackgroundPainter", "(Landroidx/compose/ui/graphics/painter/Painter;JJJLandroidx/compose/ui/graphics/painter/Painter;JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "background", "Landroidx/compose/runtime/State;", "enabled", "", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "", "hashCode", "", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultChipColors implements ChipColors {
    public static final int $stable = 0;
    private final Painter backgroundPainter;
    private final long contentColor;
    private final Painter disabledBackgroundPainter;
    private final long disabledContentColor;
    private final long disabledIconColor;
    private final long disabledSecondaryContentColor;
    private final long iconColor;
    private final long secondaryContentColor;

    public /* synthetic */ DefaultChipColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8);
    }

    public /* synthetic */ DefaultChipColors(Painter painter, long j, long j2, long j3, Painter painter2, long j4, long j5, long j6, DefaultConstructorMarker defaultConstructorMarker) {
        this(painter, j, j2, j3, painter2, j4, j5, j6);
    }

    private DefaultChipColors(Painter painter, long j, long j2, long j3, Painter painter2, long j4, long j5, long j6) {
        this.backgroundPainter = painter;
        this.contentColor = j;
        this.secondaryContentColor = j2;
        this.iconColor = j3;
        this.disabledBackgroundPainter = painter2;
        this.disabledContentColor = j4;
        this.disabledSecondaryContentColor = j5;
        this.disabledIconColor = j6;
    }

    private DefaultChipColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8) {
        this(new ColorPainter(j, (DefaultConstructorMarker) null), j2, j3, j4, new ColorPainter(j5, (DefaultConstructorMarker) null), j6, j7, j8, (DefaultConstructorMarker) null);
    }

    @Override // androidx.wear.compose.material.ChipColors
    public State<Painter> background(boolean z, Composer composer, int i) {
        composer.startReplaceGroup(-326196599);
        ComposerKt.sourceInformation(composer, "C(background)1300@59905L105:Chip.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-326196599, i, -1, "androidx.wear.compose.material.DefaultChipColors.background (Chip.kt:1299)");
        }
        State<Painter> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(z ? this.backgroundPainter : this.disabledBackgroundPainter, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return stateRememberUpdatedState;
    }

    @Override // androidx.wear.compose.material.ChipColors
    public State<Color> contentColor(boolean z, Composer composer, int i) {
        composer.startReplaceGroup(-169796795);
        ComposerKt.sourceInformation(composer, "C(contentColor)1307@60113L95:Chip.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-169796795, i, -1, "androidx.wear.compose.material.DefaultChipColors.contentColor (Chip.kt:1306)");
        }
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.box-impl(z ? this.contentColor : this.disabledContentColor), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return stateRememberUpdatedState;
    }

    @Override // androidx.wear.compose.material.ChipColors
    public State<Color> secondaryContentColor(boolean z, Composer composer, int i) {
        composer.startReplaceGroup(401145213);
        ComposerKt.sourceInformation(composer, "C(secondaryContentColor)1314@60320L113:Chip.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(401145213, i, -1, "androidx.wear.compose.material.DefaultChipColors.secondaryContentColor (Chip.kt:1313)");
        }
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.box-impl(z ? this.secondaryContentColor : this.disabledSecondaryContentColor), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return stateRememberUpdatedState;
    }

    @Override // androidx.wear.compose.material.ChipColors
    public State<Color> iconColor(boolean z, Composer composer, int i) {
        composer.startReplaceGroup(1511522281);
        ComposerKt.sourceInformation(composer, "C(iconColor)1321@60533L67:Chip.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1511522281, i, -1, "androidx.wear.compose.material.DefaultChipColors.iconColor (Chip.kt:1320)");
        }
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.box-impl(z ? this.iconColor : this.disabledIconColor), composer, 0);
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
        DefaultChipColors defaultChipColors = (DefaultChipColors) other;
        return Intrinsics.areEqual(this.backgroundPainter, defaultChipColors.backgroundPainter) && Color.equals-impl0(this.contentColor, defaultChipColors.contentColor) && Color.equals-impl0(this.secondaryContentColor, defaultChipColors.secondaryContentColor) && Color.equals-impl0(this.iconColor, defaultChipColors.iconColor) && Intrinsics.areEqual(this.disabledBackgroundPainter, defaultChipColors.disabledBackgroundPainter) && Color.equals-impl0(this.disabledContentColor, defaultChipColors.disabledContentColor) && Color.equals-impl0(this.disabledSecondaryContentColor, defaultChipColors.disabledSecondaryContentColor) && Color.equals-impl0(this.disabledIconColor, defaultChipColors.disabledIconColor);
    }

    public int hashCode() {
        return (((((((((((((this.backgroundPainter.hashCode() * 31) + Color.hashCode-impl(this.contentColor)) * 31) + Color.hashCode-impl(this.secondaryContentColor)) * 31) + Color.hashCode-impl(this.iconColor)) * 31) + this.disabledBackgroundPainter.hashCode()) * 31) + Color.hashCode-impl(this.disabledContentColor)) * 31) + Color.hashCode-impl(this.disabledSecondaryContentColor)) * 31) + Color.hashCode-impl(this.disabledIconColor);
    }
}
