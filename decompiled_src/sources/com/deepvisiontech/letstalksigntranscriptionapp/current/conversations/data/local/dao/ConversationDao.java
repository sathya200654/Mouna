package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.entity.ConversationEntity;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: ConversationDao.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\nH'J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\r\u001a\u00020\u0003H'J\u001c\u0010\u000e\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010H§@¢\u0006\u0002\u0010\u0011¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/dao/ConversationDao;", "", "insertConversation", "", "conversationEntity", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/entity/ConversationEntity;", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/entity/ConversationEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateConversation", "", "getAllConversations", "Lkotlinx/coroutines/flow/Flow;", "", "getConversation", "id", "deleteConversations", "conversations", "", "(Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ConversationDao {
    Object deleteConversations(Set<ConversationEntity> set, Continuation<? super Unit> continuation);

    Flow<List<ConversationEntity>> getAllConversations();

    Flow<ConversationEntity> getConversation(long id);

    Object insertConversation(ConversationEntity conversationEntity, Continuation<? super Long> continuation);

    Object updateConversation(ConversationEntity conversationEntity, Continuation<? super Unit> continuation);
}
