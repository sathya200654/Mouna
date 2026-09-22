package com.deepvisiontech.letstalksigntranscriptionapp.current.app.domain.usecase;

import androidx.wear.compose.foundation.SwipeToRevealKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.audiorecorder.data.local.AudioOrchestrator;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.EnvSoundRecogConstants;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.YamnetClassMapper;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.domain.model.EnvironmentSound;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.domain.repository.EnvironmentSoundHistoryRepository;
import com.google.mediapipe.tasks.components.containers.Category;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: SendSoundEventsUseCase.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/app/domain/usecase/SendSoundEventsUseCase;", "", "audioOrchestrator", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/audiorecorder/data/local/AudioOrchestrator;", "historyRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/domain/repository/EnvironmentSoundHistoryRepository;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/audiorecorder/data/local/AudioOrchestrator;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/domain/repository/EnvironmentSoundHistoryRepository;)V", "lastSavedLabel", "", "lastSavedTime", "", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/domain/model/EnvironmentSound;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SendSoundEventsUseCase {
    public static final int $stable = 8;
    private final AudioOrchestrator audioOrchestrator;
    private final EnvironmentSoundHistoryRepository historyRepository;
    private String lastSavedLabel;
    private long lastSavedTime;

    @Inject
    public SendSoundEventsUseCase(AudioOrchestrator audioOrchestrator, EnvironmentSoundHistoryRepository environmentSoundHistoryRepository) {
        Intrinsics.checkNotNullParameter(audioOrchestrator, "audioOrchestrator");
        Intrinsics.checkNotNullParameter(environmentSoundHistoryRepository, "historyRepository");
        this.audioOrchestrator = audioOrchestrator;
        this.historyRepository = environmentSoundHistoryRepository;
    }

    public final Flow<EnvironmentSound> invoke() {
        final Flow envSoundEvents = this.audioOrchestrator.getEnvSoundEvents();
        return FlowKt.onEach(new Flow<EnvironmentSound>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.app.domain.usecase.SendSoundEventsUseCase$invoke$$inlined$map$1

            /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.app.domain.usecase.SendSoundEventsUseCase$invoke$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.app.domain.usecase.SendSoundEventsUseCase$invoke$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.app.domain.usecase.SendSoundEventsUseCase$invoke$$inlined$map$1$2", f = "SendSoundEventsUseCase.kt", i = {0, 0, 0, 0, 0}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    T next;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(continuation);
                    }
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        Iterator<T> it = ((List) obj).iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                next = (T) null;
                                break;
                            }
                            next = it.next();
                            Category category = (Category) next;
                            if (category.score() >= 0.3f && EnvSoundRecogConstants.INSTANCE.getLIST_OF_CURATED_LABELS().contains(category.categoryName())) {
                                break;
                            }
                        }
                        Category category2 = next;
                        EnvironmentSound map = category2 != null ? YamnetClassMapper.INSTANCE.map(category2) : null;
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(map, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = envSoundEvents.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, new AnonymousClass2(null));
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.app.domain.usecase.SendSoundEventsUseCase$invoke$2, reason: invalid class name */
    /* JADX INFO: compiled from: SendSoundEventsUseCase.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "sound", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/domain/model/EnvironmentSound;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.app.domain.usecase.SendSoundEventsUseCase$invoke$2", f = "SendSoundEventsUseCase.kt", i = {0, 0}, l = {36}, m = "invokeSuspend", n = {"sound", "currentTime"}, s = {"L$0", "J$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<EnvironmentSound, Continuation<? super Unit>, Object> {
        long J$0;
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass2 = SendSoundEventsUseCase.this.new AnonymousClass2(continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        public final Object invoke(EnvironmentSound environmentSound, Continuation<? super Unit> continuation) {
            return create(environmentSound, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            long j;
            EnvironmentSound environmentSound = (EnvironmentSound) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (environmentSound != null) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (!Intrinsics.areEqual(environmentSound.getLabel(), SendSoundEventsUseCase.this.lastSavedLabel) || jCurrentTimeMillis - SendSoundEventsUseCase.this.lastSavedTime > 3000) {
                        this.L$0 = environmentSound;
                        this.J$0 = jCurrentTimeMillis;
                        this.label = 1;
                        if (SendSoundEventsUseCase.this.historyRepository.savePrediction(environmentSound.getLabel(), environmentSound.getConfidence(), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        j = jCurrentTimeMillis;
                    }
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j = this.J$0;
            ResultKt.throwOnFailure(obj);
            SendSoundEventsUseCase.this.lastSavedLabel = environmentSound.getLabel();
            SendSoundEventsUseCase.this.lastSavedTime = j;
            return Unit.INSTANCE;
        }
    }
}
