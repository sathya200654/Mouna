package com.deepvisiontech.letstalksigntranscriptionapp.current.app.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.core.audiorecorder.data.local.AudioOrchestrator;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.domain.repository.EnvironmentSoundHistoryRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SendSoundEventsUseCase_Factory implements Factory<SendSoundEventsUseCase> {
    private final Provider<AudioOrchestrator> audioOrchestratorProvider;
    private final Provider<EnvironmentSoundHistoryRepository> historyRepositoryProvider;

    private SendSoundEventsUseCase_Factory(Provider<AudioOrchestrator> audioOrchestratorProvider, Provider<EnvironmentSoundHistoryRepository> historyRepositoryProvider) {
        this.audioOrchestratorProvider = audioOrchestratorProvider;
        this.historyRepositoryProvider = historyRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SendSoundEventsUseCase m1333get() {
        return newInstance((AudioOrchestrator) this.audioOrchestratorProvider.get(), (EnvironmentSoundHistoryRepository) this.historyRepositoryProvider.get());
    }

    public static SendSoundEventsUseCase_Factory create(Provider<AudioOrchestrator> audioOrchestratorProvider, Provider<EnvironmentSoundHistoryRepository> historyRepositoryProvider) {
        return new SendSoundEventsUseCase_Factory(audioOrchestratorProvider, historyRepositoryProvider);
    }

    public static SendSoundEventsUseCase newInstance(AudioOrchestrator audioOrchestrator, EnvironmentSoundHistoryRepository historyRepository) {
        return new SendSoundEventsUseCase(audioOrchestrator, historyRepository);
    }
}
