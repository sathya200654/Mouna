package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecasewrappers;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.GetAllFilteredMessagesOfConversationUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.SetConversationModeUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversation.GetActiveOrNewConversationUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversation.UpdateConversationUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsummary.GenerateAndInsertConversationSummaryUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ConversationManagementUseCases_Factory implements Factory<ConversationManagementUseCases> {
    private final Provider<GetActiveOrNewConversationUseCase> getActiveOrNewConversationProvider;
    private final Provider<GetAllFilteredMessagesOfConversationUseCase> getFilteredMessagesProvider;
    private final Provider<SetConversationModeUseCase> setModeConversationModeProvider;
    private final Provider<GenerateAndInsertConversationSummaryUseCase> summarizeConversationMessagesProvider;
    private final Provider<UpdateConversationUseCase> updateConversationProvider;

    private ConversationManagementUseCases_Factory(Provider<GetAllFilteredMessagesOfConversationUseCase> getFilteredMessagesProvider, Provider<UpdateConversationUseCase> updateConversationProvider, Provider<SetConversationModeUseCase> setModeConversationModeProvider, Provider<GenerateAndInsertConversationSummaryUseCase> summarizeConversationMessagesProvider, Provider<GetActiveOrNewConversationUseCase> getActiveOrNewConversationProvider) {
        this.getFilteredMessagesProvider = getFilteredMessagesProvider;
        this.updateConversationProvider = updateConversationProvider;
        this.setModeConversationModeProvider = setModeConversationModeProvider;
        this.summarizeConversationMessagesProvider = summarizeConversationMessagesProvider;
        this.getActiveOrNewConversationProvider = getActiveOrNewConversationProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ConversationManagementUseCases m1522get() {
        return newInstance((GetAllFilteredMessagesOfConversationUseCase) this.getFilteredMessagesProvider.get(), (UpdateConversationUseCase) this.updateConversationProvider.get(), (SetConversationModeUseCase) this.setModeConversationModeProvider.get(), (GenerateAndInsertConversationSummaryUseCase) this.summarizeConversationMessagesProvider.get(), (GetActiveOrNewConversationUseCase) this.getActiveOrNewConversationProvider.get());
    }

    public static ConversationManagementUseCases_Factory create(Provider<GetAllFilteredMessagesOfConversationUseCase> getFilteredMessagesProvider, Provider<UpdateConversationUseCase> updateConversationProvider, Provider<SetConversationModeUseCase> setModeConversationModeProvider, Provider<GenerateAndInsertConversationSummaryUseCase> summarizeConversationMessagesProvider, Provider<GetActiveOrNewConversationUseCase> getActiveOrNewConversationProvider) {
        return new ConversationManagementUseCases_Factory(getFilteredMessagesProvider, updateConversationProvider, setModeConversationModeProvider, summarizeConversationMessagesProvider, getActiveOrNewConversationProvider);
    }

    public static ConversationManagementUseCases newInstance(GetAllFilteredMessagesOfConversationUseCase getFilteredMessages, UpdateConversationUseCase updateConversation, SetConversationModeUseCase setModeConversationMode, GenerateAndInsertConversationSummaryUseCase summarizeConversationMessages, GetActiveOrNewConversationUseCase getActiveOrNewConversation) {
        return new ConversationManagementUseCases(getFilteredMessages, updateConversation, setModeConversationMode, summarizeConversationMessages, getActiveOrNewConversation);
    }
}
