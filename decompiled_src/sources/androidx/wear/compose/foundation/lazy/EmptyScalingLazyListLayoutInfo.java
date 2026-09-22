package androidx.wear.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: ScalingLazyListState.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u00020\nX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000b\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0014\u0010\u001b\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u001c\u0010\u001d\u001a\u00020\u001eX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0006R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006)"}, d2 = {"Landroidx/wear/compose/foundation/lazy/EmptyScalingLazyListLayoutInfo;", "Landroidx/wear/compose/foundation/lazy/ScalingLazyListLayoutInfo;", "()V", "afterAutoCenteringPadding", "", "getAfterAutoCenteringPadding", "()I", "afterContentPadding", "getAfterContentPadding", "anchorType", "Landroidx/wear/compose/foundation/lazy/ScalingLazyListAnchorType;", "getAnchorType-ZuIr4RU", "I", "beforeAutoCenteringPadding", "getBeforeAutoCenteringPadding", "beforeContentPadding", "getBeforeContentPadding", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "reverseLayout", "", "getReverseLayout", "()Z", "totalItemsCount", "getTotalItemsCount", "viewportEndOffset", "getViewportEndOffset", "viewportSize", "Landroidx/compose/ui/unit/IntSize;", "getViewportSize-YbymL2g", "()J", "J", "viewportStartOffset", "getViewportStartOffset", "visibleItemsInfo", "", "Landroidx/wear/compose/foundation/lazy/ScalingLazyListItemInfo;", "getVisibleItemsInfo", "()Ljava/util/List;", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class EmptyScalingLazyListLayoutInfo implements ScalingLazyListLayoutInfo {
    private static final int afterAutoCenteringPadding = 0;
    private static final int afterContentPadding = 0;
    private static final int beforeAutoCenteringPadding = 0;
    private static final int beforeContentPadding = 0;
    private static final boolean reverseLayout = false;
    private static final int totalItemsCount = 0;
    private static final int viewportEndOffset = 0;
    private static final int viewportStartOffset = 0;
    public static final EmptyScalingLazyListLayoutInfo INSTANCE = new EmptyScalingLazyListLayoutInfo();
    private static final List<ScalingLazyListItemInfo> visibleItemsInfo = CollectionsKt.emptyList();
    private static final long viewportSize = IntSize.Companion.getZero-YbymL2g();
    private static final Orientation orientation = Orientation.Vertical;
    private static final int anchorType = ScalingLazyListAnchorType.INSTANCE.m469getItemCenterZuIr4RU();

    private EmptyScalingLazyListLayoutInfo() {
    }

    @Override // androidx.wear.compose.foundation.lazy.ScalingLazyListLayoutInfo
    public List<ScalingLazyListItemInfo> getVisibleItemsInfo() {
        return visibleItemsInfo;
    }

    @Override // androidx.wear.compose.foundation.lazy.ScalingLazyListLayoutInfo
    public int getViewportStartOffset() {
        return viewportStartOffset;
    }

    @Override // androidx.wear.compose.foundation.lazy.ScalingLazyListLayoutInfo
    public int getViewportEndOffset() {
        return viewportEndOffset;
    }

    @Override // androidx.wear.compose.foundation.lazy.ScalingLazyListLayoutInfo
    public int getTotalItemsCount() {
        return totalItemsCount;
    }

    @Override // androidx.wear.compose.foundation.lazy.ScalingLazyListLayoutInfo
    /* JADX INFO: renamed from: getViewportSize-YbymL2g */
    public long getViewportSize() {
        return viewportSize;
    }

    @Override // androidx.wear.compose.foundation.lazy.ScalingLazyListLayoutInfo
    public Orientation getOrientation() {
        return orientation;
    }

    @Override // androidx.wear.compose.foundation.lazy.ScalingLazyListLayoutInfo
    public boolean getReverseLayout() {
        return reverseLayout;
    }

    @Override // androidx.wear.compose.foundation.lazy.ScalingLazyListLayoutInfo
    public int getBeforeContentPadding() {
        return beforeContentPadding;
    }

    @Override // androidx.wear.compose.foundation.lazy.ScalingLazyListLayoutInfo
    public int getAfterContentPadding() {
        return afterContentPadding;
    }

    @Override // androidx.wear.compose.foundation.lazy.ScalingLazyListLayoutInfo
    public int getBeforeAutoCenteringPadding() {
        return beforeAutoCenteringPadding;
    }

    @Override // androidx.wear.compose.foundation.lazy.ScalingLazyListLayoutInfo
    public int getAfterAutoCenteringPadding() {
        return afterAutoCenteringPadding;
    }

    @Override // androidx.wear.compose.foundation.lazy.ScalingLazyListLayoutInfo
    /* JADX INFO: renamed from: getAnchorType-ZuIr4RU */
    public int getAnchorType() {
        return anchorType;
    }
}
