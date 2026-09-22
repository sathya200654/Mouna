package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository;

import androidx.credentials.CredentialManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class CredentialRepositoryImpl_Factory implements Factory<CredentialRepositoryImpl> {
    private final Provider<CredentialManager> credentialManagerProvider;

    private CredentialRepositoryImpl_Factory(Provider<CredentialManager> credentialManagerProvider) {
        this.credentialManagerProvider = credentialManagerProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public CredentialRepositoryImpl m1359get() {
        return newInstance((CredentialManager) this.credentialManagerProvider.get());
    }

    public static CredentialRepositoryImpl_Factory create(Provider<CredentialManager> credentialManagerProvider) {
        return new CredentialRepositoryImpl_Factory(credentialManagerProvider);
    }

    public static CredentialRepositoryImpl newInstance(CredentialManager credentialManager) {
        return new CredentialRepositoryImpl(credentialManager);
    }
}
