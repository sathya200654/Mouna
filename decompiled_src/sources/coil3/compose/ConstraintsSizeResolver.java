package coil3.compose;

import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import coil3.compose.internal.UtilsKt;
import coil3.size.Size;
import coil3.size.SizeResolver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: compiled from: ConstraintsSizeResolver.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eJ#\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\u0019R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcoil3/compose/ConstraintsSizeResolver;", "Lcoil3/size/SizeResolver;", "Landroidx/compose/ui/layout/LayoutModifier;", "<init>", "()V", "latestConstraints", "Landroidx/compose/ui/unit/Constraints;", "J", "continuations", "", "Lkotlin/coroutines/Continuation;", "", "size", "Lcoil3/size/Size;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "setConstraints", "setConstraints-BRTryo0", "(J)V", "coil-compose-core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ConstraintsSizeResolver implements SizeResolver, LayoutModifier {
    public static final int $stable = 0;
    private long latestConstraints = UtilsKt.getZeroConstraints();
    private List<Continuation<Unit>> continuations = new ArrayList();

    /* JADX INFO: renamed from: coil3.compose.ConstraintsSizeResolver$size$1, reason: invalid class name */
    /* JADX INFO: compiled from: ConstraintsSizeResolver.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "coil3.compose.ConstraintsSizeResolver", f = "ConstraintsSizeResolver.kt", i = {0, 0}, l = {77}, m = "size", n = {"continuation", "$i$f$suspendCancellableCoroutine"}, s = {"L$0", "I$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ConstraintsSizeResolver.this.size((Continuation) this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // coil3.size.SizeResolver
    public Object size(Continuation<? super Size> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Ref.ObjectRef objectRef;
        Throwable th;
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
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (Constraints.isZero-impl(this.latestConstraints)) {
                Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                try {
                    anonymousClass1.L$0 = objectRef2;
                    anonymousClass1.I$0 = 0;
                    anonymousClass1.label = 1;
                    CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted((Continuation) anonymousClass1), 1);
                    cancellableContinuationImpl.initCancellability();
                    CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
                    objectRef2.element = cancellableContinuation;
                    this.continuations.add(cancellableContinuation);
                    Object result = cancellableContinuationImpl.getResult();
                    if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended((Continuation) anonymousClass1);
                    }
                    if (result == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef = objectRef2;
                    TypeIntrinsics.asMutableCollection(this.continuations).remove(objectRef.element);
                } catch (Throwable th2) {
                    objectRef = objectRef2;
                    th = th2;
                    TypeIntrinsics.asMutableCollection(this.continuations).remove(objectRef.element);
                    throw th;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = anonymousClass1.I$0;
            objectRef = (Ref.ObjectRef) anonymousClass1.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                TypeIntrinsics.asMutableCollection(this.continuations).remove(objectRef.element);
            } catch (Throwable th3) {
                th = th3;
                TypeIntrinsics.asMutableCollection(this.continuations).remove(objectRef.element);
                throw th;
            }
        }
        return UtilsKt.m1045toSizeBRTryo0(this.latestConstraints);
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m1011measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        m1012setConstraintsBRTryo0(j);
        final Placeable placeable = measurable.measure-BRTryo0(j);
        return MeasureScope.layout$default(measureScope, placeable.getWidth(), placeable.getHeight(), (Map) null, new Function1() { // from class: coil3.compose.ConstraintsSizeResolver$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return ConstraintsSizeResolver.measure_3p2s80s$lambda$1(placeable, (Placeable.PlacementScope) obj);
            }
        }, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$1(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: setConstraints-BRTryo0, reason: not valid java name */
    public final void m1012setConstraintsBRTryo0(long constraints) {
        this.latestConstraints = constraints;
        if (Constraints.isZero-impl(constraints)) {
            return;
        }
        List<Continuation<Unit>> list = this.continuations;
        if (list.isEmpty()) {
            return;
        }
        this.continuations = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Continuation continuation = (Continuation) it.next();
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.constructor-impl(Unit.INSTANCE));
        }
    }
}
