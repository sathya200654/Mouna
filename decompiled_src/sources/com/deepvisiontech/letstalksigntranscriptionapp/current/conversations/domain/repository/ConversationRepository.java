package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.Conversation;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: ConversationRepository.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007J\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\f0\u000bH&J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u000e\u001a\u00020\u0004H&J\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011H¦@¢\u0006\u0002\u0010\u0012¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationRepository;", "", "insertConversationAndGetId", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "conversation", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/Conversation;", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/Conversation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateConversation", "", "getAllConversations", "Lkotlinx/coroutines/flow/Flow;", "", "getConversation", "id", "deleteConversations", "conversations", "", "(Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ConversationRepository {
    Object deleteConversations(Set<Conversation> set, Continuation<? super ResponseResource<Unit>> continuation);

    Flow<List<Conversation>> getAllConversations();

    Flow<Conversation> getConversation(long id);

    Object insertConversationAndGetId(Conversation conversation, Continuation<? super ResponseResource<Long>> continuation);

    Object updateConversation(Conversation conversation, Continuation<? super ResponseResource<Unit>> continuation);
}
