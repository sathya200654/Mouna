package com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.repository.PersonaSurveyRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.usecase.SubmitPersonaDataUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class OnBoardingViewModel_Factory implements Factory<OnBoardingViewModel> {
    private final Provider<EngagementRepository> engagementRepositoryProvider;
    private final Provider<PersonaSurveyRepository> personaSurveyRepositoryProvider;
    private final Provider<SubmitPersonaDataUseCase> submitPersonaDataUseCaseProvider;

    private OnBoardingViewModel_Factory(Provider<PersonaSurveyRepository> personaSurveyRepositoryProvider, Provider<SubmitPersonaDataUseCase> submitPersonaDataUseCaseProvider, Provider<EngagementRepository> engagementRepositoryProvider) {
        this.personaSurveyRepositoryProvider = personaSurveyRepositoryProvider;
        this.submitPersonaDataUseCaseProvider = submitPersonaDataUseCaseProvider;
        this.engagementRepositoryProvider = engagementRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public OnBoardingViewModel m1788get() {
        return newInstance((PersonaSurveyRepository) this.personaSurveyRepositoryProvider.get(), (SubmitPersonaDataUseCase) this.submitPersonaDataUseCaseProvider.get(), (EngagementRepository) this.engagementRepositoryProvider.get());
    }

    public static OnBoardingViewModel_Factory create(Provider<PersonaSurveyRepository> personaSurveyRepositoryProvider, Provider<SubmitPersonaDataUseCase> submitPersonaDataUseCaseProvider, Provider<EngagementRepository> engagementRepositoryProvider) {
        return new OnBoardingViewModel_Factory(personaSurveyRepositoryProvider, submitPersonaDataUseCaseProvider, engagementRepositoryProvider);
    }

    public static OnBoardingViewModel newInstance(PersonaSurveyRepository personaSurveyRepository, SubmitPersonaDataUseCase submitPersonaDataUseCase, EngagementRepository engagementRepository) {
        return new OnBoardingViewModel(personaSurveyRepository, submitPersonaDataUseCase, engagementRepository);
    }
}
