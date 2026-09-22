package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase.DeleteSignPracticeUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase.GetAllFilteredSignPracticesUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase.IncrementSignPracticeOpenCountUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SignPracticeListViewModel_Factory implements Factory<SignPracticeListViewModel> {
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<DeleteSignPracticeUseCase> deleteSignPracticeUseCaseProvider;
    private final Provider<GetAllFilteredSignPracticesUseCase> getAllFilteredSignPracticeUseCaseProvider;
    private final Provider<IncrementSignPracticeOpenCountUseCase> incrementSignPracticeOpenCountUseCaseProvider;

    private SignPracticeListViewModel_Factory(Provider<DeleteSignPracticeUseCase> deleteSignPracticeUseCaseProvider, Provider<IncrementSignPracticeOpenCountUseCase> incrementSignPracticeOpenCountUseCaseProvider, Provider<AnalyticsManager> analyticsManagerProvider, Provider<GetAllFilteredSignPracticesUseCase> getAllFilteredSignPracticeUseCaseProvider) {
        this.deleteSignPracticeUseCaseProvider = deleteSignPracticeUseCaseProvider;
        this.incrementSignPracticeOpenCountUseCaseProvider = incrementSignPracticeOpenCountUseCaseProvider;
        this.analyticsManagerProvider = analyticsManagerProvider;
        this.getAllFilteredSignPracticeUseCaseProvider = getAllFilteredSignPracticeUseCaseProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SignPracticeListViewModel m1856get() {
        return newInstance((DeleteSignPracticeUseCase) this.deleteSignPracticeUseCaseProvider.get(), (IncrementSignPracticeOpenCountUseCase) this.incrementSignPracticeOpenCountUseCaseProvider.get(), (AnalyticsManager) this.analyticsManagerProvider.get(), (GetAllFilteredSignPracticesUseCase) this.getAllFilteredSignPracticeUseCaseProvider.get());
    }

    public static SignPracticeListViewModel_Factory create(Provider<DeleteSignPracticeUseCase> deleteSignPracticeUseCaseProvider, Provider<IncrementSignPracticeOpenCountUseCase> incrementSignPracticeOpenCountUseCaseProvider, Provider<AnalyticsManager> analyticsManagerProvider, Provider<GetAllFilteredSignPracticesUseCase> getAllFilteredSignPracticeUseCaseProvider) {
        return new SignPracticeListViewModel_Factory(deleteSignPracticeUseCaseProvider, incrementSignPracticeOpenCountUseCaseProvider, analyticsManagerProvider, getAllFilteredSignPracticeUseCaseProvider);
    }

    public static SignPracticeListViewModel newInstance(DeleteSignPracticeUseCase deleteSignPracticeUseCase, IncrementSignPracticeOpenCountUseCase incrementSignPracticeOpenCountUseCase, AnalyticsManager analyticsManager, GetAllFilteredSignPracticesUseCase getAllFilteredSignPracticeUseCase) {
        return new SignPracticeListViewModel(deleteSignPracticeUseCase, incrementSignPracticeOpenCountUseCase, analyticsManager, getAllFilteredSignPracticeUseCase);
    }
}
