package androidx.wear.compose.material;

import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.InfiniteAnimationPolicyKt;
import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.SnapshotLongStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: Placeholder.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B+\b\u0000\u0012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u000e\u0010D\u001a\u00020EH\u0086@¢\u0006\u0002\u0010FR\"\u0010\n\u001a\u00020\u000bX\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\u00078@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001d\u0010\u001bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u001f\u001a\u00020\u00078FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b#\u0010\u0019\u0012\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0017R!\u0010$\u001a\u00020\u00078@X\u0081\u0084\u0002¢\u0006\u0012\n\u0004\b'\u0010\u0019\u0012\u0004\b%\u0010!\u001a\u0004\b&\u0010\u0017R$\u0010(\u001a\u00020)8@X\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R!\u0010/\u001a\u00020\u00078@X\u0081\u0084\u0002¢\u0006\u0012\n\u0004\b2\u0010\u0019\u0012\u0004\b0\u0010!\u001a\u0004\b1\u0010\u0017R\u001b\u00103\u001a\u00020\u00078@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u0019\u001a\u0004\b4\u0010\u0017R\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010:\u001a\u00020\u00078@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\u0019\u001a\u0004\b;\u0010\u0017R\u001b\u0010=\u001a\u00020\u00078@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\u0019\u001a\u0004\b>\u0010\u0017R\u000e\u0010@\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006G"}, d2 = {"Landroidx/wear/compose/material/PlaceholderState;", "", "isContentReady", "Landroidx/compose/runtime/State;", "Lkotlin/Function0;", "", "maxScreenDimension", "", "isReduceMotionEnabled", "(Landroidx/compose/runtime/State;FZ)V", "backgroundOffset", "Landroidx/compose/ui/geometry/Offset;", "getBackgroundOffset-F1C5BW0$compose_material_release", "()J", "setBackgroundOffset-k-4lQ0M$compose_material_release", "(J)V", "J", "frameMillis", "Landroidx/compose/runtime/MutableLongState;", "getFrameMillis$compose_material_release", "()Landroidx/compose/runtime/MutableLongState;", "gradientXYWidth", "getGradientXYWidth$compose_material_release", "()F", "gradientXYWidth$delegate", "Landroidx/compose/runtime/State;", "isShowContent", "()Z", "isShowContent$delegate", "isWipeOff", "isWipeOff$delegate", "placeholderProgression", "getPlaceholderProgression$annotations", "()V", "getPlaceholderProgression", "placeholderProgression$delegate", "placeholderShimmerAlpha", "getPlaceholderShimmerAlpha$compose_material_release$annotations", "getPlaceholderShimmerAlpha$compose_material_release", "placeholderShimmerAlpha$delegate", "placeholderStage", "Landroidx/wear/compose/material/PlaceholderStage;", "getPlaceholderStage-47HYLpQ$compose_material_release", "()I", "setPlaceholderStage-A5vP97Y$compose_material_release", "(I)V", "I", "placeholderWipeOffAlpha", "getPlaceholderWipeOffAlpha$compose_material_release$annotations", "getPlaceholderWipeOffAlpha$compose_material_release", "placeholderWipeOffAlpha$delegate", "placeholderWipeOffProgression", "getPlaceholderWipeOffProgression$compose_material_release", "placeholderWipeOffProgression$delegate", "progressionInterpolator", "Landroidx/compose/animation/core/Easing;", "resetFadeInInterpolator", "resetFadeOutInterpolator", "resetPlaceholderFadeInAlpha", "getResetPlaceholderFadeInAlpha$compose_material_release", "resetPlaceholderFadeInAlpha$delegate", "resetPlaceholderFadeOutAlpha", "getResetPlaceholderFadeOutAlpha$compose_material_release", "resetPlaceholderFadeOutAlpha$delegate", "startOfResetAnimation", "", "startOfWipeOffAnimation", "wipeOffInterpolator", "startPlaceholderAnimation", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PlaceholderState {
    public static final int $stable = 0;
    private final MutableLongState frameMillis;
    private final State<Function0<Boolean>> isContentReady;
    private final boolean isReduceMotionEnabled;
    private final float maxScreenDimension;
    private int placeholderStage;
    private final Easing progressionInterpolator;
    private final Easing resetFadeInInterpolator;
    private final Easing resetFadeOutInterpolator;
    private long startOfResetAnimation;
    private long startOfWipeOffAnimation;
    private final Easing wipeOffInterpolator;
    private long backgroundOffset = Offset.Companion.getZero-F1C5BW0();

    /* JADX INFO: renamed from: placeholderWipeOffProgression$delegate, reason: from kotlin metadata */
    private final State placeholderWipeOffProgression = SnapshotStateKt.derivedStateOf(new Function0<Float>() { // from class: androidx.wear.compose.material.PlaceholderState$placeholderWipeOffProgression$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Float m688invoke() {
            return Float.valueOf(MathHelpersKt.lerp((-this.this$0.maxScreenDimension) * 1.75f, this.this$0.maxScreenDimension * 0.75f, this.this$0.wipeOffInterpolator.transform(RangesKt.coerceAtMost(RangesKt.coerceAtMost(this.this$0.getFrameMillis().getLongValue() - this.this$0.startOfWipeOffAnimation, 300L) / 300, 1.0f))));
        }
    });

    /* JADX INFO: renamed from: placeholderWipeOffAlpha$delegate, reason: from kotlin metadata */
    private final State placeholderWipeOffAlpha = SnapshotStateKt.derivedStateOf(new Function0<Float>() { // from class: androidx.wear.compose.material.PlaceholderState$placeholderWipeOffAlpha$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Float m687invoke() {
            return Float.valueOf(this.this$0.wipeOffInterpolator.transform(MathHelpersKt.lerp(0.0f, 1.0f, RangesKt.coerceAtMost(RangesKt.coerceAtMost(this.this$0.getFrameMillis().getLongValue() - this.this$0.startOfWipeOffAnimation, 80L) / 80, 1.0f))));
        }
    });

    /* JADX INFO: renamed from: placeholderProgression$delegate, reason: from kotlin metadata */
    private final State placeholderProgression = SnapshotStateKt.derivedStateOf(new Function0<Float>() { // from class: androidx.wear.compose.material.PlaceholderState$placeholderProgression$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Float m684invoke() {
            long longValue = this.this$0.getFrameMillis().getLongValue() % PlaceholderKt.PLACEHOLDER_SHIMMER_GAP_BETWEEN_ANIMATION_LOOPS_MS;
            return Float.valueOf(MathHelpersKt.lerp((-this.this$0.maxScreenDimension) * 0.5f, this.this$0.maxScreenDimension * 1.5f, this.this$0.progressionInterpolator.transform(RangesKt.coerceAtMost(longValue + (PlaceholderKt.PLACEHOLDER_SHIMMER_GAP_BETWEEN_ANIMATION_LOOPS_MS & (((longValue ^ PlaceholderKt.PLACEHOLDER_SHIMMER_GAP_BETWEEN_ANIMATION_LOOPS_MS) & ((-longValue) | longValue)) >> 63)), 800L) / 800)));
        }
    });

    /* JADX INFO: renamed from: placeholderShimmerAlpha$delegate, reason: from kotlin metadata */
    private final State placeholderShimmerAlpha = SnapshotStateKt.derivedStateOf(new Function0<Float>() { // from class: androidx.wear.compose.material.PlaceholderState$placeholderShimmerAlpha$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Float m685invoke() {
            float fTransform;
            long longValue = this.this$0.getFrameMillis().getLongValue() % PlaceholderKt.PLACEHOLDER_SHIMMER_GAP_BETWEEN_ANIMATION_LOOPS_MS;
            float fCoerceAtMost = RangesKt.coerceAtMost(longValue + (PlaceholderKt.PLACEHOLDER_SHIMMER_GAP_BETWEEN_ANIMATION_LOOPS_MS & (((longValue ^ PlaceholderKt.PLACEHOLDER_SHIMMER_GAP_BETWEEN_ANIMATION_LOOPS_MS) & ((-longValue) | longValue)) >> 63)), 800L) / 800;
            if (fCoerceAtMost <= 0.5f) {
                fTransform = this.this$0.progressionInterpolator.transform(MathHelpersKt.lerp(0.0f, 0.15f, fCoerceAtMost * 2.0f));
            } else {
                fTransform = this.this$0.progressionInterpolator.transform(MathHelpersKt.lerp(0.15f, 0.0f, (fCoerceAtMost - 0.5f) * 2.0f));
            }
            return Float.valueOf(fTransform);
        }
    });

    /* JADX INFO: renamed from: resetPlaceholderFadeInAlpha$delegate, reason: from kotlin metadata */
    private final State resetPlaceholderFadeInAlpha = SnapshotStateKt.derivedStateOf(new Function0<Float>() { // from class: androidx.wear.compose.material.PlaceholderState$resetPlaceholderFadeInAlpha$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Float m689invoke() {
            float fCoerceAtMost = RangesKt.coerceAtMost((this.this$0.getFrameMillis().getLongValue() - this.this$0.startOfResetAnimation) - ((long) AnimationKt.RAPID), 250L) / 250.0f;
            float fTransform = 0.0f;
            if (fCoerceAtMost >= 0.0f) {
                fTransform = this.this$0.resetFadeInInterpolator.transform(MathHelpersKt.lerp(0.1f, 1.0f, fCoerceAtMost));
            }
            return Float.valueOf(fTransform);
        }
    });

    /* JADX INFO: renamed from: resetPlaceholderFadeOutAlpha$delegate, reason: from kotlin metadata */
    private final State resetPlaceholderFadeOutAlpha = SnapshotStateKt.derivedStateOf(new Function0<Float>() { // from class: androidx.wear.compose.material.PlaceholderState$resetPlaceholderFadeOutAlpha$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Float m690invoke() {
            return Float.valueOf(this.this$0.resetFadeOutInterpolator.transform(MathHelpersKt.lerp(1.0f, 0.0f, RangesKt.coerceAtMost(this.this$0.getFrameMillis().getLongValue() - this.this$0.startOfResetAnimation, 150L) / 150.0f)));
        }
    });

    /* JADX INFO: renamed from: isShowContent$delegate, reason: from kotlin metadata */
    private final State isShowContent = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: androidx.wear.compose.material.PlaceholderState.isShowContent.2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m682invoke() {
            return Boolean.valueOf(PlaceholderStage.m669equalsimpl0(PlaceholderState.this.m678getPlaceholderStage47HYLpQ$compose_material_release(), PlaceholderStage.INSTANCE.m674getShowContent47HYLpQ()));
        }
    });

    /* JADX INFO: renamed from: isWipeOff$delegate, reason: from kotlin metadata */
    private final State isWipeOff = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: androidx.wear.compose.material.PlaceholderState.isWipeOff.2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m683invoke() {
            return Boolean.valueOf(PlaceholderStage.m669equalsimpl0(PlaceholderState.this.m678getPlaceholderStage47HYLpQ$compose_material_release(), PlaceholderStage.INSTANCE.m676getWipeOff47HYLpQ()));
        }
    });

    /* JADX INFO: renamed from: gradientXYWidth$delegate, reason: from kotlin metadata */
    private final State gradientXYWidth = SnapshotStateKt.derivedStateOf(new Function0<Float>() { // from class: androidx.wear.compose.material.PlaceholderState$gradientXYWidth$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Float m681invoke() {
            return Float.valueOf(this.this$0.maxScreenDimension * ((float) Math.pow(2.0f, 1.5f)));
        }
    });

    public static /* synthetic */ void getPlaceholderProgression$annotations() {
    }

    public static /* synthetic */ void getPlaceholderShimmerAlpha$compose_material_release$annotations() {
    }

    public static /* synthetic */ void getPlaceholderWipeOffAlpha$compose_material_release$annotations() {
    }

    public PlaceholderState(State<? extends Function0<Boolean>> state, float f, boolean z) {
        this.isContentReady = state;
        this.maxScreenDimension = f;
        this.isReduceMotionEnabled = z;
        this.placeholderStage = ((Boolean) ((Function0) state.getValue()).invoke()).booleanValue() ? PlaceholderStage.INSTANCE.m674getShowContent47HYLpQ() : PlaceholderStage.INSTANCE.m675getShowPlaceholder47HYLpQ();
        this.frameMillis = SnapshotLongStateKt.mutableLongStateOf(0L);
        this.progressionInterpolator = new CubicBezierEasing(0.3f, 0.0f, 0.7f, 1.0f);
        this.wipeOffInterpolator = new CubicBezierEasing(0.0f, 0.2f, 1.0f, 0.6f);
        this.resetFadeInInterpolator = new CubicBezierEasing(0.2f, 0.0f, 0.0f, 1.0f);
        this.resetFadeOutInterpolator = new CubicBezierEasing(0.3f, 0.0f, 1.0f, 1.0f);
    }

    /* JADX INFO: renamed from: getBackgroundOffset-F1C5BW0$compose_material_release, reason: not valid java name and from getter */
    public final long getBackgroundOffset() {
        return this.backgroundOffset;
    }

    /* JADX INFO: renamed from: setBackgroundOffset-k-4lQ0M$compose_material_release, reason: not valid java name */
    public final void m679setBackgroundOffsetk4lQ0M$compose_material_release(long j) {
        this.backgroundOffset = j;
    }

    /* JADX INFO: renamed from: androidx.wear.compose.material.PlaceholderState$startPlaceholderAnimation$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Placeholder.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.wear.compose.material.PlaceholderState$startPlaceholderAnimation$2", f = "Placeholder.kt", i = {0}, l = {943}, m = "invokeSuspend", n = {"$this$coroutineScope"}, s = {"L$0"})
    static final class C01292 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C01292(Continuation<? super C01292> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c01292 = PlaceholderState.this.new C01292(continuation);
            c01292.L$0 = obj;
            return c01292;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.L$0;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            while (CoroutineScopeKt.isActive(coroutineScope)) {
                final PlaceholderState placeholderState = PlaceholderState.this;
                this.L$0 = coroutineScope;
                this.label = 1;
                if (InfiniteAnimationPolicyKt.withInfiniteAnimationFrameNanos(new Function1<Long, Unit>() { // from class: androidx.wear.compose.material.PlaceholderState$startPlaceholderAnimation$2$invokeSuspend$$inlined$withInfiniteAnimationFrameMillis$1
                    {
                        super(1);
                    }

                    public final Unit invoke(long j) {
                        placeholderState.getFrameMillis().setLongValue(j / 1000000);
                        return Unit.INSTANCE;
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        return invoke(((Number) obj2).longValue());
                    }
                }, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    public final Object startPlaceholderAnimation(Continuation<? super Unit> continuation) {
        if (!this.isReduceMotionEnabled) {
            Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C01292(null), continuation);
            return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    public final float getPlaceholderWipeOffProgression$compose_material_release() {
        return ((Number) this.placeholderWipeOffProgression.getValue()).floatValue();
    }

    public final float getPlaceholderWipeOffAlpha$compose_material_release() {
        return ((Number) this.placeholderWipeOffAlpha.getValue()).floatValue();
    }

    public final float getPlaceholderProgression() {
        return ((Number) this.placeholderProgression.getValue()).floatValue();
    }

    public final float getPlaceholderShimmerAlpha$compose_material_release() {
        return ((Number) this.placeholderShimmerAlpha.getValue()).floatValue();
    }

    public final float getResetPlaceholderFadeInAlpha$compose_material_release() {
        return ((Number) this.resetPlaceholderFadeInAlpha.getValue()).floatValue();
    }

    public final float getResetPlaceholderFadeOutAlpha$compose_material_release() {
        return ((Number) this.resetPlaceholderFadeOutAlpha.getValue()).floatValue();
    }

    public final boolean isShowContent() {
        return ((Boolean) this.isShowContent.getValue()).booleanValue();
    }

    public final boolean isWipeOff() {
        return ((Boolean) this.isWipeOff.getValue()).booleanValue();
    }

    public final float getGradientXYWidth$compose_material_release() {
        return ((Number) this.gradientXYWidth.getValue()).floatValue();
    }

    /* JADX INFO: renamed from: setPlaceholderStage-A5vP97Y$compose_material_release, reason: not valid java name */
    public final void m680setPlaceholderStageA5vP97Y$compose_material_release(int i) {
        this.placeholderStage = i;
    }

    /* JADX INFO: renamed from: getPlaceholderStage-47HYLpQ$compose_material_release, reason: not valid java name */
    public final int m678getPlaceholderStage47HYLpQ$compose_material_release() {
        return ((PlaceholderStage) SnapshotStateKt.derivedStateOf(new Function0<PlaceholderStage>() { // from class: androidx.wear.compose.material.PlaceholderState$placeholderStage$1
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                return PlaceholderStage.m666boximpl(m686invoke47HYLpQ());
            }

            /* JADX INFO: renamed from: invoke-47HYLpQ, reason: not valid java name */
            public final int m686invoke47HYLpQ() {
                if (PlaceholderStage.m669equalsimpl0(this.this$0.placeholderStage, PlaceholderStage.INSTANCE.m676getWipeOff47HYLpQ()) || PlaceholderStage.m669equalsimpl0(this.this$0.placeholderStage, PlaceholderStage.INSTANCE.m675getShowPlaceholder47HYLpQ())) {
                    if (this.this$0.startOfWipeOffAnimation != 0) {
                        if (this.this$0.getFrameMillis().getLongValue() - this.this$0.startOfWipeOffAnimation >= 300) {
                            this.this$0.placeholderStage = PlaceholderStage.INSTANCE.m674getShowContent47HYLpQ();
                        }
                    } else if (((Boolean) ((Function0) this.this$0.isContentReady.getValue()).invoke()).booleanValue()) {
                        if (this.this$0.isReduceMotionEnabled) {
                            this.this$0.placeholderStage = PlaceholderStage.INSTANCE.m674getShowContent47HYLpQ();
                        } else {
                            PlaceholderState placeholderState = this.this$0;
                            placeholderState.startOfWipeOffAnimation = placeholderState.getFrameMillis().getLongValue();
                            this.this$0.placeholderStage = PlaceholderStage.INSTANCE.m676getWipeOff47HYLpQ();
                        }
                    }
                } else if (!((Boolean) ((Function0) this.this$0.isContentReady.getValue()).invoke()).booleanValue()) {
                    if (this.this$0.startOfResetAnimation == 0) {
                        this.this$0.startOfWipeOffAnimation = 0L;
                        if (this.this$0.isReduceMotionEnabled) {
                            this.this$0.placeholderStage = PlaceholderStage.INSTANCE.m675getShowPlaceholder47HYLpQ();
                        } else {
                            PlaceholderState placeholderState2 = this.this$0;
                            placeholderState2.startOfResetAnimation = placeholderState2.getFrameMillis().getLongValue();
                            this.this$0.placeholderStage = PlaceholderStage.INSTANCE.m673getResetContent47HYLpQ();
                        }
                    } else if (this.this$0.getFrameMillis().getLongValue() - this.this$0.startOfResetAnimation >= 400) {
                        this.this$0.startOfResetAnimation = 0L;
                        this.this$0.placeholderStage = PlaceholderStage.INSTANCE.m675getShowPlaceholder47HYLpQ();
                    }
                }
                return this.this$0.placeholderStage;
            }
        }).getValue()).getType();
    }

    /* JADX INFO: renamed from: getFrameMillis$compose_material_release, reason: from getter */
    public final MutableLongState getFrameMillis() {
        return this.frameMillis;
    }
}
