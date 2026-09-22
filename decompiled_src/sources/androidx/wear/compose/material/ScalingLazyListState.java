package androidx.wear.compose.material;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.lazy.LazyListItemInfo;
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
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
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
@Deprecated(message = "Was moved to androidx.wear.compose.foundation.lazy package. Please use it instead")
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u0000 q2\u00020\u0001:\u0001qB\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J \u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u00032\b\b\u0002\u0010G\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010HJ\u001e\u0010I\u001a\u00020\u00032\f\u0010J\u001a\b\u0012\u0004\u0012\u00020L0K2\u0006\u0010M\u001a\u00020\u0003H\u0002J\u001e\u0010N\u001a\u00020\u00032\f\u0010O\u001a\b\u0012\u0004\u0012\u00020L0K2\u0006\u0010P\u001a\u00020\u0003H\u0002J\u0010\u0010Q\u001a\u00020\u001a2\u0006\u0010R\u001a\u00020SH\u0002J\u0010\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020UH\u0016J\u0017\u0010W\u001a\u0004\u0018\u00010\u00032\u0006\u0010X\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010YJ?\u0010Z\u001a\u00020E2\u0006\u0010[\u001a\u00020\\2'\u0010]\u001a#\b\u0001\u0012\u0004\u0012\u00020_\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0`\u0012\u0006\u0012\u0004\u0018\u00010a0^¢\u0006\u0002\bbH\u0096@¢\u0006\u0002\u0010cJ\u0010\u0010d\u001a\u00020EH\u0080@¢\u0006\u0004\be\u0010fJ(\u0010g\u001a\u00020E2\u0006\u0010h\u001a\u00020\u001a2\u0006\u0010F\u001a\u00020\u00032\u0006\u0010G\u001a\u00020\u0003H\u0080@¢\u0006\u0004\bi\u0010jJ \u0010g\u001a\u00020E2\u0006\u0010F\u001a\u00020\u00032\b\b\u0002\u0010G\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010HJ\u0012\u0010k\u001a\u00020\u00032\b\u0010R\u001a\u0004\u0018\u00010SH\u0002J\u0012\u0010k\u001a\u00020\u00032\b\u0010R\u001a\u0004\u0018\u00010LH\u0002J\u001e\u0010l\u001a\u00020\u001a2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020S0K2\u0006\u0010P\u001a\u00020\u0003H\u0002J\b\u0010m\u001a\u00020\u0003H\u0002J\f\u0010n\u001a\u00020\u0003*\u00020SH\u0002J\f\u0010o\u001a\u00020\u0003*\u00020LH\u0002J\f\u0010p\u001a\u00020\u0003*\u00020LH\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u001c\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u001c\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u001b\u0010\u0014\u001a\u00020\u00038@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0011\u0010\u001f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b \u0010\u0016R\u0011\u0010!\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0016R\u001c\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u000bR\u001c\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u000bR\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001a0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001a0\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u000bR\u0014\u0010,\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u001cR\u001b\u0010-\u001a\u00020.8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u0018\u001a\u0004\b/\u00100R\u001a\u00102\u001a\u000203X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020\u001a0\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u000bR\u001c\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u000bR\u001c\u0010<\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010=0\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u000bR\u001b\u0010?\u001a\u00020\u00038@X\u0080\u0084\u0002¢\u0006\f\n\u0004\bA\u0010\u0018\u001a\u0004\b@\u0010\u0016R\u001c\u0010B\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u000b¨\u0006r"}, d2 = {"Landroidx/wear/compose/material/ScalingLazyListState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "initialCenterItemIndex", "", "initialCenterItemScrollOffset", "(II)V", "_centerItemIndex", "Landroidx/compose/runtime/State;", "afterContentPaddingPx", "Landroidx/compose/runtime/MutableState;", "getAfterContentPaddingPx$compose_material_release", "()Landroidx/compose/runtime/MutableState;", "anchorType", "Landroidx/wear/compose/material/ScalingLazyListAnchorType;", "getAnchorType$compose_material_release", "autoCentering", "Landroidx/wear/compose/material/AutoCenteringParams;", "getAutoCentering$compose_material_release", "beforeContentPaddingPx", "getBeforeContentPaddingPx$compose_material_release", "bottomAutoCenteringItemSizePx", "getBottomAutoCenteringItemSizePx$compose_material_release", "()I", "bottomAutoCenteringItemSizePx$delegate", "Landroidx/compose/runtime/State;", "canScrollBackward", "", "getCanScrollBackward", "()Z", "canScrollForward", "getCanScrollForward", "centerItemIndex", "getCenterItemIndex", "centerItemScrollOffset", "getCenterItemScrollOffset", "extraPaddingPx", "getExtraPaddingPx$compose_material_release", "gapBetweenItemsPx", "getGapBetweenItemsPx$compose_material_release", "incompleteScrollAnimated", "incompleteScrollItem", "incompleteScrollOffset", "initialized", "getInitialized$compose_material_release", "isScrollInProgress", "layoutInfo", "Landroidx/wear/compose/material/ScalingLazyListLayoutInfo;", "getLayoutInfo", "()Landroidx/wear/compose/material/ScalingLazyListLayoutInfo;", "layoutInfo$delegate", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "getLazyListState$compose_material_release", "()Landroidx/compose/foundation/lazy/LazyListState;", "setLazyListState$compose_material_release", "(Landroidx/compose/foundation/lazy/LazyListState;)V", "localInspectionMode", "getLocalInspectionMode$compose_material_release", "reverseLayout", "getReverseLayout$compose_material_release", "scalingParams", "Landroidx/wear/compose/material/ScalingParams;", "getScalingParams$compose_material_release", "topAutoCenteringItemSizePx", "getTopAutoCenteringItemSizePx$compose_material_release", "topAutoCenteringItemSizePx$delegate", "viewportHeightPx", "getViewportHeightPx$compose_material_release", "animateScrollToItem", "", "index", "scrollOffset", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateBottomAutoCenteringPaddingPx", "visibleItemsInfo", "", "Landroidx/wear/compose/material/ScalingLazyListItemInfo;", "totalItemsCount", "calculateTopAutoCenteringPaddingPx", "visibleItems", "totalItemCount", "discardAutoCenteringListItem", "item", "Landroidx/compose/foundation/lazy/LazyListItemInfo;", "dispatchRawDelta", "", "delta", "findItemNearestCenter", "verticalAdjustment", "(I)Ljava/lang/Integer;", "scroll", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollToInitialItem", "scrollToInitialItem$compose_material_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollToItem", "animated", "scrollToItem$compose_material_release", "(ZIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "spaceNeeded", "topSpacerIsCorrectlySized", "viewportCenterLinePx", "itemSizeAboveOffsetPoint", "unadjustedItemSizeAboveOffsetPoint", "unadjustedItemSizeBelowOffsetPoint", "Companion", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ScalingLazyListState implements ScrollableState {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Saver<ScalingLazyListState, Object> Saver = ListSaverKt.listSaver(new Function2<SaverScope, ScalingLazyListState, List<? extends Integer>>() { // from class: androidx.wear.compose.material.ScalingLazyListState$Companion$Saver$1
        public final List<Integer> invoke(SaverScope saverScope, ScalingLazyListState scalingLazyListState) {
            return CollectionsKt.listOf(new Integer[]{Integer.valueOf(scalingLazyListState.getCenterItemIndex()), Integer.valueOf(scalingLazyListState.getCenterItemScrollOffset())});
        }
    }, new Function1<List<? extends Integer>, ScalingLazyListState>() { // from class: androidx.wear.compose.material.ScalingLazyListState$Companion$Saver$2
        public final ScalingLazyListState invoke(List<Integer> list) {
            return new ScalingLazyListState(list.get(0).intValue(), list.get(1).intValue());
        }
    });
    private final State<Integer> _centerItemIndex;
    private final MutableState<Integer> afterContentPaddingPx;
    private final MutableState<ScalingLazyListAnchorType> anchorType;
    private final MutableState<AutoCenteringParams> autoCentering;
    private final MutableState<Integer> beforeContentPaddingPx;

    /* JADX INFO: renamed from: bottomAutoCenteringItemSizePx$delegate, reason: from kotlin metadata */
    private final State bottomAutoCenteringItemSizePx;
    private final MutableState<Integer> extraPaddingPx;
    private final MutableState<Integer> gapBetweenItemsPx;
    private final MutableState<Boolean> incompleteScrollAnimated;
    private final MutableState<Integer> incompleteScrollItem;
    private final MutableState<Integer> incompleteScrollOffset;
    private int initialCenterItemIndex;
    private int initialCenterItemScrollOffset;
    private final MutableState<Boolean> initialized;

    /* JADX INFO: renamed from: layoutInfo$delegate, reason: from kotlin metadata */
    private final State layoutInfo;
    private LazyListState lazyListState;
    private final MutableState<Boolean> localInspectionMode;
    private final MutableState<Boolean> reverseLayout;
    private final MutableState<ScalingParams> scalingParams;

    /* JADX INFO: renamed from: topAutoCenteringItemSizePx$delegate, reason: from kotlin metadata */
    private final State topAutoCenteringItemSizePx;
    private final MutableState<Integer> viewportHeightPx;

    /* JADX INFO: renamed from: androidx.wear.compose.material.ScalingLazyListState$scrollToItem$2, reason: invalid class name */
    /* JADX INFO: compiled from: ScalingLazyListState.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.wear.compose.material.ScalingLazyListState", f = "ScalingLazyListState.kt", i = {1, 1, 1, 1, 1, 1, 1}, l = {474, 483, 491}, m = "scrollToItem$compose_material_release", n = {"this", "animated", "index", "scrollOffset", "targetIndex", "lazyListStateIndex", "offsetToCenterOfViewport"}, s = {"L$0", "Z$0", "I$0", "I$1", "I$2", "I$3", "I$4"})
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
            return ScalingLazyListState.this.scrollToItem$compose_material_release(false, 0, 0, (Continuation) this);
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
        this.extraPaddingPx = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.beforeContentPaddingPx = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.afterContentPaddingPx = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.scalingParams = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.gapBetweenItemsPx = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.viewportHeightPx = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.reverseLayout = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.anchorType = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.autoCentering = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.initialized = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.localInspectionMode = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.incompleteScrollItem = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.incompleteScrollOffset = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.incompleteScrollAnimated = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        this._centerItemIndex = SnapshotStateKt.derivedStateOf(new Function0<Integer>() { // from class: androidx.wear.compose.material.ScalingLazyListState$_centerItemIndex$1
            {
                super(0);
            }

            /* JADX WARN: Code duplicated, block: B:12:0x0026  */
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m772invoke() {
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
        this.topAutoCenteringItemSizePx = SnapshotStateKt.derivedStateOf(new Function0<Integer>() { // from class: androidx.wear.compose.material.ScalingLazyListState$topAutoCenteringItemSizePx$2
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m775invoke() {
                int iCoerceAtLeast = 0;
                if (this.this$0.getExtraPaddingPx$compose_material_release().getValue() != null && this.this$0.getScalingParams$compose_material_release().getValue() != null && this.this$0.getGapBetweenItemsPx$compose_material_release().getValue() != null && this.this$0.getViewportHeightPx$compose_material_release().getValue() != null && this.this$0.getAnchorType$compose_material_release().getValue() != null && this.this$0.getReverseLayout$compose_material_release().getValue() != null && this.this$0.getBeforeContentPaddingPx$compose_material_release().getValue() != null && this.this$0.getAutoCentering$compose_material_release().getValue() != null && this.this$0.getAutoCentering$compose_material_release().getValue() != null) {
                    int beforeAutoCenteringPadding = this.this$0.getLayoutInfo().getBeforeAutoCenteringPadding();
                    Object value = this.this$0.getGapBetweenItemsPx$compose_material_release().getValue();
                    Intrinsics.checkNotNull(value);
                    iCoerceAtLeast = RangesKt.coerceAtLeast(beforeAutoCenteringPadding - ((Number) value).intValue(), 0);
                }
                return Integer.valueOf(iCoerceAtLeast);
            }
        });
        this.bottomAutoCenteringItemSizePx = SnapshotStateKt.derivedStateOf(new Function0<Integer>() { // from class: androidx.wear.compose.material.ScalingLazyListState$bottomAutoCenteringItemSizePx$2
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m773invoke() {
                int iCoerceAtLeast = 0;
                if (this.this$0.getExtraPaddingPx$compose_material_release().getValue() != null && this.this$0.getScalingParams$compose_material_release().getValue() != null && this.this$0.getGapBetweenItemsPx$compose_material_release().getValue() != null && this.this$0.getViewportHeightPx$compose_material_release().getValue() != null && this.this$0.getAnchorType$compose_material_release().getValue() != null && this.this$0.getReverseLayout$compose_material_release().getValue() != null && this.this$0.getBeforeContentPaddingPx$compose_material_release().getValue() != null && this.this$0.getAutoCentering$compose_material_release().getValue() != null && !ScalingLazyListStateKt.internalVisibleItemInfo(this.this$0.getLayoutInfo()).isEmpty()) {
                    int afterAutoCenteringPadding = this.this$0.getLayoutInfo().getAfterAutoCenteringPadding();
                    Object value = this.this$0.getGapBetweenItemsPx$compose_material_release().getValue();
                    Intrinsics.checkNotNull(value);
                    iCoerceAtLeast = RangesKt.coerceAtLeast(afterAutoCenteringPadding - ((Number) value).intValue(), 0);
                }
                return Integer.valueOf(iCoerceAtLeast);
            }
        });
        this.layoutInfo = SnapshotStateKt.derivedStateOf(new Function0<ScalingLazyListLayoutInfo>() { // from class: androidx.wear.compose.material.ScalingLazyListState$layoutInfo$2
            {
                super(0);
            }

            /* JADX WARN: Code duplicated, block: B:34:0x023f  */
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ScalingLazyListLayoutInfo m774invoke() {
                int i3;
                int index;
                int totalItemsCount;
                boolean z;
                int i4;
                ScalingLazyListState scalingLazyListState;
                if (this.this$0.getExtraPaddingPx$compose_material_release().getValue() == null || this.this$0.getScalingParams$compose_material_release().getValue() == null || this.this$0.getGapBetweenItemsPx$compose_material_release().getValue() == null || this.this$0.getViewportHeightPx$compose_material_release().getValue() == null || this.this$0.getAnchorType$compose_material_release().getValue() == null || this.this$0.getReverseLayout$compose_material_release().getValue() == null || this.this$0.getBeforeContentPaddingPx$compose_material_release().getValue() == null) {
                    return EmptyScalingLazyListLayoutInfo.INSTANCE;
                }
                ArrayList arrayList = new ArrayList();
                Object value = this.this$0.getViewportHeightPx$compose_material_release().getValue();
                Intrinsics.checkNotNull(value);
                int iIntValue = ((Number) value).intValue();
                boolean z2 = ((Boolean) this.this$0.getInitialized$compose_material_release().getValue()).booleanValue() || ((Boolean) this.this$0.getLocalInspectionMode$compose_material_release().getValue()).booleanValue();
                int viewportStartOffset = this.this$0.getLazyListState().getLayoutInfo().getViewportStartOffset();
                Object value2 = this.this$0.getExtraPaddingPx$compose_material_release().getValue();
                Intrinsics.checkNotNull(value2);
                int iIntValue2 = viewportStartOffset + ((Number) value2).intValue();
                Integer numFindItemNearestCenter = this.this$0.findItemNearestCenter(iIntValue2);
                if (numFindItemNearestCenter != null) {
                    List visibleItemsInfo = this.this$0.getLazyListState().getLayoutInfo().getVisibleItemsInfo();
                    LazyListItemInfo lazyListItemInfo = (LazyListItemInfo) visibleItemsInfo.get(numFindItemNearestCenter.intValue());
                    int offset = lazyListItemInfo.getOffset();
                    int iViewportCenterLinePx = this.this$0.viewportCenterLinePx();
                    Object value3 = this.this$0.getScalingParams$compose_material_release().getValue();
                    Intrinsics.checkNotNull(value3);
                    Object value4 = this.this$0.getBeforeContentPaddingPx$compose_material_release().getValue();
                    Intrinsics.checkNotNull(value4);
                    int iIntValue3 = ((Number) value4).intValue();
                    Object value5 = this.this$0.getAnchorType$compose_material_release().getValue();
                    Intrinsics.checkNotNull(value5);
                    ScalingLazyListItemInfo scalingLazyListItemInfoM755calculateItemInfoCuKLY0U = ScalingLazyColumnMeasureKt.m755calculateItemInfoCuKLY0U(offset, lazyListItemInfo, iIntValue2, iIntValue, iViewportCenterLinePx, (ScalingParams) value3, iIntValue3, ((ScalingLazyListAnchorType) value5).getType(), (AutoCenteringParams) this.this$0.getAutoCentering$compose_material_release().getValue(), z2);
                    arrayList.add(scalingLazyListItemInfoM755calculateItemInfoCuKLY0U);
                    index = scalingLazyListItemInfoM755calculateItemInfoCuKLY0U.getIndex();
                    int i5 = -scalingLazyListItemInfoM755calculateItemInfoCuKLY0U.getOffset();
                    int offset2 = lazyListItemInfo.getOffset();
                    Object value6 = this.this$0.getAnchorType$compose_material_release().getValue();
                    Intrinsics.checkNotNull(value6);
                    float fM757startOffsetnK7FVxM = ScalingLazyColumnMeasureKt.m757startOffsetnK7FVxM(scalingLazyListItemInfoM755calculateItemInfoCuKLY0U, ((ScalingLazyListAnchorType) value6).getType());
                    Object value7 = this.this$0.getAnchorType$compose_material_release().getValue();
                    Intrinsics.checkNotNull(value7);
                    int iRoundToInt = offset2 + MathKt.roundToInt(fM757startOffsetnK7FVxM - ScalingLazyColumnMeasureKt.m758unadjustedStartOffsetnK7FVxM(scalingLazyListItemInfoM755calculateItemInfoCuKLY0U, ((ScalingLazyListAnchorType) value7).getType()));
                    Object value8 = this.this$0.getGapBetweenItemsPx$compose_material_release().getValue();
                    Intrinsics.checkNotNull(value8);
                    int iIntValue4 = iRoundToInt - ((Number) value8).intValue();
                    Iterable iterableDownTo = RangesKt.downTo(numFindItemNearestCenter.intValue() - 1, 0);
                    ScalingLazyListState scalingLazyListState2 = this.this$0;
                    IntIterator it = iterableDownTo.iterator();
                    while (it.hasNext()) {
                        int iNextInt = it.nextInt();
                        if (iIntValue4 >= iIntValue2) {
                            LazyListItemInfo lazyListItemInfo2 = (LazyListItemInfo) scalingLazyListState2.getLazyListState().getLayoutInfo().getVisibleItemsInfo().get(iNextInt);
                            if (scalingLazyListState2.discardAutoCenteringListItem(lazyListItemInfo2)) {
                                i4 = i5;
                                scalingLazyListState = scalingLazyListState2;
                            } else {
                                int size = iIntValue4 - lazyListItemInfo2.getSize();
                                int i6 = i5;
                                int iViewportCenterLinePx2 = scalingLazyListState2.viewportCenterLinePx();
                                Object value9 = scalingLazyListState2.getScalingParams$compose_material_release().getValue();
                                Intrinsics.checkNotNull(value9);
                                Object value10 = scalingLazyListState2.getBeforeContentPaddingPx$compose_material_release().getValue();
                                Intrinsics.checkNotNull(value10);
                                int iIntValue5 = ((Number) value10).intValue();
                                Object value11 = scalingLazyListState2.getAnchorType$compose_material_release().getValue();
                                Intrinsics.checkNotNull(value11);
                                scalingLazyListState = scalingLazyListState2;
                                i4 = i6;
                                ScalingLazyListItemInfo scalingLazyListItemInfoM755calculateItemInfoCuKLY0U2 = ScalingLazyColumnMeasureKt.m755calculateItemInfoCuKLY0U(size, lazyListItemInfo2, iIntValue2, iIntValue, iViewportCenterLinePx2, (ScalingParams) value9, iIntValue5, ((ScalingLazyListAnchorType) value11).getType(), (AutoCenteringParams) scalingLazyListState2.getAutoCentering$compose_material_release().getValue(), z2);
                                arrayList.add(0, scalingLazyListItemInfoM755calculateItemInfoCuKLY0U2);
                                int size2 = iIntValue4 - scalingLazyListItemInfoM755calculateItemInfoCuKLY0U2.getSize();
                                Object value12 = scalingLazyListState.getGapBetweenItemsPx$compose_material_release().getValue();
                                Intrinsics.checkNotNull(value12);
                                iIntValue4 = size2 - ((Number) value12).intValue();
                            }
                        } else {
                            i4 = i5;
                            scalingLazyListState = scalingLazyListState2;
                        }
                        i5 = i4;
                        scalingLazyListItemInfoM755calculateItemInfoCuKLY0U = scalingLazyListItemInfoM755calculateItemInfoCuKLY0U;
                        scalingLazyListState2 = scalingLazyListState;
                    }
                    int i7 = i5;
                    int size3 = iRoundToInt + scalingLazyListItemInfoM755calculateItemInfoCuKLY0U.getSize();
                    Object value13 = this.this$0.getGapBetweenItemsPx$compose_material_release().getValue();
                    Intrinsics.checkNotNull(value13);
                    int iIntValue6 = size3 + ((Number) value13).intValue();
                    Iterable iterableUntil = RangesKt.until(numFindItemNearestCenter.intValue() + 1, visibleItemsInfo.size());
                    ScalingLazyListState scalingLazyListState3 = this.this$0;
                    IntIterator it2 = iterableUntil.iterator();
                    int iIntValue7 = iIntValue6;
                    while (it2.hasNext()) {
                        int iNextInt2 = it2.nextInt();
                        if (iIntValue7 - iIntValue <= iIntValue2) {
                            LazyListItemInfo lazyListItemInfo3 = (LazyListItemInfo) scalingLazyListState3.getLazyListState().getLayoutInfo().getVisibleItemsInfo().get(iNextInt2);
                            if (!scalingLazyListState3.discardAutoCenteringListItem(lazyListItemInfo3)) {
                                int iViewportCenterLinePx3 = scalingLazyListState3.viewportCenterLinePx();
                                Object value14 = scalingLazyListState3.getScalingParams$compose_material_release().getValue();
                                Intrinsics.checkNotNull(value14);
                                Object value15 = scalingLazyListState3.getBeforeContentPaddingPx$compose_material_release().getValue();
                                Intrinsics.checkNotNull(value15);
                                int iIntValue8 = ((Number) value15).intValue();
                                Object value16 = scalingLazyListState3.getAnchorType$compose_material_release().getValue();
                                Intrinsics.checkNotNull(value16);
                                ScalingLazyListItemInfo scalingLazyListItemInfoM755calculateItemInfoCuKLY0U3 = ScalingLazyColumnMeasureKt.m755calculateItemInfoCuKLY0U(iIntValue7, lazyListItemInfo3, iIntValue2, iIntValue, iViewportCenterLinePx3, (ScalingParams) value14, iIntValue8, ((ScalingLazyListAnchorType) value16).getType(), (AutoCenteringParams) scalingLazyListState3.getAutoCentering$compose_material_release().getValue(), z2);
                                arrayList.add(scalingLazyListItemInfoM755calculateItemInfoCuKLY0U3);
                                int size4 = scalingLazyListItemInfoM755calculateItemInfoCuKLY0U3.getSize();
                                Object value17 = scalingLazyListState3.getGapBetweenItemsPx$compose_material_release().getValue();
                                Intrinsics.checkNotNull(value17);
                                iIntValue7 += size4 + ((Number) value17).intValue();
                            }
                        }
                    }
                    i3 = i7;
                } else {
                    i3 = 0;
                    index = 0;
                }
                if (this.this$0.getAutoCentering$compose_material_release().getValue() != null) {
                    totalItemsCount = RangesKt.coerceAtLeast(this.this$0.getLazyListState().getLayoutInfo().getTotalItemsCount() - 2, 0);
                } else {
                    totalItemsCount = this.this$0.getLazyListState().getLayoutInfo().getTotalItemsCount();
                }
                int i8 = totalItemsCount;
                if (((Boolean) this.this$0.getInitialized$compose_material_release().getValue()).booleanValue()) {
                    z = this.this$0.incompleteScrollItem.getValue() != null;
                } else {
                    if (this.this$0.getAutoCentering$compose_material_release().getValue() != null) {
                        if (this.this$0.getLazyListState().getLayoutInfo().getVisibleItemsInfo().size() >= 2) {
                            if (this.this$0.getLazyListState().getLayoutInfo().getVisibleItemsInfo().size() != 2) {
                                ScalingLazyListState scalingLazyListState4 = this.this$0;
                                if (scalingLazyListState4.topSpacerIsCorrectlySized(scalingLazyListState4.getLazyListState().getLayoutInfo().getVisibleItemsInfo(), this.this$0.getLazyListState().getLayoutInfo().getTotalItemsCount())) {
                                }
                            }
                        }
                    }
                }
                int viewportStartOffset2 = this.this$0.getLazyListState().getLayoutInfo().getViewportStartOffset();
                Object value18 = this.this$0.getExtraPaddingPx$compose_material_release().getValue();
                Intrinsics.checkNotNull(value18);
                int iIntValue9 = viewportStartOffset2 + ((Number) value18).intValue();
                int viewportEndOffset = this.this$0.getLazyListState().getLayoutInfo().getViewportEndOffset();
                Object value19 = this.this$0.getExtraPaddingPx$compose_material_release().getValue();
                Intrinsics.checkNotNull(value19);
                int iIntValue10 = viewportEndOffset - ((Number) value19).intValue();
                int i9 = ((Boolean) this.this$0.getInitialized$compose_material_release().getValue()).booleanValue() ? index : 0;
                if (!((Boolean) this.this$0.getInitialized$compose_material_release().getValue()).booleanValue()) {
                    i3 = 0;
                }
                Object value20 = this.this$0.getReverseLayout$compose_material_release().getValue();
                Intrinsics.checkNotNull(value20);
                boolean zBooleanValue = ((Boolean) value20).booleanValue();
                Orientation orientation = this.this$0.getLazyListState().getLayoutInfo().getOrientation();
                int i10 = IntSize.getWidth-impl(this.this$0.getLazyListState().getLayoutInfo().getViewportSize-YbymL2g());
                int i11 = IntSize.getHeight-impl(this.this$0.getLazyListState().getLayoutInfo().getViewportSize-YbymL2g());
                Object value21 = this.this$0.getExtraPaddingPx$compose_material_release().getValue();
                Intrinsics.checkNotNull(value21);
                long jIntSize = IntSizeKt.IntSize(i10, i11 - (((Number) value21).intValue() * 2));
                Object value22 = this.this$0.getBeforeContentPaddingPx$compose_material_release().getValue();
                Intrinsics.checkNotNull(value22);
                int iIntValue11 = ((Number) value22).intValue();
                Object value23 = this.this$0.getAfterContentPaddingPx$compose_material_release().getValue();
                Intrinsics.checkNotNull(value23);
                return new DefaultScalingLazyListLayoutInfo(arrayList, iIntValue9, iIntValue10, i8, i9, i3, zBooleanValue, orientation, jIntSize, iIntValue11, ((Number) value23).intValue(), this.this$0.calculateTopAutoCenteringPaddingPx(arrayList, i8), this.this$0.calculateBottomAutoCenteringPaddingPx(arrayList, i8), z, ((Boolean) this.this$0.getInitialized$compose_material_release().getValue()).booleanValue(), null);
            }
        });
    }

    public /* synthetic */ ScalingLazyListState(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 1 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    /* JADX INFO: renamed from: getLazyListState$compose_material_release, reason: from getter */
    public final LazyListState getLazyListState() {
        return this.lazyListState;
    }

    public final void setLazyListState$compose_material_release(LazyListState lazyListState) {
        this.lazyListState = lazyListState;
    }

    public final MutableState<Integer> getExtraPaddingPx$compose_material_release() {
        return this.extraPaddingPx;
    }

    public final MutableState<Integer> getBeforeContentPaddingPx$compose_material_release() {
        return this.beforeContentPaddingPx;
    }

    public final MutableState<Integer> getAfterContentPaddingPx$compose_material_release() {
        return this.afterContentPaddingPx;
    }

    public final MutableState<ScalingParams> getScalingParams$compose_material_release() {
        return this.scalingParams;
    }

    public final MutableState<Integer> getGapBetweenItemsPx$compose_material_release() {
        return this.gapBetweenItemsPx;
    }

    public final MutableState<Integer> getViewportHeightPx$compose_material_release() {
        return this.viewportHeightPx;
    }

    public final MutableState<Boolean> getReverseLayout$compose_material_release() {
        return this.reverseLayout;
    }

    public final MutableState<ScalingLazyListAnchorType> getAnchorType$compose_material_release() {
        return this.anchorType;
    }

    public final MutableState<AutoCenteringParams> getAutoCentering$compose_material_release() {
        return this.autoCentering;
    }

    public final MutableState<Boolean> getInitialized$compose_material_release() {
        return this.initialized;
    }

    public final MutableState<Boolean> getLocalInspectionMode$compose_material_release() {
        return this.localInspectionMode;
    }

    public final int getCenterItemIndex() {
        return ((Number) this._centerItemIndex.getValue()).intValue();
    }

    public final int getTopAutoCenteringItemSizePx$compose_material_release() {
        return ((Number) this.topAutoCenteringItemSizePx.getValue()).intValue();
    }

    public final int getBottomAutoCenteringItemSizePx$compose_material_release() {
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
    public final Integer findItemNearestCenter(int verticalAdjustment) {
        int size = this.lazyListState.getLayoutInfo().getVisibleItemsInfo().size();
        Integer num = null;
        for (int i = 0; i < size; i++) {
            LazyListItemInfo lazyListItemInfo = (LazyListItemInfo) this.lazyListState.getLayoutInfo().getVisibleItemsInfo().get(i);
            if (!discardAutoCenteringListItem(lazyListItemInfo)) {
                float offset = (lazyListItemInfo.getOffset() - verticalAdjustment) + lazyListItemInfo.getSize();
                Object value = this.gapBetweenItemsPx.getValue();
                Intrinsics.checkNotNull(value);
                float fFloatValue = offset + (((Number) value).floatValue() / 2.0f);
                Integer numValueOf = Integer.valueOf(i);
                if (fFloatValue > viewportCenterLinePx()) {
                    return numValueOf;
                }
                num = numValueOf;
            }
        }
        return num;
    }

    /* JADX INFO: compiled from: ScalingLazyListState.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/wear/compose/material/ScalingLazyListState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/wear/compose/material/ScalingLazyListState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
        Object objScrollToItem$compose_material_release = scrollToItem$compose_material_release(false, i, i2, continuation);
        return objScrollToItem$compose_material_release == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScrollToItem$compose_material_release : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00bf, code lost:
    
        if (androidx.wear.compose.material.ScalingLazyListStateKt.scrollToItem(r11, r12, r2, r7 + r14, r0) == r1) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0125, code lost:
    
        if (androidx.wear.compose.material.ScalingLazyListStateKt.scrollToItem(r11, r12, r2, r7, r0) == r1) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object scrollToItem$compose_material_release(boolean r12, int r13, int r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            Method dump skipped, instruction units count: 329
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.wear.compose.material.ScalingLazyListState.scrollToItem$compose_material_release(boolean, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a7, code lost:
    
        if (r7.scrollToItem$compose_material_release(r8, r2, r4, r0) == r1) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object scrollToInitialItem$compose_material_release(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof androidx.wear.compose.material.ScalingLazyListState$scrollToInitialItem$1
            if (r0 == 0) goto L14
            r0 = r8
            androidx.wear.compose.material.ScalingLazyListState$scrollToInitialItem$1 r0 = (androidx.wear.compose.material.ScalingLazyListState$scrollToInitialItem$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            androidx.wear.compose.material.ScalingLazyListState$scrollToInitialItem$1 r0 = new androidx.wear.compose.material.ScalingLazyListState$scrollToInitialItem$1
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
            androidx.wear.compose.material.ScalingLazyListState r7 = (androidx.wear.compose.material.ScalingLazyListState) r7
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
            java.lang.Object r7 = r7.scrollToItem$compose_material_release(r8, r2, r4, r0)
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.wear.compose.material.ScalingLazyListState.scrollToInitialItem$compose_material_release(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object animateScrollToItem$default(ScalingLazyListState scalingLazyListState, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return scalingLazyListState.animateScrollToItem(i, i2, continuation);
    }

    public final Object animateScrollToItem(int i, int i2, Continuation<? super Unit> continuation) {
        Object objScrollToItem$compose_material_release = scrollToItem$compose_material_release(true, i, i2, continuation);
        return objScrollToItem$compose_material_release == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScrollToItem$compose_material_release : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean discardAutoCenteringListItem(LazyListItemInfo item) {
        if (this.autoCentering.getValue() != null) {
            return item.getIndex() == 0 || item.getIndex() == this.lazyListState.getLayoutInfo().getTotalItemsCount() - 1;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int calculateTopAutoCenteringPaddingPx(List<? extends ScalingLazyListItemInfo> visibleItems, int totalItemCount) {
        ScalingLazyListItemInfo scalingLazyListItemInfo;
        if (this.autoCentering.getValue() == null || !(visibleItems.isEmpty() || ((ScalingLazyListItemInfo) CollectionsKt.first(visibleItems)).getIndex() == 0)) {
            return 0;
        }
        Object value = this.autoCentering.getValue();
        Intrinsics.checkNotNull(value);
        int iCoerceAtMost = RangesKt.coerceAtMost(((AutoCenteringParams) value).getItemIndex(), totalItemCount - 1);
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
        int iSpaceNeeded = spaceNeeded(scalingLazyListItemInfo);
        if (iSpaceNeeded > 0.0f) {
            ArrayList arrayList = new ArrayList(visibleItems.size());
            int size2 = visibleItems.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ArrayList arrayList2 = arrayList;
                ScalingLazyListItemInfo scalingLazyListItemInfo2 = visibleItems.get(i2);
                if (scalingLazyListItemInfo2.getIndex() < iCoerceAtMost) {
                    Object value2 = this.gapBetweenItemsPx.getValue();
                    Intrinsics.checkNotNull(value2);
                    iSpaceNeeded = (iSpaceNeeded - ((Number) value2).intValue()) - scalingLazyListItemInfo2.getUnadjustedSize();
                }
                arrayList2.add(Unit.INSTANCE);
            }
        }
        Object value3 = this.gapBetweenItemsPx.getValue();
        Intrinsics.checkNotNull(value3);
        return RangesKt.coerceAtLeast(iSpaceNeeded + ((Number) value3).intValue(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean topSpacerIsCorrectlySized(List<? extends LazyListItemInfo> visibleItems, int totalItemCount) {
        LazyListItemInfo lazyListItemInfo;
        if (((LazyListItemInfo) CollectionsKt.first(this.lazyListState.getLayoutInfo().getVisibleItemsInfo())).getSize() > 0) {
            return true;
        }
        Object value = this.autoCentering.getValue();
        Intrinsics.checkNotNull(value);
        int iCoerceAtMost = RangesKt.coerceAtMost(((AutoCenteringParams) value).getItemIndex() + 1, totalItemCount - 2);
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
        int iSpaceNeeded = spaceNeeded(lazyListItemInfo);
        if (iSpaceNeeded > 0.0f) {
            ArrayList arrayList = new ArrayList(visibleItems.size());
            int size2 = visibleItems.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ArrayList arrayList2 = arrayList;
                LazyListItemInfo lazyListItemInfo2 = visibleItems.get(i2);
                if (lazyListItemInfo2.getIndex() != 0 && lazyListItemInfo2.getIndex() < iCoerceAtMost) {
                    Object value2 = this.gapBetweenItemsPx.getValue();
                    Intrinsics.checkNotNull(value2);
                    iSpaceNeeded = (iSpaceNeeded - ((Number) value2).intValue()) - lazyListItemInfo2.getSize();
                }
                arrayList2.add(Unit.INSTANCE);
            }
        }
        Object value3 = this.gapBetweenItemsPx.getValue();
        Intrinsics.checkNotNull(value3);
        return iSpaceNeeded < ((Number) value3).intValue();
    }

    private final int spaceNeeded(ScalingLazyListItemInfo item) {
        int iViewportCenterLinePx = viewportCenterLinePx();
        Object value = this.gapBetweenItemsPx.getValue();
        Intrinsics.checkNotNull(value);
        int iIntValue = iViewportCenterLinePx - ((Number) value).intValue();
        Object value2 = this.autoCentering.getValue();
        Intrinsics.checkNotNull(value2);
        return (iIntValue - ((AutoCenteringParams) value2).getItemOffset()) - (item != null ? unadjustedItemSizeAboveOffsetPoint(item) : 0);
    }

    private final int spaceNeeded(LazyListItemInfo item) {
        int iViewportCenterLinePx = viewportCenterLinePx();
        Object value = this.gapBetweenItemsPx.getValue();
        Intrinsics.checkNotNull(value);
        int iIntValue = iViewportCenterLinePx - ((Number) value).intValue();
        Object value2 = this.autoCentering.getValue();
        Intrinsics.checkNotNull(value2);
        return (iIntValue - ((AutoCenteringParams) value2).getItemOffset()) - (item != null ? itemSizeAboveOffsetPoint(item) : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int calculateBottomAutoCenteringPaddingPx(List<? extends ScalingLazyListItemInfo> visibleItemsInfo, int totalItemsCount) {
        if (this.autoCentering.getValue() == null || visibleItemsInfo.isEmpty() || ((ScalingLazyListItemInfo) CollectionsKt.last(visibleItemsInfo)).getIndex() != totalItemsCount - 1) {
            return 0;
        }
        Object value = this.viewportHeightPx.getValue();
        Intrinsics.checkNotNull(value);
        return (((Number) value).intValue() - viewportCenterLinePx()) - unadjustedItemSizeBelowOffsetPoint((ScalingLazyListItemInfo) CollectionsKt.last(visibleItemsInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int viewportCenterLinePx() {
        Object value = this.viewportHeightPx.getValue();
        Intrinsics.checkNotNull(value);
        return ((Number) value).intValue() / 2;
    }

    private final int unadjustedItemSizeAboveOffsetPoint(ScalingLazyListItemInfo scalingLazyListItemInfo) {
        ScalingLazyListAnchorType scalingLazyListAnchorType = (ScalingLazyListAnchorType) this.anchorType.getValue();
        if (scalingLazyListAnchorType == null ? false : ScalingLazyListAnchorType.m762equalsimpl0(scalingLazyListAnchorType.getType(), ScalingLazyListAnchorType.INSTANCE.m767getItemStarthvgbs18())) {
            return 0;
        }
        return scalingLazyListItemInfo.getUnadjustedSize() / 2;
    }

    private final int itemSizeAboveOffsetPoint(LazyListItemInfo lazyListItemInfo) {
        ScalingLazyListAnchorType scalingLazyListAnchorType = (ScalingLazyListAnchorType) this.anchorType.getValue();
        if (scalingLazyListAnchorType == null ? false : ScalingLazyListAnchorType.m762equalsimpl0(scalingLazyListAnchorType.getType(), ScalingLazyListAnchorType.INSTANCE.m767getItemStarthvgbs18())) {
            return 0;
        }
        return lazyListItemInfo.getSize() / 2;
    }

    private final int unadjustedItemSizeBelowOffsetPoint(ScalingLazyListItemInfo scalingLazyListItemInfo) {
        return scalingLazyListItemInfo.getUnadjustedSize() - unadjustedItemSizeAboveOffsetPoint(scalingLazyListItemInfo);
    }
}
