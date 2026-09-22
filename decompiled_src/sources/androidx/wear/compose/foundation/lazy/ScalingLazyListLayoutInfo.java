package androidx.wear.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: ScalingLazyListLayoutInfo.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0018\u0010\b\u001a\u00020\tX¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\n\u0010\u0005R\u0012\u0010\u000b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0005R\u0012\u0010\r\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0005R\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0005R\u0012\u0010\u0019\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0005R\u0018\u0010\u001b\u001a\u00020\u001cX¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0012\u0010\u001f\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0005R\u0018\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%\u0082\u0001\u0002&'ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006(À\u0006\u0001"}, d2 = {"Landroidx/wear/compose/foundation/lazy/ScalingLazyListLayoutInfo;", "", "afterAutoCenteringPadding", "", "getAfterAutoCenteringPadding", "()I", "afterContentPadding", "getAfterContentPadding", "anchorType", "Landroidx/wear/compose/foundation/lazy/ScalingLazyListAnchorType;", "getAnchorType-ZuIr4RU", "beforeAutoCenteringPadding", "getBeforeAutoCenteringPadding", "beforeContentPadding", "getBeforeContentPadding", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "reverseLayout", "", "getReverseLayout", "()Z", "totalItemsCount", "getTotalItemsCount", "viewportEndOffset", "getViewportEndOffset", "viewportSize", "Landroidx/compose/ui/unit/IntSize;", "getViewportSize-YbymL2g", "()J", "viewportStartOffset", "getViewportStartOffset", "visibleItemsInfo", "", "Landroidx/wear/compose/foundation/lazy/ScalingLazyListItemInfo;", "getVisibleItemsInfo", "()Ljava/util/List;", "Landroidx/wear/compose/foundation/lazy/DefaultScalingLazyListLayoutInfo;", "Landroidx/wear/compose/foundation/lazy/EmptyScalingLazyListLayoutInfo;", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ScalingLazyListLayoutInfo {
    int getAfterAutoCenteringPadding();

    int getAfterContentPadding();

    /* JADX INFO: renamed from: getAnchorType-ZuIr4RU */
    int mo446getAnchorTypeZuIr4RU();

    int getBeforeAutoCenteringPadding();

    int getBeforeContentPadding();

    Orientation getOrientation();

    boolean getReverseLayout();

    int getTotalItemsCount();

    int getViewportEndOffset();

    /* JADX INFO: renamed from: getViewportSize-YbymL2g */
    long mo447getViewportSizeYbymL2g();

    int getViewportStartOffset();

    List<ScalingLazyListItemInfo> getVisibleItemsInfo();
}
