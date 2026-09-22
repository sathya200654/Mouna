package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.dao;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.entity.ConversationInputSuggestionSentenceEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConversationInputSuggestionDao.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/dao/SuggestionWithCategoryTuple;", "", "suggestion", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/entity/ConversationInputSuggestionSentenceEntity;", "categoryName", "", "categoryId", "", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/entity/ConversationInputSuggestionSentenceEntity;Ljava/lang/String;J)V", "getSuggestion", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/entity/ConversationInputSuggestionSentenceEntity;", "getCategoryName", "()Ljava/lang/String;", "getCategoryId", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SuggestionWithCategoryTuple {
    public static final int $stable = 0;
    private final long categoryId;
    private final String categoryName;
    private final ConversationInputSuggestionSentenceEntity suggestion;

    public static /* synthetic */ SuggestionWithCategoryTuple copy$default(SuggestionWithCategoryTuple suggestionWithCategoryTuple, ConversationInputSuggestionSentenceEntity conversationInputSuggestionSentenceEntity, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            conversationInputSuggestionSentenceEntity = suggestionWithCategoryTuple.suggestion;
        }
        if ((i & 2) != 0) {
            str = suggestionWithCategoryTuple.categoryName;
        }
        if ((i & 4) != 0) {
            j = suggestionWithCategoryTuple.categoryId;
        }
        return suggestionWithCategoryTuple.copy(conversationInputSuggestionSentenceEntity, str, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ConversationInputSuggestionSentenceEntity getSuggestion() {
        return this.suggestion;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCategoryName() {
        return this.categoryName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getCategoryId() {
        return this.categoryId;
    }

    public final SuggestionWithCategoryTuple copy(ConversationInputSuggestionSentenceEntity suggestion, String categoryName, long categoryId) {
        Intrinsics.checkNotNullParameter(suggestion, "suggestion");
        Intrinsics.checkNotNullParameter(categoryName, "categoryName");
        return new SuggestionWithCategoryTuple(suggestion, categoryName, categoryId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SuggestionWithCategoryTuple)) {
            return false;
        }
        SuggestionWithCategoryTuple suggestionWithCategoryTuple = (SuggestionWithCategoryTuple) other;
        return Intrinsics.areEqual(this.suggestion, suggestionWithCategoryTuple.suggestion) && Intrinsics.areEqual(this.categoryName, suggestionWithCategoryTuple.categoryName) && this.categoryId == suggestionWithCategoryTuple.categoryId;
    }

    public int hashCode() {
        return (((this.suggestion.hashCode() * 31) + this.categoryName.hashCode()) * 31) + Long.hashCode(this.categoryId);
    }

    public String toString() {
        return "SuggestionWithCategoryTuple(suggestion=" + this.suggestion + ", categoryName=" + this.categoryName + ", categoryId=" + this.categoryId + ")";
    }

    public SuggestionWithCategoryTuple(ConversationInputSuggestionSentenceEntity conversationInputSuggestionSentenceEntity, String str, long j) {
        Intrinsics.checkNotNullParameter(conversationInputSuggestionSentenceEntity, "suggestion");
        Intrinsics.checkNotNullParameter(str, "categoryName");
        this.suggestion = conversationInputSuggestionSentenceEntity;
        this.categoryName = str;
        this.categoryId = j;
    }

    public final ConversationInputSuggestionSentenceEntity getSuggestion() {
        return this.suggestion;
    }

    public final String getCategoryName() {
        return this.categoryName;
    }

    public final long getCategoryId() {
        return this.categoryId;
    }
}
