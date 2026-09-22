package androidx.wear.compose.foundation.rotary;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: RotaryScrollable.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0013\u001a\u00020\u0010J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J\u000e\u0010\u0017\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010\u0019J\u000e\u0010\u001a\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010\u0019J\u0006\u0010\u001b\u001a\u00020\u0010J\u0016\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/wear/compose/foundation/rotary/RotarySnapHandler;", "", "scrollableState", "Landroidx/compose/foundation/gestures/ScrollableState;", "layoutInfoProvider", "Landroidx/wear/compose/foundation/rotary/RotarySnapLayoutInfoProvider;", "snapOffset", "", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/wear/compose/foundation/rotary/RotarySnapLayoutInfoProvider;I)V", "anim", "Landroidx/compose/animation/core/AnimationState;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "defaultStiffness", "expectedDistance", "sequentialSnap", "", "snapTarget", "snapTargetUpdated", "bottomEdgeReached", "expectedDistanceTo", "index", "targetScrollOffset", "snapToClosestItem", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapToTargetItem", "topEdgeReached", "updateSnapTarget", "moveForElements", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RotarySnapHandler {
    public static final int $stable = 8;
    private float expectedDistance;
    private final RotarySnapLayoutInfoProvider layoutInfoProvider;
    private final ScrollableState scrollableState;
    private boolean sequentialSnap;
    private final int snapOffset;
    private int snapTarget;
    private AnimationState<Float, AnimationVector1D> anim = AnimationStateKt.AnimationState$default(0.0f, 0.0f, 0, 0, false, 30, (Object) null);
    private final float defaultStiffness = 200.0f;
    private boolean snapTargetUpdated = true;

    public RotarySnapHandler(ScrollableState scrollableState, RotarySnapLayoutInfoProvider rotarySnapLayoutInfoProvider, int i) {
        this.scrollableState = scrollableState;
        this.layoutInfoProvider = rotarySnapLayoutInfoProvider;
        this.snapOffset = i;
        this.snapTarget = rotarySnapLayoutInfoProvider.getCurrentItemIndex();
    }

    public final void updateSnapTarget(int moveForElements, boolean sequentialSnap) {
        this.sequentialSnap = sequentialSnap;
        if (sequentialSnap) {
            this.snapTarget += moveForElements;
        } else {
            this.snapTarget = this.layoutInfoProvider.getCurrentItemIndex() + moveForElements;
        }
        this.snapTargetUpdated = true;
        this.snapTarget = RangesKt.coerceIn(this.snapTarget, RangesKt.until(0, this.layoutInfoProvider.getTotalItemCount()));
    }

    /* JADX INFO: renamed from: androidx.wear.compose.foundation.rotary.RotarySnapHandler$snapToClosestItem$2, reason: invalid class name */
    /* JADX INFO: compiled from: RotaryScrollable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.wear.compose.foundation.rotary.RotarySnapHandler$snapToClosestItem$2", f = "RotaryScrollable.kt", i = {}, l = {547}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass2 = RotarySnapHandler.this.new AnonymousClass2(continuation);
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
                final Ref.FloatRef floatRef = new Ref.FloatRef();
                this.label = 1;
                if (SuspendAnimationKt.animateTo$default(AnimationStateKt.AnimationState$default(0.0f, 0.0f, 0L, 0L, false, 30, (Object) null), Boxing.boxFloat(-RotarySnapHandler.this.layoutInfoProvider.getCurrentItemOffset()), AnimationSpecKt.tween$default(100, 0, EasingKt.getFastOutSlowInEasing(), 2, (Object) null), false, new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.wear.compose.foundation.rotary.RotarySnapHandler.snapToClosestItem.2.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke((AnimationScope<Float, AnimationVector1D>) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                        scrollScope.scrollBy(((Number) animationScope.getValue()).floatValue() - floatRef.element);
                        floatRef.element = ((Number) animationScope.getValue()).floatValue();
                    }
                }, (Continuation) this, 4, (Object) null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            RotarySnapHandler rotarySnapHandler = RotarySnapHandler.this;
            rotarySnapHandler.snapTarget = rotarySnapHandler.layoutInfoProvider.getCurrentItemIndex();
            return Unit.INSTANCE;
        }
    }

    public final Object snapToClosestItem(Continuation<? super Unit> continuation) {
        Object objScroll = this.scrollableState.scroll(MutatePriority.UserInput, new AnonymousClass2(null), continuation);
        return objScroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScroll : Unit.INSTANCE;
    }

    public final boolean topEdgeReached() {
        return this.snapTarget <= 0;
    }

    public final boolean bottomEdgeReached() {
        return this.snapTarget >= this.layoutInfoProvider.getTotalItemCount() - 1;
    }

    public final Object snapToTargetItem(Continuation<? super Unit> continuation) {
        if (!this.sequentialSnap) {
            this.anim = AnimationStateKt.AnimationState$default(0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
        }
        Object objScroll = this.scrollableState.scroll(MutatePriority.UserInput, new C01192(null), continuation);
        return objScroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScroll : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.wear.compose.foundation.rotary.RotarySnapHandler$snapToTargetItem$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RotaryScrollable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.wear.compose.foundation.rotary.RotarySnapHandler$snapToTargetItem$2", f = "RotaryScrollable.kt", i = {0, 0, 0, 1}, l = {598, 645}, m = "invokeSuspend", n = {"$this$scroll", "latestCenterItem", "continueFirstScroll", "$this$scroll"}, s = {"L$0", "L$1", "L$2", "L$0"})
    static final class C01192 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        C01192(Continuation<? super C01192> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c01192 = RotarySnapHandler.this.new C01192(continuation);
            c01192.L$0 = obj;
            return c01192;
        }

        public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
            return create(scrollScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0043  */
        /* JADX WARN: Code duplicated, block: B:16:0x0060  */
        /* JADX WARN: Code duplicated, block: B:18:0x00d1  */
        /* JADX WARN: Code duplicated, block: B:19:0x00d3  */
        /* JADX WARN: Code duplicated, block: B:25:0x00fd  */
        /* JADX WARN: Code duplicated, block: B:27:0x0151  */
        /* JADX WARN: Code duplicated, block: B:28:0x0153  */
        /* JADX WARN: Code duplicated, block: B:32:0x0174  */
        /* JADX WARN: Code duplicated, block: B:36:0x0173 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:39:? A[LOOP:0: B:14:0x0057->B:39:?, LOOP_END, SYNTHETIC] */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:16:0x0060
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) {
            /*
                Method dump skipped, instruction units count: 378
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.wear.compose.foundation.rotary.RotarySnapHandler.C01192.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float expectedDistanceTo(int index, int targetScrollOffset) {
        return ((this.layoutInfoProvider.getAverageItemSize() * (index - this.layoutInfoProvider.getCurrentItemIndex())) + targetScrollOffset) - this.layoutInfoProvider.getCurrentItemOffset();
    }
}
