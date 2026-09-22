package androidx.wear.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.wear.compose.foundation.BasicCurvedTextKt;
import androidx.wear.compose.foundation.CurvedDirection;
import androidx.wear.compose.foundation.CurvedModifier;
import androidx.wear.compose.foundation.CurvedScope;
import androidx.wear.compose.foundation.CurvedTextStyle;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: CurvedText.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0096\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001ah\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"curvedText", "", "Landroidx/wear/compose/foundation/CurvedScope;", "text", "", "modifier", "Landroidx/wear/compose/foundation/CurvedModifier;", "background", "Landroidx/compose/ui/graphics/Color;", "color", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "style", "Landroidx/wear/compose/foundation/CurvedTextStyle;", "angularDirection", "Landroidx/wear/compose/foundation/CurvedDirection$Angular;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "curvedText-RAm4gr4", "(Landroidx/wear/compose/foundation/CurvedScope;Ljava/lang/String;Landroidx/wear/compose/foundation/CurvedModifier;JJJLandroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/wear/compose/foundation/CurvedTextStyle;Landroidx/wear/compose/foundation/CurvedDirection$Angular;I)V", "curvedText-g2yp93Q", "(Landroidx/wear/compose/foundation/CurvedScope;Ljava/lang/String;Landroidx/wear/compose/foundation/CurvedModifier;JJJLandroidx/wear/compose/foundation/CurvedTextStyle;Landroidx/wear/compose/foundation/CurvedDirection$Angular;I)V", "compose-material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CurvedTextKt {
    /* JADX INFO: renamed from: curvedText-RAm4gr4, reason: not valid java name */
    public static final void m581curvedTextRAm4gr4(CurvedScope curvedScope, String str, CurvedModifier curvedModifier, final long j, final long j2, final long j3, final FontFamily fontFamily, final FontWeight fontWeight, final FontStyle fontStyle, final FontSynthesis fontSynthesis, final CurvedTextStyle curvedTextStyle, CurvedDirection.Angular angular, int i) {
        BasicCurvedTextKt.m239basicCurvedTextzBu2efk(curvedScope, str, curvedModifier, angular, i, new Function2<Composer, Integer, CurvedTextStyle>() { // from class: androidx.wear.compose.material.CurvedTextKt$curvedText$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke((Composer) obj, ((Number) obj2).intValue());
            }

            public final CurvedTextStyle invoke(Composer composer, int i2) {
                composer.startReplaceGroup(2099089255);
                ComposerKt.sourceInformation(composer, "C:CurvedText.kt#gj9v0t");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2099089255, i2, -1, "androidx.wear.compose.material.curvedText.<anonymous> (CurvedText.kt:102)");
                }
                CurvedTextStyle curvedTextStyle2 = curvedTextStyle;
                composer.startReplaceGroup(1375248850);
                ComposerKt.sourceInformation(composer, "102@5164L7");
                if (curvedTextStyle2 == null) {
                    CompositionLocal localTextStyle = TextKt.getLocalTextStyle();
                    ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = composer.consume(localTextStyle);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    curvedTextStyle2 = new CurvedTextStyle((TextStyle) objConsume);
                }
                composer.endReplaceGroup();
                long color = j2;
                if (color == 16) {
                    composer.startReplaceGroup(1375252486);
                    ComposerKt.sourceInformation(composer, "*105@5279L7,105@5318L7");
                    color = curvedTextStyle2.getColor();
                    if (color == 16) {
                        CompositionLocal localContentColor = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composer.consume(localContentColor);
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        long j4 = ((Color) objConsume2).unbox-impl();
                        CompositionLocal localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume3 = composer.consume(localContentAlpha);
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        color = Color.copy-wmQWz5c$default(j4, ((Number) objConsume3).floatValue(), 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    }
                    composer.endReplaceGroup();
                }
                CurvedTextStyle curvedTextStyleMerge = curvedTextStyle2.merge(new CurvedTextStyle(j, color, j3, fontFamily, fontWeight, fontStyle, fontSynthesis, null));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return curvedTextStyleMerge;
            }
        });
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This overload is provided for backwards compatibility with Compose for Wear OS 1.0. A newer overload is available with additional font parameters.")
    /* JADX INFO: renamed from: curvedText-g2yp93Q, reason: not valid java name */
    public static final /* synthetic */ void m583curvedTextg2yp93Q(CurvedScope curvedScope, String str, CurvedModifier curvedModifier, final long j, final long j2, final long j3, final CurvedTextStyle curvedTextStyle, CurvedDirection.Angular angular, int i) {
        BasicCurvedTextKt.m239basicCurvedTextzBu2efk(curvedScope, str, curvedModifier, angular, i, new Function2<Composer, Integer, CurvedTextStyle>() { // from class: androidx.wear.compose.material.CurvedTextKt$curvedText$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke((Composer) obj, ((Number) obj2).intValue());
            }

            public final CurvedTextStyle invoke(Composer composer, int i2) {
                composer.startReplaceGroup(-790513052);
                ComposerKt.sourceInformation(composer, "C:CurvedText.kt#gj9v0t");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-790513052, i2, -1, "androidx.wear.compose.material.curvedText.<anonymous> (CurvedText.kt:178)");
                }
                CurvedTextStyle curvedTextStyle2 = curvedTextStyle;
                composer.startReplaceGroup(1375366290);
                ComposerKt.sourceInformation(composer, "178@8834L7");
                if (curvedTextStyle2 == null) {
                    CompositionLocal localTextStyle = TextKt.getLocalTextStyle();
                    ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = composer.consume(localTextStyle);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    curvedTextStyle2 = new CurvedTextStyle((TextStyle) objConsume);
                }
                composer.endReplaceGroup();
                long color = j2;
                if (color == 16) {
                    composer.startReplaceGroup(1375369926);
                    ComposerKt.sourceInformation(composer, "*181@8949L7,181@8988L7");
                    color = curvedTextStyle2.getColor();
                    if (color == 16) {
                        CompositionLocal localContentColor = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composer.consume(localContentColor);
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        long j4 = ((Color) objConsume2).unbox-impl();
                        CompositionLocal localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume3 = composer.consume(localContentAlpha);
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        color = Color.copy-wmQWz5c$default(j4, ((Number) objConsume3).floatValue(), 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    }
                    composer.endReplaceGroup();
                }
                CurvedTextStyle curvedTextStyleMerge = curvedTextStyle2.merge(new CurvedTextStyle(j, color, j3, null, null, null, null, 120, null));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return curvedTextStyleMerge;
            }
        });
    }
}
