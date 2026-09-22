package com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.di;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.remote.api.AnalyticsApi;
import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.repository.AnalyticsRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class AnalyticsModule_ProvideAnalyticsRepositoryFactory implements Factory<AnalyticsRepository> {
    private final Provider<AnalyticsApi> analyticsApiProvider;

    private AnalyticsModule_ProvideAnalyticsRepositoryFactory(Provider<AnalyticsApi> analyticsApiProvider) {
        this.analyticsApiProvider = analyticsApiProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public AnalyticsRepository m1311get() {
        return provideAnalyticsRepository((AnalyticsApi) this.analyticsApiProvider.get());
    }

    public static AnalyticsModule_ProvideAnalyticsRepositoryFactory create(Provider<AnalyticsApi> analyticsApiProvider) {
        return new AnalyticsModule_ProvideAnalyticsRepositoryFactory(analyticsApiProvider);
    }

    public static AnalyticsRepository provideAnalyticsRepository(AnalyticsApi analyticsApi) {
        return (AnalyticsRepository) Preconditions.checkNotNullFromProvides(AnalyticsModule.INSTANCE.provideAnalyticsRepository(analyticsApi));
    }
}
