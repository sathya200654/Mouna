package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class GetAllFilteredConversationsUseCase_Factory implements Factory<GetAllFilteredConversationsUseCase> {
    private final Provider<ConversationRepository> conversationRepositoryProvider;

    private GetAllFilteredConversationsUseCase_Factory(Provider<ConversationRepository> conversationRepositoryProvider) {
        this.conversationRepositoryProvider = conversationRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public GetAllFilteredConversationsUseCase m1487get() {
        return newInstance((ConversationRepository) this.conversationRepositoryProvider.get());
    }

    public static GetAllFilteredConversationsUseCase_Factory create(Provider<ConversationRepository> conversationRepositoryProvider) {
        return new GetAllFilteredConversationsUseCase_Factory(conversationRepositoryProvider);
    }

    public static GetAllFilteredConversationsUseCase newInstance(ConversationRepository conversationRepository) {
        return new GetAllFilteredConversationsUseCase(conversationRepository);
    }
}
