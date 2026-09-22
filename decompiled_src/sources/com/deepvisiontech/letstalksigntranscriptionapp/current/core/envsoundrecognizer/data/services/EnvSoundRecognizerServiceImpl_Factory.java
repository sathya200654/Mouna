package com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.services;

import android.content.Context;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.audiorecorder.data.local.SharedAudioEngine;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class EnvSoundRecognizerServiceImpl_Factory implements Factory<EnvSoundRecognizerServiceImpl> {
    private final Provider<Context> contextProvider;
    private final Provider<SharedAudioEngine> sharedAudioEngineProvider;

    private EnvSoundRecognizerServiceImpl_Factory(Provider<Context> contextProvider, Provider<SharedAudioEngine> sharedAudioEngineProvider) {
        this.contextProvider = contextProvider;
        this.sharedAudioEngineProvider = sharedAudioEngineProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public EnvSoundRecognizerServiceImpl m1674get() {
        return newInstance((Context) this.contextProvider.get(), (SharedAudioEngine) this.sharedAudioEngineProvider.get());
    }

    public static EnvSoundRecognizerServiceImpl_Factory create(Provider<Context> contextProvider, Provider<SharedAudioEngine> sharedAudioEngineProvider) {
        return new EnvSoundRecognizerServiceImpl_Factory(contextProvider, sharedAudioEngineProvider);
    }

    public static EnvSoundRecognizerServiceImpl newInstance(Context context, SharedAudioEngine sharedAudioEngine) {
        return new EnvSoundRecognizerServiceImpl(context, sharedAudioEngine);
    }
}
