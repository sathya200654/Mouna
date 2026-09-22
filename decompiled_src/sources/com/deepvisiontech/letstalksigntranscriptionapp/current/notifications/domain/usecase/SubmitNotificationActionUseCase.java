package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.repository.NotificationRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SubmitNotificationActionUseCase.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J,\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086B¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/usecase/SubmitNotificationActionUseCase;", "", "notificationRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/repository/NotificationRepository;", "sessionRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/repository/NotificationRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;)V", "invoke", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "notificationId", "", "pageId", "", "action", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationResponseType;", "(Ljava/lang/String;JLcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationResponseType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SubmitNotificationActionUseCase {
    public static final int $stable = 0;
    private final NotificationRepository notificationRepository;
    private final SessionRepository sessionRepository;

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.usecase.SubmitNotificationActionUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: SubmitNotificationActionUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.usecase.SubmitNotificationActionUseCase", f = "SubmitNotificationActionUseCase.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {19, 21}, m = "invoke", n = {"notificationId", "action", "pageId", "notificationId", "action", "gmailId", "pageId"}, s = {"L$0", "L$1", "J$0", "L$0", "L$1", "L$2", "J$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
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
            return SubmitNotificationActionUseCase.this.invoke(null, 0L, null, (Continuation) this);
        }
    }

    @Inject
    public SubmitNotificationActionUseCase(NotificationRepository notificationRepository, SessionRepository sessionRepository) {
        Intrinsics.checkNotNullParameter(notificationRepository, "notificationRepository");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        this.notificationRepository = notificationRepository;
        this.sessionRepository = sessionRepository;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0095, code lost:
    
        if (r13 == r0) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invoke(java.lang.String r9, long r10, com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.NotificationResponseType r12, kotlin.coroutines.Continuation<? super com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource<kotlin.Unit>> r13) {
        /*
            r8 = this;
            boolean r0 = r13 instanceof com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.usecase.SubmitNotificationActionUseCase.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r13
            com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.usecase.SubmitNotificationActionUseCase$invoke$1 r0 = (com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.usecase.SubmitNotificationActionUseCase.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L19
        L14:
            com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.usecase.SubmitNotificationActionUseCase$invoke$1 r0 = new com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.usecase.SubmitNotificationActionUseCase$invoke$1
            r0.<init>(r13)
        L19:
            r7 = r0
            java.lang.Object r13 = r7.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L53
            if (r1 == r3) goto L44
            if (r1 != r2) goto L3c
            long r8 = r7.J$0
            java.lang.Object r8 = r7.L$2
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r8 = r7.L$1
            com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.NotificationResponseType r8 = (com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.NotificationResponseType) r8
            java.lang.Object r8 = r7.L$0
            java.lang.String r8 = (java.lang.String) r8
            kotlin.ResultKt.throwOnFailure(r13)
            goto L98
        L3c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L44:
            long r10 = r7.J$0
            java.lang.Object r9 = r7.L$1
            r12 = r9
            com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.NotificationResponseType r12 = (com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.NotificationResponseType) r12
            java.lang.Object r9 = r7.L$0
            java.lang.String r9 = (java.lang.String) r9
            kotlin.ResultKt.throwOnFailure(r13)
            goto L67
        L53:
            kotlin.ResultKt.throwOnFailure(r13)
            com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository r13 = r8.sessionRepository
            r7.L$0 = r9
            r7.L$1 = r12
            r7.J$0 = r10
            r7.label = r3
            java.lang.Object r13 = r13.getGmailId(r7)
            if (r13 != r0) goto L67
            goto L97
        L67:
            r3 = r10
            r6 = r12
            com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource r13 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource) r13
            boolean r10 = r13 instanceof com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Success
            if (r10 == 0) goto L9b
            com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Success r13 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Success) r13
            java.lang.Object r10 = r13.getData()
            r5 = r10
            java.lang.String r5 = (java.lang.String) r5
            com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.repository.NotificationRepository r1 = r8.notificationRepository
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r7.L$0 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r7.L$1 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r7.L$2 = r8
            r7.J$0 = r3
            r7.label = r2
            r2 = r9
            java.lang.Object r13 = r1.submitAction(r2, r3, r5, r6, r7)
            if (r13 != r0) goto L98
        L97:
            return r0
        L98:
            com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource r13 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource) r13
            return r13
        L9b:
            boolean r8 = r13 instanceof com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Error
            if (r8 == 0) goto La0
            return r13
        La0:
            com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Loading r8 = com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Loading.INSTANCE
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r13, r8)
            if (r8 == 0) goto Lad
            com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource$Loading r8 = com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource.Loading.INSTANCE
            com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource r8 = (com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource) r8
            return r8
        Lad:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.usecase.SubmitNotificationActionUseCase.invoke(java.lang.String, long, com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.NotificationResponseType, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
