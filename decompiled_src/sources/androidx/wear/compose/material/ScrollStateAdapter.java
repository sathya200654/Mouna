package androidx.wear.compose.material;

import androidx.compose.foundation.ScrollState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PositionIndicator.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\u001d\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0015"}, d2 = {"Landroidx/wear/compose/material/ScrollStateAdapter;", "Landroidx/wear/compose/material/PositionIndicatorState;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "(Landroidx/compose/foundation/ScrollState;)V", "positionFraction", "", "getPositionFraction", "()F", "equals", "", "other", "", "hashCode", "", "sizeFraction", "scrollableContainerSizePx", "visibility", "Landroidx/wear/compose/material/PositionIndicatorVisibility;", "visibility-KCSNhGQ", "(F)I", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ScrollStateAdapter implements PositionIndicatorState {
    public static final int $stable = 0;
    private final ScrollState scrollState;

    public ScrollStateAdapter(ScrollState scrollState) {
        this.scrollState = scrollState;
    }

    @Override // androidx.wear.compose.material.PositionIndicatorState
    public float getPositionFraction() {
        if (this.scrollState.getMaxValue() == 0) {
            return 0.0f;
        }
        return this.scrollState.getValue() / this.scrollState.getMaxValue();
    }

    @Override // androidx.wear.compose.material.PositionIndicatorState
    public float sizeFraction(float scrollableContainerSizePx) {
        if (this.scrollState.getMaxValue() + scrollableContainerSizePx == 0.0f) {
            return 1.0f;
        }
        return scrollableContainerSizePx / (this.scrollState.getMaxValue() + scrollableContainerSizePx);
    }

    @Override // androidx.wear.compose.material.PositionIndicatorState
    /* JADX INFO: renamed from: visibility-KCSNhGQ */
    public int mo597visibilityKCSNhGQ(float scrollableContainerSizePx) {
        if (this.scrollState.getMaxValue() == 0) {
            return PositionIndicatorVisibility.INSTANCE.m725getHideGLQwCHQ();
        }
        if (this.scrollState.isScrollInProgress()) {
            return PositionIndicatorVisibility.INSTANCE.m726getShowGLQwCHQ();
        }
        return PositionIndicatorVisibility.INSTANCE.m724getAutoHideGLQwCHQ();
    }

    public boolean equals(Object other) {
        ScrollStateAdapter scrollStateAdapter = other instanceof ScrollStateAdapter ? (ScrollStateAdapter) other : null;
        return Intrinsics.areEqual(scrollStateAdapter != null ? scrollStateAdapter.scrollState : null, this.scrollState);
    }

    public int hashCode() {
        return this.scrollState.hashCode();
    }
}
