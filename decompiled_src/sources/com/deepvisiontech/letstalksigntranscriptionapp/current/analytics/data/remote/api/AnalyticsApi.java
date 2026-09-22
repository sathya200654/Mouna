package com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.remote.api;

import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/* JADX INFO: compiled from: AnalyticsApi.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0014\b\u0001\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\bH§@¢\u0006\u0002\u0010\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/remote/api/AnalyticsApi;", "", "logEvent", "Lretrofit2/Response;", "Ljava/lang/Void;", "mode", "", "params", "", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface AnalyticsApi {
    @GET("app_log")
    Object logEvent(@Query("mode") String str, @QueryMap Map<String, String> map, Continuation<? super Response<Void>> continuation);
}
