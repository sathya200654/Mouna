package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.conversationsuggestion;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConversationSuggestion.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/ConversationSuggestion;", "", "id", "", "text", "", "language", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "category", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/SuggestionCategory;", "<init>", "(JLjava/lang/String;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/SuggestionCategory;)V", "getId", "()J", "getText", "()Ljava/lang/String;", "getLanguage", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "getCategory", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/SuggestionCategory;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ConversationSuggestion {
    public static final int $stable = 0;
    private final SuggestionCategory category;
    private final long id;
    private final LanguageEnum language;
    private final String text;

    public static /* synthetic */ ConversationSuggestion copy$default(ConversationSuggestion conversationSuggestion, long j, String str, LanguageEnum languageEnum, SuggestionCategory suggestionCategory, int i, Object obj) {
        if ((i & 1) != 0) {
            j = conversationSuggestion.id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = conversationSuggestion.text;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            languageEnum = conversationSuggestion.language;
        }
        LanguageEnum languageEnum2 = languageEnum;
        if ((i & 8) != 0) {
            suggestionCategory = conversationSuggestion.category;
        }
        return conversationSuggestion.copy(j2, str2, languageEnum2, suggestionCategory);
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
    public final LanguageEnum getLanguage() {
        return this.language;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final SuggestionCategory getCategory() {
        return this.category;
    }

    public final ConversationSuggestion copy(long id, String text, LanguageEnum language, SuggestionCategory category) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(category, "category");
        return new ConversationSuggestion(id, text, language, category);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConversationSuggestion)) {
            return false;
        }
        ConversationSuggestion conversationSuggestion = (ConversationSuggestion) other;
        return this.id == conversationSuggestion.id && Intrinsics.areEqual(this.text, conversationSuggestion.text) && this.language == conversationSuggestion.language && Intrinsics.areEqual(this.category, conversationSuggestion.category);
    }

    public int hashCode() {
        return (((((Long.hashCode(this.id) * 31) + this.text.hashCode()) * 31) + this.language.hashCode()) * 31) + this.category.hashCode();
    }

    public String toString() {
        return "ConversationSuggestion(id=" + this.id + ", text=" + this.text + ", language=" + this.language + ", category=" + this.category + ")";
    }

    public ConversationSuggestion(long j, String str, LanguageEnum languageEnum, SuggestionCategory suggestionCategory) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(languageEnum, "language");
        Intrinsics.checkNotNullParameter(suggestionCategory, "category");
        this.id = j;
        this.text = str;
        this.language = languageEnum;
        this.category = suggestionCategory;
    }

    public /* synthetic */ ConversationSuggestion(long j, String str, LanguageEnum languageEnum, SuggestionCategory suggestionCategory, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, str, languageEnum, suggestionCategory);
    }

    public final long getId() {
        return this.id;
    }

    public final String getText() {
        return this.text;
    }

    public final LanguageEnum getLanguage() {
        return this.language;
    }

    public final SuggestionCategory getCategory() {
        return this.category;
    }
}
