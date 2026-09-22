package androidx.wear.compose.foundation.lazy;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListLayoutInfo;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.window.core.layout.WindowSizeClass;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ScalingLazyListState.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u0000 _2\u00020\u0001:\u0002_`B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J \u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00032\b\b\u0002\u00102\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u00103J&\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u00182\f\u00106\u001a\b\u0012\u0004\u0012\u000208072\u0006\u00109\u001a\u00020\u0003H\u0002J&\u0010:\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u00182\f\u0010;\u001a\b\u0012\u0004\u0012\u000208072\u0006\u0010<\u001a\u00020\u0003H\u0002J \u0010=\u001a\u00020\f2\u0006\u00105\u001a\u00020\u00182\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0002J\u0010\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020CH\u0016J'\u0010E\u001a\u0004\u0018\u00010\u00032\u0006\u0010>\u001a\u00020?2\u0006\u00105\u001a\u00020\u00182\u0006\u0010F\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010GJ?\u0010H\u001a\u0002002\u0006\u0010I\u001a\u00020J2'\u0010K\u001a#\b\u0001\u0012\u0004\u0012\u00020M\u0012\n\u0012\b\u0012\u0004\u0012\u0002000N\u0012\u0006\u0012\u0004\u0018\u00010O0L¢\u0006\u0002\bPH\u0096@¢\u0006\u0002\u0010QJ\u0010\u0010R\u001a\u000200H\u0080@¢\u0006\u0004\bS\u0010TJ(\u0010U\u001a\u0002002\u0006\u0010V\u001a\u00020\f2\u0006\u00101\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u0003H\u0080@¢\u0006\u0004\bW\u0010XJ \u0010U\u001a\u0002002\u0006\u00101\u001a\u00020\u00032\b\b\u0002\u00102\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u00103J&\u0010Y\u001a\u00020\f2\u0006\u00105\u001a\u00020\u00182\f\u0010;\u001a\b\u0012\u0004\u0012\u00020A072\u0006\u0010<\u001a\u00020\u0003H\u0002J\u0014\u0010Z\u001a\u00020\u0003*\u00020A2\u0006\u00105\u001a\u00020\u0018H\u0002J\u0016\u0010[\u001a\u00020\u0003*\u00020\u00182\b\u0010@\u001a\u0004\u0018\u00010AH\u0002J\u0016\u0010[\u001a\u00020\u0003*\u00020\u00182\b\u0010@\u001a\u0004\u0018\u000108H\u0002J\u0014\u0010\\\u001a\u00020\u0003*\u0002082\u0006\u00105\u001a\u00020\u0018H\u0002J\u0014\u0010]\u001a\u00020\u0003*\u0002082\u0006\u00105\u001a\u00020\u0018H\u0002J\f\u0010^\u001a\u00020\u0003*\u00020\u0018H\u0002R\u001b\u0010\u0006\u001a\u00020\u00038@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0012\u0010\bR\u0011\u0010\u0014\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\bR\u001c\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u0017X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0014\u0010 \u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u000eR\u001b\u0010!\u001a\u00020\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\n\u001a\u0004\b#\u0010$R\u001a\u0010&\u001a\u00020'X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001b\u0010,\u001a\u00020\u00038@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\n\u001a\u0004\b-\u0010\b¨\u0006a"}, d2 = {"Landroidx/wear/compose/foundation/lazy/ScalingLazyListState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "initialCenterItemIndex", "", "initialCenterItemScrollOffset", "(II)V", "bottomAutoCenteringItemSizePx", "getBottomAutoCenteringItemSizePx$compose_foundation_release", "()I", "bottomAutoCenteringItemSizePx$delegate", "Landroidx/compose/runtime/State;", "canScrollBackward", "", "getCanScrollBackward", "()Z", "canScrollForward", "getCanScrollForward", "centerItemIndex", "getCenterItemIndex", "centerItemIndex$delegate", "centerItemScrollOffset", "getCenterItemScrollOffset", "config", "Landroidx/compose/runtime/MutableState;", "Landroidx/wear/compose/foundation/lazy/ScalingLazyListState$Configuration;", "getConfig$compose_foundation_release", "()Landroidx/compose/runtime/MutableState;", "incompleteScrollAnimated", "incompleteScrollItem", "incompleteScrollOffset", "initialized", "getInitialized$compose_foundation_release", "isScrollInProgress", "layoutInfo", "Landroidx/wear/compose/foundation/lazy/ScalingLazyListLayoutInfo;", "getLayoutInfo", "()Landroidx/wear/compose/foundation/lazy/ScalingLazyListLayoutInfo;", "layoutInfo$delegate", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "getLazyListState$compose_foundation_release", "()Landroidx/compose/foundation/lazy/LazyListState;", "setLazyListState$compose_foundation_release", "(Landroidx/compose/foundation/lazy/LazyListState;)V", "topAutoCenteringItemSizePx", "getTopAutoCenteringItemSizePx$compose_foundation_release", "topAutoCenteringItemSizePx$delegate", "animateScrollToItem", "", "index", "scrollOffset", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateBottomAutoCenteringPaddingPx", "params", "visibleItemsInfo", "", "Landroidx/wear/compose/foundation/lazy/ScalingLazyListItemInfo;", "totalItemsCount", "calculateTopAutoCenteringPaddingPx", "visibleItems", "totalItemCount", "discardAutoCenteringListItem", "lazyListLayoutInfo", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "item", "Landroidx/compose/foundation/lazy/LazyListItemInfo;", "dispatchRawDelta", "", "delta", "findItemNearestCenter", "verticalAdjustment", "(Landroidx/compose/foundation/lazy/LazyListLayoutInfo;Landroidx/wear/compose/foundation/lazy/ScalingLazyListState$Configuration;I)Ljava/lang/Integer;", "scroll", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollToInitialItem", "scrollToInitialItem$compose_foundation_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollToItem", "animated", "scrollToItem$compose_foundation_release", "(ZIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "topSpacerIsCorrectlySized", "itemSizeAboveOffsetPoint", "spaceNeeded", "unadjustedItemSizeAboveOffsetPoint", "unadjustedItemSizeBelowOffsetPoint", "viewportCenterLinePx", "Companion", "Configuration", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ScalingLazyListState implements ScrollableState {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Saver<ScalingLazyListState, Object> Saver = ListSaverKt.listSaver(new Function2<SaverScope, ScalingLazyListState, List<? extends Integer>>() { // from class: androidx.wear.compose.foundation.lazy.ScalingLazyListState$Companion$Saver$1
        public final List<Integer> invoke(SaverScope saverScope, ScalingLazyListState scalingLazyListState) {
            return CollectionsKt.listOf(new Integer[]{Integer.valueOf(scalingLazyListState.getCenterItemIndex()), Integer.valueOf(scalingLazyListState.getCenterItemScrollOffset())});
        }
    }, new Function1<List<? extends Integer>, ScalingLazyListState>() { // from class: androidx.wear.compose.foundation.lazy.ScalingLazyListState$Companion$Saver$2
        public final ScalingLazyListState invoke(List<Integer> list) {
            return new ScalingLazyListState(list.get(0).intValue(), list.get(1).intValue());
        }
    });

    /* JADX INFO: renamed from: bottomAutoCenteringItemSizePx$delegate, reason: from kotlin metadata */
    private final State bottomAutoCenteringItemSizePx;

    /* JADX INFO: renamed from: centerItemIndex$delegate, reason: from kotlin metadata */
    private final State centerItemIndex;
    private final MutableState<Configuration> config;
    private final MutableState<Boolean> incompleteScrollAnimated;
    private final MutableState<Integer> incompleteScrollItem;
    private final MutableState<Integer> incompleteScrollOffset;
    private int initialCenterItemIndex;
    private int initialCenterItemScrollOffset;
    private final MutableState<Boolean> initialized;

    /* JADX INFO: renamed from: layoutInfo$delegate, reason: from kotlin metadata */
    private final State layoutInfo;
    private LazyListState lazyListState;

    /* JADX INFO: renamed from: topAutoCenteringItemSizePx$delegate, reason: from kotlin metadata */
    private final State topAutoCenteringItemSizePx;

    /* JADX INFO: renamed from: androidx.wear.compose.foundation.lazy.ScalingLazyListState$scrollToItem$2, reason: invalid class name */
    /* JADX INFO: compiled from: ScalingLazyListState.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.wear.compose.foundation.lazy.ScalingLazyListState", f = "ScalingLazyListState.kt", i = {1, 1, 1, 1, 1, 1, 1}, l = {WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND, 489, 497}, m = "scrollToItem$compose_foundation_release", n = {"this", "animated", "index", "scrollOffset", "targetIndex", "lazyListStateIndex", "offsetToCenterOfViewport"}, s = {"L$0", "Z$0", "I$0", "I$1", "I$2", "I$3", "I$4"})
    static final class AnonymousClass2 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ScalingLazyListState.this.scrollToItem$compose_foundation_release(false, 0, 0, (Continuation) this);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ScalingLazyListState() {
        int i = 0;
        this(i, i, 3, null);
    }

    public ScalingLazyListState(int i, int i2) {
        this.initialCenterItemIndex = i;
        this.initialCenterItemScrollOffset = i2;
        this.lazyListState = new LazyListState(0, 0);
        this.initialized = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.config = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.incompleteScrollItem = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.incompleteScrollOffset = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.incompleteScrollAnimated = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.centerItemIndex = SnapshotStateKt.derivedStateOf(new Function0<Integer>() { // from class: androidx.wear.compose.foundation.lazy.ScalingLazyListState$centerItemIndex$2
            {
                super(0);
            }

            /* JADX WARN: Code duplicated, block: B:12:0x0026  */
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m477invoke() {
                int iIntValue;
                ScalingLazyListLayoutInfo layoutInfo = this.this$0.getLayoutInfo();
                DefaultScalingLazyListLayoutInfo defaultScalingLazyListLayoutInfo = layoutInfo instanceof DefaultScalingLazyListLayoutInfo ? (DefaultScalingLazyListLayoutInfo) layoutInfo : null;
                if (defaultScalingLazyListLayoutInfo == null) {
                    iIntValue = this.this$0.initialCenterItemIndex;
                } else {
                    Integer numValueOf = defaultScalingLazyListLayoutInfo.getInitialized() ? Integer.valueOf(defaultScalingLazyListLayoutInfo.getCenterItemIndex()) : null;
                    if (numValueOf == null) {
                        iIntValue = this.this$0.initialCenterItemIndex;
                    } else {
                        iIntValue = numValueOf.intValue();
                    }
                }
                return Integer.valueOf(iIntValue);
            }
        });
        this.topAutoCenteringItemSizePx = SnapshotStateKt.derivedStateOf(new Function0<Integer>() { // from class: androidx.wear.compose.foundation.lazy.ScalingLazyListState$topAutoCenteringItemSizePx$2
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m479invoke() {
                ScalingLazyListState.Configuration configuration = (ScalingLazyListState.Configuration) this.this$0.getConfig$compose_foundation_release().getValue();
                int iCoerceAtLeast = 0;
                if (configuration != null && configuration.getAutoCentering() != null) {
                    iCoerceAtLeast = RangesKt.coerceAtLeast(this.this$0.getLayoutInfo().getBeforeAutoCenteringPadding() - configuration.getGapBetweenItemsPx(), 0);
                }
                return Integer.valueOf(iCoerceAtLeast);
            }
        });
        this.bottomAutoCenteringItemSizePx = SnapshotStateKt.derivedStateOf(new Function0<Integer>() { // from class: androidx.wear.compose.foundation.lazy.ScalingLazyListState$bottomAutoCenteringItemSizePx$2
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m476invoke() {
                ScalingLazyListState.Configuration configuration = (ScalingLazyListState.Configuration) this.this$0.getConfig$compose_foundation_release().getValue();
                int iCoerceAtLeast = 0;
                if (configuration != null && configuration.getAutoCentering() != null && !ScalingLazyListStateKt.internalVisibleItemInfo(this.this$0.getLayoutInfo()).isEmpty()) {
                    iCoerceAtLeast = RangesKt.coerceAtLeast(this.this$0.getLayoutInfo().getAfterAutoCenteringPadding() - configuration.getGapBetweenItemsPx(), 0);
                }
                return Integer.valueOf(iCoerceAtLeast);
            }
        });
        this.layoutInfo = SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new Function0<ScalingLazyListLayoutInfo>() { // from class: androidx.wear.compose.foundation.lazy.ScalingLazyListState$layoutInfo$2
            {
                super(0);
            }

            /* JADX WARN: Code duplicated, block: B:23:0x012c  */
            /* JADX WARN: Code duplicated, block: B:33:0x01b4  */
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ScalingLazyListLayoutInfo m478invoke() {
                int i3;
                int index;
                int totalItemsCount;
                int i4;
                ScalingLazyListState.Configuration configuration = (ScalingLazyListState.Configuration) this.this$0.getConfig$compose_foundation_release().getValue();
                if (configuration == null) {
                    return EmptyScalingLazyListLayoutInfo.INSTANCE;
                }
                LazyListLayoutInfo layoutInfo = this.this$0.getLazyListState().getLayoutInfo();
                boolean zBooleanValue = ((Boolean) this.this$0.getInitialized$compose_foundation_release().getValue()).booleanValue();
                ArrayList arrayList = new ArrayList();
                boolean z = zBooleanValue || configuration.getLocalInspectionMode();
                int viewportStartOffset = layoutInfo.getViewportStartOffset() + configuration.getExtraPaddingPx();
                Integer numFindItemNearestCenter = this.this$0.findItemNearestCenter(layoutInfo, configuration, viewportStartOffset);
                if (numFindItemNearestCenter != null) {
                    List visibleItemsInfo = layoutInfo.getVisibleItemsInfo();
                    LazyListItemInfo lazyListItemInfo = (LazyListItemInfo) visibleItemsInfo.get(numFindItemNearestCenter.intValue());
                    ScalingLazyListItemInfo scalingLazyListItemInfoM458calculateItemInfotAyFXGY = ScalingLazyColumnMeasureKt.m458calculateItemInfotAyFXGY(lazyListItemInfo.getOffset(), lazyListItemInfo, viewportStartOffset, configuration.getViewportHeightPx(), this.this$0.viewportCenterLinePx(configuration), configuration.getScalingParams(), configuration.getBeforeContentPaddingPx(), configuration.getAnchorType(), configuration.getAutoCentering(), z);
                    arrayList.add(scalingLazyListItemInfoM458calculateItemInfotAyFXGY);
                    index = scalingLazyListItemInfoM458calculateItemInfotAyFXGY.getIndex();
                    int i5 = -scalingLazyListItemInfoM458calculateItemInfotAyFXGY.getOffset();
                    int offset = lazyListItemInfo.getOffset() + MathKt.roundToInt(ScalingLazyColumnMeasureKt.m460startOffsetw3akWxg(scalingLazyListItemInfoM458calculateItemInfotAyFXGY, configuration.getAnchorType()) - ScalingLazyColumnMeasureKt.m461unadjustedStartOffsetw3akWxg(scalingLazyListItemInfoM458calculateItemInfotAyFXGY, configuration.getAnchorType()));
                    int gapBetweenItemsPx = offset - configuration.getGapBetweenItemsPx();
                    Iterable iterableDownTo = RangesKt.downTo(numFindItemNearestCenter.intValue() - 1, 0);
                    ScalingLazyListState scalingLazyListState = this.this$0;
                    IntIterator it = iterableDownTo.iterator();
                    while (it.hasNext()) {
                        int iNextInt = it.nextInt();
                        if (gapBetweenItemsPx >= viewportStartOffset) {
                            LazyListItemInfo lazyListItemInfo2 = (LazyListItemInfo) layoutInfo.getVisibleItemsInfo().get(iNextInt);
                            if (scalingLazyListState.discardAutoCenteringListItem(configuration, layoutInfo, lazyListItemInfo2)) {
                                i4 = i5;
                            } else {
                                i4 = i5;
                                ScalingLazyListItemInfo scalingLazyListItemInfoM458calculateItemInfotAyFXGY2 = ScalingLazyColumnMeasureKt.m458calculateItemInfotAyFXGY(gapBetweenItemsPx - lazyListItemInfo2.getSize(), lazyListItemInfo2, viewportStartOffset, configuration.getViewportHeightPx(), scalingLazyListState.viewportCenterLinePx(configuration), configuration.getScalingParams(), configuration.getBeforeContentPaddingPx(), configuration.getAnchorType(), configuration.getAutoCentering(), z);
                                arrayList.add(0, scalingLazyListItemInfoM458calculateItemInfotAyFXGY2);
                                gapBetweenItemsPx = (gapBetweenItemsPx - scalingLazyListItemInfoM458calculateItemInfotAyFXGY2.getSize()) - configuration.getGapBetweenItemsPx();
                            }
                        } else {
                            i4 = i5;
                        }
                        scalingLazyListState = scalingLazyListState;
                        scalingLazyListItemInfoM458calculateItemInfotAyFXGY = scalingLazyListItemInfoM458calculateItemInfotAyFXGY;
                        i5 = i4;
                    }
                    int i6 = i5;
                    int size = offset + scalingLazyListItemInfoM458calculateItemInfotAyFXGY.getSize() + configuration.getGapBetweenItemsPx();
                    Iterable iterableUntil = RangesKt.until(numFindItemNearestCenter.intValue() + 1, visibleItemsInfo.size());
                    ScalingLazyListState scalingLazyListState2 = this.this$0;
                    IntIterator it2 = iterableUntil.iterator();
                    while (it2.hasNext()) {
                        int iNextInt2 = it2.nextInt();
                        if (size - configuration.getViewportHeightPx() <= viewportStartOffset) {
                            LazyListItemInfo lazyListItemInfo3 = (LazyListItemInfo) layoutInfo.getVisibleItemsInfo().get(iNextInt2);
                            if (!scalingLazyListState2.discardAutoCenteringListItem(configuration, layoutInfo, lazyListItemInfo3)) {
                                int i7 = size;
                                ScalingLazyListItemInfo scalingLazyListItemInfoM458calculateItemInfotAyFXGY3 = ScalingLazyColumnMeasureKt.m458calculateItemInfotAyFXGY(i7, lazyListItemInfo3, viewportStartOffset, configuration.getViewportHeightPx(), scalingLazyListState2.viewportCenterLinePx(configuration), configuration.getScalingParams(), configuration.getBeforeContentPaddingPx(), configuration.getAnchorType(), configuration.getAutoCentering(), z);
                                arrayList.add(scalingLazyListItemInfoM458calculateItemInfotAyFXGY3);
                                size = i7 + scalingLazyListItemInfoM458calculateItemInfotAyFXGY3.getSize() + configuration.getGapBetweenItemsPx();
                            }
                        }
                        scalingLazyListState2 = scalingLazyListState2;
                    }
                    i3 = i6;
                } else {
                    i3 = 0;
                    index = 0;
                }
                if (configuration.getAutoCentering() != null) {
                    totalItemsCount = RangesKt.coerceAtLeast(layoutInfo.getTotalItemsCount() - 2, 0);
                } else {
                    totalItemsCount = layoutInfo.getTotalItemsCount();
                }
                int i8 = totalItemsCount;
                boolean z2 = zBooleanValue ? this.this$0.incompleteScrollItem.getValue() != null : !(configuration.getAutoCentering() != null && (layoutInfo.getVisibleItemsInfo().size() < 2 || !(layoutInfo.getVisibleItemsInfo().size() == 2 || this.this$0.topSpacerIsCorrectlySized(configuration, layoutInfo.getVisibleItemsInfo(), layoutInfo.getTotalItemsCount()))));
                int extraPaddingPx = configuration.getExtraPaddingPx() + layoutInfo.getViewportStartOffset();
                int viewportEndOffset = layoutInfo.getViewportEndOffset() - configuration.getExtraPaddingPx();
                int i9 = zBooleanValue ? index : 0;
                if (!zBooleanValue) {
                    i3 = 0;
                }
                return new DefaultScalingLazyListLayoutInfo(arrayList, extraPaddingPx, viewportEndOffset, i8, i9, i3, configuration.getReverseLayout(), layoutInfo.getOrientation(), IntSizeKt.IntSize(IntSize.getWidth-impl(layoutInfo.getViewportSize-YbymL2g()), IntSize.getHeight-impl(layoutInfo.getViewportSize-YbymL2g()) - (configuration.getExtraPaddingPx() * 2)), configuration.getBeforeContentPaddingPx(), configuration.getAfterContentPaddingPx(), this.this$0.calculateTopAutoCenteringPaddingPx(configuration, arrayList, i8), this.this$0.calculateBottomAutoCenteringPaddingPx(configuration, arrayList, i8), z2, zBooleanValue, configuration.getAnchorType(), null);
            }
        });
    }

    public /* synthetic */ ScalingLazyListState(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 1 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    /* JADX INFO: renamed from: getLazyListState$compose_foundation_release, reason: from getter */
    public final LazyListState getLazyListState() {
        return this.lazyListState;
    }

    public final void setLazyListState$compose_foundation_release(LazyListState lazyListState) {
        this.lazyListState = lazyListState;
    }

    /* JADX INFO: compiled from: ScalingLazyListState.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0000\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0002\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\f\u001a\u00020\rø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0011\u0010\u0010\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, d2 = {"Landroidx/wear/compose/foundation/lazy/ScalingLazyListState$Configuration;", "", "extraPaddingPx", "", "beforeContentPaddingPx", "afterContentPaddingPx", "scalingParams", "Landroidx/wear/compose/foundation/lazy/ScalingParams;", "gapBetweenItemsPx", "viewportHeightPx", "reverseLayout", "", "anchorType", "Landroidx/wear/compose/foundation/lazy/ScalingLazyListAnchorType;", "autoCentering", "Landroidx/wear/compose/foundation/lazy/AutoCenteringParams;", "localInspectionMode", "(IIILandroidx/wear/compose/foundation/lazy/ScalingParams;IIZILandroidx/wear/compose/foundation/lazy/AutoCenteringParams;ZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAfterContentPaddingPx", "()I", "getAnchorType-ZuIr4RU", "I", "getAutoCentering", "()Landroidx/wear/compose/foundation/lazy/AutoCenteringParams;", "getBeforeContentPaddingPx", "getExtraPaddingPx", "getGapBetweenItemsPx", "getLocalInspectionMode", "()Z", "getReverseLayout", "getScalingParams", "()Landroidx/wear/compose/foundation/lazy/ScalingParams;", "getViewportHeightPx", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Configuration {
        public static final int $stable = 0;
        private final int afterContentPaddingPx;
        private final int anchorType;
        private final AutoCenteringParams autoCentering;
        private final int beforeContentPaddingPx;
        private final int extraPaddingPx;
        private final int gapBetweenItemsPx;
        private final boolean localInspectionMode;
        private final boolean reverseLayout;
        private final ScalingParams scalingParams;
        private final int viewportHeightPx;

        public /* synthetic */ Configuration(int i, int i2, int i3, ScalingParams scalingParams, int i4, int i5, boolean z, int i6, AutoCenteringParams autoCenteringParams, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2, i3, scalingParams, i4, i5, z, i6, autoCenteringParams, z2);
        }

        private Configuration(int i, int i2, int i3, ScalingParams scalingParams, int i4, int i5, boolean z, int i6, AutoCenteringParams autoCenteringParams, boolean z2) {
            this.extraPaddingPx = i;
            this.beforeContentPaddingPx = i2;
            this.afterContentPaddingPx = i3;
            this.scalingParams = scalingParams;
            this.gapBetweenItemsPx = i4;
            this.viewportHeightPx = i5;
            this.reverseLayout = z;
            this.anchorType = i6;
            this.autoCentering = autoCenteringParams;
            this.localInspectionMode = z2;
        }

        public final int getExtraPaddingPx() {
            return this.extraPaddingPx;
        }

        public final int getBeforeContentPaddingPx() {
            return this.beforeContentPaddingPx;
        }

        public final int getAfterContentPaddingPx() {
            return this.afterContentPaddingPx;
        }

        public final ScalingParams getScalingParams() {
            return this.scalingParams;
        }

        public final int getGapBetweenItemsPx() {
            return this.gapBetweenItemsPx;
        }

        public final int getViewportHeightPx() {
            return this.viewportHeightPx;
        }

        public final boolean getReverseLayout() {
            return this.reverseLayout;
        }

        /* JADX INFO: renamed from: getAnchorType-ZuIr4RU, reason: not valid java name and from getter */
        public final int getAnchorType() {
            return this.anchorType;
        }

        public final AutoCenteringParams getAutoCentering() {
            return this.autoCentering;
        }

        public final boolean getLocalInspectionMode() {
            return this.localInspectionMode;
        }
    }

    public final MutableState<Boolean> getInitialized$compose_foundation_release() {
        return this.initialized;
    }

    public final MutableState<Configuration> getConfig$compose_foundation_release() {
        return this.config;
    }

    public final int getCenterItemIndex() {
        return ((Number) this.centerItemIndex.getValue()).intValue();
    }

    public final int getTopAutoCenteringItemSizePx$compose_foundation_release() {
        return ((Number) this.topAutoCenteringItemSizePx.getValue()).intValue();
    }

    public final int getBottomAutoCenteringItemSizePx$compose_foundation_release() {
        return ((Number) this.bottomAutoCenteringItemSizePx.getValue()).intValue();
    }

    public final int getCenterItemScrollOffset() {
        ScalingLazyListLayoutInfo layoutInfo = getLayoutInfo();
        DefaultScalingLazyListLayoutInfo defaultScalingLazyListLayoutInfo = layoutInfo instanceof DefaultScalingLazyListLayoutInfo ? (DefaultScalingLazyListLayoutInfo) layoutInfo : null;
        if (defaultScalingLazyListLayoutInfo != null) {
            Integer numValueOf = defaultScalingLazyListLayoutInfo.getInitialized() ? Integer.valueOf(defaultScalingLazyListLayoutInfo.getCenterItemScrollOffset()) : null;
            if (numValueOf != null) {
                return numValueOf.intValue();
            }
        }
        return this.initialCenterItemScrollOffset;
    }

    public final ScalingLazyListLayoutInfo getLayoutInfo() {
        return (ScalingLazyListLayoutInfo) this.layoutInfo.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Integer findItemNearestCenter(LazyListLayoutInfo lazyListLayoutInfo, Configuration params, int verticalAdjustment) {
        int size = lazyListLayoutInfo.getVisibleItemsInfo().size();
        Integer num = null;
        for (int i = 0; i < size; i++) {
            LazyListItemInfo lazyListItemInfo = (LazyListItemInfo) lazyListLayoutInfo.getVisibleItemsInfo().get(i);
            if (!discardAutoCenteringListItem(params, lazyListLayoutInfo, lazyListItemInfo)) {
                float offset = (lazyListItemInfo.getOffset() - verticalAdjustment) + lazyListItemInfo.getSize() + (params.getGapBetweenItemsPx() / 2.0f);
                Integer numValueOf = Integer.valueOf(i);
                if (offset > viewportCenterLinePx(params)) {
                    return numValueOf;
                }
                num = numValueOf;
            }
        }
        return num;
    }

    /* JADX INFO: compiled from: ScalingLazyListState.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/wear/compose/foundation/lazy/ScalingLazyListState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/wear/compose/foundation/lazy/ScalingLazyListState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<ScalingLazyListState, Object> getSaver() {
            return ScalingLazyListState.Saver;
        }
    }

    public boolean isScrollInProgress() {
        return this.lazyListState.isScrollInProgress();
    }

    public float dispatchRawDelta(float delta) {
        return this.lazyListState.dispatchRawDelta(delta);
    }

    public Object scroll(MutatePriority mutatePriority, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object objScroll = this.lazyListState.scroll(mutatePriority, function2, continuation);
        return objScroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScroll : Unit.INSTANCE;
    }

    public boolean getCanScrollForward() {
        return this.lazyListState.getCanScrollForward();
    }

    public boolean getCanScrollBackward() {
        return this.lazyListState.getCanScrollBackward();
    }

    public static /* synthetic */ Object scrollToItem$default(ScalingLazyListState scalingLazyListState, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return scalingLazyListState.scrollToItem(i, i2, continuation);
    }

    public final Object scrollToItem(int i, int i2, Continuation<? super Unit> continuation) {
        Object objScrollToItem$compose_foundation_release = scrollToItem$compose_foundation_release(false, i, i2, continuation);
        return objScrollToItem$compose_foundation_release == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScrollToItem$compose_foundation_release : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b1, code lost:
    
        if (androidx.wear.compose.foundation.lazy.ScalingLazyListStateKt.scrollToItem(r10, r11, r7, r8 + r13, r0) == r1) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0111, code lost:
    
        if (androidx.wear.compose.foundation.lazy.ScalingLazyListStateKt.scrollToItem(r10, r11, r7, r8, r0) == r1) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object scrollToItem$compose_foundation_release(boolean r11, int r12, int r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            Method dump skipped, instruction units count: 309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.wear.compose.foundation.lazy.ScalingLazyListState.scrollToItem$compose_foundation_release(boolean, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a7, code lost:
    
        if (r7.scrollToItem$compose_foundation_release(r8, r2, r4, r0) == r1) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object scrollToInitialItem$compose_foundation_release(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof androidx.wear.compose.foundation.lazy.ScalingLazyListState$scrollToInitialItem$1
            if (r0 == 0) goto L14
            r0 = r8
            androidx.wear.compose.foundation.lazy.ScalingLazyListState$scrollToInitialItem$1 r0 = (androidx.wear.compose.foundation.lazy.ScalingLazyListState$scrollToInitialItem$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            androidx.wear.compose.foundation.lazy.ScalingLazyListState$scrollToInitialItem$1 r0 = new androidx.wear.compose.foundation.lazy.ScalingLazyListState$scrollToInitialItem$1
            r0.<init>(r7, r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            kotlin.ResultKt.throwOnFailure(r8)
            goto Laa
        L2e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L36:
            java.lang.Object r7 = r0.L$0
            androidx.wear.compose.foundation.lazy.ScalingLazyListState r7 = (androidx.wear.compose.foundation.lazy.ScalingLazyListState) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L67
        L3e:
            kotlin.ResultKt.throwOnFailure(r8)
            androidx.compose.runtime.MutableState<java.lang.Boolean> r8 = r7.initialized
            java.lang.Object r8 = r8.getValue()
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L67
            androidx.compose.runtime.MutableState<java.lang.Boolean> r8 = r7.initialized
            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            r8.setValue(r2)
            int r8 = r7.initialCenterItemIndex
            int r2 = r7.initialCenterItemScrollOffset
            r0.L$0 = r7
            r0.label = r4
            java.lang.Object r8 = r7.scrollToItem(r8, r2, r0)
            if (r8 != r1) goto L67
            goto La9
        L67:
            androidx.compose.runtime.MutableState<java.lang.Integer> r8 = r7.incompleteScrollItem
            java.lang.Object r8 = r8.getValue()
            if (r8 == 0) goto Lad
            androidx.compose.runtime.MutableState<java.lang.Boolean> r8 = r7.incompleteScrollAnimated
            java.lang.Object r8 = r8.getValue()
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            androidx.compose.runtime.MutableState<java.lang.Integer> r2 = r7.incompleteScrollItem
            java.lang.Object r2 = r2.getValue()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            androidx.compose.runtime.MutableState<java.lang.Integer> r4 = r7.incompleteScrollOffset
            java.lang.Object r4 = r4.getValue()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            androidx.compose.runtime.MutableState<java.lang.Integer> r5 = r7.incompleteScrollItem
            r6 = 0
            r5.setValue(r6)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r7 = r7.scrollToItem$compose_foundation_release(r8, r2, r4, r0)
            if (r7 != r1) goto Laa
        La9:
            return r1
        Laa:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        Lad:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.wear.compose.foundation.lazy.ScalingLazyListState.scrollToInitialItem$compose_foundation_release(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object animateScrollToItem$default(ScalingLazyListState scalingLazyListState, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return scalingLazyListState.animateScrollToItem(i, i2, continuation);
    }

    public final Object animateScrollToItem(int i, int i2, Continuation<? super Unit> continuation) {
        Object objScrollToItem$compose_foundation_release = scrollToItem$compose_foundation_release(true, i, i2, continuation);
        return objScrollToItem$compose_foundation_release == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScrollToItem$compose_foundation_release : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean discardAutoCenteringListItem(Configuration params, LazyListLayoutInfo lazyListLayoutInfo, LazyListItemInfo item) {
        if (params.getAutoCentering() != null) {
            return item.getIndex() == 0 || item.getIndex() == lazyListLayoutInfo.getTotalItemsCount() - 1;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int calculateTopAutoCenteringPaddingPx(Configuration params, List<? extends ScalingLazyListItemInfo> visibleItems, int totalItemCount) {
        ScalingLazyListItemInfo scalingLazyListItemInfo;
        if (params.getAutoCentering() == null || !(visibleItems.isEmpty() || ((ScalingLazyListItemInfo) CollectionsKt.first(visibleItems)).getIndex() == 0)) {
            return 0;
        }
        int iCoerceAtMost = RangesKt.coerceAtMost(params.getAutoCentering().getItemIndex(), totalItemCount - 1);
        int size = visibleItems.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                scalingLazyListItemInfo = null;
                break;
            }
            scalingLazyListItemInfo = visibleItems.get(i);
            if (scalingLazyListItemInfo.getIndex() == iCoerceAtMost) {
                break;
            }
            i++;
        }
        int iSpaceNeeded = spaceNeeded(params, scalingLazyListItemInfo);
        if (iSpaceNeeded > 0.0f) {
            ArrayList arrayList = new ArrayList(visibleItems.size());
            int size2 = visibleItems.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ArrayList arrayList2 = arrayList;
                ScalingLazyListItemInfo scalingLazyListItemInfo2 = visibleItems.get(i2);
                if (scalingLazyListItemInfo2.getIndex() < iCoerceAtMost) {
                    iSpaceNeeded = (iSpaceNeeded - params.getGapBetweenItemsPx()) - scalingLazyListItemInfo2.getUnadjustedSize();
                }
                arrayList2.add(Unit.INSTANCE);
            }
        }
        return RangesKt.coerceAtLeast(iSpaceNeeded + params.getGapBetweenItemsPx(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean topSpacerIsCorrectlySized(Configuration params, List<? extends LazyListItemInfo> visibleItems, int totalItemCount) {
        LazyListItemInfo lazyListItemInfo;
        if (((LazyListItemInfo) CollectionsKt.first(visibleItems)).getSize() > 0) {
            return true;
        }
        AutoCenteringParams autoCentering = params.getAutoCentering();
        Intrinsics.checkNotNull(autoCentering);
        int iCoerceAtMost = RangesKt.coerceAtMost(autoCentering.getItemIndex() + 1, totalItemCount - 2);
        int size = visibleItems.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                lazyListItemInfo = null;
                break;
            }
            lazyListItemInfo = visibleItems.get(i);
            if (lazyListItemInfo.getIndex() == iCoerceAtMost) {
                break;
            }
            i++;
        }
        int iSpaceNeeded = spaceNeeded(params, lazyListItemInfo);
        if (iSpaceNeeded > 0.0f) {
            ArrayList arrayList = new ArrayList(visibleItems.size());
            int size2 = visibleItems.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ArrayList arrayList2 = arrayList;
                LazyListItemInfo lazyListItemInfo2 = visibleItems.get(i2);
                if (lazyListItemInfo2.getIndex() != 0 && lazyListItemInfo2.getIndex() < iCoerceAtMost) {
                    iSpaceNeeded = (iSpaceNeeded - params.getGapBetweenItemsPx()) - lazyListItemInfo2.getSize();
                }
                arrayList2.add(Unit.INSTANCE);
            }
        }
        return iSpaceNeeded < params.getGapBetweenItemsPx();
    }

    private final int spaceNeeded(Configuration configuration, ScalingLazyListItemInfo scalingLazyListItemInfo) {
        int iViewportCenterLinePx = viewportCenterLinePx(configuration) - configuration.getGapBetweenItemsPx();
        AutoCenteringParams autoCentering = configuration.getAutoCentering();
        Intrinsics.checkNotNull(autoCentering);
        return (iViewportCenterLinePx - autoCentering.getItemOffset()) - (scalingLazyListItemInfo != null ? unadjustedItemSizeAboveOffsetPoint(scalingLazyListItemInfo, configuration) : 0);
    }

    private final int spaceNeeded(Configuration configuration, LazyListItemInfo lazyListItemInfo) {
        int iViewportCenterLinePx = viewportCenterLinePx(configuration) - configuration.getGapBetweenItemsPx();
        AutoCenteringParams autoCentering = configuration.getAutoCentering();
        Intrinsics.checkNotNull(autoCentering);
        return (iViewportCenterLinePx - autoCentering.getItemOffset()) - (lazyListItemInfo != null ? itemSizeAboveOffsetPoint(lazyListItemInfo, configuration) : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int calculateBottomAutoCenteringPaddingPx(Configuration params, List<? extends ScalingLazyListItemInfo> visibleItemsInfo, int totalItemsCount) {
        if (params.getAutoCentering() == null || visibleItemsInfo.isEmpty() || ((ScalingLazyListItemInfo) CollectionsKt.last(visibleItemsInfo)).getIndex() != totalItemsCount - 1) {
            return 0;
        }
        return (params.getViewportHeightPx() - viewportCenterLinePx(params)) - unadjustedItemSizeBelowOffsetPoint((ScalingLazyListItemInfo) CollectionsKt.last(visibleItemsInfo), params);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int viewportCenterLinePx(Configuration configuration) {
        return configuration.getViewportHeightPx() / 2;
    }

    private final int unadjustedItemSizeAboveOffsetPoint(ScalingLazyListItemInfo scalingLazyListItemInfo, Configuration configuration) {
        if (ScalingLazyListAnchorType.m465equalsimpl0(configuration.getAnchorType(), ScalingLazyListAnchorType.INSTANCE.m470getItemStartZuIr4RU())) {
            return 0;
        }
        return scalingLazyListItemInfo.getUnadjustedSize() / 2;
    }

    private final int itemSizeAboveOffsetPoint(LazyListItemInfo lazyListItemInfo, Configuration configuration) {
        if (ScalingLazyListAnchorType.m465equalsimpl0(configuration.getAnchorType(), ScalingLazyListAnchorType.INSTANCE.m470getItemStartZuIr4RU())) {
            return 0;
        }
        return lazyListItemInfo.getSize() / 2;
    }

    private final int unadjustedItemSizeBelowOffsetPoint(ScalingLazyListItemInfo scalingLazyListItemInfo, Configuration configuration) {
        return scalingLazyListItemInfo.getUnadjustedSize() - unadjustedItemSizeAboveOffsetPoint(scalingLazyListItemInfo, configuration);
    }
}
