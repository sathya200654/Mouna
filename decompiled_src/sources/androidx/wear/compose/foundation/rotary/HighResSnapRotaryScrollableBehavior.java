package androidx.wear.compose.foundation.rotary;

import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.Easing;
import androidx.compose.foundation.gestures.Orientation;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: RotaryScrollable.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0002\u0010\rJ\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0010H\u0002J\u0010\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u0005H\u0002J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020#H\u0002J\u0010\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020\u0016H\u0002J2\u0010'\u001a\u00020#*\u00020(2\u0006\u0010)\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020,H\u0096@¢\u0006\u0002\u0010-R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Landroidx/wear/compose/foundation/rotary/HighResSnapRotaryScrollableBehavior;", "Landroidx/wear/compose/foundation/rotary/BaseRotaryScrollableBehavior;", "rotaryHaptics", "Landroidx/wear/compose/foundation/rotary/RotaryHapticHandler;", "scrollDistanceDivider", "", "thresholdHandlerFactory", "Lkotlin/Function0;", "Landroidx/wear/compose/foundation/rotary/ThresholdHandler;", "snapHandlerFactory", "Landroidx/wear/compose/foundation/rotary/RotarySnapHandler;", "scrollHandlerFactory", "Landroidx/wear/compose/foundation/rotary/RotaryScrollHandler;", "(Landroidx/wear/compose/foundation/rotary/RotaryHapticHandler;FLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "accumulatedSnapDelta", "maxSnapsPerEvent", "", "rotaryScrollDistance", "scrollHandler", "scrollProximityEasing", "Landroidx/compose/animation/core/Easing;", "snapDelay", "", "snapHandler", "snapJob", "Lkotlinx/coroutines/Job;", "thresholdHandler", "calculateProximityFactor", "snapThreshold", "edgeNotReached", "", "snapDistanceInItems", "isOppositeValueAfterScroll", "delta", "resetScrolling", "", "resetSnapping", "resetThresholdTracking", "time", "performScroll", "Lkotlinx/coroutines/CoroutineScope;", "timestampMillis", "inputDeviceId", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "(Lkotlinx/coroutines/CoroutineScope;JFILandroidx/compose/foundation/gestures/Orientation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HighResSnapRotaryScrollableBehavior extends BaseRotaryScrollableBehavior {
    public static final int $stable = 8;
    private float accumulatedSnapDelta;
    private final RotaryHapticHandler rotaryHaptics;
    private float rotaryScrollDistance;
    private final float scrollDistanceDivider;
    private RotaryScrollHandler scrollHandler;
    private final Function0<RotaryScrollHandler> scrollHandlerFactory;
    private RotarySnapHandler snapHandler;
    private final Function0<RotarySnapHandler> snapHandlerFactory;
    private ThresholdHandler thresholdHandler;
    private final Function0<ThresholdHandler> thresholdHandlerFactory;
    private final long snapDelay = 100;
    private final int maxSnapsPerEvent = 2;
    private Job snapJob = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
    private final Easing scrollProximityEasing = new CubicBezierEasing(0.0f, 0.0f, 0.5f, 1.0f);

    /* JADX INFO: renamed from: androidx.wear.compose.foundation.rotary.HighResSnapRotaryScrollableBehavior$performScroll$1, reason: invalid class name */
    /* JADX INFO: compiled from: RotaryScrollable.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.wear.compose.foundation.rotary.HighResSnapRotaryScrollableBehavior", f = "RotaryScrollable.kt", i = {0, 0}, l = {998}, m = "performScroll", n = {"this", "$this$performScroll"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HighResSnapRotaryScrollableBehavior.this.performScroll(null, 0L, 0.0f, 0, null, (Continuation) this);
        }
    }

    public HighResSnapRotaryScrollableBehavior(RotaryHapticHandler rotaryHapticHandler, float f, Function0<ThresholdHandler> function0, Function0<RotarySnapHandler> function1, Function0<RotaryScrollHandler> function2) {
        this.rotaryHaptics = rotaryHapticHandler;
        this.scrollDistanceDivider = f;
        this.thresholdHandlerFactory = function0;
        this.snapHandlerFactory = function1;
        this.scrollHandlerFactory = function2;
        this.snapHandler = (RotarySnapHandler) function1.invoke();
        this.scrollHandler = (RotaryScrollHandler) function2.invoke();
        this.thresholdHandler = (ThresholdHandler) function0.invoke();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    @Override // androidx.wear.compose.foundation.rotary.RotaryScrollableBehavior
    public Object performScroll(CoroutineScope coroutineScope, long j, float f, int i, Orientation orientation, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (isNewScrollEvent(j)) {
                resetScrolling();
                resetSnapping();
                resetThresholdTracking(j);
            }
            if (!isOppositeValueAfterScroll(f)) {
                this.thresholdHandler.updateTracking(j, f);
            }
            float fCalculateSnapThreshold = this.thresholdHandler.calculateSnapThreshold();
            if (!this.snapJob.isActive()) {
                this.rotaryScrollDistance += calculateProximityFactor(fCalculateSnapThreshold) * f;
            }
            this.accumulatedSnapDelta += f;
            setPreviousScrollEventTime(j);
            if (Math.abs(this.accumulatedSnapDelta) > fCalculateSnapThreshold) {
                resetScrolling();
                int i3 = (int) (this.accumulatedSnapDelta / fCalculateSnapThreshold);
                int i4 = this.maxSnapsPerEvent;
                int iCoerceIn = RangesKt.coerceIn(i3, new IntRange(-i4, i4));
                this.accumulatedSnapDelta -= fCalculateSnapThreshold * iCoerceIn;
                boolean zIsActive = this.snapJob.isActive();
                if (edgeNotReached(iCoerceIn)) {
                    this.rotaryHaptics.handleSnapHaptic(j, f);
                }
                this.snapHandler.updateSnapTarget(iCoerceIn, zIsActive);
                if (!this.snapJob.isActive()) {
                    Job.DefaultImpls.cancel$default(this.snapJob, (CancellationException) null, 1, (Object) null);
                    this.snapJob = BuildersKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new HighResSnapRotaryScrollableBehavior$performScroll$9$1(this, null), 3, (Object) null);
                }
                this.rotaryScrollDistance = 0.0f;
            } else if (!this.snapJob.isActive()) {
                this.scrollHandler.scrollToTarget(coroutineScope, this.rotaryScrollDistance / this.scrollDistanceDivider);
                long j2 = this.snapDelay;
                anonymousClass1.L$0 = this;
                anonymousClass1.L$1 = coroutineScope;
                anonymousClass1.label = 1;
                if (DelayKt.delay(j2, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        coroutineScope = (CoroutineScope) anonymousClass1.L$1;
        this = (HighResSnapRotaryScrollableBehavior) anonymousClass1.L$0;
        ResultKt.throwOnFailure(obj);
        this.resetScrolling();
        this.accumulatedSnapDelta = 0.0f;
        this.snapHandler.updateSnapTarget(0, false);
        Job.DefaultImpls.cancel$default(this.snapJob, (CancellationException) null, 1, (Object) null);
        this.snapJob = BuildersKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new HighResSnapRotaryScrollableBehavior$performScroll$11$1(this, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    private final float calculateProximityFactor(float snapThreshold) {
        return 1 - this.scrollProximityEasing.transform(Math.abs(this.rotaryScrollDistance) / snapThreshold);
    }

    private final boolean edgeNotReached(int snapDistanceInItems) {
        if (this.snapHandler.topEdgeReached() || snapDistanceInItems >= 0) {
            return !this.snapHandler.bottomEdgeReached() && snapDistanceInItems > 0;
        }
        return true;
    }

    private final void resetScrolling() {
        this.scrollHandler.cancelScrollIfActive();
        this.scrollHandler = (RotaryScrollHandler) this.scrollHandlerFactory.invoke();
        this.rotaryScrollDistance = 0.0f;
    }

    private final void resetSnapping() {
        Job.DefaultImpls.cancel$default(this.snapJob, (CancellationException) null, 1, (Object) null);
        this.snapHandler = (RotarySnapHandler) this.snapHandlerFactory.invoke();
        this.accumulatedSnapDelta = 0.0f;
    }

    private final void resetThresholdTracking(long time) {
        ThresholdHandler thresholdHandler = (ThresholdHandler) this.thresholdHandlerFactory.invoke();
        this.thresholdHandler = thresholdHandler;
        thresholdHandler.startThresholdTracking(time);
    }

    private final boolean isOppositeValueAfterScroll(float delta) {
        return this.rotaryScrollDistance * delta < 0.0f && Math.abs(delta) < Math.abs(this.rotaryScrollDistance);
    }
}
