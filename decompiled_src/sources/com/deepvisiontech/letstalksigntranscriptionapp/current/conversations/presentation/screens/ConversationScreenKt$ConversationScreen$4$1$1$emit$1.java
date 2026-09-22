package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: ConversationScreen.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.screens.ConversationScreenKt$ConversationScreen$4$1$1", f = "ConversationScreen.kt", i = {0, 1}, l = {181, 186}, m = "emit", n = {"event", "event"}, s = {"L$0", "L$0"})
final class ConversationScreenKt$ConversationScreen$4$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConversationScreenKt$ConversationScreen$4$1.AnonymousClass1<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ConversationScreenKt$ConversationScreen$4$1$1$emit$1(ConversationScreenKt$ConversationScreen$4$1.AnonymousClass1<? super T> anonymousClass1, Continuation<? super ConversationScreenKt$ConversationScreen$4$1$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = anonymousClass1;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((ConversationUiEvent) null, (Continuation<? super Unit>) this);
    }
}
