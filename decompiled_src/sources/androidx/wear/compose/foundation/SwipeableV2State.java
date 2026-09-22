package androidx.wear.compose.foundation;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Density;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: SwipeableV2.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b1\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u0080\u0001*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\u0080\u0001B\u0088\u0001\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012#\b\u0002\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\b\u0012.\b\u0002\u0010\r\u001a(\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00060\u000e¢\u0006\u0002\b\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J \u0010_\u001a\u00020`2\u0006\u0010Z\u001a\u00028\u00002\b\b\u0002\u0010a\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010bJ%\u0010c\u001a\u00028\u00002\u0006\u0010C\u001a\u00020\u00062\u0006\u0010*\u001a\u00028\u00002\u0006\u0010a\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010dJ\u000e\u0010e\u001a\u00020\u00062\u0006\u0010f\u001a\u00020\u0006J\u0013\u0010g\u001a\u00020\f2\u0006\u0010h\u001a\u00028\u0000¢\u0006\u0002\u0010iJ\u001d\u0010j\u001a\u00020k2\u0006\u0010f\u001a\u00020\u0006H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bl\u0010mJ\b\u0010n\u001a\u00020\u000fH\u0002J\u0006\u0010o\u001a\u00020\u0006J\u0016\u0010p\u001a\u00020`2\u0006\u0010a\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010qJ\u0015\u0010r\u001a\u00020`2\u0006\u0010Z\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010&J\u0016\u0010s\u001a\u00020`2\u0006\u0010Z\u001a\u00028\u0000H\u0086@¢\u0006\u0002\u0010tJ6\u0010u\u001a\u00020`2\b\b\u0002\u0010v\u001a\u00020w2\u001c\u0010x\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020`0y\u0012\u0006\u0012\u0004\u0018\u00010\u00020\bH\u0082@¢\u0006\u0002\u0010zJ\u0017\u0010{\u001a\u00020\f2\u0006\u0010Z\u001a\u00028\u0000H\u0000¢\u0006\u0004\b|\u0010iJ!\u0010}\u001a\u00020\f2\u0012\u0010~\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0018H\u0000¢\u0006\u0002\b\u007fRC\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u00182\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u00188@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R/\u0010\"\u001a\u0004\u0018\u00018\u00002\b\u0010\u0017\u001a\u0004\u0018\u00018\u00008B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b'\u0010\u001f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R/\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R+\u0010*\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00028\u00008F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b-\u0010\u001f\u001a\u0004\b+\u0010$\"\u0004\b,\u0010&R\u001c\u0010.\u001a\u0004\u0018\u00010\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0011\u00103\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b3\u00104R+\u00105\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00068F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001b\u0010<\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b=\u00107R\u001b\u0010@\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bB\u0010?\u001a\u0004\bA\u00107R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010C\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00068F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bH\u0010\u001f\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001a\u0010I\u001a\u00020JX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR:\u0010\r\u001a(\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00060\u000e¢\u0006\u0002\b\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u001b\u0010Q\u001a\u00020\u00068GX\u0086\u0084\u0002¢\u0006\f\n\u0004\bS\u0010?\u001a\u0004\bR\u00107R\u0014\u0010T\u001a\u00020UX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u000e\u0010X\u001a\u00020YX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010Z\u001a\u00028\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010?\u001a\u0004\b[\u0010$R\u001c\u0010\u0012\u001a\u00020\u0013X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010^\u001a\u0004\b]\u00107\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0081\u0001"}, d2 = {"Landroidx/wear/compose/foundation/SwipeableV2State;", "T", "", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "newValue", "", "positionalThreshold", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "totalDistance", "Lkotlin/ExtensionFunctionType;", "velocityThreshold", "Landroidx/compose/ui/unit/Dp;", "nestedScrollDispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;FLandroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "<set-?>", "", "anchors", "getAnchors$compose_foundation_release", "()Ljava/util/Map;", "setAnchors$compose_foundation_release", "(Ljava/util/Map;)V", "anchors$delegate", "Landroidx/compose/runtime/MutableState;", "getAnimationSpec$compose_foundation_release", "()Landroidx/compose/animation/core/AnimationSpec;", "animationTarget", "getAnimationTarget", "()Ljava/lang/Object;", "setAnimationTarget", "(Ljava/lang/Object;)V", "animationTarget$delegate", "getConfirmValueChange$compose_foundation_release", "()Lkotlin/jvm/functions/Function1;", "currentValue", "getCurrentValue", "setCurrentValue", "currentValue$delegate", "density", "getDensity$compose_foundation_release", "()Landroidx/compose/ui/unit/Density;", "setDensity$compose_foundation_release", "(Landroidx/compose/ui/unit/Density;)V", "isAnimationRunning", "()Z", "lastVelocity", "getLastVelocity", "()F", "setLastVelocity", "(F)V", "lastVelocity$delegate", "Landroidx/compose/runtime/MutableFloatState;", "maxOffset", "getMaxOffset", "maxOffset$delegate", "Landroidx/compose/runtime/State;", "minOffset", "getMinOffset", "minOffset$delegate", "offset", "getOffset", "()Ljava/lang/Float;", "setOffset", "(Ljava/lang/Float;)V", "offset$delegate", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "getOrientation$compose_foundation_release", "()Landroidx/compose/foundation/gestures/Orientation;", "setOrientation$compose_foundation_release", "(Landroidx/compose/foundation/gestures/Orientation;)V", "getPositionalThreshold$compose_foundation_release", "()Lkotlin/jvm/functions/Function2;", "progress", "getProgress", "progress$delegate", "swipeDraggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "getSwipeDraggableState$compose_foundation_release", "()Landroidx/compose/foundation/gestures/DraggableState;", "swipeMutex", "Landroidx/wear/compose/foundation/InternalMutatorMutex;", "targetValue", "getTargetValue", "targetValue$delegate", "getVelocityThreshold-D9Ej5fM$compose_foundation_release", "F", "animateTo", "", "velocity", "(Ljava/lang/Object;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "computeTarget", "(FLjava/lang/Object;F)Ljava/lang/Object;", "dispatchRawDelta", "delta", "hasAnchorForValue", "value", "(Ljava/lang/Object;)Z", "offsetWithOrientation", "Landroidx/compose/ui/geometry/Offset;", "offsetWithOrientation-tuRUvjQ", "(F)J", "requireDensity", "requireOffset", "settle", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snap", "snapTo", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "swipe", "swipePriority", "Landroidx/compose/foundation/MutatePriority;", "action", "Lkotlin/coroutines/Continuation;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trySnapTo", "trySnapTo$compose_foundation_release", "updateAnchors", "newAnchors", "updateAnchors$compose_foundation_release", "Companion", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SwipeableV2State<T> {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: anchors$delegate, reason: from kotlin metadata */
    private final MutableState anchors;
    private final AnimationSpec<Float> animationSpec;

    /* JADX INFO: renamed from: animationTarget$delegate, reason: from kotlin metadata */
    private final MutableState animationTarget;
    private final Function1<T, Boolean> confirmValueChange;

    /* JADX INFO: renamed from: currentValue$delegate, reason: from kotlin metadata */
    private final MutableState currentValue;
    private Density density;

    /* JADX INFO: renamed from: lastVelocity$delegate, reason: from kotlin metadata */
    private final MutableFloatState lastVelocity;

    /* JADX INFO: renamed from: maxOffset$delegate, reason: from kotlin metadata */
    private final State maxOffset;

    /* JADX INFO: renamed from: minOffset$delegate, reason: from kotlin metadata */
    private final State minOffset;
    private final NestedScrollDispatcher nestedScrollDispatcher;

    /* JADX INFO: renamed from: offset$delegate, reason: from kotlin metadata */
    private final MutableState offset;
    private Orientation orientation;
    private final Function2<Density, Float, Float> positionalThreshold;

    /* JADX INFO: renamed from: progress$delegate, reason: from kotlin metadata */
    private final State progress;
    private final DraggableState swipeDraggableState;
    private final InternalMutatorMutex swipeMutex;

    /* JADX INFO: renamed from: targetValue$delegate, reason: from kotlin metadata */
    private final State targetValue;
    private final float velocityThreshold;

    /* JADX INFO: renamed from: androidx.wear.compose.foundation.SwipeableV2State$animateTo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SwipeableV2.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.wear.compose.foundation.SwipeableV2State", f = "SwipeableV2.kt", i = {0}, l = {411}, m = "animateTo", n = {"this"}, s = {"L$0"})
    static final class C01051 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SwipeableV2State<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01051(SwipeableV2State<T> swipeableV2State, Continuation<? super C01051> continuation) {
            super(continuation);
            this.this$0 = swipeableV2State;
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.animateTo(null, 0.0f, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: androidx.wear.compose.foundation.SwipeableV2State$settle$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SwipeableV2.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.wear.compose.foundation.SwipeableV2State", f = "SwipeableV2.kt", i = {0, 0}, l = {446, 462, 465}, m = "settle", n = {"this", "availableVelocity"}, s = {"L$0", "L$1"})
    static final class C01061 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SwipeableV2State<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01061(SwipeableV2State<T> swipeableV2State, Continuation<? super C01061> continuation) {
            super(continuation);
            this.this$0 = swipeableV2State;
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.settle(0.0f, (Continuation) this);
        }
    }

    public /* synthetic */ SwipeableV2State(Object obj, AnimationSpec animationSpec, Function1 function1, Function2 function2, float f, NestedScrollDispatcher nestedScrollDispatcher, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, animationSpec, function1, function2, f, nestedScrollDispatcher);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private SwipeableV2State(T t, AnimationSpec<Float> animationSpec, Function1<? super T, Boolean> function1, Function2<? super Density, ? super Float, Float> function2, float f, NestedScrollDispatcher nestedScrollDispatcher) {
        this.animationSpec = animationSpec;
        this.confirmValueChange = function1;
        this.positionalThreshold = function2;
        this.velocityThreshold = f;
        this.nestedScrollDispatcher = nestedScrollDispatcher;
        this.swipeMutex = new InternalMutatorMutex();
        this.swipeDraggableState = new SwipeableV2State$swipeDraggableState$1(this);
        this.orientation = Orientation.Horizontal;
        this.currentValue = SnapshotStateKt.mutableStateOf$default(t, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.targetValue = SnapshotStateKt.derivedStateOf(new Function0<T>(this) { // from class: androidx.wear.compose.foundation.SwipeableV2State$targetValue$2
            final /* synthetic */ SwipeableV2State<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            public final T invoke() {
                T t2 = (T) this.this$0.getAnimationTarget();
                if (t2 != null) {
                    return t2;
                }
                SwipeableV2State<T> swipeableV2State = this.this$0;
                Float offset = swipeableV2State.getOffset();
                if (offset != null) {
                    return (T) swipeableV2State.computeTarget(offset.floatValue(), swipeableV2State.getCurrentValue(), 0.0f);
                }
                return swipeableV2State.getCurrentValue();
            }
        });
        this.offset = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.progress = SnapshotStateKt.derivedStateOf(new Function0<Float>(this) { // from class: androidx.wear.compose.foundation.SwipeableV2State$progress$2
            final /* synthetic */ SwipeableV2State<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Code duplicated, block: B:19:0x005a  */
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Float m438invoke() {
                Float f2 = (Float) this.this$0.getAnchors$compose_foundation_release().get(this.this$0.getCurrentValue());
                float f3 = 0.0f;
                float fFloatValue = f2 != null ? f2.floatValue() : 0.0f;
                Float f4 = (Float) this.this$0.getAnchors$compose_foundation_release().get(this.this$0.getTargetValue());
                float fFloatValue2 = (f4 != null ? f4.floatValue() : 0.0f) - fFloatValue;
                if (Math.abs(fFloatValue2) > 1.0E-6f) {
                    float fRequireOffset = (this.this$0.requireOffset() - fFloatValue) / fFloatValue2;
                    if (fRequireOffset >= 1.0E-6f) {
                        if (fRequireOffset > 0.999999f) {
                            f3 = 1.0f;
                        } else {
                            f3 = fRequireOffset;
                        }
                    }
                } else {
                    f3 = 1.0f;
                }
                return Float.valueOf(f3);
            }
        });
        this.lastVelocity = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.minOffset = SnapshotStateKt.derivedStateOf(new Function0<Float>(this) { // from class: androidx.wear.compose.foundation.SwipeableV2State$minOffset$2
            final /* synthetic */ SwipeableV2State<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Float m437invoke() {
                Float fMinOrNull = SwipeableV2Kt.minOrNull(this.this$0.getAnchors$compose_foundation_release());
                return Float.valueOf(fMinOrNull != null ? fMinOrNull.floatValue() : Float.NEGATIVE_INFINITY);
            }
        });
        this.maxOffset = SnapshotStateKt.derivedStateOf(new Function0<Float>(this) { // from class: androidx.wear.compose.foundation.SwipeableV2State$maxOffset$2
            final /* synthetic */ SwipeableV2State<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Float m436invoke() {
                Float fMaxOrNull = SwipeableV2Kt.maxOrNull(this.this$0.getAnchors$compose_foundation_release());
                return Float.valueOf(fMaxOrNull != null ? fMaxOrNull.floatValue() : Float.POSITIVE_INFINITY);
            }
        });
        this.animationTarget = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.anchors = SnapshotStateKt.mutableStateOf$default(MapsKt.emptyMap(), (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public /* synthetic */ SwipeableV2State(Object obj, AnimationSpec animationSpec, AnonymousClass1 anonymousClass1, Function2 function2, float f, NestedScrollDispatcher nestedScrollDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i & 2) != 0 ? (AnimationSpec) SwipeableV2Defaults.INSTANCE.getAnimationSpec() : animationSpec, (i & 4) != 0 ? new Function1<T, Boolean>() { // from class: androidx.wear.compose.foundation.SwipeableV2State.1
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Boolean m433invoke(T t) {
                return true;
            }
        } : anonymousClass1, (i & 8) != 0 ? SwipeableV2Defaults.INSTANCE.getPositionalThreshold() : function2, (i & 16) != 0 ? SwipeableV2Defaults.INSTANCE.m424getVelocityThresholdD9Ej5fM() : f, (i & 32) != 0 ? null : nestedScrollDispatcher, null);
    }

    public final AnimationSpec<Float> getAnimationSpec$compose_foundation_release() {
        return this.animationSpec;
    }

    public final Function1<T, Boolean> getConfirmValueChange$compose_foundation_release() {
        return this.confirmValueChange;
    }

    public final Function2<Density, Float, Float> getPositionalThreshold$compose_foundation_release() {
        return this.positionalThreshold;
    }

    /* JADX INFO: renamed from: getVelocityThreshold-D9Ej5fM$compose_foundation_release, reason: not valid java name and from getter */
    public final float getVelocityThreshold() {
        return this.velocityThreshold;
    }

    /* JADX INFO: renamed from: getSwipeDraggableState$compose_foundation_release, reason: from getter */
    public final DraggableState getSwipeDraggableState() {
        return this.swipeDraggableState;
    }

    /* JADX INFO: renamed from: getOrientation$compose_foundation_release, reason: from getter */
    public final Orientation getOrientation() {
        return this.orientation;
    }

    public final void setOrientation$compose_foundation_release(Orientation orientation) {
        this.orientation = orientation;
    }

    private final void setCurrentValue(T t) {
        this.currentValue.setValue(t);
    }

    public final T getCurrentValue() {
        return (T) this.currentValue.getValue();
    }

    public final T getTargetValue() {
        return (T) this.targetValue.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setOffset(Float f) {
        this.offset.setValue(f);
    }

    public final Float getOffset() {
        return (Float) this.offset.getValue();
    }

    public final float requireOffset() {
        Float offset = getOffset();
        if (offset != null) {
            return offset.floatValue();
        }
        throw new IllegalStateException("The offset was read before being initialized. Did you access the offset in a phase before layout, like effects or composition?".toString());
    }

    public final boolean isAnimationRunning() {
        return getAnimationTarget() != null;
    }

    public final float getProgress() {
        return ((Number) this.progress.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setLastVelocity(float f) {
        this.lastVelocity.setFloatValue(f);
    }

    public final float getLastVelocity() {
        return this.lastVelocity.getFloatValue();
    }

    public final float getMinOffset() {
        return ((Number) this.minOffset.getValue()).floatValue();
    }

    public final float getMaxOffset() {
        return ((Number) this.maxOffset.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final T getAnimationTarget() {
        return (T) this.animationTarget.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setAnimationTarget(T t) {
        this.animationTarget.setValue(t);
    }

    public final Map<T, Float> getAnchors$compose_foundation_release() {
        return (Map) this.anchors.getValue();
    }

    public final void setAnchors$compose_foundation_release(Map<T, Float> map) {
        this.anchors.setValue(map);
    }

    /* JADX INFO: renamed from: getDensity$compose_foundation_release, reason: from getter */
    public final Density getDensity() {
        return this.density;
    }

    public final void setDensity$compose_foundation_release(Density density) {
        this.density = density;
    }

    public final boolean updateAnchors$compose_foundation_release(Map<T, Float> newAnchors) {
        boolean z;
        boolean zIsEmpty = getAnchors$compose_foundation_release().isEmpty();
        setAnchors$compose_foundation_release(newAnchors);
        if (zIsEmpty) {
            T currentValue = getCurrentValue();
            z = getAnchors$compose_foundation_release().get(currentValue) != null;
            if (z) {
                trySnapTo$compose_foundation_release(currentValue);
            }
        } else {
            z = true;
        }
        return (z && zIsEmpty) ? false : true;
    }

    public final boolean hasAnchorForValue(T value) {
        return getAnchors$compose_foundation_release().containsKey(value);
    }

    /* JADX INFO: renamed from: androidx.wear.compose.foundation.SwipeableV2State$snapTo$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SwipeableV2.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u008a@"}, d2 = {"<anonymous>", "", "T"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.wear.compose.foundation.SwipeableV2State$snapTo$2", f = "SwipeableV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C01072 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ T $targetValue;
        int label;
        final /* synthetic */ SwipeableV2State<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01072(SwipeableV2State<T> swipeableV2State, T t, Continuation<? super C01072> continuation) {
            super(1, continuation);
            this.this$0 = swipeableV2State;
            this.$targetValue = t;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C01072(this.this$0, this.$targetValue, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.this$0.snap(this.$targetValue);
            return Unit.INSTANCE;
        }
    }

    public final Object snapTo(T t, Continuation<? super Unit> continuation) {
        Object objSwipe$default = swipe$default(this, null, new C01072(this, t, null), continuation, 1, null);
        return objSwipe$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSwipe$default : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0085  */
    /* JADX WARN: Code duplicated, block: B:33:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:35:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:42:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:48:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:50:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x00eb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object animateTo(T t, float f, Continuation<? super Unit> continuation) throws Throwable {
        C01051 c01051;
        SwipeableV2State swipeableV2State;
        SwipeableV2State swipeableV2State2;
        float fRequireOffset;
        Iterator<T> it;
        T next;
        Object key;
        float fRequireOffset2;
        Iterator<T> it2;
        T next2;
        if (continuation instanceof C01051) {
            c01051 = (C01051) continuation;
            if ((c01051.label & Integer.MIN_VALUE) != 0) {
                c01051.label -= Integer.MIN_VALUE;
            } else {
                c01051 = new C01051(this, continuation);
            }
        } else {
            c01051 = new C01051(this, continuation);
        }
        C01051 c01052 = c01051;
        Object obj = c01052.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c01052.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Float f2 = getAnchors$compose_foundation_release().get(t);
            if (f2 != null) {
                try {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(this, t, f2, f, null);
                    c01052.L$0 = this;
                    c01052.label = 1;
                    if (swipe$default(this, null, anonymousClass2, c01052, 1, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    swipeableV2State2 = this;
                    swipeableV2State2.setAnimationTarget(null);
                    fRequireOffset2 = swipeableV2State2.requireOffset();
                    it2 = swipeableV2State2.getAnchors$compose_foundation_release().entrySet().iterator();
                    do {
                        if (it2.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it2.next();
                    } while (Math.abs(((Number) ((Map.Entry) next2).getValue()).floatValue() - fRequireOffset2) >= 0.5f);
                    Map.Entry entry = (Map.Entry) next2;
                    if (entry != null) {
                    }
                    if (key == null) {
                        key = swipeableV2State2.getCurrentValue();
                    }
                    swipeableV2State2.setCurrentValue(key);
                } catch (Throwable th) {
                    th = th;
                    swipeableV2State = this;
                    swipeableV2State.setAnimationTarget(null);
                    fRequireOffset = swipeableV2State.requireOffset();
                    it = swipeableV2State.getAnchors$compose_foundation_release().entrySet().iterator();
                    do {
                        if (it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (Math.abs(((Number) ((Map.Entry) next).getValue()).floatValue() - fRequireOffset) >= 0.5f);
                    Map.Entry entry2 = (Map.Entry) next;
                    if (entry2 != null) {
                    }
                    if (key == null) {
                        key = swipeableV2State.getCurrentValue();
                    }
                    swipeableV2State.setCurrentValue(key);
                    throw th;
                }
            } else {
                setCurrentValue(t);
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            swipeableV2State = (SwipeableV2State) c01052.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                swipeableV2State2 = swipeableV2State;
                swipeableV2State2.setAnimationTarget(null);
                fRequireOffset2 = swipeableV2State2.requireOffset();
                it2 = swipeableV2State2.getAnchors$compose_foundation_release().entrySet().iterator();
                do {
                    if (it2.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it2.next();
                } while (Math.abs(((Number) ((Map.Entry) next2).getValue()).floatValue() - fRequireOffset2) >= 0.5f);
                Map.Entry entry3 = (Map.Entry) next2;
                key = entry3 != null ? entry3.getKey() : null;
                if (key == null) {
                    key = swipeableV2State2.getCurrentValue();
                }
                swipeableV2State2.setCurrentValue(key);
            } catch (Throwable th2) {
                th = th2;
                swipeableV2State.setAnimationTarget(null);
                fRequireOffset = swipeableV2State.requireOffset();
                it = swipeableV2State.getAnchors$compose_foundation_release().entrySet().iterator();
                do {
                    if (it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (Math.abs(((Number) ((Map.Entry) next).getValue()).floatValue() - fRequireOffset) >= 0.5f);
                Map.Entry entry4 = (Map.Entry) next;
                key = entry4 != null ? entry4.getKey() : null;
                if (key == null) {
                    key = swipeableV2State.getCurrentValue();
                }
                swipeableV2State.setCurrentValue(key);
                throw th;
            }
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateTo$default(SwipeableV2State swipeableV2State, Object obj, float f, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            f = swipeableV2State.getLastVelocity();
        }
        return swipeableV2State.animateTo(obj, f, continuation);
    }

    /* JADX INFO: renamed from: androidx.wear.compose.foundation.SwipeableV2State$animateTo$2, reason: invalid class name */
    /* JADX INFO: compiled from: SwipeableV2.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u008a@"}, d2 = {"<anonymous>", "", "T"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.wear.compose.foundation.SwipeableV2State$animateTo$2", f = "SwipeableV2.kt", i = {}, l = {414}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Float $targetOffset;
        final /* synthetic */ T $targetValue;
        final /* synthetic */ float $velocity;
        int label;
        final /* synthetic */ SwipeableV2State<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(SwipeableV2State<T> swipeableV2State, T t, Float f, float f2, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.this$0 = swipeableV2State;
            this.$targetValue = t;
            this.$targetOffset = f;
            this.$velocity = f2;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, this.$targetValue, this.$targetOffset, this.$velocity, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.setAnimationTarget(this.$targetValue);
                final Ref.FloatRef floatRef = new Ref.FloatRef();
                Float offset = this.this$0.getOffset();
                floatRef.element = offset != null ? offset.floatValue() : 0.0f;
                float f = floatRef.element;
                float fFloatValue = this.$targetOffset.floatValue();
                float f2 = this.$velocity;
                AnimationSpec<Float> animationSpec$compose_foundation_release = this.this$0.getAnimationSpec$compose_foundation_release();
                final SwipeableV2State<T> swipeableV2State = this.this$0;
                this.label = 1;
                if (SuspendAnimationKt.animate(f, fFloatValue, f2, animationSpec$compose_foundation_release, new Function2<Float, Float, Unit>() { // from class: androidx.wear.compose.foundation.SwipeableV2State.animateTo.2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                        invoke(((Number) obj2).floatValue(), ((Number) obj3).floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f3, float f4) {
                        swipeableV2State.setOffset(Float.valueOf(f3));
                        floatRef.element = f3;
                        swipeableV2State.setLastVelocity(f4);
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
            this.this$0.setLastVelocity(0.0f);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:36:0x00be  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b8, code lost:
    
        if (r10.animateTo(r2, r11, r0) == r1) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ca, code lost:
    
        if (r10.animateTo(r11, r12, r0) == r1) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object settle(float r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.wear.compose.foundation.SwipeableV2State.settle(float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final float dispatchRawDelta(float delta) {
        float f;
        NestedScrollDispatcher nestedScrollDispatcher = this.nestedScrollDispatcher;
        if (nestedScrollDispatcher != null) {
            long j = nestedScrollDispatcher.dispatchPreScroll-OzD1aCk(m431offsetWithOrientationtuRUvjQ(delta), NestedScrollSource.Companion.getDrag-WNlRxjI());
            f = delta - (Offset.getX-impl(j) + Offset.getY-impl(j));
        } else {
            f = delta;
        }
        Float offset = getOffset();
        float fFloatValue = offset != null ? offset.floatValue() : 0.0f;
        float fCoerceIn = RangesKt.coerceIn(fFloatValue + f, getMinOffset(), getMaxOffset()) - fFloatValue;
        if (Math.abs(fCoerceIn) >= 0.0f) {
            Float offset2 = getOffset();
            setOffset(Float.valueOf(RangesKt.coerceIn((offset2 != null ? offset2.floatValue() : 0.0f) + fCoerceIn, getMinOffset(), getMaxOffset())));
        }
        NestedScrollDispatcher nestedScrollDispatcher2 = this.nestedScrollDispatcher;
        if (nestedScrollDispatcher2 == null) {
            return f;
        }
        long j2 = nestedScrollDispatcher2.dispatchPostScroll-DzOQY0M(m431offsetWithOrientationtuRUvjQ(fCoerceIn), m431offsetWithOrientationtuRUvjQ(delta - fCoerceIn), NestedScrollSource.Companion.getDrag-WNlRxjI());
        return f - ((fCoerceIn + Offset.getX-impl(j2)) + Offset.getY-impl(j2));
    }

    /* JADX INFO: renamed from: offsetWithOrientation-tuRUvjQ, reason: not valid java name */
    private final long m431offsetWithOrientationtuRUvjQ(float delta) {
        if (this.orientation == Orientation.Horizontal) {
            return OffsetKt.Offset(delta, 0.0f);
        }
        return OffsetKt.Offset(0.0f, delta);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final T computeTarget(float offset, T currentValue, float velocity) {
        Map<T, Float> anchors$compose_foundation_release = getAnchors$compose_foundation_release();
        Float f = anchors$compose_foundation_release.get(currentValue);
        Density densityRequireDensity = requireDensity();
        float f2 = densityRequireDensity.toPx-0680j_4(this.velocityThreshold);
        if (!Intrinsics.areEqual(f, offset) && f != null) {
            if (f.floatValue() < offset) {
                if (velocity >= f2) {
                    return (T) SwipeableV2Kt.closestAnchor(anchors$compose_foundation_release, offset, true);
                }
                T t = (T) SwipeableV2Kt.closestAnchor(anchors$compose_foundation_release, offset, true);
                float fAbs = Math.abs(f.floatValue() + Math.abs(((Number) this.positionalThreshold.invoke(densityRequireDensity, Float.valueOf(Math.abs(((Number) MapsKt.getValue(anchors$compose_foundation_release, t)).floatValue() - f.floatValue())))).floatValue()));
                if (offset >= 0.0f ? offset >= fAbs : Math.abs(offset) <= fAbs) {
                    return t;
                }
            } else {
                if (velocity <= (-f2)) {
                    return (T) SwipeableV2Kt.closestAnchor(anchors$compose_foundation_release, offset, false);
                }
                T t2 = (T) SwipeableV2Kt.closestAnchor(anchors$compose_foundation_release, offset, false);
                float fAbs2 = Math.abs(f.floatValue() - Math.abs(((Number) this.positionalThreshold.invoke(densityRequireDensity, Float.valueOf(Math.abs(f.floatValue() - ((Number) MapsKt.getValue(anchors$compose_foundation_release, t2)).floatValue())))).floatValue()));
                if (offset >= 0.0f ? offset <= fAbs2 : Math.abs(offset) >= fAbs2) {
                    return t2;
                }
            }
        }
        return currentValue;
    }

    private final Density requireDensity() {
        Density density = this.density;
        if (density != null) {
            return density;
        }
        throw new IllegalArgumentException(("SwipeableState did not have a density attached. Are you using Modifier.swipeable with this=" + this + " SwipeableState?").toString());
    }

    static /* synthetic */ Object swipe$default(SwipeableV2State swipeableV2State, MutatePriority mutatePriority, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return swipeableV2State.swipe(mutatePriority, function1, continuation);
    }

    /* JADX INFO: renamed from: androidx.wear.compose.foundation.SwipeableV2State$swipe$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SwipeableV2.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.wear.compose.foundation.SwipeableV2State$swipe$2", f = "SwipeableV2.kt", i = {}, l = {567}, m = "invokeSuspend", n = {}, s = {})
    static final class C01082 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Continuation<? super Unit>, Object> $action;
        final /* synthetic */ MutatePriority $swipePriority;
        int label;
        final /* synthetic */ SwipeableV2State<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01082(SwipeableV2State<T> swipeableV2State, MutatePriority mutatePriority, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super C01082> continuation) {
            super(2, continuation);
            this.this$0 = swipeableV2State;
            this.$swipePriority = mutatePriority;
            this.$action = function1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C01082(this.this$0, this.$swipePriority, this.$action, continuation);
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
                if (((SwipeableV2State) this.this$0).swipeMutex.mutate(this.$swipePriority, this.$action, (Continuation) this) == coroutine_suspended) {
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
    public final Object swipe(MutatePriority mutatePriority, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super Unit> continuation) {
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C01082(this, mutatePriority, function1, null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
    }

    public final boolean trySnapTo$compose_foundation_release(final T targetValue) {
        return this.swipeMutex.tryMutate(new Function0<Unit>(this) { // from class: androidx.wear.compose.foundation.SwipeableV2State$trySnapTo$1
            final /* synthetic */ SwipeableV2State<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m439invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m439invoke() {
                this.this$0.snap(targetValue);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void snap(T targetValue) {
        Float f = getAnchors$compose_foundation_release().get(targetValue);
        if (f != null) {
            float fFloatValue = f.floatValue();
            Float offset = getOffset();
            dispatchRawDelta(fFloatValue - (offset != null ? offset.floatValue() : 0.0f));
            setCurrentValue(targetValue);
            setAnimationTarget(null);
            return;
        }
        setCurrentValue(targetValue);
    }

    /* JADX INFO: compiled from: SwipeableV2.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0086\u0001\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\b\b\u0001\u0010\u0006*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\f0\u000b2,\u0010\r\u001a(\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\t0\u000e¢\u0006\u0002\b\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, d2 = {"Landroidx/wear/compose/foundation/SwipeableV2State$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/wear/compose/foundation/SwipeableV2State;", "T", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "Lkotlin/Function1;", "", "positionalThreshold", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/ParameterName;", "name", "distance", "Lkotlin/ExtensionFunctionType;", "velocityThreshold", "Landroidx/compose/ui/unit/Dp;", "Saver-eqLRuRQ", "(Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;F)Landroidx/compose/runtime/saveable/Saver;", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: Saver-eqLRuRQ, reason: not valid java name */
        public final <T> Saver<SwipeableV2State<T>, T> m434SavereqLRuRQ(final AnimationSpec<Float> animationSpec, final Function1<? super T, Boolean> confirmValueChange, final Function2<? super Density, ? super Float, Float> positionalThreshold, final float velocityThreshold) {
            return SaverKt.Saver(new Function2<SaverScope, SwipeableV2State<T>, T>() { // from class: androidx.wear.compose.foundation.SwipeableV2State$Companion$Saver$1
                public final T invoke(SaverScope saverScope, SwipeableV2State<T> swipeableV2State) {
                    return swipeableV2State.getCurrentValue();
                }
            }, new Function1<T, SwipeableV2State<T>>() { // from class: androidx.wear.compose.foundation.SwipeableV2State$Companion$Saver$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final SwipeableV2State<T> m435invoke(T t) {
                    return new SwipeableV2State<>(t, animationSpec, confirmValueChange, positionalThreshold, velocityThreshold, null, 32, null);
                }
            });
        }
    }
}
