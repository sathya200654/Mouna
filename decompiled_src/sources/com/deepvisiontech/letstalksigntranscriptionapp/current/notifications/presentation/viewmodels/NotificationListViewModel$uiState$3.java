package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.DateFilterRange;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationListScreenUiState;", "currentState", "dateRange", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/DateFilterRange;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationListViewModel$uiState$3", f = "NotificationListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class NotificationListViewModel$uiState$3 extends SuspendLambda implements Function3<NotificationListScreenUiState, DateFilterRange, Continuation<? super NotificationListScreenUiState>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    NotificationListViewModel$uiState$3(Continuation<? super NotificationListViewModel$uiState$3> continuation) {
        super(3, continuation);
    }

    public final Object invoke(NotificationListScreenUiState notificationListScreenUiState, DateFilterRange dateFilterRange, Continuation<? super NotificationListScreenUiState> continuation) {
        NotificationListViewModel$uiState$3 notificationListViewModel$uiState$3 = new NotificationListViewModel$uiState$3(continuation);
        notificationListViewModel$uiState$3.L$0 = notificationListScreenUiState;
        notificationListViewModel$uiState$3.L$1 = dateFilterRange;
        return notificationListViewModel$uiState$3.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        NotificationListScreenUiState notificationListScreenUiState = (NotificationListScreenUiState) this.L$0;
        DateFilterRange dateFilterRange = (DateFilterRange) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return NotificationListScreenUiState.copy$default(notificationListScreenUiState, null, false, false, null, null, dateFilterRange, null, 95, null);
    }
}
