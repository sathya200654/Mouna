package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversation;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.Conversation;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSessionRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: GetActiveOrNewConversationUseCase.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversation/GetActiveOrNewConversationUseCase;", "", "conversationSessionRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationSessionRepository;", "conversationRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationRepository;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationSessionRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/Conversation;", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GetActiveOrNewConversationUseCase {
    public static final int $stable = 0;
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String TAG = "GetActiveOrNewConversationUseCase";
    private final ConversationRepository conversationRepository;
    private final ConversationSessionRepository conversationSessionRepository;

    @Inject
    public GetActiveOrNewConversationUseCase(ConversationSessionRepository conversationSessionRepository, ConversationRepository conversationRepository) {
        Intrinsics.checkNotNullParameter(conversationSessionRepository, "conversationSessionRepository");
        Intrinsics.checkNotNullParameter(conversationRepository, "conversationRepository");
        this.conversationSessionRepository = conversationSessionRepository;
        this.conversationRepository = conversationRepository;
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversation.GetActiveOrNewConversationUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: GetActiveOrNewConversationUseCase.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversation.GetActiveOrNewConversationUseCase$invoke$1", f = "GetActiveOrNewConversationUseCase.kt", i = {1, 1, 2, 2, 2}, l = {26, 32, 38}, m = "invokeSuspend", n = {"currentId", "newConversation", "currentId", "newConversation", "response"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Long>, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GetActiveOrNewConversationUseCase.this.new AnonymousClass1(continuation);
        }

        public final Object invoke(FlowCollector<? super Long> flowCollector, Continuation<? super Unit> continuation) {
            return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
        /* JADX WARN: Code duplicated, block: B:28:0x008f A[Catch: Exception -> 0x00dd, TryCatch #0 {Exception -> 0x00dd, blocks: (B:8:0x001d, B:13:0x0032, B:26:0x0089, B:28:0x008f, B:30:0x0097, B:31:0x009a, B:33:0x009e, B:36:0x00cf, B:37:0x00d4, B:38:0x00d5, B:39:0x00dc, B:14:0x0036, B:20:0x0054, B:22:0x0058, B:17:0x003d), top: B:44:0x0009 }] */
        /* JADX WARN: Code duplicated, block: B:30:0x0097 A[Catch: Exception -> 0x00dd, TryCatch #0 {Exception -> 0x00dd, blocks: (B:8:0x001d, B:13:0x0032, B:26:0x0089, B:28:0x008f, B:30:0x0097, B:31:0x009a, B:33:0x009e, B:36:0x00cf, B:37:0x00d4, B:38:0x00d5, B:39:0x00dc, B:14:0x0036, B:20:0x0054, B:22:0x0058, B:17:0x003d), top: B:44:0x0009 }] */
        /* JADX WARN: Code duplicated, block: B:31:0x009a A[Catch: Exception -> 0x00dd, TryCatch #0 {Exception -> 0x00dd, blocks: (B:8:0x001d, B:13:0x0032, B:26:0x0089, B:28:0x008f, B:30:0x0097, B:31:0x009a, B:33:0x009e, B:36:0x00cf, B:37:0x00d4, B:38:0x00d5, B:39:0x00dc, B:14:0x0036, B:20:0x0054, B:22:0x0058, B:17:0x003d), top: B:44:0x0009 }] */
        /* JADX WARN: Code duplicated, block: B:33:0x009e A[Catch: Exception -> 0x00dd, TryCatch #0 {Exception -> 0x00dd, blocks: (B:8:0x001d, B:13:0x0032, B:26:0x0089, B:28:0x008f, B:30:0x0097, B:31:0x009a, B:33:0x009e, B:36:0x00cf, B:37:0x00d4, B:38:0x00d5, B:39:0x00dc, B:14:0x0036, B:20:0x0054, B:22:0x0058, B:17:0x003d), top: B:44:0x0009 }] */
        /* JADX WARN: Code duplicated, block: B:36:0x00cf A[Catch: Exception -> 0x00dd, TryCatch #0 {Exception -> 0x00dd, blocks: (B:8:0x001d, B:13:0x0032, B:26:0x0089, B:28:0x008f, B:30:0x0097, B:31:0x009a, B:33:0x009e, B:36:0x00cf, B:37:0x00d4, B:38:0x00d5, B:39:0x00dc, B:14:0x0036, B:20:0x0054, B:22:0x0058, B:17:0x003d), top: B:44:0x0009 }] */
        /* JADX WARN: Code duplicated, block: B:38:0x00d5 A[Catch: Exception -> 0x00dd, TryCatch #0 {Exception -> 0x00dd, blocks: (B:8:0x001d, B:13:0x0032, B:26:0x0089, B:28:0x008f, B:30:0x0097, B:31:0x009a, B:33:0x009e, B:36:0x00cf, B:37:0x00d4, B:38:0x00d5, B:39:0x00dc, B:14:0x0036, B:20:0x0054, B:22:0x0058, B:17:0x003d), top: B:44:0x0009 }] */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00cc, code lost:
        
            if (r13.this$0.conversationSessionRepository.setActiveConversation(((java.lang.Number) ((com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Success) r14).getData()).longValue(), (kotlin.coroutines.Continuation) r13) == r0) goto L35;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) throws kotlin.NoWhenBranchMatchedException {
            /*
                Method dump skipped, instruction units count: 235
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversation.GetActiveOrNewConversationUseCase.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Flow<Conversation> invoke() {
        return FlowKt.transformLatest(FlowKt.onStart(this.conversationSessionRepository.getActiveConversationId(), new AnonymousClass1(null)), new GetActiveOrNewConversationUseCase$invoke$$inlined$flatMapLatest$1(null, this));
    }

    /* JADX INFO: compiled from: GetActiveOrNewConversationUseCase.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversation/GetActiveOrNewConversationUseCase$Companion;", "", "<init>", "()V", "TAG", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
