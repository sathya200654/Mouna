package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.repository.SignPracticeRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class GetSignPracticeFlowUseCase_Factory implements Factory<GetSignPracticeFlowUseCase> {
    private final Provider<SignPracticeRepository> signPracticeRepositoryProvider;

    private GetSignPracticeFlowUseCase_Factory(Provider<SignPracticeRepository> signPracticeRepositoryProvider) {
        this.signPracticeRepositoryProvider = signPracticeRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public GetSignPracticeFlowUseCase m1799get() {
        return newInstance((SignPracticeRepository) this.signPracticeRepositoryProvider.get());
    }

    public static GetSignPracticeFlowUseCase_Factory create(Provider<SignPracticeRepository> signPracticeRepositoryProvider) {
        return new GetSignPracticeFlowUseCase_Factory(signPracticeRepositoryProvider);
    }

    public static GetSignPracticeFlowUseCase newInstance(SignPracticeRepository signPracticeRepository) {
        return new GetSignPracticeFlowUseCase(signPracticeRepository);
    }
}
