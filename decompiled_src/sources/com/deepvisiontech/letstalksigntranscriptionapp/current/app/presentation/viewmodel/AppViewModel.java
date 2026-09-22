package com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.app.domain.usecase.SendSoundEventsUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.usecase.LogOutAndClearMailIdUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.repository.SettingsRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.network.data.NetworkMonitor;
import com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.usecase.ShowShareAppDialogUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.repository.PersonaSurveyRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: AppViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001BA\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006\""}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/app/presentation/viewmodel/AppViewModel;", "Landroidx/lifecycle/ViewModel;", "personaSurveyRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/domain/repository/PersonaSurveyRepository;", "showShareAppDialogUseCase", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/engagement/domain/usecase/ShowShareAppDialogUseCase;", "sendSoundEventsUseCase", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/app/domain/usecase/SendSoundEventsUseCase;", "settingsRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/repository/SettingsRepository;", "engagementRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/engagement/domain/repository/EngagementRepository;", "logOutAndClearMailIdUseCase", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/usecase/LogOutAndClearMailIdUseCase;", "networkMonitor", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/network/data/NetworkMonitor;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/domain/repository/PersonaSurveyRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/engagement/domain/usecase/ShowShareAppDialogUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/app/domain/usecase/SendSoundEventsUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/repository/SettingsRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/engagement/domain/repository/EngagementRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/usecase/LogOutAndClearMailIdUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/network/data/NetworkMonitor;)V", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/app/presentation/viewmodel/AppUiState;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "_events", "Lkotlinx/coroutines/channels/Channel;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/app/presentation/viewmodel/AppEvent;", "events", "Lkotlinx/coroutines/flow/Flow;", "getEvents", "()Lkotlinx/coroutines/flow/Flow;", "onAction", "", "action", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/app/presentation/viewmodel/AppUiAction;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AppViewModel extends ViewModel {
    public static final int $stable = 8;
    private final Channel<AppEvent> _events;
    private final EngagementRepository engagementRepository;
    private final Flow<AppEvent> events;
    private final LogOutAndClearMailIdUseCase logOutAndClearMailIdUseCase;
    private final NetworkMonitor networkMonitor;
    private final StateFlow<AppUiState> uiState;

    @Inject
    public AppViewModel(PersonaSurveyRepository personaSurveyRepository, ShowShareAppDialogUseCase showShareAppDialogUseCase, SendSoundEventsUseCase sendSoundEventsUseCase, SettingsRepository settingsRepository, EngagementRepository engagementRepository, LogOutAndClearMailIdUseCase logOutAndClearMailIdUseCase, NetworkMonitor networkMonitor) {
        Intrinsics.checkNotNullParameter(personaSurveyRepository, "personaSurveyRepository");
        Intrinsics.checkNotNullParameter(showShareAppDialogUseCase, "showShareAppDialogUseCase");
        Intrinsics.checkNotNullParameter(sendSoundEventsUseCase, "sendSoundEventsUseCase");
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        Intrinsics.checkNotNullParameter(engagementRepository, "engagementRepository");
        Intrinsics.checkNotNullParameter(logOutAndClearMailIdUseCase, "logOutAndClearMailIdUseCase");
        Intrinsics.checkNotNullParameter(networkMonitor, "networkMonitor");
        this.engagementRepository = engagementRepository;
        this.logOutAndClearMailIdUseCase = logOutAndClearMailIdUseCase;
        this.networkMonitor = networkMonitor;
        Flow flowCombine = FlowKt.combine(showShareAppDialogUseCase.invoke(), personaSurveyRepository.getUserPersona(), FlowKt.onStart(sendSoundEventsUseCase.invoke(), new AppViewModel$uiState$1(null)), settingsRepository.isEnvSoundRecognizerEnabled(), new AppViewModel$uiState$2(null));
        AppViewModel appViewModel = this;
        this.uiState = FlowKt.stateIn(flowCombine, ViewModelKt.getViewModelScope(appViewModel), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 5000L, 0L, 2, (Object) null), new AppUiState(null, null, false, false, 15, null));
        ReceiveChannel receiveChannelChannel$default = ChannelKt.Channel$default(0, (BufferOverflow) null, (Function1) null, 7, (Object) null);
        this._events = receiveChannelChannel$default;
        this.events = FlowKt.receiveAsFlow(receiveChannelChannel$default);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(appViewModel), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(null), 3, (Object) null);
    }

    public final StateFlow<AppUiState> getUiState() {
        return this.uiState;
    }

    public final Flow<AppEvent> getEvents() {
        return this.events;
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel.AppViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: AppViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel.AppViewModel$1", f = "AppViewModel.kt", i = {}, l = {78}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AppViewModel.this.new AnonymousClass1(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<Boolean> flowIsConnected = AppViewModel.this.networkMonitor.isConnected();
                final AppViewModel appViewModel = AppViewModel.this;
                this.label = 1;
                if (flowIsConnected.collect(new FlowCollector() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel.AppViewModel.1.1
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit(((Boolean) obj2).booleanValue(), (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                        if (!z) {
                            Object objSend = appViewModel._events.send(AppEvent.NavigateToNoNetworkScreen.INSTANCE, continuation);
                            return objSend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSend : Unit.INSTANCE;
                        }
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

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel.AppViewModel$onAction$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AppViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel.AppViewModel$onAction$1", f = "AppViewModel.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
    static final class C01741 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C01741(Continuation<? super C01741> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AppViewModel.this.new C01741(continuation);
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
                if (AppViewModel.this.logOutAndClearMailIdUseCase.invoke((Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public final void onAction(AppUiAction action) throws NoWhenBranchMatchedException {
        Intrinsics.checkNotNullParameter(action, "action");
        if (Intrinsics.areEqual(action, AppUiAction.LogOut.INSTANCE)) {
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new C01741(null), 3, (Object) null);
        } else if (Intrinsics.areEqual(action, AppUiAction.OnShareAppDialogDismiss.INSTANCE)) {
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2(null), 3, (Object) null);
        } else {
            if (!Intrinsics.areEqual(action, AppUiAction.OnShareAppDialogShared.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass3(null), 3, (Object) null);
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel.AppViewModel$onAction$2, reason: invalid class name */
    /* JADX INFO: compiled from: AppViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel.AppViewModel$onAction$2", f = "AppViewModel.kt", i = {}, l = {93, 94, 95}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AppViewModel.this.new AnonymousClass2(continuation);
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
                com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel.AppViewModel r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel.AppViewModel.this
                com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel.AppViewModel.access$getEngagementRepository$p(r7)
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
                com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel.AppViewModel r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel.AppViewModel.this
                com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel.AppViewModel.access$getEngagementRepository$p(r7)
                r1 = r6
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r6.label = r3
                java.lang.Object r7 = r7.incrementShareAppDialogUsageCount(r1)
                if (r7 != r0) goto L55
                goto L66
            L55:
                com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel.AppViewModel r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel.AppViewModel.this
                com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel.AppViewModel.access$getEngagementRepository$p(r7)
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
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel.AppViewModel.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel.AppViewModel$onAction$3, reason: invalid class name */
    /* JADX INFO: compiled from: AppViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel.AppViewModel$onAction$3", f = "AppViewModel.kt", i = {}, l = {100, 101, 102}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AppViewModel.this.new AnonymousClass3(continuation);
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
                com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel.AppViewModel r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel.AppViewModel.this
                com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel.AppViewModel.access$getEngagementRepository$p(r7)
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
                com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel.AppViewModel r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel.AppViewModel.this
                com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel.AppViewModel.access$getEngagementRepository$p(r7)
                r1 = r6
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r6.label = r3
                java.lang.Object r7 = r7.incrementShareAppDialogUsageCount(r1)
                if (r7 != r0) goto L55
                goto L66
            L55:
                com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel.AppViewModel r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel.AppViewModel.this
                com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel.AppViewModel.access$getEngagementRepository$p(r7)
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
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.viewmodel.AppViewModel.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
