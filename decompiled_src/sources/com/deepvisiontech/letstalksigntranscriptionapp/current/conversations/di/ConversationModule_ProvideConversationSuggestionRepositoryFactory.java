package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.di;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.api.ConversationSuggestionsApi;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.conversationsuggestion.ConversationSuggestionRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ConversationModule_ProvideConversationSuggestionRepositoryFactory implements Factory<ConversationSuggestionRepository> {
    private final Provider<ConversationSuggestionsApi> conversationSuggestionsApiProvider;
    private final Provider<ConversationInputSuggestionDao> daoProvider;

    private ConversationModule_ProvideConversationSuggestionRepositoryFactory(Provider<ConversationInputSuggestionDao> daoProvider, Provider<ConversationSuggestionsApi> conversationSuggestionsApiProvider) {
        this.daoProvider = daoProvider;
        this.conversationSuggestionsApiProvider = conversationSuggestionsApiProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ConversationSuggestionRepository m1479get() {
        return provideConversationSuggestionRepository((ConversationInputSuggestionDao) this.daoProvider.get(), (ConversationSuggestionsApi) this.conversationSuggestionsApiProvider.get());
    }

    public static ConversationModule_ProvideConversationSuggestionRepositoryFactory create(Provider<ConversationInputSuggestionDao> daoProvider, Provider<ConversationSuggestionsApi> conversationSuggestionsApiProvider) {
        return new ConversationModule_ProvideConversationSuggestionRepositoryFactory(daoProvider, conversationSuggestionsApiProvider);
    }

    public static ConversationSuggestionRepository provideConversationSuggestionRepository(ConversationInputSuggestionDao dao, ConversationSuggestionsApi conversationSuggestionsApi) {
        return (ConversationSuggestionRepository) Preconditions.checkNotNullFromProvides(ConversationModule.INSTANCE.provideConversationSuggestionRepository(dao, conversationSuggestionsApi));
    }
}
