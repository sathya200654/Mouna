package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.Notification;
import java.util.List;
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
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationListScreenUiState;", "notifications", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/Notification;", "query", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationListViewModel$uiState$1", f = "NotificationListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class NotificationListViewModel$uiState$1 extends SuspendLambda implements Function3<List<? extends Notification>, String, Continuation<? super NotificationListScreenUiState>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    NotificationListViewModel$uiState$1(Continuation<? super NotificationListViewModel$uiState$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(List<Notification> list, String str, Continuation<? super NotificationListScreenUiState> continuation) {
        NotificationListViewModel$uiState$1 notificationListViewModel$uiState$1 = new NotificationListViewModel$uiState$1(continuation);
        notificationListViewModel$uiState$1.L$0 = list;
        notificationListViewModel$uiState$1.L$1 = str;
        return notificationListViewModel$uiState$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        List list = (List) this.L$0;
        String str = (String) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return new NotificationListScreenUiState(list, false, false, str, null, null, null, 52, null);
    }
}
