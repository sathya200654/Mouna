package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels;

import kotlin.Metadata;

/* JADX INFO: compiled from: NotificationViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0001\u0002\u0082\u0001\u0001\u0003¨\u0006\u0004À\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationScreenEventState;", "", "ErrorEvent", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationScreenEventState$ErrorEvent;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface NotificationScreenEventState {

    /* JADX INFO: compiled from: NotificationViewModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationScreenEventState$ErrorEvent;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationScreenEventState;", "messageResId", "", "<init>", "(I)V", "getMessageResId", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ErrorEvent implements NotificationScreenEventState {
        public static final int $stable = 0;
        private final int messageResId;

        public static /* synthetic */ ErrorEvent copy$default(ErrorEvent errorEvent, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = errorEvent.messageResId;
            }
            return errorEvent.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getMessageResId() {
            return this.messageResId;
        }

        public final ErrorEvent copy(int messageResId) {
            return new ErrorEvent(messageResId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ErrorEvent) && this.messageResId == ((ErrorEvent) other).messageResId;
        }

        public int hashCode() {
            return Integer.hashCode(this.messageResId);
        }

        public String toString() {
            return "ErrorEvent(messageResId=" + this.messageResId + ")";
        }

        public ErrorEvent(int i) {
            this.messageResId = i;
        }

        public final int getMessageResId() {
            return this.messageResId;
        }
    }
}
