package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversation;

import android.util.Log;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.Conversation;
import com.fasterxml.jackson.core.internal.shaded.fdp.v2_18_4_1.FastDoubleMath;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: GetActiveOrNewConversationUseCase.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/Conversation;", "e", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversation.GetActiveOrNewConversationUseCase$invoke$2$2", f = "GetActiveOrNewConversationUseCase.kt", i = {0, 0}, l = {FastDoubleMath.DOUBLE_SIGNIFICAND_WIDTH}, m = "invokeSuspend", n = {"$this$catch", "e"}, s = {"L$0", "L$1"})
final class GetActiveOrNewConversationUseCase$invoke$2$2 extends SuspendLambda implements Function3<FlowCollector<? super Conversation>, Throwable, Continuation<? super Unit>, Object> {
    final /* synthetic */ Long $id;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GetActiveOrNewConversationUseCase$invoke$2$2(Long l, Continuation<? super GetActiveOrNewConversationUseCase$invoke$2$2> continuation) {
        super(3, continuation);
        this.$id = l;
    }

    public final Object invoke(FlowCollector<? super Conversation> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        GetActiveOrNewConversationUseCase$invoke$2$2 getActiveOrNewConversationUseCase$invoke$2$2 = new GetActiveOrNewConversationUseCase$invoke$2$2(this.$id, continuation);
        getActiveOrNewConversationUseCase$invoke$2$2.L$0 = flowCollector;
        getActiveOrNewConversationUseCase$invoke$2$2.L$1 = th;
        return getActiveOrNewConversationUseCase$invoke$2$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector = (FlowCollector) this.L$0;
        Throwable th = (Throwable) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Log.e("GetActiveOrNewConversationUseCase", "Failed to fetch conversation for ID " + this.$id, th);
            this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
            this.L$1 = SpillingKt.nullOutSpilledVariable(th);
            this.label = 1;
            if (flowCollector.emit((Object) null, (Continuation) this) == coroutine_suspended) {
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
