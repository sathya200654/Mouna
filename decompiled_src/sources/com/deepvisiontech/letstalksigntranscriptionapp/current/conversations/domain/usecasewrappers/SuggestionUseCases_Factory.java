package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecasewrappers;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsuggestion.DeleteConversationInputSuggestionCategoryUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsuggestion.DeleteConversationInputSuggestionUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsuggestion.FetchConversationInputSuggestionsFromNetwork;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsuggestion.FetchCorrectionSuggestionUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsuggestion.GetAllConversationInputSuggestionUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsuggestion.InsertConversationInputSuggestionUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class SuggestionUseCases_Factory implements Factory<SuggestionUseCases> {
    private final Provider<DeleteConversationInputSuggestionCategoryUseCase> deleteCategoryProvider;
    private final Provider<DeleteConversationInputSuggestionUseCase> deleteSuggestionProvider;
    private final Provider<FetchConversationInputSuggestionsFromNetwork> fetchFromNetworkProvider;
    private final Provider<FetchCorrectionSuggestionUseCase> fetchProvider;
    private final Provider<GetAllConversationInputSuggestionUseCase> getAllProvider;
    private final Provider<InsertConversationInputSuggestionUseCase> insertProvider;

    private SuggestionUseCases_Factory(Provider<FetchCorrectionSuggestionUseCase> fetchProvider, Provider<InsertConversationInputSuggestionUseCase> insertProvider, Provider<FetchConversationInputSuggestionsFromNetwork> fetchFromNetworkProvider, Provider<GetAllConversationInputSuggestionUseCase> getAllProvider, Provider<DeleteConversationInputSuggestionUseCase> deleteSuggestionProvider, Provider<DeleteConversationInputSuggestionCategoryUseCase> deleteCategoryProvider) {
        this.fetchProvider = fetchProvider;
        this.insertProvider = insertProvider;
        this.fetchFromNetworkProvider = fetchFromNetworkProvider;
        this.getAllProvider = getAllProvider;
        this.deleteSuggestionProvider = deleteSuggestionProvider;
        this.deleteCategoryProvider = deleteCategoryProvider;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public SuggestionUseCases m1525get() {
        return newInstance((FetchCorrectionSuggestionUseCase) this.fetchProvider.get(), (InsertConversationInputSuggestionUseCase) this.insertProvider.get(), (FetchConversationInputSuggestionsFromNetwork) this.fetchFromNetworkProvider.get(), (GetAllConversationInputSuggestionUseCase) this.getAllProvider.get(), (DeleteConversationInputSuggestionUseCase) this.deleteSuggestionProvider.get(), (DeleteConversationInputSuggestionCategoryUseCase) this.deleteCategoryProvider.get());
    }

    public static SuggestionUseCases_Factory create(Provider<FetchCorrectionSuggestionUseCase> fetchProvider, Provider<InsertConversationInputSuggestionUseCase> insertProvider, Provider<FetchConversationInputSuggestionsFromNetwork> fetchFromNetworkProvider, Provider<GetAllConversationInputSuggestionUseCase> getAllProvider, Provider<DeleteConversationInputSuggestionUseCase> deleteSuggestionProvider, Provider<DeleteConversationInputSuggestionCategoryUseCase> deleteCategoryProvider) {
        return new SuggestionUseCases_Factory(fetchProvider, insertProvider, fetchFromNetworkProvider, getAllProvider, deleteSuggestionProvider, deleteCategoryProvider);
    }

    public static SuggestionUseCases newInstance(FetchCorrectionSuggestionUseCase fetch, InsertConversationInputSuggestionUseCase insert, FetchConversationInputSuggestionsFromNetwork fetchFromNetwork, GetAllConversationInputSuggestionUseCase getAll, DeleteConversationInputSuggestionUseCase deleteSuggestion, DeleteConversationInputSuggestionCategoryUseCase deleteCategory) {
        return new SuggestionUseCases(fetch, insert, fetchFromNetwork, getAll, deleteSuggestion, deleteCategory);
    }
}
