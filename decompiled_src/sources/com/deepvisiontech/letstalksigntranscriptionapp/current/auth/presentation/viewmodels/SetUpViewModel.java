package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.usecase.LoginAndSaveTokenUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.usecase.SetEnvironmentRecognizerStateUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.notificationintent.domain.repository.NotificationIntentManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: SetUpViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001bJ\u0006\u0010\u001f\u001a\u00020\u001dJ\u0006\u0010 \u001a\u00020\u001dJ\b\u0010!\u001a\u00020\u001dH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/SetUpViewModel;", "Landroidx/lifecycle/ViewModel;", "loginAndSaveTokenUseCase", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/usecase/LoginAndSaveTokenUseCase;", "notificationIntentManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/notificationintent/domain/repository/NotificationIntentManager;", "setEnvironmentRecognizerStateUseCase", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/usecase/SetEnvironmentRecognizerStateUseCase;", "engagementRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/engagement/domain/repository/EngagementRepository;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/usecase/LoginAndSaveTokenUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/notificationintent/domain/repository/NotificationIntentManager;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/usecase/SetEnvironmentRecognizerStateUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/engagement/domain/repository/EngagementRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/SetUpScreenUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "_events", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/SetUpScreenEvent;", "events", "Lkotlinx/coroutines/flow/SharedFlow;", "getEvents", "()Lkotlinx/coroutines/flow/SharedFlow;", "isOnBoardingShown", "", "onPermissionResult", "", "isGranted", "onSkipPermission", "onRetry", "determineUserFlow", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SetUpViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableSharedFlow<SetUpScreenEvent> _events;
    private final MutableStateFlow<SetUpScreenUiState> _uiState;
    private final EngagementRepository engagementRepository;
    private final SharedFlow<SetUpScreenEvent> events;
    private final StateFlow<Boolean> isOnBoardingShown;
    private final LoginAndSaveTokenUseCase loginAndSaveTokenUseCase;
    private final NotificationIntentManager notificationIntentManager;
    private final SetEnvironmentRecognizerStateUseCase setEnvironmentRecognizerStateUseCase;
    private final StateFlow<SetUpScreenUiState> uiState;

    @Inject
    public SetUpViewModel(LoginAndSaveTokenUseCase loginAndSaveTokenUseCase, NotificationIntentManager notificationIntentManager, SetEnvironmentRecognizerStateUseCase setEnvironmentRecognizerStateUseCase, EngagementRepository engagementRepository) {
        Intrinsics.checkNotNullParameter(loginAndSaveTokenUseCase, "loginAndSaveTokenUseCase");
        Intrinsics.checkNotNullParameter(notificationIntentManager, "notificationIntentManager");
        Intrinsics.checkNotNullParameter(setEnvironmentRecognizerStateUseCase, "setEnvironmentRecognizerStateUseCase");
        Intrinsics.checkNotNullParameter(engagementRepository, "engagementRepository");
        this.loginAndSaveTokenUseCase = loginAndSaveTokenUseCase;
        this.notificationIntentManager = notificationIntentManager;
        this.setEnvironmentRecognizerStateUseCase = setEnvironmentRecognizerStateUseCase;
        this.engagementRepository = engagementRepository;
        MutableStateFlow<SetUpScreenUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(SetUpScreenUiState.IsLoading.INSTANCE);
        this._uiState = MutableStateFlow;
        this.uiState = FlowKt.asStateFlow(MutableStateFlow);
        MutableSharedFlow<SetUpScreenEvent> mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 1, (BufferOverflow) null, 5, (Object) null);
        this._events = mutableSharedFlowMutableSharedFlow$default;
        this.events = FlowKt.asSharedFlow(mutableSharedFlowMutableSharedFlow$default);
        SetUpViewModel setUpViewModel = this;
        this.isOnBoardingShown = FlowKt.stateIn(engagementRepository.getOnBoardingShownState(), ViewModelKt.getViewModelScope(setUpViewModel), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 5000L, 0L, 2, (Object) null), (Object) null);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(setUpViewModel), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(null), 3, (Object) null);
    }

    public final StateFlow<SetUpScreenUiState> getUiState() {
        return this.uiState;
    }

    public final SharedFlow<SetUpScreenEvent> getEvents() {
        return this.events;
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.SetUpViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: SetUpViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.SetUpViewModel$1", f = "SetUpViewModel.kt", i = {}, l = {64}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SetUpViewModel.this.new AnonymousClass1(continuation);
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
                obj = FlowKt.first(FlowKt.filterNotNull(SetUpViewModel.this.engagementRepository.isEnvSoundRecognitionStateSubmitted()), (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (((Boolean) obj).booleanValue()) {
                SetUpViewModel.this.determineUserFlow();
            } else {
                SetUpViewModel.this._uiState.setValue(SetUpScreenUiState.PromptEnvironmentRecognition.INSTANCE);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.SetUpViewModel$onPermissionResult$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SetUpViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.SetUpViewModel$onPermissionResult$1", f = "SetUpViewModel.kt", i = {}, l = {77, 78}, m = "invokeSuspend", n = {}, s = {})
    static final class C01861 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isGranted;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01861(boolean z, Continuation<? super C01861> continuation) {
            super(2, continuation);
            this.$isGranted = z;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SetUpViewModel.this.new C01861(this.$isGranted, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0044, code lost:
        
            if (r5.this$0.engagementRepository.setEnvSoundRecognitionSubmittedState(true, (kotlin.coroutines.Continuation) r5) == r0) goto L15;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.throwOnFailure(r6)
                goto L47
            L12:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L1a:
                kotlin.ResultKt.throwOnFailure(r6)
                goto L35
            L1e:
                kotlin.ResultKt.throwOnFailure(r6)
                com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.SetUpViewModel r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.SetUpViewModel.this
                com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.usecase.SetEnvironmentRecognizerStateUseCase r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.SetUpViewModel.access$getSetEnvironmentRecognizerStateUseCase$p(r6)
                boolean r1 = r5.$isGranted
                r4 = r5
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                r5.label = r3
                java.lang.Object r6 = r6.invoke(r1, r4)
                if (r6 != r0) goto L35
                goto L46
            L35:
                com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.SetUpViewModel r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.SetUpViewModel.this
                com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.SetUpViewModel.access$getEngagementRepository$p(r6)
                r1 = r5
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r5.label = r2
                java.lang.Object r5 = r6.setEnvSoundRecognitionSubmittedState(r3, r1)
                if (r5 != r0) goto L47
            L46:
                return r0
            L47:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.SetUpViewModel.C01861.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void onPermissionResult(boolean isGranted) {
        this._uiState.setValue(SetUpScreenUiState.IsLoading.INSTANCE);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new C01861(isGranted, null), 3, (Object) null);
        determineUserFlow();
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.SetUpViewModel$onSkipPermission$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SetUpViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.SetUpViewModel$onSkipPermission$1", f = "SetUpViewModel.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
    static final class C01871 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C01871(Continuation<? super C01871> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SetUpViewModel.this.new C01871(continuation);
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
                if (SetUpViewModel.this.engagementRepository.setEnvSoundRecognitionSubmittedState(true, (Continuation) this) == coroutine_suspended) {
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

    public final void onSkipPermission() {
        this._uiState.setValue(SetUpScreenUiState.IsLoading.INSTANCE);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new C01871(null), 3, (Object) null);
        determineUserFlow();
    }

    public final void onRetry() {
        this._uiState.setValue(SetUpScreenUiState.IsLoading.INSTANCE);
        determineUserFlow();
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.SetUpViewModel$determineUserFlow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SetUpViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.SetUpViewModel$determineUserFlow$1", f = "SetUpViewModel.kt", i = {1, 2, 2, 2, 3, 3, 3, 4, 4}, l = {98, 104, 109, 112, 115}, m = "invokeSuspend", n = {"response", "response", "pendingNotificationId", "onBoardingShown", "response", "pendingNotificationId", "onBoardingShown", "response", "onBoardingShown"}, s = {"L$0", "L$0", "L$1", "Z$0", "L$0", "L$1", "Z$0", "L$0", "Z$0"})
    static final class C01851 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;

        C01851(Continuation<? super C01851> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SetUpViewModel.this.new C01851(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
        /* JADX WARN: Code duplicated, block: B:30:0x00a8  */
        /* JADX WARN: Code duplicated, block: B:32:0x00ba  */
        /* JADX WARN: Code duplicated, block: B:36:0x00e9  */
        /* JADX WARN: Code duplicated, block: B:39:0x010b  */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00dc, code lost:
        
            if (r8.this$0._events.emit(new com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.SetUpScreenEvent.NavigateToNotification(r2), (kotlin.coroutines.Continuation) r8) == r0) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0108, code lost:
        
            if (r8.this$0._events.emit(com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.SetUpScreenEvent.NavigateToHome.INSTANCE, (kotlin.coroutines.Continuation) r8) == r0) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0124, code lost:
        
            if (r8.this$0._events.emit(com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.SetUpScreenEvent.NavigateToOnBoarding.INSTANCE, (kotlin.coroutines.Continuation) r8) == r0) goto L41;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) throws kotlin.NoWhenBranchMatchedException {
            /*
                Method dump skipped, instruction units count: 312
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.SetUpViewModel.C01851.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void determineUserFlow() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new C01851(null), 3, (Object) null);
    }
}
