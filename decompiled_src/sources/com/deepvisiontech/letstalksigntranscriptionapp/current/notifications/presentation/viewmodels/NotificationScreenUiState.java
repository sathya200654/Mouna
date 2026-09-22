package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.Notification;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotificationViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationScreenUiState;", "", "Loading", "Success", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationScreenUiState$Loading;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationScreenUiState$Success;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface NotificationScreenUiState {

    /* JADX INFO: compiled from: NotificationViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationScreenUiState$Loading;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationScreenUiState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Loading implements NotificationScreenUiState {
        public static final int $stable = 0;
        public static final Loading INSTANCE = new Loading();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Loading)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1697414983;
        }

        public String toString() {
            return "Loading";
        }

        private Loading() {
        }
    }

    /* JADX INFO: compiled from: NotificationViewModel.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationScreenUiState$Success;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationScreenUiState;", "notification", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/Notification;", "isSubmitting", "", "userSelections", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationUserSelections;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/Notification;ZLcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationUserSelections;)V", "getNotification", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/Notification;", "()Z", "getUserSelections", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationUserSelections;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Success implements NotificationScreenUiState {
        public static final int $stable = 8;
        private final boolean isSubmitting;
        private final Notification notification;
        private final NotificationUserSelections userSelections;

        public static /* synthetic */ Success copy$default(Success success, Notification notification, boolean z, NotificationUserSelections notificationUserSelections, int i, Object obj) {
            if ((i & 1) != 0) {
                notification = success.notification;
            }
            if ((i & 2) != 0) {
                z = success.isSubmitting;
            }
            if ((i & 4) != 0) {
                notificationUserSelections = success.userSelections;
            }
            return success.copy(notification, z, notificationUserSelections);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Notification getNotification() {
            return this.notification;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsSubmitting() {
            return this.isSubmitting;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final NotificationUserSelections getUserSelections() {
            return this.userSelections;
        }

        public final Success copy(Notification notification, boolean isSubmitting, NotificationUserSelections userSelections) {
            Intrinsics.checkNotNullParameter(notification, "notification");
            Intrinsics.checkNotNullParameter(userSelections, "userSelections");
            return new Success(notification, isSubmitting, userSelections);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Success)) {
                return false;
            }
            Success success = (Success) other;
            return Intrinsics.areEqual(this.notification, success.notification) && this.isSubmitting == success.isSubmitting && Intrinsics.areEqual(this.userSelections, success.userSelections);
        }

        public int hashCode() {
            return (((this.notification.hashCode() * 31) + Boolean.hashCode(this.isSubmitting)) * 31) + this.userSelections.hashCode();
        }

        public String toString() {
            return "Success(notification=" + this.notification + ", isSubmitting=" + this.isSubmitting + ", userSelections=" + this.userSelections + ")";
        }

        public Success(Notification notification, boolean z, NotificationUserSelections notificationUserSelections) {
            Intrinsics.checkNotNullParameter(notification, "notification");
            Intrinsics.checkNotNullParameter(notificationUserSelections, "userSelections");
            this.notification = notification;
            this.isSubmitting = z;
            this.userSelections = notificationUserSelections;
        }

        public final Notification getNotification() {
            return this.notification;
        }

        public final boolean isSubmitting() {
            return this.isSubmitting;
        }

        public /* synthetic */ Success(Notification notification, boolean z, NotificationUserSelections notificationUserSelections, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(notification, (i & 2) != 0 ? false : z, (i & 4) != 0 ? new NotificationUserSelections(null, 1, null) : notificationUserSelections);
        }

        public final NotificationUserSelections getUserSelections() {
            return this.userSelections;
        }
    }
}
