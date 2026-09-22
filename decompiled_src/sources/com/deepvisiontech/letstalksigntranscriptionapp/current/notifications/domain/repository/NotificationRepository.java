package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.repository;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.Notification;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.NotificationResponseType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: NotificationRepository.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\n0\tH&J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\f\u001a\u00020\rH&J\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\nH¦@¢\u0006\u0002\u0010\u0010J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007J4\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H¦@¢\u0006\u0002\u0010\u0019J:\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\r2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\nH¦@¢\u0006\u0002\u0010\u001cJ$\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H¦@¢\u0006\u0002\u0010\u001e¨\u0006\u001fÀ\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/repository/NotificationRepository;", "", "insertNotifications", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "notification", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/Notification;", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/Notification;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllNotifications", "Lkotlinx/coroutines/flow/Flow;", "", "getNotificationFlow", "id", "", "deleteNotification", "notifications", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateNotification", "submitAction", "notificationId", "pageId", "", "gmail", "action", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationResponseType;", "(Ljava/lang/String;JLjava/lang/String;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationResponseType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submitListAction", "selectedOptions", "(Ljava/lang/String;JLjava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markNotificationPageAsResponded", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface NotificationRepository {
    Object deleteNotification(List<Notification> list, Continuation<? super ResponseResource<Unit>> continuation);

    Flow<List<Notification>> getAllNotifications();

    Flow<Notification> getNotificationFlow(String id);

    Object insertNotifications(Notification notification, Continuation<? super ResponseResource<Unit>> continuation);

    Object markNotificationPageAsResponded(String str, long j, Continuation<? super ResponseResource<Unit>> continuation);

    Object submitAction(String str, long j, String str2, NotificationResponseType notificationResponseType, Continuation<? super ResponseResource<Unit>> continuation);

    Object submitListAction(String str, long j, String str2, List<String> list, Continuation<? super ResponseResource<Unit>> continuation);

    Object updateNotification(Notification notification, Continuation<? super ResponseResource<Unit>> continuation);
}
