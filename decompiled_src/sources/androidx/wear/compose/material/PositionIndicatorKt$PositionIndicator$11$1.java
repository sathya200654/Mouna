package androidx.wear.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: PositionIndicator.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.wear.compose.material.PositionIndicatorKt$PositionIndicator$11$1", f = "PositionIndicator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PositionIndicatorKt$PositionIndicator$11$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableFloatState $alphaValue;
    final /* synthetic */ Channel<Float> $animateAlphaChannel;
    final /* synthetic */ MutableState<IntSize> $containerSize$delegate;
    final /* synthetic */ Channel<Boolean> $highlightChannel;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $positionFractionAnimatable;
    final /* synthetic */ boolean $shouldShowHighlight;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $sizeFractionAnimatable;
    final /* synthetic */ PositionIndicatorState $state;
    final /* synthetic */ State<AnimationSpec<Float>> $updatedFadeInAnimationSpec$delegate;
    final /* synthetic */ State<AnimationSpec<Float>> $updatedFadeOutAnimationSpec$delegate;
    final /* synthetic */ State<AnimationSpec<Float>> $updatedPositionAnimationSpec$delegate;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PositionIndicatorKt$PositionIndicator$11$1(PositionIndicatorState positionIndicatorState, MutableState<IntSize> mutableState, Animatable<Float, AnimationVector1D> animatable, Animatable<Float, AnimationVector1D> animatable2, boolean z, Channel<Float> channel, MutableFloatState mutableFloatState, State<? extends AnimationSpec<Float>> state, Channel<Boolean> channel2, State<? extends AnimationSpec<Float>> state2, State<? extends AnimationSpec<Float>> state3, Continuation<? super PositionIndicatorKt$PositionIndicator$11$1> continuation) {
        super(2, continuation);
        this.$state = positionIndicatorState;
        this.$containerSize$delegate = mutableState;
        this.$sizeFractionAnimatable = animatable;
        this.$positionFractionAnimatable = animatable2;
        this.$shouldShowHighlight = z;
        this.$animateAlphaChannel = channel;
        this.$alphaValue = mutableFloatState;
        this.$updatedPositionAnimationSpec$delegate = state;
        this.$highlightChannel = channel2;
        this.$updatedFadeOutAnimationSpec$delegate = state2;
        this.$updatedFadeInAnimationSpec$delegate = state3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> positionIndicatorKt$PositionIndicator$11$1 = new PositionIndicatorKt$PositionIndicator$11$1(this.$state, this.$containerSize$delegate, this.$sizeFractionAnimatable, this.$positionFractionAnimatable, this.$shouldShowHighlight, this.$animateAlphaChannel, this.$alphaValue, this.$updatedPositionAnimationSpec$delegate, this.$highlightChannel, this.$updatedFadeOutAnimationSpec$delegate, this.$updatedFadeInAnimationSpec$delegate, continuation);
        positionIndicatorKt$PositionIndicator$11$1.L$0 = obj;
        return positionIndicatorKt$PositionIndicator$11$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        booleanRef2.element = true ^ PositionIndicatorVisibility.m720equalsimpl0(this.$state.mo597visibilityKCSNhGQ(IntSize.getHeight-impl(PositionIndicatorKt.PositionIndicator_sbuabJo$lambda$2(this.$containerSize$delegate))), PositionIndicatorVisibility.INSTANCE.m725getHideGLQwCHQ());
        BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this.$state, this.$containerSize$delegate, booleanRef, booleanRef2, this.$sizeFractionAnimatable, this.$positionFractionAnimatable, this.$shouldShowHighlight, this.$animateAlphaChannel, this.$alphaValue, this.$updatedPositionAnimationSpec$delegate, this.$highlightChannel, this.$updatedFadeOutAnimationSpec$delegate, this.$updatedFadeInAnimationSpec$delegate, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.wear.compose.material.PositionIndicatorKt$PositionIndicator$11$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: PositionIndicator.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.wear.compose.material.PositionIndicatorKt$PositionIndicator$11$1$1", f = "PositionIndicator.kt", i = {}, l = {727}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableFloatState $alphaValue;
        final /* synthetic */ Channel<Float> $animateAlphaChannel;
        final /* synthetic */ MutableState<IntSize> $containerSize$delegate;
        final /* synthetic */ Channel<Boolean> $highlightChannel;
        final /* synthetic */ Animatable<Float, AnimationVector1D> $positionFractionAnimatable;
        final /* synthetic */ boolean $shouldShowHighlight;
        final /* synthetic */ Animatable<Float, AnimationVector1D> $sizeFractionAnimatable;
        final /* synthetic */ Ref.BooleanRef $skipFirstAlphaAnimation;
        final /* synthetic */ Ref.BooleanRef $skipFirstPositionAnimation;
        final /* synthetic */ PositionIndicatorState $state;
        final /* synthetic */ State<AnimationSpec<Float>> $updatedFadeInAnimationSpec$delegate;
        final /* synthetic */ State<AnimationSpec<Float>> $updatedFadeOutAnimationSpec$delegate;
        final /* synthetic */ State<AnimationSpec<Float>> $updatedPositionAnimationSpec$delegate;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PositionIndicatorState positionIndicatorState, MutableState<IntSize> mutableState, Ref.BooleanRef booleanRef, Ref.BooleanRef booleanRef2, Animatable<Float, AnimationVector1D> animatable, Animatable<Float, AnimationVector1D> animatable2, boolean z, Channel<Float> channel, MutableFloatState mutableFloatState, State<? extends AnimationSpec<Float>> state, Channel<Boolean> channel2, State<? extends AnimationSpec<Float>> state2, State<? extends AnimationSpec<Float>> state3, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$state = positionIndicatorState;
            this.$containerSize$delegate = mutableState;
            this.$skipFirstPositionAnimation = booleanRef;
            this.$skipFirstAlphaAnimation = booleanRef2;
            this.$sizeFractionAnimatable = animatable;
            this.$positionFractionAnimatable = animatable2;
            this.$shouldShowHighlight = z;
            this.$animateAlphaChannel = channel;
            this.$alphaValue = mutableFloatState;
            this.$updatedPositionAnimationSpec$delegate = state;
            this.$highlightChannel = channel2;
            this.$updatedFadeOutAnimationSpec$delegate = state2;
            this.$updatedFadeInAnimationSpec$delegate = state3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$state, this.$containerSize$delegate, this.$skipFirstPositionAnimation, this.$skipFirstAlphaAnimation, this.$sizeFractionAnimatable, this.$positionFractionAnimatable, this.$shouldShowHighlight, this.$animateAlphaChannel, this.$alphaValue, this.$updatedPositionAnimationSpec$delegate, this.$highlightChannel, this.$updatedFadeOutAnimationSpec$delegate, this.$updatedFadeInAnimationSpec$delegate, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
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
                final PositionIndicatorState positionIndicatorState = this.$state;
                final MutableState<IntSize> mutableState = this.$containerSize$delegate;
                this.label = 1;
                if (FlowKt.collectLatest(SnapshotStateKt.snapshotFlow(new Function0<DisplayState>() { // from class: androidx.wear.compose.material.PositionIndicatorKt.PositionIndicator.11.1.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final DisplayState m712invoke() {
                        return new DisplayState(positionIndicatorState.getPositionFraction(), positionIndicatorState.sizeFraction(IntSize.getHeight-impl(PositionIndicatorKt.PositionIndicator_sbuabJo$lambda$2(mutableState))), positionIndicatorState.mo597visibilityKCSNhGQ(IntSize.getHeight-impl(PositionIndicatorKt.PositionIndicator_sbuabJo$lambda$2(mutableState))), null);
                    }
                }), new AnonymousClass2(this.$skipFirstPositionAnimation, this.$skipFirstAlphaAnimation, this.$sizeFractionAnimatable, this.$positionFractionAnimatable, coroutineScope, this.$shouldShowHighlight, this.$animateAlphaChannel, this.$alphaValue, this.$updatedPositionAnimationSpec$delegate, this.$highlightChannel, this.$updatedFadeOutAnimationSpec$delegate, this.$updatedFadeInAnimationSpec$delegate, null), (Continuation) this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: androidx.wear.compose.material.PositionIndicatorKt$PositionIndicator$11$1$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: PositionIndicator.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Landroidx/wear/compose/material/DisplayState;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.wear.compose.material.PositionIndicatorKt$PositionIndicator$11$1$1$2", f = "PositionIndicator.kt", i = {0, 1}, l = {741, 742, 789}, m = "invokeSuspend", n = {"it", "it"}, s = {"L$0", "L$0"})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<DisplayState, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$launch;
            final /* synthetic */ MutableFloatState $alphaValue;
            final /* synthetic */ Channel<Float> $animateAlphaChannel;
            final /* synthetic */ Channel<Boolean> $highlightChannel;
            final /* synthetic */ Animatable<Float, AnimationVector1D> $positionFractionAnimatable;
            final /* synthetic */ boolean $shouldShowHighlight;
            final /* synthetic */ Animatable<Float, AnimationVector1D> $sizeFractionAnimatable;
            final /* synthetic */ Ref.BooleanRef $skipFirstAlphaAnimation;
            final /* synthetic */ Ref.BooleanRef $skipFirstPositionAnimation;
            final /* synthetic */ State<AnimationSpec<Float>> $updatedFadeInAnimationSpec$delegate;
            final /* synthetic */ State<AnimationSpec<Float>> $updatedFadeOutAnimationSpec$delegate;
            final /* synthetic */ State<AnimationSpec<Float>> $updatedPositionAnimationSpec$delegate;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(Ref.BooleanRef booleanRef, Ref.BooleanRef booleanRef2, Animatable<Float, AnimationVector1D> animatable, Animatable<Float, AnimationVector1D> animatable2, CoroutineScope coroutineScope, boolean z, Channel<Float> channel, MutableFloatState mutableFloatState, State<? extends AnimationSpec<Float>> state, Channel<Boolean> channel2, State<? extends AnimationSpec<Float>> state2, State<? extends AnimationSpec<Float>> state3, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$skipFirstPositionAnimation = booleanRef;
                this.$skipFirstAlphaAnimation = booleanRef2;
                this.$sizeFractionAnimatable = animatable;
                this.$positionFractionAnimatable = animatable2;
                this.$$this$launch = coroutineScope;
                this.$shouldShowHighlight = z;
                this.$animateAlphaChannel = channel;
                this.$alphaValue = mutableFloatState;
                this.$updatedPositionAnimationSpec$delegate = state;
                this.$highlightChannel = channel2;
                this.$updatedFadeOutAnimationSpec$delegate = state2;
                this.$updatedFadeInAnimationSpec$delegate = state3;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass2 = new AnonymousClass2(this.$skipFirstPositionAnimation, this.$skipFirstAlphaAnimation, this.$sizeFractionAnimatable, this.$positionFractionAnimatable, this.$$this$launch, this.$shouldShowHighlight, this.$animateAlphaChannel, this.$alphaValue, this.$updatedPositionAnimationSpec$delegate, this.$highlightChannel, this.$updatedFadeOutAnimationSpec$delegate, this.$updatedFadeInAnimationSpec$delegate, continuation);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            public final Object invoke(DisplayState displayState, Continuation<? super Unit> continuation) {
                return create(displayState, continuation).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:39:0x0106  */
            /* JADX WARN: Code duplicated, block: B:40:0x0114  */
            /* JADX WARN: Code duplicated, block: B:46:0x0131  */
            /* JADX WARN: Code duplicated, block: B:49:0x014a  */
            /* JADX WARN: Code restructure failed: missing block: B:34:0x00ef, code lost:
            
                if (r21.$positionFractionAnimatable.snapTo(kotlin.coroutines.jvm.internal.Boxing.boxFloat(r2.getPosition()), (kotlin.coroutines.Continuation) r21) == r1) goto L51;
             */
            /* JADX WARN: Code restructure failed: missing block: B:50:0x0157, code lost:
            
                if (kotlinx.coroutines.DelayKt.delay(androidx.wear.compose.material.PlaceholderKt.PLACEHOLDER_SHIMMER_GAP_BETWEEN_ANIMATION_LOOPS_MS, (kotlin.coroutines.Continuation) r21) == r1) goto L51;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r22) {
                /*
                    Method dump skipped, instruction units count: 362
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.wear.compose.material.PositionIndicatorKt$PositionIndicator$11$1.AnonymousClass1.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            /* JADX INFO: renamed from: androidx.wear.compose.material.PositionIndicatorKt$PositionIndicator$11$1$1$2$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: PositionIndicator.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.wear.compose.material.PositionIndicatorKt$PositionIndicator$11$1$1$2$1", f = "PositionIndicator.kt", i = {}, l = {747}, m = "invokeSuspend", n = {}, s = {})
            static final class C00181 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ DisplayState $it;
                final /* synthetic */ Animatable<Float, AnimationVector1D> $sizeFractionAnimatable;
                final /* synthetic */ State<AnimationSpec<Float>> $updatedPositionAnimationSpec$delegate;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00181(Animatable<Float, AnimationVector1D> animatable, DisplayState displayState, State<? extends AnimationSpec<Float>> state, Continuation<? super C00181> continuation) {
                    super(2, continuation);
                    this.$sizeFractionAnimatable = animatable;
                    this.$it = displayState;
                    this.$updatedPositionAnimationSpec$delegate = state;
                }

                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C00181(this.$sizeFractionAnimatable, this.$it, this.$updatedPositionAnimationSpec$delegate, continuation);
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
                        if (Animatable.animateTo$default(this.$sizeFractionAnimatable, Boxing.boxFloat(this.$it.getSize()), PositionIndicatorKt.PositionIndicator_sbuabJo$lambda$16(this.$updatedPositionAnimationSpec$delegate), (Object) null, (Function1) null, (Continuation) this, 12, (Object) null) == coroutine_suspended) {
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

            /* JADX INFO: renamed from: androidx.wear.compose.material.PositionIndicatorKt$PositionIndicator$11$1$1$2$2, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: PositionIndicator.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.wear.compose.material.PositionIndicatorKt$PositionIndicator$11$1$1$2$2", f = "PositionIndicator.kt", i = {}, l = {754}, m = "invokeSuspend", n = {}, s = {})
            static final class C00192 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ DisplayState $it;
                final /* synthetic */ Animatable<Float, AnimationVector1D> $positionFractionAnimatable;
                final /* synthetic */ State<AnimationSpec<Float>> $updatedPositionAnimationSpec$delegate;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00192(Animatable<Float, AnimationVector1D> animatable, DisplayState displayState, State<? extends AnimationSpec<Float>> state, Continuation<? super C00192> continuation) {
                    super(2, continuation);
                    this.$positionFractionAnimatable = animatable;
                    this.$it = displayState;
                    this.$updatedPositionAnimationSpec$delegate = state;
                }

                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C00192(this.$positionFractionAnimatable, this.$it, this.$updatedPositionAnimationSpec$delegate, continuation);
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
                        if (Animatable.animateTo$default(this.$positionFractionAnimatable, Boxing.boxFloat(this.$it.getPosition()), PositionIndicatorKt.PositionIndicator_sbuabJo$lambda$16(this.$updatedPositionAnimationSpec$delegate), (Object) null, (Function1) null, (Continuation) this, 12, (Object) null) == coroutine_suspended) {
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

            /* JADX INFO: renamed from: androidx.wear.compose.material.PositionIndicatorKt$PositionIndicator$11$1$1$2$3, reason: invalid class name */
            /* JADX INFO: compiled from: PositionIndicator.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.wear.compose.material.PositionIndicatorKt$PositionIndicator$11$1$1$2$3", f = "PositionIndicator.kt", i = {}, l = {763}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Channel<Boolean> $highlightChannel;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass3(Channel<Boolean> channel, Continuation<? super AnonymousClass3> continuation) {
                    super(2, continuation);
                    this.$highlightChannel = channel;
                }

                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass3(this.$highlightChannel, continuation);
                }

                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                }

                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.$highlightChannel.trySend-JP2dKIU(Boxing.boxBoolean(true));
                        this.label = 1;
                        if (DelayKt.delay(150L, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    this.$highlightChannel.trySend-JP2dKIU(Boxing.boxBoolean(false));
                    return Unit.INSTANCE;
                }
            }
        }
    }
}
