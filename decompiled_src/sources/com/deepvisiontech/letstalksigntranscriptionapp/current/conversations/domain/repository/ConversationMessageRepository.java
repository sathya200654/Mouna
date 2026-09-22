package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository;

import androidx.tracing.perfetto.handshake.protocol.ResponseKeys;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.ConversationMessage;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: ConversationMessageRepository.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\n\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u000bJ\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\t2\u0006\u0010\u000e\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u000bJ\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011H¦@¢\u0006\u0002\u0010\u0012JF\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\t2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u001bJ<\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00140\t2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u001e¨\u0006\u001fÀ\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationMessageRepository;", "", "getAllMessagesOfConversation", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMessage;", "id", "", "insertConversationMessageWithNextSequenceIdAndGetWithId", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "conversationMessage", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateConversationMessage", "", ResponseKeys.KEY_MESSAGE, "deleteConversationMessages", "messages", "", "(Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateConversationMessageSummary", "", "deviceId", "gmailId", "customerId", "token", "content", "generatedSummaryWordCount", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchArticleSummary", "link", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ConversationMessageRepository {
    Object deleteConversationMessages(Set<ConversationMessage> set, Continuation<? super ResponseResource<Unit>> continuation);

    Object fetchArticleSummary(String str, String str2, String str3, String str4, String str5, Continuation<? super ResponseResource<String>> continuation);

    Object generateConversationMessageSummary(String str, String str2, String str3, String str4, String str5, String str6, Continuation<? super ResponseResource<String>> continuation);

    Flow<List<ConversationMessage>> getAllMessagesOfConversation(long id);

    Object insertConversationMessageWithNextSequenceIdAndGetWithId(ConversationMessage conversationMessage, Continuation<? super ResponseResource<ConversationMessage>> continuation);

    Object updateConversationMessage(ConversationMessage conversationMessage, Continuation<? super ResponseResource<Unit>> continuation);

    /* JADX INFO: compiled from: ConversationMessageRepository.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object generateConversationMessageSummary$default(ConversationMessageRepository conversationMessageRepository, String str, String str2, String str3, String str4, String str5, String str6, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: generateConversationMessageSummary");
        }
        if ((i & 32) != 0) {
            str6 = "300";
        }
        return conversationMessageRepository.generateConversationMessageSummary(str, str2, str3, str4, str5, str6, continuation);
    }
}
