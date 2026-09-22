package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.local.dao;

import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.local.entity.NotificationEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: NotificationDao.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH'J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u000b\u001a\u00020\fH'J\u0016\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH§@¢\u0006\u0002\u0010\u000eJ\u001c\u0010\u000f\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\tH§@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/data/local/dao/NotificationDao;", "", "insertNotification", "", "notificationEntity", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/data/local/entity/NotificationEntity;", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/data/local/entity/NotificationEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllNotifications", "Lkotlinx/coroutines/flow/Flow;", "", "getNotificationFlow", "id", "", "getNotification", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteNotification", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateNotification", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface NotificationDao {
    Object deleteNotification(List<NotificationEntity> list, Continuation<? super Unit> continuation);

    Flow<List<NotificationEntity>> getAllNotifications();

    Object getNotification(String str, Continuation<? super NotificationEntity> continuation);

    Flow<NotificationEntity> getNotificationFlow(String id);

    Object insertNotification(NotificationEntity notificationEntity, Continuation<? super Unit> continuation);

    Object updateNotification(NotificationEntity notificationEntity, Continuation<? super Unit> continuation);
}
