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
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: Dialog.android.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.wear.compose.material.dialog.Dialog_androidKt$Dialog$5$3$1", f = "Dialog.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class Dialog_androidKt$Dialog$5$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $pendingOnDismissCall$delegate;
    final /* synthetic */ boolean $showDialog;
    final /* synthetic */ MutableState<MutableTransitionState<DialogVisibility>> $transitionState$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Dialog_androidKt$Dialog$5$3$1(boolean z, MutableState<MutableTransitionState<DialogVisibility>> mutableState, MutableState<Boolean> mutableState2, Continuation<? super Dialog_androidKt$Dialog$5$3$1> continuation) {
        super(2, continuation);
        this.$showDialog = z;
        this.$transitionState$delegate = mutableState;
        this.$pendingOnDismissCall$delegate = mutableState2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Dialog_androidKt$Dialog$5$3$1(this.$showDialog, this.$transitionState$delegate, this.$pendingOnDismissCall$delegate, continuation);
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
        if (this.$showDialog) {
            Dialog_androidKt.Dialog$lambda$1(this.$transitionState$delegate).setTargetState(DialogVisibility.Display);
            Dialog_androidKt.Dialog$lambda$5(this.$pendingOnDismissCall$delegate, true);
        } else {
            Dialog_androidKt.Dialog$lambda$1(this.$transitionState$delegate).setTargetState(DialogVisibility.Hide);
        }
        return Unit.INSTANCE;
    }
}
