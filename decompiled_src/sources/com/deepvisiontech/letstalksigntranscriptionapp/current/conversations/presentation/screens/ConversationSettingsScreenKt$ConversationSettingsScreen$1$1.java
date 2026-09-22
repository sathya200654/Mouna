package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens;

import android.content.Context;
import androidx.compose.material3.SnackbarDuration;
import androidx.compose.material3.SnackbarHostState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationSettingsEvent;
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

/* JADX INFO: compiled from: ConversationSettingsScreen.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationSettingsScreenKt$ConversationSettingsScreen$1$1", f = "ConversationSettingsScreen.kt", i = {}, l = {130}, m = "invokeSuspend", n = {}, s = {})
final class ConversationSettingsScreenKt$ConversationSettingsScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ SnackbarHostState $snackbarHostState;
    final /* synthetic */ SharedFlow<ConversationSettingsEvent> $uiEvent;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ConversationSettingsScreenKt$ConversationSettingsScreen$1$1(SharedFlow<? extends ConversationSettingsEvent> sharedFlow, SnackbarHostState snackbarHostState, Context context, Continuation<? super ConversationSettingsScreenKt$ConversationSettingsScreen$1$1> continuation) {
        super(2, continuation);
        this.$uiEvent = sharedFlow;
        this.$snackbarHostState = snackbarHostState;
        this.$context = context;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConversationSettingsScreenKt$ConversationSettingsScreen$1$1(this.$uiEvent, this.$snackbarHostState, this.$context, continuation);
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
            SharedFlow<ConversationSettingsEvent> sharedFlow = this.$uiEvent;
            final SnackbarHostState snackbarHostState = this.$snackbarHostState;
            final Context context = this.$context;
            this.label = 1;
            if (sharedFlow.collect(new FlowCollector() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationSettingsScreenKt$ConversationSettingsScreen$1$1.1
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((ConversationSettingsEvent) obj2, (Continuation<? super Unit>) continuation);
                }

                /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                public final Object emit(ConversationSettingsEvent conversationSettingsEvent, Continuation<? super Unit> continuation) throws NoWhenBranchMatchedException {
                    if (conversationSettingsEvent instanceof ConversationSettingsEvent.ShowErrorMessage) {
                        SnackbarHostState snackbarHostState2 = snackbarHostState;
                        String string = context.getString(((ConversationSettingsEvent.ShowErrorMessage) conversationSettingsEvent).getMessageRes());
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        Object objShowSnackbar$default = SnackbarHostState.showSnackbar$default(snackbarHostState2, string, (String) null, false, (SnackbarDuration) null, continuation, 14, (Object) null);
                        return objShowSnackbar$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objShowSnackbar$default : Unit.INSTANCE;
                    }
                    if (!(conversationSettingsEvent instanceof ConversationSettingsEvent.ShowInfoMessage)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    SnackbarHostState snackbarHostState3 = snackbarHostState;
                    String string2 = context.getString(((ConversationSettingsEvent.ShowInfoMessage) conversationSettingsEvent).getMessageRes());
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    Object objShowSnackbar$default2 = SnackbarHostState.showSnackbar$default(snackbarHostState3, string2, (String) null, true, (SnackbarDuration) null, continuation, 10, (Object) null);
                    return objShowSnackbar$default2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objShowSnackbar$default2 : Unit.INSTANCE;
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
