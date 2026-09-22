package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.api;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.dto.usage.ConversationUsageRequest;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.dto.usage.ConversationUsageResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.POST;

/* JADX INFO: compiled from: ConversationUsageApi.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/api/ConversationUsageApi;", "", "fetchUsageLimits", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/dto/usage/ConversationUsageResponse;", "conversationUsageRequest", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/dto/usage/ConversationUsageRequest;", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/dto/usage/ConversationUsageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ConversationUsageApi {
    @POST("get_limits")
    Object fetchUsageLimits(@Body ConversationUsageRequest conversationUsageRequest, Continuation<? super ConversationUsageResponse> continuation);
}
