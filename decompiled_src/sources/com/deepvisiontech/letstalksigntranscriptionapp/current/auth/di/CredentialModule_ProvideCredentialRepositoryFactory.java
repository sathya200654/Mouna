package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.di;

import androidx.credentials.CredentialManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.CredentialRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class CredentialModule_ProvideCredentialRepositoryFactory implements Factory<CredentialRepository> {
    private final Provider<CredentialManager> credentialManagerProvider;

    private CredentialModule_ProvideCredentialRepositoryFactory(Provider<CredentialManager> credentialManagerProvider) {
        this.credentialManagerProvider = credentialManagerProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public CredentialRepository m1364get() {
        return provideCredentialRepository((CredentialManager) this.credentialManagerProvider.get());
    }

    public static CredentialModule_ProvideCredentialRepositoryFactory create(Provider<CredentialManager> credentialManagerProvider) {
        return new CredentialModule_ProvideCredentialRepositoryFactory(credentialManagerProvider);
    }

    public static CredentialRepository provideCredentialRepository(CredentialManager credentialManager) {
        return (CredentialRepository) Preconditions.checkNotNullFromProvides(CredentialModule.INSTANCE.provideCredentialRepository(credentialManager));
    }
}
