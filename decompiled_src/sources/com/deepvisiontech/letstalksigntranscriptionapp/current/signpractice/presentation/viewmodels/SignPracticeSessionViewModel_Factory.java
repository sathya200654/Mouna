package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels;

import androidx.lifecycle.SavedStateHandle;
import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.media.MediaPlayerManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.WebViewManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase.GetSignPracticeFlowUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase.TranslateAndInterpretSignPracticeUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SignPracticeSessionViewModel_Factory implements Factory<SignPracticeSessionViewModel> {
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<GetSignPracticeFlowUseCase> getSignPracticeFlowUseCaseProvider;
    private final Provider<MediaPlayerManager> mediaPlayerManagerProvider;
    private final Provider<SavedStateHandle> savedStateHandleProvider;
    private final Provider<TranslateAndInterpretSignPracticeUseCase> translateAndInterpretSignPracticeUseCaseProvider;
    private final Provider<WebViewManager> webViewManagerProvider;

    private SignPracticeSessionViewModel_Factory(Provider<GetSignPracticeFlowUseCase> getSignPracticeFlowUseCaseProvider, Provider<MediaPlayerManager> mediaPlayerManagerProvider, Provider<WebViewManager> webViewManagerProvider, Provider<AnalyticsManager> analyticsManagerProvider, Provider<TranslateAndInterpretSignPracticeUseCase> translateAndInterpretSignPracticeUseCaseProvider, Provider<SavedStateHandle> savedStateHandleProvider) {
        this.getSignPracticeFlowUseCaseProvider = getSignPracticeFlowUseCaseProvider;
        this.mediaPlayerManagerProvider = mediaPlayerManagerProvider;
        this.webViewManagerProvider = webViewManagerProvider;
        this.analyticsManagerProvider = analyticsManagerProvider;
        this.translateAndInterpretSignPracticeUseCaseProvider = translateAndInterpretSignPracticeUseCaseProvider;
        this.savedStateHandleProvider = savedStateHandleProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SignPracticeSessionViewModel m1858get() {
        return newInstance((GetSignPracticeFlowUseCase) this.getSignPracticeFlowUseCaseProvider.get(), (MediaPlayerManager) this.mediaPlayerManagerProvider.get(), (WebViewManager) this.webViewManagerProvider.get(), (AnalyticsManager) this.analyticsManagerProvider.get(), (TranslateAndInterpretSignPracticeUseCase) this.translateAndInterpretSignPracticeUseCaseProvider.get(), (SavedStateHandle) this.savedStateHandleProvider.get());
    }

    public static SignPracticeSessionViewModel_Factory create(Provider<GetSignPracticeFlowUseCase> getSignPracticeFlowUseCaseProvider, Provider<MediaPlayerManager> mediaPlayerManagerProvider, Provider<WebViewManager> webViewManagerProvider, Provider<AnalyticsManager> analyticsManagerProvider, Provider<TranslateAndInterpretSignPracticeUseCase> translateAndInterpretSignPracticeUseCaseProvider, Provider<SavedStateHandle> savedStateHandleProvider) {
        return new SignPracticeSessionViewModel_Factory(getSignPracticeFlowUseCaseProvider, mediaPlayerManagerProvider, webViewManagerProvider, analyticsManagerProvider, translateAndInterpretSignPracticeUseCaseProvider, savedStateHandleProvider);
    }

    public static SignPracticeSessionViewModel newInstance(GetSignPracticeFlowUseCase getSignPracticeFlowUseCase, MediaPlayerManager mediaPlayerManager, WebViewManager webViewManager, AnalyticsManager analyticsManager, TranslateAndInterpretSignPracticeUseCase translateAndInterpretSignPracticeUseCase, SavedStateHandle savedStateHandle) {
        return new SignPracticeSessionViewModel(getSignPracticeFlowUseCase, mediaPlayerManager, webViewManager, analyticsManager, translateAndInterpretSignPracticeUseCase, savedStateHandle);
    }
}
