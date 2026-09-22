package com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.repository;

import android.util.Log;
import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.remote.api.AnalyticsApi;
import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.repository.AnalyticsRepository;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Response;

/* JADX INFO: compiled from: AnalyticsRepositoryImpl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J*\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000bH\u0096@¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/repository/AnalyticsRepositoryImpl;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/repository/AnalyticsRepository;", "analyticsApi", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/remote/api/AnalyticsApi;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/remote/api/AnalyticsApi;)V", "logAppEvent", "", "mode", "", "allParams", "", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AnalyticsRepositoryImpl implements AnalyticsRepository {
    public static final int $stable = 8;
    private final AnalyticsApi analyticsApi;

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.repository.AnalyticsRepositoryImpl$logAppEvent$1, reason: invalid class name */
    /* JADX INFO: compiled from: AnalyticsRepositoryImpl.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.repository.AnalyticsRepositoryImpl", f = "AnalyticsRepositoryImpl.kt", i = {0, 0, 0}, l = {15}, m = "logAppEvent", n = {"mode", "allParams", "safeParams"}, s = {"L$0", "L$1", "L$2"})
    static final class AnonymousClass1 extends ContinuationImpl {
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
            return AnalyticsRepositoryImpl.this.logAppEvent(null, null, (Continuation) this);
        }
    }

    @Inject
    public AnalyticsRepositoryImpl(AnalyticsApi analyticsApi) {
        Intrinsics.checkNotNullParameter(analyticsApi, "analyticsApi");
        this.analyticsApi = analyticsApi;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.repository.AnalyticsRepository
    public Object logAppEvent(String str, Map<String, String> map, Continuation<? super Unit> continuation) {
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
        Object objLogEvent = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objLogEvent);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry.getValue().length() > 0) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                LinkedHashMap linkedHashMap2 = linkedHashMap;
                AnalyticsApi analyticsApi = this.analyticsApi;
                anonymousClass1.L$0 = str;
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(map);
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(linkedHashMap2);
                anonymousClass1.label = 1;
                objLogEvent = analyticsApi.logEvent(str, linkedHashMap2, anonymousClass1);
                if (objLogEvent == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str = (String) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objLogEvent);
            }
            Response response = (Response) objLogEvent;
            if (response.isSuccessful()) {
                Log.d("LoggingRepo", "Successfully logged: " + str);
            } else {
                Log.e("LoggingRepo", "Failed to log " + str + ": " + response.code());
            }
        } catch (Exception e) {
            Log.e("LoggingRepo", "Network exception for " + str, e);
        }
        return Unit.INSTANCE;
    }
}
