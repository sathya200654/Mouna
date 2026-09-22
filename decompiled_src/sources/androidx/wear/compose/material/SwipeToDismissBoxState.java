package androidx.wear.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SwipeToDismissBox.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Deprecated(message = "SwipeToDismissBoxState has been migrated, please import it from androidx.wear.compose.foundation.")
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\u0010\tJ\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\u0017R\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u000e8GX\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\f¨\u0006\u0018"}, d2 = {"Landroidx/wear/compose/material/SwipeToDismissBoxState;", "", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "Landroidx/wear/compose/material/SwipeToDismissValue;", "", "(Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;)V", "currentValue", "getCurrentValue", "()Landroidx/wear/compose/material/SwipeToDismissValue;", "foundationState", "Landroidx/wear/compose/foundation/SwipeToDismissBoxState;", "getFoundationState", "()Landroidx/wear/compose/foundation/SwipeToDismissBoxState;", "isAnimationRunning", "()Z", "targetValue", "getTargetValue", "snapTo", "", "(Landroidx/wear/compose/material/SwipeToDismissValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SwipeToDismissBoxState {
    public static final int $stable = 0;
    private final androidx.wear.compose.foundation.SwipeToDismissBoxState foundationState;

    /* JADX WARN: Illegal instructions before constructor call */
    public SwipeToDismissBoxState() {
        AnimationSpec animationSpec = null;
        this(animationSpec, animationSpec, 3, animationSpec);
    }

    public SwipeToDismissBoxState(AnimationSpec<Float> animationSpec, final Function1<? super SwipeToDismissValue, Boolean> function1) {
        this.foundationState = new androidx.wear.compose.foundation.SwipeToDismissBoxState(animationSpec, new Function1<androidx.wear.compose.foundation.SwipeToDismissValue, Boolean>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxState$foundationState$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public final Boolean invoke(androidx.wear.compose.foundation.SwipeToDismissValue swipeToDismissValue) {
                return (Boolean) function1.invoke(SwipeToDismissBoxKt.convertFromFoundationSwipeToDismissValue(swipeToDismissValue));
            }
        });
    }

    public /* synthetic */ SwipeToDismissBoxState(AnimationSpec animationSpec, AnonymousClass1 anonymousClass1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? (AnimationSpec) SwipeToDismissBoxDefaults.INSTANCE.getAnimationSpec() : animationSpec, (i & 2) != 0 ? new Function1<SwipeToDismissValue, Boolean>() { // from class: androidx.wear.compose.material.SwipeToDismissBoxState.1
            public final Boolean invoke(SwipeToDismissValue swipeToDismissValue) {
                return true;
            }
        } : anonymousClass1);
    }

    public final SwipeToDismissValue getCurrentValue() {
        return SwipeToDismissBoxKt.convertFromFoundationSwipeToDismissValue(getFoundationState().getCurrentValue());
    }

    public final SwipeToDismissValue getTargetValue() {
        return SwipeToDismissBoxKt.convertFromFoundationSwipeToDismissValue(getFoundationState().getTargetValue());
    }

    public final boolean isAnimationRunning() {
        return getFoundationState().isAnimationRunning();
    }

    public final Object snapTo(SwipeToDismissValue swipeToDismissValue, Continuation<? super Unit> continuation) {
        Object objSnapTo = getFoundationState().snapTo(SwipeToDismissBoxKt.convertToFoundationSwipeToDismissValue(swipeToDismissValue), continuation);
        return objSnapTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSnapTo : Unit.INSTANCE;
    }

    public final androidx.wear.compose.foundation.SwipeToDismissBoxState getFoundationState() {
        return this.foundationState;
    }
}
