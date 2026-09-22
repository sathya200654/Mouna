package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.conversationsuggestion.ConversationSuggestion;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConversationViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSuggestionsState;", "", "isCorrectionSuggestionsEnabled", "", "conversationSuggestions", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/ConversationSuggestion;", "<init>", "(ZLjava/util/List;)V", "()Z", "getConversationSuggestions", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ConversationSuggestionsState {
    public static final int $stable = 8;
    private final List<ConversationSuggestion> conversationSuggestions;
    private final boolean isCorrectionSuggestionsEnabled;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConversationSuggestionsState copy$default(ConversationSuggestionsState conversationSuggestionsState, boolean z, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = conversationSuggestionsState.isCorrectionSuggestionsEnabled;
        }
        if ((i & 2) != 0) {
            list = conversationSuggestionsState.conversationSuggestions;
        }
        return conversationSuggestionsState.copy(z, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsCorrectionSuggestionsEnabled() {
        return this.isCorrectionSuggestionsEnabled;
    }

    public final List<ConversationSuggestion> component2() {
        return this.conversationSuggestions;
    }

    public final ConversationSuggestionsState copy(boolean isCorrectionSuggestionsEnabled, List<ConversationSuggestion> conversationSuggestions) {
        Intrinsics.checkNotNullParameter(conversationSuggestions, "conversationSuggestions");
        return new ConversationSuggestionsState(isCorrectionSuggestionsEnabled, conversationSuggestions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConversationSuggestionsState)) {
            return false;
        }
        ConversationSuggestionsState conversationSuggestionsState = (ConversationSuggestionsState) other;
        return this.isCorrectionSuggestionsEnabled == conversationSuggestionsState.isCorrectionSuggestionsEnabled && Intrinsics.areEqual(this.conversationSuggestions, conversationSuggestionsState.conversationSuggestions);
    }

    public int hashCode() {
        return (Boolean.hashCode(this.isCorrectionSuggestionsEnabled) * 31) + this.conversationSuggestions.hashCode();
    }

    public String toString() {
        return "ConversationSuggestionsState(isCorrectionSuggestionsEnabled=" + this.isCorrectionSuggestionsEnabled + ", conversationSuggestions=" + this.conversationSuggestions + ")";
    }

    public ConversationSuggestionsState(boolean z, List<ConversationSuggestion> list) {
        Intrinsics.checkNotNullParameter(list, "conversationSuggestions");
        this.isCorrectionSuggestionsEnabled = z;
        this.conversationSuggestions = list;
    }

    public /* synthetic */ ConversationSuggestionsState(boolean z, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, list);
    }

    public final boolean isCorrectionSuggestionsEnabled() {
        return this.isCorrectionSuggestionsEnabled;
    }

    public final List<ConversationSuggestion> getConversationSuggestions() {
        return this.conversationSuggestions;
    }
}
