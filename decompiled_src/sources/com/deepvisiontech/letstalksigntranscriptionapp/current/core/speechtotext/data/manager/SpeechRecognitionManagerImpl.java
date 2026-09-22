package com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager;

import com.azure.core.util.tracing.Tracer;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.local.SpeechRecogMicrophoneStream;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.manager.SpeechRecognitionManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechErrorType;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechRecognizerEvent;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechRecognizerState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.repository.SpeechToTextRepository;
import com.microsoft.cognitiveservices.speech.CancellationReason;
import com.microsoft.cognitiveservices.speech.SessionEventArgs;
import com.microsoft.cognitiveservices.speech.SpeechConfig;
import com.microsoft.cognitiveservices.speech.SpeechRecognitionCanceledEventArgs;
import com.microsoft.cognitiveservices.speech.SpeechRecognitionEventArgs;
import com.microsoft.cognitiveservices.speech.SpeechRecognizer;
import com.microsoft.cognitiveservices.speech.audio.AudioConfig;
import com.microsoft.cognitiveservices.speech.util.EventHandler;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: SpeechRecognitionManagerImpl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010-\u001a\u0010\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/\u0018\u00010.H\u0082@¢\u0006\u0002\u00100J\u000e\u00101\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u00100J\b\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u000203H\u0002J\b\u00105\u001a\u000203H\u0002J\b\u00106\u001a\u000203H\u0017J\b\u00107\u001a\u000203H\u0017J\b\u00108\u001a\u000203H\u0016J\b\u00109\u001a\u000203H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0!X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020)0%X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020)0%X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020,0%X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/data/manager/SpeechRecognitionManagerImpl;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/domain/manager/SpeechRecognitionManager;", "speechRecogMicrophoneStream", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/data/local/SpeechRecogMicrophoneStream;", "speechToTextRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/domain/repository/SpeechToTextRepository;", "sessionRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/data/local/SpeechRecogMicrophoneStream;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/domain/repository/SpeechToTextRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;)V", "speechRecognizer", "Lcom/microsoft/cognitiveservices/speech/SpeechRecognizer;", "audioConfig", "Lcom/microsoft/cognitiveservices/speech/audio/AudioConfig;", "speechConfig", "Lcom/microsoft/cognitiveservices/speech/SpeechConfig;", "tokenRefreshJob", "Lkotlinx/coroutines/Job;", Tracer.SCOPE_KEY, "Lkotlinx/coroutines/CoroutineScope;", "isRecognizing", "", "_speechRecognizerState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/domain/model/SpeechRecognizerState;", "speechRecognizerState", "Lkotlinx/coroutines/flow/StateFlow;", "getSpeechRecognizerState", "()Lkotlinx/coroutines/flow/StateFlow;", "_recognizerEvents", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/domain/model/SpeechRecognizerEvent;", "speechRecognizerEventFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getSpeechRecognizerEventFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "recognizedListener", "Lcom/microsoft/cognitiveservices/speech/util/EventHandler;", "Lcom/microsoft/cognitiveservices/speech/SpeechRecognitionEventArgs;", "recognizingListener", "recognitionSessionStarted", "Lcom/microsoft/cognitiveservices/speech/SessionEventArgs;", "recognitionSessionStopped", "recognitionSessionCancelled", "Lcom/microsoft/cognitiveservices/speech/SpeechRecognitionCanceledEventArgs;", "fetchCredentials", "Lkotlin/Pair;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initializeRecognizer", "startTokenRefresh", "", "stopTokenRefresh", "releaseRecognizer", "startRecognizing", "recognizeOnceAsync", "stopRecognizing", "cleanUp", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SpeechRecognitionManagerImpl implements SpeechRecognitionManager {
    public static final int $stable = 8;
    private final MutableSharedFlow<SpeechRecognizerEvent> _recognizerEvents;
    private final MutableStateFlow<SpeechRecognizerState> _speechRecognizerState;
    private AudioConfig audioConfig;
    private volatile boolean isRecognizing;
    private final EventHandler<SpeechRecognitionCanceledEventArgs> recognitionSessionCancelled;
    private final EventHandler<SessionEventArgs> recognitionSessionStarted;
    private final EventHandler<SessionEventArgs> recognitionSessionStopped;
    private final EventHandler<SpeechRecognitionEventArgs> recognizedListener;
    private final EventHandler<SpeechRecognitionEventArgs> recognizingListener;
    private final CoroutineScope scope;
    private final SessionRepository sessionRepository;
    private SpeechConfig speechConfig;
    private final SpeechRecogMicrophoneStream speechRecogMicrophoneStream;
    private SpeechRecognizer speechRecognizer;
    private final SharedFlow<SpeechRecognizerEvent> speechRecognizerEventFlow;
    private final StateFlow<SpeechRecognizerState> speechRecognizerState;
    private final SpeechToTextRepository speechToTextRepository;
    private Job tokenRefreshJob;

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl$fetchCredentials$1, reason: invalid class name */
    /* JADX INFO: compiled from: SpeechRecognitionManagerImpl.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl", f = "SpeechRecognitionManagerImpl.kt", i = {0, 1, 1, 2, 2, 2, 3, 3, 3, 3}, l = {105, 106, 107, 109}, m = "fetchCredentials", n = {"customerId", "customerId", "deviceId", "customerId", "deviceId", "gmailId", "customerId", "deviceId", "gmailId", "userToken"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SpeechRecognitionManagerImpl.this.fetchCredentials((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl$initializeRecognizer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SpeechRecognitionManagerImpl.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl", f = "SpeechRecognitionManagerImpl.kt", i = {}, l = {121}, m = "initializeRecognizer", n = {}, s = {})
    static final class C02671 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C02671(Continuation<? super C02671> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SpeechRecognitionManagerImpl.this.initializeRecognizer((Continuation) this);
        }
    }

    public SpeechRecognitionManagerImpl(SpeechRecogMicrophoneStream speechRecogMicrophoneStream, SpeechToTextRepository speechToTextRepository, SessionRepository sessionRepository) {
        Intrinsics.checkNotNullParameter(speechRecogMicrophoneStream, "speechRecogMicrophoneStream");
        Intrinsics.checkNotNullParameter(speechToTextRepository, "speechToTextRepository");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        this.speechRecogMicrophoneStream = speechRecogMicrophoneStream;
        this.speechToTextRepository = speechToTextRepository;
        this.sessionRepository = sessionRepository;
        this.scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()));
        MutableStateFlow<SpeechRecognizerState> MutableStateFlow = StateFlowKt.MutableStateFlow(SpeechRecognizerState.Idle.INSTANCE);
        this._speechRecognizerState = MutableStateFlow;
        this.speechRecognizerState = FlowKt.asStateFlow(MutableStateFlow);
        MutableSharedFlow<SpeechRecognizerEvent> MutableSharedFlow = SharedFlowKt.MutableSharedFlow(0, 64, BufferOverflow.DROP_OLDEST);
        this._recognizerEvents = MutableSharedFlow;
        this.speechRecognizerEventFlow = FlowKt.asSharedFlow(MutableSharedFlow);
        this.recognizedListener = new EventHandler() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl$$ExternalSyntheticLambda0
            @Override // com.microsoft.cognitiveservices.speech.util.EventHandler
            public final void onEvent(Object obj, Object obj2) {
                SpeechRecognitionManagerImpl.recognizedListener$lambda$0(this.f$0, obj, (SpeechRecognitionEventArgs) obj2);
            }
        };
        this.recognizingListener = new EventHandler() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl$$ExternalSyntheticLambda1
            @Override // com.microsoft.cognitiveservices.speech.util.EventHandler
            public final void onEvent(Object obj, Object obj2) {
                SpeechRecognitionManagerImpl.recognizingListener$lambda$1(this.f$0, obj, (SpeechRecognitionEventArgs) obj2);
            }
        };
        this.recognitionSessionStarted = new EventHandler() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl$$ExternalSyntheticLambda2
            @Override // com.microsoft.cognitiveservices.speech.util.EventHandler
            public final void onEvent(Object obj, Object obj2) {
                SpeechRecognitionManagerImpl.recognitionSessionStarted$lambda$2(this.f$0, obj, (SessionEventArgs) obj2);
            }
        };
        this.recognitionSessionStopped = new EventHandler() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl$$ExternalSyntheticLambda3
            @Override // com.microsoft.cognitiveservices.speech.util.EventHandler
            public final void onEvent(Object obj, Object obj2) {
                SpeechRecognitionManagerImpl.recognitionSessionStopped$lambda$3(this.f$0, obj, (SessionEventArgs) obj2);
            }
        };
        this.recognitionSessionCancelled = new EventHandler() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl$$ExternalSyntheticLambda4
            @Override // com.microsoft.cognitiveservices.speech.util.EventHandler
            public final void onEvent(Object obj, Object obj2) {
                SpeechRecognitionManagerImpl.recognitionSessionCancelled$lambda$4(this.f$0, obj, (SpeechRecognitionCanceledEventArgs) obj2);
            }
        };
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.manager.SpeechRecognitionManager
    public StateFlow<SpeechRecognizerState> getSpeechRecognizerState() {
        return this.speechRecognizerState;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.manager.SpeechRecognitionManager
    public SharedFlow<SpeechRecognizerEvent> getSpeechRecognizerEventFlow() {
        return this.speechRecognizerEventFlow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void recognizedListener$lambda$0(SpeechRecognitionManagerImpl speechRecognitionManagerImpl, Object obj, SpeechRecognitionEventArgs speechRecognitionEventArgs) {
        String string = StringsKt.trim(speechRecognitionEventArgs.getResult().getText().toString()).toString();
        if (StringsKt.isBlank(string)) {
            return;
        }
        speechRecognitionManagerImpl._recognizerEvents.tryEmit(new SpeechRecognizerEvent.Recognized(string, string, LanguageEnum.ENGLISH, LanguageEnum.ENGLISH, null, null, 48, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void recognizingListener$lambda$1(SpeechRecognitionManagerImpl speechRecognitionManagerImpl, Object obj, SpeechRecognitionEventArgs speechRecognitionEventArgs) {
        speechRecognitionManagerImpl._speechRecognizerState.setValue(new SpeechRecognizerState.Recognizing(StringsKt.trim(speechRecognitionEventArgs.getResult().getText().toString()).toString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void recognitionSessionStarted$lambda$2(SpeechRecognitionManagerImpl speechRecognitionManagerImpl, Object obj, SessionEventArgs sessionEventArgs) {
        speechRecognitionManagerImpl.isRecognizing = true;
        speechRecognitionManagerImpl._speechRecognizerState.setValue(new SpeechRecognizerState.Recognizing(""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void recognitionSessionStopped$lambda$3(SpeechRecognitionManagerImpl speechRecognitionManagerImpl, Object obj, SessionEventArgs sessionEventArgs) {
        speechRecognitionManagerImpl.isRecognizing = false;
        speechRecognitionManagerImpl.speechRecogMicrophoneStream.stopListening();
        speechRecognitionManagerImpl.stopTokenRefresh();
        speechRecognitionManagerImpl._speechRecognizerState.setValue(SpeechRecognizerState.Idle.INSTANCE);
        speechRecognitionManagerImpl.releaseRecognizer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void recognitionSessionCancelled$lambda$4(SpeechRecognitionManagerImpl speechRecognitionManagerImpl, Object obj, SpeechRecognitionCanceledEventArgs speechRecognitionCanceledEventArgs) {
        speechRecognitionManagerImpl.isRecognizing = false;
        speechRecognitionManagerImpl.speechRecogMicrophoneStream.stopListening();
        speechRecognitionManagerImpl.stopTokenRefresh();
        speechRecognitionManagerImpl._speechRecognizerState.setValue(SpeechRecognizerState.Idle.INSTANCE);
        if (speechRecognitionCanceledEventArgs.getReason() == CancellationReason.Error) {
            speechRecognitionManagerImpl._recognizerEvents.tryEmit(new SpeechRecognizerEvent.Error(SpeechErrorType.TRANSCRIPTION_ERROR, speechRecognitionCanceledEventArgs.getErrorDetails()));
        }
        speechRecognitionManagerImpl.releaseRecognizer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:45:0x00c0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:46:0x00c1 A[Catch: Exception -> 0x0110, TryCatch #0 {Exception -> 0x0110, blocks: (B:15:0x0041, B:56:0x0107, B:20:0x005a, B:50:0x00d7, B:53:0x00e3, B:24:0x006b, B:43:0x00b6, B:46:0x00c1, B:27:0x0073, B:36:0x0098, B:39:0x00a3, B:30:0x007a, B:33:0x008a), top: B:59:0x0027 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:49:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:52:0x00e2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:53:0x00e3 A[Catch: Exception -> 0x0110, TryCatch #0 {Exception -> 0x0110, blocks: (B:15:0x0041, B:56:0x0107, B:20:0x005a, B:50:0x00d7, B:53:0x00e3, B:24:0x006b, B:43:0x00b6, B:46:0x00c1, B:27:0x0073, B:36:0x0098, B:39:0x00a3, B:30:0x007a, B:33:0x008a), top: B:59:0x0027 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0104, code lost:
    
        if (r10 == r0) goto L55;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object fetchCredentials(kotlin.coroutines.Continuation<? super kotlin.Pair<java.lang.String, java.lang.String>> r10) {
        /*
            Method dump skipped, instruction units count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.fetchCredentials(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object initializeRecognizer(Continuation<? super Boolean> continuation) {
        C02671 c02671;
        if (continuation instanceof C02671) {
            c02671 = (C02671) continuation;
            if ((c02671.label & Integer.MIN_VALUE) != 0) {
                c02671.label -= Integer.MIN_VALUE;
            } else {
                c02671 = new C02671(continuation);
            }
        } else {
            c02671 = new C02671(continuation);
        }
        Object objFetchCredentials = c02671.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c02671.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(objFetchCredentials);
            if (this.speechRecognizer != null) {
                return Boxing.boxBoolean(true);
            }
            c02671.label = 1;
            objFetchCredentials = fetchCredentials(c02671);
            if (objFetchCredentials == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objFetchCredentials);
        }
        Pair pair = (Pair) objFetchCredentials;
        if (pair == null) {
            return Boxing.boxBoolean(false);
        }
        try {
            this.speechConfig = SpeechConfig.fromAuthorizationToken((String) pair.component1(), (String) pair.component2());
            this.audioConfig = AudioConfig.fromStreamInput(this.speechRecogMicrophoneStream);
            SpeechRecognizer speechRecognizer = new SpeechRecognizer(this.speechConfig, this.audioConfig);
            speechRecognizer.sessionStarted.addEventListener(this.recognitionSessionStarted);
            speechRecognizer.recognized.addEventListener(this.recognizedListener);
            speechRecognizer.recognizing.addEventListener(this.recognizingListener);
            speechRecognizer.sessionStopped.addEventListener(this.recognitionSessionStopped);
            speechRecognizer.canceled.addEventListener(this.recognitionSessionCancelled);
            this.speechRecognizer = speechRecognizer;
        } catch (Exception unused) {
            releaseRecognizer();
            z = false;
        }
        return Boxing.boxBoolean(z);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl$startTokenRefresh$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SpeechRecognitionManagerImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl$startTokenRefresh$1", f = "SpeechRecognitionManagerImpl.kt", i = {0, 1}, l = {146, 147}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
    static final class C02701 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C02701(Continuation<? super C02701> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c02701 = SpeechRecognitionManagerImpl.this.new C02701(continuation);
            c02701.L$0 = obj;
            return c02701;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0055, code lost:
        
            if (r8 == r1) goto L20;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0055 -> B:21:0x0058). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = r7.L$0
                kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r7.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L22
                if (r2 == r4) goto L1e
                if (r2 != r3) goto L16
                kotlin.ResultKt.throwOnFailure(r8)
                goto L58
            L16:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L1e:
                kotlin.ResultKt.throwOnFailure(r8)
                goto L48
            L22:
                kotlin.ResultKt.throwOnFailure(r8)
            L25:
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl r8 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.this
                boolean r8 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.access$isRecognizing$p(r8)
                if (r8 == 0) goto L76
                kotlin.coroutines.CoroutineContext r8 = r0.getCoroutineContext()
                boolean r8 = kotlinx.coroutines.JobKt.isActive(r8)
                if (r8 == 0) goto L76
                r8 = r7
                kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
                r7.L$0 = r0
                r7.label = r4
                r5 = 540000(0x83d60, double:2.667954E-318)
                java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r5, r8)
                if (r8 != r1) goto L48
                goto L57
            L48:
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl r8 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.this
                r2 = r7
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                r7.L$0 = r0
                r7.label = r3
                java.lang.Object r8 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.access$fetchCredentials(r8, r2)
                if (r8 != r1) goto L58
            L57:
                return r1
            L58:
                kotlin.Pair r8 = (kotlin.Pair) r8
                if (r8 == 0) goto L25
                java.lang.Object r8 = r8.component1()
                java.lang.String r8 = (java.lang.String) r8
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl r2 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.this
                com.microsoft.cognitiveservices.speech.SpeechRecognizer r2 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.access$getSpeechRecognizer$p(r2)
                if (r2 == 0) goto L25
                com.microsoft.cognitiveservices.speech.PropertyCollection r2 = r2.getProperties()
                if (r2 == 0) goto L25
                com.microsoft.cognitiveservices.speech.PropertyId r5 = com.microsoft.cognitiveservices.speech.PropertyId.SpeechServiceAuthorization_Token
                r2.setProperty(r5, r8)
                goto L25
            L76:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.C02701.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startTokenRefresh() {
        Job job = this.tokenRefreshJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.tokenRefreshJob = BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new C02701(null), 3, (Object) null);
    }

    private final void stopTokenRefresh() {
        Job job = this.tokenRefreshJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.tokenRefreshJob = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void releaseRecognizer() {
        try {
            SpeechRecognizer speechRecognizer = this.speechRecognizer;
            if (speechRecognizer != null) {
                speechRecognizer.close();
            }
            AudioConfig audioConfig = this.audioConfig;
            if (audioConfig != null) {
                audioConfig.close();
            }
            SpeechConfig speechConfig = this.speechConfig;
            if (speechConfig != null) {
                speechConfig.close();
            }
        } catch (Exception unused) {
        } finally {
            this.speechRecognizer = null;
            this.audioConfig = null;
            this.speechConfig = null;
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl$startRecognizing$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SpeechRecognitionManagerImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl$startRecognizing$1", f = "SpeechRecognitionManagerImpl.kt", i = {}, l = {178, 188}, m = "invokeSuspend", n = {}, s = {})
    static final class C02691 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C02691(Continuation<? super C02691> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SpeechRecognitionManagerImpl.this.new C02691(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x008c, code lost:
        
            if (r5.this$0._recognizerEvents.emit(new com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechRecognizerEvent.Error(com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechErrorType.AUTH_FAILED, null, 2, null), (kotlin.coroutines.Continuation) r5) == r0) goto L26;
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
                r2 = 1
                r3 = 2
                if (r1 == 0) goto L1f
                if (r1 == r2) goto L1b
                if (r1 != r3) goto L13
                kotlin.ResultKt.throwOnFailure(r6)
                goto L8f
            L13:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L1b:
                kotlin.ResultKt.throwOnFailure(r6)
                goto L30
            L1f:
                kotlin.ResultKt.throwOnFailure(r6)
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.this
                r1 = r5
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r5.label = r2
                java.lang.Object r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.access$initializeRecognizer(r6, r1)
                if (r6 != r0) goto L30
                goto L8e
            L30:
                java.lang.Boolean r6 = (java.lang.Boolean) r6
                boolean r6 = r6.booleanValue()
                if (r6 == 0) goto L75
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.this
                com.microsoft.cognitiveservices.speech.SpeechRecognizer r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.access$getSpeechRecognizer$p(r6)
                if (r6 == 0) goto L75
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.this     // Catch: java.lang.Exception -> L5a
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.local.SpeechRecogMicrophoneStream r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.access$getSpeechRecogMicrophoneStream$p(r6)     // Catch: java.lang.Exception -> L5a
                r6.startListening()     // Catch: java.lang.Exception -> L5a
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.this     // Catch: java.lang.Exception -> L5a
                com.microsoft.cognitiveservices.speech.SpeechRecognizer r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.access$getSpeechRecognizer$p(r6)     // Catch: java.lang.Exception -> L5a
                if (r6 == 0) goto L54
                r6.startContinuousRecognitionAsync()     // Catch: java.lang.Exception -> L5a
            L54:
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.this     // Catch: java.lang.Exception -> L5a
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.access$startTokenRefresh(r6)     // Catch: java.lang.Exception -> L5a
                goto L9a
            L5a:
                r6 = move-exception
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl r0 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.this
                kotlinx.coroutines.flow.MutableSharedFlow r0 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.access$get_recognizerEvents$p(r0)
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechRecognizerEvent$Error r1 = new com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechRecognizerEvent$Error
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechErrorType r2 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechErrorType.START_FAILED
                java.lang.String r6 = r6.getMessage()
                r1.<init>(r2, r6)
                r0.tryEmit(r1)
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl r5 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.this
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.access$releaseRecognizer(r5)
                goto L9a
            L75:
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.this
                kotlinx.coroutines.flow.MutableSharedFlow r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.access$get_recognizerEvents$p(r6)
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechRecognizerEvent$Error r1 = new com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechRecognizerEvent$Error
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechErrorType r2 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechErrorType.AUTH_FAILED
                r4 = 0
                r1.<init>(r2, r4, r3, r4)
                r2 = r5
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                r5.label = r3
                java.lang.Object r6 = r6.emit(r1, r2)
                if (r6 != r0) goto L8f
            L8e:
                return r0
            L8f:
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl r5 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.this
                kotlinx.coroutines.flow.MutableStateFlow r5 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.access$get_speechRecognizerState$p(r5)
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechRecognizerState$Idle r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechRecognizerState.Idle.INSTANCE
                r5.setValue(r6)
            L9a:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.C02691.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.manager.SpeechRecognitionManager
    public void startRecognizing() {
        this._speechRecognizerState.setValue(SpeechRecognizerState.Starting.INSTANCE);
        BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new C02691(null), 3, (Object) null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl$recognizeOnceAsync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SpeechRecognitionManagerImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl$recognizeOnceAsync$1", f = "SpeechRecognitionManagerImpl.kt", i = {}, l = {198, 208}, m = "invokeSuspend", n = {}, s = {})
    static final class C02681 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C02681(Continuation<? super C02681> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SpeechRecognitionManagerImpl.this.new C02681(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x008c, code lost:
        
            if (r5.this$0._recognizerEvents.emit(new com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechRecognizerEvent.Error(com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechErrorType.AUTH_FAILED, null, 2, null), (kotlin.coroutines.Continuation) r5) == r0) goto L26;
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
                r2 = 1
                r3 = 2
                if (r1 == 0) goto L1f
                if (r1 == r2) goto L1b
                if (r1 != r3) goto L13
                kotlin.ResultKt.throwOnFailure(r6)
                goto L8f
            L13:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L1b:
                kotlin.ResultKt.throwOnFailure(r6)
                goto L30
            L1f:
                kotlin.ResultKt.throwOnFailure(r6)
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.this
                r1 = r5
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r5.label = r2
                java.lang.Object r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.access$initializeRecognizer(r6, r1)
                if (r6 != r0) goto L30
                goto L8e
            L30:
                java.lang.Boolean r6 = (java.lang.Boolean) r6
                boolean r6 = r6.booleanValue()
                if (r6 == 0) goto L75
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.this
                com.microsoft.cognitiveservices.speech.SpeechRecognizer r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.access$getSpeechRecognizer$p(r6)
                if (r6 == 0) goto L75
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.this     // Catch: java.lang.Exception -> L5a
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.local.SpeechRecogMicrophoneStream r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.access$getSpeechRecogMicrophoneStream$p(r6)     // Catch: java.lang.Exception -> L5a
                r6.startListening()     // Catch: java.lang.Exception -> L5a
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.this     // Catch: java.lang.Exception -> L5a
                com.microsoft.cognitiveservices.speech.SpeechRecognizer r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.access$getSpeechRecognizer$p(r6)     // Catch: java.lang.Exception -> L5a
                if (r6 == 0) goto L54
                r6.recognizeOnceAsync()     // Catch: java.lang.Exception -> L5a
            L54:
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.this     // Catch: java.lang.Exception -> L5a
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.access$startTokenRefresh(r6)     // Catch: java.lang.Exception -> L5a
                goto L9a
            L5a:
                r6 = move-exception
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl r0 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.this
                kotlinx.coroutines.flow.MutableSharedFlow r0 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.access$get_recognizerEvents$p(r0)
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechRecognizerEvent$Error r1 = new com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechRecognizerEvent$Error
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechErrorType r2 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechErrorType.START_FAILED
                java.lang.String r6 = r6.getMessage()
                r1.<init>(r2, r6)
                r0.tryEmit(r1)
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl r5 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.this
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.access$releaseRecognizer(r5)
                goto L9a
            L75:
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.this
                kotlinx.coroutines.flow.MutableSharedFlow r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.access$get_recognizerEvents$p(r6)
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechRecognizerEvent$Error r1 = new com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechRecognizerEvent$Error
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechErrorType r2 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechErrorType.AUTH_FAILED
                r4 = 0
                r1.<init>(r2, r4, r3, r4)
                r2 = r5
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                r5.label = r3
                java.lang.Object r6 = r6.emit(r1, r2)
                if (r6 != r0) goto L8f
            L8e:
                return r0
            L8f:
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl r5 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.this
                kotlinx.coroutines.flow.MutableStateFlow r5 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.access$get_speechRecognizerState$p(r5)
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechRecognizerState$Idle r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechRecognizerState.Idle.INSTANCE
                r5.setValue(r6)
            L9a:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.SpeechRecognitionManagerImpl.C02681.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.manager.SpeechRecognitionManager
    public void recognizeOnceAsync() {
        this._speechRecognizerState.setValue(SpeechRecognizerState.Starting.INSTANCE);
        BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new C02681(null), 3, (Object) null);
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.manager.SpeechRecognitionManager
    public void stopRecognizing() {
        try {
            stopTokenRefresh();
            if (this.speechRecognizer != null && this.isRecognizing) {
                this._speechRecognizerState.setValue(SpeechRecognizerState.Stopping.INSTANCE);
                SpeechRecognizer speechRecognizer = this.speechRecognizer;
                if (speechRecognizer != null) {
                    speechRecognizer.stopContinuousRecognitionAsync();
                    return;
                }
                return;
            }
            this._speechRecognizerState.setValue(SpeechRecognizerState.Idle.INSTANCE);
            releaseRecognizer();
        } catch (Exception e) {
            this._recognizerEvents.tryEmit(new SpeechRecognizerEvent.Error(SpeechErrorType.STOP_FAILED, e.getMessage()));
            releaseRecognizer();
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.manager.SpeechRecognitionManager
    public void cleanUp() {
        stopTokenRefresh();
        releaseRecognizer();
        this.speechRecogMicrophoneStream.close();
        CoroutineScopeKt.cancel$default(this.scope, (CancellationException) null, 1, (Object) null);
    }
}
