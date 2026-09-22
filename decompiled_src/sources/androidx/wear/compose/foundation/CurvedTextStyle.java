package androidx.wear.compose.foundation;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CurvedTextStyle.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nBS\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J0\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J^\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012ø\u0001\u0000¢\u0006\u0004\b$\u0010%J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010)\u001a\u00020*H\u0016J\u0012\u0010+\u001a\u00020\u00002\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0000J\u0011\u0010,\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u0000H\u0086\u0002J\b\u0010-\u001a\u00020.H\u0016R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001a\u0010\u0015R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u0012ø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 \u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006/"}, d2 = {"Landroidx/wear/compose/foundation/CurvedTextStyle;", "", "background", "Landroidx/compose/ui/graphics/Color;", "color", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "style", "Landroidx/compose/ui/text/TextStyle;", "(Landroidx/compose/ui/text/TextStyle;)V", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "(JJJLandroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBackground-0d7_KjU", "()J", "J", "getColor-0d7_KjU", "getFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "getFontSize-XSAIIZE", "getFontStyle-4Lr2A7w", "()Landroidx/compose/ui/text/font/FontStyle;", "getFontSynthesis-ZQGJjVo", "()Landroidx/compose/ui/text/font/FontSynthesis;", "getFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "copy", "copy-rRnh6Vg", "(JJJ)Landroidx/wear/compose/foundation/CurvedTextStyle;", "copy-xgAEyWg", "(JJJLandroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;)Landroidx/wear/compose/foundation/CurvedTextStyle;", "equals", "", "other", "hashCode", "", "merge", "plus", "toString", "", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CurvedTextStyle {
    public static final int $stable = 0;
    private final long background;
    private final long color;
    private final FontFamily fontFamily;
    private final long fontSize;
    private final FontStyle fontStyle;
    private final FontSynthesis fontSynthesis;
    private final FontWeight fontWeight;

    public /* synthetic */ CurvedTextStyle(long j, long j2, long j3, FontFamily fontFamily, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, fontFamily, fontWeight, fontStyle, fontSynthesis);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This overload is provided for backwards compatibility with Compose for Wear OS 1.0. A newer overload is available with additional font parameters.")
    public /* synthetic */ CurvedTextStyle(long j, long j2, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3);
    }

    private CurvedTextStyle(long j, long j2, long j3, FontFamily fontFamily, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis) {
        this.background = j;
        this.color = j2;
        this.fontSize = j3;
        this.fontFamily = fontFamily;
        this.fontWeight = fontWeight;
        this.fontStyle = fontStyle;
        this.fontSynthesis = fontSynthesis;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ CurvedTextStyle(long j, long j2, long j3, FontFamily fontFamily, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, int i, DefaultConstructorMarker defaultConstructorMarker) {
        long j4 = (i & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : j;
        long j5 = (i & 2) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : j2;
        long j6 = (i & 4) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : j3;
        FontFamily fontFamily2 = (i & 8) != 0 ? null : fontFamily;
        FontWeight fontWeight2 = (i & 16) != 0 ? null : fontWeight;
        FontStyle fontStyle2 = (i & 32) != 0 ? null : fontStyle;
        this(j4, j5, j6, fontFamily2, fontWeight2, fontStyle2, (i & 64) == 0 ? fontSynthesis : null, null);
    }

    /* JADX INFO: renamed from: getBackground-0d7_KjU, reason: not valid java name and from getter */
    public final long getBackground() {
        return this.background;
    }

    /* JADX INFO: renamed from: getColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: getFontSize-XSAIIZE, reason: not valid java name and from getter */
    public final long getFontSize() {
        return this.fontSize;
    }

    public final FontFamily getFontFamily() {
        return this.fontFamily;
    }

    public final FontWeight getFontWeight() {
        return this.fontWeight;
    }

    /* JADX INFO: renamed from: getFontStyle-4Lr2A7w, reason: not valid java name and from getter */
    public final FontStyle getFontStyle() {
        return this.fontStyle;
    }

    /* JADX INFO: renamed from: getFontSynthesis-ZQGJjVo, reason: not valid java name and from getter */
    public final FontSynthesis getFontSynthesis() {
        return this.fontSynthesis;
    }

    public /* synthetic */ CurvedTextStyle(long j, long j2, long j3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : j, (i & 2) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : j2, (i & 4) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : j3, null);
    }

    private CurvedTextStyle(long j, long j2, long j3) {
        this(j, j2, j3, null, null, null, null, 112, null);
    }

    public CurvedTextStyle(TextStyle textStyle) {
        this(textStyle.getBackground-0d7_KjU(), textStyle.getColor-0d7_KjU(), textStyle.getFontSize-XSAIIZE(), textStyle.getFontFamily(), textStyle.getFontWeight(), textStyle.getFontStyle-4Lr2A7w(), textStyle.getFontSynthesis-ZQGJjVo(), null);
    }

    public static /* synthetic */ CurvedTextStyle merge$default(CurvedTextStyle curvedTextStyle, CurvedTextStyle curvedTextStyle2, int i, Object obj) {
        if ((i & 1) != 0) {
            curvedTextStyle2 = null;
        }
        return curvedTextStyle.merge(curvedTextStyle2);
    }

    public final CurvedTextStyle merge(CurvedTextStyle other) {
        if (other == null) {
            return this;
        }
        long j = other.color;
        if (j == 16) {
            j = this.color;
        }
        long j2 = j;
        long j3 = !TextUnitKt.isUnspecified--R2X_6o(other.fontSize) ? other.fontSize : this.fontSize;
        long j4 = other.background;
        if (j4 == 16) {
            j4 = this.background;
        }
        long j5 = j4;
        FontFamily fontFamily = other.fontFamily;
        if (fontFamily == null) {
            fontFamily = this.fontFamily;
        }
        FontFamily fontFamily2 = fontFamily;
        FontWeight fontWeight = other.fontWeight;
        if (fontWeight == null) {
            fontWeight = this.fontWeight;
        }
        FontWeight fontWeight2 = fontWeight;
        FontStyle fontStyle = other.fontStyle;
        if (fontStyle == null) {
            fontStyle = this.fontStyle;
        }
        FontStyle fontStyle2 = fontStyle;
        FontSynthesis fontSynthesis = other.fontSynthesis;
        if (fontSynthesis == null) {
            fontSynthesis = this.fontSynthesis;
        }
        return new CurvedTextStyle(j5, j2, j3, fontFamily2, fontWeight2, fontStyle2, fontSynthesis, null);
    }

    public final CurvedTextStyle plus(CurvedTextStyle other) {
        return merge(other);
    }

    /* JADX INFO: renamed from: copy-rRnh6Vg$default, reason: not valid java name */
    public static /* synthetic */ CurvedTextStyle m361copyrRnh6Vg$default(CurvedTextStyle curvedTextStyle, long j, long j2, long j3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = curvedTextStyle.background;
        }
        long j4 = j;
        if ((i & 2) != 0) {
            j2 = curvedTextStyle.color;
        }
        long j5 = j2;
        if ((i & 4) != 0) {
            j3 = curvedTextStyle.fontSize;
        }
        return curvedTextStyle.m363copyrRnh6Vg(j4, j5, j3);
    }

    @Deprecated(message = "This overload is provided for backwards compatibility with Compose for Wear OS 1.0. A newer overload is available with additional font parameters.")
    /* JADX INFO: renamed from: copy-rRnh6Vg, reason: not valid java name */
    public final CurvedTextStyle m363copyrRnh6Vg(long background, long color, long fontSize) {
        return new CurvedTextStyle(background, color, fontSize, this.fontFamily, this.fontWeight, this.fontStyle, this.fontSynthesis, null);
    }

    /* JADX INFO: renamed from: copy-xgAEyWg$default, reason: not valid java name */
    public static /* synthetic */ CurvedTextStyle m362copyxgAEyWg$default(CurvedTextStyle curvedTextStyle, long j, long j2, long j3, FontFamily fontFamily, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, int i, Object obj) {
        if ((i & 1) != 0) {
            j = curvedTextStyle.background;
        }
        long j4 = j;
        if ((i & 2) != 0) {
            j2 = curvedTextStyle.color;
        }
        return curvedTextStyle.m364copyxgAEyWg(j4, j2, (i & 4) != 0 ? curvedTextStyle.fontSize : j3, (i & 8) != 0 ? curvedTextStyle.fontFamily : fontFamily, (i & 16) != 0 ? curvedTextStyle.fontWeight : fontWeight, (i & 32) != 0 ? curvedTextStyle.fontStyle : fontStyle, (i & 64) != 0 ? curvedTextStyle.fontSynthesis : fontSynthesis);
    }

    /* JADX INFO: renamed from: copy-xgAEyWg, reason: not valid java name */
    public final CurvedTextStyle m364copyxgAEyWg(long background, long color, long fontSize, FontFamily fontFamily, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis) {
        return new CurvedTextStyle(background, color, fontSize, fontFamily, fontWeight, fontStyle, fontSynthesis, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CurvedTextStyle)) {
            return false;
        }
        CurvedTextStyle curvedTextStyle = (CurvedTextStyle) other;
        return Color.equals-impl0(this.color, curvedTextStyle.color) && TextUnit.equals-impl0(this.fontSize, curvedTextStyle.fontSize) && Color.equals-impl0(this.background, curvedTextStyle.background) && Intrinsics.areEqual(this.fontFamily, curvedTextStyle.fontFamily) && Intrinsics.areEqual(this.fontWeight, curvedTextStyle.fontWeight) && Intrinsics.areEqual(this.fontStyle, curvedTextStyle.fontStyle) && Intrinsics.areEqual(this.fontSynthesis, curvedTextStyle.fontSynthesis);
    }

    public int hashCode() {
        int i = ((((Color.hashCode-impl(this.color) * 31) + TextUnit.hashCode-impl(this.fontSize)) * 31) + Color.hashCode-impl(this.background)) * 31;
        FontFamily fontFamily = this.fontFamily;
        int iHashCode = (i + (fontFamily != null ? fontFamily.hashCode() : 0)) * 31;
        FontWeight fontWeight = this.fontWeight;
        int iHashCode2 = (iHashCode + (fontWeight != null ? fontWeight.hashCode() : 0)) * 31;
        FontStyle fontStyle = this.fontStyle;
        int iHashCode3 = (iHashCode2 + (fontStyle != null ? fontStyle.hashCode() : 0)) * 31;
        FontSynthesis fontSynthesis = this.fontSynthesis;
        return iHashCode3 + (fontSynthesis != null ? fontSynthesis.hashCode() : 0);
    }

    public String toString() {
        return "CurvedTextStyle(background=" + ((Object) Color.toString-impl(this.background)) + "color=" + ((Object) Color.toString-impl(this.color)) + ", fontSize=" + ((Object) TextUnit.toString-impl(this.fontSize)) + ", fontFamily=" + this.fontFamily + ", fontWeight=" + this.fontWeight + ", fontStyle=" + this.fontStyle + ", fontSynthesis=" + this.fontSynthesis + ", )";
    }
}
