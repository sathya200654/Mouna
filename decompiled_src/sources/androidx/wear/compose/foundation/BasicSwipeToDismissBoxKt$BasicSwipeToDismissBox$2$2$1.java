package androidx.wear.compose.foundation;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: BasicSwipeToDismissBox.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.wear.compose.foundation.BasicSwipeToDismissBoxKt$BasicSwipeToDismissBox$2$2$1", f = "BasicSwipeToDismissBox.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BasicSwipeToDismissBoxKt$BasicSwipeToDismissBox$2$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $squeezeMode$delegate;
    final /* synthetic */ SwipeToDismissBoxState $state;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BasicSwipeToDismissBoxKt$BasicSwipeToDismissBox$2$2$1(SwipeToDismissBoxState swipeToDismissBoxState, MutableState<Boolean> mutableState, Continuation<? super BasicSwipeToDismissBoxKt$BasicSwipeToDismissBox$2$2$1> continuation) {
        super(2, continuation);
        this.$state = swipeToDismissBoxState;
        this.$squeezeMode$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BasicSwipeToDismissBoxKt$BasicSwipeToDismissBox$2$2$1(this.$state, this.$squeezeMode$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (!BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox$lambda$13$lambda$7(this.$squeezeMode$delegate) && this.$state.getTargetValue() == SwipeToDismissValue.Default) {
                BasicSwipeToDismissBoxKt.BasicSwipeToDismissBox$lambda$13$lambda$8(this.$squeezeMode$delegate, true);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
