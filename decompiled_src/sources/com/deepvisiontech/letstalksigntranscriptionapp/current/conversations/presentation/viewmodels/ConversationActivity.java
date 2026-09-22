package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.ConversationMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConversationViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\t\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u0082\u0001\t\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActivity;", "", "Idle", "IsWebViewLoading", "IsInitializing", "IsTranscribing", "IsFetchingSuggestions", "IsProcessingInputText", "IsSummarizing", "IsSpeaking", "IsInterpreting", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActivity$Idle;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActivity$IsFetchingSuggestions;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActivity$IsInitializing;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActivity$IsInterpreting;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActivity$IsProcessingInputText;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActivity$IsSpeaking;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActivity$IsSummarizing;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActivity$IsTranscribing;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActivity$IsWebViewLoading;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ConversationActivity {

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActivity$Idle;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActivity;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Idle implements ConversationActivity {
        public static final int $stable = 0;
        public static final Idle INSTANCE = new Idle();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Idle)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1246897397;
        }

        public String toString() {
            return "Idle";
        }

        private Idle() {
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActivity$IsWebViewLoading;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActivity;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class IsWebViewLoading implements ConversationActivity {
        public static final int $stable = 0;
        public static final IsWebViewLoading INSTANCE = new IsWebViewLoading();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof IsWebViewLoading)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 368194404;
        }

        public String toString() {
            return "IsWebViewLoading";
        }

        private IsWebViewLoading() {
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActivity$IsInitializing;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActivity;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class IsInitializing implements ConversationActivity {
        public static final int $stable = 0;
        public static final IsInitializing INSTANCE = new IsInitializing();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof IsInitializing)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 983529742;
        }

        public String toString() {
            return "IsInitializing";
        }

        private IsInitializing() {
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActivity$IsTranscribing;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActivity;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class IsTranscribing implements ConversationActivity {
        public static final int $stable = 0;
        public static final IsTranscribing INSTANCE = new IsTranscribing();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof IsTranscribing)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1236835891;
        }

        public String toString() {
            return "IsTranscribing";
        }

        private IsTranscribing() {
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActivity$IsFetchingSuggestions;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActivity;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class IsFetchingSuggestions implements ConversationActivity {
        public static final int $stable = 0;
        public static final IsFetchingSuggestions INSTANCE = new IsFetchingSuggestions();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof IsFetchingSuggestions)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1902444794;
        }

        public String toString() {
            return "IsFetchingSuggestions";
        }

        private IsFetchingSuggestions() {
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActivity$IsProcessingInputText;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActivity;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class IsProcessingInputText implements ConversationActivity {
        public static final int $stable = 0;
        public static final IsProcessingInputText INSTANCE = new IsProcessingInputText();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof IsProcessingInputText)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1796836765;
        }

        public String toString() {
            return "IsProcessingInputText";
        }

        private IsProcessingInputText() {
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActivity$IsSummarizing;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActivity;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class IsSummarizing implements ConversationActivity {
        public static final int $stable = 0;
        public static final IsSummarizing INSTANCE = new IsSummarizing();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof IsSummarizing)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 223586525;
        }

        public String toString() {
            return "IsSummarizing";
        }

        private IsSummarizing() {
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActivity$IsSpeaking;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActivity;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class IsSpeaking implements ConversationActivity {
        public static final int $stable = 0;
        public static final IsSpeaking INSTANCE = new IsSpeaking();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof IsSpeaking)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1118933999;
        }

        public String toString() {
            return "IsSpeaking";
        }

        private IsSpeaking() {
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActivity$IsInterpreting;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActivity;", "conversationMessage", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMessage;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMessage;)V", "getConversationMessage", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMessage;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class IsInterpreting implements ConversationActivity {
        public static final int $stable = 0;
        private final ConversationMessage conversationMessage;

        public static /* synthetic */ IsInterpreting copy$default(IsInterpreting isInterpreting, ConversationMessage conversationMessage, int i, Object obj) {
            if ((i & 1) != 0) {
                conversationMessage = isInterpreting.conversationMessage;
            }
            return isInterpreting.copy(conversationMessage);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ConversationMessage getConversationMessage() {
            return this.conversationMessage;
        }

        public final IsInterpreting copy(ConversationMessage conversationMessage) {
            Intrinsics.checkNotNullParameter(conversationMessage, "conversationMessage");
            return new IsInterpreting(conversationMessage);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof IsInterpreting) && Intrinsics.areEqual(this.conversationMessage, ((IsInterpreting) other).conversationMessage);
        }

        public int hashCode() {
            return this.conversationMessage.hashCode();
        }

        public String toString() {
            return "IsInterpreting(conversationMessage=" + this.conversationMessage + ")";
        }

        public IsInterpreting(ConversationMessage conversationMessage) {
            Intrinsics.checkNotNullParameter(conversationMessage, "conversationMessage");
            this.conversationMessage = conversationMessage;
        }

        public final ConversationMessage getConversationMessage() {
            return this.conversationMessage;
        }
    }
}
