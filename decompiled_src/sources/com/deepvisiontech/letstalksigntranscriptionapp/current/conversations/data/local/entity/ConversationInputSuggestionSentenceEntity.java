package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.entity;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConversationInputSuggestionSentenceEntity.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/entity/ConversationInputSuggestionSentenceEntity;", "", "id", "", "text", "", "categoryId", "suggestionLanguage", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "<init>", "(JLjava/lang/String;JLcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;)V", "getId", "()J", "getText", "()Ljava/lang/String;", "getCategoryId", "getSuggestionLanguage", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ConversationInputSuggestionSentenceEntity {
    public static final int $stable = 0;
    private final long categoryId;
    private final long id;
    private final LanguageEnum suggestionLanguage;
    private final String text;

    public static /* synthetic */ ConversationInputSuggestionSentenceEntity copy$default(ConversationInputSuggestionSentenceEntity conversationInputSuggestionSentenceEntity, long j, String str, long j2, LanguageEnum languageEnum, int i, Object obj) {
        if ((i & 1) != 0) {
            j = conversationInputSuggestionSentenceEntity.id;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            str = conversationInputSuggestionSentenceEntity.text;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            j2 = conversationInputSuggestionSentenceEntity.categoryId;
        }
        long j4 = j2;
        if ((i & 8) != 0) {
            languageEnum = conversationInputSuggestionSentenceEntity.suggestionLanguage;
        }
        return conversationInputSuggestionSentenceEntity.copy(j3, str2, j4, languageEnum);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getCategoryId() {
        return this.categoryId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final LanguageEnum getSuggestionLanguage() {
        return this.suggestionLanguage;
    }

    public final ConversationInputSuggestionSentenceEntity copy(long id, String text, long categoryId, LanguageEnum suggestionLanguage) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(suggestionLanguage, "suggestionLanguage");
        return new ConversationInputSuggestionSentenceEntity(id, text, categoryId, suggestionLanguage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConversationInputSuggestionSentenceEntity)) {
            return false;
        }
        ConversationInputSuggestionSentenceEntity conversationInputSuggestionSentenceEntity = (ConversationInputSuggestionSentenceEntity) other;
        return this.id == conversationInputSuggestionSentenceEntity.id && Intrinsics.areEqual(this.text, conversationInputSuggestionSentenceEntity.text) && this.categoryId == conversationInputSuggestionSentenceEntity.categoryId && this.suggestionLanguage == conversationInputSuggestionSentenceEntity.suggestionLanguage;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.id) * 31) + this.text.hashCode()) * 31) + Long.hashCode(this.categoryId)) * 31) + this.suggestionLanguage.hashCode();
    }

    public String toString() {
        return "ConversationInputSuggestionSentenceEntity(id=" + this.id + ", text=" + this.text + ", categoryId=" + this.categoryId + ", suggestionLanguage=" + this.suggestionLanguage + ")";
    }

    public ConversationInputSuggestionSentenceEntity(long j, String str, long j2, LanguageEnum languageEnum) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(languageEnum, "suggestionLanguage");
        this.id = j;
        this.text = str;
        this.categoryId = j2;
        this.suggestionLanguage = languageEnum;
    }

    public /* synthetic */ ConversationInputSuggestionSentenceEntity(long j, String str, long j2, LanguageEnum languageEnum, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, str, j2, languageEnum);
    }

    public final long getId() {
        return this.id;
    }

    public final String getText() {
        return this.text;
    }

    public final long getCategoryId() {
        return this.categoryId;
    }

    public final LanguageEnum getSuggestionLanguage() {
        return this.suggestionLanguage;
    }
}
