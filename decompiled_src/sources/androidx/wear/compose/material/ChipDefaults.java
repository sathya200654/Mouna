package androidx.wear.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.BrushPainter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Chip.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020'2\b\b\u0002\u0010)\u001a\u00020'H\u0007ø\u0001\u0000¢\u0006\u0004\b*\u0010+J%\u0010,\u001a\u00020-2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u00100\u001a\u0004\u0018\u00010/H\u0007¢\u0006\u0002\u00101Jb\u00102\u001a\u00020%2\b\b\u0002\u00103\u001a\u00020'2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020'2\b\b\u0002\u0010)\u001a\u00020'2\b\b\u0002\u00104\u001a\u00020'2\b\b\u0002\u00105\u001a\u00020'2\b\b\u0002\u00106\u001a\u00020'2\b\b\u0002\u00107\u001a\u00020'H\u0007ø\u0001\u0000¢\u0006\u0004\b8\u00109JR\u00102\u001a\u00020%2\u0006\u0010:\u001a\u00020;2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020'2\u0006\u0010<\u001a\u00020;2\u0006\u00105\u001a\u00020'2\u0006\u00106\u001a\u00020'2\u0006\u00107\u001a\u00020'H\u0007ø\u0001\u0000¢\u0006\u0004\b=\u0010>JN\u0010?\u001a\u00020%2\b\b\u0002\u0010@\u001a\u00020'2\b\b\u0002\u0010A\u001a\u00020'2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020'2\b\b\u0002\u0010)\u001a\u00020'2\b\b\u0002\u0010B\u001a\u00020CH\u0007ø\u0001\u0000¢\u0006\u0004\bD\u0010EJB\u0010F\u001a\u00020%2\u0006\u0010G\u001a\u00020;2\b\b\u0002\u0010H\u001a\u00020I2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020'2\b\b\u0002\u0010)\u001a\u00020'H\u0007ø\u0001\u0000¢\u0006\u0004\bJ\u0010KJ0\u0010L\u001a\u00020-2\b\b\u0002\u0010M\u001a\u00020'2\b\b\u0002\u0010N\u001a\u00020'2\b\b\u0002\u0010O\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\bP\u0010QJ0\u0010R\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020'2\b\b\u0002\u0010)\u001a\u00020'H\u0007ø\u0001\u0000¢\u0006\u0004\bS\u0010+J:\u0010T\u001a\u00020%2\b\b\u0002\u00103\u001a\u00020'2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020'2\b\b\u0002\u0010)\u001a\u00020'H\u0007ø\u0001\u0000¢\u0006\u0004\bU\u0010VJ:\u0010W\u001a\u00020%2\b\b\u0002\u00103\u001a\u00020'2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020'2\b\b\u0002\u0010)\u001a\u00020'H\u0007ø\u0001\u0000¢\u0006\u0004\bX\u0010VR\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0011\u0010\u0006R\u0011\u0010\u0012\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0019\u0010\u0014\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0015\u0010\u0006R\u0011\u0010\u0016\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\rR\u0019\u0010\u0018\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0019\u0010\u0006R\u001c\u0010\u001a\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001b\u0010\u0006R\u0019\u0010\u001c\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001d\u0010\u0006R\u001c\u0010\u001e\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001f\u0010\u0006R\u0019\u0010 \u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b!\u0010\u0006R\u0019\u0010\"\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b#\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Y"}, d2 = {"Landroidx/wear/compose/material/ChipDefaults;", "", "()V", "ChipHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "getChipHorizontalPadding-D9Ej5fM", "()F", "F", "ChipVerticalPadding", "getChipVerticalPadding-D9Ej5fM", "CompactChipContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getCompactChipContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "CompactChipHeight", "getCompactChipHeight-D9Ej5fM", "CompactChipHorizontalPadding", "getCompactChipHorizontalPadding-D9Ej5fM", "CompactChipTapTargetPadding", "getCompactChipTapTargetPadding", "CompactChipVerticalPadding", "getCompactChipVerticalPadding-D9Ej5fM", "ContentPadding", "getContentPadding", "Height", "getHeight-D9Ej5fM", "IconOnlyCompactChipWidth", "getIconOnlyCompactChipWidth-D9Ej5fM$compose_material_release", "IconSize", "getIconSize-D9Ej5fM", "IconSpacing", "getIconSpacing-D9Ej5fM$compose_material_release", "LargeIconSize", "getLargeIconSize-D9Ej5fM", "SmallIconSize", "getSmallIconSize-D9Ej5fM", "childChipColors", "Landroidx/wear/compose/material/ChipColors;", "contentColor", "Landroidx/compose/ui/graphics/Color;", "secondaryContentColor", "iconColor", "childChipColors-RGew2ao", "(JJJLandroidx/compose/runtime/Composer;II)Landroidx/wear/compose/material/ChipColors;", "chipBorder", "Landroidx/wear/compose/material/ChipBorder;", "borderStroke", "Landroidx/compose/foundation/BorderStroke;", "disabledBorderStroke", "(Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/runtime/Composer;II)Landroidx/wear/compose/material/ChipBorder;", "chipColors", "backgroundColor", "disabledBackgroundColor", "disabledContentColor", "disabledSecondaryContentColor", "disabledIconColor", "chipColors-oq7We08", "(JJJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/wear/compose/material/ChipColors;", "backgroundPainter", "Landroidx/compose/ui/graphics/painter/Painter;", "disabledBackgroundPainter", "chipColors-_rQONyM", "(Landroidx/compose/ui/graphics/painter/Painter;JJJLandroidx/compose/ui/graphics/painter/Painter;JJJ)Landroidx/wear/compose/material/ChipColors;", "gradientBackgroundChipColors", "startBackgroundColor", "endBackgroundColor", "gradientDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "gradientBackgroundChipColors-O8qE4YA", "(JJJJJLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/runtime/Composer;II)Landroidx/wear/compose/material/ChipColors;", "imageBackgroundChipColors", "backgroundImagePainter", "backgroundImageScrimBrush", "Landroidx/compose/ui/graphics/Brush;", "imageBackgroundChipColors-aDBTMWw", "(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/Brush;JJJLandroidx/compose/runtime/Composer;II)Landroidx/wear/compose/material/ChipColors;", "outlinedChipBorder", "borderColor", "disabledBorderColor", "borderWidth", "outlinedChipBorder-d_3_b6Q", "(JJFLandroidx/compose/runtime/Composer;II)Landroidx/wear/compose/material/ChipBorder;", "outlinedChipColors", "outlinedChipColors-RGew2ao", "primaryChipColors", "primaryChipColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/wear/compose/material/ChipColors;", "secondaryChipColors", "secondaryChipColors-ro_MJ88", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ChipDefaults {
    public static final int $stable = 0;
    private static final float ChipHorizontalPadding;
    private static final float ChipVerticalPadding;
    private static final PaddingValues CompactChipContentPadding;
    private static final float CompactChipHeight;
    private static final float CompactChipHorizontalPadding;
    private static final PaddingValues CompactChipTapTargetPadding;
    private static final float CompactChipVerticalPadding;
    private static final PaddingValues ContentPadding;
    private static final float Height;
    public static final ChipDefaults INSTANCE = new ChipDefaults();
    private static final float IconOnlyCompactChipWidth;
    private static final float IconSize;
    private static final float IconSpacing;
    private static final float LargeIconSize;
    private static final float SmallIconSize;

    private ChipDefaults() {
    }

    /* JADX INFO: renamed from: primaryChipColors-ro_MJ88, reason: not valid java name */
    public final ChipColors m550primaryChipColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -780313255, "C(primaryChipColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.graphics.Color,2:c#ui.graphics.Color)852@40993L6,853@41039L32,865@41656L6,866@41733L6,867@41798L6,860@41413L413:Chip.kt#gj9v0t");
        long primary = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getPrimary() : j;
        long jM574contentColorForek8zF_U = (i2 & 2) != 0 ? ColorsKt.m574contentColorForek8zF_U(primary, composer, i & 14) : j2;
        long j5 = (i2 & 4) != 0 ? jM574contentColorForek8zF_U : j3;
        long j6 = (i2 & 8) != 0 ? jM574contentColorForek8zF_U : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-780313255, i, -1, "androidx.wear.compose.material.ChipDefaults.primaryChipColors (Chip.kt:856)");
        }
        ChipColors chipColorsM534chipColorsoq7We08 = m534chipColorsoq7We08(primary, jM574contentColorForek8zF_U, j5, j6, 0L, MaterialTheme.INSTANCE.getColors(composer, 6).getBackground(), MaterialTheme.INSTANCE.getColors(composer, 6).getBackground(), MaterialTheme.INSTANCE.getColors(composer, 6).getBackground(), composer, (i & 8190) | ((i << 12) & 234881024), 16);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return chipColorsM534chipColorsoq7We08;
    }

    /* JADX INFO: renamed from: gradientBackgroundChipColors-O8qE4YA, reason: not valid java name */
    public final ChipColors m546gradientBackgroundChipColorsO8qE4YA(long j, long j2, long j3, long j4, long j5, LayoutDirection layoutDirection, Composer composer, int i, int i2) {
        LayoutDirection layoutDirection2;
        List listListOf;
        List listListOf2;
        ComposerKt.sourceInformationMarkerStart(composer, -548365967, "C(gradientBackgroundChipColors)P(5:c#ui.graphics.Color,1:c#ui.graphics.Color,0:c#ui.graphics.Color,4:c#ui.graphics.Color,3:c#ui.graphics.Color)894@43271L6,895@43346L6,896@43413L6,897@43486L6,898@43533L35,901@43730L7,932@45059L8,934@45179L8,936@45271L8:Chip.kt#gj9v0t");
        long j6 = (i2 & 1) != 0 ? ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).getPrimary(), 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColors(composer, 6).getSurface()) : j;
        long j7 = (i2 & 2) != 0 ? ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).getSurface(), 0.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColors(composer, 6).getSurface()) : j2;
        long jM574contentColorForek8zF_U = (i2 & 4) != 0 ? ColorsKt.m574contentColorForek8zF_U(j7, composer, (i >> 3) & 14) : j3;
        long j8 = (i2 & 8) != 0 ? jM574contentColorForek8zF_U : j4;
        long j9 = (i2 & 16) != 0 ? jM574contentColorForek8zF_U : j5;
        if ((i2 & 32) != 0) {
            CompositionLocal localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composer);
            layoutDirection2 = (LayoutDirection) objConsume;
        } else {
            layoutDirection2 = layoutDirection;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-548365967, i, -1, "androidx.wear.compose.material.ChipDefaults.gradientBackgroundChipColors (Chip.kt:902)");
        }
        if (layoutDirection2 == LayoutDirection.Ltr) {
            composer.startReplaceGroup(501772354);
            ComposerKt.sourceInformation(composer, "911@44142L8,912@44214L8");
            listListOf = CollectionsKt.listOf(new Color[]{Color.box-impl(j6), Color.box-impl(j7)});
            listListOf2 = CollectionsKt.listOf(new Color[]{Color.box-impl(Color.copy-wmQWz5c$default(j6, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null)), Color.box-impl(Color.copy-wmQWz5c$default(j7, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null))});
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(502118593);
            ComposerKt.sourceInformation(composer, "920@44489L8,921@44563L8");
            listListOf = CollectionsKt.listOf(new Color[]{Color.box-impl(j7), Color.box-impl(j6)});
            listListOf2 = CollectionsKt.listOf(new Color[]{Color.box-impl(Color.copy-wmQWz5c$default(j7, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null)), Color.box-impl(Color.copy-wmQWz5c$default(j6, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null))});
            composer.endReplaceGroup();
        }
        DefaultChipColors defaultChipColors = new DefaultChipColors(new BrushPainter(Brush.Companion.linearGradient-mHitzGk$default(Brush.Companion, listListOf, 0L, 0L, 0, 14, (Object) null)), jM574contentColorForek8zF_U, j8, j9, new BrushPainter(Brush.Companion.linearGradient-mHitzGk$default(Brush.Companion, listListOf2, 0L, 0L, 0, 14, (Object) null)), Color.copy-wmQWz5c$default(jM574contentColorForek8zF_U, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.copy-wmQWz5c$default(j8, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.copy-wmQWz5c$default(j9, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null), (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultChipColors;
    }

    /* JADX INFO: renamed from: secondaryChipColors-ro_MJ88, reason: not valid java name */
    public final ChipColors m551secondaryChipColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1748639819, "C(secondaryChipColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.graphics.Color,2:c#ui.graphics.Color)954@46099L6,955@46145L32,959@46307L202:Chip.kt#gj9v0t");
        long surface = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getSurface() : j;
        long jM574contentColorForek8zF_U = (i2 & 2) != 0 ? ColorsKt.m574contentColorForek8zF_U(surface, composer, i & 14) : j2;
        long j5 = (i2 & 4) != 0 ? jM574contentColorForek8zF_U : j3;
        long j6 = (i2 & 8) != 0 ? jM574contentColorForek8zF_U : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1748639819, i, -1, "androidx.wear.compose.material.ChipDefaults.secondaryChipColors (Chip.kt:958)");
        }
        ChipColors chipColorsM534chipColorsoq7We08 = m534chipColorsoq7We08(surface, jM574contentColorForek8zF_U, j5, j6, 0L, 0L, 0L, 0L, composer, (i & 8190) | ((i << 12) & 234881024), 240);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return chipColorsM534chipColorsoq7We08;
    }

    /* JADX INFO: renamed from: childChipColors-RGew2ao, reason: not valid java name */
    public final ChipColors m532childChipColorsRGew2ao(long j, long j2, long j3, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 2094328028, "C(childChipColors)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,1:c#ui.graphics.Color)982@47278L6,986@47424L261:Chip.kt#gj9v0t");
        long onSurface = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getOnSurface() : j;
        long j4 = (i2 & 2) != 0 ? onSurface : j2;
        long j5 = (i2 & 4) != 0 ? onSurface : j3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2094328028, i, -1, "androidx.wear.compose.material.ChipDefaults.childChipColors (Chip.kt:985)");
        }
        int i3 = i << 3;
        ChipColors chipColorsM534chipColorsoq7We08 = m534chipColorsoq7We08(Color.Companion.getTransparent-0d7_KjU(), onSurface, j4, j5, Color.Companion.getTransparent-0d7_KjU(), 0L, 0L, 0L, composer, (i3 & 7168) | (i3 & 112) | 24582 | (i3 & 896) | ((i << 15) & 234881024), 224);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return chipColorsM534chipColorsoq7We08;
    }

    /* JADX INFO: renamed from: imageBackgroundChipColors-aDBTMWw, reason: not valid java name */
    public final ChipColors m547imageBackgroundChipColorsaDBTMWw(Painter painter, Brush brush, long j, long j2, long j3, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1510793834, "C(imageBackgroundChipColors)P(!2,2:c#ui.graphics.Color,4:c#ui.graphics.Color,3:c#ui.graphics.Color)1013@48772L6,1014@48837L6,1017@48938L6,1022@49117L245,1029@49412L8,1031@49473L318,1044@50153L8,1046@50273L8,1048@50365L8:Chip.kt#gj9v0t");
        Brush brush2 = (i2 & 2) != 0 ? Brush.Companion.linearGradient-mHitzGk$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).getSurface(), 1.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null)), Color.box-impl(Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).getSurface(), 0.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null))}), 0L, 0L, 0, 14, (Object) null) : brush;
        long onBackground = (i2 & 4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getOnBackground() : j;
        long j4 = (i2 & 8) != 0 ? onBackground : j2;
        long j5 = (i2 & 16) != 0 ? onBackground : j3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1510793834, i, -1, "androidx.wear.compose.material.ChipDefaults.imageBackgroundChipColors (Chip.kt:1020)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1891985557, "CC(remember):Chip.kt#9igjgp");
        int i3 = (i & 112) ^ 48;
        boolean zChanged = composer.changed(painter) | ((i3 > 32 && composer.changed(brush2)) || (i & 48) == 32);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new ImageWithScrimPainter(painter, brush2, 0.0f, 0.0f, 12, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        ImageWithScrimPainter imageWithScrimPainter = (ImageWithScrimPainter) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        float disabled = ContentAlpha.INSTANCE.getDisabled(composer, 6);
        ComposerKt.sourceInformationMarkerStart(composer, -1891974092, "CC(remember):Chip.kt#9igjgp");
        boolean zChanged2 = composer.changed(painter) | ((i3 > 32 && composer.changed(brush2)) || (i & 48) == 32) | composer.changed(disabled);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
            objRememberedValue2 = new ImageWithScrimPainter(painter, brush2, 0.0f, disabled, 4, null);
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        DefaultChipColors defaultChipColors = new DefaultChipColors(imageWithScrimPainter, onBackground, j4, j5, (ImageWithScrimPainter) objRememberedValue2, Color.copy-wmQWz5c$default(onBackground, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.copy-wmQWz5c$default(j4, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.copy-wmQWz5c$default(j5, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null), (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultChipColors;
    }

    /* JADX INFO: renamed from: outlinedChipColors-RGew2ao, reason: not valid java name */
    public final ChipColors m549outlinedChipColorsRGew2ao(long j, long j2, long j3, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 127346686, "C(outlinedChipColors)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,1:c#ui.graphics.Color)1066@51048L6,1070@51193L262:Chip.kt#gj9v0t");
        long primary = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getPrimary() : j;
        long j4 = (i2 & 2) != 0 ? primary : j2;
        long j5 = (i2 & 4) != 0 ? primary : j3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(127346686, i, -1, "androidx.wear.compose.material.ChipDefaults.outlinedChipColors (Chip.kt:1069)");
        }
        int i3 = i << 3;
        ChipColors chipColorsM534chipColorsoq7We08 = m534chipColorsoq7We08(Color.Companion.getTransparent-0d7_KjU(), primary, j4, j5, Color.Companion.getTransparent-0d7_KjU(), 0L, 0L, 0L, composer, (i3 & 7168) | (i3 & 112) | 24582 | (i3 & 896) | ((i << 15) & 234881024), 224);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return chipColorsM534chipColorsoq7We08;
    }

    public final ChipBorder chipBorder(BorderStroke borderStroke, BorderStroke borderStroke2, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -613355721, "C(chipBorder):Chip.kt#gj9v0t");
        if ((i2 & 1) != 0) {
            borderStroke = null;
        }
        if ((i2 & 2) != 0) {
            borderStroke2 = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-613355721, i, -1, "androidx.wear.compose.material.ChipDefaults.chipBorder (Chip.kt:1089)");
        }
        DefaultChipBorder defaultChipBorder = new DefaultChipBorder(borderStroke, borderStroke2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultChipBorder;
    }

    /* JADX INFO: renamed from: outlinedChipBorder-d_3_b6Q, reason: not valid java name */
    public final ChipBorder m548outlinedChipBorderd_3_b6Q(long j, long j2, float f, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1415262709, "C(outlinedChipBorder)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,1:c#ui.unit.Dp)1106@52462L6,1107@52579L8:Chip.kt#gj9v0t");
        long j3 = (i2 & 1) != 0 ? Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).getPrimaryVariant(), 0.6f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j;
        long j4 = (i2 & 2) != 0 ? Color.copy-wmQWz5c$default(j3, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j2;
        float f2 = (i2 & 4) != 0 ? Dp.constructor-impl(1) : f;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1415262709, i, -1, "androidx.wear.compose.material.ChipDefaults.outlinedChipBorder (Chip.kt:1109)");
        }
        DefaultChipBorder defaultChipBorder = new DefaultChipBorder(BorderStrokeKt.BorderStroke-cXLIe8U(f2, j3), BorderStrokeKt.BorderStroke-cXLIe8U(f2, j4));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultChipBorder;
    }

    /* JADX INFO: renamed from: getChipHorizontalPadding-D9Ej5fM, reason: not valid java name */
    public final float m535getChipHorizontalPaddingD9Ej5fM() {
        return ChipHorizontalPadding;
    }

    /* JADX INFO: renamed from: getChipVerticalPadding-D9Ej5fM, reason: not valid java name */
    public final float m536getChipVerticalPaddingD9Ej5fM() {
        return ChipVerticalPadding;
    }

    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    /* JADX INFO: renamed from: getCompactChipHorizontalPadding-D9Ej5fM, reason: not valid java name */
    public final float m538getCompactChipHorizontalPaddingD9Ej5fM() {
        return CompactChipHorizontalPadding;
    }

    /* JADX INFO: renamed from: getCompactChipVerticalPadding-D9Ej5fM, reason: not valid java name */
    public final float m539getCompactChipVerticalPaddingD9Ej5fM() {
        return CompactChipVerticalPadding;
    }

    public final PaddingValues getCompactChipContentPadding() {
        return CompactChipContentPadding;
    }

    /* JADX INFO: renamed from: getHeight-D9Ej5fM, reason: not valid java name */
    public final float m540getHeightD9Ej5fM() {
        return Height;
    }

    /* JADX INFO: renamed from: getCompactChipHeight-D9Ej5fM, reason: not valid java name */
    public final float m537getCompactChipHeightD9Ej5fM() {
        return CompactChipHeight;
    }

    public final PaddingValues getCompactChipTapTargetPadding() {
        return CompactChipTapTargetPadding;
    }

    /* JADX INFO: renamed from: getIconOnlyCompactChipWidth-D9Ej5fM$compose_material_release, reason: not valid java name */
    public final float m541getIconOnlyCompactChipWidthD9Ej5fM$compose_material_release() {
        return IconOnlyCompactChipWidth;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m542getIconSizeD9Ej5fM() {
        return IconSize;
    }

    /* JADX INFO: renamed from: getLargeIconSize-D9Ej5fM, reason: not valid java name */
    public final float m544getLargeIconSizeD9Ej5fM() {
        return LargeIconSize;
    }

    /* JADX INFO: renamed from: getSmallIconSize-D9Ej5fM, reason: not valid java name */
    public final float m545getSmallIconSizeD9Ej5fM() {
        return SmallIconSize;
    }

    /* JADX INFO: renamed from: getIconSpacing-D9Ej5fM$compose_material_release, reason: not valid java name */
    public final float m543getIconSpacingD9Ej5fM$compose_material_release() {
        return IconSpacing;
    }

    /* JADX INFO: renamed from: chipColors-oq7We08, reason: not valid java name */
    public final ChipColors m534chipColorsoq7We08(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, Composer composer, int i, int i2) {
        long j9;
        long j10;
        long j11;
        long j12;
        ComposerKt.sourceInformationMarkerStart(composer, 798460911, "C(chipColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,7:c#ui.graphics.Color,6:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,5:c#ui.graphics.Color,4:c#ui.graphics.Color)1209@56211L6,1210@56257L32,1213@56468L8,1214@56556L8,1216@56674L8,1217@56756L8:Chip.kt#gj9v0t");
        long primary = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getPrimary() : j;
        long jM574contentColorForek8zF_U = (i2 & 2) != 0 ? ColorsKt.m574contentColorForek8zF_U(primary, composer, i & 14) : j2;
        long j13 = (i2 & 4) != 0 ? jM574contentColorForek8zF_U : j3;
        long j14 = (i2 & 8) != 0 ? jM574contentColorForek8zF_U : j4;
        if ((i2 & 16) != 0) {
            j9 = Color.copy-wmQWz5c$default(primary, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j9 = j5;
        }
        if ((i2 & 32) != 0) {
            j10 = Color.copy-wmQWz5c$default(jM574contentColorForek8zF_U, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j10 = j6;
        }
        if ((i2 & 64) != 0) {
            j11 = Color.copy-wmQWz5c$default(j13, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j11 = j7;
        }
        if ((i2 & 128) != 0) {
            j12 = Color.copy-wmQWz5c$default(j14, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j12 = j8;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(798460911, i, -1, "androidx.wear.compose.material.ChipDefaults.chipColors (Chip.kt:1218)");
        }
        DefaultChipColors defaultChipColors = new DefaultChipColors(primary, jM574contentColorForek8zF_U, j13, j14, j9, j10, j11, j12, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultChipColors;
    }

    /* JADX INFO: renamed from: chipColors-_rQONyM, reason: not valid java name */
    public final ChipColors m533chipColors_rQONyM(Painter backgroundPainter, long contentColor, long secondaryContentColor, long iconColor, Painter disabledBackgroundPainter, long disabledContentColor, long disabledSecondaryContentColor, long disabledIconColor) {
        return new DefaultChipColors(backgroundPainter, contentColor, secondaryContentColor, iconColor, disabledBackgroundPainter, disabledContentColor, disabledSecondaryContentColor, disabledIconColor, (DefaultConstructorMarker) null);
    }

    static {
        float f = Dp.constructor-impl(14);
        ChipHorizontalPadding = f;
        float f2 = 6;
        float f3 = Dp.constructor-impl(f2);
        ChipVerticalPadding = f3;
        ContentPadding = PaddingKt.PaddingValues-a9UjIt4(f, f3, f, f3);
        float f4 = Dp.constructor-impl(12);
        CompactChipHorizontalPadding = f4;
        float f5 = Dp.constructor-impl(0);
        CompactChipVerticalPadding = f5;
        CompactChipContentPadding = PaddingKt.PaddingValues-a9UjIt4(f4, f5, f4, f5);
        float f6 = 52;
        Height = Dp.constructor-impl(f6);
        CompactChipHeight = Dp.constructor-impl(48);
        float f7 = 8;
        CompactChipTapTargetPadding = PaddingKt.PaddingValues-a9UjIt4$default(0.0f, Dp.constructor-impl(f7), 0.0f, Dp.constructor-impl(f7), 5, (Object) null);
        IconOnlyCompactChipWidth = Dp.constructor-impl(f6);
        IconSize = Dp.constructor-impl(24);
        LargeIconSize = Dp.constructor-impl(32);
        SmallIconSize = Dp.constructor-impl(20);
        IconSpacing = Dp.constructor-impl(f2);
    }
}
