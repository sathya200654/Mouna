package com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.domain.repository;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.local.entities.EnvironmentSoundHistoryEntity;
import com.google.firebase.messaging.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: EnvironmentSoundHistoryRepository.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&J$\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH¦@¢\u0006\u0002\u0010\r¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/domain/repository/EnvironmentSoundHistoryRepository;", "", "getHistory", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/data/local/entities/EnvironmentSoundHistoryEntity;", "savePrediction", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", Constants.ScionAnalytics.PARAM_LABEL, "", "confidence", "", "(Ljava/lang/String;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface EnvironmentSoundHistoryRepository {
    Flow<List<EnvironmentSoundHistoryEntity>> getHistory();

    Object savePrediction(String str, float f, Continuation<? super ResponseResource<Unit>> continuation);
}
