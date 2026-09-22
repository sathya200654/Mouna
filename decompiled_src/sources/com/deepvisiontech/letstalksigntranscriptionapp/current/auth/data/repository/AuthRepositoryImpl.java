package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository;

import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.remote.api.AuthApi;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.remote.dto.LoginResponse;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.remote.dto.LoginSubmissionRequest;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.AuthRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.helper.SafeCall;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AuthRepositoryImpl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J,\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\fJ\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007H\u0096@¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/data/repository/AuthRepositoryImpl;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/AuthRepository;", "authApi", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/data/remote/api/AuthApi;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/data/remote/api/AuthApi;)V", "login", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "deviceId", "customerId", "gmailId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logout", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AuthRepositoryImpl implements AuthRepository {
    private static final String TAG = "AuthRepositoryImpl";
    private final AuthApi authApi;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    @Inject
    public AuthRepositoryImpl(AuthApi authApi) {
        Intrinsics.checkNotNullParameter(authApi, "authApi");
        this.authApi = authApi;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.AuthRepository
    public Object login(String str, String str2, String str3, Continuation<? super ResponseResource<String>> continuation) {
        return SafeCall.api$default(SafeCall.INSTANCE, TAG, null, new AnonymousClass2(str, str3, str2, null), new AnonymousClass3(null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.AuthRepositoryImpl$login$2, reason: invalid class name */
    /* JADX INFO: compiled from: AuthRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/data/remote/dto/LoginResponse;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.AuthRepositoryImpl$login$2", f = "AuthRepositoryImpl.kt", i = {}, l = {25}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super LoginResponse>, Object> {
        final /* synthetic */ String $customerId;
        final /* synthetic */ String $deviceId;
        final /* synthetic */ String $gmailId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, String str2, String str3, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$deviceId = str;
            this.$gmailId = str2;
            this.$customerId = str3;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return AuthRepositoryImpl.this.new AnonymousClass2(this.$deviceId, this.$gmailId, this.$customerId, continuation);
        }

        public final Object invoke(Continuation<? super LoginResponse> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objLogin = AuthRepositoryImpl.this.authApi.login(new LoginSubmissionRequest(this.$deviceId, this.$gmailId, this.$customerId), (Continuation) this);
            return objLogin == coroutine_suspended ? coroutine_suspended : objLogin;
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.AuthRepositoryImpl$login$3, reason: invalid class name */
    /* JADX INFO: compiled from: AuthRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "response", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/data/remote/dto/LoginResponse;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.auth.data.repository.AuthRepositoryImpl$login$3", f = "AuthRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<LoginResponse, Continuation<? super String>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass3 = new AnonymousClass3(continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        public final Object invoke(LoginResponse loginResponse, Continuation<? super String> continuation) {
            return create(loginResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            LoginResponse loginResponse = (LoginResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            List listSplit$default = StringsKt.split$default(loginResponse.getToken(), new String[]{" "}, false, 0, 6, (Object) null);
            return 1 < listSplit$default.size() ? listSplit$default.get(1) : loginResponse.getToken();
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.AuthRepository
    public Object logout(Continuation<? super ResponseResource<Unit>> continuation) {
        return new ResponseResource.Success(Unit.INSTANCE);
    }

    /* JADX INFO: compiled from: AuthRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/data/repository/AuthRepositoryImpl$Companion;", "", "<init>", "()V", "TAG", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
