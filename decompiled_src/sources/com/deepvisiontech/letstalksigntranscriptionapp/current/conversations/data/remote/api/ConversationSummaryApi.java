package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.api;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.dto.summary.ConversationArticleSummaryRequest;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.dto.summary.ConversationArticleSummaryResponse;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.dto.summary.ConversationSummaryRequest;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.dto.summary.ConversationSummaryResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.POST;

/* JADX INFO: compiled from: ConversationSummaryApi.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0004\u001a\u00020\tH§@¢\u0006\u0002\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/api/ConversationSummaryApi;", "", "generateConversationSummary", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/dto/summary/ConversationSummaryResponse;", "request", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/dto/summary/ConversationSummaryRequest;", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/dto/summary/ConversationSummaryRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateArticleSummary", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/dto/summary/ConversationArticleSummaryResponse;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/dto/summary/ConversationArticleSummaryRequest;", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/dto/summary/ConversationArticleSummaryRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ConversationSummaryApi {
    @POST("get_news_summary")
    Object generateArticleSummary(@Body ConversationArticleSummaryRequest conversationArticleSummaryRequest, Continuation<? super ConversationArticleSummaryResponse> continuation);

    @POST("gpt_transcripts_json")
    Object generateConversationSummary(@Body ConversationSummaryRequest conversationSummaryRequest, Continuation<? super ConversationSummaryResponse> continuation);
}
