package com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.repository.PersonaSurveyRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SubmitPersonaDataUseCase_Factory implements Factory<SubmitPersonaDataUseCase> {
    private final Provider<EngagementRepository> engagementRepositoryProvider;
    private final Provider<PersonaSurveyRepository> personaSurveyRepositoryProvider;
    private final Provider<SessionRepository> sessionRepositoryProvider;

    private SubmitPersonaDataUseCase_Factory(Provider<PersonaSurveyRepository> personaSurveyRepositoryProvider, Provider<SessionRepository> sessionRepositoryProvider, Provider<EngagementRepository> engagementRepositoryProvider) {
        this.personaSurveyRepositoryProvider = personaSurveyRepositoryProvider;
        this.sessionRepositoryProvider = sessionRepositoryProvider;
        this.engagementRepositoryProvider = engagementRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SubmitPersonaDataUseCase m1776get() {
        return newInstance((PersonaSurveyRepository) this.personaSurveyRepositoryProvider.get(), (SessionRepository) this.sessionRepositoryProvider.get(), (EngagementRepository) this.engagementRepositoryProvider.get());
    }

    public static SubmitPersonaDataUseCase_Factory create(Provider<PersonaSurveyRepository> personaSurveyRepositoryProvider, Provider<SessionRepository> sessionRepositoryProvider, Provider<EngagementRepository> engagementRepositoryProvider) {
        return new SubmitPersonaDataUseCase_Factory(personaSurveyRepositoryProvider, sessionRepositoryProvider, engagementRepositoryProvider);
    }

    public static SubmitPersonaDataUseCase newInstance(PersonaSurveyRepository personaSurveyRepository, SessionRepository sessionRepository, EngagementRepository engagementRepository) {
        return new SubmitPersonaDataUseCase(personaSurveyRepository, sessionRepository, engagementRepository);
    }
}
