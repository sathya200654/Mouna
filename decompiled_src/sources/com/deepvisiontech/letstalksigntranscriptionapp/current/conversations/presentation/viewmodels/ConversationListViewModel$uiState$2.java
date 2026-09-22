package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.ListSortOrder;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationListScreenUiState;", "currentState", "sortOrder", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/ListSortOrder;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListViewModel$uiState$2", f = "ConversationListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ConversationListViewModel$uiState$2 extends SuspendLambda implements Function3<ConversationListScreenUiState, ListSortOrder, Continuation<? super ConversationListScreenUiState>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    ConversationListViewModel$uiState$2(Continuation<? super ConversationListViewModel$uiState$2> continuation) {
        super(3, continuation);
    }

    public final Object invoke(ConversationListScreenUiState conversationListScreenUiState, ListSortOrder listSortOrder, Continuation<? super ConversationListScreenUiState> continuation) {
        ConversationListViewModel$uiState$2 conversationListViewModel$uiState$2 = new ConversationListViewModel$uiState$2(continuation);
        conversationListViewModel$uiState$2.L$0 = conversationListScreenUiState;
        conversationListViewModel$uiState$2.L$1 = listSortOrder;
        return conversationListViewModel$uiState$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        ConversationListScreenUiState conversationListScreenUiState = (ConversationListScreenUiState) this.L$0;
        ListSortOrder listSortOrder = (ListSortOrder) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return ConversationListScreenUiState.copy$default(conversationListScreenUiState, null, false, false, null, listSortOrder, null, null, 111, null);
    }
}
