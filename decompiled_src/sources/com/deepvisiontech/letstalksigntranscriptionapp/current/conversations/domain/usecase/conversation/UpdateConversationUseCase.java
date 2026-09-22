package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversation;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.Conversation;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationRepository;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UpdateConversationUseCase.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Singleton
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0086B¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversation/UpdateConversationUseCase;", "", "conversationRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationRepository;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationRepository;)V", "invoke", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "conversation", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/Conversation;", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/Conversation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UpdateConversationUseCase {
    public static final int $stable = 8;
    private final ConversationRepository conversationRepository;

    @Inject
    public UpdateConversationUseCase(ConversationRepository conversationRepository) {
        Intrinsics.checkNotNullParameter(conversationRepository, "conversationRepository");
        this.conversationRepository = conversationRepository;
    }

    public final Object invoke(Conversation conversation, Continuation<? super ResponseResource<Unit>> continuation) {
        return this.conversationRepository.updateConversation(conversation, continuation);
    }
}
