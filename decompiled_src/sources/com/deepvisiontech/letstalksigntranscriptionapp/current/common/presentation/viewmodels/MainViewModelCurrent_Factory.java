package com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.usecase.LogOutAndClearMailIdUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.usecase.ShowShareAppDialogUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class MainViewModelCurrent_Factory implements Factory<MainViewModelCurrent> {
    private final Provider<EngagementRepository> engagementRepositoryProvider;
    private final Provider<LogOutAndClearMailIdUseCase> logOutAndClearMailIdUseCaseProvider;
    private final Provider<ShowShareAppDialogUseCase> showShareAppDialogUseCaseProvider;

    private MainViewModelCurrent_Factory(Provider<ShowShareAppDialogUseCase> showShareAppDialogUseCaseProvider, Provider<EngagementRepository> engagementRepositoryProvider, Provider<LogOutAndClearMailIdUseCase> logOutAndClearMailIdUseCaseProvider) {
        this.showShareAppDialogUseCaseProvider = showShareAppDialogUseCaseProvider;
        this.engagementRepositoryProvider = engagementRepositoryProvider;
        this.logOutAndClearMailIdUseCaseProvider = logOutAndClearMailIdUseCaseProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public MainViewModelCurrent m1456get() {
        return newInstance((ShowShareAppDialogUseCase) this.showShareAppDialogUseCaseProvider.get(), (EngagementRepository) this.engagementRepositoryProvider.get(), (LogOutAndClearMailIdUseCase) this.logOutAndClearMailIdUseCaseProvider.get());
    }

    public static MainViewModelCurrent_Factory create(Provider<ShowShareAppDialogUseCase> showShareAppDialogUseCaseProvider, Provider<EngagementRepository> engagementRepositoryProvider, Provider<LogOutAndClearMailIdUseCase> logOutAndClearMailIdUseCaseProvider) {
        return new MainViewModelCurrent_Factory(showShareAppDialogUseCaseProvider, engagementRepositoryProvider, logOutAndClearMailIdUseCaseProvider);
    }

    public static MainViewModelCurrent newInstance(ShowShareAppDialogUseCase showShareAppDialogUseCase, EngagementRepository engagementRepository, LogOutAndClearMailIdUseCase logOutAndClearMailIdUseCase) {
        return new MainViewModelCurrent(showShareAppDialogUseCase, engagementRepository, logOutAndClearMailIdUseCase);
    }
}
