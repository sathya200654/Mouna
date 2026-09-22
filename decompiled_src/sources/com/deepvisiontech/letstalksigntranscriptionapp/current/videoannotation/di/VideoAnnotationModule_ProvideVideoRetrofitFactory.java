package com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class VideoAnnotationModule_ProvideVideoRetrofitFactory implements Factory<Retrofit> {
    private final Provider<OkHttpClient> okHttpClientProvider;

    private VideoAnnotationModule_ProvideVideoRetrofitFactory(Provider<OkHttpClient> okHttpClientProvider) {
        this.okHttpClientProvider = okHttpClientProvider;
    }

    public Retrofit get() {
        return provideVideoRetrofit((OkHttpClient) this.okHttpClientProvider.get());
    }

    public static VideoAnnotationModule_ProvideVideoRetrofitFactory create(Provider<OkHttpClient> okHttpClientProvider) {
        return new VideoAnnotationModule_ProvideVideoRetrofitFactory(okHttpClientProvider);
    }

    public static Retrofit provideVideoRetrofit(OkHttpClient okHttpClient) {
        return (Retrofit) Preconditions.checkNotNullFromProvides(VideoAnnotationModule.INSTANCE.provideVideoRetrofit(okHttpClient));
    }
}
