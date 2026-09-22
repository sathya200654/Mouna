package androidx.wear.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: compiled from: Button.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0007¢\u0006\u0002\u0010\u001bJ:\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\u001f2\b\b\u0002\u0010\"\u001a\u00020\u001fH\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u001c\u0010%\u001a\u00020\u001d2\b\b\u0002\u0010 \u001a\u00020\u001fH\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010'J0\u0010(\u001a\u00020\u00172\b\b\u0002\u0010)\u001a\u00020\u001f2\b\b\u0002\u0010*\u001a\u00020\u001f2\b\b\u0002\u0010+\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b,\u0010-J\u001c\u0010.\u001a\u00020\u001d2\b\b\u0002\u0010 \u001a\u00020\u001fH\u0007ø\u0001\u0000¢\u0006\u0004\b/\u0010'J&\u00100\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001fH\u0007ø\u0001\u0000¢\u0006\u0004\b1\u00102J&\u00103\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001fH\u0007ø\u0001\u0000¢\u0006\u0004\b4\u00102R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0019\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0011\u0010\u0006R\u0019\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0013\u0010\u0006R\u0019\u0010\u0014\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0015\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00065"}, d2 = {"Landroidx/wear/compose/material/ButtonDefaults;", "", "()V", "CompactButtonBackgroundPadding", "Landroidx/compose/ui/unit/Dp;", "getCompactButtonBackgroundPadding-D9Ej5fM", "()F", "F", "DefaultButtonSize", "getDefaultButtonSize-D9Ej5fM", "DefaultIconSize", "getDefaultIconSize-D9Ej5fM", "ExtraSmallButtonSize", "getExtraSmallButtonSize-D9Ej5fM", "LargeButtonSize", "getLargeButtonSize-D9Ej5fM", "LargeIconSize", "getLargeIconSize-D9Ej5fM", "SmallButtonSize", "getSmallButtonSize-D9Ej5fM", "SmallIconSize", "getSmallIconSize-D9Ej5fM", "buttonBorder", "Landroidx/wear/compose/material/ButtonBorder;", "borderStroke", "Landroidx/compose/foundation/BorderStroke;", "disabledBorderStroke", "(Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/runtime/Composer;II)Landroidx/wear/compose/material/ButtonBorder;", "buttonColors", "Landroidx/wear/compose/material/ButtonColors;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledBackgroundColor", "disabledContentColor", "buttonColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/wear/compose/material/ButtonColors;", "iconButtonColors", "iconButtonColors-Iv8Zu3U", "(JLandroidx/compose/runtime/Composer;II)Landroidx/wear/compose/material/ButtonColors;", "outlinedButtonBorder", "borderColor", "disabledBorderColor", "borderWidth", "outlinedButtonBorder-d_3_b6Q", "(JJFLandroidx/compose/runtime/Composer;II)Landroidx/wear/compose/material/ButtonBorder;", "outlinedButtonColors", "outlinedButtonColors-Iv8Zu3U", "primaryButtonColors", "primaryButtonColors-dgg9oW8", "(JJLandroidx/compose/runtime/Composer;II)Landroidx/wear/compose/material/ButtonColors;", "secondaryButtonColors", "secondaryButtonColors-dgg9oW8", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ButtonDefaults {
    public static final int $stable = 0;
    public static final ButtonDefaults INSTANCE = new ButtonDefaults();
    private static final float ExtraSmallButtonSize = Dp.constructor-impl(32);
    private static final float SmallButtonSize = Dp.constructor-impl(48);
    private static final float DefaultButtonSize = Dp.constructor-impl(52);
    private static final float LargeButtonSize = Dp.constructor-impl(60);
    private static final float SmallIconSize = Dp.constructor-impl(24);
    private static final float DefaultIconSize = Dp.constructor-impl(26);
    private static final float LargeIconSize = Dp.constructor-impl(30);
    private static final float CompactButtonBackgroundPadding = Dp.constructor-impl(8);

    private ButtonDefaults() {
    }

    /* JADX INFO: renamed from: primaryButtonColors-dgg9oW8, reason: not valid java name */
    public final ButtonColors m519primaryButtonColorsdgg9oW8(long j, long j2, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1159233899, "C(primaryButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color)476@21698L6,477@21744L32,485@22177L6,482@22026L178:Button.kt#gj9v0t");
        long primary = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getPrimary() : j;
        long jM574contentColorForek8zF_U = (i2 & 2) != 0 ? ColorsKt.m574contentColorForek8zF_U(primary, composer, i & 14) : j2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1159233899, i, -1, "androidx.wear.compose.material.ButtonDefaults.primaryButtonColors (Button.kt:478)");
        }
        ButtonColors buttonColorsM507buttonColorsro_MJ88 = m507buttonColorsro_MJ88(primary, jM574contentColorForek8zF_U, 0L, MaterialTheme.INSTANCE.getColors(composer, 6).getBackground(), composer, (i & 126) | ((i << 6) & 57344), 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return buttonColorsM507buttonColorsro_MJ88;
    }

    /* JADX INFO: renamed from: secondaryButtonColors-dgg9oW8, reason: not valid java name */
    public final ButtonColors m520secondaryButtonColorsdgg9oW8(long j, long j2, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1484747427, "C(secondaryButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color)500@22805L6,501@22851L32,503@22921L110:Button.kt#gj9v0t");
        if ((i2 & 1) != 0) {
            j = MaterialTheme.INSTANCE.getColors(composer, 6).getSurface();
        }
        long jM574contentColorForek8zF_U = (i2 & 2) != 0 ? ColorsKt.m574contentColorForek8zF_U(j, composer, i & 14) : j2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1484747427, i, -1, "androidx.wear.compose.material.ButtonDefaults.secondaryButtonColors (Button.kt:502)");
        }
        ButtonColors buttonColorsM507buttonColorsro_MJ88 = m507buttonColorsro_MJ88(j, jM574contentColorForek8zF_U, 0L, 0L, composer, (i & 126) | ((i << 6) & 57344), 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return buttonColorsM507buttonColorsro_MJ88;
    }

    /* JADX INFO: renamed from: iconButtonColors-Iv8Zu3U, reason: not valid java name */
    public final ButtonColors m516iconButtonColorsIv8Zu3U(long j, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 856458023, "C(iconButtonColors)P(0:c#ui.graphics.Color)518@23438L6,520@23493L113:Button.kt#gj9v0t");
        long onSurface = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getOnSurface() : j;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(856458023, i, -1, "androidx.wear.compose.material.ButtonDefaults.iconButtonColors (Button.kt:519)");
        }
        ButtonColors buttonColorsM507buttonColorsro_MJ88 = m507buttonColorsro_MJ88(Color.Companion.getTransparent-0d7_KjU(), onSurface, 0L, 0L, composer, 6 | ((i << 3) & 112) | ((i << 9) & 57344), 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return buttonColorsM507buttonColorsro_MJ88;
    }

    /* JADX INFO: renamed from: outlinedButtonColors-Iv8Zu3U, reason: not valid java name */
    public final ButtonColors m518outlinedButtonColorsIv8Zu3U(long j, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -74313392, "C(outlinedButtonColors)P(0:c#ui.graphics.Color)535@24023L6,537@24076L112:Button.kt#gj9v0t");
        long primary = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getPrimary() : j;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-74313392, i, -1, "androidx.wear.compose.material.ButtonDefaults.outlinedButtonColors (Button.kt:536)");
        }
        ButtonColors buttonColorsM507buttonColorsro_MJ88 = m507buttonColorsro_MJ88(Color.Companion.getTransparent-0d7_KjU(), primary, 0L, 0L, composer, 6 | ((i << 3) & 112) | ((i << 9) & 57344), 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return buttonColorsM507buttonColorsro_MJ88;
    }

    public final ButtonBorder buttonBorder(BorderStroke borderStroke, BorderStroke borderStroke2, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1022523063, "C(buttonBorder):Button.kt#gj9v0t");
        if ((i2 & 1) != 0) {
            borderStroke = null;
        }
        if ((i2 & 2) != 0) {
            borderStroke2 = borderStroke;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1022523063, i, -1, "androidx.wear.compose.material.ButtonDefaults.buttonBorder (Button.kt:553)");
        }
        DefaultButtonBorder defaultButtonBorder = new DefaultButtonBorder(borderStroke, borderStroke2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultButtonBorder;
    }

    /* JADX INFO: renamed from: outlinedButtonBorder-d_3_b6Q, reason: not valid java name */
    public final ButtonBorder m517outlinedButtonBorderd_3_b6Q(long j, long j2, float f, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1949232641, "C(outlinedButtonBorder)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,1:c#ui.unit.Dp)570@25277L6,571@25394L8:Button.kt#gj9v0t");
        long j3 = (i2 & 1) != 0 ? Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).getPrimaryVariant(), 0.6f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j;
        long j4 = (i2 & 2) != 0 ? Color.copy-wmQWz5c$default(j3, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j2;
        float f2 = (i2 & 4) != 0 ? Dp.constructor-impl(1) : f;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1949232641, i, -1, "androidx.wear.compose.material.ButtonDefaults.outlinedButtonBorder (Button.kt:573)");
        }
        DefaultButtonBorder defaultButtonBorder = new DefaultButtonBorder(BorderStrokeKt.BorderStroke-cXLIe8U(f2, j3), BorderStrokeKt.BorderStroke-cXLIe8U(f2, j4));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultButtonBorder;
    }

    /* JADX INFO: renamed from: getExtraSmallButtonSize-D9Ej5fM, reason: not valid java name */
    public final float m511getExtraSmallButtonSizeD9Ej5fM() {
        return ExtraSmallButtonSize;
    }

    /* JADX INFO: renamed from: getSmallButtonSize-D9Ej5fM, reason: not valid java name */
    public final float m514getSmallButtonSizeD9Ej5fM() {
        return SmallButtonSize;
    }

    /* JADX INFO: renamed from: getDefaultButtonSize-D9Ej5fM, reason: not valid java name */
    public final float m509getDefaultButtonSizeD9Ej5fM() {
        return DefaultButtonSize;
    }

    /* JADX INFO: renamed from: getLargeButtonSize-D9Ej5fM, reason: not valid java name */
    public final float m512getLargeButtonSizeD9Ej5fM() {
        return LargeButtonSize;
    }

    /* JADX INFO: renamed from: getSmallIconSize-D9Ej5fM, reason: not valid java name */
    public final float m515getSmallIconSizeD9Ej5fM() {
        return SmallIconSize;
    }

    /* JADX INFO: renamed from: getDefaultIconSize-D9Ej5fM, reason: not valid java name */
    public final float m510getDefaultIconSizeD9Ej5fM() {
        return DefaultIconSize;
    }

    /* JADX INFO: renamed from: getLargeIconSize-D9Ej5fM, reason: not valid java name */
    public final float m513getLargeIconSizeD9Ej5fM() {
        return LargeIconSize;
    }

    /* JADX INFO: renamed from: getCompactButtonBackgroundPadding-D9Ej5fM, reason: not valid java name */
    public final float m508getCompactButtonBackgroundPaddingD9Ej5fM() {
        return CompactButtonBackgroundPadding;
    }

    /* JADX INFO: renamed from: buttonColors-ro_MJ88, reason: not valid java name */
    public final ButtonColors m507buttonColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        long j5;
        long j6;
        ComposerKt.sourceInformationMarkerStart(composer, 1390637843, "C(buttonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)635@27524L6,636@27570L32,637@27687L8,638@27775L8:Button.kt#gj9v0t");
        long primary = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getPrimary() : j;
        long jM574contentColorForek8zF_U = (i2 & 2) != 0 ? ColorsKt.m574contentColorForek8zF_U(primary, composer, i & 14) : j2;
        long j7 = (i2 & 4) != 0 ? Color.copy-wmQWz5c$default(primary, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j3;
        if ((i2 & 8) != 0) {
            long j8 = jM574contentColorForek8zF_U;
            j5 = j8;
            j6 = Color.copy-wmQWz5c$default(j8, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j5 = jM574contentColorForek8zF_U;
            j6 = j4;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1390637843, i, -1, "androidx.wear.compose.material.ButtonDefaults.buttonColors (Button.kt:639)");
        }
        DefaultButtonColors defaultButtonColors = new DefaultButtonColors(primary, j5, j7, j6, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultButtonColors;
    }
}
