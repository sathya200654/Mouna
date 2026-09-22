package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.core.texttospeech.TextToSpeechManagerEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: InsertSignPracticeAndGetIdUseCase.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManagerEvent;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase.InsertSignPracticeAndGetIdUseCase$invoke$synthesisResult$1$1$synthesisResultJob$1", f = "InsertSignPracticeAndGetIdUseCase.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {})
final class InsertSignPracticeAndGetIdUseCase$invoke$synthesisResult$1$1$synthesisResultJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super TextToSpeechManagerEvent>, Object> {
    final /* synthetic */ String $utteranceId;
    int label;
    final /* synthetic */ InsertSignPracticeAndGetIdUseCase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InsertSignPracticeAndGetIdUseCase$invoke$synthesisResult$1$1$synthesisResultJob$1(InsertSignPracticeAndGetIdUseCase insertSignPracticeAndGetIdUseCase, String str, Continuation<? super InsertSignPracticeAndGetIdUseCase$invoke$synthesisResult$1$1$synthesisResultJob$1> continuation) {
        super(2, continuation);
        this.this$0 = insertSignPracticeAndGetIdUseCase;
        this.$utteranceId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InsertSignPracticeAndGetIdUseCase$invoke$synthesisResult$1$1$synthesisResultJob$1(this.this$0, this.$utteranceId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super TextToSpeechManagerEvent> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase.InsertSignPracticeAndGetIdUseCase$invoke$synthesisResult$1$1$synthesisResultJob$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: InsertSignPracticeAndGetIdUseCase.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "event", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManagerEvent;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase.InsertSignPracticeAndGetIdUseCase$invoke$synthesisResult$1$1$synthesisResultJob$1$1", f = "InsertSignPracticeAndGetIdUseCase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<TextToSpeechManagerEvent, Continuation<? super Boolean>, Object> {
        final /* synthetic */ String $utteranceId;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$utteranceId = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$utteranceId, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(TextToSpeechManagerEvent textToSpeechManagerEvent, Continuation<? super Boolean> continuation) {
            return create(textToSpeechManagerEvent, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            boolean zAreEqual;
            TextToSpeechManagerEvent textToSpeechManagerEvent = (TextToSpeechManagerEvent) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (textToSpeechManagerEvent instanceof TextToSpeechManagerEvent.Error.SynthesisFailed) {
                zAreEqual = Intrinsics.areEqual(((TextToSpeechManagerEvent.Error.SynthesisFailed) textToSpeechManagerEvent).getUtteranceId(), this.$utteranceId);
            } else {
                zAreEqual = textToSpeechManagerEvent instanceof TextToSpeechManagerEvent.SynthesisResult ? Intrinsics.areEqual(((TextToSpeechManagerEvent.SynthesisResult) textToSpeechManagerEvent).getUtteranceId(), this.$utteranceId) : false;
            }
            return Boxing.boxBoolean(zAreEqual);
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        this.label = 1;
        Object objFirst = FlowKt.first(this.this$0.textToSpeechManager.getTextToSpeechManagerEvent(), new AnonymousClass1(this.$utteranceId, null), (Continuation) this);
        return objFirst == coroutine_suspended ? coroutine_suspended : objFirst;
    }
}
