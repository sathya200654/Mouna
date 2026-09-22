package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversation;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class UpdateConversationUseCase_Factory implements Factory<UpdateConversationUseCase> {
    private final Provider<ConversationRepository> conversationRepositoryProvider;

    private UpdateConversationUseCase_Factory(Provider<ConversationRepository> conversationRepositoryProvider) {
        this.conversationRepositoryProvider = conversationRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public UpdateConversationUseCase m1500get() {
        return newInstance((ConversationRepository) this.conversationRepositoryProvider.get());
    }

    public static UpdateConversationUseCase_Factory create(Provider<ConversationRepository> conversationRepositoryProvider) {
        return new UpdateConversationUseCase_Factory(conversationRepositoryProvider);
    }

    public static UpdateConversationUseCase newInstance(ConversationRepository conversationRepository) {
        return new UpdateConversationUseCase(conversationRepository);
    }
}
