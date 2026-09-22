package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.AuthRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LoginAndSaveTokenUseCase.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0086B¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/usecase/LoginAndSaveTokenUseCase;", "", "authRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/AuthRepository;", "sessionRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;", "analyticsManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/AuthRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;)V", "invoke", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LoginAndSaveTokenUseCase {
    public static final int $stable = AnalyticsManager.$stable;
    private final AnalyticsManager analyticsManager;
    private final AuthRepository authRepository;
    private final SessionRepository sessionRepository;

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.usecase.LoginAndSaveTokenUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: LoginAndSaveTokenUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.usecase.LoginAndSaveTokenUseCase", f = "LoginAndSaveTokenUseCase.kt", i = {1, 1, 2, 2, 2, 3, 3, 3, 3}, l = {19, 21, 23, 28}, m = "invoke", n = {"deviceId", "customerId", "deviceId", "customerId", "gmailId", "deviceId", "customerId", "gmailId", "response"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
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
            return LoginAndSaveTokenUseCase.this.invoke((Continuation) this);
        }
    }

    @Inject
    public LoginAndSaveTokenUseCase(AuthRepository authRepository, SessionRepository sessionRepository, AnalyticsManager analyticsManager) {
        Intrinsics.checkNotNullParameter(authRepository, "authRepository");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(analyticsManager, "analyticsManager");
        this.authRepository = authRepository;
        this.sessionRepository = sessionRepository;
        this.analyticsManager = analyticsManager;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:36:0x00da  */
    /* JADX WARN: Code duplicated, block: B:39:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:44:0x0131  */
    /* JADX WARN: Code duplicated, block: B:46:0x0135  */
    /* JADX WARN: Code duplicated, block: B:48:0x0143  */
    /* JADX WARN: Code duplicated, block: B:50:0x0147  */
    /* JADX WARN: Code duplicated, block: B:52:0x0153  */
    /* JADX WARN: Code duplicated, block: B:54:0x0159  */
    /* JADX WARN: Code duplicated, block: B:56:0x015d  */
    /* JADX WARN: Code duplicated, block: B:58:0x0167  */
    /* JADX WARN: Code duplicated, block: B:60:0x016f  */
    /* JADX WARN: Code duplicated, block: B:62:0x017d  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0124, code lost:
    
        if (r10.setToken(r6, r0) == r1) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invoke(kotlin.coroutines.Continuation<? super com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource<kotlin.Unit>> r11) {
        /*
            Method dump skipped, instruction units count: 471
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.usecase.LoginAndSaveTokenUseCase.invoke(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
