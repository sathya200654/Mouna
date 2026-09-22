package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.api;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.dto.suggestion.CorrectionSuggestionRequest;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.dto.suggestion.CorrectionSuggestionResponse;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.dto.suggestion.InputSuggestionRequest;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.dto.suggestion.InputSuggestionResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.POST;

/* JADX INFO: compiled from: ConversationSuggestionsApi.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0004\u001a\u00020\tH§@¢\u0006\u0002\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/api/ConversationSuggestionsApi;", "", "getInputSuggestions", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/dto/suggestion/InputSuggestionResponse;", "request", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/dto/suggestion/InputSuggestionRequest;", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/dto/suggestion/InputSuggestionRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCorrectionSuggestions", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/dto/suggestion/CorrectionSuggestionResponse;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/dto/suggestion/CorrectionSuggestionRequest;", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/dto/suggestion/CorrectionSuggestionRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ConversationSuggestionsApi {
    @POST("get_correct_sentences")
    Object getCorrectionSuggestions(@Body CorrectionSuggestionRequest correctionSuggestionRequest, Continuation<? super CorrectionSuggestionResponse> continuation);

    @POST("get_predefined_sentences")
    Object getInputSuggestions(@Body InputSuggestionRequest inputSuggestionRequest, Continuation<? super InputSuggestionResponse> continuation);
}
