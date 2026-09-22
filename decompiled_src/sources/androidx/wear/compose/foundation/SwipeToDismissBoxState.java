package androidx.wear.compose.foundation;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.State;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: BasicSwipeToDismissBox.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB+\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\u0010\tJ\u001b\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0000¢\u0006\u0002\b\u001aJ\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\u001dR\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\f¨\u0006\u001f"}, d2 = {"Landroidx/wear/compose/foundation/SwipeToDismissBoxState;", "", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "Landroidx/wear/compose/foundation/SwipeToDismissValue;", "", "(Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;)V", "currentValue", "getCurrentValue", "()Landroidx/wear/compose/foundation/SwipeToDismissValue;", "isAnimationRunning", "()Z", "swipeableState", "Landroidx/wear/compose/foundation/SwipeableV2State;", "getSwipeableState$compose_foundation_release", "()Landroidx/wear/compose/foundation/SwipeableV2State;", "targetValue", "getTargetValue", "edgeNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "edgeSwipeState", "Landroidx/compose/runtime/State;", "Landroidx/wear/compose/foundation/EdgeSwipeState;", "edgeNestedScrollConnection$compose_foundation_release", "snapTo", "", "(Landroidx/wear/compose/foundation/SwipeToDismissValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SwipeToDismissBoxState {
    public static final int $stable = 0;
    private static final Companion Companion = new Companion(null);
    private final SwipeableV2State<SwipeToDismissValue> swipeableState;

    /* JADX WARN: Illegal instructions before constructor call */
    public SwipeToDismissBoxState() {
        AnimationSpec animationSpec = null;
        this(animationSpec, animationSpec, 3, animationSpec);
    }

    public SwipeToDismissBoxState(AnimationSpec<Float> animationSpec, Function1<? super SwipeToDismissValue, Boolean> function1) {
        this.swipeableState = new SwipeableV2State<>(SwipeToDismissValue.Default, animationSpec, function1, SwipeableV2Kt.fractionalPositionalThreshold(0.5f), 0.0f, null, 48, null);
    }

    public /* synthetic */ SwipeToDismissBoxState(AnimationSpec animationSpec, AnonymousClass1 anonymousClass1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? (AnimationSpec) SwipeToDismissBoxDefaults.INSTANCE.getAnimationSpec() : animationSpec, (i & 2) != 0 ? new Function1<SwipeToDismissValue, Boolean>() { // from class: androidx.wear.compose.foundation.SwipeToDismissBoxState.1
            public final Boolean invoke(SwipeToDismissValue swipeToDismissValue) {
                return true;
            }
        } : anonymousClass1);
    }

    public final SwipeToDismissValue getCurrentValue() {
        return this.swipeableState.getCurrentValue();
    }

    public final SwipeToDismissValue getTargetValue() {
        return this.swipeableState.getTargetValue();
    }

    public final boolean isAnimationRunning() {
        return this.swipeableState.isAnimationRunning();
    }

    public final NestedScrollConnection edgeNestedScrollConnection$compose_foundation_release(State<? extends EdgeSwipeState> edgeSwipeState) {
        return Companion.edgeNestedScrollConnection(this.swipeableState, edgeSwipeState);
    }

    public final Object snapTo(SwipeToDismissValue swipeToDismissValue, Continuation<? super Unit> continuation) {
        Object objSnapTo = this.swipeableState.snapTo(swipeToDismissValue, continuation);
        return objSnapTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSnapTo : Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: BasicSwipeToDismissBox.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002¨\u0006\n"}, d2 = {"Landroidx/wear/compose/foundation/SwipeToDismissBoxState$Companion;", "", "()V", "edgeNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "T", "Landroidx/wear/compose/foundation/SwipeableV2State;", "edgeSwipeState", "Landroidx/compose/runtime/State;", "Landroidx/wear/compose/foundation/EdgeSwipeState;", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final <T> NestedScrollConnection edgeNestedScrollConnection(SwipeableV2State<T> swipeableV2State, State<? extends EdgeSwipeState> state) {
            return new SwipeToDismissBoxState$Companion$edgeNestedScrollConnection$1(state, swipeableV2State);
        }
    }

    public final SwipeableV2State<SwipeToDismissValue> getSwipeableState$compose_foundation_release() {
        return this.swipeableState;
    }
}
