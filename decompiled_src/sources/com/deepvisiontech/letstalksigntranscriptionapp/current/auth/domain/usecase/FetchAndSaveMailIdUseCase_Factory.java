package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.CredentialRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class FetchAndSaveMailIdUseCase_Factory implements Factory<FetchAndSaveMailIdUseCase> {
    private final Provider<CredentialRepository> credentialRepositoryProvider;
    private final Provider<SessionRepository> sessionRepositoryProvider;

    private FetchAndSaveMailIdUseCase_Factory(Provider<CredentialRepository> credentialRepositoryProvider, Provider<SessionRepository> sessionRepositoryProvider) {
        this.credentialRepositoryProvider = credentialRepositoryProvider;
        this.sessionRepositoryProvider = sessionRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public FetchAndSaveMailIdUseCase m1366get() {
        return newInstance((CredentialRepository) this.credentialRepositoryProvider.get(), (SessionRepository) this.sessionRepositoryProvider.get());
    }

    public static FetchAndSaveMailIdUseCase_Factory create(Provider<CredentialRepository> credentialRepositoryProvider, Provider<SessionRepository> sessionRepositoryProvider) {
        return new FetchAndSaveMailIdUseCase_Factory(credentialRepositoryProvider, sessionRepositoryProvider);
    }

    public static FetchAndSaveMailIdUseCase newInstance(CredentialRepository credentialRepository, SessionRepository sessionRepository) {
        return new FetchAndSaveMailIdUseCase(credentialRepository, sessionRepository);
    }
}
