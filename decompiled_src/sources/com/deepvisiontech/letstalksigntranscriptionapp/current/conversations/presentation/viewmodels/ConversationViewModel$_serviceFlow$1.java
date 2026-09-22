package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationServiceState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.texttospeech.TextToSpeechManagerState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.data.manager.WebViewState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: ConversationViewModel.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ServiceState;", "speech", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/service/ConversationServiceState;", "web", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/data/manager/WebViewState;", "tts", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/texttospeech/TextToSpeechManagerState;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationViewModel$_serviceFlow$1", f = "ConversationViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ConversationViewModel$_serviceFlow$1 extends SuspendLambda implements Function4<ConversationServiceState, WebViewState, TextToSpeechManagerState, Continuation<? super ServiceState>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    int label;

    ConversationViewModel$_serviceFlow$1(Continuation<? super ConversationViewModel$_serviceFlow$1> continuation) {
        super(4, continuation);
    }

    public final Object invoke(ConversationServiceState conversationServiceState, WebViewState webViewState, TextToSpeechManagerState textToSpeechManagerState, Continuation<? super ServiceState> continuation) {
        ConversationViewModel$_serviceFlow$1 conversationViewModel$_serviceFlow$1 = new ConversationViewModel$_serviceFlow$1(continuation);
        conversationViewModel$_serviceFlow$1.L$0 = conversationServiceState;
        conversationViewModel$_serviceFlow$1.L$1 = webViewState;
        conversationViewModel$_serviceFlow$1.L$2 = textToSpeechManagerState;
        return conversationViewModel$_serviceFlow$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        ConversationServiceState conversationServiceState = (ConversationServiceState) this.L$0;
        WebViewState webViewState = (WebViewState) this.L$1;
        TextToSpeechManagerState textToSpeechManagerState = (TextToSpeechManagerState) this.L$2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return new ServiceState(conversationServiceState, webViewState, textToSpeechManagerState);
    }
}
