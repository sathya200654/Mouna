package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/viewmodels/SignPracticeCreationUiState;", "currentState", "language", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeCreationViewModel$uiState$7", f = "SignPracticeCreationViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SignPracticeCreationViewModel$uiState$7 extends SuspendLambda implements Function3<SignPracticeCreationUiState, LanguageEnum, Continuation<? super SignPracticeCreationUiState>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    SignPracticeCreationViewModel$uiState$7(Continuation<? super SignPracticeCreationViewModel$uiState$7> continuation) {
        super(3, continuation);
    }

    public final Object invoke(SignPracticeCreationUiState signPracticeCreationUiState, LanguageEnum languageEnum, Continuation<? super SignPracticeCreationUiState> continuation) {
        SignPracticeCreationViewModel$uiState$7 signPracticeCreationViewModel$uiState$7 = new SignPracticeCreationViewModel$uiState$7(continuation);
        signPracticeCreationViewModel$uiState$7.L$0 = signPracticeCreationUiState;
        signPracticeCreationViewModel$uiState$7.L$1 = languageEnum;
        return signPracticeCreationViewModel$uiState$7.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        SignPracticeCreationUiState signPracticeCreationUiState = (SignPracticeCreationUiState) this.L$0;
        LanguageEnum languageEnum = (LanguageEnum) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return SignPracticeCreationUiState.copy$default(signPracticeCreationUiState, false, false, null, null, null, null, null, languageEnum, null, 383, null);
    }
}
