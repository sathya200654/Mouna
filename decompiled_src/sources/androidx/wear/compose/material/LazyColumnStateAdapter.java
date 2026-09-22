package androidx.wear.compose.material;

import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListState;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: PositionIndicator.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\u001d\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"Landroidx/wear/compose/material/LazyColumnStateAdapter;", "Landroidx/wear/compose/material/PositionIndicatorState;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/foundation/lazy/LazyListState;", "(Landroidx/compose/foundation/lazy/LazyListState;)V", "positionFraction", "", "getPositionFraction", "()F", "decimalFirstItemIndex", "decimalLastItemIndex", "equals", "", "other", "", "hashCode", "", "sizeFraction", "scrollableContainerSizePx", "visibility", "Landroidx/wear/compose/material/PositionIndicatorVisibility;", "visibility-KCSNhGQ", "(F)I", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LazyColumnStateAdapter implements PositionIndicatorState {
    public static final int $stable = 0;
    private final LazyListState state;

    public LazyColumnStateAdapter(LazyListState lazyListState) {
        this.state = lazyListState;
    }

    @Override // androidx.wear.compose.material.PositionIndicatorState
    public float getPositionFraction() {
        if (this.state.getLayoutInfo().getVisibleItemsInfo().isEmpty()) {
            return 0.0f;
        }
        float fDecimalFirstItemIndex = decimalFirstItemIndex();
        float totalItemsCount = (this.state.getLayoutInfo().getTotalItemsCount() - decimalLastItemIndex()) + fDecimalFirstItemIndex;
        if (totalItemsCount == 0.0f) {
            return 0.0f;
        }
        return fDecimalFirstItemIndex / totalItemsCount;
    }

    @Override // androidx.wear.compose.material.PositionIndicatorState
    public float sizeFraction(float scrollableContainerSizePx) {
        if (this.state.getLayoutInfo().getTotalItemsCount() == 0) {
            return 1.0f;
        }
        return (decimalLastItemIndex() - decimalFirstItemIndex()) / this.state.getLayoutInfo().getTotalItemsCount();
    }

    @Override // androidx.wear.compose.material.PositionIndicatorState
    /* JADX INFO: renamed from: visibility-KCSNhGQ */
    public int mo597visibilityKCSNhGQ(float scrollableContainerSizePx) {
        if (sizeFraction(scrollableContainerSizePx) < 0.999f) {
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
        LazyColumnStateAdapter lazyColumnStateAdapter = other instanceof LazyColumnStateAdapter ? (LazyColumnStateAdapter) other : null;
        return Intrinsics.areEqual(lazyColumnStateAdapter != null ? lazyColumnStateAdapter.state : null, this.state);
    }

    private final float decimalLastItemIndex() {
        if (this.state.getLayoutInfo().getVisibleItemsInfo().isEmpty()) {
            return 0.0f;
        }
        LazyListItemInfo lazyListItemInfo = (LazyListItemInfo) CollectionsKt.last(this.state.getLayoutInfo().getVisibleItemsInfo());
        return lazyListItemInfo.getIndex() + (RangesKt.coerceAtLeast(RangesKt.coerceAtMost(this.state.getLayoutInfo().getViewportEndOffset() - lazyListItemInfo.getOffset(), lazyListItemInfo.getSize()), 1) / RangesKt.coerceAtLeast(lazyListItemInfo.getSize(), 1));
    }

    private final float decimalFirstItemIndex() {
        if (this.state.getLayoutInfo().getVisibleItemsInfo().isEmpty()) {
            return 0.0f;
        }
        LazyListItemInfo lazyListItemInfo = (LazyListItemInfo) CollectionsKt.first(this.state.getLayoutInfo().getVisibleItemsInfo());
        return lazyListItemInfo.getIndex() - (RangesKt.coerceAtMost(lazyListItemInfo.getOffset() - this.state.getLayoutInfo().getViewportStartOffset(), 0) / RangesKt.coerceAtLeast(lazyListItemInfo.getSize(), 1));
    }
}
