package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.repository.SignPracticeRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class IncrementSignPracticeOpenCountUseCase_Factory implements Factory<IncrementSignPracticeOpenCountUseCase> {
    private final Provider<SignPracticeRepository> signPracticeRepositoryProvider;

    private IncrementSignPracticeOpenCountUseCase_Factory(Provider<SignPracticeRepository> signPracticeRepositoryProvider) {
        this.signPracticeRepositoryProvider = signPracticeRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public IncrementSignPracticeOpenCountUseCase m1800get() {
        return newInstance((SignPracticeRepository) this.signPracticeRepositoryProvider.get());
    }

    public static IncrementSignPracticeOpenCountUseCase_Factory create(Provider<SignPracticeRepository> signPracticeRepositoryProvider) {
        return new IncrementSignPracticeOpenCountUseCase_Factory(signPracticeRepositoryProvider);
    }

    public static IncrementSignPracticeOpenCountUseCase newInstance(SignPracticeRepository signPracticeRepository) {
        return new IncrementSignPracticeOpenCountUseCase(signPracticeRepository);
    }
}
