package androidx.wear.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ScalingLazyColumnMeasure.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0000\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u0018¢\u0006\u0002\u0010\u0019R\u0014\u0010\u0014\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0012\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u001c\u0010\u0017\u001a\u00020\u0018X\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001d\u0010\u001bR\u0014\u0010\u0013\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0014\u0010\u0011\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0014\u0010\u0016\u001a\u00020\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0014\u0010\u0015\u001a\u00020\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010$R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010$R\u0014\u0010\b\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001bR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001bR\u001c\u0010\u000f\u001a\u00020\u0010X\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010/\u001a\u0004\b-\u0010.R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001bR\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u0010&\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00063"}, d2 = {"Landroidx/wear/compose/foundation/lazy/DefaultScalingLazyListLayoutInfo;", "Landroidx/wear/compose/foundation/lazy/ScalingLazyListLayoutInfo;", "internalVisibleItemsInfo", "", "Landroidx/wear/compose/foundation/lazy/ScalingLazyListItemInfo;", "viewportStartOffset", "", "viewportEndOffset", "totalItemsCount", "centerItemIndex", "centerItemScrollOffset", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "viewportSize", "Landroidx/compose/ui/unit/IntSize;", "beforeContentPadding", "afterContentPadding", "beforeAutoCenteringPadding", "afterAutoCenteringPadding", "readyForInitialScroll", "initialized", "anchorType", "Landroidx/wear/compose/foundation/lazy/ScalingLazyListAnchorType;", "(Ljava/util/List;IIIIIZLandroidx/compose/foundation/gestures/Orientation;JIIIIZZILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAfterAutoCenteringPadding", "()I", "getAfterContentPadding", "getAnchorType-ZuIr4RU", "I", "getBeforeAutoCenteringPadding", "getBeforeContentPadding", "getCenterItemIndex", "getCenterItemScrollOffset", "getInitialized$compose_foundation_release", "()Z", "getInternalVisibleItemsInfo$compose_foundation_release", "()Ljava/util/List;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getReadyForInitialScroll$compose_foundation_release", "getReverseLayout", "getTotalItemsCount", "getViewportEndOffset", "getViewportSize-YbymL2g", "()J", "J", "getViewportStartOffset", "visibleItemsInfo", "getVisibleItemsInfo", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultScalingLazyListLayoutInfo implements ScalingLazyListLayoutInfo {
    public static final int $stable = 8;
    private final int afterAutoCenteringPadding;
    private final int afterContentPadding;
    private final int anchorType;
    private final int beforeAutoCenteringPadding;
    private final int beforeContentPadding;
    private final int centerItemIndex;
    private final int centerItemScrollOffset;
    private final boolean initialized;
    private final List<ScalingLazyListItemInfo> internalVisibleItemsInfo;
    private final Orientation orientation;
    private final boolean readyForInitialScroll;
    private final boolean reverseLayout;
    private final int totalItemsCount;
    private final int viewportEndOffset;
    private final long viewportSize;
    private final int viewportStartOffset;

    public /* synthetic */ DefaultScalingLazyListLayoutInfo(List list, int i, int i2, int i3, int i4, int i5, boolean z, Orientation orientation, long j, int i6, int i7, int i8, int i9, boolean z2, boolean z3, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, i, i2, i3, i4, i5, z, orientation, j, i6, i7, i8, i9, z2, z3, i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private DefaultScalingLazyListLayoutInfo(List<? extends ScalingLazyListItemInfo> list, int i, int i2, int i3, int i4, int i5, boolean z, Orientation orientation, long j, int i6, int i7, int i8, int i9, boolean z2, boolean z3, int i10) {
        this.internalVisibleItemsInfo = list;
        this.viewportStartOffset = i;
        this.viewportEndOffset = i2;
        this.totalItemsCount = i3;
        this.centerItemIndex = i4;
        this.centerItemScrollOffset = i5;
        this.reverseLayout = z;
        this.orientation = orientation;
        this.viewportSize = j;
        this.beforeContentPadding = i6;
        this.afterContentPadding = i7;
        this.beforeAutoCenteringPadding = i8;
        this.afterAutoCenteringPadding = i9;
        this.readyForInitialScroll = z2;
        this.initialized = z3;
        this.anchorType = i10;
    }

    public final List<ScalingLazyListItemInfo> getInternalVisibleItemsInfo$compose_foundation_release() {
        return this.internalVisibleItemsInfo;
    }

    @Override // androidx.wear.compose.foundation.lazy.ScalingLazyListLayoutInfo
    public int getViewportStartOffset() {
        return this.viewportStartOffset;
    }

    @Override // androidx.wear.compose.foundation.lazy.ScalingLazyListLayoutInfo
    public int getViewportEndOffset() {
        return this.viewportEndOffset;
    }

    @Override // androidx.wear.compose.foundation.lazy.ScalingLazyListLayoutInfo
    public int getTotalItemsCount() {
        return this.totalItemsCount;
    }

    public final int getCenterItemIndex() {
        return this.centerItemIndex;
    }

    public final int getCenterItemScrollOffset() {
        return this.centerItemScrollOffset;
    }

    @Override // androidx.wear.compose.foundation.lazy.ScalingLazyListLayoutInfo
    public boolean getReverseLayout() {
        return this.reverseLayout;
    }

    @Override // androidx.wear.compose.foundation.lazy.ScalingLazyListLayoutInfo
    public Orientation getOrientation() {
        return this.orientation;
    }

    @Override // androidx.wear.compose.foundation.lazy.ScalingLazyListLayoutInfo
    /* JADX INFO: renamed from: getViewportSize-YbymL2g, reason: not valid java name and from getter */
    public long getViewportSize() {
        return this.viewportSize;
    }

    @Override // androidx.wear.compose.foundation.lazy.ScalingLazyListLayoutInfo
    public int getBeforeContentPadding() {
        return this.beforeContentPadding;
    }

    @Override // androidx.wear.compose.foundation.lazy.ScalingLazyListLayoutInfo
    public int getAfterContentPadding() {
        return this.afterContentPadding;
    }

    @Override // androidx.wear.compose.foundation.lazy.ScalingLazyListLayoutInfo
    public int getBeforeAutoCenteringPadding() {
        return this.beforeAutoCenteringPadding;
    }

    @Override // androidx.wear.compose.foundation.lazy.ScalingLazyListLayoutInfo
    public int getAfterAutoCenteringPadding() {
        return this.afterAutoCenteringPadding;
    }

    /* JADX INFO: renamed from: getReadyForInitialScroll$compose_foundation_release, reason: from getter */
    public final boolean getReadyForInitialScroll() {
        return this.readyForInitialScroll;
    }

    /* JADX INFO: renamed from: getInitialized$compose_foundation_release, reason: from getter */
    public final boolean getInitialized() {
        return this.initialized;
    }

    @Override // androidx.wear.compose.foundation.lazy.ScalingLazyListLayoutInfo
    /* JADX INFO: renamed from: getAnchorType-ZuIr4RU, reason: not valid java name and from getter */
    public int getAnchorType() {
        return this.anchorType;
    }

    @Override // androidx.wear.compose.foundation.lazy.ScalingLazyListLayoutInfo
    public List<ScalingLazyListItemInfo> getVisibleItemsInfo() {
        return this.initialized ? this.internalVisibleItemsInfo : CollectionsKt.emptyList();
    }
}
