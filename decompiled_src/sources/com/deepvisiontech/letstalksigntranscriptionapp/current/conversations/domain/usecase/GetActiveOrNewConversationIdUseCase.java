package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationSessionRepository;
import com.google.protobuf.DescriptorProtos;
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

/* JADX INFO: compiled from: GetActiveOrNewConversationIdUseCase.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/GetActiveOrNewConversationIdUseCase;", "", "conversationSessionRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationSessionRepository;", "conversationRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationRepository;", "analyticsManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationSessionRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GetActiveOrNewConversationIdUseCase {

    @Deprecated
    public static final String TAG = "GetActiveOrNewConversationUseCase";
    private final AnalyticsManager analyticsManager;
    private final ConversationRepository conversationRepository;
    private final ConversationSessionRepository conversationSessionRepository;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = AnalyticsManager.$stable;

    @Inject
    public GetActiveOrNewConversationIdUseCase(ConversationSessionRepository conversationSessionRepository, ConversationRepository conversationRepository, AnalyticsManager analyticsManager) {
        Intrinsics.checkNotNullParameter(conversationSessionRepository, "conversationSessionRepository");
        Intrinsics.checkNotNullParameter(conversationRepository, "conversationRepository");
        Intrinsics.checkNotNullParameter(analyticsManager, "analyticsManager");
        this.conversationSessionRepository = conversationSessionRepository;
        this.conversationRepository = conversationRepository;
        this.analyticsManager = analyticsManager;
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.GetActiveOrNewConversationIdUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: GetActiveOrNewConversationIdUseCase.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.GetActiveOrNewConversationIdUseCase$invoke$1", f = "GetActiveOrNewConversationIdUseCase.kt", i = {0, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4}, l = {23, DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER, DescriptorProtos.MethodOptions.IDEMPOTENCY_LEVEL_FIELD_NUMBER, DescriptorProtos.FileOptions.SWIFT_PREFIX_FIELD_NUMBER, 47}, m = "invokeSuspend", n = {"$this$onStart", "$this$onStart", "currentId", "newConversation", "$this$onStart", "currentId", "newConversation", "response", "newId", "$this$onStart", "currentId", "newConversation", "response", "$this$onStart", "e"}, s = {"L$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Long>, Continuation<? super Unit>, Object> {
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = GetActiveOrNewConversationIdUseCase.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(FlowCollector<? super Long> flowCollector, Continuation<? super Unit> continuation) {
            return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
        /* JADX WARN: Code duplicated, block: B:36:0x00c9 A[Catch: Exception -> 0x006a, TryCatch #0 {Exception -> 0x006a, blocks: (B:13:0x003f, B:16:0x0050, B:39:0x00ff, B:19:0x005d, B:34:0x00c3, B:36:0x00c9, B:40:0x010d, B:42:0x0111, B:45:0x0148, B:48:0x014d, B:49:0x0152, B:20:0x0064, B:28:0x0089, B:30:0x008d, B:25:0x0070), top: B:55:0x0016 }] */
        /* JADX WARN: Code duplicated, block: B:38:0x00fd  */
        /* JADX WARN: Code duplicated, block: B:40:0x010d A[Catch: Exception -> 0x006a, TryCatch #0 {Exception -> 0x006a, blocks: (B:13:0x003f, B:16:0x0050, B:39:0x00ff, B:19:0x005d, B:34:0x00c3, B:36:0x00c9, B:40:0x010d, B:42:0x0111, B:45:0x0148, B:48:0x014d, B:49:0x0152, B:20:0x0064, B:28:0x0089, B:30:0x008d, B:25:0x0070), top: B:55:0x0016 }] */
        /* JADX WARN: Code duplicated, block: B:42:0x0111 A[Catch: Exception -> 0x006a, TryCatch #0 {Exception -> 0x006a, blocks: (B:13:0x003f, B:16:0x0050, B:39:0x00ff, B:19:0x005d, B:34:0x00c3, B:36:0x00c9, B:40:0x010d, B:42:0x0111, B:45:0x0148, B:48:0x014d, B:49:0x0152, B:20:0x0064, B:28:0x0089, B:30:0x008d, B:25:0x0070), top: B:55:0x0016 }] */
        /* JADX WARN: Code duplicated, block: B:44:0x0147  */
        /* JADX WARN: Code duplicated, block: B:45:0x0148 A[Catch: Exception -> 0x006a, TryCatch #0 {Exception -> 0x006a, blocks: (B:13:0x003f, B:16:0x0050, B:39:0x00ff, B:19:0x005d, B:34:0x00c3, B:36:0x00c9, B:40:0x010d, B:42:0x0111, B:45:0x0148, B:48:0x014d, B:49:0x0152, B:20:0x0064, B:28:0x0089, B:30:0x008d, B:25:0x0070), top: B:55:0x0016 }] */
        /* JADX WARN: Code duplicated, block: B:47:0x014c  */
        /* JADX WARN: Code duplicated, block: B:48:0x014d A[Catch: Exception -> 0x006a, TryCatch #0 {Exception -> 0x006a, blocks: (B:13:0x003f, B:16:0x0050, B:39:0x00ff, B:19:0x005d, B:34:0x00c3, B:36:0x00c9, B:40:0x010d, B:42:0x0111, B:45:0x0148, B:48:0x014d, B:49:0x0152, B:20:0x0064, B:28:0x0089, B:30:0x008d, B:25:0x0070), top: B:55:0x0016 }] */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x0174, code lost:
        
            if (r2.emit((java.lang.Object) null, (kotlin.coroutines.Continuation) r21) == r3) goto L52;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r22) throws kotlin.NoWhenBranchMatchedException {
            /*
                Method dump skipped, instruction units count: 378
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.GetActiveOrNewConversationIdUseCase.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Flow<Long> invoke() {
        return FlowKt.onStart(this.conversationSessionRepository.getActiveConversationId(), new AnonymousClass1(null));
    }

    /* JADX INFO: compiled from: GetActiveOrNewConversationIdUseCase.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/GetActiveOrNewConversationIdUseCase$Companion;", "", "<init>", "()V", "TAG", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
