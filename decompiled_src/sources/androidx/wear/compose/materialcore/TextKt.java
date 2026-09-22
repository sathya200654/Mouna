package androidx.wear.compose.materialcore;

import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.InlineTextContent;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
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
import androidx.recyclerview.widget.RecyclerView;
import io.grpc.internal.GrpcUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Text.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aÄ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001e2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00010\"2\u0006\u0010$\u001a\u00020%H\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006("}, d2 = {"Text", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "letterSpacing", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "lineHeight", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "inlineContent", "", "", "Landroidx/compose/foundation/text/InlineTextContent;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "style", "Landroidx/compose/ui/text/TextStyle;", "Text--4IGK_g", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;II)V", "compose-material-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextKt {
    /* JADX INFO: renamed from: Text--4IGK_g, reason: not valid java name */
    public static final void m937Text4IGK_g(final AnnotatedString annotatedString, final Modifier modifier, final long j, final long j2, final FontStyle fontStyle, final FontWeight fontWeight, final FontFamily fontFamily, final long j3, final TextDecoration textDecoration, final TextAlign textAlign, final long j4, final int i, final boolean z, final int i2, final int i3, final Map<String, InlineTextContent> map, final Function1<? super TextLayoutResult, Unit> function1, final TextStyle textStyle, Composer composer, final int i4, final int i5) {
        int i6;
        FontStyle fontStyle2;
        int i7;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1475122251);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Text)P(15,10,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,6:c#ui.unit.TextUnit,17,16:c#ui.text.style.TextAlign,7:c#ui.unit.TextUnit,12:c#ui.text.style.TextOverflow,13,8,9)101@4968L686:Text.kt#f7tims");
        if ((i4 & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(annotatedString) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        if ((i4 & 48) == 0) {
            i6 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i6 |= composerStartRestartGroup.changed(j) ? 256 : 128;
        }
        int i8 = i4 & 3072;
        int i9 = RecyclerView.ItemAnimator.FLAG_MOVED;
        if (i8 == 0) {
            i6 |= composerStartRestartGroup.changed(j2) ? 2048 : 1024;
        }
        if ((i4 & 24576) == 0) {
            fontStyle2 = fontStyle;
            i6 |= composerStartRestartGroup.changed(fontStyle2) ? 16384 : 8192;
        } else {
            fontStyle2 = fontStyle;
        }
        if ((i4 & 196608) == 0) {
            i6 |= composerStartRestartGroup.changed(fontWeight) ? 131072 : 65536;
        }
        if ((i4 & 1572864) == 0) {
            i6 |= composerStartRestartGroup.changed(fontFamily) ? 1048576 : 524288;
        }
        if ((i4 & 12582912) == 0) {
            i6 |= composerStartRestartGroup.changed(j3) ? 8388608 : GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
        }
        if ((i4 & 100663296) == 0) {
            i6 |= composerStartRestartGroup.changed(textDecoration) ? 67108864 : 33554432;
        }
        if ((i4 & 805306368) == 0) {
            i6 |= composerStartRestartGroup.changed(textAlign) ? 536870912 : 268435456;
        }
        if ((i5 & 6) == 0) {
            i7 = i5 | (composerStartRestartGroup.changed(j4) ? 4 : 2);
        } else {
            i7 = i5;
        }
        if ((i5 & 48) == 0) {
            i7 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i7 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            if (!composerStartRestartGroup.changed(i2)) {
                i9 = 1024;
            }
            i7 |= i9;
        }
        if ((i5 & 24576) == 0) {
            i7 |= composerStartRestartGroup.changed(i3) ? 16384 : 8192;
        }
        if ((i5 & 196608) == 0) {
            i7 |= composerStartRestartGroup.changedInstance(map) ? 131072 : 65536;
        }
        if ((i5 & 1572864) == 0) {
            i7 |= composerStartRestartGroup.changedInstance(function1) ? 1048576 : 524288;
        }
        if ((i5 & 12582912) == 0) {
            i7 |= composerStartRestartGroup.changed(textStyle) ? 8388608 : GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
        }
        int i10 = i7;
        if ((i6 & 306783379) != 306783378 || (4793491 & i10) != 4793490 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1475122251, i6, i10, "androidx.wear.compose.materialcore.Text (Text.kt:100)");
            }
            int i11 = (i6 & 126) | ((i10 >> 9) & 7168);
            int i12 = i10 << 9;
            composer2 = composerStartRestartGroup;
            BasicTextKt.BasicText-RWo7tUw(annotatedString, modifier, TextStyle.merge-dA7vx0o$default(textStyle, j, j2, fontWeight, fontStyle2, (FontSynthesis) null, fontFamily, (String) null, j3, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration, (Shadow) null, (DrawStyle) null, textAlign != null ? textAlign.unbox-impl() : TextAlign.Companion.getUnspecified-e0LSkKk(), 0, j4, (TextIndent) null, (LineHeightStyle) null, 0, 0, (PlatformTextStyle) null, (TextMotion) null, 16609104, (Object) null), function1, i, z, i2, i3, map, (ColorProducer) null, composer2, i11 | (57344 & i12) | (458752 & i12) | (3670016 & i12) | (29360128 & i12) | (i12 & 234881024), 512);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.materialcore.TextKt$Text$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i13) {
                    TextKt.m937Text4IGK_g(annotatedString, modifier, j, j2, fontStyle, fontWeight, fontFamily, j3, textDecoration, textAlign, j4, i, z, i2, i3, map, function1, textStyle, composer3, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), RecomposeScopeImplKt.updateChangedFlags(i5));
                }
            });
        }
    }
}
