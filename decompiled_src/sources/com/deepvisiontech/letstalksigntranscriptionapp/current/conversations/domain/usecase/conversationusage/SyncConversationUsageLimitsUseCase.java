package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationusage;

import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository.ConversationUsageRepository;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SyncConversationUsageLimitsUseCase.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Singleton
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0086B¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/usecase/conversationusage/SyncConversationUsageLimitsUseCase;", "", "conversationUsageRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationUsageRepository;", "sessionRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationUsageRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;)V", "invoke", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SyncConversationUsageLimitsUseCase {
    public static final int $stable = 0;
    private final ConversationUsageRepository conversationUsageRepository;
    private final SessionRepository sessionRepository;

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationusage.SyncConversationUsageLimitsUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: SyncConversationUsageLimitsUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationusage.SyncConversationUsageLimitsUseCase", f = "SyncConversationUsageLimitsUseCase.kt", i = {1, 2, 2, 3, 3, 3, 3}, l = {17, 18, 19, 22}, m = "invoke", n = {"token", "token", "gmail", "token", "gmail", "deviceId", "customerId"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3"})
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
            return SyncConversationUsageLimitsUseCase.this.invoke((Continuation) this);
        }
    }

    @Inject
    public SyncConversationUsageLimitsUseCase(ConversationUsageRepository conversationUsageRepository, SessionRepository sessionRepository) {
        Intrinsics.checkNotNullParameter(conversationUsageRepository, "conversationUsageRepository");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        this.conversationUsageRepository = conversationUsageRepository;
        this.sessionRepository = sessionRepository;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    /* JADX WARN: Code duplicated, block: B:31:0x009b  */
    /* JADX WARN: Code duplicated, block: B:34:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:37:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:39:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:44:0x0103  */
    /* JADX WARN: Code duplicated, block: B:46:0x0107 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:47:0x0108  */
    /* JADX WARN: Code duplicated, block: B:49:0x0110  */
    /* JADX WARN: Code duplicated, block: B:51:0x0115  */
    /* JADX WARN: Code duplicated, block: B:53:0x011b  */
    /* JADX WARN: Code duplicated, block: B:55:0x011f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:56:0x0120  */
    /* JADX WARN: Code duplicated, block: B:58:0x0128  */
    /* JADX WARN: Code duplicated, block: B:60:0x012d  */
    /* JADX WARN: Code duplicated, block: B:62:0x0133  */
    /* JADX WARN: Code duplicated, block: B:64:0x0137 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:65:0x0138  */
    /* JADX WARN: Code duplicated, block: B:67:0x0140  */
    /* JADX WARN: Code duplicated, block: B:69:0x0145  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00f8, code lost:
    
        if (r1.syncAllowedLimitsWithNetwork(r9, r3, r4, r5, r6) == r0) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invoke(kotlin.coroutines.Continuation<? super com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource<kotlin.Unit>> r9) throws kotlin.NoWhenBranchMatchedException {
        /*
            Method dump skipped, instruction units count: 355
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.usecase.conversationusage.SyncConversationUsageLimitsUseCase.invoke(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
