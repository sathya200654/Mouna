package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels;

import kotlin.Metadata;

/* JADX INFO: compiled from: ConversationSettingsViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsEvent;", "", "ShowErrorMessage", "ShowInfoMessage", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsEvent$ShowErrorMessage;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsEvent$ShowInfoMessage;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ConversationSettingsEvent {

    /* JADX INFO: compiled from: ConversationSettingsViewModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsEvent$ShowErrorMessage;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsEvent;", "messageRes", "", "<init>", "(I)V", "getMessageRes", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ShowErrorMessage implements ConversationSettingsEvent {
        public static final int $stable = 0;
        private final int messageRes;

        public static /* synthetic */ ShowErrorMessage copy$default(ShowErrorMessage showErrorMessage, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = showErrorMessage.messageRes;
            }
            return showErrorMessage.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getMessageRes() {
            return this.messageRes;
        }

        public final ShowErrorMessage copy(int messageRes) {
            return new ShowErrorMessage(messageRes);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ShowErrorMessage) && this.messageRes == ((ShowErrorMessage) other).messageRes;
        }

        public int hashCode() {
            return Integer.hashCode(this.messageRes);
        }

        public String toString() {
            return "ShowErrorMessage(messageRes=" + this.messageRes + ")";
        }

        public ShowErrorMessage(int i) {
            this.messageRes = i;
        }

        public final int getMessageRes() {
            return this.messageRes;
        }
    }

    /* JADX INFO: compiled from: ConversationSettingsViewModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsEvent$ShowInfoMessage;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationSettingsEvent;", "messageRes", "", "<init>", "(I)V", "getMessageRes", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ShowInfoMessage implements ConversationSettingsEvent {
        public static final int $stable = 0;
        private final int messageRes;

        public static /* synthetic */ ShowInfoMessage copy$default(ShowInfoMessage showInfoMessage, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = showInfoMessage.messageRes;
            }
            return showInfoMessage.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getMessageRes() {
            return this.messageRes;
        }

        public final ShowInfoMessage copy(int messageRes) {
            return new ShowInfoMessage(messageRes);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ShowInfoMessage) && this.messageRes == ((ShowInfoMessage) other).messageRes;
        }

        public int hashCode() {
            return Integer.hashCode(this.messageRes);
        }

        public String toString() {
            return "ShowInfoMessage(messageRes=" + this.messageRes + ")";
        }

        public ShowInfoMessage(int i) {
            this.messageRes = i;
        }

        public final int getMessageRes() {
            return this.messageRes;
        }
    }
}
