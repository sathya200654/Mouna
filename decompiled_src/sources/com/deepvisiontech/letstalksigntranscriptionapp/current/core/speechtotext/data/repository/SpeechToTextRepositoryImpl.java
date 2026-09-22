package com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.repository;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.helper.SafeCall;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.remote.api.SpeechToTextApi;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.remote.dto.FetchSpeechTokenRequest;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.remote.dto.FetchSpeechTokenResponse;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.repository.SpeechToTextRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpeechToTextRepositoryImpl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J@\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b0\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/data/repository/SpeechToTextRepositoryImpl;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/domain/repository/SpeechToTextRepository;", "speechToTextApi", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/data/remote/api/SpeechToTextApi;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/data/remote/api/SpeechToTextApi;)V", "fetchSpeechToken", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "Lkotlin/Pair;", "", "customerId", "deviceId", "gmailId", "token", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SpeechToTextRepositoryImpl implements SpeechToTextRepository {
    public static final int $stable = 8;
    private final SpeechToTextApi speechToTextApi;

    @Inject
    public SpeechToTextRepositoryImpl(SpeechToTextApi speechToTextApi) {
        Intrinsics.checkNotNullParameter(speechToTextApi, "speechToTextApi");
        this.speechToTextApi = speechToTextApi;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.repository.SpeechToTextRepository
    public Object fetchSpeechToken(String str, String str2, String str3, String str4, Continuation<? super ResponseResource<Pair<String, String>>> continuation) {
        return SafeCall.api$default(SafeCall.INSTANCE, "", null, new AnonymousClass2(str2, str3, str4, str, null), new AnonymousClass3(null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.repository.SpeechToTextRepositoryImpl$fetchSpeechToken$2, reason: invalid class name */
    /* JADX INFO: compiled from: SpeechToTextRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/data/remote/dto/FetchSpeechTokenResponse;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.repository.SpeechToTextRepositoryImpl$fetchSpeechToken$2", f = "SpeechToTextRepositoryImpl.kt", i = {}, l = {22}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super FetchSpeechTokenResponse>, Object> {
        final /* synthetic */ String $customerId;
        final /* synthetic */ String $deviceId;
        final /* synthetic */ String $gmailId;
        final /* synthetic */ String $token;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, String str2, String str3, String str4, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$deviceId = str;
            this.$gmailId = str2;
            this.$token = str3;
            this.$customerId = str4;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return SpeechToTextRepositoryImpl.this.new AnonymousClass2(this.$deviceId, this.$gmailId, this.$token, this.$customerId, continuation);
        }

        public final Object invoke(Continuation<? super FetchSpeechTokenResponse> continuation) {
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
            Object objFetchSpeechToken = SpeechToTextRepositoryImpl.this.speechToTextApi.fetchSpeechToken(new FetchSpeechTokenRequest(this.$deviceId, this.$gmailId, this.$token, this.$customerId), (Continuation) this);
            return objFetchSpeechToken == coroutine_suspended ? coroutine_suspended : objFetchSpeechToken;
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.repository.SpeechToTextRepositoryImpl$fetchSpeechToken$3, reason: invalid class name */
    /* JADX INFO: compiled from: SpeechToTextRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "response", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/data/remote/dto/FetchSpeechTokenResponse;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.data.repository.SpeechToTextRepositoryImpl$fetchSpeechToken$3", f = "SpeechToTextRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<FetchSpeechTokenResponse, Continuation<? super Pair<? extends String, ? extends String>>, Object> {
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

        public final Object invoke(FetchSpeechTokenResponse fetchSpeechTokenResponse, Continuation<? super Pair<String, String>> continuation) {
            return create(fetchSpeechTokenResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            FetchSpeechTokenResponse fetchSpeechTokenResponse = (FetchSpeechTokenResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return new Pair(fetchSpeechTokenResponse.getToken(), fetchSpeechTokenResponse.getRegion());
        }
    }
}
