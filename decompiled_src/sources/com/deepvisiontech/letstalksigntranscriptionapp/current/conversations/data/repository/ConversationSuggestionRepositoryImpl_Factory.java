package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.repository;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao.ConversationInputSuggestionDao;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.api.ConversationSuggestionsApi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ConversationSuggestionRepositoryImpl_Factory implements Factory<ConversationSuggestionRepositoryImpl> {
    private final Provider<ConversationSuggestionsApi> conversationSuggestionsApiProvider;
    private final Provider<ConversationInputSuggestionDao> daoProvider;

    private ConversationSuggestionRepositoryImpl_Factory(Provider<ConversationInputSuggestionDao> daoProvider, Provider<ConversationSuggestionsApi> conversationSuggestionsApiProvider) {
        this.daoProvider = daoProvider;
        this.conversationSuggestionsApiProvider = conversationSuggestionsApiProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ConversationSuggestionRepositoryImpl m1467get() {
        return newInstance((ConversationInputSuggestionDao) this.daoProvider.get(), (ConversationSuggestionsApi) this.conversationSuggestionsApiProvider.get());
    }

    public static ConversationSuggestionRepositoryImpl_Factory create(Provider<ConversationInputSuggestionDao> daoProvider, Provider<ConversationSuggestionsApi> conversationSuggestionsApiProvider) {
        return new ConversationSuggestionRepositoryImpl_Factory(daoProvider, conversationSuggestionsApiProvider);
    }

    public static ConversationSuggestionRepositoryImpl newInstance(ConversationInputSuggestionDao dao, ConversationSuggestionsApi conversationSuggestionsApi) {
        return new ConversationSuggestionRepositoryImpl(dao, conversationSuggestionsApi);
    }
}
