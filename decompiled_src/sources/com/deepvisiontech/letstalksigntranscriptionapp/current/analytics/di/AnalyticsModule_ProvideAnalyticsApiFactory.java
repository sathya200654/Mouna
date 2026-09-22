package com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.di;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.remote.api.AnalyticsApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class AnalyticsModule_ProvideAnalyticsApiFactory implements Factory<AnalyticsApi> {
    private final Provider<Retrofit> retrofitProvider;

    private AnalyticsModule_ProvideAnalyticsApiFactory(Provider<Retrofit> retrofitProvider) {
        this.retrofitProvider = retrofitProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public AnalyticsApi m1309get() {
        return provideAnalyticsApi((Retrofit) this.retrofitProvider.get());
    }

    public static AnalyticsModule_ProvideAnalyticsApiFactory create(Provider<Retrofit> retrofitProvider) {
        return new AnalyticsModule_ProvideAnalyticsApiFactory(retrofitProvider);
    }

    public static AnalyticsApi provideAnalyticsApi(Retrofit retrofit) {
        return (AnalyticsApi) Preconditions.checkNotNullFromProvides(AnalyticsModule.INSTANCE.provideAnalyticsApi(retrofit));
    }
}
