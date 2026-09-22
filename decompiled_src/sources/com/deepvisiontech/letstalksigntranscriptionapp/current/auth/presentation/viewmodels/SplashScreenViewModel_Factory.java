package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.usecase.SyncPendingPersonaDataUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SplashScreenViewModel_Factory implements Factory<SplashScreenViewModel> {
    private final Provider<SessionRepository> sessionRepositoryProvider;
    private final Provider<SyncPendingPersonaDataUseCase> syncPendingPersonaDataUseCaseProvider;

    private SplashScreenViewModel_Factory(Provider<SessionRepository> sessionRepositoryProvider, Provider<SyncPendingPersonaDataUseCase> syncPendingPersonaDataUseCaseProvider) {
        this.sessionRepositoryProvider = sessionRepositoryProvider;
        this.syncPendingPersonaDataUseCaseProvider = syncPendingPersonaDataUseCaseProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SplashScreenViewModel m1393get() {
        return newInstance((SessionRepository) this.sessionRepositoryProvider.get(), (SyncPendingPersonaDataUseCase) this.syncPendingPersonaDataUseCaseProvider.get());
    }

    public static SplashScreenViewModel_Factory create(Provider<SessionRepository> sessionRepositoryProvider, Provider<SyncPendingPersonaDataUseCase> syncPendingPersonaDataUseCaseProvider) {
        return new SplashScreenViewModel_Factory(sessionRepositoryProvider, syncPendingPersonaDataUseCaseProvider);
    }

    public static SplashScreenViewModel newInstance(SessionRepository sessionRepository, SyncPendingPersonaDataUseCase syncPendingPersonaDataUseCase) {
        return new SplashScreenViewModel(sessionRepository, syncPendingPersonaDataUseCase);
    }
}
