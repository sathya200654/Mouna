package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.DateFilterRange;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.ListSortOrder;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.Conversation;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConversationListViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\t\u0010\"\u001a\u00020\rHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u000fHÆ\u0003JW\u0010$\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001J\u0013\u0010%\u001a\u00020\u00062\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\tHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006*"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationListScreenUiState;", "", "conversations", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/Conversation;", "isLoading", "", "isSelecting", "searchQuery", "", "sortOrder", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/ListSortOrder;", "dateRange", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/DateFilterRange;", "error", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "<init>", "(Ljava/util/List;ZZLjava/lang/String;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/ListSortOrder;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/DateFilterRange;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;)V", "getConversations", "()Ljava/util/List;", "()Z", "getSearchQuery", "()Ljava/lang/String;", "getSortOrder", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/ListSortOrder;", "getDateRange", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/DateFilterRange;", "getError", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ConversationListScreenUiState {
    public static final int $stable = 8;
    private final List<Conversation> conversations;
    private final DateFilterRange dateRange;
    private final AppError error;
    private final boolean isLoading;
    private final boolean isSelecting;
    private final String searchQuery;
    private final ListSortOrder sortOrder;

    public ConversationListScreenUiState() {
        this(null, false, false, null, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConversationListScreenUiState copy$default(ConversationListScreenUiState conversationListScreenUiState, List list, boolean z, boolean z2, String str, ListSortOrder listSortOrder, DateFilterRange dateFilterRange, AppError appError, int i, Object obj) {
        if ((i & 1) != 0) {
            list = conversationListScreenUiState.conversations;
        }
        if ((i & 2) != 0) {
            z = conversationListScreenUiState.isLoading;
        }
        if ((i & 4) != 0) {
            z2 = conversationListScreenUiState.isSelecting;
        }
        if ((i & 8) != 0) {
            str = conversationListScreenUiState.searchQuery;
        }
        if ((i & 16) != 0) {
            listSortOrder = conversationListScreenUiState.sortOrder;
        }
        if ((i & 32) != 0) {
            dateFilterRange = conversationListScreenUiState.dateRange;
        }
        if ((i & 64) != 0) {
            appError = conversationListScreenUiState.error;
        }
        DateFilterRange dateFilterRange2 = dateFilterRange;
        AppError appError2 = appError;
        ListSortOrder listSortOrder2 = listSortOrder;
        boolean z3 = z2;
        return conversationListScreenUiState.copy(list, z, z3, str, listSortOrder2, dateFilterRange2, appError2);
    }

    public final List<Conversation> component1() {
        return this.conversations;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsLoading() {
        return this.isLoading;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsSelecting() {
        return this.isSelecting;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSearchQuery() {
        return this.searchQuery;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final ListSortOrder getSortOrder() {
        return this.sortOrder;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final DateFilterRange getDateRange() {
        return this.dateRange;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final AppError getError() {
        return this.error;
    }

    public final ConversationListScreenUiState copy(List<Conversation> conversations, boolean isLoading, boolean isSelecting, String searchQuery, ListSortOrder sortOrder, DateFilterRange dateRange, AppError error) {
        Intrinsics.checkNotNullParameter(conversations, "conversations");
        Intrinsics.checkNotNullParameter(searchQuery, "searchQuery");
        Intrinsics.checkNotNullParameter(sortOrder, "sortOrder");
        Intrinsics.checkNotNullParameter(dateRange, "dateRange");
        return new ConversationListScreenUiState(conversations, isLoading, isSelecting, searchQuery, sortOrder, dateRange, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConversationListScreenUiState)) {
            return false;
        }
        ConversationListScreenUiState conversationListScreenUiState = (ConversationListScreenUiState) other;
        return Intrinsics.areEqual(this.conversations, conversationListScreenUiState.conversations) && this.isLoading == conversationListScreenUiState.isLoading && this.isSelecting == conversationListScreenUiState.isSelecting && Intrinsics.areEqual(this.searchQuery, conversationListScreenUiState.searchQuery) && this.sortOrder == conversationListScreenUiState.sortOrder && Intrinsics.areEqual(this.dateRange, conversationListScreenUiState.dateRange) && Intrinsics.areEqual(this.error, conversationListScreenUiState.error);
    }

    public int hashCode() {
        int iHashCode = ((((((((((this.conversations.hashCode() * 31) + Boolean.hashCode(this.isLoading)) * 31) + Boolean.hashCode(this.isSelecting)) * 31) + this.searchQuery.hashCode()) * 31) + this.sortOrder.hashCode()) * 31) + this.dateRange.hashCode()) * 31;
        AppError appError = this.error;
        return iHashCode + (appError == null ? 0 : appError.hashCode());
    }

    public String toString() {
        return "ConversationListScreenUiState(conversations=" + this.conversations + ", isLoading=" + this.isLoading + ", isSelecting=" + this.isSelecting + ", searchQuery=" + this.searchQuery + ", sortOrder=" + this.sortOrder + ", dateRange=" + this.dateRange + ", error=" + this.error + ")";
    }

    public ConversationListScreenUiState(List<Conversation> list, boolean z, boolean z2, String str, ListSortOrder listSortOrder, DateFilterRange dateFilterRange, AppError appError) {
        Intrinsics.checkNotNullParameter(list, "conversations");
        Intrinsics.checkNotNullParameter(str, "searchQuery");
        Intrinsics.checkNotNullParameter(listSortOrder, "sortOrder");
        Intrinsics.checkNotNullParameter(dateFilterRange, "dateRange");
        this.conversations = list;
        this.isLoading = z;
        this.isSelecting = z2;
        this.searchQuery = str;
        this.sortOrder = listSortOrder;
        this.dateRange = dateFilterRange;
        this.error = appError;
    }

    public /* synthetic */ ConversationListScreenUiState(List list, boolean z, boolean z2, String str, ListSortOrder listSortOrder, DateFilterRange dateFilterRange, AppError appError, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? true : z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? "" : str, (i & 16) != 0 ? ListSortOrder.BY_TIME_DESC : listSortOrder, (i & 32) != 0 ? new DateFilterRange(null, null, 3, null) : dateFilterRange, (i & 64) != 0 ? null : appError);
    }

    public final List<Conversation> getConversations() {
        return this.conversations;
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public final boolean isSelecting() {
        return this.isSelecting;
    }

    public final String getSearchQuery() {
        return this.searchQuery;
    }

    public final ListSortOrder getSortOrder() {
        return this.sortOrder;
    }

    public final DateFilterRange getDateRange() {
        return this.dateRange;
    }

    public final AppError getError() {
        return this.error;
    }
}
