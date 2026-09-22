package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.NotificationResponseType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotificationViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationScreenUiAction;", "", "OnNotificationActionClick", "OnNotificationSubmitListActionClick", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationScreenUiAction$OnNotificationActionClick;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationScreenUiAction$OnNotificationSubmitListActionClick;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface NotificationScreenUiAction {

    /* JADX INFO: compiled from: NotificationViewModel.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationScreenUiAction$OnNotificationActionClick;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationScreenUiAction;", "pageId", "", "action", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationResponseType;", "<init>", "(JLcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationResponseType;)V", "getPageId", "()J", "getAction", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationResponseType;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnNotificationActionClick implements NotificationScreenUiAction {
        public static final int $stable = 0;
        private final NotificationResponseType action;
        private final long pageId;

        public static /* synthetic */ OnNotificationActionClick copy$default(OnNotificationActionClick onNotificationActionClick, long j, NotificationResponseType notificationResponseType, int i, Object obj) {
            if ((i & 1) != 0) {
                j = onNotificationActionClick.pageId;
            }
            if ((i & 2) != 0) {
                notificationResponseType = onNotificationActionClick.action;
            }
            return onNotificationActionClick.copy(j, notificationResponseType);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getPageId() {
            return this.pageId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final NotificationResponseType getAction() {
            return this.action;
        }

        public final OnNotificationActionClick copy(long pageId, NotificationResponseType action) {
            Intrinsics.checkNotNullParameter(action, "action");
            return new OnNotificationActionClick(pageId, action);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnNotificationActionClick)) {
                return false;
            }
            OnNotificationActionClick onNotificationActionClick = (OnNotificationActionClick) other;
            return this.pageId == onNotificationActionClick.pageId && this.action == onNotificationActionClick.action;
        }

        public int hashCode() {
            return (Long.hashCode(this.pageId) * 31) + this.action.hashCode();
        }

        public String toString() {
            return "OnNotificationActionClick(pageId=" + this.pageId + ", action=" + this.action + ")";
        }

        public OnNotificationActionClick(long j, NotificationResponseType notificationResponseType) {
            Intrinsics.checkNotNullParameter(notificationResponseType, "action");
            this.pageId = j;
            this.action = notificationResponseType;
        }

        public final long getPageId() {
            return this.pageId;
        }

        public final NotificationResponseType getAction() {
            return this.action;
        }
    }

    /* JADX INFO: compiled from: NotificationViewModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationScreenUiAction$OnNotificationSubmitListActionClick;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationScreenUiAction;", "pageId", "", "<init>", "(J)V", "getPageId", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnNotificationSubmitListActionClick implements NotificationScreenUiAction {
        public static final int $stable = 0;
        private final long pageId;

        public static /* synthetic */ OnNotificationSubmitListActionClick copy$default(OnNotificationSubmitListActionClick onNotificationSubmitListActionClick, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = onNotificationSubmitListActionClick.pageId;
            }
            return onNotificationSubmitListActionClick.copy(j);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getPageId() {
            return this.pageId;
        }

        public final OnNotificationSubmitListActionClick copy(long pageId) {
            return new OnNotificationSubmitListActionClick(pageId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OnNotificationSubmitListActionClick) && this.pageId == ((OnNotificationSubmitListActionClick) other).pageId;
        }

        public int hashCode() {
            return Long.hashCode(this.pageId);
        }

        public String toString() {
            return "OnNotificationSubmitListActionClick(pageId=" + this.pageId + ")";
        }

        public OnNotificationSubmitListActionClick(long j) {
            this.pageId = j;
        }

        public final long getPageId() {
            return this.pageId;
        }
    }
}
