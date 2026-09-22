package androidx.wear.compose.material;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.BrushPainter;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: SelectableChip.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0080\u0001\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u00132\b\b\u0002\u0010\u0018\u001a\u00020\u00132\b\b\u0002\u0010\u0019\u001a\u00020\u00132\b\b\u0002\u0010\u001a\u001a\u00020\u00132\b\b\u0002\u0010\u001b\u001a\u00020\u00132\b\b\u0002\u0010\u001c\u001a\u00020\u00132\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 JN\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00132\b\b\u0002\u0010$\u001a\u00020\u00132\b\b\u0002\u0010%\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u00132\b\b\u0002\u0010\u001c\u001a\u00020\u00132\b\b\u0002\u0010&\u001a\u00020\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b'\u0010(R\u0016\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u000b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u000f\u0010\r\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006)"}, d2 = {"Landroidx/wear/compose/material/SelectableChipDefaults;", "", "()V", "ChipHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ChipVerticalPadding", "ContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "Height", "getHeight-D9Ej5fM", "()F", "IconSize", "getIconSize-D9Ej5fM", "selectableChipColors", "Landroidx/wear/compose/material/SelectableChipColors;", "selectedStartBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "selectedEndBackgroundColor", "selectedContentColor", "selectedSecondaryContentColor", "selectedSelectionControlColor", "unselectedStartBackgroundColor", "unselectedEndBackgroundColor", "unselectedContentColor", "unselectedSecondaryContentColor", "unselectedSelectionControlColor", "gradientDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "selectableChipColors-r6VPBpI", "(JJJJJJJJJJLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/runtime/Composer;III)Landroidx/wear/compose/material/SelectableChipColors;", "splitSelectableChipColors", "Landroidx/wear/compose/material/SplitSelectableChipColors;", "backgroundColor", "contentColor", "secondaryContentColor", "splitBackgroundOverlayColor", "splitSelectableChipColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/wear/compose/material/SplitSelectableChipColors;", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SelectableChipDefaults {
    public static final int $stable = 0;
    private static final float ChipHorizontalPadding;
    private static final float ChipVerticalPadding;
    private static final PaddingValues ContentPadding;
    private static final float Height;
    public static final SelectableChipDefaults INSTANCE = new SelectableChipDefaults();
    private static final float IconSize;

    private SelectableChipDefaults() {
    }

    /* JADX INFO: renamed from: selectableChipColors-r6VPBpI, reason: not valid java name */
    public final SelectableChipColors m788selectableChipColorsr6VPBpI(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, LayoutDirection layoutDirection, Composer composer, int i, int i2, int i3) {
        LayoutDirection layoutDirection2;
        char c;
        char c2;
        List listListOf;
        List listListOf2;
        List listListOf3;
        List listListOf4;
        ComposerKt.sourceInformationMarkerStart(composer, 1245868294, "C(selectableChipColors)P(5:c#ui.graphics.Color,2:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color,10:c#ui.graphics.Color,7:c#ui.graphics.Color,6:c#ui.graphics.Color,8:c#ui.graphics.Color,9:c#ui.graphics.Color)425@20377L6,426@20454L6,428@20541L6,429@20620L6,430@20689L6,431@20768L6,432@20854L6,433@20934L6,435@21068L43,438@21325L7,499@24248L8,501@24384L8,504@24521L8,510@24808L8,513@24961L8,516@25102L8:SelectableChip.kt#gj9v0t");
        long j11 = (i3 & 1) != 0 ? ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).getSurface(), 0.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColors(composer, 6).getSurface()) : j;
        long j12 = (i3 & 2) != 0 ? ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).getPrimary(), 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColors(composer, 6).getSurface()) : j2;
        long onSurface = (i3 & 4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getOnSurface() : j3;
        long onSurfaceVariant = (i3 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getOnSurfaceVariant() : j4;
        long secondary = (i3 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getSecondary() : j5;
        long surface = (i3 & 32) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getSurface() : j6;
        long j13 = (i3 & 64) != 0 ? surface : j7;
        long jM574contentColorForek8zF_U = (i3 & 128) != 0 ? ColorsKt.m574contentColorForek8zF_U(j12, composer, (i >> 3) & 14) : j8;
        long j14 = (i3 & 256) != 0 ? jM574contentColorForek8zF_U : j9;
        long j15 = (i3 & 512) != 0 ? jM574contentColorForek8zF_U : j10;
        if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0) {
            CompositionLocal localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composer);
            layoutDirection2 = (LayoutDirection) objConsume;
        } else {
            layoutDirection2 = layoutDirection;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1245868294, i, i2, "androidx.wear.compose.material.SelectableChipDefaults.selectableChipColors (SelectableChip.kt:439)");
        }
        if (layoutDirection2 == LayoutDirection.Ltr) {
            composer.startReplaceGroup(-70684720);
            ComposerKt.sourceInformation(composer, "448@21803L8,449@21883L8");
            listListOf2 = CollectionsKt.listOf(new Color[]{Color.box-impl(j11), Color.box-impl(j12)});
            c = 0;
            c2 = 1;
            listListOf = CollectionsKt.listOf(new Color[]{Color.box-impl(Color.copy-wmQWz5c$default(j11, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null)), Color.box-impl(Color.copy-wmQWz5c$default(j12, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null))});
            composer.endReplaceGroup();
        } else {
            c = 0;
            c2 = 1;
            composer.startReplaceGroup(-70290865);
            ComposerKt.sourceInformation(composer, "457@22198L8,458@22280L8");
            List listListOf5 = CollectionsKt.listOf(new Color[]{Color.box-impl(j12), Color.box-impl(j11)});
            List listListOf6 = CollectionsKt.listOf(new Color[]{Color.box-impl(Color.copy-wmQWz5c$default(j12, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null)), Color.box-impl(Color.copy-wmQWz5c$default(j11, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null))});
            composer.endReplaceGroup();
            listListOf = listListOf6;
            listListOf2 = listListOf5;
        }
        if (layoutDirection2 == LayoutDirection.Ltr) {
            composer.startReplaceGroup(-69735996);
            ComposerKt.sourceInformation(composer, "469@22769L8,470@22851L8");
            Color[] colorArr = new Color[2];
            colorArr[c] = Color.box-impl(surface);
            colorArr[c2] = Color.box-impl(j13);
            listListOf4 = CollectionsKt.listOf(colorArr);
            Color[] colorArr2 = new Color[2];
            colorArr2[c] = Color.box-impl(Color.copy-wmQWz5c$default(surface, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null));
            colorArr2[c2] = Color.box-impl(Color.copy-wmQWz5c$default(j13, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null));
            listListOf3 = CollectionsKt.listOf(colorArr2);
            composer.endReplaceGroup();
        } else {
            long j16 = j13;
            composer.startReplaceGroup(-69330237);
            ComposerKt.sourceInformation(composer, "478@23176L8,479@23260L8");
            Color[] colorArr3 = new Color[2];
            colorArr3[c] = Color.box-impl(j16);
            colorArr3[c2] = Color.box-impl(surface);
            List listListOf7 = CollectionsKt.listOf(colorArr3);
            Color[] colorArr4 = new Color[2];
            colorArr4[c] = Color.box-impl(Color.copy-wmQWz5c$default(j16, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null));
            colorArr4[c2] = Color.box-impl(Color.copy-wmQWz5c$default(surface, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null));
            listListOf3 = CollectionsKt.listOf(colorArr4);
            composer.endReplaceGroup();
            listListOf4 = listListOf7;
        }
        DefaultSelectableChipColors defaultSelectableChipColors = new DefaultSelectableChipColors(new BrushPainter(Brush.Companion.linearGradient-mHitzGk$default(Brush.Companion, listListOf2, 0L, 0L, 0, 14, (Object) null)), onSurface, onSurfaceVariant, secondary, new BrushPainter(Brush.Companion.linearGradient-mHitzGk$default(Brush.Companion, listListOf, 0L, 0L, 0, 14, (Object) null)), Color.copy-wmQWz5c$default(onSurface, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.copy-wmQWz5c$default(onSurfaceVariant, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.copy-wmQWz5c$default(secondary, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null), new BrushPainter(Brush.Companion.linearGradient-mHitzGk$default(Brush.Companion, listListOf4, 0L, 0L, 0, 14, (Object) null)), jM574contentColorForek8zF_U, j14, j15, new BrushPainter(Brush.Companion.linearGradient-mHitzGk$default(Brush.Companion, listListOf3, 0L, 0L, 0, 14, (Object) null)), Color.copy-wmQWz5c$default(jM574contentColorForek8zF_U, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.copy-wmQWz5c$default(j14, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.copy-wmQWz5c$default(j15, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null), null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultSelectableChipColors;
    }

    /* JADX INFO: renamed from: splitSelectableChipColors-5tl4gsc, reason: not valid java name */
    public final SplitSelectableChipColors m789splitSelectableChipColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1937259265, "C(splitSelectableChipColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,5:c#ui.graphics.Color,4:c#ui.graphics.Color)539@26222L6,540@26282L6,541@26353L6,542@26439L6,554@27189L8,555@27274L8,557@27394L8,560@27531L8,564@27754L8:SelectableChip.kt#gj9v0t");
        long surface = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getSurface() : j;
        long onSurface = (i2 & 2) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getOnSurface() : j2;
        long onSurfaceVariant = (i2 & 4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getOnSurfaceVariant() : j3;
        long secondary = (i2 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getSecondary() : j4;
        long j7 = (i2 & 16) != 0 ? onSurface : j5;
        long j8 = (i2 & 32) != 0 ? Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.05f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1937259265, i, -1, "androidx.wear.compose.material.SelectableChipDefaults.splitSelectableChipColors (SelectableChip.kt:545)");
        }
        DefaultSplitSelectableChipColors defaultSplitSelectableChipColors = new DefaultSplitSelectableChipColors(surface, onSurface, onSurfaceVariant, secondary, j8, Color.copy-wmQWz5c$default(surface, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.copy-wmQWz5c$default(onSurface, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.copy-wmQWz5c$default(onSurfaceVariant, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.copy-wmQWz5c$default(secondary, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null), j8, j7, j8, Color.copy-wmQWz5c$default(j7, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null), j8, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultSplitSelectableChipColors;
    }

    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    /* JADX INFO: renamed from: getHeight-D9Ej5fM, reason: not valid java name */
    public final float m786getHeightD9Ej5fM() {
        return Height;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m787getIconSizeD9Ej5fM() {
        return IconSize;
    }

    static {
        float f = Dp.constructor-impl(14);
        ChipHorizontalPadding = f;
        float f2 = Dp.constructor-impl(6);
        ChipVerticalPadding = f2;
        ContentPadding = PaddingKt.PaddingValues-a9UjIt4(f, f2, f, f2);
        Height = Dp.constructor-impl(52);
        IconSize = Dp.constructor-impl(24);
    }
}
