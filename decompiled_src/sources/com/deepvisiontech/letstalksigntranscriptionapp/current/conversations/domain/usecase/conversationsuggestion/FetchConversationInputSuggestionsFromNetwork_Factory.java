package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsuggestion;

import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.conversationsuggestion.ConversationSuggestionRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class FetchConversationInputSuggestionsFromNetwork_Factory implements Factory<FetchConversationInputSuggestionsFromNetwork> {
    private final Provider<ConversationSuggestionRepository> conversationSuggestionRepositoryProvider;
    private final Provider<SessionRepository> sessionRepositoryProvider;

    private FetchConversationInputSuggestionsFromNetwork_Factory(Provider<ConversationSuggestionRepository> conversationSuggestionRepositoryProvider, Provider<SessionRepository> sessionRepositoryProvider) {
        this.conversationSuggestionRepositoryProvider = conversationSuggestionRepositoryProvider;
        this.sessionRepositoryProvider = sessionRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public FetchConversationInputSuggestionsFromNetwork m1515get() {
        return newInstance((ConversationSuggestionRepository) this.conversationSuggestionRepositoryProvider.get(), (SessionRepository) this.sessionRepositoryProvider.get());
    }

    public static FetchConversationInputSuggestionsFromNetwork_Factory create(Provider<ConversationSuggestionRepository> conversationSuggestionRepositoryProvider, Provider<SessionRepository> sessionRepositoryProvider) {
        return new FetchConversationInputSuggestionsFromNetwork_Factory(conversationSuggestionRepositoryProvider, sessionRepositoryProvider);
    }

    public static FetchConversationInputSuggestionsFromNetwork newInstance(ConversationSuggestionRepository conversationSuggestionRepository, SessionRepository sessionRepository) {
        return new FetchConversationInputSuggestionsFromNetwork(conversationSuggestionRepository, sessionRepository);
    }
}
