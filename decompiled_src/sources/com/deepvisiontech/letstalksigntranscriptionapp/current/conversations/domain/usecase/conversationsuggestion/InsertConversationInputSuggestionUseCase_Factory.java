package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsuggestion;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.conversationsuggestion.ConversationSuggestionRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class InsertConversationInputSuggestionUseCase_Factory implements Factory<InsertConversationInputSuggestionUseCase> {
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<ConversationSuggestionRepository> conversationSuggestionRepositoryProvider;

    private InsertConversationInputSuggestionUseCase_Factory(Provider<ConversationSuggestionRepository> conversationSuggestionRepositoryProvider, Provider<AnalyticsManager> analyticsManagerProvider) {
        this.conversationSuggestionRepositoryProvider = conversationSuggestionRepositoryProvider;
        this.analyticsManagerProvider = analyticsManagerProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public InsertConversationInputSuggestionUseCase m1518get() {
        return newInstance((ConversationSuggestionRepository) this.conversationSuggestionRepositoryProvider.get(), (AnalyticsManager) this.analyticsManagerProvider.get());
    }

    public static InsertConversationInputSuggestionUseCase_Factory create(Provider<ConversationSuggestionRepository> conversationSuggestionRepositoryProvider, Provider<AnalyticsManager> analyticsManagerProvider) {
        return new InsertConversationInputSuggestionUseCase_Factory(conversationSuggestionRepositoryProvider, analyticsManagerProvider);
    }

    public static InsertConversationInputSuggestionUseCase newInstance(ConversationSuggestionRepository conversationSuggestionRepository, AnalyticsManager analyticsManager) {
        return new InsertConversationInputSuggestionUseCase(conversationSuggestionRepository, analyticsManager);
    }
}
