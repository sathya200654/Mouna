package com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.di;

import android.content.Context;
import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.repository.AppUsageRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class AnalyticsModule_ProvideAppUsageRepositoryFactory implements Factory<AppUsageRepository> {
    private final Provider<Context> contextProvider;

    private AnalyticsModule_ProvideAppUsageRepositoryFactory(Provider<Context> contextProvider) {
        this.contextProvider = contextProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public AppUsageRepository m1312get() {
        return provideAppUsageRepository((Context) this.contextProvider.get());
    }

    public static AnalyticsModule_ProvideAppUsageRepositoryFactory create(Provider<Context> contextProvider) {
        return new AnalyticsModule_ProvideAppUsageRepositoryFactory(contextProvider);
    }

    public static AppUsageRepository provideAppUsageRepository(Context context) {
        return (AppUsageRepository) Preconditions.checkNotNullFromProvides(AnalyticsModule.INSTANCE.provideAppUsageRepository(context));
    }
}
