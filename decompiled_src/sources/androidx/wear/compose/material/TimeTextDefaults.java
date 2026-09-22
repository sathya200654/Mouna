package androidx.wear.compose.material;

import android.text.format.DateFormat;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import androidx.recyclerview.widget.RecyclerView;
import androidx.wear.compose.foundation.ArcPaddingValues;
import androidx.wear.compose.foundation.CurvedModifier;
import androidx.wear.compose.foundation.CurvedPaddingKt;
import androidx.wear.compose.foundation.CurvedScope;
import androidx.wear.compose.foundation.CurvedTextStyle;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: TimeText.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J+\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0014J\r\u0010\u0015\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u000bJ0\u0010\u0019\u001a\u00020\u00122\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J \u0010!\u001a\u00020\u000e*\u00020\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020&R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\bX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006'"}, d2 = {"Landroidx/wear/compose/material/TimeTextDefaults;", "", "()V", "ContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "Padding", "Landroidx/compose/ui/unit/Dp;", "F", "TimeFormat12Hours", "", "TimeFormat24Hours", "TextSeparator", "", "modifier", "Landroidx/compose/ui/Modifier;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "contentPadding", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "timeFormat", "(Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "timeSource", "Landroidx/wear/compose/material/TimeSource;", "timeTextStyle", "background", "Landroidx/compose/ui/graphics/Color;", "color", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "timeTextStyle-28gAR5Q", "(JJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/ui/text/TextStyle;", "CurvedTextSeparator", "Landroidx/wear/compose/foundation/CurvedScope;", "curvedTextStyle", "Landroidx/wear/compose/foundation/CurvedTextStyle;", "contentArcPadding", "Landroidx/wear/compose/foundation/ArcPaddingValues;", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TimeTextDefaults {
    public static final int $stable = 0;
    private static final PaddingValues ContentPadding;
    public static final TimeTextDefaults INSTANCE = new TimeTextDefaults();
    private static final float Padding;
    public static final String TimeFormat12Hours = "h:mm";
    public static final String TimeFormat24Hours = "HH:mm";

    private TimeTextDefaults() {
    }

    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    public final String timeFormat(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 976949226, "C(timeFormat)193@7805L16:TimeText.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(976949226, i, -1, "androidx.wear.compose.material.TimeTextDefaults.timeFormat (TimeText.kt:192)");
        }
        String string = StringsKt.trim(StringsKt.replace$default(DateFormat.getBestDateTimePattern(Locale.getDefault(), androidx.wear.compose.materialcore.ResourcesKt.is24HourFormat(composer, 0) ? TimeFormat24Hours : TimeFormat12Hours), "a", "", false, 4, (Object) null)).toString();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return string;
    }

    /* JADX INFO: renamed from: timeTextStyle-28gAR5Q, reason: not valid java name */
    public final TextStyle m847timeTextStyle28gAR5Q(long j, long j2, long j3, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 706111857, "C(timeTextStyle)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.unit.TextUnit)211@8508L10:TimeText.kt#gj9v0t");
        long j4 = (i2 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : j;
        long j5 = (i2 & 2) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : j2;
        long j6 = (i2 & 4) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : j3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(706111857, i, -1, "androidx.wear.compose.material.TimeTextDefaults.timeTextStyle (TimeText.kt:211)");
        }
        TextStyle textStylePlus = MaterialTheme.INSTANCE.getTypography(composer, 6).getCaption1().plus(new TextStyle(j5, j6, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, j4, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16775164, (DefaultConstructorMarker) null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return textStylePlus;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x006b  */
    /* JADX WARN: Code duplicated, block: B:38:0x006e  */
    /* JADX WARN: Code duplicated, block: B:40:0x0072  */
    /* JADX WARN: Code duplicated, block: B:42:0x007a  */
    /* JADX WARN: Code duplicated, block: B:43:0x007d  */
    /* JADX WARN: Code duplicated, block: B:48:0x0089  */
    /* JADX WARN: Code duplicated, block: B:52:0x009a  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:62:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:63:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:67:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:69:0x00de  */
    /* JADX WARN: Code duplicated, block: B:70:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:74:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:77:0x0130  */
    /* JADX WARN: Code duplicated, block: B:81:0x013d  */
    /* JADX WARN: Code duplicated, block: B:83:? A[RETURN, SYNTHETIC] */
    public final void TextSeparator(Modifier modifier, TextStyle textStyle, PaddingValues paddingValues, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        TextStyle textStyleM847timeTextStyle28gAR5Q;
        PaddingValues paddingValues2;
        int i4;
        Modifier modifier3;
        PaddingValues paddingValues3;
        TextStyle textStyle2;
        final PaddingValues paddingValues4;
        final TextStyle textStyle3;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1037218251);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextSeparator)P(1,2)224@9061L15,227@9167L126:TimeText.kt#gj9v0t");
        int i5 = i2 & 1;
        if (i5 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                textStyleM847timeTextStyle28gAR5Q = textStyle;
                int i6 = composerStartRestartGroup.changed(textStyleM847timeTextStyle28gAR5Q) ? 32 : 16;
                i3 |= i6;
            } else {
                textStyleM847timeTextStyle28gAR5Q = textStyle;
            }
            i3 |= i6;
        } else {
            textStyleM847timeTextStyle28gAR5Q = textStyle;
        }
        int i7 = i2 & 4;
        if (i7 == 0) {
            if ((i & 384) == 0) {
                paddingValues2 = paddingValues;
                i3 |= composerStartRestartGroup.changed(paddingValues2) ? 256 : 128;
            }
            if ((i2 & 8) != 0) {
                if ((i & 3072) == 0) {
                    if (composerStartRestartGroup.changed(this)) {
                        i4 = RecyclerView.ItemAnimator.FLAG_MOVED;
                    } else {
                        i4 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                    }
                    i3 |= i4;
                }
                if ((i3 & 1171) == 1170 || !composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i5 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            textStyleM847timeTextStyle28gAR5Q = m847timeTextStyle28gAR5Q(0L, 0L, 0L, composerStartRestartGroup, i3 & 7168, 7);
                            i3 &= -113;
                        }
                        if (i7 != 0) {
                            paddingValues3 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(4), 0.0f, 2, (Object) null);
                        } else {
                            paddingValues3 = paddingValues;
                        }
                        textStyle2 = textStyleM847timeTextStyle28gAR5Q;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                        }
                        modifier3 = modifier2;
                        textStyle2 = textStyleM847timeTextStyle28gAR5Q;
                        paddingValues3 = paddingValues2;
                        composerStartRestartGroup = composerStartRestartGroup;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1037218251, i3, -1, "androidx.wear.compose.material.TimeTextDefaults.TextSeparator (TimeText.kt:226)");
                    }
                    TextKt.m843Text4IGK_g("·", PaddingKt.padding(modifier3, paddingValues3), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, textStyle2, composerStartRestartGroup, 6, (i3 << 15) & 3670016, 65532);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues4 = paddingValues3;
                    textStyle3 = textStyle2;
                    modifier4 = modifier3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier4 = modifier2;
                    textStyle3 = textStyleM847timeTextStyle28gAR5Q;
                    paddingValues4 = paddingValues2;
                    composerStartRestartGroup = composerStartRestartGroup;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.TimeTextDefaults.TextSeparator.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i8) {
                            TimeTextDefaults.this.TextSeparator(modifier4, textStyle3, paddingValues4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 3072;
            if ((i3 & 1171) == 1170) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i5 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        textStyleM847timeTextStyle28gAR5Q = m847timeTextStyle28gAR5Q(0L, 0L, 0L, composerStartRestartGroup, i3 & 7168, 7);
                        i3 &= -113;
                    }
                    if (i7 != 0) {
                        paddingValues3 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(4), 0.0f, 2, (Object) null);
                    } else {
                        paddingValues3 = paddingValues;
                    }
                    textStyle2 = textStyleM847timeTextStyle28gAR5Q;
                } else {
                    if (i5 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        textStyleM847timeTextStyle28gAR5Q = m847timeTextStyle28gAR5Q(0L, 0L, 0L, composerStartRestartGroup, i3 & 7168, 7);
                        i3 &= -113;
                    }
                    if (i7 != 0) {
                        paddingValues3 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(4), 0.0f, 2, (Object) null);
                    } else {
                        paddingValues3 = paddingValues;
                    }
                    textStyle2 = textStyleM847timeTextStyle28gAR5Q;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1037218251, i3, -1, "androidx.wear.compose.material.TimeTextDefaults.TextSeparator (TimeText.kt:226)");
                }
                TextKt.m843Text4IGK_g("·", PaddingKt.padding(modifier3, paddingValues3), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, textStyle2, composerStartRestartGroup, 6, (i3 << 15) & 3670016, 65532);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                paddingValues4 = paddingValues3;
                textStyle3 = textStyle2;
                modifier4 = modifier3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i5 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        textStyleM847timeTextStyle28gAR5Q = m847timeTextStyle28gAR5Q(0L, 0L, 0L, composerStartRestartGroup, i3 & 7168, 7);
                        i3 &= -113;
                    }
                    if (i7 != 0) {
                        paddingValues3 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(4), 0.0f, 2, (Object) null);
                    } else {
                        paddingValues3 = paddingValues;
                    }
                    textStyle2 = textStyleM847timeTextStyle28gAR5Q;
                } else {
                    if (i5 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        textStyleM847timeTextStyle28gAR5Q = m847timeTextStyle28gAR5Q(0L, 0L, 0L, composerStartRestartGroup, i3 & 7168, 7);
                        i3 &= -113;
                    }
                    if (i7 != 0) {
                        paddingValues3 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(4), 0.0f, 2, (Object) null);
                    } else {
                        paddingValues3 = paddingValues;
                    }
                    textStyle2 = textStyleM847timeTextStyle28gAR5Q;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1037218251, i3, -1, "androidx.wear.compose.material.TimeTextDefaults.TextSeparator (TimeText.kt:226)");
                }
                TextKt.m843Text4IGK_g("·", PaddingKt.padding(modifier3, paddingValues3), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, textStyle2, composerStartRestartGroup, 6, (i3 << 15) & 3670016, 65532);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                paddingValues4 = paddingValues3;
                textStyle3 = textStyle2;
                modifier4 = modifier3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.TimeTextDefaults.TextSeparator.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i8) {
                        TimeTextDefaults.this.TextSeparator(modifier4, textStyle3, paddingValues4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 384;
        paddingValues2 = paddingValues;
        if ((i2 & 8) != 0) {
            if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i4 = RecyclerView.ItemAnimator.FLAG_MOVED;
                } else {
                    i4 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                }
                i3 |= i4;
            }
            if ((i3 & 1171) == 1170) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i5 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        textStyleM847timeTextStyle28gAR5Q = m847timeTextStyle28gAR5Q(0L, 0L, 0L, composerStartRestartGroup, i3 & 7168, 7);
                        i3 &= -113;
                    }
                    if (i7 != 0) {
                        paddingValues3 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(4), 0.0f, 2, (Object) null);
                    } else {
                        paddingValues3 = paddingValues;
                    }
                    textStyle2 = textStyleM847timeTextStyle28gAR5Q;
                } else {
                    if (i5 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        textStyleM847timeTextStyle28gAR5Q = m847timeTextStyle28gAR5Q(0L, 0L, 0L, composerStartRestartGroup, i3 & 7168, 7);
                        i3 &= -113;
                    }
                    if (i7 != 0) {
                        paddingValues3 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(4), 0.0f, 2, (Object) null);
                    } else {
                        paddingValues3 = paddingValues;
                    }
                    textStyle2 = textStyleM847timeTextStyle28gAR5Q;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1037218251, i3, -1, "androidx.wear.compose.material.TimeTextDefaults.TextSeparator (TimeText.kt:226)");
                }
                TextKt.m843Text4IGK_g("·", PaddingKt.padding(modifier3, paddingValues3), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, textStyle2, composerStartRestartGroup, 6, (i3 << 15) & 3670016, 65532);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                paddingValues4 = paddingValues3;
                textStyle3 = textStyle2;
                modifier4 = modifier3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i5 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        textStyleM847timeTextStyle28gAR5Q = m847timeTextStyle28gAR5Q(0L, 0L, 0L, composerStartRestartGroup, i3 & 7168, 7);
                        i3 &= -113;
                    }
                    if (i7 != 0) {
                        paddingValues3 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(4), 0.0f, 2, (Object) null);
                    } else {
                        paddingValues3 = paddingValues;
                    }
                    textStyle2 = textStyleM847timeTextStyle28gAR5Q;
                } else {
                    if (i5 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        textStyleM847timeTextStyle28gAR5Q = m847timeTextStyle28gAR5Q(0L, 0L, 0L, composerStartRestartGroup, i3 & 7168, 7);
                        i3 &= -113;
                    }
                    if (i7 != 0) {
                        paddingValues3 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(4), 0.0f, 2, (Object) null);
                    } else {
                        paddingValues3 = paddingValues;
                    }
                    textStyle2 = textStyleM847timeTextStyle28gAR5Q;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1037218251, i3, -1, "androidx.wear.compose.material.TimeTextDefaults.TextSeparator (TimeText.kt:226)");
                }
                TextKt.m843Text4IGK_g("·", PaddingKt.padding(modifier3, paddingValues3), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, textStyle2, composerStartRestartGroup, 6, (i3 << 15) & 3670016, 65532);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                paddingValues4 = paddingValues3;
                textStyle3 = textStyle2;
                modifier4 = modifier3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.TimeTextDefaults.TextSeparator.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i8) {
                        TimeTextDefaults.this.TextSeparator(modifier4, textStyle3, paddingValues4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 3072;
        if ((i3 & 1171) == 1170) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i5 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    textStyleM847timeTextStyle28gAR5Q = m847timeTextStyle28gAR5Q(0L, 0L, 0L, composerStartRestartGroup, i3 & 7168, 7);
                    i3 &= -113;
                }
                if (i7 != 0) {
                    paddingValues3 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(4), 0.0f, 2, (Object) null);
                } else {
                    paddingValues3 = paddingValues;
                }
                textStyle2 = textStyleM847timeTextStyle28gAR5Q;
            } else {
                if (i5 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    textStyleM847timeTextStyle28gAR5Q = m847timeTextStyle28gAR5Q(0L, 0L, 0L, composerStartRestartGroup, i3 & 7168, 7);
                    i3 &= -113;
                }
                if (i7 != 0) {
                    paddingValues3 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(4), 0.0f, 2, (Object) null);
                } else {
                    paddingValues3 = paddingValues;
                }
                textStyle2 = textStyleM847timeTextStyle28gAR5Q;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1037218251, i3, -1, "androidx.wear.compose.material.TimeTextDefaults.TextSeparator (TimeText.kt:226)");
            }
            TextKt.m843Text4IGK_g("·", PaddingKt.padding(modifier3, paddingValues3), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, textStyle2, composerStartRestartGroup, 6, (i3 << 15) & 3670016, 65532);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            paddingValues4 = paddingValues3;
            textStyle3 = textStyle2;
            modifier4 = modifier3;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i5 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    textStyleM847timeTextStyle28gAR5Q = m847timeTextStyle28gAR5Q(0L, 0L, 0L, composerStartRestartGroup, i3 & 7168, 7);
                    i3 &= -113;
                }
                if (i7 != 0) {
                    paddingValues3 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(4), 0.0f, 2, (Object) null);
                } else {
                    paddingValues3 = paddingValues;
                }
                textStyle2 = textStyleM847timeTextStyle28gAR5Q;
            } else {
                if (i5 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 2) != 0) {
                    textStyleM847timeTextStyle28gAR5Q = m847timeTextStyle28gAR5Q(0L, 0L, 0L, composerStartRestartGroup, i3 & 7168, 7);
                    i3 &= -113;
                }
                if (i7 != 0) {
                    paddingValues3 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(4), 0.0f, 2, (Object) null);
                } else {
                    paddingValues3 = paddingValues;
                }
                textStyle2 = textStyleM847timeTextStyle28gAR5Q;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1037218251, i3, -1, "androidx.wear.compose.material.TimeTextDefaults.TextSeparator (TimeText.kt:226)");
            }
            TextKt.m843Text4IGK_g("·", PaddingKt.padding(modifier3, paddingValues3), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, textStyle2, composerStartRestartGroup, 6, (i3 << 15) & 3670016, 65532);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            paddingValues4 = paddingValues3;
            textStyle3 = textStyle2;
            modifier4 = modifier3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.TimeTextDefaults.TextSeparator.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i8) {
                    TimeTextDefaults.this.TextSeparator(modifier4, textStyle3, paddingValues4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    public final void CurvedTextSeparator(CurvedScope curvedScope, CurvedTextStyle curvedTextStyle, ArcPaddingValues arcPaddingValues) {
        CurvedTextKt.m581curvedTextRAm4gr4(curvedScope, "·", (3580 & 2) != 0 ? CurvedModifier.INSTANCE : CurvedPaddingKt.padding(CurvedModifier.INSTANCE, arcPaddingValues), (3580 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : 0L, (3580 & 8) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : 0L, (3580 & 16) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : 0L, (3580 & 32) != 0 ? null : null, (3580 & 64) != 0 ? null : null, (3580 & 128) != 0 ? null : null, (3580 & 256) != 0 ? null : null, (3580 & 512) != 0 ? null : curvedTextStyle, (3580 & UserMetadata.MAX_ATTRIBUTE_SIZE) == 0 ? null : null, (3580 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0 ? TextOverflow.Companion.getClip-gIe3tQ8() : 0);
    }

    public final TimeSource timeSource(String timeFormat) {
        return new DefaultTimeSource(timeFormat);
    }

    public static /* synthetic */ void CurvedTextSeparator$default(TimeTextDefaults timeTextDefaults, CurvedScope curvedScope, CurvedTextStyle curvedTextStyle, ArcPaddingValues arcPaddingValues, int i, Object obj) {
        if ((i & 1) != 0) {
            curvedTextStyle = null;
        }
        if ((i & 2) != 0) {
            arcPaddingValues = CurvedPaddingKt.m339ArcPaddingValuesYgX7TsA$default(0.0f, Dp.constructor-impl(4), 1, null);
        }
        timeTextDefaults.CurvedTextSeparator(curvedScope, curvedTextStyle, arcPaddingValues);
    }

    static {
        float f = Dp.constructor-impl(2);
        Padding = f;
        ContentPadding = PaddingKt.PaddingValues-0680j_4(f);
    }
}
