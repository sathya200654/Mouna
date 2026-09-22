package com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.repository.PersonaSurveyRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SyncPendingPersonaDataUseCase_Factory implements Factory<SyncPendingPersonaDataUseCase> {
    private final Provider<EngagementRepository> engagementRepositoryProvider;
    private final Provider<PersonaSurveyRepository> personaSurveyRepositoryProvider;
    private final Provider<SessionRepository> sessionRepositoryProvider;

    private SyncPendingPersonaDataUseCase_Factory(Provider<EngagementRepository> engagementRepositoryProvider, Provider<PersonaSurveyRepository> personaSurveyRepositoryProvider, Provider<SessionRepository> sessionRepositoryProvider) {
        this.engagementRepositoryProvider = engagementRepositoryProvider;
        this.personaSurveyRepositoryProvider = personaSurveyRepositoryProvider;
        this.sessionRepositoryProvider = sessionRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SyncPendingPersonaDataUseCase m1777get() {
        return newInstance((EngagementRepository) this.engagementRepositoryProvider.get(), (PersonaSurveyRepository) this.personaSurveyRepositoryProvider.get(), (SessionRepository) this.sessionRepositoryProvider.get());
    }

    public static SyncPendingPersonaDataUseCase_Factory create(Provider<EngagementRepository> engagementRepositoryProvider, Provider<PersonaSurveyRepository> personaSurveyRepositoryProvider, Provider<SessionRepository> sessionRepositoryProvider) {
        return new SyncPendingPersonaDataUseCase_Factory(engagementRepositoryProvider, personaSurveyRepositoryProvider, sessionRepositoryProvider);
    }

    public static SyncPendingPersonaDataUseCase newInstance(EngagementRepository engagementRepository, PersonaSurveyRepository personaSurveyRepository, SessionRepository sessionRepository) {
        return new SyncPendingPersonaDataUseCase(engagementRepository, personaSurveyRepository, sessionRepository);
    }
}
