package com.deepvisiontech.letstalksigntranscriptionapp.legacy.ui.theme;

import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyKt;
import androidx.compose.ui.text.font.FontKt;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import kotlin.Metadata;

/* JADX INFO: compiled from: Type.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"customFontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "getCustomFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "appTypography", "Landroidx/compose/material3/Typography;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/Typography;", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TypeKt {
    private static final FontFamily customFontFamily = FontFamilyKt.FontFamily(new Font[]{FontKt.Font-YpTlLL0$default(R.font.rimouski_sb_regular, (FontWeight) null, 0, 0, 14, (Object) null)});

    public static final FontFamily getCustomFontFamily() {
        return customFontFamily;
    }

    public static final Typography appTypography(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -543545012, "C(appTypography)17@607L10:Type.kt#cx00st");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-543545012, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.legacy.ui.theme.appTypography (Type.kt:16)");
        }
        Typography typography = MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable);
        TextStyle displayLarge = typography.getDisplayLarge();
        FontFamily fontFamily = customFontFamily;
        Typography typography2 = new Typography(TextStyle.copy-p1EtxEg$default(displayLarge, 0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, fontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777183, (Object) null), TextStyle.copy-p1EtxEg$default(typography.getDisplayMedium(), 0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, fontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777183, (Object) null), TextStyle.copy-p1EtxEg$default(typography.getDisplaySmall(), 0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, fontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777183, (Object) null), TextStyle.copy-p1EtxEg$default(typography.getHeadlineLarge(), 0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, fontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777183, (Object) null), TextStyle.copy-p1EtxEg$default(typography.getHeadlineMedium(), 0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, fontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777183, (Object) null), TextStyle.copy-p1EtxEg$default(typography.getHeadlineSmall(), 0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, fontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777183, (Object) null), TextStyle.copy-p1EtxEg$default(typography.getTitleLarge(), 0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, fontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777183, (Object) null), TextStyle.copy-p1EtxEg$default(typography.getTitleMedium(), 0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, fontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777183, (Object) null), TextStyle.copy-p1EtxEg$default(typography.getTitleSmall(), 0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, fontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777183, (Object) null), TextStyle.copy-p1EtxEg$default(typography.getBodyLarge(), 0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, fontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777183, (Object) null), TextStyle.copy-p1EtxEg$default(typography.getBodyMedium(), 0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, fontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777183, (Object) null), TextStyle.copy-p1EtxEg$default(typography.getBodySmall(), 0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, fontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777183, (Object) null), TextStyle.copy-p1EtxEg$default(typography.getLabelLarge(), 0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, fontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777183, (Object) null), TextStyle.copy-p1EtxEg$default(typography.getLabelMedium(), 0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, fontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777183, (Object) null), TextStyle.copy-p1EtxEg$default(typography.getLabelSmall(), 0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, fontFamily, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777183, (Object) null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return typography2;
    }
}
