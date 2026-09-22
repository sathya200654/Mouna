package com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.di;

import com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.data.remote.api.VideoApiService;
import com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.domain.repository.VideoUploadRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class VideoAnnotationModule_ProvideVideoUploadRepositoryFactory implements Factory<VideoUploadRepository> {
    private final Provider<VideoApiService> videoApiServiceProvider;

    private VideoAnnotationModule_ProvideVideoUploadRepositoryFactory(Provider<VideoApiService> videoApiServiceProvider) {
        this.videoApiServiceProvider = videoApiServiceProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public VideoUploadRepository m1867get() {
        return provideVideoUploadRepository((VideoApiService) this.videoApiServiceProvider.get());
    }

    public static VideoAnnotationModule_ProvideVideoUploadRepositoryFactory create(Provider<VideoApiService> videoApiServiceProvider) {
        return new VideoAnnotationModule_ProvideVideoUploadRepositoryFactory(videoApiServiceProvider);
    }

    public static VideoUploadRepository provideVideoUploadRepository(VideoApiService videoApiService) {
        return (VideoUploadRepository) Preconditions.checkNotNullFromProvides(VideoAnnotationModule.INSTANCE.provideVideoUploadRepository(videoApiService));
    }
}
