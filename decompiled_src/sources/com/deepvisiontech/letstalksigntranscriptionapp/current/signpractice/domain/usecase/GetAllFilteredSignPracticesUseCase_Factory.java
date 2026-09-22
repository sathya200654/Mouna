package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.repository.SignPracticeRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class GetAllFilteredSignPracticesUseCase_Factory implements Factory<GetAllFilteredSignPracticesUseCase> {
    private final Provider<SignPracticeRepository> signPracticeRepositoryProvider;

    private GetAllFilteredSignPracticesUseCase_Factory(Provider<SignPracticeRepository> signPracticeRepositoryProvider) {
        this.signPracticeRepositoryProvider = signPracticeRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public GetAllFilteredSignPracticesUseCase m1798get() {
        return newInstance((SignPracticeRepository) this.signPracticeRepositoryProvider.get());
    }

    public static GetAllFilteredSignPracticesUseCase_Factory create(Provider<SignPracticeRepository> signPracticeRepositoryProvider) {
        return new GetAllFilteredSignPracticesUseCase_Factory(signPracticeRepositoryProvider);
    }

    public static GetAllFilteredSignPracticesUseCase newInstance(SignPracticeRepository signPracticeRepository) {
        return new GetAllFilteredSignPracticesUseCase(signPracticeRepository);
    }
}
