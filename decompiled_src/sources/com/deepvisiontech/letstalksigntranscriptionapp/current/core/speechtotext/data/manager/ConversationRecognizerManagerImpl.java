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
import com.microsoft.cognitiveservices.speech.audio.AudioConfig;
import com.microsoft.cognitiveservices.speech.transcription.ConversationTranscriber;
import com.microsoft.cognitiveservices.speech.transcription.ConversationTranscriptionCanceledEventArgs;
import com.microsoft.cognitiveservices.speech.transcription.ConversationTranscriptionEventArgs;
import com.microsoft.cognitiveservices.speech.transcription.ConversationTranscriptionResult;
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

/* JADX INFO: compiled from: ConversationRecognizerManagerImpl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010-\u001a\u0010\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/\u0018\u00010.H\u0082@¢\u0006\u0002\u00100J\u000e\u00101\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u00100J\b\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u000203H\u0002J\b\u00105\u001a\u000203H\u0002J\b\u00106\u001a\u000203H\u0017J\b\u00107\u001a\u000203H\u0016J\b\u00108\u001a\u000203H\u0016J\b\u00109\u001a\u000203H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0!X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020)0%X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020)0%X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020,0%X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/data/manager/ConversationRecognizerManagerImpl;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/domain/manager/SpeechRecognitionManager;", "speechRecogMicrophoneStream", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/data/local/SpeechRecogMicrophoneStream;", "speechToTextRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/domain/repository/SpeechToTextRepository;", "sessionRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/data/local/SpeechRecogMicrophoneStream;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/domain/repository/SpeechToTextRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;)V", "speechRecognizer", "Lcom/microsoft/cognitiveservices/speech/transcription/ConversationTranscriber;", "audioConfig", "Lcom/microsoft/cognitiveservices/speech/audio/AudioConfig;", "speechConfig", "Lcom/microsoft/cognitiveservices/speech/SpeechConfig;", "tokenRefreshJob", "Lkotlinx/coroutines/Job;", Tracer.SCOPE_KEY, "Lkotlinx/coroutines/CoroutineScope;", "isRecognizing", "", "_recognizerEvents", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/domain/model/SpeechRecognizerEvent;", "speechRecognizerEventFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getSpeechRecognizerEventFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "_speechRecognizerState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/domain/model/SpeechRecognizerState;", "speechRecognizerState", "Lkotlinx/coroutines/flow/StateFlow;", "getSpeechRecognizerState", "()Lkotlinx/coroutines/flow/StateFlow;", "recognizedListener", "Lcom/microsoft/cognitiveservices/speech/util/EventHandler;", "Lcom/microsoft/cognitiveservices/speech/transcription/ConversationTranscriptionEventArgs;", "recognizingListener", "recognitionSessionStarted", "Lcom/microsoft/cognitiveservices/speech/SessionEventArgs;", "recognitionSessionStopped", "recognitionSessionCancelled", "Lcom/microsoft/cognitiveservices/speech/transcription/ConversationTranscriptionCanceledEventArgs;", "fetchCredentials", "Lkotlin/Pair;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initializeRecognizer", "startTokenRefresh", "", "stopTokenRefresh", "releaseRecognizer", "startRecognizing", "recognizeOnceAsync", "stopRecognizing", "cleanUp", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ConversationRecognizerManagerImpl implements SpeechRecognitionManager {
    public static final int $stable = 8;
    private final MutableSharedFlow<SpeechRecognizerEvent> _recognizerEvents;
    private final MutableStateFlow<SpeechRecognizerState> _speechRecognizerState;
    private AudioConfig audioConfig;
    private volatile boolean isRecognizing;
    private final EventHandler<ConversationTranscriptionCanceledEventArgs> recognitionSessionCancelled;
    private final EventHandler<SessionEventArgs> recognitionSessionStarted;
    private final EventHandler<SessionEventArgs> recognitionSessionStopped;
    private final EventHandler<ConversationTranscriptionEventArgs> recognizedListener;
    private final EventHandler<ConversationTranscriptionEventArgs> recognizingListener;
    private final CoroutineScope scope;
    private final SessionRepository sessionRepository;
    private SpeechConfig speechConfig;
    private final SpeechRecogMicrophoneStream speechRecogMicrophoneStream;
    private ConversationTranscriber speechRecognizer;
    private final SharedFlow<SpeechRecognizerEvent> speechRecognizerEventFlow;
    private final StateFlow<SpeechRecognizerState> speechRecognizerState;
    private final SpeechToTextRepository speechToTextRepository;
    private Job tokenRefreshJob;

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl$fetchCredentials$1, reason: invalid class name */
    /* JADX INFO: compiled from: ConversationRecognizerManagerImpl.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl", f = "ConversationRecognizerManagerImpl.kt", i = {0, 1, 1, 2, 2, 2, 3, 3, 3, 3}, l = {117, 118, 119, 121}, m = "fetchCredentials", n = {"customerId", "customerId", "deviceId", "customerId", "deviceId", "gmailId", "customerId", "deviceId", "gmailId", "userToken"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
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
            return ConversationRecognizerManagerImpl.this.fetchCredentials((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl$initializeRecognizer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationRecognizerManagerImpl.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl", f = "ConversationRecognizerManagerImpl.kt", i = {}, l = {133}, m = "initializeRecognizer", n = {}, s = {})
    static final class C02641 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C02641(Continuation<? super C02641> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ConversationRecognizerManagerImpl.this.initializeRecognizer((Continuation) this);
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.manager.SpeechRecognitionManager
    public void recognizeOnceAsync() {
    }

    public ConversationRecognizerManagerImpl(SpeechRecogMicrophoneStream speechRecogMicrophoneStream, SpeechToTextRepository speechToTextRepository, SessionRepository sessionRepository) {
        Intrinsics.checkNotNullParameter(speechRecogMicrophoneStream, "speechRecogMicrophoneStream");
        Intrinsics.checkNotNullParameter(speechToTextRepository, "speechToTextRepository");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        this.speechRecogMicrophoneStream = speechRecogMicrophoneStream;
        this.speechToTextRepository = speechToTextRepository;
        this.sessionRepository = sessionRepository;
        this.scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()));
        MutableSharedFlow<SpeechRecognizerEvent> MutableSharedFlow = SharedFlowKt.MutableSharedFlow(0, 64, BufferOverflow.DROP_OLDEST);
        this._recognizerEvents = MutableSharedFlow;
        this.speechRecognizerEventFlow = FlowKt.asSharedFlow(MutableSharedFlow);
        MutableStateFlow<SpeechRecognizerState> MutableStateFlow = StateFlowKt.MutableStateFlow(SpeechRecognizerState.Idle.INSTANCE);
        this._speechRecognizerState = MutableStateFlow;
        this.speechRecognizerState = FlowKt.asStateFlow(MutableStateFlow);
        this.recognizedListener = new EventHandler() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl$$ExternalSyntheticLambda0
            @Override // com.microsoft.cognitiveservices.speech.util.EventHandler
            public final void onEvent(Object obj, Object obj2) {
                ConversationRecognizerManagerImpl.recognizedListener$lambda$0(this.f$0, obj, (ConversationTranscriptionEventArgs) obj2);
            }
        };
        this.recognizingListener = new EventHandler() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl$$ExternalSyntheticLambda1
            @Override // com.microsoft.cognitiveservices.speech.util.EventHandler
            public final void onEvent(Object obj, Object obj2) {
                ConversationRecognizerManagerImpl.recognizingListener$lambda$1(this.f$0, obj, (ConversationTranscriptionEventArgs) obj2);
            }
        };
        this.recognitionSessionStarted = new EventHandler() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl$$ExternalSyntheticLambda2
            @Override // com.microsoft.cognitiveservices.speech.util.EventHandler
            public final void onEvent(Object obj, Object obj2) {
                ConversationRecognizerManagerImpl.recognitionSessionStarted$lambda$2(this.f$0, obj, (SessionEventArgs) obj2);
            }
        };
        this.recognitionSessionStopped = new EventHandler() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl$$ExternalSyntheticLambda3
            @Override // com.microsoft.cognitiveservices.speech.util.EventHandler
            public final void onEvent(Object obj, Object obj2) {
                ConversationRecognizerManagerImpl.recognitionSessionStopped$lambda$3(this.f$0, obj, (SessionEventArgs) obj2);
            }
        };
        this.recognitionSessionCancelled = new EventHandler() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl$$ExternalSyntheticLambda4
            @Override // com.microsoft.cognitiveservices.speech.util.EventHandler
            public final void onEvent(Object obj, Object obj2) {
                ConversationRecognizerManagerImpl.recognitionSessionCancelled$lambda$4(this.f$0, obj, (ConversationTranscriptionCanceledEventArgs) obj2);
            }
        };
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.manager.SpeechRecognitionManager
    public SharedFlow<SpeechRecognizerEvent> getSpeechRecognizerEventFlow() {
        return this.speechRecognizerEventFlow;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.manager.SpeechRecognitionManager
    public StateFlow<SpeechRecognizerState> getSpeechRecognizerState() {
        return this.speechRecognizerState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void recognizedListener$lambda$0(ConversationRecognizerManagerImpl conversationRecognizerManagerImpl, Object obj, ConversationTranscriptionEventArgs conversationTranscriptionEventArgs) {
        ConversationTranscriptionResult result = conversationTranscriptionEventArgs.getResult();
        String string = StringsKt.trim(result.getText().toString()).toString();
        String string2 = StringsKt.trim(result.getSpeakerId().toString()).toString();
        if (StringsKt.isBlank(string)) {
            return;
        }
        conversationRecognizerManagerImpl._recognizerEvents.tryEmit(new SpeechRecognizerEvent.Recognized(string, string, LanguageEnum.ENGLISH, LanguageEnum.ENGLISH, string2, null, 32, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void recognizingListener$lambda$1(ConversationRecognizerManagerImpl conversationRecognizerManagerImpl, Object obj, ConversationTranscriptionEventArgs conversationTranscriptionEventArgs) {
        String string = StringsKt.trim(conversationTranscriptionEventArgs.getResult().getText().toString()).toString();
        if (StringsKt.isBlank(string)) {
            return;
        }
        conversationRecognizerManagerImpl._speechRecognizerState.setValue(new SpeechRecognizerState.Recognizing(string));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void recognitionSessionStarted$lambda$2(ConversationRecognizerManagerImpl conversationRecognizerManagerImpl, Object obj, SessionEventArgs sessionEventArgs) {
        conversationRecognizerManagerImpl.isRecognizing = true;
        conversationRecognizerManagerImpl._speechRecognizerState.setValue(new SpeechRecognizerState.Recognizing(""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void recognitionSessionStopped$lambda$3(ConversationRecognizerManagerImpl conversationRecognizerManagerImpl, Object obj, SessionEventArgs sessionEventArgs) {
        conversationRecognizerManagerImpl.isRecognizing = false;
        conversationRecognizerManagerImpl.speechRecogMicrophoneStream.stopListening();
        conversationRecognizerManagerImpl.stopTokenRefresh();
        conversationRecognizerManagerImpl._speechRecognizerState.setValue(SpeechRecognizerState.Idle.INSTANCE);
        conversationRecognizerManagerImpl.releaseRecognizer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void recognitionSessionCancelled$lambda$4(ConversationRecognizerManagerImpl conversationRecognizerManagerImpl, Object obj, ConversationTranscriptionCanceledEventArgs conversationTranscriptionCanceledEventArgs) {
        conversationRecognizerManagerImpl.isRecognizing = false;
        conversationRecognizerManagerImpl.speechRecogMicrophoneStream.stopListening();
        conversationRecognizerManagerImpl.stopTokenRefresh();
        conversationRecognizerManagerImpl._speechRecognizerState.setValue(SpeechRecognizerState.Idle.INSTANCE);
        if (conversationTranscriptionCanceledEventArgs.getReason() == CancellationReason.Error) {
            conversationRecognizerManagerImpl._recognizerEvents.tryEmit(new SpeechRecognizerEvent.Error(SpeechErrorType.TRANSCRIPTION_ERROR, conversationTranscriptionCanceledEventArgs.getErrorDetails()));
        }
        conversationRecognizerManagerImpl.releaseRecognizer();
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
        throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl.fetchCredentials(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object initializeRecognizer(Continuation<? super Boolean> continuation) {
        C02641 c02641;
        if (continuation instanceof C02641) {
            c02641 = (C02641) continuation;
            if ((c02641.label & Integer.MIN_VALUE) != 0) {
                c02641.label -= Integer.MIN_VALUE;
            } else {
                c02641 = new C02641(continuation);
            }
        } else {
            c02641 = new C02641(continuation);
        }
        Object objFetchCredentials = c02641.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c02641.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(objFetchCredentials);
            if (this.speechRecognizer != null) {
                return Boxing.boxBoolean(true);
            }
            c02641.label = 1;
            objFetchCredentials = fetchCredentials(c02641);
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
            ConversationTranscriber conversationTranscriber = new ConversationTranscriber(this.speechConfig, this.audioConfig);
            conversationTranscriber.sessionStarted.addEventListener(this.recognitionSessionStarted);
            conversationTranscriber.transcribing.addEventListener(this.recognizingListener);
            conversationTranscriber.transcribed.addEventListener(this.recognizedListener);
            conversationTranscriber.sessionStopped.addEventListener(this.recognitionSessionStopped);
            conversationTranscriber.canceled.addEventListener(this.recognitionSessionCancelled);
            this.speechRecognizer = conversationTranscriber;
        } catch (Exception unused) {
            releaseRecognizer();
            z = false;
        }
        return Boxing.boxBoolean(z);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl$startTokenRefresh$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationRecognizerManagerImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl$startTokenRefresh$1", f = "ConversationRecognizerManagerImpl.kt", i = {0, 1}, l = {158, 159}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
    static final class C02661 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C02661(Continuation<? super C02661> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c02661 = ConversationRecognizerManagerImpl.this.new C02661(continuation);
            c02661.L$0 = obj;
            return c02661;
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
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl r8 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl.this
                boolean r8 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl.access$isRecognizing$p(r8)
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
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl r8 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl.this
                r2 = r7
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                r7.L$0 = r0
                r7.label = r3
                java.lang.Object r8 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl.access$fetchCredentials(r8, r2)
                if (r8 != r1) goto L58
            L57:
                return r1
            L58:
                kotlin.Pair r8 = (kotlin.Pair) r8
                if (r8 == 0) goto L25
                java.lang.Object r8 = r8.component1()
                java.lang.String r8 = (java.lang.String) r8
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl r2 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl.this
                com.microsoft.cognitiveservices.speech.transcription.ConversationTranscriber r2 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl.access$getSpeechRecognizer$p(r2)
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
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl.C02661.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startTokenRefresh() {
        Job job = this.tokenRefreshJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.tokenRefreshJob = BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new C02661(null), 3, (Object) null);
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
            ConversationTranscriber conversationTranscriber = this.speechRecognizer;
            if (conversationTranscriber != null) {
                conversationTranscriber.close();
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

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl$startRecognizing$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ConversationRecognizerManagerImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl$startRecognizing$1", f = "ConversationRecognizerManagerImpl.kt", i = {1}, l = {190, 196, 200}, m = "invokeSuspend", n = {"e"}, s = {"L$0"})
    static final class C02651 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C02651(Continuation<? super C02651> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ConversationRecognizerManagerImpl.this.new C02651(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x0086, code lost:
        
            if (r6.this$0._recognizerEvents.emit(new com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechRecognizerEvent.Error(com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechErrorType.START_FAILED, r7.getMessage()), (kotlin.coroutines.Continuation) r6) == r0) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00a6, code lost:
        
            if (r6.this$0._recognizerEvents.emit(new com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechRecognizerEvent.Error(com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechErrorType.AUTH_FAILED, null, 2, null), (kotlin.coroutines.Continuation) r6) == r0) goto L31;
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
                r3 = 1
                r4 = 2
                if (r1 == 0) goto L2a
                if (r1 == r3) goto L26
                if (r1 == r4) goto L1e
                if (r1 != r2) goto L16
                kotlin.ResultKt.throwOnFailure(r7)
                goto La9
            L16:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L1e:
                java.lang.Object r0 = r6.L$0
                java.lang.Exception r0 = (java.lang.Exception) r0
                kotlin.ResultKt.throwOnFailure(r7)
                goto L89
            L26:
                kotlin.ResultKt.throwOnFailure(r7)
                goto L3b
            L2a:
                kotlin.ResultKt.throwOnFailure(r7)
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl.this
                r1 = r6
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r6.label = r3
                java.lang.Object r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl.access$initializeRecognizer(r7, r1)
                if (r7 != r0) goto L3b
                goto La8
            L3b:
                java.lang.Boolean r7 = (java.lang.Boolean) r7
                boolean r7 = r7.booleanValue()
                if (r7 == 0) goto L8f
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl.this
                com.microsoft.cognitiveservices.speech.transcription.ConversationTranscriber r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl.access$getSpeechRecognizer$p(r7)
                if (r7 == 0) goto L8f
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl.this     // Catch: java.lang.Exception -> L65
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.local.SpeechRecogMicrophoneStream r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl.access$getSpeechRecogMicrophoneStream$p(r7)     // Catch: java.lang.Exception -> L65
                r7.startListening()     // Catch: java.lang.Exception -> L65
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl.this     // Catch: java.lang.Exception -> L65
                com.microsoft.cognitiveservices.speech.transcription.ConversationTranscriber r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl.access$getSpeechRecognizer$p(r7)     // Catch: java.lang.Exception -> L65
                if (r7 == 0) goto L5f
                r7.startTranscribingAsync()     // Catch: java.lang.Exception -> L65
            L5f:
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl.this     // Catch: java.lang.Exception -> L65
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl.access$startTokenRefresh(r7)     // Catch: java.lang.Exception -> L65
                goto Lb4
            L65:
                r7 = move-exception
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl r1 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl.this
                kotlinx.coroutines.flow.MutableSharedFlow r1 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl.access$get_recognizerEvents$p(r1)
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechRecognizerEvent$Error r2 = new com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechRecognizerEvent$Error
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechErrorType r3 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechErrorType.START_FAILED
                java.lang.String r5 = r7.getMessage()
                r2.<init>(r3, r5)
                r3 = r6
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
                r6.L$0 = r7
                r6.label = r4
                java.lang.Object r7 = r1.emit(r2, r3)
                if (r7 != r0) goto L89
                goto La8
            L89:
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl.this
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl.access$releaseRecognizer(r6)
                goto Lb4
            L8f:
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl.this
                kotlinx.coroutines.flow.MutableSharedFlow r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl.access$get_recognizerEvents$p(r7)
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechRecognizerEvent$Error r1 = new com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechRecognizerEvent$Error
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechErrorType r3 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechErrorType.AUTH_FAILED
                r5 = 0
                r1.<init>(r3, r5, r4, r5)
                r3 = r6
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                r6.label = r2
                java.lang.Object r7 = r7.emit(r1, r3)
                if (r7 != r0) goto La9
            La8:
                return r0
            La9:
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl.this
                kotlinx.coroutines.flow.MutableStateFlow r6 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl.access$get_speechRecognizerState$p(r6)
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechRecognizerState$Idle r7 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechRecognizerState.Idle.INSTANCE
                r6.setValue(r7)
            Lb4:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.manager.ConversationRecognizerManagerImpl.C02651.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.manager.SpeechRecognitionManager
    public void startRecognizing() {
        this._speechRecognizerState.setValue(SpeechRecognizerState.Starting.INSTANCE);
        BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new C02651(null), 3, (Object) null);
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.manager.SpeechRecognitionManager
    public void stopRecognizing() {
        try {
            stopTokenRefresh();
            if (this.speechRecognizer != null && this.isRecognizing) {
                this._speechRecognizerState.setValue(SpeechRecognizerState.Stopping.INSTANCE);
                ConversationTranscriber conversationTranscriber = this.speechRecognizer;
                if (conversationTranscriber != null) {
                    conversationTranscriber.stopTranscribingAsync();
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
