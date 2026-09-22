package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.DateFilterRange;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: ConversationListViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationListScreenUiState;", "currentState", "dateRange", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/DateFilterRange;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListViewModel$uiState$3", f = "ConversationListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ConversationListViewModel$uiState$3 extends SuspendLambda implements Function3<ConversationListScreenUiState, DateFilterRange, Continuation<? super ConversationListScreenUiState>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    ConversationListViewModel$uiState$3(Continuation<? super ConversationListViewModel$uiState$3> continuation) {
        super(3, continuation);
    }

    public final Object invoke(ConversationListScreenUiState conversationListScreenUiState, DateFilterRange dateFilterRange, Continuation<? super ConversationListScreenUiState> continuation) {
        ConversationListViewModel$uiState$3 conversationListViewModel$uiState$3 = new ConversationListViewModel$uiState$3(continuation);
        conversationListViewModel$uiState$3.L$0 = conversationListScreenUiState;
        conversationListViewModel$uiState$3.L$1 = dateFilterRange;
        return conversationListViewModel$uiState$3.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        ConversationListScreenUiState conversationListScreenUiState = (ConversationListScreenUiState) this.L$0;
        DateFilterRange dateFilterRange = (DateFilterRange) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return ConversationListScreenUiState.copy$default(conversationListScreenUiState, null, false, false, null, null, dateFilterRange, null, 95, null);
    }
}
