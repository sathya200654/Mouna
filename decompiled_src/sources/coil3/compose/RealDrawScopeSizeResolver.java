package coil3.compose;

import androidx.compose.ui.geometry.Size;
import coil3.compose.internal.UtilsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: compiled from: DrawScopeSizeResolver.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u000e\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\rR\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcoil3/compose/RealDrawScopeSizeResolver;", "Lcoil3/compose/DrawScopeSizeResolver;", "<init>", "()V", "latestSize", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/compose/ui/geometry/Size;", "connect", "", "sizes", "size", "Lcoil3/size/Size;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coil-compose-core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
final class RealDrawScopeSizeResolver implements DrawScopeSizeResolver {
    private final MutableSharedFlow<Flow<Size>> latestSize = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2, (Object) null);

    @Override // coil3.compose.DrawScopeSizeResolver
    public void connect(Flow<Size> sizes) {
        this.latestSize.tryEmit(sizes);
    }

    /* JADX INFO: renamed from: coil3.compose.RealDrawScopeSizeResolver$size$2, reason: invalid class name */
    /* JADX INFO: compiled from: DrawScopeSizeResolver.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Landroidx/compose/ui/geometry/Size;", "it", "Lkotlinx/coroutines/flow/Flow;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "coil3.compose.RealDrawScopeSizeResolver$size$2", f = "DrawScopeSizeResolver.kt", i = {0, 0}, l = {58}, m = "invokeSuspend", n = {"$this$transformLatest", "it"}, s = {"L$0", "L$1"})
    static final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<? super Size>, Flow<? extends Size>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        public final Object invoke(FlowCollector<? super Size> flowCollector, Flow<Size> flow, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = flowCollector;
            anonymousClass2.L$1 = flow;
            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Flow flow = (Flow) this.L$1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                this.L$1 = SpillingKt.nullOutSpilledVariable(flow);
                this.label = 1;
                if (FlowKt.emitAll(flowCollector, flow, (Continuation) this) == coroutine_suspended) {
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

    @Override // coil3.size.SizeResolver
    public Object size(Continuation<? super coil3.size.Size> continuation) {
        final Flow flowTransformLatest = FlowKt.transformLatest(this.latestSize, new AnonymousClass2(null));
        return FlowKt.first(new Flow<coil3.size.Size>() { // from class: coil3.compose.RealDrawScopeSizeResolver$size$$inlined$mapNotNull$1

            /* JADX INFO: renamed from: coil3.compose.RealDrawScopeSizeResolver$size$$inlined$mapNotNull$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: coil3.compose.RealDrawScopeSizeResolver$size$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "coil3.compose.RealDrawScopeSizeResolver$size$$inlined$mapNotNull$1$2", f = "DrawScopeSizeResolver.kt", i = {0, 0, 0, 0, 0, 0}, l = {52}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
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
                        coil3.size.Size sizeM1046toSizeOrNulluvyYCjk = UtilsKt.m1046toSizeOrNulluvyYCjk(((Size) obj).unbox-impl());
                        if (sizeM1046toSizeOrNulluvyYCjk != null) {
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(sizeM1046toSizeOrNulluvyYCjk);
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(sizeM1046toSizeOrNulluvyYCjk, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            public Object collect(FlowCollector flowCollector, Continuation continuation2) {
                Object objCollect = flowTransformLatest.collect(new AnonymousClass2(flowCollector), continuation2);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, continuation);
    }
}
