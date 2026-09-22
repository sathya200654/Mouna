package androidx.wear.compose.material.dialog;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.runtime.MutableState;
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

/* JADX INFO: compiled from: Dialog.android.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.wear.compose.material.dialog.Dialog_androidKt$Dialog$5$4$1", f = "Dialog.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class Dialog_androidKt$Dialog$5$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $onDismissRequest;
    final /* synthetic */ MutableState<Boolean> $pendingOnDismissCall$delegate;
    final /* synthetic */ MutableState<MutableTransitionState<DialogVisibility>> $transitionState$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Dialog_androidKt$Dialog$5$4$1(Function0<Unit> function0, MutableState<Boolean> mutableState, MutableState<MutableTransitionState<DialogVisibility>> mutableState2, Continuation<? super Dialog_androidKt$Dialog$5$4$1> continuation) {
        super(2, continuation);
        this.$onDismissRequest = function0;
        this.$pendingOnDismissCall$delegate = mutableState;
        this.$transitionState$delegate = mutableState2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Dialog_androidKt$Dialog$5$4$1(this.$onDismissRequest, this.$pendingOnDismissCall$delegate, this.$transitionState$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (Dialog_androidKt.Dialog$lambda$4(this.$pendingOnDismissCall$delegate) && Dialog_androidKt.Dialog$lambda$1(this.$transitionState$delegate).getCurrentState() == DialogVisibility.Hide && Dialog_androidKt.Dialog$lambda$1(this.$transitionState$delegate).isIdle()) {
                this.$onDismissRequest.invoke();
                Dialog_androidKt.Dialog$lambda$5(this.$pendingOnDismissCall$delegate, false);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
