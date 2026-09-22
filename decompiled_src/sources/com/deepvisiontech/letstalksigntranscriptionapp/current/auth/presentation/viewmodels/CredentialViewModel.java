package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.usecase.FetchAndSaveMailIdUseCase;
import com.google.protobuf.DescriptorProtos;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: compiled from: CredentialViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/CredentialViewModel;", "Landroidx/lifecycle/ViewModel;", "fetchAndSaveMailIdUseCase", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/usecase/FetchAndSaveMailIdUseCase;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/usecase/FetchAndSaveMailIdUseCase;)V", "_uiEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/CredentialScreenUiEvent;", "uiEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "getUiEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "fetchAndSaveMailId", "", "context", "Landroid/content/Context;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CredentialViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableSharedFlow<CredentialScreenUiEvent> _uiEvent;
    private final FetchAndSaveMailIdUseCase fetchAndSaveMailIdUseCase;
    private final SharedFlow<CredentialScreenUiEvent> uiEvent;

    @Inject
    public CredentialViewModel(FetchAndSaveMailIdUseCase fetchAndSaveMailIdUseCase) {
        Intrinsics.checkNotNullParameter(fetchAndSaveMailIdUseCase, "fetchAndSaveMailIdUseCase");
        this.fetchAndSaveMailIdUseCase = fetchAndSaveMailIdUseCase;
        MutableSharedFlow<CredentialScreenUiEvent> mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this._uiEvent = mutableSharedFlowMutableSharedFlow$default;
        this.uiEvent = FlowKt.asSharedFlow(mutableSharedFlowMutableSharedFlow$default);
    }

    public final SharedFlow<CredentialScreenUiEvent> getUiEvent() {
        return this.uiEvent;
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.CredentialViewModel$fetchAndSaveMailId$1, reason: invalid class name */
    /* JADX INFO: compiled from: CredentialViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.CredentialViewModel$fetchAndSaveMailId$1", f = "CredentialViewModel.kt", i = {1, 2}, l = {32, DescriptorProtos.MethodOptions.IDEMPOTENCY_LEVEL_FIELD_NUMBER, 38}, m = "invokeSuspend", n = {"response", "response"}, s = {"L$0", "L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Context context, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$context = context;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CredentialViewModel.this.new AnonymousClass1(this.$context, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0069, code lost:
        
            if (r6.this$0._uiEvent.emit(new com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.CredentialScreenUiEvent.Error(com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.mappers.AppErrorMapperKt.toCredentialErrorMessageRes(((com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error) r7).getError())), (kotlin.coroutines.Continuation) r6) == r0) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x008f, code lost:
        
            if (r6.this$0._uiEvent.emit(com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.CredentialScreenUiEvent.NavigateToNextScreen.INSTANCE, (kotlin.coroutines.Continuation) r6) == r0) goto L26;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) throws kotlin.NoWhenBranchMatchedException {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L27
                if (r1 == r4) goto L23
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                goto L1a
            L12:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L1a:
                java.lang.Object r6 = r6.L$0
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource r6 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource) r6
                kotlin.ResultKt.throwOnFailure(r7)
                goto L98
            L23:
                kotlin.ResultKt.throwOnFailure(r7)
                goto L3e
            L27:
                kotlin.ResultKt.throwOnFailure(r7)
                com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.CredentialViewModel r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.CredentialViewModel.this
                com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.usecase.FetchAndSaveMailIdUseCase r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.CredentialViewModel.access$getFetchAndSaveMailIdUseCase$p(r7)
                android.content.Context r1 = r6.$context
                r5 = r6
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                r6.label = r4
                java.lang.Object r7 = r7.invoke(r1, r5)
                if (r7 != r0) goto L3e
                goto L91
            L3e:
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource r7 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource) r7
                boolean r1 = r7 instanceof com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error
                if (r1 == 0) goto L6c
                com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.CredentialViewModel r1 = com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.CredentialViewModel.this
                kotlinx.coroutines.flow.MutableSharedFlow r1 = com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.CredentialViewModel.access$get_uiEvent$p(r1)
                com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.CredentialScreenUiEvent$Error r2 = new com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.CredentialScreenUiEvent$Error
                r4 = r7
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Error r4 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error) r4
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError r4 = r4.getError()
                int r4 = com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.mappers.AppErrorMapperKt.toCredentialErrorMessageRes(r4)
                r2.<init>(r4)
                r4 = r6
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
                r6.L$0 = r7
                r6.label = r3
                java.lang.Object r6 = r1.emit(r2, r4)
                if (r6 != r0) goto L98
                goto L91
            L6c:
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Loading r1 = com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Loading.INSTANCE
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r1)
                if (r1 != 0) goto L98
                boolean r1 = r7 instanceof com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Success
                if (r1 == 0) goto L92
                com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.CredentialViewModel r1 = com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.CredentialViewModel.this
                kotlinx.coroutines.flow.MutableSharedFlow r1 = com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.CredentialViewModel.access$get_uiEvent$p(r1)
                com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.CredentialScreenUiEvent$NavigateToNextScreen r3 = com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.CredentialScreenUiEvent.NavigateToNextScreen.INSTANCE
                r4 = r6
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
                r6.L$0 = r7
                r6.label = r2
                java.lang.Object r6 = r1.emit(r3, r4)
                if (r6 != r0) goto L98
            L91:
                return r0
            L92:
                kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
                r6.<init>()
                throw r6
            L98:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.CredentialViewModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void fetchAndSaveMailId(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(context, null), 3, (Object) null);
    }
}
