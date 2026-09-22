package androidx.wear.compose.material;

import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
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
import androidx.compose.ui.unit.TextUnitKt;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Typography.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0089\u0001\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005¢\u0006\u0002\u0010\u0011Bg\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005¢\u0006\u0002\u0010\u0012J~\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u0005J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020'H\u0016R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014¨\u0006("}, d2 = {"Landroidx/wear/compose/material/Typography;", "", "defaultFontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "display1", "Landroidx/compose/ui/text/TextStyle;", "display2", "display3", "title1", "title2", "title3", "body1", "body2", "button", "caption1", "caption2", "caption3", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;)V", "(Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;)V", "getBody1", "()Landroidx/compose/ui/text/TextStyle;", "getBody2", "getButton", "getCaption1", "getCaption2", "getCaption3", "getDisplay1", "getDisplay2", "getDisplay3", "getTitle1", "getTitle2", "getTitle3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Typography {
    public static final int $stable = 0;
    private final TextStyle body1;
    private final TextStyle body2;
    private final TextStyle button;
    private final TextStyle caption1;
    private final TextStyle caption2;
    private final TextStyle caption3;
    private final TextStyle display1;
    private final TextStyle display2;
    private final TextStyle display3;
    private final TextStyle title1;
    private final TextStyle title2;
    private final TextStyle title3;

    public Typography(TextStyle textStyle, TextStyle textStyle2, TextStyle textStyle3, TextStyle textStyle4, TextStyle textStyle5, TextStyle textStyle6, TextStyle textStyle7, TextStyle textStyle8, TextStyle textStyle9, TextStyle textStyle10, TextStyle textStyle11, TextStyle textStyle12) {
        this.display1 = textStyle;
        this.display2 = textStyle2;
        this.display3 = textStyle3;
        this.title1 = textStyle4;
        this.title2 = textStyle5;
        this.title3 = textStyle6;
        this.body1 = textStyle7;
        this.body2 = textStyle8;
        this.button = textStyle9;
        this.caption1 = textStyle10;
        this.caption2 = textStyle11;
        this.caption3 = textStyle12;
    }

    public final TextStyle getDisplay1() {
        return this.display1;
    }

    public final TextStyle getDisplay2() {
        return this.display2;
    }

    public final TextStyle getDisplay3() {
        return this.display3;
    }

    public final TextStyle getTitle1() {
        return this.title1;
    }

    public final TextStyle getTitle2() {
        return this.title2;
    }

    public final TextStyle getTitle3() {
        return this.title3;
    }

    public final TextStyle getBody1() {
        return this.body1;
    }

    public final TextStyle getBody2() {
        return this.body2;
    }

    public final TextStyle getButton() {
        return this.button;
    }

    public final TextStyle getCaption1() {
        return this.caption1;
    }

    public final TextStyle getCaption2() {
        return this.caption2;
    }

    public final TextStyle getCaption3() {
        return this.caption3;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ Typography(FontFamily fontFamily, TextStyle textStyle, TextStyle textStyle2, TextStyle textStyle3, TextStyle textStyle4, TextStyle textStyle5, TextStyle textStyle6, TextStyle textStyle7, TextStyle textStyle8, TextStyle textStyle9, TextStyle textStyle10, TextStyle textStyle11, TextStyle textStyle12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        TextStyle textStyle13;
        TextStyle textStyle14;
        TextStyle textStyle15;
        TextStyle textStyle16;
        TextStyle textStyle17;
        TextStyle textStyle18;
        TextStyle textStyle19;
        TextStyle textStyle20;
        TextStyle textStyle21;
        TextStyle textStyle22;
        TextStyle textStyle23;
        TextStyle textStyle24;
        FontFamily fontFamily2 = (i & 1) != 0 ? (FontFamily) FontFamily.Companion.getDefault() : fontFamily;
        if ((i & 2) != 0) {
            textStyle13 = TextStyle.copy-p1EtxEg$default(TypographyKt.getDefaultTextStyle(), 0L, TextUnitKt.getSp(40), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0.5d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(46), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646009, (Object) null);
        } else {
            textStyle13 = textStyle;
        }
        if ((i & 4) != 0) {
            textStyle14 = TextStyle.copy-p1EtxEg$default(TypographyKt.getDefaultTextStyle(), 0L, TextUnitKt.getSp(34), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(1), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(40), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646009, (Object) null);
        } else {
            textStyle14 = textStyle2;
        }
        if ((i & 8) != 0) {
            textStyle15 = TextStyle.copy-p1EtxEg$default(TypographyKt.getDefaultTextStyle(), 0L, TextUnitKt.getSp(30), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0.8d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(36), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646009, (Object) null);
        } else {
            textStyle15 = textStyle3;
        }
        if ((i & 16) != 0) {
            textStyle16 = TextStyle.copy-p1EtxEg$default(TypographyKt.getDefaultTextStyle(), 0L, TextUnitKt.getSp(24), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0.2d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(28), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646009, (Object) null);
        } else {
            textStyle16 = textStyle4;
        }
        if ((i & 32) != 0) {
            textStyle17 = TextStyle.copy-p1EtxEg$default(TypographyKt.getDefaultTextStyle(), 0L, TextUnitKt.getSp(20), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0.2d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(24), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646009, (Object) null);
        } else {
            textStyle17 = textStyle5;
        }
        if ((i & 64) != 0) {
            textStyle18 = TextStyle.copy-p1EtxEg$default(TypographyKt.getDefaultTextStyle(), 0L, TextUnitKt.getSp(16), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0.2d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(20), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646009, (Object) null);
        } else {
            textStyle18 = textStyle6;
        }
        if ((i & 128) != 0) {
            textStyle19 = TextStyle.copy-p1EtxEg$default(TypographyKt.getDefaultTextStyle(), 0L, TextUnitKt.getSp(16), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0.18d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(20), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646009, (Object) null);
        } else {
            textStyle19 = textStyle7;
        }
        if ((i & 256) != 0) {
            textStyle20 = TextStyle.copy-p1EtxEg$default(TypographyKt.getDefaultTextStyle(), 0L, TextUnitKt.getSp(14), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0.2d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(18), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646009, (Object) null);
        } else {
            textStyle20 = textStyle8;
        }
        if ((i & 512) != 0) {
            textStyle21 = TextStyle.copy-p1EtxEg$default(TypographyKt.getDefaultTextStyle(), 0L, TextUnitKt.getSp(15), FontWeight.Companion.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0.38d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(19), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646009, (Object) null);
        } else {
            textStyle21 = textStyle9;
        }
        if ((i & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0) {
            textStyle22 = TextStyle.copy-p1EtxEg$default(TypographyKt.getDefaultTextStyle(), 0L, TextUnitKt.getSp(14), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0.1d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(18), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646009, (Object) null);
        } else {
            textStyle22 = textStyle10;
        }
        if ((i & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
            textStyle23 = TextStyle.copy-p1EtxEg$default(TypographyKt.getDefaultTextStyle(), 0L, TextUnitKt.getSp(12), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0.1d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(16), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646009, (Object) null);
        } else {
            textStyle23 = textStyle11;
        }
        if ((i & 4096) != 0) {
            textStyle24 = TextStyle.copy-p1EtxEg$default(TypographyKt.getDefaultTextStyle(), 0L, TextUnitKt.getSp(10), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0.1d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(14), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646009, (Object) null);
        } else {
            textStyle24 = textStyle12;
        }
        this(fontFamily2, textStyle13, textStyle14, textStyle15, textStyle16, textStyle17, textStyle18, textStyle19, textStyle20, textStyle21, textStyle22, textStyle23, textStyle24);
    }

    public Typography(FontFamily fontFamily, TextStyle textStyle, TextStyle textStyle2, TextStyle textStyle3, TextStyle textStyle4, TextStyle textStyle5, TextStyle textStyle6, TextStyle textStyle7, TextStyle textStyle8, TextStyle textStyle9, TextStyle textStyle10, TextStyle textStyle11, TextStyle textStyle12) {
        this(TypographyKt.withDefaultFontFamily(textStyle, fontFamily), TypographyKt.withDefaultFontFamily(textStyle2, fontFamily), TypographyKt.withDefaultFontFamily(textStyle3, fontFamily), TypographyKt.withDefaultFontFamily(textStyle4, fontFamily), TypographyKt.withDefaultFontFamily(textStyle5, fontFamily), TypographyKt.withDefaultFontFamily(textStyle6, fontFamily), TypographyKt.withDefaultFontFamily(textStyle7, fontFamily), TypographyKt.withDefaultFontFamily(textStyle8, fontFamily), TypographyKt.withDefaultFontFamily(textStyle9, fontFamily), TypographyKt.withDefaultFontFamily(textStyle10, fontFamily), TypographyKt.withDefaultFontFamily(textStyle11, fontFamily), TypographyKt.withDefaultFontFamily(textStyle12, fontFamily));
    }

    public static /* synthetic */ Typography copy$default(Typography typography, TextStyle textStyle, TextStyle textStyle2, TextStyle textStyle3, TextStyle textStyle4, TextStyle textStyle5, TextStyle textStyle6, TextStyle textStyle7, TextStyle textStyle8, TextStyle textStyle9, TextStyle textStyle10, TextStyle textStyle11, TextStyle textStyle12, int i, Object obj) {
        if ((i & 1) != 0) {
            textStyle = typography.display1;
        }
        if ((i & 2) != 0) {
            textStyle2 = typography.display2;
        }
        if ((i & 4) != 0) {
            textStyle3 = typography.display3;
        }
        if ((i & 8) != 0) {
            textStyle4 = typography.title1;
        }
        if ((i & 16) != 0) {
            textStyle5 = typography.title2;
        }
        if ((i & 32) != 0) {
            textStyle6 = typography.title3;
        }
        if ((i & 64) != 0) {
            textStyle7 = typography.body1;
        }
        if ((i & 128) != 0) {
            textStyle8 = typography.body2;
        }
        if ((i & 256) != 0) {
            textStyle9 = typography.button;
        }
        if ((i & 512) != 0) {
            textStyle10 = typography.caption1;
        }
        if ((i & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0) {
            textStyle11 = typography.caption2;
        }
        if ((i & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
            textStyle12 = typography.caption3;
        }
        TextStyle textStyle13 = textStyle11;
        TextStyle textStyle14 = textStyle12;
        TextStyle textStyle15 = textStyle9;
        TextStyle textStyle16 = textStyle10;
        TextStyle textStyle17 = textStyle7;
        TextStyle textStyle18 = textStyle8;
        TextStyle textStyle19 = textStyle5;
        TextStyle textStyle20 = textStyle6;
        return typography.copy(textStyle, textStyle2, textStyle3, textStyle4, textStyle19, textStyle20, textStyle17, textStyle18, textStyle15, textStyle16, textStyle13, textStyle14);
    }

    public final Typography copy(TextStyle display1, TextStyle display2, TextStyle display3, TextStyle title1, TextStyle title2, TextStyle title3, TextStyle body1, TextStyle body2, TextStyle button, TextStyle caption1, TextStyle caption2, TextStyle caption3) {
        return new Typography(display1, display2, display3, title1, title2, title3, body1, body2, button, caption1, caption2, caption3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Typography)) {
            return false;
        }
        Typography typography = (Typography) other;
        return Intrinsics.areEqual(this.display1, typography.display1) && Intrinsics.areEqual(this.display2, typography.display2) && Intrinsics.areEqual(this.display3, typography.display3) && Intrinsics.areEqual(this.title1, typography.title1) && Intrinsics.areEqual(this.title2, typography.title2) && Intrinsics.areEqual(this.title3, typography.title3) && Intrinsics.areEqual(this.body1, typography.body1) && Intrinsics.areEqual(this.body2, typography.body2) && Intrinsics.areEqual(this.button, typography.button) && Intrinsics.areEqual(this.caption1, typography.caption1) && Intrinsics.areEqual(this.caption2, typography.caption2) && Intrinsics.areEqual(this.caption3, typography.caption3);
    }

    public int hashCode() {
        return (((((((((((((((((((((this.display1.hashCode() * 31) + this.display2.hashCode()) * 31) + this.display3.hashCode()) * 31) + this.title1.hashCode()) * 31) + this.title2.hashCode()) * 31) + this.title3.hashCode()) * 31) + this.body1.hashCode()) * 31) + this.body2.hashCode()) * 31) + this.button.hashCode()) * 31) + this.caption1.hashCode()) * 31) + this.caption2.hashCode()) * 31) + this.caption3.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Typography(display1=");
        sb.append(this.display1).append(", display2=").append(this.display2).append(", display3=").append(this.display3).append(", title1=").append(this.title1).append(", title2=").append(this.title2).append(", title3=").append(this.title3).append(", body1=").append(this.body1).append(", body2=").append(this.body2).append(", button=").append(this.button).append(", caption1=").append(this.caption1).append(", caption2=").append(this.caption2).append(", caption3=");
        sb.append(this.caption3).append(')');
        return sb.toString();
    }
}
