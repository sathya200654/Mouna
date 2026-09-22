package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels;

import android.util.Log;
import androidx.lifecycle.ViewModelKt;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: NotificationListViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/viewmodels/NotificationListScreenUiState;", "e", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationListViewModel$uiState$5", f = "NotificationListViewModel.kt", i = {0, 0}, l = {94}, m = "invokeSuspend", n = {"$this$catch", "e"}, s = {"L$0", "L$1"})
final class NotificationListViewModel$uiState$5 extends SuspendLambda implements Function3<FlowCollector<? super NotificationListScreenUiState>, Throwable, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ NotificationListViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NotificationListViewModel$uiState$5(NotificationListViewModel notificationListViewModel, Continuation<? super NotificationListViewModel$uiState$5> continuation) {
        super(3, continuation);
        this.this$0 = notificationListViewModel;
    }

    public final Object invoke(FlowCollector<? super NotificationListScreenUiState> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        NotificationListViewModel$uiState$5 notificationListViewModel$uiState$5 = new NotificationListViewModel$uiState$5(this.this$0, continuation);
        notificationListViewModel$uiState$5.L$0 = flowCollector;
        notificationListViewModel$uiState$5.L$1 = th;
        return notificationListViewModel$uiState$5.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector = (FlowCollector) this.L$0;
        Throwable th = (Throwable) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Log.e("NotificationListViewModel", "Failed to load notifications", th);
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this.this$0, null), 3, (Object) null);
            this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
            this.L$1 = SpillingKt.nullOutSpilledVariable(th);
            this.label = 1;
            if (flowCollector.emit(new NotificationListScreenUiState(null, false, false, null, null, null, th, 61, null), (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationListViewModel$uiState$5$1, reason: invalid class name */
    /* JADX INFO: compiled from: NotificationListViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationListViewModel$uiState$5$1", f = "NotificationListViewModel.kt", i = {}, l = {90}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ NotificationListViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(NotificationListViewModel notificationListViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = notificationListViewModel;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.this$0._uiEvent.emit(new NotificationListScreenEvent.ShowUserMessage(R.string.notification_load_error), (Continuation) this) == coroutine_suspended) {
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
    }
}
