package androidx.wear.compose.material;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.window.core.layout.WindowSizeClass;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: ScalingLazyColumnSnapFlingBehavior.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u001a\u0010\u0013\u001a\u00020\b*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u0016R\u000e\u0010\n\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Landroidx/wear/compose/material/ScalingLazyColumnSnapFlingBehavior;", "Landroidx/compose/foundation/gestures/FlingBehavior;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/wear/compose/material/ScalingLazyListState;", "snapOffset", "", "decay", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "(Landroidx/wear/compose/material/ScalingLazyListState;ILandroidx/compose/animation/core/DecayAnimationSpec;)V", "FINAL_SNAP_DURATION_MAX", "FINAL_SNAP_DURATION_MIN", "SNAP_SPEED_THRESHOLD", "getDecay", "()Landroidx/compose/animation/core/DecayAnimationSpec;", "getSnapOffset", "()I", "getState", "()Landroidx/wear/compose/material/ScalingLazyListState;", "performFling", "Landroidx/compose/foundation/gestures/ScrollScope;", "initialVelocity", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ScalingLazyColumnSnapFlingBehavior implements FlingBehavior {
    public static final int $stable = 0;
    private final float FINAL_SNAP_DURATION_MAX;
    private final float FINAL_SNAP_DURATION_MIN;
    private final int SNAP_SPEED_THRESHOLD;
    private final DecayAnimationSpec<Float> decay;
    private final int snapOffset;
    private final ScalingLazyListState state;

    /* JADX INFO: renamed from: androidx.wear.compose.material.ScalingLazyColumnSnapFlingBehavior$performFling$1, reason: invalid class name */
    /* JADX INFO: compiled from: ScalingLazyColumnSnapFlingBehavior.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.wear.compose.material.ScalingLazyColumnSnapFlingBehavior", f = "ScalingLazyColumnSnapFlingBehavior.kt", i = {0, 0, 0, 0, 0, 0, 1}, l = {57, 121}, m = "performFling", n = {"this", "$this$performFling", "animationState", "lastValue", "endOfListReached", "decayTarget", "animationState"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "F$0", "L$0"})
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

    /* JADX WARN: Code duplicated, block: B:49:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:51:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:52:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:56:0x0213  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    public Object performFling(ScrollScope scrollScope, float f, Continuation<? super Float> continuation) {
        AnonymousClass1 anonymousClass1;
        AnimationState animationStateAnimationState$default;
        final Ref.FloatRef floatRef;
        float f2;
        float centerItemScrollOffset;
        int i;
        AnimationState animationState;
        Ref.FloatRef floatRef2;
        Ref.BooleanRef booleanRef;
        float fFloatValue;
        float fSqrt;
        float f3;
        float f4;
        Float fBoxFloat;
        AnimationSpec animationSpecTween$default;
        Function1<AnimationScope<Float, AnimationVector1D>, Unit> function1;
        AnimationState animationState2;
        Object obj;
        final ScalingLazyColumnSnapFlingBehavior scalingLazyColumnSnapFlingBehavior = this;
        final ScrollScope scrollScope2 = scrollScope;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = scalingLazyColumnSnapFlingBehavior.new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = scalingLazyColumnSnapFlingBehavior.new AnonymousClass1(continuation);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object obj2 = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass2.label;
        float f5 = 0.0f;
        float f6 = 1.0f;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            animationStateAnimationState$default = AnimationStateKt.AnimationState$default(0.0f, f, 0L, 0L, false, 28, (Object) null);
            floatRef = new Ref.FloatRef();
            List<ScalingLazyListItemInfo> visibleItemsInfo = scalingLazyColumnSnapFlingBehavior.state.getLayoutInfo().getVisibleItemsInfo();
            if (Math.abs(f) > 1.0f && visibleItemsInfo.size() > 1) {
                float fCalculateTargetValue = DecayAnimationSpecKt.calculateTargetValue(scalingLazyColumnSnapFlingBehavior.decay, 0.0f, f);
                final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
                DecayAnimationSpec<Float> decayAnimationSpec = scalingLazyColumnSnapFlingBehavior.decay;
                Function1<AnimationScope<Float, AnimationVector1D>, Unit> function2 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnSnapFlingBehavior$performFling$finalTarget$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                        invoke((AnimationScope<Float, AnimationVector1D>) obj3);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                        float fFloatValue2 = ((Number) animationScope.getValue()).floatValue() - floatRef.element;
                        float fScrollBy = scrollScope2.scrollBy(fFloatValue2);
                        floatRef.element = ((Number) animationScope.getValue()).floatValue();
                        if (Math.abs(((Number) animationScope.getVelocity()).floatValue()) < scalingLazyColumnSnapFlingBehavior.SNAP_SPEED_THRESHOLD) {
                            animationScope.cancelAnimation();
                        }
                        if (Math.abs(fFloatValue2 - fScrollBy) > 0.1f) {
                            booleanRef2.element = true;
                            animationScope.cancelAnimation();
                        }
                    }
                };
                anonymousClass2.L$0 = scalingLazyColumnSnapFlingBehavior;
                anonymousClass2.L$1 = scrollScope2;
                anonymousClass2.L$2 = animationStateAnimationState$default;
                anonymousClass2.L$3 = floatRef;
                anonymousClass2.L$4 = booleanRef2;
                anonymousClass2.F$0 = fCalculateTargetValue;
                anonymousClass2.label = 1;
                centerItemScrollOffset = fCalculateTargetValue;
                i = 1;
                if (SuspendAnimationKt.animateDecay$default(animationStateAnimationState$default, decayAnimationSpec, false, function2, anonymousClass2, 2, (Object) null) != coroutine_suspended) {
                    animationState = animationStateAnimationState$default;
                    floatRef2 = floatRef;
                    booleanRef = booleanRef2;
                }
            } else {
                f5 = 0.0f;
                f2 = 1.0f;
                centerItemScrollOffset = scalingLazyColumnSnapFlingBehavior.snapOffset - scalingLazyColumnSnapFlingBehavior.state.getCenterItemScrollOffset();
                fFloatValue = centerItemScrollOffset - ((Number) animationStateAnimationState$default.getValue()).floatValue();
                if (fFloatValue != f5) {
                    float fFloatValue2 = ((Number) animationStateAnimationState$default.getVelocity()).floatValue();
                    float fLerp = MathHelpersKt.lerp(scalingLazyColumnSnapFlingBehavior.FINAL_SNAP_DURATION_MIN, scalingLazyColumnSnapFlingBehavior.FINAL_SNAP_DURATION_MAX, Math.abs(fFloatValue2) / scalingLazyColumnSnapFlingBehavior.SNAP_SPEED_THRESHOLD);
                    float f7 = (fFloatValue2 * fLerp) / fFloatValue;
                    fSqrt = 0.5f / ((float) Math.sqrt((f7 * f7) + f2));
                    f3 = f7 * fSqrt;
                    if (fSqrt > f3) {
                        f4 = 0.8f;
                    } else {
                        f4 = f2;
                    }
                    fBoxFloat = Boxing.boxFloat(centerItemScrollOffset);
                    animationSpecTween$default = AnimationSpecKt.tween$default(MathKt.roundToInt(fLerp * 1000), 0, new CubicBezierEasing(fSqrt, f3, 0.8f, f4), 2, (Object) null);
                    function1 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnSnapFlingBehavior.performFling.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                            invoke((AnimationScope<Float, AnimationVector1D>) obj3);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                            scrollScope2.scrollBy(((Number) animationScope.getValue()).floatValue() - floatRef.element);
                            floatRef.element = ((Number) animationScope.getValue()).floatValue();
                        }
                    };
                    anonymousClass2.L$0 = animationStateAnimationState$default;
                    anonymousClass2.L$1 = null;
                    anonymousClass2.L$2 = null;
                    anonymousClass2.L$3 = null;
                    anonymousClass2.L$4 = null;
                    anonymousClass2.label = 2;
                    if (SuspendAnimationKt.animateTo$default(animationStateAnimationState$default, fBoxFloat, animationSpecTween$default, false, function1, anonymousClass2, 4, (Object) null) != coroutine_suspended) {
                        animationState2 = animationStateAnimationState$default;
                        animationStateAnimationState$default = animationState2;
                    }
                }
                return animationStateAnimationState$default.getVelocity();
            }
            return coroutine_suspended;
        }
        if (i2 == 1) {
            float f8 = anonymousClass2.F$0;
            Ref.BooleanRef booleanRef3 = (Ref.BooleanRef) anonymousClass2.L$4;
            floatRef2 = (Ref.FloatRef) anonymousClass2.L$3;
            animationState = (AnimationState) anonymousClass2.L$2;
            ScrollScope scrollScope3 = (ScrollScope) anonymousClass2.L$1;
            ScalingLazyColumnSnapFlingBehavior scalingLazyColumnSnapFlingBehavior2 = (ScalingLazyColumnSnapFlingBehavior) anonymousClass2.L$0;
            ResultKt.throwOnFailure(obj2);
            centerItemScrollOffset = f8;
            booleanRef = booleanRef3;
            scrollScope2 = scrollScope3;
            scalingLazyColumnSnapFlingBehavior = scalingLazyColumnSnapFlingBehavior2;
            i = 1;
        } else {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            animationState2 = (AnimationState) anonymousClass2.L$0;
            ResultKt.throwOnFailure(obj2);
        }
        animationStateAnimationState$default = animationState2;
        return animationStateAnimationState$default.getVelocity();
        if (booleanRef.element) {
            scrollScope2.scrollBy(scalingLazyColumnSnapFlingBehavior.snapOffset - scalingLazyColumnSnapFlingBehavior.state.getCenterItemScrollOffset());
            return animationState.getVelocity();
        }
        List<ScalingLazyListItemInfo> visibleItemsInfo2 = scalingLazyColumnSnapFlingBehavior.state.getLayoutInfo().getVisibleItemsInfo();
        ArrayList arrayList = new ArrayList(visibleItemsInfo2.size());
        int size = visibleItemsInfo2.size();
        int i3 = 0;
        while (i3 < size) {
            arrayList.add(Boxing.boxFloat(((Number) animationState.getValue()).floatValue() + visibleItemsInfo2.get(i3).getUnadjustedOffset() + scalingLazyColumnSnapFlingBehavior.snapOffset));
            i3++;
            f6 = f6;
        }
        f2 = f6;
        ArrayList arrayList2 = arrayList;
        if (!arrayList2.isEmpty()) {
            obj = arrayList2.get(0);
            float fAbs = Math.abs(((Number) obj).floatValue() - centerItemScrollOffset);
            int lastIndex = CollectionsKt.getLastIndex(arrayList2);
            if (i <= lastIndex) {
                while (true) {
                    Object obj3 = arrayList2.get(i);
                    float fAbs2 = Math.abs(((Number) obj3).floatValue() - centerItemScrollOffset);
                    if (Float.compare(fAbs, fAbs2) > 0) {
                        obj = obj3;
                        fAbs = fAbs2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
        } else {
            obj = null;
        }
        Float f9 = (Float) obj;
        if (f9 != null) {
            centerItemScrollOffset = f9.floatValue();
        }
        floatRef = floatRef2;
        animationStateAnimationState$default = animationState;
        fFloatValue = centerItemScrollOffset - ((Number) animationStateAnimationState$default.getValue()).floatValue();
        if (fFloatValue != f5) {
            float fFloatValue3 = ((Number) animationStateAnimationState$default.getVelocity()).floatValue();
            float fLerp2 = MathHelpersKt.lerp(scalingLazyColumnSnapFlingBehavior.FINAL_SNAP_DURATION_MIN, scalingLazyColumnSnapFlingBehavior.FINAL_SNAP_DURATION_MAX, Math.abs(fFloatValue3) / scalingLazyColumnSnapFlingBehavior.SNAP_SPEED_THRESHOLD);
            float f10 = (fFloatValue3 * fLerp2) / fFloatValue;
            fSqrt = 0.5f / ((float) Math.sqrt((f10 * f10) + f2));
            f3 = f10 * fSqrt;
            if (fSqrt > f3) {
                f4 = 0.8f;
            } else {
                f4 = f2;
            }
            fBoxFloat = Boxing.boxFloat(centerItemScrollOffset);
            animationSpecTween$default = AnimationSpecKt.tween$default(MathKt.roundToInt(fLerp2 * 1000), 0, new CubicBezierEasing(fSqrt, f3, 0.8f, f4), 2, (Object) null);
            function1 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.wear.compose.material.ScalingLazyColumnSnapFlingBehavior.performFling.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj4) {
                    invoke((AnimationScope<Float, AnimationVector1D>) obj4);
                    return Unit.INSTANCE;
                }

                public final void invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                    scrollScope2.scrollBy(((Number) animationScope.getValue()).floatValue() - floatRef.element);
                    floatRef.element = ((Number) animationScope.getValue()).floatValue();
                }
            };
            anonymousClass2.L$0 = animationStateAnimationState$default;
            anonymousClass2.L$1 = null;
            anonymousClass2.L$2 = null;
            anonymousClass2.L$3 = null;
            anonymousClass2.L$4 = null;
            anonymousClass2.label = 2;
            if (SuspendAnimationKt.animateTo$default(animationStateAnimationState$default, fBoxFloat, animationSpecTween$default, false, function1, anonymousClass2, 4, (Object) null) != coroutine_suspended) {
                animationState2 = animationStateAnimationState$default;
                animationStateAnimationState$default = animationState2;
            }
            return coroutine_suspended;
        }
        return animationStateAnimationState$default.getVelocity();
    }
}
