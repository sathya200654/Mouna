package com.deepvisiontech.letstalksigntranscriptionapp.current.core.speechtotext.domain.repository;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: SpeechToTextRepository.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/speechtotext/domain/repository/SpeechToTextRepository;", "", "fetchSpeechToken", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "Lkotlin/Pair;", "", "customerId", "deviceId", "gmailId", "token", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SpeechToTextRepository {
    Object fetchSpeechToken(String str, String str2, String str3, String str4, Continuation<? super ResponseResource<Pair<String, String>>> continuation);
}
