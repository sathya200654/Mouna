package com.deepvisiontech.letstalksigntranscriptionapp.current.common.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import okhttp3.logging.HttpLoggingInterceptor;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class AppModule_ProvideLoggingInterceptorFactory implements Factory<HttpLoggingInterceptor> {
    public HttpLoggingInterceptor get() {
        return provideLoggingInterceptor();
    }

    public static AppModule_ProvideLoggingInterceptorFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static HttpLoggingInterceptor provideLoggingInterceptor() {
        return (HttpLoggingInterceptor) Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideLoggingInterceptor());
    }

    private static final class InstanceHolder {
        static final AppModule_ProvideLoggingInterceptorFactory INSTANCE = new AppModule_ProvideLoggingInterceptorFactory();

        private InstanceHolder() {
        }
    }
}
