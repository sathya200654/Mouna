package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels;

import android.util.Log;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: SignPracticeCreationViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/viewmodels/SignPracticeCreationUiState;", "e", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeCreationViewModel$uiState$9", f = "SignPracticeCreationViewModel.kt", i = {0}, l = {94}, m = "invokeSuspend", n = {"e"}, s = {"L$0"})
final class SignPracticeCreationViewModel$uiState$9 extends SuspendLambda implements Function3<FlowCollector<? super SignPracticeCreationUiState>, Throwable, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SignPracticeCreationViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SignPracticeCreationViewModel$uiState$9(SignPracticeCreationViewModel signPracticeCreationViewModel, Continuation<? super SignPracticeCreationViewModel$uiState$9> continuation) {
        super(3, continuation);
        this.this$0 = signPracticeCreationViewModel;
    }

    public final Object invoke(FlowCollector<? super SignPracticeCreationUiState> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        SignPracticeCreationViewModel$uiState$9 signPracticeCreationViewModel$uiState$9 = new SignPracticeCreationViewModel$uiState$9(this.this$0, continuation);
        signPracticeCreationViewModel$uiState$9.L$0 = th;
        return signPracticeCreationViewModel$uiState$9.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Throwable th = (Throwable) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Log.e("SignPracticeCreationViewModel", "Error in UI state flow", th);
            this.L$0 = SpillingKt.nullOutSpilledVariable(th);
            this.label = 1;
            if (this.this$0._uiEvent.emit(new SignPracticeCreationUiEvent.ErrorMessage(R.string.sign_practice_load_error, null, 2, null), (Continuation) this) == coroutine_suspended) {
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
