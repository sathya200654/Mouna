package com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.ConversationMessage;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebViewManagerImpl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0006\u0002\u0003\u0004\u0005\u0006\u0007\u0082\u0001\u0006\b\t\n\u000b\f\r¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/manager/WebViewState;", "", "IsLoading", "IsInterpretingConversationMessage", "IsInterpretingSentences", "Idle", "Minimized", "Error", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/manager/WebViewState$Error;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/manager/WebViewState$Idle;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/manager/WebViewState$IsInterpretingConversationMessage;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/manager/WebViewState$IsInterpretingSentences;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/manager/WebViewState$IsLoading;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/manager/WebViewState$Minimized;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface WebViewState {

    /* JADX INFO: compiled from: WebViewManagerImpl.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/manager/WebViewState$IsLoading;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/manager/WebViewState;", "<init>", "()V", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class IsLoading implements WebViewState {
        public static final int $stable = 0;
        public static final IsLoading INSTANCE = new IsLoading();

        private IsLoading() {
        }
    }

    /* JADX INFO: compiled from: WebViewManagerImpl.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/manager/WebViewState$IsInterpretingConversationMessage;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/manager/WebViewState;", "currentlyInterpreting", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMessage;", "interpretationQueue", "", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMessage;Ljava/util/List;)V", "getCurrentlyInterpreting", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMessage;", "getInterpretationQueue", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class IsInterpretingConversationMessage implements WebViewState {
        public static final int $stable = 8;
        private final ConversationMessage currentlyInterpreting;
        private final List<ConversationMessage> interpretationQueue;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ IsInterpretingConversationMessage copy$default(IsInterpretingConversationMessage isInterpretingConversationMessage, ConversationMessage conversationMessage, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                conversationMessage = isInterpretingConversationMessage.currentlyInterpreting;
            }
            if ((i & 2) != 0) {
                list = isInterpretingConversationMessage.interpretationQueue;
            }
            return isInterpretingConversationMessage.copy(conversationMessage, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ConversationMessage getCurrentlyInterpreting() {
            return this.currentlyInterpreting;
        }

        public final List<ConversationMessage> component2() {
            return this.interpretationQueue;
        }

        public final IsInterpretingConversationMessage copy(ConversationMessage currentlyInterpreting, List<ConversationMessage> interpretationQueue) {
            Intrinsics.checkNotNullParameter(currentlyInterpreting, "currentlyInterpreting");
            Intrinsics.checkNotNullParameter(interpretationQueue, "interpretationQueue");
            return new IsInterpretingConversationMessage(currentlyInterpreting, interpretationQueue);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof IsInterpretingConversationMessage)) {
                return false;
            }
            IsInterpretingConversationMessage isInterpretingConversationMessage = (IsInterpretingConversationMessage) other;
            return Intrinsics.areEqual(this.currentlyInterpreting, isInterpretingConversationMessage.currentlyInterpreting) && Intrinsics.areEqual(this.interpretationQueue, isInterpretingConversationMessage.interpretationQueue);
        }

        public int hashCode() {
            return (this.currentlyInterpreting.hashCode() * 31) + this.interpretationQueue.hashCode();
        }

        public String toString() {
            return "IsInterpretingConversationMessage(currentlyInterpreting=" + this.currentlyInterpreting + ", interpretationQueue=" + this.interpretationQueue + ")";
        }

        public IsInterpretingConversationMessage(ConversationMessage conversationMessage, List<ConversationMessage> list) {
            Intrinsics.checkNotNullParameter(conversationMessage, "currentlyInterpreting");
            Intrinsics.checkNotNullParameter(list, "interpretationQueue");
            this.currentlyInterpreting = conversationMessage;
            this.interpretationQueue = list;
        }

        public final ConversationMessage getCurrentlyInterpreting() {
            return this.currentlyInterpreting;
        }

        public final List<ConversationMessage> getInterpretationQueue() {
            return this.interpretationQueue;
        }
    }

    /* JADX INFO: compiled from: WebViewManagerImpl.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/manager/WebViewState$IsInterpretingSentences;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/manager/WebViewState;", "currentlyInterpreting", "", "sentencesQueue", "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getCurrentlyInterpreting", "()Ljava/lang/String;", "getSentencesQueue", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class IsInterpretingSentences implements WebViewState {
        public static final int $stable = 8;
        private final String currentlyInterpreting;
        private final List<String> sentencesQueue;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ IsInterpretingSentences copy$default(IsInterpretingSentences isInterpretingSentences, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = isInterpretingSentences.currentlyInterpreting;
            }
            if ((i & 2) != 0) {
                list = isInterpretingSentences.sentencesQueue;
            }
            return isInterpretingSentences.copy(str, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getCurrentlyInterpreting() {
            return this.currentlyInterpreting;
        }

        public final List<String> component2() {
            return this.sentencesQueue;
        }

        public final IsInterpretingSentences copy(String currentlyInterpreting, List<String> sentencesQueue) {
            Intrinsics.checkNotNullParameter(currentlyInterpreting, "currentlyInterpreting");
            Intrinsics.checkNotNullParameter(sentencesQueue, "sentencesQueue");
            return new IsInterpretingSentences(currentlyInterpreting, sentencesQueue);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof IsInterpretingSentences)) {
                return false;
            }
            IsInterpretingSentences isInterpretingSentences = (IsInterpretingSentences) other;
            return Intrinsics.areEqual(this.currentlyInterpreting, isInterpretingSentences.currentlyInterpreting) && Intrinsics.areEqual(this.sentencesQueue, isInterpretingSentences.sentencesQueue);
        }

        public int hashCode() {
            return (this.currentlyInterpreting.hashCode() * 31) + this.sentencesQueue.hashCode();
        }

        public String toString() {
            return "IsInterpretingSentences(currentlyInterpreting=" + this.currentlyInterpreting + ", sentencesQueue=" + this.sentencesQueue + ")";
        }

        public IsInterpretingSentences(String str, List<String> list) {
            Intrinsics.checkNotNullParameter(str, "currentlyInterpreting");
            Intrinsics.checkNotNullParameter(list, "sentencesQueue");
            this.currentlyInterpreting = str;
            this.sentencesQueue = list;
        }

        public final String getCurrentlyInterpreting() {
            return this.currentlyInterpreting;
        }

        public final List<String> getSentencesQueue() {
            return this.sentencesQueue;
        }
    }

    /* JADX INFO: compiled from: WebViewManagerImpl.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/manager/WebViewState$Idle;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/manager/WebViewState;", "<init>", "()V", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Idle implements WebViewState {
        public static final int $stable = 0;
        public static final Idle INSTANCE = new Idle();

        private Idle() {
        }
    }

    /* JADX INFO: compiled from: WebViewManagerImpl.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/manager/WebViewState$Minimized;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/manager/WebViewState;", "<init>", "()V", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Minimized implements WebViewState {
        public static final int $stable = 0;
        public static final Minimized INSTANCE = new Minimized();

        private Minimized() {
        }
    }

    /* JADX INFO: compiled from: WebViewManagerImpl.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/manager/WebViewState$Error;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/manager/WebViewState;", "<init>", "()V", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Error implements WebViewState {
        public static final int $stable = 0;
        public static final Error INSTANCE = new Error();

        private Error() {
        }
    }
}
