package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.Conversation;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSessionRepository;
import java.util.Iterator;
import java.util.Set;
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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: DeleteConversationsUseCase.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0086B¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/DeleteConversationsUseCase;", "", "conversationSessionRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationSessionRepository;", "conversationRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationRepository;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationSessionRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationRepository;)V", "invoke", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "conversations", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/Conversation;", "(Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeleteConversationsUseCase {
    public static final int $stable = 0;
    private final ConversationRepository conversationRepository;
    private final ConversationSessionRepository conversationSessionRepository;

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.DeleteConversationsUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: DeleteConversationsUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.DeleteConversationsUseCase", f = "DeleteConversationsUseCase.kt", i = {0, 1, 1, 1, 2, 2, 2}, l = {15, 19, 21}, m = "invoke", n = {"conversations", "conversations", "activeConversation", "isActiveConversationInDeleteList", "conversations", "activeConversation", "isActiveConversationInDeleteList"}, s = {"L$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
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
            return DeleteConversationsUseCase.this.invoke(null, (Continuation) this);
        }
    }

    @Inject
    public DeleteConversationsUseCase(ConversationSessionRepository conversationSessionRepository, ConversationRepository conversationRepository) {
        Intrinsics.checkNotNullParameter(conversationSessionRepository, "conversationSessionRepository");
        Intrinsics.checkNotNullParameter(conversationRepository, "conversationRepository");
        this.conversationSessionRepository = conversationSessionRepository;
        this.conversationRepository = conversationRepository;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00d7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object invoke(Set<Conversation> set, Continuation<? super ResponseResource<Unit>> continuation) {
        AnonymousClass1 anonymousClass1;
        Long l;
        Object next;
        Conversation conversation;
        Set<Conversation> set2;
        Conversation conversation2;
        Object objDeleteConversations;
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
        Object objFirst = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objFirst);
            Flow<Long> activeConversationId = this.conversationSessionRepository.getActiveConversationId();
            anonymousClass1.L$0 = set;
            anonymousClass1.label = 1;
            objFirst = FlowKt.first(activeConversationId, anonymousClass1);
            if (objFirst != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            set = (Set) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objFirst);
        } else {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objFirst);
                return objFirst;
            }
            conversation2 = (Conversation) anonymousClass1.L$2;
            l = (Long) anonymousClass1.L$1;
            set2 = (Set) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objFirst);
        }
        conversation = conversation2;
        set = set2;
        ConversationRepository conversationRepository = this.conversationRepository;
        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(set);
        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(l);
        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(conversation);
        anonymousClass1.label = 3;
        objDeleteConversations = conversationRepository.deleteConversations(set, anonymousClass1);
        if (objDeleteConversations == coroutine_suspended) {
            return coroutine_suspended;
        }
        return objDeleteConversations;
        l = (Long) objFirst;
        Iterator<T> it = set.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            long id = ((Conversation) next).getId();
            if (l != null && id == l.longValue()) {
                break;
            }
        }
        conversation = (Conversation) next;
        if (conversation != null) {
            ConversationSessionRepository conversationSessionRepository = this.conversationSessionRepository;
            anonymousClass1.L$0 = set;
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(l);
            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(conversation);
            anonymousClass1.label = 2;
            if (conversationSessionRepository.clearActiveConversation(anonymousClass1) != coroutine_suspended) {
                set2 = set;
                conversation2 = conversation;
                conversation = conversation2;
                set = set2;
                ConversationRepository conversationRepository2 = this.conversationRepository;
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(set);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(l);
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(conversation);
                anonymousClass1.label = 3;
                objDeleteConversations = conversationRepository2.deleteConversations(set, anonymousClass1);
                if (objDeleteConversations == coroutine_suspended) {
                    return objDeleteConversations;
                }
            }
        } else {
            ConversationRepository conversationRepository3 = this.conversationRepository;
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(set);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(l);
            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(conversation);
            anonymousClass1.label = 3;
            objDeleteConversations = conversationRepository3.deleteConversations(set, anonymousClass1);
            if (objDeleteConversations == coroutine_suspended) {
                return objDeleteConversations;
            }
        }
        return coroutine_suspended;
    }
}
