package com.deepvisiontech.letstalksigntranscriptionapp.current.common.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class AppModule_ProvideLtsRetrofitFactory implements Factory<Retrofit> {
    private final Provider<OkHttpClient> okHttpClientProvider;

    private AppModule_ProvideLtsRetrofitFactory(Provider<OkHttpClient> okHttpClientProvider) {
        this.okHttpClientProvider = okHttpClientProvider;
    }

    public Retrofit get() {
        return provideLtsRetrofit((OkHttpClient) this.okHttpClientProvider.get());
    }

    public static AppModule_ProvideLtsRetrofitFactory create(Provider<OkHttpClient> okHttpClientProvider) {
        return new AppModule_ProvideLtsRetrofitFactory(okHttpClientProvider);
    }

    public static Retrofit provideLtsRetrofit(OkHttpClient okHttpClient) {
        return (Retrofit) Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideLtsRetrofit(okHttpClient));
    }
}
