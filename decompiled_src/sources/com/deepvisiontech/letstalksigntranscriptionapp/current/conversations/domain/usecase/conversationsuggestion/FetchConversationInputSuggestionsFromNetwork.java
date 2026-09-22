package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsuggestion;

import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.conversationsuggestion.ConversationSuggestionRepository;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FetchConversationInputSuggestionsFromNetwork.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Singleton
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH\u0086B¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationsuggestion/FetchConversationInputSuggestionsFromNetwork;", "", "conversationSuggestionRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/conversationsuggestion/ConversationSuggestionRepository;", "sessionRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/conversationsuggestion/ConversationSuggestionRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;)V", "invoke", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/ConversationSuggestion;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FetchConversationInputSuggestionsFromNetwork {
    public static final int $stable = 0;
    private final ConversationSuggestionRepository conversationSuggestionRepository;
    private final SessionRepository sessionRepository;

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsuggestion.FetchConversationInputSuggestionsFromNetwork$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: FetchConversationInputSuggestionsFromNetwork.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsuggestion.FetchConversationInputSuggestionsFromNetwork", f = "FetchConversationInputSuggestionsFromNetwork.kt", i = {0, 1, 1, 2, 2, 2, 3, 3, 3, 3}, l = {21, 22, 23, 25}, m = "invoke", n = {"customerId", "customerId", "deviceId", "customerId", "deviceId", "gmailId", "customerId", "deviceId", "gmailId", "token"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FetchConversationInputSuggestionsFromNetwork.this.invoke((Continuation) this);
        }
    }

    @Inject
    public FetchConversationInputSuggestionsFromNetwork(ConversationSuggestionRepository conversationSuggestionRepository, SessionRepository sessionRepository) {
        Intrinsics.checkNotNullParameter(conversationSuggestionRepository, "conversationSuggestionRepository");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        this.conversationSuggestionRepository = conversationSuggestionRepository;
        this.sessionRepository = sessionRepository;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:36:0x00da  */
    /* JADX WARN: Code duplicated, block: B:39:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:44:0x0116  */
    /* JADX WARN: Code duplicated, block: B:46:0x011a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:47:0x011b  */
    /* JADX WARN: Code duplicated, block: B:49:0x0123  */
    /* JADX WARN: Code duplicated, block: B:51:0x0128  */
    /* JADX WARN: Code duplicated, block: B:53:0x012e  */
    /* JADX WARN: Code duplicated, block: B:55:0x0132 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:56:0x0133  */
    /* JADX WARN: Code duplicated, block: B:58:0x013b  */
    /* JADX WARN: Code duplicated, block: B:60:0x0140  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0110, code lost:
    
        if (r9 == r0) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invoke(kotlin.coroutines.Continuation<? super com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource<? extends java.util.List<com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.conversationsuggestion.ConversationSuggestion>>> r9) {
        /*
            Method dump skipped, instruction units count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationsuggestion.FetchConversationInputSuggestionsFromNetwork.invoke(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
