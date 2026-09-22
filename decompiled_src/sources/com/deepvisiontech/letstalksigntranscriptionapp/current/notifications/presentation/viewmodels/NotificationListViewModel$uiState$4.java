package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.Notification;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: NotificationListViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationListScreenUiState;", "currentState", "selectedIds", "", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationListViewModel$uiState$4", f = "NotificationListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class NotificationListViewModel$uiState$4 extends SuspendLambda implements Function3<NotificationListScreenUiState, Set<? extends String>, Continuation<? super NotificationListScreenUiState>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    NotificationListViewModel$uiState$4(Continuation<? super NotificationListViewModel$uiState$4> continuation) {
        super(3, continuation);
    }

    public final Object invoke(NotificationListScreenUiState notificationListScreenUiState, Set<String> set, Continuation<? super NotificationListScreenUiState> continuation) {
        NotificationListViewModel$uiState$4 notificationListViewModel$uiState$4 = new NotificationListViewModel$uiState$4(continuation);
        notificationListViewModel$uiState$4.L$0 = notificationListScreenUiState;
        notificationListViewModel$uiState$4.L$1 = set;
        return notificationListViewModel$uiState$4.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        NotificationListScreenUiState notificationListScreenUiState = (NotificationListScreenUiState) this.L$0;
        Set set = (Set) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        List<Notification> notifications = notificationListScreenUiState.getNotifications();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(notifications, 10));
        for (Notification notification : notifications) {
            arrayList.add(Notification.copy$default(notification, null, null, null, null, false, set.contains(notification.getId()), 0L, 95, null));
        }
        return NotificationListScreenUiState.copy$default(notificationListScreenUiState, arrayList, false, !set.isEmpty(), null, null, null, null, 122, null);
    }
}
