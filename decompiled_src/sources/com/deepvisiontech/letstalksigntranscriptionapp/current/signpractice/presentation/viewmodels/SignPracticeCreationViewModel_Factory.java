package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.repository.SignPracticeRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase.InsertSignPracticeAndGetIdUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SignPracticeCreationViewModel_Factory implements Factory<SignPracticeCreationViewModel> {
    private final Provider<InsertSignPracticeAndGetIdUseCase> insertSignPracticeAndGetIdUseCaseProvider;
    private final Provider<SignPracticeRepository> signPracticeRepositoryProvider;

    private SignPracticeCreationViewModel_Factory(Provider<InsertSignPracticeAndGetIdUseCase> insertSignPracticeAndGetIdUseCaseProvider, Provider<SignPracticeRepository> signPracticeRepositoryProvider) {
        this.insertSignPracticeAndGetIdUseCaseProvider = insertSignPracticeAndGetIdUseCaseProvider;
        this.signPracticeRepositoryProvider = signPracticeRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SignPracticeCreationViewModel m1854get() {
        return newInstance((InsertSignPracticeAndGetIdUseCase) this.insertSignPracticeAndGetIdUseCaseProvider.get(), (SignPracticeRepository) this.signPracticeRepositoryProvider.get());
    }

    public static SignPracticeCreationViewModel_Factory create(Provider<InsertSignPracticeAndGetIdUseCase> insertSignPracticeAndGetIdUseCaseProvider, Provider<SignPracticeRepository> signPracticeRepositoryProvider) {
        return new SignPracticeCreationViewModel_Factory(insertSignPracticeAndGetIdUseCaseProvider, signPracticeRepositoryProvider);
    }

    public static SignPracticeCreationViewModel newInstance(InsertSignPracticeAndGetIdUseCase insertSignPracticeAndGetIdUseCase, SignPracticeRepository signPracticeRepository) {
        return new SignPracticeCreationViewModel(insertSignPracticeAndGetIdUseCase, signPracticeRepository);
    }
}
