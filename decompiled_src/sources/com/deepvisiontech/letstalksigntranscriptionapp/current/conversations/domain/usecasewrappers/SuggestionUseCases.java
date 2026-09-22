package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecasewrappers;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsuggestion.DeleteConversationInputSuggestionCategoryUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsuggestion.DeleteConversationInputSuggestionUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsuggestion.FetchConversationInputSuggestionsFromNetwork;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsuggestion.FetchCorrectionSuggestionUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsuggestion.GetAllConversationInputSuggestionUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsuggestion.InsertConversationInputSuggestionUseCase;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SuggestionUseCases.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Singleton
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\t\u0010!\u001a\u00020\rHÆ\u0003JE\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006*"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecasewrappers/SuggestionUseCases;", "", RemoteConfigComponent.FETCH_FILE_NAME, "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsuggestion/FetchCorrectionSuggestionUseCase;", "insert", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsuggestion/InsertConversationInputSuggestionUseCase;", "fetchFromNetwork", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsuggestion/FetchConversationInputSuggestionsFromNetwork;", "getAll", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsuggestion/GetAllConversationInputSuggestionUseCase;", "deleteSuggestion", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsuggestion/DeleteConversationInputSuggestionUseCase;", "deleteCategory", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsuggestion/DeleteConversationInputSuggestionCategoryUseCase;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsuggestion/FetchCorrectionSuggestionUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsuggestion/InsertConversationInputSuggestionUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsuggestion/FetchConversationInputSuggestionsFromNetwork;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsuggestion/GetAllConversationInputSuggestionUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsuggestion/DeleteConversationInputSuggestionUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsuggestion/DeleteConversationInputSuggestionCategoryUseCase;)V", "getFetch", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsuggestion/FetchCorrectionSuggestionUseCase;", "getInsert", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsuggestion/InsertConversationInputSuggestionUseCase;", "getFetchFromNetwork", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsuggestion/FetchConversationInputSuggestionsFromNetwork;", "getGetAll", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsuggestion/GetAllConversationInputSuggestionUseCase;", "getDeleteSuggestion", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsuggestion/DeleteConversationInputSuggestionUseCase;", "getDeleteCategory", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsuggestion/DeleteConversationInputSuggestionCategoryUseCase;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SuggestionUseCases {
    public static final int $stable = 8;
    private final DeleteConversationInputSuggestionCategoryUseCase deleteCategory;
    private final DeleteConversationInputSuggestionUseCase deleteSuggestion;
    private final FetchCorrectionSuggestionUseCase fetch;
    private final FetchConversationInputSuggestionsFromNetwork fetchFromNetwork;
    private final GetAllConversationInputSuggestionUseCase getAll;
    private final InsertConversationInputSuggestionUseCase insert;

    public static /* synthetic */ SuggestionUseCases copy$default(SuggestionUseCases suggestionUseCases, FetchCorrectionSuggestionUseCase fetchCorrectionSuggestionUseCase, InsertConversationInputSuggestionUseCase insertConversationInputSuggestionUseCase, FetchConversationInputSuggestionsFromNetwork fetchConversationInputSuggestionsFromNetwork, GetAllConversationInputSuggestionUseCase getAllConversationInputSuggestionUseCase, DeleteConversationInputSuggestionUseCase deleteConversationInputSuggestionUseCase, DeleteConversationInputSuggestionCategoryUseCase deleteConversationInputSuggestionCategoryUseCase, int i, Object obj) {
        if ((i & 1) != 0) {
            fetchCorrectionSuggestionUseCase = suggestionUseCases.fetch;
        }
        if ((i & 2) != 0) {
            insertConversationInputSuggestionUseCase = suggestionUseCases.insert;
        }
        if ((i & 4) != 0) {
            fetchConversationInputSuggestionsFromNetwork = suggestionUseCases.fetchFromNetwork;
        }
        if ((i & 8) != 0) {
            getAllConversationInputSuggestionUseCase = suggestionUseCases.getAll;
        }
        if ((i & 16) != 0) {
            deleteConversationInputSuggestionUseCase = suggestionUseCases.deleteSuggestion;
        }
        if ((i & 32) != 0) {
            deleteConversationInputSuggestionCategoryUseCase = suggestionUseCases.deleteCategory;
        }
        DeleteConversationInputSuggestionUseCase deleteConversationInputSuggestionUseCase2 = deleteConversationInputSuggestionUseCase;
        DeleteConversationInputSuggestionCategoryUseCase deleteConversationInputSuggestionCategoryUseCase2 = deleteConversationInputSuggestionCategoryUseCase;
        return suggestionUseCases.copy(fetchCorrectionSuggestionUseCase, insertConversationInputSuggestionUseCase, fetchConversationInputSuggestionsFromNetwork, getAllConversationInputSuggestionUseCase, deleteConversationInputSuggestionUseCase2, deleteConversationInputSuggestionCategoryUseCase2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final FetchCorrectionSuggestionUseCase getFetch() {
        return this.fetch;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final InsertConversationInputSuggestionUseCase getInsert() {
        return this.insert;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final FetchConversationInputSuggestionsFromNetwork getFetchFromNetwork() {
        return this.fetchFromNetwork;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final GetAllConversationInputSuggestionUseCase getGetAll() {
        return this.getAll;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final DeleteConversationInputSuggestionUseCase getDeleteSuggestion() {
        return this.deleteSuggestion;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final DeleteConversationInputSuggestionCategoryUseCase getDeleteCategory() {
        return this.deleteCategory;
    }

    public final SuggestionUseCases copy(FetchCorrectionSuggestionUseCase fetch, InsertConversationInputSuggestionUseCase insert, FetchConversationInputSuggestionsFromNetwork fetchFromNetwork, GetAllConversationInputSuggestionUseCase getAll, DeleteConversationInputSuggestionUseCase deleteSuggestion, DeleteConversationInputSuggestionCategoryUseCase deleteCategory) {
        Intrinsics.checkNotNullParameter(fetch, RemoteConfigComponent.FETCH_FILE_NAME);
        Intrinsics.checkNotNullParameter(insert, "insert");
        Intrinsics.checkNotNullParameter(fetchFromNetwork, "fetchFromNetwork");
        Intrinsics.checkNotNullParameter(getAll, "getAll");
        Intrinsics.checkNotNullParameter(deleteSuggestion, "deleteSuggestion");
        Intrinsics.checkNotNullParameter(deleteCategory, "deleteCategory");
        return new SuggestionUseCases(fetch, insert, fetchFromNetwork, getAll, deleteSuggestion, deleteCategory);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SuggestionUseCases)) {
            return false;
        }
        SuggestionUseCases suggestionUseCases = (SuggestionUseCases) other;
        return Intrinsics.areEqual(this.fetch, suggestionUseCases.fetch) && Intrinsics.areEqual(this.insert, suggestionUseCases.insert) && Intrinsics.areEqual(this.fetchFromNetwork, suggestionUseCases.fetchFromNetwork) && Intrinsics.areEqual(this.getAll, suggestionUseCases.getAll) && Intrinsics.areEqual(this.deleteSuggestion, suggestionUseCases.deleteSuggestion) && Intrinsics.areEqual(this.deleteCategory, suggestionUseCases.deleteCategory);
    }

    public int hashCode() {
        return (((((((((this.fetch.hashCode() * 31) + this.insert.hashCode()) * 31) + this.fetchFromNetwork.hashCode()) * 31) + this.getAll.hashCode()) * 31) + this.deleteSuggestion.hashCode()) * 31) + this.deleteCategory.hashCode();
    }

    public String toString() {
        return "SuggestionUseCases(fetch=" + this.fetch + ", insert=" + this.insert + ", fetchFromNetwork=" + this.fetchFromNetwork + ", getAll=" + this.getAll + ", deleteSuggestion=" + this.deleteSuggestion + ", deleteCategory=" + this.deleteCategory + ")";
    }

    @Inject
    public SuggestionUseCases(FetchCorrectionSuggestionUseCase fetchCorrectionSuggestionUseCase, InsertConversationInputSuggestionUseCase insertConversationInputSuggestionUseCase, FetchConversationInputSuggestionsFromNetwork fetchConversationInputSuggestionsFromNetwork, GetAllConversationInputSuggestionUseCase getAllConversationInputSuggestionUseCase, DeleteConversationInputSuggestionUseCase deleteConversationInputSuggestionUseCase, DeleteConversationInputSuggestionCategoryUseCase deleteConversationInputSuggestionCategoryUseCase) {
        Intrinsics.checkNotNullParameter(fetchCorrectionSuggestionUseCase, RemoteConfigComponent.FETCH_FILE_NAME);
        Intrinsics.checkNotNullParameter(insertConversationInputSuggestionUseCase, "insert");
        Intrinsics.checkNotNullParameter(fetchConversationInputSuggestionsFromNetwork, "fetchFromNetwork");
        Intrinsics.checkNotNullParameter(getAllConversationInputSuggestionUseCase, "getAll");
        Intrinsics.checkNotNullParameter(deleteConversationInputSuggestionUseCase, "deleteSuggestion");
        Intrinsics.checkNotNullParameter(deleteConversationInputSuggestionCategoryUseCase, "deleteCategory");
        this.fetch = fetchCorrectionSuggestionUseCase;
        this.insert = insertConversationInputSuggestionUseCase;
        this.fetchFromNetwork = fetchConversationInputSuggestionsFromNetwork;
        this.getAll = getAllConversationInputSuggestionUseCase;
        this.deleteSuggestion = deleteConversationInputSuggestionUseCase;
        this.deleteCategory = deleteConversationInputSuggestionCategoryUseCase;
    }

    public final FetchCorrectionSuggestionUseCase getFetch() {
        return this.fetch;
    }

    public final InsertConversationInputSuggestionUseCase getInsert() {
        return this.insert;
    }

    public final FetchConversationInputSuggestionsFromNetwork getFetchFromNetwork() {
        return this.fetchFromNetwork;
    }

    public final GetAllConversationInputSuggestionUseCase getGetAll() {
        return this.getAll;
    }

    public final DeleteConversationInputSuggestionUseCase getDeleteSuggestion() {
        return this.deleteSuggestion;
    }

    public final DeleteConversationInputSuggestionCategoryUseCase getDeleteCategory() {
        return this.deleteCategory;
    }
}
