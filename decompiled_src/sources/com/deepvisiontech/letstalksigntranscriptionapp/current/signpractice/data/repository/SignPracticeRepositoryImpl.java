package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.repository;

import androidx.wear.compose.foundation.SwipeToRevealKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.helper.SafeCall;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.local.dao.SignPracticeDao;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.local.entity.SignPracticeEntity;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.local.mappers.SignPracticeMapperKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.local.stores.SignPracticeGenerationLocalDataStore;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.remote.api.SignPracticeApi;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.remote.dto.GeneratePracticeResponse;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPractice;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPracticeDomain;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPracticeEssay;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.repository.SignPracticeRepository;
import com.google.protobuf.DescriptorProtos;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: SignPracticeRepositoryImpl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 .2\u00020\u0001:\u0001.B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\r2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u0016H\u0096@¢\u0006\u0002\u0010\u0017J\u001a\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00160\rH\u0096@¢\u0006\u0002\u0010\u001aJd\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\r2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001eH\u0096@¢\u0006\u0002\u0010)J\u0014\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00160+H\u0016J\u0016\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00100+2\u0006\u0010-\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u000b¨\u0006/"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/data/repository/SignPracticeRepositoryImpl;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/repository/SignPracticeRepository;", "signPracticeDao", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/data/local/dao/SignPracticeDao;", "signPracticeApi", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/data/remote/api/SignPracticeApi;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/data/local/dao/SignPracticeDao;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/data/remote/api/SignPracticeApi;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getIoDispatcher$annotations", "()V", "insertPracticeAndGetId", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "signPractice", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPractice;", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPractice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePractice", "", "deletePractices", "signPractices", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSignPracticeDomains", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPracticeDomain;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generatePracticeEssay", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPracticeEssay;", "customerId", "", "deviceId", "gmailId", "token", "domain", "language", "topic", "complexity", "length", "", "intType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllPractices", "Lkotlinx/coroutines/flow/Flow;", "getPracticeFlow", "id", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SignPracticeRepositoryImpl implements SignPracticeRepository {
    private static final String TAG = "SignPracticeRepositoryImpl";
    private final CoroutineDispatcher ioDispatcher;
    private final SignPracticeApi signPracticeApi;
    private final SignPracticeDao signPracticeDao;
    public static final int $stable = 8;

    private static /* synthetic */ void getIoDispatcher$annotations() {
    }

    @Inject
    public SignPracticeRepositoryImpl(SignPracticeDao signPracticeDao, SignPracticeApi signPracticeApi, CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(signPracticeDao, "signPracticeDao");
        Intrinsics.checkNotNullParameter(signPracticeApi, "signPracticeApi");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "ioDispatcher");
        this.signPracticeDao = signPracticeDao;
        this.signPracticeApi = signPracticeApi;
        this.ioDispatcher = coroutineDispatcher;
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.repository.SignPracticeRepositoryImpl$insertPracticeAndGetId$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SignPracticeRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.repository.SignPracticeRepositoryImpl$insertPracticeAndGetId$2", f = "SignPracticeRepositoryImpl.kt", i = {}, l = {28}, m = "invokeSuspend", n = {}, s = {})
    static final class C03032 extends SuspendLambda implements Function1<Continuation<? super Long>, Object> {
        final /* synthetic */ SignPractice $signPractice;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03032(SignPractice signPractice, Continuation<? super C03032> continuation) {
            super(1, continuation);
            this.$signPractice = signPractice;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return SignPracticeRepositoryImpl.this.new C03032(this.$signPractice, continuation);
        }

        public final Object invoke(Continuation<? super Long> continuation) {
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
            Object objInsertPractice = SignPracticeRepositoryImpl.this.signPracticeDao.insertPractice(SignPracticeMapperKt.toEntity(this.$signPractice), (Continuation) this);
            return objInsertPractice == coroutine_suspended ? coroutine_suspended : objInsertPractice;
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.repository.SignPracticeRepository
    public Object insertPracticeAndGetId(SignPractice signPractice, Continuation<? super ResponseResource<Long>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C03032(signPractice, null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.repository.SignPracticeRepositoryImpl$updatePractice$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SignPracticeRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.repository.SignPracticeRepositoryImpl$updatePractice$2", f = "SignPracticeRepositoryImpl.kt", i = {}, l = {DescriptorProtos.MethodOptions.IDEMPOTENCY_LEVEL_FIELD_NUMBER}, m = "invokeSuspend", n = {}, s = {})
    static final class C03042 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ SignPractice $signPractice;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03042(SignPractice signPractice, Continuation<? super C03042> continuation) {
            super(1, continuation);
            this.$signPractice = signPractice;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return SignPracticeRepositoryImpl.this.new C03042(this.$signPractice, continuation);
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
                if (SignPracticeRepositoryImpl.this.signPracticeDao.updatePractice(SignPracticeMapperKt.toEntity(this.$signPractice), (Continuation) this) == coroutine_suspended) {
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

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.repository.SignPracticeRepository
    public Object updatePractice(SignPractice signPractice, Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C03042(signPractice, null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.repository.SignPracticeRepositoryImpl$deletePractices$2, reason: invalid class name */
    /* JADX INFO: compiled from: SignPracticeRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.repository.SignPracticeRepositoryImpl$deletePractices$2", f = "SignPracticeRepositoryImpl.kt", i = {0}, l = {DescriptorProtos.FileOptions.PHP_NAMESPACE_FIELD_NUMBER}, m = "invokeSuspend", n = {"signPracticeEntities"}, s = {"L$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ List<SignPractice> $signPractices;
        Object L$0;
        int label;
        final /* synthetic */ SignPracticeRepositoryImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(List<SignPractice> list, SignPracticeRepositoryImpl signPracticeRepositoryImpl, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$signPractices = list;
            this.this$0 = signPracticeRepositoryImpl;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass2(this.$signPractices, this.this$0, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                List<SignPractice> list = this.$signPractices;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(SignPracticeMapperKt.toEntity((SignPractice) it.next()));
                }
                ArrayList arrayList2 = arrayList;
                this.L$0 = SpillingKt.nullOutSpilledVariable(arrayList2);
                this.label = 1;
                if (this.this$0.signPracticeDao.deletePractice(arrayList2, (Continuation) this) == coroutine_suspended) {
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

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.repository.SignPracticeRepository
    public Object deletePractices(List<SignPractice> list, Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new AnonymousClass2(list, this, null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.repository.SignPracticeRepositoryImpl$getSignPracticeDomains$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SignPracticeRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPracticeDomain;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.repository.SignPracticeRepositoryImpl$getSignPracticeDomains$2", f = "SignPracticeRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03022 extends SuspendLambda implements Function1<Continuation<? super List<? extends SignPracticeDomain>>, Object> {
        int label;

        C03022(Continuation<? super C03022> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C03022(continuation);
        }

        public final Object invoke(Continuation<? super List<SignPracticeDomain>> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return SignPracticeGenerationLocalDataStore.INSTANCE.getGenerationDomains();
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.repository.SignPracticeRepository
    public Object getSignPracticeDomains(Continuation<? super ResponseResource<? extends List<SignPracticeDomain>>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new C03022(null), continuation, 2, null);
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.repository.SignPracticeRepository
    public Object generatePracticeEssay(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, String str9, Continuation<? super ResponseResource<SignPracticeEssay>> continuation) {
        return SafeCall.api$default(SafeCall.INSTANCE, TAG, null, new C03012(str, str2, str3, str4, str5, str6, str7, str8, i, str9, null), new AnonymousClass3(null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.repository.SignPracticeRepositoryImpl$generatePracticeEssay$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SignPracticeRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/data/remote/dto/GeneratePracticeResponse;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.repository.SignPracticeRepositoryImpl$generatePracticeEssay$2", f = "SignPracticeRepositoryImpl.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
    static final class C03012 extends SuspendLambda implements Function1<Continuation<? super GeneratePracticeResponse>, Object> {
        final /* synthetic */ String $complexity;
        final /* synthetic */ String $customerId;
        final /* synthetic */ String $deviceId;
        final /* synthetic */ String $domain;
        final /* synthetic */ String $gmailId;
        final /* synthetic */ String $intType;
        final /* synthetic */ String $language;
        final /* synthetic */ int $length;
        final /* synthetic */ String $token;
        final /* synthetic */ String $topic;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03012(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, String str9, Continuation<? super C03012> continuation) {
            super(1, continuation);
            this.$customerId = str;
            this.$deviceId = str2;
            this.$gmailId = str3;
            this.$token = str4;
            this.$domain = str5;
            this.$language = str6;
            this.$topic = str7;
            this.$complexity = str8;
            this.$length = i;
            this.$intType = str9;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return SignPracticeRepositoryImpl.this.new C03012(this.$customerId, this.$deviceId, this.$gmailId, this.$token, this.$domain, this.$language, this.$topic, this.$complexity, this.$length, this.$intType, continuation);
        }

        public final Object invoke(Continuation<? super GeneratePracticeResponse> continuation) {
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
            Object objGeneratePracticeEssay = SignPracticeRepositoryImpl.this.signPracticeApi.generatePracticeEssay(this.$customerId, this.$deviceId, this.$gmailId, this.$token, this.$domain, this.$language, this.$topic, this.$complexity, this.$length, this.$intType, (Continuation) this);
            return objGeneratePracticeEssay == coroutine_suspended ? coroutine_suspended : objGeneratePracticeEssay;
        }
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.repository.SignPracticeRepositoryImpl$generatePracticeEssay$3, reason: invalid class name */
    /* JADX INFO: compiled from: SignPracticeRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPracticeEssay;", "response", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/data/remote/dto/GeneratePracticeResponse;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.repository.SignPracticeRepositoryImpl$generatePracticeEssay$3", f = "SignPracticeRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<GeneratePracticeResponse, Continuation<? super SignPracticeEssay>, Object> {
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

        public final Object invoke(GeneratePracticeResponse generatePracticeResponse, Continuation<? super SignPracticeEssay> continuation) {
            return create(generatePracticeResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            GeneratePracticeResponse generatePracticeResponse = (GeneratePracticeResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            String essay = generatePracticeResponse.getEssay();
            if (essay != null) {
                Integer totalContentSize = generatePracticeResponse.getTotalContentSize();
                return new SignPracticeEssay(essay, totalContentSize != null ? totalContentSize.intValue() : 0);
            }
            return new SignPracticeEssay("", 0);
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.repository.SignPracticeRepository
    public Flow<List<SignPractice>> getAllPractices() {
        final Flow<List<SignPracticeEntity>> allPractices = this.signPracticeDao.getAllPractices();
        return FlowKt.flowOn(new Flow<List<? extends SignPractice>>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.repository.SignPracticeRepositoryImpl$getAllPractices$$inlined$map$1

            /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.repository.SignPracticeRepositoryImpl$getAllPractices$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.repository.SignPracticeRepositoryImpl$getAllPractices$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.repository.SignPracticeRepositoryImpl$getAllPractices$$inlined$map$1$2", f = "SignPracticeRepositoryImpl.kt", i = {0, 0, 0, 0, 0}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                public final Object emit(Object obj, Continuation continuation) {
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
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        List list = (List) obj;
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                        Iterator<T> it = list.iterator();
                        while (it.hasNext()) {
                            arrayList.add(SignPracticeMapperKt.toPractice((SignPracticeEntity) it.next()));
                        }
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(arrayList, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = allPractices.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, this.ioDispatcher);
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.repository.SignPracticeRepository
    public Flow<SignPractice> getPracticeFlow(long id) {
        final Flow<SignPracticeEntity> practiceFlow = this.signPracticeDao.getPracticeFlow(id);
        return FlowKt.flowOn(new Flow<SignPractice>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.repository.SignPracticeRepositoryImpl$getPracticeFlow$$inlined$map$1

            /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.repository.SignPracticeRepositoryImpl$getPracticeFlow$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.repository.SignPracticeRepositoryImpl$getPracticeFlow$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.repository.SignPracticeRepositoryImpl$getPracticeFlow$$inlined$map$1$2", f = "SignPracticeRepositoryImpl.kt", i = {0, 0, 0, 0, 0}, l = {SwipeToRevealKt.SHORT_ANIMATION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                public final Object emit(Object obj, Continuation continuation) {
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
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        SignPractice practice = SignPracticeMapperKt.toPractice((SignPracticeEntity) obj);
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(practice, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = practiceFlow.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, this.ioDispatcher);
    }
}
