package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.repository.SettingsRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SetEnvironmentRecognizerStateUseCase_Factory implements Factory<SetEnvironmentRecognizerStateUseCase> {
    private final Provider<SettingsRepository> settingsRepositoryProvider;

    private SetEnvironmentRecognizerStateUseCase_Factory(Provider<SettingsRepository> settingsRepositoryProvider) {
        this.settingsRepositoryProvider = settingsRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SetEnvironmentRecognizerStateUseCase m1369get() {
        return newInstance((SettingsRepository) this.settingsRepositoryProvider.get());
    }

    public static SetEnvironmentRecognizerStateUseCase_Factory create(Provider<SettingsRepository> settingsRepositoryProvider) {
        return new SetEnvironmentRecognizerStateUseCase_Factory(settingsRepositoryProvider);
    }

    public static SetEnvironmentRecognizerStateUseCase newInstance(SettingsRepository settingsRepository) {
        return new SetEnvironmentRecognizerStateUseCase(settingsRepository);
    }
}
