package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsuggestion;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.conversationsuggestion.ConversationSuggestionRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class FetchCorrectionSuggestionUseCase_Factory implements Factory<FetchCorrectionSuggestionUseCase> {
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<ConversationSuggestionRepository> conversationSuggestionRepositoryProvider;
    private final Provider<SessionRepository> sessionRepositoryProvider;

    private FetchCorrectionSuggestionUseCase_Factory(Provider<SessionRepository> sessionRepositoryProvider, Provider<ConversationSuggestionRepository> conversationSuggestionRepositoryProvider, Provider<AnalyticsManager> analyticsManagerProvider) {
        this.sessionRepositoryProvider = sessionRepositoryProvider;
        this.conversationSuggestionRepositoryProvider = conversationSuggestionRepositoryProvider;
        this.analyticsManagerProvider = analyticsManagerProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public FetchCorrectionSuggestionUseCase m1516get() {
        return newInstance((SessionRepository) this.sessionRepositoryProvider.get(), (ConversationSuggestionRepository) this.conversationSuggestionRepositoryProvider.get(), (AnalyticsManager) this.analyticsManagerProvider.get());
    }

    public static FetchCorrectionSuggestionUseCase_Factory create(Provider<SessionRepository> sessionRepositoryProvider, Provider<ConversationSuggestionRepository> conversationSuggestionRepositoryProvider, Provider<AnalyticsManager> analyticsManagerProvider) {
        return new FetchCorrectionSuggestionUseCase_Factory(sessionRepositoryProvider, conversationSuggestionRepositoryProvider, analyticsManagerProvider);
    }

    public static FetchCorrectionSuggestionUseCase newInstance(SessionRepository sessionRepository, ConversationSuggestionRepository conversationSuggestionRepository, AnalyticsManager analyticsManager) {
        return new FetchCorrectionSuggestionUseCase(sessionRepository, conversationSuggestionRepository, analyticsManager);
    }
}
