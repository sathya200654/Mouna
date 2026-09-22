package com.deepvisiontech.letstalksigntranscriptionapp.current.common.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class AppModule_ProvideOkHttpClientFactory implements Factory<OkHttpClient> {
    private final Provider<HttpLoggingInterceptor> loggingInterceptorProvider;

    private AppModule_ProvideOkHttpClientFactory(Provider<HttpLoggingInterceptor> loggingInterceptorProvider) {
        this.loggingInterceptorProvider = loggingInterceptorProvider;
    }

    public OkHttpClient get() {
        return provideOkHttpClient((HttpLoggingInterceptor) this.loggingInterceptorProvider.get());
    }

    public static AppModule_ProvideOkHttpClientFactory create(Provider<HttpLoggingInterceptor> loggingInterceptorProvider) {
        return new AppModule_ProvideOkHttpClientFactory(loggingInterceptorProvider);
    }

    public static OkHttpClient provideOkHttpClient(HttpLoggingInterceptor loggingInterceptor) {
        return (OkHttpClient) Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideOkHttpClient(loggingInterceptor));
    }
}
