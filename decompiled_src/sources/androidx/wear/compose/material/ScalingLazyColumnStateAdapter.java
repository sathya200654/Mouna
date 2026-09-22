package androidx.wear.compose.material;

import androidx.compose.ui.unit.IntSize;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: PositionIndicator.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0002J\u0013\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J\u001d\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, d2 = {"Landroidx/wear/compose/material/ScalingLazyColumnStateAdapter;", "Landroidx/wear/compose/material/PositionIndicatorState;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/wear/compose/foundation/lazy/ScalingLazyListState;", "(Landroidx/wear/compose/foundation/lazy/ScalingLazyListState;)V", "positionFraction", "", "getPositionFraction", "()F", "canScrollBackwardsOrForwards", "", "decimalFirstItemIndex", "layoutInfo", "Landroidx/wear/compose/foundation/lazy/ScalingLazyListLayoutInfo;", "decimalLastItemIndex", "equals", "other", "", "hashCode", "", "sizeFraction", "scrollableContainerSizePx", "visibility", "Landroidx/wear/compose/material/PositionIndicatorVisibility;", "visibility-KCSNhGQ", "(F)I", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ScalingLazyColumnStateAdapter implements PositionIndicatorState {
    public static final int $stable = 0;
    private final androidx.wear.compose.foundation.lazy.ScalingLazyListState state;

    public ScalingLazyColumnStateAdapter(androidx.wear.compose.foundation.lazy.ScalingLazyListState scalingLazyListState) {
        this.state = scalingLazyListState;
    }

    @Override // androidx.wear.compose.material.PositionIndicatorState
    public float getPositionFraction() {
        androidx.wear.compose.foundation.lazy.ScalingLazyListLayoutInfo layoutInfo = this.state.getLayoutInfo();
        if (layoutInfo.getVisibleItemsInfo().isEmpty()) {
            return 0.0f;
        }
        float fDecimalFirstItemIndex = decimalFirstItemIndex(layoutInfo);
        float totalItemsCount = (layoutInfo.getTotalItemsCount() - decimalLastItemIndex(layoutInfo)) + fDecimalFirstItemIndex;
        if (totalItemsCount == 0.0f) {
            return 0.0f;
        }
        return fDecimalFirstItemIndex / totalItemsCount;
    }

    @Override // androidx.wear.compose.material.PositionIndicatorState
    public float sizeFraction(float scrollableContainerSizePx) {
        androidx.wear.compose.foundation.lazy.ScalingLazyListLayoutInfo layoutInfo = this.state.getLayoutInfo();
        if (layoutInfo.getTotalItemsCount() == 0) {
            return 1.0f;
        }
        return (decimalLastItemIndex(layoutInfo) - decimalFirstItemIndex(layoutInfo)) / layoutInfo.getTotalItemsCount();
    }

    @Override // androidx.wear.compose.material.PositionIndicatorState
    /* JADX INFO: renamed from: visibility-KCSNhGQ */
    public int mo597visibilityKCSNhGQ(float scrollableContainerSizePx) {
        if (!this.state.getLayoutInfo().getVisibleItemsInfo().isEmpty() && canScrollBackwardsOrForwards()) {
            if (this.state.isScrollInProgress()) {
                return PositionIndicatorVisibility.INSTANCE.m726getShowGLQwCHQ();
            }
            return PositionIndicatorVisibility.INSTANCE.m724getAutoHideGLQwCHQ();
        }
        return PositionIndicatorVisibility.INSTANCE.m725getHideGLQwCHQ();
    }

    public int hashCode() {
        return this.state.hashCode();
    }

    public boolean equals(Object other) {
        ScalingLazyColumnStateAdapter scalingLazyColumnStateAdapter = other instanceof ScalingLazyColumnStateAdapter ? (ScalingLazyColumnStateAdapter) other : null;
        return Intrinsics.areEqual(scalingLazyColumnStateAdapter != null ? scalingLazyColumnStateAdapter.state : null, this.state);
    }

    private final float decimalLastItemIndex(androidx.wear.compose.foundation.lazy.ScalingLazyListLayoutInfo layoutInfo) {
        if (layoutInfo.getVisibleItemsInfo().isEmpty()) {
            return 0.0f;
        }
        androidx.wear.compose.foundation.lazy.ScalingLazyListItemInfo scalingLazyListItemInfo = (androidx.wear.compose.foundation.lazy.ScalingLazyListItemInfo) CollectionsKt.last(layoutInfo.getVisibleItemsInfo());
        return scalingLazyListItemInfo.getIndex() + RangesKt.coerceAtMost(1.0f - (((PositionIndicatorKt.m711startOffsetw3akWxg(scalingLazyListItemInfo, layoutInfo.getAnchorType()) + scalingLazyListItemInfo.getSize()) - (IntSize.getHeight-impl(layoutInfo.getViewportSize()) / 2.0f)) / RangesKt.coerceAtLeast(scalingLazyListItemInfo.getSize(), 1)), 1.0f);
    }

    private final float decimalFirstItemIndex(androidx.wear.compose.foundation.lazy.ScalingLazyListLayoutInfo layoutInfo) {
        if (layoutInfo.getVisibleItemsInfo().isEmpty()) {
            return 0.0f;
        }
        androidx.wear.compose.foundation.lazy.ScalingLazyListItemInfo scalingLazyListItemInfo = (androidx.wear.compose.foundation.lazy.ScalingLazyListItemInfo) CollectionsKt.first(layoutInfo.getVisibleItemsInfo());
        return scalingLazyListItemInfo.getIndex() + RangesKt.coerceAtLeast(((-(IntSize.getHeight-impl(layoutInfo.getViewportSize()) / 2.0f)) - PositionIndicatorKt.m711startOffsetw3akWxg(scalingLazyListItemInfo, layoutInfo.getAnchorType())) / RangesKt.coerceAtLeast(scalingLazyListItemInfo.getSize(), 1), 0.0f);
    }

    private final boolean canScrollBackwardsOrForwards() {
        return this.state.getCanScrollBackward() || this.state.getCanScrollForward();
    }
}
