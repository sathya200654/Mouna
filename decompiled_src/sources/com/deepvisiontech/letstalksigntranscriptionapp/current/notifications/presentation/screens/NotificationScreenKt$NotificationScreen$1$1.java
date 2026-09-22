package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens;

import android.content.Context;
import androidx.compose.material3.SnackbarDuration;
import androidx.compose.material3.SnackbarHostState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.viewmodels.NotificationScreenEventState;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;

/* JADX INFO: compiled from: NotificationScreen.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationScreenKt$NotificationScreen$1$1", f = "NotificationScreen.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {})
final class NotificationScreenKt$NotificationScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ SnackbarHostState $snackbarHostState;
    final /* synthetic */ SharedFlow<NotificationScreenEventState> $uiEvent;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    NotificationScreenKt$NotificationScreen$1$1(SharedFlow<? extends NotificationScreenEventState> sharedFlow, SnackbarHostState snackbarHostState, Context context, Continuation<? super NotificationScreenKt$NotificationScreen$1$1> continuation) {
        super(2, continuation);
        this.$uiEvent = sharedFlow;
        this.$snackbarHostState = snackbarHostState;
        this.$context = context;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NotificationScreenKt$NotificationScreen$1$1(this.$uiEvent, this.$snackbarHostState, this.$context, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.KotlinNothingValueException */
    public final Object invokeSuspend(Object obj) throws KotlinNothingValueException {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SharedFlow<NotificationScreenEventState> sharedFlow = this.$uiEvent;
            final SnackbarHostState snackbarHostState = this.$snackbarHostState;
            final Context context = this.$context;
            this.label = 1;
            if (sharedFlow.collect(new FlowCollector() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.NotificationScreenKt$NotificationScreen$1$1.1
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((NotificationScreenEventState) obj2, (Continuation<? super Unit>) continuation);
                }

                /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                public final Object emit(NotificationScreenEventState notificationScreenEventState, Continuation<? super Unit> continuation) throws NoWhenBranchMatchedException {
                    if (!(notificationScreenEventState instanceof NotificationScreenEventState.ErrorEvent)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    SnackbarHostState snackbarHostState2 = snackbarHostState;
                    String string = context.getString(((NotificationScreenEventState.ErrorEvent) notificationScreenEventState).getMessageResId());
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    Object objShowSnackbar$default = SnackbarHostState.showSnackbar$default(snackbarHostState2, string, (String) null, false, (SnackbarDuration) null, continuation, 14, (Object) null);
                    return objShowSnackbar$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objShowSnackbar$default : Unit.INSTANCE;
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
        throw new KotlinNothingValueException();
    }
}
