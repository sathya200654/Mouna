package com.deepvisiontech.letstalksigntranscriptionapp.current.common.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class AppModule_ProvideAnalyticsAndResponseRetrofitFactory implements Factory<Retrofit> {
    private final Provider<OkHttpClient> okHttpClientProvider;

    private AppModule_ProvideAnalyticsAndResponseRetrofitFactory(Provider<OkHttpClient> okHttpClientProvider) {
        this.okHttpClientProvider = okHttpClientProvider;
    }

    public Retrofit get() {
        return provideAnalyticsAndResponseRetrofit((OkHttpClient) this.okHttpClientProvider.get());
    }

    public static AppModule_ProvideAnalyticsAndResponseRetrofitFactory create(Provider<OkHttpClient> okHttpClientProvider) {
        return new AppModule_ProvideAnalyticsAndResponseRetrofitFactory(okHttpClientProvider);
    }

    public static Retrofit provideAnalyticsAndResponseRetrofit(OkHttpClient okHttpClient) {
        return (Retrofit) Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideAnalyticsAndResponseRetrofit(okHttpClient));
    }
}
