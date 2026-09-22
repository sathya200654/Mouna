package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.repository.SettingsRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SetEnvironmentRecognitionStateUseCase_Factory implements Factory<SetEnvironmentRecognitionStateUseCase> {
    private final Provider<SettingsRepository> settingsRepositoryProvider;

    private SetEnvironmentRecognitionStateUseCase_Factory(Provider<SettingsRepository> settingsRepositoryProvider) {
        this.settingsRepositoryProvider = settingsRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SetEnvironmentRecognitionStateUseCase m1509get() {
        return newInstance((SettingsRepository) this.settingsRepositoryProvider.get());
    }

    public static SetEnvironmentRecognitionStateUseCase_Factory create(Provider<SettingsRepository> settingsRepositoryProvider) {
        return new SetEnvironmentRecognitionStateUseCase_Factory(settingsRepositoryProvider);
    }

    public static SetEnvironmentRecognitionStateUseCase newInstance(SettingsRepository settingsRepository) {
        return new SetEnvironmentRecognitionStateUseCase(settingsRepository);
    }
}
