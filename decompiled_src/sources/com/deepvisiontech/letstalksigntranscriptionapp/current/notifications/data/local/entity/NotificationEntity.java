package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.local.entity;

import com.azure.core.implementation.logging.LoggingKeys;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.NotificationData;
import com.google.firebase.messaging.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotificationEntity.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003J\t\u0010\u001d\u001a\u00020\fHÆ\u0003JO\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0015R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/data/local/entity/NotificationEntity;", "", "id", "", "title", LoggingKeys.BODY_KEY, Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationData;", "isRead", "", "dateTime", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZJ)V", "getId", "()Ljava/lang/String;", "getTitle", "getBody", "getData", "()Ljava/util/List;", "()Z", "getDateTime", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class NotificationEntity {
    public static final int $stable = 8;
    private final String body;
    private final List<NotificationData> data;
    private final long dateTime;
    private final String id;
    private final boolean isRead;
    private final String title;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NotificationEntity copy$default(NotificationEntity notificationEntity, String str, String str2, String str3, List list, boolean z, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = notificationEntity.id;
        }
        if ((i & 2) != 0) {
            str2 = notificationEntity.title;
        }
        if ((i & 4) != 0) {
            str3 = notificationEntity.body;
        }
        if ((i & 8) != 0) {
            list = notificationEntity.data;
        }
        if ((i & 16) != 0) {
            z = notificationEntity.isRead;
        }
        if ((i & 32) != 0) {
            j = notificationEntity.dateTime;
        }
        long j2 = j;
        boolean z2 = z;
        String str4 = str3;
        return notificationEntity.copy(str, str2, str4, list, z2, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getBody() {
        return this.body;
    }

    public final List<NotificationData> component4() {
        return this.data;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsRead() {
        return this.isRead;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getDateTime() {
        return this.dateTime;
    }

    public final NotificationEntity copy(String id, String title, String body, List<NotificationData> data, boolean isRead, long dateTime) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        return new NotificationEntity(id, title, body, data, isRead, dateTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotificationEntity)) {
            return false;
        }
        NotificationEntity notificationEntity = (NotificationEntity) other;
        return Intrinsics.areEqual(this.id, notificationEntity.id) && Intrinsics.areEqual(this.title, notificationEntity.title) && Intrinsics.areEqual(this.body, notificationEntity.body) && Intrinsics.areEqual(this.data, notificationEntity.data) && this.isRead == notificationEntity.isRead && this.dateTime == notificationEntity.dateTime;
    }

    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.title.hashCode()) * 31;
        String str = this.body;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<NotificationData> list = this.data;
        return ((((iHashCode2 + (list != null ? list.hashCode() : 0)) * 31) + Boolean.hashCode(this.isRead)) * 31) + Long.hashCode(this.dateTime);
    }

    public String toString() {
        return "NotificationEntity(id=" + this.id + ", title=" + this.title + ", body=" + this.body + ", data=" + this.data + ", isRead=" + this.isRead + ", dateTime=" + this.dateTime + ")";
    }

    public NotificationEntity(String str, String str2, String str3, List<NotificationData> list, boolean z, long j) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.id = str;
        this.title = str2;
        this.body = str3;
        this.data = list;
        this.isRead = z;
        this.dateTime = j;
    }

    public final String getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public /* synthetic */ NotificationEntity(String str, String str2, String str3, List list, boolean z, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "Untitled" : str2, (i & 4) != 0 ? null : str3, (i & 8) == 0 ? list : null, (i & 16) != 0 ? false : z, (i & 32) != 0 ? 0L : j);
    }

    public final String getBody() {
        return this.body;
    }

    public final List<NotificationData> getData() {
        return this.data;
    }

    public final boolean isRead() {
        return this.isRead;
    }

    public final long getDateTime() {
        return this.dateTime;
    }
}
