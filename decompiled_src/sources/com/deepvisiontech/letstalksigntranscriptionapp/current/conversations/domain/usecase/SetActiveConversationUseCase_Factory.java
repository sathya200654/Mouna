package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSessionRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SetActiveConversationUseCase_Factory implements Factory<SetActiveConversationUseCase> {
    private final Provider<ConversationSessionRepository> conversationSessionRepositoryProvider;

    private SetActiveConversationUseCase_Factory(Provider<ConversationSessionRepository> conversationSessionRepositoryProvider) {
        this.conversationSessionRepositoryProvider = conversationSessionRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SetActiveConversationUseCase m1493get() {
        return newInstance((ConversationSessionRepository) this.conversationSessionRepositoryProvider.get());
    }

    public static SetActiveConversationUseCase_Factory create(Provider<ConversationSessionRepository> conversationSessionRepositoryProvider) {
        return new SetActiveConversationUseCase_Factory(conversationSessionRepositoryProvider);
    }

    public static SetActiveConversationUseCase newInstance(ConversationSessionRepository conversationSessionRepository) {
        return new SetActiveConversationUseCase(conversationSessionRepository);
    }
}
