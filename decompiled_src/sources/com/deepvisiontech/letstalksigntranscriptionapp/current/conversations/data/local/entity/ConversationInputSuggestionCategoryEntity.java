package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConversationInputSuggestionCategoryEntity.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/entity/ConversationInputSuggestionCategoryEntity;", "", "id", "", "categoryName", "", "<init>", "(JLjava/lang/String;)V", "getId", "()J", "getCategoryName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ConversationInputSuggestionCategoryEntity {
    public static final int $stable = 0;
    private final String categoryName;
    private final long id;

    public static /* synthetic */ ConversationInputSuggestionCategoryEntity copy$default(ConversationInputSuggestionCategoryEntity conversationInputSuggestionCategoryEntity, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = conversationInputSuggestionCategoryEntity.id;
        }
        if ((i & 2) != 0) {
            str = conversationInputSuggestionCategoryEntity.categoryName;
        }
        return conversationInputSuggestionCategoryEntity.copy(j, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCategoryName() {
        return this.categoryName;
    }

    public final ConversationInputSuggestionCategoryEntity copy(long id, String categoryName) {
        Intrinsics.checkNotNullParameter(categoryName, "categoryName");
        return new ConversationInputSuggestionCategoryEntity(id, categoryName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConversationInputSuggestionCategoryEntity)) {
            return false;
        }
        ConversationInputSuggestionCategoryEntity conversationInputSuggestionCategoryEntity = (ConversationInputSuggestionCategoryEntity) other;
        return this.id == conversationInputSuggestionCategoryEntity.id && Intrinsics.areEqual(this.categoryName, conversationInputSuggestionCategoryEntity.categoryName);
    }

    public int hashCode() {
        return (Long.hashCode(this.id) * 31) + this.categoryName.hashCode();
    }

    public String toString() {
        return "ConversationInputSuggestionCategoryEntity(id=" + this.id + ", categoryName=" + this.categoryName + ")";
    }

    public ConversationInputSuggestionCategoryEntity(long j, String str) {
        Intrinsics.checkNotNullParameter(str, "categoryName");
        this.id = j;
        this.categoryName = str;
    }

    public final long getId() {
        return this.id;
    }

    public final String getCategoryName() {
        return this.categoryName;
    }
}
