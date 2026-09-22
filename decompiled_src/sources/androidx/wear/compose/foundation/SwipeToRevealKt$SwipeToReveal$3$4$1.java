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

/* JADX INFO: compiled from: SwipeToReveal.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.wear.compose.foundation.SwipeToRevealKt$SwipeToReveal$3$4$1", f = "SwipeToReveal.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SwipeToRevealKt$SwipeToReveal$3$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $onFullSwipe;
    final /* synthetic */ RevealState $state;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SwipeToRevealKt$SwipeToReveal$3$4$1(RevealState revealState, Function0<Unit> function0, Continuation<? super SwipeToRevealKt$SwipeToReveal$3$4$1> continuation) {
        super(2, continuation);
        this.$state = revealState;
        this.$onFullSwipe = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SwipeToRevealKt$SwipeToReveal$3$4$1(this.$state, this.$onFullSwipe, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (RevealValue.m401equalsimpl0(this.$state.m392getCurrentValueEhNvi2Q(), RevealValue.INSTANCE.m406getRevealedEhNvi2Q()) && RevealActionType.m380equalsimpl0(this.$state.m393getLastActionTypeBxv7xxc(), RevealActionType.INSTANCE.m384getNoneBxv7xxc())) {
            this.$onFullSwipe.invoke();
        }
        return Unit.INSTANCE;
    }
}
