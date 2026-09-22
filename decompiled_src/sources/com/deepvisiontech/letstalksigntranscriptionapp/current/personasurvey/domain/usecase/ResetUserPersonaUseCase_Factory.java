package com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.repository.PersonaSurveyRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ResetUserPersonaUseCase_Factory implements Factory<ResetUserPersonaUseCase> {
    private final Provider<EngagementRepository> engagementRepositoryProvider;
    private final Provider<PersonaSurveyRepository> personaSurveyRepositoryProvider;

    private ResetUserPersonaUseCase_Factory(Provider<PersonaSurveyRepository> personaSurveyRepositoryProvider, Provider<EngagementRepository> engagementRepositoryProvider) {
        this.personaSurveyRepositoryProvider = personaSurveyRepositoryProvider;
        this.engagementRepositoryProvider = engagementRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ResetUserPersonaUseCase m1775get() {
        return newInstance((PersonaSurveyRepository) this.personaSurveyRepositoryProvider.get(), (EngagementRepository) this.engagementRepositoryProvider.get());
    }

    public static ResetUserPersonaUseCase_Factory create(Provider<PersonaSurveyRepository> personaSurveyRepositoryProvider, Provider<EngagementRepository> engagementRepositoryProvider) {
        return new ResetUserPersonaUseCase_Factory(personaSurveyRepositoryProvider, engagementRepositoryProvider);
    }

    public static ResetUserPersonaUseCase newInstance(PersonaSurveyRepository personaSurveyRepository, EngagementRepository engagementRepository) {
        return new ResetUserPersonaUseCase(personaSurveyRepository, engagementRepository);
    }
}
