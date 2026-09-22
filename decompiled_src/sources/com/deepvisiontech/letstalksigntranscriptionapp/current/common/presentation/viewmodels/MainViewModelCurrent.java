package com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.viewmodels;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.usecase.LogOutAndClearMailIdUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.usecase.ShowShareAppDialogUseCase;
import com.google.protobuf.DescriptorProtos;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: MainViewModelCurrent.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/presentation/viewmodels/MainViewModelCurrent;", "Landroidx/lifecycle/ViewModel;", "showShareAppDialogUseCase", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/engagement/domain/usecase/ShowShareAppDialogUseCase;", "engagementRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/engagement/domain/repository/EngagementRepository;", "logOutAndClearMailIdUseCase", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/usecase/LogOutAndClearMailIdUseCase;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/engagement/domain/usecase/ShowShareAppDialogUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/engagement/domain/repository/EngagementRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/usecase/LogOutAndClearMailIdUseCase;)V", "_showShareAppDialog", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "showShareAppDialog", "Lkotlinx/coroutines/flow/StateFlow;", "getShowShareAppDialog", "()Lkotlinx/coroutines/flow/StateFlow;", "shareAppDialogDismissed", "", "shareAppDialogShared", "logout", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MainViewModelCurrent extends ViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<Boolean> _showShareAppDialog;
    private final EngagementRepository engagementRepository;
    private final LogOutAndClearMailIdUseCase logOutAndClearMailIdUseCase;
    private final StateFlow<Boolean> showShareAppDialog;
    private final ShowShareAppDialogUseCase showShareAppDialogUseCase;

    @Inject
    public MainViewModelCurrent(ShowShareAppDialogUseCase showShareAppDialogUseCase, EngagementRepository engagementRepository, LogOutAndClearMailIdUseCase logOutAndClearMailIdUseCase) {
        Intrinsics.checkNotNullParameter(showShareAppDialogUseCase, "showShareAppDialogUseCase");
        Intrinsics.checkNotNullParameter(engagementRepository, "engagementRepository");
        Intrinsics.checkNotNullParameter(logOutAndClearMailIdUseCase, "logOutAndClearMailIdUseCase");
        this.showShareAppDialogUseCase = showShareAppDialogUseCase;
        this.engagementRepository = engagementRepository;
        this.logOutAndClearMailIdUseCase = logOutAndClearMailIdUseCase;
        StateFlow<Boolean> stateFlowMutableStateFlow = StateFlowKt.MutableStateFlow(false);
        this._showShareAppDialog = stateFlowMutableStateFlow;
        this.showShareAppDialog = stateFlowMutableStateFlow;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(null), 3, (Object) null);
    }

    public final StateFlow<Boolean> getShowShareAppDialog() {
        return this.showShareAppDialog;
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.viewmodels.MainViewModelCurrent$1, reason: invalid class name */
    /* JADX INFO: compiled from: MainViewModelCurrent.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.viewmodels.MainViewModelCurrent$1", f = "MainViewModelCurrent.kt", i = {}, l = {29}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModelCurrent.this.new AnonymousClass1(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<Boolean> flowInvoke = MainViewModelCurrent.this.showShareAppDialogUseCase.invoke();
                final MainViewModelCurrent mainViewModelCurrent = MainViewModelCurrent.this;
                this.label = 1;
                if (flowInvoke.collect(new FlowCollector() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.viewmodels.MainViewModelCurrent.1.1
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit(((Boolean) obj2).booleanValue(), (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                        mainViewModelCurrent._showShareAppDialog.setValue(Boxing.boxBoolean(z));
                        return Unit.INSTANCE;
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
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.viewmodels.MainViewModelCurrent$shareAppDialogDismissed$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MainViewModelCurrent.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.viewmodels.MainViewModelCurrent$shareAppDialogDismissed$1", f = "MainViewModelCurrent.kt", i = {}, l = {DescriptorProtos.FileOptions.CSHARP_NAMESPACE_FIELD_NUMBER, 38, DescriptorProtos.FileOptions.SWIFT_PREFIX_FIELD_NUMBER}, m = "invokeSuspend", n = {}, s = {})
    static final class C01971 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C01971(Continuation<? super C01971> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModelCurrent.this.new C01971(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0064, code lost:
        
            if (r6.this$0.engagementRepository.incrementShareAppDialogDismissCount((kotlin.coroutines.Continuation) r6) == r0) goto L20;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L25
                if (r1 == r4) goto L21
                if (r1 == r3) goto L1d
                if (r1 != r2) goto L15
                kotlin.ResultKt.throwOnFailure(r7)
                goto L67
            L15:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L1d:
                kotlin.ResultKt.throwOnFailure(r7)
                goto L55
            L21:
                kotlin.ResultKt.throwOnFailure(r7)
                goto L43
            L25:
                kotlin.ResultKt.throwOnFailure(r7)
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.viewmodels.MainViewModelCurrent r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.viewmodels.MainViewModelCurrent.this
                com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.viewmodels.MainViewModelCurrent.access$getEngagementRepository$p(r7)
                java.time.LocalDate r1 = java.time.LocalDate.now()
                java.lang.String r5 = "now(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)
                r5 = r6
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                r6.label = r4
                java.lang.Object r7 = r7.setShareAppDialogLastUsageDate(r1, r5)
                if (r7 != r0) goto L43
                goto L66
            L43:
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.viewmodels.MainViewModelCurrent r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.viewmodels.MainViewModelCurrent.this
                com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.viewmodels.MainViewModelCurrent.access$getEngagementRepository$p(r7)
                r1 = r6
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r6.label = r3
                java.lang.Object r7 = r7.incrementShareAppDialogUsageCount(r1)
                if (r7 != r0) goto L55
                goto L66
            L55:
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.viewmodels.MainViewModelCurrent r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.viewmodels.MainViewModelCurrent.this
                com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.viewmodels.MainViewModelCurrent.access$getEngagementRepository$p(r7)
                r1 = r6
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r6.label = r2
                java.lang.Object r6 = r7.incrementShareAppDialogDismissCount(r1)
                if (r6 != r0) goto L67
            L66:
                return r0
            L67:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.viewmodels.MainViewModelCurrent.C01971.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void shareAppDialogDismissed() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new C01971(null), 3, (Object) null);
        this._showShareAppDialog.setValue(false);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.viewmodels.MainViewModelCurrent$shareAppDialogShared$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MainViewModelCurrent.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.viewmodels.MainViewModelCurrent$shareAppDialogShared$1", f = "MainViewModelCurrent.kt", i = {}, l = {46, 47, 48}, m = "invokeSuspend", n = {}, s = {})
    static final class C01981 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C01981(Continuation<? super C01981> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModelCurrent.this.new C01981(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0064, code lost:
        
            if (r6.this$0.engagementRepository.incrementShareAppDialogShareCount((kotlin.coroutines.Continuation) r6) == r0) goto L20;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L25
                if (r1 == r4) goto L21
                if (r1 == r3) goto L1d
                if (r1 != r2) goto L15
                kotlin.ResultKt.throwOnFailure(r7)
                goto L67
            L15:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L1d:
                kotlin.ResultKt.throwOnFailure(r7)
                goto L55
            L21:
                kotlin.ResultKt.throwOnFailure(r7)
                goto L43
            L25:
                kotlin.ResultKt.throwOnFailure(r7)
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.viewmodels.MainViewModelCurrent r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.viewmodels.MainViewModelCurrent.this
                com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.viewmodels.MainViewModelCurrent.access$getEngagementRepository$p(r7)
                java.time.LocalDate r1 = java.time.LocalDate.now()
                java.lang.String r5 = "now(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)
                r5 = r6
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                r6.label = r4
                java.lang.Object r7 = r7.setShareAppDialogLastUsageDate(r1, r5)
                if (r7 != r0) goto L43
                goto L66
            L43:
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.viewmodels.MainViewModelCurrent r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.viewmodels.MainViewModelCurrent.this
                com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.viewmodels.MainViewModelCurrent.access$getEngagementRepository$p(r7)
                r1 = r6
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r6.label = r3
                java.lang.Object r7 = r7.incrementShareAppDialogUsageCount(r1)
                if (r7 != r0) goto L55
                goto L66
            L55:
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.viewmodels.MainViewModelCurrent r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.viewmodels.MainViewModelCurrent.this
                com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.viewmodels.MainViewModelCurrent.access$getEngagementRepository$p(r7)
                r1 = r6
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r6.label = r2
                java.lang.Object r6 = r7.incrementShareAppDialogShareCount(r1)
                if (r6 != r0) goto L67
            L66:
                return r0
            L67:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.viewmodels.MainViewModelCurrent.C01981.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void shareAppDialogShared() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new C01981(null), 3, (Object) null);
        this._showShareAppDialog.setValue(false);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.viewmodels.MainViewModelCurrent$logout$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MainViewModelCurrent.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.viewmodels.MainViewModelCurrent$logout$1", f = "MainViewModelCurrent.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
    static final class C01961 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C01961(Continuation<? super C01961> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModelCurrent.this.new C01961(continuation);
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
                if (MainViewModelCurrent.this.logOutAndClearMailIdUseCase.invoke((Continuation) this) == coroutine_suspended) {
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

    public final void logout() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new C01961(null), 3, (Object) null);
    }
}
