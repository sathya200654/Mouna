package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.DeleteConversationsUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.GetAllFilteredConversationsUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.InsertAndSetActiveConversationUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.SetActiveConversationUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class ConversationListViewModel_Factory implements Factory<ConversationListViewModel> {
    private final Provider<DeleteConversationsUseCase> deleteConversationsUseCaseProvider;
    private final Provider<GetAllFilteredConversationsUseCase> getAllFilteredConversationsUseCaseProvider;
    private final Provider<InsertAndSetActiveConversationUseCase> insertAndSetActiveConversationUseCaseProvider;
    private final Provider<SetActiveConversationUseCase> setActiveConversationUseCaseProvider;

    private ConversationListViewModel_Factory(Provider<GetAllFilteredConversationsUseCase> getAllFilteredConversationsUseCaseProvider, Provider<SetActiveConversationUseCase> setActiveConversationUseCaseProvider, Provider<DeleteConversationsUseCase> deleteConversationsUseCaseProvider, Provider<InsertAndSetActiveConversationUseCase> insertAndSetActiveConversationUseCaseProvider) {
        this.getAllFilteredConversationsUseCaseProvider = getAllFilteredConversationsUseCaseProvider;
        this.setActiveConversationUseCaseProvider = setActiveConversationUseCaseProvider;
        this.deleteConversationsUseCaseProvider = deleteConversationsUseCaseProvider;
        this.insertAndSetActiveConversationUseCaseProvider = insertAndSetActiveConversationUseCaseProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public ConversationListViewModel m1657get() {
        return newInstance((GetAllFilteredConversationsUseCase) this.getAllFilteredConversationsUseCaseProvider.get(), (SetActiveConversationUseCase) this.setActiveConversationUseCaseProvider.get(), (DeleteConversationsUseCase) this.deleteConversationsUseCaseProvider.get(), (InsertAndSetActiveConversationUseCase) this.insertAndSetActiveConversationUseCaseProvider.get());
    }

    public static ConversationListViewModel_Factory create(Provider<GetAllFilteredConversationsUseCase> getAllFilteredConversationsUseCaseProvider, Provider<SetActiveConversationUseCase> setActiveConversationUseCaseProvider, Provider<DeleteConversationsUseCase> deleteConversationsUseCaseProvider, Provider<InsertAndSetActiveConversationUseCase> insertAndSetActiveConversationUseCaseProvider) {
        return new ConversationListViewModel_Factory(getAllFilteredConversationsUseCaseProvider, setActiveConversationUseCaseProvider, deleteConversationsUseCaseProvider, insertAndSetActiveConversationUseCaseProvider);
    }

    public static ConversationListViewModel newInstance(GetAllFilteredConversationsUseCase getAllFilteredConversationsUseCase, SetActiveConversationUseCase setActiveConversationUseCase, DeleteConversationsUseCase deleteConversationsUseCase, InsertAndSetActiveConversationUseCase insertAndSetActiveConversationUseCase) {
        return new ConversationListViewModel(getAllFilteredConversationsUseCase, setActiveConversationUseCase, deleteConversationsUseCase, insertAndSetActiveConversationUseCase);
    }
}
