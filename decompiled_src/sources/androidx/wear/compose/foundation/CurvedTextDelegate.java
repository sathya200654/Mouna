package androidx.wear.compose.foundation;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyResolver_androidKt;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextOverflow;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: BasicCurvedText.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J:\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u000102H\u0007ø\u0001\u0000¢\u0006\u0004\b3\u00104J(\u00105\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u0002062\u0006\u00107\u001a\u00020\f2\u0006\u00108\u001a\u000209H\u0002J\u001e\u0010:\u001a\u00020*2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006J\b\u0010;\u001a\u00020*H\u0002J\u0018\u0010<\u001a\u00020*2\u0006\u0010=\u001a\u00020\u000f2\u0006\u0010>\u001a\u00020\u0006H\u0002J\b\u0010?\u001a\u00020*H\u0002J<\u0010@\u001a\u00020**\u00020A2\u0006\u0010=\u001a\u00020\u000f2\u0006\u0010>\u001a\u00020\u00062\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020Eø\u0001\u0000¢\u0006\u0004\bG\u0010HR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00068F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\b\"\u0004\b\u001e\u0010\nR\u000e\u0010!\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\"\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00068F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010 \u001a\u0004\b#\u0010\b\"\u0004\b$\u0010\nR\u0016\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0'X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006I"}, d2 = {"Landroidx/wear/compose/foundation/CurvedTextDelegate;", "", "()V", "backgroundPath", "Landroid/graphics/Path;", "baseLinePosition", "", "getBaseLinePosition", "()F", "setBaseLinePosition", "(F)V", "clockwise", "", "fontSizePx", "lastLayoutInfo", "Landroidx/wear/compose/foundation/CurvedLayoutInfo;", "getLastLayoutInfo", "()Landroidx/wear/compose/foundation/CurvedLayoutInfo;", "setLastLayoutInfo", "(Landroidx/wear/compose/foundation/CurvedLayoutInfo;)V", "lastParentSweepRadians", "getLastParentSweepRadians", "setLastParentSweepRadians", "paint", "Landroid/graphics/Paint;", "text", "", "<set-?>", "textHeight", "getTextHeight", "setTextHeight", "textHeight$delegate", "Landroidx/compose/runtime/MutableFloatState;", "textPath", "textWidth", "getTextWidth", "setTextWidth", "textWidth$delegate", "typeFace", "Landroidx/compose/runtime/State;", "Landroid/graphics/Typeface;", "UpdateFontIfNeeded", "", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "UpdateFontIfNeeded-SyNm_b8", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/runtime/Composer;I)V", "ellipsize", "Landroid/text/TextPaint;", "addEllipsis", "ellipsizedWidth", "", "updateIfNeeded", "updateMeasures", "updatePathsIfNeeded", "layoutInfo", "parentSweepRadians", "updateTypeFace", "doDraw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "color", "Landroidx/compose/ui/graphics/Color;", "background", "doDraw-mWnK_ns", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/wear/compose/foundation/CurvedLayoutInfo;FIJJ)V", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CurvedTextDelegate {
    public static final int $stable = 8;
    private final Path backgroundPath;
    private float baseLinePosition;
    private float fontSizePx;
    private CurvedLayoutInfo lastLayoutInfo;
    private float lastParentSweepRadians;
    private final Paint paint;
    private final Path textPath;
    private String text = "";
    private boolean clockwise = true;

    /* JADX INFO: renamed from: textWidth$delegate, reason: from kotlin metadata */
    private final MutableFloatState textWidth = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);

    /* JADX INFO: renamed from: textHeight$delegate, reason: from kotlin metadata */
    private final MutableFloatState textHeight = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
    private State<? extends Typeface> typeFace = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);

    public CurvedTextDelegate() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        this.paint = paint;
        this.backgroundPath = new Path();
        this.textPath = new Path();
    }

    public final float getTextWidth() {
        return this.textWidth.getFloatValue();
    }

    public final void setTextWidth(float f) {
        this.textWidth.setFloatValue(f);
    }

    public final float getTextHeight() {
        return this.textHeight.getFloatValue();
    }

    public final void setTextHeight(float f) {
        this.textHeight.setFloatValue(f);
    }

    public final float getBaseLinePosition() {
        return this.baseLinePosition;
    }

    public final void setBaseLinePosition(float f) {
        this.baseLinePosition = f;
    }

    public final CurvedLayoutInfo getLastLayoutInfo() {
        return this.lastLayoutInfo;
    }

    public final void setLastLayoutInfo(CurvedLayoutInfo curvedLayoutInfo) {
        this.lastLayoutInfo = curvedLayoutInfo;
    }

    public final float getLastParentSweepRadians() {
        return this.lastParentSweepRadians;
    }

    public final void setLastParentSweepRadians(float f) {
        this.lastParentSweepRadians = f;
    }

    public final void updateIfNeeded(String text, boolean clockwise, float fontSizePx) {
        if (Intrinsics.areEqual(text, this.text) && clockwise == this.clockwise && fontSizePx == this.fontSizePx) {
            return;
        }
        this.text = text;
        this.clockwise = clockwise;
        this.fontSizePx = fontSizePx;
        this.paint.setTextSize(fontSizePx);
        updateMeasures();
        this.lastLayoutInfo = null;
    }

    /* JADX INFO: renamed from: UpdateFontIfNeeded-SyNm_b8, reason: not valid java name */
    public final void m358UpdateFontIfNeededSyNm_b8(final FontFamily fontFamily, final FontWeight fontWeight, final FontStyle fontStyle, final FontSynthesis fontSynthesis, Composer composer, final int i) {
        int i2;
        FontSynthesis fontSynthesis2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-936433771);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(UpdateFontIfNeeded)P(!1,3,1:c#ui.text.font.FontStyle,2:c#ui.text.font.FontSynthesis)263@10017L7,264@10044L402:BasicCurvedText.kt#m5emhl");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(fontFamily) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(fontWeight) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(fontStyle) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            fontSynthesis2 = fontSynthesis;
            i2 |= composerStartRestartGroup.changed(fontSynthesis2) ? 2048 : UserMetadata.MAX_ATTRIBUTE_SIZE;
        } else {
            fontSynthesis2 = fontSynthesis;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 16384 : 8192;
        }
        if ((i2 & 9363) != 9362 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-936433771, i2, -1, "androidx.wear.compose.foundation.CurvedTextDelegate.UpdateFontIfNeeded (BasicCurvedText.kt:262)");
            }
            CompositionLocal localFontFamilyResolver = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFontFamilyResolver();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localFontFamilyResolver);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final FontFamily.Resolver resolver = (FontFamily.Resolver) objConsume;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1500629042, "CC(remember):BasicCurvedText.kt#9igjgp");
            boolean zChanged = ((i2 & 14) == 4) | ((i2 & 112) == 32) | ((i2 & 896) == 256) | ((i2 & 7168) == 2048) | composerStartRestartGroup.changed(resolver);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                final FontSynthesis fontSynthesis3 = fontSynthesis2;
                objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<Typeface>() { // from class: androidx.wear.compose.foundation.CurvedTextDelegate$UpdateFontIfNeeded$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final Typeface m360invoke() {
                        FontFamily.Resolver resolver2 = resolver;
                        FontFamily fontFamily2 = fontFamily;
                        FontWeight normal = fontWeight;
                        if (normal == null) {
                            normal = FontWeight.Companion.getNormal();
                        }
                        FontStyle fontStyle2 = fontStyle;
                        int i3 = fontStyle2 != null ? fontStyle2.unbox-impl() : FontStyle.Companion.getNormal-_-LCdwA();
                        FontSynthesis fontSynthesis4 = fontSynthesis3;
                        return (Typeface) FontFamilyResolver_androidKt.resolveAsTypeface-Wqqsr6A(resolver2, fontFamily2, normal, i3, fontSynthesis4 != null ? fontSynthesis4.unbox-impl() : FontSynthesis.Companion.getAll-GVVA2EU()).getValue();
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            this.typeFace = (State) objRememberedValue;
            updateTypeFace();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.foundation.CurvedTextDelegate$UpdateFontIfNeeded$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    this.$tmp1_rcvr.m358UpdateFontIfNeededSyNm_b8(fontFamily, fontWeight, fontStyle, fontSynthesis, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private final void updateMeasures() {
        Rect rect = new Rect();
        Paint paint = this.paint;
        String str = this.text;
        paint.getTextBounds(str, 0, str.length(), rect);
        setTextWidth(rect.width());
        setTextHeight((-this.paint.getFontMetrics().top) + this.paint.getFontMetrics().bottom);
        this.baseLinePosition = this.clockwise ? -this.paint.getFontMetrics().top : this.paint.getFontMetrics().bottom;
    }

    private final void updateTypeFace() {
        Typeface typeface = (Typeface) this.typeFace.getValue();
        if (Intrinsics.areEqual(typeface, this.paint.getTypeface())) {
            return;
        }
        this.paint.setTypeface(typeface);
        updateMeasures();
        this.lastLayoutInfo = null;
    }

    private final void updatePathsIfNeeded(CurvedLayoutInfo layoutInfo, float parentSweepRadians) {
        if (!Intrinsics.areEqual(layoutInfo, this.lastLayoutInfo) || Math.abs(this.lastParentSweepRadians - parentSweepRadians) > 1.0E-4d) {
            this.lastLayoutInfo = layoutInfo;
            this.lastParentSweepRadians = parentSweepRadians;
            float f = this.clockwise ? 1.0f : -1.0f;
            float fCoerceAtMost = RangesKt.coerceAtMost(CurvedLayoutKt.toDegrees(Math.min(layoutInfo.getSweepRadians(), parentSweepRadians)), 360.0f);
            float f2 = Offset.getX-impl(layoutInfo.getCenterOffset());
            float f3 = Offset.getY-impl(layoutInfo.getCenterOffset());
            this.backgroundPath.reset();
            this.backgroundPath.arcTo(f2 - layoutInfo.getOuterRadius(), f3 - layoutInfo.getOuterRadius(), layoutInfo.getOuterRadius() + f2, layoutInfo.getOuterRadius() + f3, CurvedLayoutKt.toDegrees(layoutInfo.getStartAngleRadians()), fCoerceAtMost, false);
            this.backgroundPath.arcTo(f2 - layoutInfo.getInnerRadius(), f3 - layoutInfo.getInnerRadius(), f2 + layoutInfo.getInnerRadius(), f3 + layoutInfo.getInnerRadius(), CurvedLayoutKt.toDegrees(layoutInfo.getStartAngleRadians()) + fCoerceAtMost, -fCoerceAtMost, false);
            this.backgroundPath.close();
            this.textPath.reset();
            this.textPath.addArc(f2 - layoutInfo.getMeasureRadius(), f3 - layoutInfo.getMeasureRadius(), f2 + layoutInfo.getMeasureRadius(), f3 + layoutInfo.getMeasureRadius(), CurvedLayoutKt.toDegrees(layoutInfo.getStartAngleRadians()) + (this.clockwise ? 0.0f : fCoerceAtMost), f * fCoerceAtMost);
        }
    }

    /* JADX INFO: renamed from: doDraw-mWnK_ns, reason: not valid java name */
    public final void m359doDrawmWnK_ns(DrawScope drawScope, CurvedLayoutInfo curvedLayoutInfo, float f, int i, long j, long j2) {
        String strEllipsize;
        updateTypeFace();
        updatePathsIfNeeded(curvedLayoutInfo, f);
        Canvas canvas = drawScope.getDrawContext().getCanvas();
        if (j2 != 16 && !Color.equals-impl0(j2, Color.Companion.getTransparent-0d7_KjU())) {
            this.paint.setColor(ColorKt.toArgb-8_81llA(j2));
            AndroidCanvas_androidKt.getNativeCanvas(canvas).drawPath(this.backgroundPath, this.paint);
        }
        this.paint.setColor(ColorKt.toArgb-8_81llA(j));
        if (curvedLayoutInfo.getSweepRadians() <= 0.001f + f || TextOverflow.equals-impl0(i, TextOverflow.Companion.getVisible-gIe3tQ8())) {
            strEllipsize = this.text;
        } else {
            strEllipsize = ellipsize(this.text, new TextPaint(this.paint), TextOverflow.equals-impl0(i, TextOverflow.Companion.getEllipsis-gIe3tQ8()), MathKt.roundToInt(f * curvedLayoutInfo.getMeasureRadius()));
        }
        AndroidCanvas_androidKt.getNativeCanvas(canvas).drawTextOnPath(strEllipsize, this.textPath, 0.0f, 0.0f, this.paint);
    }

    private final String ellipsize(String text, TextPaint paint, boolean addEllipsis, int ellipsizedWidth) {
        if (addEllipsis) {
            return TextUtils.ellipsize(text, paint, ellipsizedWidth, TextUtils.TruncateAt.END).toString();
        }
        String strSubstring = text.substring(0, StaticLayout.Builder.obtain(text, 0, text.length(), paint, ellipsizedWidth).setEllipsize(null).setMaxLines(1).build().getLineEnd(0));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }
}
