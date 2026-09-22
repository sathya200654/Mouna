package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.repository.SettingsRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SetInterpretationModeUseCase_Factory implements Factory<SetInterpretationModeUseCase> {
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<SettingsRepository> settingsRepositoryProvider;

    private SetInterpretationModeUseCase_Factory(Provider<SettingsRepository> settingsRepositoryProvider, Provider<AnalyticsManager> analyticsManagerProvider) {
        this.settingsRepositoryProvider = settingsRepositoryProvider;
        this.analyticsManagerProvider = analyticsManagerProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SetInterpretationModeUseCase m1510get() {
        return newInstance((SettingsRepository) this.settingsRepositoryProvider.get(), (AnalyticsManager) this.analyticsManagerProvider.get());
    }

    public static SetInterpretationModeUseCase_Factory create(Provider<SettingsRepository> settingsRepositoryProvider, Provider<AnalyticsManager> analyticsManagerProvider) {
        return new SetInterpretationModeUseCase_Factory(settingsRepositoryProvider, analyticsManagerProvider);
    }

    public static SetInterpretationModeUseCase newInstance(SettingsRepository settingsRepository, AnalyticsManager analyticsManager) {
        return new SetInterpretationModeUseCase(settingsRepository, analyticsManager);
    }
}
