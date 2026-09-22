package androidx.wear.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: compiled from: ToggleButton.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jb\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00162\b\b\u0002\u0010\u001a\u001a\u00020\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u00162\b\b\u0002\u0010\u001d\u001a\u00020\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000e\u0010\u0006R\u0019\u0010\u000f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0010\u0010\u0006R\u0019\u0010\u0011\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0012\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, d2 = {"Landroidx/wear/compose/material/ToggleButtonDefaults;", "", "()V", "DefaultIconSize", "Landroidx/compose/ui/unit/Dp;", "getDefaultIconSize-D9Ej5fM", "()F", "F", "DefaultRole", "Landroidx/compose/ui/semantics/Role;", "getDefaultRole-o7Vup1c", "()I", "I", "DefaultToggleButtonSize", "getDefaultToggleButtonSize-D9Ej5fM", "SmallIconSize", "getSmallIconSize-D9Ej5fM", "SmallToggleButtonSize", "getSmallToggleButtonSize-D9Ej5fM", "toggleButtonColors", "Landroidx/wear/compose/material/ToggleButtonColors;", "checkedBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "checkedContentColor", "disabledCheckedBackgroundColor", "disabledCheckedContentColor", "uncheckedBackgroundColor", "uncheckedContentColor", "disabledUncheckedBackgroundColor", "disabledUncheckedContentColor", "toggleButtonColors-oq7We08", "(JJJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/wear/compose/material/ToggleButtonColors;", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ToggleButtonDefaults {
    public static final int $stable = 0;
    public static final ToggleButtonDefaults INSTANCE = new ToggleButtonDefaults();
    private static final float SmallToggleButtonSize = Dp.constructor-impl(48);
    private static final float DefaultToggleButtonSize = Dp.constructor-impl(52);
    private static final float SmallIconSize = Dp.constructor-impl(24);
    private static final float DefaultIconSize = Dp.constructor-impl(26);
    private static final int DefaultRole = Role.Companion.getCheckbox-o7Vup1c();

    private ToggleButtonDefaults() {
    }

    /* JADX INFO: renamed from: getSmallToggleButtonSize-D9Ej5fM, reason: not valid java name */
    public final float m855getSmallToggleButtonSizeD9Ej5fM() {
        return SmallToggleButtonSize;
    }

    /* JADX INFO: renamed from: getDefaultToggleButtonSize-D9Ej5fM, reason: not valid java name */
    public final float m853getDefaultToggleButtonSizeD9Ej5fM() {
        return DefaultToggleButtonSize;
    }

    /* JADX INFO: renamed from: getSmallIconSize-D9Ej5fM, reason: not valid java name */
    public final float m854getSmallIconSizeD9Ej5fM() {
        return SmallIconSize;
    }

    /* JADX INFO: renamed from: getDefaultIconSize-D9Ej5fM, reason: not valid java name */
    public final float m851getDefaultIconSizeD9Ej5fM() {
        return DefaultIconSize;
    }

    /* JADX INFO: renamed from: getDefaultRole-o7Vup1c, reason: not valid java name */
    public final int m852getDefaultRoleo7Vup1c() {
        return DefaultRole;
    }

    /* JADX INFO: renamed from: toggleButtonColors-oq7We08, reason: not valid java name */
    public final ToggleButtonColors m856toggleButtonColorsoq7We08(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, Composer composer, int i, int i2) {
        long j9;
        long j10;
        long j11;
        ComposerKt.sourceInformationMarkerStart(composer, -840855569, "C(toggleButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,6:c#ui.graphics.Color,7:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.graphics.Color)316@14168L6,317@14221L39,319@14371L8,320@14441L6,321@14516L6,322@14571L41,324@14727L8,326@14845L8:ToggleButton.kt#gj9v0t");
        long primary = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getPrimary() : j;
        long jM574contentColorForek8zF_U = (i2 & 2) != 0 ? ColorsKt.m574contentColorForek8zF_U(primary, composer, i & 14) : j2;
        long j12 = (i2 & 4) != 0 ? Color.copy-wmQWz5c$default(primary, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j3;
        long background = (i2 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getBackground() : j4;
        long surface = (i2 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getSurface() : j5;
        long jM574contentColorForek8zF_U2 = (i2 & 32) != 0 ? ColorsKt.m574contentColorForek8zF_U(surface, composer, (i >> 12) & 14) : j6;
        if ((i2 & 64) != 0) {
            long j13 = surface;
            j9 = j13;
            j10 = Color.copy-wmQWz5c$default(j13, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j9 = surface;
            j10 = j7;
        }
        if ((i2 & 128) != 0) {
            j11 = Color.copy-wmQWz5c$default(jM574contentColorForek8zF_U2, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j11 = j8;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-840855569, i, -1, "androidx.wear.compose.material.ToggleButtonDefaults.toggleButtonColors (ToggleButton.kt:327)");
        }
        DefaultToggleButtonColors defaultToggleButtonColors = new DefaultToggleButtonColors(primary, jM574contentColorForek8zF_U, j12, background, j9, jM574contentColorForek8zF_U2, j10, j11, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultToggleButtonColors;
    }
}
