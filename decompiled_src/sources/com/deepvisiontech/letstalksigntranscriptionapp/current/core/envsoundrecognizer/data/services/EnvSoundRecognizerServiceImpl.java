package com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.services;

import android.content.Context;
import android.util.Log;
import com.azure.core.util.tracing.Tracer;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.audiorecorder.data.local.SharedAudioEngine;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.audiorecorder.domain.AudioStreamListener;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.EnvSoundRecogConstants;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.domain.services.EnvSoundRecognizerService;
import com.google.common.primitives.UnsignedBytes;
import com.google.mediapipe.tasks.audio.audioclassifier.AudioClassifier;
import com.google.mediapipe.tasks.components.containers.AudioData;
import com.google.mediapipe.tasks.components.containers.Category;
import com.google.mediapipe.tasks.core.BaseOptions;
import dagger.hilt.android.qualifiers.ApplicationContext;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: EnvSoundRecognizerServiceImpl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0007\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0014H\u0016J\u0014\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0#H\u0016J\b\u0010$\u001a\u00020\u001eH\u0016R\u0010\u0010\u0003\u001a\u00020\u00048\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/data/services/EnvSoundRecognizerServiceImpl;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/domain/services/EnvSoundRecognizerService;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/audiorecorder/domain/AudioStreamListener;", "context", "Landroid/content/Context;", "sharedAudioEngine", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/audiorecorder/data/local/SharedAudioEngine;", "<init>", "(Landroid/content/Context;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/audiorecorder/data/local/SharedAudioEngine;)V", "classifier", "Lcom/google/mediapipe/tasks/audio/audioclassifier/AudioClassifier;", "recognitionTimer", "Ljava/util/Timer;", "recognitionIntervalMillis", "", Tracer.SCOPE_KEY, "Lkotlinx/coroutines/CoroutineScope;", "audioWindow", "", "windowSize", "", "windowLock", "", "isListening", "", "currentFlowProducer", "Lkotlinx/coroutines/channels/SendChannel;", "", "Lcom/google/mediapipe/tasks/components/containers/Category;", "onAudioData", "", "audioData", "", "size", "startListening", "Lkotlinx/coroutines/flow/Flow;", "stopListening", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EnvSoundRecognizerServiceImpl implements EnvSoundRecognizerService, AudioStreamListener {
    public static final int $stable = 8;
    private float[] audioWindow;
    private AudioClassifier classifier;

    @ApplicationContext
    private final Context context;
    private SendChannel<? super List<? extends Category>> currentFlowProducer;
    private volatile boolean isListening;
    private final long recognitionIntervalMillis;
    private Timer recognitionTimer;
    private final CoroutineScope scope;
    private final SharedAudioEngine sharedAudioEngine;
    private final Object windowLock;
    private int windowSize;

    @Inject
    public EnvSoundRecognizerServiceImpl(@ApplicationContext Context context, SharedAudioEngine sharedAudioEngine) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sharedAudioEngine, "sharedAudioEngine");
        this.context = context;
        this.sharedAudioEngine = sharedAudioEngine;
        this.recognitionIntervalMillis = 1000L;
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(JobKt.Job$default((Job) null, 1, (Object) null)));
        this.audioWindow = new float[0];
        this.windowLock = new Object();
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.core.audiorecorder.domain.AudioStreamListener
    public void onAudioData(byte[] audioData, int size) {
        Intrinsics.checkNotNullParameter(audioData, "audioData");
        if (!this.isListening || this.windowSize == 0) {
            return;
        }
        int i = size / 2;
        float[] fArr = new float[i];
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = i2 * 2;
            fArr[i2] = ((audioData[i3 + 1] << 8) | (audioData[i3] & UnsignedBytes.MAX_VALUE)) / 32768.0f;
        }
        synchronized (this.windowLock) {
            int i4 = this.windowSize;
            if (i >= i4) {
                System.arraycopy(fArr, i - i4, this.audioWindow, 0, i4);
            } else {
                float[] fArr2 = this.audioWindow;
                System.arraycopy(fArr2, i, fArr2, 0, i4 - i);
                System.arraycopy(fArr, 0, this.audioWindow, this.windowSize - i, i);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.services.EnvSoundRecognizerServiceImpl$startListening$1, reason: invalid class name */
    /* JADX INFO: compiled from: EnvSoundRecognizerServiceImpl.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "", "Lcom/google/mediapipe/tasks/components/containers/Category;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.services.EnvSoundRecognizerServiceImpl$startListening$1", f = "EnvSoundRecognizerServiceImpl.kt", i = {0, 0, 0, 0}, l = {132}, m = "invokeSuspend", n = {"$this$callbackFlow", "classifierInstance", "audioDataFormat", "audioData"}, s = {"L$0", "L$1", "L$2", "L$3"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<ProducerScope<? super List<? extends Category>>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = EnvSoundRecognizerServiceImpl.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(ProducerScope<? super List<? extends Category>> producerScope, Continuation<? super Unit> continuation) {
            return create(producerScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            final SendChannel sendChannel = (ProducerScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                EnvSoundRecognizerServiceImpl.this.currentFlowProducer = sendChannel;
                EnvSoundRecognizerServiceImpl.this.isListening = true;
                try {
                    final AudioClassifier audioClassifierCreateFromOptions = AudioClassifier.createFromOptions(EnvSoundRecognizerServiceImpl.this.context, AudioClassifier.AudioClassifierOptions.builder().setBaseOptions(BaseOptions.builder().setModelAssetPath(EnvSoundRecogConstants.YAMNET_MODEL_FILE).build()).setMaxResults(Boxing.boxInt(5)).build());
                    EnvSoundRecognizerServiceImpl.this.classifier = audioClassifierCreateFromOptions;
                    EnvSoundRecognizerServiceImpl.this.windowSize = 15600;
                    AudioData.AudioDataFormat audioDataFormatBuild = AudioData.AudioDataFormat.builder().setNumOfChannels(1).setSampleRate(16000.0f).build();
                    final AudioData audioDataCreate = AudioData.create(audioDataFormatBuild, EnvSoundRecognizerServiceImpl.this.windowSize);
                    Object obj2 = EnvSoundRecognizerServiceImpl.this.windowLock;
                    EnvSoundRecognizerServiceImpl envSoundRecognizerServiceImpl = EnvSoundRecognizerServiceImpl.this;
                    synchronized (obj2) {
                        envSoundRecognizerServiceImpl.audioWindow = new float[envSoundRecognizerServiceImpl.windowSize];
                        Unit unit = Unit.INSTANCE;
                    }
                    EnvSoundRecognizerServiceImpl.this.sharedAudioEngine.addListener(EnvSoundRecognizerServiceImpl.this);
                    EnvSoundRecognizerServiceImpl.this.recognitionTimer = new Timer();
                    Timer timer = EnvSoundRecognizerServiceImpl.this.recognitionTimer;
                    if (timer != null) {
                        final EnvSoundRecognizerServiceImpl envSoundRecognizerServiceImpl2 = EnvSoundRecognizerServiceImpl.this;
                        timer.schedule(new TimerTask() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.services.EnvSoundRecognizerServiceImpl.startListening.1.2
                            @Override // java.util.TimerTask, java.lang.Runnable
                            public void run() {
                                BuildersKt.launch$default(envSoundRecognizerServiceImpl2.scope, (CoroutineContext) null, (CoroutineStart) null, new EnvSoundRecognizerServiceImpl$startListening$1$2$run$1(envSoundRecognizerServiceImpl2, audioDataCreate, audioClassifierCreateFromOptions, sendChannel, null), 3, (Object) null);
                            }
                        }, EnvSoundRecognizerServiceImpl.this.recognitionIntervalMillis, EnvSoundRecognizerServiceImpl.this.recognitionIntervalMillis);
                    }
                    final EnvSoundRecognizerServiceImpl envSoundRecognizerServiceImpl3 = EnvSoundRecognizerServiceImpl.this;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(sendChannel);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(audioClassifierCreateFromOptions);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(audioDataFormatBuild);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(audioDataCreate);
                    this.label = 1;
                    if (ProduceKt.awaitClose(sendChannel, new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.services.EnvSoundRecognizerServiceImpl$startListening$1$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            return EnvSoundRecognizerServiceImpl.AnonymousClass1.invokeSuspend$lambda$1(envSoundRecognizerServiceImpl3);
                        }
                    }, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } catch (Exception e) {
                    Exception exc = e;
                    Log.e("AudioRecognizerImpl", "Failed to initialize AudioClassifier", exc);
                    sendChannel.close(exc);
                    return Unit.INSTANCE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$1(EnvSoundRecognizerServiceImpl envSoundRecognizerServiceImpl) {
            envSoundRecognizerServiceImpl.stopListening();
            return Unit.INSTANCE;
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.domain.services.EnvSoundRecognizerService
    public Flow<List<Category>> startListening() {
        return FlowKt.callbackFlow(new AnonymousClass1(null));
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.domain.services.EnvSoundRecognizerService
    public void stopListening() {
        this.isListening = false;
        SendChannel<? super List<? extends Category>> sendChannel = this.currentFlowProducer;
        if (sendChannel != null) {
            SendChannel.DefaultImpls.close$default(sendChannel, (Throwable) null, 1, (Object) null);
        }
        this.currentFlowProducer = null;
        this.sharedAudioEngine.removeListener(this);
        Timer timer = this.recognitionTimer;
        if (timer != null) {
            timer.cancel();
        }
        this.recognitionTimer = null;
        AudioClassifier audioClassifier = this.classifier;
        if (audioClassifier != null) {
            audioClassifier.close();
        }
        this.classifier = null;
        synchronized (this.windowLock) {
            this.audioWindow = new float[0];
            this.windowSize = 0;
            Unit unit = Unit.INSTANCE;
        }
        Log.d("AudioRecognizerImpl", "Recognition stopped and resources released.");
    }
}
