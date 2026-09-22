package com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.di;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.repository.AnalyticsRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class AnalyticsModule_ProvideAnalyticsManagerFactory implements Factory<AnalyticsManager> {
    private final Provider<AnalyticsRepository> analyticsRepositoryProvider;
    private final Provider<SessionRepository> sessionRepositoryProvider;

    private AnalyticsModule_ProvideAnalyticsManagerFactory(Provider<SessionRepository> sessionRepositoryProvider, Provider<AnalyticsRepository> analyticsRepositoryProvider) {
        this.sessionRepositoryProvider = sessionRepositoryProvider;
        this.analyticsRepositoryProvider = analyticsRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public AnalyticsManager m1310get() {
        return provideAnalyticsManager((SessionRepository) this.sessionRepositoryProvider.get(), (AnalyticsRepository) this.analyticsRepositoryProvider.get());
    }

    public static AnalyticsModule_ProvideAnalyticsManagerFactory create(Provider<SessionRepository> sessionRepositoryProvider, Provider<AnalyticsRepository> analyticsRepositoryProvider) {
        return new AnalyticsModule_ProvideAnalyticsManagerFactory(sessionRepositoryProvider, analyticsRepositoryProvider);
    }

    public static AnalyticsManager provideAnalyticsManager(SessionRepository sessionRepository, AnalyticsRepository analyticsRepository) {
        return (AnalyticsManager) Preconditions.checkNotNullFromProvides(AnalyticsModule.INSTANCE.provideAnalyticsManager(sessionRepository, analyticsRepository));
    }
}
