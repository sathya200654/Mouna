package com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.di;

import com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.data.remote.api.VideoApiService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class VideoAnnotationModule_ProvideVideoApiServiceFactory implements Factory<VideoApiService> {
    private final Provider<Retrofit> retrofitProvider;

    private VideoAnnotationModule_ProvideVideoApiServiceFactory(Provider<Retrofit> retrofitProvider) {
        this.retrofitProvider = retrofitProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public VideoApiService m1865get() {
        return provideVideoApiService((Retrofit) this.retrofitProvider.get());
    }

    public static VideoAnnotationModule_ProvideVideoApiServiceFactory create(Provider<Retrofit> retrofitProvider) {
        return new VideoAnnotationModule_ProvideVideoApiServiceFactory(retrofitProvider);
    }

    public static VideoApiService provideVideoApiService(Retrofit retrofit) {
        return (VideoApiService) Preconditions.checkNotNullFromProvides(VideoAnnotationModule.INSTANCE.provideVideoApiService(retrofit));
    }
}
