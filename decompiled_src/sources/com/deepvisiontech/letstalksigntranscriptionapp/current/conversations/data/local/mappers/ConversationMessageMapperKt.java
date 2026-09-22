package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.mappers;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.entity.ConversationMessageEntity;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.ConversationMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConversationMessageMapper.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0001¨\u0006\u0004"}, d2 = {"toEntity", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/entity/ConversationMessageEntity;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMessage;", "toConversationMessage", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ConversationMessageMapperKt {
    public static final ConversationMessageEntity toEntity(ConversationMessage conversationMessage) {
        Intrinsics.checkNotNullParameter(conversationMessage, "<this>");
        return new ConversationMessageEntity(conversationMessage.getId(), conversationMessage.getConversationIdFk(), conversationMessage.getUserName(), conversationMessage.getMessage(), conversationMessage.getProcessedMessage(), conversationMessage.getProcessedMessageLanguage(), conversationMessage.getMessageLanguage(), conversationMessage.getSignGloss(), conversationMessage.getSequenceId(), conversationMessage.getMessageInputType(), conversationMessage.getMessageType(), conversationMessage.isProcessed(), conversationMessage.getTimeCreated());
    }

    public static final ConversationMessage toConversationMessage(ConversationMessageEntity conversationMessageEntity) {
        Intrinsics.checkNotNullParameter(conversationMessageEntity, "<this>");
        return new ConversationMessage(conversationMessageEntity.getId(), conversationMessageEntity.getConversationIdFk(), conversationMessageEntity.getUserName(), conversationMessageEntity.getMessage(), conversationMessageEntity.getProcessedMessage(), conversationMessageEntity.getProcessedMessageLanguage(), conversationMessageEntity.getSignGloss(), conversationMessageEntity.getSequenceId(), conversationMessageEntity.getMessageLanguage(), conversationMessageEntity.getMessageInputType(), conversationMessageEntity.getMessageType(), conversationMessageEntity.isProcessed(), false, conversationMessageEntity.getTimeCreated(), 4096, null);
    }
}
