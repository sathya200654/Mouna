package androidx.wear.compose.material;

import androidx.compose.ui.Modifier;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: compiled from: ScalingLazyListItemScope.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@ScalingLazyScopeMarker
@Deprecated(message = "Was moved to androidx.wear.compose.foundation.lazy package. Please use it instead")
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\u00020\u0003*\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0007\u001a\u00020\u0003*\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005H&\u0082\u0001\u0001\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Landroidx/wear/compose/material/ScalingLazyListItemScope;", "", "fillParentMaxHeight", "Landroidx/compose/ui/Modifier;", "fraction", "", "fillParentMaxSize", "fillParentMaxWidth", "Landroidx/wear/compose/material/ScalingLazyListItemScopeImpl;", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ScalingLazyListItemScope {
    Modifier fillParentMaxHeight(Modifier modifier, float f);

    Modifier fillParentMaxSize(Modifier modifier, float f);

    Modifier fillParentMaxWidth(Modifier modifier, float f);

    static /* synthetic */ Modifier fillParentMaxSize$default(ScalingLazyListItemScope scalingLazyListItemScope, Modifier modifier, float f, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fillParentMaxSize");
        }
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        return scalingLazyListItemScope.fillParentMaxSize(modifier, f);
    }

    static /* synthetic */ Modifier fillParentMaxWidth$default(ScalingLazyListItemScope scalingLazyListItemScope, Modifier modifier, float f, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fillParentMaxWidth");
        }
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        return scalingLazyListItemScope.fillParentMaxWidth(modifier, f);
    }

    static /* synthetic */ Modifier fillParentMaxHeight$default(ScalingLazyListItemScope scalingLazyListItemScope, Modifier modifier, float f, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fillParentMaxHeight");
        }
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        return scalingLazyListItemScope.fillParentMaxHeight(modifier, f);
    }
}
