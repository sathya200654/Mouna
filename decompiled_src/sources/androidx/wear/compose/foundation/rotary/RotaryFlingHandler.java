package androidx.wear.compose.foundation.rotary;

import android.view.ViewConfiguration;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: RotaryScrollable.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u000eJ?\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00190!2!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00190#J\u000e\u0010'\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\tJ?\u0010(\u001a\u00020\u00192\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00190!2!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00190#H\u0082@¢\u0006\u0002\u0010)R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Landroidx/wear/compose/foundation/rotary/RotaryFlingHandler;", "", "scrollableState", "Landroidx/compose/foundation/gestures/ScrollableState;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "viewConfiguration", "Landroid/view/ViewConfiguration;", "flingTimeframe", "", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/gestures/FlingBehavior;Landroid/view/ViewConfiguration;J)V", "flingJob", "Lkotlinx/coroutines/Job;", "flingScaleFactor", "", "flingTimestamp", "flingVelocity", "latestEventTimestamp", "maxFlingSpeed", "minFlingSpeed", "previousVelocity", "rotaryVelocityTracker", "Landroidx/wear/compose/foundation/rotary/RotaryVelocityTracker;", "timeRangeToFling", "cancelFlingIfActive", "", "observeEvent", "timestamp", "delta", "performFlingIfRequired", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "beforeFling", "Lkotlin/Function0;", "edgeReached", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "velocity", "startFlingTracking", "trackFling", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RotaryFlingHandler {
    public static final int $stable = 8;
    private final FlingBehavior flingBehavior;
    private final long flingTimeframe;
    private long flingTimestamp;
    private float flingVelocity;
    private long latestEventTimestamp;
    private final float maxFlingSpeed;
    private final float minFlingSpeed;
    private float previousVelocity;
    private final ScrollableState scrollableState;
    private final long timeRangeToFling;
    private Job flingJob = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
    private final float flingScaleFactor = 0.7f;
    private final RotaryVelocityTracker rotaryVelocityTracker = new RotaryVelocityTracker();

    /* JADX INFO: renamed from: androidx.wear.compose.foundation.rotary.RotaryFlingHandler$trackFling$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RotaryScrollable.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.wear.compose.foundation.rotary.RotaryFlingHandler", f = "RotaryScrollable.kt", i = {0, 0, 0}, l = {777, 794}, m = "trackFling", n = {"this", "beforeFling", "edgeReached"}, s = {"L$0", "L$1", "L$2"})
    static final class C01161 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C01161(Continuation<? super C01161> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RotaryFlingHandler.this.trackFling(null, null, (Continuation) this);
        }
    }

    public RotaryFlingHandler(ScrollableState scrollableState, FlingBehavior flingBehavior, ViewConfiguration viewConfiguration, long j) {
        this.scrollableState = scrollableState;
        this.flingBehavior = flingBehavior;
        this.flingTimeframe = j;
        this.timeRangeToFling = j * ((long) 2);
        this.minFlingSpeed = viewConfiguration.getScaledMinimumFlingVelocity();
        this.maxFlingSpeed = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    public final void startFlingTracking(long timestamp) {
        this.rotaryVelocityTracker.start(timestamp);
        this.latestEventTimestamp = timestamp;
        this.previousVelocity = 0.0f;
    }

    public final void cancelFlingIfActive() {
        if (this.flingJob.isActive()) {
            Job.DefaultImpls.cancel$default(this.flingJob, (CancellationException) null, 1, (Object) null);
        }
    }

    public final void observeEvent(long timestamp, float delta) {
        this.rotaryVelocityTracker.move(timestamp, delta);
        this.latestEventTimestamp = timestamp;
    }

    public final void performFlingIfRequired(CoroutineScope coroutineScope, Function0<Unit> beforeFling, Function1<? super Float, Unit> edgeReached) {
        cancelFlingIfActive();
        this.flingJob = BuildersKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(beforeFling, edgeReached, null), 3, (Object) null);
    }

    /* JADX INFO: renamed from: androidx.wear.compose.foundation.rotary.RotaryFlingHandler$performFlingIfRequired$1, reason: invalid class name */
    /* JADX INFO: compiled from: RotaryScrollable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.wear.compose.foundation.rotary.RotaryFlingHandler$performFlingIfRequired$1", f = "RotaryScrollable.kt", i = {}, l = {755}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $beforeFling;
        final /* synthetic */ Function1<Float, Unit> $edgeReached;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function0<Unit> function0, Function1<? super Float, Unit> function1, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$beforeFling = function0;
            this.$edgeReached = function1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RotaryFlingHandler.this.new AnonymousClass1(this.$beforeFling, this.$edgeReached, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (RotaryFlingHandler.this.trackFling(this.$beforeFling, this.$edgeReached, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b6, code lost:
    
        if (r11.scroll(r2, r4, r0) == r1) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object trackFling(kotlin.jvm.functions.Function0<kotlin.Unit> r9, kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof androidx.wear.compose.foundation.rotary.RotaryFlingHandler.C01161
            if (r0 == 0) goto L14
            r0 = r11
            androidx.wear.compose.foundation.rotary.RotaryFlingHandler$trackFling$1 r0 = (androidx.wear.compose.foundation.rotary.RotaryFlingHandler.C01161) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            androidx.wear.compose.foundation.rotary.RotaryFlingHandler$trackFling$1 r0 = new androidx.wear.compose.foundation.rotary.RotaryFlingHandler$trackFling$1
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L48
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            kotlin.ResultKt.throwOnFailure(r11)
            goto Lb9
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            java.lang.Object r8 = r0.L$2
            r10 = r8
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            java.lang.Object r8 = r0.L$1
            r9 = r8
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            java.lang.Object r8 = r0.L$0
            androidx.wear.compose.foundation.rotary.RotaryFlingHandler r8 = (androidx.wear.compose.foundation.rotary.RotaryFlingHandler) r8
            kotlin.ResultKt.throwOnFailure(r11)
            goto L7b
        L48:
            kotlin.ResultKt.throwOnFailure(r11)
            androidx.wear.compose.foundation.rotary.RotaryVelocityTracker r11 = r8.rotaryVelocityTracker
            float r11 = r11.getVelocity()
            float r2 = java.lang.Math.abs(r11)
            float r5 = r8.previousVelocity
            float r5 = java.lang.Math.abs(r5)
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 < 0) goto L68
            long r5 = r8.latestEventTimestamp
            r8.flingTimestamp = r5
            float r2 = r8.flingScaleFactor
            float r2 = r2 * r11
            r8.flingVelocity = r2
        L68:
            r8.previousVelocity = r11
            long r5 = r8.flingTimeframe
            r0.L$0 = r8
            r0.L$1 = r9
            r0.L$2 = r10
            r0.label = r4
            java.lang.Object r11 = kotlinx.coroutines.DelayKt.delay(r5, r0)
            if (r11 != r1) goto L7b
            goto Lb8
        L7b:
            long r4 = r8.latestEventTimestamp
            long r6 = r8.flingTimestamp
            long r4 = r4 - r6
            long r6 = r8.timeRangeToFling
            int r11 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r11 >= 0) goto Lbc
            float r11 = r8.flingVelocity
            float r11 = java.lang.Math.abs(r11)
            float r2 = r8.minFlingSpeed
            int r11 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r11 <= 0) goto Lbc
            r9.invoke()
            float r9 = r8.flingVelocity
            float r11 = r8.maxFlingSpeed
            float r2 = -r11
            float r9 = kotlin.ranges.RangesKt.coerceIn(r9, r2, r11)
            androidx.compose.foundation.gestures.ScrollableState r11 = r8.scrollableState
            androidx.compose.foundation.MutatePriority r2 = androidx.compose.foundation.MutatePriority.UserInput
            androidx.wear.compose.foundation.rotary.RotaryFlingHandler$trackFling$4 r4 = new androidx.wear.compose.foundation.rotary.RotaryFlingHandler$trackFling$4
            r5 = 0
            r4.<init>(r9, r10, r5)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r0.L$0 = r5
            r0.L$1 = r5
            r0.L$2 = r5
            r0.label = r3
            java.lang.Object r8 = r11.scroll(r2, r4, r0)
            if (r8 != r1) goto Lb9
        Lb8:
            return r1
        Lb9:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        Lbc:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.wear.compose.foundation.rotary.RotaryFlingHandler.trackFling(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: androidx.wear.compose.foundation.rotary.RotaryFlingHandler$trackFling$4, reason: invalid class name */
    /* JADX INFO: compiled from: RotaryScrollable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.wear.compose.foundation.rotary.RotaryFlingHandler$trackFling$4", f = "RotaryScrollable.kt", i = {}, l = {797}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Float, Unit> $edgeReached;
        final /* synthetic */ float $velocity;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass4(float f, Function1<? super Float, Unit> function1, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$velocity = f;
            this.$edgeReached = function1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass4 = RotaryFlingHandler.this.new AnonymousClass4(this.$velocity, this.$edgeReached, continuation);
            anonymousClass4.L$0 = obj;
            return anonymousClass4;
        }

        public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
            return create(scrollScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Function1<Float, Unit> function1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ScrollScope scrollScope = (ScrollScope) this.L$0;
                FlingBehavior flingBehavior = RotaryFlingHandler.this.flingBehavior;
                float f = this.$velocity;
                Function1<Float, Unit> function2 = this.$edgeReached;
                this.L$0 = function2;
                this.label = 1;
                obj = flingBehavior.performFling(scrollScope, f, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                function1 = function2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                function1 = (Function1) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            float fFloatValue = ((Number) obj).floatValue();
            if (fFloatValue != 0.0f) {
                function1.invoke(Boxing.boxFloat(fFloatValue));
            }
            return Unit.INSTANCE;
        }
    }
}
