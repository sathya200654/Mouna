package com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.di;

import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.data.remote.api.PersonaSurveyApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class UserPersonaModule_ProvideUserPersonaApiFactory implements Factory<PersonaSurveyApi> {
    private final Provider<Retrofit> retrofitProvider;

    private UserPersonaModule_ProvideUserPersonaApiFactory(Provider<Retrofit> retrofitProvider) {
        this.retrofitProvider = retrofitProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public PersonaSurveyApi m1774get() {
        return provideUserPersonaApi((Retrofit) this.retrofitProvider.get());
    }

    public static UserPersonaModule_ProvideUserPersonaApiFactory create(Provider<Retrofit> retrofitProvider) {
        return new UserPersonaModule_ProvideUserPersonaApiFactory(retrofitProvider);
    }

    public static PersonaSurveyApi provideUserPersonaApi(Retrofit retrofit) {
        return (PersonaSurveyApi) Preconditions.checkNotNullFromProvides(UserPersonaModule.INSTANCE.provideUserPersonaApi(retrofit));
    }
}
