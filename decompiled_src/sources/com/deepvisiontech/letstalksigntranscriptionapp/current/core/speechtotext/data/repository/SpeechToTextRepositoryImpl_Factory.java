package com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.repository;

import com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.remote.api.SpeechToTextApi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SpeechToTextRepositoryImpl_Factory implements Factory<SpeechToTextRepositoryImpl> {
    private final Provider<SpeechToTextApi> speechToTextApiProvider;

    private SpeechToTextRepositoryImpl_Factory(Provider<SpeechToTextApi> speechToTextApiProvider) {
        this.speechToTextApiProvider = speechToTextApiProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SpeechToTextRepositoryImpl m1704get() {
        return newInstance((SpeechToTextApi) this.speechToTextApiProvider.get());
    }

    public static SpeechToTextRepositoryImpl_Factory create(Provider<SpeechToTextApi> speechToTextApiProvider) {
        return new SpeechToTextRepositoryImpl_Factory(speechToTextApiProvider);
    }

    public static SpeechToTextRepositoryImpl newInstance(SpeechToTextApi speechToTextApi) {
        return new SpeechToTextRepositoryImpl(speechToTextApi);
    }
}
