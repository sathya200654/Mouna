package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.usecase.SyncPendingPersonaDataUseCase;
import com.google.protobuf.DescriptorProtos;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: SplashScreenViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/SplashScreenViewModel;", "Landroidx/lifecycle/ViewModel;", "sessionRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;", "syncPendingPersonaDataUseCase", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/domain/usecase/SyncPendingPersonaDataUseCase;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/domain/usecase/SyncPendingPersonaDataUseCase;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/presentation/viewmodels/SplashScreenUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "mailIdState", "", "checkUserSession", "", "validateMailId", "", "mailId", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SplashScreenViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<SplashScreenUiState> _uiState;
    private final StateFlow<String> mailIdState;
    private final SessionRepository sessionRepository;
    private final SyncPendingPersonaDataUseCase syncPendingPersonaDataUseCase;
    private final StateFlow<SplashScreenUiState> uiState;

    @Inject
    public SplashScreenViewModel(SessionRepository sessionRepository, SyncPendingPersonaDataUseCase syncPendingPersonaDataUseCase) {
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(syncPendingPersonaDataUseCase, "syncPendingPersonaDataUseCase");
        this.sessionRepository = sessionRepository;
        this.syncPendingPersonaDataUseCase = syncPendingPersonaDataUseCase;
        MutableStateFlow<SplashScreenUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(SplashScreenUiState.Loading.INSTANCE);
        this._uiState = MutableStateFlow;
        this.uiState = FlowKt.asStateFlow(MutableStateFlow);
        SplashScreenViewModel splashScreenViewModel = this;
        this.mailIdState = FlowKt.stateIn(sessionRepository.getGmailId(), ViewModelKt.getViewModelScope(splashScreenViewModel), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 5000L, 0L, 2, (Object) null), (Object) null);
        checkUserSession();
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(splashScreenViewModel), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(null), 3, (Object) null);
    }

    public final StateFlow<SplashScreenUiState> getUiState() {
        return this.uiState;
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.SplashScreenViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: SplashScreenViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.SplashScreenViewModel$1", f = "SplashScreenViewModel.kt", i = {}, l = {DescriptorProtos.FileOptions.PHP_METADATA_NAMESPACE_FIELD_NUMBER}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SplashScreenViewModel.this.new AnonymousClass1(continuation);
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
                if (SplashScreenViewModel.this.syncPendingPersonaDataUseCase.invoke((Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.SplashScreenViewModel$checkUserSession$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SplashScreenViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.presentation.viewmodels.SplashScreenViewModel$checkUserSession$1", f = "SplashScreenViewModel.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {})
    static final class C01881 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C01881(Continuation<? super C01881> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SplashScreenViewModel.this.new C01881(continuation);
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
                obj = FlowKt.first(FlowKt.filterNotNull(SplashScreenViewModel.this.mailIdState), (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            SplashScreenViewModel splashScreenViewModel = SplashScreenViewModel.this;
            if (splashScreenViewModel.validateMailId((String) obj)) {
                splashScreenViewModel._uiState.setValue(SplashScreenUiState.NavigateToLoadingScreen.INSTANCE);
            } else {
                splashScreenViewModel._uiState.setValue(SplashScreenUiState.NavigateToCredentialScreen.INSTANCE);
            }
            return Unit.INSTANCE;
        }
    }

    private final void checkUserSession() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new C01881(null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean validateMailId(String mailId) {
        String str = mailId;
        return !StringsKt.isBlank(StringsKt.trim(str).toString()) && StringsKt.contains$default(str, "@gmail.com", false, 2, (Object) null);
    }
}
