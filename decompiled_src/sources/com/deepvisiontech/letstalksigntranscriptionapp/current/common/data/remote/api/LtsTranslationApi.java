package com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.remote.api;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.remote.dto.translatebhashini.TranslateBhashiniRequest;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.remote.dto.translatebhashini.TranslateBhashiniResponse;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.remote.dto.translatefromenglish.TranslateFromEnglishRequest;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.remote.dto.translatetoenglish.TranslateToEnglishRequest;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.data.remote.dto.translatetoenglish.TranslateToEnglishResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.POST;

/* JADX INFO: compiled from: LtsTranslationApi.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\bH§@¢\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\u0004\u001a\u00020\fH§@¢\u0006\u0002\u0010\r¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/data/remote/api/LtsTranslationApi;", "", "translateToEnglish", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/data/remote/dto/translatetoenglish/TranslateToEnglishResponse;", "request", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/data/remote/dto/translatetoenglish/TranslateToEnglishRequest;", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/data/remote/dto/translatetoenglish/TranslateToEnglishRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "translateFromEnglish", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/data/remote/dto/translatefromenglish/TranslateFromEnglishRequest;", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/data/remote/dto/translatefromenglish/TranslateFromEnglishRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "translateBhashini", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/data/remote/dto/translatebhashini/TranslateBhashiniResponse;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/data/remote/dto/translatebhashini/TranslateBhashiniRequest;", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/data/remote/dto/translatebhashini/TranslateBhashiniRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface LtsTranslationApi {
    @POST("translate-bhashini")
    Object translateBhashini(@Body TranslateBhashiniRequest translateBhashiniRequest, Continuation<? super TranslateBhashiniResponse> continuation);

    @POST("translate-from-en")
    Object translateFromEnglish(@Body TranslateFromEnglishRequest translateFromEnglishRequest, Continuation<? super TranslateToEnglishResponse> continuation);

    @POST("translate")
    Object translateToEnglish(@Body TranslateToEnglishRequest translateToEnglishRequest, Continuation<? super TranslateToEnglishResponse> continuation);
}
