package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.AuthRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class LoginAndSaveTokenUseCase_Factory implements Factory<LoginAndSaveTokenUseCase> {
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<AuthRepository> authRepositoryProvider;
    private final Provider<SessionRepository> sessionRepositoryProvider;

    private LoginAndSaveTokenUseCase_Factory(Provider<AuthRepository> authRepositoryProvider, Provider<SessionRepository> sessionRepositoryProvider, Provider<AnalyticsManager> analyticsManagerProvider) {
        this.authRepositoryProvider = authRepositoryProvider;
        this.sessionRepositoryProvider = sessionRepositoryProvider;
        this.analyticsManagerProvider = analyticsManagerProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public LoginAndSaveTokenUseCase m1368get() {
        return newInstance((AuthRepository) this.authRepositoryProvider.get(), (SessionRepository) this.sessionRepositoryProvider.get(), (AnalyticsManager) this.analyticsManagerProvider.get());
    }

    public static LoginAndSaveTokenUseCase_Factory create(Provider<AuthRepository> authRepositoryProvider, Provider<SessionRepository> sessionRepositoryProvider, Provider<AnalyticsManager> analyticsManagerProvider) {
        return new LoginAndSaveTokenUseCase_Factory(authRepositoryProvider, sessionRepositoryProvider, analyticsManagerProvider);
    }

    public static LoginAndSaveTokenUseCase newInstance(AuthRepository authRepository, SessionRepository sessionRepository, AnalyticsManager analyticsManager) {
        return new LoginAndSaveTokenUseCase(authRepository, sessionRepository, analyticsManager);
    }
}
