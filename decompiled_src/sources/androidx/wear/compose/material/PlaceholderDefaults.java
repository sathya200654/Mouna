package androidx.wear.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import kotlin.Metadata;

/* JADX INFO: compiled from: Placeholder.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ$\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ,\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0016"}, d2 = {"Landroidx/wear/compose/material/PlaceholderDefaults;", "", "()V", "painterWithPlaceholderOverlayBackgroundBrush", "Landroidx/compose/ui/graphics/painter/Painter;", "placeholderState", "Landroidx/wear/compose/material/PlaceholderState;", "painter", "color", "Landroidx/compose/ui/graphics/Color;", "painterWithPlaceholderOverlayBackgroundBrush-FNF3uiM", "(Landroidx/wear/compose/material/PlaceholderState;Landroidx/compose/ui/graphics/painter/Painter;JLandroidx/compose/runtime/Composer;II)Landroidx/compose/ui/graphics/painter/Painter;", "placeholderBackgroundBrush", "placeholderBackgroundBrush-iJQMabo", "(Landroidx/wear/compose/material/PlaceholderState;JLandroidx/compose/runtime/Composer;II)Landroidx/compose/ui/graphics/painter/Painter;", "placeholderChipColors", "Landroidx/wear/compose/material/ChipColors;", "originalChipColors", "placeholderChipColors-FNF3uiM", "(Landroidx/wear/compose/material/ChipColors;Landroidx/wear/compose/material/PlaceholderState;JLandroidx/compose/runtime/Composer;II)Landroidx/wear/compose/material/ChipColors;", "placeholderChipColors-iJQMabo", "(Landroidx/wear/compose/material/PlaceholderState;JLandroidx/compose/runtime/Composer;II)Landroidx/wear/compose/material/ChipColors;", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PlaceholderDefaults {
    public static final int $stable = 0;
    public static final PlaceholderDefaults INSTANCE = new PlaceholderDefaults();

    private PlaceholderDefaults() {
    }

    /* JADX INFO: renamed from: placeholderChipColors-FNF3uiM, reason: not valid java name */
    public final ChipColors m660placeholderChipColorsFNF3uiM(ChipColors chipColors, PlaceholderState placeholderState, long j, Composer composer, int i, int i2) {
        ChipColors chipColorsM533chipColors_rQONyM = chipColors;
        ComposerKt.sourceInformationMarkerStart(composer, 1860505179, "C(placeholderChipColors)P(1,2,0:c#ui.graphics.Color)509@23554L6:Placeholder.kt#gj9v0t");
        long surface = (i2 & 4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getSurface() : j;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1860505179, i, -1, "androidx.wear.compose.material.PlaceholderDefaults.placeholderChipColors (Placeholder.kt:510)");
        }
        composer.startReplaceGroup(129627177);
        ComposerKt.sourceInformation(composer, "514@23796L26,518@23990L28,520@24106L37,521@24198L25,523@24354L27,527@24557L29,529@24682L38,530@24783L26");
        if (!placeholderState.isShowContent()) {
            int i3 = ((i << 3) & 112) | 6;
            chipColorsM533chipColors_rQONyM = ChipDefaults.INSTANCE.m533chipColors_rQONyM(new PlaceholderBackgroundPainter((Painter) chipColorsM533chipColors_rQONyM.background(true, composer, i3).getValue(), placeholderState, surface, 0.0f, 8, null), ((Color) chipColorsM533chipColors_rQONyM.contentColor(true, composer, i3).getValue()).unbox-impl(), ((Color) chipColorsM533chipColors_rQONyM.secondaryContentColor(true, composer, i3).getValue()).unbox-impl(), ((Color) chipColorsM533chipColors_rQONyM.iconColor(true, composer, i3).getValue()).unbox-impl(), new PlaceholderBackgroundPainter((Painter) chipColorsM533chipColors_rQONyM.background(false, composer, i3).getValue(), placeholderState, surface, 0.0f, 8, null), ((Color) chipColorsM533chipColors_rQONyM.contentColor(false, composer, i3).getValue()).unbox-impl(), ((Color) chipColorsM533chipColors_rQONyM.secondaryContentColor(false, composer, i3).getValue()).unbox-impl(), ((Color) chipColorsM533chipColors_rQONyM.iconColor(false, composer, i3).getValue()).unbox-impl());
        }
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return chipColorsM533chipColors_rQONyM;
    }

    /* JADX INFO: renamed from: placeholderChipColors-iJQMabo, reason: not valid java name */
    public final ChipColors m661placeholderChipColorsiJQMabo(PlaceholderState placeholderState, long j, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -662300327, "C(placeholderChipColors)P(1,0:c#ui.graphics.Color)554@25914L6:Placeholder.kt#gj9v0t");
        long surface = (i2 & 2) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getSurface() : j;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-662300327, i, -1, "androidx.wear.compose.material.PlaceholderDefaults.placeholderChipColors (Placeholder.kt:555)");
        }
        ChipColors chipColorsM533chipColors_rQONyM = ChipDefaults.INSTANCE.m533chipColors_rQONyM(new PlaceholderBackgroundPainter(null, placeholderState, surface, 0.0f, 8, null), Color.Companion.getTransparent-0d7_KjU(), Color.Companion.getTransparent-0d7_KjU(), Color.Companion.getTransparent-0d7_KjU(), new PlaceholderBackgroundPainter(null, placeholderState, surface, 0.0f, 8, null), Color.Companion.getTransparent-0d7_KjU(), Color.Companion.getTransparent-0d7_KjU(), Color.Companion.getTransparent-0d7_KjU());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return chipColorsM533chipColors_rQONyM;
    }

    /* JADX INFO: renamed from: painterWithPlaceholderOverlayBackgroundBrush-FNF3uiM, reason: not valid java name */
    public final Painter m658painterWithPlaceholderOverlayBackgroundBrushFNF3uiM(PlaceholderState placeholderState, Painter painter, long j, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -2051949968, "C(painterWithPlaceholderOverlayBackgroundBrush)P(2,1,0:c#ui.graphics.Color)591@27575L6:Placeholder.kt#gj9v0t");
        long surface = (i2 & 4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getSurface() : j;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2051949968, i, -1, "androidx.wear.compose.material.PlaceholderDefaults.painterWithPlaceholderOverlayBackgroundBrush (Placeholder.kt:592)");
        }
        if (!placeholderState.isShowContent()) {
            painter = new PlaceholderBackgroundPainter(painter, placeholderState, surface, 0.0f, 8, null);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return painter;
    }

    /* JADX INFO: renamed from: placeholderBackgroundBrush-iJQMabo, reason: not valid java name */
    public final Painter m659placeholderBackgroundBrushiJQMabo(PlaceholderState placeholderState, long j, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 2034497450, "C(placeholderBackgroundBrush)P(1,0:c#ui.graphics.Color)616@28549L6:Placeholder.kt#gj9v0t");
        if ((i2 & 2) != 0) {
            j = MaterialTheme.INSTANCE.getColors(composer, 6).getSurface();
        }
        long j2 = j;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2034497450, i, -1, "androidx.wear.compose.material.PlaceholderDefaults.placeholderBackgroundBrush (Placeholder.kt:617)");
        }
        PlaceholderBackgroundPainter placeholderBackgroundPainter = new PlaceholderBackgroundPainter(null, placeholderState, j2, 0.0f, 8, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return placeholderBackgroundPainter;
    }
}
