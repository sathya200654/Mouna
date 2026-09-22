package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.repository.SignPracticeRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class DeleteSignPracticeUseCase_Factory implements Factory<DeleteSignPracticeUseCase> {
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<SignPracticeRepository> signPracticeRepositoryProvider;

    private DeleteSignPracticeUseCase_Factory(Provider<SignPracticeRepository> signPracticeRepositoryProvider, Provider<AnalyticsManager> analyticsManagerProvider) {
        this.signPracticeRepositoryProvider = signPracticeRepositoryProvider;
        this.analyticsManagerProvider = analyticsManagerProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public DeleteSignPracticeUseCase m1797get() {
        return newInstance((SignPracticeRepository) this.signPracticeRepositoryProvider.get(), (AnalyticsManager) this.analyticsManagerProvider.get());
    }

    public static DeleteSignPracticeUseCase_Factory create(Provider<SignPracticeRepository> signPracticeRepositoryProvider, Provider<AnalyticsManager> analyticsManagerProvider) {
        return new DeleteSignPracticeUseCase_Factory(signPracticeRepositoryProvider, analyticsManagerProvider);
    }

    public static DeleteSignPracticeUseCase newInstance(SignPracticeRepository signPracticeRepository, AnalyticsManager analyticsManager) {
        return new DeleteSignPracticeUseCase(signPracticeRepository, analyticsManager);
    }
}
