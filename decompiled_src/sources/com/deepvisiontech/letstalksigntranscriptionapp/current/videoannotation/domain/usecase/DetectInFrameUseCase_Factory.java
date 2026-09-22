package com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.domain.repository.VisionDetectionRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class DetectInFrameUseCase_Factory implements Factory<DetectInFrameUseCase> {
    private final Provider<VisionDetectionRepository> repositoryProvider;

    private DetectInFrameUseCase_Factory(Provider<VisionDetectionRepository> repositoryProvider) {
        this.repositoryProvider = repositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public DetectInFrameUseCase m1868get() {
        return newInstance((VisionDetectionRepository) this.repositoryProvider.get());
    }

    public static DetectInFrameUseCase_Factory create(Provider<VisionDetectionRepository> repositoryProvider) {
        return new DetectInFrameUseCase_Factory(repositoryProvider);
    }

    public static DetectInFrameUseCase newInstance(VisionDetectionRepository repository) {
        return new DetectInFrameUseCase(repository);
    }
}
