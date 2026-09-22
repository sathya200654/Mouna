package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels;

import kotlin.Metadata;

/* JADX INFO: compiled from: ConversationViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActionElement;", "", "InterpretationWebView", "TextToSpeechDrawer", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActionElement$InterpretationWebView;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActionElement$TextToSpeechDrawer;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ConversationActionElement {

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActionElement$InterpretationWebView;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActionElement;", "isMinimized", "", "<init>", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class InterpretationWebView implements ConversationActionElement {
        public static final int $stable = 0;
        private final boolean isMinimized;

        public static /* synthetic */ InterpretationWebView copy$default(InterpretationWebView interpretationWebView, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = interpretationWebView.isMinimized;
            }
            return interpretationWebView.copy(z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsMinimized() {
            return this.isMinimized;
        }

        public final InterpretationWebView copy(boolean isMinimized) {
            return new InterpretationWebView(isMinimized);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof InterpretationWebView) && this.isMinimized == ((InterpretationWebView) other).isMinimized;
        }

        public int hashCode() {
            return Boolean.hashCode(this.isMinimized);
        }

        public String toString() {
            return "InterpretationWebView(isMinimized=" + this.isMinimized + ")";
        }

        public InterpretationWebView(boolean z) {
            this.isMinimized = z;
        }

        public final boolean isMinimized() {
            return this.isMinimized;
        }
    }

    /* JADX INFO: compiled from: ConversationViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActionElement$TextToSpeechDrawer;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationActionElement;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class TextToSpeechDrawer implements ConversationActionElement {
        public static final int $stable = 0;
        public static final TextToSpeechDrawer INSTANCE = new TextToSpeechDrawer();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TextToSpeechDrawer)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1708266069;
        }

        public String toString() {
            return "TextToSpeechDrawer";
        }

        private TextToSpeechDrawer() {
        }
    }
}
