package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.usecase.FetchAndSaveMailIdUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class CredentialViewModel_Factory implements Factory<CredentialViewModel> {
    private final Provider<FetchAndSaveMailIdUseCase> fetchAndSaveMailIdUseCaseProvider;

    private CredentialViewModel_Factory(Provider<FetchAndSaveMailIdUseCase> fetchAndSaveMailIdUseCaseProvider) {
        this.fetchAndSaveMailIdUseCaseProvider = fetchAndSaveMailIdUseCaseProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public CredentialViewModel m1389get() {
        return newInstance((FetchAndSaveMailIdUseCase) this.fetchAndSaveMailIdUseCaseProvider.get());
    }

    public static CredentialViewModel_Factory create(Provider<FetchAndSaveMailIdUseCase> fetchAndSaveMailIdUseCaseProvider) {
        return new CredentialViewModel_Factory(fetchAndSaveMailIdUseCaseProvider);
    }

    public static CredentialViewModel newInstance(FetchAndSaveMailIdUseCase fetchAndSaveMailIdUseCase) {
        return new CredentialViewModel(fetchAndSaveMailIdUseCase);
    }
}
