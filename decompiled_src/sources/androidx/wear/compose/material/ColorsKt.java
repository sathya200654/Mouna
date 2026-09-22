package androidx.wear.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: Colors.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a \u0010\f\u001a\u00020\u0006*\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0011"}, d2 = {"LocalColors", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/wear/compose/material/Colors;", "getLocalColors", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "contentColorFor", "Landroidx/compose/ui/graphics/Color;", "backgroundColor", "contentColorFor-ek8zF_U", "(JLandroidx/compose/runtime/Composer;I)J", "contentColorFor-4WTKRHQ", "(Landroidx/wear/compose/material/Colors;J)J", "toDisabledColor", "disabledContentAlpha", "", "toDisabledColor-3J-VO9M", "(JFLandroidx/compose/runtime/Composer;II)J", "compose-material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ColorsKt {
    private static final ProvidableCompositionLocal<Colors> LocalColors = CompositionLocalKt.staticCompositionLocalOf(new Function0<Colors>() { // from class: androidx.wear.compose.material.ColorsKt$LocalColors$1
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Colors m576invoke() {
            return new Colors(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 8191, null);
        }
    });

    /* JADX INFO: renamed from: contentColorFor-4WTKRHQ, reason: not valid java name */
    public static final long m573contentColorFor4WTKRHQ(Colors colors, long j) {
        if (!Color.equals-impl0(j, colors.getPrimary()) && !Color.equals-impl0(j, colors.getPrimaryVariant())) {
            if (!Color.equals-impl0(j, colors.getSecondary()) && !Color.equals-impl0(j, colors.getSecondaryVariant())) {
                if (Color.equals-impl0(j, colors.getBackground())) {
                    return colors.getOnBackground();
                }
                if (Color.equals-impl0(j, colors.getSurface())) {
                    return colors.getOnSurface();
                }
                return Color.equals-impl0(j, colors.getError()) ? colors.getOnError() : Color.Companion.getUnspecified-0d7_KjU();
            }
            return colors.getOnSecondary();
        }
        return colors.getOnPrimary();
    }

    /* JADX INFO: renamed from: contentColorFor-ek8zF_U, reason: not valid java name */
    public static final long m574contentColorForek8zF_U(long j, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 583563822, "C(contentColorFor)P(0:c#ui.graphics.Color):Colors.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(583563822, i, -1, "androidx.wear.compose.material.contentColorFor (Colors.kt:145)");
        }
        composer.startReplaceGroup(-1876942554);
        ComposerKt.sourceInformation(composer, "*145@5705L6,145@5776L7");
        long jM573contentColorFor4WTKRHQ = m573contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColors(composer, 6), j);
        if (jM573contentColorFor4WTKRHQ == 16) {
            CompositionLocal localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd(composer);
            jM573contentColorFor4WTKRHQ = ((Color) objConsume).unbox-impl();
        }
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return jM573contentColorFor4WTKRHQ;
    }

    /* JADX INFO: renamed from: toDisabledColor-3J-VO9M, reason: not valid java name */
    public static final long m575toDisabledColor3JVO9M(long j, float f, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -74705399, "C(toDisabledColor)152@6007L8:Colors.kt#gj9v0t");
        if ((i2 & 1) != 0) {
            f = ContentAlpha.INSTANCE.getDisabled(composer, 6);
        }
        float f2 = f;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-74705399, i, -1, "androidx.wear.compose.material.toDisabledColor (Colors.kt:153)");
        }
        long j2 = Color.copy-wmQWz5c$default(j, f2, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return j2;
    }

    public static final ProvidableCompositionLocal<Colors> getLocalColors() {
        return LocalColors;
    }
}
