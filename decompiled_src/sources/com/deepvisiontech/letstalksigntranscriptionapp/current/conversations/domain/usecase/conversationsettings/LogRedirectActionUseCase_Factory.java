package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class LogRedirectActionUseCase_Factory implements Factory<LogRedirectActionUseCase> {
    private final Provider<AnalyticsManager> analyticsManagerProvider;

    private LogRedirectActionUseCase_Factory(Provider<AnalyticsManager> analyticsManagerProvider) {
        this.analyticsManagerProvider = analyticsManagerProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public LogRedirectActionUseCase m1502get() {
        return newInstance((AnalyticsManager) this.analyticsManagerProvider.get());
    }

    public static LogRedirectActionUseCase_Factory create(Provider<AnalyticsManager> analyticsManagerProvider) {
        return new LogRedirectActionUseCase_Factory(analyticsManagerProvider);
    }

    public static LogRedirectActionUseCase newInstance(AnalyticsManager analyticsManager) {
        return new LogRedirectActionUseCase(analyticsManager);
    }
}
