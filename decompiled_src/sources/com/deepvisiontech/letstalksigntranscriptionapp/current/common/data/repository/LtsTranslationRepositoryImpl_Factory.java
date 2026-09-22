package com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.repository;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.remote.api.LtsTranslationApi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class LtsTranslationRepositoryImpl_Factory implements Factory<LtsTranslationRepositoryImpl> {
    private final Provider<LtsTranslationApi> ltsTranslationApiProvider;

    private LtsTranslationRepositoryImpl_Factory(Provider<LtsTranslationApi> ltsTranslationApiProvider) {
        this.ltsTranslationApiProvider = ltsTranslationApiProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public LtsTranslationRepositoryImpl m1398get() {
        return newInstance((LtsTranslationApi) this.ltsTranslationApiProvider.get());
    }

    public static LtsTranslationRepositoryImpl_Factory create(Provider<LtsTranslationApi> ltsTranslationApiProvider) {
        return new LtsTranslationRepositoryImpl_Factory(ltsTranslationApiProvider);
    }

    public static LtsTranslationRepositoryImpl newInstance(LtsTranslationApi ltsTranslationApi) {
        return new LtsTranslationRepositoryImpl(ltsTranslationApi);
    }
}
