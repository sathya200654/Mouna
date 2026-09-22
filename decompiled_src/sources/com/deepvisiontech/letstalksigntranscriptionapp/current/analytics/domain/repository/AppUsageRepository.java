package com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.repository;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: AppUsageRepository.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH¦@¢\u0006\u0002\u0010\nR\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/domain/repository/AppUsageRepository;", "", "appOpenCountFlow", "Lkotlinx/coroutines/flow/Flow;", "", "getAppOpenCountFlow", "()Lkotlinx/coroutines/flow/Flow;", "incrementAppOpenCount", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface AppUsageRepository {
    Flow<Integer> getAppOpenCountFlow();

    Object incrementAppOpenCount(Continuation<? super ResponseResource<Unit>> continuation);
}
