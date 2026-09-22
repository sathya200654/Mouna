package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels;

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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/viewmodels/SignPracticeCreationUiState;", "isLoading", "", "isGenerating"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeCreationViewModel$uiState$1", f = "SignPracticeCreationViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SignPracticeCreationViewModel$uiState$1 extends SuspendLambda implements Function3<Boolean, Boolean, Continuation<? super SignPracticeCreationUiState>, Object> {
    /* synthetic */ boolean Z$0;
    /* synthetic */ boolean Z$1;
    int label;

    SignPracticeCreationViewModel$uiState$1(Continuation<? super SignPracticeCreationViewModel$uiState$1> continuation) {
        super(3, continuation);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Continuation<? super SignPracticeCreationUiState>) obj3);
    }

    public final Object invoke(boolean z, boolean z2, Continuation<? super SignPracticeCreationUiState> continuation) {
        SignPracticeCreationViewModel$uiState$1 signPracticeCreationViewModel$uiState$1 = new SignPracticeCreationViewModel$uiState$1(continuation);
        signPracticeCreationViewModel$uiState$1.Z$0 = z;
        signPracticeCreationViewModel$uiState$1.Z$1 = z2;
        return signPracticeCreationViewModel$uiState$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        boolean z = this.Z$0;
        boolean z2 = this.Z$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return new SignPracticeCreationUiState(z, z2, null, null, null, null, null, null, null, 508, null);
    }
}
