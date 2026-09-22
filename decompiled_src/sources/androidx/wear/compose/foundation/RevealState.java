package androidx.wear.compose.foundation;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.unit.Density;
import androidx.core.util.Predicate;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: compiled from: SwipeToReveal.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001:\u0001FB\u0083\u0001\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b\u0012,\u0010\n\u001a(\u0012\u0004\u0012\u00020\f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0002\b\u0010\u0012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J\u001b\u00106\u001a\u0002072\u0006\u00104\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b8\u00109J(\u0010:\u001a\u00020\t2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030;2\u0006\u0010<\u001a\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\b=\u0010>J\r\u0010?\u001a\u00020\u0006H\u0000¢\u0006\u0002\b@J\u0016\u0010A\u001a\u0002072\u0006\u0010B\u001a\u00020\u0000H\u0082@¢\u0006\u0002\u0010CJ\u001b\u0010D\u001a\u0002072\u0006\u00104\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\bE\u00109R \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0013\u001a\u00020\u0014X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001c\u001a\u00020\u00038Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R1\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"8F@FX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b$\u0010\u001e\"\u0004\b%\u0010&R\u0014\u0010\u0015\u001a\u00020\u0016X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b,\u0010-R\u001d\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00128F¢\u0006\u0006\u001a\u0004\b/\u0010\u0019R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\u000301X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0017\u00104\u001a\u00020\u00038Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b5\u0010\u001e\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006G"}, d2 = {"Landroidx/wear/compose/foundation/RevealState;", "", "initialValue", "Landroidx/wear/compose/foundation/RevealValue;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "Lkotlin/Function1;", "", "positionalThreshold", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/ParameterName;", "name", "totalDistance", "Lkotlin/ExtensionFunctionType;", "anchors", "", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "nestedScrollDispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "(ILandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Ljava/util/Map;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAnchors$compose_foundation_release", "()Ljava/util/Map;", "getCoroutineScope$compose_foundation_release", "()Lkotlinx/coroutines/CoroutineScope;", "currentValue", "getCurrentValue-EhNvi2Q", "()I", "isAnimationRunning", "()Z", "<set-?>", "Landroidx/wear/compose/foundation/RevealActionType;", "lastActionType", "getLastActionType-Bxv7xxc", "setLastActionType-zcPJnak", "(I)V", "lastActionType$delegate", "Landroidx/compose/runtime/MutableState;", "getNestedScrollDispatcher$compose_foundation_release", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "offset", "getOffset", "()F", "swipeAnchors", "getSwipeAnchors", "swipeableState", "Landroidx/wear/compose/foundation/SwipeableV2State;", "getSwipeableState$compose_foundation_release", "()Landroidx/wear/compose/foundation/SwipeableV2State;", "targetValue", "getTargetValue-EhNvi2Q", "animateTo", "", "animateTo-HVQT5Qc", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmValueChangeAndReset", "Landroidx/core/util/Predicate;", "revealValue", "confirmValueChangeAndReset-TIIb0GA", "(Landroidx/core/util/Predicate;I)Z", "requireOffset", "requireOffset$compose_foundation_release", "resetLastState", "currentState", "(Landroidx/wear/compose/foundation/RevealState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapTo", "snapTo-HVQT5Qc", "SingleSwipeCoordinator", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RevealState {
    public static final int $stable = 8;
    private final Map<RevealValue, Float> anchors;
    private final CoroutineScope coroutineScope;

    /* JADX INFO: renamed from: lastActionType$delegate, reason: from kotlin metadata */
    private final MutableState lastActionType;
    private final NestedScrollDispatcher nestedScrollDispatcher;
    private final SwipeableV2State<RevealValue> swipeableState;

    public /* synthetic */ RevealState(int i, AnimationSpec animationSpec, Function1 function1, Function2 function2, Map map, CoroutineScope coroutineScope, NestedScrollDispatcher nestedScrollDispatcher, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, animationSpec, function1, function2, map, coroutineScope, nestedScrollDispatcher);
    }

    private RevealState(int i, AnimationSpec<Float> animationSpec, Function1<? super RevealValue, Boolean> function1, Function2<? super Density, ? super Float, Float> function2, Map<RevealValue, Float> map, CoroutineScope coroutineScope, NestedScrollDispatcher nestedScrollDispatcher) {
        this.anchors = map;
        this.coroutineScope = coroutineScope;
        this.nestedScrollDispatcher = nestedScrollDispatcher;
        this.swipeableState = new SwipeableV2State<>(RevealValue.m398boximpl(i), animationSpec, new RevealState$swipeableState$1(this, function1), function2, 0.0f, nestedScrollDispatcher, 16, null);
        this.lastActionType = SnapshotStateKt.mutableStateOf$default(RevealActionType.m377boximpl(RevealActionType.INSTANCE.m384getNoneBxv7xxc()), (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public final Map<RevealValue, Float> getAnchors$compose_foundation_release() {
        return this.anchors;
    }

    /* JADX INFO: renamed from: getCoroutineScope$compose_foundation_release, reason: from getter */
    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    /* JADX INFO: renamed from: getNestedScrollDispatcher$compose_foundation_release, reason: from getter */
    public final NestedScrollDispatcher getNestedScrollDispatcher() {
        return this.nestedScrollDispatcher;
    }

    public final SwipeableV2State<RevealValue> getSwipeableState$compose_foundation_release() {
        return this.swipeableState;
    }

    /* JADX INFO: renamed from: getLastActionType-Bxv7xxc, reason: not valid java name */
    public final int m393getLastActionTypeBxv7xxc() {
        return ((RevealActionType) this.lastActionType.getValue()).m383unboximpl();
    }

    /* JADX INFO: renamed from: setLastActionType-zcPJnak, reason: not valid java name */
    public final void m395setLastActionTypezcPJnak(int i) {
        this.lastActionType.setValue(RevealActionType.m377boximpl(i));
    }

    /* JADX INFO: renamed from: getCurrentValue-EhNvi2Q, reason: not valid java name */
    public final int m392getCurrentValueEhNvi2Q() {
        return this.swipeableState.getCurrentValue().m404unboximpl();
    }

    /* JADX INFO: renamed from: getTargetValue-EhNvi2Q, reason: not valid java name */
    public final int m394getTargetValueEhNvi2Q() {
        return this.swipeableState.getTargetValue().m404unboximpl();
    }

    public final boolean isAnimationRunning() {
        return this.swipeableState.isAnimationRunning();
    }

    public final float getOffset() {
        Float offset = this.swipeableState.getOffset();
        if (offset != null) {
            return offset.floatValue();
        }
        return 0.0f;
    }

    public final Map<RevealValue, Float> getSwipeAnchors() {
        return this.anchors;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006d, code lost:
    
        if (r6.snapTo(r7, r0) == r1) goto L23;
     */
    /* JADX INFO: renamed from: snapTo-HVQT5Qc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m396snapToHVQT5Qc(int r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof androidx.wear.compose.foundation.RevealState$snapTo$1
            if (r0 == 0) goto L14
            r0 = r8
            androidx.wear.compose.foundation.RevealState$snapTo$1 r0 = (androidx.wear.compose.foundation.RevealState$snapTo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            androidx.wear.compose.foundation.RevealState$snapTo$1 r0 = new androidx.wear.compose.foundation.RevealState$snapTo$1
            r0.<init>(r6, r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r8)
            goto L70
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            int r6 = r0.I$0
            java.lang.Object r7 = r0.L$0
            androidx.wear.compose.foundation.RevealState r7 = (androidx.wear.compose.foundation.RevealState) r7
            kotlin.ResultKt.throwOnFailure(r8)
            r5 = r7
            r7 = r6
            r6 = r5
            goto L5e
        L42:
            kotlin.ResultKt.throwOnFailure(r8)
            androidx.wear.compose.foundation.RevealValue$Companion r8 = androidx.wear.compose.foundation.RevealValue.INSTANCE
            int r8 = r8.m405getCoveredEhNvi2Q()
            boolean r8 = androidx.wear.compose.foundation.RevealValue.m401equalsimpl0(r7, r8)
            if (r8 != 0) goto L5e
            r0.L$0 = r6
            r0.I$0 = r7
            r0.label = r4
            java.lang.Object r8 = r6.resetLastState(r6, r0)
            if (r8 != r1) goto L5e
            goto L6f
        L5e:
            androidx.wear.compose.foundation.SwipeableV2State<androidx.wear.compose.foundation.RevealValue> r6 = r6.swipeableState
            androidx.wear.compose.foundation.RevealValue r7 = androidx.wear.compose.foundation.RevealValue.m398boximpl(r7)
            r8 = 0
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r6 = r6.snapTo(r7, r0)
            if (r6 != r1) goto L70
        L6f:
            return r1
        L70:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.wear.compose.foundation.RevealState.m396snapToHVQT5Qc(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0072, code lost:
    
        if (androidx.wear.compose.foundation.SwipeableV2State.animateTo$default(r1, r8, 0.0f, r4, 2, null) == r0) goto L23;
     */
    /* JADX INFO: renamed from: animateTo-HVQT5Qc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m391animateToHVQT5Qc(int r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof androidx.wear.compose.foundation.RevealState$animateTo$1
            if (r0 == 0) goto L14
            r0 = r10
            androidx.wear.compose.foundation.RevealState$animateTo$1 r0 = (androidx.wear.compose.foundation.RevealState$animateTo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            androidx.wear.compose.foundation.RevealState$animateTo$1 r0 = new androidx.wear.compose.foundation.RevealState$animateTo$1
            r0.<init>(r8, r10)
        L19:
            r4 = r0
            java.lang.Object r10 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L43
            if (r1 == r3) goto L36
            if (r1 != r2) goto L2e
            kotlin.ResultKt.throwOnFailure(r10)
            goto L75
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            int r8 = r4.I$0
            java.lang.Object r9 = r4.L$0
            androidx.wear.compose.foundation.RevealState r9 = (androidx.wear.compose.foundation.RevealState) r9
            kotlin.ResultKt.throwOnFailure(r10)
            r7 = r9
            r9 = r8
            r8 = r7
            goto L5f
        L43:
            kotlin.ResultKt.throwOnFailure(r10)
            androidx.wear.compose.foundation.RevealValue$Companion r10 = androidx.wear.compose.foundation.RevealValue.INSTANCE
            int r10 = r10.m405getCoveredEhNvi2Q()
            boolean r10 = androidx.wear.compose.foundation.RevealValue.m401equalsimpl0(r9, r10)
            if (r10 != 0) goto L5f
            r4.L$0 = r8
            r4.I$0 = r9
            r4.label = r3
            java.lang.Object r10 = r8.resetLastState(r8, r4)
            if (r10 != r0) goto L5f
            goto L74
        L5f:
            androidx.wear.compose.foundation.SwipeableV2State<androidx.wear.compose.foundation.RevealValue> r1 = r8.swipeableState
            androidx.wear.compose.foundation.RevealValue r8 = androidx.wear.compose.foundation.RevealValue.m398boximpl(r9)
            r9 = 0
            r4.L$0 = r9
            r4.label = r2
            r3 = 0
            r5 = 2
            r6 = 0
            r2 = r8
            java.lang.Object r8 = androidx.wear.compose.foundation.SwipeableV2State.animateTo$default(r1, r2, r3, r4, r5, r6)
            if (r8 != r0) goto L75
        L74:
            return r0
        L75:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.wear.compose.foundation.RevealState.m391animateToHVQT5Qc(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final float requireOffset$compose_foundation_release() {
        return this.swipeableState.requireOffset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: confirmValueChangeAndReset-TIIb0GA, reason: not valid java name */
    public final boolean m390confirmValueChangeAndResetTIIb0GA(Predicate<RevealValue> confirmValueChange, int revealValue) {
        boolean zTest = confirmValueChange.test(RevealValue.m398boximpl(revealValue));
        if (zTest && !RevealValue.m401equalsimpl0(revealValue, RevealValue.INSTANCE.m405getCoveredEhNvi2Q())) {
            BuildersKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new RevealState$confirmValueChangeAndReset$1(this, this, null), 3, (Object) null);
        }
        return zTest;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object resetLastState(RevealState revealState, Continuation<? super Unit> continuation) {
        RevealState andSet = SingleSwipeCoordinator.INSTANCE.getLastUpdatedState().getAndSet(revealState);
        if (!Intrinsics.areEqual(revealState, andSet)) {
            RevealValue revealValueM398boximpl = andSet != null ? RevealValue.m398boximpl(andSet.m392getCurrentValueEhNvi2Q()) : null;
            if (revealValueM398boximpl == null ? false : RevealValue.m401equalsimpl0(revealValueM398boximpl.m404unboximpl(), RevealValue.INSTANCE.m407getRevealingEhNvi2Q())) {
                Object objM391animateToHVQT5Qc = andSet.m391animateToHVQT5Qc(RevealValue.INSTANCE.m405getCoveredEhNvi2Q(), continuation);
                return objM391animateToHVQT5Qc == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM391animateToHVQT5Qc : Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: SwipeToReveal.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/wear/compose/foundation/RevealState$SingleSwipeCoordinator;", "", "()V", "lastUpdatedState", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/wear/compose/foundation/RevealState;", "getLastUpdatedState", "()Ljava/util/concurrent/atomic/AtomicReference;", "setLastUpdatedState", "(Ljava/util/concurrent/atomic/AtomicReference;)V", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class SingleSwipeCoordinator {
        public static final SingleSwipeCoordinator INSTANCE = new SingleSwipeCoordinator();
        private static AtomicReference<RevealState> lastUpdatedState = new AtomicReference<>(null);

        private SingleSwipeCoordinator() {
        }

        public final AtomicReference<RevealState> getLastUpdatedState() {
            return lastUpdatedState;
        }

        public final void setLastUpdatedState(AtomicReference<RevealState> atomicReference) {
            lastUpdatedState = atomicReference;
        }
    }
}
