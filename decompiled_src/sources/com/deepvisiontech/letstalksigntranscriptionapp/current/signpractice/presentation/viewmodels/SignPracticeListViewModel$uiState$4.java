package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPractice;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: SignPracticeListViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/viewmodels/SignPracticeListUiState;", "currentState", "selectedIds", "", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeListViewModel$uiState$4", f = "SignPracticeListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SignPracticeListViewModel$uiState$4 extends SuspendLambda implements Function3<SignPracticeListUiState, Set<? extends Integer>, Continuation<? super SignPracticeListUiState>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    SignPracticeListViewModel$uiState$4(Continuation<? super SignPracticeListViewModel$uiState$4> continuation) {
        super(3, continuation);
    }

    public final Object invoke(SignPracticeListUiState signPracticeListUiState, Set<Integer> set, Continuation<? super SignPracticeListUiState> continuation) {
        SignPracticeListViewModel$uiState$4 signPracticeListViewModel$uiState$4 = new SignPracticeListViewModel$uiState$4(continuation);
        signPracticeListViewModel$uiState$4.L$0 = signPracticeListUiState;
        signPracticeListViewModel$uiState$4.L$1 = set;
        return signPracticeListViewModel$uiState$4.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        SignPracticeListUiState signPracticeListUiState = (SignPracticeListUiState) this.L$0;
        Set set = (Set) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        List<SignPractice> signPractices = signPracticeListUiState.getSignPractices();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(signPractices, 10));
        for (SignPractice signPractice : signPractices) {
            arrayList.add(SignPractice.copy$default(signPractice, 0, null, null, null, null, null, null, null, null, 0, 0L, set.contains(Boxing.boxInt(signPractice.getId())), 2047, null));
        }
        return SignPracticeListUiState.copy$default(signPracticeListUiState, arrayList, false, !set.isEmpty(), null, null, null, null, 122, null);
    }
}
