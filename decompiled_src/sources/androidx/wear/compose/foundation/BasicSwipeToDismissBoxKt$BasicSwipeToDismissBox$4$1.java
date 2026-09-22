package androidx.wear.compose.foundation;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: BasicSwipeToDismissBox.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.wear.compose.foundation.BasicSwipeToDismissBoxKt$BasicSwipeToDismissBox$4$1", f = "BasicSwipeToDismissBox.kt", i = {}, l = {288}, m = "invokeSuspend", n = {}, s = {})
final class BasicSwipeToDismissBoxKt$BasicSwipeToDismissBox$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $onDismissed;
    final /* synthetic */ SwipeToDismissBoxState $state;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BasicSwipeToDismissBoxKt$BasicSwipeToDismissBox$4$1(SwipeToDismissBoxState swipeToDismissBoxState, Function0<Unit> function0, Continuation<? super BasicSwipeToDismissBoxKt$BasicSwipeToDismissBox$4$1> continuation) {
        super(2, continuation);
        this.$state = swipeToDismissBoxState;
        this.$onDismissed = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BasicSwipeToDismissBoxKt$BasicSwipeToDismissBox$4$1(this.$state, this.$onDismissed, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$state.getCurrentValue() == SwipeToDismissValue.Dismissed) {
                this.label = 1;
                if (this.$state.snapTo(SwipeToDismissValue.Default, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$onDismissed.invoke();
        return Unit.INSTANCE;
    }
}
