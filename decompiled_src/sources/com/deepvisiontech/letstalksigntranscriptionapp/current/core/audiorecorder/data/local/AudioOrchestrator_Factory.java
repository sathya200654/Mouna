package com.deepvisiontech.letstalksigntranscriptionapp.current.core.audiorecorder.data.local;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.repository.SettingsRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationSpeechRecognizerService;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.domain.services.EnvSoundRecognizerService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class AudioOrchestrator_Factory implements Factory<AudioOrchestrator> {
    private final Provider<EnvSoundRecognizerService> envSoundRecognizerServiceProvider;
    private final Provider<SettingsRepository> settingsRepositoryProvider;
    private final Provider<SharedAudioEngine> sharedAudioEngineProvider;
    private final Provider<ConversationSpeechRecognizerService> speechRecognizerServiceProvider;

    private AudioOrchestrator_Factory(Provider<SharedAudioEngine> sharedAudioEngineProvider, Provider<ConversationSpeechRecognizerService> speechRecognizerServiceProvider, Provider<EnvSoundRecognizerService> envSoundRecognizerServiceProvider, Provider<SettingsRepository> settingsRepositoryProvider) {
        this.sharedAudioEngineProvider = sharedAudioEngineProvider;
        this.speechRecognizerServiceProvider = speechRecognizerServiceProvider;
        this.envSoundRecognizerServiceProvider = envSoundRecognizerServiceProvider;
        this.settingsRepositoryProvider = settingsRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public AudioOrchestrator m1668get() {
        return newInstance((SharedAudioEngine) this.sharedAudioEngineProvider.get(), (ConversationSpeechRecognizerService) this.speechRecognizerServiceProvider.get(), (EnvSoundRecognizerService) this.envSoundRecognizerServiceProvider.get(), (SettingsRepository) this.settingsRepositoryProvider.get());
    }

    public static AudioOrchestrator_Factory create(Provider<SharedAudioEngine> sharedAudioEngineProvider, Provider<ConversationSpeechRecognizerService> speechRecognizerServiceProvider, Provider<EnvSoundRecognizerService> envSoundRecognizerServiceProvider, Provider<SettingsRepository> settingsRepositoryProvider) {
        return new AudioOrchestrator_Factory(sharedAudioEngineProvider, speechRecognizerServiceProvider, envSoundRecognizerServiceProvider, settingsRepositoryProvider);
    }

    public static AudioOrchestrator newInstance(SharedAudioEngine sharedAudioEngine, ConversationSpeechRecognizerService speechRecognizerService, EnvSoundRecognizerService envSoundRecognizerService, SettingsRepository settingsRepository) {
        return new AudioOrchestrator(sharedAudioEngine, speechRecognizerService, envSoundRecognizerService, settingsRepository);
    }
}
