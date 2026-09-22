package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.api;

import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.dto.ocr.OcrResponseDto;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/* JADX INFO: compiled from: ConversationOcrApi.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001JJ\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\t\u001a\u00020\u00072\b\b\u0001\u0010\n\u001a\u00020\u00072\b\b\u0001\u0010\u000b\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\f¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/api/ConversationOcrApi;", "", "performOcr", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/dto/ocr/OcrResponseDto;", "image", "Lokhttp3/MultipartBody$Part;", "deviceId", "Lokhttp3/RequestBody;", "gmailId", "customerId", "token", "inputLang", "(Lokhttp3/MultipartBody$Part;Lokhttp3/RequestBody;Lokhttp3/RequestBody;Lokhttp3/RequestBody;Lokhttp3/RequestBody;Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ConversationOcrApi {
    @POST("ocr")
    @Multipart
    Object performOcr(@Part MultipartBody.Part part, @Part("device_id") RequestBody requestBody, @Part("gmail_id") RequestBody requestBody2, @Part("customer_id") RequestBody requestBody3, @Part("token") RequestBody requestBody4, @Part("input_lang") RequestBody requestBody5, Continuation<? super OcrResponseDto> continuation);
}
