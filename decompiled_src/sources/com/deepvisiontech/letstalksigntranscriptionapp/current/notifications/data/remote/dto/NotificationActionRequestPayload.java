package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.remote.dto;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotificationActionRequestPayload.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/data/remote/dto/NotificationActionRequestPayload;", "", "notificationId", "", "pageId", "", "notificationResponse", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/data/remote/dto/NotificationActionData;", "<init>", "(Ljava/lang/String;JLcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/data/remote/dto/NotificationActionData;)V", "getNotificationId", "()Ljava/lang/String;", "getPageId", "()J", "getNotificationResponse", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/data/remote/dto/NotificationActionData;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class NotificationActionRequestPayload {
    public static final int $stable = 8;

    @SerializedName("notificationId")
    private final String notificationId;

    @SerializedName("notificationResponse")
    private final NotificationActionData notificationResponse;

    @SerializedName("pageId")
    private final long pageId;

    public static /* synthetic */ NotificationActionRequestPayload copy$default(NotificationActionRequestPayload notificationActionRequestPayload, String str, long j, NotificationActionData notificationActionData, int i, Object obj) {
        if ((i & 1) != 0) {
            str = notificationActionRequestPayload.notificationId;
        }
        if ((i & 2) != 0) {
            j = notificationActionRequestPayload.pageId;
        }
        if ((i & 4) != 0) {
            notificationActionData = notificationActionRequestPayload.notificationResponse;
        }
        return notificationActionRequestPayload.copy(str, j, notificationActionData);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getNotificationId() {
        return this.notificationId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getPageId() {
        return this.pageId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final NotificationActionData getNotificationResponse() {
        return this.notificationResponse;
    }

    public final NotificationActionRequestPayload copy(String notificationId, long pageId, NotificationActionData notificationResponse) {
        Intrinsics.checkNotNullParameter(notificationId, "notificationId");
        Intrinsics.checkNotNullParameter(notificationResponse, "notificationResponse");
        return new NotificationActionRequestPayload(notificationId, pageId, notificationResponse);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotificationActionRequestPayload)) {
            return false;
        }
        NotificationActionRequestPayload notificationActionRequestPayload = (NotificationActionRequestPayload) other;
        return Intrinsics.areEqual(this.notificationId, notificationActionRequestPayload.notificationId) && this.pageId == notificationActionRequestPayload.pageId && Intrinsics.areEqual(this.notificationResponse, notificationActionRequestPayload.notificationResponse);
    }

    public int hashCode() {
        return (((this.notificationId.hashCode() * 31) + Long.hashCode(this.pageId)) * 31) + this.notificationResponse.hashCode();
    }

    public String toString() {
        return "NotificationActionRequestPayload(notificationId=" + this.notificationId + ", pageId=" + this.pageId + ", notificationResponse=" + this.notificationResponse + ")";
    }

    public NotificationActionRequestPayload(String str, long j, NotificationActionData notificationActionData) {
        Intrinsics.checkNotNullParameter(str, "notificationId");
        Intrinsics.checkNotNullParameter(notificationActionData, "notificationResponse");
        this.notificationId = str;
        this.pageId = j;
        this.notificationResponse = notificationActionData;
    }

    public final String getNotificationId() {
        return this.notificationId;
    }

    public final long getPageId() {
        return this.pageId;
    }

    public final NotificationActionData getNotificationResponse() {
        return this.notificationResponse;
    }
}
