package com.deepvisiontech.letstalksigntranscriptionapp.current.common.di;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.remote.api.LtsTranslationApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class AppModule_ProvidesLtsTranslationApiFactory implements Factory<LtsTranslationApi> {
    private final Provider<Retrofit> retrofitProvider;

    private AppModule_ProvidesLtsTranslationApiFactory(Provider<Retrofit> retrofitProvider) {
        this.retrofitProvider = retrofitProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public LtsTranslationApi m1409get() {
        return providesLtsTranslationApi((Retrofit) this.retrofitProvider.get());
    }

    public static AppModule_ProvidesLtsTranslationApiFactory create(Provider<Retrofit> retrofitProvider) {
        return new AppModule_ProvidesLtsTranslationApiFactory(retrofitProvider);
    }

    public static LtsTranslationApi providesLtsTranslationApi(Retrofit retrofit) {
        return (LtsTranslationApi) Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.providesLtsTranslationApi(retrofit));
    }
}
