package com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.services;

import android.util.Log;
import com.google.mediapipe.tasks.audio.audioclassifier.AudioClassifier;
import com.google.mediapipe.tasks.components.containers.AudioData;
import com.google.mediapipe.tasks.components.containers.Category;
import com.google.mediapipe.tasks.components.containers.ClassificationResult;
import com.google.mediapipe.tasks.components.containers.Classifications;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProducerScope;

/* JADX INFO: compiled from: EnvSoundRecognizerServiceImpl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.services.EnvSoundRecognizerServiceImpl$startListening$1$2$run$1", f = "EnvSoundRecognizerServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class EnvSoundRecognizerServiceImpl$startListening$1$2$run$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ProducerScope<List<? extends Category>> $$this$callbackFlow;
    final /* synthetic */ AudioData $audioData;
    final /* synthetic */ AudioClassifier $classifierInstance;
    int label;
    final /* synthetic */ EnvSoundRecognizerServiceImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    EnvSoundRecognizerServiceImpl$startListening$1$2$run$1(EnvSoundRecognizerServiceImpl envSoundRecognizerServiceImpl, AudioData audioData, AudioClassifier audioClassifier, ProducerScope<? super List<? extends Category>> producerScope, Continuation<? super EnvSoundRecognizerServiceImpl$startListening$1$2$run$1> continuation) {
        super(2, continuation);
        this.this$0 = envSoundRecognizerServiceImpl;
        this.$audioData = audioData;
        this.$classifierInstance = audioClassifier;
        this.$$this$callbackFlow = producerScope;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EnvSoundRecognizerServiceImpl$startListening$1$2$run$1(this.this$0, this.$audioData, this.$classifierInstance, this.$$this$callbackFlow, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                float[] fArr = new float[this.this$0.windowSize];
                Object obj2 = this.this$0.windowLock;
                EnvSoundRecognizerServiceImpl envSoundRecognizerServiceImpl = this.this$0;
                synchronized (obj2) {
                    System.arraycopy(envSoundRecognizerServiceImpl.audioWindow, 0, fArr, 0, envSoundRecognizerServiceImpl.windowSize);
                    Unit unit = Unit.INSTANCE;
                }
                this.$audioData.load(fArr, 0, this.this$0.windowSize);
                List<ClassificationResult> listClassificationResults = this.$classifierInstance.classify(this.$audioData).classificationResults();
                Intrinsics.checkNotNull(listClassificationResults);
                if (!listClassificationResults.isEmpty()) {
                    List<Classifications> listClassifications = listClassificationResults.get(0).classifications();
                    Intrinsics.checkNotNullExpressionValue(listClassifications, "classifications(...)");
                    if (!listClassifications.isEmpty()) {
                        List<Category> listCategories = listClassificationResults.get(0).classifications().get(0).categories();
                        Intrinsics.checkNotNull(listCategories);
                        if (!listCategories.isEmpty()) {
                            this.$$this$callbackFlow.trySend-JP2dKIU(listCategories);
                        }
                    }
                }
            } catch (Exception e) {
                Log.e("AudioRecognizerImpl", "Classification error: " + e);
                this.this$0.stopListening();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
