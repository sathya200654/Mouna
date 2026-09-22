package androidx.wear.compose.material;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: Picker.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 ;2\u00020\u0001:\u0001;B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010'J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)H\u0016J\u0010\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u0003H\u0002J\r\u0010-\u001a\u00020\u0003H\u0000¢\u0006\u0002\b.J?\u0010/\u001a\u00020%2\u0006\u00100\u001a\u0002012'\u00102\u001a#\b\u0001\u0012\u0004\u0012\u000204\u0012\n\u0012\b\u0012\u0004\u0012\u00020%05\u0012\u0006\u0012\u0004\u0018\u00010603¢\u0006\u0002\b7H\u0096@¢\u0006\u0002\u00108J\u0016\u00109\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010'J\u0010\u0010:\u001a\u00020%2\u0006\u0010\u0017\u001a\u00020\u0003H\u0002R+\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0012R$\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\rR\u001a\u0010\u001a\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001c\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0014\u0010\u001e\u001a\u00020\u001fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b#\u0010\u000b¨\u0006<"}, d2 = {"Landroidx/wear/compose/material/PickerState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "initialNumberOfOptions", "", "initiallySelectedOption", "repeatItems", "", "(IIZ)V", "<set-?>", "_numberOfOptions", "get_numberOfOptions", "()I", "set_numberOfOptions", "(I)V", "_numberOfOptions$delegate", "Landroidx/compose/runtime/MutableIntState;", "canScrollBackward", "getCanScrollBackward", "()Z", "canScrollForward", "getCanScrollForward", "isScrollInProgress", "newNumberOfOptions", "numberOfOptions", "getNumberOfOptions", "setNumberOfOptions", "optionsOffset", "getOptionsOffset$compose_material_release", "setOptionsOffset$compose_material_release", "getRepeatItems", "scalingLazyListState", "Landroidx/wear/compose/foundation/lazy/ScalingLazyListState;", "getScalingLazyListState$compose_material_release", "()Landroidx/wear/compose/foundation/lazy/ScalingLazyListState;", "selectedOption", "getSelectedOption", "animateScrollToOption", "", "index", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchRawDelta", "", "delta", "getClosestTargetItemIndex", "option", "numberOfItems", "numberOfItems$compose_material_release", "scroll", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollToOption", "verifyNumberOfOptions", "Companion", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PickerState implements ScrollableState {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Saver<PickerState, Object> Saver = ListSaverKt.listSaver(new Function2<SaverScope, PickerState, List<? extends Object>>() { // from class: androidx.wear.compose.material.PickerState$Companion$Saver$1
        public final List<Object> invoke(SaverScope saverScope, PickerState pickerState) {
            return CollectionsKt.listOf(new Object[]{Integer.valueOf(pickerState.getNumberOfOptions()), Integer.valueOf(pickerState.getSelectedOption()), Boolean.valueOf(pickerState.getRepeatItems())});
        }
    }, new Function1<List<? extends Object>, PickerState>() { // from class: androidx.wear.compose.material.PickerState$Companion$Saver$2
        public final PickerState invoke(List<? extends Object> list) {
            Object obj = list.get(0);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            int iIntValue = ((Integer) obj).intValue();
            Object obj2 = list.get(1);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
            int iIntValue2 = ((Integer) obj2).intValue();
            Object obj3 = list.get(2);
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            return new PickerState(iIntValue, iIntValue2, ((Boolean) obj3).booleanValue());
        }
    });

    /* JADX INFO: renamed from: _numberOfOptions$delegate, reason: from kotlin metadata */
    private final MutableIntState _numberOfOptions;
    private int optionsOffset;
    private final boolean repeatItems;
    private final androidx.wear.compose.foundation.lazy.ScalingLazyListState scalingLazyListState;

    public PickerState(int i, int i2, boolean z) {
        this.repeatItems = z;
        verifyNumberOfOptions(i);
        this._numberOfOptions = SnapshotIntStateKt.mutableIntStateOf(i);
        this.scalingLazyListState = new androidx.wear.compose.foundation.lazy.ScalingLazyListState((getNumberOfOptions() * ((this.repeatItems ? 100000000 / getNumberOfOptions() : 1) / 2)) + i2, 0);
    }

    public /* synthetic */ PickerState(int i, int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? true : z);
    }

    public final boolean getRepeatItems() {
        return this.repeatItems;
    }

    private final int get_numberOfOptions() {
        return this._numberOfOptions.getIntValue();
    }

    private final void set_numberOfOptions(int i) {
        this._numberOfOptions.setIntValue(i);
    }

    public final int getNumberOfOptions() {
        return get_numberOfOptions();
    }

    public final void setNumberOfOptions(int i) {
        verifyNumberOfOptions(i);
        this.optionsOffset = PickerKt.positiveModulo(RangesKt.coerceAtMost(getSelectedOption(), i - 1) - this.scalingLazyListState.getCenterItemIndex(), i);
        set_numberOfOptions(i);
    }

    public final int numberOfItems$compose_material_release() {
        if (this.repeatItems) {
            return 100000000;
        }
        return getNumberOfOptions();
    }

    /* JADX INFO: renamed from: getOptionsOffset$compose_material_release, reason: from getter */
    public final int getOptionsOffset() {
        return this.optionsOffset;
    }

    public final void setOptionsOffset$compose_material_release(int i) {
        this.optionsOffset = i;
    }

    /* JADX INFO: renamed from: getScalingLazyListState$compose_material_release, reason: from getter */
    public final androidx.wear.compose.foundation.lazy.ScalingLazyListState getScalingLazyListState() {
        return this.scalingLazyListState;
    }

    public final int getSelectedOption() {
        return (this.scalingLazyListState.getCenterItemIndex() + this.optionsOffset) % getNumberOfOptions();
    }

    public final Object scrollToOption(int i, Continuation<? super Unit> continuation) {
        Object objScrollToItem = this.scalingLazyListState.scrollToItem(getClosestTargetItemIndex(i), 0, continuation);
        return objScrollToItem == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScrollToItem : Unit.INSTANCE;
    }

    public final Object animateScrollToOption(int i, Continuation<? super Unit> continuation) {
        Object objAnimateScrollToItem = this.scalingLazyListState.animateScrollToItem(getClosestTargetItemIndex(i), 0, continuation);
        return objAnimateScrollToItem == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateScrollToItem : Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: Picker.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/wear/compose/material/PickerState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/wear/compose/material/PickerState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<PickerState, Object> getSaver() {
            return PickerState.Saver;
        }
    }

    public Object scroll(MutatePriority mutatePriority, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object objScroll = this.scalingLazyListState.scroll(mutatePriority, function2, continuation);
        return objScroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScroll : Unit.INSTANCE;
    }

    public float dispatchRawDelta(float delta) {
        return this.scalingLazyListState.dispatchRawDelta(delta);
    }

    public boolean isScrollInProgress() {
        return this.scalingLazyListState.isScrollInProgress();
    }

    public boolean getCanScrollForward() {
        return this.scalingLazyListState.getCanScrollForward();
    }

    public boolean getCanScrollBackward() {
        return this.scalingLazyListState.getCanScrollBackward();
    }

    private final int getClosestTargetItemIndex(int option) {
        if (!this.repeatItems) {
            return option;
        }
        int iPositiveModulo = PickerKt.positiveModulo(getSelectedOption() - option, getNumberOfOptions());
        int iPositiveModulo2 = PickerKt.positiveModulo(option - getSelectedOption(), getNumberOfOptions());
        int centerItemIndex = this.scalingLazyListState.getCenterItemIndex();
        if (iPositiveModulo <= iPositiveModulo2) {
            iPositiveModulo2 = -iPositiveModulo;
        }
        return centerItemIndex + iPositiveModulo2;
    }

    private final void verifyNumberOfOptions(int numberOfOptions) {
        if (numberOfOptions <= 0) {
            throw new IllegalArgumentException("The picker should have at least one item.".toString());
        }
        if (numberOfOptions >= 33333333) {
            throw new IllegalArgumentException("The picker should have less than 33333333 items".toString());
        }
    }
}
