package com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.factory;

import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.local.SpeechRecogMicrophoneStream;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.repository.SpeechToTextRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SpeechRecognizerFactory_Factory implements Factory<SpeechRecognizerFactory> {
    private final Provider<SessionRepository> sessionRepositoryProvider;
    private final Provider<SpeechToTextRepository> speechToTextRepositoryProvider;
    private final Provider<SpeechRecogMicrophoneStream> streamProvider;

    private SpeechRecognizerFactory_Factory(Provider<SpeechRecogMicrophoneStream> streamProvider, Provider<SpeechToTextRepository> speechToTextRepositoryProvider, Provider<SessionRepository> sessionRepositoryProvider) {
        this.streamProvider = streamProvider;
        this.speechToTextRepositoryProvider = speechToTextRepositoryProvider;
        this.sessionRepositoryProvider = sessionRepositoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SpeechRecognizerFactory m1696get() {
        return newInstance(this.streamProvider, (SpeechToTextRepository) this.speechToTextRepositoryProvider.get(), (SessionRepository) this.sessionRepositoryProvider.get());
    }

    public static SpeechRecognizerFactory_Factory create(Provider<SpeechRecogMicrophoneStream> streamProvider, Provider<SpeechToTextRepository> speechToTextRepositoryProvider, Provider<SessionRepository> sessionRepositoryProvider) {
        return new SpeechRecognizerFactory_Factory(streamProvider, speechToTextRepositoryProvider, sessionRepositoryProvider);
    }

    public static SpeechRecognizerFactory newInstance(javax.inject.Provider<SpeechRecogMicrophoneStream> streamProvider, SpeechToTextRepository speechToTextRepository, SessionRepository sessionRepository) {
        return new SpeechRecognizerFactory(streamProvider, speechToTextRepository, sessionRepository);
    }
}
