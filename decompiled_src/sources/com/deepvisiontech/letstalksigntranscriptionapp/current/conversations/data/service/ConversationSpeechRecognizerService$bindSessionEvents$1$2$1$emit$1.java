package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service;

import com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.model.SpeechRecognizerEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: ConversationSpeechRecognizerService.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.service.ConversationSpeechRecognizerService$bindSessionEvents$1$2$1", f = "ConversationSpeechRecognizerService.kt", i = {0, 1}, l = {161, 163}, m = "emit", n = {"event", "event"}, s = {"L$0", "L$0"})
final class ConversationSpeechRecognizerService$bindSessionEvents$1$2$1$emit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConversationSpeechRecognizerService.C02331.AnonymousClass2.C00441<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ConversationSpeechRecognizerService$bindSessionEvents$1$2$1$emit$1(ConversationSpeechRecognizerService.C02331.AnonymousClass2.C00441<? super T> c00441, Continuation<? super ConversationSpeechRecognizerService$bindSessionEvents$1$2$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = c00441;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((SpeechRecognizerEvent) null, (Continuation<? super Unit>) this);
    }
}
