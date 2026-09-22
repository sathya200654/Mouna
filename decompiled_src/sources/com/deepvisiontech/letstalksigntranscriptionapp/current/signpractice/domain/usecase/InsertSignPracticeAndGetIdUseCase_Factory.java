package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.texttospeech.TextToSpeechManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.repository.SignPracticeRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class InsertSignPracticeAndGetIdUseCase_Factory implements Factory<InsertSignPracticeAndGetIdUseCase> {
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<SessionRepository> sessionRepositoryProvider;
    private final Provider<SignPracticeRepository> signPracticeRepositoryProvider;
    private final Provider<TextToSpeechManager> textToSpeechManagerProvider;

    private InsertSignPracticeAndGetIdUseCase_Factory(Provider<SignPracticeRepository> signPracticeRepositoryProvider, Provider<SessionRepository> sessionRepositoryProvider, Provider<AnalyticsManager> analyticsManagerProvider, Provider<TextToSpeechManager> textToSpeechManagerProvider) {
        this.signPracticeRepositoryProvider = signPracticeRepositoryProvider;
        this.sessionRepositoryProvider = sessionRepositoryProvider;
        this.analyticsManagerProvider = analyticsManagerProvider;
        this.textToSpeechManagerProvider = textToSpeechManagerProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public InsertSignPracticeAndGetIdUseCase m1801get() {
        return newInstance((SignPracticeRepository) this.signPracticeRepositoryProvider.get(), (SessionRepository) this.sessionRepositoryProvider.get(), (AnalyticsManager) this.analyticsManagerProvider.get(), (TextToSpeechManager) this.textToSpeechManagerProvider.get());
    }

    public static InsertSignPracticeAndGetIdUseCase_Factory create(Provider<SignPracticeRepository> signPracticeRepositoryProvider, Provider<SessionRepository> sessionRepositoryProvider, Provider<AnalyticsManager> analyticsManagerProvider, Provider<TextToSpeechManager> textToSpeechManagerProvider) {
        return new InsertSignPracticeAndGetIdUseCase_Factory(signPracticeRepositoryProvider, sessionRepositoryProvider, analyticsManagerProvider, textToSpeechManagerProvider);
    }

    public static InsertSignPracticeAndGetIdUseCase newInstance(SignPracticeRepository signPracticeRepository, SessionRepository sessionRepository, AnalyticsManager analyticsManager, TextToSpeechManager textToSpeechManager) {
        return new InsertSignPracticeAndGetIdUseCase(signPracticeRepository, sessionRepository, analyticsManager, textToSpeechManager);
    }
}
