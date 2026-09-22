package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.navigation.SavedStateHandleKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.media.MediaPlayerManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.media.MediaPlayerState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.WebViewManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPractice;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase.GetSignPracticeFlowUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase.TranslateAndInterpretSignPracticeUseCase;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.navigation.SignPracticeRoute;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: SignPracticeSessionViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0007\u0018\u0000 72\u00020\u0001:\u00017B9\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020%J\u0006\u0010-\u001a\u00020+J\u0006\u0010.\u001a\u00020+J\u0006\u0010/\u001a\u00020+J\u0006\u00100\u001a\u00020+J\u000e\u00101\u001a\u00020+2\u0006\u00102\u001a\u00020\u001bJ\u000e\u00103\u001a\u00020+2\u0006\u00104\u001a\u000205J\u0006\u00106\u001a\u00020+R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u0013¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)¨\u00068"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/viewmodels/SignPracticeSessionViewModel;", "Landroidx/lifecycle/ViewModel;", "getSignPracticeFlowUseCase", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/usecase/GetSignPracticeFlowUseCase;", "mediaPlayerManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/media/MediaPlayerManager;", "webViewManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/manager/WebViewManager;", "analyticsManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;", "translateAndInterpretSignPracticeUseCase", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/usecase/TranslateAndInterpretSignPracticeUseCase;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/usecase/GetSignPracticeFlowUseCase;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/media/MediaPlayerManager;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/manager/WebViewManager;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/usecase/TranslateAndInterpretSignPracticeUseCase;Landroidx/lifecycle/SavedStateHandle;)V", "_navigationArgs", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/navigation/SignPracticeRoute$SignPracticeSessionScreen;", "_mediaPlayerState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/media/MediaPlayerState;", "_webViewState", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/manager/WebViewState;", "_isTranslatingSignPractice", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_signPracticeId", "", "_uiEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/viewmodels/SignPracticeSessionEventState;", "uiEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "getUiEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "signPracticeFlow", "Lkotlinx/coroutines/flow/Flow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPractice;", "uiState", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/presentation/viewmodels/SignPracticeSessionUiState;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "sendSignPracticeToWebView", "", "signPractice", "resetWebView", "stopInterpretation", "play", "pause", "seekTo", "positionMs", "setPlayBackSpeed", "speed", "", "stopPlayBack", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SignPracticeSessionViewModel extends ViewModel {
    private static final String TAG = "SignPracticeSessionViewModel";
    private final MutableStateFlow<Boolean> _isTranslatingSignPractice;
    private final StateFlow<MediaPlayerState> _mediaPlayerState;
    private final SignPracticeRoute.SignPracticeSessionScreen _navigationArgs;
    private final long _signPracticeId;
    private final MutableSharedFlow<SignPracticeSessionEventState> _uiEvent;
    private final StateFlow<WebViewState> _webViewState;
    private final AnalyticsManager analyticsManager;
    private final MediaPlayerManager mediaPlayerManager;
    private final Flow<SignPractice> signPracticeFlow;
    private final TranslateAndInterpretSignPracticeUseCase translateAndInterpretSignPracticeUseCase;
    private final SharedFlow<SignPracticeSessionEventState> uiEvent;
    private final StateFlow<SignPracticeSessionUiState> uiState;
    private final WebViewManager webViewManager;
    public static final int $stable = 8;

    @Inject
    public SignPracticeSessionViewModel(GetSignPracticeFlowUseCase getSignPracticeFlowUseCase, MediaPlayerManager mediaPlayerManager, WebViewManager webViewManager, AnalyticsManager analyticsManager, TranslateAndInterpretSignPracticeUseCase translateAndInterpretSignPracticeUseCase, SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(getSignPracticeFlowUseCase, "getSignPracticeFlowUseCase");
        Intrinsics.checkNotNullParameter(mediaPlayerManager, "mediaPlayerManager");
        Intrinsics.checkNotNullParameter(webViewManager, "webViewManager");
        Intrinsics.checkNotNullParameter(analyticsManager, "analyticsManager");
        Intrinsics.checkNotNullParameter(translateAndInterpretSignPracticeUseCase, "translateAndInterpretSignPracticeUseCase");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        this.mediaPlayerManager = mediaPlayerManager;
        this.webViewManager = webViewManager;
        this.analyticsManager = analyticsManager;
        this.translateAndInterpretSignPracticeUseCase = translateAndInterpretSignPracticeUseCase;
        SignPracticeRoute.SignPracticeSessionScreen signPracticeSessionScreen = (SignPracticeRoute.SignPracticeSessionScreen) SavedStateHandleKt.toRoute(savedStateHandle, Reflection.getOrCreateKotlinClass(SignPracticeRoute.SignPracticeSessionScreen.class), MapsKt.emptyMap());
        this._navigationArgs = signPracticeSessionScreen;
        Flow mediaPlayerState = mediaPlayerManager.getMediaPlayerState();
        this._mediaPlayerState = mediaPlayerState;
        Flow webViewState = webViewManager.getWebViewState();
        this._webViewState = webViewState;
        Flow flowMutableStateFlow = StateFlowKt.MutableStateFlow(false);
        this._isTranslatingSignPractice = flowMutableStateFlow;
        this._signPracticeId = signPracticeSessionScreen.getSignPracticeId();
        MutableSharedFlow<SignPracticeSessionEventState> mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this._uiEvent = mutableSharedFlowMutableSharedFlow$default;
        this.uiEvent = FlowKt.asSharedFlow(mutableSharedFlowMutableSharedFlow$default);
        Flow<SignPractice> flow = FlowKt.flow(new SignPracticeSessionViewModel$signPracticeFlow$1(getSignPracticeFlowUseCase, this, null));
        this.signPracticeFlow = flow;
        this.uiState = FlowKt.stateIn(FlowKt.catch(FlowKt.combine(mediaPlayerState, flow, webViewState, flowMutableStateFlow, new SignPracticeSessionViewModel$uiState$1(null)), new SignPracticeSessionViewModel$uiState$2(this, null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 5000L, 0L, 2, (Object) null), SignPracticeSessionUiState.Loading.INSTANCE);
    }

    public final SharedFlow<SignPracticeSessionEventState> getUiEvent() {
        return this.uiEvent;
    }

    public final StateFlow<SignPracticeSessionUiState> getUiState() {
        return this.uiState;
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeSessionViewModel$sendSignPracticeToWebView$1, reason: invalid class name */
    /* JADX INFO: compiled from: SignPracticeSessionViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeSessionViewModel$sendSignPracticeToWebView$1", f = "SignPracticeSessionViewModel.kt", i = {1}, l = {110, 112}, m = "invokeSuspend", n = {"response"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SignPractice $signPractice;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SignPractice signPractice, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$signPractice = signPractice;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SignPracticeSessionViewModel.this.new AnonymousClass1(this.$signPractice, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x007b, code lost:
        
            if (r6.this$0._uiEvent.emit(new com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeSessionEventState.ErrorEvent(com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.mappers.AppErrorMapperKt.toSignPracticeErrorMessageRes(((com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error) r7).getError())), (kotlin.coroutines.Continuation) r6) == r0) goto L23;
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
                r2 = 2
                r3 = 0
                r4 = 1
                if (r1 == 0) goto L27
                if (r1 == r4) goto L20
                if (r1 != r2) goto L18
                java.lang.Object r0 = r6.L$0
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource r0 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource) r0
                kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L24
                goto L9e
            L18:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L20:
                kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L24
                goto L50
            L24:
                r7 = move-exception
                goto Lae
            L27:
                kotlin.ResultKt.throwOnFailure(r7)
                com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeSessionViewModel r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeSessionViewModel.this     // Catch: java.lang.Throwable -> L24
                r7.pause()     // Catch: java.lang.Throwable -> L24
                com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeSessionViewModel r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeSessionViewModel.this     // Catch: java.lang.Throwable -> L24
                kotlinx.coroutines.flow.MutableStateFlow r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeSessionViewModel.access$get_isTranslatingSignPractice$p(r7)     // Catch: java.lang.Throwable -> L24
                java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)     // Catch: java.lang.Throwable -> L24
                r7.setValue(r1)     // Catch: java.lang.Throwable -> L24
                com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeSessionViewModel r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeSessionViewModel.this     // Catch: java.lang.Throwable -> L24
                com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase.TranslateAndInterpretSignPracticeUseCase r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeSessionViewModel.access$getTranslateAndInterpretSignPracticeUseCase$p(r7)     // Catch: java.lang.Throwable -> L24
                com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPractice r1 = r6.$signPractice     // Catch: java.lang.Throwable -> L24
                r5 = r6
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch: java.lang.Throwable -> L24
                r6.label = r4     // Catch: java.lang.Throwable -> L24
                java.lang.Object r7 = r7.invoke(r1, r5)     // Catch: java.lang.Throwable -> L24
                if (r7 != r0) goto L50
                goto L7d
            L50:
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource r7 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource) r7     // Catch: java.lang.Throwable -> L24
                boolean r1 = r7 instanceof com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error     // Catch: java.lang.Throwable -> L24
                if (r1 == 0) goto L7e
                com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeSessionViewModel r1 = com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeSessionViewModel.this     // Catch: java.lang.Throwable -> L24
                kotlinx.coroutines.flow.MutableSharedFlow r1 = com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeSessionViewModel.access$get_uiEvent$p(r1)     // Catch: java.lang.Throwable -> L24
                com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeSessionEventState$ErrorEvent r4 = new com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeSessionEventState$ErrorEvent     // Catch: java.lang.Throwable -> L24
                r5 = r7
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Error r5 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error) r5     // Catch: java.lang.Throwable -> L24
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError r5 = r5.getError()     // Catch: java.lang.Throwable -> L24
                int r5 = com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.mappers.AppErrorMapperKt.toSignPracticeErrorMessageRes(r5)     // Catch: java.lang.Throwable -> L24
                r4.<init>(r5)     // Catch: java.lang.Throwable -> L24
                r5 = r6
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch: java.lang.Throwable -> L24
                java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)     // Catch: java.lang.Throwable -> L24
                r6.L$0 = r7     // Catch: java.lang.Throwable -> L24
                r6.label = r2     // Catch: java.lang.Throwable -> L24
                java.lang.Object r7 = r1.emit(r4, r5)     // Catch: java.lang.Throwable -> L24
                if (r7 != r0) goto L9e
            L7d:
                return r0
            L7e:
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Loading r0 = com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Loading.INSTANCE     // Catch: java.lang.Throwable -> L24
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r0)     // Catch: java.lang.Throwable -> L24
                if (r0 != 0) goto L9e
                boolean r7 = r7 instanceof com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Success     // Catch: java.lang.Throwable -> L24
                if (r7 == 0) goto L98
                com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeSessionViewModel r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeSessionViewModel.this     // Catch: java.lang.Throwable -> L24
                kotlinx.coroutines.flow.MutableStateFlow r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeSessionViewModel.access$get_isTranslatingSignPractice$p(r7)     // Catch: java.lang.Throwable -> L24
                java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)     // Catch: java.lang.Throwable -> L24
                r7.setValue(r0)     // Catch: java.lang.Throwable -> L24
                goto L9e
            L98:
                kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException     // Catch: java.lang.Throwable -> L24
                r7.<init>()     // Catch: java.lang.Throwable -> L24
                throw r7     // Catch: java.lang.Throwable -> L24
            L9e:
                com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeSessionViewModel r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeSessionViewModel.this
                kotlinx.coroutines.flow.MutableStateFlow r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeSessionViewModel.access$get_isTranslatingSignPractice$p(r6)
                java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
                r6.setValue(r7)
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            Lae:
                com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeSessionViewModel r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeSessionViewModel.this
                kotlinx.coroutines.flow.MutableStateFlow r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeSessionViewModel.access$get_isTranslatingSignPractice$p(r6)
                java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
                r6.setValue(r0)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeSessionViewModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void sendSignPracticeToWebView(SignPractice signPractice) {
        Intrinsics.checkNotNullParameter(signPractice, "signPractice");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(signPractice, null), 3, (Object) null);
    }

    public final void resetWebView() {
        this.webViewManager.resetToIdle();
    }

    public final void stopInterpretation() {
        this.webViewManager.stopInterpretationAndClearTranscripts();
    }

    public final void play() {
        this.analyticsManager.logEvent(AnalyticsEvent.SignPracticePlayed.INSTANCE);
        this.mediaPlayerManager.play();
    }

    public final void pause() {
        this.mediaPlayerManager.pause();
    }

    public final void seekTo(long positionMs) {
        this.mediaPlayerManager.seekTo(positionMs);
    }

    public final void setPlayBackSpeed(float speed) {
        this.mediaPlayerManager.setPlaybackSpeed(speed);
    }

    public final void stopPlayBack() {
        this.mediaPlayerManager.stop();
    }
}
