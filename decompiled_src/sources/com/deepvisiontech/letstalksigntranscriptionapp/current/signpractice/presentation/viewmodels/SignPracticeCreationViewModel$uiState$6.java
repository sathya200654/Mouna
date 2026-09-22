package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPracticeComplexity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: SignPracticeCreationViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/viewmodels/SignPracticeCreationUiState;", "currentState", "complexity", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPracticeComplexity;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeCreationViewModel$uiState$6", f = "SignPracticeCreationViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SignPracticeCreationViewModel$uiState$6 extends SuspendLambda implements Function3<SignPracticeCreationUiState, SignPracticeComplexity, Continuation<? super SignPracticeCreationUiState>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    SignPracticeCreationViewModel$uiState$6(Continuation<? super SignPracticeCreationViewModel$uiState$6> continuation) {
        super(3, continuation);
    }

    public final Object invoke(SignPracticeCreationUiState signPracticeCreationUiState, SignPracticeComplexity signPracticeComplexity, Continuation<? super SignPracticeCreationUiState> continuation) {
        SignPracticeCreationViewModel$uiState$6 signPracticeCreationViewModel$uiState$6 = new SignPracticeCreationViewModel$uiState$6(continuation);
        signPracticeCreationViewModel$uiState$6.L$0 = signPracticeCreationUiState;
        signPracticeCreationViewModel$uiState$6.L$1 = signPracticeComplexity;
        return signPracticeCreationViewModel$uiState$6.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        SignPracticeCreationUiState signPracticeCreationUiState = (SignPracticeCreationUiState) this.L$0;
        SignPracticeComplexity signPracticeComplexity = (SignPracticeComplexity) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return SignPracticeCreationUiState.copy$default(signPracticeCreationUiState, false, false, null, null, signPracticeComplexity, null, null, null, null, 495, null);
    }
}
