package com.deepvisiontech.letstalksigntranscriptionapp.current.common.di;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.remote.api.LtsTranslationApi;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.repository.LtsTranslationRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class AppModule_ProvideLtsTranslationRepositoryFactory implements Factory<LtsTranslationRepository> {
    private final Provider<LtsTranslationApi> ltsTranslationApiProvider;

    private AppModule_ProvideLtsTranslationRepositoryFactory(Provider<LtsTranslationApi> ltsTranslationApiProvider) {
        this.ltsTranslationApiProvider = ltsTranslationApiProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public LtsTranslationRepository m1406get() {
        return provideLtsTranslationRepository((LtsTranslationApi) this.ltsTranslationApiProvider.get());
    }

    public static AppModule_ProvideLtsTranslationRepositoryFactory create(Provider<LtsTranslationApi> ltsTranslationApiProvider) {
        return new AppModule_ProvideLtsTranslationRepositoryFactory(ltsTranslationApiProvider);
    }

    public static LtsTranslationRepository provideLtsTranslationRepository(LtsTranslationApi ltsTranslationApi) {
        return (LtsTranslationRepository) Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideLtsTranslationRepository(ltsTranslationApi));
    }
}
