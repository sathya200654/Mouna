package com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.repository;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.helper.SafeCall;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.local.daos.EnvironmentSoundHistoryDao;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.local.entities.EnvironmentSoundHistoryEntity;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.domain.repository.EnvironmentSoundHistoryRepository;
import com.google.firebase.messaging.Constants;
import com.google.protobuf.DescriptorProtos;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: EnvironmentSoundHistoryRepositoryImpl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0016J$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/data/repository/EnvironmentSoundHistoryRepositoryImpl;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/domain/repository/EnvironmentSoundHistoryRepository;", "dao", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/data/local/daos/EnvironmentSoundHistoryDao;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/data/local/daos/EnvironmentSoundHistoryDao;)V", "getHistory", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/data/local/entities/EnvironmentSoundHistoryEntity;", "savePrediction", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", Constants.ScionAnalytics.PARAM_LABEL, "", "confidence", "", "(Ljava/lang/String;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EnvironmentSoundHistoryRepositoryImpl implements EnvironmentSoundHistoryRepository {
    private static final String TAG = "EnvironmentSoundHistoryRepositoryImpl";
    private final EnvironmentSoundHistoryDao dao;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    @Inject
    public EnvironmentSoundHistoryRepositoryImpl(EnvironmentSoundHistoryDao environmentSoundHistoryDao) {
        Intrinsics.checkNotNullParameter(environmentSoundHistoryDao, "dao");
        this.dao = environmentSoundHistoryDao;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.domain.repository.EnvironmentSoundHistoryRepository
    public Flow<List<EnvironmentSoundHistoryEntity>> getHistory() {
        return this.dao.getHistory();
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.repository.EnvironmentSoundHistoryRepositoryImpl$savePrediction$2, reason: invalid class name */
    /* JADX INFO: compiled from: EnvironmentSoundHistoryRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.repository.EnvironmentSoundHistoryRepositoryImpl$savePrediction$2", f = "EnvironmentSoundHistoryRepositoryImpl.kt", i = {0, 1}, l = {26, DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER}, m = "invokeSuspend", n = {"entity", "entity"}, s = {"L$0", "L$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ float $confidence;
        final /* synthetic */ String $label;
        Object L$0;
        int label;
        final /* synthetic */ EnvironmentSoundHistoryRepositoryImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, float f, EnvironmentSoundHistoryRepositoryImpl environmentSoundHistoryRepositoryImpl, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$label = str;
            this.$confidence = f;
            this.this$0 = environmentSoundHistoryRepositoryImpl;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass2(this.$label, this.$confidence, this.this$0, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0068, code lost:
        
            if (r13.this$0.dao.keepOnlyLast1000((kotlin.coroutines.Continuation) r13) == r0) goto L16;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                r13 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r13.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L26
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                java.lang.Object r13 = r13.L$0
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.local.entities.EnvironmentSoundHistoryEntity r13 = (com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.local.entities.EnvironmentSoundHistoryEntity) r13
                kotlin.ResultKt.throwOnFailure(r14)
                goto L6b
            L16:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r14)
                throw r13
            L1e:
                java.lang.Object r1 = r13.L$0
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.local.entities.EnvironmentSoundHistoryEntity r1 = (com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.local.entities.EnvironmentSoundHistoryEntity) r1
                kotlin.ResultKt.throwOnFailure(r14)
                goto L53
            L26:
                kotlin.ResultKt.throwOnFailure(r14)
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.local.entities.EnvironmentSoundHistoryEntity r4 = new com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.local.entities.EnvironmentSoundHistoryEntity
                java.lang.String r7 = r13.$label
                float r8 = r13.$confidence
                long r9 = java.lang.System.currentTimeMillis()
                r11 = 1
                r12 = 0
                r5 = 0
                r4.<init>(r5, r7, r8, r9, r11, r12)
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.repository.EnvironmentSoundHistoryRepositoryImpl r14 = r13.this$0
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.local.daos.EnvironmentSoundHistoryDao r14 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.repository.EnvironmentSoundHistoryRepositoryImpl.access$getDao$p(r14)
                r1 = r13
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
                r13.L$0 = r5
                r13.label = r3
                java.lang.Object r14 = r14.insert(r4, r1)
                if (r14 != r0) goto L52
                goto L6a
            L52:
                r1 = r4
            L53:
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.repository.EnvironmentSoundHistoryRepositoryImpl r14 = r13.this$0
                com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.local.daos.EnvironmentSoundHistoryDao r14 = com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.repository.EnvironmentSoundHistoryRepositoryImpl.access$getDao$p(r14)
                r3 = r13
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
                r13.L$0 = r1
                r13.label = r2
                java.lang.Object r13 = r14.keepOnlyLast1000(r3)
                if (r13 != r0) goto L6b
            L6a:
                return r0
            L6b:
                kotlin.Unit r13 = kotlin.Unit.INSTANCE
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.repository.EnvironmentSoundHistoryRepositoryImpl.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.domain.repository.EnvironmentSoundHistoryRepository
    public Object savePrediction(String str, float f, Continuation<? super ResponseResource<Unit>> continuation) {
        return SafeCall.local$default(SafeCall.INSTANCE, TAG, null, new AnonymousClass2(str, f, this, null), continuation, 2, null);
    }

    /* JADX INFO: compiled from: EnvironmentSoundHistoryRepositoryImpl.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/data/repository/EnvironmentSoundHistoryRepositoryImpl$Companion;", "", "<init>", "()V", "TAG", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
