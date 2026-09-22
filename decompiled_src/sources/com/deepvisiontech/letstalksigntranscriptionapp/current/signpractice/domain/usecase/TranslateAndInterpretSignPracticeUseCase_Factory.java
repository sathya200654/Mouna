package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.repository.LtsTranslationRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.WebViewManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class TranslateAndInterpretSignPracticeUseCase_Factory implements Factory<TranslateAndInterpretSignPracticeUseCase> {
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<LtsTranslationRepository> ltsTranslationRepositoryProvider;
    private final Provider<SessionRepository> sessionRepositoryProvider;
    private final Provider<WebViewManager> webViewManagerProvider;

    private TranslateAndInterpretSignPracticeUseCase_Factory(Provider<WebViewManager> webViewManagerProvider, Provider<SessionRepository> sessionRepositoryProvider, Provider<LtsTranslationRepository> ltsTranslationRepositoryProvider, Provider<AnalyticsManager> analyticsManagerProvider) {
        this.webViewManagerProvider = webViewManagerProvider;
        this.sessionRepositoryProvider = sessionRepositoryProvider;
        this.ltsTranslationRepositoryProvider = ltsTranslationRepositoryProvider;
        this.analyticsManagerProvider = analyticsManagerProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public TranslateAndInterpretSignPracticeUseCase m1802get() {
        return newInstance((WebViewManager) this.webViewManagerProvider.get(), (SessionRepository) this.sessionRepositoryProvider.get(), (LtsTranslationRepository) this.ltsTranslationRepositoryProvider.get(), (AnalyticsManager) this.analyticsManagerProvider.get());
    }

    public static TranslateAndInterpretSignPracticeUseCase_Factory create(Provider<WebViewManager> webViewManagerProvider, Provider<SessionRepository> sessionRepositoryProvider, Provider<LtsTranslationRepository> ltsTranslationRepositoryProvider, Provider<AnalyticsManager> analyticsManagerProvider) {
        return new TranslateAndInterpretSignPracticeUseCase_Factory(webViewManagerProvider, sessionRepositoryProvider, ltsTranslationRepositoryProvider, analyticsManagerProvider);
    }

    public static TranslateAndInterpretSignPracticeUseCase newInstance(WebViewManager webViewManager, SessionRepository sessionRepository, LtsTranslationRepository ltsTranslationRepository, AnalyticsManager analyticsManager) {
        return new TranslateAndInterpretSignPracticeUseCase(webViewManager, sessionRepository, ltsTranslationRepository, analyticsManager);
    }
}
