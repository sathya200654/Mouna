package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels;

import android.util.Log;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.Notification;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.NotificationData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: NotificationViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationScreenUiState$Success;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationViewModel$uiState$1", f = "NotificationViewModel.kt", i = {0}, l = {108}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
final class NotificationViewModel$uiState$1 extends SuspendLambda implements Function2<FlowCollector<? super NotificationScreenUiState.Success>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ NotificationViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NotificationViewModel$uiState$1(NotificationViewModel notificationViewModel, Continuation<? super NotificationViewModel$uiState$1> continuation) {
        super(2, continuation);
        this.this$0 = notificationViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> notificationViewModel$uiState$1 = new NotificationViewModel$uiState$1(this.this$0, continuation);
        notificationViewModel$uiState$1.L$0 = obj;
        return notificationViewModel$uiState$1;
    }

    public final Object invoke(FlowCollector<? super NotificationScreenUiState.Success> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        final FlowCollector flowCollector = (FlowCollector) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
            this.label = 1;
            if (FlowKt.catch(this.this$0.getNotificationFlowUseCase.invoke(this.this$0._notificationId), new AnonymousClass1(this.this$0, null)).collect(new FlowCollector() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationViewModel$uiState$1.2
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((Notification) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(Notification notification, Continuation<? super Unit> continuation) {
                    ArrayList arrayList;
                    List<NotificationData> data = notification.getData();
                    if (data != null) {
                        ArrayList arrayList2 = new ArrayList();
                        for (T t : data) {
                            if (!((NotificationData) t).isResponded()) {
                                arrayList2.add(t);
                            }
                        }
                        arrayList = arrayList2;
                    } else {
                        arrayList = null;
                    }
                    Object objEmit = flowCollector.emit(new NotificationScreenUiState.Success(Notification.copy$default(notification, null, null, null, arrayList, false, false, 0L, 119, null), false, null, 6, null), continuation);
                    return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
                }
            }, (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationViewModel$uiState$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: NotificationViewModel.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/Notification;", "exception", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationViewModel$uiState$1$1", f = "NotificationViewModel.kt", i = {0}, l = {105}, m = "invokeSuspend", n = {"exception"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function3<FlowCollector<? super Notification>, Throwable, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ NotificationViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(NotificationViewModel notificationViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(3, continuation);
            this.this$0 = notificationViewModel;
        }

        public final Object invoke(FlowCollector<? super Notification> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = th;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Throwable th = (Throwable) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.L$0 = th;
                this.label = 1;
                if (this.this$0._uiEvent.emit(new NotificationScreenEventState.ErrorEvent(R.string.notification_load_error), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Log.e("NotificationViewModel", "Failed to load notification.", th);
            return Unit.INSTANCE;
        }
    }
}
