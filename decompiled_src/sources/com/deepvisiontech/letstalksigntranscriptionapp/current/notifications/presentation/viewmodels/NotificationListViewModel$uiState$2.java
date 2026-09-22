package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.ListSortOrder;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: NotificationListViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationListScreenUiState;", "currentState", "sortOrder", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/ListSortOrder;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationListViewModel$uiState$2", f = "NotificationListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class NotificationListViewModel$uiState$2 extends SuspendLambda implements Function3<NotificationListScreenUiState, ListSortOrder, Continuation<? super NotificationListScreenUiState>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    NotificationListViewModel$uiState$2(Continuation<? super NotificationListViewModel$uiState$2> continuation) {
        super(3, continuation);
    }

    public final Object invoke(NotificationListScreenUiState notificationListScreenUiState, ListSortOrder listSortOrder, Continuation<? super NotificationListScreenUiState> continuation) {
        NotificationListViewModel$uiState$2 notificationListViewModel$uiState$2 = new NotificationListViewModel$uiState$2(continuation);
        notificationListViewModel$uiState$2.L$0 = notificationListScreenUiState;
        notificationListViewModel$uiState$2.L$1 = listSortOrder;
        return notificationListViewModel$uiState$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        NotificationListScreenUiState notificationListScreenUiState = (NotificationListScreenUiState) this.L$0;
        ListSortOrder listSortOrder = (ListSortOrder) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return NotificationListScreenUiState.copy$default(notificationListScreenUiState, null, false, false, null, listSortOrder, null, null, 111, null);
    }
}
