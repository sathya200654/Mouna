package com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.repository.AppUsageRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ShowShareAppDialogUseCase_Factory implements Factory<ShowShareAppDialogUseCase> {
    private final Provider<AppUsageRepository> appUsageRepositoryProvider;
    private final Provider<EngagementRepository> engagementRepositoryProvider;

    private ShowShareAppDialogUseCase_Factory(Provider<AppUsageRepository> appUsageRepositoryProvider, Provider<EngagementRepository> engagementRepositoryProvider) {
        this.appUsageRepositoryProvider = appUsageRepositoryProvider;
        this.engagementRepositoryProvider = engagementRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ShowShareAppDialogUseCase m1711get() {
        return newInstance((AppUsageRepository) this.appUsageRepositoryProvider.get(), (EngagementRepository) this.engagementRepositoryProvider.get());
    }

    public static ShowShareAppDialogUseCase_Factory create(Provider<AppUsageRepository> appUsageRepositoryProvider, Provider<EngagementRepository> engagementRepositoryProvider) {
        return new ShowShareAppDialogUseCase_Factory(appUsageRepositoryProvider, engagementRepositoryProvider);
    }

    public static ShowShareAppDialogUseCase newInstance(AppUsageRepository appUsageRepository, EngagementRepository engagementRepository) {
        return new ShowShareAppDialogUseCase(appUsageRepository, engagementRepository);
    }
}
