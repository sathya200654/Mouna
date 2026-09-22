package androidx.wear.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: ToggleControl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, d2 = {"Landroidx/wear/compose/material/CheckboxDefaults;", "", "()V", "colors", "Landroidx/wear/compose/material/CheckboxColors;", "checkedBoxColor", "Landroidx/compose/ui/graphics/Color;", "checkedCheckmarkColor", "uncheckedBoxColor", "uncheckedCheckmarkColor", "colors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/wear/compose/material/CheckboxColors;", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CheckboxDefaults {
    public static final int $stable = 0;
    public static final CheckboxDefaults INSTANCE = new CheckboxDefaults();

    private CheckboxDefaults() {
    }

    /* JADX INFO: renamed from: colors-ro_MJ88, reason: not valid java name */
    public final CheckboxColors m531colorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 645474258, "C(colors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)313@12208L6,316@12360L6,317@12439L6,315@12317L147,327@12874L17,329@12971L17,331@13060L17,333@13161L17:ToggleControl.kt#gj9v0t");
        long secondary = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).getSecondary() : j;
        long j5 = (i2 & 2) != 0 ? secondary : j2;
        long jM574contentColorForek8zF_U = (i2 & 4) != 0 ? ColorsKt.m574contentColorForek8zF_U(ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).getPrimary(), 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColors(composer, 6).getSurface()), composer, 0) : j3;
        long j6 = (i2 & 8) != 0 ? jM574contentColorForek8zF_U : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(645474258, i, -1, "androidx.wear.compose.material.CheckboxDefaults.colors (ToggleControl.kt:320)");
        }
        DefaultCheckboxColors defaultCheckboxColors = new DefaultCheckboxColors(secondary, j5, j6, jM574contentColorForek8zF_U, ColorsKt.m575toDisabledColor3JVO9M(secondary, 0.0f, composer, i & 14, 1), ColorsKt.m575toDisabledColor3JVO9M(j5, 0.0f, composer, (i >> 3) & 14, 1), ColorsKt.m575toDisabledColor3JVO9M(jM574contentColorForek8zF_U, 0.0f, composer, (i >> 6) & 14, 1), ColorsKt.m575toDisabledColor3JVO9M(j6, 0.0f, composer, (i >> 9) & 14, 1), null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultCheckboxColors;
    }
}
