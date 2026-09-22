package com.deepvisiontech.letstalksigntranscriptionapp.current.core.audiorecorder.data.local;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.azure.core.util.tracing.Tracer;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.repository.SettingsRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationServiceState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationSpeechRecognizerService;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.domain.services.EnvSoundRecognizerService;
import com.google.mediapipe.tasks.components.containers.Category;
import java.util.List;
import java.util.concurrent.CancellationException;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
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
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: compiled from: AudioOrchestrator.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Singleton
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0017J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010 \u001a\u00020\u001cH\u0003J\b\u0010!\u001a\u00020\u001cH\u0002J\b\u0010\"\u001a\u00020\u001cH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/audiorecorder/data/local/AudioOrchestrator;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "sharedAudioEngine", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/audiorecorder/data/local/SharedAudioEngine;", "speechRecognizerService", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/service/ConversationSpeechRecognizerService;", "envSoundRecognizerService", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/domain/services/EnvSoundRecognizerService;", "settingsRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/repository/SettingsRepository;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/audiorecorder/data/local/SharedAudioEngine;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/service/ConversationSpeechRecognizerService;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/domain/services/EnvSoundRecognizerService;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/repository/SettingsRepository;)V", Tracer.SCOPE_KEY, "Lkotlinx/coroutines/CoroutineScope;", "_envSoundEvents", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "Lcom/google/mediapipe/tasks/components/containers/Category;", "envSoundEvents", "Lkotlinx/coroutines/flow/SharedFlow;", "getEnvSoundEvents", "()Lkotlinx/coroutines/flow/SharedFlow;", "isOrchestratorActive", "", "envListeningJob", "Lkotlinx/coroutines/Job;", "stateObserverJob", "onStart", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onStop", "observeSpeechAndSettingsState", "startEnvSound", "stopEnvSound", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AudioOrchestrator implements DefaultLifecycleObserver {
    public static final int $stable = 8;
    private final MutableSharedFlow<List<Category>> _envSoundEvents;
    private Job envListeningJob;
    private final SharedFlow<List<Category>> envSoundEvents;
    private final EnvSoundRecognizerService envSoundRecognizerService;
    private boolean isOrchestratorActive;
    private final CoroutineScope scope;
    private final SettingsRepository settingsRepository;
    private final SharedAudioEngine sharedAudioEngine;
    private final ConversationSpeechRecognizerService speechRecognizerService;
    private Job stateObserverJob;

    public void onCreate(LifecycleOwner lifecycleOwner) {
        super.onCreate(lifecycleOwner);
    }

    public void onDestroy(LifecycleOwner lifecycleOwner) {
        super.onDestroy(lifecycleOwner);
    }

    public void onPause(LifecycleOwner lifecycleOwner) {
        super.onPause(lifecycleOwner);
    }

    public void onResume(LifecycleOwner lifecycleOwner) {
        super.onResume(lifecycleOwner);
    }

    @Inject
    public AudioOrchestrator(SharedAudioEngine sharedAudioEngine, ConversationSpeechRecognizerService conversationSpeechRecognizerService, EnvSoundRecognizerService envSoundRecognizerService, SettingsRepository settingsRepository) {
        Intrinsics.checkNotNullParameter(sharedAudioEngine, "sharedAudioEngine");
        Intrinsics.checkNotNullParameter(conversationSpeechRecognizerService, "speechRecognizerService");
        Intrinsics.checkNotNullParameter(envSoundRecognizerService, "envSoundRecognizerService");
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        this.sharedAudioEngine = sharedAudioEngine;
        this.speechRecognizerService = conversationSpeechRecognizerService;
        this.envSoundRecognizerService = envSoundRecognizerService;
        this.settingsRepository = settingsRepository;
        this.scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));
        MutableSharedFlow<List<Category>> mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 1, BufferOverflow.DROP_OLDEST, 1, (Object) null);
        this._envSoundEvents = mutableSharedFlowMutableSharedFlow$default;
        this.envSoundEvents = FlowKt.asSharedFlow(mutableSharedFlowMutableSharedFlow$default);
    }

    public final SharedFlow<List<Category>> getEnvSoundEvents() {
        return this.envSoundEvents;
    }

    public void onStart(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        if (this.isOrchestratorActive) {
            return;
        }
        this.isOrchestratorActive = true;
        observeSpeechAndSettingsState();
    }

    public void onStop(LifecycleOwner owner) throws InterruptedException {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.isOrchestratorActive = false;
        Job job = this.stateObserverJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        stopEnvSound();
        this.sharedAudioEngine.stopEngine();
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.core.audiorecorder.data.local.AudioOrchestrator$observeSpeechAndSettingsState$1, reason: invalid class name */
    /* JADX INFO: compiled from: AudioOrchestrator.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.core.audiorecorder.data.local.AudioOrchestrator$observeSpeechAndSettingsState$1", f = "AudioOrchestrator.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AudioOrchestrator.this.new AnonymousClass1(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow flowCombine = FlowKt.combine(AudioOrchestrator.this.speechRecognizerService.getServiceState(), AudioOrchestrator.this.settingsRepository.isEnvSoundRecognizerEnabled(), new C00461(null));
                final AudioOrchestrator audioOrchestrator = AudioOrchestrator.this;
                this.label = 1;
                if (flowCombine.collect(new FlowCollector() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.audiorecorder.data.local.AudioOrchestrator.observeSpeechAndSettingsState.1.2
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((Pair<? extends ConversationServiceState, Boolean>) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(Pair<? extends ConversationServiceState, Boolean> pair, Continuation<? super Unit> continuation) throws InterruptedException {
                        ConversationServiceState conversationServiceState = (ConversationServiceState) pair.component1();
                        boolean zBooleanValue = ((Boolean) pair.component2()).booleanValue();
                        if (!audioOrchestrator.isOrchestratorActive) {
                            return Unit.INSTANCE;
                        }
                        boolean z = ((conversationServiceState instanceof ConversationServiceState.Idle) || (conversationServiceState instanceof ConversationServiceState.Stopping)) ? false : true;
                        if (z || zBooleanValue) {
                            Boxing.boxBoolean(audioOrchestrator.sharedAudioEngine.startEngine());
                        } else {
                            audioOrchestrator.sharedAudioEngine.stopEngine();
                        }
                        if (!zBooleanValue || z) {
                            audioOrchestrator.stopEnvSound();
                        } else {
                            audioOrchestrator.startEnvSound();
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

        /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.core.audiorecorder.data.local.AudioOrchestrator$observeSpeechAndSettingsState$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: AudioOrchestrator.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/service/ConversationServiceState;", "", "speechState", "isEnvEnabled"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.core.audiorecorder.data.local.AudioOrchestrator$observeSpeechAndSettingsState$1$1", f = "AudioOrchestrator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00461 extends SuspendLambda implements Function3<ConversationServiceState, Boolean, Continuation<? super Pair<? extends ConversationServiceState, ? extends Boolean>>, Object> {
            /* synthetic */ Object L$0;
            /* synthetic */ boolean Z$0;
            int label;

            C00461(Continuation<? super C00461> continuation) {
                super(3, continuation);
            }

            public final Object invoke(ConversationServiceState conversationServiceState, boolean z, Continuation<? super Pair<? extends ConversationServiceState, Boolean>> continuation) {
                C00461 c00461 = new C00461(continuation);
                c00461.L$0 = conversationServiceState;
                c00461.Z$0 = z;
                return c00461.invokeSuspend(Unit.INSTANCE);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((ConversationServiceState) obj, ((Boolean) obj2).booleanValue(), (Continuation<? super Pair<? extends ConversationServiceState, Boolean>>) obj3);
            }

            public final Object invokeSuspend(Object obj) {
                ConversationServiceState conversationServiceState = (ConversationServiceState) this.L$0;
                boolean z = this.Z$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return new Pair(conversationServiceState, Boxing.boxBoolean(z));
            }
        }
    }

    private final void observeSpeechAndSettingsState() {
        Job job = this.stateObserverJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.stateObserverJob = BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startEnvSound() {
        Job job = this.envListeningJob;
        if (job == null || !job.isActive()) {
            this.envListeningJob = BuildersKt.launch$default(this.scope, Dispatchers.getIO(), (CoroutineStart) null, new C02621(null), 2, (Object) null);
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.core.audiorecorder.data.local.AudioOrchestrator$startEnvSound$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AudioOrchestrator.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.core.audiorecorder.data.local.AudioOrchestrator$startEnvSound$1", f = "AudioOrchestrator.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
    static final class C02621 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C02621(Continuation<? super C02621> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AudioOrchestrator.this.new C02621(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<List<Category>> flowStartListening = AudioOrchestrator.this.envSoundRecognizerService.startListening();
                final AudioOrchestrator audioOrchestrator = AudioOrchestrator.this;
                this.label = 1;
                if (flowStartListening.collect(new FlowCollector() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.audiorecorder.data.local.AudioOrchestrator.startEnvSound.1.1
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((List<? extends Category>) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(List<? extends Category> list, Continuation<? super Unit> continuation) {
                        audioOrchestrator._envSoundEvents.tryEmit(list);
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopEnvSound() {
        Job job = this.envListeningJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.envListeningJob = null;
    }
}
