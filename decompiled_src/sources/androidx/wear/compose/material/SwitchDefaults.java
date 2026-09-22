package androidx.wear.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;

/* JADX INFO: compiled from: ToggleControl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, d2 = {"Landroidx/wear/compose/material/SwitchDefaults;", "", "()V", "colors", "Landroidx/wear/compose/material/SwitchColors;", "checkedThumbColor", "Landroidx/compose/ui/graphics/Color;", "checkedTrackColor", "uncheckedThumbColor", "uncheckedTrackColor", "colors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/wear/compose/material/SwitchColors;", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SwitchDefaults {
    public static final int $stable = 0;
    public static final SwitchDefaults INSTANCE = new SwitchDefaults();

    private SwitchDefaults() {
    }

    /* JADX INFO: renamed from: colors-ro_MJ88, reason: not valid java name */
    public final SwitchColors m841colorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        long j5;
        ComposerKt.sourceInformationMarkerStart(composer, 2112719026, "C(colors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)352@13825L6,353@13922L8,354@13984L6,356@14144L8,363@14483L17,365@14655L8,364@14560L104,368@14837L8,367@14740L106,371@15019L8,370@14922L106:ToggleControl.kt#gj9v0t");
        long secondary = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getSecondary() : j;
        long j6 = (i2 & 2) != 0 ? Color.copy-wmQWz5c$default(secondary, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j2;
        long j7 = (i2 & 4) != 0 ? Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).getOnSurface(), 0.6f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j3;
        if ((i2 & 8) != 0) {
            j5 = Color.copy-wmQWz5c$default(j7, Color.getAlpha-impl(j7) * ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j5 = j4;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2112719026, i, -1, "androidx.wear.compose.material.SwitchDefaults.colors (ToggleControl.kt:357)");
        }
        long j8 = secondary;
        DefaultSwitchColors defaultSwitchColors = new DefaultSwitchColors(j8, j6, j7, j5, ColorsKt.m575toDisabledColor3JVO9M(j8, 0.0f, composer, i & 14, 1), ColorsKt.m575toDisabledColor3JVO9M(j6, Color.getAlpha-impl(j6) * ContentAlpha.INSTANCE.getDisabled(composer, 6), composer, (i >> 3) & 14, 0), ColorsKt.m575toDisabledColor3JVO9M(j7, Color.getAlpha-impl(j7) * ContentAlpha.INSTANCE.getDisabled(composer, 6), composer, (i >> 6) & 14, 0), ColorsKt.m575toDisabledColor3JVO9M(j5, Color.getAlpha-impl(j5) * ContentAlpha.INSTANCE.getDisabled(composer, 6), composer, (i >> 9) & 14, 0), null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultSwitchColors;
    }
}
