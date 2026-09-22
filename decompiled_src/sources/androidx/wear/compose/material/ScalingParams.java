package androidx.wear.compose.material;

import androidx.compose.animation.core.Easing;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: compiled from: ScalingLazyColumnMeasure.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Deprecated(message = "Was moved to androidx.wear.compose.foundation.lazy package. Please use it instead")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H&ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0002\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0014\u0010\f\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0014\u0010\u000e\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013ø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\u001aÀ\u0006\u0001"}, d2 = {"Landroidx/wear/compose/material/ScalingParams;", "", "edgeAlpha", "", "getEdgeAlpha", "()F", "edgeScale", "getEdgeScale", "maxElementHeight", "getMaxElementHeight", "maxTransitionArea", "getMaxTransitionArea", "minElementHeight", "getMinElementHeight", "minTransitionArea", "getMinTransitionArea", "scaleInterpolator", "Landroidx/compose/animation/core/Easing;", "getScaleInterpolator", "()Landroidx/compose/animation/core/Easing;", "resolveViewportVerticalOffset", "", "viewportConstraints", "Landroidx/compose/ui/unit/Constraints;", "resolveViewportVerticalOffset-BRTryo0", "(J)I", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ScalingParams {
    float getEdgeAlpha();

    float getEdgeScale();

    float getMaxElementHeight();

    float getMaxTransitionArea();

    float getMinElementHeight();

    float getMinTransitionArea();

    Easing getScaleInterpolator();

    /* JADX INFO: renamed from: resolveViewportVerticalOffset-BRTryo0 */
    int mo586resolveViewportVerticalOffsetBRTryo0(long viewportConstraints);
}
