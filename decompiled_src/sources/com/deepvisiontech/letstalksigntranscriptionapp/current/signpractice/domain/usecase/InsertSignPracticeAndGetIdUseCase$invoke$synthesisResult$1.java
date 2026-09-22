package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase;

import android.net.Uri;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.texttospeech.TextToSpeechManagerEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;

/* JADX INFO: compiled from: InsertSignPracticeAndGetIdUseCase.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "Landroid/net/Uri;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase.InsertSignPracticeAndGetIdUseCase$invoke$synthesisResult$1", f = "InsertSignPracticeAndGetIdUseCase.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
final class InsertSignPracticeAndGetIdUseCase$invoke$synthesisResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ResponseResource<? extends Uri>>, Object> {
    final /* synthetic */ String $content;
    final /* synthetic */ LanguageEnum $language;
    final /* synthetic */ String $utteranceId;
    int label;
    final /* synthetic */ InsertSignPracticeAndGetIdUseCase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InsertSignPracticeAndGetIdUseCase$invoke$synthesisResult$1(InsertSignPracticeAndGetIdUseCase insertSignPracticeAndGetIdUseCase, String str, LanguageEnum languageEnum, String str2, Continuation<? super InsertSignPracticeAndGetIdUseCase$invoke$synthesisResult$1> continuation) {
        super(2, continuation);
        this.this$0 = insertSignPracticeAndGetIdUseCase;
        this.$content = str;
        this.$language = languageEnum;
        this.$utteranceId = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InsertSignPracticeAndGetIdUseCase$invoke$synthesisResult$1(this.this$0, this.$content, this.$language, this.$utteranceId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ResponseResource<? extends Uri>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase.InsertSignPracticeAndGetIdUseCase$invoke$synthesisResult$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: InsertSignPracticeAndGetIdUseCase.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "Landroid/net/Uri;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.usecase.InsertSignPracticeAndGetIdUseCase$invoke$synthesisResult$1$1", f = "InsertSignPracticeAndGetIdUseCase.kt", i = {0, 0}, l = {90}, m = "invokeSuspend", n = {"$this$coroutineScope", "synthesisResultJob"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ResponseResource<? extends Uri>>, Object> {
        final /* synthetic */ String $content;
        final /* synthetic */ LanguageEnum $language;
        final /* synthetic */ String $utteranceId;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ InsertSignPracticeAndGetIdUseCase this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(InsertSignPracticeAndGetIdUseCase insertSignPracticeAndGetIdUseCase, String str, LanguageEnum languageEnum, String str2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = insertSignPracticeAndGetIdUseCase;
            this.$content = str;
            this.$language = languageEnum;
            this.$utteranceId = str2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.this$0, this.$content, this.$language, this.$utteranceId, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ResponseResource<? extends Uri>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Deferred deferredAsync$default = BuildersKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new InsertSignPracticeAndGetIdUseCase$invoke$synthesisResult$1$1$synthesisResultJob$1(this.this$0, this.$utteranceId, null), 3, (Object) null);
                this.this$0.textToSpeechManager.synthesizeToFile(this.$content, this.$language, this.$utteranceId);
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(deferredAsync$default);
                this.label = 1;
                obj = deferredAsync$default.await((Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            TextToSpeechManagerEvent textToSpeechManagerEvent = (TextToSpeechManagerEvent) obj;
            if (textToSpeechManagerEvent instanceof TextToSpeechManagerEvent.Error.SynthesisFailed) {
                return new ResponseResource.Error(AppError.TextToSpeechFailed.INSTANCE);
            }
            if (textToSpeechManagerEvent instanceof TextToSpeechManagerEvent.SynthesisResult) {
                return new ResponseResource.Success(((TextToSpeechManagerEvent.SynthesisResult) textToSpeechManagerEvent).getUri());
            }
            return new ResponseResource.Error(AppError.TextToSpeechFailed.INSTANCE);
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
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new AnonymousClass1(this.this$0, this.$content, this.$language, this.$utteranceId, null), (Continuation) this);
        return objCoroutineScope == coroutine_suspended ? coroutine_suspended : objCoroutineScope;
    }
}
