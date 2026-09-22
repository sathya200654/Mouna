package androidx.wear.compose.foundation.rotary;

import androidx.compose.foundation.gestures.Orientation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: RotaryScrollable.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0002J2\u0010\u0017\u001a\u00020\u0013*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/wear/compose/foundation/rotary/FlingRotaryScrollableBehavior;", "Landroidx/wear/compose/foundation/rotary/BaseRotaryScrollableBehavior;", "isLowRes", "", "rotaryHaptics", "Landroidx/wear/compose/foundation/rotary/RotaryHapticHandler;", "rotaryFlingHandlerFactory", "Lkotlin/Function0;", "Landroidx/wear/compose/foundation/rotary/RotaryFlingHandler;", "scrollHandlerFactory", "Landroidx/wear/compose/foundation/rotary/RotaryScrollHandler;", "(ZLandroidx/wear/compose/foundation/rotary/RotaryHapticHandler;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "rotaryFlingHandler", "rotaryScrollDistance", "", "scrollHandler", "isOppositeValueAfterScroll", "delta", "resetFlingTracking", "", "timestamp", "", "resetScrolling", "performScroll", "Lkotlinx/coroutines/CoroutineScope;", "timestampMillis", "inputDeviceId", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "(Lkotlinx/coroutines/CoroutineScope;JFILandroidx/compose/foundation/gestures/Orientation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FlingRotaryScrollableBehavior extends BaseRotaryScrollableBehavior {
    public static final int $stable = 8;
    private final boolean isLowRes;
    private RotaryFlingHandler rotaryFlingHandler;
    private final Function0<RotaryFlingHandler> rotaryFlingHandlerFactory;
    private final RotaryHapticHandler rotaryHaptics;
    private float rotaryScrollDistance;
    private RotaryScrollHandler scrollHandler;
    private final Function0<RotaryScrollHandler> scrollHandlerFactory;

    public FlingRotaryScrollableBehavior(boolean z, RotaryHapticHandler rotaryHapticHandler, Function0<RotaryFlingHandler> function0, Function0<RotaryScrollHandler> function1) {
        this.isLowRes = z;
        this.rotaryHaptics = rotaryHapticHandler;
        this.rotaryFlingHandlerFactory = function0;
        this.scrollHandlerFactory = function1;
        this.rotaryFlingHandler = (RotaryFlingHandler) function0.invoke();
        this.scrollHandler = (RotaryScrollHandler) function1.invoke();
    }

    @Override // androidx.wear.compose.foundation.rotary.RotaryScrollableBehavior
    public Object performScroll(CoroutineScope coroutineScope, long j, float f, int i, Orientation orientation, Continuation<? super Unit> continuation) {
        RotaryFlingHandler rotaryFlingHandler;
        if (isNewScrollEvent(j)) {
            resetScrolling();
            resetFlingTracking(j);
        } else if ((this.isLowRes || !isOppositeValueAfterScroll(f)) && (rotaryFlingHandler = this.rotaryFlingHandler) != null) {
            rotaryFlingHandler.observeEvent(j, f);
        }
        this.rotaryScrollDistance += f;
        this.rotaryHaptics.handleScrollHaptic(j, f);
        setPreviousScrollEventTime(j);
        this.scrollHandler.scrollToTarget(coroutineScope, this.rotaryScrollDistance);
        RotaryFlingHandler rotaryFlingHandler2 = this.rotaryFlingHandler;
        if (rotaryFlingHandler2 != null) {
            rotaryFlingHandler2.performFlingIfRequired(coroutineScope, new Function0<Unit>() { // from class: androidx.wear.compose.foundation.rotary.FlingRotaryScrollableBehavior.performScroll.6
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m481invoke();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m481invoke() {
                    FlingRotaryScrollableBehavior.this.resetScrolling();
                }
            }, new Function1<Float, Unit>() { // from class: androidx.wear.compose.foundation.rotary.FlingRotaryScrollableBehavior.performScroll.7
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Number) obj).floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(float f2) {
                    FlingRotaryScrollableBehavior.this.rotaryHaptics.handleLimitHaptic(f2 > 0.0f);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetScrolling() {
        this.scrollHandler.cancelScrollIfActive();
        this.scrollHandler = (RotaryScrollHandler) this.scrollHandlerFactory.invoke();
        this.rotaryScrollDistance = 0.0f;
    }

    private final void resetFlingTracking(long timestamp) {
        RotaryFlingHandler rotaryFlingHandler = this.rotaryFlingHandler;
        if (rotaryFlingHandler != null) {
            rotaryFlingHandler.cancelFlingIfActive();
        }
        RotaryFlingHandler rotaryFlingHandler2 = (RotaryFlingHandler) this.rotaryFlingHandlerFactory.invoke();
        this.rotaryFlingHandler = rotaryFlingHandler2;
        if (rotaryFlingHandler2 != null) {
            rotaryFlingHandler2.startFlingTracking(timestamp);
        }
    }

    private final boolean isOppositeValueAfterScroll(float delta) {
        return this.rotaryScrollDistance * delta < 0.0f && Math.abs(delta) < Math.abs(this.rotaryScrollDistance);
    }
}
