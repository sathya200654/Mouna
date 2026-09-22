package com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services;

import com.azure.core.util.tracing.Tracer;
import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent;
import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.repository.AnalyticsRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository;
import com.google.protobuf.DescriptorProtos;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: AnalyticsManager.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Singleton
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;", "", "sessionRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;", "analyticsRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/repository/AnalyticsRepository;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/repository/AnalyticsRepository;)V", Tracer.SCOPE_KEY, "Lkotlinx/coroutines/CoroutineScope;", "logEvent", "", "event", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/constants/AnalyticsEvent;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AnalyticsManager {
    public static final int $stable = 8;
    private final AnalyticsRepository analyticsRepository;
    private final CoroutineScope scope;
    private final SessionRepository sessionRepository;

    @Inject
    public AnalyticsManager(SessionRepository sessionRepository, AnalyticsRepository analyticsRepository) {
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(analyticsRepository, "analyticsRepository");
        this.sessionRepository = sessionRepository;
        this.analyticsRepository = analyticsRepository;
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager$logEvent$1, reason: invalid class name */
    /* JADX INFO: compiled from: AnalyticsManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager$logEvent$1", f = "AnalyticsManager.kt", i = {1, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3}, l = {26, DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER, 28, DescriptorProtos.FileOptions.RUBY_PACKAGE_FIELD_NUMBER}, m = "invokeSuspend", n = {"token", "token", "deviceId", "token", "deviceId", "gmailId", "customerId", "mandatoryParams", "eventParams", "finalParams", "cleanParams"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AnalyticsEvent $event;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AnalyticsEvent analyticsEvent, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$event = analyticsEvent;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AnalyticsManager.this.new AnonymousClass1(this.$event, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:32:0x00a4  */
        /* JADX WARN: Code duplicated, block: B:33:0x00a6 A[Catch: Exception -> 0x005a, PHI: r1 r6 r13
  0x00a6: PHI (r1v9 com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource) = 
  (r1v8 com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource)
  (r1v14 com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource)
 binds: [B:31:0x00a2, B:14:0x0049] A[DONT_GENERATE, DONT_INLINE]
  0x00a6: PHI (r6v4 com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource) = 
  (r6v3 com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource)
  (r6v8 com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource)
 binds: [B:31:0x00a2, B:14:0x0049] A[DONT_GENERATE, DONT_INLINE]
  0x00a6: PHI (r13v13 java.lang.Object) = (r13v12 java.lang.Object), (r13v0 java.lang.Object) binds: [B:31:0x00a2, B:14:0x0049] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {Exception -> 0x005a, blocks: (B:9:0x0034, B:14:0x0049, B:33:0x00a6, B:34:0x0102, B:36:0x0108, B:37:0x0121, B:17:0x0051, B:30:0x008c, B:18:0x0056, B:26:0x0073, B:23:0x0060), top: B:43:0x000a }] */
        /* JADX WARN: Code duplicated, block: B:36:0x0108 A[Catch: Exception -> 0x005a, LOOP:0: B:34:0x0102->B:36:0x0108, LOOP_END, TryCatch #0 {Exception -> 0x005a, blocks: (B:9:0x0034, B:14:0x0049, B:33:0x00a6, B:34:0x0102, B:36:0x0108, B:37:0x0121, B:17:0x0051, B:30:0x008c, B:18:0x0056, B:26:0x0073, B:23:0x0060), top: B:43:0x000a }] */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0166, code lost:
        
            if (r12.this$0.analyticsRepository.logAppEvent(r12.$event.getMode(), r9, (kotlin.coroutines.Continuation) r12) == r0) goto L39;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                Method dump skipped, instruction units count: 392
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void logEvent(AnalyticsEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(event, null), 3, (Object) null);
    }
}
