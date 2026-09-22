package com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.repository.AnalyticsRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class AnalyticsManager_Factory implements Factory<AnalyticsManager> {
    private final Provider<AnalyticsRepository> analyticsRepositoryProvider;
    private final Provider<SessionRepository> sessionRepositoryProvider;

    private AnalyticsManager_Factory(Provider<SessionRepository> sessionRepositoryProvider, Provider<AnalyticsRepository> analyticsRepositoryProvider) {
        this.sessionRepositoryProvider = sessionRepositoryProvider;
        this.analyticsRepositoryProvider = analyticsRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public AnalyticsManager m1308get() {
        return newInstance((SessionRepository) this.sessionRepositoryProvider.get(), (AnalyticsRepository) this.analyticsRepositoryProvider.get());
    }

    public static AnalyticsManager_Factory create(Provider<SessionRepository> sessionRepositoryProvider, Provider<AnalyticsRepository> analyticsRepositoryProvider) {
        return new AnalyticsManager_Factory(sessionRepositoryProvider, analyticsRepositoryProvider);
    }

    public static AnalyticsManager newInstance(SessionRepository sessionRepository, AnalyticsRepository analyticsRepository) {
        return new AnalyticsManager(sessionRepository, analyticsRepository);
    }
}
