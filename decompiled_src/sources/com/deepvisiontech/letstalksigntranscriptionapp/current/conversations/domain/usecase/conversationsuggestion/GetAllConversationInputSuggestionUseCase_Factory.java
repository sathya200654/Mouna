package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsuggestion;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.conversationsuggestion.ConversationSuggestionRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class GetAllConversationInputSuggestionUseCase_Factory implements Factory<GetAllConversationInputSuggestionUseCase> {
    private final Provider<ConversationSuggestionRepository> conversationSuggestionRepositoryProvider;

    private GetAllConversationInputSuggestionUseCase_Factory(Provider<ConversationSuggestionRepository> conversationSuggestionRepositoryProvider) {
        this.conversationSuggestionRepositoryProvider = conversationSuggestionRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public GetAllConversationInputSuggestionUseCase m1517get() {
        return newInstance((ConversationSuggestionRepository) this.conversationSuggestionRepositoryProvider.get());
    }

    public static GetAllConversationInputSuggestionUseCase_Factory create(Provider<ConversationSuggestionRepository> conversationSuggestionRepositoryProvider) {
        return new GetAllConversationInputSuggestionUseCase_Factory(conversationSuggestionRepositoryProvider);
    }

    public static GetAllConversationInputSuggestionUseCase newInstance(ConversationSuggestionRepository conversationSuggestionRepository) {
        return new GetAllConversationInputSuggestionUseCase(conversationSuggestionRepository);
    }
}
