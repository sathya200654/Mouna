package androidx.wear.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.DragScope;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: Swipeable.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0018\b\u0017\u0018\u0000 ~*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001~BB\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012#\b\u0002\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\b¢\u0006\u0002\u0010\rJ$\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020\u00062\f\u0010i\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0082@¢\u0006\u0002\u0010jJ&\u0010k\u001a\u00020g2\u0006\u0010W\u001a\u00028\u00002\u000e\b\u0002\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0087@¢\u0006\u0002\u0010mJ!\u0010n\u001a\u00020g2\u0012\u0010o\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0011H\u0000¢\u0006\u0002\bpJ\u0015\u0010q\u001a\u00020\u00062\u0006\u0010r\u001a\u00020\u0006H\u0000¢\u0006\u0002\bsJ\u0016\u0010t\u001a\u00020g2\u0006\u0010u\u001a\u00020\u0006H\u0087@¢\u0006\u0002\u0010vJ8\u0010w\u001a\u00020g2\u0012\u0010x\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u00112\u0012\u0010o\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0011H\u0080@¢\u0006\u0004\by\u0010zJ\u0016\u0010{\u001a\u00020g2\u0006\u0010h\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u0010vJ\u0016\u0010|\u001a\u00020g2\u0006\u0010W\u001a\u00028\u0000H\u0087@¢\u0006\u0002\u0010}R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000RC\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u00112\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u00118@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR1\u0010\u001f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u00008F@BX\u0087\u008e\u0002¢\u0006\u0018\n\u0004\b&\u0010\u0018\u0012\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010'\u001a\u00020\u00068FX\u0087\u0004¢\u0006\f\u0012\u0004\b(\u0010!\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020,X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u000e\u0010/\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0003\u001a\u00028\u0000X\u0080\u0004¢\u0006\n\n\u0002\u00101\u001a\u0004\b0\u0010#R1\u00102\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f8F@BX\u0087\u008e\u0002¢\u0006\u0018\n\u0004\b7\u0010\u0018\u0012\u0004\b3\u0010!\u001a\u0004\b2\u00104\"\u0004\b5\u00106R \u00108\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u001109X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010:\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010*\"\u0004\b<\u0010=R\u001a\u0010>\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010*\"\u0004\b@\u0010=R \u0010A\u001a\b\u0012\u0004\u0012\u00020\u00060B8FX\u0087\u0004¢\u0006\f\u0012\u0004\bC\u0010!\u001a\u0004\bD\u0010ER\u000e\u0010F\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010G\u001a\b\u0012\u0004\u0012\u00020\u00060B8FX\u0087\u0004¢\u0006\f\u0012\u0004\bH\u0010!\u001a\u0004\bI\u0010ER\u000e\u0010J\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000L8FX\u0087\u0004¢\u0006\f\u0012\u0004\bM\u0010!\u001a\u0004\bN\u0010OR/\u0010Q\u001a\u0004\u0018\u00010P2\b\u0010\u0010\u001a\u0004\u0018\u00010P8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bV\u0010\u0018\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u001a\u0010W\u001a\u00028\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\bX\u0010!\u001a\u0004\bY\u0010#RO\u0010[\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060Z2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060Z8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b`\u0010\u0018\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R+\u0010a\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00068@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bb\u0010*\"\u0004\bc\u0010=¨\u0006\u007f"}, d2 = {"Landroidx/wear/compose/material/SwipeableState;", "T", "", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "newValue", "", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;)V", "absoluteOffset", "Landroidx/compose/runtime/MutableFloatState;", "<set-?>", "", "anchors", "getAnchors$compose_material_release", "()Ljava/util/Map;", "setAnchors$compose_material_release", "(Ljava/util/Map;)V", "anchors$delegate", "Landroidx/compose/runtime/MutableState;", "getAnimationSpec$compose_material_release", "()Landroidx/compose/animation/core/AnimationSpec;", "animationTarget", "Landroidx/compose/runtime/MutableState;", "getConfirmStateChange$compose_material_release", "()Lkotlin/jvm/functions/Function1;", "currentValue", "getCurrentValue$annotations", "()V", "getCurrentValue", "()Ljava/lang/Object;", "setCurrentValue", "(Ljava/lang/Object;)V", "currentValue$delegate", "direction", "getDirection$annotations", "getDirection", "()F", "draggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "getDraggableState$compose_material_release", "()Landroidx/compose/foundation/gestures/DraggableState;", "initialOffset", "getInitialValue$compose_material_release", "Ljava/lang/Object;", "isAnimationRunning", "isAnimationRunning$annotations", "()Z", "setAnimationRunning", "(Z)V", "isAnimationRunning$delegate", "latestNonEmptyAnchorsFlow", "Lkotlinx/coroutines/flow/Flow;", "maxBound", "getMaxBound$compose_material_release", "setMaxBound$compose_material_release", "(F)V", "minBound", "getMinBound$compose_material_release", "setMinBound$compose_material_release", "offset", "Landroidx/compose/runtime/State;", "getOffset$annotations", "getOffset", "()Landroidx/compose/runtime/State;", "offsetState", "overflow", "getOverflow$annotations", "getOverflow", "overflowState", "progress", "Landroidx/wear/compose/material/SwipeProgress;", "getProgress$annotations", "getProgress", "()Landroidx/wear/compose/material/SwipeProgress;", "Landroidx/wear/compose/material/ResistanceConfig;", "resistance", "getResistance$compose_material_release", "()Landroidx/wear/compose/material/ResistanceConfig;", "setResistance$compose_material_release", "(Landroidx/wear/compose/material/ResistanceConfig;)V", "resistance$delegate", "targetValue", "getTargetValue$annotations", "getTargetValue", "Lkotlin/Function2;", "thresholds", "getThresholds$compose_material_release", "()Lkotlin/jvm/functions/Function2;", "setThresholds$compose_material_release", "(Lkotlin/jvm/functions/Function2;)V", "thresholds$delegate", "velocityThreshold", "getVelocityThreshold$compose_material_release", "setVelocityThreshold$compose_material_release", "velocityThreshold$delegate", "Landroidx/compose/runtime/MutableFloatState;", "animateInternalToOffset", "", "target", "spec", "(FLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateTo", "anim", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureInit", "newAnchors", "ensureInit$compose_material_release", "performDrag", "delta", "performDrag$compose_material_release", "performFling", "velocity", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processNewAnchors", "oldAnchors", "processNewAnchors$compose_material_release", "(Ljava/util/Map;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapInternalToOffset", "snapTo", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class SwipeableState<T> {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final MutableFloatState absoluteOffset;

    /* JADX INFO: renamed from: anchors$delegate, reason: from kotlin metadata */
    private final MutableState anchors;
    private final AnimationSpec<Float> animationSpec;
    private final MutableState<Float> animationTarget;
    private final Function1<T, Boolean> confirmStateChange;

    /* JADX INFO: renamed from: currentValue$delegate, reason: from kotlin metadata */
    private final MutableState currentValue;
    private final DraggableState draggableState;
    private float initialOffset;
    private final T initialValue;

    /* JADX INFO: renamed from: isAnimationRunning$delegate, reason: from kotlin metadata */
    private final MutableState isAnimationRunning;
    private final Flow<Map<Float, T>> latestNonEmptyAnchorsFlow;
    private float maxBound;
    private float minBound;
    private final MutableFloatState offsetState;
    private final MutableFloatState overflowState;

    /* JADX INFO: renamed from: resistance$delegate, reason: from kotlin metadata */
    private final MutableState resistance;

    /* JADX INFO: renamed from: thresholds$delegate, reason: from kotlin metadata */
    private final MutableState thresholds;

    /* JADX INFO: renamed from: velocityThreshold$delegate, reason: from kotlin metadata */
    private final MutableFloatState velocityThreshold;

    public static /* synthetic */ void getCurrentValue$annotations() {
    }

    public static /* synthetic */ void getDirection$annotations() {
    }

    public static /* synthetic */ void getOffset$annotations() {
    }

    public static /* synthetic */ void getOverflow$annotations() {
    }

    public static /* synthetic */ void getProgress$annotations() {
    }

    public static /* synthetic */ void getTargetValue$annotations() {
    }

    public static /* synthetic */ void isAnimationRunning$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SwipeableState(T t, AnimationSpec<Float> animationSpec, Function1<? super T, Boolean> function1) {
        this.initialValue = t;
        this.animationSpec = animationSpec;
        this.confirmStateChange = function1;
        this.currentValue = SnapshotStateKt.mutableStateOf$default(t, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.isAnimationRunning = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.offsetState = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.overflowState = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.absoluteOffset = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.animationTarget = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.anchors = SnapshotStateKt.mutableStateOf$default(MapsKt.emptyMap(), (SnapshotMutationPolicy) null, 2, (Object) null);
        final Flow flowSnapshotFlow = SnapshotStateKt.snapshotFlow(new Function0<Map<Float, ? extends T>>(this) { // from class: androidx.wear.compose.material.SwipeableState$latestNonEmptyAnchorsFlow$1
            final /* synthetic */ SwipeableState<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            public final Map<Float, T> invoke() {
                return this.this$0.getAnchors$compose_material_release();
            }
        });
        this.latestNonEmptyAnchorsFlow = FlowKt.take(new Flow<Map<Float, ? extends T>>() { // from class: androidx.wear.compose.material.SwipeableState$special$$inlined$filter$1

            /* JADX INFO: renamed from: androidx.wear.compose.material.SwipeableState$special$$inlined$filter$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 8, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: androidx.wear.compose.material.SwipeableState$special$$inlined$filter$1$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "androidx.wear.compose.material.SwipeableState$special$$inlined$filter$1$2", f = "Swipeable.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                public final Object emit(Object obj, Continuation continuation) {
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
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        if (!((Map) obj).isEmpty()) {
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(obj, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = flowSnapshotFlow.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, 1);
        this.minBound = Float.NEGATIVE_INFINITY;
        this.maxBound = Float.POSITIVE_INFINITY;
        this.thresholds = SnapshotStateKt.mutableStateOf$default(new Function2<Float, Float, Float>() { // from class: androidx.wear.compose.material.SwipeableState$thresholds$2
            public final Float invoke(float f, float f2) {
                return Float.valueOf(0.0f);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke(((Number) obj).floatValue(), ((Number) obj2).floatValue());
            }
        }, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.velocityThreshold = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.resistance = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.draggableState = DraggableKt.DraggableState(new Function1<Float, Unit>(this) { // from class: androidx.wear.compose.material.SwipeableState$draggableState$1
            final /* synthetic */ SwipeableState<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(float f) {
                float floatValue = ((SwipeableState) this.this$0).absoluteOffset.getFloatValue() + f;
                float fCoerceIn = RangesKt.coerceIn(floatValue, this.this$0.getMinBound(), this.this$0.getMaxBound());
                float f2 = floatValue - fCoerceIn;
                ResistanceConfig resistance$compose_material_release = this.this$0.getResistance$compose_material_release();
                ((SwipeableState) this.this$0).offsetState.setFloatValue(fCoerceIn + (resistance$compose_material_release != null ? resistance$compose_material_release.computeResistance(f2) : 0.0f));
                ((SwipeableState) this.this$0).overflowState.setFloatValue(f2);
                ((SwipeableState) this.this$0).absoluteOffset.setFloatValue(floatValue);
            }
        });
    }

    public final T getInitialValue$compose_material_release() {
        return this.initialValue;
    }

    public /* synthetic */ SwipeableState(Object obj, AnimationSpec animationSpec, AnonymousClass1 anonymousClass1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i & 2) != 0 ? (AnimationSpec) SwipeableDefaults.INSTANCE.getAnimationSpec() : animationSpec, (i & 4) != 0 ? new Function1<T, Boolean>() { // from class: androidx.wear.compose.material.SwipeableState.1
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Boolean m838invoke(T t) {
                return true;
            }
        } : anonymousClass1);
    }

    public final AnimationSpec<Float> getAnimationSpec$compose_material_release() {
        return this.animationSpec;
    }

    public final Function1<T, Boolean> getConfirmStateChange$compose_material_release() {
        return this.confirmStateChange;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCurrentValue(T t) {
        this.currentValue.setValue(t);
    }

    public final T getCurrentValue() {
        return (T) this.currentValue.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setAnimationRunning(boolean z) {
        this.isAnimationRunning.setValue(Boolean.valueOf(z));
    }

    public final boolean isAnimationRunning() {
        return ((Boolean) this.isAnimationRunning.getValue()).booleanValue();
    }

    public final State<Float> getOffset() {
        return this.offsetState;
    }

    public final State<Float> getOverflow() {
        return this.overflowState;
    }

    public final Map<Float, T> getAnchors$compose_material_release() {
        return (Map) this.anchors.getValue();
    }

    public final void setAnchors$compose_material_release(Map<Float, ? extends T> map) {
        this.anchors.setValue(map);
    }

    /* JADX INFO: renamed from: getMinBound$compose_material_release, reason: from getter */
    public final float getMinBound() {
        return this.minBound;
    }

    public final void setMinBound$compose_material_release(float f) {
        this.minBound = f;
    }

    /* JADX INFO: renamed from: getMaxBound$compose_material_release, reason: from getter */
    public final float getMaxBound() {
        return this.maxBound;
    }

    public final void setMaxBound$compose_material_release(float f) {
        this.maxBound = f;
    }

    public final void ensureInit$compose_material_release(Map<Float, ? extends T> newAnchors) {
        if (getAnchors$compose_material_release().isEmpty()) {
            Float offset = SwipeableKt.getOffset(newAnchors, getCurrentValue());
            if (offset == null) {
                throw new IllegalArgumentException("The initial value must have an associated anchor.".toString());
            }
            this.offsetState.setFloatValue(offset.floatValue());
            this.absoluteOffset.setFloatValue(offset.floatValue());
            this.initialOffset = offset.floatValue();
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code duplicated, block: B:82:0x0221  */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a9, code lost:
    
        if (snapInternalToOffset(r11, r0) == r1) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01dc, code lost:
    
        if (r13 == r1) goto L81;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [androidx.wear.compose.material.SwipeableState, androidx.wear.compose.material.SwipeableState<T>, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v3, types: [androidx.wear.compose.material.SwipeableState] */
    /* JADX WARN: Type inference failed for: r10v32 */
    /* JADX WARN: Type inference failed for: r10v33 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5, types: [androidx.wear.compose.material.SwipeableState, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v7, types: [androidx.wear.compose.material.SwipeableState] */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v40, types: [float] */
    /* JADX WARN: Type inference failed for: r11v51 */
    /* JADX WARN: Type inference failed for: r11v52 */
    /* JADX WARN: Type inference failed for: r11v53 */
    /* JADX WARN: Type inference failed for: r11v54, types: [float] */
    /* JADX WARN: Type inference failed for: r11v65, types: [androidx.wear.compose.material.SwipeableState] */
    /* JADX WARN: Type inference failed for: r11v66 */
    /* JADX WARN: Type inference failed for: r11v70 */
    /* JADX WARN: Type inference failed for: r11v71 */
    /* JADX WARN: Type inference failed for: r11v81 */
    /* JADX WARN: Type inference failed for: r11v82 */
    /* JADX WARN: Type inference failed for: r11v83 */
    /* JADX WARN: Type inference failed for: r11v84 */
    /* JADX WARN: Type inference failed for: r11v85 */
    /* JADX WARN: Type inference failed for: r11v86 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object processNewAnchors$compose_material_release(java.util.Map<java.lang.Float, ? extends T> r11, java.util.Map<java.lang.Float, ? extends T> r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 652
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.wear.compose.material.SwipeableState.processNewAnchors$compose_material_release(java.util.Map, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Function2<Float, Float, Float> getThresholds$compose_material_release() {
        return (Function2) this.thresholds.getValue();
    }

    public final void setThresholds$compose_material_release(Function2<? super Float, ? super Float, Float> function2) {
        this.thresholds.setValue(function2);
    }

    public final float getVelocityThreshold$compose_material_release() {
        return this.velocityThreshold.getFloatValue();
    }

    public final void setVelocityThreshold$compose_material_release(float f) {
        this.velocityThreshold.setFloatValue(f);
    }

    public final ResistanceConfig getResistance$compose_material_release() {
        return (ResistanceConfig) this.resistance.getValue();
    }

    public final void setResistance$compose_material_release(ResistanceConfig resistanceConfig) {
        this.resistance.setValue(resistanceConfig);
    }

    /* JADX INFO: renamed from: getDraggableState$compose_material_release, reason: from getter */
    public final DraggableState getDraggableState() {
        return this.draggableState;
    }

    /* JADX INFO: renamed from: androidx.wear.compose.material.SwipeableState$snapInternalToOffset$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Swipeable.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/gestures/DragScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.wear.compose.material.SwipeableState$snapInternalToOffset$2", f = "Swipeable.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C01502 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $target;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SwipeableState<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01502(float f, SwipeableState<T> swipeableState, Continuation<? super C01502> continuation) {
            super(2, continuation);
            this.$target = f;
            this.this$0 = swipeableState;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c01502 = new C01502(this.$target, this.this$0, continuation);
            c01502.L$0 = obj;
            return c01502;
        }

        public final Object invoke(DragScope dragScope, Continuation<? super Unit> continuation) {
            return create(dragScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ((DragScope) this.L$0).dragBy(this.$target - ((SwipeableState) this.this$0).absoluteOffset.getFloatValue());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object snapInternalToOffset(float f, Continuation<? super Unit> continuation) {
        Object objDrag$default = DraggableState.drag$default(this.draggableState, (MutatePriority) null, new C01502(f, this, null), continuation, 1, (Object) null);
        return objDrag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDrag$default : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.wear.compose.material.SwipeableState$animateInternalToOffset$2, reason: invalid class name */
    /* JADX INFO: compiled from: Swipeable.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/gestures/DragScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.wear.compose.material.SwipeableState$animateInternalToOffset$2", f = "Swipeable.kt", i = {}, l = {235}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AnimationSpec<Float> $spec;
        final /* synthetic */ float $target;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SwipeableState<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(SwipeableState<T> swipeableState, float f, AnimationSpec<Float> animationSpec, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = swipeableState;
            this.$target = f;
            this.$spec = animationSpec;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass2 = new AnonymousClass2(this.this$0, this.$target, this.$spec, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        public final Object invoke(DragScope dragScope, Continuation<? super Unit> continuation) {
            return create(dragScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    final DragScope dragScope = (DragScope) this.L$0;
                    final Ref.FloatRef floatRef = new Ref.FloatRef();
                    floatRef.element = ((SwipeableState) this.this$0).absoluteOffset.getFloatValue();
                    ((SwipeableState) this.this$0).animationTarget.setValue(Boxing.boxFloat(this.$target));
                    this.this$0.setAnimationRunning(true);
                    this.label = 1;
                    if (Animatable.animateTo$default(AnimatableKt.Animatable$default(floatRef.element, 0.0f, 2, (Object) null), Boxing.boxFloat(this.$target), this.$spec, (Object) null, new Function1<Animatable<Float, AnimationVector1D>, Unit>() { // from class: androidx.wear.compose.material.SwipeableState.animateInternalToOffset.2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                            invoke((Animatable<Float, AnimationVector1D>) obj2);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Animatable<Float, AnimationVector1D> animatable) {
                            dragScope.dragBy(((Number) animatable.getValue()).floatValue() - floatRef.element);
                            floatRef.element = ((Number) animatable.getValue()).floatValue();
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
                ((SwipeableState) this.this$0).animationTarget.setValue((Object) null);
                this.this$0.setAnimationRunning(false);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                ((SwipeableState) this.this$0).animationTarget.setValue((Object) null);
                this.this$0.setAnimationRunning(false);
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object animateInternalToOffset(float f, AnimationSpec<Float> animationSpec, Continuation<? super Unit> continuation) {
        Object objDrag$default = DraggableState.drag$default(this.draggableState, (MutatePriority) null, new AnonymousClass2(this, f, animationSpec, null), continuation, 1, (Object) null);
        return objDrag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDrag$default : Unit.INSTANCE;
    }

    public final T getTargetValue() {
        float fComputeTarget;
        Float f = (Float) this.animationTarget.getValue();
        if (f != null) {
            fComputeTarget = f.floatValue();
        } else {
            float fFloatValue = ((Number) getOffset().getValue()).floatValue();
            Float offset = SwipeableKt.getOffset(getAnchors$compose_material_release(), getCurrentValue());
            fComputeTarget = SwipeableKt.computeTarget(fFloatValue, offset != null ? offset.floatValue() : ((Number) getOffset().getValue()).floatValue(), getAnchors$compose_material_release().keySet(), getThresholds$compose_material_release(), 0.0f, Float.POSITIVE_INFINITY);
        }
        T t = getAnchors$compose_material_release().get(Float.valueOf(fComputeTarget));
        return t == null ? getCurrentValue() : t;
    }

    public final SwipeProgress<T> getProgress() {
        Object currentValue;
        float fFloatValue;
        Object value;
        Pair pair;
        List listFindBounds = SwipeableKt.findBounds(((Number) getOffset().getValue()).floatValue(), getAnchors$compose_material_release().keySet());
        int size = listFindBounds.size();
        if (size == 0) {
            T currentValue2 = getCurrentValue();
            currentValue = getCurrentValue();
            fFloatValue = 1.0f;
            value = currentValue2;
        } else if (size == 1) {
            Object value2 = MapsKt.getValue(getAnchors$compose_material_release(), listFindBounds.get(0));
            currentValue = MapsKt.getValue(getAnchors$compose_material_release(), listFindBounds.get(0));
            fFloatValue = 1.0f;
            value = value2;
        } else {
            if (getDirection() > 0.0f) {
                pair = TuplesKt.to(listFindBounds.get(0), listFindBounds.get(1));
            } else {
                pair = TuplesKt.to(listFindBounds.get(1), listFindBounds.get(0));
            }
            float fFloatValue2 = ((Number) pair.component1()).floatValue();
            float fFloatValue3 = ((Number) pair.component2()).floatValue();
            value = MapsKt.getValue(getAnchors$compose_material_release(), Float.valueOf(fFloatValue2));
            currentValue = MapsKt.getValue(getAnchors$compose_material_release(), Float.valueOf(fFloatValue3));
            fFloatValue = (((Number) getOffset().getValue()).floatValue() - fFloatValue2) / (fFloatValue3 - fFloatValue2);
        }
        return new SwipeProgress<>(value, currentValue, fFloatValue);
    }

    public final float getDirection() {
        Float offset = SwipeableKt.getOffset(getAnchors$compose_material_release(), getCurrentValue());
        if (offset == null) {
            return 0.0f;
        }
        return Math.signum(((Number) getOffset().getValue()).floatValue() - offset.floatValue());
    }

    /* JADX INFO: renamed from: androidx.wear.compose.material.SwipeableState$snapTo$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Swipeable.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "anchors", "", "", "emit", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C01512<T> implements FlowCollector {
        final /* synthetic */ T $targetValue;
        final /* synthetic */ SwipeableState<T> this$0;

        C01512(T t, SwipeableState<T> swipeableState) {
            this.$targetValue = t;
            this.this$0 = swipeableState;
        }

        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return emit((Map) obj, (Continuation<? super Unit>) continuation);
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
        public final Object emit(Map<Float, ? extends T> map, Continuation<? super Unit> continuation) {
            SwipeableState$snapTo$2$emit$1 swipeableState$snapTo$2$emit$1;
            if (continuation instanceof SwipeableState$snapTo$2$emit$1) {
                swipeableState$snapTo$2$emit$1 = (SwipeableState$snapTo$2$emit$1) continuation;
                if ((swipeableState$snapTo$2$emit$1.label & Integer.MIN_VALUE) != 0) {
                    swipeableState$snapTo$2$emit$1.label -= Integer.MIN_VALUE;
                } else {
                    swipeableState$snapTo$2$emit$1 = new SwipeableState$snapTo$2$emit$1(this, continuation);
                }
            } else {
                swipeableState$snapTo$2$emit$1 = new SwipeableState$snapTo$2$emit$1(this, continuation);
            }
            Object obj = swipeableState$snapTo$2$emit$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = swipeableState$snapTo$2$emit$1.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Float offset = SwipeableKt.getOffset(map, this.$targetValue);
                if (offset == null) {
                    throw new IllegalArgumentException("The target value must have an associated anchor.".toString());
                }
                SwipeableState<T> swipeableState = this.this$0;
                float fFloatValue = offset.floatValue();
                swipeableState$snapTo$2$emit$1.L$0 = this;
                swipeableState$snapTo$2$emit$1.label = 1;
                if (swipeableState.snapInternalToOffset(fFloatValue, swipeableState$snapTo$2$emit$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                this = (C01512) swipeableState$snapTo$2$emit$1.L$0;
                ResultKt.throwOnFailure(obj);
            }
            this.this$0.setCurrentValue(this.$targetValue);
            return Unit.INSTANCE;
        }
    }

    public final Object snapTo(T t, Continuation<? super Unit> continuation) {
        Object objCollect = this.latestNonEmptyAnchorsFlow.collect(new C01512(t, this), continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.wear.compose.material.SwipeableState$animateTo$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Swipeable.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "anchors", "", "", "emit", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C01482<T> implements FlowCollector {
        final /* synthetic */ AnimationSpec<Float> $anim;
        final /* synthetic */ T $targetValue;
        final /* synthetic */ SwipeableState<T> this$0;

        C01482(T t, SwipeableState<T> swipeableState, AnimationSpec<Float> animationSpec) {
            this.$targetValue = t;
            this.this$0 = swipeableState;
            this.$anim = animationSpec;
        }

        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return emit((Map) obj, (Continuation<? super Unit>) continuation);
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
        public final Object emit(Map<Float, ? extends T> map, Continuation<? super Unit> continuation) {
            SwipeableState$animateTo$2$emit$1 swipeableState$animateTo$2$emit$1;
            if (continuation instanceof SwipeableState$animateTo$2$emit$1) {
                swipeableState$animateTo$2$emit$1 = (SwipeableState$animateTo$2$emit$1) continuation;
                if ((swipeableState$animateTo$2$emit$1.label & Integer.MIN_VALUE) != 0) {
                    swipeableState$animateTo$2$emit$1.label -= Integer.MIN_VALUE;
                } else {
                    swipeableState$animateTo$2$emit$1 = new SwipeableState$animateTo$2$emit$1(this, continuation);
                }
            } else {
                swipeableState$animateTo$2$emit$1 = new SwipeableState$animateTo$2$emit$1(this, continuation);
            }
            Object obj = swipeableState$animateTo$2$emit$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = swipeableState$animateTo$2$emit$1.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Float offset = SwipeableKt.getOffset(map, this.$targetValue);
                    if (offset == null) {
                        throw new IllegalArgumentException("The target value must have an associated anchor.".toString());
                    }
                    SwipeableState<T> swipeableState = this.this$0;
                    float fFloatValue = offset.floatValue();
                    AnimationSpec<Float> animationSpec = this.$anim;
                    swipeableState$animateTo$2$emit$1.L$0 = this;
                    swipeableState$animateTo$2$emit$1.L$1 = map;
                    swipeableState$animateTo$2$emit$1.label = 1;
                    if (swipeableState.animateInternalToOffset(fFloatValue, animationSpec, swipeableState$animateTo$2$emit$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    map = (Map) swipeableState$animateTo$2$emit$1.L$1;
                    this = (C01482) swipeableState$animateTo$2$emit$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                float floatValue = ((SwipeableState) this.this$0).absoluteOffset.getFloatValue();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<Float, ? extends T> entry : map.entrySet()) {
                    if (Math.abs(entry.getKey().floatValue() - floatValue) < 0.5f) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                Object objFirstOrNull = CollectionsKt.firstOrNull(linkedHashMap.values());
                if (objFirstOrNull == null) {
                    objFirstOrNull = this.this$0.getCurrentValue();
                }
                this.this$0.setCurrentValue(objFirstOrNull);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                float floatValue2 = ((SwipeableState) this.this$0).absoluteOffset.getFloatValue();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for (Map.Entry<Float, ? extends T> entry2 : map.entrySet()) {
                    if (Math.abs(entry2.getKey().floatValue() - floatValue2) < 0.5f) {
                        linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                    }
                }
                Object objFirstOrNull2 = CollectionsKt.firstOrNull(linkedHashMap2.values());
                if (objFirstOrNull2 == null) {
                    objFirstOrNull2 = this.this$0.getCurrentValue();
                }
                this.this$0.setCurrentValue(objFirstOrNull2);
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateTo$default(SwipeableState swipeableState, Object obj, AnimationSpec animationSpec, Continuation continuation, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateTo");
        }
        if ((i & 2) != 0) {
            animationSpec = swipeableState.animationSpec;
        }
        return swipeableState.animateTo(obj, animationSpec, continuation);
    }

    public final Object animateTo(T t, AnimationSpec<Float> animationSpec, Continuation<? super Unit> continuation) {
        Object objCollect = this.latestNonEmptyAnchorsFlow.collect(new C01482(t, this, animationSpec), continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }

    public final Object performFling(final float f, Continuation<? super Unit> continuation) {
        Object objCollect = this.latestNonEmptyAnchorsFlow.collect(new FlowCollector(this) { // from class: androidx.wear.compose.material.SwipeableState.performFling.2
            final /* synthetic */ SwipeableState<T> this$0;

            {
                this.this$0 = this;
            }

            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation2) {
                return emit((Map) obj, (Continuation<? super Unit>) continuation2);
            }

            public final Object emit(Map<Float, ? extends T> map, Continuation<? super Unit> continuation2) {
                Float offset = SwipeableKt.getOffset(map, this.this$0.getCurrentValue());
                Intrinsics.checkNotNull(offset);
                float fFloatValue = offset.floatValue();
                T t = map.get(Boxing.boxFloat(SwipeableKt.computeTarget(((Number) this.this$0.getOffset().getValue()).floatValue(), fFloatValue, map.keySet(), this.this$0.getThresholds$compose_material_release(), f, this.this$0.getVelocityThreshold$compose_material_release())));
                if (t != null && ((Boolean) this.this$0.getConfirmStateChange$compose_material_release().invoke(t)).booleanValue()) {
                    Object objAnimateTo$default = SwipeableState.animateTo$default(this.this$0, t, null, continuation2, 2, null);
                    return objAnimateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateTo$default : Unit.INSTANCE;
                }
                SwipeableState<T> swipeableState = this.this$0;
                Object objAnimateInternalToOffset = swipeableState.animateInternalToOffset(fFloatValue, swipeableState.getAnimationSpec$compose_material_release(), continuation2);
                return objAnimateInternalToOffset == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateInternalToOffset : Unit.INSTANCE;
            }
        }, continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }

    public final float performDrag$compose_material_release(float delta) {
        float fCoerceIn = RangesKt.coerceIn(this.absoluteOffset.getFloatValue() + delta, this.minBound, this.maxBound) - this.absoluteOffset.getFloatValue();
        if (Math.abs(fCoerceIn) > 0.0f) {
            this.draggableState.dispatchRawDelta(fCoerceIn);
        }
        return fCoerceIn;
    }

    /* JADX INFO: compiled from: Swipeable.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JD\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\b\b\u0001\u0010\u0006*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\f0\u000b¨\u0006\r"}, d2 = {"Landroidx/wear/compose/material/SwipeableState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/wear/compose/material/SwipeableState;", "T", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "", "compose-material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <T> Saver<SwipeableState<T>, T> Saver(final AnimationSpec<Float> animationSpec, final Function1<? super T, Boolean> confirmStateChange) {
            return SaverKt.Saver(new Function2<SaverScope, SwipeableState<T>, T>() { // from class: androidx.wear.compose.material.SwipeableState$Companion$Saver$1
                public final T invoke(SaverScope saverScope, SwipeableState<T> swipeableState) {
                    return swipeableState.getCurrentValue();
                }
            }, new Function1<T, SwipeableState<T>>() { // from class: androidx.wear.compose.material.SwipeableState$Companion$Saver$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final SwipeableState<T> m839invoke(T t) {
                    return new SwipeableState<>(t, animationSpec, confirmStateChange);
                }
            });
        }
    }
}
