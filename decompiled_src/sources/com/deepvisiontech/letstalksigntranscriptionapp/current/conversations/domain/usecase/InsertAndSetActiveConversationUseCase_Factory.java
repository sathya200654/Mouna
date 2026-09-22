package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSessionRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class InsertAndSetActiveConversationUseCase_Factory implements Factory<InsertAndSetActiveConversationUseCase> {
    private final Provider<ConversationRepository> conversationRepositoryProvider;
    private final Provider<ConversationSessionRepository> conversationSessionRepositoryProvider;

    private InsertAndSetActiveConversationUseCase_Factory(Provider<ConversationRepository> conversationRepositoryProvider, Provider<ConversationSessionRepository> conversationSessionRepositoryProvider) {
        this.conversationRepositoryProvider = conversationRepositoryProvider;
        this.conversationSessionRepositoryProvider = conversationSessionRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public InsertAndSetActiveConversationUseCase m1490get() {
        return newInstance((ConversationRepository) this.conversationRepositoryProvider.get(), (ConversationSessionRepository) this.conversationSessionRepositoryProvider.get());
    }

    public static InsertAndSetActiveConversationUseCase_Factory create(Provider<ConversationRepository> conversationRepositoryProvider, Provider<ConversationSessionRepository> conversationSessionRepositoryProvider) {
        return new InsertAndSetActiveConversationUseCase_Factory(conversationRepositoryProvider, conversationSessionRepositoryProvider);
    }

    public static InsertAndSetActiveConversationUseCase newInstance(ConversationRepository conversationRepository, ConversationSessionRepository conversationSessionRepository) {
        return new InsertAndSetActiveConversationUseCase(conversationRepository, conversationSessionRepository);
    }
}
