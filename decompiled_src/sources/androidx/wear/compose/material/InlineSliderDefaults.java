package androidx.wear.compose.material;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.AddKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.unit.Dp;
import androidx.wear.compose.materialcore.RangeIcons;
import kotlin.Metadata;

/* JADX INFO: compiled from: Slider.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jb\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\u001d2\b\b\u0002\u0010 \u001a\u00020\u001d2\b\b\u0002\u0010!\u001a\u00020\u001d2\b\b\u0002\u0010\"\u001a\u00020\u001d2\b\b\u0002\u0010#\u001a\u00020\u001d2\b\b\u0002\u0010$\u001a\u00020\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&R\u001c\u0010\u0003\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u001c\u0010\f\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0014\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0016\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0017\u0010\u0006R\u001c\u0010\u0018\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0019\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006'"}, d2 = {"Landroidx/wear/compose/material/InlineSliderDefaults;", "", "()V", "BarHeight", "Landroidx/compose/ui/unit/Dp;", "getBarHeight-D9Ej5fM$compose_material_release", "()F", "F", "BarMargin", "getBarMargin-D9Ej5fM$compose_material_release", "BarSeparatorWidth", "getBarSeparatorWidth-D9Ej5fM$compose_material_release", "ControlSize", "getControlSize-D9Ej5fM$compose_material_release", "Decrease", "Landroidx/compose/ui/graphics/vector/ImageVector;", "getDecrease", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "Increase", "getIncrease", "OuterHorizontalMargin", "getOuterHorizontalMargin-D9Ej5fM$compose_material_release", "SliderHeight", "getSliderHeight-D9Ej5fM$compose_material_release", "SpacersWidth", "getSpacersWidth-D9Ej5fM$compose_material_release", "colors", "Landroidx/wear/compose/material/InlineSliderColors;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "spacerColor", "selectedBarColor", "unselectedBarColor", "disabledBackgroundColor", "disabledSpacerColor", "disabledSelectedBarColor", "disabledUnselectedBarColor", "colors-oq7We08", "(JJJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/wear/compose/material/InlineSliderColors;", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class InlineSliderDefaults {
    public static final int $stable = 0;
    private static final float BarSeparatorWidth;
    private static final float SpacersWidth;
    public static final InlineSliderDefaults INSTANCE = new InlineSliderDefaults();
    private static final float SliderHeight = Dp.constructor-impl(52);
    private static final float ControlSize = Dp.constructor-impl(36);
    private static final float OuterHorizontalMargin = Dp.constructor-impl(8);
    private static final float BarMargin = Dp.constructor-impl(7);
    private static final float BarHeight = Dp.constructor-impl(6);
    private static final ImageVector Decrease = RangeIcons.INSTANCE.getMinus();
    private static final ImageVector Increase = AddKt.getAdd(Icons.Filled.INSTANCE);

    private InlineSliderDefaults() {
    }

    /* JADX INFO: renamed from: getSliderHeight-D9Ej5fM$compose_material_release, reason: not valid java name */
    public final float m612getSliderHeightD9Ej5fM$compose_material_release() {
        return SliderHeight;
    }

    /* JADX INFO: renamed from: getControlSize-D9Ej5fM$compose_material_release, reason: not valid java name */
    public final float m610getControlSizeD9Ej5fM$compose_material_release() {
        return ControlSize;
    }

    /* JADX INFO: renamed from: getOuterHorizontalMargin-D9Ej5fM$compose_material_release, reason: not valid java name */
    public final float m611getOuterHorizontalMarginD9Ej5fM$compose_material_release() {
        return OuterHorizontalMargin;
    }

    /* JADX INFO: renamed from: getSpacersWidth-D9Ej5fM$compose_material_release, reason: not valid java name */
    public final float m613getSpacersWidthD9Ej5fM$compose_material_release() {
        return SpacersWidth;
    }

    /* JADX INFO: renamed from: getBarMargin-D9Ej5fM$compose_material_release, reason: not valid java name */
    public final float m608getBarMarginD9Ej5fM$compose_material_release() {
        return BarMargin;
    }

    /* JADX INFO: renamed from: getBarHeight-D9Ej5fM$compose_material_release, reason: not valid java name */
    public final float m607getBarHeightD9Ej5fM$compose_material_release() {
        return BarHeight;
    }

    /* JADX INFO: renamed from: getBarSeparatorWidth-D9Ej5fM$compose_material_release, reason: not valid java name */
    public final float m609getBarSeparatorWidthD9Ej5fM$compose_material_release() {
        return BarSeparatorWidth;
    }

    /* JADX INFO: renamed from: colors-oq7We08, reason: not valid java name */
    public final InlineSliderColors m606colorsoq7We08(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, Composer composer, int i, int i2) {
        long j9;
        long j10;
        long j11;
        ComposerKt.sourceInformationMarkerStart(composer, 2044210062, "C(colors)P(0:c#ui.graphics.Color,6:c#ui.graphics.Color,5:c#ui.graphics.Color,7:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.graphics.Color)351@15168L6,352@15227L6,353@15294L6,354@15362L6,355@15474L8,356@15560L8,357@15656L8:Slider.kt#gj9v0t");
        long surface = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getSurface() : j;
        long background = (i2 & 2) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getBackground() : j2;
        long secondary = (i2 & 4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getSecondary() : j3;
        long j12 = (i2 & 8) != 0 ? Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).getOnSurface(), 0.1f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j4;
        if ((i2 & 16) != 0) {
            j9 = Color.copy-wmQWz5c$default(surface, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j9 = j5;
        }
        if ((i2 & 32) != 0) {
            j10 = Color.copy-wmQWz5c$default(background, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j10 = j6;
        }
        if ((i2 & 64) != 0) {
            j11 = Color.copy-wmQWz5c$default(secondary, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j11 = j7;
        }
        long j13 = (i2 & 128) != 0 ? Color.copy-wmQWz5c$default(j12, 0.05f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j8;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2044210062, i, -1, "androidx.wear.compose.material.InlineSliderDefaults.colors (Slider.kt:359)");
        }
        DefaultInlineSliderColors defaultInlineSliderColors = new DefaultInlineSliderColors(surface, background, secondary, j12, j9, j10, j11, j13, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultInlineSliderColors;
    }

    public final ImageVector getDecrease() {
        return Decrease;
    }

    public final ImageVector getIncrease() {
        return Increase;
    }

    static {
        float f = 1;
        SpacersWidth = Dp.constructor-impl(f);
        BarSeparatorWidth = Dp.constructor-impl(f);
    }
}
