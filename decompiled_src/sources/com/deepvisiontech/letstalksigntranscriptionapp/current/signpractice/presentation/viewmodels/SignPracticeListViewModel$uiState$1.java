package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPractice;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: SignPracticeListViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/viewmodels/SignPracticeListUiState;", "practices", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPractice;", "query", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeListViewModel$uiState$1", f = "SignPracticeListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SignPracticeListViewModel$uiState$1 extends SuspendLambda implements Function3<List<? extends SignPractice>, String, Continuation<? super SignPracticeListUiState>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    SignPracticeListViewModel$uiState$1(Continuation<? super SignPracticeListViewModel$uiState$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(List<SignPractice> list, String str, Continuation<? super SignPracticeListUiState> continuation) {
        SignPracticeListViewModel$uiState$1 signPracticeListViewModel$uiState$1 = new SignPracticeListViewModel$uiState$1(continuation);
        signPracticeListViewModel$uiState$1.L$0 = list;
        signPracticeListViewModel$uiState$1.L$1 = str;
        return signPracticeListViewModel$uiState$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        List list = (List) this.L$0;
        String str = (String) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return new SignPracticeListUiState(list, false, false, str, null, null, null, 116, null);
    }
}
