package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversation;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSessionRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class GetActiveOrNewConversationUseCase_Factory implements Factory<GetActiveOrNewConversationUseCase> {
    private final Provider<ConversationRepository> conversationRepositoryProvider;
    private final Provider<ConversationSessionRepository> conversationSessionRepositoryProvider;

    private GetActiveOrNewConversationUseCase_Factory(Provider<ConversationSessionRepository> conversationSessionRepositoryProvider, Provider<ConversationRepository> conversationRepositoryProvider) {
        this.conversationSessionRepositoryProvider = conversationSessionRepositoryProvider;
        this.conversationRepositoryProvider = conversationRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public GetActiveOrNewConversationUseCase m1499get() {
        return newInstance((ConversationSessionRepository) this.conversationSessionRepositoryProvider.get(), (ConversationRepository) this.conversationRepositoryProvider.get());
    }

    public static GetActiveOrNewConversationUseCase_Factory create(Provider<ConversationSessionRepository> conversationSessionRepositoryProvider, Provider<ConversationRepository> conversationRepositoryProvider) {
        return new GetActiveOrNewConversationUseCase_Factory(conversationSessionRepositoryProvider, conversationRepositoryProvider);
    }

    public static GetActiveOrNewConversationUseCase newInstance(ConversationSessionRepository conversationSessionRepository, ConversationRepository conversationRepository) {
        return new GetActiveOrNewConversationUseCase(conversationSessionRepository, conversationRepository);
    }
}
