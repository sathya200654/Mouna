package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.local.mappers;

import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.local.entity.NotificationEntity;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.Notification;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotificationMapper.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0001¨\u0006\u0004"}, d2 = {"toNotification", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/Notification;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/data/local/entity/NotificationEntity;", "toEntity", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class NotificationMapperKt {
    public static final Notification toNotification(NotificationEntity notificationEntity) {
        Intrinsics.checkNotNullParameter(notificationEntity, "<this>");
        return new Notification(notificationEntity.getId(), notificationEntity.getTitle(), notificationEntity.getBody(), (List) notificationEntity.getData(), notificationEntity.isRead(), false, notificationEntity.getDateTime(), 32, (DefaultConstructorMarker) null);
    }

    public static final NotificationEntity toEntity(Notification notification) {
        Intrinsics.checkNotNullParameter(notification, "<this>");
        return new NotificationEntity(notification.getId(), notification.getTitle(), notification.getBody(), notification.getData(), notification.isRead(), notification.getDateTime());
    }
}
