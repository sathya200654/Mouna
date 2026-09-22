package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.Conversation;
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

/* JADX INFO: compiled from: ConversationListViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationListScreenUiState;", "currentState", "selectedIds", "", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationListViewModel$uiState$4", f = "ConversationListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ConversationListViewModel$uiState$4 extends SuspendLambda implements Function3<ConversationListScreenUiState, Set<? extends Long>, Continuation<? super ConversationListScreenUiState>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    ConversationListViewModel$uiState$4(Continuation<? super ConversationListViewModel$uiState$4> continuation) {
        super(3, continuation);
    }

    public final Object invoke(ConversationListScreenUiState conversationListScreenUiState, Set<Long> set, Continuation<? super ConversationListScreenUiState> continuation) {
        ConversationListViewModel$uiState$4 conversationListViewModel$uiState$4 = new ConversationListViewModel$uiState$4(continuation);
        conversationListViewModel$uiState$4.L$0 = conversationListScreenUiState;
        conversationListViewModel$uiState$4.L$1 = set;
        return conversationListViewModel$uiState$4.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        ConversationListScreenUiState conversationListScreenUiState = (ConversationListScreenUiState) this.L$0;
        Set set = (Set) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        boolean z = !set.isEmpty();
        List<Conversation> conversations = conversationListScreenUiState.getConversations();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(conversations, 10));
        for (Conversation conversation : conversations) {
            arrayList.add(Conversation.copy$default(conversation, 0L, null, set.contains(Boxing.boxLong(conversation.getId())), 0L, 11, null));
        }
        return ConversationListScreenUiState.copy$default(conversationListScreenUiState, arrayList, false, z, null, null, null, null, 122, null);
    }
}
