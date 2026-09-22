package androidx.wear.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import kotlin.Metadata;

/* JADX INFO: compiled from: MaterialTheme.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8G¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/wear/compose/material/MaterialTheme;", "", "()V", "colors", "Landroidx/wear/compose/material/Colors;", "getColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/wear/compose/material/Colors;", "shapes", "Landroidx/wear/compose/material/Shapes;", "getShapes", "(Landroidx/compose/runtime/Composer;I)Landroidx/wear/compose/material/Shapes;", "typography", "Landroidx/wear/compose/material/Typography;", "getTypography", "(Landroidx/compose/runtime/Composer;I)Landroidx/wear/compose/material/Typography;", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MaterialTheme {
    public static final int $stable = 0;
    public static final MaterialTheme INSTANCE = new MaterialTheme();

    private MaterialTheme() {
    }

    public final Colors getColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1382188726, "C87@4087L7:MaterialTheme.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1382188726, i, -1, "androidx.wear.compose.material.MaterialTheme.<get-colors> (MaterialTheme.kt:87)");
        }
        CompositionLocal localColors = ColorsKt.getLocalColors();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localColors);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Colors colors = (Colors) objConsume;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return colors;
    }

    public final Typography getTypography(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1002471115, "C92@4214L7:MaterialTheme.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1002471115, i, -1, "androidx.wear.compose.material.MaterialTheme.<get-typography> (MaterialTheme.kt:92)");
        }
        CompositionLocal localTypography = TypographyKt.getLocalTypography();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localTypography);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Typography typography = (Typography) objConsume;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return typography;
    }

    public final Shapes getShapes(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1881265992, "C97@4329L7:MaterialTheme.kt#gj9v0t");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1881265992, i, -1, "androidx.wear.compose.material.MaterialTheme.<get-shapes> (MaterialTheme.kt:97)");
        }
        CompositionLocal localShapes = ShapesKt.getLocalShapes();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localShapes);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Shapes shapes = (Shapes) objConsume;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return shapes;
    }
}
