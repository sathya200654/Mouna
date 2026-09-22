package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.AuthRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.CredentialRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LogOutAndClearMailIdUseCase.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0086B¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/usecase/LogOutAndClearMailIdUseCase;", "", "authRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/AuthRepository;", "sessionRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;", "credentialRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/CredentialRepository;", "analyticsManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/AuthRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/CredentialRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;)V", "invoke", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LogOutAndClearMailIdUseCase {
    public static final int $stable = 8;
    private final AnalyticsManager analyticsManager;
    private final AuthRepository authRepository;
    private final CredentialRepository credentialRepository;
    private final SessionRepository sessionRepository;

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.usecase.LogOutAndClearMailIdUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: LogOutAndClearMailIdUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.usecase.LogOutAndClearMailIdUseCase", f = "LogOutAndClearMailIdUseCase.kt", i = {}, l = {20, 21, 22}, m = "invoke", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LogOutAndClearMailIdUseCase.this.invoke((Continuation) this);
        }
    }

    @Inject
    public LogOutAndClearMailIdUseCase(AuthRepository authRepository, SessionRepository sessionRepository, CredentialRepository credentialRepository, AnalyticsManager analyticsManager) {
        Intrinsics.checkNotNullParameter(authRepository, "authRepository");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(credentialRepository, "credentialRepository");
        Intrinsics.checkNotNullParameter(analyticsManager, "analyticsManager");
        this.authRepository = authRepository;
        this.sessionRepository = sessionRepository;
        this.credentialRepository = credentialRepository;
        this.analyticsManager = analyticsManager;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    /* JADX WARN: Code duplicated, block: B:28:0x0073  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:46:0x00b2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:47:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:49:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:51:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0080, code lost:
    
        if (r7 == r1) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invoke(kotlin.coroutines.Continuation<? super com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource<kotlin.Unit>> r7) throws kotlin.NoWhenBranchMatchedException {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.usecase.LogOutAndClearMailIdUseCase.invoke(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
