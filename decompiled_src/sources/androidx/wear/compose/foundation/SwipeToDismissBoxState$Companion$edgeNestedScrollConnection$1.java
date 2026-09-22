package androidx.wear.compose.foundation;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: compiled from: BasicSwipeToDismissBox.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"androidx/wear/compose/foundation/SwipeToDismissBoxState$Companion$edgeNestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", Constants.ScionAnalytics.PARAM_SOURCE, "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SwipeToDismissBoxState$Companion$edgeNestedScrollConnection$1 implements NestedScrollConnection {
    final /* synthetic */ State<EdgeSwipeState> $edgeSwipeState;
    final /* synthetic */ SwipeableV2State<T> $this_edgeNestedScrollConnection;

    /* JADX WARN: Multi-variable type inference failed */
    SwipeToDismissBoxState$Companion$edgeNestedScrollConnection$1(State<? extends EdgeSwipeState> state, SwipeableV2State<T> swipeableV2State) {
        this.$edgeSwipeState = state;
        this.$this_edgeNestedScrollConnection = swipeableV2State;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk, reason: not valid java name */
    public long m414onPreScrollOzD1aCk(long available, int source) {
        float f = Offset.getX-impl(available);
        if (this.$edgeSwipeState.getValue() == EdgeSwipeState.SwipingToDismiss && NestedScrollSource.equals-impl0(source, NestedScrollSource.Companion.getDrag-WNlRxjI())) {
            this.$this_edgeNestedScrollConnection.dispatchRawDelta(f);
            return available;
        }
        return Offset.Companion.getZero-F1C5BW0();
    }

    /* JADX INFO: renamed from: onPostScroll-DzOQY0M, reason: not valid java name */
    public long m412onPostScrollDzOQY0M(long consumed, long available, int source) {
        return Offset.Companion.getZero-F1C5BW0();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: onPreFling-QWom1Mo, reason: not valid java name */
    public Object m413onPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation) {
        Continuation<? super Unit> swipeToDismissBoxState$Companion$edgeNestedScrollConnection$1$onPreFling$1;
        long j2;
        if (continuation instanceof SwipeToDismissBoxState$Companion$edgeNestedScrollConnection$1$onPreFling$1) {
            swipeToDismissBoxState$Companion$edgeNestedScrollConnection$1$onPreFling$1 = (SwipeToDismissBoxState$Companion$edgeNestedScrollConnection$1$onPreFling$1) continuation;
            if ((swipeToDismissBoxState$Companion$edgeNestedScrollConnection$1$onPreFling$1.label & Integer.MIN_VALUE) != 0) {
                swipeToDismissBoxState$Companion$edgeNestedScrollConnection$1$onPreFling$1.label -= Integer.MIN_VALUE;
            } else {
                swipeToDismissBoxState$Companion$edgeNestedScrollConnection$1$onPreFling$1 = new SwipeToDismissBoxState$Companion$edgeNestedScrollConnection$1$onPreFling$1(this, continuation);
            }
        } else {
            swipeToDismissBoxState$Companion$edgeNestedScrollConnection$1$onPreFling$1 = new SwipeToDismissBoxState$Companion$edgeNestedScrollConnection$1$onPreFling$1(this, continuation);
        }
        Object obj = swipeToDismissBoxState$Companion$edgeNestedScrollConnection$1$onPreFling$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = swipeToDismissBoxState$Companion$edgeNestedScrollConnection$1$onPreFling$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            float f = Velocity.getX-impl(j);
            if (this.$edgeSwipeState.getValue() == EdgeSwipeState.SwipingToDismiss || this.$edgeSwipeState.getValue() == EdgeSwipeState.SwipeToDismissInProgress) {
                SwipeableV2State<T> swipeableV2State = this.$this_edgeNestedScrollConnection;
                swipeToDismissBoxState$Companion$edgeNestedScrollConnection$1$onPreFling$1.J$0 = j;
                swipeToDismissBoxState$Companion$edgeNestedScrollConnection$1$onPreFling$1.label = 1;
                if (swipeableV2State.settle(f, swipeToDismissBoxState$Companion$edgeNestedScrollConnection$1$onPreFling$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                j2 = Velocity.Companion.getZero-9UxMQ8M();
            }
            return Velocity.box-impl(j2);
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        j = swipeToDismissBoxState$Companion$edgeNestedScrollConnection$1$onPreFling$1.J$0;
        ResultKt.throwOnFailure(obj);
        j2 = j;
        return Velocity.box-impl(j2);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY, reason: not valid java name */
    public Object m411onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
        Continuation<? super Unit> swipeToDismissBoxState$Companion$edgeNestedScrollConnection$1$onPostFling$1;
        if (continuation instanceof SwipeToDismissBoxState$Companion$edgeNestedScrollConnection$1$onPostFling$1) {
            swipeToDismissBoxState$Companion$edgeNestedScrollConnection$1$onPostFling$1 = (SwipeToDismissBoxState$Companion$edgeNestedScrollConnection$1$onPostFling$1) continuation;
            if ((swipeToDismissBoxState$Companion$edgeNestedScrollConnection$1$onPostFling$1.label & Integer.MIN_VALUE) != 0) {
                swipeToDismissBoxState$Companion$edgeNestedScrollConnection$1$onPostFling$1.label -= Integer.MIN_VALUE;
            } else {
                swipeToDismissBoxState$Companion$edgeNestedScrollConnection$1$onPostFling$1 = new SwipeToDismissBoxState$Companion$edgeNestedScrollConnection$1$onPostFling$1(this, continuation);
            }
        } else {
            swipeToDismissBoxState$Companion$edgeNestedScrollConnection$1$onPostFling$1 = new SwipeToDismissBoxState$Companion$edgeNestedScrollConnection$1$onPostFling$1(this, continuation);
        }
        Object obj = swipeToDismissBoxState$Companion$edgeNestedScrollConnection$1$onPostFling$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = swipeToDismissBoxState$Companion$edgeNestedScrollConnection$1$onPostFling$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SwipeableV2State<T> swipeableV2State = this.$this_edgeNestedScrollConnection;
            float f = Velocity.getX-impl(j2);
            swipeToDismissBoxState$Companion$edgeNestedScrollConnection$1$onPostFling$1.J$0 = j2;
            swipeToDismissBoxState$Companion$edgeNestedScrollConnection$1$onPostFling$1.label = 1;
            if (swipeableV2State.settle(f, swipeToDismissBoxState$Companion$edgeNestedScrollConnection$1$onPostFling$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j2 = swipeToDismissBoxState$Companion$edgeNestedScrollConnection$1$onPostFling$1.J$0;
            ResultKt.throwOnFailure(obj);
        }
        return Velocity.box-impl(j2);
    }
}
