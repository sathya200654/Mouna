package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.usecase;

import android.content.Context;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.CredentialRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.helper.SafeCall;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeCreationViewModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FetchAndSaveMailIdUseCase.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0086B¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/usecase/FetchAndSaveMailIdUseCase;", "", "credentialRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/CredentialRepository;", "sessionRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/CredentialRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;)V", "invoke", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FetchAndSaveMailIdUseCase {
    public static final int $stable = 0;
    private static final String TAG = "FetchAndSaveMailIdUseCase";
    private final CredentialRepository credentialRepository;
    private final SessionRepository sessionRepository;

    @Inject
    public FetchAndSaveMailIdUseCase(CredentialRepository credentialRepository, SessionRepository sessionRepository) {
        Intrinsics.checkNotNullParameter(credentialRepository, "credentialRepository");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        this.credentialRepository = credentialRepository;
        this.sessionRepository = sessionRepository;
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.usecase.FetchAndSaveMailIdUseCase$invoke$2, reason: invalid class name */
    /* JADX INFO: compiled from: FetchAndSaveMailIdUseCase.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.usecase.FetchAndSaveMailIdUseCase$invoke$2", f = "FetchAndSaveMailIdUseCase.kt", i = {1, 1}, l = {SignPracticeCreationViewModel.PRACTICE_NAME_MAX_CHAR_LIMIT, 33}, m = "invokeSuspend", n = {"fetchResource", "mailId"}, s = {"L$0", "L$1"})
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Context context, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$context = context;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return FetchAndSaveMailIdUseCase.this.new AnonymousClass2(this.$context, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0069, code lost:
        
            if (r7 == r0) goto L17;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) throws kotlin.NoWhenBranchMatchedException {
            /*
                Method dump skipped, instruction units count: 234
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.usecase.FetchAndSaveMailIdUseCase.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object invoke(Context context, Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new AnonymousClass2(context, null), continuation, 2, null);
    }
}
