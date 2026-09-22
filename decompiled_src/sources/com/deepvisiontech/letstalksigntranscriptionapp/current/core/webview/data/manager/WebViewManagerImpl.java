package com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.ConsoleMessage;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.webkit.WebViewAssetLoader;
import com.azure.core.util.tracing.Tracer;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.repository.SettingsRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.ConversationMessage;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.mappers.WebViewErrorMapper;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.webviewinterface.WebViewJavascriptInterface;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.JavascriptCallbackHandler;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.WebViewManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.model.InterpretationMode;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.model.InterpretationSpeed;
import com.google.firebase.messaging.Constants;
import dagger.hilt.android.qualifiers.ApplicationContext;
import java.util.List;
import java.util.concurrent.CancellationException;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: WebViewManagerImpl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Singleton
@Metadata(d1 = {"\u0000±\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b*\u00012\b\u0007\u0018\u0000 ]2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001]B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u00104\u001a\u000205H\u0016J\u0010\u00106\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\tH\u0003J\b\u00107\u001a\u000205H\u0002J\u0010\u00108\u001a\u0002052\u0006\u00109\u001a\u00020:H\u0002J\u0010\u0010;\u001a\u0002052\u0006\u0010<\u001a\u00020*H\u0002J\u0010\u0010=\u001a\u0002052\u0006\u0010>\u001a\u00020,H\u0002J\b\u0010?\u001a\u000205H\u0002J\b\u0010@\u001a\u000205H\u0002J\u0010\u0010A\u001a\u0002052\u0006\u0010B\u001a\u00020CH\u0002J\u0010\u0010D\u001a\u0002052\u0006\u0010E\u001a\u00020\u000fH\u0002J\u0010\u0010F\u001a\u00020\u000f2\u0006\u0010G\u001a\u00020\u000fH\u0002J\u0010\u0010H\u001a\u0002052\u0006\u0010B\u001a\u00020CH\u0016J\u0016\u0010I\u001a\u0002052\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u000f0.H\u0016J\b\u0010K\u001a\u000205H\u0016J\b\u0010L\u001a\u000205H\u0016J\u0010\u0010M\u001a\u0002052\u0006\u0010N\u001a\u00020OH\u0016J\b\u0010P\u001a\u000205H\u0016J\u0010\u0010Q\u001a\u0002052\u0006\u0010R\u001a\u00020SH\u0016J\u0010\u0010T\u001a\u0002052\u0006\u0010R\u001a\u00020SH\u0016J\u0010\u0010U\u001a\u0002052\u0006\u0010V\u001a\u00020\u000fH\u0016J\u0010\u0010W\u001a\u0002052\u0006\u0010X\u001a\u00020\u000fH\u0016J\n\u0010Y\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010Z\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010[\u001a\u000205H\u0016J\b\u0010\\\u001a\u000205H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\rR\u0010\u0010\b\u001a\u00020\t8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020$0&X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010-\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103¨\u0006^"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/manager/WebViewManagerImpl;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/manager/WebViewManager;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/manager/JavascriptCallbackHandler;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "settingsRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/repository/SettingsRepository;", "defaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "context", "Landroid/content/Context;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/repository/SettingsRepository;Lkotlinx/coroutines/CoroutineDispatcher;Landroid/content/Context;)V", "getDefaultDispatcher$annotations", "()V", "currentUrl", "", "value", "Landroid/webkit/WebView;", "webView", "getWebView", "()Landroid/webkit/WebView;", "job", "Lkotlinx/coroutines/CompletableJob;", Tracer.SCOPE_KEY, "Lkotlinx/coroutines/CoroutineScope;", "stuckTimerJob", "Lkotlinx/coroutines/Job;", "_webViewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/manager/WebViewState;", "webViewState", "Lkotlinx/coroutines/flow/StateFlow;", "getWebViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "_webViewEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/manager/WebViewEvent;", "webViewEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "getWebViewEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "latestSpeed", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/model/InterpretationSpeed;", "latestMode", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/model/InterpretationMode;", "pendingSentences", "", "connectivityManager", "Landroid/net/ConnectivityManager;", "networkCallback", "com/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/manager/WebViewManagerImpl$networkCallback$1", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/manager/WebViewManagerImpl$networkCallback$1;", "reload", "", "createWebView", "recreateWebView", "handleLoadError", "error", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/AppError;", "setInterpretationSpeed", "speed", "setInterpretationMode", "mode", "startAryaStuckTimer", "cancelAryaStuckTimerJob", "postInterpretMessageToWebView", "conversationMessage", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMessage;", "postSentenceToWebView", "sentence", "cleanString", "input", "sendConversationMessageToWebView", "sendSentenceListToWebView", "sentences", "stopInterpretationAndClearTranscripts", "stopInterpretation", "setWebViewVisibility", "isVisible", "", "resetToIdle", "onStop", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onDestroy", "handleJavascriptEvent", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "onMissingAnimation", "word", "getInterpretationModeKey", "getInterpretationSpeedKey", "onCloseAction", "restoreView", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class WebViewManagerImpl implements WebViewManager, JavascriptCallbackHandler, DefaultLifecycleObserver {
    private static final long ARYA_STUCK_TIMER_DURATION_MS = 20000;
    private final MutableSharedFlow<WebViewEvent> _webViewEvent;
    private final MutableStateFlow<WebViewState> _webViewState;
    private final ConnectivityManager connectivityManager;

    @ApplicationContext
    private final Context context;
    private final String currentUrl;
    private final CoroutineDispatcher defaultDispatcher;
    private final CompletableJob job;
    private InterpretationMode latestMode;
    private InterpretationSpeed latestSpeed;
    private final WebViewManagerImpl$networkCallback$1 networkCallback;
    private List<String> pendingSentences;
    private final CoroutineScope scope;
    private final SettingsRepository settingsRepository;
    private Job stuckTimerJob;
    private WebView webView;
    private final SharedFlow<WebViewEvent> webViewEvent;
    private final StateFlow<WebViewState> webViewState;
    public static final int $stable = 8;

    private static /* synthetic */ void getDefaultDispatcher$annotations() {
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.JavascriptCallbackHandler
    public void onMissingAnimation(String word) {
        Intrinsics.checkNotNullParameter(word, "word");
    }

    public void onCreate(LifecycleOwner lifecycleOwner) {
        super.onCreate(lifecycleOwner);
    }

    public void onPause(LifecycleOwner lifecycleOwner) {
        super.onPause(lifecycleOwner);
    }

    public void onResume(LifecycleOwner lifecycleOwner) {
        super.onResume(lifecycleOwner);
    }

    public void onStart(LifecycleOwner lifecycleOwner) {
        super.onStart(lifecycleOwner);
    }

    /* JADX WARN: Type inference failed for: r9v4, types: [com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl$networkCallback$1] */
    @Inject
    public WebViewManagerImpl(SettingsRepository settingsRepository, CoroutineDispatcher coroutineDispatcher, @ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "defaultDispatcher");
        Intrinsics.checkNotNullParameter(context, "context");
        this.settingsRepository = settingsRepository;
        this.defaultDispatcher = coroutineDispatcher;
        this.context = context;
        this.currentUrl = "https://appassets.androidplatform.net/assets/page-app-comm-device-overlay.html";
        this.webView = createWebView(context);
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.job = completableJobSupervisorJob$default;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(completableJobSupervisorJob$default.plus((CoroutineContext) coroutineDispatcher));
        this.scope = CoroutineScope;
        MutableStateFlow<WebViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(WebViewState.IsLoading.INSTANCE);
        this._webViewState = MutableStateFlow;
        this.webViewState = FlowKt.asStateFlow(MutableStateFlow);
        MutableSharedFlow<WebViewEvent> mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this._webViewEvent = mutableSharedFlowMutableSharedFlow$default;
        this.webViewEvent = FlowKt.asSharedFlow(mutableSharedFlowMutableSharedFlow$default);
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        this.connectivityManager = connectivityManager;
        ?? r9 = new ConnectivityManager.NetworkCallback() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl$networkCallback$1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                Intrinsics.checkNotNullParameter(network, "network");
                BuildersKt.launch$default(this.this$0.scope, (CoroutineContext) null, (CoroutineStart) null, new WebViewManagerImpl$networkCallback$1$onAvailable$1(this.this$0, null), 3, (Object) null);
            }
        };
        this.networkCallback = r9;
        BuildersKt.launch$default(CoroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(null), 3, (Object) null);
        BuildersKt.launch$default(CoroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2(null), 3, (Object) null);
        connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).build(), (ConnectivityManager.NetworkCallback) r9);
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.WebViewManager
    public WebView getWebView() {
        return this.webView;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.WebViewManager
    public StateFlow<WebViewState> getWebViewState() {
        return this.webViewState;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.WebViewManager
    public SharedFlow<WebViewEvent> getWebViewEvent() {
        return this.webViewEvent;
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl$1, reason: invalid class name */
    /* JADX INFO: compiled from: WebViewManagerImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl$1", f = "WebViewManagerImpl.kt", i = {}, l = {115}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return WebViewManagerImpl.this.new AnonymousClass1(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<InterpretationSpeed> interpretationSpeed = WebViewManagerImpl.this.settingsRepository.getInterpretationSpeed();
                final WebViewManagerImpl webViewManagerImpl = WebViewManagerImpl.this;
                this.label = 1;
                if (interpretationSpeed.collect(new FlowCollector() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl.1.1
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((InterpretationSpeed) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(InterpretationSpeed interpretationSpeed2, Continuation<? super Unit> continuation) {
                        webViewManagerImpl.latestSpeed = interpretationSpeed2;
                        webViewManagerImpl.setInterpretationSpeed(interpretationSpeed2);
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

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl$2, reason: invalid class name */
    /* JADX INFO: compiled from: WebViewManagerImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl$2", f = "WebViewManagerImpl.kt", i = {}, l = {121}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return WebViewManagerImpl.this.new AnonymousClass2(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<InterpretationMode> interpretationMode = WebViewManagerImpl.this.settingsRepository.getInterpretationMode();
                final WebViewManagerImpl webViewManagerImpl = WebViewManagerImpl.this;
                this.label = 1;
                if (interpretationMode.collect(new FlowCollector() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl.2.1
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((InterpretationMode) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(InterpretationMode interpretationMode2, Continuation<? super Unit> continuation) {
                        webViewManagerImpl.latestMode = interpretationMode2;
                        webViewManagerImpl.setInterpretationMode(interpretationMode2);
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

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl$reload$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WebViewManagerImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl$reload$1", f = "WebViewManagerImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C02761 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C02761(Continuation<? super C02761> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return WebViewManagerImpl.this.new C02761(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                WebViewManagerImpl.this._webViewState.setValue(WebViewState.IsLoading.INSTANCE);
                if (WebViewManagerImpl.this.getWebView().getUrl() == null && !(WebViewManagerImpl.this._webViewState.getValue() instanceof WebViewState.Minimized)) {
                    WebViewManagerImpl.this.recreateWebView();
                } else {
                    WebViewManagerImpl.this.getWebView().reload();
                }
                WebViewManagerImpl.this.startAryaStuckTimer();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.WebViewManager
    public void reload() {
        BuildersKt.launch$default(this.scope, Dispatchers.getMain(), (CoroutineStart) null, new C02761(null), 2, (Object) null);
    }

    private final WebView createWebView(Context context) {
        final WebViewAssetLoader webViewAssetLoaderBuild = new WebViewAssetLoader.Builder().addPathHandler("/assets/", new WebViewAssetLoader.AssetsPathHandler(context)).build();
        Intrinsics.checkNotNullExpressionValue(webViewAssetLoaderBuild, "build(...)");
        WebView webView = new WebView(context);
        webView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        webView.setWebViewClient(new WebViewClient() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl$createWebView$1$1
            @Override // android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(request, "request");
                return webViewAssetLoaderBuild.shouldInterceptRequest(request.getUrl());
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                this.startAryaStuckTimer();
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                if (request == null || !request.isForMainFrame()) {
                    return;
                }
                this.handleLoadError(WebViewErrorMapper.INSTANCE.mapResourceError(error != null ? error.getErrorCode() : -1));
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
                super.onReceivedHttpError(view, request, errorResponse);
                if (request == null || !request.isForMainFrame()) {
                    return;
                }
                this.handleLoadError(AppError.AvatarAssetLoadFailed.INSTANCE);
            }

            @Override // android.webkit.WebViewClient
            public boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(detail, "detail");
                BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new WebViewManagerImpl$createWebView$1$1$onRenderProcessGone$1(detail, this, null), 3, (Object) null);
                return true;
            }
        });
        WebSettings settings = webView.getSettings();
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        webView.setWebChromeClient(new WebChromeClient() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl$createWebView$1$3
            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                Intrinsics.checkNotNullParameter(consoleMessage, "consoleMessage");
                return true;
            }
        });
        webView.setBackgroundColor(ColorKt.toArgb-8_81llA(Color.Companion.getTransparent-0d7_KjU()));
        webView.addJavascriptInterface(new WebViewJavascriptInterface(this, context), "AndroidInterface");
        webView.loadUrl(this.currentUrl);
        return webView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recreateWebView() {
        ViewParent parent = getWebView().getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        int iIndexOfChild = viewGroup != null ? viewGroup.indexOfChild(getWebView()) : -1;
        getWebView().removeJavascriptInterface("AndroidInterface");
        getWebView().destroy();
        this.webView = createWebView(this.context);
        if (viewGroup == null || iIndexOfChild == -1) {
            return;
        }
        viewGroup.removeViewAt(iIndexOfChild);
        viewGroup.addView(getWebView(), iIndexOfChild);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleLoadError(AppError error) {
        cancelAryaStuckTimerJob();
        this._webViewState.setValue(WebViewState.Error.INSTANCE);
        BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new C02751(error, null), 3, (Object) null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl$handleLoadError$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WebViewManagerImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl$handleLoadError$1", f = "WebViewManagerImpl.kt", i = {}, l = {241}, m = "invokeSuspend", n = {}, s = {})
    static final class C02751 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppError $error;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02751(AppError appError, Continuation<? super C02751> continuation) {
            super(2, continuation);
            this.$error = appError;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return WebViewManagerImpl.this.new C02751(this.$error, continuation);
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
                if (WebViewManagerImpl.this._webViewEvent.emit(new WebViewEvent.Error(this.$error, "Failed to Load Avatar. Please restart the app."), (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void setInterpretationSpeed(InterpretationSpeed speed) {
        final String str = "setSpeedModeValue(`" + speed.getWebViewKey() + "`)";
        getWebView().post(new Runnable() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                WebViewManagerImpl.setInterpretationSpeed$lambda$2(this.f$0, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setInterpretationSpeed$lambda$2(WebViewManagerImpl webViewManagerImpl, String str) {
        webViewManagerImpl.getWebView().evaluateJavascript(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setInterpretationMode(InterpretationMode mode) {
        final String str = "setQuickInterpretationValue(`" + mode.getWebViewKey() + "`)";
        getWebView().post(new Runnable() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                WebViewManagerImpl.setInterpretationMode$lambda$3(this.f$0, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setInterpretationMode$lambda$3(WebViewManagerImpl webViewManagerImpl, String str) {
        webViewManagerImpl.getWebView().evaluateJavascript(str, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl$startAryaStuckTimer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WebViewManagerImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl$startAryaStuckTimer$1", f = "WebViewManagerImpl.kt", i = {}, l = {258, 260, 261}, m = "invokeSuspend", n = {}, s = {})
    static final class C02771 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C02771(Continuation<? super C02771> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return WebViewManagerImpl.this.new C02771(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x006f, code lost:
        
            if (r6.this$0._webViewEvent.emit(com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewEvent.WebViewLoadFailed.INSTANCE, (kotlin.coroutines.Continuation) r6) == r0) goto L20;
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
                goto L72
            L15:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L1d:
                kotlin.ResultKt.throwOnFailure(r7)
                goto L5e
            L21:
                kotlin.ResultKt.throwOnFailure(r7)
                goto L36
            L25:
                kotlin.ResultKt.throwOnFailure(r7)
                r7 = r6
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                r6.label = r4
                r4 = 20000(0x4e20, double:9.8813E-320)
                java.lang.Object r7 = kotlinx.coroutines.DelayKt.delay(r4, r7)
                if (r7 != r0) goto L36
                goto L71
            L36:
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl.this
                kotlinx.coroutines.flow.MutableStateFlow r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl.access$get_webViewState$p(r7)
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewState$Error r1 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewState.Error.INSTANCE
                r7.setValue(r1)
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl.this
                kotlinx.coroutines.flow.MutableSharedFlow r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl.access$get_webViewEvent$p(r7)
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewEvent$Error r1 = new com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewEvent$Error
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError$AvatarLoadTimeout r4 = com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError.AvatarLoadTimeout.INSTANCE
                com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError r4 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError) r4
                java.lang.String r5 = "Avatar initialization timed out"
                r1.<init>(r4, r5)
                r4 = r6
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                r6.label = r3
                java.lang.Object r7 = r7.emit(r1, r4)
                if (r7 != r0) goto L5e
                goto L71
            L5e:
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl.this
                kotlinx.coroutines.flow.MutableSharedFlow r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl.access$get_webViewEvent$p(r7)
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewEvent$WebViewLoadFailed r1 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewEvent.WebViewLoadFailed.INSTANCE
                r3 = r6
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                r6.label = r2
                java.lang.Object r6 = r7.emit(r1, r3)
                if (r6 != r0) goto L72
            L71:
                return r0
            L72:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl.C02771.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startAryaStuckTimer() {
        cancelAryaStuckTimerJob();
        this.stuckTimerJob = BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new C02771(null), 3, (Object) null);
    }

    private final void cancelAryaStuckTimerJob() {
        Job job = this.stuckTimerJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.stuckTimerJob = null;
    }

    private final void postInterpretMessageToWebView(ConversationMessage conversationMessage) {
        String processedMessage = conversationMessage.getProcessedMessage();
        String strName = conversationMessage.getMessageInputType().name();
        String signGloss = conversationMessage.getSignGloss();
        if (signGloss == null) {
            signGloss = "";
        }
        final String str = "sendMessage(`" + cleanString(StringsKt.trim(processedMessage).toString()) + "`,`" + strName + "`,`" + signGloss + "`);";
        getWebView().post(new Runnable() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                WebViewManagerImpl.postInterpretMessageToWebView$lambda$4(this.f$0, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void postInterpretMessageToWebView$lambda$4(WebViewManagerImpl webViewManagerImpl, String str) {
        webViewManagerImpl.getWebView().evaluateJavascript(str, null);
    }

    private final void postSentenceToWebView(String sentence) {
        final String str = "sendMessage(`" + cleanString(StringsKt.trim(sentence).toString()) + "`,`typed`,``);";
        getWebView().post(new Runnable() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                WebViewManagerImpl.postSentenceToWebView$lambda$5(this.f$0, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void postSentenceToWebView$lambda$5(WebViewManagerImpl webViewManagerImpl, String str) {
        webViewManagerImpl.getWebView().evaluateJavascript(str, null);
    }

    private final String cleanString(String input) {
        return StringsKt.replace$default(StringsKt.replace$default(input, "`", "'", false, 4, (Object) null), "\n", " ", false, 4, (Object) null);
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.WebViewManager
    public void sendConversationMessageToWebView(ConversationMessage conversationMessage) {
        Intrinsics.checkNotNullParameter(conversationMessage, "conversationMessage");
        WebViewState webViewState = (WebViewState) this._webViewState.getValue();
        if ((webViewState instanceof WebViewState.Minimized) || (webViewState instanceof WebViewState.Error)) {
            if (webViewState instanceof WebViewState.Error) {
                reload();
            }
        } else if (webViewState instanceof WebViewState.IsInterpretingConversationMessage) {
            WebViewState.IsInterpretingConversationMessage isInterpretingConversationMessage = (WebViewState.IsInterpretingConversationMessage) webViewState;
            this._webViewState.setValue(new WebViewState.IsInterpretingConversationMessage(isInterpretingConversationMessage.getCurrentlyInterpreting(), CollectionsKt.plus(isInterpretingConversationMessage.getInterpretationQueue(), conversationMessage)));
        } else {
            this._webViewState.setValue(new WebViewState.IsInterpretingConversationMessage(conversationMessage, CollectionsKt.emptyList()));
            postInterpretMessageToWebView(conversationMessage);
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.WebViewManager
    public void sendSentenceListToWebView(List<String> sentences) {
        Intrinsics.checkNotNullParameter(sentences, "sentences");
        if (sentences.isEmpty()) {
            stopInterpretationAndClearTranscripts();
            return;
        }
        WebViewState webViewState = (WebViewState) this._webViewState.getValue();
        if (webViewState instanceof WebViewState.Minimized) {
            return;
        }
        if (webViewState instanceof WebViewState.Error) {
            this.pendingSentences = sentences;
            reload();
        } else if ((webViewState instanceof WebViewState.IsInterpretingConversationMessage) || (webViewState instanceof WebViewState.IsInterpretingSentences)) {
            this.pendingSentences = sentences;
            stopInterpretation();
        } else {
            String str = (String) CollectionsKt.first(sentences);
            this._webViewState.setValue(new WebViewState.IsInterpretingSentences(str, CollectionsKt.drop(sentences, 1)));
            postSentenceToWebView(str);
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.WebViewManager
    public void stopInterpretationAndClearTranscripts() {
        this.pendingSentences = null;
        stopInterpretation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void stopInterpretation$lambda$6(WebViewManagerImpl webViewManagerImpl, String str) {
        webViewManagerImpl.getWebView().evaluateJavascript(str, null);
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.WebViewManager
    public void stopInterpretation() {
        final String str = "stopInterpretation()";
        getWebView().post(new Runnable() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                WebViewManagerImpl.stopInterpretation$lambda$6(this.f$0, str);
            }
        });
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.WebViewManager
    public void setWebViewVisibility(boolean isVisible) {
        getWebView().setVisibility(isVisible ? 0 : 8);
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.WebViewManager
    public void resetToIdle() {
        if (this._webViewState.getValue() instanceof WebViewState.Idle) {
            return;
        }
        stopInterpretationAndClearTranscripts();
    }

    public void onStop(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        resetToIdle();
    }

    public void onDestroy(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.connectivityManager.unregisterNetworkCallback(this.networkCallback);
        ViewParent parent = getWebView().getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(getWebView());
        }
        getWebView().removeJavascriptInterface("AndroidInterface");
        getWebView().destroy();
        Job.DefaultImpls.cancel$default(this.job, (CancellationException) null, 1, (Object) null);
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.JavascriptCallbackHandler
    public void handleJavascriptEvent(String data) {
        Intrinsics.checkNotNullParameter(data, Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        try {
            switch (data.hashCode()) {
                case -579582027:
                    if (data.equals("interpretation stopped") && !(this._webViewState.getValue() instanceof WebViewState.Minimized)) {
                        List<String> list = this.pendingSentences;
                        List<String> list2 = list;
                        if (list2 != null && !list2.isEmpty()) {
                            this.pendingSentences = null;
                            String str = (String) CollectionsKt.first(list);
                            this._webViewState.setValue(new WebViewState.IsInterpretingSentences(str, CollectionsKt.drop(list, 1)));
                            postSentenceToWebView(str);
                            return;
                        }
                        this._webViewState.setValue(WebViewState.Idle.INSTANCE);
                        return;
                    }
                    return;
                case -460706191:
                    if (!data.equals("allow error")) {
                        return;
                    }
                    break;
                case 29019448:
                    if (!data.equals("clip error")) {
                        return;
                    }
                    break;
                case 69558229:
                    if (!data.equals("cors error")) {
                        return;
                    }
                    break;
                case 108386723:
                    if (data.equals("ready")) {
                        cancelAryaStuckTimerJob();
                        List<String> list3 = this.pendingSentences;
                        if (list3 != null) {
                            Intrinsics.checkNotNull(list3);
                            sendSentenceListToWebView(list3);
                            this.pendingSentences = null;
                        } else {
                            this._webViewState.setValue(WebViewState.Idle.INSTANCE);
                        }
                        InterpretationSpeed interpretationSpeed = this.latestSpeed;
                        if (interpretationSpeed != null) {
                            setInterpretationSpeed(interpretationSpeed);
                        }
                        InterpretationMode interpretationMode = this.latestMode;
                        if (interpretationMode != null) {
                            setInterpretationMode(interpretationMode);
                            return;
                        }
                        return;
                    }
                    return;
                case 562946544:
                    if (!data.equals("interpretation error")) {
                        return;
                    }
                    break;
                case 575919178:
                    data.equals("interpretation start");
                    return;
                case 1931309763:
                    if (data.equals("interpretation end")) {
                        WebViewState webViewState = (WebViewState) this._webViewState.getValue();
                        if ((webViewState instanceof WebViewState.IsInterpretingConversationMessage) && !((WebViewState.IsInterpretingConversationMessage) webViewState).getInterpretationQueue().isEmpty()) {
                            ConversationMessage conversationMessage = (ConversationMessage) CollectionsKt.first(((WebViewState.IsInterpretingConversationMessage) webViewState).getInterpretationQueue());
                            this._webViewState.setValue(new WebViewState.IsInterpretingConversationMessage(conversationMessage, CollectionsKt.drop(((WebViewState.IsInterpretingConversationMessage) webViewState).getInterpretationQueue(), 1)));
                            postInterpretMessageToWebView(conversationMessage);
                            return;
                        }
                        if (!(webViewState instanceof WebViewState.IsInterpretingSentences) || ((WebViewState.IsInterpretingSentences) webViewState).getSentencesQueue().isEmpty()) {
                            this._webViewState.setValue(WebViewState.Idle.INSTANCE);
                            return;
                        }
                        String str2 = (String) CollectionsKt.first(((WebViewState.IsInterpretingSentences) webViewState).getSentencesQueue());
                        this._webViewState.setValue(new WebViewState.IsInterpretingSentences(str2, CollectionsKt.drop(((WebViewState.IsInterpretingSentences) webViewState).getSentencesQueue(), 1)));
                        postSentenceToWebView(str2);
                        return;
                    }
                    return;
                default:
                    return;
            }
            this._webViewState.setValue(WebViewState.Error.INSTANCE);
            BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass3(WebViewErrorMapper.INSTANCE.mapJavascriptEvent(data), data, null), 3, (Object) null);
            reload();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl$handleJavascriptEvent$3, reason: invalid class name */
    /* JADX INFO: compiled from: WebViewManagerImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewManagerImpl$handleJavascriptEvent$3", f = "WebViewManagerImpl.kt", i = {}, l = {438}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $data;
        final /* synthetic */ AppError $error;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(AppError appError, String str, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$error = appError;
            this.$data = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return WebViewManagerImpl.this.new AnonymousClass3(this.$error, this.$data, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableSharedFlow mutableSharedFlow = WebViewManagerImpl.this._webViewEvent;
                AppError appError = this.$error;
                String str = this.$data;
                this.label = 1;
                if (mutableSharedFlow.emit(new WebViewEvent.Error(appError, "Avatar JS Error: " + str), (Continuation) this) == coroutine_suspended) {
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

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.JavascriptCallbackHandler
    public String getInterpretationModeKey() {
        InterpretationMode interpretationMode = this.latestMode;
        if (interpretationMode != null) {
            return interpretationMode.getWebViewKey();
        }
        return null;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.JavascriptCallbackHandler
    public String getInterpretationSpeedKey() {
        InterpretationSpeed interpretationSpeed = this.latestSpeed;
        if (interpretationSpeed != null) {
            return interpretationSpeed.getWebViewKey();
        }
        return null;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.WebViewManager, com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.JavascriptCallbackHandler
    public void onCloseAction() {
        stopInterpretation();
        this.pendingSentences = null;
        this._webViewState.setValue(WebViewState.Minimized.INSTANCE);
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.WebViewManager
    public void restoreView() {
        if (this._webViewState.getValue() instanceof WebViewState.Minimized) {
            this._webViewState.setValue(WebViewState.Idle.INSTANCE);
        }
    }
}
