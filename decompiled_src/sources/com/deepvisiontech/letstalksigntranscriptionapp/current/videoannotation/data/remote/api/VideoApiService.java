package com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.data.remote.api;

import com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.data.remote.dto.VideoUploadSuccessResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/* JADX INFO: compiled from: VideoApiService.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/data/remote/api/VideoApiService;", "", "uploadVideo", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/data/remote/dto/VideoUploadSuccessResponse;", "gmailId", "Lokhttp3/RequestBody;", "video", "Lokhttp3/MultipartBody$Part;", "(Lokhttp3/RequestBody;Lokhttp3/MultipartBody$Part;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface VideoApiService {
    @POST("uploadVideo.php")
    @Multipart
    Object uploadVideo(@Part("gmailId") RequestBody requestBody, @Part MultipartBody.Part part, Continuation<? super VideoUploadSuccessResponse> continuation);
}
