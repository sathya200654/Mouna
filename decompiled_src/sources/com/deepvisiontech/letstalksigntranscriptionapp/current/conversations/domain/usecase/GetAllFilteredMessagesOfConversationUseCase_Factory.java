package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationMessageRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class GetAllFilteredMessagesOfConversationUseCase_Factory implements Factory<GetAllFilteredMessagesOfConversationUseCase> {
    private final Provider<ConversationMessageRepository> conversationMessageRepositoryProvider;

    private GetAllFilteredMessagesOfConversationUseCase_Factory(Provider<ConversationMessageRepository> conversationMessageRepositoryProvider) {
        this.conversationMessageRepositoryProvider = conversationMessageRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public GetAllFilteredMessagesOfConversationUseCase m1488get() {
        return newInstance((ConversationMessageRepository) this.conversationMessageRepositoryProvider.get());
    }

    public static GetAllFilteredMessagesOfConversationUseCase_Factory create(Provider<ConversationMessageRepository> conversationMessageRepositoryProvider) {
        return new GetAllFilteredMessagesOfConversationUseCase_Factory(conversationMessageRepositoryProvider);
    }

    public static GetAllFilteredMessagesOfConversationUseCase newInstance(ConversationMessageRepository conversationMessageRepository) {
        return new GetAllFilteredMessagesOfConversationUseCase(conversationMessageRepository);
    }
}
