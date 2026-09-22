package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: NotificationViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationScreenUiState$Success;", "currentState", "selections", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationUserSelections;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationViewModel$uiState$2", f = "NotificationViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class NotificationViewModel$uiState$2 extends SuspendLambda implements Function3<NotificationScreenUiState.Success, NotificationUserSelections, Continuation<? super NotificationScreenUiState.Success>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    NotificationViewModel$uiState$2(Continuation<? super NotificationViewModel$uiState$2> continuation) {
        super(3, continuation);
    }

    public final Object invoke(NotificationScreenUiState.Success success, NotificationUserSelections notificationUserSelections, Continuation<? super NotificationScreenUiState.Success> continuation) {
        NotificationViewModel$uiState$2 notificationViewModel$uiState$2 = new NotificationViewModel$uiState$2(continuation);
        notificationViewModel$uiState$2.L$0 = success;
        notificationViewModel$uiState$2.L$1 = notificationUserSelections;
        return notificationViewModel$uiState$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        NotificationScreenUiState.Success success = (NotificationScreenUiState.Success) this.L$0;
        NotificationUserSelections notificationUserSelections = (NotificationUserSelections) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return NotificationScreenUiState.Success.copy$default(success, null, false, notificationUserSelections, 3, null);
    }
}
