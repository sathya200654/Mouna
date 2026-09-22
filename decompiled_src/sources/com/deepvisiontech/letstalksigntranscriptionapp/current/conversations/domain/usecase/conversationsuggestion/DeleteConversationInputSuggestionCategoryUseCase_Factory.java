package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsuggestion;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.conversationsuggestion.ConversationSuggestionRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class DeleteConversationInputSuggestionCategoryUseCase_Factory implements Factory<DeleteConversationInputSuggestionCategoryUseCase> {
    private final Provider<ConversationSuggestionRepository> conversationSuggestionRepositoryProvider;

    private DeleteConversationInputSuggestionCategoryUseCase_Factory(Provider<ConversationSuggestionRepository> conversationSuggestionRepositoryProvider) {
        this.conversationSuggestionRepositoryProvider = conversationSuggestionRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public DeleteConversationInputSuggestionCategoryUseCase m1513get() {
        return newInstance((ConversationSuggestionRepository) this.conversationSuggestionRepositoryProvider.get());
    }

    public static DeleteConversationInputSuggestionCategoryUseCase_Factory create(Provider<ConversationSuggestionRepository> conversationSuggestionRepositoryProvider) {
        return new DeleteConversationInputSuggestionCategoryUseCase_Factory(conversationSuggestionRepositoryProvider);
    }

    public static DeleteConversationInputSuggestionCategoryUseCase newInstance(ConversationSuggestionRepository conversationSuggestionRepository) {
        return new DeleteConversationInputSuggestionCategoryUseCase(conversationSuggestionRepository);
    }
}
