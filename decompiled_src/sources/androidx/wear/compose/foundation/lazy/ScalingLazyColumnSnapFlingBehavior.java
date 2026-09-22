package androidx.wear.compose.foundation.lazy;

import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.window.core.layout.WindowSizeClass;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ScalingLazyColumnSnapFlingBehavior.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u001a\u0010\u0013\u001a\u00020\b*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u0016R\u000e\u0010\n\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Landroidx/wear/compose/foundation/lazy/ScalingLazyColumnSnapFlingBehavior;", "Landroidx/compose/foundation/gestures/FlingBehavior;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/wear/compose/foundation/lazy/ScalingLazyListState;", "snapOffset", "", "decay", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "(Landroidx/wear/compose/foundation/lazy/ScalingLazyListState;ILandroidx/compose/animation/core/DecayAnimationSpec;)V", "FINAL_SNAP_DURATION_MAX", "FINAL_SNAP_DURATION_MIN", "SNAP_SPEED_THRESHOLD", "getDecay", "()Landroidx/compose/animation/core/DecayAnimationSpec;", "getSnapOffset", "()I", "getState", "()Landroidx/wear/compose/foundation/lazy/ScalingLazyListState;", "performFling", "Landroidx/compose/foundation/gestures/ScrollScope;", "initialVelocity", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ScalingLazyColumnSnapFlingBehavior implements FlingBehavior {
    public static final int $stable = 0;
    private final float FINAL_SNAP_DURATION_MAX;
    private final float FINAL_SNAP_DURATION_MIN;
    private final int SNAP_SPEED_THRESHOLD;
    private final DecayAnimationSpec<Float> decay;
    private final int snapOffset;
    private final ScalingLazyListState state;

    /* JADX INFO: renamed from: androidx.wear.compose.foundation.lazy.ScalingLazyColumnSnapFlingBehavior$performFling$1, reason: invalid class name */
    /* JADX INFO: compiled from: ScalingLazyColumnSnapFlingBehavior.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.wear.compose.foundation.lazy.ScalingLazyColumnSnapFlingBehavior", f = "ScalingLazyColumnSnapFlingBehavior.kt", i = {0, 0, 0, 0, 0, 0}, l = {56, 120}, m = "performFling", n = {"this", "$this$performFling", "animationState", "lastValue", "endOfListReached", "decayTarget"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "F$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        float F$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ScalingLazyColumnSnapFlingBehavior.this.performFling(null, 0.0f, (Continuation) this);
        }
    }

    public ScalingLazyColumnSnapFlingBehavior(ScalingLazyListState scalingLazyListState, int i, DecayAnimationSpec<Float> decayAnimationSpec) {
        this.state = scalingLazyListState;
        this.snapOffset = i;
        this.decay = decayAnimationSpec;
        this.SNAP_SPEED_THRESHOLD = WindowSizeClass.WIDTH_DP_LARGE_LOWER_BOUND;
        this.FINAL_SNAP_DURATION_MIN = 0.1f;
        this.FINAL_SNAP_DURATION_MAX = 0.35f;
    }

    public final ScalingLazyListState getState() {
        return this.state;
    }

    public final int getSnapOffset() {
        return this.snapOffset;
    }

    public /* synthetic */ ScalingLazyColumnSnapFlingBehavior(ScalingLazyListState scalingLazyListState, int i, DecayAnimationSpec decayAnimationSpec, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(scalingLazyListState, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? DecayAnimationSpecKt.exponentialDecay$default(0.0f, 0.0f, 3, (Object) null) : decayAnimationSpec);
    }

    public final DecayAnimationSpec<Float> getDecay() {
        return this.decay;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:51:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:53:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:54:0x01db  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0213, code lost:
    
        if (androidx.compose.animation.core.SuspendAnimationKt.animateTo$default(r4, r5, r6, false, r0, r8, 4, (java.lang.Object) null) == r3) goto L57;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object performFling(androidx.compose.foundation.gestures.ScrollScope r26, float r27, kotlin.coroutines.Continuation<? super java.lang.Float> r28) {
        /*
            Method dump skipped, instruction units count: 539
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.wear.compose.foundation.lazy.ScalingLazyColumnSnapFlingBehavior.performFling(androidx.compose.foundation.gestures.ScrollScope, float, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
