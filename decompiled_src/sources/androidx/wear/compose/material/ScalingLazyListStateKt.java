package androidx.wear.compose.material;

import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListLayoutInfo;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: ScalingLazyListState.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a!\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0005\u001a\f\u0010\u0006\u001a\u00020\u0003*\u00020\u0007H\u0002\u001a\u0016\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0002\u001a\u0012\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r*\u00020\u0007H\u0000\u001a*\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003H\u0082@¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"rememberScalingLazyListState", "Landroidx/wear/compose/material/ScalingLazyListState;", "initialCenterItemIndex", "", "initialCenterItemScrollOffset", "(IILandroidx/compose/runtime/Composer;II)Landroidx/wear/compose/material/ScalingLazyListState;", "averageUnadjustedItemSize", "Landroidx/wear/compose/material/ScalingLazyListLayoutInfo;", "findItemInfoWithIndex", "Landroidx/compose/foundation/lazy/LazyListItemInfo;", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "index", "internalVisibleItemInfo", "", "Landroidx/wear/compose/material/ScalingLazyListItemInfo;", "scrollToItem", "", "Landroidx/compose/foundation/lazy/LazyListState;", "animated", "", "offset", "(Landroidx/compose/foundation/lazy/LazyListState;ZIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "compose-material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ScalingLazyListStateKt {
    @Deprecated(message = "Was moved to androidx.wear.compose.foundation.lazy package. Please use it instead")
    public static final ScalingLazyListState rememberScalingLazyListState(final int i, final int i2, Composer composer, int i3, int i4) {
        ComposerKt.sourceInformationMarkerStart(composer, 774957636, "C(rememberScalingLazyListState)58@2432L125,58@2379L178:ScalingLazyListState.kt#gj9v0t");
        boolean z = true;
        if ((i4 & 1) != 0) {
            i = 1;
        }
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(774957636, i3, -1, "androidx.wear.compose.material.rememberScalingLazyListState (ScalingLazyListState.kt:57)");
        }
        Object[] objArr = new Object[0];
        Saver<ScalingLazyListState, Object> saver = ScalingLazyListState.Companion.getSaver();
        ComposerKt.sourceInformationMarkerStart(composer, -711613341, "CC(remember):ScalingLazyListState.kt#9igjgp");
        boolean z2 = (((i3 & 14) ^ 6) > 4 && composer.changed(i)) || (i3 & 6) == 4;
        if ((((i3 & 112) ^ 48) <= 32 || !composer.changed(i2)) && (i3 & 48) != 32) {
            z = false;
        }
        boolean z3 = z2 | z;
        Object objRememberedValue = composer.rememberedValue();
        if (z3 || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = (Function0) new Function0<ScalingLazyListState>() { // from class: androidx.wear.compose.material.ScalingLazyListStateKt$rememberScalingLazyListState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final ScalingLazyListState m776invoke() {
                    return new ScalingLazyListState(i, i2);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        ScalingLazyListState scalingLazyListState = (ScalingLazyListState) RememberSaveableKt.rememberSaveable(objArr, saver, (String) null, (Function0) objRememberedValue, composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return scalingLazyListState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LazyListItemInfo findItemInfoWithIndex(LazyListLayoutInfo lazyListLayoutInfo, int i) {
        Object obj;
        List visibleItemsInfo = lazyListLayoutInfo.getVisibleItemsInfo();
        int size = visibleItemsInfo.size();
        for (int i2 = 0; i2 < size; i2++) {
            obj = visibleItemsInfo.get(i2);
            if (((LazyListItemInfo) obj).getIndex() == i) {
                return (LazyListItemInfo) obj;
            }
        }
        obj = null;
        return (LazyListItemInfo) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object scrollToItem(LazyListState lazyListState, boolean z, int i, int i2, Continuation<? super Unit> continuation) {
        if (z) {
            Object objAnimateScrollToItem = lazyListState.animateScrollToItem(i, i2, continuation);
            return objAnimateScrollToItem == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateScrollToItem : Unit.INSTANCE;
        }
        Object objScrollToItem = lazyListState.scrollToItem(i, i2, continuation);
        return objScrollToItem == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScrollToItem : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int averageUnadjustedItemSize(ScalingLazyListLayoutInfo scalingLazyListLayoutInfo) {
        List<ScalingLazyListItemInfo> visibleItemsInfo = scalingLazyListLayoutInfo.getVisibleItemsInfo();
        int size = visibleItemsInfo.size();
        int unadjustedSize = 0;
        for (int i = 0; i < size; i++) {
            unadjustedSize += visibleItemsInfo.get(i).getUnadjustedSize();
        }
        if (scalingLazyListLayoutInfo.getVisibleItemsInfo().isEmpty()) {
            return 0;
        }
        return MathKt.roundToInt(unadjustedSize / scalingLazyListLayoutInfo.getVisibleItemsInfo().size());
    }

    public static final List<ScalingLazyListItemInfo> internalVisibleItemInfo(ScalingLazyListLayoutInfo scalingLazyListLayoutInfo) {
        List<ScalingLazyListItemInfo> internalVisibleItemsInfo$compose_material_release;
        DefaultScalingLazyListLayoutInfo defaultScalingLazyListLayoutInfo = scalingLazyListLayoutInfo instanceof DefaultScalingLazyListLayoutInfo ? (DefaultScalingLazyListLayoutInfo) scalingLazyListLayoutInfo : null;
        return (defaultScalingLazyListLayoutInfo == null || (internalVisibleItemsInfo$compose_material_release = defaultScalingLazyListLayoutInfo.getInternalVisibleItemsInfo$compose_material_release()) == null) ? CollectionsKt.emptyList() : internalVisibleItemsInfo$compose_material_release;
    }
}
