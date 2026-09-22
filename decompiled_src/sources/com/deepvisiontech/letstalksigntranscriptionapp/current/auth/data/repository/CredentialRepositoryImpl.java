package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository;

import android.content.Context;
import android.util.Log;
import androidx.credentials.ClearCredentialStateRequest;
import androidx.credentials.Credential;
import androidx.credentials.CredentialManager;
import androidx.credentials.CustomCredential;
import androidx.credentials.GetCredentialRequest;
import androidx.credentials.GetCredentialResponse;
import com.deepvisiontech.letstalksigntranscriptionapp.BuildConfig;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.CredentialRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.helper.SafeCall;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.google.android.libraries.identity.googleid.GetGoogleIdOption;
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential;
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CredentialRepositoryImpl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0007H\u0096@¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/data/repository/CredentialRepositoryImpl;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/CredentialRepository;", "credentialManager", "Landroidx/credentials/CredentialManager;", "<init>", "(Landroidx/credentials/CredentialManager;)V", "fetchMailId", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearCredentialManagerCredentials", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CredentialRepositoryImpl implements CredentialRepository {

    @Deprecated
    public static final String TAG = "CredentialRepositoryImpl";
    private final CredentialManager credentialManager;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.CredentialRepositoryImpl$fetchMailId$1, reason: invalid class name */
    /* JADX INFO: compiled from: CredentialRepositoryImpl.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.CredentialRepositoryImpl", f = "CredentialRepositoryImpl.kt", i = {0}, l = {25}, m = "fetchMailId", n = {"context"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CredentialRepositoryImpl.this.fetchMailId(null, (Continuation) this);
        }
    }

    @Inject
    public CredentialRepositoryImpl(CredentialManager credentialManager) {
        Intrinsics.checkNotNullParameter(credentialManager, "credentialManager");
        this.credentialManager = credentialManager;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.CredentialRepository
    public Object fetchMailId(Context context, Continuation<? super ResponseResource<String>> continuation) {
        AnonymousClass1 anonymousClass1;
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
        Object credential = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(credential);
            CredentialManager credentialManager = this.credentialManager;
            GetCredentialRequest getCredentialRequestBuild = new GetCredentialRequest.Builder().addCredentialOption(new GetGoogleIdOption.Builder().setFilterByAuthorizedAccounts(false).setServerClientId(BuildConfig.GOOGLE_CLIENT_ID).build()).build();
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(context);
            anonymousClass1.label = 1;
            credential = credentialManager.getCredential(context, getCredentialRequestBuild, anonymousClass1);
            if (credential == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(credential);
        }
        Credential credential2 = ((GetCredentialResponse) credential).getCredential();
        if (credential2 instanceof CustomCredential) {
            try {
                return new ResponseResource.Success(GoogleIdTokenCredential.Companion.createFrom(credential2.getData()).getId());
            } catch (GoogleIdTokenParsingException e) {
                Log.e(TAG, "Failed to fetch mail Id.", e);
                return new ResponseResource.Error(AppError.AuthenticationFailed.INSTANCE);
            }
        }
        Log.e(TAG, "Failed to fetch mail Id.");
        return new ResponseResource.Error(AppError.AuthenticationFailed.INSTANCE);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.CredentialRepositoryImpl$clearCredentialManagerCredentials$2, reason: invalid class name */
    /* JADX INFO: compiled from: CredentialRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.CredentialRepositoryImpl$clearCredentialManagerCredentials$2", f = "CredentialRepositoryImpl.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return CredentialRepositoryImpl.this.new AnonymousClass2(continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (CredentialRepositoryImpl.this.credentialManager.clearCredentialState(new ClearCredentialStateRequest((String) null, 1, (DefaultConstructorMarker) null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.CredentialRepository
    public Object clearCredentialManagerCredentials(Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new AnonymousClass2(null), continuation, 2, null);
    }

    /* JADX INFO: compiled from: CredentialRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/data/repository/CredentialRepositoryImpl$Companion;", "", "<init>", "()V", "TAG", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
