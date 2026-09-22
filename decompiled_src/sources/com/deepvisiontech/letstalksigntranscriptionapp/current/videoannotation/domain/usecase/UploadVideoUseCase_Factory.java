package com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.domain.repository.VideoUploadRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class UploadVideoUseCase_Factory implements Factory<UploadVideoUseCase> {
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<SessionRepository> sessionRepositoryProvider;
    private final Provider<VideoUploadRepository> videoUploadRepositoryProvider;

    private UploadVideoUseCase_Factory(Provider<VideoUploadRepository> videoUploadRepositoryProvider, Provider<SessionRepository> sessionRepositoryProvider, Provider<AnalyticsManager> analyticsManagerProvider) {
        this.videoUploadRepositoryProvider = videoUploadRepositoryProvider;
        this.sessionRepositoryProvider = sessionRepositoryProvider;
        this.analyticsManagerProvider = analyticsManagerProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public UploadVideoUseCase m1869get() {
        return newInstance((VideoUploadRepository) this.videoUploadRepositoryProvider.get(), (SessionRepository) this.sessionRepositoryProvider.get(), (AnalyticsManager) this.analyticsManagerProvider.get());
    }

    public static UploadVideoUseCase_Factory create(Provider<VideoUploadRepository> videoUploadRepositoryProvider, Provider<SessionRepository> sessionRepositoryProvider, Provider<AnalyticsManager> analyticsManagerProvider) {
        return new UploadVideoUseCase_Factory(videoUploadRepositoryProvider, sessionRepositoryProvider, analyticsManagerProvider);
    }

    public static UploadVideoUseCase newInstance(VideoUploadRepository videoUploadRepository, SessionRepository sessionRepository, AnalyticsManager analyticsManager) {
        return new UploadVideoUseCase(videoUploadRepository, sessionRepository, analyticsManager);
    }
}
