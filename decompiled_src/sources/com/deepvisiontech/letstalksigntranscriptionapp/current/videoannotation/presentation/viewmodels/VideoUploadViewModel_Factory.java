package com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.data.vision.VisionDetector;
import com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.domain.usecase.UploadVideoUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class VideoUploadViewModel_Factory implements Factory<VideoUploadViewModel> {
    private final Provider<UploadVideoUseCase> uploadVideoUseCaseProvider;
    private final Provider<VisionDetector> visionDetectorProvider;

    private VideoUploadViewModel_Factory(Provider<UploadVideoUseCase> uploadVideoUseCaseProvider, Provider<VisionDetector> visionDetectorProvider) {
        this.uploadVideoUseCaseProvider = uploadVideoUseCaseProvider;
        this.visionDetectorProvider = visionDetectorProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public VideoUploadViewModel m1884get() {
        return newInstance((UploadVideoUseCase) this.uploadVideoUseCaseProvider.get(), this.visionDetectorProvider);
    }

    public static VideoUploadViewModel_Factory create(Provider<UploadVideoUseCase> uploadVideoUseCaseProvider, Provider<VisionDetector> visionDetectorProvider) {
        return new VideoUploadViewModel_Factory(uploadVideoUseCaseProvider, visionDetectorProvider);
    }

    public static VideoUploadViewModel newInstance(UploadVideoUseCase uploadVideoUseCase, javax.inject.Provider<VisionDetector> visionDetectorProvider) {
        return new VideoUploadViewModel(uploadVideoUseCase, visionDetectorProvider);
    }
}
