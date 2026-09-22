package androidx.wear.compose.material;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.painter.BrushPainter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ToggleChip.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020*J\u000e\u0010+\u001a\u00020\u00042\u0006\u0010)\u001a\u00020*JN\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020\u001f2\b\b\u0002\u0010/\u001a\u00020\u001f2\b\b\u0002\u00100\u001a\u00020\u001f2\b\b\u0002\u00101\u001a\u00020\u001f2\b\b\u0002\u00102\u001a\u00020\u001f2\b\b\u0002\u00103\u001a\u00020\u001fH\u0007ø\u0001\u0000¢\u0006\u0004\b4\u00105J\u000e\u00106\u001a\u00020\u00042\u0006\u0010)\u001a\u00020*J\u0080\u0001\u00107\u001a\u0002082\b\b\u0002\u00109\u001a\u00020\u001f2\b\b\u0002\u0010:\u001a\u00020\u001f2\b\b\u0002\u0010;\u001a\u00020\u001f2\b\b\u0002\u0010<\u001a\u00020\u001f2\b\b\u0002\u00101\u001a\u00020\u001f2\b\b\u0002\u0010=\u001a\u00020\u001f2\b\b\u0002\u0010>\u001a\u00020\u001f2\b\b\u0002\u0010?\u001a\u00020\u001f2\b\b\u0002\u0010@\u001a\u00020\u001f2\b\b\u0002\u00102\u001a\u00020\u001f2\b\b\u0002\u0010A\u001a\u00020BH\u0007ø\u0001\u0000¢\u0006\u0004\bC\u0010DR\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0016\u0010\t\u001a\u00020\nX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\f\u001a\u00020\nX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000bR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0011\u001a\u00020\nø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0014\u001a\u00020\nø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0016\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0006R\u0011\u0010\u0018\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0006R\u0014\u0010\u001a\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0006R\u0014\u0010\u001c\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0006R\u0017\u0010\u001e\u001a\u00020\u001f8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006E"}, d2 = {"Landroidx/wear/compose/material/ToggleChipDefaults;", "", "()V", "CheckboxOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "getCheckboxOff", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "CheckboxOn", "getCheckboxOn", "ChipHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ChipVerticalPadding", "ContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "Height", "getHeight-D9Ej5fM", "()F", "IconSize", "getIconSize-D9Ej5fM", "RadioOff", "getRadioOff", "RadioOn", "getRadioOn", "SwitchOff", "getSwitchOff", "SwitchOn", "getSwitchOn", "SwitchUncheckedIconColor", "Landroidx/compose/ui/graphics/Color;", "getSwitchUncheckedIconColor", "(Landroidx/compose/runtime/Composer;I)J", "_checkboxOff", "_checkboxOn", "_radioOff", "_radioOn", "_switchOff", "_switchOn", "checkboxIcon", "checked", "", "radioIcon", "splitToggleChipColors", "Landroidx/wear/compose/material/SplitToggleChipColors;", "backgroundColor", "contentColor", "secondaryContentColor", "checkedToggleControlColor", "uncheckedToggleControlColor", "splitBackgroundOverlayColor", "splitToggleChipColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/wear/compose/material/SplitToggleChipColors;", "switchIcon", "toggleChipColors", "Landroidx/wear/compose/material/ToggleChipColors;", "checkedStartBackgroundColor", "checkedEndBackgroundColor", "checkedContentColor", "checkedSecondaryContentColor", "uncheckedStartBackgroundColor", "uncheckedEndBackgroundColor", "uncheckedContentColor", "uncheckedSecondaryContentColor", "gradientDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "toggleChipColors-r6VPBpI", "(JJJJJJJJJJLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/runtime/Composer;III)Landroidx/wear/compose/material/ToggleChipColors;", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ToggleChipDefaults {
    public static final int $stable;
    private static final float ChipHorizontalPadding;
    private static final float ChipVerticalPadding;
    private static final PaddingValues ContentPadding;
    private static final float Height;
    public static final ToggleChipDefaults INSTANCE = new ToggleChipDefaults();
    private static final float IconSize;
    private static ImageVector _checkboxOff;
    private static ImageVector _checkboxOn;
    private static ImageVector _radioOff;
    private static ImageVector _radioOn;
    private static ImageVector _switchOff;
    private static ImageVector _switchOn;

    private ToggleChipDefaults() {
    }

    /* JADX INFO: renamed from: toggleChipColors-r6VPBpI, reason: not valid java name */
    public final ToggleChipColors m861toggleChipColorsr6VPBpI(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, LayoutDirection layoutDirection, Composer composer, int i, int i2, int i3) {
        LayoutDirection layoutDirection2;
        char c;
        char c2;
        List listListOf;
        List listListOf2;
        List listListOf3;
        List listListOf4;
        ComposerKt.sourceInformationMarkerStart(composer, -396686970, "C(toggleChipColors)P(3:c#ui.graphics.Color,1:c#ui.graphics.Color,0:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.graphics.Color,9:c#ui.graphics.Color,7:c#ui.graphics.Color,6:c#ui.graphics.Color,8:c#ui.graphics.Color,10:c#ui.graphics.Color)428@20302L6,429@20379L6,431@20465L6,432@20544L6,433@20612L6,434@20690L6,435@20772L6,436@20851L6,438@20982L42,441@21231L7,500@24062L8,502@24196L8,505@24328L8,511@24611L8,514@24762L8,517@24898L8:ToggleChip.kt#gj9v0t");
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
            ComposerKt.traceEventStart(-396686970, i, i2, "androidx.wear.compose.material.ToggleChipDefaults.toggleChipColors (ToggleChip.kt:442)");
        }
        if (layoutDirection2 == LayoutDirection.Ltr) {
            composer.startReplaceGroup(41796694);
            ComposerKt.sourceInformation(composer, "451@21698L8,452@21777L8");
            listListOf2 = CollectionsKt.listOf(new Color[]{Color.box-impl(j11), Color.box-impl(j12)});
            c = 0;
            c2 = 1;
            listListOf = CollectionsKt.listOf(new Color[]{Color.box-impl(Color.copy-wmQWz5c$default(j11, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null)), Color.box-impl(Color.copy-wmQWz5c$default(j12, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null))});
            composer.endReplaceGroup();
        } else {
            c = 0;
            c2 = 1;
            composer.startReplaceGroup(42184597);
            ComposerKt.sourceInformation(composer, "460@22087L8,461@22168L8");
            List listListOf5 = CollectionsKt.listOf(new Color[]{Color.box-impl(j12), Color.box-impl(j11)});
            List listListOf6 = CollectionsKt.listOf(new Color[]{Color.box-impl(Color.copy-wmQWz5c$default(j12, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null)), Color.box-impl(Color.copy-wmQWz5c$default(j11, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null))});
            composer.endReplaceGroup();
            listListOf = listListOf6;
            listListOf2 = listListOf5;
        }
        if (layoutDirection2 == LayoutDirection.Ltr) {
            composer.startReplaceGroup(42731530);
            ComposerKt.sourceInformation(composer, "472@22650L8,473@22731L8");
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
            composer.startReplaceGroup(43131337);
            ComposerKt.sourceInformation(composer, "481@23051L8,482@23134L8");
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
        DefaultToggleChipColors defaultToggleChipColors = new DefaultToggleChipColors(new BrushPainter(Brush.Companion.linearGradient-mHitzGk$default(Brush.Companion, listListOf2, 0L, 0L, 0, 14, (Object) null)), onSurface, onSurfaceVariant, secondary, new BrushPainter(Brush.Companion.linearGradient-mHitzGk$default(Brush.Companion, listListOf, 0L, 0L, 0, 14, (Object) null)), Color.copy-wmQWz5c$default(onSurface, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.copy-wmQWz5c$default(onSurfaceVariant, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.copy-wmQWz5c$default(secondary, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null), new BrushPainter(Brush.Companion.linearGradient-mHitzGk$default(Brush.Companion, listListOf4, 0L, 0L, 0, 14, (Object) null)), jM574contentColorForek8zF_U, j14, j15, new BrushPainter(Brush.Companion.linearGradient-mHitzGk$default(Brush.Companion, listListOf3, 0L, 0L, 0, 14, (Object) null)), Color.copy-wmQWz5c$default(jM574contentColorForek8zF_U, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.copy-wmQWz5c$default(j14, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.copy-wmQWz5c$default(j15, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null), null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultToggleChipColors;
    }

    /* JADX INFO: renamed from: splitToggleChipColors-5tl4gsc, reason: not valid java name */
    public final SplitToggleChipColors m860splitToggleChipColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1368423875, "C(splitToggleChipColors)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,1:c#ui.graphics.Color,5:c#ui.graphics.Color,4:c#ui.graphics.Color)540@25965L6,541@26025L6,542@26096L6,543@26178L6,555@26904L8,556@26989L8,558@27109L8,561@27241L8,565@27458L8:ToggleChip.kt#gj9v0t");
        long surface = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getSurface() : j;
        long onSurface = (i2 & 2) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getOnSurface() : j2;
        long onSurfaceVariant = (i2 & 4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getOnSurfaceVariant() : j3;
        long secondary = (i2 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getSecondary() : j4;
        long j7 = (i2 & 16) != 0 ? onSurface : j5;
        long j8 = (i2 & 32) != 0 ? Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.05f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1368423875, i, -1, "androidx.wear.compose.material.ToggleChipDefaults.splitToggleChipColors (ToggleChip.kt:546)");
        }
        DefaultSplitToggleChipColors defaultSplitToggleChipColors = new DefaultSplitToggleChipColors(surface, onSurface, onSurfaceVariant, secondary, j8, Color.copy-wmQWz5c$default(surface, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.copy-wmQWz5c$default(onSurface, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.copy-wmQWz5c$default(onSurfaceVariant, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.copy-wmQWz5c$default(secondary, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null), j8, j7, j8, Color.copy-wmQWz5c$default(j7, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null), j8, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultSplitToggleChipColors;
    }

    public final long getSwitchUncheckedIconColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 572359621, "C575@27770L6:ToggleChip.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(572359621, i, -1, "androidx.wear.compose.material.ToggleChipDefaults.<get-SwitchUncheckedIconColor> (ToggleChip.kt:575)");
        }
        long j = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).getOnSurface(), 0.6f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return j;
    }

    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    public final ImageVector switchIcon(boolean checked) {
        return checked ? getSwitchOn() : getSwitchOff();
    }

    public final ImageVector radioIcon(boolean checked) {
        return checked ? getRadioOn() : getRadioOff();
    }

    public final ImageVector checkboxIcon(boolean checked) {
        return checked ? getCheckboxOn() : getCheckboxOff();
    }

    /* JADX INFO: renamed from: getHeight-D9Ej5fM, reason: not valid java name */
    public final float m858getHeightD9Ej5fM() {
        return Height;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m859getIconSizeD9Ej5fM() {
        return IconSize;
    }

    private final ImageVector getSwitchOn() {
        ImageVector imageVector = _switchOn;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("SwitchOn", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, (DefaultConstructorMarker) null);
        int defaultFillType = VectorKt.getDefaultFillType();
        Brush solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), (DefaultConstructorMarker) null);
        int i = StrokeCap.Companion.getButt-KaPHkGw();
        int i2 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(5.0f, 7.0f);
        pathBuilder.lineTo(19.0f, 7.0f);
        pathBuilder.arcTo(5.0f, 5.0f, 0.0f, false, true, 24.0f, 12.0f);
        pathBuilder.lineTo(24.0f, 12.0f);
        pathBuilder.arcTo(5.0f, 5.0f, 0.0f, false, true, 19.0f, 17.0f);
        pathBuilder.lineTo(5.0f, 17.0f);
        pathBuilder.arcTo(5.0f, 5.0f, 0.0f, false, true, 0.0f, 12.0f);
        pathBuilder.lineTo(0.0f, 12.0f);
        pathBuilder.arcTo(5.0f, 5.0f, 0.0f, false, true, 5.0f, 7.0f);
        pathBuilder.close();
        ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), defaultFillType, "", solidColor, 0.38f, (Brush) null, 0.38f, 1.0f, i, i2, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null);
        int i3 = PathFillType.Companion.getEvenOdd-Rg-k1Os();
        Brush solidColor2 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), (DefaultConstructorMarker) null);
        int i4 = StrokeCap.Companion.getButt-KaPHkGw();
        int i5 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder pathBuilder2 = new PathBuilder();
        pathBuilder2.moveTo(17.0f, 19.0f);
        pathBuilder2.curveTo(20.866f, 19.0f, 24.0f, 15.866f, 24.0f, 12.0f);
        pathBuilder2.curveTo(24.0f, 8.134f, 20.866f, 5.0f, 17.0f, 5.0f);
        pathBuilder2.curveTo(13.134f, 5.0f, 10.0f, 8.134f, 10.0f, 12.0f);
        pathBuilder2.curveTo(10.0f, 15.866f, 13.134f, 19.0f, 17.0f, 19.0f);
        pathBuilder2.close();
        ImageVector imageVectorBuild = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder2.getNodes(), i3, "", solidColor2, 1.0f, (Brush) null, 1.0f, 1.0f, i4, i5, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null).build();
        _switchOn = imageVectorBuild;
        Intrinsics.checkNotNull(imageVectorBuild);
        return imageVectorBuild;
    }

    private final ImageVector getSwitchOff() {
        ImageVector imageVector = _switchOff;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("SwitchOff", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, (DefaultConstructorMarker) null);
        int defaultFillType = VectorKt.getDefaultFillType();
        Brush solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), (DefaultConstructorMarker) null);
        int i = StrokeCap.Companion.getButt-KaPHkGw();
        int i2 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(5.0f, 7.0f);
        pathBuilder.lineTo(19.0f, 7.0f);
        pathBuilder.arcTo(5.0f, 5.0f, 0.0f, false, true, 24.0f, 12.0f);
        pathBuilder.lineTo(24.0f, 12.0f);
        pathBuilder.arcTo(5.0f, 5.0f, 0.0f, false, true, 19.0f, 17.0f);
        pathBuilder.lineTo(5.0f, 17.0f);
        pathBuilder.arcTo(5.0f, 5.0f, 0.0f, false, true, 0.0f, 12.0f);
        pathBuilder.lineTo(0.0f, 12.0f);
        pathBuilder.arcTo(5.0f, 5.0f, 0.0f, false, true, 5.0f, 7.0f);
        pathBuilder.close();
        ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), defaultFillType, "", solidColor, 0.38f, (Brush) null, 0.38f, 1.0f, i, i2, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null);
        int i3 = PathFillType.Companion.getEvenOdd-Rg-k1Os();
        Brush solidColor2 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), (DefaultConstructorMarker) null);
        int i4 = StrokeCap.Companion.getButt-KaPHkGw();
        int i5 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder pathBuilder2 = new PathBuilder();
        pathBuilder2.moveTo(7.0f, 19.0f);
        pathBuilder2.curveTo(10.866f, 19.0f, 14.0f, 15.866f, 14.0f, 12.0f);
        pathBuilder2.curveTo(14.0f, 8.134f, 10.866f, 5.0f, 7.0f, 5.0f);
        pathBuilder2.curveTo(3.134f, 5.0f, 0.0f, 8.134f, 0.0f, 12.0f);
        pathBuilder2.curveTo(0.0f, 15.866f, 3.134f, 19.0f, 7.0f, 19.0f);
        pathBuilder2.close();
        ImageVector imageVectorBuild = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder2.getNodes(), i3, "", solidColor2, 1.0f, (Brush) null, 1.0f, 1.0f, i4, i5, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null).build();
        _switchOff = imageVectorBuild;
        Intrinsics.checkNotNull(imageVectorBuild);
        return imageVectorBuild;
    }

    public final ImageVector getRadioOn() {
        ImageVector imageVector = _radioOn;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("RadioOn", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, (DefaultConstructorMarker) null);
        int defaultFillType = VectorKt.getDefaultFillType();
        Brush solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), (DefaultConstructorMarker) null);
        int i = StrokeCap.Companion.getButt-KaPHkGw();
        int i2 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(12.0f, 2.0f);
        pathBuilder.curveTo(6.48f, 2.0f, 2.0f, 6.48f, 2.0f, 12.0f);
        pathBuilder.curveTo(2.0f, 17.52f, 6.48f, 22.0f, 12.0f, 22.0f);
        pathBuilder.curveTo(17.52f, 22.0f, 22.0f, 17.52f, 22.0f, 12.0f);
        pathBuilder.curveTo(22.0f, 6.48f, 17.52f, 2.0f, 12.0f, 2.0f);
        pathBuilder.close();
        pathBuilder.moveTo(12.0f, 20.0f);
        pathBuilder.curveTo(7.58f, 20.0f, 4.0f, 16.42f, 4.0f, 12.0f);
        pathBuilder.curveTo(4.0f, 7.58f, 7.58f, 4.0f, 12.0f, 4.0f);
        pathBuilder.curveTo(16.42f, 4.0f, 20.0f, 7.58f, 20.0f, 12.0f);
        pathBuilder.curveTo(20.0f, 16.42f, 16.42f, 20.0f, 12.0f, 20.0f);
        pathBuilder.close();
        ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), defaultFillType, "", solidColor, 1.0f, (Brush) null, 1.0f, 1.0f, i, i2, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null);
        int defaultFillType2 = VectorKt.getDefaultFillType();
        Brush solidColor2 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), (DefaultConstructorMarker) null);
        int i3 = StrokeCap.Companion.getButt-KaPHkGw();
        int i4 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder pathBuilder2 = new PathBuilder();
        pathBuilder2.moveTo(12.0f, 12.0f);
        pathBuilder2.moveToRelative(-5.0f, 0.0f);
        pathBuilder2.arcToRelative(5.0f, 5.0f, 0.0f, true, true, 10.0f, 0.0f);
        pathBuilder2.arcToRelative(5.0f, 5.0f, 0.0f, true, true, -10.0f, 0.0f);
        ImageVector imageVectorBuild = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder2.getNodes(), defaultFillType2, "", solidColor2, 1.0f, (Brush) null, 1.0f, 1.0f, i3, i4, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null).build();
        _radioOn = imageVectorBuild;
        Intrinsics.checkNotNull(imageVectorBuild);
        return imageVectorBuild;
    }

    public final ImageVector getRadioOff() {
        ImageVector imageVector = _radioOff;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("RadioOff", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, (DefaultConstructorMarker) null);
        int defaultFillType = VectorKt.getDefaultFillType();
        Brush solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), (DefaultConstructorMarker) null);
        int i = StrokeCap.Companion.getButt-KaPHkGw();
        int i2 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(12.0f, 2.0f);
        pathBuilder.curveTo(6.48f, 2.0f, 2.0f, 6.48f, 2.0f, 12.0f);
        pathBuilder.curveTo(2.0f, 17.52f, 6.48f, 22.0f, 12.0f, 22.0f);
        pathBuilder.curveTo(17.52f, 22.0f, 22.0f, 17.52f, 22.0f, 12.0f);
        pathBuilder.curveTo(22.0f, 6.48f, 17.52f, 2.0f, 12.0f, 2.0f);
        pathBuilder.close();
        pathBuilder.moveTo(12.0f, 20.0f);
        pathBuilder.curveTo(7.58f, 20.0f, 4.0f, 16.42f, 4.0f, 12.0f);
        pathBuilder.curveTo(4.0f, 7.58f, 7.58f, 4.0f, 12.0f, 4.0f);
        pathBuilder.curveTo(16.42f, 4.0f, 20.0f, 7.58f, 20.0f, 12.0f);
        pathBuilder.curveTo(20.0f, 16.42f, 16.42f, 20.0f, 12.0f, 20.0f);
        pathBuilder.close();
        ImageVector imageVectorBuild = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), defaultFillType, "", solidColor, 1.0f, (Brush) null, 1.0f, 1.0f, i, i2, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null).build();
        _radioOff = imageVectorBuild;
        Intrinsics.checkNotNull(imageVectorBuild);
        return imageVectorBuild;
    }

    public final ImageVector getCheckboxOn() {
        ImageVector imageVector = _checkboxOn;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("CheckboxOn", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, (DefaultConstructorMarker) null);
        int defaultFillType = VectorKt.getDefaultFillType();
        Brush solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), (DefaultConstructorMarker) null);
        int i = StrokeCap.Companion.getButt-KaPHkGw();
        int i2 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(19.0f, 3.0f);
        pathBuilder.horizontalLineTo(5.0f);
        pathBuilder.curveTo(3.9f, 3.0f, 3.0f, 3.9f, 3.0f, 5.0f);
        pathBuilder.verticalLineTo(19.0f);
        pathBuilder.curveTo(3.0f, 20.1f, 3.9f, 21.0f, 5.0f, 21.0f);
        pathBuilder.horizontalLineTo(19.0f);
        pathBuilder.curveTo(20.1f, 21.0f, 21.0f, 20.1f, 21.0f, 19.0f);
        pathBuilder.verticalLineTo(5.0f);
        pathBuilder.curveTo(21.0f, 3.9f, 20.1f, 3.0f, 19.0f, 3.0f);
        pathBuilder.close();
        pathBuilder.moveTo(19.0f, 19.0f);
        pathBuilder.horizontalLineTo(5.0f);
        pathBuilder.verticalLineTo(5.0f);
        pathBuilder.horizontalLineTo(19.0f);
        pathBuilder.verticalLineTo(19.0f);
        pathBuilder.close();
        pathBuilder.moveTo(18.0f, 9.0f);
        pathBuilder.lineTo(16.6f, 7.6f);
        pathBuilder.lineTo(13.3f, 10.9f);
        pathBuilder.lineTo(10.0f, 14.2f);
        pathBuilder.lineTo(7.4f, 11.6f);
        pathBuilder.lineTo(6.0f, 13.0f);
        pathBuilder.lineTo(10.0f, 17.0f);
        pathBuilder.lineTo(18.0f, 9.0f);
        pathBuilder.close();
        ImageVector imageVectorBuild = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), defaultFillType, "", solidColor, 1.0f, (Brush) null, 1.0f, 1.0f, i, i2, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null).build();
        _checkboxOn = imageVectorBuild;
        Intrinsics.checkNotNull(imageVectorBuild);
        return imageVectorBuild;
    }

    private final ImageVector getCheckboxOff() {
        ImageVector imageVector = _checkboxOff;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("CheckboxOff", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, (DefaultConstructorMarker) null);
        int defaultFillType = VectorKt.getDefaultFillType();
        Brush solidColor = new SolidColor(Color.Companion.getBlack-0d7_KjU(), (DefaultConstructorMarker) null);
        int i = StrokeCap.Companion.getButt-KaPHkGw();
        int i2 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(19.0f, 5.0f);
        pathBuilder.verticalLineTo(19.0f);
        pathBuilder.horizontalLineTo(5.0f);
        pathBuilder.verticalLineTo(5.0f);
        pathBuilder.horizontalLineTo(19.0f);
        pathBuilder.close();
        pathBuilder.moveTo(19.0f, 3.0f);
        pathBuilder.horizontalLineTo(5.0f);
        pathBuilder.curveTo(3.9f, 3.0f, 3.0f, 3.9f, 3.0f, 5.0f);
        pathBuilder.verticalLineTo(19.0f);
        pathBuilder.curveTo(3.0f, 20.1f, 3.9f, 21.0f, 5.0f, 21.0f);
        pathBuilder.horizontalLineTo(19.0f);
        pathBuilder.curveTo(20.1f, 21.0f, 21.0f, 20.1f, 21.0f, 19.0f);
        pathBuilder.verticalLineTo(5.0f);
        pathBuilder.curveTo(21.0f, 3.9f, 20.1f, 3.0f, 19.0f, 3.0f);
        pathBuilder.close();
        ImageVector imageVectorBuild = ImageVector.Builder.addPath-oIyEayM$default(builder, pathBuilder.getNodes(), defaultFillType, "", solidColor, 1.0f, (Brush) null, 1.0f, 1.0f, i, i2, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null).build();
        _checkboxOff = imageVectorBuild;
        Intrinsics.checkNotNull(imageVectorBuild);
        return imageVectorBuild;
    }

    static {
        float f = Dp.constructor-impl(14);
        ChipHorizontalPadding = f;
        float f2 = Dp.constructor-impl(6);
        ChipVerticalPadding = f2;
        ContentPadding = PaddingKt.PaddingValues-a9UjIt4(f, f2, f, f2);
        Height = Dp.constructor-impl(52);
        IconSize = Dp.constructor-impl(24);
        $stable = 8;
    }
}
