package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase;

import android.speech.tts.Voice;
import android.util.Log;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.local.mappers.LanguageMapper;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.ConversationMessage;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationMessageRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.texttospeech.TextToSpeechManager;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpeakConversationUseCase.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0086B¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/SpeakConversationUseCase;", "", "textToSpeechManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManager;", "conversationMessageRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationMessageRepository;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManager;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationMessageRepository;)V", "invoke", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "conversationMessage", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMessage;", "voice", "Landroid/speech/tts/Voice;", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMessage;Landroid/speech/tts/Voice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SpeakConversationUseCase {
    private static final String TAG = "SpeakConversationUseCase";
    private final ConversationMessageRepository conversationMessageRepository;
    private final TextToSpeechManager textToSpeechManager;
    public static final int $stable = TextToSpeechManager.$stable;

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.SpeakConversationUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: SpeakConversationUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.SpeakConversationUseCase", f = "SpeakConversationUseCase.kt", i = {0, 0, 0}, l = {23}, m = "invoke", n = {"conversationMessage", "voice", "processedMessage"}, s = {"L$0", "L$1", "L$2"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SpeakConversationUseCase.this.invoke(null, null, (Continuation) this);
        }
    }

    @Inject
    public SpeakConversationUseCase(TextToSpeechManager textToSpeechManager, ConversationMessageRepository conversationMessageRepository) {
        Intrinsics.checkNotNullParameter(textToSpeechManager, "textToSpeechManager");
        Intrinsics.checkNotNullParameter(conversationMessageRepository, "conversationMessageRepository");
        this.textToSpeechManager = textToSpeechManager;
        this.conversationMessageRepository = conversationMessageRepository;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object invoke(ConversationMessage conversationMessage, Voice voice, Continuation<? super ResponseResource<Unit>> continuation) {
        AnonymousClass1 anonymousClass1;
        ConversationMessage conversationMessage2;
        Voice voice2;
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
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ConversationMessage conversationMessageCopy$default = ConversationMessage.copy$default(conversationMessage, 0L, 0L, null, null, null, null, null, 0, null, null, null, true, false, 0L, 14335, null);
                ConversationMessageRepository conversationMessageRepository = this.conversationMessageRepository;
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(conversationMessage);
                anonymousClass1.L$1 = voice;
                anonymousClass1.L$2 = conversationMessageCopy$default;
                anonymousClass1.label = 1;
                if (conversationMessageRepository.updateConversationMessage(conversationMessageCopy$default, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                conversationMessage2 = conversationMessageCopy$default;
                voice2 = voice;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                conversationMessage2 = (ConversationMessage) anonymousClass1.L$2;
                Voice voice3 = (Voice) anonymousClass1.L$1;
                ResultKt.throwOnFailure(obj);
                voice2 = voice3;
            }
            TextToSpeechManager.speakText$default(this.textToSpeechManager, conversationMessage2.getProcessedMessage(), LanguageMapper.INSTANCE.toTranscriptionLang(conversationMessage2.getProcessedMessageLanguage()), voice2, 0, 8, null);
            return new ResponseResource.Success(Unit.INSTANCE);
        } catch (Exception e) {
            Log.e(TAG, "Failed to send conversation message to tts engine", e);
            return new ResponseResource.Error(AppError.UnknownError.INSTANCE);
        }
    }
}
