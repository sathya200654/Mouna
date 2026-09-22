package androidx.wear.compose.material;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotMutationPolicy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ContentAlpha.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"LocalContentAlpha", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalContentAlpha", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "compose-material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ContentAlphaKt {
    private static final ProvidableCompositionLocal<Float> LocalContentAlpha = CompositionLocalKt.compositionLocalOf$default((SnapshotMutationPolicy) null, new Function0<Float>() { // from class: androidx.wear.compose.material.ContentAlphaKt$LocalContentAlpha$1
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Float m579invoke() {
            return Float.valueOf(1.0f);
        }
    }, 1, (Object) null);

    public static final ProvidableCompositionLocal<Float> getLocalContentAlpha() {
        return LocalContentAlpha;
    }
}
