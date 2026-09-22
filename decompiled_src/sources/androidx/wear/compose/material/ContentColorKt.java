package androidx.wear.compose.material;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ContentColor.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"LocalContentColor", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/graphics/Color;", "getLocalContentColor", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "compose-material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ContentColorKt {
    private static final ProvidableCompositionLocal<Color> LocalContentColor = CompositionLocalKt.compositionLocalOf$default((SnapshotMutationPolicy) null, new Function0<Color>() { // from class: androidx.wear.compose.material.ContentColorKt$LocalContentColor$1
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.box-impl(m580invoke0d7_KjU());
        }

        /* JADX INFO: renamed from: invoke-0d7_KjU, reason: not valid java name */
        public final long m580invoke0d7_KjU() {
            return Color.Companion.getWhite-0d7_KjU();
        }
    }, 1, (Object) null);

    public static final ProvidableCompositionLocal<Color> getLocalContentColor() {
        return LocalContentColor;
    }
}
