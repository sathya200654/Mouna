package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.ConversationMode;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSettingsRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.factory.SpeechRecognizerFactory;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.manager.SpeechRecognitionManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechRecognizerEvent;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechRecognizerState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechRecognizerType;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
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
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: ConversationSpeechRecognizerService.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Singleton
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001.B+\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0082@¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020!H\u0002J\u000e\u0010)\u001a\u00020#H\u0086@¢\u0006\u0002\u0010*J\u000e\u0010+\u001a\u00020#H\u0086@¢\u0006\u0002\u0010*J\u0010\u0010,\u001a\u00020-2\u0006\u0010$\u001a\u00020%H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u00020\t8\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/service/ConversationSpeechRecognizerService;", "", "speechRecognizerFactory", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/data/factory/SpeechRecognizerFactory;", "conversationSettingsRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationSettingsRepository;", "analyticsManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/data/factory/SpeechRecognizerFactory;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationSettingsRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getIoDispatcher$annotations", "()V", "serviceScope", "Lkotlinx/coroutines/CoroutineScope;", "_serviceState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/service/ConversationServiceState;", "serviceState", "Lkotlinx/coroutines/flow/StateFlow;", "getServiceState", "()Lkotlinx/coroutines/flow/StateFlow;", "_events", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/domain/model/SpeechRecognizerEvent;", "events", "Lkotlinx/coroutines/flow/SharedFlow;", "getEvents", "()Lkotlinx/coroutines/flow/SharedFlow;", "sessionMutex", "Lkotlinx/coroutines/sync/Mutex;", "currentSession", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/service/ConversationSpeechRecognizerService$SessionWrapper;", "reconfigureSession", "", "settings", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/service/SettingsState;", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/service/SettingsState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bindSessionEvents", "session", "startListening", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopListening", "determineRecognizerType", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/domain/model/SpeechRecognizerType;", "SessionWrapper", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ConversationSpeechRecognizerService {
    public static final int $stable = 8;
    private final MutableSharedFlow<SpeechRecognizerEvent> _events;
    private final MutableStateFlow<ConversationServiceState> _serviceState;
    private final AnalyticsManager analyticsManager;
    private SessionWrapper currentSession;
    private final SharedFlow<SpeechRecognizerEvent> events;
    private final CoroutineDispatcher ioDispatcher;
    private final CoroutineScope serviceScope;
    private final StateFlow<ConversationServiceState> serviceState;
    private final Mutex sessionMutex;
    private final SpeechRecognizerFactory speechRecognizerFactory;

    /* JADX INFO: compiled from: ConversationSpeechRecognizerService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ConversationMode.values().length];
            try {
                iArr[ConversationMode.ONE_TO_ONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ConversationMode.MEETING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationSpeechRecognizerService$reconfigureSession$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationSpeechRecognizerService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationSpeechRecognizerService", f = "ConversationSpeechRecognizerService.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4}, l = {232, 95, 132, 135, 136}, m = "reconfigureSession", n = {"settings", "$this$withLock_u24default$iv", "$i$f$withLock", "settings", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-ConversationSpeechRecognizerService$reconfigureSession$2", "settings", "$this$withLock_u24default$iv", "oldSession", "newRecognizer", "newSessionScope", "newSession", "$i$f$withLock", "$i$a$-withLock$default-ConversationSpeechRecognizerService$reconfigureSession$2", "settings", "$this$withLock_u24default$iv", "oldSession", "e", "$i$f$withLock", "$i$a$-withLock$default-ConversationSpeechRecognizerService$reconfigureSession$2", "settings", "$this$withLock_u24default$iv", "oldSession", "e", "$i$f$withLock", "$i$a$-withLock$default-ConversationSpeechRecognizerService$reconfigureSession$2"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1"})
    static final class C02341 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C02341(Continuation<? super C02341> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ConversationSpeechRecognizerService.this.reconfigureSession(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationSpeechRecognizerService$startListening$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationSpeechRecognizerService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationSpeechRecognizerService", f = "ConversationSpeechRecognizerService.kt", i = {1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5}, l = {171, 232, 175, 183, 190, 191}, m = "startListening", n = {"$this$withLock_u24default$iv", "$i$f$withLock", "$this$withLock_u24default$iv", "session", "$i$f$withLock", "$i$a$-withLock$default-ConversationSpeechRecognizerService$startListening$2", "$this$withLock_u24default$iv", "session", "$i$f$withLock", "$i$a$-withLock$default-ConversationSpeechRecognizerService$startListening$2", "$this$withLock_u24default$iv", "session", "e", "$i$f$withLock", "$i$a$-withLock$default-ConversationSpeechRecognizerService$startListening$2", "$this$withLock_u24default$iv", "session", "e", "$i$f$withLock", "$i$a$-withLock$default-ConversationSpeechRecognizerService$startListening$2"}, s = {"L$0", "I$0", "L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"})
    static final class C02351 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C02351(Continuation<? super C02351> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ConversationSpeechRecognizerService.this.startListening((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationSpeechRecognizerService$stopListening$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationSpeechRecognizerService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationSpeechRecognizerService", f = "ConversationSpeechRecognizerService.kt", i = {1, 1, 2, 2, 2, 2}, l = {197, 232, 205}, m = "stopListening", n = {"$this$withLock_u24default$iv", "$i$f$withLock", "$this$withLock_u24default$iv", "session", "$i$f$withLock", "$i$a$-withLock$default-ConversationSpeechRecognizerService$stopListening$2"}, s = {"L$0", "I$0", "L$0", "L$1", "I$0", "I$1"})
    static final class C02361 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C02361(Continuation<? super C02361> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ConversationSpeechRecognizerService.this.stopListening((Continuation) this);
        }
    }

    private static /* synthetic */ void getIoDispatcher$annotations() {
    }

    @Inject
    public ConversationSpeechRecognizerService(SpeechRecognizerFactory speechRecognizerFactory, ConversationSettingsRepository conversationSettingsRepository, AnalyticsManager analyticsManager, CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(speechRecognizerFactory, "speechRecognizerFactory");
        Intrinsics.checkNotNullParameter(conversationSettingsRepository, "conversationSettingsRepository");
        Intrinsics.checkNotNullParameter(analyticsManager, "analyticsManager");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "ioDispatcher");
        this.speechRecognizerFactory = speechRecognizerFactory;
        this.analyticsManager = analyticsManager;
        this.ioDispatcher = coroutineDispatcher;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus((CoroutineContext) coroutineDispatcher));
        this.serviceScope = CoroutineScope;
        MutableStateFlow<ConversationServiceState> MutableStateFlow = StateFlowKt.MutableStateFlow(ConversationServiceState.Idle.INSTANCE);
        this._serviceState = MutableStateFlow;
        this.serviceState = FlowKt.asStateFlow(MutableStateFlow);
        MutableSharedFlow<SpeechRecognizerEvent> mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this._events = mutableSharedFlowMutableSharedFlow$default;
        this.events = FlowKt.asSharedFlow(mutableSharedFlowMutableSharedFlow$default);
        this.sessionMutex = MutexKt.Mutex$default(false, 1, (Object) null);
        BuildersKt.launch$default(CoroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(conversationSettingsRepository, this, null), 3, (Object) null);
    }

    public final StateFlow<ConversationServiceState> getServiceState() {
        return this.serviceState;
    }

    public final SharedFlow<SpeechRecognizerEvent> getEvents() {
        return this.events;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: ConversationSpeechRecognizerService.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/service/ConversationSpeechRecognizerService$SessionWrapper;", "", "id", "", "recognizer", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/domain/manager/SpeechRecognitionManager;", "mode", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMode;", "userLanguage", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "sessionScope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Ljava/lang/String;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/domain/manager/SpeechRecognitionManager;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMode;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;Lkotlinx/coroutines/CoroutineScope;)V", "getId", "()Ljava/lang/String;", "getRecognizer", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/domain/manager/SpeechRecognitionManager;", "getMode", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMode;", "getUserLanguage", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "getSessionScope", "()Lkotlinx/coroutines/CoroutineScope;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    static final /* data */ class SessionWrapper {
        private final String id;
        private final ConversationMode mode;
        private final SpeechRecognitionManager recognizer;
        private final CoroutineScope sessionScope;
        private final LanguageEnum userLanguage;

        public static /* synthetic */ SessionWrapper copy$default(SessionWrapper sessionWrapper, String str, SpeechRecognitionManager speechRecognitionManager, ConversationMode conversationMode, LanguageEnum languageEnum, CoroutineScope coroutineScope, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sessionWrapper.id;
            }
            if ((i & 2) != 0) {
                speechRecognitionManager = sessionWrapper.recognizer;
            }
            if ((i & 4) != 0) {
                conversationMode = sessionWrapper.mode;
            }
            if ((i & 8) != 0) {
                languageEnum = sessionWrapper.userLanguage;
            }
            if ((i & 16) != 0) {
                coroutineScope = sessionWrapper.sessionScope;
            }
            CoroutineScope coroutineScope2 = coroutineScope;
            ConversationMode conversationMode2 = conversationMode;
            return sessionWrapper.copy(str, speechRecognitionManager, conversationMode2, languageEnum, coroutineScope2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final SpeechRecognitionManager getRecognizer() {
            return this.recognizer;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final ConversationMode getMode() {
            return this.mode;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final LanguageEnum getUserLanguage() {
            return this.userLanguage;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final CoroutineScope getSessionScope() {
            return this.sessionScope;
        }

        public final SessionWrapper copy(String id, SpeechRecognitionManager recognizer, ConversationMode mode, LanguageEnum userLanguage, CoroutineScope sessionScope) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(recognizer, "recognizer");
            Intrinsics.checkNotNullParameter(mode, "mode");
            Intrinsics.checkNotNullParameter(userLanguage, "userLanguage");
            Intrinsics.checkNotNullParameter(sessionScope, "sessionScope");
            return new SessionWrapper(id, recognizer, mode, userLanguage, sessionScope);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SessionWrapper)) {
                return false;
            }
            SessionWrapper sessionWrapper = (SessionWrapper) other;
            return Intrinsics.areEqual(this.id, sessionWrapper.id) && Intrinsics.areEqual(this.recognizer, sessionWrapper.recognizer) && this.mode == sessionWrapper.mode && this.userLanguage == sessionWrapper.userLanguage && Intrinsics.areEqual(this.sessionScope, sessionWrapper.sessionScope);
        }

        public int hashCode() {
            return (((((((this.id.hashCode() * 31) + this.recognizer.hashCode()) * 31) + this.mode.hashCode()) * 31) + this.userLanguage.hashCode()) * 31) + this.sessionScope.hashCode();
        }

        public String toString() {
            return "SessionWrapper(id=" + this.id + ", recognizer=" + this.recognizer + ", mode=" + this.mode + ", userLanguage=" + this.userLanguage + ", sessionScope=" + this.sessionScope + ")";
        }

        public SessionWrapper(String str, SpeechRecognitionManager speechRecognitionManager, ConversationMode conversationMode, LanguageEnum languageEnum, CoroutineScope coroutineScope) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(speechRecognitionManager, "recognizer");
            Intrinsics.checkNotNullParameter(conversationMode, "mode");
            Intrinsics.checkNotNullParameter(languageEnum, "userLanguage");
            Intrinsics.checkNotNullParameter(coroutineScope, "sessionScope");
            this.id = str;
            this.recognizer = speechRecognitionManager;
            this.mode = conversationMode;
            this.userLanguage = languageEnum;
            this.sessionScope = coroutineScope;
        }

        public final String getId() {
            return this.id;
        }

        public final SpeechRecognitionManager getRecognizer() {
            return this.recognizer;
        }

        public final ConversationMode getMode() {
            return this.mode;
        }

        public final LanguageEnum getUserLanguage() {
            return this.userLanguage;
        }

        public final CoroutineScope getSessionScope() {
            return this.sessionScope;
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationSpeechRecognizerService$1, reason: invalid class name */
    /* JADX INFO: compiled from: ConversationSpeechRecognizerService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationSpeechRecognizerService$1", f = "ConversationSpeechRecognizerService.kt", i = {}, l = {87}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ConversationSettingsRepository $conversationSettingsRepository;
        int label;
        final /* synthetic */ ConversationSpeechRecognizerService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ConversationSettingsRepository conversationSettingsRepository, ConversationSpeechRecognizerService conversationSpeechRecognizerService, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$conversationSettingsRepository = conversationSettingsRepository;
            this.this$0 = conversationSpeechRecognizerService;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$conversationSettingsRepository, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow flowDistinctUntilChanged = FlowKt.distinctUntilChanged(FlowKt.combine(this.$conversationSettingsRepository.getConversationMode(), this.$conversationSettingsRepository.getUserLanguage(), this.$conversationSettingsRepository.getSpeakerLanguage(), this.$conversationSettingsRepository.isSpeakerDetectionEnabled(), new C00411(null)));
                final ConversationSpeechRecognizerService conversationSpeechRecognizerService = this.this$0;
                this.label = 1;
                if (flowDistinctUntilChanged.collect(new FlowCollector() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationSpeechRecognizerService.1.2
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((SettingsState) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(SettingsState settingsState, Continuation<? super Unit> continuation) throws Throwable {
                        Object objReconfigureSession = conversationSpeechRecognizerService.reconfigureSession(settingsState, continuation);
                        return objReconfigureSession == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objReconfigureSession : Unit.INSTANCE;
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

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationSpeechRecognizerService$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: ConversationSpeechRecognizerService.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/service/SettingsState;", "mode", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMode;", "userLang", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "speakerLang", "speakerDetection", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationSpeechRecognizerService$1$1", f = "ConversationSpeechRecognizerService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00411 extends SuspendLambda implements Function5<ConversationMode, LanguageEnum, LanguageEnum, Boolean, Continuation<? super SettingsState>, Object> {
            /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            /* synthetic */ Object L$2;
            /* synthetic */ boolean Z$0;
            int label;

            C00411(Continuation<? super C00411> continuation) {
                super(5, continuation);
            }

            public final Object invoke(ConversationMode conversationMode, LanguageEnum languageEnum, LanguageEnum languageEnum2, boolean z, Continuation<? super SettingsState> continuation) {
                C00411 c00411 = new C00411(continuation);
                c00411.L$0 = conversationMode;
                c00411.L$1 = languageEnum;
                c00411.L$2 = languageEnum2;
                c00411.Z$0 = z;
                return c00411.invokeSuspend(Unit.INSTANCE);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                return invoke((ConversationMode) obj, (LanguageEnum) obj2, (LanguageEnum) obj3, ((Boolean) obj4).booleanValue(), (Continuation<? super SettingsState>) obj5);
            }

            public final Object invokeSuspend(Object obj) {
                ConversationMode conversationMode = (ConversationMode) this.L$0;
                LanguageEnum languageEnum = (LanguageEnum) this.L$1;
                LanguageEnum languageEnum2 = (LanguageEnum) this.L$2;
                boolean z = this.Z$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return new SettingsState(conversationMode, languageEnum, languageEnum2, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:52:0x0102 A[Catch: all -> 0x00a9, Exception -> 0x0105, TRY_LEAVE, TryCatch #3 {all -> 0x00a9, blocks: (B:23:0x0070, B:65:0x01d3, B:26:0x0091, B:61:0x01a0, B:31:0x00a5, B:44:0x00ed, B:46:0x00f1, B:48:0x00f7, B:50:0x00fc, B:52:0x0102, B:54:0x0107, B:55:0x0122), top: B:84:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:54:0x0107 A[Catch: all -> 0x00a9, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x00a9, blocks: (B:23:0x0070, B:65:0x01d3, B:26:0x0091, B:61:0x01a0, B:31:0x00a5, B:44:0x00ed, B:46:0x00f1, B:48:0x00f7, B:50:0x00fc, B:52:0x0102, B:54:0x0107, B:55:0x0122), top: B:84:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:63:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:64:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:68:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:87:0x00fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0195, code lost:
    
        if (r6.emit(r10, r2) == r3) goto L67;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v16, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object reconfigureSession(com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.SettingsState r23, kotlin.coroutines.Continuation<? super kotlin.Unit> r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 522
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationSpeechRecognizerService.reconfigureSession(com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.SettingsState, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationSpeechRecognizerService$bindSessionEvents$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationSpeechRecognizerService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationSpeechRecognizerService$bindSessionEvents$1", f = "ConversationSpeechRecognizerService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C02331 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SessionWrapper $session;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ConversationSpeechRecognizerService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02331(SessionWrapper sessionWrapper, ConversationSpeechRecognizerService conversationSpeechRecognizerService, Continuation<? super C02331> continuation) {
            super(2, continuation);
            this.$session = sessionWrapper;
            this.this$0 = conversationSpeechRecognizerService;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c02331 = new C02331(this.$session, this.this$0, continuation);
            c02331.L$0 = obj;
            return c02331;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationSpeechRecognizerService$bindSessionEvents$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: ConversationSpeechRecognizerService.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationSpeechRecognizerService$bindSessionEvents$1$1", f = "ConversationSpeechRecognizerService.kt", i = {}, l = {145}, m = "invokeSuspend", n = {}, s = {})
        static final class C00421 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ SessionWrapper $session;
            int label;
            final /* synthetic */ ConversationSpeechRecognizerService this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00421(SessionWrapper sessionWrapper, ConversationSpeechRecognizerService conversationSpeechRecognizerService, Continuation<? super C00421> continuation) {
                super(2, continuation);
                this.$session = sessionWrapper;
                this.this$0 = conversationSpeechRecognizerService;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00421(this.$session, this.this$0, continuation);
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
                    StateFlow<SpeechRecognizerState> speechRecognizerState = this.$session.getRecognizer().getSpeechRecognizerState();
                    final ConversationSpeechRecognizerService conversationSpeechRecognizerService = this.this$0;
                    this.label = 1;
                    if (speechRecognizerState.collect(new FlowCollector() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationSpeechRecognizerService.bindSessionEvents.1.1.1
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((SpeechRecognizerState) obj2, (Continuation<? super Unit>) continuation);
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public final Object emit(SpeechRecognizerState speechRecognizerState2, Continuation<? super Unit> continuation) throws NoWhenBranchMatchedException {
                            if (speechRecognizerState2 instanceof SpeechRecognizerState.Recognizing) {
                                Object objEmit = conversationSpeechRecognizerService._serviceState.emit(new ConversationServiceState.Listening(((SpeechRecognizerState.Recognizing) speechRecognizerState2).getPartialText()), continuation);
                                return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
                            }
                            if (Intrinsics.areEqual(speechRecognizerState2, SpeechRecognizerState.Starting.INSTANCE)) {
                                Object objEmit2 = conversationSpeechRecognizerService._serviceState.emit(ConversationServiceState.Starting.INSTANCE, continuation);
                                return objEmit2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit2 : Unit.INSTANCE;
                            }
                            if (Intrinsics.areEqual(speechRecognizerState2, SpeechRecognizerState.Idle.INSTANCE)) {
                                Object objEmit3 = conversationSpeechRecognizerService._serviceState.emit(ConversationServiceState.Idle.INSTANCE, continuation);
                                return objEmit3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit3 : Unit.INSTANCE;
                            }
                            if (Intrinsics.areEqual(speechRecognizerState2, SpeechRecognizerState.Stopping.INSTANCE)) {
                                Object objEmit4 = conversationSpeechRecognizerService._serviceState.emit(ConversationServiceState.Stopping.INSTANCE, continuation);
                                return objEmit4 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit4 : Unit.INSTANCE;
                            }
                            throw new NoWhenBranchMatchedException();
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

        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new C00421(this.$session, this.this$0, null), 3, (Object) null);
            BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2(this.$session, this.this$0, null), 3, (Object) null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationSpeechRecognizerService$bindSessionEvents$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: ConversationSpeechRecognizerService.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationSpeechRecognizerService$bindSessionEvents$1$2", f = "ConversationSpeechRecognizerService.kt", i = {}, l = {160}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ SessionWrapper $session;
            int label;
            final /* synthetic */ ConversationSpeechRecognizerService this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(SessionWrapper sessionWrapper, ConversationSpeechRecognizerService conversationSpeechRecognizerService, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$session = sessionWrapper;
                this.this$0 = conversationSpeechRecognizerService;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$session, this.this$0, continuation);
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationSpeechRecognizerService$bindSessionEvents$1$2$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: ConversationSpeechRecognizerService.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            static final class C00441<T> implements FlowCollector {
                final /* synthetic */ ConversationSpeechRecognizerService this$0;

                C00441(ConversationSpeechRecognizerService conversationSpeechRecognizerService) {
                    this.this$0 = conversationSpeechRecognizerService;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                /* JADX WARN: Code restructure failed: missing block: B:22:0x006d, code lost:
                
                    if (r5.emit(r7, r0) == r1) goto L23;
                 */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechRecognizerEvent r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationSpeechRecognizerService$bindSessionEvents$1$2$1$emit$1
                        if (r0 == 0) goto L14
                        r0 = r7
                        com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationSpeechRecognizerService$bindSessionEvents$1$2$1$emit$1 r0 = (com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationSpeechRecognizerService$bindSessionEvents$1$2$1$emit$1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r7 = r0.label
                        int r7 = r7 - r2
                        r0.label = r7
                        goto L19
                    L14:
                        com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationSpeechRecognizerService$bindSessionEvents$1$2$1$emit$1 r0 = new com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationSpeechRecognizerService$bindSessionEvents$1$2$1$emit$1
                        r0.<init>(r5, r7)
                    L19:
                        java.lang.Object r7 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L41
                        if (r2 == r4) goto L39
                        if (r2 != r3) goto L31
                        java.lang.Object r5 = r0.L$0
                        com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechRecognizerEvent r5 = (com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechRecognizerEvent) r5
                        kotlin.ResultKt.throwOnFailure(r7)
                        goto L70
                    L31:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L39:
                        java.lang.Object r6 = r0.L$0
                        com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechRecognizerEvent r6 = (com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechRecognizerEvent) r6
                        kotlin.ResultKt.throwOnFailure(r7)
                        goto L55
                    L41:
                        kotlin.ResultKt.throwOnFailure(r7)
                        com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationSpeechRecognizerService r7 = r5.this$0
                        kotlinx.coroutines.flow.MutableSharedFlow r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationSpeechRecognizerService.access$get_events$p(r7)
                        r0.L$0 = r6
                        r0.label = r4
                        java.lang.Object r7 = r7.emit(r6, r0)
                        if (r7 != r1) goto L55
                        goto L6f
                    L55:
                        boolean r7 = r6 instanceof com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechRecognizerEvent.Error
                        if (r7 == 0) goto L73
                        com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationSpeechRecognizerService r5 = r5.this$0
                        kotlinx.coroutines.flow.MutableStateFlow r5 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationSpeechRecognizerService.access$get_serviceState$p(r5)
                        com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationServiceState$Idle r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationServiceState.Idle.INSTANCE
                        java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
                        r0.L$0 = r6
                        r0.label = r3
                        java.lang.Object r5 = r5.emit(r7, r0)
                        if (r5 != r1) goto L70
                    L6f:
                        return r1
                    L70:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    L73:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationSpeechRecognizerService.C02331.AnonymousClass2.C00441.emit(com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechRecognizerEvent, kotlin.coroutines.Continuation):java.lang.Object");
                }

                public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                    return emit((SpeechRecognizerEvent) obj, (Continuation<? super Unit>) continuation);
                }
            }

            /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.KotlinNothingValueException */
            public final Object invokeSuspend(Object obj) throws KotlinNothingValueException {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (this.$session.getRecognizer().getSpeechRecognizerEventFlow().collect(new C00441(this.this$0), (Continuation) this) == coroutine_suspended) {
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
    }

    private final void bindSessionEvents(SessionWrapper session) {
        BuildersKt.launch$default(session.getSessionScope(), (CoroutineContext) null, (CoroutineStart) null, new C02331(session, this, null), 3, (Object) null);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:41:0x00c0 A[Catch: all -> 0x018f, TRY_LEAVE, TryCatch #4 {all -> 0x018f, blocks: (B:65:0x0167, B:52:0x0115, B:55:0x0125, B:56:0x012d, B:57:0x0132, B:58:0x0133, B:61:0x013d, B:39:0x00bc, B:41:0x00c0, B:48:0x00e7), top: B:81:0x00bc, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:48:0x00e7 A[Catch: all -> 0x018f, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x018f, blocks: (B:65:0x0167, B:52:0x0115, B:55:0x0125, B:56:0x012d, B:57:0x0132, B:58:0x0133, B:61:0x013d, B:39:0x00bc, B:41:0x00c0, B:48:0x00e7), top: B:81:0x00bc, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x0112  */
    /* JADX WARN: Code duplicated, block: B:54:0x0123 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:55:0x0125 A[Catch: Exception -> 0x013c, all -> 0x018f, TryCatch #0 {Exception -> 0x013c, blocks: (B:52:0x0115, B:55:0x0125, B:56:0x012d, B:57:0x0132, B:58:0x0133), top: B:75:0x0115, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x012d A[Catch: Exception -> 0x013c, all -> 0x018f, TryCatch #0 {Exception -> 0x013c, blocks: (B:52:0x0115, B:55:0x0125, B:56:0x012d, B:57:0x0132, B:58:0x0133), top: B:75:0x0115, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x0133 A[Catch: Exception -> 0x013c, all -> 0x018f, TRY_LEAVE, TryCatch #0 {Exception -> 0x013c, blocks: (B:52:0x0115, B:55:0x0125, B:56:0x012d, B:57:0x0132, B:58:0x0133), top: B:75:0x0115, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0184, code lost:
    
        if (r12.emit(r7, r0) == r1) goto L67;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object startListening(kotlin.coroutines.Continuation<? super kotlin.Unit> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 426
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationSpeechRecognizerService.startListening(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:31:0x007d A[Catch: all -> 0x00c2, TRY_LEAVE, TryCatch #0 {all -> 0x00c2, blocks: (B:29:0x0079, B:31:0x007d, B:34:0x0083), top: B:45:0x0079 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0083 A[Catch: all -> 0x00c2, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00c2, blocks: (B:29:0x0079, B:31:0x007d, B:34:0x0083), top: B:45:0x0079 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object stopListening(Continuation<? super Unit> continuation) throws Throwable {
        C02361 c02361;
        Mutex mutex;
        int i;
        Throwable th;
        Mutex mutex2;
        SessionWrapper sessionWrapper;
        CoroutineContext io2;
        ConversationSpeechRecognizerService$stopListening$2$1 conversationSpeechRecognizerService$stopListening$2$1;
        if (continuation instanceof C02361) {
            c02361 = (C02361) continuation;
            if ((c02361.label & Integer.MIN_VALUE) != 0) {
                c02361.label -= Integer.MIN_VALUE;
            } else {
                c02361 = new C02361(continuation);
            }
        } else {
            c02361 = new C02361(continuation);
        }
        Object obj = c02361.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c02361.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            MutableStateFlow<ConversationServiceState> mutableStateFlow = this._serviceState;
            ConversationServiceState.Stopping stopping = ConversationServiceState.Stopping.INSTANCE;
            c02361.label = 1;
            if (mutableStateFlow.emit(stopping, c02361) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i3 = c02361.I$1;
                int i4 = c02361.I$0;
                mutex2 = (Mutex) c02361.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    Unit unit = Unit.INSTANCE;
                    mutex2.unlock((Object) null);
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock((Object) null);
                    throw th;
                }
            }
            i = c02361.I$0;
            Mutex mutex3 = (Mutex) c02361.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex3;
            try {
                sessionWrapper = this.currentSession;
                if (sessionWrapper == null) {
                    this.analyticsManager.logEvent(new AnalyticsEvent.SttEnded(sessionWrapper.getUserLanguage().toString()));
                    io2 = Dispatchers.getIO();
                    conversationSpeechRecognizerService$stopListening$2$1 = new ConversationSpeechRecognizerService$stopListening$2$1(sessionWrapper, null);
                    c02361.L$0 = mutex;
                    c02361.L$1 = SpillingKt.nullOutSpilledVariable(sessionWrapper);
                    c02361.I$0 = i;
                    c02361.I$1 = 0;
                    c02361.label = 3;
                    if (BuildersKt.withContext(io2, conversationSpeechRecognizerService$stopListening$2$1, c02361) != coroutine_suspended) {
                        mutex2 = mutex;
                        Unit unit2 = Unit.INSTANCE;
                        mutex2.unlock((Object) null);
                        return Unit.INSTANCE;
                    }
                    return coroutine_suspended;
                }
                Unit unit3 = Unit.INSTANCE;
                mutex.unlock((Object) null);
                return unit3;
            } catch (Throwable th3) {
                Mutex mutex4 = mutex;
                th = th3;
                mutex2 = mutex4;
                mutex2.unlock((Object) null);
                throw th;
            }
        }
        ResultKt.throwOnFailure(obj);
        mutex = this.sessionMutex;
        c02361.L$0 = mutex;
        c02361.I$0 = 0;
        c02361.label = 2;
        if (mutex.lock((Object) null, c02361) != coroutine_suspended) {
            i = 0;
            sessionWrapper = this.currentSession;
            if (sessionWrapper == null) {
                this.analyticsManager.logEvent(new AnalyticsEvent.SttEnded(sessionWrapper.getUserLanguage().toString()));
                io2 = Dispatchers.getIO();
                conversationSpeechRecognizerService$stopListening$2$1 = new ConversationSpeechRecognizerService$stopListening$2$1(sessionWrapper, null);
                c02361.L$0 = mutex;
                c02361.L$1 = SpillingKt.nullOutSpilledVariable(sessionWrapper);
                c02361.I$0 = i;
                c02361.I$1 = 0;
                c02361.label = 3;
                if (BuildersKt.withContext(io2, conversationSpeechRecognizerService$stopListening$2$1, c02361) != coroutine_suspended) {
                    mutex2 = mutex;
                    Unit unit4 = Unit.INSTANCE;
                    mutex2.unlock((Object) null);
                    return Unit.INSTANCE;
                }
            } else {
                Unit unit5 = Unit.INSTANCE;
                mutex.unlock((Object) null);
                return unit5;
            }
        }
        return coroutine_suspended;
    }

    private final SpeechRecognizerType determineRecognizerType(SettingsState settings) {
        boolean z = settings.getUserLanguage() == LanguageEnum.ENGLISH && settings.getSpeakerLanguage() == LanguageEnum.ENGLISH;
        if (settings.getConversationMode() == ConversationMode.MEETING && settings.isSpeakerDetectionEnabled() && z) {
            return SpeechRecognizerType.CONVERSATION;
        }
        if (z) {
            return SpeechRecognizerType.SPEECH;
        }
        return SpeechRecognizerType.TRANSLATION_TO_TARGET;
    }
}
