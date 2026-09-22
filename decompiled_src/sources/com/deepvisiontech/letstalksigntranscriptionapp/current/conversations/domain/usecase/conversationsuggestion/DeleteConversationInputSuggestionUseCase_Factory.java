package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsuggestion;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.conversationsuggestion.ConversationSuggestionRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class DeleteConversationInputSuggestionUseCase_Factory implements Factory<DeleteConversationInputSuggestionUseCase> {
    private final Provider<ConversationSuggestionRepository> conversationSuggestionRepositoryProvider;

    private DeleteConversationInputSuggestionUseCase_Factory(Provider<ConversationSuggestionRepository> conversationSuggestionRepositoryProvider) {
        this.conversationSuggestionRepositoryProvider = conversationSuggestionRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public DeleteConversationInputSuggestionUseCase m1514get() {
        return newInstance((ConversationSuggestionRepository) this.conversationSuggestionRepositoryProvider.get());
    }

    public static DeleteConversationInputSuggestionUseCase_Factory create(Provider<ConversationSuggestionRepository> conversationSuggestionRepositoryProvider) {
        return new DeleteConversationInputSuggestionUseCase_Factory(conversationSuggestionRepositoryProvider);
    }

    public static DeleteConversationInputSuggestionUseCase newInstance(ConversationSuggestionRepository conversationSuggestionRepository) {
        return new DeleteConversationInputSuggestionUseCase(conversationSuggestionRepository);
    }
}
