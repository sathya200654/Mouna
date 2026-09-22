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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationScreenUiState$Success;", "currentState", "isSubmitting", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationViewModel$uiState$3", f = "NotificationViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class NotificationViewModel$uiState$3 extends SuspendLambda implements Function3<NotificationScreenUiState.Success, Boolean, Continuation<? super NotificationScreenUiState.Success>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ boolean Z$0;
    int label;

    NotificationViewModel$uiState$3(Continuation<? super NotificationViewModel$uiState$3> continuation) {
        super(3, continuation);
    }

    public final Object invoke(NotificationScreenUiState.Success success, boolean z, Continuation<? super NotificationScreenUiState.Success> continuation) {
        NotificationViewModel$uiState$3 notificationViewModel$uiState$3 = new NotificationViewModel$uiState$3(continuation);
        notificationViewModel$uiState$3.L$0 = success;
        notificationViewModel$uiState$3.Z$0 = z;
        return notificationViewModel$uiState$3.invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((NotificationScreenUiState.Success) obj, ((Boolean) obj2).booleanValue(), (Continuation<? super NotificationScreenUiState.Success>) obj3);
    }

    public final Object invokeSuspend(Object obj) {
        NotificationScreenUiState.Success success = (NotificationScreenUiState.Success) this.L$0;
        boolean z = this.Z$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return NotificationScreenUiState.Success.copy$default(success, null, z, null, 5, null);
    }
}
