package androidx.wear.compose.foundation.rotary;

import androidx.compose.foundation.gestures.Orientation;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: RotaryScrollable.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0002J2\u0010\u000f\u001a\u00020\u000e*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010\u0018R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Landroidx/wear/compose/foundation/rotary/LowResSnapRotaryScrollableBehavior;", "Landroidx/wear/compose/foundation/rotary/BaseRotaryScrollableBehavior;", "rotaryHaptics", "Landroidx/wear/compose/foundation/rotary/RotaryHapticHandler;", "snapHandlerFactory", "Lkotlin/Function0;", "Landroidx/wear/compose/foundation/rotary/RotarySnapHandler;", "(Landroidx/wear/compose/foundation/rotary/RotaryHapticHandler;Lkotlin/jvm/functions/Function0;)V", "accumulatedSnapDelta", "", "snapHandler", "snapJob", "Lkotlinx/coroutines/Job;", "resetSnapping", "", "performScroll", "Lkotlinx/coroutines/CoroutineScope;", "timestampMillis", "", "delta", "inputDeviceId", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "(Lkotlinx/coroutines/CoroutineScope;JFILandroidx/compose/foundation/gestures/Orientation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LowResSnapRotaryScrollableBehavior extends BaseRotaryScrollableBehavior {
    public static final int $stable = 8;
    private float accumulatedSnapDelta;
    private final RotaryHapticHandler rotaryHaptics;
    private RotarySnapHandler snapHandler;
    private final Function0<RotarySnapHandler> snapHandlerFactory;
    private Job snapJob = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);

    public LowResSnapRotaryScrollableBehavior(RotaryHapticHandler rotaryHapticHandler, Function0<RotarySnapHandler> function0) {
        this.rotaryHaptics = rotaryHapticHandler;
        this.snapHandlerFactory = function0;
        this.snapHandler = (RotarySnapHandler) function0.invoke();
    }

    @Override // androidx.wear.compose.foundation.rotary.RotaryScrollableBehavior
    public Object performScroll(CoroutineScope coroutineScope, long j, float f, int i, Orientation orientation, Continuation<? super Unit> continuation) {
        if (isNewScrollEvent(j)) {
            resetSnapping();
        }
        this.accumulatedSnapDelta += f;
        setPreviousScrollEventTime(j);
        if (Math.abs(this.accumulatedSnapDelta) > 1.0f) {
            int iSignum = (int) Math.signum(this.accumulatedSnapDelta);
            this.rotaryHaptics.handleSnapHaptic(j, f);
            this.snapHandler.updateSnapTarget(iSignum, this.snapJob.isActive());
            if (!this.snapJob.isActive()) {
                Job.DefaultImpls.cancel$default(this.snapJob, (CancellationException) null, 1, (Object) null);
                this.snapJob = BuildersKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new LowResSnapRotaryScrollableBehavior$performScroll$6$1(this, null), 3, (Object) null);
            }
            this.accumulatedSnapDelta = 0.0f;
        }
        return Unit.INSTANCE;
    }

    private final void resetSnapping() {
        Job.DefaultImpls.cancel$default(this.snapJob, (CancellationException) null, 1, (Object) null);
        this.snapHandler = (RotarySnapHandler) this.snapHandlerFactory.invoke();
        this.accumulatedSnapDelta = 0.0f;
    }
}
