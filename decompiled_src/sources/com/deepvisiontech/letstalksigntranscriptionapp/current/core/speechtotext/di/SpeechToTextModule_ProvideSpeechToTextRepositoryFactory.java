package com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.di;

import com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.remote.api.SpeechToTextApi;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.repository.SpeechToTextRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SpeechToTextModule_ProvideSpeechToTextRepositoryFactory implements Factory<SpeechToTextRepository> {
    private final Provider<SpeechToTextApi> speechToTextApiProvider;

    private SpeechToTextModule_ProvideSpeechToTextRepositoryFactory(Provider<SpeechToTextApi> speechToTextApiProvider) {
        this.speechToTextApiProvider = speechToTextApiProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SpeechToTextRepository m1706get() {
        return provideSpeechToTextRepository((SpeechToTextApi) this.speechToTextApiProvider.get());
    }

    public static SpeechToTextModule_ProvideSpeechToTextRepositoryFactory create(Provider<SpeechToTextApi> speechToTextApiProvider) {
        return new SpeechToTextModule_ProvideSpeechToTextRepositoryFactory(speechToTextApiProvider);
    }

    public static SpeechToTextRepository provideSpeechToTextRepository(SpeechToTextApi speechToTextApi) {
        return (SpeechToTextRepository) Preconditions.checkNotNullFromProvides(SpeechToTextModule.INSTANCE.provideSpeechToTextRepository(speechToTextApi));
    }
}
