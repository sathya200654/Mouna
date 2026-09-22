package androidx.wear.compose.foundation.rotary;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.MutatePriority;
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
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: RotaryScrollable.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/wear/compose/foundation/rotary/RotaryScrollHandler;", "", "scrollableState", "Landroidx/compose/foundation/gestures/ScrollableState;", "(Landroidx/compose/foundation/gestures/ScrollableState;)V", "prevPosition", "", "scrollAnimation", "Landroidx/compose/animation/core/AnimationState;", "Landroidx/compose/animation/core/AnimationVector1D;", "scrollJob", "Lkotlinx/coroutines/Job;", "sequentialAnimation", "", "cancelScrollIfActive", "", "scrollTo", "targetValue", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollToTarget", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RotaryScrollHandler {
    public static final int $stable = 8;
    private float prevPosition;
    private AnimationState<Float, AnimationVector1D> scrollAnimation = AnimationStateKt.AnimationState$default(0.0f, 0.0f, 0, 0, false, 30, (Object) null);
    private Job scrollJob = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
    private final ScrollableState scrollableState;
    private boolean sequentialAnimation;

    public RotaryScrollHandler(ScrollableState scrollableState) {
        this.scrollableState = scrollableState;
    }

    public final void scrollToTarget(CoroutineScope coroutineScope, float targetValue) {
        cancelScrollIfActive();
        this.scrollJob = BuildersKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(targetValue, null), 3, (Object) null);
    }

    /* JADX INFO: renamed from: androidx.wear.compose.foundation.rotary.RotaryScrollHandler$scrollToTarget$1, reason: invalid class name */
    /* JADX INFO: compiled from: RotaryScrollable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.wear.compose.foundation.rotary.RotaryScrollHandler$scrollToTarget$1", f = "RotaryScrollable.kt", i = {}, l = {470}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $targetValue;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(float f, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$targetValue = f;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RotaryScrollHandler.this.new AnonymousClass1(this.$targetValue, continuation);
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
                if (RotaryScrollHandler.this.scrollTo(this.$targetValue, (Continuation) this) == coroutine_suspended) {
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

    public final void cancelScrollIfActive() {
        if (this.scrollJob.isActive()) {
            Job.DefaultImpls.cancel$default(this.scrollJob, (CancellationException) null, 1, (Object) null);
        }
    }

    /* JADX INFO: renamed from: androidx.wear.compose.foundation.rotary.RotaryScrollHandler$scrollTo$2, reason: invalid class name */
    /* JADX INFO: compiled from: RotaryScrollable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.wear.compose.foundation.rotary.RotaryScrollHandler$scrollTo$2", f = "RotaryScrollable.kt", i = {}, l = {482}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $targetValue;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(float f, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$targetValue = f;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass2 = RotaryScrollHandler.this.new AnonymousClass2(this.$targetValue, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
            return create(scrollScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final ScrollScope scrollScope = (ScrollScope) this.L$0;
                AnimationState animationState = RotaryScrollHandler.this.scrollAnimation;
                Float fBoxFloat = Boxing.boxFloat(this.$targetValue);
                AnimationSpec animationSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null);
                boolean z = RotaryScrollHandler.this.sequentialAnimation;
                final RotaryScrollHandler rotaryScrollHandler = RotaryScrollHandler.this;
                this.label = 1;
                if (SuspendAnimationKt.animateTo(animationState, fBoxFloat, animationSpecSpring$default, z, new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.wear.compose.foundation.rotary.RotaryScrollHandler.scrollTo.2.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke((AnimationScope<Float, AnimationVector1D>) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                        scrollScope.scrollBy(((Number) animationScope.getValue()).floatValue() - rotaryScrollHandler.prevPosition);
                        rotaryScrollHandler.prevPosition = ((Number) animationScope.getValue()).floatValue();
                        rotaryScrollHandler.sequentialAnimation = !(((Number) animationScope.getValue()).floatValue() == ((Number) animationScope.getTargetValue()).floatValue());
                    }
                }, (Continuation) this) == coroutine_suspended) {
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
    public final Object scrollTo(float f, Continuation<? super Unit> continuation) {
        Object objScroll = this.scrollableState.scroll(MutatePriority.UserInput, new AnonymousClass2(f, null), continuation);
        return objScroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScroll : Unit.INSTANCE;
    }
}
