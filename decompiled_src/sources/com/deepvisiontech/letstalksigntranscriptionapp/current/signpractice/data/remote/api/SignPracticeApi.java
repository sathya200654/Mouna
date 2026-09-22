package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.remote.api;

import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.remote.dto.GeneratePracticeResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* JADX INFO: compiled from: SignPracticeApi.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001Jr\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u00052\b\b\u0001\u0010\b\u001a\u00020\u00052\b\b\u0001\u0010\t\u001a\u00020\u00052\b\b\u0001\u0010\n\u001a\u00020\u00052\b\b\u0001\u0010\u000b\u001a\u00020\u00052\b\b\u0001\u0010\f\u001a\u00020\u00052\b\b\u0001\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0010¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/data/remote/api/SignPracticeApi;", "", "generatePracticeEssay", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/data/remote/dto/GeneratePracticeResponse;", "customerId", "", "deviceId", "gmailId", "token", "domain", "language", "topic", "complexity", "length", "", "intType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SignPracticeApi {
    @FormUrlEncoded
    @POST("generate_sign_practice")
    Object generatePracticeEssay(@Field("customer_id") String str, @Field("device_id") String str2, @Field("gmail_id") String str3, @Field("token") String str4, @Field("domain") String str5, @Field("language") String str6, @Field("topic") String str7, @Field("complexity") String str8, @Field("length") int i, @Field("int_type") String str9, Continuation<? super GeneratePracticeResponse> continuation);
}
