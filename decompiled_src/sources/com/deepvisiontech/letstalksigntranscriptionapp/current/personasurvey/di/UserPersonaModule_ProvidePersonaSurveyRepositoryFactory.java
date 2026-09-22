package com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.di;

import android.content.Context;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.data.remote.api.PersonaSurveyApi;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.repository.PersonaSurveyRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class UserPersonaModule_ProvidePersonaSurveyRepositoryFactory implements Factory<PersonaSurveyRepository> {
    private final Provider<Context> contextProvider;
    private final Provider<PersonaSurveyApi> personaSurveyApiProvider;

    private UserPersonaModule_ProvidePersonaSurveyRepositoryFactory(Provider<Context> contextProvider, Provider<PersonaSurveyApi> personaSurveyApiProvider) {
        this.contextProvider = contextProvider;
        this.personaSurveyApiProvider = personaSurveyApiProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public PersonaSurveyRepository m1773get() {
        return providePersonaSurveyRepository((Context) this.contextProvider.get(), (PersonaSurveyApi) this.personaSurveyApiProvider.get());
    }

    public static UserPersonaModule_ProvidePersonaSurveyRepositoryFactory create(Provider<Context> contextProvider, Provider<PersonaSurveyApi> personaSurveyApiProvider) {
        return new UserPersonaModule_ProvidePersonaSurveyRepositoryFactory(contextProvider, personaSurveyApiProvider);
    }

    public static PersonaSurveyRepository providePersonaSurveyRepository(Context context, PersonaSurveyApi personaSurveyApi) {
        return (PersonaSurveyRepository) Preconditions.checkNotNullFromProvides(UserPersonaModule.INSTANCE.providePersonaSurveyRepository(context, personaSurveyApi));
    }
}
