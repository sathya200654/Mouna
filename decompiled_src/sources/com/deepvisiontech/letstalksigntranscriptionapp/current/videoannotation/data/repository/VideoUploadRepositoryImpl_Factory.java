package com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.data.repository;

import com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.data.remote.api.VideoApiService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class VideoUploadRepositoryImpl_Factory implements Factory<VideoUploadRepositoryImpl> {
    private final Provider<VideoApiService> videoApiServiceProvider;

    private VideoUploadRepositoryImpl_Factory(Provider<VideoApiService> videoApiServiceProvider) {
        this.videoApiServiceProvider = videoApiServiceProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public VideoUploadRepositoryImpl m1860get() {
        return newInstance((VideoApiService) this.videoApiServiceProvider.get());
    }

    public static VideoUploadRepositoryImpl_Factory create(Provider<VideoApiService> videoApiServiceProvider) {
        return new VideoUploadRepositoryImpl_Factory(videoApiServiceProvider);
    }

    public static VideoUploadRepositoryImpl newInstance(VideoApiService videoApiService) {
        return new VideoUploadRepositoryImpl(videoApiService);
    }
}
