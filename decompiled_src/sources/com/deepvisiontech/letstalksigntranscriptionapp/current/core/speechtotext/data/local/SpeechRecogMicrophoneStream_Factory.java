package com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.local;

import com.deepvisiontech.letstalksigntranscriptionapp.current.core.audiorecorder.data.local.SharedAudioEngine;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SpeechRecogMicrophoneStream_Factory implements Factory<SpeechRecogMicrophoneStream> {
    private final Provider<SharedAudioEngine> sharedAudioEngineProvider;

    private SpeechRecogMicrophoneStream_Factory(Provider<SharedAudioEngine> sharedAudioEngineProvider) {
        this.sharedAudioEngineProvider = sharedAudioEngineProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SpeechRecogMicrophoneStream m1697get() {
        return newInstance((SharedAudioEngine) this.sharedAudioEngineProvider.get());
    }

    public static SpeechRecogMicrophoneStream_Factory create(Provider<SharedAudioEngine> sharedAudioEngineProvider) {
        return new SpeechRecogMicrophoneStream_Factory(sharedAudioEngineProvider);
    }

    public static SpeechRecogMicrophoneStream newInstance(SharedAudioEngine sharedAudioEngine) {
        return new SpeechRecogMicrophoneStream(sharedAudioEngine);
    }
}
