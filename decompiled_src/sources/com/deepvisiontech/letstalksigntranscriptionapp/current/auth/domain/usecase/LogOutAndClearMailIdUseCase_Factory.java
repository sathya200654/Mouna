package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.AuthRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.CredentialRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class LogOutAndClearMailIdUseCase_Factory implements Factory<LogOutAndClearMailIdUseCase> {
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<AuthRepository> authRepositoryProvider;
    private final Provider<CredentialRepository> credentialRepositoryProvider;
    private final Provider<SessionRepository> sessionRepositoryProvider;

    private LogOutAndClearMailIdUseCase_Factory(Provider<AuthRepository> authRepositoryProvider, Provider<SessionRepository> sessionRepositoryProvider, Provider<CredentialRepository> credentialRepositoryProvider, Provider<AnalyticsManager> analyticsManagerProvider) {
        this.authRepositoryProvider = authRepositoryProvider;
        this.sessionRepositoryProvider = sessionRepositoryProvider;
        this.credentialRepositoryProvider = credentialRepositoryProvider;
        this.analyticsManagerProvider = analyticsManagerProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public LogOutAndClearMailIdUseCase m1367get() {
        return newInstance((AuthRepository) this.authRepositoryProvider.get(), (SessionRepository) this.sessionRepositoryProvider.get(), (CredentialRepository) this.credentialRepositoryProvider.get(), (AnalyticsManager) this.analyticsManagerProvider.get());
    }

    public static LogOutAndClearMailIdUseCase_Factory create(Provider<AuthRepository> authRepositoryProvider, Provider<SessionRepository> sessionRepositoryProvider, Provider<CredentialRepository> credentialRepositoryProvider, Provider<AnalyticsManager> analyticsManagerProvider) {
        return new LogOutAndClearMailIdUseCase_Factory(authRepositoryProvider, sessionRepositoryProvider, credentialRepositoryProvider, analyticsManagerProvider);
    }

    public static LogOutAndClearMailIdUseCase newInstance(AuthRepository authRepository, SessionRepository sessionRepository, CredentialRepository credentialRepository, AnalyticsManager analyticsManager) {
        return new LogOutAndClearMailIdUseCase(authRepository, sessionRepository, credentialRepository, analyticsManager);
    }
}
