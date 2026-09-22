package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings;

import android.speech.tts.Voice;
import androidx.wear.compose.foundation.SwipeToRevealKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.texttospeech.TextToSpeechManagerState;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: Merge.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0003H\n¨\u0006\u0006"}, d2 = {"<anonymous>", "", "R", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "kotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings.GetAvailableVoicesForLanguageUseCase$invoke$$inlined$flatMapLatest$1", f = "GetAvailableVoicesForLanguageUseCase.kt", i = {0, 0}, l = {189}, m = "invokeSuspend", n = {"$this$transformLatest", "it"}, s = {"L$0", "L$1"})
public final class GetAvailableVoicesForLanguageUseCase$invoke$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<? super List<? extends Voice>>, Locale, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ GetAvailableVoicesForLanguageUseCase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetAvailableVoicesForLanguageUseCase$invoke$$inlined$flatMapLatest$1(Continuation continuation, GetAvailableVoicesForLanguageUseCase getAvailableVoicesForLanguageUseCase) {
        super(3, continuation);
        this.this$0 = getAvailableVoicesForLanguageUseCase;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((FlowCollector<? super List<? extends Voice>>) obj, (Locale) obj2, (Continuation<? super Unit>) obj3);
    }

    public final Object invoke(FlowCollector<? super List<? extends Voice>> flowCollector, Locale locale, Continuation<? super Unit> continuation) {
        GetAvailableVoicesForLanguageUseCase$invoke$$inlined$flatMapLatest$1 getAvailableVoicesForLanguageUseCase$invoke$$inlined$flatMapLatest$1 = new GetAvailableVoicesForLanguageUseCase$invoke$$inlined$flatMapLatest$1(continuation, this.this$0);
        getAvailableVoicesForLanguageUseCase$invoke$$inlined$flatMapLatest$1.L$0 = flowCollector;
        getAvailableVoicesForLanguageUseCase$invoke$$inlined$flatMapLatest$1.L$1 = locale;
        return getAvailableVoicesForLanguageUseCase$invoke$$inlined$flatMapLatest$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Object obj2 = this.L$1;
            final Locale locale = (Locale) obj2;
            final Flow textToSpeechManagerState = this.this$0.textToSpeechManager.getTextToSpeechManagerState();
            Flow<List<? extends Voice>> flow = new Flow<List<? extends Voice>>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings.GetAvailableVoicesForLanguageUseCase$invoke$lambda$3$$inlined$map$1

                /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings.GetAvailableVoicesForLanguageUseCase$invoke$lambda$3$$inlined$map$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ Locale $activeLocale$inlined;
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings.GetAvailableVoicesForLanguageUseCase$invoke$lambda$3$$inlined$map$1$2$1, reason: invalid class name */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsettings.GetAvailableVoicesForLanguageUseCase$invoke$lambda$3$$inlined$map$1$2", f = "GetAvailableVoicesForLanguageUseCase.kt", i = {0, 0, 0, 0, 0}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
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

                    public AnonymousClass2(FlowCollector flowCollector, Locale locale) {
                        this.$this_unsafeFlow = flowCollector;
                        this.$activeLocale$inlined = locale;
                    }

                    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                    public final Object emit(Object obj, Continuation continuation) {
                        AnonymousClass1 anonymousClass1;
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
                            List<Voice> voices = ((TextToSpeechManagerState) obj).getVoices();
                            ArrayList arrayList = new ArrayList();
                            for (T t : voices) {
                                if (Intrinsics.areEqual(((Voice) t).getLocale(), this.$activeLocale$inlined)) {
                                    arrayList.add(t);
                                }
                            }
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(arrayList, anonymousClass1) == coroutine_suspended) {
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

                public Object collect(FlowCollector flowCollector2, Continuation continuation) {
                    Object objCollect = textToSpeechManagerState.collect(new AnonymousClass2(flowCollector2, locale), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }
            };
            this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
            this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
            this.label = 1;
            if (FlowKt.emitAll(flowCollector, flow, (Continuation) this) == coroutine_suspended) {
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
