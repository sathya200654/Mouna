package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.repository.SettingsRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SetInterpretationSpeedUseCase_Factory implements Factory<SetInterpretationSpeedUseCase> {
    private final Provider<SettingsRepository> settingsRepositoryProvider;

    private SetInterpretationSpeedUseCase_Factory(Provider<SettingsRepository> settingsRepositoryProvider) {
        this.settingsRepositoryProvider = settingsRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SetInterpretationSpeedUseCase m1511get() {
        return newInstance((SettingsRepository) this.settingsRepositoryProvider.get());
    }

    public static SetInterpretationSpeedUseCase_Factory create(Provider<SettingsRepository> settingsRepositoryProvider) {
        return new SetInterpretationSpeedUseCase_Factory(settingsRepositoryProvider);
    }

    public static SetInterpretationSpeedUseCase newInstance(SettingsRepository settingsRepository) {
        return new SetInterpretationSpeedUseCase(settingsRepository);
    }
}
