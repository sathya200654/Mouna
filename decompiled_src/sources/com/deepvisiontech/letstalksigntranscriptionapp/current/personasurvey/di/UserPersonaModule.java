package com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.di;

import android.content.Context;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.data.remote.api.PersonaSurveyApi;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.data.repository.PersonaSurveyRepositoryImpl;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.repository.PersonaSurveyRepository;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.android.qualifiers.ApplicationContext;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Retrofit;

/* JADX INFO: compiled from: UserPersonaModule.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0007J\u001a\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0007¨\u0006\r"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/di/UserPersonaModule;", "", "<init>", "()V", "provideUserPersonaApi", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/data/remote/api/PersonaSurveyApi;", "retrofit", "Lretrofit2/Retrofit;", "providePersonaSurveyRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/domain/repository/PersonaSurveyRepository;", "context", "Landroid/content/Context;", "personaSurveyApi", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module
public final class UserPersonaModule {
    public static final int $stable = 0;
    public static final UserPersonaModule INSTANCE = new UserPersonaModule();

    private UserPersonaModule() {
    }

    @Provides
    @Singleton
    public final PersonaSurveyApi provideUserPersonaApi(Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object objCreate = retrofit.create(PersonaSurveyApi.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (PersonaSurveyApi) objCreate;
    }

    @Provides
    @Singleton
    public final PersonaSurveyRepository providePersonaSurveyRepository(@ApplicationContext Context context, PersonaSurveyApi personaSurveyApi) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(personaSurveyApi, "personaSurveyApi");
        return new PersonaSurveyRepositoryImpl(context, personaSurveyApi);
    }
}
