package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.Conversation;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSessionRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InsertAndSetActiveConversationUseCase.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0086B¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/InsertAndSetActiveConversationUseCase;", "", "conversationRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationRepository;", "conversationSessionRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationSessionRepository;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationSessionRepository;)V", "invoke", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "conversationName", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InsertAndSetActiveConversationUseCase {
    public static final int $stable = 0;
    private final ConversationRepository conversationRepository;
    private final ConversationSessionRepository conversationSessionRepository;

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.InsertAndSetActiveConversationUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: InsertAndSetActiveConversationUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.InsertAndSetActiveConversationUseCase", f = "InsertAndSetActiveConversationUseCase.kt", i = {0, 0, 1, 1, 1}, l = {22, 23}, m = "invoke", n = {"conversationName", "conversation", "conversationName", "conversation", "conversationId"}, s = {"L$0", "L$1", "L$0", "L$1", "J$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InsertAndSetActiveConversationUseCase.this.invoke(null, (Continuation) this);
        }
    }

    @Inject
    public InsertAndSetActiveConversationUseCase(ConversationRepository conversationRepository, ConversationSessionRepository conversationSessionRepository) {
        Intrinsics.checkNotNullParameter(conversationRepository, "conversationRepository");
        Intrinsics.checkNotNullParameter(conversationSessionRepository, "conversationSessionRepository");
        this.conversationRepository = conversationRepository;
        this.conversationSessionRepository = conversationSessionRepository;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object invoke(String str, Continuation<? super ResponseResource<Unit>> continuation) throws NoWhenBranchMatchedException {
        AnonymousClass1 anonymousClass1;
        String str2;
        Conversation conversation;
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
        Object objInsertConversationAndGetId = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objInsertConversationAndGetId);
            Conversation conversation2 = new Conversation(0L, str, false, System.currentTimeMillis(), 4, null);
            ConversationRepository conversationRepository = this.conversationRepository;
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(conversation2);
            anonymousClass1.label = 1;
            objInsertConversationAndGetId = conversationRepository.insertConversationAndGetId(conversation2, anonymousClass1);
            if (objInsertConversationAndGetId != coroutine_suspended) {
                str2 = str;
                conversation = conversation2;
            }
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long j = anonymousClass1.J$0;
            ResultKt.throwOnFailure(objInsertConversationAndGetId);
            return objInsertConversationAndGetId;
        }
        conversation = (Conversation) anonymousClass1.L$1;
        str2 = (String) anonymousClass1.L$0;
        ResultKt.throwOnFailure(objInsertConversationAndGetId);
        ResponseResource responseResource = (ResponseResource) objInsertConversationAndGetId;
        if (responseResource instanceof ResponseResource.Success) {
            long jLongValue = ((Number) ((ResponseResource.Success) responseResource).getData()).longValue();
            ConversationSessionRepository conversationSessionRepository = this.conversationSessionRepository;
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str2);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(conversation);
            anonymousClass1.J$0 = jLongValue;
            anonymousClass1.label = 2;
            Object activeConversation = conversationSessionRepository.setActiveConversation(jLongValue, anonymousClass1);
            return activeConversation == coroutine_suspended ? coroutine_suspended : activeConversation;
        }
        if (responseResource instanceof ResponseResource.Error) {
            return responseResource;
        }
        if (Intrinsics.areEqual(responseResource, ResponseResource.Loading.INSTANCE)) {
            return ResponseResource.Loading.INSTANCE;
        }
        throw new NoWhenBranchMatchedException();
    }
}
