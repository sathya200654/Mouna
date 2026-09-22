package com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel;

import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.repository.PersonaSurveyRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class NavigationViewModel_Factory implements Factory<NavigationViewModel> {
    private final Provider<PersonaSurveyRepository> personaSurveyRepositoryProvider;

    private NavigationViewModel_Factory(Provider<PersonaSurveyRepository> personaSurveyRepositoryProvider) {
        this.personaSurveyRepositoryProvider = personaSurveyRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public NavigationViewModel m1356get() {
        return newInstance((PersonaSurveyRepository) this.personaSurveyRepositoryProvider.get());
    }

    public static NavigationViewModel_Factory create(Provider<PersonaSurveyRepository> personaSurveyRepositoryProvider) {
        return new NavigationViewModel_Factory(personaSurveyRepositoryProvider);
    }

    public static NavigationViewModel newInstance(PersonaSurveyRepository personaSurveyRepository) {
        return new NavigationViewModel(personaSurveyRepository);
    }
}
