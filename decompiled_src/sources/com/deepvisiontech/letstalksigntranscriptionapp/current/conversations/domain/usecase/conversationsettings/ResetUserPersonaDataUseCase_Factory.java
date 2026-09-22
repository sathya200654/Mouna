package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.repository.PersonaSurveyRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ResetUserPersonaDataUseCase_Factory implements Factory<ResetUserPersonaDataUseCase> {
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<EngagementRepository> engagementRepositoryProvider;
    private final Provider<PersonaSurveyRepository> personaSurveyRepositoryProvider;

    private ResetUserPersonaDataUseCase_Factory(Provider<PersonaSurveyRepository> personaSurveyRepositoryProvider, Provider<EngagementRepository> engagementRepositoryProvider, Provider<AnalyticsManager> analyticsManagerProvider) {
        this.personaSurveyRepositoryProvider = personaSurveyRepositoryProvider;
        this.engagementRepositoryProvider = engagementRepositoryProvider;
        this.analyticsManagerProvider = analyticsManagerProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ResetUserPersonaDataUseCase m1504get() {
        return newInstance((PersonaSurveyRepository) this.personaSurveyRepositoryProvider.get(), (EngagementRepository) this.engagementRepositoryProvider.get(), (AnalyticsManager) this.analyticsManagerProvider.get());
    }

    public static ResetUserPersonaDataUseCase_Factory create(Provider<PersonaSurveyRepository> personaSurveyRepositoryProvider, Provider<EngagementRepository> engagementRepositoryProvider, Provider<AnalyticsManager> analyticsManagerProvider) {
        return new ResetUserPersonaDataUseCase_Factory(personaSurveyRepositoryProvider, engagementRepositoryProvider, analyticsManagerProvider);
    }

    public static ResetUserPersonaDataUseCase newInstance(PersonaSurveyRepository personaSurveyRepository, EngagementRepository engagementRepository, AnalyticsManager analyticsManager) {
        return new ResetUserPersonaDataUseCase(personaSurveyRepository, engagementRepository, analyticsManager);
    }
}
