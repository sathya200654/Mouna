package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.api.ConversationOcrApi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ExtractTextFromImageUseCase_Factory implements Factory<ExtractTextFromImageUseCase> {
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<ConversationOcrApi> conversationOcrApiProvider;
    private final Provider<SessionRepository> sessionRepositoryProvider;

    private ExtractTextFromImageUseCase_Factory(Provider<SessionRepository> sessionRepositoryProvider, Provider<ConversationOcrApi> conversationOcrApiProvider, Provider<AnalyticsManager> analyticsManagerProvider) {
        this.sessionRepositoryProvider = sessionRepositoryProvider;
        this.conversationOcrApiProvider = conversationOcrApiProvider;
        this.analyticsManagerProvider = analyticsManagerProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ExtractTextFromImageUseCase m1485get() {
        return newInstance((SessionRepository) this.sessionRepositoryProvider.get(), (ConversationOcrApi) this.conversationOcrApiProvider.get(), (AnalyticsManager) this.analyticsManagerProvider.get());
    }

    public static ExtractTextFromImageUseCase_Factory create(Provider<SessionRepository> sessionRepositoryProvider, Provider<ConversationOcrApi> conversationOcrApiProvider, Provider<AnalyticsManager> analyticsManagerProvider) {
        return new ExtractTextFromImageUseCase_Factory(sessionRepositoryProvider, conversationOcrApiProvider, analyticsManagerProvider);
    }

    public static ExtractTextFromImageUseCase newInstance(SessionRepository sessionRepository, ConversationOcrApi conversationOcrApi, AnalyticsManager analyticsManager) {
        return new ExtractTextFromImageUseCase(sessionRepository, conversationOcrApi, analyticsManager);
    }
}
