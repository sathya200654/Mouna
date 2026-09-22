package androidx.wear.compose.material;

import androidx.compose.ui.unit.Density;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: Swipeable.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.wear.compose.material.SwipeableKt$swipeable$3$3$1", f = "Swipeable.kt", i = {}, l = {584}, m = "invokeSuspend", n = {}, s = {})
final class SwipeableKt$swipeable$3$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<Float, T> $anchors;
    final /* synthetic */ Density $density;
    final /* synthetic */ ResistanceConfig $resistance;
    final /* synthetic */ SwipeableState<T> $state;
    final /* synthetic */ Function2<T, T, ThresholdConfig> $thresholds;
    final /* synthetic */ float $velocityThreshold;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SwipeableKt$swipeable$3$3$1(SwipeableState<T> swipeableState, Map<Float, ? extends T> map, ResistanceConfig resistanceConfig, Density density, Function2<? super T, ? super T, ? extends ThresholdConfig> function2, float f, Continuation<? super SwipeableKt$swipeable$3$3$1> continuation) {
        super(2, continuation);
        this.$state = swipeableState;
        this.$anchors = map;
        this.$resistance = resistanceConfig;
        this.$density = density;
        this.$thresholds = function2;
        this.$velocityThreshold = f;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SwipeableKt$swipeable$3$3$1(this.$state, this.$anchors, this.$resistance, this.$density, this.$thresholds, this.$velocityThreshold, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Map anchors$compose_material_release = this.$state.getAnchors$compose_material_release();
            this.$state.setAnchors$compose_material_release(this.$anchors);
            this.$state.setResistance$compose_material_release(this.$resistance);
            SwipeableState<T> swipeableState = this.$state;
            final Map<Float, T> map = this.$anchors;
            final Function2<T, T, ThresholdConfig> function2 = this.$thresholds;
            final Density density = this.$density;
            swipeableState.setThresholds$compose_material_release(new Function2<Float, Float, Float>() { // from class: androidx.wear.compose.material.SwipeableKt$swipeable$3$3$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    return invoke(((Number) obj2).floatValue(), ((Number) obj3).floatValue());
                }

                public final Float invoke(float f, float f2) {
                    return Float.valueOf(((ThresholdConfig) function2.invoke(MapsKt.getValue(map, Float.valueOf(f)), MapsKt.getValue(map, Float.valueOf(f2)))).computeThreshold(density, f, f2));
                }
            });
            this.$state.setVelocityThreshold$compose_material_release(this.$density.toPx-0680j_4(this.$velocityThreshold));
            this.label = 1;
            if (this.$state.processNewAnchors$compose_material_release(anchors$compose_material_release, this.$anchors, (Continuation) this) == coroutine_suspended) {
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
