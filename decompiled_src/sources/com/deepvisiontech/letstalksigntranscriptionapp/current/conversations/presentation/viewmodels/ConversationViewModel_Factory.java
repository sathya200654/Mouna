package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationSpeechRecognizerService;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSettingsRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationusage.CheckAndResetDailyLimitsUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationusage.SyncConversationUsageLimitsUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecasewrappers.ConversationManagementUseCases;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecasewrappers.ConversationSettingsUseCases;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecasewrappers.InterpretationUseCases;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecasewrappers.SuggestionUseCases;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecasewrappers.TextToSpeechUseCases;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.shareintent.domain.ShareIntentManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.texttospeech.TextToSpeechManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.WebViewManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ConversationViewModel_Factory implements Factory<ConversationViewModel> {
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<CheckAndResetDailyLimitsUseCase> checkAndResetDailyLimitsUseCaseProvider;
    private final Provider<ConversationManagementUseCases> conversationManagementUseCasesProvider;
    private final Provider<ConversationSettingsRepository> conversationSettingsRepositoryProvider;
    private final Provider<ConversationSettingsUseCases> conversationSettingsUseCasesProvider;
    private final Provider<ConversationSpeechRecognizerService> conversationSpeechRecognizerServiceProvider;
    private final Provider<InterpretationUseCases> interpretationUseCasesProvider;
    private final Provider<ShareIntentManager> shareIntentManagerProvider;
    private final Provider<SuggestionUseCases> suggestionUseCasesProvider;
    private final Provider<SyncConversationUsageLimitsUseCase> syncConversationUsageLimitsUseCaseProvider;
    private final Provider<TextToSpeechManager> textToSpeechManagerProvider;
    private final Provider<TextToSpeechUseCases> textToSpeechUseCasesProvider;
    private final Provider<WebViewManager> webViewManagerProvider;

    private ConversationViewModel_Factory(Provider<ConversationSpeechRecognizerService> conversationSpeechRecognizerServiceProvider, Provider<WebViewManager> webViewManagerProvider, Provider<TextToSpeechManager> textToSpeechManagerProvider, Provider<ShareIntentManager> shareIntentManagerProvider, Provider<ConversationSettingsRepository> conversationSettingsRepositoryProvider, Provider<SuggestionUseCases> suggestionUseCasesProvider, Provider<InterpretationUseCases> interpretationUseCasesProvider, Provider<ConversationManagementUseCases> conversationManagementUseCasesProvider, Provider<SyncConversationUsageLimitsUseCase> syncConversationUsageLimitsUseCaseProvider, Provider<CheckAndResetDailyLimitsUseCase> checkAndResetDailyLimitsUseCaseProvider, Provider<ConversationSettingsUseCases> conversationSettingsUseCasesProvider, Provider<AnalyticsManager> analyticsManagerProvider, Provider<TextToSpeechUseCases> textToSpeechUseCasesProvider) {
        this.conversationSpeechRecognizerServiceProvider = conversationSpeechRecognizerServiceProvider;
        this.webViewManagerProvider = webViewManagerProvider;
        this.textToSpeechManagerProvider = textToSpeechManagerProvider;
        this.shareIntentManagerProvider = shareIntentManagerProvider;
        this.conversationSettingsRepositoryProvider = conversationSettingsRepositoryProvider;
        this.suggestionUseCasesProvider = suggestionUseCasesProvider;
        this.interpretationUseCasesProvider = interpretationUseCasesProvider;
        this.conversationManagementUseCasesProvider = conversationManagementUseCasesProvider;
        this.syncConversationUsageLimitsUseCaseProvider = syncConversationUsageLimitsUseCaseProvider;
        this.checkAndResetDailyLimitsUseCaseProvider = checkAndResetDailyLimitsUseCaseProvider;
        this.conversationSettingsUseCasesProvider = conversationSettingsUseCasesProvider;
        this.analyticsManagerProvider = analyticsManagerProvider;
        this.textToSpeechUseCasesProvider = textToSpeechUseCasesProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ConversationViewModel m1661get() {
        return newInstance((ConversationSpeechRecognizerService) this.conversationSpeechRecognizerServiceProvider.get(), (WebViewManager) this.webViewManagerProvider.get(), (TextToSpeechManager) this.textToSpeechManagerProvider.get(), (ShareIntentManager) this.shareIntentManagerProvider.get(), (ConversationSettingsRepository) this.conversationSettingsRepositoryProvider.get(), (SuggestionUseCases) this.suggestionUseCasesProvider.get(), (InterpretationUseCases) this.interpretationUseCasesProvider.get(), (ConversationManagementUseCases) this.conversationManagementUseCasesProvider.get(), (SyncConversationUsageLimitsUseCase) this.syncConversationUsageLimitsUseCaseProvider.get(), (CheckAndResetDailyLimitsUseCase) this.checkAndResetDailyLimitsUseCaseProvider.get(), (ConversationSettingsUseCases) this.conversationSettingsUseCasesProvider.get(), (AnalyticsManager) this.analyticsManagerProvider.get(), (TextToSpeechUseCases) this.textToSpeechUseCasesProvider.get());
    }

    public static ConversationViewModel_Factory create(Provider<ConversationSpeechRecognizerService> conversationSpeechRecognizerServiceProvider, Provider<WebViewManager> webViewManagerProvider, Provider<TextToSpeechManager> textToSpeechManagerProvider, Provider<ShareIntentManager> shareIntentManagerProvider, Provider<ConversationSettingsRepository> conversationSettingsRepositoryProvider, Provider<SuggestionUseCases> suggestionUseCasesProvider, Provider<InterpretationUseCases> interpretationUseCasesProvider, Provider<ConversationManagementUseCases> conversationManagementUseCasesProvider, Provider<SyncConversationUsageLimitsUseCase> syncConversationUsageLimitsUseCaseProvider, Provider<CheckAndResetDailyLimitsUseCase> checkAndResetDailyLimitsUseCaseProvider, Provider<ConversationSettingsUseCases> conversationSettingsUseCasesProvider, Provider<AnalyticsManager> analyticsManagerProvider, Provider<TextToSpeechUseCases> textToSpeechUseCasesProvider) {
        return new ConversationViewModel_Factory(conversationSpeechRecognizerServiceProvider, webViewManagerProvider, textToSpeechManagerProvider, shareIntentManagerProvider, conversationSettingsRepositoryProvider, suggestionUseCasesProvider, interpretationUseCasesProvider, conversationManagementUseCasesProvider, syncConversationUsageLimitsUseCaseProvider, checkAndResetDailyLimitsUseCaseProvider, conversationSettingsUseCasesProvider, analyticsManagerProvider, textToSpeechUseCasesProvider);
    }

    public static ConversationViewModel newInstance(ConversationSpeechRecognizerService conversationSpeechRecognizerService, WebViewManager webViewManager, TextToSpeechManager textToSpeechManager, ShareIntentManager shareIntentManager, ConversationSettingsRepository conversationSettingsRepository, SuggestionUseCases suggestionUseCases, InterpretationUseCases interpretationUseCases, ConversationManagementUseCases conversationManagementUseCases, SyncConversationUsageLimitsUseCase syncConversationUsageLimitsUseCase, CheckAndResetDailyLimitsUseCase checkAndResetDailyLimitsUseCase, ConversationSettingsUseCases conversationSettingsUseCases, AnalyticsManager analyticsManager, TextToSpeechUseCases textToSpeechUseCases) {
        return new ConversationViewModel(conversationSpeechRecognizerService, webViewManager, textToSpeechManager, shareIntentManager, conversationSettingsRepository, suggestionUseCases, interpretationUseCases, conversationManagementUseCases, syncConversationUsageLimitsUseCase, checkAndResetDailyLimitsUseCase, conversationSettingsUseCases, analyticsManager, textToSpeechUseCases);
    }
}
