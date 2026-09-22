package com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer;

import android.content.Context;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.audiorecorder.data.local.SharedAudioEngine;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.domain.services.EnvSoundRecognizerService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SoundRecognizerModule_ProvidesSoundRecognizerServiceFactory implements Factory<EnvSoundRecognizerService> {
    private final Provider<Context> contextProvider;
    private final Provider<SharedAudioEngine> sharedAudioEngineProvider;

    private SoundRecognizerModule_ProvidesSoundRecognizerServiceFactory(Provider<Context> contextProvider, Provider<SharedAudioEngine> sharedAudioEngineProvider) {
        this.contextProvider = contextProvider;
        this.sharedAudioEngineProvider = sharedAudioEngineProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public EnvSoundRecognizerService m1670get() {
        return providesSoundRecognizerService((Context) this.contextProvider.get(), (SharedAudioEngine) this.sharedAudioEngineProvider.get());
    }

    public static SoundRecognizerModule_ProvidesSoundRecognizerServiceFactory create(Provider<Context> contextProvider, Provider<SharedAudioEngine> sharedAudioEngineProvider) {
        return new SoundRecognizerModule_ProvidesSoundRecognizerServiceFactory(contextProvider, sharedAudioEngineProvider);
    }

    public static EnvSoundRecognizerService providesSoundRecognizerService(Context context, SharedAudioEngine sharedAudioEngine) {
        return (EnvSoundRecognizerService) Preconditions.checkNotNullFromProvides(SoundRecognizerModule.INSTANCE.providesSoundRecognizerService(context, sharedAudioEngine));
    }
}
