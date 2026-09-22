package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class GetConversationUseCase_Factory implements Factory<GetConversationUseCase> {
    private final Provider<ConversationRepository> conversationRepositoryProvider;

    private GetConversationUseCase_Factory(Provider<ConversationRepository> conversationRepositoryProvider) {
        this.conversationRepositoryProvider = conversationRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public GetConversationUseCase m1489get() {
        return newInstance((ConversationRepository) this.conversationRepositoryProvider.get());
    }

    public static GetConversationUseCase_Factory create(Provider<ConversationRepository> conversationRepositoryProvider) {
        return new GetConversationUseCase_Factory(conversationRepositoryProvider);
    }

    public static GetConversationUseCase newInstance(ConversationRepository conversationRepository) {
        return new GetConversationUseCase(conversationRepository);
    }
}
