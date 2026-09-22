package androidx.wear.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SnapSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: PositionIndicator.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.wear.compose.material.PositionIndicatorKt$PositionIndicator$12$1", f = "PositionIndicator.kt", i = {}, l = {843}, m = "invokeSuspend", n = {}, s = {})
final class PositionIndicatorKt$PositionIndicator$12$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableFloatState $alphaValue;
    final /* synthetic */ Channel<Float> $animateAlphaChannel;
    final /* synthetic */ MutableFloatState $highlightAlpha$delegate;
    final /* synthetic */ Channel<Boolean> $highlightChannel;
    final /* synthetic */ AnimationSpec<Float> $positionAnimationSpec;
    final /* synthetic */ boolean $shouldShowHighlight;
    final /* synthetic */ State<AnimationSpec<Float>> $updatedFadeInAnimationSpec$delegate;
    final /* synthetic */ State<AnimationSpec<Float>> $updatedFadeOutAnimationSpec$delegate;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PositionIndicatorKt$PositionIndicator$12$1(boolean z, AnimationSpec<Float> animationSpec, Channel<Float> channel, Channel<Boolean> channel2, MutableFloatState mutableFloatState, MutableFloatState mutableFloatState2, State<? extends AnimationSpec<Float>> state, State<? extends AnimationSpec<Float>> state2, Continuation<? super PositionIndicatorKt$PositionIndicator$12$1> continuation) {
        super(2, continuation);
        this.$shouldShowHighlight = z;
        this.$positionAnimationSpec = animationSpec;
        this.$animateAlphaChannel = channel;
        this.$highlightChannel = channel2;
        this.$highlightAlpha$delegate = mutableFloatState;
        this.$alphaValue = mutableFloatState2;
        this.$updatedFadeInAnimationSpec$delegate = state;
        this.$updatedFadeOutAnimationSpec$delegate = state2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> positionIndicatorKt$PositionIndicator$12$1 = new PositionIndicatorKt$PositionIndicator$12$1(this.$shouldShowHighlight, this.$positionAnimationSpec, this.$animateAlphaChannel, this.$highlightChannel, this.$highlightAlpha$delegate, this.$alphaValue, this.$updatedFadeInAnimationSpec$delegate, this.$updatedFadeOutAnimationSpec$delegate, continuation);
        positionIndicatorKt$PositionIndicator$12$1.L$0 = obj;
        return positionIndicatorKt$PositionIndicator$12$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            if (this.$shouldShowHighlight && !(this.$positionAnimationSpec instanceof SnapSpec)) {
                BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this.$highlightChannel, this.$highlightAlpha$delegate, null), 3, (Object) null);
            }
            this.label = 1;
            if (FlowKt.collectLatest(FlowKt.distinctUntilChanged(FlowKt.receiveAsFlow(this.$animateAlphaChannel)), new AnonymousClass2(this.$alphaValue, this.$updatedFadeInAnimationSpec$delegate, this.$updatedFadeOutAnimationSpec$delegate, null), (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: androidx.wear.compose.material.PositionIndicatorKt$PositionIndicator$12$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: PositionIndicator.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.wear.compose.material.PositionIndicatorKt$PositionIndicator$12$1$1", f = "PositionIndicator.kt", i = {}, l = {810}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableFloatState $highlightAlpha$delegate;
        final /* synthetic */ Channel<Boolean> $highlightChannel;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Channel<Boolean> channel, MutableFloatState mutableFloatState, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$highlightChannel = channel;
            this.$highlightAlpha$delegate = mutableFloatState;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$highlightChannel, this.$highlightAlpha$delegate, continuation);
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
                if (FlowKt.collectLatest(FlowKt.distinctUntilChanged(FlowKt.receiveAsFlow(this.$highlightChannel)), new C00201(this.$highlightAlpha$delegate, null), (Continuation) this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: androidx.wear.compose.material.PositionIndicatorKt$PositionIndicator$12$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: PositionIndicator.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "showHighlight", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.wear.compose.material.PositionIndicatorKt$PositionIndicator$12$1$1$1", f = "PositionIndicator.kt", i = {}, l = {812, 823}, m = "invokeSuspend", n = {}, s = {})
        static final class C00201 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
            final /* synthetic */ MutableFloatState $highlightAlpha$delegate;
            /* synthetic */ boolean Z$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00201(MutableFloatState mutableFloatState, Continuation<? super C00201> continuation) {
                super(2, continuation);
                this.$highlightAlpha$delegate = mutableFloatState;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c00201 = new C00201(this.$highlightAlpha$delegate, continuation);
                c00201.Z$0 = ((Boolean) obj).booleanValue();
                return c00201;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke(((Boolean) obj).booleanValue(), (Continuation<? super Unit>) obj2);
            }

            public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
                return create(Boolean.valueOf(z), continuation).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x005c, code lost:
            
                if (androidx.compose.animation.core.SuspendAnimationKt.animate$default(r9, 0.33f, 0.0f, r12, new androidx.wear.compose.material.PositionIndicatorKt$PositionIndicator$12$1.AnonymousClass1.C00201.C00211(), (kotlin.coroutines.Continuation) r17, 4, (java.lang.Object) null) == r1) goto L17;
             */
            /* JADX WARN: Code restructure failed: missing block: B:16:0x0091, code lost:
            
                if (androidx.compose.animation.core.SuspendAnimationKt.animate$default(r9, 0.0f, 0.0f, r12, new androidx.wear.compose.material.PositionIndicatorKt$PositionIndicator$12$1.AnonymousClass1.C00201.AnonymousClass2(), (kotlin.coroutines.Continuation) r17, 4, (java.lang.Object) null) == r1) goto L17;
             */
            /* JADX WARN: Code restructure failed: missing block: B:17:0x0093, code lost:
            
                return r1;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r18) {
                /*
                    r17 = this;
                    r0 = r17
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.label
                    r3 = 1
                    r4 = 2
                    if (r2 == 0) goto L1d
                    if (r2 == r3) goto L19
                    if (r2 != r4) goto L11
                    goto L19
                L11:
                    java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                    java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                    r0.<init>(r1)
                    throw r0
                L19:
                    kotlin.ResultKt.throwOnFailure(r18)
                    goto L94
                L1d:
                    kotlin.ResultKt.throwOnFailure(r18)
                    boolean r2 = r0.Z$0
                    r5 = 0
                    r6 = 1065353216(0x3f800000, float:1.0)
                    r7 = 0
                    r8 = 0
                    if (r2 == 0) goto L5f
                    androidx.compose.runtime.MutableFloatState r2 = r0.$highlightAlpha$delegate
                    float r9 = androidx.wear.compose.material.PositionIndicatorKt.access$PositionIndicator_sbuabJo$lambda$7(r2)
                    androidx.compose.animation.core.CubicBezierEasing r2 = new androidx.compose.animation.core.CubicBezierEasing
                    r10 = 1045220557(0x3e4ccccd, float:0.2)
                    r2.<init>(r8, r8, r10, r6)
                    androidx.compose.animation.core.Easing r2 = (androidx.compose.animation.core.Easing) r2
                    r6 = 150(0x96, float:2.1E-43)
                    androidx.compose.animation.core.TweenSpec r2 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r6, r7, r2, r4, r5)
                    r12 = r2
                    androidx.compose.animation.core.AnimationSpec r12 = (androidx.compose.animation.core.AnimationSpec) r12
                    androidx.wear.compose.material.PositionIndicatorKt$PositionIndicator$12$1$1$1$1 r2 = new androidx.wear.compose.material.PositionIndicatorKt$PositionIndicator$12$1$1$1$1
                    androidx.compose.runtime.MutableFloatState r4 = r0.$highlightAlpha$delegate
                    r2.<init>()
                    r13 = r2
                    kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
                    r14 = r0
                    kotlin.coroutines.Continuation r14 = (kotlin.coroutines.Continuation) r14
                    r0.label = r3
                    r10 = 1051260355(0x3ea8f5c3, float:0.33)
                    r11 = 0
                    r15 = 4
                    r16 = 0
                    java.lang.Object r0 = androidx.compose.animation.core.SuspendAnimationKt.animate$default(r9, r10, r11, r12, r13, r14, r15, r16)
                    if (r0 != r1) goto L94
                    goto L93
                L5f:
                    androidx.compose.runtime.MutableFloatState r2 = r0.$highlightAlpha$delegate
                    float r9 = androidx.wear.compose.material.PositionIndicatorKt.access$PositionIndicator_sbuabJo$lambda$7(r2)
                    androidx.compose.animation.core.CubicBezierEasing r2 = new androidx.compose.animation.core.CubicBezierEasing
                    r3 = 1048576000(0x3e800000, float:0.25)
                    r10 = 1061158912(0x3f400000, float:0.75)
                    r2.<init>(r3, r8, r10, r6)
                    androidx.compose.animation.core.Easing r2 = (androidx.compose.animation.core.Easing) r2
                    r3 = 500(0x1f4, float:7.0E-43)
                    androidx.compose.animation.core.TweenSpec r2 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r3, r7, r2, r4, r5)
                    r12 = r2
                    androidx.compose.animation.core.AnimationSpec r12 = (androidx.compose.animation.core.AnimationSpec) r12
                    androidx.wear.compose.material.PositionIndicatorKt$PositionIndicator$12$1$1$1$2 r2 = new androidx.wear.compose.material.PositionIndicatorKt$PositionIndicator$12$1$1$1$2
                    androidx.compose.runtime.MutableFloatState r3 = r0.$highlightAlpha$delegate
                    r2.<init>()
                    r13 = r2
                    kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
                    r14 = r0
                    kotlin.coroutines.Continuation r14 = (kotlin.coroutines.Continuation) r14
                    r0.label = r4
                    r10 = 0
                    r11 = 0
                    r15 = 4
                    r16 = 0
                    java.lang.Object r0 = androidx.compose.animation.core.SuspendAnimationKt.animate$default(r9, r10, r11, r12, r13, r14, r15, r16)
                    if (r0 != r1) goto L94
                L93:
                    return r1
                L94:
                    kotlin.Unit r0 = kotlin.Unit.INSTANCE
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.wear.compose.material.PositionIndicatorKt$PositionIndicator$12$1.AnonymousClass1.C00201.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }
    }

    /* JADX INFO: renamed from: androidx.wear.compose.material.PositionIndicatorKt$PositionIndicator$12$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: PositionIndicator.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "targetValue", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.wear.compose.material.PositionIndicatorKt$PositionIndicator$12$1$2", f = "PositionIndicator.kt", i = {}, l = {844}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<Float, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableFloatState $alphaValue;
        final /* synthetic */ State<AnimationSpec<Float>> $updatedFadeInAnimationSpec$delegate;
        final /* synthetic */ State<AnimationSpec<Float>> $updatedFadeOutAnimationSpec$delegate;
        /* synthetic */ float F$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(MutableFloatState mutableFloatState, State<? extends AnimationSpec<Float>> state, State<? extends AnimationSpec<Float>> state2, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$alphaValue = mutableFloatState;
            this.$updatedFadeInAnimationSpec$delegate = state;
            this.$updatedFadeOutAnimationSpec$delegate = state2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass2 = new AnonymousClass2(this.$alphaValue, this.$updatedFadeInAnimationSpec$delegate, this.$updatedFadeOutAnimationSpec$delegate, continuation);
            anonymousClass2.F$0 = ((Number) obj).floatValue();
            return anonymousClass2;
        }

        public final Object invoke(float f, Continuation<? super Unit> continuation) {
            return create(Float.valueOf(f), continuation).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke(((Number) obj).floatValue(), (Continuation<? super Unit>) obj2);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                float f = this.F$0;
                float floatValue = this.$alphaValue.getFloatValue();
                AnimationSpec animationSpecPositionIndicator_sbuabJo$lambda$14 = f >= 1.0f ? PositionIndicatorKt.PositionIndicator_sbuabJo$lambda$14(this.$updatedFadeInAnimationSpec$delegate) : PositionIndicatorKt.PositionIndicator_sbuabJo$lambda$15(this.$updatedFadeOutAnimationSpec$delegate);
                final MutableFloatState mutableFloatState = this.$alphaValue;
                this.label = 1;
                if (SuspendAnimationKt.animate$default(floatValue, f, 0.0f, animationSpecPositionIndicator_sbuabJo$lambda$14, new Function2<Float, Float, Unit>() { // from class: androidx.wear.compose.material.PositionIndicatorKt.PositionIndicator.12.1.2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                        invoke(((Number) obj2).floatValue(), ((Number) obj3).floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f2, float f3) {
                        mutableFloatState.setFloatValue(f2);
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
            return Unit.INSTANCE;
        }
    }
}
