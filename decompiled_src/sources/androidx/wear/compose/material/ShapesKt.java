package androidx.wear.compose.material;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: Shapes.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"LocalShapes", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/wear/compose/material/Shapes;", "getLocalShapes", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "compose-material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ShapesKt {
    private static final ProvidableCompositionLocal<Shapes> LocalShapes = CompositionLocalKt.staticCompositionLocalOf(new Function0<Shapes>() { // from class: androidx.wear.compose.material.ShapesKt$LocalShapes$1
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Shapes m790invoke() {
            return new Shapes(null, null, null, 7, null);
        }
    });

    public static final ProvidableCompositionLocal<Shapes> getLocalShapes() {
        return LocalShapes;
    }
}
