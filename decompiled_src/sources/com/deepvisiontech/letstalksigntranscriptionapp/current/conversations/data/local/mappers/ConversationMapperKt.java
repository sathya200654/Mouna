package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.mappers;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.entity.ConversationEntity;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.Conversation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConversationMapper.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0001¨\u0006\u0004"}, d2 = {"toEntity", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/entity/ConversationEntity;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/Conversation;", "toConversation", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ConversationMapperKt {
    public static final ConversationEntity toEntity(Conversation conversation) {
        Intrinsics.checkNotNullParameter(conversation, "<this>");
        return new ConversationEntity(conversation.getId(), conversation.getConversationName(), conversation.getTimeCreated());
    }

    public static final Conversation toConversation(ConversationEntity conversationEntity) {
        Intrinsics.checkNotNullParameter(conversationEntity, "<this>");
        return new Conversation(conversationEntity.getId(), conversationEntity.getConversationName(), false, conversationEntity.getTimeCreated(), 4, null);
    }
}
