package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels;

import kotlin.Metadata;

/* JADX INFO: compiled from: NotificationListViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0001\u0002\u0082\u0001\u0001\u0003¨\u0006\u0004À\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationListScreenEvent;", "", "ShowUserMessage", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationListScreenEvent$ShowUserMessage;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface NotificationListScreenEvent {

    /* JADX INFO: compiled from: NotificationListViewModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationListScreenEvent$ShowUserMessage;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationListScreenEvent;", "messageResId", "", "<init>", "(I)V", "getMessageResId", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ShowUserMessage implements NotificationListScreenEvent {
        public static final int $stable = 0;
        private final int messageResId;

        public static /* synthetic */ ShowUserMessage copy$default(ShowUserMessage showUserMessage, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = showUserMessage.messageResId;
            }
            return showUserMessage.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getMessageResId() {
            return this.messageResId;
        }

        public final ShowUserMessage copy(int messageResId) {
            return new ShowUserMessage(messageResId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ShowUserMessage) && this.messageResId == ((ShowUserMessage) other).messageResId;
        }

        public int hashCode() {
            return Integer.hashCode(this.messageResId);
        }

        public String toString() {
            return "ShowUserMessage(messageResId=" + this.messageResId + ")";
        }

        public ShowUserMessage(int i) {
            this.messageResId = i;
        }

        public final int getMessageResId() {
            return this.messageResId;
        }
    }
}
