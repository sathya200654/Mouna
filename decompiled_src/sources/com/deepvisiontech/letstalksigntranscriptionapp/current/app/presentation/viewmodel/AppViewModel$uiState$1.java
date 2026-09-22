package com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel;

import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.domain.model.EnvironmentSound;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: AppViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/domain/model/EnvironmentSound;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel.AppViewModel$uiState$1", f = "AppViewModel.kt", i = {0}, l = {58}, m = "invokeSuspend", n = {"$this$onStart"}, s = {"L$0"})
final class AppViewModel$uiState$1 extends SuspendLambda implements Function2<FlowCollector<? super EnvironmentSound>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    AppViewModel$uiState$1(Continuation<? super AppViewModel$uiState$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> appViewModel$uiState$1 = new AppViewModel$uiState$1(continuation);
        appViewModel$uiState$1.L$0 = obj;
        return appViewModel$uiState$1;
    }

    public final Object invoke(FlowCollector<? super EnvironmentSound> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector = (FlowCollector) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
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
