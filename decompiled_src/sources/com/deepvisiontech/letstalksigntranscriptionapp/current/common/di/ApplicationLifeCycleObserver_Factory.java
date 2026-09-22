package com.deepvisiontech.letstalksigntranscriptionapp.current.common.di;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.repository.AppUsageRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ApplicationLifeCycleObserver_Factory implements Factory<ApplicationLifeCycleObserver> {
    private final Provider<AppUsageRepository> appUsageRepositoryProvider;

    private ApplicationLifeCycleObserver_Factory(Provider<AppUsageRepository> appUsageRepositoryProvider) {
        this.appUsageRepositoryProvider = appUsageRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ApplicationLifeCycleObserver m1410get() {
        return newInstance((AppUsageRepository) this.appUsageRepositoryProvider.get());
    }

    public static ApplicationLifeCycleObserver_Factory create(Provider<AppUsageRepository> appUsageRepositoryProvider) {
        return new ApplicationLifeCycleObserver_Factory(appUsageRepositoryProvider);
    }

    public static ApplicationLifeCycleObserver newInstance(AppUsageRepository appUsageRepository) {
        return new ApplicationLifeCycleObserver(appUsageRepository);
    }
}
