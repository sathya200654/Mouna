package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSessionRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class DeleteConversationsUseCase_Factory implements Factory<DeleteConversationsUseCase> {
    private final Provider<ConversationRepository> conversationRepositoryProvider;
    private final Provider<ConversationSessionRepository> conversationSessionRepositoryProvider;

    private DeleteConversationsUseCase_Factory(Provider<ConversationSessionRepository> conversationSessionRepositoryProvider, Provider<ConversationRepository> conversationRepositoryProvider) {
        this.conversationSessionRepositoryProvider = conversationSessionRepositoryProvider;
        this.conversationRepositoryProvider = conversationRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public DeleteConversationsUseCase m1484get() {
        return newInstance((ConversationSessionRepository) this.conversationSessionRepositoryProvider.get(), (ConversationRepository) this.conversationRepositoryProvider.get());
    }

    public static DeleteConversationsUseCase_Factory create(Provider<ConversationSessionRepository> conversationSessionRepositoryProvider, Provider<ConversationRepository> conversationRepositoryProvider) {
        return new DeleteConversationsUseCase_Factory(conversationSessionRepositoryProvider, conversationRepositoryProvider);
    }

    public static DeleteConversationsUseCase newInstance(ConversationSessionRepository conversationSessionRepository, ConversationRepository conversationRepository) {
        return new DeleteConversationsUseCase(conversationSessionRepository, conversationRepository);
    }
}
