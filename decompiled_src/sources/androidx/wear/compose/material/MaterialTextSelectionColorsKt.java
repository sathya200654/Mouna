package androidx.wear.compose.material;

import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MaterialTextSelectionColors.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\"\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0000ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a2\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a*\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0015\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0001¢\u0006\u0002\u0010\u001a\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"DefaultSelectionBackgroundAlpha", "", "DesiredContrastRatio", "MinimumSelectionBackgroundAlpha", "binarySearchForAccessibleSelectionColorAlpha", "selectionColor", "Landroidx/compose/ui/graphics/Color;", "textColor", "backgroundColor", "binarySearchForAccessibleSelectionColorAlpha-ysEtTa8", "(JJJ)F", "calculateContrastRatio", "foreground", "background", "calculateContrastRatio--OWjLjI", "(JJ)F", "selectionColorAlpha", "calculateContrastRatio-nb2GgbA", "(JFJJ)F", "calculateSelectionBackgroundColor", "calculateSelectionBackgroundColor-ysEtTa8", "(JJJ)J", "rememberTextSelectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "colors", "Landroidx/wear/compose/material/Colors;", "(Landroidx/wear/compose/material/Colors;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/text/selection/TextSelectionColors;", "compose-material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MaterialTextSelectionColorsKt {
    private static final float DefaultSelectionBackgroundAlpha = 0.4f;
    private static final float DesiredContrastRatio = 4.5f;
    private static final float MinimumSelectionBackgroundAlpha = 0.2f;

    public static final TextSelectionColors rememberTextSelectionColors(Colors colors, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -795744188, "C(rememberTextSelectionColors)44@1906L6,46@1934L384:MaterialTextSelectionColors.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-795744188, i, -1, "androidx.wear.compose.material.rememberTextSelectionColors (MaterialTextSelectionColors.kt:34)");
        }
        long primary = colors.getPrimary();
        long background = colors.getBackground();
        composer.startReplaceGroup(592585981);
        ComposerKt.sourceInformation(composer, "*42@1849L7");
        long jM573contentColorFor4WTKRHQ = ColorsKt.m573contentColorFor4WTKRHQ(colors, background);
        if (jM573contentColorFor4WTKRHQ == 16) {
            CompositionLocal localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd(composer);
            jM573contentColorFor4WTKRHQ = ((Color) objConsume).unbox-impl();
        }
        composer.endReplaceGroup();
        long j = Color.copy-wmQWz5c$default(jM573contentColorFor4WTKRHQ, ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        ComposerKt.sourceInformationMarkerStart(composer, 592590401, "CC(remember):MaterialTextSelectionColors.kt#9igjgp");
        boolean zChanged = composer.changed(primary) | composer.changed(background) | composer.changed(j);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            TextSelectionColors textSelectionColors = new TextSelectionColors(colors.getPrimary(), m618calculateSelectionBackgroundColorysEtTa8(primary, j, background), (DefaultConstructorMarker) null);
            composer.updateRememberedValue(textSelectionColors);
            objRememberedValue = textSelectionColors;
        }
        TextSelectionColors textSelectionColors2 = (TextSelectionColors) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return textSelectionColors2;
    }

    /* JADX INFO: renamed from: calculateSelectionBackgroundColor-ysEtTa8, reason: not valid java name */
    public static final long m618calculateSelectionBackgroundColorysEtTa8(long j, long j2, long j3) {
        float fM615binarySearchForAccessibleSelectionColorAlphaysEtTa8;
        float fM617calculateContrastRationb2GgbA = m617calculateContrastRationb2GgbA(j, DefaultSelectionBackgroundAlpha, j2, j3);
        float fM617calculateContrastRationb2GgbA2 = m617calculateContrastRationb2GgbA(j, MinimumSelectionBackgroundAlpha, j2, j3);
        if (fM617calculateContrastRationb2GgbA >= DesiredContrastRatio) {
            fM615binarySearchForAccessibleSelectionColorAlphaysEtTa8 = DefaultSelectionBackgroundAlpha;
        } else {
            fM615binarySearchForAccessibleSelectionColorAlphaysEtTa8 = fM617calculateContrastRationb2GgbA2 < DesiredContrastRatio ? MinimumSelectionBackgroundAlpha : m615binarySearchForAccessibleSelectionColorAlphaysEtTa8(j, j2, j3);
        }
        return Color.copy-wmQWz5c$default(j, fM615binarySearchForAccessibleSelectionColorAlphaysEtTa8, 0.0f, 0.0f, 0.0f, 14, (Object) null);
    }

    /* JADX INFO: renamed from: binarySearchForAccessibleSelectionColorAlpha-ysEtTa8, reason: not valid java name */
    private static final float m615binarySearchForAccessibleSelectionColorAlphaysEtTa8(long j, long j2, long j3) {
        int i = 0;
        float f = MinimumSelectionBackgroundAlpha;
        float f2 = 0.4f;
        float f3 = 0.4f;
        while (i < 7) {
            long j4 = j;
            long j5 = j2;
            long j6 = j3;
            float fM617calculateContrastRationb2GgbA = (m617calculateContrastRationb2GgbA(j4, f2, j5, j6) / DesiredContrastRatio) - 1.0f;
            if (0.0f <= fM617calculateContrastRationb2GgbA && fM617calculateContrastRationb2GgbA <= 0.01f) {
                return f2;
            }
            if (fM617calculateContrastRationb2GgbA < 0.0f) {
                f3 = f2;
            } else {
                f = f2;
            }
            f2 = (f3 + f) / 2.0f;
            i++;
            j = j4;
            j2 = j5;
            j3 = j6;
        }
        return f2;
    }

    /* JADX INFO: renamed from: calculateContrastRatio-nb2GgbA, reason: not valid java name */
    private static final float m617calculateContrastRationb2GgbA(long j, float f, long j2, long j3) {
        long j4 = ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(j, f, 0.0f, 0.0f, 0.0f, 14, (Object) null), j3);
        return m616calculateContrastRatioOWjLjI(ColorKt.compositeOver--OWjLjI(j2, j4), j4);
    }

    /* JADX INFO: renamed from: calculateContrastRatio--OWjLjI, reason: not valid java name */
    public static final float m616calculateContrastRatioOWjLjI(long j, long j2) {
        float f = ColorKt.luminance-8_81llA(j) + 0.05f;
        float f2 = ColorKt.luminance-8_81llA(j2) + 0.05f;
        return Math.max(f, f2) / Math.min(f, f2);
    }
}
